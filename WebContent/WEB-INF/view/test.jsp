<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<c:forEach items="${list}" var="list1">
				<td>${list1.employeecode}</td>
				<td>${list1.employeename}</td>
				<td>${list1.designation}</td>
				<td>${list1.employmenttype}</td>
				<td>${list1.employmentsubtype}</td>
				<td>${list1.joiningagainst}</td>
				<td><a href="#">EmployeeJoining</a></td>
			</c:forEach>
		</tr>
	</table>
</body>
</html>