<!DOCTYPE HTML>
<html>
&lt;@g.head "xxx管理" />
<body>
&lt;@g.breadcrumb ["管理员中心", "管理员管理"] />
<div class="page-container">
	<div class="text-c">
		&lt;@g.text "account" "输入账号" />
		&lt;@g.text "password" "输入密码" />
		&lt;@g.text "name" "输入名称" />
		&lt;@g.text "avatar" "输入头像" />
		&lt;@g.text "birthday" "输入生日" />
		&lt;@g.text "sex" "输入性别" />
		&lt;@g.text "email" "输入邮箱" />
		&lt;@g.text "phone" "输入电话" />
		&lt;@g.text "status" "输入状态" />
		&lt;@g.text "createTime" "输入创建时间" />
		&lt;@g.text "version" "输入版本" />
		<button type="submit" class="btn btn-success radius"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
	</div>
	&lt;@g.operate "/manager/add.html" 90 />
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort"></table>
	</div>
</div>

&lt;@g.js>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="${ctx}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${ctx}/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="${ctx}/js/manager.js"></script>
&lt;/@g.js>
</body>
</html>