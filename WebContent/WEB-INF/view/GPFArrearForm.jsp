<%-- ******************************** JSP FOR GPF Ledger **************************

==========================================================================
 * Description 	: This JSP is responsible for the operations related to Change of Password.
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
<title>U.P JAL NIGAM- GPFArrear</title>
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

			<form action="/UPJN/insertArrear">
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
																Arrear Entry</td>
														</tr>

														<tr>
															<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
															<td align="right" class="error_normal">* Fields are
																required</td>
														</tr>
														
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Employee Code
															</td>
															<td class="cell_bg" valign="top" align="left"><input name="emp_code"
																type="text" class="txt_medium" /> <span class="star">*</span></td>
														</tr>

														 <tr>
															<td></td>
														</tr>

														<tr>
															<td></td>
														</tr>
														

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">Month</td>

															<td align="left"><select class="cmb_medium"
																name="month" required>
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
																name="year" required>
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
															<td class="cell_bg" valign="top" align="left">Arrear From</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" class="txt_date" name="arrearfrom" required /> <a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].arrearfrom,'dd/mm/yyyy',document.forms[0].arrearfrom)">

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
															<td class="cell_bg" valign="top" align="left">Arrear To</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" class="txt_date" name="arrearto" required /> <a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].arrearto,'dd/mm/yyyy',document.forms[0].arrearto)">

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
															<td class="cell_bg" valign="top" align="left">Date of Effect</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" class="txt_date" name="dateofentry" required /> <a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].dateofentry,'dd/mm/yyyy',document.forms[0].dateofentry)">

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
																type="text" class="txt_medium" name="amount"/> <span class="star">*</span></td>
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
																type="text" class="txt_medium" name="billnumber"/> <span class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">Arrear</td>

															<td align="left"><select class="cmb_medium"
																name="arreartype" required>
																	<option value="-1">[Select Arrear Type]</option>
																	<option value="DA Arrear">DA Arrear</option>
																	<option value="Other">Other</option>
															</select></td>
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