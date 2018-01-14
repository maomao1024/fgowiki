import Vue from 'vue'
import VueRouter from 'vue-router'
import Servant from '../components/servant.vue'
import Page2 from '../components/page2.vue'
import Page3 from '../components/page3.vue'
Vue.use(VueRouter);

const router = new VueRouter({
    routes:[{
        path: '/Servant', component: Servant
    },{
        path: '/Page2', component: Page2
    },{
        path:'/Page3', component: Page3
    }]
});

export default router;