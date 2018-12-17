
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>U.P JAL NIGAM-Employee Loan Details</title>
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

<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<script type="text/javascript">
	$(document).ready(sortDropDownListByText);
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#monthList").val($("#monthName").val());
		$("#yearList").val($("#yearName").val());
		$("#loanMasterList").val($("#ppLoanmasterid").val());
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
			<form action="/UPJN/insertLoanSanctionDetails">
				<input type="hidden" name="pp_EmployeeMasterID"
					value="${pp_EmployeeMasterID}">
					<input type="hidden" name="ppLoandetailid"
					value="${ppLoandetailid}">
					



				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td valign="top" class="msg">${mes}</td>

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
																			class="table_head">Add New Loan</td>
																		<td align="center" valign="middle" class="table_head">
																			<a href="/UPJN/selectRegister"> <img
																				src="resources/images/cross.jpeg" height="16" width="16"
																				border="0" hspace="0" >
																		</a>
																		</td>
																	</tr>
																</table>
																<table width="100%" border="0" cellspacing="1"
																	cellpadding="3">
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td colspan="2" align="left" valign="top"
																			class="cell_bg">&nbsp;</td>
																	</tr>
																	<tr>
																		<td colspan="4" valign="top" class="cell_bg"></td>
																	</tr>
																	<tr>
																		<td colspan="4" valign="top" class="cell_bg"></td>
																	</tr>

																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Employee Name</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<input type="text" name="employeeName"
																			value="${employeeName}" maxlength="200"
																			readonly="readonly" class="txt_noborder">
																		</td>
																	</tr>
																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Designation</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<input type="text" name="designation"
																			value="${designation}" maxlength="100" size="50"
																			readonly="readonly" class="txt_noborder">
																		</td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Loan Name</td>
																		<td align="left" valign="top" class="cell_bg">
																		
																		<c:if
																				test="${ppLoanMasterList1 == null}">
																				<select id="loanname" name="ppLoanmasterid"
																					style="width: 100pt" class="cmb_small">
																					<option value="-1">[Select Loan Name]</option>
																					<c:forEach var="d" items="${loanMasterList}">
																						<option value="${d.key}">${d.value}</option>
																					</c:forEach>
																				</select>
																			</c:if> <c:if test="${ppLoanMasterList1 != null}">
																				<c:forEach items="${ppLoanMasterList1}" var="a">
																					<input type="hidden"
																						value="${a.ppLoanmasterid}" id="ppLoanmasterid"
																						>
																				</c:forEach>
																				<select id="loanname" name="ppLoanmasterid"
																					style="width: 100pt" class="cmb_small">
																					<option value="-1">[Select Loan Name]</option>
																					<c:forEach var="d" items="${loanMasterList}">
																						<option value="${d.key}">${d.value}</option>
																					</c:forEach>
																				</select>
																			</c:if>
																		
																		
																		
																		
																		</td>

																	</tr>

																	<tr>
																		<td colspan="3" class="cell_bg"></td>
																	</tr>

																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Loan Short Name</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="text" name="loanShortName"
																			value="${loanShortName}" id="loanShortName"
																			maxlength="50" size="50" readonly="readonly"
																			class="txt_noborder"></td>
																	</tr>



																	<tr>
																		<td colspan="3" class="cell_bg"></td>
																	</tr>

																	<td align="left" colspan="3" class="bold">
																		Sanction Detail</td>
																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Loan Amount</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<input type="text" name="loanAmount"
																			value="${loanAmount}" maxlength="7"
																			class="txt_medium"> <span class="star">*</span>
																		</td>
																	</tr>
																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Loan Sanction Order No.</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<input type="text" name="loanSanctionOrdNo"
																			value="${loanSanctionOrdNo}" class="txt_medium">
																		</td>
																	</tr>
																	<tr>
																		<td colspan="3" class="cell_bg"></td>
																	</tr>


																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">

																			Sanction Date (dd/mm/yyyy)</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="text" class="txt_date" name="sanctionDate"
																			value="${sanctionDate}" id="sanctionDate" size="11"
																			maxlength="10" readonly="readonly"> <a
																			href="javascript:;"
																			onclick="displayCalendar(document.forms[0].sanctionDate,'dd/mm/yyyy', document.forms[0].sanctionDate);">
																				<img alt="" src="resources/images/calendar-icon.gif"
																				height="16" hspace="0" width="16">
																		</a> <span class="star">*[Max 16 char.]</span></td>
																	</tr>


																	<td align="left" colspan="3" class="bold">
																		Recovery Detail</td>
																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">

																			Total No Of Instalments</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<input type="hidden" name="max_InstallmentNo">
																			<input type="text" name="pa_NoOfInstallments"
																			value="${pa_NoOfInstallments}" maxlength="3"
																			class="txt_date"> <span class="star">*</span>
																		</td>
																	</tr>
																	<td align="left" colspan="3" class="bold">EMI
																		(Equated Monthly Installment)</td>
																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			First Installment Amount</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<input type="text" name="firstinstallmentamount"
																			value="${firstinstallmentamount}" maxlength="7"
																			class="txt_medium"> <span class="star">*</span>
																		</td>
																	</tr>
																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">


																			Remaining Installment Amount</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<input type="text" name="paInstallmentamount"
																			value="${paInstallmentamount}" maxlength="7"
																			class="txt_medium"> <span class="star">*</span>
																		</td>
																	</tr>




																	<tr>
																		<td align="left" colspan="3" class="bold">
																			Recovery Start</td>
																	</tr>


																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Month</td>
																		<td class="cell_bg" valign="top" align="left"><c:if
																				test="${ppLoanEntities == null}">
																				<select id="monthId" name="monthName"
																					style="width: 100pt" class="cmb_small">
																					<option value="-1">[Select Month]</option>
																					<c:forEach var="d" items="${monthList}">
																						<option value="${d.monthName}">${d.value}</option>
																					</c:forEach>
																				</select>
																			</c:if> <c:if test="${ppLoanEntities != null}">
																				<c:forEach items="${ppLoanEntities}" var="a">
																					<input type="hidden"
																						value="${a.pa_RecovCommenceMonth}" id="monthName"
																						>
																				</c:forEach>
																				<select id="monthList" name="monthName"
																					style="width: 100pt" class="cmb_small">
																					<option value="-1">[Select Month]</option>
																					<c:forEach var="d" items="${monthList}">
																						<option value="${d.monthName}">${d.value}</option>
																					</c:forEach>
																				</select>
																			</c:if></td>
																	</tr>

																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Year</td>
																		<td class="cell_bg" valign="top" align="left"><c:if
																				test="${ppLoanEntities == null}">
																				<select id="yearListId" name="yearName"
																					style="width: 100pt" class="cmb_small">
																					<option value="-1">[Select Year]</option>
																					<c:forEach var="d" items="${yearList}">
																						<option value="${d.value}">${d.value}</option>
																					</c:forEach>
																				</select>
																			</c:if> <c:if test="${ppLoanEntities != null}">
																				<c:forEach items="${ppLoanEntities}" var="a">
																					<input type="hidden"
																						value="${a.pa_RecovCommenceYear}" id="yearName"
																						>
																				</c:forEach>
																				<select id="yearList" name="yearName"
																					style="width: 100pt" class="cmb_small">
																					<option value="-1">[Select Year]</option>
																					<c:forEach var="d" items="${yearList}">
																						<option value="${d.value}">${d.value}</option>
																					</c:forEach>
																				</select>
																			</c:if></td>
																	</tr>
																	

																	<td align="left" colspan="3" class="bold">
																		Recovery Status</td>
																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Next Installment No.</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<input type="text" value="${paNextinstallmentno}"
																			name="paNextinstallmentno" maxlength="3"
																			class="txt_date"> <span class="star">*</span>

																			(stop NextInstallmentNo) <input type="checkbox"
																			name="stopInstallment" value="${stopInstallment}">
																		</td>
																	</tr>
																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Recovered Amount</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<input type="text" value="${pa_Recovered}"
																			name="pa_Recovered" class="txt_medium">
																		</td>
																	</tr>
																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Set As Fully Recovered (for Premature termination)</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<input type="checkbox" name="pa_IsFullyRecovered"
																			value="${pa_IsFullyRecovered}">
																		</td>
																	</tr>
																	<tr>
																		<td class="cell_bg" valign="top">&nbsp;</td>
																		<td colspan="5" align="center" valign="top"
																			class="cell_bg"><input type="submit"
																			value="Submit" class="btn_medium"> <input
																			type="reset" value="Reset" class="btn_medium"></td>
																	</tr>

																	<tr>
																		<td colspan="1" align="right" valign="top"
																			class="cell_bg"></td>
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

								<tr>
									<td valign="top">
										<table width="100%" border="0" align="center" cellpadding="0"
											cellspacing="0">
											<tr>
												<td align="center" valign="top">
													<table width="100%" border="0" cellspacing="0"
														cellpadding="0">
														<tr>
															<td valign="top" align="center">
																<table width="80%" border="0" cellspacing="1"
																	cellpadding="1">
																	<tr>
																		<td valign="top" class="table_bg">
																			<table width="100%" border="0" cellspacing="1"
																				cellpadding="3">

																				<tr>
																					<td id="t"><img alt=""
																						src="resources/images/sort.gif">Loan
																						ShortName</td>
																					<td id="t"><img alt=""
																						src="resources/images/sort.gif">Loan Amount</td>
																					<td id="t"><img alt=""
																						src="resources/images/sort.gif">Sanction
																						Date</td>


																					<td id="t">Action</td>
																				</tr>

																				<c:forEach items="${loanSanctionList}" var="list1">
																					<input type="hidden" id="ppEmployeemasterid"
																						value="${list1.ppEmployeemasterid}"
																						name="ppEmployeemasterid" />
																					<tr>
																						<td>${list1.loanshortname}</td>
																						<td>${list1.loanamount}</td>
																						<td>${list1.sanctiondate}</td>

																						<td><a
																							href="retrieveLoanSanction?pp_LoanDetailID=<c:out value="${list1.ppLoandetailid}"/>">
																								EDIT</a></td>
																						<td><a
																							href="deleteLoanSanction?pp_LoanDetailID=<c:out value="${list1.ppLoandetailid}"/>">
																								DELETE</a></td>
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
