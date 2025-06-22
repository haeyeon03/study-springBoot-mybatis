<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/member/read.css' />">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<main>
	<h2>READ</h2>
	<form:form modelAttribute="member">
		<form:hidden path="memberNo" />
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="memberID" readonly="true" /></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:input path="memberPW" readonly="true" /></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><form:textarea path="memberName" readonly="true" /></td>
			</tr>
			<tr>
				<td>email - 1</td>
				<td><form:input path="emailList[0].email" readonly="true" /></td>
			</tr>
			<tr>
				<td>email - 2</td>
				<td><form:input path="emailList[1].email" readonly="true" /></td>

			</tr>
			<tr>
				<td>auth - 1</td>
				<td><form:select path="authList[0].auth" disabled="true">
						<form:option value="" label="=== 선택해 주세요 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
			</tr>
			<tr>
				<td>auth - 2</td>
				<td><form:select path="authList[1].auth" disabled="true">
						<form:option value="" label="=== 선택해 주세요 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
			</tr>
			<tr>
				<td>auth - 3</td>
				<td><form:select path="authList[2].auth" disabled="true">
						<form:option value="" label="=== 선택해 주세요 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
			</tr>
			<tr>
		</table>
	</form:form>
	<div>
		<button type="submit" id="btnModify">Modify</button>
		<button type="submit" id="btnRemove">Remove</button>
		<button type="submit" id="btnList">List</button>
	</div>
</main>

<%@ include file="./footer.jsp"%>
<script>
	$(document).ready(function() {
		var formObj = $("#member");
		console.log(formObj);
		$("#btnModify").on("click", function() {
			var memberNo = $("#memberNo");
			var memberNoVal = memberNo.val();
			/* http://~:8080//member/modify?memberNo=1 */
			self.location = "/member/modify?memberNo=" + memberNoVal;
		});
		$("#btnRemove").on("click", function() {
			formObj.attr("action", "/member/remove");
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			/* http://~:8080/member/list */
			self.location = "/member/list";
		});
	});
</script>