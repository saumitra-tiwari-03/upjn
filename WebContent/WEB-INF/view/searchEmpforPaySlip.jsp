<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Employee Search</title>
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<link href="resources/css/upjnBeta.css" rel="stylesheet" type="text/css" />
<script src="resources/js/validation.js" type="text/javascript"></script>
<script src="resources/js/validation.js" type="text/javascript"></script>

</head>
<body>
 <form action="/UPJN/selEmpPaySlip">
   <table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td>
					<table width="95%"  border="0" align="center" cellpadding="1" cellspacing="1">
						<tr>
							<td align="center" class="table_bg" valign="top">
								<table width="100%" border="0" cellspacing="3" cellpadding="3">
									<tr>
										<td colspan="9" valign="top" class="table_head" align="left">
											Employee List
										</td>
									</tr>
									
									<tr><td><input type="hidden" value="${ppRegistermasterid}" name="ppRegistermasterid" id="ppRegistermasterid"/></td>  </tr>
									
									
									<c:choose>
										<c:when test="${employeeList == null}">
											<tr>
												<td colspan="9" valign="top" class="cell_bg" align="center">
												
													No Records Found
												</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${employeeList != null }">
											<tr>
												<td>Employee Code</td>
												<td>Employee Name</td>
												<td>Employee Designation</td>
												<td>Select</td>
											</tr>
											<c:forEach var="list" items="${employeeList}">
												<tr>
													<td><c:out value="${list.employeecode }"/></td>
													<td><c:out value="${list.employeename }"/></td>
													<td><c:out value="${list.designation }"/></td>
													<td>
													<input type="checkbox" value="${list.employeecode}" name="empcode" id="empcode"/>
													<%-- <input type="hidden" value="${list.employeecode}" name="empcode"/> --%>
													</td>
												</tr>
											</c:forEach>
										</c:when>
									</c:choose>
								<tr>
									<td colspan="9" valign="top" class="cell_bg" align="center">
									
									<input type="submit" value="Submit" class="btn_medium" />
										
									</td>
								</tr>
							</table></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="30" valign="top">&nbsp;</td>
			</tr>
		</table>
 
 </form>

</body>
</html>