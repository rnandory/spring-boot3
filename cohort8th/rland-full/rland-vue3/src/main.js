import { createApp } from 'vue'
import { createMemoryHistory, createRouter, createWebHistory } from 'vue-router'

import App from './App.vue'
import Default from './layouts/Default.vue'
import Admin from './layouts/Admin.vue'
import Index from './pages/Index.vue'
import MenuList from './pages/menu/List.vue'
import MenuDetail from './pages/menu/Detail.vue'
import AdminIndex from './pages/admin/Index.vue'
import AdminMenuList from './pages/admin/menu/List.vue'

let adminChild = [
  {path: '', component: AdminIndex},
  {path: 'index', component: AdminIndex},
  {path: 'menu/list', component: AdminMenuList}
];

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
        path: '/', children: [
        { path: 'index', component: Index },
        { path: '', component: Index },
        { path: 'menu/list', component: MenuList },
        { path: 'menu/detail', component: MenuDetail }
        ], component: Default
    },
    {
        path: '/admin', children: adminChild, component: Admin
    }
  ],
})


let app = createApp(App);
app.use(router);
app.mount('#app');