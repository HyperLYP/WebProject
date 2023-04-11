<!--  -->
<template>
    <div class='news'>
        <van-nav-bar class="nav-bar" title="新闻" />
        <van-list v-model="loading" :finished="finished" finished-text="没有更多了" @load="onLoad">
            <van-cell v-for="item in list" :key="item.id" :title="item.title" />
        </van-list>
    </div>
</template>

<script>
// import { response } from 'express';


export default {
    components: {},
    data() {
        //这里存放数据
        return {
            list: [],
            loading: false,
            finished: false,
        };
    },
    mounted() {

    },
    methods: {
        onLoad() {
            // 联网请求
            this.$api.api_news.getNews().then(resp => {
                console.log(resp);
                this.list = resp.result.newslist;
                this.list.push(resp.result.newslist.length);
                // 加载状态结束
                this.loading = false;
                this.finished = true;
            })
            // 异步更新数据
            // setTimeout 仅做示例，真实场景中一般为 ajax 请求
            // setTimeout(() => {
            //     for (let i = 0; i < 10; i++) {
            //         this.list.push(this.list.length + 1);
            //     }

            //     // 加载状态结束
            //     this.loading = false;

            //     // 数据全部加载完成
            //     if (this.list.length >= 40) {
            //         this.finished = true;
            //     }
            // }, 1000);
        },
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

.news /deep/ .van-nav-bar__title {
    color: white;
}

.nav-bar {
    background-color: pink;
}
</style>