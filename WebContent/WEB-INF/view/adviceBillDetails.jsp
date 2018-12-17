<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UP Jal Nigam - Bill Advice PayBill Detail List</title>
<script type="text/javascript">
	
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
			style="height: 700px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px; overflow-x: auto;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div
			style="height: 100%; width: 79%; float: left; padding-top: 10px; overflow-x: auto;">
			<form action="/UPJN/generateBillAdviceReport" method="post">
				<input type="hidden" name="monthName" value="${monthName}">
				<input type="hidden" name="yearName" value="${yearName}">
				<input type="hidden" name="sysPaymentmodeid"
					value="${sysPaymentmodeid}">
					
				<!--
				This is to change the method of the action 
				first for edit else for add operation.
			-->
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td valign="top" class="msg"></td>
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
												<td width="2%" align="left" valign="top" class="bold">&nbsp;</td>
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
											</tr>


											<c:forEach items="${payBillDetailList}" var="list">
												<tr>


                                                   
													<td><input type="radio" name="pp_PayBillDetailID" value="${list.PP_PAYBILLDETAILID}"></td>
													<td>salary , ${list.MONTH} ${list.YEAR}</td>
													<td>${list.REGISTERNAME}</td>
													<td>${list.BILLNO}</td>
													<td>${list.BILLAMOUNT}</td>
													<td>${list.BILLDATE}</td>

												</tr>
											</c:forEach>



											<tr>
												<td colspan="6" align="center" valign="top" class="cell_bg">
													<input type="submit" value="Submit" class="btn_medium">
													&nbsp; <input type="reset" value="Reset" class="btn_medium">
												</td>
											</tr>
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