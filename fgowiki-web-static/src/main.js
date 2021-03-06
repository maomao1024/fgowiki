import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
//import './assets/theme/theme-green/index.css'
import VueRouter from 'vue-router'
import store from './vuex/store'
import Vuex from 'vuex'
//import NProgress from 'nprogress'
//import 'nprogress/nprogress.css'
import routes from './routes'
//Mock.bootstrap();
import 'font-awesome/css/font-awesome.min.css'
import axios from 'axios';

Vue.use(ElementUI);
Vue.use(VueRouter);
Vue.use(Vuex);

//NProgress.configure({ showSpinner: false });

const router = new VueRouter({
    routes
});

const no_login = -1;
const success = 0;
const fail = 1;
const no_permission = 2;


router.beforeEach((to, from, next) => {
    //NProgress.start();
    if (to.path === '/login') {
        sessionStorage.removeItem('user');
        localStorage.removeItem('JWT_TOKEN');
    }
    let token = localStorage.getItem('JWT_TOKEN');
    if (!token && to.path !== '/login') {
        next({path: '/login'})
    } else {
        next()
    }
});

// http request 拦截器
axios.interceptors.request.use(
    config => {
        if (localStorage.JWT_TOKEN) {  // 判断是否存在token，如果存在的话，则每个http header都加上token
            config.headers.Authorization = `Bearer ${localStorage.JWT_TOKEN}`;
        }
        return config;
    },
    err => {
        return Promise.reject(err);
    });

// http response 拦截器
axios.interceptors.response.use(
    response => {
        if (response.data.code === no_login) {
            sessionStorage.removeItem('user');
            localStorage.removeItem('JWT_TOKEN');
            store.commit('LOG_OUT');
            router.replace({
                path: 'login',
                query: {redirect: router.currentRoute.fullPath}
            });
        }
        let authorization = response.headers.Authorization || response.headers.authorization;
        if (authorization && authorization.startsWith('RefreshToken ')) {
            localStorage.setItem('JWT_TOKEN', authorization.split(' ')[1]);
        }
        return response;
    },
    error => {
        if (error.response) {
            console.log('axios:' + error.response.status);
            switch (error.response.status) {
                case 401:
                    // 返回 401 清除token信息并跳转到登录页面
                    store.commit('LOG_OUT');
                    router.replace({
                        path: 'login',
                        query: {redirect: router.currentRoute.fullPath}
                    });
            }
        }
        return Promise.reject(error.response.data);   // 返回接口返回的错误信息
    });

Vue.prototype.$http = axios;

new Vue({
    //el: '#app',
    //template: '<App/>',
    router,
    store,
    //components: { App }
    render: h => h(App)
}).$mount('#app');
