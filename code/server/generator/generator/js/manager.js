$('.table').myDataTable({
    url: "/manager/page?now=" + new Date().getTime(),
    columns: [
        {"mDataProp" : "id", "sTitle" : "管理员ID", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "account", "sTitle" : "账号", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "password", "sTitle" : "密码", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "name", "sTitle" : "名称", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "avatar", "sTitle" : "头像", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "birthday", "sTitle" : "生日", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "sex", "sTitle" : "性别", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "email", "sTitle" : "邮箱", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "phone", "sTitle" : "电话", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "status", "sTitle" : "状态", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "createTime", "sTitle" : "创建时间", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "version", "sTitle" : "版本", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "id", "sTitle" : "操作", "sDefaultContent" : "", "sClass" : "center", "bSortable": false, "mRender" : function(data,type, row, meta) {
                return "<a title=\"编辑\" href=\"javascript:;\" onclick=\"layer_show('编辑','/manager/edit.html?id="+row.id+"','','510')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a> <a title=\"删除\" href=\"javascript:;\" onclick=\"deleteById(this,"+row.id+")\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>";
            }
        }
    ]
});

/*删除对话框*/
function deleteById(obj,id) {
    deleteRow(obj, id, '/manager/delete');
}

/*批量删除*/
function batchDeleteByIds() {
    batchDelete('/manager/delete');
}