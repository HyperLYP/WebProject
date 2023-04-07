<!--  -->
<template>
    <div class='home'>
        <van-nav-bar class="nav-bar" title="主页" />
        <van-notice-bar left-icon="volume-o" :text="notice" />
    </div>
</template>

<script>

export default {
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
</style>