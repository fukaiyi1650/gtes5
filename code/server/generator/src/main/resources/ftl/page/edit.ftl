<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
&lt;@g.head "编辑${table.comment!}" />
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
		<#list table.fields as field>
			<#if !field.keyFlag>
		&lt;@g.textfield "${field.propertyName}" "${field.comment}" />
			</#if>
		</#list>
		&lt;@g.submit />
	</form>
</article>

&lt;@g.js>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="${r'${ctx}'}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="${r'${ctx}'}/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript" src="${r'${ctx}'}/lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript" src="${r'${ctx}'}/lib/jquery.validation/1.14.0/messages_zh.js"></script>
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
			<#list table.fields as field>
			<#if !field.keyFlag>
				${field.propertyName}:{
					required:true
				}<#if field_index!=(table.fields?size-1)>,</#if>
			</#if>
			</#list>
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