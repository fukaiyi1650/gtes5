$('.table').myDataTable({
    url: "/managerRole/page?now=" + new Date().getTime(),
    columns: [
        {"mDataProp" : "id", "sTitle" : "管理员角色ID", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "managerId", "sTitle" : "管理员ID", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "roleId", "sTitle" : "角色ID", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "id", "sTitle" : "操作", "sDefaultContent" : "", "sClass" : "center", "bSortable": false, "mRender" : function(data,type, row, meta) {
                return "<a title=\"编辑\" href=\"javascript:;\" onclick=\"layer_show('编辑','/managerRole/edit.html?id="+row.id+"','','510')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a> <a title=\"删除\" href=\"javascript:;\" onclick=\"deleteById(this,"+row.id+")\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>";
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