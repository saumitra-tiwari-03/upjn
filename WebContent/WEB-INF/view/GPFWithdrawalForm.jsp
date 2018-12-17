<%-- ******************************** JSP FOR GPF Ledger **************************

==========================================================================
 * Description 	: This JSP is a form for Withdrawal Entry in GPF Ledger.
 * Date			:
 * Author		: VIKAS SINGH
 * Review By 	: 
 * Review Date	:  
==========================================================================

  --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM- GPFWithdrawal</title>
<script type="text/javascript" src="resources/js/popcalendar.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div style="height: 100%; width: 100%;">

		<div
			style="height: 100px; width: 100%; border-bottom: gray solid 4px;">
			<%@ include file="/WEB-INF/view/Header.jsp"%>
		</div>

		<div
			style="height: 700px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px; overflow-x: auto;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div align="center"
			style="height: 100%; width: 79%; float: left; padding-top: 10px; overflow-x: auto;">

			<form action="/UPJN/insertWithdrawal">

				<table width="95%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td align="center" valign="top"><table width="100%"
								border="0" cellspacing="1" cellpadding="1">
								<tr>
									<td valign="top"><table width="100%" border="0"
											cellspacing="3" cellpadding="3">
											<tr>
												<td valign="top" class="table_bg">
													<table border="0" width="100%">

														<tr>
															<td class="msg" colspan="4">${msg}</td>
														</tr>
														<tr>
															<td class="error" colspan="4">${error}</td>
														</tr>
														<tr>

															<td class="table_head" colspan="4">GPF Ledger -
																Withdrawal Entry</td>
														</tr>
														<tr>
															<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
															<td align="right" class="error_normal">* Fields are
																required</td>
														</tr>
														
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Employee
																Code</td>
															<td class="cell_bg" valign="top" align="left"><input
																name="emp_code" type="text"
																class="txt_medium" /> <span class="star">*</span>																
															</td>
														</tr>		
														
														<%-- <tr>
															<td>
															    <input type="hidden" value="${ppempmasid}" name="PP_EMPLOYEEMASTERID">
															</td>
														</tr> --%>
														
														<tr>
															<td></td>
														</tr>
														
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">Month</td>

															<td align="left"><select class="cmb_medium"
																name="MONTH" required>
																	<option value="-1">[Select Month]</option>
																	<c:forEach var="a" items="${months}">
																		<option value="${a.monthName}">${a.value}</option>
																	</c:forEach>
															</select></td>
														</tr>


														<tr>
															<td></td>
														</tr>

														<tr>
															<td></td>
														</tr>
														
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">Year</td>

															<td align="left"><select class="cmb_medium"
																name="YEAR" required>
																	<option value="-1">[Select Year]</option>
																	<c:forEach var="a" items="${years}">
																		<option value="${a.value}">${a.yearName}</option>
																	</c:forEach>
															</select></td>
														</tr>
														<tr>
															<td></td>
														</tr>
														
														<tr>
															<td></td>
														</tr>
														
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Date of Entry
																</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" class="txt_date" name="DATE_OF_ENTRY" required />
																<a href="javascript:;"
																onclick="displayCalendar(document.forms[0].DATE_OF_ENTRY,'dd/mm/yyyy',document.forms[0].DATE_OF_ENTRY)">

																	<img height="16" hspace="0"
																	src="resources/images/calendar-icon.gif" width="16"
																	border="0" />
															</a> <span class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td></td>
														</tr>
														
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Order
																Date</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" class="txt_date" name="ORDERDATE" required />
																<a href="javascript:;"
																onclick="displayCalendar(document.forms[0].ORDERDATE,'dd/mm/yyyy',document.forms[0].ORDERDATE)">

																	<img height="16" hspace="0"
																	src="resources/images/calendar-icon.gif" width="16"
																	border="0" />
															</a> <span class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>


														<tr>
															<td></td>
														</tr>
														
														
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Effective
																Date</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" class="txt_date" name="EFFECTIVEDATE"
																required /> <a href="javascript:;"
																onclick="displayCalendar(document.forms[0].EFFECTIVEDATE,'dd/mm/yyyy',document.forms[0].EFFECTIVEDATE)">

																	<img height="16" hspace="0"
																	src="resources/images/calendar-icon.gif" width="16"
																	border="0" />
															</a> <span class="star">*</span></td>
														</tr>


														<tr>
															<td></td>
														</tr>


														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Amount
															</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" class="txt_medium" name="AMOUNT" /> <span
																class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Order
																Number</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" class="txt_medium" name="ORDERNUMBER" /> <span
																class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>
														
														<tr>
															<td></td>
														</tr>
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Bill
																Number</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" class="txt_medium" name="BILL_NUMBER" /> <span
																class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>


														<tr>
															<td></td>
														</tr>

														<tr>

															<td colspan="4" align="center" valign="top"
																class="cell_bg"><input type="submit" value="Submit"
																class="btn_medium"> <input type="reset"
																value="Reset" class="btn_medium"></td>
														</tr>
												
												<tr>
															<td></td>
														</tr>

														<tr>
															<td></td>
														</tr>
														
													</table>
												</td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table>

			</form>
		</div>
	</div>

</body>
</html>
