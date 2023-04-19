<!--  -->
<template>
    <div class='news'>
        <van-nav-bar class="nav-bar" title="新闻" />
        <div class="content">
            <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
                <van-list v-model="loading" :finished="finished" finished-text="没有更多了" @load="onLoad">
                    <van-cell v-for="item in list" :key="item.id">
                        <!-- 条目新闻布局 -->
                        <div class="itemContainer">
                            <div class="item_left">
                                <a :href="item.url" class="ellipsis1">{{ item.title }}</a>
                                <div><span>{{ item.source }}</span></div>
                            </div>
                            <div><img :src="item.picUrl"></div>
                        </div>
                    </van-cell>
                </van-list>
            </van-pull-refresh>
        </div>
    </div>
</template>

<script>
// import { response } from 'express';


export default {
    name: "news",
    components: {},
    data() {
        //这里存放数据
        return {
            list: [],
            loading: false,
            finished: false,
            refreshing: false,
            page: 0,
        };
    },
    beforeDestroy() {
        console.log("销毁前执行--news组件")
    },
    methods: {
        onRefresh() {
            // 清空列表数据
            this.list=[];
            this.finished = false;

            // 重新加载数据
            // 将 loading 设置为 true，表示处于加载状态
            this.loading = true;
            this.page = 0;
            this.onLoad();
        },
        onLoad() {
            this.page += 1;
            this.callNet();
        },
        callNet() {
            // 联网请求
            this.$api.api_news.getNews(this.page).then(resp => {
                console.log("请求的页码是：" + this.page);
                console.log(resp);
                // 解构赋值
                this.list.push(...resp.result.newslist);
                // 加载状态结束
                this.loading = false;
                // this.finished = true;
                // 模拟没有数据了，就手动结束请求加载
                if (this.page == 5) {
                    this.finished = true;
                }
            })
        }
    }
}
</script>
<style scoped>
.news {
    display: flex;
    flex-flow: column nowrap;
}

.news /deep/ .van-nav-bar__title {
    color: white;
}

.nav-bar {
    background-color: pink;
}

.itemContainer {
    display: flex;
    flex-flow: nowrap row;
    justify-content: space-between;
}

.itemContainer img {
    width: 160px;
    height: 130px;
    background-image: url('@/assets/logo.png');
    background-size: cover;
    background-position: center;
}

.item_left {
    display: flex;
    flex-flow: column nowrap;
    justify-content: space-between;
}

van-list {
    height: 20px;
}

.content {
    position: fixed;
    bottom: 50px;
    left: 0;
    top: 46px;
    right: 0;
    overflow-y: auto;
}
</style>