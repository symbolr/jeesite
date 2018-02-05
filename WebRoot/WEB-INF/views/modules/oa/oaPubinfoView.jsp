<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>审批管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/oa/oaPubinfo/">公共信息列表</a></li>
		<li class="active"><a href="${ctx}/oa/oaPubinfo/form?procInsId=${testAudit.procInsId}">审批详情</a></li>
	</ul>
	<form:form class="form-horizontal">
		<sys:message content="${message}"/>
		<fieldset>
			<legend>公共信息发布详情</legend>
			<table class="table-form">
				<tr>
					<td class="tit">发布人</td><td>${oaPubinfo.user.name}</td>
					<td class="tit">部门</td><td>${oaPubinfo.office.name}</td>
				</tr>
				<tr>
					<td class="tit">信息内容</td>
					<td colspan="5">${oaPubinfo.content}</td>
				</tr>
				<tr>
					<td class="tit">管理员意见</td>
					<td colspan="5">
						${oaPubinfo.adminText}
					</td>
				</tr>
			</table>
		</fieldset>
		<act:histoicFlow procInsId="${oaPubinfo.act.procInsId}" />
		<div class="form-actions">
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
