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
<title>U.P JAL NIGAM- GPFLedger</title>
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

			<form action="/UPJN/insertnewopeningbalance">
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
																Opening Balance Entry</td>
														</tr>

														<tr>
															<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
															<td align="right" class="error_normal">* Fields are
																required</td>
														</tr>
														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="center">Employee
																Code</td>
															<td class="cell_bg" valign="top" align="left"><input
																maxlength="6" type="text" class="txt_medium"
																name="employeecode" /> <span class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="center"
																width="43%">Year</td>

															<td align="left"><select class="cmb_medium"
																name="financeYear" required>
																	<option value="-1">[Select Financial Year]</option>
																	<%--	<c:forEach var="a" items="${financeYearList}">
																		<option value="${a.startyear}">${a.startyear}</option>
																	</c:forEach> --%>
																	<option value="2015-2016">2015-2016</option>
																	<!-- <option value="2017-2018">2017-2018</option>
																	<option value="2018-2019">2018-2019</option>
																	<option value="2019-2020">2019-2020</option> -->
															</select> <span class="star"> *</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="center">Opening
																Balance</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" class="txt_medium" name="openingbalance" />
																<span class="star">*</span></td>
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

															<td colspan="4" align="center" valign="top"
																class="cell_bg">
														
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