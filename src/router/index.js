import Vue from 'vue'
import VueRouter from 'vue-router'
import Add from '../views/Add'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        redirect:'/find'
    },
    {
        path: '/add',
        name: 'Add',
        component: Add
    },
    {
        path: '/delete',
        name: 'Delete',
        component: () => import('../views/Delete')
    },
    {
        path: '/find',
        name: 'Find',
        component: () => import('../views/Find')
    },
    {
        path: '/update',
        name: 'Update',
        component: () => import('../views/Update')
    }

]

const router = new VueRouter({
    mode:'history',
    routes
})

export default router
