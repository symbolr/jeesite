<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>视频广告下发记录管理</title>
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
		<li class="active"><a href="${ctx}/data/dataAccount/">视频广告下发记录列表</a></li>
		<shiro:hasPermission name="data:dataAccount:edit"><li><a href="${ctx}/data/dataAccount/form">视频广告下发记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="dataAccount" action="${ctx}/data/dataAccount/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>视频名称：</label>
				<form:input path="customerName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>发布人姓名</th>
				<th>发布时间</th>
				<th>视频名称</th>
				<th>区域</th>
				<th>备注</th>
				<shiro:hasPermission name="data:dataAccount:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dataAccount">
			<tr>
				<td><a href="${ctx}/data/dataAccount/form?id=${dataAccount.id}">
					${dataAccount.customerName}
				</a></td>
					<td>
					<fmt:formatDate value="${dataAccount.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${dataAccount.customerAddress}
				</td>
				<td>
					${dataAccount.totalEnerge}
				</td>
				<td>
					${dataAccount.remarks}
				</td>
				<shiro:hasPermission name="data:dataAccount:edit"><td>
    				<a href="${ctx}/data/dataAccount/form?id=${dataAccount.id}">修改</a>
					<a href="${ctx}/data/dataAccount/delete?id=${dataAccount.id}" onclick="return confirmx('确认要删除该视频广告下发记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>