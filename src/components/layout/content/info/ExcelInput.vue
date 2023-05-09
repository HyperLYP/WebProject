<!-- 上传excel表格的界面 -->
<template>
    <el-dialog
      title="导入数据："
      width="400px"
      :visible.sync="dialogDetailVisible"
      :close-on-click-modal="true"
      :before-close="handleClose"
    >
      <div class="top">
        <!-- 标题 -->
        <p class="title">
          {{ dialogName }}
        </p>
      </div>
      <div
        slot="footer"
        class="dialog-footer"
      />
      <!-- 封装组件：上传excel功能 -->
      <el-form>
        <el-form-item>
          <!-- 上传选择组件 -->
          <el-upload
            ref="upfile"
            style="display: inline"
            :auto-upload="false"
            :on-change="handleChange"
            :on-remove='onRemoveFile'
            :file-list="fileList"
            action="javascript:void(0)"
            accept=".xlsx,.xls"
          >
            <el-button
              type="primary"
              plain
              :disabled="fileList.length > 0 ? true : false"
            >选择文件</el-button>
          </el-upload>
        </el-form-item>
        <el-form-item>
          <el-button
            type="primary"
            plain
            @click="upload"
            :disabled="fileList.length <= 0 ? true : false"
          >点击上传</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </template>
  <script>
  export default {
    props: {
      dialogDetailVisible: {
        type: Boolean,
        default: false,
      },
      dialogName: {
        type: String,
        default: "数据源",
      },
    },
    data() {
      return {
        name: "",
        fileList: [], //未使用
        file: "",
      };
    },
  
  
    methods: {
      // 关闭dialog之前执行的回调
      handleClose() {
        console.log("--- 关闭前回调 -----");
        this.file = "";
        this.fileList = [];
        this.$emit("update:dialogDetailVisible", false);
      },
      //通过onchanne触发方法获得文件列表
      handleChange(file, fileList) {
        console.log(file);
        this.fileList = fileList;
        this.file = file;
      },
      //点击文件移除：
      onRemoveFile(file, fileList) {
        console.log("点击文件移除：");
        console.log(file);
        console.log(fileList);
        this.file = "";
        this.fileList = [];
      },
      // 点击上传的执行代码：
      upload() {
        let fd = new FormData();
        //文件信息中raw才是真的文件
        fd.append("file", this.file.raw);
        this.$axios
          .post("/api/excel/upload", fd, {
            "Content-type": "multipart/form-data",
          })
          .then(
            (res) => {
              console.log(res);
              // 上传成功后的处理
              this.handleClose();
              this.$message({
                message: "恭喜你，上传成功",
                type: "success",
              });
            },
            (err) => {
              // 出现错误时的处理
              console.log(err);
              this.$message({
                message: "操作失败",
                type: "success",
              });
            }
          );
      },
    },
  };
  </script>