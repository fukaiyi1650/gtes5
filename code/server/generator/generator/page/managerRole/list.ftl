<!DOCTYPE HTML>
<html>
&lt;@g.head "xxx管理" />
<body>
&lt;@g.breadcrumb ["管理员角色中心", "管理员角色管理"] />
<div class="page-container">
	<div class="text-c">
		&lt;@g.text "managerId" "输入管理员ID" />
		&lt;@g.text "roleId" "输入角色ID" />
		<button type="submit" class="btn btn-success radius"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
	</div>
	&lt;@g.operate "/managerRole/add.html" 90 />
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort"></table>
	</div>
</div>

&lt;@g.js>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="${ctx}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${ctx}/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="${ctx}/js/managerRole.js"></script>
&lt;/@g.js>
</body>
</html>