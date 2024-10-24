import Admin from '../../layouts/Admin.vue'
import menuRouter from './menus/router.js'
import Index from './Index.vue'

export default {
    path: '/admin', children: [
        { path: '', component: Index },
        { path: 'index', component: Index },
        menuRouter
    ], component: Admin
}