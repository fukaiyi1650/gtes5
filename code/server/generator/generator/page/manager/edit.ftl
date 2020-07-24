<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
&lt;@g.head "编辑管理员" />
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
		&lt;@g.textfield "account" "账号" />
		&lt;@g.textfield "password" "密码" />
		&lt;@g.textfield "name" "名称" />
		&lt;@g.textfield "avatar" "头像" />
		&lt;@g.textfield "birthday" "生日" />
		&lt;@g.textfield "sex" "性别" />
		&lt;@g.textfield "email" "邮箱" />
		&lt;@g.textfield "phone" "电话" />
		&lt;@g.textfield "status" "状态" />
		&lt;@g.textfield "createTime" "创建时间" />
		&lt;@g.textfield "version" "版本" />
		&lt;@g.submit />
	</form>
</article>

&lt;@g.js>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="${ctx}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript" src="${ctx}/lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript" src="${ctx}/lib/jquery.validation/1.14.0/messages_zh.js"></script>
&lt;/@g.js>

<script type="text/javascript">
	$(function(){
		$('.skin-minimal input').iCheck({
			checkboxClass: 'icheckbox-blue',
			radioClass: 'iradio-blue',
			increaseArea: '20%'
		});

		$("#form-member-add").validate({
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
				},
				status:{
					required:true
				},
				createTime:{
					required:true
				},
				version:{
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