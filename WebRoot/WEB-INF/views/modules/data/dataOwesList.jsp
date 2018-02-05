<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>欠费详情管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/data/dataOwes/">欠费详情列表</a></li>
		<shiro:hasPermission name="data:dataOwes:edit"><li><a href="${ctx}/data/dataOwes/form">欠费详情添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="dataOwes" action="${ctx}/data/dataOwes/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>消费月份：</label>
				<form:input path="feeMonth" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>表号：</label>
				<form:input path="ewatchNo" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>消费月份</th>
				<th>消费电量</th>
				<th>表号</th>
				<th>消费金额</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="data:dataOwes:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dataOwes">
			<tr>
				<td><a href="${ctx}/data/dataOwes/form?id=${dataOwes.id}">
					${dataOwes.feeMonth}
				</a></td>
				<td>
					${dataOwes.feeEnergy}
				</td>
				<td>
					${dataOwes.ewatchNo}
				</td>
				<td>
					${dataOwes.monetary}
				</td>
				<td>
					<fmt:formatDate value="${dataOwes.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${dataOwes.remarks}
				</td>
				<shiro:hasPermission name="data:dataOwes:edit"><td>
    				<a href="${ctx}/data/dataOwes/form?id=${dataOwes.id}">修改</a>
					<a href="${ctx}/data/dataOwes/delete?id=${dataOwes.id}" onclick="return confirmx('确认要删除该欠费详情吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>