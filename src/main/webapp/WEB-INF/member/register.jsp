<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 헤더영역 -->
<%@ include file="./header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/member/register.css' />">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<main>
		<h2>REGISTER</h2>
		<form:form modelAttribute="member" action="register">
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
			</table>
		</form:form>
		<div>
			<button type="submit" id="btnRegister">게시판입력</button>
			<button type="submit" id="btnList">게시판전체출력</button>
		</div>
	</main>

	<%@ include file="./footer.jsp"%>
	<script>
		$(document).ready(function() {
			var formObj = $("#member");
			$("#btnRegister").on("click", function() {
				formObj.attr("action", "/member/register");
				formObj.attr("method", "post");
				formObj.submit();
			});
			$("#btnList").on("click", function() {
				/*http://~:8080/member/list  */
				self.location = "/member/list";
			});
		});
	</script>