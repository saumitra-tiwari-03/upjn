<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM-Modify User Role</title>
<script type="text/javascript">
	$(document).ready(function() {
		  $("#myTable").tablesorter();
	});
</script>
<body>
	<script type="text/javascript">
	function validate() {

		var a = document.getElementById("employeename").value;
		var b = document.getElementById("password").value;
		var c = document.getElementById("conpassword").value;
		/* var d = document.getElementById("roles").required; */

		alert(a + "   " + b + "   " + c + "  " + d);

		if (a == -1) {
			alert("required values cannot be null");
			return false;
		}
		if (b != c) {
			alert("password and confirm password should be same");
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

			<form action="/UPJN/addModifyRoleOfUser">
				<input type="hidden" name="ppEmployeemasterid"
					value="${ppEmployeemasterid}">

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
															<td class="msg" align="4">${msg}</td>
														</tr>

														<tr>
															<td class="error" colspan="4">${error}</td>
														</tr>





														<tr>

															<td class="table_head" colspan="4">Role management -
																Create User</td>
														</tr>

														<tr>
															<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
															<td colspan="5" style="padding: 5px;"><b>Select
																	Employee whom Roles are to be assigned -
																	${employeename} </b></td>
														</tr>


														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td><c:forEach items="${rolelist}" var="a">
																	<%
																			boolean check = false;
																		%>
																	<c:forEach items="${rolelistById}" var="b">
																		<c:if test="${a.rmRoleid == b.rmRoleid}">
																			<td><input type="checkbox" checked="checked"
																				name="roles" value="${a.rmRoleid}">
																				${a.rolename}</td>
																			<%
									     						check = true;
															%>
																		</c:if>

																	</c:forEach>
																	<%
															if (check == false) {
																					%>

																	<td><input type="checkbox" name="roles"
																		value="${a.rmRoleid}">${a.rolename}</td>
																	<%
																						}
																					%>


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

				<!--  -->

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
												src="resources/images/sort.gif">Employee Code</th>
											<th id="t" width="20%"><img alt=""
												src="resources/images/sort.gif">Employee Name</th>
											<th id="t" width="20%"><img alt=""
												src="resources/images/sort.gif">Employee Designation</th>
											<th id="t" width="20%"><img alt=""
												src="resources/images/sort.gif"> Role Name</th>
											<th id="t" width="20%">Action</th>
										</tr>
									</thead>

									<tbody id="b" align="center">
										<c:forEach items="${employeelist}" var="list">
											<tr>
												<td>${list.employeecode}</td>
												<td>${list.employeename}</td>
												<td>${list.designation}</td>
												<td>${list.rolename}</td>
												
												<td><a
													href="/UPJN/modificationOfUserRoles?ppEmployeemasterid=<c:out value="${list.ppEmployeemasterid}"/>"><u>
															Modify</u></a> </td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</td>
					</tr>
				</table>


				<!--  -->

			</form>

		</div>

	</div>


</body>

</html>