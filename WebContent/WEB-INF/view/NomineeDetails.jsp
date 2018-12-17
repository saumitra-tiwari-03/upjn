<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM-Nominee Details</title>
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

</head>

<body>

 <form action="#" method="post">
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
													<td width="95%" align="left" valign="top"
														class="table_head">Service Book-Personal Information
													</td>
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
														bordercolor="#4390E0" bgcolor="#4390E0" width="25%">
														<a
														href="#"><strong>Personal
																Details</strong> </a>
													</td>

													<td colspan="1" valign="middle" class="tabdefault"
														bordercolor="#4390E0" bgcolor="#4390E0" width="25%">
														<a
														href="/UPJN/qualificationDetails?PpEmployeemasterid=<c:out value="${PpEmployeemasterid}"/>"><strong>Qualification
																Details</strong> </a>
													</td>
													<td colspan="1" valign="middle" class="tabdefault"
														bordercolor="#4390E0" bgcolor="#FFFFFF" width="25%">
														<strong> 
														Nominee Details </strong>
													</td>
													<td colspan="1" valign="middle" class="tabdefault"
														bordercolor="#4390E0" bgcolor="#4390E0" width="25%">
														<a
														href="/UPJN/DependentDetails?PpEmployeemasterid=<c:out value="${PpEmployeemasterid}"/>"><strong>Dependent
																Details</strong></a>

													</td>
												</tr>
												<tr>
													<td colspan="4" valign="top" class="cell_bg">&nbsp;</td>
												</tr>
											</table>
										

											<table width="100%" border="0" cellspacing="1"
												cellpadding="3">
												<tr>
													<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
													<td colspan="1" valign="middle" class="error_normal"
														align="right">* Fields are required.</td>
												</tr>
												<tr>
													<td colspan="5" valign="top" class="table_bg"></td>
												</tr>
												<tr>
													<td align="left" colspan="3" class="bold">Personal
														Details:</td>
												</tr>
												<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="center">Employee Code</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" name="employeename" readonly="readonly"
																id="employeename" class="txt_medium" maxlength="15"
																value=""/> <span class="star">*</span></td>
														</tr>

														
<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="center">Employee Name</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" name="employeename" readonly="readonly"
																	id="employeename" class="txt_medium" maxlength="15"
																value=""/> <span class="star">*</span></td>
														</tr>

													

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="center">Employee Designation</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" name="nomineename" id="nomineename"
																class="txt_medium" required /> <span
																class="star">*</span></td>
														</tr>

														
														
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="center">Nomination Type</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" name="nomineename" id="nomineename"
																class="txt_medium" required /> <span
																class="star">*</span></td>
														</tr>

														
														
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="center">G P F</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" name="gpf" id="gpf"
																class="txt_medium" required />
													      <a href="javascript:;"
																onclick="displayCalendar(document.forms[0].gpf,'dd/mm/yyyy',document.forms[0].gpf)">

																<img height="16" hspace="0"
																src="resources/images/calendar-icon.gif" width="16"
																border="0" />
															</a>			 <span
																class="star">*</span></td>
														</tr>
														
													
														
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="center">GRATUITY</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" name="gratuity" id="gratuity"
																class="txt_medium" required />
													      <a href="javascript:;"
																onclick="displayCalendar(document.forms[0].gratuity,'dd/mm/yyyy',document.forms[0].gratuity)">

																<img height="16" hspace="0"
																src="resources/images/calendar-icon.gif" width="16"
																border="0" />
															</a>			 <span
																class="star">*</span></td>
														</tr>
														
													
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="center">INSURANCE</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" name="insurance" id="insurance"
																class="txt_medium" required />
													      <a href="javascript:;"
																onclick="displayCalendar(document.forms[0].insurance,'dd/mm/yyyy',document.forms[0].insurance)">

																<img height="16" hspace="0"
																src="resources/images/calendar-icon.gif" width="16"
																border="0" />
															</a>			 <span
																class="star">*</span></td>
														</tr>
														
													
														
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="center">PENSION</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" name="pension" id="pension"
																class="txt_medium" required />
													      <a href="javascript:;"
																onclick="displayCalendar(document.forms[0].pension,'dd/mm/yyyy',document.forms[0].pension)">

																<img height="16" hspace="0"
																src="resources/images/calendar-icon.gif" width="16"
																border="0" />
															</a>			 <span
																class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>

															<td colspan="2" align="right" valign="top"
																class="cell_bg"><input type="submit" value="Submit"
																class="btn_medium"></td><td> <input type="reset"
																value="Reset" class="btn_medium"></td>
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
</body>
</html>