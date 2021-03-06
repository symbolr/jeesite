<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>客户评价管理</title>
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
		<li class="active"><a href="${ctx}/data/dataEvaluate/">客户评价列表</a></li>
		<shiro:hasPermission name="data:dataEvaluate:edit"><li><a href="${ctx}/data/dataEvaluate/form">客户评价添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="dataEvaluate" action="${ctx}/data/dataEvaluate/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>网格员工号：</label>
				<form:input path="workerId" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>客户号：</label>
				<form:input path="customerNo" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>网格员工号</th>
				<th>得分（星数）</th>
				<th>客户号</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="data:dataEvaluate:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dataEvaluate">
			<tr>
				<td><a href="${ctx}/data/dataEvaluate/form?id=${dataEvaluate.id}">
					${dataEvaluate.workerId}
				</a></td>
				<td>
					${dataEvaluate.value}
				</td>
				<td>
					${dataEvaluate.customerNo}
				</td>
				<td>
					<fmt:formatDate value="${dataEvaluate.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${dataEvaluate.remarks}
				</td>
				<shiro:hasPermission name="data:dataEvaluate:edit"><td>
    				<a href="${ctx}/data/dataEvaluate/form?id=${dataEvaluate.id}">修改</a>
					<a href="${ctx}/data/dataEvaluate/delete?id=${dataEvaluate.id}" onclick="return confirmx('确认要删除该客户评价吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>