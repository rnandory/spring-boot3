import { createApp } from 'vue'
import { createMemoryHistory, createRouter, createWebHistory } from 'vue-router'

import adminRouter from './pages/admin/router.js'

import App from './App.vue'
import Default from './layouts/Default.vue'
import Index from './pages/Index.vue'
import MenuList from './pages/menu/List.vue'
import MenuDetail from './pages/menu/Detail.vue'

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
    //anonymousRouter,
    adminRouter
  ]
});


let app = createApp(App);
app.use(router);
app.mount('#app');