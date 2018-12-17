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
<title>Insert title here</title>
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
	int total_Number_Of_Employees=0;
	%>

	<table border="1" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td align="center" bgcolor="#E2E2E2"><a href="#"
				onClick="history.back();"> Back </a></td>

			<td colspan="4" align="center" bgcolor="#E2E2E2"><font size="4"
				color="#003366"><b>Uttar Pradesh Jal Nigam</b></font> &nbsp; <!-- <font
				size="3" color="#003366"><b>[</b></font>Download PDF<font size="3"
				color="#003366"><b>]</b></font> -->
				
				<input type="button" value="Print this page" onClick="window.print()">
				</td>
		</tr>
	</table>

	<table width="100%" border="0">
		<tr>
			<td colspan="10" align="center"><font size="2" color="#003366">
					<b> Completed Loan Statement For ${monthName} - ${yearName} </b>
			</font></td>
		</tr>

		<tr>
			<td colspan="10" height="2" bgcolor="lightgrey"></td>
		</tr>

		<tr>
			<td colspan="8" align="left"><font size="2" color="#003366"></font>
			</td>
			<td align="left"><font size="1" color="#003366">Run Date
					: <%=date%></font></td>
		</tr>

		<tr>
			<td colspan="10" height="1" bgcolor="black"></td>
		</tr>
		<tr>
			<td class="bold" bgcolor="#E2E2E2">S.No</td>
			<td class="bold" bgcolor="#E2E2E2">Employee Name</td>
			<td class="bold" bgcolor="#E2E2E2">Employee Code</td>
			<td class="bold" bgcolor="#E2E2E2">Loan Short Name</td>
			<td class="bold" bgcolor="#E2E2E2">Total Installments</td>
			<td class="bold" bgcolor="#E2E2E2">Installment Amount</td>
			<td class="bold" bgcolor="#E2E2E2">Loan Sanction Order No.</td>
			<td class="bold" bgcolor="#E2E2E2">Sanction Date</td>
			<td class="bold" bgcolor="#E2E2E2">Recovery Commence Month</td>
			<td class="bold" bgcolor="#E2E2E2">Recovery Commence Year</td>

		</tr>
		<tr>
			<td colspan="10" height="1" bgcolor="black"></td>
		</tr>


		<%int i = 1; %>
		<c:forEach items="${completedloanList}" var="a">
			<%
			total_Number_Of_Employees++;
		%>
			<tr>
				<td><%=i%></td>
				<td>${a.employeename}</td>
				<td>${a.employeecode}</td>
				<td>${a.loanshortname}</td>
				<td>${a.paNoofinstallments}</td>
				<td>${a.loanamount}</td>
				<td>${a.loansanctionordno}</td>
				<td>${a.sanctiondate}</td>
				<td>${a.paRecovcommencemonth}</td>
				<td>${a.paRecovcommenceyear}</td>

				<!-- <td><bean:write name="lst" property="daysFromRel" /></td> -->
			</tr>
			<% i++; %>
		</c:forEach>
		<tr>
			<td colspan="10" class="bold" align="left">Total Employees <%=total_Number_Of_Employees%></td>
		</tr>
	</table>
</body>
</html>