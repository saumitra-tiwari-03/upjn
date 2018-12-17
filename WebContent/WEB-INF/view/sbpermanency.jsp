

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>



<html>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM-SB Permanency</title>

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

</head>


<script type="text/javascript" language="Javascript1.1"> 

 </script>




<form  action="/UPJN/UpdatePermanency" onsubmit="javascript:return cutomValidation(this)">
	<input type="hidden" name="ppEmployeemasterid" value="${ppEmployeemasterid}">
	
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top" class="msg">
					 
				</td>
			</tr>
			<tr>
				<td valign="top" class="error">					
					
			</td>
			</tr>
			<tr>
			<td valign="top">
				<table width="90%" align="center" cellpadding="0" cellspacing="0" border="0">
					<tr>
						<td valign="top">
							<table width="100%" align="center" cellpadding="0" cellspacing="0" border="0" class="table_bg">
								<tr>
									<td valign="top">
										<table width="100%" align="center" class="cell_bg" cellpadding="0" cellspacing="1" border="0">
											<tr>
												<td width="95%" align="left" valign="top" class="table_head">
													Service Book - Permanency 
												</td>
												

											</tr>
											<tr>


										</table>
										<table width="100%" align="center" class="cell_bg" cellpadding="0" cellspacing="1" border="0">	
										  <tr>
											<td colspan="4">&nbsp;
											</td>
										  </tr>
										  <tr>
											 <td colspan="2" valign="middle" class="tabdefault" bgcolor="#FFFFFF" width="50%"> <strong>Permanency Details</strong></td>
											 <td colspan="2" valign="middle" class="tabdefault" bordercolor="#4390E0" bgcolor="#4390E0" width="50%">
												<strong><a
												href="/UPJN/confirmationEmployeeDetails?ppEmployeemasterid=<c:out value="${ppEmployeemasterid}"/>"><u>Confirmation Details</u>
													</a></strong>
											</td>
										  </tr>
										  <tr>
											<td colspan="4" valign="top" class="cell_bg">&nbsp;</td>
										  </tr>					  
										</table>

										<!-- Inner Table No 2	-->
										
										<table border="0" cellpadding="0" cellspacing="0" width="100%">
										<tr>
										  <!-- fwtable fwsrc="login_main.png" fwbase="login_main.jpg" fwstyle="Dreamweaver" fwdocid = "119018000" fwnested="1" -->
										  <td  colspan="3" valign="middle" align="right" class="error_normal" align="right">
										  * Fields are required.
										  </td>
														
										  <tr>
											<td valign="top"><table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
											  <tr>
												<td align="center" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
												  <tr>
													<td valign="top" align="center"><table width="70%" border="0" cellspacing="1" cellpadding="1">
														<tr>
														  <td valign="top" class="table_bg"><table width="100%" border="0" cellspacing="1" cellpadding="3">																
																<tr>
																  <td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
																</tr>
																<tr>
																  <td valign="top" class="cell_bg">&nbsp;</td>
																  <td align="left" valign="top" class="cell_bg">
																  Employee Code
																  
	                                                              <td width="54%" align="left" valign="top" class="cell_bg">
		                                                          <c:forEach items="${list}" var="a">
                                                                     ${a.employeecode}</c:forEach> 		
	                                                                 </td>
																	
																  </tr>
																<tr>
																  <td valign="top" class="cell_bg">&nbsp;</td>
																  <td align="left" valign="top" class="cell_bg">
																  Employee Name
																  </td>
																  <td align="left" valign="top" class="cell_bg">
                                                                  <c:forEach items="${list}" var="a">
                                                                 ${a.employeename}</c:forEach> 	
	                                                             </td>																
																  </tr>
																<tr>
																  <td width="3%"  valign="top" class="cell_bg">&nbsp;</td>
																  <td  align="left" valign="top" class="cell_bg">
																  Employee Designation
																  </td>
																  <td  align="left" valign="middle" class="cell_bg" >
																<c:forEach items="${list}" var="a">
                                                                  ${a.employeedesignation}</c:forEach> 	</td>
																		
																	
																</tr>
																
																
																
																<tr><td colspan="3" class="cell_bg"></td></tr>
																
																
																<tr>
											<td valign="top" class="cell_bg">&nbsp;</td>
											<td align="left" valign="top" class="cell_bg">
												  Whether Permanent</td>
											<td align="left" valign="top" class="cell_bg">
												<input type="radio" name="isPermanent" value="true">Yes
												<input type="radio" name="isPermanent" value="false">No
												<span class="star">*</span>
											</td>
										</tr>
																
																<tr>
																  <td valign="top" class="cell_bg">&nbsp;</td>
																  <td align="left" valign="top" class="cell_bg">
																  Order No.		
																   </td>
																  <td align="left" valign="top" class="cell_bg">
																  <input type="text" name="PERMANENTORDERNO" maxlength="50" size="50" value="" class="txt_medium">
																	<span class="star">*[Max 50 char.]</span> </td>
																  </tr>
																  
																  	<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

																 Order Date 
															(dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date" name="PERMANENTORDERDATE"
																size="11" maxlength="10" readonly="readonly" required><a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].PERMANENTORDERDATE,'dd/mm/yyyy', document.forms[0].PERMANENTORDERDATE);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
														</tr>
																  
															
																<tr>
																  <td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
																</tr>
																<tr>
																	<td colspan="1" align="center" valign="top" class="cell_bg">&nbsp;</td>
																	<td colspan="2" align="center" valign="middle" class="cell_bg">
																		<input type="submit" value="Submit" class="btn_medium">
																		<input type="reset" value="Reset" class="btn_medium">
																		 </td>
																					</tr>
																			 </table>
																			</td>
																			</tr>
																			</table>
																			</td>
																			</tr>
																			</table>
																			</td>
																			</tr>
																			</table>
																			</td>
																			</tr>
																			</table>
																			</td>
																			</tr>
																			</table>
																			</td>
																			</tr>
																			</table>
																			</td>
																			</tr>
																			</table>
																			
																		
															
			
				
				</form>
				</html>
				
				
