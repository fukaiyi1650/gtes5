<!DOCTYPE HTML>
<html>
&lt;@g.head "xxx管理" />
<body>
&lt;@g.breadcrumb ["菜单中心", "菜单管理"] />
<div class="page-container">
	<div class="text-c">
		&lt;@g.text "parentId" "输入父菜单ID" />
		&lt;@g.text "name" "输入名称" />
		&lt;@g.text "icon" "输入图标" />
		&lt;@g.text "url" "输入URL" />
		&lt;@g.text "sort" "输入排序" />
		&lt;@g.text "menu" "输入是否菜单" />
		&lt;@g.text "remark" "输入备注" />
		&lt;@g.text "status" "输入状态" />
		&lt;@g.text "remove" "输入删除" />
		<button type="submit" class="btn btn-success radius"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
	</div>
	&lt;@g.operate "/menu/add.html" 90 />
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort"></table>
	</div>
</div>

&lt;@g.js>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="${ctx}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${ctx}/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="${ctx}/js/menu.js"></script>
&lt;/@g.js>
</body>
</html>