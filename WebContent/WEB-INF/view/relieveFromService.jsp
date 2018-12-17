<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="java.util.ArrayList"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM-Relieve From Service</title>

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
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<script src="<c:url value="/resources/js/upjn.js" />"></script>
<script type="text/javascript">
	$(document).ready(sortDropDownListByText);
</script>
<script type="text/javascript">
 function validatedetails(){
	 
	 var employeecode = document.getElementById("employeecode").value;
	 if (employeecode == "") {
			alert("Please fill Employee Code");
			return false;
		}
	 
	 var SUBPHASENAME = document.getElementById("SUBPHASENAME").value;
	 if (SUBPHASENAME == -1) {
			alert("Please fill Cause of Relieve");
			return false;
		}
	
	 var retirementOrderNumber = document.getElementById("retirementOrderNumber").value;
	 if (retirementOrderNumber == "") {
			alert("Please fill Retirement order Number");
			return false;
		}
	 
	 var retirementorderDate = document.getElementById("retirementorderDate").value;
	 if (retirementorderDate == "") {
			alert("Please fill Retirement Order Date ");
			return false;
		}

	 var referenceOfRelieve = document.getElementById("referenceOfRelieve").value;
	 if (referenceOfRelieve == "") {
			alert("Please fill Reference of Relieve");
			return false;
		}
	 
	 var dateOfReference = document.getElementById("dateOfReference").value;
	 if (dateOfReference == "") {
			alert("Please fill Date of Reference");
			return false;
		}

	 var dateOfEffect = document.getElementById("dateOfEffect").value;
	 if (dateOfEffect == "") {
			alert("Please fill Date of Effect");
			return false;
		}
		
	 var joining_time = document.getElementById("joining_time").value;
	 if (joining_time == -1) {
			alert("Please select Joining Time");
			return false;
		}   
                    
 }  
 </script>
<!-- <script type="text/javascript">
	function datevalidate() {
		var rod = document.getElementById("retirementorderDate").value;
		var doe = document.getElementById("dateOfEffect").value;

		if (rod > doe) {
			alert("Date of Effect should be greater than retirement order Date ");
			return false;
		} else {
			return true;
		}

	}
</script> -->
<script type="text/javascript">
	function populaterelfromservicedetails() {
		
		document.getElementById("populaterelfromservicedetails").action = "/UPJN/populateRelieveFromServiceEmployee";
		document.getElementById("populaterelfromservicedetails").Method = "POST";
		document.getElementById("populaterelfromservicedetails").submit();
	}
	</script>


<script type="text/javascript">
	/* function MM_openBrWindow(theURL,winName,features) { //v2.0
	 window.open(theURL,winName,features);
	 }	 */
</script>
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
			<form action="/UPJN/addRelieveFromServiceRecord" method="post" id="populaterelfromservicedetails"
				onsubmit="return validatedetails();">
				<input type="hidden" name="PpEmployeemasterid"
					value="${PpEmployeemasterid}">

				<table border="0" cellpadding="0" cellspacing="0" width="100%">

					<tr>
						<td valign="top" class="msg">${app_msg}</td>
					</tr>
					<tr>
						<td valign="top"><table width="90%" align="center"
								cellpadding="0" cellspacing="0" border="0">
								<tr>
									<td valign="top"><table width="100%" align="center"
											cellpadding="0" cellspacing="1" border="0" class="table_bg">
											<tr>
												<td valign="top"><table width="100%" align="center"
														class="cell_bg" cellpadding="3" cellspacing="3" border="0">
														<tr>
															<td align="left" valign="top" class="table_head"
																colspan="6">Relieve From Service - Add Relieve
																Details</td>
														</tr>
														<tr>
															<td colspan="3" valign="top" class="cell_bg">&nbsp;</td>
															<td colspan="3" valign="middle" class="error_normal"
																align="right">* Fields are required.</td>
														</tr>
														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

																Employee Code</td>
															<td align="left" valign="top" class="cell_bg" colspan="3">


																<c:choose>
																	<c:when test="${list==null}">
																		<input type="text" class="txt_medium" maxlength="16"
																			name="employeecode" id="employeecode">
																		<span class="star">*[Max 16 char.]</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${list}" var="a">
																			<input type="text" class="txt_medium" maxlength="16"
																				name="employeecode" id="employeecode" value="${a.employeecode}"
																				>
																		</c:forEach>
																	</c:otherwise>
																</c:choose> 
																
															<input type="submit" 
																class="btn_go" value="GO" onclick="return populaterelfromservicedetails()"> <span class="star">*</span>
																&nbsp;
																
																<a
																href="/UPJN/relieveFromServiceEmployeeSearch" class="bold"> <u>Select
																		Employee</u></a>	
																
																<!-- <input type="submit" class="btn_go" value="GO">
																<span class="star">*</span> &nbsp; <a
																href="/UPJN/relieveFromServiceEmployeeSearch"
																onclick="return hs.htmlExpand(this, { objectType: 'iframe' } )">
																	Select Employee </a> -->
															</td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">
																Employee Name</td>
															<td class="cell_bg" valign="top" align="left"><c:forEach
																	items="${list}" var="a">
							                                ${a.employeename}</c:forEach></td>
														</tr>
														<tr>
															<td class="cell_bg" valign="top" width="3%">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">
																Employee Designation</td>
															<td class="cell_bg" valign="middle" align="left"><c:forEach
																	items="${list}" var="a">
							                                 ${a.designation}</c:forEach></td>

														</tr>


														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="bold" valign="top" align="center" width="43%">
																Cause of Relieve</td>
															<td align="left" valign="middle" class="cell_bg"><select
																id="SUBPHASENAME" name="SUBPHASENAME" class="cmb_medium">
																	<option value="-1">[Cause of Relieve]</option>
																	<c:forEach var="d" items="${Data}">
																		<option value="${d.key}">${d.value}</option>
																	</c:forEach>
															</select></td>
														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">
																Retirement Order No.</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_medium"
																name="retirementOrderNumber" id="retirementOrderNumber" size="11" maxlength="50"
																> <span class="star">*[Max 50
																	char.]</span></td>
														</tr>
														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

																Retirement Order Date (dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date" name="retirementorderDate"
																id="retirementorderDate" size="11" maxlength="10"
																readonly="readonly" > <a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].retirementorderDate,'dd/mm/yyyy', document.forms[0].retirementorderDate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
														</tr>

														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">

																Reference of Relieve</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_medium" name="referenceOfRelieve" id="referenceOfRelieve"
																size="20" maxlength="30" > <span
																class="star">*[Max 80 char.]</span></td>
														</tr>

														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">Date
																Of Reference (dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date" name="dateOfReference" id="dateOfReference"
																size="11" maxlength="10" readonly="readonly" >
																<a href="javascript:;"
																onclick="displayCalendar(document.forms[0].dateOfReference,'dd/mm/yyyy', document.forms[0].dateOfReference);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
														</tr>


														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">Date
																of Effect</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date" name="dateOfEffect"
																id="dateOfEffect" size="11" maxlength="10"
																readonly="readonly" > <a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].dateOfEffect,'dd/mm/yyyy', document.forms[0].dateOfEffect);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
														</tr>


														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">
																Joining Time</td>
															<td align="left" valign="middle" class="cell_bg"><select
																id="joining_time" name="relieveanfn" class="cmb_medium">
																	<option selected="selected" disabled value="-1" >
																		Select Time</option>
																	<option value="FN">FN</option>
																	<option value="AN">AN</option>
																	<c:forEach var="d" items="${Data1}">
																		<option value="${d.key}">${d.value}</option>
																	</c:forEach>
															</select></td>

														</tr>


														<tr>
															<td class="cell_bg" valign="top" colSpan=5>&nbsp;</td>
														</tr>
														<tr>
															<td class="cell_bg" valign="top" align="center"
																colSpan="5"><input type="submit" class="btn_medium"
																value="Submit" /> <input type="reset" class="btn_medium"
																value="Reset" /></td>
														</tr>
													</table></td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table>
				<br>

			</form>
		</div>
	</div>
</body>
</html>