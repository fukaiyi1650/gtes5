<!DOCTYPE HTML>
<html>
<@g.head "xxx管理" />
<body>
<@g.breadcrumb ["菜单中心", "菜单管理"] />
<div class="page-container">
	<div class="text-c">
		<@g.text "parentId" "输入父菜单ID" />
		<@g.text "name" "输入名称" />
		<@g.text "icon" "输入图标" />
		<@g.text "url" "输入URL" />
		<@g.text "sort" "输入排序" />
		<@g.text "menu" "输入是否菜单" />
		<@g.text "remark" "输入备注" />
		<@g.text "status" "输入状态" />
		<@g.text "remove" "输入删除" />
		<button type="submit" class="btn btn-success radius"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
	</div>
	<@g.operate "/menu/add.html" 90 />
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort"></table>
	</div>
</div>

<@g.js>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="${ctx}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${ctx}/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="${ctx}/js/menu.js"></script>
</@g.js>
</body>
</html>