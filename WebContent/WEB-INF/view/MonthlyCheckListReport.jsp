<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM-Monthly CheckList Report</title>
<script type="text/javascript">
	
</script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />

</head>
<body bgcolor="#ffffff">

			<%
				java.util.Date date = new java.util.Date();
			%>
			<table border="1" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td align="center" bgcolor="#E2E2E2"><a href="#"
						onClick="history.back();"> Back </a></td>
					<td colspan="4" align="center" bgcolor="#E2E2E2"><font
						size="4" color="#003366"><b>Uttar Pradesh Jal Nigam </b></font>
						&nbsp; <font size="3" color="#003366"></font> <%-- <a href="<%=pdfFileName%>" target="_blank">Download PDF</a> --%>
						<font size="3" color="#003366"></font> <input
						type="button" value="Print this page" onClick="window.print()">

					</td>
				</tr>
			</table>
			<table width="100%" border="0">
				<tr>
					<td colspan="8" align="center"><font size="2" color="#003366">
							<b> Statement of CheckList For ${month} - ${year} </b>
					</font></td>
				</tr>

				<tr>
					<td colspan="9" height="2" bgcolor="lightgrey"></td>
				</tr>
				<tr>
					<td colspan="6" align="left"><font size="2" color="#003366"></font>
					</td>
					<td align="left"><font size="1" color="#003366">Run
							Date : <%=date%></font></td>
				</tr>

				<tr>
					<td colspan="9" height="1" bgcolor="black"></td>
				</tr>
				<tr>
					<td class="bold" bgcolor="#E2E2E2">S.No</td>
					<td class="bold" bgcolor="#E2E2E2">Employee Code</td>
					<td class="bold" bgcolor="#E2E2E2">Employee Name</td>
					<td class="bold" bgcolor="#E2E2E2">Old Value</td>
					<td class="bold" bgcolor="#E2E2E2">New Value</td>
					<td class="bold" bgcolor="#E2E2E2">Description</td>
					<td class="bold" bgcolor="#E2E2E2">Execution Date</td>
					<td class="bold" bgcolor="#E2E2E2">Register Name</td>
					<td class="bold" bgcolor="#E2E2E2">User Name</td>

				</tr>
				<tr>
					<td colspan="9" height="1" bgcolor="black"></td>
				</tr>
				<%
					int i = 1;
				%>
				<c:forEach items="${list}" var="a">
					<%-- <%
			total_Number_Of_Employees++;
		%> --%>
					<tr>
						<td><%=i%></td>
						<td>${a.employeename}</td>
						<td>${a.employeecode}</td>
						<td>${a.oldvalue}</td>
						<td>${a.newvalue}</td>
						<td>${a.description}</td>
						<td>${a.executiondate}<fmt:formatDate
								value="${a.executiondate}" pattern="dd/MM/yyyy" />
						</td>
						<td>${a.register}</td>
						<td>${a.username}</td>
					</tr>
					<%
						i++;
					%>
				</c:forEach>

				<tr>
					<td colspan="9" height="1" bgcolor="black"></td>
				</tr>
				<%-- <tr>
			<td  colspan="9" class="bold"><bean:message key="report.totalNoOfEmployee"/> <%=total_Number_Of_Employees%></td>
		</tr> --%>
			</table>

</body>
</html>
