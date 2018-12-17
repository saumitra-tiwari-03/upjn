<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM-Reinstate Termination</title>
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
			style="height: 600px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px; overflow-x: auto;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div
			style="height: 100%; width: 79%; float: left; padding-top: 10px; overflow-x: auto;">

			<form action="#" method="post">
				<script type="text/javascript" src="resources/js/tablesorter.js"></script>

				<table width="90%" class="table_bg" cellpadding="3" cellspacing="3"
					border="0" align="center">
					<tr>
						<td colspan="9" valign="top" class="table_head" align="left">
							Re-Instate Termination - List of Employees</td>
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
												src="resources/images/sort.gif">Employee Designation</th>
											<th id="t" width="15%"><img alt=""
												src="resources/images/sort.gif">Employment Type</th>
											<th id="t" width="18%"><img alt=""
												src="resources/images/sort.gif">Employment Category</th>
											<th id="t" width="15%">Action</th>
										</tr>
									</thead>

									<tbody id="b" align="center">
										<c:forEach items="${list}" var="list">
											<tr>

												<td>${list.employeecode}</td>
												<td>${list.employeename}</td>
												<td>${list.designation}</td>
												<td>${list.employmenttype}</td>
												<td>${list.employmentsubtype}</td>
												<td><a
													href="/UPJN/reinstateTerminationdetails?ppTerminationdetailid=<c:out value="${list.ppTerminationdetailid}"/>"><u>
															Re-Instate</u> </a></td>
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
