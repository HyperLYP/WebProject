<!-- 主页面 -->
<template>
  <div class='home'>
    <el-row :gutter="10">
      <el-col :span="8">
        <div class="h_left bg-purple">
          <el-card class="box-card">
            <div
              slot="header"
              class="clearfix"
            >
              <span>卡片名称</span>
              <el-button
                style="float: right; padding: 3px 0"
                type="text"
              >操作按钮</el-button>
            </div>
            <div
              v-for="o in 4"
              :key="o"
              class="text item"
            >
              {{'列表内容 ' + o }}
            </div>
          </el-card>
        </div>
      </el-col>
      <el-col :span="16">
        <div class="h_right bg-purple"></div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  components: {},
  data() {
    //这里存放数据
    return {};
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
  height: 100%;
}
.bg-purple {
  background: #d3dce6;
}
.h_left,
.h_right {
  border-radius: 4px;
  height: calc(100vh - 171px);
}
</style>