<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<!-- <link href="resources/css/Sorting.css" rel="stylesheet" type="text/css" /> -->

<script type="text/javascript" src="resources/js/jquery-latest.js"></script>
<script type="text/javascript" src="resources/js/tablesorter.js"></script>
<title>UP Jal Nigam</title>

<script type="text/javascript">
	$(document).ready(function() {
		$("#mas_StateID").val($("#stateid").val());
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

		<div
			style="height: 100%; width: 79%; float: left; padding-top: 10px; overflow-x: auto;">

			<c:if test="${districtdetails == null}">
				<form action="/UPJN/insertNewDistrict" method="post">
			</c:if>
			<c:if test="${districtdetails != null}">
				<form action="/UPJN/editDistrict" method="post">
			</c:if>

			<!-- ---------- -->

			<c:forEach items="${districtdetails}" var="a">
				<input type="hidden" value="${a.MAS_STATEID}" id="stateid">
				<input type="hidden" value="${a.masDistrictid}"
					name="mas_DistrictID">
			</c:forEach>

			<!-- ---------- -->
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td valign="top" class="msg">${mes}</td>

				</tr>
				<tr>
					<td valign="top" class="error">${error}</td>
				</tr>
				<tr>
					<td valign="top"><table width="98%" border="0" align="center"
							cellpadding="0" cellspacing="0">
							<tr>
								<td align="center" valign="top"><table width="60%"
										border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td valign="top"><table width="100%" border="0"
													cellspacing="0" cellpadding="0">
													<tr>
														<td valign="top" class="table_bg"><table width="100%"
																border="0" cellspacing="0" cellpadding="3">
																<tr>
																	<td colspan="3" valign="top" class="table_head"
																		align="left">Master - District Master</td>
																</tr>
																<tr>
																	<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
																	<td colspan="1" valign="middle" class="error_normal"
																		align="right">* Fields are required.</td>
																</tr>

																<!-- -------------------------------------New------------------------------------------------- -->
																<c:if test="${districtdetails == null}">
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td width="40%" align="left" valign="top"
																			class="cell_bg">State Name</td>
																		<td align="left" valign="top" class="cell_bg"><select
																			name="mas_StateID" style="width: 160px"
																			class="cmb_medium"><option value="-1">[Select
																					State]</option>
																				<c:forEach var="d" items="${stateMap}">
																					<option value="${d.key}">${d.value}</option>
																				</c:forEach>
																		</select><span class="star"> *</span></td>
																	</tr>
																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg"><span
																			class="cell_bg"> Census District Code </span></td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="text" name="censusDistrictCode" maxlength="250"
																			class="txt_medium"> <span class="star">
																				*</span></td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			District Name</td>
																		<td align="left" valign="top" class="cell_bg"><input
																			type="text" name="districtName" maxlength="250"
																			onkeyup="this.value=this.value.toUpperCase();"
																			class="txt_medium"><span class="star">
																				*</span></td>
																	</tr>
																</c:if>
																<!-- --------------------------------------Edit-------------------------------------------------------- -->
																<c:if test="${districtdetails != null}">
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td width="40%" align="left" valign="top"
																			class="cell_bg">State Name</td>
																		<td align="left" valign="top" class="cell_bg"><select
																			id="mas_StateID" name="mas_StateID"
																			style="width: 160px" class="cmb_medium"><option
																					value="-1">[Select State]</option>
																				<c:forEach var="d" items="${stateMap}">
																					<option value="${d.key}">${d.value}</option>
																				</c:forEach>
																		</select><span class="star"> *</span></td>
																	</tr>
																	<tr>
																		<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg"><span
																			class="cell_bg"> Census District Code </span></td>
																		<td align="left" valign="top" class="cell_bg"><c:forEach
																				items="${districtdetails}" var="a">
																				<input type="text" name="censusDistrictCode"
																					maxlength="250" value="${a.censusdistrictcode}"
																					class="txt_medium">
																			</c:forEach><span class="star"> *</span></td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">
																			District Name</td>
																		<td align="left" valign="top" class="cell_bg"><c:forEach
																				items="${districtdetails}" var="a">
																				<input type="text" name="districtName"
																					maxlength="250" value="${a.districtname}"
																					onkeyup="this.value=this.value.toUpperCase();"
																					class="txt_medium">
																			</c:forEach> <span class="star"> *</span></td>
																	</tr>
																</c:if>
																<!-- ------------------------------------------------------------------------------------------------------------------------- -->
																<tr>
																	<td colspan="3" valign="top" class="cell_bg">&nbsp;</td>
																</tr>
																<tr>
																	<td colspan="3" valign="top" class="cell_bg">&nbsp;</td>
																</tr>

																<tr>
																	<td colspan="3" align="center" valign="top"
																		class="cell_bg"><input type="submit"
																		value="Submit" class="btn_medium"> &nbsp; <input
																		type="reset" value="Reset" class="btn_medium"></td>
																</tr>
															</table></td>
													</tr>
												</table></td>
										</tr>
									</table></td>
							</tr>
						</table>
			</table>
			<br>
			<script type="text/javascript" src="resources/js/tablesorter.js"></script>
<style type="text/css">
.tablesorter {
    width: 100%;
    display:block;
}
#h {
    display: inline-block;
    width: 100%;
    height: 20px;
    /* border: 1px solid black; */
}
#b {
    height: 300px;
    display: inline-block;
    width: 100%;
    overflow: auto;
}
</style>
			<!--  -->
		
												<table width="90%" class="table_bg"
													cellpadding="3" cellspacing="3" border="0" align="center">
													<tr>
														<td>
															<table width="100%"  id="myTable"
																	cellpadding="0" cellspacing="1" border="0"
																	class="tablesorter">

																	<thead id="h" align="center">
																		<tr>
																			<th id="t" width="20%"><img alt=""
																				src="resources/images/sort.gif">Census
																				District Code</th>
																			<th id="t" width="70%"><img alt=""
																				src="resources/images/sort.gif">District Name</th>
																			<th id="t" width="10%" >Action</th>
																		</tr>
																	</thead>

																	<tbody id="b" align="center">
																		<c:forEach items="${districtList}" var="list">
																			<tr>

																				<td width="20%" align="center">${list.censusdistrictcode}</td>
																				<td width="70%" align="center">${list.districtname}</td>




																				<td width="10%" align="center"><a
																					href="/UPJN/EditDistrictMaster?masDistrictid=<c:out value="${list.masDistrictid}"/>"><u>Edit</u>
																				</a> || <a
																					href="/UPJN/DeleteDistrictMaster?masDistrictid=<c:out value="${list.masDistrictid}"/>">
																						<u> Delete </u>
																				</a></td>
																			</tr>
																		</c:forEach>
																	</tbody>
																</table>
															
														</td>
													</tr>
												</table>
								
			</form>
		</div>
	</div>


</body>

</html>