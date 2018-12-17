
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



			<form method="post" action="/UPJN/addNewLoanDetails">
			<input type="hidden" name="pp_LoanMasterID" value="${pp_LoanMasterID}">


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
																colspan="4">Loan Master</td>
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
															<td align="left" valign="top" class="cell_bg">Loan
																Name</td>
															<td align="left" valign="top" class="cell_bg" colspan="3"><c:choose>
																	<c:when test="${list==null}">
																		<input type="text" class="txt_medium" name="loanName"
																			id="loanName" required maxlength="40">

																		<span class="star">*</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${list}" var="a">
																			<input type="text" class="txt_medium" maxlength="40"
																				name="loanName" id="loanName" value="${a.loanname}"
																				maxlength="40" required>
																		</c:forEach>
																		<span class="star">*</span>
																	</c:otherwise>
																</c:choose></td>
														</tr>




														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">Loan
																ShortName</td>
															<td align="left" valign="top" class="cell_bg" colspan="3"><c:choose>
																	<c:when test="${list==null}">
																		<input type="text" class="txt_medium"
																			name="loanShortName" id="loanShortName" required
																			maxlength="40">

																		<span class="star">*</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${list}" var="a">
																			<input type="text" class="txt_medium" maxlength="40"
																				name="loanShortName" id="loanShortName"
																				value="${a.loanshortname}" maxlength="40" required>
																		</c:forEach>
																		<span class="star">*</span>
																	</c:otherwise>
																</c:choose></td>
														</tr>



														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">Is
																Interest Bearing</td>
															<td align="left" valign="top" class="cell_bg" colspan="3"><c:choose>
																	<c:when test="${list==null}">
																		<input type="text" class="txt_medium"
																			name="pp_ScheduleMasterID" id="pp_ScheduleMasterID"
																			required maxlength="40">

																		<span class="star">*</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${list}" var="a">
																			<input type="text" class="txt_medium" maxlength="40"
																				name="pp_ScheduleMasterID" id="pp_ScheduleMasterID"
																				value="${a.ppSchedulemasterid}" maxlength="40"
																				required>

																		</c:forEach>
																		<span class="star">*</span>
																	</c:otherwise>
																</c:choose></td>
														</tr>



														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">Max
																Installments</td>
															<td align="left" valign="top" class="cell_bg" colspan="3"><c:choose>
																	<c:when test="${list==null}">
																		<input type="text" class="txt_medium"
																			name="max_InstallmentNo" id="max_InstallmentNo"
																			required maxlength="40">

																		<span class="star">*</span>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${list}" var="a">
																			<input type="text" class="txt_medium" maxlength="40"
																				name="max_InstallmentNo" id="max_InstallmentNo"
																				value="${a.maxInstallmentno}" maxlength="40"
																				required>
																			<span class="star">*</span>
																		</c:forEach>
																	</c:otherwise>
																</c:choose></td>
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
				<table width="95%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td align="center" valign="top"><table width="100%"
								border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td valign="top"><table width="100%" border="0"
											cellspacing="1" cellpadding="1">
											<tr>
												<td valign="top" class="table_bg">


													<table cellspacing="0" cellpadding="0" border="0"
														align="CENTER" class="FORM">
														<tr>
															<td valign="top"><table cellspacing="1"
																	cellpadding="1" border="0" width="100%">






																	<tr valign="top">
																		<th class="FORM"><table border="0" width="100%">
																				<tr>

																					<td>Loan Name</td>
																				</tr>
																			</table></th>
																		<th class="FORM"><table border="0" width="100%">
																				<tr>

																					<td>Loan ShortName</td>
																				</tr>
																			</table></th>
																		<th class="FORM"><table border="0" width="100%">
																				<tr>

																					<td>Max Amount</td>
																				</tr>
																			</table></th>
																		<th class="FORM"><table border="0" width="100%">
																				<tr>

																					<td>Max Installment</td>
																				</tr>
																			</table></th>
																		<th class="FORM"><table border="0" width="100%">
																				<tr>

																				</tr>
																			</table></th>
																		<th class="FORM" width="8%">Action</th>
																	</tr>


																	<c:forEach items="${loanMasterList}" var="list">

																		<tr>

																			<td>${list.loanname}</td>
																			<td>${list.loanshortname}</td>
																			<td>${list.ppSchedulemasterid}</td>
																			<td>${list.maxInstallmentno}</td>

																			<td><a
																				href="editLoan?ppLoanmasterid=<c:out value="${list.ppLoanmasterid}"/>">
																					EDIT</a></td>
																			<td><a
																				href="deleteNewLoanInfo?ppLoanmasterid=<c:out value="${list.ppLoanmasterid}"/>">
																					DELETE</a></td>
																		</tr>
																	</c:forEach>

																</table>
													</table>
												</td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table>

			</form>
		</div>
	</div>

</body>
</html>