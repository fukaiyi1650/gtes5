<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
${r'<@'}g.head "修改${table.comment!}" />
<body>
<article class="page-container">
	<form action="${r'${ctx}'}/${table.entityPath}/update" method="post" class="form form-horizontal" id="dialog-form">
		<input type="hidden" name="id" value="${r'${'}${table.entityPath}.id}">
		<#list table.fields as field>
			<#if !field.keyFlag>
		${r'<@'}g.textfield "${field.propertyName}" "${field.comment}" "${r'${'}${table.entityPath}.${field.propertyName}}" />
			</#if>
		</#list>
		${r'<@'}g.submit />
	</form>
</article>

${r'<@'}g.js>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${r'${ctx}'}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${r'${ctx}'}/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${r'${ctx}'}/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${r'${ctx}'}/lib/jquery.validation/1.14.0/messages_zh.js"></script>
${r'</@'}g.js>

<script type="text/javascript">
	$(function(){
		$('.skin-minimal input').iCheck({
			checkboxClass: 'icheckbox-blue',
			radioClass: 'iradio-blue',
			increaseArea: '20%'
		});

		$("#dialog-form").validate({
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