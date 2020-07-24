<!DOCTYPE HTML>
<html>
<@g.head "用户管理" />
<body>
<@g.breadcrumb ["用户中心", "用户管理"] />
<div class="page-container">
	<div class="text-c">
		日期范围： <@g.minDate "datemin" "datemax" /> - <@g.maxDate "datemax" "datemin" />
		<@g.text "query" "输入会员名称、电话、邮箱" />
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</div>
	<@g.operate "/member/add.html" />
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort" width="100%"></table>
	</div>
</div>

<@g.js>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="${ctx}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${ctx}/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="${ctx}/js/member.js"></script>
</@g.js>
</body>
</html>