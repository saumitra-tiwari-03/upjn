<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM- HeadQuarter Master</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script type="text/javascript" src="resources/js/validation.js"></script>
<script type="text/javascript" src="resources/js/popcalendar.js"></script>
<script type="text/javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<script src="<c:url value="/resources/js/upjn.js" />"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#masDistrictid").val($("#districtID").val());
		$("#ppTowncategorymasterid").val($("#townid").val());
		$("#myTable").tablesorter();
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

		<div align="center"
			style="height: 100%; width: 79%; float: left; padding-top: 10px; overflow-x: auto;">

			<c:if test="${placeinfo == null}">
				<form action="/UPJN/insertHeadQuarter">
			</c:if>
			<c:if test="${placeinfo != null}">
				<form action="/UPJN/editheadquarter">
			</c:if>

			<!--  -->

			<c:forEach items="${placeinfo}" var="a">
				<tr>
					<td><input type="hidden" name="townid" id="townid"
						value="${a.ppTowncategorymasterid}"> <input type="hidden"
						name="districtID" id="districtID" value="${a.masDistrictid}">
						<input type="hidden" name="ppPlacemasterid"
						value="${a.ppPlacemasterid}"></td>
				</tr>
			</c:forEach>

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

														<td class="table_head" colspan="4">Master -
															HeadQuarterMaster</td>
													</tr>

													<tr>
														<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
														<td align="right" class="error_normal">* Fields are
															required</td>
													</tr>

													<!-- ------------------------------  In case of New -------------------------------------------------------- -->




													<c:if test="${placeinfo == null}">
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">District</td>
															<td class="cell_bg" valign="top" align="left"><select
																name="masDistrictid" class="cmb_medium">
																	<option value="-1">[Select District]</option>
																	<c:forEach var="d" items="${districtlist}">
																		<option value="${d.masDistrictid}">${d.districtname}</option>
																	</c:forEach>
															</select> <span class="star">*</span></td>
														</tr>


														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Head
																Quarter Name</td>
															<td><input type="text" name="place"
																class="cmb_medium"><span class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>



														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Category</td>
															<td class="cell_bg" valign="top" align="left"><select
																name="ppTowncategorymasterid" class="cmb_medium">
																	<option value="-1">[Select Category]</option>
																	<c:forEach var="d" items="${towncategorylist}">
																		<option value="${d.ppTowncategorymasterid}">${d.categorytype}</option>
																	</c:forEach>
															</select> <span class="star">*</span></td>
														</tr>

													</c:if>



													<!-- ----------------------------------------In case of Edit---------------------------------------------------------- -->
													<c:if test="${placeinfo != null}">

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">District
															</td>
															<td class="cell_bg" valign="top" align="left"><select
																id="masDistrictid" name="masDistrictid"
																class="cmb_medium">
																	<option value="-1">[Select District]</option>
																	<c:forEach var="d" items="${districtlist}">
																		<option value="${d.masDistrictid}">${d.districtname}</option>
																	</c:forEach>
															</select> <span class="star">*</span></td>
														</tr>


														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Head
																Quarter Name</td>

															<c:forEach items="${placeinfo}" var="a">
																<td><input type="text" name="place"
																	value="${a.place}" class="cmb_medium"><span
																	class="star">*</span></td>
															</c:forEach>

														</tr>

														<tr>
															<td></td>
														</tr>



														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Category</td>
															<td class="cell_bg" valign="top" align="left"><select
																id="ppTowncategorymasterid"
																name="ppTowncategorymasterid" class="cmb_medium">
																	<option value="-1">[Select Category]</option>
																	<c:forEach var="d" items="${towncategorylist}">
																		<option value="${d.ppTowncategorymasterid}">${d.categorytype}</option>
																	</c:forEach>
															</select> <span class="star">*</span></td>
														</tr>

													</c:if>
													<!-- -------------------------------------------------------------------------------------------------------------------------------- -->

													<tr>
														<td></td>
													</tr>

													<tr>
														<td colspan="3" align="center" valign="top"
															class="cell_bg"><input type="submit" value="Submit"
															class="btn_medium"> &nbsp; <input type="reset"
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

			<!--  -->
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
										<th id="t" width="20%"><img alt=""
											src="resources/images/sort.gif">District Name</th>
										<th id="t" width="30%"><img alt=""
											src="resources/images/sort.gif">head Quarter Name</th>
																		
										<th id="t" width="30%"><img alt=""
											src="resources/images/sort.gif"> Category</th>

										<th id="t" width="20%">Action</th>
									</tr>
								</thead>

								<tbody id="b" align="center">
									<c:forEach items="${placemaster}" var="list">
																	<tr>
																		<td>${list.districtname}</td>
																		<td>${list.place}</td>
																		<td>${list.categorytype}</td>
																		<td><a href="/UPJN/populatePlace?ppPlacemasterid=${list.ppPlacemasterid}">Edit</a> || 
																		<a href="/UPJN/deleteHeadQuarter?ppPlacemasterid=${list.ppPlacemasterid}" onclick="javascript:return confirm('Are you sure you want to delete ?');">Delete</a>
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