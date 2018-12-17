<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM- Master</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resources/js/jquery-latest.js"></script>
<script type="text/javascript" src="resources/js/tablesorter.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
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

			<form action="/UPJN/insertDeductionMaster">

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
															<td class="msg" colspan="4">${msg}</td>
														</tr>
														<tr>
															<td class="table_head" colspan="4">Manage Deduction</td>
														</tr>

														<tr>
															<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
															<td align="right" class="error_normal">* Fields are
																required</td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">Deduction
																Name</td>

															<td align="left"><input type="text" name="deductionName"
																class="txt_medium"></td>
														</tr>


														<tr>
															<td></td>
														</tr>


														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">Deduction
																Short Name</td>

															<td align="left"><input type="text" name="dedShortName"
																class="txt_medium"></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">Employee
																Category</td>

															<td class="cell_bg" valign="top" align="left" width="43%">Default
																Value</td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left"><c:forEach
																	items="${Employmenttypelist}" var="a">
															
																	${a.employmenttype}
																	
																	
																<input type="checkbox" name="mas_EmploymentTypeID"
																		value="${a.masEmploymenttypeid}"><br>
																</c:forEach></td>
														</tr>

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
											<th id="t" width="30%"><img alt=""
												src="resources/images/sort.gif">Deduction Name</th>
											<th id="t" width="30%"><img alt=""
												src="resources/images/sort.gif">Deduction Short name</th>
											<th id="t" width="40%">Action</th>
										</tr>
									</thead>

									<tbody id="b" align="center">
										<c:forEach items="${deductionlist}" var="list">
											<tr>
												<td>${list.deductionname}</td>
												<td>${list.dedshortname}</td>
												<td><a href="#"> Edit</a>|| <a href="#"> Delete</a></td>
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