<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<@g.head "修改菜单" />
<body>
<article class="page-container">
	<form action="${ctx}/menu/update" method="post" class="form form-horizontal" id="dialog-form">
		<input type="hidden" name="id" value="${menu.id}">
		<@g.textfield "parentId" "父菜单ID" "${menu.parentId}" />
		<@g.textfield "name" "名称" "${menu.name}" />
		<@g.textfield "icon" "图标" "${menu.icon}" />
		<@g.textfield "url" "URL" "${menu.url}" />
		<@g.textfield "sort" "排序" "${menu.sort}" />
		<@g.textfield "menu" "是否菜单" "${menu.menu}" />
		<@g.textfield "remark" "备注" "${menu.remark}" />
		<@g.textfield "status" "状态" "${menu.status}" />
		<@g.textfield "remove" "删除" "${menu.remove}" />
		<@g.submit />
	</form>
</article>

<@g.js>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${ctx}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${ctx}/lib/jquery.validation/1.14.0/messages_zh.js"></script>
</@g.js>

<script type="text/javascript">
	$(function(){
		$('.skin-minimal input').iCheck({
			checkboxClass: 'icheckbox-blue',
			radioClass: 'iradio-blue',
			increaseArea: '20%'
		});

		$("#dialog-form").validate({
			rules:{
				parentId:{
					required:true
				},
				name:{
					required:true
				},
				icon:{
					required:true
				},
				url:{
					required:true
				},
				sort:{
					required:true
				},
				menu:{
					required:true
				},
				remark:{
					required:true
				},
				status:{
					required:true
				},
				remove:{
					required:true
				}
			},
			onkeyup:false,
			focusCleanup:true,
			success:"valid",
			submitHandler:function(form) {
				$(form).ajaxSubmit(function(data) {
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.msg('修改成功!',{icon:1,time:1000});
					parent.refresh();
					parent.layer.close(index);
				});
			}
		});
	});
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>