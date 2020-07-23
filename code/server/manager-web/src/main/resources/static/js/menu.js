$('.table').dataTable({
    "destroy":true,  //不加会报错
    "bProcessing" : true, //DataTables载入数据时，是否显示‘进度’提示
    "bServerSide" : true, //是否启动服务器端数据导入
    "bStateSave" : true, //是否打开客户端状态记录功能,此功能在ajax刷新纪录的时候不会将个性化设定回复为初始化状态
    "aLengthMenu" : [10, 20, 30], //更改显示记录数选项
    "iDisplayLength" : 10, //默认显示的记录数
    "bAutoWidth" : true, //是否自适应宽度
    "bScrollCollapse" : true, //是否开启DataTables的高度自适应，当数据条数不够分页数据条数的时候，插件高度是否随数据条数而改变
    "bPaginate" : true, //是否显示（应用）分页器
    "bInfo" : true, //是否显示页脚信息，DataTables插件左下角显示记录数
    "sPaginationType" : "full_numbers", //详细分页组，可以支持直接跳转到某页
    "bSort" : true, //是否启动各个字段的排序功能
    "aaSorting" : [[1, "asc"]], //默认的排序方式，第2列，升序排列
    "bFilter" : false, //是否启动过滤、搜索功能
    "aoColumns" : [{
        "mDataProp" : "id",
        "sTitle": "<input type=\"checkbox\" name=\"\" value=\"\">",
        "sDefaultContent" : "", //此列默认值为""，以防数据中没有此值，DataTables加载数据的时候报错
        "bVisible" : false, //此列不显示
        "bSortable": false, //是否排序
        "mRender" : function(data, type, row, meta) { // 返回自定义内容
            return "<input name=\"checkbox\" value=\""+row.id+"\" type=\"checkbox\">";
        }
    }, {
        "mDataProp" : "menuId",
        "sTitle" : "菜单ID",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "parentId",
        "sTitle" : "父菜单ID",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "name",
        "sTitle" : "名称",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "icon",
        "sTitle" : "图标",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "url",
        "sTitle" : "URL",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "sort",
        "sTitle" : "排序",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "menu",
        "sTitle" : "是否菜单",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "remark",
        "sTitle" : "备注",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "status",
        "sTitle" : "状态",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "remove",
        "sTitle" : "删除",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "id",
        "sTitle" : "操作",
        "sDefaultContent" : "",
        "sClass" : "center",
        "bSortable": false,
        "mRender" : function(data,type, row, meta) {
            if(row.state===1){
                return "<a title=\"编辑\" href=\"javascript:;\" onclick=\"layer_show('编辑','/menu/edit.html?id="+row.id+"','','510')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a> <a title=\"删除\" href=\"javascript:;\" onclick=\"deleteRow(this,"+row.id+")\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>";
            } else{
                return "<a title=\"编辑\" href=\"javascript:;\" onclick=\"layer_show('编辑','/menu/edit.html?id="+row.id+"','','510')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a> <a title=\"删除\" href=\"javascript:;\" onclick=\"deleteRow(this,"+row.id+")\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>";
            }
        }
    }],
    "sAjaxSource" : "/test.json?now=" + new Date().getTime(),
    //服务器端，数据回调处理
    "fnServerData" : function(sSource, aDataSet, fnCallback) {
        $.ajax({
            "dataType" : 'json',
            "type" : "get",
            "url" : sSource,
            "data" : aDataSet,
            "success" : fnCallback
        });
    }
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
