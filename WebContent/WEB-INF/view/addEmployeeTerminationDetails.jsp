<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="java.util.ArrayList"%>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM- Add Termination details Page</title>

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

 function validatedetails(){
	 var employeecode = document.getElementById("employeecode").value;
	 if (employeecode == "") {
			alert("Please fill Employee Code");
			return false;
		}
	 
	 var terminationordno = document.getElementById("terminationordno").value;
	 if (terminationordno == "") {
			alert("Please fill Termination order No.");
			return false;
		}
	
	 var terminationorddate = document.getElementById("terminationorddate").value;
	 if (terminationorddate == "") {
			alert("Please fill Termination order Date");
			return false;
		}
	 
	 var effectivedate = document.getElementById("effectivedate").value;
	 if (effectivedate == "") {
			alert("Please fill Effective date of Termination");
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
	 var reasonfortermination = document.getElementById("reasonfortermination").value;
	 if (reasonfortermination == "") {
			alert("Please fill Reason For Termination");
			return false;
		}                          
 }  

</script>

<script type="text/javascript">
	function populateterminationdetails() {
		
		document.getElementById("populateterminationdetails").action = "/UPJN/populateemployeeTerminationDetails";
		document.getElementById("populateterminationdetails").Method = "POST";
		document.getElementById("populateterminationdetails").submit();
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

			<form action="/UPJN/EmployeeTermination" method="post"
				id="populateterminationdetails">

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
																colspan="6">Employee Termination - Add Termination
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
																	<c:when test="${terminationEmployeeInfoList==null}">
																		<input type="text" class="txt_medium" maxlength="16"
																			name="employeecode" id="employeecode">
																		<span class="star">*[Max 16 char.]</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${terminationEmployeeInfoList}"
																			var="a">
																			<input type="text" class="txt_medium" maxlength="16"
																				name="employeecode" id="employeecode"
																				value="${a.employeecode}" required>

																			<input type="hidden" class="txt_medium"
																				name="ppEmployeemasterid"
																				value="${a.ppEmployeemasterid}">

																		</c:forEach>
																	</c:otherwise>
																</c:choose> <input type="submit" name="terminationEmployeeSearch"
																class="btn_go" value="GO"
																onclick="return populateterminationdetails()"> <span
																class="star">*</span> &nbsp; <a
																href="/UPJN/terminationEmployeeSearch" class="bold">
																	<u>Select Employee</u>
															</a>

															</td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">
																Employee Name</td>
															<td class="cell_bg" valign="top" align="left"><c:forEach
																	items="${terminationEmployeeInfoList}" var="a">
							                                ${a.employeename}</c:forEach></td>
														</tr>
														<tr>
															<td class="cell_bg" valign="top" width="3%">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">
																Employee Designation</td>
															<td class="cell_bg" valign="middle" align="left"><c:forEach
																	items="${terminationEmployeeInfoList}" var="a">
							                                 ${a.designation}</c:forEach></td>

														</tr>

														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">
																Termination Order No.</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_medium" name="terminationordno"
																id="terminationordno" size="11" maxlength="50">
																<span class="star">*[Max 50 char.]</span></td>
														</tr>
														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

																Termination Order Date (dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date" name="terminationorddate"
																id="terminationorddate" size="11" maxlength="10"
																readonly="readonly"> <a href="javascript:;"
																onclick="displayCalendar(document.forms[0].terminationorddate,'dd/mm/yyyy', document.forms[0].terminationorddate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
														</tr>
														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

																Effective Date of Termination (dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date" name="effectivedate"
																id="effectivedate" size="11" maxlength="10"
																readonly="readonly"> <a href="javascript:;"
																onclick="displayCalendar(document.forms[0].effectivedate,'dd/mm/yyyy', document.forms[0].effectivedate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
														</tr>
														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">

																Ordering Authority Name</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_medium" name="orderauthname"
																id="orderauthname" size="20" maxlength="30"> <span
																class="star">*[Max 30 char.]</span></td>
														</tr>
														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">Ordering
																Authority's Designation</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_medium" name="orderauthdesig"
																id="orderauthdesig" size="20" maxlength="50"> <span
																class="star">*[Max 50 char.]</span></td>
														</tr>




														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">Reason
																for Termination</td>
															<td align="left" valign="top" class="cell_bg"><textarea
																	class="txtarea_small" name="reasonfortermination"
																	id="reasonfortermination" rows="" cols=""
																	maxlength="150"></textarea> <span class="star">*[Max
																	150 char.]</span></td>
														</tr>
														<tr>
															<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
														</tr>
														<tr>
															<td colspan="5" align="center" valign="top"
																class="cell_bg"><input type="submit"
																class="btn_large" value="Submit"
																name="saveTerminationRecord"
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
							<div style="overflow-y: scroll; height: 200px">
								<table width="100%" id="myTable" cellpadding="0" cellspacing="1"
									border="0" class="tablesorter">

									<thead id="h" align="center">
										<tr>
											<th id="t" width="20%"><img alt=""
												src="resources/images/sort.gif">Employee Name</th>
											<th id="t" width="15%"><img alt=""
												src="resources/images/sort.gif">Employee Designation</th>
											<th id="t" width="15%"><img alt=""
												src="resources/images/sort.gif">Termination Order No</th>
											<th id="t" width="15%"><img alt=""
												src="resources/images/sort.gif">Termination Order Date</th>
											<th id="t" width="15%"><img alt=""
												src="resources/images/sort.gif">Ordering Authority Name</th>

											<th id="t" width="20%">Action</th>
										</tr>
									</thead>

									<tbody id="b" align="center">
									<c:forEach items="${list}" var="list">
																
																	<input type="hidden" id="ppEmployeemasterid"
																		value="${list.ppEmployeemasterid}"
																		name="ppEmployeemasterid" />
																		<tr>
																	<td>${list.employeename}</td>
																	<td>${list.designation}</td>
																	<td>${list.terminationordno}</td>

																	<td><fmt:formatDate pattern="dd/MM/yyyy"
																			value="${list.terminationorddate}" /></td>
																	<td>${list.orderauthname}</td>
																	<td>
																	<a href="/UPJN/editTerminationdetails?ppTerminationdetailid=<c:out value="${list.ppTerminationdetailid}"/>&employeecode=<c:out value="${list.employeecode}"/>"><u> Edit</u> </a>
																	||
																	<a href="/UPJN/deleteTerminationdetails?ppTerminationdetailid=<c:out value="${list.ppTerminationdetailid}"/>&ppEmployeemasterid=<c:out value="${list.ppEmployeemasterid}"/>"
																	onclick="javascript:return confirm('Are you sure to delete ?');"
																	> <u>Delete</u></a>
																	</td>
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