
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM-Pay BillInfo</title>

<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script language="javascript" src="resources/js/validation.js"></script>
<script language="javascript" src="resources/js/popcalendar.js"></script>
<script language="javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>




</head>

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

			<form method="post" action="/UPJN/InsertLockPayBillDetailForLock">
				<input type="hidden" name="ppPaybilldetailid"
					value="${ppPaybilldetailid}">



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
						<td valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td valign="top"><table width="98%" border="0" align="center"
								cellpadding="0" cellspacing="0">
								<tr>
									<td align="center" valign="top"><table width="60%"
											border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td valign="top"><table width="100%" border="0"
														cellspacing="0" cellpadding="0">
														<tr>
															<td valign="top" class="table_bg"><table
																	width="100%" border="0" cellspacing="0" cellpadding="3">
																	<tr>
																		<td colspan="3" valign="top" class="table_head"
																			align="left">Lock Pay Bill</td>
																		<td align="center" valign="middle" class="table_head">&nbsp;

																		</td>
																	</tr>
																	<tr>
																		<td colspan="3" valign="top" class="table_bg"></td>
																	</tr>
																	<tr>
																		<td colspan="3" valign="top" class="cell_bg">&nbsp;</td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Month</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="text" name="monthName" value="${month}"
																			readonly="readonly" class="txt_noborder"> <input
																			type="hidden" name="month"></td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">Year
																		</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="text" name="year" value="${year}"
																			readonly="readonly" class="txt_noborder"></td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Register</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="hidden" name="pp_RegisterMasterID"> <input
																			type="text" name="registername"
																			value="${registername}" readonly="readonly"
																			class="txt_noborder"></td>
																	</tr>

																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Description</td>
																		<td align="left" valign="top" class="cell_bg">
																		<%-- <input
																			type="text" name="description"  value="${description}" 
																			readonly="readonly" class="txt_noborder"> --%>
																			${description} </td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">Net
																			Amount(Rs.)</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="text" name="bill_Amount" value="${billamount}"
																			readonly="readonly" class="txt_noborder"></td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">Bill
																			Amount(Rs.)</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="text" name="net_Pay" value="${netpay}"
																			readonly="readonly" class="txt_noborder"></td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">Bill
																			No.</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="text" name="billNo" class="txt_medium"><span
																			class="star"> *</span></td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">Bill
																			Date</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="text" name="billDate" class="txt_date"
																			readonly="true" /> <a href="javascript:;"
																			onclick="displayCalendar(document.forms[0].billDate,'dd/mm/yyyy', document.forms[0].billDate);">
																				<img height="16" hspace="0"
																				src="resources/images/calendar-icon.gif" width="16"
																				border="0" />
																		</a> <span class="star">*</span>
																	</tr>


																	<tr>
																		<td align="center" valign="top" class="cell_bg"
																			colspan="3"><input type="submit" value="Submit"
																			class="btn_medium"></td>
																	</tr>
																</table></td>
														</tr>
													</table></td>
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