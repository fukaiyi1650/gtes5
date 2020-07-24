<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>菜单管理</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box">
        <el-button type="primary" icon="delete" class="handle-del mr10" @click="delAll" :disabled="this.delData.length===0">批量删除</el-button>
        <el-input v-model="query.menuId" placeholder="菜单ID" class="handle-input mr10" />
        <el-input v-model="query.parentId" placeholder="父菜单ID" class="handle-input mr10" />
        <el-input v-model="query.name" placeholder="名称" class="handle-input mr10" />
        <el-input v-model="query.icon" placeholder="图标" class="handle-input mr10" />
        <el-input v-model="query.url" placeholder="URL" class="handle-input mr10" />
        <el-input v-model="query.sort" placeholder="排序" class="handle-input mr10" />
        <el-input v-model="query.menu" placeholder="是否菜单" class="handle-input mr10" />
        <el-input v-model="query.remark" placeholder="备注" class="handle-input mr10" />
        <el-input v-model="query.status" placeholder="状态" class="handle-input mr10" />
        <el-input v-model="query.remove" placeholder="删除" class="handle-input mr10" />
        <el-button type="primary" icon="search" @click="getList">搜索</el-button>
        <el-button type="primary" @click="handleAdd">新建</el-button>
      </div>
      <el-table :data="tableData" border class="table" ref="multipleTable" @selection-change="handleSelectionChange" v-loading="isShowloading">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column prop="menuId" label="菜单ID" sortable />
        <el-table-column prop="parentId" label="父菜单ID" sortable />
        <el-table-column prop="name" label="名称" sortable />
        <el-table-column prop="icon" label="图标" sortable />
        <el-table-column prop="url" label="URL" sortable />
        <el-table-column prop="sort" label="排序" sortable />
        <el-table-column prop="menu" label="是否菜单" sortable />
        <el-table-column prop="remark" label="备注" sortable />
        <el-table-column prop="status" label="状态" sortable />
        <el-table-column prop="remove" label="删除" sortable />
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
          <el-form-item label="菜单ID" :label-width="formLabelWidth" prop="menuId">
            <el-input v-model="form.menuId" autocomplete="off" />
          </el-form-item>
          <el-form-item label="父菜单ID" :label-width="formLabelWidth" prop="parentId">
            <el-input v-model="form.parentId" autocomplete="off" />
          </el-form-item>
          <el-form-item label="名称" :label-width="formLabelWidth" prop="name">
            <el-input v-model="form.name" autocomplete="off" />
          </el-form-item>
          <el-form-item label="图标" :label-width="formLabelWidth" prop="icon">
            <el-input v-model="form.icon" autocomplete="off" />
          </el-form-item>
          <el-form-item label="URL" :label-width="formLabelWidth" prop="url">
            <el-input v-model="form.url" autocomplete="off" />
          </el-form-item>
          <el-form-item label="排序" :label-width="formLabelWidth" prop="sort">
            <el-input v-model="form.sort" autocomplete="off" />
          </el-form-item>
          <el-form-item label="是否菜单" :label-width="formLabelWidth" prop="menu">
            <el-input v-model="form.menu" autocomplete="off" />
          </el-form-item>
          <el-form-item label="备注" :label-width="formLabelWidth" prop="remark">
            <el-input v-model="form.remark" autocomplete="off" />
          </el-form-item>
          <el-form-item label="状态" :label-width="formLabelWidth" prop="status">
            <el-input v-model="form.status" autocomplete="off" />
          </el-form-item>
          <el-form-item label="删除" :label-width="formLabelWidth" prop="remove">
            <el-input v-model="form.remove" autocomplete="off" />
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
          <el-form-item label="菜单ID" :label-width="formLabelWidth" prop="menuId">
            <el-input v-model="form.menuId" autocomplete="off" />
          </el-form-item>
          <el-form-item label="父菜单ID" :label-width="formLabelWidth" prop="parentId">
            <el-input v-model="form.parentId" autocomplete="off" />
          </el-form-item>
          <el-form-item label="名称" :label-width="formLabelWidth" prop="name">
            <el-input v-model="form.name" autocomplete="off" />
          </el-form-item>
          <el-form-item label="图标" :label-width="formLabelWidth" prop="icon">
            <el-input v-model="form.icon" autocomplete="off" />
          </el-form-item>
          <el-form-item label="URL" :label-width="formLabelWidth" prop="url">
            <el-input v-model="form.url" autocomplete="off" />
          </el-form-item>
          <el-form-item label="排序" :label-width="formLabelWidth" prop="sort">
            <el-input v-model="form.sort" autocomplete="off" />
          </el-form-item>
          <el-form-item label="是否菜单" :label-width="formLabelWidth" prop="menu">
            <el-input v-model="form.menu" autocomplete="off" />
          </el-form-item>
          <el-form-item label="备注" :label-width="formLabelWidth" prop="remark">
            <el-input v-model="form.remark" autocomplete="off" />
          </el-form-item>
          <el-form-item label="状态" :label-width="formLabelWidth" prop="status">
            <el-input v-model="form.status" autocomplete="off" />
          </el-form-item>
          <el-form-item label="删除" :label-width="formLabelWidth" prop="remove">
            <el-input v-model="form.remove" autocomplete="off" />
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
        menuId: [{ required: true, message: "请输入菜单ID", trigger: "blur" }],
        parentId: [{ required: true, message: "请输入父菜单ID", trigger: "blur" }],
        name: [{ required: true, message: "请输入名称", trigger: "blur" }],
        icon: [{ required: true, message: "请输入图标", trigger: "blur" }],
        url: [{ required: true, message: "请输入URL", trigger: "blur" }],
        sort: [{ required: true, message: "请输入排序", trigger: "blur" }],
        menu: [{ required: true, message: "请输入是否菜单", trigger: "blur" }],
        remark: [{ required: true, message: "请输入备注", trigger: "blur" }],
        status: [{ required: true, message: "请输入状态", trigger: "blur" }],
        remove: [{ required: true, message: "请输入删除", trigger: "blur" }],
      },
      editRule: {
        menuId: [{ required: true, message: "请输入菜单ID", trigger: "blur" }],
        parentId: [{ required: true, message: "请输入父菜单ID", trigger: "blur" }],
        name: [{ required: true, message: "请输入名称", trigger: "blur" }],
        icon: [{ required: true, message: "请输入图标", trigger: "blur" }],
        url: [{ required: true, message: "请输入URL", trigger: "blur" }],
        sort: [{ required: true, message: "请输入排序", trigger: "blur" }],
        menu: [{ required: true, message: "请输入是否菜单", trigger: "blur" }],
        remark: [{ required: true, message: "请输入备注", trigger: "blur" }],
        status: [{ required: true, message: "请输入状态", trigger: "blur" }],
        remove: [{ required: true, message: "请输入删除", trigger: "blur" }],
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
        url: "/api/menu/page",
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
        url: "/api/menu/save",
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
            url: "/api/menu/update",
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
          url: "/api/menu/delete",
          method: "get",
          params: { id: row.menuId }
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
        let ids = this.delData.map(item => item.menuId).toString();
        axios({
          url: "/api/menu/delete",
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
