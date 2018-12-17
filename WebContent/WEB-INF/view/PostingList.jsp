<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="java.util.ArrayList"%>
<html>
<head>
<title>U.P JAL NIGAM-Posting List</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/js/jquery-latest.js"></script>
<script type="text/javascript" src="resources/js/tablesorter.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#myTable").tablesorter();
	});
</script>
</head>



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
			<form action="/NewPosting" method="post">
			<!--  -->
				<script type="text/javascript" src="resources/js/tablesorter.js"></script>
				
				<table width="90%" class="table_bg" cellpadding="3" cellspacing="3"
					border="0" align="center">
					<tr>
												<td colspan="9" valign="top" class="table_head" align="left">
												Posting - List of Employees</td>
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
											<th id="t" width="13%"><img alt=""
												src="resources/images/sort.gif">Employee Designation</th>
											<th id="t" width="10%"><img alt=""
												src="resources/images/sort.gif">Employment Type</th>
											<th id="t" width="18%"><img alt=""
												src="resources/images/sort.gif">Employment Category</th>
												<th id="t" width="15%"><img alt=""
												src="resources/images/sort.gif">Posting Against</th>

											<th id="t" width="10%">Action</th>
										</tr>
									</thead>

									<tbody id="b" align="center">
										<c:forEach items="${list}" var="list">
															<input type="hidden" id="ppEmployeemasterid"
																	value="${list.ppEmployeemasterid}"
																	name="ppEmployeemasterid" />
															<tr>															
																<td>${list.employeecode}</td>
																<td>${list.employeename}</td>
																<td>${list.designation}</td>
																<td>${list.employmenttype}</td>
																<td>${list.employmentsubtype}</td>
																<td>${list.postingagainst}</td>
															
																<td><a
																	href="/UPJN/EmployeePosting?ppEmployeemasterid=<c:out value="${list.ppEmployeemasterid}"/>"><u>Posting</u></a></td>
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