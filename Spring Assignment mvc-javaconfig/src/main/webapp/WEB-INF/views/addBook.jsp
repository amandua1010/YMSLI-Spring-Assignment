<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="addBook" method="post" modelAttribute="book">
		
		<table>
			<tr>
				<td>Input ISBN of the Book: </td>
				<td><form:input path="isbn" /></td>
			</tr>
			<tr>
				<td>Input Title of the Book: </td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>Input Author Name of the Book: </td>
				<td><form:input path="author" /></td>
			</tr>
			<tr>
				<td>Input Price of the Book: </td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
		
	</form:form>
	
</body>
</html>