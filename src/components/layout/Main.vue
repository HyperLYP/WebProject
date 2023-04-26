<!-- 主页面 -->
<template>
  <div class='main'>
    <el-container>
      <!-- 左边菜单栏，直接引入组件 -->
      <el-aside width="auto">
        <!-- 抽取组件 -->
        <Menu></Menu>
      </el-aside>
      <!-- 右边容器部分 -->
      <el-container class="content">
        <!-- 顶部的头部栏 -->
        <el-header>
          <!-- 抽取组件 -->
          <Header></Header>
        </el-header>
        <!-- 内容部分：使用路由切换不同的组件 -->
        <el-main>
          <router-view></router-view>
        </el-main>
        <!-- 如果需要页脚，再添加即可 -->
        <!-- <el-footer>Footer</el-footer> -->
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Header from "@/components/layout/content/Header";
import Menu from "@/components/layout/menu/Menu";
export default {
  components: { Menu, Header },
  data() {
    //这里存放数据
    return {};
  },
};
</script>
<style lang="less" scoped>
.el-header {
  padding: 0;
}
.el-aside {
  width: 200px;
  height: calc(100vh); //61px为顶部header盒子高度
  overflow-y: auto;
}
// 切换的主要内容区域
.el-main {
  background-color: rgba(255, 255, 0, 0.041);
}
/* 清空菜单栏和头部导航栏的一个小缝隙 */
.el-menu {
  border: none;
}
.el-container {
  display: flex;
}
.content {
  padding: 0px;
  height: 100vh; //61px为顶部header盒子高度
  flex: 1;
}
</style>