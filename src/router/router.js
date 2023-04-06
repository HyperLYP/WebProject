import Vue from 'vue';
import VueRouter from 'vue-router';
//因为vue-router是插件
Vue.use(VueRouter);
import Layout from '@/pages/Layout';
import home from '@/pages/home';
import news from '@/pages/news';
import other from '@/pages/other'
//创建router对象--- 并配置路由信息
const router = new VueRouter({
    // 在routs配置项中添加路由信息
    routes: [
        {
            path: '/',
            component: Layout,
            children: [
                {
                    path: '/',
                    redirect: '/home'
                },
                {
                    path: '/home',
                    component: home,
                },
                {
                    path: '/news',
                    component: news,
                },
                {
                    path: '/other',
                    component: other,
                },
                {
                    path: '/me',
                    component: () => import ('@/pages/me'),
                }
            ]
        }
    ],
});
export default router;