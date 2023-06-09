<!-- 主页面 -->
<template>
  <div class='home'>
    <el-row :gutter="20" style="font-size:15px;height:160px">
      <el-col :span="12">
        <el-card class="box-card" style="font-size: 20px;">
          <div slot="header" class="clearfix">
            <span style="color:red">项目介绍</span>
          </div>
          <div class="grid-content">
            <div style="color: blue;">
              <span>开发环境：maven:3.6.3, JDK17, windows10, node18.0.5</span>
            </div>
            <div style="color: green;">
              <span>开发工具：IDEA2022.3, vscode 1.53.2</span>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple-light"></div>
        <el-card class="box-card" style="font-size: 20px;">
          <div slot="header" class="clearfix">
            <span style="color:red">互联一班</span>
          </div>
          <div class="grid-content">
            <div style="color: blue;">
              <span>开发者：lyp  学号：233233233</span>
            </div>
            <div style="color: green;">
              <span>联系方式：233233233</span>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <el-row type="flex" justify="center" :gutter="20">
      <el-col :span="12">
        <div class="statistic_content">
          <p>柱状图</p>
          <div class="chartBox">
            <ve-histogram :data="chartData" />
          </div>
        </div>
      </el-col>
      <el-col :span="12">
        <div class="statistic_content">
          <p>饼图</p>
          <div class="chartBox">
            <ve-pie :data="chartData" />
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import VeLine from "v-charts/lib/line";
export default {
  components: { VeLine },
  data() {
    //这里存放数据
    return {
      chartData: {
        columns: ["majorName", "count"],
        rows: [],
      },
    };
  },
  mounted() {
    this.$api.api_info.getCountByMajor().then((resp) => {
      console.log(JSON.stringify(resp.data));
      this.chartData.rows = resp.data;
    });
  },
};
</script>
<style lang="less" scoped>
// 整体
.home {
  height: calc(100vh - 61px);
  overflow-x: hidden;
}

// 一行的容器layout
.el-row {
  padding: 10px;
}

.bg-purple {
  background: #d3dce6;
}

.h_left,
.h_right {
  border-radius: 4px;
  height: calc(100vh - 171px);
}

.statistic_content {
  border: 1px solid #ebedf2;

  p {
    margin: 0px;
    padding: 15px 0 15px 20px;
    border-bottom: 1px solid #ebedf2;
    background-color: #f9f9fc;
    font-size: 16px;
    font-family: MicrosoftYaHei;
    color: #444657;

    &::before {
      content: "";
      margin-top: 3px;
      float: left;
      width: 6px;
      height: 16px;
      background-color: #409eff;
      border-radius: 4px;
      margin-right: 8px;
    }
  }
}
</style>