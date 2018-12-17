<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM- Master</title>
<script type="text/javascript">
	
</script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resources/js/jquery-latest.js"></script>
<script type="text/javascript" src="resources/js/tablesorter.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#myTable").tablesorter();
		$("#category").val($("#id").val());
	});
</script>
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
			
			<!--  -->
			<c:if test="${info == null}">
				<form action="/UPJN/insertQualificationTrainingMaster">
			</c:if>
			<c:if test="${info != null}">
				<form action="/UPJN/editQualificationTrainingMaster">
			</c:if>
			<!--  -->


			<!--  -->
			<c:if test="${selectedtype eq 'Qualification'}">
				<input type="hidden" id="id" value="Qualification" name="selectedtype">
                 <c:forEach items="${info}" var="a">
                   <input type="hidden" name="masterid" value="${a.ppQualificationmasterid}">
                 </c:forEach>
			</c:if>

			<c:if test="${selectedtype ne 'Qualification'}">
				<input type="hidden" id="id" value="Training" name="selectedtype">
				  <c:forEach items="${info}" var="a">
                   <input type="hidden" name="masterid" value="${a.ppTrainingtypemasterid}">
                 </c:forEach>
			</c:if>

			<!--  -->

			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0">

				<tr>
					<td align="center" valign="top"><table width="100%" border="0"
							cellspacing="1" cellpadding="1">
							<tr>
								<td valign="top"><table width="100%" border="0"
										cellspacing="3" cellpadding="3">
										<tr>
											<td valign="top" class="table_bg">
												<table border="0" width="100%">
													<tr>
														<td class="msg" colspan="4">${msg}</td>
													</tr>
													<tr>
														<td class="table_head" colspan="4">Master - Add
															Training/Qualification</td>
													</tr>

													<tr>
														<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
														<td align="right" class="error_normal">* Fields are
															required</td>
													</tr>

													<!-- ------------------------------  In case of New -------------------------------------------------------- -->
													<c:if test="${info == null}">
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">Category</td>

															<td align="left"><select class="cmb_medium"
																name="category" required>
																	<option value="-1">[Select Category]</option>
																	<option value="Qualification">Qualification</option>
																	<option value="Training">Training Type</option>

															</select></td>
														</tr>

														<tr>
															<td></td>
														</tr>


														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">Name</td>

															<td align="left"><input type="text" name="name"
																class="txt_medium"></td>
														</tr>
													</c:if>
													<!-- ----------------------------------------In case of Edit---------------------------------------------------------- -->
													<c:if test="${info != null}">
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">Category</td>

															<td align="left"><select class="cmb_medium"
																id="category" name="category" required>
																	<option value="-1">[Select Category]</option>
																	<option value="Qualification">Qualification</option>
																	<option value="Training">Training Type</option>

															</select></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">Name</td>

															<c:if test="${selectedtype eq 'Qualification'}">
																<c:forEach items="${info}" var="a">
																	<td><input type="text" name="name"
																		value="${a.qualification}" class="cmb_medium"><span
																		class="star">*</span></td>
																</c:forEach>
															</c:if>

															<c:if test="${selectedtype ne 'Qualification'}">
																<c:forEach items="${info}" var="a">
																	<td><input type="text" name="name"
																		value="${a.trainingtype}" class="cmb_medium"><span
																		class="star">*</span></td>
																</c:forEach>
															</c:if>
														</tr>
													</c:if>


													<!-- ----------------------------------------------------------------------------------- -->
													<tr>
														<td></td>
													</tr>


													<tr>
														<td class="cell_bg" valign="top">&nbsp;</td>
														<td colspan="5" align="center" valign="top"
															class="cell_bg"><input type="submit" value="Submit"
															class="btn_medium"> <input type="reset"
															value="Reset" class="btn_medium"></td>
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

			<!-- -------------Data Fields--------------- -->
			<br>
			<script type="text/javascript" src="resources/js/tablesorter.js"></script>

			<table width="90%" class="table_bg" cellpadding="3" cellspacing="3"
				border="0" align="center">
				<tr>
					<td>
						<div style="overflow-y: scroll; height: 400px">
							<table width="100%" id="myTable" cellpadding="0" cellspacing="1"
								border="0" class="tablesorter">

								<thead id="h" align="center">
									<tr>

										<c:if test="${selectedtype eq 'Qualification'}">
											<th id="t" width="60%"><img alt=""
												src="resources/images/sort.gif"> Qualification</th>
										</c:if>
										<c:if test="${selectedtype ne 'Qualification'}">
											<th id="t" width="60%"><img alt=""
												src="resources/images/sort.gif"> Training</th>
										</c:if>

										<th id="t" width="20%">Action</th>
									</tr>
								</thead>

								<tbody id="b" align="center">
									<c:forEach items="${list}" var="list">

										<tr>

											<c:if test="${selectedtype eq 'Qualification'}">
												<td>${list.qualification}</td>
												<td><a
													href="/UPJN/populateQualification?ppQualificationmasterid=${list.ppQualificationmasterid}">Edit</a>
													|| <a href="/UPJN/deleteQualification?ppQualificationmasterid=${list.ppQualificationmasterid}"> Delete</a></td>
											</c:if>

											<c:if test="${selectedtype ne 'Qualification'}">
												<td>${list.trainingtype}</td>
												<td><a
													href="/UPJN/populateTraining?ppTrainingtypemasterid=${list.ppTrainingtypemasterid}">Edit</a>
													|| <a href="/UPJN/deleteTraining?ppTrainingtypemasterid=${list.ppTrainingtypemasterid}"> Delete</a></td>
											</c:if>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</td>
				</tr>
			</table>

			<!-- --------------------------------------------  -->

			</form>

		</div>

	</div>


</body>

</html>