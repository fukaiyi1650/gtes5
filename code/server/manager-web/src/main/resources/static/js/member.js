$('.table').dataTable({
    "destroy":true,  //不加会报错
    "bProcessing" : true, //DataTables载入数据时，是否显示‘进度’提示
    "bServerSide" : true, //是否启动服务器端数据导入
    "bStateSave" : true, //是否打开客户端状态记录功能,此功能在ajax刷新纪录的时候不会将个性化设定回复为初始化状态
    // "bJQueryUI" : true, //是否使用 jQury的UI theme
    // "sScrollY" : 450, //DataTables的高
    // "sScrollX" : 820, //DataTables的宽
    "aLengthMenu" : [10, 20, 30], //更改显示记录数选项
    "iDisplayLength" : 10, //默认显示的记录数
    "bAutoWidth" : true, //是否自适应宽度
    //"bScrollInfinite" : false, //是否启动初始化滚动条
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
        "mDataProp" : "username",
        "sTitle" : "用户名",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "sex",
        "sTitle" : "性别",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "phone",
        "sTitle" : "手机",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "email",
        "sTitle" : "邮箱",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "address",
        "sTitle" : "地址",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "created",
        "sTitle" : "创建时间",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "updated",
        "sTitle" : "更新时间",
        "sDefaultContent" : "",
        "sClass" : "center"
    }, {
        "mDataProp" : "status",
        "sTitle" : "状态",
        "sDefaultContent" : "",
        "sClass" : "center",
        "mRender" : function(data,type, row, meta) {
            if (row.status === 1) {
                return '<span class="label label-success radius">已启用</span>';
            } else {
                return '<span class="label label-error radius">已禁用</span>';
            }
        }
    }, {
        "mDataProp" : "id",
        "sTitle" : "操作",
        "sDefaultContent" : "",
        "sClass" : "center",
        "bSortable": false,
        "mRender" : function(data,type, row, meta) {
            if(row.state===1){
                return "<a id=\"td-manage\" style=\"text-decoration:none\" onClick=\"member_stop(this,"+row.id+")\" href=\"javascript:;\" title=\"停用\"><i class=\"Hui-iconfont\">&#xe631;</i></a> <a title=\"编辑\" href=\"javascript:;\" onclick=\"member_edit('编辑','/member/add.html',"+row.id+",'','510')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a> <a style=\"text-decoration:none\" class=\"ml-5\" onClick=\"change_password('修改密码','change-password',"+row.id+",'600','270')\" href=\"javascript:;\" title=\"修改密码\"><i class=\"Hui-iconfont\">&#xe63f;</i></a> <a title=\"删除\" href=\"javascript:;\" onclick=\"member_del(this,"+row.id+")\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>";
            } else{
                return "<a id=\"td-manage\" style=\"text-decoration:none\" onClick=\"member_start(this,"+row.id+")\" href=\"javascript:;\" title=\"启用\"><i class=\"Hui-iconfont\">&#xe6e1;</i></a> <a title=\"编辑\" href=\"javascript:;\" onclick=\"member_edit('编辑','/member/add.html',"+row.id+",'','510')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a> <a style=\"text-decoration:none\" class=\"ml-5\" onClick=\"change_password('修改密码','change-password',"+row.id+",'600','270')\" href=\"javascript:;\" title=\"修改密码\"><i class=\"Hui-iconfont\">&#xe63f;</i></a> <a title=\"删除\" href=\"javascript:;\" onclick=\"member_del(this,"+row.id+")\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>";
            }
        }
    }],
    // "oLanguage": { //国际化配置
    //     "sProcessing": "正在获取数据，请稍后...",
    //     "sLengthMenu": "显示 _MENU_ 条",
    //     "sZeroRecords": "没有您要搜索的内容",
    //     "sInfo": "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
    //     "sInfoEmpty": "记录数为0",
    //     "sInfoFiltered": "(全部记录数 _MAX_ 条)",
    //     "sInfoPostFix": "",
    //     "sSearch": "搜索",
    //     "sUrl": "",
    //     "oPaginate": {
    //         "sFirst": "第一页",
    //         "sPrevious": "上一页",
    //         "sNext": "下一页",
    //         "sLast": "最后一页"
    //     }
    // },
    // "fnRowCallback" : function(nRow, aData, iDisplayIndex) {
    //     /* 用来改写用户权限的 */
    //     if (aData.ISADMIN === '1')
    //         $('td:eq(5)', nRow).html('管理员');
    //     if (aData.ISADMIN === '2')
    //         $('td:eq(5)', nRow).html('资料下载');
    //     if (aData.ISADMIN === '3')
    //         $('td:eq(5)', nRow).html('一般用户');
    //
    //     return nRow;
    // },
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

/*用户-添加*/
function member_add(title,url,w,h){
    layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
    layer_show(title,url,w,h);
}
/*用户-停用*/
function member_stop(obj,id){
    layer.confirm('确认要停用吗？',function(index){
        $.ajax({
            type: 'POST',
            url: '',
            dataType: 'json',
            success: function(data){
                $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
                $(obj).remove();
                layer.msg('已停用!',{icon: 5,time:1000});
            },
            error:function(data) {
                console.log(data.msg);
            },
        });
    });
}

/*用户-启用*/
function member_start(obj,id){
    layer.confirm('确认要启用吗？',function(index){
        $.ajax({
            type: 'POST',
            url: '',
            dataType: 'json',
            success: function(data){
                $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
                $(obj).remove();
                layer.msg('已启用!',{icon: 6,time:1000});
            },
            error:function(data) {
                console.log(data.msg);
            },
        });
    });
}
/*用户-编辑*/
function member_edit(title,url,id,w,h){
    layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
    layer_show(title,url,w,h);
}
/*用户-删除*/
function member_del(obj,id){
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
function datadel() {
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
            url: '/member/remove/'+ids,
            dataType: 'json',
            success:function(data){
                layer.close(index);
                if(data.success!=true){
                    layer.alert(data.message,{title: '错误信息',icon: 2});
                    return;
                }
                layer.msg('已删除!',{icon:1,time:1000});
                member_count();
                refresh();
            },
            error:function(XMLHttpRequest){
                layer.close(index);
                layer.alert('数据处理失败! 错误码:'+XMLHttpRequest.status,{title: '错误信息',icon: 2});
            }
        });
    });
}