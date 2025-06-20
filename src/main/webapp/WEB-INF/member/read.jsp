
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