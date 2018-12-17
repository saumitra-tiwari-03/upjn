<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>U.P JAL NIGAM-assign office ADMIN</title>
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

<script type="text/javascript">
    	$(document).ready(function() {
    		$("#myTable").tablesorter();
		$("#EmployeeNameID").val($("#ppEmployeemasterid").val());
    	});
</script>

<script type="text/javascript">
function validate() {
	
	var a = document.getElementById("masOfficelevelid").value;
	var b = document.getElementById("rmOfficeid").value;
	var c = document.getElementById("EmployeeNameID").value;
	var d = document.getElementById("password").value;
	var e = document.getElementById("Confirmpassword").value;
	
	if(a == -1 || b == -1 || c == -1 ){
		alert("required values cannot be null");	
		return false;
	}
	if(c == -1){
		alert("required values cannot be null");	
		return false;
	}

	if(d != e){
		alert("Password and confirm password should be same");
		return false;
	}
}
</script>
</head>
<body>
<body style="margin: 0px 0px 0px 0px;">

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
			<form action="/UPJN/executionOfassignOfficeAdmin"
				onsubmit="return validate()">
				<input type="hidden" name="rmRoleid" value="${rmRoleid}"> <input
					type="hidden" name="rmOfficeid" value="${rmOfficeid}">




				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td valign="top" class="msg">${success}</td>
					</tr>
					<tr>
						<td valign="top" class="error">${error}</td>
					</tr>
					<tr>
						<td valign="top"><table width="80%" align="center"
								cellpadding="0" cellspacing="0" border="0">
								<tr>
									<td valign="top"><table width="100%" align="center"
											cellpadding="0" cellspacing="1" border="0" class="table_bg">
											<tr>
												<td valign="top"><table width="100%" align="center"
														class="cell_bg" cellpadding="3" cellspacing="1" border="0">
														<tr>
															<td align="left" valign="top" class="table_head"
																colspan="4">Role Management - Assign Office Admin</td>
														</tr>
														<tr>
															<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
															<td colspan="1" valign="middle" class="error_normal"
																align="right">* Fields are required.</td>
														</tr>


														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">Office
																Level</td>

															<td align="left" valign="top" class="cell_bg" colspan="3"><c:choose>
																	<c:when test="${officelevel==null}">
																		<select id="masOfficelevelid" name="masOfficelevelid"
																			class="cmb_medium">
																			<option value="-1">[Select Level]</option>
																			<c:forEach var="l" items="${officelevelMap}">
																				<option value="${l.key}">${l.value}</option>
																			</c:forEach>
																		</select>
																		<span class="star">*</span>
																	</c:when>
																	<c:otherwise>
																					
							                                                         ${officelevel}
																				</c:otherwise>
																</c:choose></td>
														</tr>


														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">
																Office Name</td>
															<td class="cell_bg" valign="top" align="left"><c:choose>
																	<c:when test="${officename==null}">
																		<select id="rmOfficeid" name="officeNameID"
																			class="cmb_medium">
																			<option value="-1">[Select Office Name]</option>
																			<c:forEach var="d" items="${Data}">
																				<option value="${d.key}">${d.value}</option>
																			</c:forEach>
																		</select>
																		<span class="star">*</span>
																	</c:when>
																	<c:otherwise>
												
							                     ${officename}
												
												</c:otherwise>
																</c:choose></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">
																Employee Name</td>
															<td class="cell_bg" valign="top" align="left"
																id="EmpnameList"><c:if
																	test="${EmpnameList == null}">
																	<select id="EmployeeNameID" name="ppEmployeemasterid"
																		class="cmb_medium">
																		<option value="-1">[Select Employee Name]</option>
																		<c:forEach var="d" items="${EmpnameList}">
																			<option value="${d.key}">${d.value}</option>
																		</c:forEach>
																	</select>
																</c:if> <c:if test="${EmpnameList != null}">
																	<c:forEach var="d" items="${assignInfoPerticular}">
																		<input type="hidden" id="ppEmployeemasterid"
																			value="${d.ppEmployeemasterid}">
																	</c:forEach>
																	<select id="EmployeeNameID" name="ppEmployeemasterid"
																		class="cmb_medium">
																		<option value="-1">[Select Employee Name]</option>
																		<c:forEach var="d" items="${EmpnameList}">
																			<option value="${d.key}">${d.value}</option>
																		</c:forEach>
																	</select>
																</c:if> <span class="star">*</span></td>
														</tr>
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">
																Password</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="password" name="password" maxlength="15"
																id="password" required class="txt_medium"> <span
																class="star">*</span></td>
														</tr>
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">
																Confirm Password</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="password" name="Confirmpassword" maxlength="15"
																required id="Confirmpassword" class="txt_medium">
																<span class="star">*</span></td>
														</tr>
														<tr>
															<td colspan="5" align="center" valign="top"
																class="cell_bg"><input type="submit" name="btn12"
																value="Submit" class="btn_medium"> &nbsp; <input
																type="reset" name="reset" value="Reset"
																class="btn_medium"></td>
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
				<br>

				<script type="text/javascript" src="resources/js/tablesorter.js"></script>

				<!--  -->

				<table width="90%" class="table_bg" cellpadding="3" cellspacing="3"
					border="0" align="center">
					<tr>
						<td>
							<div style="overflow-y: scroll; height: 400px">
								<table width="100%" id="myTable" cellpadding="0" cellspacing="1"
									border="0" class="tablesorter">

									<thead id="h" align="center" >
										<tr>
											<th id="t" width="20%"><img alt=""
												src="resources/images/sort.gif">Office Name</th>
											<th id="t" width="10%"><img alt=""
												src="resources/images/sort.gif">Employee Code</th>
											<th id="t" width="20%"><img alt=""
												src="resources/images/sort.gif">Employee Name</th>
											<th id="t" width="20%"><img alt=""
												src="resources/images/sort.gif">Employee Designation</th>
											<th id="t" width="20%">Action</th>
										</tr>
									</thead>

									<tbody id="b" align="center">
										<c:forEach items="${employeeInfoList}" var="list">
											<tr>

												<td>${list.officename}</td>
												<td>${list.employeecode}</td>
												<td>${list.employeename}</td>
												<td>${list.designation}</td>



												
												<td><a
													href="/UPJN/EditAssignOfficeRecord?employeecode=<c:out value="${list.employeecode}"/>"><u>Re-Assign</u></a> ||
												<a
													href="/UPJN/ChangeRightsOfficeRecord?rmOfficeid=<c:out value="${list.rmOfficeid}"/>"><u>Change-Rights</u></a></td>



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
