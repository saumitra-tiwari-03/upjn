<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>U.P JAL NIGAM-Update Pay Detail - Select Register</title>

<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<link href="resources/css/upjnBeta.css" rel="stylesheet" type="text/css" />
<script src="resources/js/validation.js" type="text/javascript"></script>
<script>
	function registerSelect() {
		var registerV = document.getElementById('registerList');
		var queryString = "location.href='/UPJN/getAddPayEmployeeList?register="
				+ registerV.value + "'";
		var button = document.getElementById('registerButton').setAttribute(
				"onclick", queryString);

	}
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#myTable").tablesorter();
	});
</script>

</head>
<body style="margin: 0px 0px 0px 0px;">
	<div style="height: 100%; width: 100%;">
		<!-- Page Header -->
		<div
			style="height: 100px; width: 100%; border-bottom: gray solid 4px;">
			<%@ include file="/WEB-INF/view/Header.jsp"%>
		</div>
		<!-- Page Menu -->
		<div
			style="height: 600px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px; overflow-x: auto;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>
		<!-- Page Body -->
		<div
			style="height: 100%; width: 79%; float: left; padding-top: 10px; overflow-x: auto;">
			<span>${msg_sectionMaster}</span>
			<div id="selectRegisterDiv">
				<c:choose>
					<c:when test="${selectRegister == true}">
						<form action="/UPJN/PayBill" method="post">
							<table width="95%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td align="center" valign="top"><table width="100%"
											border="0" cellspacing="1" cellpadding="1">
											<tr>
												<td valign="top"><table width="100%" border="0"
														cellspacing="3" cellpadding="3">
														<tr>
															<td valign="top" class="table_bg">
																<table border="0" width="100%">
															

																	<tr>

																		<td class="table_head" colspan="4">Pay Bill
																			Preparation</td>
																	</tr>

																	<tr>
																		<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="right" class="error_normal">* Fields
																			are required</td>
																	</tr>

																	<tr>
																		<td></td>
																	</tr>


																	<tr>
																		<td class="cell_bg" valign="top">&nbsp;</td>
																		<td class="cell_bg" valign="top" align="left"
																			width="43%">Register Name</td>

																		<td align="left"><select class="cmb_small"
																			id="registerList" style="width: 200px"
																			name="ppRegistermasterid"
																			onchange="registerSelect();">
																				<option value="-1">[Select Register]</option>
																				<c:forEach items="${registerList}" var="list">
																					<option
																						value="<c:out value="${list.ppRegistermasterid}"/>"><c:out
																							value="${list.registername}" /></option>
																				</c:forEach>
																		</select></td>
																	</tr>

																	<tr>
																		<td></td>
																	</tr>
																	<tr>
																		<td></td>
																	</tr>

																	<tr>

																		<td colspan="4" align="center" valign="top"
																			class="cell_bg"><input class="btn_large"
																			type="submit" name="updatePayDetails"
																			value="Update Pay Detail" /> <input
																			class="btn_medium" type="submit"
																			name="monthlyPayBill" value="Monthly Bill" /></td>
																	</tr>
																	<tr>
																		<td></td>
																	</tr>
																	<tr>
																		<td></td>
																	</tr>
																</table>
															</td>
														</tr>
													</table></td>
											</tr>
										</table></td>
								</tr>
							</table>
						</form>
					</c:when>
					<c:otherwise>

						<script type="text/javascript" src="resources/js/tablesorter.js"></script>

						<!--  -->

						<table width="90%" class="table_bg" cellpadding="3"
							cellspacing="3" border="0" align="center">
							<tr>
								<td>
									<div style="overflow-y: scroll; height: 600px">
										<table width="100%" id="myTable" cellpadding="0"
											cellspacing="1" border="0" class="tablesorter">

											<thead id="h" align="center">
												<tr>
													<th id="t" width="15%"><img alt=""
														src="resources/images/sort.gif">Employee Code</th>
													<th id="t" width="17%"><img alt=""
														src="resources/images/sort.gif">Employee Name</th>
													<th id="t" width="17%"><img alt=""
														src="resources/images/sort.gif">Designation</th>
													<th id="t" width="17%"><img alt=""
														src="resources/images/sort.gif">Section Name</th>
													<th id="t" width="17%"><img alt=""
														src="resources/images/sort.gif">Employment Type</th>
													<th id="t" width="17%">Action</th>
												</tr>
											</thead>

											<tbody id="b" align="center">
												<c:forEach items="${empList}" var="empList">
													<tr>
														<td><c:out value="${empList.employeecode }" /></td>

														<td><c:out value="${empList.employeename }" /></td>

														<td><c:out value="${empList.designation }" /></td>

														<td><c:out value="${empList.sectionname }" /></td>

														<td><c:out value="${empList.employmenttype }" /></td>

														<c:choose>
															<c:when test="${empList.iseditable != 0}">
																<td><a
																	href="/UPJN/populateEmployeePayDetail?ppEmployemasterID=<c:out value="${empList.ppEmployeemasterid }"/>">Edit</a>
																</td>
															</c:when>
															<c:otherwise>
																<td><a
																	href="/UPJN/populateEmployeePayDetail?ppEmployemasterID=<c:out value="${empList.ppEmployeemasterid }"/>">Add</a>
																</td>
															</c:otherwise>
														</c:choose>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</td>
							</tr>
						</table>


					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>