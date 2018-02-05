<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>公共信息管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaPubinfo/">公共信息列表</a></li>
		<shiro:hasPermission name="oa:oaPubinfo:edit"><li><a href="${ctx}/oa/oaPubinfo/form">公共信息发布申请</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaPubinfo" action="${ctx}/oa/oaPubinfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
<!-- 		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul> -->
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>编号</th>
				<th>发布人</th>
				<th>归属机构</th>
				<th>信息内容</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="oa:oaPubinfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaPubinfo">
			<tr>
				<td><a href="${ctx}/oa/oaPubinfo/form?id=${oaPubinfo.id}">
					${oaPubinfo.id}
				</a></td>
				<td>
					${oaPubinfo.user.name}
				</td>
				<td>
					${oaPubinfo.office.name}
				</td>
				<td>
					${oaPubinfo.content}
				</td>
				<td>
					<fmt:formatDate value="${oaPubinfo.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${oaPubinfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oaPubinfo.remarks}
				</td>
				<shiro:hasPermission name="oa:oaPubinfo:edit"><td>
    				<a href="${ctx}/oa/oaPubinfo/form?id=${oaPubinfo.id}">详情</a>
					<a href="${ctx}/oa/oaPubinfo/delete?id=${oaPubinfo.id}" onclick="return confirmx('确认要删除该公共信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>