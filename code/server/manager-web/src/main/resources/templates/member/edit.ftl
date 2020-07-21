<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<@g.head "添加会员" />
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
		<@g.textfield "username" "用户名" />
		<@g.radiofield name="sex" label="性别" items=[["男", '1'], ["女", '2'], ["保密", "3"]] />
		<@g.textfield "mobile" "手机" />
		<@g.textfield "email" "邮箱" />
		<@g.filefield "uploadfile" "附件" />
		<@g.selectfield "city" "所在城市">
			<option value="" selected>请选择城市</option>
			<option value="1">北京</option>
			<option value="2">上海</option>
			<option value="3">广州</option>
		</@g.selectfield>
		<@g.areafield "beizhu" "备注" />
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
				username:{
					required:true,
					minlength:2,
					maxlength:16
				},
				sex:{
					required:true,
				},
				mobile:{
					required:true,
					isMobile:true,
				},
				email:{
					required:true,
					email:true,
				},
				uploadfile:{
					required:true,
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