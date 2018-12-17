<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM-Employee Transfer</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script language="javascript" src="resources/js/validation.js"></script>
<script language="javascript" src="resources/js/popcalendar.js"></script>
<script language="javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
<script type="text/javascript" src="resources/js/jquery-latest.js"></script>
<script type="text/javascript" src="resources/js/tablesorter.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#myTable").tablesorter();
	});
</script>
<script type="text/javascript">
	function populateTransferDetails() {

		document.getElementById("populateTransferDetails").action = "/UPJN/populateTransferDetails";
		document.getElementById("populateTransferDetails").Method = "POST";
		document.getElementById("populateTransferDetails").submit();
	}
</script>

</head>

<body style="margin: 0px 0px 0px 0px;">

	<div style="height: 100%; width: 100%;">

		<div
			style="height: 100px; width: 100%; border-bottom: gray solid 4px;">
			<%@ include file="/WEB-INF/view/Header.jsp"%>
		</div>

		<div
			style="height: 800px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div style="height: 100%; width: 79%; float: left; padding-top: 10px;">
			<!--   <form action="/transferEmployee" method="post"> -->
			<form action="/UPJN/transfer" method="post"
				id="populateTransferDetails">
				<input type="hidden" name="ppEmployeemasterid"
					value="${PPEMPLOYEEMASTERID}"> <input type="hidden"
					name="ppNoduesdetailid" value="${ppNoduesdetailid}">


				<table border="0" cellpadding="0" cellspacing="0" width="100%">

					<tr>
						<td valign="top" class="msg">${msg}</td>
					</tr>
					<tr>
						<td valign="top"><table width="70%" align="center"
								cellpadding="0" cellspacing="0" border="0">
								<tr>
									<td valign="top"><table width="100%" align="center"
											cellpadding="0" cellspacing="1" border="0" class="table_bg">
											<tr>
												<td valign="top"><table width="100%" align="center"
														class="cell_bg" cellpadding="3" cellspacing="3" border="0">
														<tr>
															<td align="left" valign="top" class="table_head"
																colspan="4">Add Transfer Details</td>
														</tr>
														<tr>
															<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
															<td colspan="1" valign="middle" class="error_normal"
																align="right">* Fields are required.</td>
														</tr>

														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">
																Employee Code</td>
															<td align="left" valign="middle" class="cell_bg"><c:choose>
																	<c:when test="${empcode==null}">
																		<input type="text" class="txt_small" name="employee"
																			required size="30" maxlength="8">

																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${empcode}">
																			<input type="text" class="txt_small" name="employee"
																				size="30" maxlength="8" value="${empcode}">
																			<input type="hidden" name="ppEmployeemasterid"
																				required value="${PPEMPLOYEEMASTERID}">
																		</c:forEach>
																	</c:otherwise>
																</c:choose> <input type="submit" class="btn_go" name="method"
																value="GO" onclick="populateTransferDetails()">

																<span class="star">*</span> &nbsp; <a
																href="/UPJN/SearchEmployee" class="bold"> <u>Select
																		Employee</u></a></td>
														</tr>
														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">
																Employee Name</td>
															<td align="left" valign="top" class="cell_bg"><c:choose>
																	<c:when test="${nameofemployee==null}">
																		<input type="text" name="employeename"
																			class="txt_noborder" size="30" maxlength="100"
																			readonly="readonly">

																	</c:when>
																	<c:otherwise>
																		
																			<input type="text" name="employeename"
																				class="txt_noborder" size="30" maxlength="100"
																				readonly="readonly" value="${nameofemployee}">
																		
																	</c:otherwise>
																</c:choose></td>
														</tr>
														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">
																Employee Designation</td>
															<td align="left" valign="middle" class="cell_bg"><c:choose>
																	<c:when test="${designationofemployee==null}">
																		<input type="text" name="designation"
																			class="txt_noborder" size="30" maxlength="100"
																			readonly="readonly">

																	</c:when>
																	<c:otherwise>
																		
																			<input type="text" name="designation"
																				class="txt_noborder" size="30" maxlength="100"
																				readonly="readonly" value="${designationofemployee}">
																		
																	</c:otherwise>
																</c:choose></td>
														</tr>
														<tr>
															<td colspan="3" class="cell_bg"></td>
														</tr>
														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">
																Transfer Order No.</td>

															<c:choose>
																<c:when test="${noduesordno==null}">
																	<td align="left" valign="top" class="cell_bg"><input
																		class="txt_medium" name="noduesordno" size="20"
																		maxlength="50"> <!-- <html:text styleClass="txt_medium" property="noDuesOrdNo" size="20" maxlength="50" /> -->
																		<span class="star">*[Max 50 char.]</span></td>
																</c:when>
																<c:otherwise>
																	<td align="left" valign="top" class="cell_bg"><input
																		value="${noduesordno}" class="txt_medium" required
																		name="noduesordno" size="20" maxlength="50"> <!-- <html:text styleClass="txt_medium" property="noDuesOrdNo" size="20" maxlength="50" /> -->
																		<span class="star">*[Max 50 char.]</span></td>
																</c:otherwise>
															</c:choose>

														</tr>
														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">
																Transfer Order date (dd/mm/yyyy)</td>
															<c:choose>
																<c:when test="${noduesorddate==null}">
																	<td align="left" valign="top" class="cell_bg"><input
																		type="text" class="txt_date" name="noduesorddate"
																		readonly="readonly"> <a href="javascript:;"
																		onclick="displayCalendar(document.forms[0].noduesorddate,'dd/mm/yyyy',document.forms[0].noduesorddate)">
																			<img height="16" hspace="0"
																			src="resources/images/calendar-icon.gif" width="16"
																			border="0" />

																	</a> <span class="star">*</span></td>
																</c:when>
																<c:otherwise>
																	<td align="left" valign="top" class="cell_bg"><input
																		type="text" class="txt_date"
																		value='<fmt:formatDate value="${noduesorddate}" pattern="dd/MM/yyyy"/>'
																		required name="noduesorddate" readonly="readonly">
																		<a href="javascript:;"
																		onclick="displayCalendar(document.forms[0].noduesorddate,'dd/mm/yyyy',document.forms[0].noduesorddate)">
																			<img height="16" hspace="0"
																			src="resources/images/calendar-icon.gif" width="16"
																			border="0" />

																	</a> <span class="star">*</span></td>
																</c:otherwise>
															</c:choose>
														</tr>
														<tr>
															<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
														</tr>
														<tr>
															<td colspan="5" align="center" valign="top"
																class="cell_bg"><input type="submit"
																class="btn_medium" value="Submit" /> <input
																type="reset" class="btn_medium" value="Reset" /></td>
														</tr>
														<tr>
															<td colspan="1" align="right" valign="top"
																class="cell_bg"></td>
														</tr>
													</table></td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table>

				<br> <br>
				<!-- Data table starts here -->
				<!--  -->
				<script type="text/javascript" src="resources/js/tablesorter.js"></script>

				<table width="90%" class="table_bg" cellpadding="3" cellspacing="3"
					border="0" align="center">

					<tr>
						<td>
							<div style="overflow-y: scroll; height: 200px">
								<table width="100%" id="myTable" cellpadding="0" cellspacing="1"
									border="0" class="tablesorter">

									<thead id="h" align="center">
										<tr>
											<th id="t" width="12%"><img alt=""
												src="resources/images/sort.gif">Employee Code</th>
											<th id="t" width="17%"><img alt=""
												src="resources/images/sort.gif">Employee Name</th>
											<th id="t" width="13%"><img alt=""
												src="resources/images/sort.gif">Employee Designation</th>
											<th id="t" width="10%"><img alt=""
												src="resources/images/sort.gif">Transfer Order No</th>
											<th id="t" width="18%"><img alt=""
												src="resources/images/sort.gif">Transfer Order Date</th>
											<th id="t" width="10%">Action</th>
										</tr>
									</thead>

									<tbody id="b" align="center">
										<c:forEach items="${list}" var="list">
											<tr>											
												<td>${list.employeecode}</td>
												<td>${list.employeename}</td>
												<td>${list.designation}</td>
												<td>${list.noduesordno}</td>

												<td><fmt:formatDate pattern="dd/MM/yyyy"
														value="${list.noduesorddate}" /></td>
												<td><a
													href="/UPJN/edittransfer?employeecode1=<c:out value="${list.employeecode}"/>&ppNoduesdetailid1=<c:out value="${list.ppNoduesdetailid}"/>"><u>Edit</u></a>

													<a
													href="/UPJN/deletetransfer?ID=<c:out value="${list.ppEmployeemasterid}"/>&ID1=<c:out value="${list.ppNoduesdetailid}"/>"
													onclick="javascript:return confirm('Are you sure to delete ?');"><u>Delete</u></a>

												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</td>
					</tr>
				</table>

			</form>
		</div>

	</div>
</body>
</html>