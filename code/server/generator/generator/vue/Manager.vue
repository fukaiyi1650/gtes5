<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>管理员管理</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box">
        <el-button type="primary" icon="delete" class="handle-del mr10" @click="delAll" :disabled="this.delData.length===0">批量删除</el-button>
        <el-input v-model="query.managerId" placeholder="管理员ID" class="handle-input mr10" />
        <el-input v-model="query.account" placeholder="账号" class="handle-input mr10" />
        <el-input v-model="query.password" placeholder="密码" class="handle-input mr10" />
        <el-input v-model="query.name" placeholder="名称" class="handle-input mr10" />
        <el-input v-model="query.avatar" placeholder="头像" class="handle-input mr10" />
        <el-input v-model="query.birthday" placeholder="生日" class="handle-input mr10" />
        <el-input v-model="query.sex" placeholder="性别" class="handle-input mr10" />
        <el-input v-model="query.email" placeholder="邮箱" class="handle-input mr10" />
        <el-input v-model="query.phone" placeholder="电话" class="handle-input mr10" />
        <el-input v-model="query.status" placeholder="状态" class="handle-input mr10" />
        <el-input v-model="query.createTime" placeholder="创建时间" class="handle-input mr10" />
        <el-input v-model="query.version" placeholder="版本" class="handle-input mr10" />
        <el-button type="primary" icon="search" @click="getList">搜索</el-button>
        <el-button type="primary" @click="handleAdd">新建</el-button>
      </div>
      <el-table :data="tableData" border class="table" ref="multipleTable" @selection-change="handleSelectionChange" v-loading="isShowloading">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column prop="managerId" label="管理员ID" sortable />
        <el-table-column prop="account" label="账号" sortable />
        <el-table-column prop="password" label="密码" sortable />
        <el-table-column prop="name" label="名称" sortable />
        <el-table-column prop="avatar" label="头像" sortable />
        <el-table-column prop="birthday" label="生日" sortable />
        <el-table-column prop="sex" label="性别" sortable />
        <el-table-column prop="email" label="邮箱" sortable />
        <el-table-column prop="phone" label="电话" sortable />
        <el-table-column prop="status" label="状态" sortable />
        <el-table-column prop="createTime" label="创建时间" sortable />
        <el-table-column prop="version" label="版本" sortable />
        <el-table-column label="操作" width="220" align="center">
          <template slot-scope="scope">
            <el-button type="text" icon="el-icon-edit" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button type="text" icon="el-icon-delete" class="red" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="pagination">
        <el-pagination background @current-change="currentChange" @size-change="handleSizeChange" layout="total, sizes, prev, pager, next, jumper" :total="total" :current-page="query.page" :page-size="query.pageSize"></el-pagination>
      </div>

      <!-- 编辑框 -->
      <el-dialog title="修改信息" :visible.sync="editDialogVisible" ref="editform" :before-close="confirmClose" v-dialogDrag>
        <el-form :model="form" :rules="editRule" ref="editform">
          <el-form-item label="管理员ID" :label-width="formLabelWidth" prop="managerId">
            <el-input v-model="form.managerId" autocomplete="off" />
          </el-form-item>
          <el-form-item label="账号" :label-width="formLabelWidth" prop="account">
            <el-input v-model="form.account" autocomplete="off" />
          </el-form-item>
          <el-form-item label="密码" :label-width="formLabelWidth" prop="password">
            <el-input v-model="form.password" autocomplete="off" />
          </el-form-item>
          <el-form-item label="名称" :label-width="formLabelWidth" prop="name">
            <el-input v-model="form.name" autocomplete="off" />
          </el-form-item>
          <el-form-item label="头像" :label-width="formLabelWidth" prop="avatar">
            <el-input v-model="form.avatar" autocomplete="off" />
          </el-form-item>
          <el-form-item label="生日" :label-width="formLabelWidth" prop="birthday">
            <el-input v-model="form.birthday" autocomplete="off" />
          </el-form-item>
          <el-form-item label="性别" :label-width="formLabelWidth" prop="sex">
            <el-input v-model="form.sex" autocomplete="off" />
          </el-form-item>
          <el-form-item label="邮箱" :label-width="formLabelWidth" prop="email">
            <el-input v-model="form.email" autocomplete="off" />
          </el-form-item>
          <el-form-item label="电话" :label-width="formLabelWidth" prop="phone">
            <el-input v-model="form.phone" autocomplete="off" />
          </el-form-item>
          <el-form-item label="状态" :label-width="formLabelWidth" prop="status">
            <el-input v-model="form.status" autocomplete="off" />
          </el-form-item>
          <el-form-item label="创建时间" :label-width="formLabelWidth" prop="createTime">
            <el-input v-model="form.createTime" autocomplete="off" />
          </el-form-item>
          <el-form-item label="版本" :label-width="formLabelWidth" prop="version">
            <el-input v-model="form.version" autocomplete="off" />
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="editDialogVisible=false">取 消</el-button>
          <el-button type="primary" @click.native="edit">确 定</el-button>
        </div>
      </el-dialog>

      <!-- 新建用户 -->
      <el-dialog title="新建用户" :visible.sync="addDialogVisible" ref="form" v-dialogDrag>
        <el-form :model="form" :rules="addRule">
          <el-form-item label="管理员ID" :label-width="formLabelWidth" prop="managerId">
            <el-input v-model="form.managerId" autocomplete="off" />
          </el-form-item>
          <el-form-item label="账号" :label-width="formLabelWidth" prop="account">
            <el-input v-model="form.account" autocomplete="off" />
          </el-form-item>
          <el-form-item label="密码" :label-width="formLabelWidth" prop="password">
            <el-input v-model="form.password" autocomplete="off" />
          </el-form-item>
          <el-form-item label="名称" :label-width="formLabelWidth" prop="name">
            <el-input v-model="form.name" autocomplete="off" />
          </el-form-item>
          <el-form-item label="头像" :label-width="formLabelWidth" prop="avatar">
            <el-input v-model="form.avatar" autocomplete="off" />
          </el-form-item>
          <el-form-item label="生日" :label-width="formLabelWidth" prop="birthday">
            <el-input v-model="form.birthday" autocomplete="off" />
          </el-form-item>
          <el-form-item label="性别" :label-width="formLabelWidth" prop="sex">
            <el-input v-model="form.sex" autocomplete="off" />
          </el-form-item>
          <el-form-item label="邮箱" :label-width="formLabelWidth" prop="email">
            <el-input v-model="form.email" autocomplete="off" />
          </el-form-item>
          <el-form-item label="电话" :label-width="formLabelWidth" prop="phone">
            <el-input v-model="form.phone" autocomplete="off" />
          </el-form-item>
          <el-form-item label="状态" :label-width="formLabelWidth" prop="status">
            <el-input v-model="form.status" autocomplete="off" />
          </el-form-item>
          <el-form-item label="创建时间" :label-width="formLabelWidth" prop="createTime">
            <el-input v-model="form.createTime" autocomplete="off" />
          </el-form-item>
          <el-form-item label="版本" :label-width="formLabelWidth" prop="version">
            <el-input v-model="form.version" autocomplete="off" />
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="addDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="save">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>
<script>
import axios from "@/utils/request";

export default {
  data() {
    return {
      url: "",
      query: {
        page: 1,
        pageSize: 10
      },
      tableData: [],
      total: 0,
      isShowloading: false,
      delData: [], //删除的数据
      editDialogVisible: false, //是否显示编辑
      addDialogVisible: false, //新建用户框
      form: {
        status: "1"
      },
      addRule: {
        managerId: [{ required: true, message: "请输入管理员ID", trigger: "blur" }],
        account: [{ required: true, message: "请输入账号", trigger: "blur" }],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
        name: [{ required: true, message: "请输入名称", trigger: "blur" }],
        avatar: [{ required: true, message: "请输入头像", trigger: "blur" }],
        birthday: [{ required: true, message: "请输入生日", trigger: "blur" }],
        sex: [{ required: true, message: "请输入性别", trigger: "blur" }],
        email: [{ required: true, message: "请输入邮箱", trigger: "blur" }],
        phone: [{ required: true, message: "请输入电话", trigger: "blur" }],
        status: [{ required: true, message: "请输入状态", trigger: "blur" }],
        createTime: [{ required: true, message: "请输入创建时间", trigger: "blur" }],
        version: [{ required: true, message: "请输入版本", trigger: "blur" }],
      },
      editRule: {
        managerId: [{ required: true, message: "请输入管理员ID", trigger: "blur" }],
        account: [{ required: true, message: "请输入账号", trigger: "blur" }],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
        name: [{ required: true, message: "请输入名称", trigger: "blur" }],
        avatar: [{ required: true, message: "请输入头像", trigger: "blur" }],
        birthday: [{ required: true, message: "请输入生日", trigger: "blur" }],
        sex: [{ required: true, message: "请输入性别", trigger: "blur" }],
        email: [{ required: true, message: "请输入邮箱", trigger: "blur" }],
        phone: [{ required: true, message: "请输入电话", trigger: "blur" }],
        status: [{ required: true, message: "请输入状态", trigger: "blur" }],
        createTime: [{ required: true, message: "请输入创建时间", trigger: "blur" }],
        version: [{ required: true, message: "请输入版本", trigger: "blur" }],
      },
      formLabelWidth: "120px"
    };
  },
  methods: {
    // 分页查询相关
    currentChange(val) {
      this.query.page = val;
      this.getList();
    },
    handleSizeChange(val) {
      this.query.pageSize = val;
      this.getList();
    },
    getList() {
      this.isShowloading = true;
      axios({
        url: "/api/manager/page",
        method: "post",
        data: this.query
      }).then(res => {
        this.tableData = res.records;
        this.total = res.total;
        this.isShowloading = false;
      });
    },
    // 触发添加
    handleAdd() {
        this.form = {};
        this.addDialogVisible=true;
    },    // 保存用户
    save() {
      axios({
        url: "/api/manager/save",
        method: "post",
        data: this.form
      }).then(res => {
        this.$message({
          message: "添加成功",
          type: "success"
        });
        this.addDialogVisible = false;
        this.form = {};
        this.getList();
      });
    },
    // 修改用户
    handleEdit(index, row) {
      this.editDialogVisible = true;
      this.form = Object.assign({}, row);
    },
    edit() {
      this.$refs["editform"].validate(valid => {
        if (valid) {
          axios({
            url: "/api/manager/update",
            method: "post",
            data: this.form
          }).then(res => {
            this.$message({
              type: "success",
              message: "修改用户成功"
            });
            this.getList();
            this.editDialogVisible = false;
            this.form = {};
          });
        }
      });
    },
    confirmClose(done) {
      this.$confirm("确认关闭将丢失已编辑内容？", "提示", {
        type: "warning"
      }).then(() => {
        this.form = {};
        done();
      });
    },
    // 删除单个用户
    handleDelete(index, row) {
      this.$confirm("确认删除选中的记录吗？", "提示", {
        type: "warning"
      }).then(() => {
        axios({
          url: "/api/manager/delete",
          method: "get",
          params: { id: row.managerId }
        }).then(res => {
          this.$message({
            type: "success",
            message: "删除成功"
          });
          this.getList();
        });
      });
    },
    // 批量删除用户
    handleSelectionChange(delData) {
      this.delData = delData;
    },
    delAll() {
      this.$confirm("确认删除选中的记录吗?", "提示", {
        type: "warning"
      }).then(() => {
        this.isShowloading = true;
        let ids = this.delData.map(item => item.managerId).toString();
        axios({
          url: "/api/manager/delete",
          method: "get",
          params: { id: ids }
        }).then(res => {
          this.isShowloading = false;
          this.$message({
            message: "删除成功",
            type: "success"
          });
          this.getList();
        });
      });
    }
  },
  mounted() {
    this.getList();
  }
};
</script>
<style scoped>
.handle-box {
  margin-bottom: 20px;
}

.handle-select {
  width: 120px;
}

.handle-input {
  width: 150px;
  display: inline-block;
}
.del-dialog-cnt {
  font-size: 16px;
  text-align: center;
}
.table {
  width: 100%;
  font-size: 14px;
}
.red {
  color: #ff0000;
}
.mr10 {
  margin-right: 10px;
}
</style>
