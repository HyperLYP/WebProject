import Vue from 'vue';
import App from './App.vue';
import router from './router/router';
import store from './store/store';
import ElementUI from 'element-ui';
import VCharts from 'v-charts'
Vue.use(VCharts)
// 解决在使用v-charts时候控制台报错问题
Vue._watchers = Vue.prototype._watchers = []
import '@/assets/reset.css';
import 'element-ui/lib/theme-chalk/index.css';
// 引入初始化样式：
import 'normalize.css';
import axios from 'axios';
Vue.prototype.$axios = axios;
// 使用axios，到原型上！
import api from '@/api/api';
Vue.prototype.$api = api;
Vue.config.productionTip = false;
Vue.use(ElementUI);
new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app');
