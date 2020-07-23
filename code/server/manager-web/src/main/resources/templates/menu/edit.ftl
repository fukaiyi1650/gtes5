<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<@g.head "编辑菜单" />
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
		<@g.textfield "parentId" "父菜单ID" />
		<@g.textfield "name" "名称" />
		<@g.textfield "icon" "图标" />
		<@g.textfield "url" "URL" />
		<@g.textfield "sort" "排序" />
		<@g.textfield "menu" "是否菜单" />
		<@g.textfield "remark" "备注" />
		<@g.textfield "status" "状态" />
		<@g.textfield "remove" "删除" />
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

		$("#form-member-add").validate({
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
				submitHandler:function(form){
			//$(form).ajaxSubmit();
			var index = parent.layer.getFrameIndex(window.name);
			//parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
	});
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>