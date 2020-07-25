$('.roles').myDataTable({
    url: "/role/page?now=" + new Date().getTime(),
    columns: [
        {"mDataProp" : "name", "sTitle" : "名称", "sDefaultContent" : "", "sClass" : "center"}
    ]
});

/*保存用户的角色*/
function saveRoles(managerId) {
    var cks=document.getElementsByName("checkbox");
    var count=0,ids="";
    console.log(cks.length);
    for(var i=0;i<cks.length;i++){
        if(cks[i].checked){
            count++;
            ids+=cks[i].value+",";
        }
    }
    if(count===0){
        parent.layer.msg('您还未勾选任何数据!',{icon:5,time:3000});
        return;
    }
    /*去除末尾逗号*/
    if(ids.length>0){
        ids=ids.substring(0,ids.length-1);
    }
    parent.layer.confirm('确认要保存所选的'+count+'条数据吗？',{icon:0},function(index){
        // var index = layer.load(3);
        $.ajax({
            type: 'POST',
            url: '/manager/saveRoles',
            dataType: 'json',
            data: {managerId : managerId, roleIds : ids},
            success:function(data){
                var index = parent.layer.getFrameIndex(window.name);
                if(data.error){
                    parent.layer.msg(data.message,{title: '错误信息',icon: 2});
                    return;
                }
                parent.layer.msg('已保存角色!',{icon:1,time:1000});
                parent.layer.close(index);
            },
            error:function(XMLHttpRequest){
                parent.layer.close(index);
                parent.layer.alert('数据处理失败! 错误码:'+XMLHttpRequest.status,{title: '错误信息',icon: 2});
            }
        });
    });
}
