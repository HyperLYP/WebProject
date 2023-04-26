import Vue from 'vue';
import VueRouter from 'vue-router';
Vue.use(VueRouter);
// 路由的信息
const routes = [
  {
    path: '/',
    component: () => import('@/components/layout/Main'),
    children: [
      {
        path: '/',
        redirect: '/home',
      },
      {
        path: '/home',
        component: () => import('@/components/layout/content/home/Home'),
      },
      {
        path: '/info',
        component: () => import('@/components/layout/content/info/Info'),
      },
      {
        path: '/user',
        component: () => import('@/components/layout/content/user/User'),
      },
      {
        path: '/other01',
        component: () => import('@/components/layout/content/other/Other01'),
      },
      {
        path: '/other02',
        component: () => import('@/components/layout/content/other/Other02'),
      },
    ],
  },
  {
    path: '/login',
    component: () => import('@/components/login/Login'),
  },
];
// 创建router实例，传入路由配置！
const router = new VueRouter({
  // mode: 'history',
  // base: process.env.BASE_URL,
  routes,
});

export default router;
