

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>



<html>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM-Employee Training </title>

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
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
	
	<script type="text/javascript">
	
    $(document).ready(sortDropDownListByText);
</script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

</head>


<script type="text/javascript" language="Javascript1.1"> 

 </script>

<form  action="/UPJN/saveEmployeeTrainingRecord" onsubmit="javascript:return cutomValidation(this)">
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
			<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center" valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td valign="top" align="center">
									<table width="70%" border="0" cellspacing="1" cellpadding="1">
										<tr>
											<td valign="top" class="table_bg">
												<table width="100%" border="0" cellspacing="1" cellpadding="3">                      
													<tr>
														<td width="95%" align="left" valign="top" class="table_head">
															Service Book - Add Training Details 
														</td>
														<td align="center" valign="middle" class="table_head">
															<a href="/upjn3/SearchEmployee.do?method=searchEmployeeSB"><img src="images/cross.jpeg" height="16" width="16" border="0" hspace="0"></a>
														</td>	
													</tr>
												</table>
												<table width="100%" border="0" cellspacing="1" cellpadding="3">
													<td  colspan="3" valign="middle" align="right" class="error_normal" align="right">
														* Fields are required.
														
													
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
                                                                  ${a.designation}</c:forEach> 	</td>
																 </tr>
																



                             <tr>
											<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
											<td width="43%" align="left" valign="top" class="cell_bg">
												Training Name 
											</td>
											<c:choose>
											<c:when test="${employeeTrainingInfoList!=null}">
											<td align="left" valign="top" class="cell_bg">
												<select name="ppTrainingtypemasterid" class="cmb_medium">
												<c:forEach items="${employeeTrainingInfoList}" var="a">
												<option>${a.ppTrainingtypemasterid}</option>
												</c:forEach> 
												<c:forEach var="ts" items="${trainingTypeMap}">
                                                          <option value="${ts.key}">${ts.value}</option>
													   </c:forEach>
                                              </select>
													<span class="star">*</span>
											</td>
											
											
											</c:when>
											<c:otherwise>
											<td align="left" valign="top" class="cell_bg">
												<select name="ppTrainingtypemasterid" class="cmb_medium">
												
												<option value="-1">[Training Status]</option>
												<c:forEach var="ts" items="${trainingTypeMap}">
                                                          <option value="${ts.key}">${ts.value}</option>
													   </c:forEach>
                                              </select>
													<span class="star">*</span>
											</td>
											
											</c:otherwise>
											</c:choose>
										
										</tr>

			
													<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
														<c:choose>
											<c:when test="${employeeTrainingInfoList!=null}">
											
											<td align="left" valign="top" class="cell_bg">

																Training Start Date
															(dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg">
															<c:forEach items="${employeeTrainingInfoList}" var="a">
															<input
																type="text" class="txt_date" name="trainingstartdate" value="${a.trainingstartdate}"
																size="11" maxlength="10" readonly="readonly">
																</c:forEach>
																<a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].trainingstartdate,'dd/mm/yyyy', document.forms[0].trainingstartdate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
											</c:when>
											<c:otherwise>
											
															<td align="left" valign="top" class="cell_bg">

																Training Start Date
															(dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date" name="trainingstartdate" 
																size="11" maxlength="10" readonly="readonly"><a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].trainingstartdate,'dd/mm/yyyy', document.forms[0].trainingstartdate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
											</c:otherwise>
											</c:choose>
														
														</tr>
													
													
													<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

															Training End Date
															(dd/mm/yyyy)</td>
										<c:choose>
										<c:when test="${employeeTrainingInfoList!=null}">
										<td align="left" valign="top" class="cell_bg">
										<c:forEach items="${employeeTrainingInfoList}" var="a">
										<input
													value="${a.trainingenddate}"			type="text" class="txt_date" name="trainingenddate"
																size="11" maxlength="10" readonly="readonly">
																
												</c:forEach>				
																<a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].trainingenddate,'dd/mm/yyyy', document.forms[0].trainingenddate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
										</c:when>
										<c:otherwise>
										<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date" name="trainingenddate"
																size="11" maxlength="10" readonly="readonly"><a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].trainingenddate,'dd/mm/yyyy', document.forms[0].trainingenddate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
										</c:otherwise>
										</c:choose>					
															
														</tr>
													
													
													
														
																<tr>
											<td valign="top" class="cell_bg">&nbsp;</td>
											<td align="left" valign="top" class="cell_bg">
												  Training Abroad</td>
											<td align="left" valign="top" class="cell_bg">
											<c:choose>
											<c:when test="${employeeTrainingInfoList!=null}">
											<c:forEach items="${employeeTrainingInfoList}" var="a">
											
											${a.isabroad}											
											<c:if test="${a.isabroad==1}">											
											<input type="radio" name="isabroad"  checked="checked">Yes
											<input type="radio" name="isabroad" >No
											</c:if>
											<c:if test="${a.isabroad==0}">
											<input type="radio" name="isabroad" >Yes
												<input type="radio" name="isabroad" checked="checked">No
											</c:if>
											</c:forEach>
											</c:when>
											<c:otherwise>
											<input type="radio" name="isabroad" >Yes
												<input type="radio" name="isabroad" >No
											</c:otherwise>
											</c:choose>
												
												<span class="star">*</span>
											</td>
										</tr>
													
													
													<tr>
											<td valign="top" class="cell_bg">&nbsp;</td>
											<td align="left" valign="top" class="cell_bg">
												  Departmental training</td>
											<td align="left" valign="top" class="cell_bg">
											<c:choose>
											<c:when test="${employeeTrainingInfoList!=null}">
											<c:forEach items="${employeeTrainingInfoList}" var="a">
											<c:if test="${a.isdepartmental==1}">
											<input type="radio" name="isdepartmental" value='1' checked="checked">Yes
												<input type="radio" name="isdepartmental" value='0'>No
											</c:if>
											<c:if test="${a.isdepartmental==0}">
											<input type="radio" name="isdepartmental" value='1'>Yes
												<input type="radio" name="isdepartmental" value='0' checked="checked">No
											</c:if>
											</c:forEach>
											</c:when>
											<c:otherwise>
											<input type="radio" name="isdepartmental" value='1'>Yes
												<input type="radio" name="isdepartmental" value='0'>No
											</c:otherwise>
											</c:choose>
												
												<span class="star">*</span>
											</td>
										</tr>
													
													<tr>
														<td width="3%"  valign="top" class="cell_bg">&nbsp;</td>
														<td  align="left" valign="top" class="cell_bg">
															Training venue 
														</td>
														<td  align="left" valign="middle" class="cell_bg" >
												<c:choose>
											<c:when test="${employeeTrainingInfoList!=null}">			
											<c:forEach items="${employeeTrainingInfoList}" var="a">
											<input type="text" name="trainingvenue" maxlength="50" size="30" value="${a.trainingvenue}" class="txt_medium">
											</c:forEach>
											</c:when>
											<c:otherwise>
												<input type="text" name="trainingvenue" maxlength="50" size="30" value="" class="txt_medium">
											</c:otherwise>
											</c:choose>			
															<span class="star">[Max 50 char.]</span>
														</td>
													</tr>
												
												
													<tr>
														<td width="3%"  valign="top" class="cell_bg">&nbsp;</td>
														<td  align="left" valign="top" class="cell_bg">
															Subject of training 
														</td>
														<td  align="left" valign="middle" class="cell_bg" >
								<c:choose>
											<c:when test="${employeeTrainingInfoList!=null}">			
											<c:forEach items="${employeeTrainingInfoList}" var="a">		
											<input type="text" name="trainingsubject" maxlength="100" size="30" value="${a.trainingsubject}" class="txt_medium">
											</c:forEach>
											</c:when>
											<c:otherwise>
											<input type="text" name="trainingsubject" maxlength="100" size="30" value="" class="txt_medium">
											</c:otherwise></c:choose>	
												
															<span class="star">[Max 100 char.]</span>
														</td>
													</tr>
												
												
													<tr>
														<td width="3%"  valign="top" class="cell_bg">&nbsp;</td>
														<td  align="left" valign="top" class="cell_bg">
															Training organized by 
														</td>
														<td  align="left" valign="middle" class="cell_bg" >
													
														<c:choose>
													<c:when test="${employeeTrainingInfoList!=null}">			
											<c:forEach items="${employeeTrainingInfoList}" var="a">		
											<input type="text" name="organizer" maxlength="50" size="30" value="${a.organizer}" class="txt_medium">
											</c:forEach>
											</c:when>
											<c:otherwise>
											<input type="text" name="organizer" maxlength="50" size="30" value="" class="txt_medium">
											</c:otherwise>
											</c:choose>
															<span class="star">[Max 50 char.]</span>
														</td>
													</tr>
											
											
													<tr>
																  <td valign="top" class="cell_bg">&nbsp;</td>
																  <td align="left" valign="top" class="cell_bg">
																  Order No.		
																   </td>
																  <td align="left" valign="top" class="cell_bg">
										<c:choose>
											<c:when test="${employeeTrainingInfoList!=null}">			
											<c:forEach items="${employeeTrainingInfoList}" var="a">								  
										  <input type="text" name="orderno" maxlength="50" size="50" value="${a.orderno}" class="txt_medium">
											</c:forEach>
											</c:when>
											<c:otherwise>
											  <input type="text" name="orderno" maxlength="50" size="50" value="" class="txt_medium">
											</c:otherwise>
											</c:choose>		
																	<span class="star">*[Max 50 char.]</span> </td>
																  </tr>
													
													<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

															 Order Date 
															(dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg">
										<c:choose>
											<c:when test="${employeeTrainingInfoList!=null}">			
											<c:forEach items="${employeeTrainingInfoList}" var="a">						
															<input
																type="text" class="txt_date" name="orderdate" value="${a.orderdate}"
																size="11" maxlength="10" readonly="readonly">
										</c:forEach>
											</c:when>
											<c:otherwise>
											 <input
																type="text" class="txt_date" name="orderdate" value=""
																size="11" maxlength="10" readonly="readonly">
											</c:otherwise>
											</c:choose>							
																<a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].orderdate,'dd/mm/yyyy', document.forms[0].orderdate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
														</tr>
																  
													
													<tr>
														<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
													</tr>
													<tr>
														<td colspan="5" align="center" valign="top" class="cell_bg">&nbsp;
															
															
																<input type="submit" value="Submit" class="btn_medium">	
															
															&nbsp;								
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
			<br>
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td valign="top" class="msg"></td>
					</tr>
					<tr>
						<td align="left" valign="top" class="error"></td>
					</tr>
					<tr>
						<td><table width="95%" border="0" align="center"
								cellpadding="1" cellspacing="1">
								<tr>
									<td align="center" class="table_bg" valign="top"><table
											width="100%" border="0" cellspacing="3" cellpadding="3">

											<tr>
												<td colspan="9" valign="top" class="" align="left">
													<table width="100%" align="center" class="cell_bg"
														cellpadding="3" cellspacing="3">


														<table width="100%" cellpadding="3" cellspacing="3">
														<tr>

															<td id="t"><img alt=""
																src="resources/images/sort.gif">Training Name</td>
															<td id="t"><img alt=""
																src="resources/images/sort.gif">Start Date
																Designation</td>
															<td id="t"><img alt=""
																src="resources/images/sort.gif">End Date</td>
															<td id="t"><img alt=""
																src="resources/images/sort.gif">Order No</td>
															<td id="t"><img alt=""
																src="resources/images/sort.gif">Order Date</td>
															<td id="t">Action</td>
														</tr>

														<c:forEach items="${employeeTrainingList}" var="list">
														
																<input type="hidden" id="ppEmployeetrainingid"
																	value="${list.ppEmployeetrainingid}"
																	name="ppEmployeetrainingid" />
															<tr>
															
															

																<td>${list.trainingtype}</td>
																<td>${list.trainingstartdate}</td>
																<td>${list.trainingenddate}</td>
																<td>${list.orderno}</td>
																<td>${list.orderdate}</td>
														
																<td><a
																href="/UPJN/editTrainingDetails?ppEmployeetrainingid=<c:out value="${list.ppEmployeetrainingid}"/>"><u>Edit</u></a></td>
                                                               <td><a
															    href="/UPJN/deleteTrainingDetails?ppEmployeetrainingid=<c:out value="${list.ppEmployeetrainingid}"/>"><u>Delete</u></a></td>
															</tr>
														</c:forEach>
													</table>
													</table>
												</td>
											</tr>

											<tr>

											</tr>

										</table></td>
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