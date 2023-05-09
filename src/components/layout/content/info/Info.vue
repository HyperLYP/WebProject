<!-- info -->
<template>
  <div>
    <el-row :gutter="10">
      <el-col
        :xs="24"
        :sm="24"
        :md="24"
        :lg="24"
        :xl="24"
      >
        <div class="grid-content bg-purple">
          <div class="top">
            <el-button
              size="medium"
              type="primary"
              @click="excelImport()"
            >
              <i class="el-icon-upload el-icon--right"></i> 导入
            </el-button>
            <el-button
              size="medium"
              type="primary"
              @click="add()"
            >
              <i class="el-icon-upload el-icon-plus"></i> 新增
            </el-button>
          </div>
          <el-table
            :data="tableData"
            height="500"
          >
            <el-table-column
              prop="date"
              label="日期"
              width="120px"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="姓名"
              width="120px"
            >
            </el-table-column>
            <el-table-column
              prop="address"
              label="地址"
            >
            </el-table-column>
          </el-table>
        </div>
      </el-col>
    </el-row>
    <!--弹窗组件： 新增组件-->
    <ExcelInput
      ref="excelInput"
      :dialog-detail-visible.sync="dialogDetailVisible"
      :dialog-name="dialogName"
    />
  </div>
</template>
<script>
import ExcelInput from "./ExcelInput";
export default {
  components: { ExcelInput },
  data() {
    return {
      searchMsg: "",
      tableData: [
        {
          date: "2016-05-03",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1516 弄",
        },
      ],
      // 新增组件的操作数据：
      dialogDetailVisible: false,
      dialogName: "选择导入的学生excel表：",
    };
  },
  methods: {
    // 关闭弹窗
    closeDialog() {
      console.log("在info组件中执行关闭操作");
      this.dialogDetailVisible = false;
    },
    // 打开弹窗执行
    excelImport() {
      this.dialogDetailVisible = true;
    },
    // 打开新增学生 信息页面：
    add() {},
  },
};
</script>
<style lang="less" scoped>
.top {
  margin: 5px;
  .el-button {
    width: 70px;
    height: 30px;
    font-size: 13px;
    padding: 0;
  }
}
.el-table {
  width: 99%;
}
</style>