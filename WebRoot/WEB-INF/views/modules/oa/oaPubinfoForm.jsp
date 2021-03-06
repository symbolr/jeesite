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
		<li><a href="${ctx}/oa/oaPubinfo/">审批列表</a></li>
		<li class="active"><a href="${ctx}/oa/oaPubinfo/form?id=${oaPubinfo.id}">公共信息<shiro:hasPermission name="oa:oaPubinfo:edit">${not empty oaPubinfo.id?'修改':'申请'}</shiro:hasPermission><shiro:lacksPermission name="oa:oaPubinfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="oaPubinfo" action="${ctx}/oa/oaPubinfo/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="act.taskId"/>
		<form:hidden path="act.taskName"/>
		<form:hidden path="act.taskDefKey"/>
		<form:hidden path="act.procInsId"/>
		<form:hidden path="act.procDefId"/>
		<form:hidden id="flag" path="act.flag"/>
		<sys:message content="${message}"/>
		<fieldset>
			<legend>审批申请</legend>
			<table class="table-form">
				<tr>	
				<td class="tit">发布人</td><td>					
				<sys:treeselect id="user" name="user.id" value="${oaPubinfo.user.id}" labelName="user.name" labelValue="${oaPubinfo.user.name}"					
				title="用户" url="/sys/office/treeData?type=3" cssClass="required recipient" cssStyle="width:150px" 
							allowClear="true" notAllowSelectParent="true" smallBtn="false"/>
				</td></tr>
				<tr>
				<td class="tit">归属机构</td>
				<td>
				<sys:treeselect id="office" name="office.id" value="${oaPubinfo.office.id}" labelName="office.name" labelValue="${oaPubinfo.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="required recipient" cssStyle="width:150px" 
							allowClear="true" notAllowSelectParent="true" smallBtn="false"/>
				</tr>
				<tr>
					<td class="tit">信息内容</td>
					<td colspan="5">
						<form:textarea path="content" class="required" rows="5" maxlength="200" cssStyle="width:500px"/>
					</td>
				</tr>
				<tr>
					<td class="tit">管理员意见</td>
					<td colspan="5">
						${oaPubinfo.adminText}
					</td>
				</tr>
		</table>
		</fieldset>
		<div class="form-actions">
			<shiro:hasPermission name="oa:oaPubinfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="提交申请"/>&nbsp;
				<c:if test="${not empty oaPubinfo.id}">
					<input id="btnSubmit2" class="btn btn-inverse" type="submit" value="销毁申请" onclick="$('#flag').val('no')"/>&nbsp;
				</c:if>
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	<c:if test="${not empty oaPubinfo.id}">
			<act:histoicFlow procInsId="${oaPubinfo.act.procInsId}" />
		</c:if>
	</form:form>
</body>
</html>