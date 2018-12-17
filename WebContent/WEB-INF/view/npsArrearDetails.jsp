<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>U.P JAL NIGAM-NPS Arrear Details</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script language="javascript" src="resources/js/validation.js"></script>
<script language="javascript" src="resources/js/popcalendar.js"></script>
<script language="javascript" src="resources/js/NEW_NEW.js"></script>
<script language="javascript" src="resources/js/upjn.js"></script>

<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>

</head>

<body>
	<script type="text/javascript" language="Javascript1.1">
		
	</script>
	<script type="text/javascript">
		$(document).ready(function() {

			$("#monthList").val($("#actual_ded_mon").val());
			$("#yearList").val($("#actual_ded_year").val());
			$("#monthListCON").val($("#mon_contr").val());
			$("#yearListCON").val($("#year_contr").val());

		});
	</script>


	<form action="/UPJN/addNPSErrearDetails" method="post">
		 
		<input type="hidden" name="method" value="addEmployeePayDetail">
		<input type="hidden" name="ppEmployeeMasterID" value="${ppEmployeeMasterID}">
		
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top" class="msg">
				${mes}
				</td>
			</tr>
			<tr>
				<td valign="top" class="error">
				${error}
				</td>
			</tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td align="center" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td valign="top" align="center">
											<table width="80%" border="0" cellspacing="1" cellpadding="1">
												<tr>
													<td valign="top" class="table_bg">
														<table width="100%" border="0" cellspacing="1"
															cellpadding="3">
															<tr>
																<td width="79%" align="left" valign="top"
																	class="table_head">Update NPS Arrear</td>
																<td width="21%" align="center" valign="middle"
																	class="table_head"><a
																	href="setEmpPayDetail.do?method=dedDetail&action=add&ID=3025">
																		Back to Deduction Page</a></td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<td valign="top" class="table_bg">
														<table width="100%" border="0" cellspacing="1"
															cellpadding="3">
															<tr>
																<td colspan="4">
																	<table width="100%" border="0" cellspacing="1"
																		cellpadding="3">
																	</table>
																</td>
															</tr>
															<tr>
																<td valign="top" class="cell_bg">&nbsp;</td>
																<td colspan="3" align="left" valign="top"
																	class="cell_bg">&nbsp;</td>
															</tr>
															<tr>
																<td valign="top" class="cell_bg">&nbsp;</td>
																<td width="31%" align="left" valign="top"
																	class="cell_bg">Register Name</td>
																<td colspan="2" align="left" valign="top"
																	class="cell_bg"><input type="text"
																	name="registerName" value="${registerName}"
																	readonly="readonly" class="txt_noborder"></td>
															</tr>
															<tr>
																<td valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">
																	Employee Code</td>
																<td colspan="2" align="left" valign="middle"
																	class="cell_bg"><input type="text"
																	name="employeeCode" value="${employeecode}"
																	readonly="readonly" class="txt_noborder">
															</tr>

															<tr>
																<td valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">
																	Employee Name</td>
																<td colspan="2" align="left" valign="top"
																	class="cell_bg"><input type="text"
																	name="employeeName" value="${employeename}"
																	readonly="readonly" class="txt_noborder"></td>
															</tr>
															<tr>
																<td colspan="4" class="cell_bg"></td>
															</tr>
															<tr>
																<td width="5%" valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">
																	Employee Designation</td>
																<td colspan="2" align="left" valign="middle"
																	class="cell_bg"><input type="text"
																	name="designation" value="${designation}"
																	readonly="readonly" class="txt_noborder"></td>
															</tr>
															<tr>
																<td colspan="4" class="cell_bg"></td>
															</tr>

															<tr>
																<td valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">
																	Section Name</td>
																<td colspan="2" align="left" valign="top"
																	class="cell_bg"><input type="text"
																	name="sectionName" value="${sectionname}"
																	readonly="readonly" class="txt_noborder"></td>
															</tr>
															<tr>
																<td width="5%" valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">
																	Employment Type</td>
																<td colspan="2" align="left" valign="middle"
																	class="cell_bg"><input type="text"
																	name="employmentType" value="${employmenttype}"
																	readonly="readonly" class="txt_noborder"> <input
																	type="hidden" name="mas_EmploymentTypeID"></td>
															</tr>


															<tr>
																<td valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">

																	Joining Date</td>
																<td align="left" valign="top" class="cell_bg"><input
																	type="text" class="txt_date" name="joining_mnth"
																	value="${joining_mnth}" id="joining_mnth"
																	maxlength="10" readonly="readonly"> <a
																	href="javascript:;"
																	onclick="displayCalendar(document.forms[0].joining_mnth,'dd/mm/yyyy', document.forms[0].joining_mnth);">
																		<img alt="" src="resources/images/calendar-icon.gif"
																		height="16" hspace="0" width="16">
																</a> <span class="star">*</span></td>
															</tr>





															<tr>
																<td valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">

																	Starting Month for Regular Contribution</td>
																<td align="left" valign="top" class="cell_bg"><input
																	type="text" class="txt_date"
																	name="startmon_forregular_cont"
																	value="${startmon_forregular_cont}"
																	id="startmon_forregular_cont" maxlength="10"
																	readonly="readonly"> <a href="javascript:;"
																	onclick="displayCalendar(document.forms[0].startmon_forregular_cont,'dd/mm/yyyy', document.forms[0].startmon_forregular_cont);">
																		<img alt="" src="resources/images/calendar-icon.gif"
																		height="16" hspace="0" width="16">
																</a> <span class="star">*</span></td>
															</tr>



															<tr>
																<td width="5%" valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">&nbsp;</td>

																<td align="left" valign="middle" class="cell_bg">
																	Month</td>
																<td align="left" valign="middle" class="cell_bg">Year</td>
															</tr>
															<tr>
																<td width="5%" valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">Period
																	For Which NPS Arrear Is Due</td>

																<td align="left" valign="middle" class="cell_bg"><input
																	type="hidden" value="${mon_contr}" id="mon_contr">
																	<select id="monthListCON" name="mon_contr"
																	style="width: 100pt" class="cmb_small"><option
																			value="-1">[Select Month]</option>
																		<c:forEach var="d" items="${monthListCON}">
																			<option value="${d.monthName}">${d.value}</option>
																		</c:forEach></select> <span class="star">*</span></td>
																<td align="left" valign="middle" class="cell_bg"><input
																	type="hidden" value="${year_contr}" id="year_contr">
																	<select id="yearListCON" name="year_contr"
																	style="width: 100pt" class="cmb_small"><option
																			value="-1">[Select Year]</option>
																		<c:forEach var="d" items="${yearListCON}">
																			<option value="${d.value}">${d.value}</option>
																		</c:forEach></select> <span class="star">*</span></td>
															</tr>

															<tr>

																<td valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">Actual
																	Deducted During</td>
																<td align="left" valign="middle" class="cell_bg"><input
																	type="hidden" value="${actual_ded_mon}"
																	id="actual_ded_mon"> <select id="monthList"
																	name="actual_ded_mon" style="width: 100pt"
																	class="cmb_small">
																		<option value="-1">[Select Month]</option>
																		<c:forEach var="d" items="${monthList}">
																			<option value="${d.monthName}">${d.value}</option>
																		</c:forEach>
																</select> <span class="star"> *</span></td>
																<td align="left" valign="middle" class="cell_bg"><input
																	type="hidden" value="${actual_ded_year}"
																	id="actual_ded_year"> <select id="yearList"
																	name="actual_ded_year" style="width: 100pt"
																	class="cmb_small"><option value="-1">[Select
																			Year]</option>
																		<c:forEach var="d" items="${yearList}">
																			<option value="${d.value}">${d.value}</option>
																		</c:forEach></select> <span class="star">*</span></td>
															</tr>
															<tr>
																<td valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">
																	Contribution Amount</td>
																<td width="25%" align="left" valign="top"
																	class="cell_bg">Employee</td>
																<td width="39%" align="left" valign="top"
																	class="cell_bg">Employer's</td>
																<td valign="top" class="cell_bg">Stop contr.</td>
															</tr>
															<tr>
																<td valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg"></td>
																<td align="left" valign="top" class="cell_bg"><input
																	type="text" name="empContAmt" value="${emp_cont_amt}"
																	onkeypress="return numbersonly(event);"
																	class="txt_date"> <span class="star">*</span></td>
																<td align="left" valign="top" class="cell_bg"><input
																	type="text" name="empContAmt" value="${emp_cont_amt}"
																	onkeypress="return numbersonly(event);"
																	class="txt_date"> <span class="star">*</span></td>
																<td><input type="checkbox" name="stopcontr"></td>
															</tr>
															<tr>
																<td colspan="4" valign="top" class="cell_bg"></td>
															</tr>

															<tr>
																<td>&nbsp;</td>
																<td>&nbsp;</td>
																<td><input type="submit" value="Submit"
																	class="btn_medium"></td>
																<td>&nbsp;</td>
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
					<table width="100%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td align="center" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td valign="top">
											<table width="80%" border="0" cellspacing="1" cellpadding="1"
												align="center">
												<tr>

													<td valign="top" class="table_bg">
														<div
															style="width: 99%; height: 200px; overflow: auto; padding: 5px;">

															<table cellspacing="0" cellpadding="0" border="0"
																align="CENTER" class="FORM">
																<tr>
																	<td valign="top"><table cellspacing="1"
																			cellpadding="1" border="0" width="100%">


																			<tr>
																				<td id="t"><img alt=""
																					src="resources/images/sort.gif">Contr. Month</td>
																				<td id="t"><img alt=""
																					src="resources/images/sort.gif">Contr. Year</td>
																				<td id="t"><img alt=""
																					src="resources/images/sort.gif">Actual Ded.
																					Month</td>
																				<td id="t"><img alt=""
																					src="resources/images/sort.gif">Actual Ded.
																					Year</td>
																				<td id="t"><img alt=""
																					src="resources/images/sort.gif">Employee
																					Contr.</td>



																			</tr>
																			<c:forEach items="${npsarrearList}" var="list">
																				<tr>

																					<td>${list.monContr}</td>
																					<td>${list.yearContr}</td>
																					<td>${list.actualDedMon}</td>
																					<td>${list.actualDedYear}</td>
																					<td>${list.empContAmt}</td>



																					<td>
																				</tr>
																			</c:forEach>






																		</table></td>
																</tr>
															</table>



														</div>
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

</body>


</body>

</html>

