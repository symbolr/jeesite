<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>日志管理</title>
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
		<li class="active"><a href="${ctx}/data/dataSyslog/">日志列表</a></li>
		<shiro:hasPermission name="data:dataSyslog:edit"><li><a href="${ctx}/data/dataSyslog/form">日志添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="dataSyslog" action="${ctx}/data/dataSyslog/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>设备编号，终端或APP：</label>
				<form:input path="termId" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>类型 ，1 终端的，2 App的：</label>
				<form:input path="termType" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>系统产生日志时间：</label>
				<input name="sysDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${dataSyslog.sysDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>设备编号，终端或APP</th>
				<th>类型 ，1 终端的，2 App的</th>
				<th>系统产生日志时间</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="data:dataSyslog:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dataSyslog">
			<tr>
				<td><a href="${ctx}/data/dataSyslog/form?id=${dataSyslog.id}">
					${dataSyslog.termId}
				</a></td>
				<td>
					${dataSyslog.termType}
				</td>
				<td>
					<fmt:formatDate value="${dataSyslog.sysDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${dataSyslog.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${dataSyslog.remarks}
				</td>
				<shiro:hasPermission name="data:dataSyslog:edit"><td>
    				<a href="${ctx}/data/dataSyslog/form?id=${dataSyslog.id}">修改</a>
					<a href="${ctx}/data/dataSyslog/delete?id=${dataSyslog.id}" onclick="return confirmx('确认要删除该日志吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>