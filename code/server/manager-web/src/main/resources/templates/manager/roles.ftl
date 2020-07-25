<!DOCTYPE HTML>
<html>
<@g.head "管理员管理" />
<body>
	<table class="roles table table-border table-bordered table-hover table-bg table-sort" width="100%"></table>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="button" onclick="saveRoles(${managerId})" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
</div>

<@g.js>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="${ctx}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${ctx}/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="${ctx}/js/manager/roles.js"></script>
</@g.js>
</body>
</html>