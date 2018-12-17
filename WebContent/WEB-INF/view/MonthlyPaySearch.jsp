<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM-Monthly Pay Search</title>
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
			style="height: 600px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px; overflow-x: auto;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div
			style="height: 100%; width: 79%; float: left; padding-top: 10px; overflow-x: auto;">

			<form action="/UPJN/MonPayReport">

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

															<td class="table_head" colspan="4">Bill Detail</td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td></td>
															<!-- <td>Regular Pay Bills</td> -->
															<td>Register name</td>
															<td>Bill No.</td>
															<td>Bill Amount</td>
															<td>Pay Bill Date</td>														
														</tr>
														
														<c:forEach items="${billdetail}" var="a">
															<tr>
															<td><input type="checkbox" name="ppPaybilldetailid" value="${a.ppPaybilldetailid}"> </td>
															<!-- <td></td> -->
															<td>${registername}</td>
															<td>${a.billno}</td>
															<td>${a.billamount}</td>
															<td>
															<fmt:formatDate pattern="dd-MMM-yyyy" value="${a.billdate}" />
															</td>	
													<!-- Hidden Fields -->	
													<td>
													    <input type="hidden" name="ppRegistermasterid" value="${a.ppRegistermasterid}">
													    <input type="hidden" name="year" value="${a.year}">
													    <input type="hidden" name="month" value="${a.month}">
													 <%--    <input type="hidden" name="ppPaybilldetailid" value="${a.ppPaybilldetailid}"> --%>
													</td>	
													<!--  --></tr>
														</c:forEach>														
														


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

			</form>

		</div>

	</div>


</body>

</html>