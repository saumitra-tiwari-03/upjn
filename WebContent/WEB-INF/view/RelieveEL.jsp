<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="java.util.ArrayList"%>
<html>
<head>
<title>U.P JAL NIGAM-Relieve EL</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM</title>
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
	function populateRelieveELDetails() {

		document.getElementById("populateRelieveELDetails").action = "/UPJN/populateRelieveELDetails";
		document.getElementById("populateRelieveELDetails").Method = "POST";
		document.getElementById("populateRelieveELDetails").submit();
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
			style="height: 600px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div style="height: 100%; width: 79%; float: left; padding-top: 10px;">

			<c:choose>
				<c:when test="${empdetailsize==0}">
					<form action="/UPJN/addRelieveEL" id="populateRelieveELDetails"
						method="post">
				</c:when>
				<c:when test="${empdetailsizetransfer!=0}">
					<form action="/UPJN/transferRelieveEL"
						id="populateRelieveELDetails" method="post">
						<c:forEach items="${empdetailtransfer}" var="a">
							<input type="hidden" name="ppEmployeeEldetailid"
								value="${a.ppEmployeeEldetailid}">
						</c:forEach>
				</c:when>

				<c:otherwise>
					<form action="/UPJN/joinRelieveEL" id="populateRelieveELDetails"
						method="post">
						<c:forEach items="${empdetail}" var="a">
							<input type="hidden" name="ppEmployeeEldetailid"
								value="${a.ppEmployeeEldetailid}">
						</c:forEach>
				</c:otherwise>
			</c:choose>
			<table cellSpacing=1 cellPadding=1 width="70%" border="0"
				align="center">
				<tr>
					<td align="left" valign="top" class="msg">${msg}</td>
				</tr>
				<tr>
					<c:set var="currentdate" value="<%=new java.util.Date()%>" />
					<td><input type="hidden" name="currentdate" id="currentdate"
						value="<fmt:formatDate pattern="dd/MM/yyyy" value="${currentdate}" />">
					</td>
				</tr>
				<tr>
					<td class="table_bg" valign="top">
						<table cellSpacing=1 cellPadding=3 width="100%" border="0"
							align="center">

							<tr>
								<td class="table_head" valign="top" align="left" width="95%">
									Relieve On EL</td>

							</tr>
						</table>

						<table cellSpacing="1" cellPadding="3" width="100%" border="0"
							align="center">
							<tr>
								<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
								<td colspan="1" valign="middle" class="error_normal"
									align="right">* Fields are required.</td>
							</tr>
							<tr>
								<!-- <td  valign="top" class="cell_bg">&nbsp;</td> -->
								<td align="center" valign="top" class="cell_bg">Employee
									Code</td>

								<td align="center" valign="middle" class="cell_bg"><c:choose>
										<c:when test="${empcode==null}">
											<input type="text" class="txt_small" name="employeecode"
												required size="30" maxlength="6">
										</c:when>
										<c:otherwise>
											<c:forEach items="${empcode}">
												<input type="text" class="txt_small" name="employeecode"
													size="30" maxlength="8" value="${empcode}" required>
												<input type="hidden" name="ppEmployeemasterid"
													value="${ppEmployeemasterid}">
											</c:forEach>
										</c:otherwise>
									</c:choose> <input type="submit" class="btn_go" name="method" value="GO"
									onclick="populateRelieveELDetails()"> <span
									class="star">*</span> &nbsp;
								<td><a href="/UPJN/SearchEmployeeforRelieveEL" class="bold">

										<u>Select Employee</u>
								</a></td>
								<!-- </td> -->
							</tr>

							<tr>
								<td class="cell_bg" valign="top" colspan="4"></td>
							</tr>

							<tr>
								<!-- <td valign="top" class="cell_bg">&nbsp;</td> -->
								<td align="center" valign="top" class="cell_bg">Employee
									Name</td>
								<td align="center" valign="top" class="cell_bg"><c:choose>
										<c:when test="${nameofemployee==null}">
											<input type="text" name="employeename" class="txt_noborder"
												size="30" maxlength="100" readonly="readonly">

										</c:when>
										<c:otherwise>
											
												<input type="text" name="employeename" class="txt_noborder"
													size="30" maxlength="100" readonly="readonly"
													value="${nameofemployee}">
										
										</c:otherwise>
									</c:choose></td>


							</tr>

							<tr>
								<td class="cell_bg" valign="top" colspan="4"></td>
							</tr>

							<tr>
								<td class="cell_bg" valign="top" align="center">
									Designation</td>
								<td class="cell_bg" valign="top" align="center"><c:choose>
										<c:when test="${designationofemployee==null}">
											<input type="text" name="designation" class="txt_noborder"
												size="30" maxlength="100" readonly="readonly">

										</c:when>
										<c:otherwise>
											
												<input type="text" name="designation" class="txt_noborder"
													size="30" maxlength="100" readonly="readonly"
													value="${designationofemployee}">
											
										</c:otherwise>
									</c:choose></td>
							</tr>


							<tr>
								<td class="cell_bg" valign="top" colspan="4"></td>
							</tr>


							<c:choose>
								<c:when test="${empdetailsizetransfer!=0}">

									<tr>
										<td align="center">Office Level</td>
										<td class="cell_bg" valign="top" align="left"><select
											id="hm" name="mas_OfficeLevelID" class="cmb_medium">
												<option>[Select Level]</option>
												<c:forEach var="d" items="${Data}">
													<option value="${d.key}">${d.value}</option>
												</c:forEach>
										</select>
									</tr>

									<tr>
										<td align="center">District</td>
										<td align="left" valign="middle" class="cell_bg"><select
											id="district" name="mas_DistrictID" class="cmb_medium">
												<option value="-1">[Select District]</option>
												<c:forEach var="d" items="${Data1}">
													<option value="${d.key}">${d.value}</option>
												</c:forEach>
										</select></td>
									</tr>

									<tr>

										<td valign="top" align="center" width="43%">Office Name</td>
										<td class="cell_bg" valign="top" id="officename" align="left">
											<select id="hmap" name="officeto" class="cmb_medium">
												<option value="-1">[Select Office Name]</option>
												<c:forEach var="d" items="${officename}">
													<option value="${d.key}">${d.value}</option>
												</c:forEach>
										</select>

										</td>
									</tr>

									<tr>

										<td align="center" valign="top" class="cell_bg">Transfer
											Order no.</td>
										<td align="left" valign="top" class="cell_bg"><input
											type="text" class="txt_medium" name="transferordno" size="11"
											maxlength="50"> <span class="star">*[Max size
												50]</span></td>
									</tr>

									<tr>

										<td align="center" valign="top" class="cell_bg">Transfer
											Order date (dd/mm/yyyy)</td>
										<td align="left" valign="top" class="cell_bg"><input
											type="text" class="txt_date" name="transferorderdate"
											readonly="readonly"> <a href="javascript:;"
											onclick="displayCalendar(document.forms[0].transferorderdate,'dd/mm/yyyy',document.forms[0].transferorderdate)">
												<img height="16" hspace="0"
												src="resources/images/calendar-icon.gif" width="16"
												border="0" />
										</a> <span class="star">*</span></td>
									</tr>


								</c:when>


								<c:when test="${empdetailsize==0}">
									<tr>
										<td class="cell_bg" valign="top" align="center">
											Relieving Order No.</td>
										<td class="cell_bg" valign="top" align="center"><input
											type="text" name="relorderno" class="txt_medium" size="11"
											maxlength="50" required> <span class="star">*</span>
										</td>
									</tr>

									<tr>
										<td class="cell_bg" valign="top" colspan="4"></td>
									</tr>

									<tr>
										<td align="center" valign="top" class="cell_bg">
											Relieving Order Date</td>


										<td align="center" valign="top" class="cell_bg"><input
											type="text" class="txt_date" name="relorderdate"
											readonly="readonly" required> <a href="javascript:;"
											onclick="displayCalendar(document.forms[0].relorderdate,'dd/mm/yyyy',document.forms[0].relorderdate)">
												<img height="16" hspace="0"
												src="resources/images/calendar-icon.gif" width="16"
												border="0" />
										</a> <span class="star">*</span></td>

									</tr>
								</c:when>

								<c:otherwise>
									<tr>
										<td align="center" valign="top" class="cell_bg">Joining
											Date</td>
										<td align="left" valign="top" class="cell_bg"><input
											type="text" class="txt_date" name="joiningdate" required
											readonly="readonly"> <a href="javascript:;"
											onclick="displayCalendar(document.forms[0].joiningdate,'dd/mm/yyyy',document.forms[0].joiningdate)">
												<img height="16" hspace="0"
												src="resources/images/calendar-icon.gif" width="16"
												border="0" />
										</a> <span class="star">*</span></td>
									</tr>

									<tr>
										<td class="cell_bg" valign="top" colspan="4"></td>
									</tr>

									<tr>
										<td align="center" valign="top" class="cell_bg">Joining
											Order Date</td>
										<td align="left" valign="top" class="cell_bg"><input
											type="text" class="txt_date" name="joiningorderdate" required
											readonly="readonly"> <a href="javascript:;"
											onclick="displayCalendar(document.forms[0].joiningorderdate,'dd/mm/yyyy',document.forms[0].joiningorderdate)">
												<img height="16" hspace="0"
												src="resources/images/calendar-icon.gif" width="16"
												border="0" />
										</a> <span class="star">*</span></td>
									</tr>

									<tr>
										<td class="cell_bg" valign="top" align="center">Joining
											Order No.</td>
										<td class="cell_bg" valign="top" align="left"><input
											type="text" name="joiningorder" class="txt_medium" size="11"
											required maxlength="50"> <span class="star">*</span></td>
									</tr>

									<tr>
										<td class="cell_bg" valign="top" colspan="4"></td>
									</tr>

									<tr>
										<td class="cell_bg" valign="top" colspan="4"></td>
									</tr>

									<tr>
										<td width="43%" align="center" valign="top" class="cell_bg">
											Joining Time</td>
										<td align="left" valign="top" class="cell_bg"><select
											required name="joininganfn" class="cmb_small">
												<option value="-1">[Select Time]</option>
												<option value="FN">Fore Noon</option>
												<option value="AN">After Noon</option>
										</select> <span class="star">*</span></td>
									</tr>
								</c:otherwise>
							</c:choose>

							<tr>
								<td class="cell_bg" valign="top" colspan="4"></td>
							</tr>

							<tr>
								<td class="cell_bg" valign="top" colspan="4"></td>
							</tr>

							<tr>
								<td colspan="5" align="center" valign="top" class="cell_bg">
									<c:choose>
										<c:when test="${empdetailsize==0}">
											<input type="submit" class="btn_medium" value="Submit" />
										</c:when>
										<c:when test="${empdetailsizetransfer!=0}">
											<input type="submit" class="btn_medium" value="Transfer" />
										</c:when>
										<c:otherwise>
											<input type="submit" class="btn_medium" value="Join" />

										</c:otherwise>
									</c:choose> <input type="reset" class="btn_medium" value="Reset" />

								</td>
							</tr>

							<tr>
								<td class="cell_bg" valign="top" colspan="4"></td>
							</tr>
							<tr>
								<td class="cell_bg" valign="top" colspan="4"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>


			<br> <br>
			<!-- Data table starts here -->

			<script type="text/javascript" src="resources/js/tablesorter.js"></script>

			<!--  -->

			<table width="90%" class="table_bg" cellpadding="3" cellspacing="3"
				border="0" align="center">
				<tr>
					<td>
						<div style="overflow-y: scroll; height: 300px">
							<table width="100%" id="myTable" cellpadding="0" cellspacing="1"
								border="0" class="tablesorter">

								<thead id="h" align="center">
									<tr>
										<th id="t" width="15%"><img alt=""
												src="resources/images/sort.gif">Employee Code</th>
											<th id="t" width="20%"><img alt=""
												src="resources/images/sort.gif">Employee Name</th>
											<th id="t" width="20%"><img alt=""
												src="resources/images/sort.gif">Employee Designation</th>
											<th id="t" width="15%"><img alt=""
												src="resources/images/sort.gif">Transfer Order No</th>
											<th id="t" width="15%"><img alt=""
												src="resources/images/sort.gif">Transfer Order Date</th>

										<th id="t" width="15%">Action</th>
									</tr>
								</thead>
<tr><td class="msg">${list_msg}</td></tr>
								<tbody id="b" align="center">
										<c:forEach items="${list}" var="list">
														<tr>
															<td>${list.employeecode}</td>
															<td>${list.employeename}</td>
															<td>${list.designation}</td>
															<td>${list.relorderno}</td>
															
															<td><fmt:formatDate value="${list.relorderdate}" pattern="dd/MM/yyyy"/>  </td>

															<td><a
																href="/UPJN/deleteRelieveEL?ID=<c:out value="${list.ppEmployeeEldetailid}"/>&ID1=<c:out value="${list.ppEmployeemasterid}"/>"
																onclick="javascript:return confirm('Are you sure to delete ?');">
																	<u>Delete</u> ||
															</a> <a
																href="/UPJN/EmpJoinRelieveELdetail?ID=<c:out value="${list.ppEmployeeEldetailid}"/>&ID1=<c:out value="${list.employeecode}"/>"
																onclick="javascript:return confirm('Are you sure to join ?');">
																	<u>Emp Join</u> ||
															</a> <a
																href="/UPJN/transferRelieveELdetail?ID=<c:out value="${list.ppEmployeeEldetailid}"/>&ID1=<c:out value="${list.employeecode}"/>"
																onclick="javascript:return confirm('Are you sure to Transfer ?');">
																	<u>Transfer</u>
															</a></td>
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