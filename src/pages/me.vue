<!--  -->
<template>
    <div class='me'>
        <van-nav-bar class="nav-bar" title="我的" />
    </div>
</template>

<script>

export default {
    name: "me",
    components: {},
    data() {
        //这里存放数据
        return {

        };
    },
}
</script>
<style scoped>
.me {
    display: flex;
    flex-flow: column nowrap;
}

.me /deep/ .van-nav-bar__title {
    color: white;
}

.nav-bar {
    background-color: pink;
}
</style>