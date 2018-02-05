<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>终端信息管理</title>
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
		<li class="active"><a href="${ctx}/data/dataTerm/">终端列表</a></li>
		<shiro:hasPermission name="data:dataTerm:edit"><li><a href="${ctx}/data/dataTerm/form">终端添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="dataTerm" action="${ctx}/data/dataTerm/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>终端编号：</label>
				<form:input path="hxCode" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>终端位置：</label>
				<form:input path="hxName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>终端编号</th>
				<th>终端位置</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="data:dataTerm:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dataTerm">
			<tr>
				<td><a href="${ctx}/data/dataTerm/form?id=${dataTerm.id}">
					${dataTerm.hxCode}
				</a></td>
				<td>
					${dataTerm.hxName}
				</td>
				<td>
					<fmt:formatDate value="${dataTerm.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${dataTerm.remarks}
				</td>
				<shiro:hasPermission name="data:dataTerm:edit"><td>
    				<a href="${ctx}/data/dataTerm/form?id=${dataTerm.id}">修改</a>
					<a href="${ctx}/data/dataTerm/delete?id=${dataTerm.id}" onclick="return confirmx('确认要删除该终端信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>