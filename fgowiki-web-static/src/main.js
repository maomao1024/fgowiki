import Vue from 'vue'
import axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import Navi from './components/Navi/Navi.vue'
import router from './router/index'

Vue.use(ElementUI);
Vue.prototype.ajax = axios;
new Vue({
    el: '#app',
    router,
    render: h => h(Navi)
});
