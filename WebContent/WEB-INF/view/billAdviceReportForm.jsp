<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UP Jal Nigam - Bill Advice Form</title>
<script type="text/javascript">
	
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

			<form action="/UPJN/getPayBillDetail12" method="post">

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

															<td class="table_head" colspan="4">Bill Advice Form</td>
														</tr>

														<tr>
															<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
															<td align="right" class="error_normal">* Fields are
																required</td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">Month</td>

															<td align="left"><select class="cmb_medium"
																name="monthName" required>
																	<option value="-1">[Select Month]</option>
																	<c:forEach var="a" items="${months}">
																		<option value="${a.monthName}">${a.value}</option>
																	</c:forEach>
															</select>
															<span class="star"> *</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>


														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">Year</td>

															<td align="left"><select class="cmb_medium"
																name="yearName" required>
																	<option value="-1">[Select Year]</option>
																	<c:forEach var="a" items="${years}">
																		<option value="${a.value}">${a.yearName}</option>
																	</c:forEach>
															</select>
															<span class="star"> *</span>
															</td>
														</tr>

														<tr>
															<td></td>
														</tr>

														

															
														
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">Advice Type</td>

															<td align="left"><select class="cmb_medium"
																name="sysPaymentmodeid" required>
																	<option value="-1">[Select Payment Mode]</option>
																		<c:forEach var="c" items="${paymentModeList}">
																		<option value="${c.sysPaymentmodeid}">
																		${c.paymentmode}
																			</option>
																	</c:forEach>
															</select>
															<span class="star"> *</span>
															</td>
														</tr>

														<tr>
															<td></td>
														</tr>



														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td colspan="5" align="center" valign="top"
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

</html>l>