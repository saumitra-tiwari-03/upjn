<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM-Qualification Details</title>

<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
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
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>

<script type="text/javascript">
	$(document).ready(sortDropDownListByText);
</script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

</head>


<script type="text/javascript" language="Javascript1.1">
	
</script>
<form action="/UPJN/insertQualificationDetails">
	<input type="hidden" name="PpEmployeemasterid"
		value="${PpEmployeemasterid}">

	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td valign="top">&nbsp;</td>
		</tr>
		<tr>
			<td valign="top" class="msg">${msg}</td>
		</tr>
		<tr>
			<td valign="top" class="error">${error}</td>
		</tr>
		<tr>
			<td valign="top">
				<table width="90%" align="center" cellpadding="0" cellspacing="0"
					border="0">
					<tr>
						<td valign="top">
							<table width="100%" align="center" cellpadding="0"
								cellspacing="0" border="0" class="table_bg">
								<tr>
									<td valign="top">
										<table width="100%" align="center" class="cell_bg"
											cellpadding="0" cellspacing="1" border="0">
											<tr>
												<td width="95%" align="left" valign="top" class="table_head">
													Service Book-Personal Information</td>
												<td></td>
												<td align="center" valign="middle" class="table_head">
													<a href="/upjn3/SearchEmployee.do?method=searchEmployeeSB"><img
														src="images/cross.jpeg" height="16" width="16" border="0"
														hspace="0"></a>
												</td>
											</tr>
										</table>
										<table width="100%" align="center" class="cell_bg"
											cellpadding="0" cellspacing="1" border="0">
											<tr>
												<td colspan="4">&nbsp;</td>
											</tr>
											<tr>
												<td colspan="1" valign="middle" class="tabdefault"
													bordercolor="#4390E0" bgcolor="#4390E0" width="25%"><a
													href="/UPJN/ServiceBook?PpEmployeemasterid=<c:out value="${PpEmployeemasterid}"/>"><strong>Personal
															Details</strong></a></td>
												<td colspan="1" valign="middle" class="tabdefault"
													bgcolor="#FFFFFF" width="25%"><strong>
														Qualification Details </strong></td>
												<td colspan="1" valign="middle" class="tabdefault"
													bordercolor="#4390E0" bgcolor="#4390E0" width="25%"><a
													href="/UPJN/NomineeDetails?PpEmployeemasterid=<c:out value="${PpEmployeemasterid}"/>"><strong>Nominee
															Details</strong></a></td>
												<td colspan="1" valign="middle" class="tabdefault"
													bordercolor="#4390E0" bgcolor="#4390E0" width="25%"><a
													href="/UPJN/DependentDetails?PpEmployeemasterid=<c:out value="${PpEmployeemasterid}"/>"><strong>Dependents
															Detail</strong></a></td>
											</tr>
											<tr>
												<td colspan="4" valign="top" class="cell_bg">&nbsp;</td>
											</tr>
										</table> <!-- Inner Table No 2	-->

										<table border="0" cellpadding="0" cellspacing="0" width="100%">
											<!-- fwtable fwsrc="login_main.png" fwbase="login_main.jpg" fwstyle="Dreamweaver" fwdocid = "119018000" fwnested="1" -->
											<tr>

												<td colspan="1" valign="middle" class="error_normal"
													align="right">* Fields are required.</td>
											</tr>
											<tr>
												<td valign="top">
													<table width="100%" border="0" align="center"
														cellpadding="0" cellspacing="0">
														<tr>
															<td align="center" valign="top">
																<table width="100%" border="0" cellspacing="0"
																	cellpadding="0">
																	<tr>
																		<td valign="top" align="center">
																			<table width="70%" border="0" cellspacing="1"
																				cellpadding="1">
																				<tr>
																					<td valign="top" class="table_bg">
																						<table width="100%" border="0" cellspacing="1"
																							cellpadding="3">
																							<tr>
																								<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
																							</tr>

																							<tr>
																								<td valign="top" class="cell_bg">&nbsp;</td>
																								<td align="left" valign="top" class="cell_bg">
																									Employee Code
																								<td width="54%" align="left" valign="top"
																									class="cell_bg"><c:forEach items="${list}"
																										var="a">
                                                                     ${a.employeecode}</c:forEach>
																								</td>

																							</tr>
																							<tr>
																								<td valign="top" class="cell_bg">&nbsp;</td>
																								<td align="left" valign="top" class="cell_bg">
																									Employee Name</td>
																								<td align="left" valign="top" class="cell_bg">
																									<c:forEach items="${list}" var="a">
                                                                 ${a.employeename}</c:forEach>
																								</td>
																							</tr>


																							<tr>
																								<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																								<td align="left" valign="top" class="cell_bg">
																									Employee Designation</td>
																								<td align="left" valign="middle" class="cell_bg">
																									<c:forEach items="${list}" var="a">
                                                                  ${a.designation}</c:forEach>
																								</td>
																							</tr>


																							<tr>
																								<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																								<td width="43%" align="left" valign="top"
																									class="cell_bg">Qualification</td>
																								<td align="left" valign="top" class="cell_bg">
																									<select name="ppQualificationmasterid"
																									class="cmb_medium"><option value="-1">[Select
																											Qualification]</option>
																										<c:forEach var="q" items="${QualificationMap}">
																											<option value="${q.key}">${q.value}</option>
																										</c:forEach>
																								</select> <span class="star">*</span>
																								</td>
																							</tr>

																							<tr>
																								<td width="3%" valign="top" class="cell_bg">&nbsp;
																								</td>
																								<td width="43%" align="left" valign="top"
																									class="cell_bg">Details Of Qualification</td>
																								<td align="left" valign="top" class="cell_bg">
																									<input type="text" name="qualificationdetails"
																									maxlength="100" size="30" class="txt_medium">
																									<span class="star">[Max 100 char.]</span>
																								</td>
																							</tr>
																							<tr>
																								<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																								<td width="43%" align="left" valign="top"
																									class="cell_bg"><input type="radio"
																									name="isatjoining" value="true">At Time
																									Of Appointment</td>
																								<td align="left" valign="top" class="cell_bg">
																									<input type="radio" name="isatjoining"
																									value="false">Post Appointment
																								</td>
																							</tr>
																							<tr>
																								<td colspan="3" class="cell_bg"></td>
																							</tr>
																							<tr>
																								<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																								<td width="43%" align="left" valign="top"
																									class="cell_bg">Permission No.</td>
																								<td align="left" valign="top" class="cell_bg">
																									<input type="text" name="permissionno"
																									maxlength="50" size="30" class="txt_medium">
																									<span class="star">*[Max 50 char.]</span>
																								</td>
																							</tr>

																							<tr>
																								<td valign="top" class="cell_bg">&nbsp;</td>
																								<td align="left" valign="top" class="cell_bg">

																									Permission Date (dd/mm/yyyy)</td>
																								<td align="left" valign="top" class="cell_bg"><input
																									type="text" class="txt_date"
																									name="permissiondate" size="11" maxlength="10"
																									readonly="readonly" required><a
																									href="javascript:;"
																									onclick="displayCalendar(document.forms[0].permissiondate,'dd/mm/yyyy', document.forms[0].permissiondate);">
																										<img alt=""
																										src="resources/images/calendar-icon.gif"
																										height="16" hspace="0" width="16">
																								</a> <span class="star">*</span></td>
																							</tr>



																							<tr>
																								<td colspan="5" valign="top" class="cell_bg">&nbsp;
																								</td>
																							</tr>
																							<tr>
																								<td colspan="5" align="center" valign="top"
																									class="cell_bg"><input type="submit"
																									value="Submit" class="btn_medium">

																									&nbsp; <input type="reset" value="Reset"
																									class="btn_medium"></td>
																							</tr>
																						</table>
																					</td>
																				</tr>
																			</table>
																		</td>
																	</tr>
																</table>

															</td>
														</tr>
													</table> <br>
													<table border="0" cellpadding="0" cellspacing="0"
														width="100%">
														<tr>
															<td valign="top" class="msg"></td>
														</tr>
														<tr>
															<td align="left" valign="top" class="error"></td>
														</tr>
														<tr>
															<td><table width="95%" border="0" align="center"
																	cellpadding="1" cellspacing="1">
																	<tr>
																		<td align="center" class="table_bg" valign="top"><table
																				width="100%" border="0" cellspacing="3"
																				cellpadding="3">

																				<tr>
																					<td colspan="9" valign="top" class="" align="left">
																						<table width="100%" align="center" class="cell_bg"
																							cellpadding="3" cellspacing="3">



																							<tr>

																								<td id="t"><img alt=""
																									src="resources/images/sort.gif">Qualification</td>
																								<td id="t"><img alt=""
																									src="resources/images/sort.gif">Detail of
																									Qualification Designation</td>
																								<td id="t"><img alt=""
																									src="resources/images/sort.gif">Time</td>
																								<td id="t"><img alt=""
																									src="resources/images/sort.gif">Permission
																									No</td>
																								<td id="t"><img alt=""
																									src="resources/images/sort.gif">Permission
																									date</td>

																								<td id="t">Action</td>
																							</tr>

																							<c:forEach items="${qualificationInfo}"
																								var="list">
																							
																								<tr>
																									<td>${list.qualification}</td>
																									<td>${list.qualificationdetails}</td>
																									<td>${list.isatjoining}</td>
																									<td>${list.permissionno}</td>
																									<td>${list.permissiondate}</td>

																									<td><a
																										href="/UPJN/editTrainingDetails?ppEmployeequalificationid=<c:out value="${list.ppEmployeequalificationid}"/>"><u>Edit</u></a>   
																										<a
																										href="/UPJN/deleteTrainingDetails?ppEmployeequalificationid=<c:out value="${list.ppEmployeequalificationid}"/>"><u>Delete</u></a></td>
																								</tr>
																							</c:forEach>
																						</table>
																			</table></td>
																	</tr>

																	<tr>
																		<td>&nbsp;</td>

																	</tr>
																	<tr>
																		<td>&nbsp;</td>

																	</tr>
																</table></td>
														</tr>
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
			</td>
		</tr>
	</table>

</form>





</html>