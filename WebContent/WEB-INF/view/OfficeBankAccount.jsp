<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="javascript" src="resources/js/upjn.js"></script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resources/js/jquery-latest.js"></script>
<script type="text/javascript" src="resources/js/tablesorter.js"></script>
<script language="javascript" src="resources/js/upjn.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#myTable").tablesorter();
		$("#bankid").val($("#bankidvalue").val());
	});
</script>

</head>
<body>
	<div style="height: 100%; width: 100%;">
		<div style="height: 100%; width: 100%; border-bottom: gray solid 4px;">
			<%@include file="/WEB-INF/view/Header.jsp"%>
		</div>

		<div
			style="height: 700px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px; overflow-x: auto;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div
			style="height: 100%; width: 79%; float: left; padding-top: 10px; overflow-x: auto;">

			<form action="/UPJN/OfficeBankAccount">
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td><c:forEach items="${accountinfo}" var="a">
								<input type="hidden" id="bankidvalue" value="${a.masBankid}">
							</c:forEach></td>
					</tr>
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
																colspan="4">Open Bank A/C(s)</td>
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
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="bold" valign="top" align="center" width="43%">
																Office Level</td>
															<td class="cell_bg" valign="top" align="left"><select
																id="hm" name="masOfficelevelid" class="cmb_medium">
																	<option>[Select Level]</option>
																	<c:forEach var="d" items="${Data}">
																		<option value="${d.key}">${d.value}</option>
																	</c:forEach>
															</select></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="bold" valign="top" align="center" width="43%">
																District</td>
															<td align="left" valign="middle" class="cell_bg"><select
																id="district" name="masDistrictid" class="cmb_medium">
																	<option value="-1">[Select District]</option>
																	<c:forEach var="d" items="${Data1}">
																		<option value="${d.key}">${d.value}</option>
																	</c:forEach>
															</select></td>

														</tr>
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="bold" valign="top" align="center" width="43%">
																Office Name</td>
															<td class="cell_bg" valign="top" id="officename"
																align="left"><select id=hmap name="Officeid"
																class="cmb_medium">
																	<option value="-1">[Select Office Name]</option>
																	<c:forEach var="d" items="${officename}">
																		<option value="${d.key}">${d.value}</option>
																		<!-- alert(d.key) -->
																	</c:forEach>
															</select></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="bold" valign="top" align="center" width="43%">
																Account Holder Name</td>
															<td class="cell_bg" valign="top" align="left"><select
																name="acHoldername" class="cmb_medium">
																	<option value="-1">[Report Type]</option>
																	<option value="Managing Director">Managing
																		Director</option>
																	<option value="Chief Engineer">Chief Engineer</option>
																	<option value="Supritendent Engineer">Supritendent
																		Engineer</option>
																	<option value="Executive Engineer">Executive
																		Engineer</option>
																	<option value="Sub Division Officer">Sub
																		Division Officer</option>
																	<option value="Project Manager">Project
																		Manager</option>
																	<option value="General Manager">General
																		Manager</option>
																	<option value="Joint Director">Joint Director</option>
																	<option value="Director C&DS">Director C&DS</option>
																	<option value="Director NW,C&DS">Director
																		NW,C&DS</option>
															</select></td>
														</tr>
														<!--  ---------------------------------------------In case of New-------------------------------------------------------  -->

														<c:if test="${accountinfo == null}">
															<tr>
																<td class="cell_bg" valign="top">&nbsp;</td>
																<td class="bold" valign="top" align="center">A/C
																	Number</td>
																<td class="cell_bg" valign="top" align="left"><input
																	type="text" name="acNumber" class="txt_medium"
																	maxlength="15" required /> <span class="star">*</span></td>
															</tr>

															<tr>
																<td class="cell_bg" valign="top">&nbsp;</td>
																<td class="bold" valign="top" align="center" width="43%">
																	Bank Name</td>
																<td class="cell_bg" valign="top" align="left"><select
																	name="masBankid" class="cmb_medium">
																		<option value="-1">[Select Bank]</option>
																		<c:forEach var="d" items="${banklist}">
																			<option value="${d.masBankid}">${d.bankname}</option>
																		</c:forEach>
																</select></td>
															</tr>

															<tr>
																<td class="cell_bg" valign="top">&nbsp;</td>
																<td class="bold" valign="top" align="center">Branch
																	Name</td>
																<td class="cell_bg" valign="top" align="left"><input
																	type="text" name="branchName" class="txt_medium"
																	required /> <span class="star">*</span></td>
															</tr>

															<tr>
																<td class="cell_bg" valign="top">&nbsp;</td>
																<td class="bold" valign="top" align="center">IFSC
																	CODE</td>
																<td class="cell_bg" valign="top" align="left"><input
																	type="text" name="ifscCode" class="txt_medium" required />
																	<span class="star">*</span></td>


																<td><input type="hidden" value="add" name="root">
																</td>
															</tr>
														</c:if>
														<!-- -------------------------------------In case of Edit------------------------------------------------------------- -->
														<c:if test="${accountinfo != null }">
															<tr>
																<td class="cell_bg" valign="top">&nbsp;</td>
																<td class="bold" valign="top" align="center">A/C
																	Number</td>
																<td class="cell_bg" valign="top" align="left"><c:forEach
																		items="${accountinfo}" var="a">
																		<input type="text" name="acNumber"
																			value="${a.acNumber}" class="txt_medium"
																			maxlength="15" required />
																	</c:forEach> <span class="star">*</span></td>
															</tr>

															<tr>
																<td class="cell_bg" valign="top">&nbsp;</td>
																<td class="bold" valign="top" align="center" width="43%">
																	Bank Name</td>
																<td class="cell_bg" valign="top" align="left"><select
																	name="masBankid" id="bankid" class="cmb_medium">
																		<option value="-1">[Select Bank]</option>
																		<c:forEach var="d" items="${banklist}">
																			<option value="${d.masBankid}">${d.bankname}</option>
																		</c:forEach>
																</select></td>
															</tr>

															<tr>
																<td class="cell_bg" valign="top">&nbsp;</td>
																<td class="bold" valign="top" align="center">Branch
																	Name</td>
																<td class="cell_bg" valign="top" align="left"><c:forEach
																		items="${accountinfo}" var="a">
																		<input type="text" value="${a.branchName}"
																			name="branchName" class="txt_medium" required />
																	</c:forEach> <span class="star">*</span></td>
															</tr>

															<tr>
																<td class="cell_bg" valign="top">&nbsp;</td>
																<td class="bold" valign="top" align="center">IFSC
																	CODE</td>
																<td class="cell_bg" valign="top" align="left"><c:forEach
																		items="${accountinfo}" var="a">
																		<input type="text" value="${a.ifscCode}"
																			name="ifscCode" class="txt_medium" required />
																	</c:forEach> <span class="star">*</span></td>

																<td><input type="hidden" value="edit" name="root">
																</td>
																
																<c:forEach items="${accountinfo}" var="a">
																	<input type="hidden" value="${a.fwaBankaccountid}" name="fwaBankaccountid" class="txt_medium">
																<%-- 	<input type="hidden" value="${a.fwaBankaccountid}" name="fwaBankaccountid" class="txt_medium"> --%>																																				
																</c:forEach>

															</tr>
														</c:if>
														<!-- ------------------------------------------------------------------------------------------------------------------------- -->

														<tr>
															<td valign="top">&nbsp;</td>
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

				<table width="90%" class="table_bg" cellpadding="3" cellspacing="3"
					border="0" align="center">
					<tr>
						<td>
							<div style="overflow-y: scroll; height: 270px">
								<table width="100%" id="myTable" cellpadding="0" cellspacing="1"
									border="0" class="tablesorter">

									<thead id="h" align="center">
										<tr>
											<th id="t" width="15%"><img alt=""
												src="resources/images/sort.gif">A/C Holder Name</th>
											<th id="t" width="15%"><img alt=""
												src="resources/images/sort.gif">A/c Number</th>
											<th id="t" width="15%"><img alt=""
												src="resources/images/sort.gif">Bank Name</th>
											<th id="t" width="15%"><img alt=""
												src="resources/images/sort.gif">Office Name</th>
											<th id="t" width="10%"><img alt=""
												src="resources/images/sort.gif">IFSC CODE</th>
											<th id="t" width="10%"><img alt=""
												src="resources/images/sort.gif">Acc Holder Office</th>
											<th id="t" width="20%">Action</th>
										</tr>
									</thead>

									<tbody id="b" align="center">
										<c:forEach items="${bankaccountList}" var="list">

											<tr>

												<td>${list.AC_HOLDERNAME}</td>
												<td>${list.AC_NUMBER}</td>
												<td>${list.BANKNAME}</td>
												<td>${list.OFFICENAME}</td>
												<td>${list.IFSC_CODE}</td>
												<td>${list.ACC_OFFICENAME}</td>

												<td><a
													href="/UPJN/populateBankAccount?fwaBankaccountid=<c:out value="${list.FWA_BANKACCOUNTID}"/>">
														Edit</a>|| <a
													onclick="javascript:return confirm('Are you sure to delete ?');"
													href="/UPJN/deleteBankAccount?fwaBankaccountid=<c:out value="${list.FWA_BANKACCOUNTID}"/>">
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