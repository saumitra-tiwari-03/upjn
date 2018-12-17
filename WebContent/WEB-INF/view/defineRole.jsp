
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="java.util.ArrayList"%>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM- Define Role</title>



<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script language="javascript" src="resources/js/validation.js"></script>
<script language="javascript" src="resources/js/popcalendar.js"></script>
<script language="javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<script src="<c:url value="/resources/js/upjn.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {
		  $("#myTable").tablesorter();
	});
</script>
<script>
 function validateForm() {
	 var x = document.forms["myForm"]["rolename"].value;
	 
	 if (x == null || x == "") {
	        alert("Name must be filled out");
	        return false;
	    }
}


</script>
<body style="margin: 0px 0px 0px 0px;">

	<div style="height: 100%; width: 100%;">

		<div
			style="height: 100px; width: 100%; border-bottom: gray solid 4px;">
			<%@ include file="/WEB-INF/view/Header.jsp"%>
		</div>

		<div
			style="height: 700px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div style="height: 100%; width: 79%; float: left; padding-top: 10px;">

			<form name="myForm" action="/UPJN/createNewRole"
				onsubmit="return validateForm()" method="post">
				<input type="hidden" name="rmRoleid" value="${rmRoleid}">

				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td valign="top" class="msg">${msg}</td>
					</tr>
					<tr>
						<td valign="top" class="error">${error}</td>
					</tr>
					<tr>
						<td valign="top"><table width="70%" align="center"
								cellpadding="0" cellspacing="0" border="0">
								<tr>
									<td valign="top"><table width="100%" align="center"
											cellpadding="0" cellspacing="1" border="0" class="table_bg">
											<tr>
												<td valign="top"><table width="100%" align="center"
														class="cell_bg" cellpadding="3" cellspacing="1" border="0">
														<tr>
															<td align="left" valign="top" class="table_head"
																colspan="4">Role Management - Define Role</td>
														</tr>
														<tr>
															<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
															<td colspan="1" valign="middle" class="error_normal"
																align="right">* Fields are required.</td>
														</tr>
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left" width="43%">
																Role Name</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" name="rolename" maxlength="50"
																value="${roleName}" class="txt_medium"> <span
																class="star">*</span></td>
														</tr>
														<tr>
															<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
														</tr>
														<tr>
															<td colspan="5" align="center" valign="top"
																class="cell_bg"><input type="submit" value="Submit"
																class="btn_medium"> &nbsp; <input type="reset"
																name="reset" value="Reset" class="btn_medium"></td>
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
							<div style="overflow-y: scroll; height: 400px">
								<table width="100%" id="myTable" cellpadding="0" cellspacing="1"
									border="0" class="tablesorter">

									<thead id="h" align="center">
										<tr>
											<th id="t" width="30%"><img alt=""
												src="resources/images/sort.gif">Role Name</th>
											<th id="t" width="30%"><img alt=""
												src="resources/images/sort.gif">Office Name</th>
											<th id="t" width="30%">Action</th>
										</tr>
									</thead>

									<tbody id="b" align="center">
										<c:forEach items="${roleInfoList}" var="list">
											<tr>

												<td>${list.rolename}</td>
												<td>${list.officename}</td>
												<td>
												<td><a
													href="/UPJN/EditDefineRole?rmRoleid=<c:out value="${list.rmRoleid}"/>"><u>Edit</u></a></td>
												<td><a
													href="/UPJN/AssignRightsForDefineRole?rmRoleid=<c:out value="${list.rmRoleid}"/>"><u>Assign
															Rights</u></a></td>
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
