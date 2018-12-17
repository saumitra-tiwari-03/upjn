<%@page
	import="java.util.Iterator,com.nic.upjn.spring.entity.BillAdviceReportEntity"%>
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
<body bgcolor="#ffffff">

	<% 
		int columnspan=4;
		double netPay=0;
		double grandTotal=0;
	%>
	<table border="1" cellpadding="1" cellspacing="1" width="100%"
		bordercolor="lightgrey">
		<c:if test="${visible eq '1'}">
			<%columnspan=6;%>
		</c:if>

		<%
		java.util.Date date = new java.util.Date();
		int columnSize=4;
		//int headSize=3; 
		java.text.DecimalFormat formatter=new java.text.DecimalFormat("##,##0.00");
	%>



		<tr>
			<td align="center" bgcolor="#E2E2E2"><a href="#"
				onClick="history.back();"> Back </a></td>

			<td colspan="<%=columnspan-1%>" align="center" bgcolor="#E2E2E2">

				<input type="button" value="Print this page"
				onClick="window.print()"> <!-- <font size="4" color="#003366"><b> </b></font> &nbsp;<font size="3"
				color="#003366"><b>[</b></font><a onClick="window.print()"
				target="_blank">Download PDF</a><font size="3" color="#003366"><b>]</b></font> -->
			</td>

		</tr>

		<tr>
			<td align="center" bgcolor="#E2E2E2"></td>

			<td colspan="<%=columnspan-1%>" align="center" bgcolor="#E2E2E2">
				<font size="2" color="#003366"><b>Detail Of salary
						paybill(Net) to Employee</b></font> &nbsp;<font size="2" color="#003366"><b>
						Month Name:${monthName} year Name:${yearName} office:${officeName}</b></font>
			</td>

		</tr>
		<tr>
			<td align="left" bgcolor="white" class="bold">S.No.</td>
			<td align="left" bgcolor="white" class="bold">Employee Code</td>
			<td align="left" bgcolor="white" class="bold">Employee Name</td>

			<c:if test="${visible eq '1'}">
				<td align="left" bgcolor="white" class="bold">Bank Account No.
				</td>
				<td align="left" bgcolor="white" class="bold">Branch(Bank)</td>
			</c:if>
			<td align="right" bgcolor="white" class="bold">Pay Amount</td>
		</tr>
		<%
					int i = 1;
				%>
		<c:if test="${billAdviceList != null}">

			<%
				List<BillAdviceReportEntity> list = (List<BillAdviceReportEntity>) request.getAttribute("billAdviceList");
				
				for(BillAdviceReportEntity billAdviceReportEntity : list){
					netPay=Double.parseDouble(billAdviceReportEntity.getPP_NETPAY());
					grandTotal+=netPay;		
			%>

			<tr>
				<td align="left"><%=i%></td>
				<td align="left" bgcolor="white"><%=billAdviceReportEntity.getEMPLOYEECODE() %>
				</td>
				<td align="left" bgcolor="white"><%=billAdviceReportEntity.getEMPLOYEENAME() %>
				</td>

				<c:if test="${visible eq '1'}">
					<td align="left" bgcolor="white"><%=billAdviceReportEntity.getBANKACCNO() %>
					</td>
					<td align="left" bgcolor="white">
						<% if(billAdviceReportEntity.getBRANCHNAME() != null){ %> <%=billAdviceReportEntity.getBRANCHNAME() %>
						(<%=billAdviceReportEntity.getBANKNAME() %>) <%}%>
					</td>
				</c:if>

				<td align="right" bgcolor="white"><%=netPay%></td>
			</tr>
			<%i++; %>
			<%} %>

		</c:if>
		<tr>
			<td align="left" bgcolor="#E2E2E2" colspan="<%=columnspan-1%>"
				class="bold">Grand Total :</td>
			<td align="right" bgcolor="#E2E2E2" colspan="1" class="bold"><%=grandTotal%>
			</td>
		</tr>
	</table>
</body>
</html>