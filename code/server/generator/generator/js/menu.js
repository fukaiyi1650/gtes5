$('.table').myDataTable({
    url: "/menu/page?now=" + new Date().getTime(),
    columns: [
        {"mDataProp" : "id", "sTitle" : "菜单ID", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "parentId", "sTitle" : "父菜单ID", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "name", "sTitle" : "名称", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "icon", "sTitle" : "图标", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "url", "sTitle" : "URL", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "sort", "sTitle" : "排序", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "menu", "sTitle" : "是否菜单", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "remark", "sTitle" : "备注", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "status", "sTitle" : "状态", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "remove", "sTitle" : "删除", "sDefaultContent" : "", "sClass" : "center"},
        {"mDataProp" : "id", "sTitle" : "操作", "sDefaultContent" : "", "sClass" : "center", "bSortable": false, "mRender" : function(data,type, row, meta) {
                return "<a title=\"编辑\" href=\"javascript:;\" onclick=\"layer_show('编辑','/menu/edit.html?id="+row.id+"','','510')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a> <a title=\"删除\" href=\"javascript:;\" onclick=\"deleteById(this,"+row.id+")\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>";
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