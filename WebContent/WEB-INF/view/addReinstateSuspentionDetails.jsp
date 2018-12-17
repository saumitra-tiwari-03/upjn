<!--
	@author: Vikas Singh
	@Date : 30-01-2016
	@updated by : 
	@updated on : 
-->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="java.util.ArrayList"%>
<html>
<head>

<title>U.P JAL NIGAM-add Reinstate Suspension Details</title>


<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Re-Instate Suspension Details</title>

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
	$(document).ready(function(){
		$("#hm").val($("#Officelevelid").val());
		$("#district_edit").val($("#districtid").val());
		$("#hmap").val($("#officeid").val());
		district
	});
</script>


<script type="text/javascript">
function validatedetails(){
	var officelevel = document.getElementById("hm").value;
	 if (officelevel == -1) {
			alert("Please fill Office Level");
			return false;
		}
	 var district = document.getElementById("district").value;
	 if (district == -1) {
			alert("Please fill District");
			return false;
		}
	 var officename = document.getElementById("hmap").value;
	 if (officename == -1) {
			alert("Please fill office Name");
			return false;
		}
	 var reInstateOrderNo = document.getElementById("reInstateOrderNo").value;
	 if (reInstateOrderNo == "") {
			alert("Please fill Reinstate Order No.");
			return false;
		}
	 var reinstateSuspensionOrddate = document.getElementById("reinstateSuspensionOrddate").value;
	 if (reinstateSuspensionOrddate == "") {
			alert("Please fill Reinstate Order Date");
			return false;
		}
	 var reinstateeffectdate = document.getElementById("reinstateeffectdate").value;
	 if (reinstateeffectdate == "") {
			alert("Please fill Date of Effect of Re-Instate");
			return false;
		}
	 var reasonForSuspension = document.getElementById("reasonForSuspension").value;
	 if (reasonForSuspension == "") {
			alert("Please fill Re-instate Order Detail");
			return false;
		} 
}

</script>


<script type="text/javascript">
	/* function MM_openBrWindow(theURL,winName,features) { //v2.0
	 window.open(theURL,winName,features);
	 }	*/
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
			<form action="/UPJN/saveRecordofReinstateEmployeeSuspension"
				method="post" onsubmit="return validatedetails()">
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
																colspan="6">Re-instate Suspension - Add Re-instate
																Details</td>
														</tr>
														<tr>
															<td colspan="3" valign="top" class="cell_bg">&nbsp;</td>
															<td colspan="3" valign="middle" class="error_normal"
																align="right">* Fields are required.</td>
														</tr>
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">
																Employee Code</td>
															<td class="cell_bg" valign="top" align="left"><c:forEach
																	items="${list}" var="a">
	                                                         ${a.employeecode}</c:forEach></td>
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
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">
																Suspension Order No.</td>

															<td class="cell_bg" valign="middle" align="left"><c:forEach
																	items="${list}" var="a">
	                                                       ${a.suspensionordno}</c:forEach></td>

														</tr>
														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

																Suspension Order Date (dd/mm/yyyy)</td>
															
															<td class="cell_bg" valign="middle" align="left"><c:forEach
																	items="${list}" var="a">
	                                                       <fmt:formatDate value="${a.suspensionorddate}" pattern="dd/MM/yyyy"/> </c:forEach></td>

														</tr>
														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

																Effective Date of Suspension (dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><c:forEach
																	items="${list}" var="a">
																	<fmt:formatDate value="${a.effectivedate}" pattern="dd/MM/yyyy"/>
	                               </c:forEach></td>
														</tr>
														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">

																Ordering Authority Name</td>
															<td align="left" valign="top" class="cell_bg"><c:forEach
																	items="${list}" var="a">
	                                ${a.orderauthname}</c:forEach></td>
														</tr>
														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">Ordering
																Authority's Designation</td>
															<td align="left" valign="top" class="cell_bg"><c:forEach
																	items="${list}" var="a">
	                                ${a.orderauthdesig}</c:forEach></td>
														</tr>

														<tr>
															<td align="left" colspan="3" class="bold">Attached
																with Office</td>
														</tr>
                     <tr>
                     <td>
      
                     <input type="hidden" id="Officelevelid" value="${Officelevelid}">
                      <input type="hidden" id="districtid" value="${districtid}">
                      <input type="hidden" id="officeid" value="${rmofficeid}">
                     </td>
                     </tr>


														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="" valign="top" align="left" width="43%">
																Office Level</td>
															<td class="cell_bg" valign="top" align="left"><select
																id="hm" name="mas_OfficeLevelID" class="cmb_medium">
																	<option value="-1">[Select Level]</option>
																	<c:forEach var="d" items="${Data}">
																		<option value="${d.key}">${d.value}</option>
																	</c:forEach>
															</select></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="" valign="top" align="left" width="43%">
																District</td>
															<td align="left" valign="middle" class="cell_bg"><select
																id="district_edit" name="mas_DistrictID" class="cmb_medium">
																	<option value="-1">[Select District]</option>
																	<c:forEach var="d" items="${Data1}">
																		<option value="${d.key}">${d.value}</option>
																	</c:forEach>
															</select></td>

														</tr>
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="" valign="top" align="left" width="43%">
																Office Name</td>
															<td class="cell_bg" valign="top" id="officename"
																align="left"><select id="hmap" name="rm_OfficeID"
																class="cmb_medium">
																	<option value="-1">[Select Office Name]</option>
																	<c:forEach var="d" items="${officename}">
																		<option value="${d.key}">${d.value}</option>
																	</c:forEach>
															</select></td>
														</tr>


														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">
																Re-instate Order No.</td>
															<td align="left" valign="top" class="cell_bg"><input 
																type="text" class="txt_medium" name="reInstateOrderNo" id="reInstateOrderNo"
																size="11" maxlength="50"> <span class="star">*[Max
																	50 char.]</span></td>
														</tr>

														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

																Re-instate Order Date (dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date"
																name="reinstateSuspensionOrddate" size="11" id="reinstateSuspensionOrddate"
																maxlength="10" readonly="readonly"> <a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].reinstateSuspensionOrddate,'dd/mm/yyyy', document.forms[0].reinstateSuspensionOrddate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
														</tr>

														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">Date
																of Effect of Re-instate</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date" name="reinstateeffectdate" id="reinstateeffectdate"
																size="11" maxlength="10" readonly="readonly"> <a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].reinstateeffectdate,'dd/mm/yyyy', document.forms[0].reinstateeffectdate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
														</tr>


														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">Re-instate
																Order Detail</td>
															<td align="left" valign="top" class="cell_bg"><textarea
																	class="txtarea_small" name="reasonForSuspension" id="reasonForSuspension"
																	 maxlength="150"></textarea> <span
																class="star">*[Max 150 char.]</span></td>
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
														<tr>
															<td colspan="1" align="right" valign="top"
																class="cell_bg"></td>
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

