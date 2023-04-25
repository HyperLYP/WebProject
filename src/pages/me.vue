<!--  -->
<template>
    <div class='me'>
        <van-nav-bar class="nav-bar" title="我的" />
        <div class='container'>
            <div class="headimg">
                <van-image cover round width="100px" height="100px" :src="require('@/assets/head_default.png')" />
            </div>
            <div class="tag">
                <van-tag type="primary">健身达人</van-tag>
                <van-tag type="success">考研小能手</van-tag>
                <van-tag type="danger">学习ing</van-tag>
                <van-tag type="warning">编程爱好者</van-tag>
            </div>
            <van-divider></van-divider>
            <ul>
                <li>
                    我的收藏
                </li>
                <van-divider></van-divider>
                <li>
                    浏览历史
                    <van-divider></van-divider>
                </li>
                <li>
                    清除缓存
                </li>
                <van-divider></van-divider>
                <li>
                    设置
                </li>
                <van-divider></van-divider>
            </ul>
        </div>
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

.container {
    display: flex;
    flex-flow: wrap column;
    align-content: center;
    background-color: #fff;
    height: calc(100vh - 96px);
}

.headimg {
    margin: 10px;
    align-self: center;
}

.tag {
    display: flex;
    width: 305px;
    justify-content: flex-start;
    flex-flow: row wrap;
}

.tag .van-tag {
    margin-left: 8px;
}

ul li {
    color: gray;
}
</style>