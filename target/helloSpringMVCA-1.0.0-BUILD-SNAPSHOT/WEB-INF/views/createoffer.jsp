<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post"
		action="${pageContext.request.contextPath}/docreate">

		<table>
			<tr>
				<td>Subject:</td>
				<td><input type="text" path="subject" /></td>
			</tr>
			<tr>
				<td>Part:</td>
				<td><input type="text" path="part" /></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="수강신청" /></td>
			</tr>
			

		</table>
		
		
	</form>
	
</body>
</html>
