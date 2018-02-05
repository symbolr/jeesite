<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>操作记录管理</title>
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
		<li class="active"><a href="${ctx}/data/dataOperate/">操作记录列表</a></li>
<%-- 		<shiro:hasPermission name="data:dataOperate:edit"><li><a href="${ctx}/data/dataOperate/form">操作记录添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="dataOperate" action="${ctx}/data/dataOperate/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>操作名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>终端编号：</label>
				<form:input path="termId" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>操作人：</label>
				<sys:treeselect id="user" name="user.id" value="${dataOperate.user.id}" labelName="user.name" labelValue="${dataOperate.user.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>操作名称</th>
				<th>操作状态</th>
				<th>终端编号</th>
				<th>操作人</th>
				<th>更新时间</th>
				<th>操作内容</th>
				<shiro:hasPermission name="data:dataOperate:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dataOperate">
			<tr>
				<td><a href="${ctx}/data/dataOperate/form?id=${dataOperate.id}">
					${dataOperate.name}
				</a></td>
				<td>
					成功
				</td>
				<td>
					${dataOperate.termId}
				</td>
				<td>
					${dataOperate.user.name}
				</td>
				<td>
					<fmt:formatDate value="${dataOperate.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${dataOperate.remarks}
				</td>
				<shiro:hasPermission name="data:dataOperate:edit"><td>
    				<a href="${ctx}/data/dataOperate/form?id=${dataOperate.id}">修改</a>
					<a href="${ctx}/data/dataOperate/delete?id=${dataOperate.id}" onclick="return confirmx('确认要删除该操作记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>