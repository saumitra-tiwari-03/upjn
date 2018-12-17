<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script language="javascript" src="resources/js/validation.js"></script>
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script src="resources/js/validation.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/js/popcalendar.js"></script>
<script type="text/javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
<script type="text/javascript" src="resources/js/jquery-latest.js"></script>
<script type="text/javascript" src="resources/js/tablesorter.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#myTable").tablesorter();
	});
</script>
</head>
<body>
	<div style="height: 100%; width: 100%;">

		<div
			style="height: 100px; width: 100%; border-bottom: gray solid 4px;">
			<%@ include file="/WEB-INF/view/Header.jsp"%>
		</div>

		<div
			style="height: 700px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div style="height: 100%; width: 79%; float: left; padding-top: 10px;">
			<form action="/UPJN/insertPensionerDetails" method="post"
				id="insertPensionerDetails">
				<table border="0" width="100%">

					<tr>
						<td colspan="6" align="center" class="msg">${msg}</td>
					</tr>
					<tr>
						<td colspan="6" align="center" class="error">${error}</td>
					</tr>

					<tr>
						<td colspan="6" align="left" valign="top" class="table_head">
							Employee Verification for Pre-pension</td>
					</tr>



					<tr>
						<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
						<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>

					</tr>
					<tr>
						<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
						<td align="left" colspan="5" class="bold">Retiring Employee
							List:</td>
					</tr>

					<tr style="display: none">
						<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
						<td width="35%" align="left" valign="top" class="cell_bg">
							Check This Box, If Pension Already Sanctioned ?</td>
						<td align="left" valign="middle" class="cell_bg"></td>
					</tr>

					<tr>
						<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
						<td colspan="3" valign="top" class="cell_bg">&nbsp;</td>
						<td colspan="2" valign="top" class="error_normal">&nbsp;</td>
					</tr>
					<tr>
						<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
						<td align="left" valign="top" class="cell_bg">EmployeeCode</td>
						<td align="left" valign="top" class="cell_bg" style="width: 100px">

							<c:choose>
								<c:when test="${employeeCode==null}">
									<input type="text" name="employeecode" maxlength="25" value=""
										class="txt_medium">
								</c:when>
								<c:otherwise>
									<input type="text" name="employeecode" class="txt_medium"
										value="${employeeCode}">
								</c:otherwise>
							</c:choose>
						</td>
						<td align="left" valign="top" class="cell_bg" width="20px"><input
							type="button" name="none" value="GO"
							onclick="retrievedataofemployee();" class="btn_go"></td>
						<td align="left" valign="top" class="cell_bg">M.I. No.</td>
						<td align="left" valign="top" class="cell_bg" style="width: 90px">
							<input type="text" name="miNo" maxlength="25" value=""
							class="txt_medium">
						</td>
					</tr>
					<tr>
						<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
						<td align="left" valign="top" class="cell_bg">First Name</td>
						<td align="left" valign="top" class="cell_bg" style="width: 100px">
							<c:choose>
								<c:when test="${firstname==null}">
									<input type="text" name="firstname" maxlength="25" value=""
										class="txt_medium">
								</c:when>
								<c:otherwise>
									<input type="text" name="firstname" class="txt_medium"
										value="${firstname}">
								</c:otherwise>
							</c:choose>


						</td>
						<td>&nbsp;</td>
						<td align="left" valign="top" class="cell_bg">Middle Name</td>
						<td align="left" valign="top" class="cell_bg" style="width: 90px">
							<c:choose>
								<c:when test="${middlename==null}">
									<input type="text" name="middlename" maxlength="25" value=""
										class="txt_medium">
								</c:when>
								<c:otherwise>
									<input type="text" name="middlename" class="txt_medium"
										value="${middlename}">
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
						<td align="left" valign="top" class="cell_bg">Last Name</td>
						<td align="left" valign="top" class="cell_bg" style="width: 100px">

							<c:choose>
								<c:when test="${lastname==null}">
									<input type="text" name="lastname" maxlength="25" value=""
										class="txt_medium">
								</c:when>
								<c:otherwise>
									<input type="text" name="lastname" class="txt_medium"
										value="${lastname}">
								</c:otherwise>
							</c:choose>
						</td>


						<td>&nbsp;</td>
						<td align="left" valign="top" class="cell_bg">Father Name</td>
						<td align="left" valign="top" class="cell_bg" style="width: 90px">
							<c:choose>
								<c:when test="${fathername==null}">
									<input type="text" name="fathername" maxlength="25" value=""
										class="txt_medium">
								</c:when>
								<c:otherwise>
									<input type="text" name="fathername" class="txt_medium"
										value="${fathername}">
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
						<td align="left" valign="top" class="cell_bg">Date Of Birth</td>
						<td align="left" valign="top" class="cell_bg"><c:choose>
								<c:when test="${dateofbirth==null}">
									<input type="text" name="dateofbirth" maxlength="25" value=""
										class="txt_date">
								</c:when>
								<c:otherwise>
									<input type="text" name="dateofbirth" class="txt_date"
										value="${dateofbirth}">
								</c:otherwise>
							</c:choose> <a href="javascript:;"
							onclick="displayCalendar(document.forms[0].dateofbirth,'dd/mm/yyyy',document.forms[0].dateofbirth)">

								<img height="16" hspace="0"
								src="resources/images/calendar-icon.gif" width="16" border="0" />
						</a> <span class="star">*</span></td>
						<td>&nbsp;</td>

						<td align="left" valign="top" class="cell_bg">Date Of joining
						</td>
						<td align="left" valign="top" class="cell_bg"><c:choose>
								<c:when test="${dateofjoining==null}">
									<input type="text" name="dateofjoining" maxlength="25" value=""
										class="txt_date">
								</c:when>
								<c:otherwise>
									<input type="text" name="dateofjoining" class="txt_date"
										value="${dateofjoining}">
								</c:otherwise>
							</c:choose> <a href="javascript:;"
							onclick="displayCalendar(document.forms[0].dateofjoining,'dd/mm/yyyy',document.forms[0].dateofjoining)">
								<img height="16" hspace="0"
								src="resources/images/calendar-icon.gif" width="16" border="0" />
						</a> <span class="star">*</span></td>
					</tr>
					<tr>
						<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
						<td align="left" valign="top" class="cell_bg">Date Of
							Retirement</td>
						<td align="left" valign="top" class="cell_bg"><c:choose>
								<c:when test="${dateofretirement==null}">
									<input type="text" name="dateofretirement" maxlength="25"
										value="" class="txt_date">
								</c:when>
								<c:otherwise>
									<input type="text" name="dateofretirement" class="txt_date"
										value="${dateofretirement}">
								</c:otherwise>
							</c:choose> <a href="javascript:;"
							onclick="displayCalendar(document.forms[0].dateofretirement,'dd/mm/yyyy',document.forms[0].dateofretirement)">
								<img height="16" hspace="0"
								src="resources/images/calendar-icon.gif" width="16" border="0" />
						</a> <span class="star">*</span></td>
						<td>&nbsp;</td>
						<td align="left" valign="top" class="cell_bg">IS Employee
							Exist</td>
						<td align="left" valign="middle" class="cell_bg"><select
							name="ISEMPLOYEECODEEXIST" class="cmb_medium">

								<option value="E">Existing In PIS
								<option>
								<option value="NECA">NOT Exist(Code Allocate)
								<option>
								<option value="NECNA">NOT Exist(Code Not Allocate)
								<option>
						</select></td>
					</tr>
					<tr>
						<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
						<td align="left" valign="top" class="cell_bg">Office Level</td>
						<td class="cell_bg" valign="top" align="left"><select id="hm"
							name="mas_OfficeLevelID" class="cmb_medium">
								<option value="-1">[Select Level]</option>
								<c:forEach var="d" items="${officeLevel}">
									<option value="${d.masOfficelevelid}">${d.officelevel}</option>
								</c:forEach>
						</select></td>

						<td>&nbsp;</td>
						<td align="left" valign="top" class="cell_bg">Designation</td>
						<td align="left" valign="middle" class="cell_bg"><c:choose>
								<c:when test="${designation==null}">
									<input type="text" name="designation" value=""
										class="txt_medium">
								</c:when>
								<c:otherwise>
									<input type="text" name="designation" class="txt_medium"
										value="${designation}">
								</c:otherwise>
							</c:choose></td>
					</tr>

					<tr>
						<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
						<td align="left" valign="top" class="cell_bg">District</td>
						<td class="cell_bg" valign="top" align="left"><select
							id="district" name="mas_DistrictID" class="cmb_medium">
								<option value="-1">[Select District]</option>
								<c:forEach var="d" items="${district}">
									<option value="${d.masDistrictid}">${d.districtname}</option>
								</c:forEach>
						</select></td>

						<td>&nbsp;</td>
						<td align="left" valign="top" class="cell_bg">Pensioner Type</td>
						<td align="left" valign="middle" class="cell_bg"><select
							name="pensioner_type" class="cmb_medium">
								<option value="E">Pensioner
								<option>
								<option value="F">Family Pensioner
								<option>
						</select></td>
					</tr>
					<tr>
						<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
						<td class="cell_bg" valign="top" align="left">Office Name</td>
						<td class="cell_bg" valign="top" id="officename" align="left">
							<select id="hmap" name="rmOfficeid" class="cmb_medium">
								<option value="-1">[Select Office Name]</option>
								<c:forEach var="d" items="${officename}">
									<option value="${d.key}">${d.value}</option>
									<!-- alert(d.key) -->
								</c:forEach>
						</select>

						</td>


						<td>&nbsp;</td>
						<td align="left" valign="top" class="cell_bg">Applicant's
							Name</td>
						<td align="left" valign="middle" class="cell_bg"><input
							type="text" name="fp_name" maxlength="25" class="txt_medium">
						</td>
					</tr>
					<tr>
						<td colspan="6" align="center" valign="top" class="cell_bg"><input
							type="submit" class="btn_medium" value="Submit"
							onclick="return validateform()" /> <input type="reset"
							class="btn_medium" value="Reset" /></td>
					</tr>
				</table>
			</form>
			<table width="100%" class="table_bg" cellpadding="3" cellspacing="3"
				border="0" align="center">

				<tr>
					<td>
						<div style="overflow-y: scroll; height: 400px">
							<table width="100%" id="myTable" cellpadding="0" cellspacing="1"
								border="0" class="tablesorter">

								<thead id="h" align="center">
									<tr>
										<td>&nbsp;</td>
										<th id="t" width="20%"><img alt=""
											src="resources/images/sort.gif">Employee Code</th>
										<th id="t" width="20%"><img alt=""
											src="resources/images/sort.gif">Employee Name</th>
										<th id="t" width="20%"><img alt=""
											src="resources/images/sort.gif">Father's Name</th>
										<th id="t" width="20%"><img alt=""
											src="resources/images/sort.gif">Date Of Birth</th>
										<th id="t" width="20%"><img alt=""
											src="resources/images/sort.gif">GPF A/C</th>
										<th id="t" width="20%">Action</th>
									</tr>
								</thead>

								<tbody id="b" align="center">
									<c:forEach items="${employeeList}" var="list">
										<tr>
											<td>&nbsp;</td>
											<td align="center">${list.employeecode}</td>
											<td align="left">${list.firstname}${list.middlename}
												${list.lastname}</td>
											<td align="left">${list.fatherName}</td>
											<td align="center">${list.dateOfBirth}</td>
											<td align="left">${list.gpfAcNo}</td>
											<td><a
												href="/UPJN/selectEmployeeForPensionVerification?employeecode=<c:out value="${list.employeecode}" />">Select</a>
												<%-- <a
												href="/UPJN/editRelieve?ID=<c:out value="${list.employeecode}"/>&ID1=<c:out value="${list.ppTransferdetailid}"/>&ID2=<c:out value="${list.ppNoduesdetailid}"/>"><u>Edit</u></a>
												|| <a
												href="/UPJN/deleteRelieve?ID=<c:out value="${list.ppTransferdetailid}"/>&ID1=<c:out value="${list.ppEmployeemasterid}"/>&ID2=<c:out value="${list.ppNoduesdetailid}"/>"
												onclick="javascript:return confirm('Are you sure to delete ?');"><u>Delete</u></a> --%>

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