<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>U.P JAL NIGAM-New Appointment</title>
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<script type="text/javascript">
	$(document).ready(sortDropDownListByText);
</script>
<script src="./resources/js/jquery-1.11.1.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$('#designation').change(function(event) {
			var designationid = $("select#designation").val();

			$.get('/UPJN/getDesignationcombocategorylist', {
				designationid : designationid,

			}, function(jsonResponse) {
				var select = $('#employeementcategory');
				select.find('option').remove();
				/* $('<option>').val("-1").text("[Select]").appendTo(select); */
				$.each(jsonResponse, function(index, value) {
					$('<option>').val(index).text(value).appendTo(select);
				});
			});
		});
	});
	$(document).ready(function() {

		$('#emp_type').change(function(event) {

			var tempVal = $("select#emp_type").val();
			$.get('/UPJN/getDesignationcombolist', {
				employementtype : tempVal
			//ofname:ofid
			}, function(jsonResponse) {
				var select = $('#designation');
				select.find('option').remove();
				$('<option>').val("-1").text("[select]").appendTo(select);
				$.each(jsonResponse, function(index, value) {

					$('<option>').val(index).text(value).appendTo(select);
				});
			});

		});
	});

	$(document).ready(function() {

		$('#hmap1').change(function(event) {

			var tempVal = $("select#hmap1").val();
			$.get('/UPJN/getDesignationcombolist', {
				employementtype : tempVal
			//ofname:ofid
			}, function(jsonResponse) {
				var select = $('#designation');
				select.find('option').remove();
				$('<option>').val("-1").text("[Select Designation]").appendTo(select);
				$.each(jsonResponse, function(index, value) {

					$('<option>').val(index).text(value).appendTo(select);
				});
			});

		});
	});
</script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script src="resources/js/validation.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/js/popcalendar.js"></script>
<script type="text/javascript" src="resources/js/New_Appointment_validation.js"></script>
<script type="text/javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>


<script type="text/javascript">
	$(document).ready(function() {

		$("#hmap").val($("#ModeofApp").val());
		$("#hmap1").val($("#emptypeid").val());

	});
</script>

</head>

<body style="margin: 0px 0px 0px 0px;" onload="return dateformat()">

	<script type="text/javascript">
		
	<%String str = (String) request.getAttribute("str");
			if (str == null) {%>
		function callAction() {
			document.getElementById("New_Appointment").action = "/UPJN/getcombolist";
			document.getElementById("New_Appointment").method = "post";
			document.getElementById("New_Appointment").submit();
		}
	<%}%>
		
	</script>

	<div style="height: 100%; width: 100%;">

		<div
			style="height: 100px; width: 100%; border-bottom: gray solid 4px;">
			<%@ include file="/WEB-INF/view/Header.jsp"%>
		</div>

		<div
			style="height: 700px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px; overflow-x: auto;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div
			style="height: 100%; width: 79%; float: left; padding-top: 4px; overflow-x: auto;" align="center">

			<c:choose>
				<c:when test="${flag==1}">
					<form action="/UPJN/editAppointment" id="New_Appointment"
						onsubmit="return validate_edit_details();">
				</c:when>
				<c:otherwise>
					<form id="New_Appointment" action="/UPJN/save.html" method="post"
						onsubmit="return validate_details();">
				</c:otherwise>
			</c:choose>


			<table style="border: 0px; width: 100%;">

				<tr>
					<td align="left" valign="top" class="msg">${app_msg}</td>
				</tr>

				<tr>
					<c:set var="currentdate" value="<%=new java.util.Date()%>" />
					<td><input type="hidden" name="currentdate" id="currentdate"
						value="<fmt:formatDate pattern="dd/MM/yyyy" value="${currentdate}" />">
					</td>
				</tr>

				<tr>
					<td><c:forEach items="${lis}" var="a">
							<input type="hidden" value="${a.ppEmployeedetailid}"
								name="ppEmployeedetailid">
						</c:forEach> <c:forEach items="${lis1}" var="a">
							<input type="hidden" value="${a.ppEmployeepaydetailid}"
								name="ppEmployeepaydetailid">
						</c:forEach> <c:forEach items="${list1}" var="a">
							<input type="hidden" value="${a.ppEmployeepersonaldetailid}"
								name="ppEmployeepersonaldetailid">
						</c:forEach> <c:forEach items="${list2}" var="a">
							<input type="hidden" value="${a.ppEmployeeappointmentdetailid}"
								name="ppEmployeeappointmentdetailid">
						</c:forEach></td>
				</tr>

				<tr>
					<td valign="top"><table style="width: 90%; border: 0px; ">
							<tr>
								<td align="center" valign="top"><table
										style="width: 100%; border: 0px;">
										<tr>
											<td valign="top"><table
													style="width: 100%; border: 0px;">
													<tr>
														<td valign="top" class="table_bg"><table
																style="width: 100%; border: 0px;">
																<tr>


																	<td width="95%" align="left" valign="top"
																		class="table_head">Initial Appointment - Add
																		Appointment Details</td>

																</tr>
															</table>
															<table style="width: 100%; border: 0px;">
																<tr>
																	<td colspan="3" valign="top" class="cell_bg">&nbsp;</td>
																	<td colspan="2" valign="top" class="error_normal">
																		* Fields are required.</td>
																</tr>
																<tr>
																	<td align="left" colspan="3" class="bold">Personal
																		Details</td>
																</tr>
																<tr>
																	<td align="left" colspan="3" class="bold"></td>
																</tr>


																<tr>
																	<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																	<td width="43%" align="left" valign="top"
																		class="cell_bg">Employee Code</td>

																	<td align="left" valign="top" class="cell_bg"
																		colspan="3"><c:choose>
																			<c:when test="${list==null}">
																				<input type="text" class="txt_medium" required
																					maxlength="6" name="employeecode" id="employeecode"
																					onkeypress="return onlynumbers()">
																				<span class="star">*[Max 6 char.]</span>
																				<!-- <input type="button" value="Check Availability" 
																					onclick="return checkemployeecode()"> -->

																			</c:when>
																			<c:otherwise>
																				<c:forEach items="${list}" var="a">
																					<input type="text" class="txt_medium" maxlength="6"
																						name="employeecode" id="employeecode"
																						value="${a.employeecode}"
																						onkeypress="return onlynumbers()" required>
																					<input type="hidden" name="ppEmployeemasterid"
																						value="${a.ppEmployeemasterid}">
																				</c:forEach>
																			</c:otherwise>
																		</c:choose></td>
																</tr>

																<!-- Row for First name -->
																<tr>
																	<td valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">First
																		Name</td>
																	<td align="left" valign="top" class="cell_bg"
																		colspan="3"><c:choose>
																			<c:when test="${list==null}">
																				<input type="text" class="txt_medium"
																					name="firstname" id="firstname" required
																					maxlength="40">

																				<span class="star">*[Max 40 char.]</span>
																			</c:when>
																			<c:otherwise>
																				<c:forEach items="${list}" var="a">
																					<input type="text" class="txt_medium"
																						maxlength="40" name="firstname" id="firstname"
																						value="${a.firstname}" maxlength="40" required>
																				</c:forEach>
																			</c:otherwise>
																		</c:choose></td>
																</tr>

																<!-- Row for Middle name -->
																<tr>
																	<td valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">Middle
																		Name</td>

																	<td align="left" valign="top" class="cell_bg"
																		colspan="3"><c:choose>
																			<c:when test="${list==null}">
																				<input type="text" class="txt_medium"
																					id="middlename" maxlength="40" name="middlename">
																			</c:when>
																			<c:otherwise>
																				<c:forEach items="${list}" var="a">
																					<input type="text" class="txt_medium"
																						id="middlename" maxlength="40" name="middlename"
																						value="${a.middlename}">

																				</c:forEach>
																			</c:otherwise>
																		</c:choose></td>
																</tr>

																<!-- Row for Last name -->
																<tr>
																	<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">Last
																		Name</td>

																	<td align="left" valign="middle" class="cell_bg"
																		colspan="3"><c:choose>
																			<c:when test="${list==null}">
																				<input type="text" class="txt_medium" id="lastname"
																					maxlength="40" name="lastname">
																			</c:when>
																			<c:otherwise>
																				<c:forEach items="${list}" var="a">
																					<input type="text" class="txt_medium" id="lastname"
																						maxlength="40" name="lastname"
																						value="${a.lastname}">

																				</c:forEach>
																			</c:otherwise>
																		</c:choose></td>
																</tr>


																<!-- Row for Sex-Code name -->
																<tr>
																	<td valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">
																		Sex-Code</td>
																	<td align="left" valign="top" class="cell_bg"><c:choose>
																			<c:when test="${list1==null}">
																				<input type="radio" name="sexcode" value="m">Male 
																<input type="radio" name="sexcode" value="f">Female 
																<span class="star">*</span>
																			</c:when>
																			<c:otherwise>

																				<c:forEach items="${list1}" var="a">
																					<c:set var="sex" value="${a.sexcode}" />
																				</c:forEach>

																				<c:if test="${fn:contains(sex,'m')}">
																					<input type="radio" name="sexcode" value="m"
																						checked="checked">Male 
																<input type="radio" name="sexcode" value="f">Female
																	</c:if>
																				<c:if test="${fn:contains(sex,'f')}">
																					<input type="radio" name="sexcode" value="m">Male 
															          	<input type="radio" name="sexcode" value="f"
																						checked="checked">Female
																	</c:if>

																			</c:otherwise>
																		</c:choose></td>
																</tr>

																<!-- Row for Date of birth -->
																<tr>
																	<td valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">Date
																		of Birth (dd/mm/yyyy)</td>

																	<td align="left" valign="top" class="cell_bg"><c:choose>
																			<c:when test="${list1==null}">
																				<input type="text" class="txt_date"
																					name="dateofbirth" id="dateofbirth" required>

																				<a href="javascript:;"
																					onclick="displayCalendar(document.forms[0].dateofbirth,'dd/mm/yyyy',document.forms[0].dateofbirth)">

																					<img height="16" hspace="0"
																					src="resources/images/calendar-icon.gif" width="16"
																					border="0" />
																				</a>
																				<span class="star">*</span>
																			</c:when>
																			<c:otherwise>
																				<c:forEach items="${list1}" var="a">
																					<input type="text" class="txt_date"
																						name="dateofbirth" id="dateofbirth"
																						value='<fmt:formatDate value="${a.dateofbirth}" pattern="dd/MM/yyyy"/>'
																						<%-- value="${a.dateofbirth}" --%>
																							required>

																					<a href="javascript:;"
																						onclick="displayCalendar(document.forms[0].dateofbirth,'dd/mm/yyyy',document.forms[0].dateofbirth)">

																						<img height="16" hspace="0"
																						src="resources/images/calendar-icon.gif"
																						width="16" border="0" />
																					</a>
																					<span class="star">*</span>
																				</c:forEach>
																			</c:otherwise>
																		</c:choose></td>
																</tr>

																<!-- Father name -->
																<tr>
																	<td valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">
																		Father's Name</td>
																	<td align="left" valign="top" class="cell_bg"
																		colspan="3"><c:choose>
																			<c:when test="${list1==null}">
																				<input type="text" class="txt_medium"
																					id="fathername" name="fathername" maxlength="30"
																					required>
																				<span class="star">*[Max 30 char.]</span>
																			</c:when>
																			<c:otherwise>
																				<c:forEach items="${list1}" var="a">
																					<input type="text" class="txt_medium"
																						id="fathername" onchange="return onlycharacters()"
																						name="fathername" maxlength="30"
																						value="${a.fathername}" required>
																					<span class="star">*[Max 30 char.]</span>
																				</c:forEach>
																			</c:otherwise>
																		</c:choose></td>
																</tr>


																<tr>
																	<td align="left" colspan="3" class="bold"></td>
																</tr>
																<tr>
																	<td align="left" colspan="3" class="bold">
																		Appointment Details</td>
																</tr>
																<tr>
																	<td align="left" colspan="3" class="bold"></td>
																</tr>

																<!-- Appointment letter no -->
																<tr>
																	<td valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">
																		Appointment Letter No.</td>
																	<td align="left" valign="top" class="cell_bg"
																		colspan="3"><c:choose>
																			<c:when test="${list2==null}">
																				<input type="text" class="txt_medium"
																					name="appointmentfileno" maxlength="50" required>

																				<span class="star">*[Max 50 char.]</span>
																			</c:when>
																			<c:otherwise>
																				<c:forEach items="${list2}" var="a">
																					<input type="text" class="txt_medium"
																						name="appointmentfileno" maxlength="50"
																						value="${a.appointmentfileno}" required>

																					<span class="star">*[Max 50 char.]</span>
																				</c:forEach>
																			</c:otherwise>
																		</c:choose></td>
																</tr>
																<tr>
																	<td valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">
																		Appointment Letter Date (dd/mm/yyyy)</td>
																	<td align="left" valign="top" class="cell_bg"><c:choose>
																			<c:when test="${list2==null}">
																				<input type="text" name="appointmentfiledate"
																					id="appointmentfiledate" class="txt_date" required />

																				<a href="javascript:;"
																					onclick="displayCalendar(document.forms[0].appointmentfiledate,'dd/mm/yyyy', document.forms[0].appointmentfiledate);">
																					<img height="16" hspace="0"
																					src="resources/images/calendar-icon.gif" width="16"
																					border="0" />
																				</a>
																				<span class="star">*</span>
																			</c:when>
																			<c:otherwise>
																				<c:forEach items="${list2}" var="a">
																					<input type="text" name="appointmentfiledate"
																						id="appointmentfiledate" class="txt_date"
																						value='<fmt:formatDate value="${a.appointmentfiledate}" pattern="dd/MM/yyyy" />'
																						<%-- value="${a.appointmentfiledate}" --%>
																							required />

																					<a href="javascript:;"
																						onclick="displayCalendar(document.forms[0].appointmentfiledate,'dd/mm/yyyy', document.forms[0].appointmentfiledate);">
																						<img height="16" hspace="0"
																						src="resources/images/calendar-icon.gif"
																						width="16" border="0" />
																					</a>
																					<span class="star">*</span>
																				</c:forEach>
																			</c:otherwise>
																		</c:choose></td>
																</tr>

																<!--  Appointment Authority-->
																<tr>
																	<td valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">
																		Appointment Authority</td>
																	<td align="left" valign="top" class="cell_bg"
																		colspan="3"><c:choose>
																			<c:when test="${list2==null}">
																				<input type="text" name="appointmentauthority"
																					class="txt_medium" maxlength="50" required />

																				<span class="star">*[Max 50 char.]</span>
																			</c:when>
																			<c:otherwise>
																				<c:forEach items="${list2}" var="a">
																					<input type="text" name="appointmentauthority"
																						class="txt_medium" maxlength="50" required
																						value="${a.appointmentauthority}" />

																				</c:forEach>
																			</c:otherwise>
																		</c:choose></td>
																</tr>


																<!-- Date of joining -->

																<tr>
																	<td valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">Date
																		of Joining (dd/mm/yyyy)</td>
																	<td align="left" valign="top" class="cell_bg"><c:choose>
																			<c:when test="${list2==null}">
																				<input type="text" name="datejoining" required
																					id="datejoining" class="txt_date" />
																				<a href="javascript:;"
																					onclick="displayCalendar(document.forms[0].datejoining,'dd/mm/yyyy', document.forms[0].datejoining);">
																					<img height="16" hspace="0"
																					src="resources/images/calendar-icon.gif" width="16"
																					border="0" />
																				</a>
																				<span class="star">*</span>
																			</c:when>

																			<c:otherwise>
																				<c:forEach items="${list2}" var="a">
																					<input type="text" name="datejoining" required
																						class="txt_date"
																						value='<fmt:formatDate value="${a.datejoining}" pattern="dd/MM/yyyy"/>'
																						id="datejoining" />
																					<a href="javascript:;"
																						onclick="displayCalendar(document.forms[0].datejoining,'dd/mm/yyyy', document.forms[0].datejoining);">
																						<img height="16" hspace="0"
																						src="resources/images/calendar-icon.gif"
																						width="16" border="0" />
																					</a>
																					<span class="star">*</span>
																				</c:forEach>
																			</c:otherwise>
																		</c:choose></td>
																</tr>

																<!-- Effective date of appointment -->
																<tr>
																	<td valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">
																		Effective Date Of Appointment/Regularization
																		(dd/mm/yyyy)</td>
																	<td align="left" valign="top" class="cell_bg"><c:choose>
																			<c:when test="${list2==null}">
																				<input type="text" name="effectivedatjoin" required
																					id="effectivedatjoin" class="txt_date" />
																				<a href="javascript:;"
																					onclick="displayCalendar(document.forms[0].effectivedatjoin,'dd/mm/yyyy', document.forms[0].effectivedatjoin);">
																					<img height="16" hspace="0"
																					src="resources/images/calendar-icon.gif" width="16"
																					border="0" />
																				</a>
																				<span class="star">*</span>
																			</c:when>
																			<c:otherwise>
																				<c:forEach items="${list2}" var="a">
																					<input type="text" name="effectivedatjoin"
																						id="effectivedatjoin" class="txt_date" required
																						value="${a.effectivedatjoin}" />
																					<a href="javascript:;"
																						onclick="displayCalendar(document.forms[0].effectivedatjoin,'dd/mm/yyyy', document.forms[0].effectivedatjoin);">
																						<img height="16" hspace="0"
																						src="resources/images/calendar-icon.gif"
																						width="16" border="0" />
																					</a>
																					<span class="star">*</span>
																				</c:forEach>
																			</c:otherwise>
																		</c:choose></td>
																</tr>

																<!-- Mode of Appointment  -->
																<tr>
																	<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">Mode
																		of Appointment</td>
																	<td align="left" valign="middle" class="cell_bg">

																		<c:if test="${list2 == null}">
																			<select required id="new_modeofapp" name="sysSubservicephasemasterid"
																				class="cmb_medium">
																				<option value="-1">[Select Mode]</option>
																				<c:forEach var="d" items="${Data}">
																					<option value="${d.key}">${d.value}</option>
																				</c:forEach>
																			</select>
																			<span class="star">*</span>
																		</c:if> <c:if test="${list2 != null}">
																			<c:forEach items="${list2}" var="a">

																				<input type="hidden"
																					value="${a.sysSubservicephasemasterid}"
																					name="MOdeofApp" id="ModeofApp">
																			</c:forEach>

																			<select required id="hmap"
																				name="sysSubservicephasemasterid" class="cmb_medium">

																				<option value="-1">[Select Mode]</option>

																				<c:forEach var="d" items="${Data}">
																					<option value="${d.key}">${d.value}</option>
																				</c:forEach>
																			</select>
																			<span class="star">*</span>
																		</c:if>

																	</td>
																</tr>

																<!-- Employment type -->
																<tr>
																	<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">
																		Employment Type</td>
																	<td align="left" valign="middle" class="cell_bg">
																		<c:choose>
																			<c:when test="${list3==null}">
																				<select required name="employmenttype" id="emp_type"
																					class="cmb_medium">
																					<option value="-1">[Select Type]</option>
																					<c:forEach var="d" items="${Data1}">
																						<option value="${d.key}">${d.value}</option>
																					</c:forEach>
																				</select>
																			</c:when>
																			<c:otherwise>

																				<c:forEach items="${employment_type_id}" var="a">
																					<input type="hidden"
																						value="${a.masEmploymenttypeid}" id="emptypeid"
																						name="emptypeid">
																				</c:forEach>
																				<select id="hmap1" name="employmenttype"
																					class="cmb_medium">

																					<%-- <c:forEach items="${list3}" var="a">
																						<option value="">${a.employmenttype}</option>
																					</c:forEach> --%>
																					<option value="-1">[Select Type]</option>
																					<c:forEach var="d" items="${Data1}">
																						<option value="${d.key}">${d.value}</option>
																					</c:forEach>
																				</select>
																			</c:otherwise>
																		</c:choose> <span class="star">*</span>
																	</td>
																</tr>

																<!--(Designation) Appearance of this combo depends upon above combo -->

																<tr>
																	<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">
																		Designation (At The Time Of Appointment)</td>
																	<td align="left" valign="middle" class="cell_bg">

																		<c:choose>
																			<c:when test="${list3==null}">
																				<select id="designation" required
																					name="ppDesignationmasterid" class="cmb_medium">

																					<option value="-1">[Select Designation]</option>
																					<c:forEach var="d" items="${designation}">
																						<option value="${d.key}">${d.value}</option>
																					</c:forEach>
																				</select>
																			</c:when>
																			<c:otherwise>
																				<select id="designation"
																					name="ppDesignationmasterid" class="cmb_medium">

																					<c:forEach items="${list3}" var="a">
																						<option value="">${a.designation}</option>
																					</c:forEach>

																					<c:forEach var="d" items="${designation}">
																						<option value="${d.key}">${d.value}</option>
																					</c:forEach>
																				</select>
																			</c:otherwise>
																		</c:choose> <span class="star">*</span>
																	</td>
																</tr>

																<!--  Employment category. This combo depends on designation-->

																<tr>
																	<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">
																		Employment Category</td>
																	<td align="left" valign="middle" class="cell_bg">

																		<c:choose>
																			<c:when test="${list3==null}">
																				<select id="employeementcategory" required
																					name="masEmploymentsubtypeid" class="cmb_medium">
																					<option>[Select Category]</option>
																					<c:forEach var="d" items="${employeementcategory}">
																						<option value="${d.key}">${d.value}</option>
																					</c:forEach>
																				</select>
																			</c:when>
																			<c:otherwise>
																				<select id="employeementcategory"
																					name="masEmploymentsubtypeid" class="cmb_medium">
																					<c:forEach items="${list3}" var="a">
																						<option value="">${a.employmentsubtype}</option>
																					</c:forEach>
																					<c:forEach var="d" items="${employeementcategory}">
																						<option value="${d.key}">${d.value}</option>
																					</c:forEach>
																				</select>
																			</c:otherwise>
																		</c:choose>
																	</td>
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
															</table>
												</table>
									</table></td>
							</tr>
						</table></td>
				</tr>
				<tr>
					<td height="30" valign="top">&nbsp;</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
</body>
</html>