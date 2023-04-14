<!--  -->
<template>
    <div class='home'>
        <van-nav-bar class="nav-bar" title="主页" />
        <van-notice-bar left-icon="volume-o" :text="notice" />
        <van-swipe class="my-swipe" :autoplay="3000" indicator-color="white">
            <van-swipe-item><img src="https://cdn.cnbj1.fds.api.mi-img.com/product-images/mi12s-provuejwm/70.png" alt=""></van-swipe-item>
            <van-swipe-item><img src="https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomi-13kb7buy/2793.png" alt=""></van-swipe-item>
            <van-swipe-item><img src="https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomi-13kb7buy/13142.png" alt=""></van-swipe-item>
            <van-swipe-item><img src="https://cdn.cnbj1.fds.api.mi-img.com/product-images/xiaomi-13kb7buy/9193.png" alt=""></van-swipe-item>
        </van-swipe>
    </div>
</template>

<script>

export default {
    name: "home",
    components: {},
    data() {
        //这里存放数据
        return {
            notice: "",
        };
    },
    mounted() {
        this.$api.api_home.getNotice().then((resp) => {
            this.notice = resp;
        })
    },
    beforeDestroy() {
        console.log("销毁前执行--home组件")
    }
}
</script>
<style scoped>
.home {
    min-height: 100vh;
    background-color: aqua;
}

.nav-bar {
    background-color: pink;
}
.my-swipe .van-swipe-item {
    color: #fff;
    font-size: 20px;
    line-height: 150px;
    text-align: center;
    background-color: #39a9ed;
}
.my-swipe .van-swipe-item img {
    display: auto;
    height: 219px;
}
</style>