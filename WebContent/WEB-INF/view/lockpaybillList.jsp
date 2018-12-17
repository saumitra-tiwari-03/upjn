
<!DOCTYPE HTML >
<%@page import="com.mysql.jdbc.Util"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.ArrayList"%>

<html>
<head>
<title>U.P JAL NIGAM-Lock Pay Bill Employee Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM</title>

<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script type="text/javascript" src="resources/js/validation.js"></script>
<script type="text/javascript" src="resources/js/popcalendar.js"></script>
<script type="text/javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<script src="<c:url value="/resources/js/upjn.js" />"></script>
<script type="text/javascript">
	$(document).ready(sortDropDownListByText);
</script>


</head>

<body style="margin: 0px 0px 0px 0px;">

	<form method="post" action="/UPJN/getPayBillList">


		<div style="height: 100%; width: 100%;">

			<div
				style="height: 100px; width: 100%; border-bottom: gray solid 4px;">
				<%@ include file="/WEB-INF/view/Header.jsp"%>
			</div>

			<div
				style="height: 700px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px;">
				<%@ include file="/WEB-INF/view/Menu.jsp"%>
			</div>

			<div
				style="height: 100%; width: 79%; float: left; padding-top: 10px;">



				<table style="border: 0px; width: 100%;">

					<tr>
						<td valign="top" class="msg">${app_msg}</td>

					</tr>
					<tr>
						<td align="left" valign="top" class="error"></td>
					</tr>
					<tr>
						<td valign="top">
							<table style="border: 0px; width: 100%;">
								<tr>
									<td valign="top" align="center"><table
											style="border: 0px; width: 100%;">
											<tr>
												<td valign="top" align="center"><table
														style="border: 0px; width: 90%;">
														<tr>
															<td class="table_bg" valign="top"><table
																	style="border: 0px; width: 100%;">
																	<tr>
																		<td class=table_head valign="top" align="left"
																			width="95%">Lock Pay Bill</td>

																	</tr>
																</table>

																<table style="border: 0px; width: 100%;">

																	<tr>
																		<td colspan="3">&nbsp;</td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Month</td>
																		<td align="left" valign="top" class="cell_bg"><select
																			name="monthName" style="width: 100pt"
																			class="cmb_small">
																				<option value="-1">[Select Month]</option>
																				<c:forEach var="d" items="${monthList}">
																					<option value="${d.monthName}">${d.value}</option>
																				</c:forEach>
																		</select> <span class="star"> *</span></td>
																	</tr>

																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Year</td>
																		<td align="left" valign="top" class="cell_bg"><select
																			name="yearName" style="width: 100pt"
																			class="cmb_small">
																				<option value="-1">[Select Year]</option>
																				<c:forEach var="d" items="${yearList}">
																					<option value="${d.value}">${d.value}</option>
																				</c:forEach>
																		</select> <span class="star"> *</span></td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			Register</td>
																		<td align="left" valign="top" class="cell_bg"><select
																			name="ppRegistermasterid" style="width: 100pt"
																			class="cmb_small">
																				<option value="-1">[Select Register]</option>
																				<c:forEach var="d" items="${registerList}">
																					<option value="${d.key}">${d.value}</option>
																				</c:forEach>
																		</select> <span class="star"> *</span></td>
																	</tr>

																	<tr>
																		<td colspan="5" align="center" valign="top"
																			class="cell_bg"><input type="submit"
																			value="Submit" class="btn_small">&nbsp;&nbsp;
																		</td>
																	</tr>
																</table>


																<table style="border: 0px; width: 100%;" class="cell_bg">

																	<tr>
																		<td id="t"><img alt=""
																			src="resources/images/sort.gif">Bill clerk Name</td>
																		<td id="t"><img alt=""
																			src="resources/images/sort.gif">Bill Name</td>
																		<td id="t"><img alt=""
																			src="resources/images/sort.gif">Amount</td>

																		<td id="t">Action</td>
																	</tr>
																	<c:forEach items="${billList}" var="list">
																		<tr>

																			<td>${list.billclerkname}</td>
																			<td>${list.billName}</td>
																			<td>${list.billamount}</td>



																			<td>
																			<td><a
																				href="/UPJN/populateEmployeePayBillInfo?ppPaybilldetailid=<c:out value="${list.ppPaybilldetailid}"/>">Select</a></td>




																		</tr>
																	</c:forEach>


																</table>
													</table></td>
											</tr>
										</table>
							</table>

						</td>
					</tr>
				</table>

			</div>
		</div>
	</form>
</body>
</html>