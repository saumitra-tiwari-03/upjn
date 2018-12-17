

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="java.util.ArrayList"%>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM-Relieve For Deputation</title>

<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script language="javascript" src="resources/js/validation.js"></script>
<script language="javascript" src="resources/js/popcalendar.js"></script>
<script language="javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
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
	 
	 var deputationorderno = document.getElementById("deputationorderno").value;
	 if (deputationorderno == "") {
			alert("Please fill Deputation order No.");
			return false;
		}
	
	 var deputationorderdate = document.getElementById("deputationorderdate").value;
	 if (deputationorderdate == "") {
			alert("Please fill Deputation order Date");
			return false;
		}
	 
	 var targetoffice = document.getElementById("targetoffice").value;
	 if (targetoffice == "") {
			alert("Please fill Target Office ");
			return false;
		}

	 var relieveorderno = document.getElementById("relieveorderno").value;
	 if (relieveorderno == "") {
			alert("Please fill Relieve Order No.");
			return false;
		}
	 
	 var relieveorderdate = document.getElementById("relieveorderdate").value;
	 if (relieveorderdate == "") {
			alert("Please fill Relieve Order Date");
			return false;
		}

	 var relievedate = document.getElementById("relievedate").value;
	 if (relievedate == "") {
			alert("Please fill Relieving Date");
			return false;
		}
		
	 var joining_time = document.getElementById("joining_time").value;
	 if (joining_time == -1) {
			alert("Please select Joining Time");
			return false;
		}   
                      
 }  

</script>
<script type="text/javascript">
	function populatedeputationdetails() {
		
		document.getElementById("populatedeputationdetails").action = "/UPJN/populateemployeeRelieveDeputationDetails";
		document.getElementById("populatedeputationdetails").Method = "POST";
		document.getElementById("populatedeputationdetails").submit();
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
			<form action="/UPJN/savereliveDeputationRecord" method="post"
				id="populatedeputationdetails">
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
																colspan="6">Relieve Employee - Relieve For
																Deputation</td>
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
																	<c:when test="${deputationInfo==null}">
																		<input type="text" class="txt_medium" maxlength="16"
																			name="employeecode" id="employeecode">
																		<span class="star">*[Max 16 char.]</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${deputationInfo}" var="a">
																			<input type="text" class="txt_medium" maxlength="16"
																				name="employeecode" id="employeecode"
																				value="${a.employeecode}">
																		</c:forEach>
																	</c:otherwise>
																</c:choose> <input type="submit" name="terminationEmployeeSearch"
																class="btn_go" value="GO"
																onclick="return populatedeputationdetails()"> <span
																class="star">*</span> &nbsp; <a
																href="/UPJN/relieveForDeputationEmployeeSearch"
																class="bold"> <u>Select Employee</u></a> <!-- <input type="submit" class="btn_go" value="GO">
																<span class="star">*</span> &nbsp; <a
																href="/UPJN/relieveForDeputationEmployeeSearch"
																onclick="return hs.htmlExpand(this, { objectType: 'iframe' } )">
																	Select Employee </a> -->
															</td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">
																Employee Name</td>
															<td class="cell_bg" valign="top" align="left"><c:forEach
																	items="${deputationInfo}" var="a">
							                                ${a.employeename}</c:forEach></td>
														</tr>
														<tr>
															<td class="cell_bg" valign="top" width="3%">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">
																Employee Designation</td>
															<td class="cell_bg" valign="middle" align="left"><c:forEach
																	items="${deputationInfo}" var="a">
							                                 ${a.designation}</c:forEach></td>

														</tr>

														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">
																Deputation Order No.</td>
															<td align="left" valign="top" class="cell_bg"><c:choose>
																	<c:when test="${deputationInfoList==null}">
																		<input type="text" class="txt_medium" maxlength="16"
																			name="deputationorderno" id="deputationorderno">
																		<span class="star">*[Max 16 char.]</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${deputationInfoList}" var="a">
																			<input type="text" class="txt_medium" maxlength="16"
																				name="deputationorderno" id="deputationorderno"
																				value="${a.deputationorderno}">
																		</c:forEach>
																	</c:otherwise>
																</c:choose></td>
														</tr>
														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

																Deputation Order Date (dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><c:choose>
																	<c:when test="${deputationInfoList==null}">
																		<input type="text" class="txt_date"
																			name="deputationorderdate" id="deputationorderdate"
																			size="11" maxlength="10" readonly="readonly">
																		<a href="javascript:;"
																			onclick="displayCalendar(document.forms[0].deputationorderdate,'dd/mm/yyyy', document.forms[0].deputationorderdate);">
																			<img alt="" src="resources/images/calendar-icon.gif"
																			height="16" hspace="0" width="16">
																		</a>
																		<span class="star">*[Max 16 char.]</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${deputationInfoList}" var="a">
																			<input type="text" class="txt_medium" maxlength="16"
																				name="deputationorderdate" id="deputationorderdate"
																				value='<fmt:formatDate value="${a.deputationorderdate}" pattern="dd/MM/yyyy"/>'<%-- value="${a.deputationorderdate}" --%> >
																			<a href="javascript:;"
																				onclick="displayCalendar(document.forms[0].deputationorderdate,'dd/mm/yyyy', document.forms[0].deputationorderdate);">
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
																Target Office Detail</td>
															<td align="left" valign="top" class="cell_bg"><c:choose>
																	<c:when test="${deputationInfoList==null}">
																		<input type="text" class="txt_medium" maxlength="16"
																			name="targetoffice" id="targetoffice">
																		<span class="star">*[Max 50 char.]</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${deputationInfoList}" var="a">
																			<input type="text" class="txt_medium" maxlength="20"
																				 name="targetoffice" id="targetoffice"
																				value="${a.targetoffice}">
																		</c:forEach>
																	</c:otherwise>
																</c:choose></td>
														</tr>


														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="43%" align="left" valign="top" class="cell_bg">Relieve
																Order No.</td>
															<td align="left" valign="top" class="cell_bg"><c:choose>
																	<c:when test="${deputationInfoList==null}">
																		<input type="text" class="txt_medium" maxlength="16"
																			name="relieveorderno" id="relieveorderno">
																		<span class="star">*[Max 50 char.]</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${deputationInfoList}" var="a">
																			<input type="text" class="txt_medium" maxlength="20"
																				name="relieveorderno" id="relieveorderno"
																				value="${a.relieveorderno}">
																		</c:forEach>
																	</c:otherwise>
																</c:choose> <span class="star">*[Max 50 char.]</span></td>
														</tr>

														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

																Relieve Order Date (dd/mm/yyyy) (dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><c:choose>
																	<c:when test="${deputationInfoList==null}">
																		<input type="text" class="txt_date"
																			name="relieveorderdate" id="relieveorderdate" size="11" maxlength="10"
																			readonly="readonly">
																		<a href="javascript:;"
																			onclick="displayCalendar(document.forms[0].relieveorderdate,'dd/mm/yyyy', document.forms[0].relieveorderdate);">
																			<img alt="" src="resources/images/calendar-icon.gif"
																			height="16" hspace="0" width="16">
																		</a>
																		<span class="star">*[Max 16 char.]</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${deputationInfoList}" var="a">
																			<input type="text" class="txt_medium" maxlength="16"
																				name="relieveorderdate"
																				id="relieveorderdate"
																				<%-- value="${a.relieveorderdate}" --%>
																				value='<fmt:formatDate value="${a.relieveorderdate}" pattern="dd/MM/yyyy"/>'>
																			<a href="javascript:;"
																				onclick="displayCalendar(document.forms[0].relieveorderdate,'dd/mm/yyyy', document.forms[0].relieveorderdate);">
																				<img alt="" src="resources/images/calendar-icon.gif"
																				height="16" hspace="0" width="16">
																			</a>
																		</c:forEach>
																	</c:otherwise>
																</c:choose></td>
														</tr>


														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

																Relieving Date (dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><c:choose>
																	<c:when test="${deputationInfoList==null}">
																		<input type="text" class="txt_date" name="relievedate" id="relievedate"
																			size="11" maxlength="10" readonly="readonly">
																		<a href="javascript:;"
																			onclick="displayCalendar(document.forms[0].relievedate,'dd/mm/yyyy', document.forms[0].relievedate);">
																			<img alt="" src="resources/images/calendar-icon.gif"
																			height="16" hspace="0" width="16">
																		</a>
																		<span class="star">*[Max 16 char.]</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${deputationInfoList}" var="a">
																			<input type="text" class="txt_medium" maxlength="16"
																			name="relievedate" id="relievedate"
																				value='<fmt:formatDate value="${a.relievedate}" pattern="dd/MM/yyyy"/>'
																				value="${a.relievedate}">
																			<a href="javascript:;"
																				onclick="displayCalendar(document.forms[0].relievedate,'dd/mm/yyyy', document.forms[0].relievedate);">
																				<img alt="" src="resources/images/calendar-icon.gif"
																				height="16" hspace="0" width="16">
																			</a>
																		</c:forEach>
																	</c:otherwise>
																</c:choose></td>
														</tr>


														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">
																Joining Time</td>
															<td align="left" valign="middle" class="cell_bg"><select
																id="joining_time" name="relieveanfn" class="cmb_medium">
																	<option selected="selected" value="-1" disabled selection>
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
																colSpan="5"><input type="submit" class="btn_medium" onclick="return validatedetails()"																value="Submit" /> <input type="reset"
																class="btn_medium" value="Reset" /></td>
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
		
												<table width="90%" class="table_bg"
													cellpadding="3" cellspacing="3" border="0" align="center">
													<tr>
														<td>
													<div style="overflow-y:scroll; height: 200px">			
															<table width="100%"  id="myTable"
																	cellpadding="0" cellspacing="1" border="0"
																	class="tablesorter">

																	<thead id="h" align="center" >
																		<tr>
																		<th id="t" width="15%"><img alt=""
																				src="resources/images/sort.gif">Employee Name</th>
																				<th id="t" width="15%"><img alt=""
																				src="resources/images/sort.gif">Employee Designation</th>
																			<th id="t" width="15%"><img alt=""
																				src="resources/images/sort.gif">Target Office</th>
																			<th id="t" width="20%"><img alt=""
																				src="resources/images/sort.gif">Deputation Order No</th>
																		<th id="t" width="20%"><img alt=""
																				src="resources/images/sort.gif">Deputation Order Date</th>		
																				
																			<th id="t" width="15%" >Action</th>
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
																	<td>${list.targetoffice}</td>
																	<td>${list.deputationorderno}</td>

																	<td><fmt:formatDate
																			value="${list.deputationorderdate}"
																			pattern="dd/MM/yyyy" />
																	<td>
																	<td><a
																		href="/UPJN/editDepuatationDetails?ppDeputationdetailid=<c:out value="${list.ppDeputationdetailid}"/>"><u>Edit</u></a>

																		|| <a
																		href="/UPJN/deleteDeputationDetails?ppDeputationdetailid=<c:out value="${list.ppDeputationdetailid}"/>&ppEmployeemasterid=<c:out value="${list.ppEmployeemasterid}"/>&ppNoduesdetailid=<c:out value="${list.ppNoduesdetailid}"/>"
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