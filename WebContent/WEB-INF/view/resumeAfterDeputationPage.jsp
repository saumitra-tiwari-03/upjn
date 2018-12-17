	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
		<title>U.P JAL NIGAM -Resume After Deputation Page</title>
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
	
<script type="text/javascript">

function validatedetails(){
	 var orderNumberForJoinUpjn = document.getElementById("orderNumberForJoinUpjn").value;
	 if (orderNumberForJoinUpjn == "") {
			alert("Please fill 'Order Number For Join Upjn'");
			return false;
		}
	 var dateOfResuming = document.getElementById("dateOfResuming").value;
	 if (dateOfResuming == "") {
			alert("Please fill 'Date Of Resuming'");
			return false;
		}
}
</script>


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
  		<form action="/UPJN/saveResumeAfterDeputationRecord" method="post" onsubmit="return validatedetails()">
          <input type="hidden" name="ppEmployeemasterid" value="${ppEmployeemasterid}">
           
          
			<table cellSpacing=0 cellPadding=0 width="100%" border="0" align="center">
		
								<tr>
					<td valign="top" class="msg">
					${app_msg} 
						
					</td>
				</tr>
				<tr>
					<td align="left" valign="top" class="error">		
							
						
					</td>
				</tr>
				<tr>
					<td valign="top">
						<table cellSpacing=0 cellPadding=0 width="100%" align="center" border="0">					
							<tr>
								<td valign="top" align="center"><table cellSpacing=0 cellPadding=0 width="100%" border="0" align="center">					
									<tr>
										<td valign="top" align="center"><table cellSpacing=1 cellPadding=1 width="70%" border="0" align="center">
											<tr>
												<td class="table_bg" valign="top"><table cellSpacing=1 cellPadding=3 width="100%" border="0" align="center">
													<tr>
														<td class=table_head valign="top" align="left" width="95%">
														
																Resume After Deputation - Resume
															
														</td>
														<td align="center" valign="middle" class="table_head">															
														<a href="/UPJN/resumeAfterDeuptation">
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
																	Date of Relieving For Deputation
																	</td>
																<td align="left" valign="top" class="cell_bg">
																<c:forEach items="${list}" var="a">
							                                <fmt:formatDate value="${a.relievedate}" pattern="dd/MM/yyyy" />          
							                                           </c:forEach> 
																
																</td>
														
															</tr>
															
															
								<!-- Order No for join to Upjn -->
															<tr>
																<td valign="top" class="cell_bg">&nbsp;</td>
												    <td align="left" valign="top" class="cell_bg">
																	Order No for join to Upjn</td>
													<td align="left" valign="top" class="cell_bg" colspan="3">
																
												    <input type="text" class="txt_medium" name="orderNumberForJoinUpjn" maxlength="50" id="orderNumberForJoinUpjn">
																	<span class="star">*[Max 50 char.]</span>
																	</td>
																	
																	
																</tr>
																
																<tr>
														<td class="cell_bg" valign="top" colSpan=5>&nbsp;</td>
													</tr>
													<tr>
													

                               <tr>
										<td valign="top" class="cell_bg">&nbsp;</td>
										<td align="left" valign="top" class="cell_bg">
																						     
										   Date Of Resuming (dd/mm/yyyy)
										</td>
										<td align="left" valign="top" class="cell_bg">
										
											<input type="text" class="txt_date" name="dateOfResuming" id="dateOfResuming" size="11" maxlength="10" readonly="readonly" >
										<a href="javascript:;" onclick="displayCalendar(document.forms[0].dateOfResuming,'dd/mm/yyyy', document.forms[0].dateOfResuming);">
										<img alt="" src="resources/images/calendar-icon.gif" height="16" hspace="0" width="16"></a>
											<span class="star">*</span> 	
										</td>
									</tr>
													
													
													
												
													<tr>
														<td class="cell_bg" valign="top" colSpan=5>&nbsp;</td>
													</tr>
													<tr>
														<td class="cell_bg" valign="top" align="center" colSpan="5">
														<input type="submit" class="btn_medium" value="Submit" />
														<input type="reset" class="btn_medium" value="Reset" />
														
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