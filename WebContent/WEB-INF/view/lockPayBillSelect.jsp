<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>U.P JAL NIGAM-Lock Pay Bill Employee List</title>
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<script type="text/javascript">
	$(document).ready(sortDropDownListByText);
</script>
<script src="./resources/js/jquery-1.11.1.js"></script>


<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script src="resources/js/validation.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/js/popcalendar.js"></script>
<script type="text/javascript" src="resources/js/NEW_NEW.js"></script>
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
			style="height: 600px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px; overflow-x: auto;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div
			style="height: 100%; width: 79%; float: left; padding-top: 10px; overflow-x: auto;">

			<form  method="post"
				action="/UPJN/getPayBillList">

				<input type="hidden" name="registerID" value="${registerID}">

				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td valign="top" class="msg">${mes}</td>
					</tr>
					<tr>
						<td valign="center" class="error"></td>
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
																		<td align="center" valign="middle" class="table_head">
																			<a href="UpdatePayDetail.do?method=begin"> <img
																				src="images/cross.jpeg" height="16" width="16"
																				border="0" hspace="0">
																		</a>
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
											Month
										</td>
										<td align="left" valign="top" class="cell_bg">
											<select name="monthName" style="width:100pt" class="cmb_small">
											<option value="-1">[Select Month]</option>
												<c:forEach var="d" items="${monthList}">
                                                          <option value="${d.monthName}">${d.value}</option>
													   </c:forEach>
													</select>
											<span class="star"> *</span>
										</td>
									</tr>
									<tr>
										<td valign="top" class="cell_bg">&nbsp;</td>
										<td align="left" valign="top" class="cell_bg">
											Year
										</td>
										<td align="left" valign="top" class="cell_bg">
											<select name="yearName" style="width:100pt" class="cmb_small">
											<option value="-1">[Select Year]</option>
												<c:forEach var="d" items="${yearList}">
                                                          <option value="${d.value}">${d.value}</option>
													   </c:forEach>
													</select>
											<span class="star"> *</span>
										</td>
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

																</table></td>
														</tr>
													</table></td>
											</tr>
										</table></td>
								</tr>
							</table> <br></td>
					</tr>
				</table>



			</form>
		</div>
	</div>

</body>


</html>