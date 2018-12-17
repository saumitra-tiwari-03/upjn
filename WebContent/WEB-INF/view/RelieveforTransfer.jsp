<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM-Relieve For Transfer</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script language="javascript" src="resources/js/validation.js"></script>
<script language="javascript" src="resources/js/popcalendar.js"></script>
<script language="javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<script src="<c:url value="/resources/js/upjn.js" />"></script>
<script type="text/javascript" src="resources/js/jquery-latest.js"></script>
<script type="text/javascript" src="resources/js/tablesorter.js"></script>

<script type="text/javascript">
	$(document).ready(sortDropDownListByText);
</script>
<script type="text/javascript">
	function MM_openBrWindow(theURL, winName, features) { //v2.0
		window.open(theURL, winName, features);
	}

	function validatedate() {

		var w = document.getElementById("noduesorddate").value;
		var x = document.getElementById("transferorderdate").value;
		var y = document.getElementById("relievedate").value;

	}
</script>
<script type="text/javascript">

	$(document).ready(function(){
		$("#myTable").tablesorter();
		$("#hm_edit").val($("#officelevelID").val());
		$("#district_edit").val($("#masDistrictid").val());
		$("#hmap_edit").val($("#officetoid").val());
		}
	);
	
	</script>

<script type="text/javascript">
	function validateform() {
		var employeecode = document.getElementById("employee").value;
		 if (employeecode == "") {
				alert("Please fill Employee Code");
				return false;
			}

		var rel_order_no = document.getElementById("transferorderno").value;
		if (rel_order_no == "") {
			alert("Please fill Relieving Order No.");
			return false;
		}

		var rel_order_date = document.getElementById("transferorderdate").value;
		if (rel_order_date == "") {
			alert("Please fill Relieving Order Date");
			return false;
		}

		var relieveanfn = document.getElementById("relieveanfn").value;
		if (relieveanfn == -1) {
			alert("Please Select Time");
			return false;
		}

		var rel_date = document.getElementById("relievedate").value;
		if (rel_date == "") {
			alert("Please fill Relieving Date");
			return false;
		}
		
		var office_level = document.getElementById("hm").value;
		if (office_level == -1) {
			alert("Please Select Office Level");
			return false;
		}

		var office_level = document.getElementById("hm").value;
		if (office_level == "") {
			alert("Please Select Office Level");
			return false;
		}

		var district = document.getElementById("district").value;
		if (district == -1) {
			alert("Please Select District");
			return false;
		}
		var office_name = document.getElementById("hmap").value;
		if (office_name == -1) {
			alert("Please Select Office Name");
			return false;
		}
		
	}
</script>
<script type="text/javascript">
	function populateRelieveDetails() {

		document.getElementById("populateRelieveDetails").action = "/UPJN/populateRelieveDetails";
		document.getElementById("populateRelieveDetails").Method = "POST";
		document.getElementById("populateRelieveDetails").submit();
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
			style="height: 1100px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div style="height: 100%; width: 79%; float: left; padding-top: 10px;">
			<!--   <form action="/transferEmployee" method="post"> -->
			<c:choose>
				<c:when test="${list1size==0}">
					<form action="/UPJN/EmployeeRelieved" id="populateRelieveDetails"
						method="post">
				</c:when>
				<c:otherwise>
					<form action="/UPJN/EditRelievedEmployee"
						id="populateRelieveDetails" method="post">
				</c:otherwise>
			</c:choose>
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td valign="top" class="msg">${msg}</td>
				</tr>
				<tr>
					<td valign="top"><table width="80%" align="center"
							cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td valign="top"><table width="100%" align="center"
										cellpadding="0" cellspacing="1" border="0" class="table_bg">
										<tr>
											<td valign="top"><table width="100%" align="center"
													class="cell_bg" cellpadding="3" cellspacing="3" border="0">

													<!-- Hidden values -->

													<tr>
														<td align="left" valign="top" class="table_head"
															colspan="4">Transfer Employee-Add Relieving Detail</td>
													</tr>
													<tr>
														<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
														<td colspan="1" valign="middle" class="error_normal"
															align="right">* Fields are required.</td>
													</tr>

													<tr>
														<!-- <td  valign="top" class="cell_bg" >&nbsp;</td> -->
														<td align="center" valign="top" class="cell_bg">
															Employee Code</td>
														<td align="left" valign="middle" class="cell_bg"><c:choose>

																<c:when test="${empcode==null}">
																	<input type="text" class="txt_small" name="employee"
																		id="employee" size="30" maxlength="8" required>
																</c:when>

																<c:otherwise>
																	<c:forEach items="${empcode}">
																		<input type="text" class="txt_small" name="employee"
																			id="employee" size="30" maxlength="8"
																			value="${empcode}">
																		<c:forEach items="${ppNoduesdetail}" var="a">
																			<input type="hidden" name="ppNoduesdetailid"
																				value="${a.ppNoduesdetailid}">
																		</c:forEach>
																		<input type="hidden" name="ppEmployeemasterid"
																			value="${ppEmployeemasterid}">
																		<input type="hidden" name="officefromid"
																			value="${officefromid}">
																	</c:forEach>
																</c:otherwise>

															</c:choose> <input type="submit" class="btn_go" name="method"
															value="GO" onclick="populateRelieveDetails()"> <span
															class="star">*</span> &nbsp; <a
															href="/UPJN/SearchEmployeeforRelieve" class="bold"> <u>Select
																	Employee</u></a></td>
													</tr>

													<c:choose>
														<c:when
															test="${nameofemployee==null&&designationofemployee==null&&noduesordno==null&&noduesorddate==null}">
														</c:when>

														<c:otherwise>
															<tr>

																<td align="center" valign="top" class="cell_bg">
																	Employee Name</td>
																<td align="left" valign="top" class="cell_bg">
																		<input type="text" name="employeename"
																			class="txt_noborder" size="30" maxlength="100"
																			readonly="readonly" value="${nameofemployee}">
																	</td>
															</tr>
															<tr>

																<td align="center" valign="top" class="cell_bg">
																	Employee Designation</td>
																<td align="left" valign="top" class="cell_bg">
																		<input type="text" name="designation"
																			class="txt_noborder" size="30" maxlength="100"
																			readonly="readonly" value="${designationofemployee}">
																	</td>
															</tr>
															<tr>

																<td align="center" valign="top" class="cell_bg">
																	Transfer Order No.</td>
																<td align="left" valign="top" class="cell_bg"><c:forEach
																		items="${noduesordno}">
																		<input type="text" name="noduesordno"
																			class="txt_noborder" size="30" maxlength="100"
																			readonly="readonly" value="${noduesordno}">
																	</c:forEach></td>
															</tr>
															<tr>
																<td align="center" valign="top" class="cell_bg">
																	Transfer Order date (dd/mm/yyyy)</td>
																<td align="left" valign="top" class="cell_bg"><input
																	type="text" name="noduesorddate" id="noduesorddate"
																	class="txt_noborder" size="30" maxlength="100"
																	readonly="readonly" value="${noduesorddate}"></td>
																<td></td>
															</tr>
														</c:otherwise>
													</c:choose>


													<c:choose>
														<c:when test="${list1size==0}">
															<tr>

																<td align="center" valign="top" class="cell_bg">
																	Relieving Order no.</td>
																<td align="left" valign="top" class="cell_bg"><input
																	type="text" class="txt_medium" name="transferorderno"
																	id="transferorderno" size="11" maxlength="50">
																	<span class="star">*[Max size 50]</span></td>
															</tr>

															<tr>

																<td align="center" valign="top" class="cell_bg">
																	Relieving Order date (dd/mm/yyyy)</td>
																<td align="left" valign="top" class="cell_bg"><input
																	type="text" class="txt_date" name="transferorderdate"
																	id="transferorderdate" readonly="readonly"> <a
																	href="javascript:;"
																	onclick="displayCalendar(document.forms[0].transferorderdate,'dd/mm/yyyy',document.forms[0].transferorderdate)">
																		<img height="16" hspace="0"
																		src="resources/images/calendar-icon.gif" width="16"
																		border="0" />
																</a> <span class="star">*</span></td>
															</tr>

															<!--  -->
															<tr>

																<td width="43%" align="center" valign="top"
																	class="cell_bg">Relieving Time</td>
																<td align="left" valign="top" class="cell_bg"><select
																	required name="relieveanfn" id="relieveanfn"
																	class="cmb_small">
																		<option value="-1">[Select Time]</option>
																		<option value="FN">Fore Noon</option>
																		<option value="AN">After Noon</option>
																</select> <span class="star">*</span></td>
															</tr>
															<tr>
																<!-- <td width="3%" valign="top" class="cell_bg">&nbsp;</td> -->
																<td width="43%" align="center" valign="top"
																	class="cell_bg">Relieving Date (dd/mm/yyyy)</td>
																<td align="left" valign="top" class="cell_bg"><input
																	type="text" class="txt_date" name="relievedate"
																	id="relievedate" required readonly="readonly">
																	<a href="javascript:;"
																	onclick="displayCalendar(document.forms[0].relievedate,'dd/mm/yyyy',document.forms[0].relievedate)">
																		<img height="16" hspace="0"
																		src="resources/images/calendar-icon.gif" width="16"
																		border="0" />
																</a> <span class="star">*</span></td>
															</tr>
														</c:when>


														<c:otherwise>
															<c:forEach items="${list1}" var="a">

																<input type="hidden" name="ppEmployeemasterid"
																	value="${a.ppEmployeemasterid}">
																<input type="hidden" name="ppTransferdetailid"
																	value="${a.ppTransferdetailid}">
																<input type="hidden" name="relieveorderno"
																	value="${a.relieveorderno}">
																<input type="hidden" name="relieveorderdate"
																	value="${a.relieveorderdate}">
																<tr>

																	<td align="center" valign="top" class="cell_bg">
																		Relieving Order no.</td>
																	<td align="left" valign="top" class="cell_bg"><input
																		type="text" class="txt_medium" name="transferorderno"
																		id="transferorderno" size="11" maxlength="50"
																		value="${a.transferorderno}"> <span
																		class="star">*[Max size 50]</span></td>
																</tr>

																<tr>

																	<td align="center" valign="top" class="cell_bg">
																		Relieving Order date (dd/mm/yyyy)</td>
																	<td align="left" valign="top" class="cell_bg"><input
																		<%-- value="${a.transferorderdate}" --%>
																		value='<fmt:formatDate value="${a.transferorderdate}" pattern="dd/MM/yy"/>'
																		type="text" required class="txt_date"
																		name="transferorderdate" id="transferorderdate">
																		<a href="javascript:;"
																		onclick="displayCalendar(document.forms[0].transferorderdate,'dd/mm/yyyy',document.forms[0].transferorderdate)">
																			<img height="16" hspace="0"
																			src="resources/images/calendar-icon.gif" width="16"
																			border="0" />
																	</a> <span class="star">*</span></td>
																</tr>

																<!--  -->
																<tr>

																	<td width="43%" align="center" valign="top"
																		class="cell_bg">Relieving Time</td>
																	<td align="left" valign="top" class="cell_bg"><select
																		required name="relieveanfn" class="cmb_small">

																			<c:choose>
																				<c:when test="${a.relieveanfn==AN}">
																					<option value="AN">After Noon</option>
																					<option value="FN">Fore Noon</option>
																				</c:when>
																				<c:otherwise>
																					<option value="FN">Fore Noon</option>
																					<option value="AN">After Noon</option>
																				</c:otherwise>
																			</c:choose>

																	</select> <span class="star">*</span></td>
																</tr>
																<tr>

																	<td width="43%" align="center" valign="top"
																		class="cell_bg">Relieving Date (dd/mm/yyyy)</td>
																	<td align="left" valign="top" class="cell_bg"><input
																		type="text" class="txt_date" name="relievedate" id=""
																		required
																		value='<fmt:formatDate value="${a.relievedate}" pattern="dd/MM/yy"/>'>
																		<a href="javascript:;"
																		onclick="displayCalendar(document.forms[0].relievedate,'dd/mm/yyyy',document.forms[0].relievedate)">
																			<img height="16" hspace="0"
																			src="resources/images/calendar-icon.gif" width="16"
																			border="0" />
																	</a> <span class="star">*</span></td>
																</tr>
															</c:forEach>
														</c:otherwise>
													</c:choose>

													<tr>
														<td width="43%" class="txt_noborder_bold" valign="top"
															align="center">Select Target Office</td>
													</tr>
													<!--  -->
													<c:forEach items="${list1}" var="a">
														<tr>
															<td><input type="hidden" id="officelevelID"
																value="${a.masOfficelevelid}"> <input
																type="hidden" id="masDistrictid"
																value="${a.masDistrictid}"> <input type="hidden"
																id="officetoid" value="${a.officetoid}"></td>
														</tr>
													</c:forEach>
													<!--  -->
													<tr>
														<td align="center">Office Level</td>
														<td class="cell_bg" valign="top" align="left"><c:choose>
																<c:when test="${list1 == null}">
																	<select id="hm" name="mas_OfficeLevelID"
																		class="cmb_medium">
																		<option value="-1">[Select Level]</option>
																		<c:forEach var="d" items="${Data}">
																			<option value="${d.key}">${d.value}</option>
																		</c:forEach>
																	</select>
																</c:when>
																<c:otherwise>
																	<select id="hm_edit" name="mas_OfficeLevelID"
																		class="cmb_medium">
																		<option value="-1">[Select Level]</option>
																		<c:forEach var="d" items="${Data}">
																			<option value="${d.key}">${d.value}</option>
																		</c:forEach>
																	</select>
																</c:otherwise>
															</c:choose>
													</tr>

													<tr>
														<td align="center">District</td>
														<td align="left" valign="middle" class="cell_bg"><c:choose>
																<c:when test="${list1 == null}">
																	<select id="district" name="mas_DistrictID"
																		class="cmb_medium">
																		<option value="-1">[Select District]</option>
																		<c:forEach var="d" items="${Data1}">
																			<option value="${d.key}">${d.value}</option>
																		</c:forEach>
																	</select>
																</c:when>
																<c:otherwise>
																	<select id="district_edit" name="mas_DistrictID"
																		class="cmb_medium">
																		<option value="-1">[Select District]</option>
																		<c:forEach var="d" items="${Data1}">
																			<option value="${d.key}">${d.value}</option>
																		</c:forEach>
																	</select>
																</c:otherwise>
															</c:choose></td>
													</tr>

													<tr>

														<td valign="top" align="center" width="43%">Office
															Name</td>
														<td class="cell_bg" valign="top" id="officename"
															align="left"><c:choose>
																<c:when test="${list1 == null}">
																	<select id="hmap" name="officetoid" class="cmb_medium">
																		<option value="-1">[Select Office Name]</option>
																		<c:forEach var="d" items="${officename}">
																			<option value="${d.key}">${d.value}</option>
																		</c:forEach>
																	</select>
																</c:when>
																<c:otherwise>
																	<select id="hmap_edit" name="officetoid"
																		class="cmb_medium">
																		<option value="-1">[Select Office Name]</option>
																		<c:forEach var="d" items="${officename}">
																			<option value="${d.key}">${d.value}</option>
																		</c:forEach>
																	</select>
																</c:otherwise>
															</c:choose></td>
													</tr>

													<tr>
														<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
													</tr>

													<tr>
														<td colspan="5" align="center" valign="top"
															class="cell_bg"><input type="submit"
															class="btn_medium" value="Submit"
															onclick="return validateform()" /> <input type="reset"
															class="btn_medium" value="Reset" /></td>
													</tr>
													<tr>
														<td colspan="1" align="right" valign="top" class="cell_bg"></td>
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
						<div style="overflow-y: scroll; height: 400px">
							<table width="100%" id="myTable" cellpadding="0" cellspacing="1"
								border="0" class="tablesorter">

								<thead id="h" align="center">
									<tr>

										<th id="t" width="20%"><img alt=""
											src="resources/images/sort.gif">Employee Name</th>
										<th id="t" width="20%"><img alt=""
											src="resources/images/sort.gif">Employee Designation</th>
										<th id="t" width="20%"><img alt=""
											src="resources/images/sort.gif">Transfer Order No</th>
										<th id="t" width="20%"><img alt=""
											src="resources/images/sort.gif">Transfer Order Date</th>
										<th id="t" width="20%">Action</th>
									</tr>
								</thead>

								<tbody id="b" align="center">
									<c:forEach items="${list}" var="list">
										<tr>

											<td>${list.employeename}</td>
											<td>${list.designation}</td>
											<td>${list.transferorderno}</td>
											<%-- <td>${list.transferorderdate}</td> --%>
											<td><fmt:formatDate value="${list.transferorderdate}"
													pattern="dd/MM/yy" /></td>
											<td><a
												href="/UPJN/editRelieve?ID=<c:out value="${list.employeecode}"/>&ID1=<c:out value="${list.ppTransferdetailid}"/>&ID2=<c:out value="${list.ppNoduesdetailid}"/>"><u>Edit</u></a>
												|| <a
												href="/UPJN/deleteRelieve?ID=<c:out value="${list.ppTransferdetailid}"/>&ID1=<c:out value="${list.ppEmployeemasterid}"/>&ID2=<c:out value="${list.ppNoduesdetailid}"/>"
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

		</div>

	</div>
</body>
</html>