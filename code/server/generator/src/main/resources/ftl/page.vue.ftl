<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>${table.comment!}管理</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box">
        <el-button type="primary" icon="delete" class="handle-del mr10" @click="delAll" :disabled="this.delData.length===0">批量删除</el-button>
        <#list table.fields as field>
        <el-input v-model="query.${field.propertyName}" placeholder="${field.comment}" class="handle-input mr10" />
        </#list>
        <el-button type="primary" icon="search" @click="getList">搜索</el-button>
        <el-button type="primary" @click="handleAdd">新建</el-button>
      </div>
      <el-table :data="tableData" border class="table" ref="multipleTable" @selection-change="handleSelectionChange" v-loading="isShowloading">
        <el-table-column type="selection" width="55" align="center" />
        <#list table.fields as field>
        <el-table-column prop="${field.propertyName}" label="${field.comment}" sortable />
        </#list>
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
          <#list table.fields as field>
          <el-form-item label="${field.comment}" :label-width="formLabelWidth" prop="${field.propertyName}">
            <el-input v-model="form.${field.propertyName}" autocomplete="off" />
          </el-form-item>
          </#list>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="editDialogVisible=false">取 消</el-button>
          <el-button type="primary" @click.native="edit">确 定</el-button>
        </div>
      </el-dialog>

      <!-- 新建用户 -->
      <el-dialog title="新建用户" :visible.sync="addDialogVisible" ref="form" v-dialogDrag>
        <el-form :model="form" :rules="addRule">
          <#list table.fields as field>
          <el-form-item label="${field.comment}" :label-width="formLabelWidth" prop="${field.propertyName}">
            <el-input v-model="form.${field.propertyName}" autocomplete="off" />
          </el-form-item>
          </#list>
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
        <#list table.fields as field>
        ${field.propertyName}: [{ required: true, message: "请输入${field.comment}", trigger: "blur" }],
        </#list>
      },
      editRule: {
        <#list table.fields as field>
        ${field.propertyName}: [{ required: true, message: "请输入${field.comment}", trigger: "blur" }],
        </#list>
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
        url: "/api/${table.entityPath}/page",
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
        url: "/api/${table.entityPath}/save",
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
            url: "/api/${table.entityPath}/update",
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
          url: "/api/${table.entityPath}/delete",
          method: "get",
          <#list table.fields as field>
          <#if field.keyFlag>
          params: { id: row.${field.propertyName} }
          </#if>
          </#list>
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
        <#list table.fields as field>
        <#if field.keyFlag>
        let ids = this.delData.map(item => item.${field.propertyName}).toString();
        </#if>
        </#list>
        axios({
          url: "/api/${table.entityPath}/delete",
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
