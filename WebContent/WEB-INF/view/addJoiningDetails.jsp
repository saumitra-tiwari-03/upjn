	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
		<title>U.P JAL NIGAM-add Joining Details</title>
		
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
	
<body style="margin:0px 0px 0px 0px;">
	
<div style="height: 100%; width: 100%;">

<div style="height:100px; width: 100%;border-bottom: gray solid 4px;">
<%@ include file="/WEB-INF/view/Header.jsp" %>
</div>

<div style="height:700px;width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px;">
<%@ include file="/WEB-INF/view/Menu.jsp" %>
</div>
				 
<div style="height: 100%; width: 79%;float: left;padding-top: 10px;">
  		<form action="/UPJN/saveRecordOfJoining" method="post">
          <input type="hidden" name="ppEmployeemasterid" value="${ppEmployeemasterid}">
           
          
			<table cellSpacing=0 cellPadding=0 width="100%" border="0" align="center">
		
								<tr>
					<td valign="top" class="msg">
						${msg}
					</td>
				</tr>
				<tr>
					<td align="left" valign="top" class="error">		
							
						
					</td>
				</tr>
				<tr>
					<td valign="top">
						<table cellSpacing="0" cellPadding="0" width="100%" align="center" border="0">					
							<tr>
								<td valign="top" align="center"><table cellSpacing=0 cellPadding=0 width="100%" border="0" align="center">					
									<tr>
										<td valign="top" align="center"><table cellSpacing=1 cellPadding=1 width="70%" border="0" align="center">
											<tr>
												<td class="table_bg" valign="top"><table cellSpacing=1 cellPadding=3 width="100%" border="0" align="center">
													<tr>
														<td class=table_head valign="top" align="left" width="95%">
														
																Joining - Add Joining Details
															
														</td>
														<td align="center" valign="middle" class="table_head">															
														<a href="/UPJN/EmployeeJoininglist">
															<img alt="" src="resources/images/cross.jpeg">
														</a></td>												
													</tr>
												</table>
												
												<table cellSpacing=1 cellPadding=3 width="100%" border="0" align="center">
													<tr>
														<td  colspan="2" valign="top" class="cell_bg">&nbsp;</td>
														<td  colspan="1" valign="middle" class="error_normal" align="right">
															* Fields are required.
														</td>
													</tr>
													<tr>
														<td class="cell_bg" valign="top" colSpan="5" align="left">
															<b>
																Joining Against-Direct
															</b>
														</td>
													</tr>
														<tr>
														<td class="cell_bg" valign="top">&nbsp;</td>
														<td class="cell_bg" valign="top" align="left">
															Employee Code
														</td>
														<td class="cell_bg" valign="top" align="left">
														<c:forEach items="${list}" var="a">
							                              ${a.employeecode}</c:forEach> 
														</td>
													</tr>
													<tr>
														<td class="cell_bg" valign="top">&nbsp;</td>
														<td class="cell_bg" valign="top" align="left">
															Employee Name
														</td>
														<td class="cell_bg" valign="top" align="left">
														 <c:forEach items="${list}" var="a">
							                                ${a.employeename}</c:forEach> 
														</td>
													</tr>
									
													<tr><td colspan="3"></td></tr>
													<tr>
														<td class="cell_bg" valign="top" width="3%">&nbsp;</td>
														<td class="cell_bg" valign="top" align="left">
															Designation
														</td>
														<td  class="cell_bg" valign="middle" align="left" >
															 <c:forEach items="${list}" var="a">
							                                 ${a.designation}</c:forEach> 
														</td>
														
													</tr>
													<tr><td colspan="3"></td></tr>
													
													
													<tr>
																<td valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">
																	Effective Date Of Appointment/Regularization
																	(dd/mm/yyyy)</td>
																<td align="left" valign="top" class="cell_bg">
																<c:forEach items="${list}" var="a">
							                                          ${a.effectivedatjoin} </c:forEach> 
																
																</td>
														
															</tr>
															
															
								<tr>
																<td valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">Date
																	of Joining (dd/mm/yyyy)</td>
																<td align="left" valign="top" class="cell_bg">
															
															<c:choose>
															  <c:when test="${list2==null}">
																<input	type="text" name="datejoining" class="txt_date" readonly="true" />
										<a href="javascript:;" onclick="displayCalendar(document.forms[0].datejoining,'dd/mm/yyyy', document.forms[0].datejoining);">
													<img height="16" hspace="0"		src="resources/images/calendar-icon.gif" width="16" border="0" />
													</a> <span class="star">*</span>					
															</c:when>	
															
															<c:otherwise>
															  <c:forEach items="${list2}" var="a">
															  <input	type="text" name="datejoining" class="txt_date" readonly="true" value="${a.datejoining}" />
										<a href="javascript:;" onclick="displayCalendar(document.forms[0].datejoining,'dd/mm/yyyy', document.forms[0].datejoining);">
													<img height="16" hspace="0"		src="resources/images/calendar-icon.gif" width="16" border="0" />
													</a> <span class="star">*</span></c:forEach></c:otherwise></c:choose>
																</td>
															</tr>
													

                               <tr>
									<td class="cell_bg" valign="top">&nbsp;</td>
												<td class="cell_bg" valign="top" align="left">
													Joining Time
										</td>
										<td  align="left" valign="middle" class="cell_bg" >
										<select id="joining_time" name="joinANFN_in"  class="cmb_medium" >
													<option selected="selected" disabled selection> Select Time</option>
                                                       <option value="Fore Noon">Fore Noon</option>
                                                       <option value="After Noon">After Noon</option>
													 <c:forEach var="d" items="${Data1}">
                                                          <option value="${d.key}">${d.value}</option>
													   </c:forEach>
													 </select>
													 
													 
													   	</td>

									</tr>
											
				
													<tr>
														<td class="cell_bg" valign="top" colSpan=5>&nbsp;</td>
													</tr>
													<tr>
														<td class="cell_bg" valign="top" align="center" colSpan="5">
														<input type="submit" class="btn_medium" value="Submit" />
																	 <input type="reset" class="btn_medium" value="Reset" />
														
														
														<!-- Changing form's action acc to action ADD/EDIT -->
															<!-- <logic:equal name="action" value="edit">
																For EDIT
																<html:submit styleClass="btn_small" >
																	<bean:message key="button.save" />				
																</html:submit>
															</logic:equal>
															<logic:equal name="action" value="add">
																For ADD
																<html:submit styleClass="btn_small" >
																	<bean:message key="button.submit" />				
																</html:submit>
															</logic:equal>

															<html:reset styleClass="btn_small"/> -->
													</td>
												</tr>					
											</table></td>
										</tr>					
									</table></td>
								</tr>
							</table></td>
						</tr>
					</table>
					<tr>
						<td valign="top" height=30>&nbsp;</td>
					</tr>
				</table>
		</form>
			 
</div>
</div>
</body>
</html>