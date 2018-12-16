<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">

</head>

<body>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		modelAttribute="offer">

		<table class="formtable">
			<tr>
				<td class="label">Subject:</td>
				<td><sf:input class="control" type="text" path="subject" /> <br />
					<sf:errors path="subject" class="error" /></td>
			</tr>
			<tr>
				<td class="label">Part:</td>
				<td><sf:input class="control" type="text" path="part" /> <br />
					<sf:errors path="part" class="error" /></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" type="submit" value="수강신청" /></td>
			</tr>

		</table>


	</sf:form>

</body>
</html>
