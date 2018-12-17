<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>U.P JAL NIGAM-Employee Pay Details</title>
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

$(document).ready(function(){
	$("#salaryPercent").val($("#salarypercentID").val());
	$("#sys_PaymentMode").val($("#paymentmodeID").val());
	if($("#nod").val() == "full") {
		$("#nodCheck").prop("checked",true);
	}
	});
</script>

<%-- <% request.getAttribute("Data"); %>
<% request.getAttribute("Data1"); %> --%>





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
			<form method="post" action="/UPJN/setEmpPayDetail">

				<input type="hidden" name="action" value="edit">
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td valign="top" class="msg"></td>
					</tr>
					<tr>
						<td valign="top" class="error"></td>
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
																			<a href="UpdatePayDetail"> <img
																				src="images/cross.jpeg" height="16" width="16"
																				border="0" hspace="0">
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
																						bgcolor="#FFFFFF" width="25%"><strong>
																							General Detail </strong></td>
																					<td valign="middle" class="tabdefault"
																						bordercolor="#4390E0" bgcolor="#4390E0"
																						width="25%"><a
																						href="/UPJN/payandalwdetails?ppEmployeeMasterID=${ppempmasterid}&sectionname=${sectionname}"><u></u>
																							<strong>Pay & Allowance Detail</strong> </a></td>
																					<td valign="middle" class="tabdefault"
																						bordercolor="#4390E0" bgcolor="#4390E0"
																						width="25%"><a
																						href="/UPJN/PayAllowanceDetail/>"><u></u>
																							<strong>Deduction Detail</strong> </a></td>
																					<td valign="middle" class="tabdefault"
																						bordercolor="#4390E0" bgcolor="#4390E0"
																						width="25%"><a
																						href="/UPJN/PayAllowanceDetail/>"><u></u>
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
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td width="40%" align="left" valign="top"
																			class="cell_bg">Register Name</td>
																		<td width="48%" align="left" valign="top"
																			class="cell_bg"><input type="text"
																			name="registerName" value="${registername}" maxlength="100" size="30"
																			readonly="readonly" class="txt_noborder"></td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Employee Code</td>
																		<td align="left" valign="middle" class="cell_bg">

																			<input type="text" name="employeeCode" value="${employeecode}" maxlength="25"
																			size="25" readonly="readonly" class="txt_noborder">


																		</td>
																	</tr>

																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Employee Name</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="text" name="employeeName" value="${employeename}" maxlength="100"
																			size="25" readonly="readonly" class="txt_noborder">
																		</td>
																	</tr>
																	<tr>
																		<td colspan="3" class="cell_bg"></td>
																	</tr>
																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Employee Designation</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<input type="text" name="designation" value="${designation}" maxlength="100"
																			size="25" readonly="readonly" class="txt_noborder">
																		</td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Section Name</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="text" name="sectionName" maxlength="100"
																			size="25" readonly="readonly" class="txt_noborder" value="${sectionname }">
																		</td>
																	</tr>

																	<tr>
																		<td class="cell_bg" valign="top">&nbsp;</td>
																		<td class="cell_bg" valign="top" align="left">PF
																			Category</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<select id="isnps" name="isnps" class="cmb_medium">
																				<option value="N">NPS</option>
																				<option value="G" selected="selected">GPF</option>
																				<option value="O">Not Applicable</option>
																				<c:forEach var="d" items="${CategoryList}">
																					<option value="${d.key}">${d.value}</option>
																				</c:forEach>
																		</select>


																		</td>

																	</tr>

																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg"
																			id="gpfno">GPF A/C No</td>
																		<td align="left" valign="top" class="cell_bg"
																			id='empPayDetailForm'><input type="text"
																			name="gpfAcNo" maxlength="25" size="25"
																			class="txt_small" id="empPayDetailForm" value="${gpfacno}"> <span
																			class="star">*[Max 25 char.]</span></td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			PAN No</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="text" name="panno" maxlength="25" size="25" value="${panno}"
																			class="txt_small"></td>
																	</tr>

																	<tr>
																		<td class="cell_bg" valign="top">&nbsp;</td>
																		<td class="cell_bg" valign="top" align="left">
																			Payment Mode</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<select id="sys_PaymentMode" name="sys_PaymentModeID"
																			class="cmb_medium">
																				<option value="-1">Select Payment Mode</option>
																				<option value="BANK">BANK</option>
																				<option value="CASH">CASH</option>
																				<option value="CHEQUE">CHEQUE</option>
																		</select>
																		<input type="hidden" id="paymentmodeID" name="paymentmode" value="${paymentmode }"/>


																		</td>

																	</tr>


																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Employment Type</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<input type="text" name="employmentType"
																			maxlength="100" size="25" readonly="readonly" value="${emptype }"
																			class="txt_noborder"> <input type="hidden"
																			name="mas_EmploymentTypeID">
																		</td>
																	</tr>








																	<tr>
																		<td class="cell_bg" valign="top">&nbsp;</td>
																		<td class="cell_bg" valign="top" align="left">
																			Office Account No.</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<select id="fwa_BankAccountID"
																			name="fwa_BankAccountID" class="cmb_medium">
																				<c:forEach var="d" items="${fwabankaccount}">
																					<option>${d.acNumber}</option>
																				</c:forEach>
																		</select>


																		</td>

																	</tr>




																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Bank A/C No.</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<input type="text" name="bankAccNo" maxlength="20" value="${bankaccno}"
																			size="30" class="txt_small"> <span
																			class="star">*[Max 20 char.]</span>
																		</td>
																	</tr>

																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Bank Name</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="text" name="bank_Name" value="${bankname}" class="txt_medium">
																		
																	</tr>

																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Branch Name</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="text" name="branch_Name" value = "${branchname}"class="txt_medium">
																		
																	</tr>

																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			IFSC CODE</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="text" name="ifsc_code" value="${ifsccode}" class="txt_medium">
																			
																	</tr>


																	<tr>
																		<td class="cell_bg" valign="top">&nbsp;</td>
																		<td class="cell_bg" valign="top" align="left">
																			Salary Percent</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<select id="salaryPercent" name=""
																			class="cmb_medium">
																				<option value="-1">Select Salary Percent</option>
																				<option value="100">100</option>
																				<option value="75">75</option>
																				<option value="50">50</option>
																				<option value="0">none</option>
																			</select>
																			<input type="hidden" name="salarypercent" id="salarypercentID" value="${salarypercent}"/>


																		</td>

																	</tr>



																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">No
																			Of Days</td>
																		<td align="left" valign="middle" class="cell_bg">
																			Full Month <input type="checkbox" name="txtNoOfDays"
																			value="null" id = "nodCheck" onclick="return onCheck();"> <input
																			type="text" name="noOfDays" maxlength="2"
																			onkeypress="return numbersonly(event);"
																			class="txt_small"> <span class="star">*</span>
																			<input type="hidden" id="nod" value="${nod }"/>
																		</td>
																	</tr>
																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Head Quarter</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<input type="text" name="headQuarter" maxlength="15" value="${hq }"
																			size="30" class="txt_small"> <span
																			class="star">*[Max 15 char.]</span>
																		</td>
																	</tr>






																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="right" valign="top" class="cell_bg"><input
																			type="button" name="none" value="Submit"
																			class="btn_medium"></td>
																		<td colspan="1" align="right" valign="top"
																			class="cell_bg"><a
																			href="/UPJN/PayAllowanceDetail?employeecode=<c:out value="${list.employeecode}"/>"><u></u>
																				next >> </a></td>
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
					</tr>
				</table>

			</form>
			<script>
				
			</script>
		</div>
	</div>

</body>
</html>
