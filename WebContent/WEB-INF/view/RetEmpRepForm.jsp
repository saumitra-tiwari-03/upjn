<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM-Retired Employee Report Form</title>
<script type="text/javascript">
	
</script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script src="resources/js/validation.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/js/popcalendar.js"></script>
<script type="text/javascript"
	src="resources/js/New_Appointment_validation.js"></script>
<script type="text/javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
	<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<script src="<c:url value="/resources/js/upjn.js" />"></script>

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

			<form action="/UPJN/RetiredEmpReport">

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

															<td class="table_head" colspan="4">Report - Employee
																Search</td>
														</tr>

														<tr>
															<td></td>
														</tr>
														<tr>
															<td></td>
														</tr>
														<tr>
															<td></td>
														</tr>


														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">Employee
																Code</td>

															<td align="left" valign="top" class="cell_bg" colspan="3">

																<input type="text" class="txt_medium"
																name="empcode" id="empcode">

															</td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">First
																Name</td>

															<td align="left" valign="top" class="cell_bg" colspan="3">

																<input type="text" class="txt_medium" name="firstName"
																id="firstName">

															</td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">Last
																Name</td>

															<td align="left" valign="top" class="cell_bg" colspan="3">

																<input type="text" class="txt_medium" name="lastName"
																id="lastName">

															</td>
														</tr>

														<tr>
															<td></td>
														</tr>

<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">Designation</td>

															<td align="left" valign="top" class="cell_bg" colspan="3">

																<select id="pp_DesignationMasterID"
																name="designationid" class="cmb_medium">
																	<option value="-1">[Select Designation]</option>
																	<c:forEach var="d" items="${designationlist}">
																		<option value="${d.ppDesignationmasterid}">${d.designation}</option>
																	</c:forEach>
															</select>

															</td>
														</tr>
														
														<tr>
															<td></td>
														</tr>

														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">Relieve After Date</td>

															<td><input type="text" name="relieveafterdate"
																size="5"> <a href="javascript:;"
																onclick="displayCalendar(document.forms[0].relieveafterdate,'dd/mm/yyyy',document.forms[0].relieveafterdate)">
																	<img height="16" hspace="0"
																	src="resources/images/calendar-icon.gif" width="16"
																	border="0" />
															</a> </td>
														</tr>
														<tr>
															<td></td>
														</tr>

														

														<tr>
															<td></td>
														</tr>

														


													 	
		
														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td colspan="5" align="center" valign="top"
																class="cell_bg"><input type="submit" value="Search"
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