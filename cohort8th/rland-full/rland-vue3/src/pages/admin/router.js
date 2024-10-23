import Admin from '../../layouts/Admin.vue'
import Index from './Index.vue'
import MenuIndex from './menus/Index.vue'
import MenuDetail from './menus/Detail.vue'
import MenuReg from './menus/New.vue'
import MenuEdit from './menus/Edit.vue'

export default {
    path: '/admin', children: [
        { path: '', component: Index },
        { path: 'index', component: Index },
        { path: 'menus'
            , children: [
                // /admin/menus
                { path: '', component: MenuIndex },
                // /admin/menus/12
                { path: ':id', component: MenuDetail },
                // /admin/menus/new
                { path: 'new', component: MenuReg },
                // /admin/menus/12/edit
                { path: ':id/edit', component: MenuEdit },
            ]            
        }
    ], component: Admin
}