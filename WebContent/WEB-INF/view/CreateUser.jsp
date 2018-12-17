<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM- Create User</title>
<script type="text/javascript" src="resources/js/jquery-latest.js"></script>
<script type="text/javascript" src="resources/js/tablesorter.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#myTable").tablesorter();
	});
</script>
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

			<form action="/UPJN/NewUser" onsubmit="return validate()">

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
															<td class="error" colspan="4">${error}</td>
														</tr>





														<tr>

															<td class="table_head" colspan="4">Role management -
																Create User</td>
														</tr>

														<tr>
															<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
															<td align="right" class="error_normal">* Fields are
																required</td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">Employee
																Name</td>

															<td align="left"><select class="cmb_medium"
																name="ppEmployeemasterid" required id="employeename">
																	<option value="-1">[Select Employee]</option>
																	<c:forEach var="a" items="${listName}">
																		<option value="${a.ppEmployeemasterid}">
																			${a.employeecode}......${a.employeename}</option>
																	</c:forEach>
															</select></td>
														</tr>

														<tr>
															<td></td>
														</tr>


														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Password</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="password" name="password" id="password"
																class="txt_medium" maxlength="15" required /> <span
																class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Confirm
																Password</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="password" id="Confirmpassword"
																name="Confirmpassword" class="txt_medium" maxlength="15"
																required /> <span class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>


														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td><c:forEach items="${rolelist}" var="a">
																	<input type="checkbox" name="roles" id="roles"
																		value="${a.rmRoleid}">${a.rolename}
														     
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
																				src="resources/images/sort.gif">Employee Code</th>
																			<th id="t" width="20%"><img alt=""
																				src="resources/images/sort.gif">Employee Name</th>
																		<th id="t" width="20%"><img alt=""
																				src="resources/images/sort.gif">Employee Designation</th>		
																			<th id="t" width="20%"><img alt=""
																				src="resources/images/sort.gif">Role Name</th>		
																			<th id="t" width="20%" >Action</th>
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
																	href="/UPJN/getresetpassword?ID1=<c:out value="${list.ppEmployeemasterid}"/>"><u>Reset
																			Password</u></a>  ||


																<c:if test="${list.isloginlocked.toString() eq '1'}">
																	<a
																		href="/UPJN/unlockUser?ID1=<c:out value="${list.ppEmployeemasterid}"/>" 
																		onclick="return confirm('Are you sure to unlock ?')"><u>
																				Unlock</u></a> 
																</c:if>
																<c:if test="${list.isloginlocked.toString() eq '0'}">
																	<a
																		href="/UPJN/lockUser?ID1=<c:out value="${list.ppEmployeemasterid}"/>"
																		onclick="return confirm('Are you sure to lock ?')">
																			<u>Lock</u>
																	</a>
																</c:if>
																</td>
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