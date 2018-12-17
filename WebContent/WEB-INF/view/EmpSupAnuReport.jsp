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
<title>U.P JAL NIGAM-Employee Suspension Annual Report</title>
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

<%int total_Number_Of_Employees=0;
		java.util.Date date = new java.util.Date();
		java.text.DateFormat df = java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM, java.util.Locale.ENGLISH);
	%>
	
	<table border="1" cellpadding="0" cellspacing="0" width="100%">
	<tr>
			<td align="center" bgcolor="#E2E2E2">
				<a href="#" onclick="history.back();">
					Back
				</a>
			</td>
			<td colspan="4" align="center" bgcolor="#E2E2E2">
				<font size="4" color="#003366"><b>Uttar Pradesh Jal Nigam</b></font>
				&nbsp;<!-- <font size="3" color="#003366"><b>[</b></font>Download PDF<font size="3" color="#003366"><b>]</b></font> -->
				
				<input type="button" value="Print this page" onClick="window.print()">
			</td>
		</tr>
	<tr>
		<td colspan="5">
			<table width="100%" border="0">
			<tr>
															<td class="msg" colspan="4">${msg}</td>
														</tr>
			<tr>
			
				<td colspan="5" align="left" >
					<font size="2" color="#003366"><b>List of Employees To Be SuperAnnuated</b></font>
				</td>
				<td colspan="1" align="right" class="bold">
					Employee Category:
					<c:forEach items="${list}" var="a">
					${a.employmentsubtype}
					</c:forEach>
					
				</td>
			</tr>
		</td>
	</tr>
	<tr>
		<td colspan="6" height="2" bgcolor="lightgrey"></td>
	</tr>
	<tr>
		<td colspan="6" align="right" class="bold">
			As on Date:<%=date%> 
		</td>
	</tr>
	<tr>
		<td colspan="6" height="1" bgcolor="black"></td>
	</tr>	
	<tr>
		<td class="bold" bgcolor="#E2E2E2">S.No</td>
		<td class="bold" bgcolor="#E2E2E2">Employee Name</td>
		<td class="bold" bgcolor="#E2E2E2">Employee Code</td>
		<td class="bold" bgcolor="#E2E2E2">Designation</td>
		<td class="bold" bgcolor="#E2E2E2">Retirement Age</td>
		<td class="bold" bgcolor="#E2E2E2">Super Annuation Date</td>
		
	</tr>
	<tr>
		<td colspan="6" height="1" bgcolor="black"></td>
	</tr>	
	<%int i = 1; %>
                                            <c:forEach items="${empList}" var="a">
                                            <%
			total_Number_Of_Employees++;
		%>
											<tr>
												<td><%=i%></td>
												<td>${a.employeename}</td>
												<td>${a.employeecode}</td>
												<td>${a.designation}</td>
												<td>${a.retirementage}</td>
												<%-- <td>${a.retirementdate}</td> --%>
												<td><fmt:formatDate pattern="dd/MM/yyyy" value="${a.retirementdate}" /></td>
											</tr>
											<%
											i++;
                                               
                                                %>
											</c:forEach>

											
	<tr>
		<td colspan="6" height="1" bgcolor="black"></td>
	</tr>	
		<tr>			
			<td  colspan="6" class="bold">Total Employees <%=total_Number_Of_Employees%></td>
		</tr>
	</table>
	</td>
	</tr>
	</table>

</body>
</html>


