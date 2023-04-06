<!-- 布局页面 -->
<template>
    <div class='container'>
        <router-view></router-view>
        <!-- 底部导航栏 -->
        <van-tabbar v-model="active" route>
            <van-tabbar-item icon="wap-home-o" to="/home">主页</van-tabbar-item>
            <van-tabbar-item icon="apps-o" to="/news">新闻</van-tabbar-item>
            <van-tabbar-item icon="comment-o" to="/other">其它</van-tabbar-item>
            <van-tabbar-item icon="manager-o" to="/me">我的</van-tabbar-item>
        </van-tabbar>
    </div>
</template>
  <van-icon name="-o" />
<script>
export default {
    components: {},
    data() {
        return {
            active: 0
        };
    },
}
</script>
<style  scoped>
.container {
    height: 100%;
}
.container:after {
    display: block;
    content: "";
    height: 50px;
}
</style>