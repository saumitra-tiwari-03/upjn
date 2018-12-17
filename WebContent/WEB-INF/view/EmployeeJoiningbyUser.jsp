
<!DOCTYPE HTML >
<%@page import="com.mysql.jdbc.Util"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.ArrayList"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM</title>

<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script type="text/javascript" src="resources/js/validation.js"></script>
<script type="text/javascript" src="resources/js/popcalendar.js"></script>
<script type="text/javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<script src="<c:url value="/resources/js/upjn.js" />"></script>
<script type="text/javascript">
	$(document).ready(sortDropDownListByText);
</script>

<script type="text/javascript">
	function searchforjoining() {	
		document.getElementById("employeeJoining").action = "/UPJN/EmployeeJoininglist";
		document.getElementById("employeeJoining").Method = "POST";
		document.getElementById("employeeJoining").submit();

	}
</script>
</head>

<body style="margin: 0px 0px 0px 0px;">

	<form id="employeeJoining" action="" method="post">
		<div style="height: 100%; width: 100%;">

			<div
				style="height: 100px; width: 100%; border-bottom: gray solid 4px;">
				<%@ include file="/WEB-INF/view/Header.jsp"%>
			</div>

			<div
				style="height: 700px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px;">
				<%@ include file="/WEB-INF/view/Menu.jsp"%>
			</div>

			<div
				style="height: 100%; width: 79%; float: left; padding-top: 10px;">

				<input type="hidden" name="ppEmployeemasterid"
					value="${ppEmployeemasterid}">

				<table style="border: 0px; width: 100%;">

					<tr>
						<td valign="top" class="msg">${app_msg}</td>

					</tr>
					<tr>
						<td align="left" valign="top" class="error"></td>
					</tr>
					<tr>
						<td valign="top">
							<table style="border: 0px; width: 100%;">
								<tr>
									<td valign="top" align="center"><table
											style="border: 0px; width: 100%;">
											<tr>
												<td valign="top" align="center"><table
														style="border: 0px; width: 90%;">
														<tr>
															<td class="table_bg" valign="top"><table
																	style="border: 0px; width: 100%;">
																	<tr>
																		<td class=table_head valign="top" align="left"
																			width="95%"></td>

																	</tr>
																</table>

																

																<table style="border: 0px; width: 100%;">
																	<tr>
																		<td class=table_head valign="top" align="left"
																			width="95%">Employee Joining - List of Employees

																		</td>

																	</tr>
																</table>

																<table style="border: 0px; width: 100%;" class="cell_bg">

																	<tr>
																		<td id="t"><img alt=""
																			src="resources/images/sort.gif">Employee Code</td>
																		<td id="t"><img alt=""
																			src="resources/images/sort.gif">Employee Name</td>
																		<td id="t"><img alt=""
																			src="resources/images/sort.gif">Employee
																			Designation</td>
																		<td id="t"><img alt=""
																			src="resources/images/sort.gif">Employment Type</td>
																		<td id="t"><img alt=""
																			src="resources/images/sort.gif">Employee
																			Category</td>
																		<td id="t"><img alt=""
																			src="resources/images/sort.gif">Joining Against</td>
																		<td id="t">Action</td>
																	</tr>
<tr>
						<td valign="top" class="msg">${record_msg}</td>

					</tr>
																	<c:forEach items="${list}" var="list1">
																		<input type="hidden" id="ppEmployeemasterid"
																			value="${list1.ppEmployeemasterid}"
																			name="ppEmployeemasterid" />
																		<tr>
																			<td>${list1.employeecode}</td>
																			<td>${list1.employeename}</td>
																			<td>${list1.designation}</td>
																			<td>${list1.employmenttype}</td>
																			<td>${list1.employmentsubtype}</td>
																			<td>${list1.joiningagainst}</td>

																			<td><a
																				href="saveEmployeeJoiningRecord?ppEmployeemasterid=<c:out value="${list1.ppEmployeemasterid}"/>">
																					Join Employee</a></td>
																		</tr>
																	</c:forEach>

																</table>
													</table></td>
											</tr>
										</table>
							</table>

						</td>
					</tr>
				</table>

			</div>
		</div>
	</form>
</body>
</html>