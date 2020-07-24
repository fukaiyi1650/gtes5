$('.table').myDataTable({
    url: "/${table.entityPath}/page?now=" + new Date().getTime(),
    columns: [
    <#list table.fields as field>
        {"mDataProp" : "${field.propertyName}", "sTitle" : "${field.comment}", "sDefaultContent" : "", "sClass" : "center"},
    </#list>
        {"mDataProp" : "id", "sTitle" : "操作", "sDefaultContent" : "", "sClass" : "center", "bSortable": false, "mRender" : function(data,type, row, meta) {
                return "<a title=\"编辑\" href=\"javascript:;\" onclick=\"layer_show('编辑','/${table.entityPath}/edit.html?id="+row.id+"','','510')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a> <a title=\"删除\" href=\"javascript:;\" onclick=\"deleteById(this,"+row.id+")\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>";
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