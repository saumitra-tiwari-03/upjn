<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM-DA Arrear Employee Wise Report</title>
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

	<%
		int total_Number_Of_Employees = 0;
		java.util.Date date = new java.util.Date();
		java.text.DateFormat df = java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM,
				java.util.Locale.ENGLISH);
	%>

	<table border="1" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td align="center" bgcolor="#E2E2E2"><a href="#"
				onclick="history.back();"> Back </a></td>
			<td colspan="4" align="center" bgcolor="#E2E2E2"><font size="4"
				color="#003366"><b>Uttar Pradesh Jal Nigam</b></font> &nbsp;<!-- <font size="3" color="#003366"><b>[</b></font>Download PDF<font size="3" color="#003366"><b>]</b></font> -->

				<input type="button" value="Print this page"
				onClick="window.print()"></td>
		</tr>
		<tr>
			<td colspan="5">
				<table width="100%" border="0">
					<tr>
						<td class="msg" colspan="4"></td>
					</tr>
					<tr>

						<td colspan="5" align="left"><font size="2" color="#003366"><b>DA
									Arrear Employee Wise Report</b></font></td>

					</tr>

					<tr>
						<td colspan="14" height="2" bgcolor="lightgrey"></td>
					</tr>
					<tr>
						<td colspan="14" align="right" class="bold">Date:<%=date%>
						</td>
					</tr>
					<tr>
						<c:forEach items="${empdetail}" var="a">
							<td>Emp Code : ${a.employeecode}</td>
							<td>Employee Name : ${a.firstname} ${a.middlename}
								${a.lastname}</td>
							<td>Designation : ${designation}</td>
						</c:forEach>
						<c:forEach items="${gpfdetail}" var="a">
							<td>PAN : ${a.panno}</td>

							<c:if test="${a.isnps eq 'G'}">
								<td>GPF : ${a.gpfacno}</td>
							</c:if>
							<c:if test="${a.isnps eq 'N'}">
								<td>PRAN : ${gpfacno}</td>
							</c:if>
						</c:forEach>
                        <td>Current DA:
						 ${percentvalue1}</td>
						<td>Revised DA:
						 ${percentvalue}</td>
						<td>Due Date : <fmt:formatDate value="${duedate}"
								pattern="dd-MMM-yyyy" />
						</td>
						<td>Into GPF:<fmt:formatDate value="${gpfdate}"
								pattern="dd-MMM-yyyy" />
						</td>
						<td>Cash:<fmt:formatDate value="${cashdate}"
								pattern="dd-MMM-yyyy" />
						</td>
					</tr>

					<tr>
						<td colspan="14" height="1" bgcolor="black"></td>
					</tr>
					<tr>
					
						<td class="bold" bgcolor="#E2E2E2">Month/Year</td>
						<td class="bold" bgcolor="#E2E2E2">Basic Pay</td>
						<td class="bold" bgcolor="#E2E2E2">Grade Pay</td>
						<td class="bold" bgcolor="#E2E2E2">Total</td>
						<td class="bold" bgcolor="#E2E2E2">DA Drawn Amount</td>
						<td class="bold" bgcolor="#E2E2E2">DA Revised Amount</td>
						<%-- <c:if test="${a.isnps eq 'G'}"> --%>
						<td class="bold" bgcolor="#E2E2E2"> Total</td>
						<td class="bold" bgcolor="#E2E2E2">GPF Account</td>
						<td class="bold" bgcolor="#E2E2E2">Net Cash</td>
						<%-- </c:if> --%>
						<%-- <c:if test="${a.isnps eq 'N'}"> --%>
						<td class="bold" bgcolor="#E2E2E2">Total</td>
						<td class="bold" bgcolor="#E2E2E2">NPS</td>
						<td class="bold" bgcolor="#E2E2E2">NSC</td>
						<td class="bold" bgcolor="#E2E2E2">Cash</td>
						<td class="bold" bgcolor="#E2E2E2">UPJN Contribution</td>
						<%-- </c:if> --%>
					</tr>
					
					<tr>
						<td colspan="14" height="1" bgcolor="black"></td>
					</tr>
					<c:forEach items="${paydetail}" var="a">
						<tr>
						
							<td>${a.monthname}/${a.PAYYEAR}</td>
							<td>${a.basicpay}</td>
							<td>${a.gradepay}</td>
							<td>${a.basicpay + a.gradepay}</td>
							<td>${a.da}</td>
							
							<c:choose>
							 <c:when test="${(a.PAYMONTH >= duemonth) && (a.PAYYEAR >= dueyear)}">
							 <td><fmt:formatNumber maxFractionDigits="2" minFractionDigits="2" value="${(a.basicpay + a.gradepay)*percentvalue/100}" /></td>
							<td>${((a.basicpay + a.gradepay)*percentvalue/100) - a.da}</td>
							 </c:when>
							  <c:when test="${(a.PAYMONTH >= duemonth1) && (a.PAYYEAR >= dueyear1)}">
							 <td><fmt:formatNumber maxFractionDigits="2" minFractionDigits="2" value="${(a.basicpay + a.gradepay)*percentvalue1/100}" /></td>
							<td>${((a.basicpay + a.gradepay)*percentvalue1/100) - a.da}</td>
							 </c:when>
							 <%-- <c:otherwise>
							  <td><fmt:formatNumber maxFractionDigits="2" minFractionDigits="2" value="${(a.basicpay + a.gradepay)*percentvalue1/100}" /></td>
							<td>${((a.basicpay + a.gradepay)*percentvalue1/100) - a.da}</td>
							 </c:otherwise> --%>
							</c:choose>						
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							
							
							
						</tr>
					</c:forEach>
					<tr>

						<td colspan="14" height="1" bgcolor="black"></td>
					</tr>

				</table>
			</td>
		</tr>
	</table>

</body>
</html>

<%-- <c:if test="${(a.PAYMONTH >= duemonth) && (a.PAYYEAR >= dueyear)}">
							<td><fmt:formatNumber maxFractionDigits="2" minFractionDigits="2" value="${(a.basicpay + a.gradepay)*percentvalue/100}" /></td>
							<td>${((a.basicpay + a.gradepay)*percentvalue/100) - a.da}</td>
							</c:if>	 --%>
