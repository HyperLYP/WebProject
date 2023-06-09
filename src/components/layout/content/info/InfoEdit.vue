<template>
  <el-dialog class='dialog' title="编辑学生信息：" :visible.sync="editVisible" :close-on-click-modal="true"
    :before-close="dialogClose" width="25%">
    <!-- 在dialog中定义form布局 -->
    <div>
      <el-form :model="stu" label-position="right" label-width="70px" size="mini" :inline="false" :rules="regRules"
        ref="formStu">
        <el-form-item label="学号" prop="stuNum">
          <el-input v-model.trim="stu.stuNum"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="stuName">
          <el-input v-model.trim="stu.stuName"></el-input>
        </el-form-item>
        <el-form-item label="手机号" prop="stuPhone">
          <el-input v-model.trim="stu.stuPhone"></el-input>
        </el-form-item>
        <el-form-item label="地址" prop="stuAddress">
          <el-input v-model.trim="stu.stuAddress"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio-group v-model="stu.stuGender">
            <!-- :label:这里相当于之前单选框中value属性 -->
            <el-radio label="男">男</el-radio>
            <el-radio label="女">女</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="专业" prop="stuMajor" value-key="majorId">
          <!-- label：是显示的选择内容，value是上传的内容 -->
          <el-select v-model="stu.stuMajor" placeholder="请选择">
            <el-option v-for="item in majors" :key="item.majorId" :label="item.majorName" :value="item.majorNum">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="头像" prop="stuPic" size="mini">
          <el-upload class="avatar-uploader" :action="actionPic" :show-file-list="false" :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload" accept=".jpg,.png,.jpeg">
            <img v-if="imageUrl" :src="imageUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            <el-tooltip placement="bottom" effect="light">
              <div slot="content" v-html="'只能上传jpg/png文件'"></div>
              <div>{{ uploadResult }}</div>
            </el-tooltip>
          </el-upload>
        </el-form-item>
        <br>
        <el-form-item>
          <el-button type="primary" @click="onSubmit('formStu')" size="mini">修改</el-button>
        </el-form-item>
      </el-form>
    </div>
  </el-dialog>
</template>
<script>
export default {
  props: {
    editVisible: {
      type: Boolean,
      default: false,
    },
    itemDate: {
      type: Object,
      default() {
        return {};
      },
    },
  },
  data() {
    return {
      // 专业表的数据：
      majors: [],
      // 图片上传的地址：  需要些全路径，这里没有用到axios请求
      actionPic: "/api/file/upload",
      imageUrl: "",
      uploadResult: "",
      // 表单属性：
      stu: {
        stuName: "",
        stuNum: "",
        stuPhone: "13505389999",
        stuAddress: "",
        stuGender: "女",
        stuMajor: "请选择",
        stuPic: "",
      },
      regRules: {
        stuNum: [{ required: true, message: "请输入学号", trigger: "blur" }],
        stuAddress: [
          { required: true, message: "请输入地址", trigger: "blur" },
        ],
        stuMajor: [{ required: true, message: "请输入专业", trigger: "blur" }],
        stuPic: [{ required: true, message: "请输入图片", trigger: "blur" }],
        stuName: [
          { required: true, message: "请输入用户姓名", trigger: "blur" },
        ],
        stuPhone: [
          { required: true, message: "请输入电话号码", trigger: "blur" },
          {
            pattern:
              /^(13[0-9]|14[01456879]|15[0-3,5-9]|16[2567]|17[0-8]|18[0-9]|19[0-3,5-9])\d{8}$/,
            message: "请输入合法电话号码",
            trigger: "blur",
          },
        ],
        path: [{ required: true, message: "请上传头像" }],
      },
    };
  },
  watch: {
    // 监听到显示属性的变化执行：-相当于显示后的一些执行操作 -代替mounted函数
    editVisible: function (val) {
      console.log("dialog内部--显示修改页面 -- " + val);
      if (val) {
        // 显示数据
        this.stu = this.itemDate;
        this.imageUrl = "/api/img/" + this.itemDate.stuPic;
        this.$nextTick(() => {
          console.log("dialog内部-----执行一些操作");
          //获取专业列表：
          this.$api.api_major.get_major_list().then((resp) => {
            console.log("专业列表：" + JSON.stringify(resp));
            this.majors = resp.data;
          });
        });
      }
    },
  },

  methods: {
    // 关闭的执行回调：
    dialogClose() {
      this.$emit("editVisible", false);
    },
    // 点击提交按钮：
    onSubmit(formStu) {
      this.$refs[formStu].validate((valid) => {
        if (valid) {
          this.$api.api_info.editStu(this.stu).then((resp) => {
            console.log(JSON.stringify(resp));
            this.$message.success("保存成功");
            // // 清空表单项：
            this.$refs.formStu.resetFields();
            this.imageUrl = "";
            this.uploadResult = "";
            this.dialogClose();
          });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    // 处理头像：
    handleAvatarSuccess(res, file) {
      console.log("res = " + JSON.stringify(res));
      console.log("file = " + JSON.stringify(file));
      if (res.code == "200") {
        this.uploadResult = "100%";
        this.imageUrl = URL.createObjectURL(file.raw);
        this.stu.stuPic = res.data;
      }
    },
    beforeAvatarUpload() { },
  },
};
</script>
<style lang="less" scoped>
/deep/ .avatar-uploader .el-upload {
  border: 1px dashed #409eff;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

/deep/ .avatar-uploader .el-upload:hover {
  border-color: #409eff;
}

/deep/ .avatar-uploader-icon {
  font-size: 12px;
  color: #8c939d;
  width: 100px;
  height: 100px;
  line-height: 100px;
  text-align: center;
}

/deep/ .avatar {
  width: 100px;
  height: 100px;
  display: block;
}
</style>