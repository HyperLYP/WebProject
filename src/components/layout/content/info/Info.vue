<!-- info -->
<template>
  <div>
    <el-row :gutter="10">
      <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
        <div class="grid-content bg-purple">
          <div class="top">
            <el-button size="medium" type="primary" @click="excelImport()">
              <i class="el-icon-upload el-icon--right"></i> 导入
            </el-button>
            <el-button size="medium" type="primary" @click="add()">
              <i class="el-icon-upload el-icon-plus"></i> 新增
            </el-button>
          </div>
          <el-table :data="tableData" height="500">
            <el-table-column prop="stuNum" label="学号" width="150px"></el-table-column>
            <el-table-column prop="stuName" label="姓名"> </el-table-column>
            <el-table-column prop="stuGender" label="性别"> </el-table-column>
            <el-table-column prop="stuPhone" label="手机号"> </el-table-column>
            <el-table-column prop="stuMajor" label="专业"> </el-table-column>

            <!-- ************************************************** -->
            <el-table-column label="头像" prop="stuPic" align="center">
              <template slot-scope="scope">
                <el-image style="width: 80px; height: 80px; margin-bottom:-4px" :src="picLoc + `${scope.row.stuPic}`">
                </el-image>
              </template>
            </el-table-column>
            <!-- ************************************************** -->

            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
                <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
          <div class="block">
            <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
              :current-page="currentPage" :page-sizes="[10, 20, 30, 40, 50]" :page-size="pageSize"
              layout="total, sizes, prev, pager, next, jumper" :total="totalCount">
            </el-pagination>
          </div>
        </div>
      </el-col>
    </el-row>
    <!--弹窗组件： 新增组件-->
    <ExcelInput ref="excelInput" :dialog-detail-visible.sync="dialogDetailVisible" :dialog-name="dialogName" />
    <!-- 新增页面 -->
    <InfoAdd ref="infoAdd" :infoAddVisible.sync="addVisible" />
    <!-- 编辑页面 -->
    <InfoEdit ref="infoEdit" :editVisible.sync="editVisible" :itemDate=stuDate />
  </div>
</template>
<script>
import ExcelInput from "./ExcelInput";
import InfoAdd from "./InfoAdd.vue";
import InfoEdit from "./InfoEdit.vue";
export default {
  components: { ExcelInput, InfoAdd, InfoEdit },
  data() {
    return {
      picLoc: "/api/img/",
      currentPage: 1, //当前页码
      pageSize: 10, //每页显示条数
      totalCount: 0, //总条数
      searchMsg: "",
      tableData: [],
      // 新增组件的操作数据：
      dialogDetailVisible: false,
      dialogName: "选择导入的学生excel表：",
      // 新增相关
      addVisible: false,  //是否可见
      //修改显示属性：
      editVisible: false,
      stuDate: {}, //这是要传递的学生对象信息
    };
  },
  mounted() {
    // 获取外网地址：
    this.callStuList();
  },
  methods: {
    //请求学生列表数据
    callStuList() {
      this.$api.api_info.getStuList(this.currentPage, this.pageSize).then((resp) => {
        console.log(resp);
        this.tableData = resp.data;
        this.totalCount = resp.count;
      });
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.pageSize = val;
      this.callStuList();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.currentPage = val;
      this.callStuList();
    },
    // 关闭弹窗
    closeDialog() {
      this.dialogDetailVisible = false;
    },
    // 打开弹窗执行
    excelImport() {
      this.dialogDetailVisible = true;
    },
    // 打开新增学生 信息页面：
    add() {
      this.addVisible = true;
      // 点击监听 dialog的关闭回调
      this.$refs.infoAdd.$once("infoAddVisible", this.closeInfoAdd);
    },
    closeInfoAdd() {
      this.addVisible = false;
      this.callStuList();
    },
    //编辑的函数：
    handleEdit(row) {
      console.log(JSON.stringify(row));
      this.stuDate = row;
      this.editVisible = true;
      //添加一个事件回调：
      this.$refs.infoEdit.$once("editVisible", this.closeInfoEdit);
    },
    closeInfoEdit() {
      this.editVisible = false;
      this.callStuList();
    },
    handleDelete(row) {
      console.log("删除的信息是：" + JSON.stringify(row));
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      })
        .then(() => {
          this.$api.api_info.deleteStu(row).then((resp) => {
            console.log(JSON.stringify(resp));
            this.$message.success("删除成功");

            this.callStuList();
          });
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });

    },
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
