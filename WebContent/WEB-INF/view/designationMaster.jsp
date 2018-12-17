
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>U.P JAL NIGAM-Employee Loan Details</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script language="javascript" src="resources/js/validation.js"></script>
<script language="javascript" src="resources/js/popcalendar.js"></script>
<script language="javascript" src="resources/js/NEW_NEW.js"></script>
<script language="javascript" src="resources/js/upjn.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>

<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<script type="text/javascript">
	$(document).ready(sortDropDownListByText);
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#myTable").tablesorter();
	});
</script>


<script type="text/javascript">
function validate() {
	
	var a = document.getElementById("emp_type").value;
	var b = document.getElementById("employeementcategory").value;
	
	if(a == -1 || b == -1){
		alert("required values cannot be null");
		return false;
	}

}
</script>

<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />

</head>
<body>

	<div style="height: 100%; width: 100%;">

		<div
			style="height: 100px; width: 100%; border-bottom: gray solid 4px;">
			<%@ include file="/WEB-INF/view/Header.jsp"%>
		</div>


		<div
			style="height: 600px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px; overflow-x: auto;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div
			style="height: 100%; width: 79%; float: left; padding-top: 10px; overflow-x: auto;">



			<form method="post" action="/UPJN/addNewDesignationDetails">
				<input type="hidden" name="pp_DesignationMasterID"
					value="${ppDesignationmasterid}">


				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td valign="top" class="msg">&nbsp; ${success}</td>
					</tr>
					<tr>
						<td valign="top" class="error">${error}</td>
					</tr>
					<tr>
						<td valign="top"><table width="80%" align="center"
								cellpadding="0" cellspacing="0" border="0">
								<tr>
									<td valign="top"><table width="100%" align="center"
											cellpadding="0" cellspacing="1" border="0" class="table_bg">
											<tr>
												<td valign="top"><table width="100%" align="center"
														class="cell_bg" cellpadding="3" cellspacing="3" border="0">
														<tr>
															<td align="left" valign="top" class="table_head"
																colspan="4">Designation Master</td>
														</tr>
														<tr>
															<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
															<td colspan="1" valign="middle" class="error_normal"
																align="right">* Fields are required.</td>
														</tr>
														<tr>
															<td valign="top">&nbsp;</td>
														</tr>

														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">Designation</td>
															<td align="left" valign="top" class="cell_bg" colspan="3"><c:choose>
																	<c:when test="${designationInfiList==null}">
																		<input type="text" class="txt_medium" name="designation"
																			id="designation" required maxlength="40">

																		<span class="star">*</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${designationInfiList}" var="a">
																			<input type="text" class="txt_medium" maxlength="40"
																				name="designation" id="designation" value="${a.designation}"
																				maxlength="40" required>
																		</c:forEach>
																		<span class="star">*</span>
																	</c:otherwise>
																</c:choose></td>
														</tr>




														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="bold" valign="top" align="left" width="43%">
																Employment Type</td>
															<td class="cell_bg" valign="top" align="left"><c:if
																	test="${masEmploymenttypeList == null}">
																	<select id="emp_type" name="mas_EmploymentTypeID"
																		class="cmb_medium">
																		<option value="-1">[Select Employment Type]</option>
																		<c:forEach var="l" items="${masEmploymenttypeMap}">
																			<option value="${l.key}">${l.value}</option>
																		</c:forEach>
																	</select>
																</c:if> <c:if test="${masEmploymenttypeList != null}">
																	<c:forEach items="${masEmploymenttypeList}" var="a">
																		<input type="hidden" value="${a.masEmploymenttypeid}"
																			id="mas_EmploymentTypeID" name="mas_EmploymentTypeID">
																	</c:forEach>
																	<select id="hmap1" name="employmenttype"
																		class="cmb_medium">
																		<option value="-1">[Select Employment Type]</option>
																		<c:forEach var="l" items="${masEmploymenttypeMap}">
																			<option value="${l.key}">${l.value}</option>
																		</c:forEach>
																	</select>
																</c:if></td>
														</tr>
														
														
														
														
														<tr>
																	<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																	<td align="left" valign="top" class="cell_bg">
																		Employment Category</td>
																	<td align="left" valign="middle" class="cell_bg">

																		<c:choose>
																			<c:when test="${list3==null}">
																				<select id="employeementcategory" required
																					name="mas_EmploymentSubTypeID" class="cmb_medium">
																					<option>[Select Category]</option>
																					<c:forEach var="d" items="${employeementcategory}">
																						<option value="${d.key}">${d.value}</option>
																					</c:forEach>
																				</select>
																			</c:when>
																			<c:otherwise>
																				<select id="employeementcategory"
																					name="mas_EmploymentSubTypeID" class="cmb_medium">
																					<c:forEach items="${list3}" var="a">
																						<option value="">${a.employmentsubtype}</option>
																					</c:forEach>
																					<c:forEach var="d" items="${employeementcategory}">
																						<option value="${d.key}">${d.value}</option>
																					</c:forEach>
																				</select>
																			</c:otherwise>
																		</c:choose>
																	</td>
																</tr>


														<tr>
															<td align="center" valign="top" class="cell_bg"
																colspan="3"><input type="submit" value="Submit"
																class="btn_medium"></td>
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
		
												<table width="90%" class="table_bg"
													cellpadding="3" cellspacing="3" border="0" align="center">
													<tr>
														<td>
													<div style="overflow-y:scroll; height: 400px">			
															<table width="100%"  id="myTable"
																	cellpadding="0" cellspacing="1" border="0"
																	class="tablesorter">

																	<thead id="h" align="center" >
																		<tr>
																			<th id="t" width="20%"><img alt=""
																				src="resources/images/sort.gif">Designation</th>
																			<th id="t" width="30%"><img alt=""
																				src="resources/images/sort.gif">Employment Type</th>
																		<th id="t" width="30%"><img alt=""
																				src="resources/images/sort.gif">Employee Category</th>		
																				
																			<th id="t" width="20%" >Action</th>
																		</tr>
																	</thead>

																	<tbody id="b" align="center">
																		<c:forEach items="${designationList}" var="list">

																		<tr>

																			<td>${list.designation}</td>
																			<td>${list.employmenttype}</td>
																			<td>${list.employmentsubtype}</td>
																			

																			<td><a
																				href="editDesignation?ppDesignationmasterid=<c:out value="${list.ppDesignationmasterid}"/>">
																					Edit</a>||
																			<a
																				href="deleteDesignation?ppDesignationmasterid=<c:out value="${list.ppDesignationmasterid}"/>">
																					Delete</a></td>
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