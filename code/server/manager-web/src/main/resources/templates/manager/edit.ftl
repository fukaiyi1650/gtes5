<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<@g.head "修改管理员" />
<body>
<article class="page-container">
	<form action="${ctx}/manager/update" method="post" class="form form-horizontal" id="dialog-form">
		<input type="hidden" name="id" value="${manager.id}">
		<@g.textfield "account" "账号" "${manager.account}" />
		<@g.textfield "password" "密码" />
		<@g.textfield "name" "名称" "${manager.name}" />
		<@g.textfield "avatar" "头像" "${manager.avatar}" />
		<#assign birthday=(manager.birthday?string("yyyy-MM-dd"))! />
		<@g.textfield "birthday" "生日" birthday />
		<@g.textfield "sex" "性别" "${manager.sex}" />
		<@g.textfield "email" "邮箱" "${manager.email}" />
		<@g.textfield "phone" "电话" "${manager.phone}" />
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
				account:{
					required:true
				},
				password:{
					required:true
				},
				name:{
					required:true
				},
				avatar:{
					required:true
				},
				birthday:{
					required:true
				},
				sex:{
					required:true
				},
				email:{
					required:true
				},
				phone:{
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