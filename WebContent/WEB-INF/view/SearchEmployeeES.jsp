<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script src="resources/js/validation.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/js/popcalendar.js"></script>
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

		<div
			style="height: 100%; width: 79%; float: left; padding-top: 10px; overflow-x: auto;">
	<form method="post" action="/UPJN/EmployeeSearchList">


		<table border="0" cellpadding="0" cellspacing="0" width="100%">

			<tr>
				<td valign="top"><table width="80%" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td align="center" valign="top"><table width="100%"
									border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td valign="top"><table width="100%" border="0"
												cellspacing="1" cellpadding="1">
												<tr>
													<td valign="top" class="table_bg"><table width="100%"
															border="0" cellspacing="1" cellpadding="3">
															<tr>
																<td align="left" valign="top" class="table_head">
																	Employee Search</td>
															</tr>
														</table>
														<table width="100%" border="0" cellspacing="1"
															cellpadding="3">
															<tr>
																<td colspan="5" valign="top" class="table_bg"></td>
															</tr>
															<tr>
																<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
															</tr>
															<tr>
																<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																<td width="43%" align="left" valign="top"
																	class="cell_bg">Employee Code</td>
																<td align="left" valign="top" class="cell_bg"><input
																	type="text" name="employeecode" class="txt_medium"
																	maxlength="250">
															</tr>
															<tr>
																<td valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">
																	Employee Name</td>
																<td align="left" valign="top" class="cell_bg"><input
																	type="text" name="employeename" class="txt_medium"
																	maxlength="250"></td>
															</tr>
															<tr>
																<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																<td width="43%" align="left" valign="top"
																	class="cell_bg">Father Name</td>
																<td align="left" valign="top" class="cell_bg"><input
																	type="text" name="fathername" class="txt_medium"
																	maxlength="250">
															</tr>
															<tr>
																<td valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">
																	Date of Birth</td>
																<td align="left" valign="top" class="cell_bg"><input
																	type="text" name="dateofbirth" class="txt_medium"
																	maxlength="250">
																	<a href="javascript:;"
																						onclick="displayCalendar(document.forms[0].dateofbirth,'dd/mm/yyyy',document.forms[0].dateofbirth)">

																						<img height="16" hspace="0"
																						src="resources/images/calendar-icon.gif"
																						width="16" border="0" />
																					</a>
																	</td>
															</tr>
															
															<%-- <tr>
																<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																<td width="43%" align="left" valign="top"
																	class="cell_bg">Employee Category</td>
																<td align="left" valign="top" class="cell_bg"><select
																	name="masEmploymentsubtypeid" class="cmb_medium">
																		<option value="-1">[Select Category]</option>
																		
																			 <c:forEach items="${categorylist}" var="a">
																				<option value="${a.masEmploymentsubtypeid}">${a.employmentsubtype}</option>

																			</c:forEach> 
																		
																</select></td>
															</tr>
															<tr>
																<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">
																	Designation</td>
																<td align="left" valign="middle" class="cell_bg">

																	<select name="ppDesignationmasterid" class="cmb_medium">
																		<option value="-1">[Select Designation]</option>

																		<c:forEach items="${designationlist}" var="a">
																			<option value="${a.ppDesignationmasterid}">${a.designation}</option>

																		</c:forEach>

																</select>

																</td>
															</tr> --%>
															<tr>
																<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
															</tr>
															<tr>
																<td colspan="5" align="center" valign="top"
																	class="cell_bg"><input type="submit"
																	class="btn_medium" value="Submit" /> <input
																	type="reset" class="btn_medium" value="Reset" /></td>
															</tr>
														</table></td>
												</tr>
											</table></td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height="30" valign="top">&nbsp;</td>
			</tr>
		</table>
	</form>
	</div>
</div>	
</body>
</html>