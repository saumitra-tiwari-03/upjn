
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM-User Page</title>

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
			<form action="">

				<table style="border: 0px solid black; width: 100%; margin-left: 50px">
					<tr>
						<td valign="top" class="msg">${mes}</td>
					</tr>
					<tr>
						<td align="left" valign="top" class="error">${app_msg}</td>
					</tr>


					<tr>
						<td valign="top"><table
								style="width: 95%; border: 0px solid black;">
								<tr>
									<td align="center" valign="top"><table
											style="width: 100%; border: 0px;">
											<tr>
												<td valign="top"><table
														style="width: 100%; border: 0px;">
														<tr>
															<td valign="top" class="table_bg"><table
																	style="width: 100%; border: 0px;">
																	<tr>


																		<td width="95%" align="left" valign="top"
																			class="table_head">
																			<font size="3">
																			Welcome
																			</font>
																			</td>

																	</tr>
																</table>
																<table style="width: 100%;" border="0">
																	<tr>
																		<td colspan="3" valign="top" class="cell_bg">&nbsp;</td>
																		<td colspan="2" valign="top" class="error_normal">
																		</td>
																	</tr>
																	<tr>
																		<td align="right" colspan="2" class="bold">
																			
																			<font size="3">
																			Employee Name : ${employee_name}
																			</font>
																			</td>
																	</tr>

																	<tr>
																		<td align="right" colspan="2" class="bold">
																		    <font size="3">
																			Designation : ${designation_}
																			</font>
																			</td>
																	</tr>
																	
																	<tr>
																		<td align="right" colspan="2" class="bold">
																		    <font size="3">
																			User ID : ${userID}
																			</font>
																			</td>
																	</tr>
																		<%-- <tr>
																		<td align="right" colspan="2" class="bold">
																			PP_Employeemasterid : ${ppEmployeemasterid}</td>
																	</tr>
																	<tr>
																		<td align="right" colspan="3" class="bold">
																			RM_OfficeID : ${rm_OfficeID}</td>
																	</tr> --%>
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
