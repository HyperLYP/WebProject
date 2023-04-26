import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  // 存储数据
  state: {
    isFold: false, //是否折叠侧边栏
    // 当前标签的名称；
    currentTab: '',
  },
  getters: {},
  mutations: {
    // 提交修改数据
    switchFold(state) {
      state.isFold = !state.isFold;
    },
    currentTagNameChange(state, name) {
      state.currentTab = name;
    },
  },
  actions: {},
  modules: {},
});
