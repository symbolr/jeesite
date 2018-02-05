<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>升级文件管理</title>
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
		<li class="active"><a href="${ctx}/data/dataUpfile/">升级文件列表</a></li>
		<shiro:hasPermission name="data:dataUpfile:edit"><li><a href="${ctx}/data/dataUpfile/form">升级文件添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="dataUpfile" action="${ctx}/data/dataUpfile/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>设备类型：</label>
				<form:input path="termType" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>文件版本：</label>
				<form:input path="version" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>设备类型</th>
				<th>文件版本</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="data:dataUpfile:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dataUpfile">
			<tr>
				<td><a href="${ctx}/data/dataUpfile/form?id=${dataUpfile.id}">
					${dataUpfile.termType}
				</a></td>
				<td>
					${dataUpfile.version}
				</td>
				<td>
					<fmt:formatDate value="${dataUpfile.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${dataUpfile.remarks}
				</td>
				<shiro:hasPermission name="data:dataUpfile:edit"><td>
    				<a href="${ctx}/data/dataUpfile/form?id=${dataUpfile.id}">修改</a>
					<a href="${ctx}/data/dataUpfile/delete?id=${dataUpfile.id}" onclick="return confirmx('确认要删除该升级文件吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>