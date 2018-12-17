
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="java.util.ArrayList"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM-Employee Suspension Details</title>

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
<script type="text/javascript" src="resources/js/jquery-latest.js"></script>
<script type="text/javascript" src="resources/js/tablesorter.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#myTable").tablesorter();
	});
</script>
<script type="text/javascript">
	$(document).ready(sortDropDownListByText);
</script>

<script type="text/javascript">
	function populateSuspensionDetails() {

		document.getElementById("populateSuspensionDetails").action = "/UPJN/populateemployeeSuspensionDetails";
		document.getElementById("populateSuspensionDetails").Method = "POST";
		document.getElementById("populateSuspensionDetails").submit();
	}
</script>
<script type="text/javascript">

 function validatedetails(){
	 var employeecode = document.getElementById("employeecode").value;
	 if (employeecode == "") {
			alert("Please fill Employee Code");
			return false;
		}
	 var suspensionordno = document.getElementById("suspensionordno").value;
	 if (suspensionordno == "") {
			alert("Please fill Suspension order no.");
			return false;
		}
	 var suspensionorddate = document.getElementById("suspensionorddate").value;
	 if (suspensionorddate == "") {
			alert("Please fill Suspension order date");
			return false;
		}
	 var effectivedate = document.getElementById("effectivedate").value;
	 if (effectivedate == "") {
			alert("Please fill Effective Date of Suspension");
			return false;
		}
	 var orderauthname = document.getElementById("orderauthname").value;
	 if (orderauthname == "") {
			alert("Please fill Ordering Authority Name");
			return false;
		}
	 
	 var orderauthdesig = document.getElementById("orderauthdesig").value;
	 if (orderauthdesig == "") {
			alert("Please fill Ordering Authority Designation");
			return false;
		}
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
	 var reportingdate = document.getElementById("reportingdate").value;
	 if (reportingdate == "") {
			alert("Please fill Reporting Date");
			return false;
		}
	 var reasonForSuspension = document.getElementById("reasonForSuspension").value;
	 if (reasonForSuspension == "") {
			alert("Please fill Reason For Suspension");
			return false;
		}                          
 }  

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
			<form action="/UPJN/saveRecordOfEmployeeSuspension"
				id="populateSuspensionDetails" method="post">



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
																colspan="6">Employee Suspension - Add Suspension
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
																	<c:when test="${suspentionEmployeeInfoList==null}">
																		<input type="text" class="txt_medium" maxlength="16"
																			name="employeecode" id="employeecode">
																		<span class="star">*[Max 16 char.]</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${suspentionEmployeeInfoList}"
																			var="a">
																			<input type="text" class="txt_medium" maxlength="16"
																				name="employeecode" value="${a.employeecode}"
																				id="employeecode">
																		</c:forEach>
																	</c:otherwise>
																</c:choose> <input type="submit" class="btn_go" name="method"
																value="GO" onclick="populateSuspensionDetails()">
																<span class="star">*</span> &nbsp; <a
																href="/UPJN/suspensionEmployeeSearch" class="bold">
																	<u>Select Employee</u>
															</a>
															</td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">
																Employee Name</td>
															<td class="cell_bg" valign="top" align="left"><c:forEach
																	items="${suspentionEmployeeInfoList}" var="a">
							                                ${a.employeename}</c:forEach></td>
														</tr>
														<tr>
															<td class="cell_bg" valign="top" width="3%">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">
																Employee Designation</td>
															<td class="cell_bg" valign="middle" align="left"><c:forEach
																	items="${suspentionEmployeeInfoList}" var="a">
							                                 ${a.designation}</c:forEach></td>

														</tr>
														<!-- <td colspan="3" class="cell_bg"></td>
									</tr>	 -->
														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">
																Suspension Order No.</td>
															<td align="left" valign="top" class="cell_bg"><c:choose>
																	<c:when test="${suspentionEmployeeInfo==null}">
																		<input type="text" class="txt_medium" maxlength="16"
																			name="suspensionordno" id="suspensionordno">
																		<span class="star">*[Max 16 char.]</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${suspentionEmployeeInfo}" var="a">
																			<input type="text" class="txt_medium" maxlength="16"
																				name="suspensionordno" id="suspensionordno"
																				value="${a.suspensionordno}">
																		</c:forEach>
																	</c:otherwise>
																</c:choose></td>
														</tr>
														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

																Suspension Order Date (dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><c:choose>
																	<c:when test="${suspentionEmployeeInfo==null}">
																		<input type="text" class="txt_date"
																			name="suspensionorddate" id="suspensionorddate"
																			size="11" maxlength="10" readonly="readonly">
																		<a href="javascript:;"
																			onclick="displayCalendar(document.forms[0].suspensionorddate,'dd/mm/yyyy', document.forms[0].suspensionorddate);">
																			<img alt="" src="resources/images/calendar-icon.gif"
																			height="16" hspace="0" width="16">
																		</a>
																		<span class="star">*[Max 16 char.]</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${suspentionEmployeeInfo}" var="a">
																			<input type="text" class="txt_medium" maxlength="16"
																				name="suspensionorddate" id="suspensionorddate"
																				value='<fmt:formatDate value="${a.suspensionorddate}" pattern="dd/MM/yyyy"/>'>
																			<a href="javascript:;"
																				onclick="displayCalendar(document.forms[0].suspensionorddate,'dd/mm/yyyy', document.forms[0].suspensionorddate);">
																				<img alt="" src="resources/images/calendar-icon.gif"
																				height="16" hspace="0" width="16">
																			</a>
																		</c:forEach>
																	</c:otherwise>
																</c:choose> <span class="star">*</span></td>
														</tr>
														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

																Effective Date of Suspension (dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><c:choose>
																	<c:when test="${suspentionEmployeeInfo==null}">
																		<input type="text" class="txt_date"
																			name="effectivedate" id="effectivedate" size="11"
																			maxlength="10" readonly="readonly">
																		<a href="javascript:;"
																			onclick="displayCalendar(document.forms[0].effectivedate,'dd/mm/yyyy', document.forms[0].suspensionorddate);">
																			<img alt="" src="resources/images/calendar-icon.gif"
																			height="16" hspace="0" width="16">
																		</a>
																		<span class="star">*[Max 16 char.]</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${suspentionEmployeeInfo}" var="a">
																			<input type="text" class="txt_medium" maxlength="16"
																				name="effectivedate" id="effectivedate"
																				value='<fmt:formatDate value="${a.effectivedate}" pattern="dd/MM/yyyy"/>'>
																			<a href="javascript:;"
																				onclick="displayCalendar(document.forms[0].effectivedate,'dd/mm/yyyy', document.forms[0].effectivedate);">
																				<img alt="" src="resources/images/calendar-icon.gif"
																				height="16" hspace="0" width="16">
																			</a>
																		</c:forEach>
																	</c:otherwise>
																</c:choose> <span class="star">*</span></td>
														</tr>
														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">

																Ordering Authority Name</td>
															<td align="left" valign="top" class="cell_bg"><c:choose>
																	<c:when test="${suspentionEmployeeInfo==null}">
																		<input type="text" class="txt_medium" maxlength="16"
																			name="orderauthname" id="orderauthname">
																		<span class="star">*[Max 30 char.]</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${suspentionEmployeeInfo}" var="a">
																			<input type="text" class="txt_medium" maxlength="16"
																				name="orderauthname" id="orderauthname"
																				value="${a.orderauthname}">
																		</c:forEach>
																		<span class="star">*[Max 30 char.]</span>
																	</c:otherwise>
																</c:choose></td>
														</tr>
														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">Ordering
																Authority's Designation</td>
															<td align="left" valign="top" class="cell_bg"><c:choose>
																	<c:when test="${suspentionEmployeeInfo==null}">
																		<input type="text" class="txt_medium" maxlength="16"
																			name="orderauthdesig" id="orderauthdesig">
																		<span class="star">*[Max 30 char.]</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${suspentionEmployeeInfo}" var="a">
																			<input type="text" class="txt_medium" maxlength="16"
																				name="orderauthdesig" id="orderauthdesig"
																				value="${a.orderauthdesig}">
																		</c:forEach>
																		<span class="star">*[Max 30 char.]</span>
																	</c:otherwise>
																</c:choose></td>
														</tr>

														<tr>
															<td align="left" colspan="3" class="bold">Attached
																with Office</td>
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
																id="district" name="mas_DistrictID" class="cmb_medium">
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
															<td class="cell_bg" valign="top" align="left"><select
																id="hmap" name="relievingoffice" class="cmb_medium">
																	<option value="-1">[Select Office Name]</option>
																	<c:forEach var="d" items="${officename}">
																		<option value="${d.key}">${d.value}</option>
																	</c:forEach>
															</select></td>
														</tr>

														<c:choose>
															<c:when test="${detailslist==null}">
																<tr>
																	<td valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">Date
																		of Reporting (dd/mm/yyyy)</td>
																	<td align="left" valign="top" class="cell_bg"><input
																		type="text" class="txt_date" name="reportingdate"
																		id="reportingdate" size="11" maxlength="10"
																		readonly="readonly"> <a href="javascript:;"
																		onclick="displayCalendar(document.forms[0].reportingdate,'dd/mm/yyyy', document.forms[0].reportingdate);">
																			<img alt="" src="resources/images/calendar-icon.gif"
																			height="16" hspace="0" width="16">
																	</a> <span class="star">*</span></td>
																</tr>
															</c:when>
															<c:otherwise>
																<tr>
																	<td valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">Date
																		of Reporting (dd/mm/yyyy)</td>
																	<td align="left" valign="top" class="cell_bg"><c:forEach
																			items="${detailslist}" var="a">
																			<input type="text" class="txt_date"
																				name="reportingdate" size="11" maxlength="10"
																				readonly="readonly" id="reportingdate"
																				value='<fmt:formatDate value="${a.reportingdate}" pattern="dd/MM/yyyy"/>'>
																		</c:forEach> <a href="javascript:;"
																		onclick="displayCalendar(document.forms[0].reportingdate,'dd/mm/yyyy', document.forms[0].reportingdate);">
																			<img alt="" src="resources/images/calendar-icon.gif"
																			height="16" hspace="0" width="16">
																	</a> <span class="star">*</span></td>
																</tr>
															</c:otherwise>
														</c:choose>

														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">Reason
																for Suspension</td>
															<td align="left" valign="top" class="cell_bg"><c:choose>
																	<c:when test="${suspentionEmployeeInfo==null}">
																		<textarea class="txtarea_small"
																			name="reasonForSuspension" id="reasonForSuspension"
																			maxlength="150"></textarea>
																		<span class="star">*[Max 30 char.]</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${suspentionEmployeeInfo}" var="a">

																			<textarea class="txtarea_small"
																				name="reasonForSuspension" id="reasonForSuspension"
																				maxlength="150">${a.reasonforsuspension}</textarea>
																		</c:forEach>
																		<span class="star">*[Max 30 char.]</span>
																	</c:otherwise>
																</c:choose></td>
														</tr>
														<tr>
															<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
														</tr>
														<tr>
															<td colspan="5" align="center" valign="top"
																class="cell_bg"><input type="submit"
																class="btn_medium" value="Submit"
																onclick="return validatedetails()" /> <input
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
				<script type="text/javascript" src="resources/js/tablesorter.js"></script>

				<!--  -->

				<table width="90%" class="table_bg" cellpadding="3" cellspacing="3"
					border="0" align="center">
					<tr>
						<td>
							<div style="overflow-y: scroll; height: 100px">
								<table width="100%" id="myTable" cellpadding="0" cellspacing="1"
									border="0" class="tablesorter">

									<thead id="h" align="center">
										<tr>
											<th id="t" width="12%"><img alt=""
												src="resources/images/sort.gif">Employee Name</th>
											<th id="t" width="17%"><img alt=""
												src="resources/images/sort.gif">Employee Designation</th>
											<th id="t" width="13%"><img alt=""
												src="resources/images/sort.gif">Suspension Order no</th>
											<th id="t" width="10%"><img alt=""
												src="resources/images/sort.gif">Suspension Order date</th>
											<th id="t" width="18%"><img alt=""
												src="resources/images/sort.gif">Ordering Authority
												Name</th>
											<th id="t" width="10%">Action</th>
										</tr>
									</thead>

									<tbody id="b" align="center">
										<c:forEach items="${list}" var="list">
											<input type="hidden" id="ppSuspensiondetailid"
												value="${list.ppSuspensiondetailid}"
												name="ppSuspensiondetailid" />
											<tr>

												<td>${list.employeename}</td>
												<td>${list.designation}</td>
												<td>${list.suspensionordno}</td>

												<td><fmt:formatDate pattern="dd/MM/yyyy"
														value="${list.suspensionorddate}" /></td>
												<td>${list.orderauthname}</td>
												
												<td><a
													href="/UPJN/editSuspentionDetails?ppSuspensiondetailid=<c:out value="${list.ppSuspensiondetailid}"/>"><u>Edit</u></a>
													|| <a
													href="/UPJN/deleteSuspentionDetails?ppSuspensiondetailid=<c:out value="${list.ppSuspensiondetailid}"/>"
													onclick="javascript:return confirm('Are you sure to delete ?');"><u>Delete</u></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</td>
					</tr>
				</table>

			</form>
		</div>
	</div>
</body>
</html>