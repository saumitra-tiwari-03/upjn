<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM-Modification Role List</title>
<script type="text/javascript">
	
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

	

				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td align="center" valign="top"><table width="100%"
								border="0" cellspacing="1" cellpadding="1">
								<tr>
									<td valign="top"><table width="100%" border="0"
											cellspacing="3" cellpadding="3">
											<tr>
												<td valign="top" class="table_bg">
													<table width="100%" align="center" class="cell_bg"
														cellpadding="2" cellspacing="2">

														<tr>
															<td id="t"><img alt=""
																src="resources/images/sort.gif">Employee Code</td>
															<td id="t"><img alt=""
																src="resources/images/sort.gif">Employee Name</td>
															<td id="t"><img alt=""
																src="resources/images/sort.gif">Employee
																Designation</td>
															<td id="t"><img alt=""
																src="resources/images/sort.gif">Role Name</td>

															<td id="t">Action</td>
														</tr>

														<c:forEach items="${employeelist}" var="list">
															<tr>
																<td>${list.employeecode}</td>
																<td>${list.employeename}</td>
																<td>${list.designation}</td>
																<td>${list.rolename}</td>
																<td>
																<td><a
																	href="/UPJN/modificationOfUserRoles?ppEmployeemasterid=<c:out value="${list.ppEmployeemasterid}"/>"><u>
																			Modify</u></a>
															</tr>
														</c:forEach>


													</table>

												</td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table>

				<!--  -->

			

		</div>


</body>

</html>