<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>录音管理</title>
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
		<li class="active"><a href="${ctx}/data/dataContact/">录音列表</a></li>
		<%-- <shiro:hasPermission name="data:dataContact:edit"><li><a href="${ctx}/data/dataContact/form">短信联系人添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="dataContact" action="${ctx}/data/dataContact/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>终端：</label>
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
<!-- 			<li><label>电话：</label>
				<form:input path="phone" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li> -->
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>终端编号</th>
				<th>录音</th>
				<th>录音用户</th>
				<th>时间</th>
				<shiro:hasPermission name="data:dataContact:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dataContact">
			<tr>
				<td>123113</td>
				<td>
					
				</td>
				<td>
					张三
				</td>
				<td>
					<fmt:formatDate value="${dataContact.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="data:dataContact:edit"><td>
    				<a href="${ctx}/data/dataContact/form?id=${dataContact.id}">听录音</a>
					<%-- <a href="${ctx}/data/dataContact/delete?id=${dataContact.id}" onclick="return confirmx('确认要删除该短信联系人吗？', this.href)">删除</a> --%>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>