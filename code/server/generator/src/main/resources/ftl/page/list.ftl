﻿<!DOCTYPE HTML>
<html>
${r'<@'}g.head "${table.comment!}管理" />
<body>
${r'<@'}g.breadcrumb ["${table.comment!}中心", "${table.comment!}管理"] />
<div class="page-container">
	<div class="text-c">
		<#list table.fields as field>
		<#if !field.keyFlag>
		${r'<@'}g.text "${field.propertyName}" "输入${field.comment}" />
		</#if>
		</#list>
		<button type="submit" class="btn btn-success radius"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
	</div>
	${r'<@'}g.operate "/${table.entityPath}/add.html" />
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort" width="100%"></table>
	</div>
</div>

${r'<@'}g.js>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="${r'${ctx}'}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="${r'${ctx}'}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${r'${ctx}'}/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="${r'${ctx}'}/js/${table.entityPath}.js"></script>
${r'</@'}g.js>
</body>
</html>