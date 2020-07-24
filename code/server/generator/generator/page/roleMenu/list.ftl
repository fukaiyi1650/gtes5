<!DOCTYPE HTML>
<html>
<@g.head "xxx管理" />
<body>
<@g.breadcrumb ["角色菜单中心", "角色菜单管理"] />
<div class="page-container">
	<div class="text-c">
			<@g.text "roleId" "输入角色ID" />
			<@g.text "menuId" "输入菜单ID" />
		<button type="submit" class="btn btn-success radius"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
	</div>
	<@g.operate "/roleMenu/add.html" />
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort" width="100%"></table>
	</div>
</div>

<@g.js>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="${ctx}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${ctx}/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="${ctx}/js/roleMenu.js"></script>
<@g.js>
</body>
</html>