<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>U.P JAL NIGAM-Employee ALW Details</title>
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
<script>
	$(document).ready(function() {
		$("#catPayListID").val($("#paySysCatID").val());
		$("#hraList").val($("#hraID").val());
		$("#ccaList").val($("#ccaID").val());
		$("#sysPayScaleList").val($("#payScaleID").val());
		$("#nextIncrementMonth").val($("#increment_monthID").val());
		if ($("#stopAlwFlagID").val() == 1) {
			$("#stopAlwFlag").prop("checked", true);
		}
	});
</script>
<script type="text/javascript">
	function ShowAlw() {
		
		document.getElementById("empPayDetailForm").action = "/UPJN/ShowAlwforNewUser";
		document.getElementById("empPayDetailForm").method = "post";
		document.getElementById("empPayDetailForm").submit();
	}

	function validatedetails() {
		var a = document.getElementById("defaultIncrementAmount").value;

		if (a == "" || a == null) {
			alert("Please fill the Increment Amount");
			return false;
		}
	}
</script>

<script type="text/javascript">
$(document).ready(function() {


	$('#ccaList').change(function(event) {

	        var ppEmployeemasterID = $("input#ppEmployeemasterID").val(); 
	        var catPayListID = $("select#catPayListID").val(); 
	        
	        $.post('/UPJN/populatePayScale', {
	        	syspayID : catPayListID,
	        	ppEmployeemasterID : ppEmployeemasterID
	        }, function(response) {

	        var select = $('#sysPayScaleList');
	        select.find('option').remove();
	        $('<option>').val('-1').text('[Select PayScale Category]').appendTo(select);
	          $.each(response, function(index, value) {
	        //	 alert(index+'--'+value);
	          $('<option>').val(index).text(value).appendTo(select);
	          
	      });
	          
	        });
	        });
	});
</script>

</head>

<body>
	<script type="text/javascript" language="Javascript1.1">
		
	</script>
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
			<form action="/UPJN/UpdatePay&AlwDetails" name="empPayDetailForm"
				id="empPayDetailForm" method="post">


				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td valign="top" class="msg">${ msg}</td>
					</tr>
					<tr>
						<td valign="top" class="error">${error}</td>
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
													<table width="80%" border="0" cellspacing="1"
														cellpadding="1">
														<tr>
															<td valign="top" class="table_bg">
																<table width="100%" border="0" cellspacing="1"
																	cellpadding="3">
																	<tr>
																		<td width="95%" align="left" valign="top"
																			class="table_head">Update Pay Detail</td>
																		<td align="center" valign="middle" class="table_head">
																			<a href="/UPJN/selectRegister"> <img
																				src="resources/images/cross.jpeg" height="16"
																				width="16" border="0" hspace="0">
																		</a>
																		</td>
																	</tr>
																</table>
															</td>
														</tr>
														<tr>
															<td valign="top" class="table_bg">
																<table width="100%" border="0" cellspacing="1"
																	cellpadding="3">
																	<tr>
																		<td colspan="3">
																			<table width="100%" border="0" cellspacing="1"
																				cellpadding="3">
																				<tr>
																					<td valign="middle" class="tabdefault"
																						bordercolor="#4390E0" bgcolor="#4390E0"
																						width="25%"><a
																						href="/UPJN/populateEmployeePayDetail?ppEmployemasterID=${ppEmployeeMasterID}"><u></u>
																							<strong>General Detail</strong> </a></td>
																					<td valign="middle" class="tabdefault"
																						bgcolor="#FFFFFF" width="25%"><strong>
																							Pay & Allowance Detail </strong></td>
																					<td valign="middle" class="tabdefault"
																						bordercolor="#4390E0" bgcolor="#4390E0"
																						width="25%"><a
																						href="/UPJN/populateEmployeeDeductionDetail?ppEmployemasterID=${ppEmployeeMasterID}&sectionname=${sectionName}&register=${registerName}"><u></u>
																							<strong>Deduction Detail</strong> </a></td>

																					<td valign="middle" class="tabdefault"
																						bordercolor="#4390E0" bgcolor="#4390E0"
																						width="25%"><a
																						href="/UPJN/populateEmployeeLoanDetail?ppEmployemasterID=${ppEmployeeMasterID}&sectionname=${sectionName}&register=${registerName}"><u></u>
																							<strong>Loan Detail</strong> </a></td>
																				</tr>
																			</table>
																		</td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td colspan="2" align="left" valign="top"
																			class="cell_bg">&nbsp;</td>
																	</tr>
																	<c:forEach items="${empList}" var="empList">
																		<tr>
																			<td valign="top" class="cell_bg">&nbsp; <input
																				type="hidden" name="ppEmployeemasterid"
																				value="${empList.ppEmployeemasterid}">
																			</td>
																			<td width="40%" align="left" valign="top"
																				class="cell_bg">Register Name</td>
																			<td width="48%" align="left" valign="top"
																				class="cell_bg"><input type="text"
																				name="registerName" maxlength="25" size="25"
																				readonly="readonly" value="${registerName}"
																				class="txt_noborder"></td>
																		</tr>
																		<tr>
																			<td valign="top" class="cell_bg">&nbsp;</td>
																			<td align="left" valign="top" class="cell_bg">
																				Employee Code</td>
																			<td align="left" valign="middle" class="cell_bg">

																				<input type="text" name="employeeCode"
																				maxlength="25" size="25"
																				value="${empList.employeecode}" readonly="readonly"
																				class="txt_noborder">



																			</td>
																		</tr>

																		<tr>
																			<td valign="top" class="cell_bg">&nbsp;</td>
																			<td align="left" valign="top" class="cell_bg">
																				Employee Name</td>
																			<td align="left" valign="top" class="cell_bg"><input
																				type="text" name="employeeName" maxlength="100"
																				size="25" value="${empList.employeename}"
																				readonly="readonly" class="txt_noborder"> <!-- ppEmployeemasterID -->
																				<input type="hidden" id="ppEmployeemasterID"
																				name="ppEmployeemasterID"
																				value="${empList.ppEmployeemasterid}"
																				class="txt_noborder"> <!--  --></td>
																		</tr>
																		<tr>
																			<td colspan="3" class="cell_bg"></td>
																		</tr>
																		<tr>
																			<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																			<td align="left" valign="top" class="cell_bg">
																				Employee Designation</td>
																			<td align="left" valign="middle" class="cell_bg">
																				<input type="text" name="designation"
																				maxlength="100" size="25"
																				value="${empList.designation}" readonly="readonly"
																				class="txt_noborder">
																			</td>
																		</tr>
																		<tr>
																			<td colspan="3" class="cell_bg"></td>
																		</tr>
																		<tr>
																			<td valign="top" class="cell_bg">&nbsp;</td>
																			<td align="left" valign="top" class="cell_bg">
																				Section Name</td>
																			<td align="left" valign="top" class="cell_bg"><input
																				type="text" name="sectionName" maxlength="100"
																				size="25" readonly="readonly" value="${sectionName}"
																				class="txt_noborder"></td>
																		</tr>
																		<tr>
																			<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																			<td align="left" valign="top" class="cell_bg">
																				Employment Type</td>
																			<td align="left" valign="middle" class="cell_bg">
																				<input type="text" name="employmentType"
																				maxlength="100" size="25"
																				value="${empList.employmenttype}"
																				readonly="readonly" class="txt_noborder"> <input
																				type="hidden" name="mas_EmploymentTypeID" value="1">
																			</td>
																		</tr>
																	</c:forEach>
																	<c:forEach items="${empPayList}" var="l">
																		<tr>

																			<td valign="top" class="cell_bg">&nbsp;</td>
																			<td align="left" valign="top" class="cell_bg">
																				Pay Category</td>
																			<td align="left" valign="middle" class="cell_bg">
																				<select name="sys_PayCategoryID" class="cmb_small"
																				id="catPayListID">
																					<option value="-1">[Select Pay Category]</option>
																					<c:forEach var="d" items="${payCatList}">
																						<option value="${d.sysPaycategoryid}">${d.paycategory}</option>
																					</c:forEach>
																			</select><span class="star">*</span> <input type="hidden"
																				value="${l.sysPaycategoryid}" id="paySysCatID" />
																			</td>
																			<td><input type="button" align="left"
																				value="Show Allowances" class="btn_medium"
																				onclick="return ShowAlw()"></td>


																		</tr>
																		<!----------  ---------------->
																		<tr>
																			<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																			<td align="left" valign="top" class="cell_bg">
																				Town Category For HRA</td>
																			<td align="left" valign="middle" class="cell_bg">
																				<select name="hraTownCategoryID" id="hraList"
																				class="cmb_small">
																					<option value="-1">[Select Town Category]</option>

																					<c:forEach var="d" items="${hraList}">
																						<option value="${d.ppTowncategorymasterid}">${d.categorytype}</option>
																						${d.ppTowncategorymasterid}
																					</c:forEach>
																			</select> <span class="star">*</span> <input type="hidden"
																				id="hraID" value="${l.hratowncategoryid}" />
																			</td>
																		</tr>
																		<tr>
																			<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																			<td align="left" valign="top" class="cell_bg">
																				Town Category For CCA</td>
																			<td align="left" valign="middle" class="cell_bg">
																				<select name="ccaTownCategoryID" id="ccaList"
																				class="cmb_small">
																					<option value="-1">[Select Town Category]</option>

																					<c:forEach var="x" items="${ccaList}">
																						<option value="${x.ppTowncategorymasterid}">${x.categorytype}</option>
																					</c:forEach>
																			</select> <span class="star">*</span> <input type="hidden"
																				id="ccaID" value="${l.ccatowncategoryid }" />
																			</td>
																		</tr>
																		<tr>

																			<td valign="top" class="cell_bg">&nbsp;</td>
																			<td align="left" valign="top" class="cell_bg">
																				Pay Scale</td>
																			<td align="left" valign="middle" class="cell_bg">
																				<select name="pp_PayScaleMasterID"
																				id="sysPayScaleList" class="cmb_small">
																					<option value="-1">[Select Pay Scale List]</option>
																					<c:forEach var="d" items="${sysPayScaleList}">
																						<option value="${d.ppPayscalemasterid}">${d.payscale}</option>
																					</c:forEach>
																			</select> <input type="hidden" id="payScaleID"
																				value="${l.ppPayscalemasterid}" />
																			</td>

																		</tr>
																		<tr>
																			<td valign="top" class="cell_bg">&nbsp;</td>
																			<td align="left" valign="top" class="cell_bg">
																				Increment Month</td>
																			<td align="left" valign="top" class="cell_bg"><input
																				type="hidden" id="increment_monthID"
																				value="${increment_monthID}"> <select
																				id="nextIncrementMonth" name="nextIncrementMonth"
																				class="cmb_small"><option value="-1">[Select
																						Month]</option>
																					<c:forEach var="d" items="${Data}">
																						<option value="${d.monthName}">${d.value}</option>
																					</c:forEach></select> <span class="star">*</span></td>
																		</tr>
																		<tr>
																			<td valign="top" class="cell_bg">&nbsp;</td>
																			<td align="left" valign="top" class="cell_bg">
																				Increment Amount</td>

																			<td align="left" valign="top" class="cell_bg"><input
																				type="text" name="defaultIncrementAmount"
																				id="defaultIncrementAmount"
																				value="${defaultIncrementAmount}" maxlength="4"
																				size="30"> <span class="star">* In
																					Percentage</span></td>
																		</tr>
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
							</table> <!--
			--> <br>
							<table width="100%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td align="center" valign="top">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td><table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="1">
														<tr>
															<td align="center" class="table_bg" valign="top"><table
																	width="100%" border="0" cellspacing="3" cellpadding="3">
																	<tr>
																		<td colspan="9" valign="top" class="table_head"
																			align="left"></td>
																	</tr>
																	<tr>
																		<td colspan="9" valign="top" class="" align="left">
																			<table width="100%" align="center" class="cell_bg"
																				cellpadding="3" cellspacing="3">



																				<tr>
																					<td id="t">Pay/Allowance Name</td>
																					<td id="t">Pay Amount</td>
																					<td id="t">Stop This Allowances</td>
																				</tr>
																				<c:forEach items="${empAlwList}" var="l">
																					<tr>
																						<td>${l.alwname}</td>
																						<td align="right"><c:choose>
																								<c:when test="${l.alwcategory == 'User Input' }">
																									<input type="text" class="txt_small"
																										value="${l.amount}" name="amount" />
																									<input type="hidden" class="txt_small"
																										value="0" name="chkAuto" />
																								</c:when>


																								<c:when test="${l.alwcategory != 'User Input' }">	
																									AUTO
																									<input type="hidden" class="txt_small"
																										name="amount" value="${l.amount}" />
																									<input type="hidden" class="txt_small"
																										value="1" name="chkAuto" />

																								</c:when>
																							</c:choose></td>
																						<td><input type="hidden"
																							id="ppPayalwmasterid" name="ppPayalwmasterid"
																							value="${l.ppPayalwmasterid}" /> <c:choose>
																								<c:when test="${l.stopAlwFlag eq '1'}">
																									<input type="checkbox" id="stopAlwFlag"
																										checked="checked" name="stopAlwFlag"
																										value="${l.ppPayalwmasterid}" />
																								</c:when>
																								<c:otherwise>
																									<input type="checkbox" id="stopAlwFlag"
																										name="stopAlwFlag"
																										value="${l.ppPayalwmasterid}" />
																								</c:otherwise>
																							</c:choose></td>
																					</tr>
																				</c:forEach>
																			</table>
																	<tr>
																		<td><a href=""> </a></td>
																		<td><input type="submit" value="Submit"
																			class="btn_medium" onclick="return validatedetails()"></td>
																		<td colspan="1" align="right" valign="top"
																			class="cell_bg"><a href=""></a></td>
																	</tr>
																</table></td>
														</tr>
													</table></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
