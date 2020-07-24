$('.table').myDataTable({
    url: "/menu/page?now=" + new Date().getTime(),
    columns: [
        {"mDataProp" : "menuId", "sTitle" : "菜单ID", "sDefaultContent" : "", "sClass" : "center"},
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
                if(row.state===1){
                    return "<a title=\"编辑\" href=\"javascript:;\" onclick=\"layer_show('编辑','/menu/edit.html?id="+row.id+"','','510')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a> <a title=\"删除\" href=\"javascript:;\" onclick=\"deleteRow(this,"+row.id+")\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>";
                } else{
                    return "<a title=\"编辑\" href=\"javascript:;\" onclick=\"layer_show('编辑','/menu/edit.html?id="+row.id+"','','510')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a> <a title=\"删除\" href=\"javascript:;\" onclick=\"deleteRow(this,"+row.id+")\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>";
                }
            }
        }
    ]
});

/*删除对话框*/
function deleteRow(obj,id){
    layer.confirm('确认要删除吗？',function(index){
        $.ajax({
            type: 'POST',
            url: '',
            dataType: 'json',
            success: function(data){
                $(obj).parents("tr").remove();
                layer.msg('已删除!',{icon:1,time:1000});
            },
            error:function(data) {
                console.log(data.msg);
            },
        });
    });
}

/*批量删除*/
function batchDelete() {
    var cks=document.getElementsByName("checkbox");
    var count=0,ids="";
    console.log(cks.length);
    for(var i=0;i<cks.length;i++){
        if(cks[i].checked){
            count++;
            ids+=cks[i].value+",";
        }
    }
    if(count==0){
        layer.msg('您还未勾选任何数据!',{icon:5,time:3000});
        return;
    }
    /*去除末尾逗号*/
    if(ids.length>0){
        ids=ids.substring(0,ids.length-1);
    }
    layer.confirm('确认要删除所选的'+count+'条数据吗？',{icon:0},function(index){
        var index = layer.load(3);
        $.ajax({
            type: 'PUT',
            url: '/menu/remove/'+ids,
            dataType: 'json',
            success:function(data){
                layer.close(index);
                if(data.success!=true){
                    layer.alert(data.message,{title: '错误信息',icon: 2});
                    return;
                }
                layer.msg('已删除!',{icon:1,time:1000});
                refresh();
            },
            error:function(XMLHttpRequest){
                layer.close(index);
                layer.alert('数据处理失败! 错误码:'+XMLHttpRequest.status,{title: '错误信息',icon: 2});
            }
        });
    });
}
