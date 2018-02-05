<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>缴费交易管理</title>
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
		<li class="active"><a href="${ctx}/data/dataTrans/">缴费交易列表</a></li>
		<shiro:hasPermission name="data:dataTrans:edit"><li><a href="${ctx}/data/dataTrans/form">缴费交易添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="dataTrans" action="${ctx}/data/dataTrans/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>终端流水号：</label>
				<form:input path="termWaste" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>客户名称：</label>
				<form:input path="customerName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>用电地址：</label>
				<form:input path="customerAddress" htmlEscape="false" maxlength="64" class="input-medium"/>
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
				<th>批次号</th>
				<th>客户名称</th>
				<th>用电地址</th>
				<th>交易类型</th>
				<th>支付类型</th>
				<th>电表识别号</th>
				<th>交易流水号</th>
				<th>交易金额</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="data:dataTrans:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dataTrans">
			<tr>
				<td><a href="${ctx}/data/dataTrans/form?id=${dataTrans.id}">
					${dataTrans.termId}
				</a></td>
				<td>
					${dataTrans.batchNo}
				</td>
				<td>
					${dataTrans.customerName}
				</td>
				<td>
					${dataTrans.customerAddress}
				</td>
				<td>
					${dataTrans.businessType}
				</td>
				<td>
					${dataTrans.payType}
				</td>
				<td>
					${dataTrans.ewatchNo}
				</td>
				<td>
					${dataTrans.transWaste}
				</td>
				<td>
					${dataTrans.transAmount}
				</td>
				<td>
					<fmt:formatDate value="${dataTrans.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${dataTrans.remarks}
				</td>
				<shiro:hasPermission name="data:dataTrans:edit"><td>
    				<a href="${ctx}/data/dataTrans/form?id=${dataTrans.id}">修改</a>
					<a href="${ctx}/data/dataTrans/delete?id=${dataTrans.id}" onclick="return confirmx('确认要删除该缴费交易吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>