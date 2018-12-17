<%--
==========================================================================
 * Description 	: 
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
<title>U.P JAL NIGAM-Emp Wise-DA Arrear Form</title>
<script type="text/javascript">
	
</script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
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

			<form action="/UPJN/empwiseDAArrear">

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
															<td class="table_head" colspan="4">DA Arrear -
																Employee Wise</td>
														</tr>

														<tr>
															<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
															<td align="right" class="error_normal">* Fields are
																required</td>
														</tr>

														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="center" valign="top" class="cell_bg">
																Employee Code</td>
															<td align="left" valign="middle" class="cell_bg">																															
																			<input type="text" class="txt_small" name="employeecode"
																				size="30" maxlength="8" />
																	<span class="star"> *</span>	</td>
														</tr>
														<tr>
															<td></td>
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
																	<option value="2013-2014">2013-2014</option>
																	<option value="2014-2015">2014-2015</option>
																	<option value="2015-2016">2015-2016</option>
																	<option value="2016-2017">2016-2017</option>
																	<option value="2017-2018">2017-2018</option>
																	<option value="2018-2019">2018-2019</option>
																	<option value="2019-2020">2019-2020</option>
															</select> <span class="star"> *</span></td>
														</tr>
														
														<tr>
															<td></td>
														</tr>

														<tr>
															<td></td>
														</tr>
														

														<!-- <tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">From
																(Starting Date)</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" name="startDate" class="txt_date" />
																<a href="javascript:;"
																onclick="displayCalendar(document.forms[0].startDate,'dd/mm/yyyy', document.forms[0].startDate);">
																	<img height="16" hspace="0"
																	src="resources/images/calendar-icon.gif" width="16"
																	border="0" />
															</a> <span class="star">*</span>
														</tr>


														<tr>
															<td></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">To
																(End Date)</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" name="endDate" class="txt_date" />
																<a href="javascript:;"
																onclick="displayCalendar(document.forms[0].endDate,'dd/mm/yyyy', document.forms[0].endDate);">
																	<img height="16" hspace="0"
																	src="resources/images/calendar-icon.gif" width="16"
																	border="0" />
															</a> <span class="star">*</span>
														</tr>
 -->

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