<!DOCTYPE HTML>
<html>
<@g.head "xxx管理" />
<body>
<@g.breadcrumb ["管理员中心", "管理员管理"] />
<div class="page-container">
	<div class="text-c">
		<@g.text "account" "输入账号" />
		<@g.text "name" "输入名称" />
		<@g.text "avatar" "输入头像" />
		<@g.text "birthday" "输入生日" />
		<@g.text "sex" "输入性别" />
		<@g.text "email" "输入邮箱" />
		<@g.text "phone" "输入电话" />
		<button type="submit" class="btn btn-success radius"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
	</div>
	<@g.operate "/manager/add.html" />
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort" width="100%"></table>
	</div>
</div>

<@g.js>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="${ctx}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${ctx}/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="${ctx}/js/manager/manager.js"></script>
	<script type="text/javascript" src="${ctx}/js/manager/roles.js"></script>
</@g.js>
</body>
</html>