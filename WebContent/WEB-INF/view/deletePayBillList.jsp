<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>U.P JAL NIGAM- Delete Pay Bill List</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script language="javascript" src="resources/js/validation.js"></script>
<script language="javascript" src="resources/js/popcalendar.js"></script>
<script language="javascript" src="resources/js/NEW_NEW.js"></script>
<script language="javascript" src="resources/js/upjn.js"></script>

<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>

</head>

<body>

	<script type="text/javascript" language="Javascript1.1">
		
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
			<form name="issueLPCActionForm" method="post"
				action="/upjn/PayBillDelete.do">
				<!--
				This is to change the method of the action 
				first for edit else for add operation.
			-->
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td valign="top" class="msg">
						${mes}
						</td>
					</tr>
					<tr>
						<td valign="top" class="error"></td>
					</tr>
					<tr>
						<td valign="top"><table width="100%" align="center"
								cellpadding="0" cellspacing="1" border="0" class="table_bg">
								<tr>
									<td valign="top"><table width="100%" align="center"
											class="cell_bg" cellpadding="3" cellspacing="3" border="0">
											<tr>
												<td colspan="6" align="left" valign="top" class="table_head"
													width="100%">Bill Detail</td>
											</tr>
											<tr>
												<td width="28%" align="left" valign="top" class="bold">Regular
													Pay Bills</td>
												<td width="20%" align="left" valign="top" class="bold">Register
													Name</td>
												<td width="10%" align="left" valign="top" class="bold">Bill
													No.</td>
												<td width="20%" align="right" valign="top" class="bold">Bill
													Amount</td>
												<td width="20%" align="right" valign="top" class="bold">Pay
													Bill Date</td>
												<td width="2%" align="left" valign="top" class="bold">Action</td>
											</tr>



											<c:forEach items="${payBillList}" var="list">
												<tr>

													<td>salary , ${list.month} ${list.year}</td>
													<td>${list.registerName}</td>
													<td>${list.billNO}</td>
													<td>${list.billAmount}</td>
													<td>${list.billDate}</td>


													<td><a
														href="deletePayBillLogic?pp_PayBillDetailID=<c:out value="${list.pp_PayBillDetailID}"/>">
															DELETE</a></td>



													<td>
												</tr>
											</c:forEach>








											<tr>
												<td colspan="1" align="right" valign="top" class="cell_bg"></td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
</html>