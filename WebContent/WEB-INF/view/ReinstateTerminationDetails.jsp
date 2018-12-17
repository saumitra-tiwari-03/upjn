<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM-Reinstate Termination Details</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script src="resources/js/validation.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/js/popcalendar.js"></script>
<script type="text/javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
<script type="text/javascript">
function validatedetails(){
	
	 var reinstateeffectdate = document.getElementById("reinstateeffectdate").value;
	 if (reinstateeffectdate == "") {
			alert("Please fill Date of Effect of Re-Instate");
			return false;
		}
	 var reinstateorderdetail = document.getElementById("reinstateorderdetail").value;
	 if (reinstateorderdetail == "") {
			alert("Please fill Re-instate Order Detail");
			return false;
		} 
}

reinstateeffectdate,reinstateorderdetail
</script>	
	
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
			<form action="/UPJN/ReinstateTermination" method="post">

				<table style="border: 0px; width: 100%; margin-left: 5%">

					<tr>
						<td align="left" valign="top" class="msg">${msg}</td>
					</tr>
					<tr>
						<td align="left" valign="top" class="error">${error}</td>
					</tr>

					<tr>
						<td valign="top"><table style="width: 90%; border: 0px;">
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
																			class="table_head">Re-instate Termination - Add
																			Re-instate Details</td>

																	</tr>
																</table>
																<table style="width: 100%; border: 0px;">
																	<tr>
																		<td colspan="6" valign="top" class="cell_bg">&nbsp;</td>
																		<td colspan="2" valign="top" class="error_normal">
																			* Fields are required.</td>
																	</tr>

																	<tr>
																		<td align="left" colspan="3" class="bold"></td>
																	</tr>

																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td width="43%" align="left" valign="top"
																			class="cell_bg">Employee Code</td>

																		<td align="left" valign="top" class="cell_bg"
																			colspan="3"><c:forEach items="${list}" var="a">
										<input type="hidden" name="employeecode" value="${a.employeecode}">
										<input type="hidden" name="ppEmployeemasterid" value="${a.ppEmployeemasterid}">
										<input type="hidden" name="ppTerminationdetailid" value="${a.ppTerminationdetailid}">
										${a.employeecode}				
																					</c:forEach></td>
																	</tr>

																	<tr>
																		<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
																	</tr>

																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td width="43%" align="left" valign="top"
																			class="cell_bg">Employee Name</td>

																		<td align="left" valign="top" class="cell_bg"
																			colspan="3"><c:forEach items="${list}" var="a">
										<input type="hidden" name="employeename" value="${a.employeename}">	${a.employeename}					
																					</c:forEach></td>
																	</tr>
																	<tr>
																		<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
																	</tr>
																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td width="43%" align="left" valign="top"
																			class="cell_bg">Employee Designation</td>

																		<td align="left" valign="top" class="cell_bg"
																			colspan="3"><c:forEach items="${list}" var="a">
																<input type="hidden" name="designation" value="${a.designation}">					
																						${a.designation}					
																					</c:forEach></td>
																	</tr>
																	<tr>
																		<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
																	</tr>

																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td width="43%" align="left" valign="top"
																			class="cell_bg">Termination Order No.</td>

																		<td align="left" valign="top" class="cell_bg"
																			colspan="3"><c:forEach items="${list}" var="a">
															<input type="hidden" name="terminationordno" value="${a.terminationordno}">		
																								${a.terminationordno}			
																					</c:forEach></td>
																	</tr>
																	<tr>
																		<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
																	</tr>

																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td width="43%" align="left" valign="top"
																			class="cell_bg">Termination Order Date</td>

																		<td align="left" valign="top" class="cell_bg"
																			colspan="3"><c:forEach items="${list}" var="a">
														<input type="hidden" name="terminationorddate" value="${a.terminationorddate}">				
																<fmt:formatDate value="${a.terminationorddate}" pattern="dd/MM/yyyy"/>		
																					</c:forEach></td>
																	</tr>

																	<tr>
																		<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
																	</tr>

																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td width="43%" align="left" valign="top"
																			class="cell_bg">Effective date of Termination</td>

																		<td align="left" valign="top" class="cell_bg"
																			colspan="3"><c:forEach items="${list}" var="a">
															<input type="hidden" name="effectivedate" value="${a.effectivedate}">
															<fmt:formatDate value="${a.effectivedate}" pattern="dd/MM/yyyy"/>
																					</c:forEach></td>
																	</tr>

																	<tr>
																		<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
																	</tr>

																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td width="43%" align="left" valign="top"
																			class="cell_bg">Ordering Authority Name</td>

																		<td align="left" valign="top" class="cell_bg"
																			colspan="3"><c:forEach items="${list}" var="a">
														<input type="hidden" name="orderauthname" value="${a.orderauthname}">					
																								${a.orderauthname}			
																					</c:forEach></td>
																	</tr>
																	<tr>
																		<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
																	</tr>

																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td width="43%" align="left" valign="top"
																			class="cell_bg">Ordering Authority Designation</td>

																		<td align="left" valign="top" class="cell_bg"
																			colspan="3"><c:forEach items="${list}" var="a">
													<input type="hidden" name="orderauthdesig" value="${a.orderauthdesig}">						
																								${a.orderauthdesig}			
																					</c:forEach></td>
																	</tr>

																	<tr>
																		<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
																	</tr>
																	
																	
																	<tr>
									<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td width="43%" align="left" valign="top"
																			class="cell_bg">Date of Effect of Re-instate</td>
									<td align="left" valign="top" class="cell_bg"><input
										type="text" class="txt_date" name="reinstateeffectdate" id="reinstateeffectdate"
										readonly="readonly" > <a href="javascript:;"
										onclick="displayCalendar(document.forms[0].reinstateeffectdate,'dd/mm/yyyy',document.forms[0].reinstateeffectdate)">
											<img height="16" hspace="0"
											src="resources/images/calendar-icon.gif" width="16"
											border="0" />
									</a> <span class="star">*</span></td>
								</tr>

							
																	<tr>
																		<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
																	</tr>

																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td width="43%" align="left" valign="top"
																			class="cell_bg">Re-instate Order Detail</td>

																		<td align="left" valign="top" class="cell_bg"
																			colspan="3"><textarea rows="" cols=""
																				name="reinstateorderdetail" id="reinstateorderdetail"></textarea></td>
																	</tr>


																	<tr>
																		<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
																	</tr>

																	<tr>

																		<td colspan="5" align="center" valign="top"
																			class="cell_bg"><input type="submit"
																			class="btn_medium" value="Submit" /> <input
																			type="reset" class="btn_medium" value="Reset" /></td>
																	</tr>
																</table>
													</table>
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