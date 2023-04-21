<!--  -->
<template>
    <div class='other'>
        <van-nav-bar class="nav-bar" :title="address" />
        <baidu-map class="map-wrap" :center="mapData.center" :zoom="mapData.zoom" @ready="mapHandler" @click="getLocation">
            <bm-navigation anchor="BMAP_ANCHOR_TOP_LEFT"></bm-navigation>
            <bm-city-list anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-city-list>
            <bm-geolocation anchor="BMAP_ANCHOR_BOTTOM_RIGHT" :showAddressBar="true" :autoLocation="true"></bm-geolocation>
        </baidu-map>
    </div>
</template>

<script>

export default {
    components: {},
    data() {
        //这里存放数据
        return {
            address: "位置",
            //商家信息(包含坐标信息)
            businessDetail: {},
            //地图数据
            mapData: {
                //中心坐标
                center: { lng: 0, lat: 0 },
                //缩放级别
                zoom: 15
            },
            //BMap类
            BMap: null,
            //地图对象
            map: null
        };
    },
    methods: {
        //地图预处理
        async mapHandler({ BMap, map }) {
            if (this.businessId) {
                //可以在此处请求接口获取坐标数据
                await this.getMallBusinessDetail()
            }
            //保存百度地图类
            this.BMap = BMap
            //保存地图对象
            this.map = map
            //如果一开始坐标存在(编辑的时候)
            if (this.businessDetail.longitude && this.businessDetail.latitude) {
                //设置坐标
                this.mapData.center.lng = this.businessDetail.longitude
                this.mapData.center.lat = this.businessDetail.latitude
            } else {
                //如果坐标不存在则动态获取当前浏览器坐标（创建的时候）
                let geolocation = new BMap.Geolocation()
                //获取当前的坐标（使用promise 将异步转换为同步）
                await new Promise((resolve) => {
                    geolocation.getCurrentPosition((r) => {
                        this.mapData.center.lng = this.businessDetail.longitude =
                            r.point.lng
                        this.mapData.center.lat = this.businessDetail.latitude = r.point.lat
                        resolve()
                    })
                })
            }
            //创建定位标记
            let marker = new BMap.Marker(
                new BMap.Point(
                    this.businessDetail.longitude,
                    this.businessDetail.latitude
                )
            )
            //将标记添加到地图上
            map.addOverlay(marker)
        },
        //在地图上选择区域
        getLocation(e) {
            //设置经度
            this.businessDetail.longitude = e.point.lng
            //设置纬度
            this.businessDetail.latitude = e.point.lat
            //百度地图类
            let BMapGL = this.BMap
            //地图对象
            let map = this.map
            //清除地图上所有的覆盖物(保证每次点击只有一个标记)
            map.clearOverlays()
            //创建定位标记
            let marker = new BMapGL.Marker(new BMapGL.Point(e.point.lng, e.point.lat))
            //将标记添加到地图上
            map.addOverlay(marker)
            //创建坐标解析对象
            let geoc = new BMapGL.Geocoder()
            //解析当前的坐标成地址
            geoc.getLocation(e.point, (rs) => {
                //获取地址对象
                let addressComp = rs.addressComponents
                //拼接出详细地址
                this.businessDetail.address =
                    addressComp.province +
                    addressComp.city +
                    addressComp.district +
                    addressComp.street +
                    addressComp.streetNumber
                this.address = addressComp.district + addressComp.street
            })
        },
    }
}


</script>
<style scoped>
.other {
    display: flex;
    flex-flow: column nowrap;
}

.other /deep/ .van-nav-bar__title {
    color: white;
}

.nav-bar {
    background-color: pink;
}

.map-wrap {
    position: fixed;
    bottom: 50px;
    left: 0px;
    right: 0px;
    top: 46px;
}
</style>