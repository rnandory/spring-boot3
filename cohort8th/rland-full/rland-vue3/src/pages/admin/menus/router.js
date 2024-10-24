import MenuIndex from './Index.vue'
import MenuDetail from './Detail.vue'
import MenuReg from './New.vue'
import MenuEdit from './Edit.vue'

export default { path: 'menus'
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