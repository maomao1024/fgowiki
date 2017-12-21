import Vue from 'vue'
import VueRouter from 'vue-router'
import Page1 from '../components/page1.vue'
import Page2 from '../components/page2.vue'
import Page3 from '../components/page3.vue'
Vue.use(VueRouter)

const router = new VueRouter({
    routes:[{
        path: '/Page1', component: Page1
    },{
        path: '/Page2', component: Page2
    },{
        path:'/Page3', component: Page3
    }]
})

export default router;