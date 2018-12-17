<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>U.P JAL NIGAM-Employee Deduction Details</title>
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
			<form action="/UPJN/EmployeeDeductions" method="post">
				<input type="hidden" name="ppEmployeeMasterID"
					value="${ppEmployeeMasterID}">


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
																			class="table_head">Update Deduction Detail</td>
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
																						bordercolor="#4390E0" bgcolor="#4390E0"
																						width="25%"><a
																						href="/UPJN/payandalwdetails?ppEmployeeMasterID=${ppEmployeeMasterID}&sectionname=${sectionName}&register=${registerName}"><u></u>
																							<strong>Pay and Allowance Detail</strong> </a></td>
																					<td valign="middle" class="tabdefault"
																						bordercolor="#FFFFFF" width="25%"><a href="#"><u></u>
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
																				readonly="readonly" class="txt_noborder"></td>
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
																				readonly="readonly" class="txt_noborder"> <!-- <input
																				type="hidden" name="mas_EmploymentTypeID" value="1"> -->

																			</td>
																		</tr>
																	</c:forEach>
																	<tr>
																		<td colspan="3" class="cell_bg"></td>
																		<td><input type="hidden" name="isnps" value="${isnps}">  </td>
																	</tr>
																	
																	
															<c:if test="${isnps eq 'G'}">		
																	<c:forEach items="${dedList}" var="dedList" end="8">

																		<tr>
																			<td valign="top" class="cell_bg">&nbsp;</td>
																			<td align="left" valign="top" class="cell_bg">
																				${dedList.deductionname}</td>
																			<td align="left" valign="middle" class="cell_bg">
																				<input type="text" name="amount" maxlength="100"
																				size="25" value="${dedList.amount}" class="txt_small"> <input
																				type="checkbox"
																				value="${dedList.ppDeductionmasterid}"
																				name="stopDeduction"> <input type="hidden"
																				name="ppDeductionmasterid"
																				value="${dedList.ppDeductionmasterid}">
																			</td>	
																		</tr>

																	</c:forEach>
															</c:if>	
															
															<c:if test="${isnps eq 'N'}">		
																	<c:forEach items="${dedList}" var="dedList" begin="1">

																		<tr>
																			<td valign="top" class="cell_bg">&nbsp;</td>
																			<td align="left" valign="top" class="cell_bg">
																				${dedList.deductionname}</td>
																			<td align="left" valign="middle" class="cell_bg">
																				<input type="text" name="amount" maxlength="100"
																				size="25" value="${dedList.amount}" class="txt_small"> <input
																				type="checkbox"
																				value="${dedList.ppDeductionmasterid}"
																				name="stopDeduction"> <input type="hidden"
																				name="ppDeductionmasterid"
																				value="${dedList.ppDeductionmasterid}">
																			</td>	
																		</tr>

																	</c:forEach>
															</c:if>		

																
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td colspan="2" align="left" valign="top"
																			class="cell_bg">&nbsp;</td>
																	</tr>

																	<c:forEach items="${empPayList}" var="a">
																		<c:if test="${a.isnps eq 'N'}">
																			<tr>
																				<td valign="top" class="cell_bg">&nbsp;</td>
																				<td align="right" valign="top" class="cell_bg"><input
																					type="submit" name="NpsArrearDetails"
																					value="NpsArrear" class="btn_medium"></td>
																			</tr>
																		</c:if>

																	</c:forEach>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="submit" name="saveDetuctionDetails"
																			value="Submit" class="btn_medium"></td>

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
		</div>
	</div>
</body>
</html>
