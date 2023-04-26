<!-- header 布局 --> 
<template>
  <div class='header'>

    <div class="h_left">
      <el-button
        @click="switchFold"
        v-show="!$store.state.isFold"
        type="primary"
        icon="el-icon-s-fold"
      ></el-button>
      <el-button
        @click="switchFold"
        v-show="$store.state.isFold"
        type="primary"
        icon="el-icon-s-unfold"
      ></el-button>
      <span>{{this.$store.state.currentTab}}</span>
      <span style="margin-left: 5px;">{{ this.$route.path }}</span>
    </div>
    <el-dropdown @command="handleCommand">
      <img
        src="@/assets/head_default.png"
        class="imgHeader"
      >
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item
          command="down_person_center"
          :plain="true"
        >个人中心</el-dropdown-item>
        <el-dropdown-item
          command="down_login_out"
          :plain="true"
        >退出</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>
<script>
export default {
  components: {},
  data() {
    //这里存放数据
    return {};
  },
  methods: {
    // 提交修改数据，不是异步操作，直接提交修改！
    switchFold() {
      this.$store.commit("switchFold");
    },
    // 点击事件：
    handleCommand(command) {
      this.$message({
        message: "点击了：" + command,
        type: "success",
      });
    },
  },
};
</script>
<style lang="less" scoped>
.header {
  background-color: #409eff;
  height: 60px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  color: #fff;

  .h_left {
    display: flex;
    align-items: center;
  }

  .el-button {
    margin-left: 5px;
    font-size: 18px;
  }

  .el-dropdown {
    margin-right: 20px;

    .imgHeader {
      width: 40px;
      height: 40px;
    }
  }
}
</style>