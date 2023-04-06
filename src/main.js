import Vue from 'vue'
import App from './App.vue'
import router from './router/router'
import '@/assets/reset.css'
import '@/plugins/vant'
// 引入接口统一入口文件，类似App.vue统一管理组件
import api from '@/api/api'
import 'amfe-flexible'
Vue.config.productionTip = false
// 引入统一的api调用
Vue.prototype.$api = api;

new Vue({
  render: h => h(App),
  router,
}).$mount('#app')
