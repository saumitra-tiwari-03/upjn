<%@page import="java.util.Iterator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM-Office Wise Employee Report</title>
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
				String fileName = (String) request.getAttribute("pdfFileName");
				java.util.Date date = new java.util.Date();
				java.text.DateFormat df = java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM,
						java.util.Locale.ENGLISH);
			%>
	<table border="0" cellpadding="1" cellspacing="3" width="100%">
		<tr>
			<td valign="top">&nbsp;</td>
		</tr>
		<tr>
			<td valign="top">
				<table width="100%" align="center" cellpadding="1" cellspacing="1"
					border="0">
					<tr>
						<td valign="top">
							<table width="95%" align="center" cellpadding="1" cellspacing="3"
								border="0" class="table_bg">
								<tr>
									<td valign="top" colspan="7">
										<table width="100%" align="center" class="cell_bg"
											cellpadding="1" cellspacing="3" border="0">
											<tr>
												<td width="95%" colspan="5" align="center" bgcolor="#E2E2E2"><font
													size="4" color="#003366"><b>Uttar Pradesh Jal
															Nigam</b> <input type="button" value="Print this page"
														onClick="window.print()"> <%-- </font> &nbsp;<font size="3" color="#003366"><b>[</b></font><a
													href="<%=fileName%>" target="_blank">Print</a><font
													size="3" color="#003366"><b>]</b></font> --%></td>
												<td align="center" valign="middle" class="table_head">
													<a href="/UPJN/OfficewiseEmpRepForm"> <img height="16"
														hspace="0" src="resources/images/cross.jpeg" width="16"
														border="0" />
												</a>
												</td>
											</tr>

											<tr>
												<td colspan="6" width="100%">
													<table width="100%">
														<tr>
															<td align="left" class="bold" width="50%">Employee
																List</td>
															<td align="right" class="bold" width="100%">Run Date
																<%=df.format(date)%>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
										<table width="100%" align="center" class="cell_bg"
											cellpadding="3" cellspacing="1" border="0">
											<tr>
												<td width="4%" class="bold">S.No</td>
												<td width="13%" class="bold">Employee Code</td>
												<td width="13%" class="bold">Employee Name</td>
												<td width="10%" class="bold">Father Name</td>
												<td width="15%" class="bold">Designation</td>
												<td width="10%" class="bold">Date of Birth</td>
												<td width="10%" class="bold">Home Town</td>
												<td width="10%" class="bold">Category</td>
												<td width="10%" class="bold">Joining Date</td>
												<td width="10%" class="bold">App'nt Mode</td>
												<td width="10%" class="bold">Office Name</td>
												<td width="10%" class="bold">Location Code</td>
												<!-- <td width="10%" class="bold">Cadre</td> -->
											</tr>

											<%
														int i = 1;
													%>
											<c:forEach items="${empList}" var="a">
												<tr>
													<td><%=i%></td>
													<td>${a.employeeCode}</td>
													<td>${a.employeename}</td>

													<td>${a.fathername}</td>
													<td>${a.designation}</td>
													<td>${a.dateofbirth}</td>
													<td>${a.HOMETOWN}</td>

													<td>${a.CASTE}</td>
													<td>${a.datejoining}</td>
													<td>${a.MODEOFAPPOINTMENT}</td>
													<td>${a.officeName}</td>

													<td>${a.loc_code}</td>

													<td></td>


												</tr>
												<%
															i++;
														%>
											</c:forEach>


										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>


