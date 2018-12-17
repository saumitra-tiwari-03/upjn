<%@page import="java.util.Iterator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Deduction Report</title>
<script type="text/javascript">
	
</script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script src="resources/js/validation.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/js/popcalendar.js"></script>
<script type="text/javascript"
	src="resources/js/New_Appointment_validation.js"></script>
<script type="text/javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<script src="<c:url value="/resources/js/upjn.js" />"></script>

</head>
<body bgcolor="#ffffff">

	<%	java.util.Date date = new java.util.Date();
		int total_Employees=0;
	%>

	<table border="1" class="table_rpt" width="100%">
		<tr>
			<td colspan="2" align="center" bgcolor="#E2E2E2"><a href="#"
				onclick="history.back();"> Back </a></td>
			<td colspan="8" align="center" bgcolor="#E2E2E2"><font size="4"
				color="#003366"><b>Uttar Pradesh Jal Nigam</b></font> 
				&nbsp;
				<font size="3" color="#003366"><b>[</b></font>
				<input type="button" value="Print this page" onClick="window.print()">
				<font size="3" color="#003366"><b>]</b></font></td>
		</tr>
		<tr>
			<td colspan="10" align="center" bgcolor="#E2E2E2"><font size="3"
				color="#003366"> List of Employees On Deputation on Date
					${asondate} </font></td>
		</tr>
		<tr>
			<td colspan="10">
				<table width="100%">
					<tr>
						<td colspan="6" align="left" class="bold">Category:<c:forEach
								items="${list}" var="a">
					${a.employmentsubtype}
					</c:forEach>
						</td>
						<td colspan="4" align="right" class="bold">Date: <%=date%>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td class="bold">S.No</td>
			<td class="bold">Employee Name</td>
			<td class="bold">Employee Code</td>
			<td class="bold">Designation</td>
			<td class="bold">Target Office</td>
			<td class="bold">Deputation Order No.</td>
			<td class="bold">Deputation Order Date</td>
			<td class="bold">Retirement Order No.</td>
			<td class="bold">Retirement Order Date</td>
			<td class="bold">Days From Relieveing</td>
		</tr>
		<%int i = 1; %>
		<c:forEach items="${empList}" var="a">
			<%
                                            total_Employees++;
		%>
			<tr>
				<td><%=i%></td>
				<td>${a.employeename}</td> 
				<td>${a.employeecode}</td>
				<td>${a.designation}</td>
				<td>${a.lastoffice}</td>			
				<td>${a.deputationorderno}</td>
				<td>${a.deputationorderdate}</td>
				<td>${a.relieveorderno}</td>
				<td>${a.relieveorderdate}</td>
				<td>${a.daysFromRel}</td>
				
				<!-- <td><bean:write name="lst" property="daysFromRel" /></td> -->
			</tr>
			<% i++; %>
		</c:forEach>
		<tr>
			<td colspan="10" class="bold" align="left">Total Employees <%=total_Employees%></td>
		</tr>
	</table>
</body>
</html>