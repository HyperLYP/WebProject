<!--  -->
<template>
    <div class='news'>
        <van-nav-bar class="nav-bar" title="新闻"/>
    </div>
</template>

<script>
// import { response } from 'express';


export default {
    components: {},
    data() {
        //这里存放数据
        return {

        };
    },
    mounted() {
        // 联网请求
        this.$api.api_news.getNews().then(resp => {
            console.log(resp);
        })
    }
}
</script>
<style scoped>
.news {
    min-height: 100vh;
    /* background-color: pink; */
    display: flex;
    /* justify-content: center;
    align-items: center; */
    flex-flow: column nowrap;
}
.nav-bar {
    background-color: pink;
}
</style>