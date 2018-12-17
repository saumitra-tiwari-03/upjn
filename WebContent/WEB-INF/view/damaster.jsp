
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
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />

</head>
<body>

	<div style="height: 100%; width: 100%;">

		<div
			style="height: 100px; width: 100%; border-bottom: gray solid 4px;">
			<%@ include file="/WEB-INF/view/Header.jsp"%>
		</div>


		<div
			style="height: 600px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px; overflow-x: auto;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div
			style="height: 100%; width: 79%; float: left; padding-top: 10px; overflow-x: auto;">


			<form method="post" action="/UPJN/addDARecord">

				<input type="hidden" name="method" value="insertDA">




				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td valign="top" class="msg">${success}</td>
					</tr>
					<tr>
						<td valign="top" class="error">${error}</td>
					</tr>
					<tr>
						<td valign="top"><table width="100%" align="center"
								cellpadding="0" cellspacing="0" border="0">
								<tr>
									<td valign="top"><table width="60%" align="center"
											cellpadding="0" cellspacing="1" border="0" class="table_bg">
											<tr>
												<td valign="top"><table width="100%" align="center"
														class="cell_bg" cellpadding="3" cellspacing="3" border="0">
														<tr>
															<td align="left" valign="top" class="table_head"
																colspan="4">DA MASTER FORM</td>
														</tr>

														<tr>
															<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
															<td colspan="2" valign="middle" class="error_normal"
																align="right">* Fields are required.</td>
														</tr>
														<tr>
															<td>&nbsp;</td>
															<td align="left" valign="top">Pay Category</td>
															<td class="cell_bg" valign="top" align="left"><select
																name="payCategory" class="cmb_medium"><option
																		value="-1">Select Category</option>
																	<option value="572">VI-P/SCL</option>
																	<option value="427">V-P/ SCL</option></select><span class="star">*</span></td>
														</tr>

														<tr>
															<td>&nbsp;</td>
															<td align="left" valign="top">DA rule order No</td>
															<td align="left"><input type="text"
																name="ruleOrderNo" value="" class="txt_medium">
																<span class="star">*</span></td>
														</tr>

														<tr>
															<td>&nbsp;</td>
															<td align="left" valign="top">DA rule order Date</td>

															<td align="left"><input type="text" class="txt_date"
																name="ruleOrderDate" required> <a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].ruleOrderDate,'dd/mm/yyyy',document.forms[0].ruleOrderDate)">

																	<img height="16" hspace="0"
																	src="resources/images/calendar-icon.gif" width="16"
																	border="0" />
															</a> <span class="star">*</span></td>

														</tr>

														<tr>
															<td>&nbsp;</td>
															<td align="left" valign="top">DA Due Date</td>


															<td align="left"><input type="text" class="txt_date"
																name="dueDate" required> <a href="javascript:;"
																onclick="displayCalendar(document.forms[0].dueDate,'dd/mm/yyyy',document.forms[0].dueDate)">

																	<img height="16" hspace="0"
																	src="resources/images/calendar-icon.gif" width="16"
																	border="0" />
															</a> <span class="star">*</span></td>

														</tr>

														<tr>
															<td>&nbsp;</td>
															<td align="left" valign="top">DA Arrear into
																GPF(Till)[Date]</td>


															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date" name="gpfDate" size="11"
																maxlength="10" readonly="readonly"> <a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].gpfDate,'dd/mm/yyyy', document.forms[0].gpfDate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>



														</tr>

														<tr>
															<td>&nbsp;</td>
															<td align="left" valign="top">DA Arrear payable
																Cash(Till)[Date]</td>

															<td align="left"><input type="text" class="txt_date"
																name="cashDate" required> <a href="javascript:;"
																onclick="displayCalendar(document.forms[0].cashDate,'dd/mm/yyyy',document.forms[0].cashDate)">

																	<img height="16" hspace="0"
																	src="resources/images/calendar-icon.gif" width="16"
																	border="0" />
															</a> <span class="star">*</span></td>


														</tr>



														<tr>
															<td>&nbsp;</td>
															<td align="left" valign="top">DA payable with
																salary[Date]</td>

															<td align="left"><input type="text" class="txt_date"
																name="ruleEffectiveDate" required> <a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].ruleEffectiveDate,'dd/mm/yyyy',document.forms[0].ruleEffectiveDate)">

																	<img height="16" hspace="0"
																	src="resources/images/calendar-icon.gif" width="16"
																	border="0" />
															</a> <span class="star">*</span></td>

														</tr>

														<tr>
															<td>&nbsp;</td>
															<td align="left" valign="top">Rate of Dearness
																Allowance(in %)</td>
															<td align="left"><input type="text" name="daPercent"
																value="" class="txt_medium"> <span class="star">*</span></td>
														</tr>


														<tr>
															<td align="center" valign="top" class="cell_bg"
																colspan="3"><input type="submit" value="Submit"
																class="btn_medium"></td>
														</tr>
													</table>
										</table> <br> <br></td>
								</tr>
							</table></td>
					</tr>
				</table>



				<table width="90%" border="0" cellspacing="1" cellpadding="3"
					align="center">
					<tr>
						<td valign="top" class="table_bg">


							<div
								style="width: 99%; height: 320px; overflow: auto; padding: 5px;">

								<table cellspacing="0" cellpadding="0" border="0" align="CENTER"
									class="FORM">
									<tr>
										<td valign="top"><table cellspacing="1" cellpadding="1"
												border="0" width="100%">

												<tr>

													<td class="table_head" colspan="4">DA Information</td>
												</tr>
												</tr>
											</table>

											<table style="border: 0px; width: 100%;" class="cell_bg">


												<c:forEach items="${dalist}" var="a">

													<tr>
														<td>${a.paycategory}</td>
														<td>${a.RULEORDERNO}</td>
														<td>${a.DATEOFEFFECT}</td>
														<td>${a.DUEDATE}</td>
														<td>${a.GPFDATE}</td>
														<td>${a.CASHDATE}</td>
														<td>${a.RULEORDERDATE}</td>
														<td>${a.PERCENTVALUE}</td>
													</tr>
												</c:forEach>
												
											</table></td>
									</tr>
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



