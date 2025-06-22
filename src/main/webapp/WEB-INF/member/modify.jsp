<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/member/modify.css' />">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
	<main>
		<h2>MODIFY</h2>
		<form:form modelAttribute="member" action="modify">
			<form:hidden path="memberNo" />
			<table>
				<tr>
					<td>ID</td>
					<td><form:input path="memberID" /></td>
					<td><font color="red"><form:errors path="memberID" /></font></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><form:input path="memberPW" /></td>
					<td><font color="red"><form:errors path="memberPW" /></font></td>
				</tr>
				<tr>
					<td>NAME</td>
					<td><form:textarea path="memberName" /></td>
					<td><font color="red"><form:errors path="memberName" /></font></td>
				</tr>
				<tr>
				<td>email - 1</td>
				<td><form:input path="emailList[0].email"/></td>
				<td><font color="red"><form:errors
							path="emailList[0].email" /></font></td>
			</tr>
			<tr>
				<td>email - 2</td>
				<td><form:input path="emailList[1].email"/></td>
				<td><font color="red"><form:errors
							path="emailList[1].email" /></font></td>

			</tr>
			<tr>
				<td>auth - 1</td>
				<td><form:select path="authList[0].auth">
						<form:option value="" label="=== 선택해주세요 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
				<td><font color="red"><form:errors
							path="authList[0].auth" /></font></td>
			</tr>
			<tr>
				<td>auth - 2</td>
				<td><form:select path="authList[1].auth">
						<form:option value="" label="=== 선택해주세요 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
				<td><font color="red"><form:errors
							path="authList[1].auth" /></font></td>
			</tr>
			<tr>
				<td>auth - 3</td>
				<td><form:select path="authList[2].auth">
						<form:option value="" label="=== 선택해주세요 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
				<td><font color="red"><form:errors
							path="authList[2].auth" /></font></td>
			</tr>
			</table>
		</form:form>

		<div>
			<button type="submit" id="btnModify">Modify</button>
			<button type="submit" id="btnList">List</button>
		</div>

	</main>

	<%@ include file="./footer.jsp"%>
	<script>
		$(document).ready(function() {
			var formObj = $("#member");
			$("#btnModify").on("click", function() {
				formObj.attr("action", "/member/modify");
				formObj.attr("method", "post");
				formObj.submit();
			});
			$("#btnList").on("click", function() {
				self.location = "/member/list";
			});
		});
	</script>