<!-- 菜单 -->
<template>
  <el-menu
    :router="true"
    :default-active="$route.path"
    class="menu_left"
    @open="handleOpen"
    @close="handleClose"
    :collapse="isCollapse"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
  >
    <div class="menu_title">
      <span v-show="!isCollapse">通用管理系统</span>
      <span v-show="isCollapse">系统</span>
    </div>
    <!--只有 一级菜单栏 index也是唯一标识 -->
    <el-menu-item
      v-for="item in noChildren"
      :index="item.path"
      :key="item.name"
      @click="clickItem(item.label)"
      :route="item.path"
    >
      <i :class="item.icon"></i>
      <span slot="title">{{ item.label }}</span>
    </el-menu-item>
    <!-- 有二级菜单 -->
    <el-submenu
      :index='items.label'
      v-for="items in hasChildren"
      :key='items.label'
    >
      <template slot="title">
        <i class="el-icon-bank-card"></i>
        <span slot="title">{{ items.label }}</span>
      </template>
      <el-menu-item-group>
        <el-menu-item
          v-for="item in items.children"
          :key="item.name"
          :index="item.path"
          @click="clickItem(item.label)"
        >
          <i :class="item.icon"></i>
          <span slot="title">{{ item.label }} </span>
        </el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>
<style lang="less" scoped>
.menu_left {
  height: 100vh;
  white-space: nowrap; //取消换行
}

// 解决侧边栏折叠卡顿的问题
.menu_left:not(.el-menu--collapse) {
  width: 220px;
}

.menu_title {
  color: white;
  justify-content: center;
  display: flex;
  font-size: 16px;
  height: 60px;
  font-weight: 400;
  align-items: center;
}
</style>
<script>
export default {
  data() {
    return {
      // 联网获取到的菜单数据，这个数据是后台维护的，后台获取可以做权限的管理
      // 不同权限，给定不同的数据！这里就直接拿了json串！
      menuDate: [
        {
          path: "/home",
          name: "home",
          label: "首页",
          icon: "el-icon-s-home",
          url: "home/Home",
        },
        {
          path: "/info",
          name: "info",
          label: "信息管理",
          icon: "el-icon-set-up",
          url: "info/info",
        },
        {
          path: "/user",
          name: "user",
          label: "用户管理",
          icon: "el-icon-user",
          url: "user/user",
        },
        {
          label: "其它",
          icon: "el-icon-set-up",
          children: [
            {
              path: "/other01",
              name: "other01",
              label: "页面1",
              icon: "el-icon-set-up",
              url: "Other/PageOne",
            },
            {
              path: "/other02",
              name: "other02",
              label: "页面2",
              icon: "el-icon-setting",
              url: "Other/PageTwo",
            },
          ],
        },
      ],
    };
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    clickItem(tagName) {
      console.log("---------" + tagName);
      this.$store.commit("currentTagNameChange", tagName);
    },
  },
  computed: {
    //没有子菜单：
    noChildren() {
      return this.menuDate.filter((item) => !item.children);
    },
    // 有子菜单：
    hasChildren() {
      return this.menuDate.filter((item) => item.children);
    },
    // 折叠侧边栏：
    isCollapse() {
      return this.$store.state.isFold;
    },
  },
};
</script>
