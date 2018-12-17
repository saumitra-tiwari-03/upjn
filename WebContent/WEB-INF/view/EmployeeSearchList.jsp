<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM-Employee Search List</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
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
			style="height: 800px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div style="height: 100%; width: 79%; float: left; padding-top: 10px;">
			<form action="/UPJN/employeeDetails" method="post">
				<input type="hidden" name="employeecode" value="${employeecode}">
				<!--  -->
				<script type="text/javascript" src="resources/js/tablesorter.js"></script>

				<table width="90%" class="table_bg" cellpadding="3" cellspacing="3"
					border="0" align="center">
					<tr>
						<td colspan="9" valign="top" class="table_head" align="left">
							List of Employees</td>
						<td colspan="1" valign="top" class="table_head" align="right">
							<a href="/UPJN/searchEmployee"><u>Search Again</u></a>
						</td>
					</tr>
					<tr>
						<td>
							<div style="overflow-y: scroll; height: 600px">
								<table width="100%" id="myTable" cellpadding="0" cellspacing="1"
									border="0" class="tablesorter">

									<thead id="h" align="center">
										<tr>
											<th id="t" width="12%"><img alt=""
												src="resources/images/sort.gif">Employee Code</th>
											<th id="t" width="17%"><img alt=""
												src="resources/images/sort.gif">Employee Name</th>
											<th id="t" width="18%"><img alt=""
												src="resources/images/sort.gif">Employee Father Name</th>
											<th id="t" width="10%"><img alt=""
												src="resources/images/sort.gif">Date of Birth</th>
											<th id="t" width="18%"><img alt=""
												src="resources/images/sort.gif">Designation</th>
											<th id="t" width="25%"><img alt=""
												src="resources/images/sort.gif">Current Status</th>


										</tr>
									</thead>

									<tbody id="b" align="center">
										<c:choose>
											<c:when test="${list!=null}">
												<c:forEach items="${list}" var="list">


													<tr>

														<td width="12%">${list.employeecode}</td>

														<td width="12%">${list.employeename}</td>
														<td width="12%">${list.fathername}</td>
														<td width="12%">${list.dateofbirth}</td>
														<td width="12%">${list.designation}</td>
														<td width="12%">${list.currentstatus}</td>
													</tr>

												</c:forEach>
											</c:when>
											<c:otherwise>
												<c:forEach items="${list1}" var="list">


													<tr>

														<td width="15%">${list.employeecode}</td>

														<td width="15%">${list.employeename}</td>
														<td width="15%">${list.designation}</td>
														<td width="15%">${list.employmenttype}</td>
														<td width="15%">${list.employmentsubtype}</td>
													</tr>
												</c:forEach>
											</c:otherwise>
										</c:choose>
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