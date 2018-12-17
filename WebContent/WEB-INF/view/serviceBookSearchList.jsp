<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM-Service Book Search List</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">

<!-- <script type="text/javascript">
function closeSelf(){
	
    self.close();
    return true;
} 
</script> -->
<!-- <script language="javascript">
			function putValues(){
				             
				window.close();
			}
		</script> -->

</head>
<body>
  <form action="/UPJN/ServiceBook" method="post">
    <%--  <c:forEach items="${list}" var="a">
     <input type="hidden" 
        name="ppEmployeemasterid"
       value="${a.ppEmployeemasterid}" maxlength="16">
</c:forEach>
  
 --%>


	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td valign="top" class="msg"></td>
		</tr>
		<tr>
			<td align="left" valign="top" class="error"></td>
		</tr>
		<tr>
			<td><table width="95%" border="0" align="center" cellpadding="1"
					cellspacing="1">
					<tr>
						<td align="center" class="table_bg" valign="top"><table
								width="100%" border="0" cellspacing="3" cellpadding="3">
								<tr>
									<td colspan="8" valign="top" class="table_head" align="left">
										Service Book - List of Employees</td>
									<td colspan="1" valign="top" class="table_head" align="right">
										<a href="/UPJN/serviceBookEmployeeSearch"><u>Search Again</u></a>
									</td>
								</tr>
								
								<tr>
									<td colspan="2" align="left" valign="top" class="cell_bg" >																	
										<input type="submit" class="btn_large" value="Personal Information" name="actionPersonalInfo" onclick="javascript:putValues()"/>
										 
									</td>
									<td colspan="2" align="left" valign="top" class="cell_bg" >																	
										<input type="submit" class="btn_large" value="Promotion" name="actionPromotionInfo" onclick="javascript:putValues()"/>
									</td>
				        <td colspan="2" align="left" valign="top" class="cell_bg" >																	
								<input type="submit" class="btn_large" value="Permanency" name="actionPermanencyInfo" onclick="javascript:putValues()"/>
						</td>
						<td colspan="2" align="left" valign="top" class="cell_bg" >																	
							<input type="submit" class="btn_large" value="Training" name="actionTrainingInfo" onclick="javascript:putValues()"/>
						</td>		
								
								</tr>
								<tr>
									<td colspan="9" valign="top" class="" align="left">
										<table width="100%" align="center" class="cell_bg"
											cellpadding="3" cellspacing="3">
											<tr>
												<td>

													<table width="100%" height="700px" cellpadding="3" cellspacing="3">
														<tr>
															<td id="t">Action</td>
															<td id="t"><img alt=""
																src="resources/images/sort.gif">Employee Code</td>
															<td id="t"><img alt=""
																src="resources/images/sort.gif">Employee Name</td>
															<td id="t"><img alt=""
																src="resources/images/sort.gif">Employee
																Designation</td>
															<td id="t"><img alt=""
																src="resources/images/sort.gif">Employment Type</td>
															<td id="t"><img alt=""
																src="resources/images/sort.gif">Employee Category</td>
														</tr>
														<tr>
														<td colspan=6>
														<div style="height: 650px; width: 100%; overflow: auto;">
														<table border="0px" style="width: 100%">
															<c:choose>
																<c:when test="${list!=null}">
																	<c:forEach items="${list}" var="list">
																	
																	
																		<tr>
																			<td width="7%"><input type="radio" name="ppEmployeemasterid" value="${list.ppEmployeemasterid}"></td>
										<td width="15%">${list.employeecode} </td>
										
										<td width="15%">${list.employeename}</td>
										<td width="15%">${list.designation}</td>
																			<td width="15%">${list.employmenttype}</td>
																			<td width="15%">${list.employmentsubtype}</td>
																													
																		</tr>
																		
																	</c:forEach>
																</c:when>
																<c:otherwise>
																	<c:forEach items="${list1}" var="list">
																	
																	
																		<tr>
																			<td width="7%"><input type="radio" name="ppEmployeemasterid" value="${list.ppEmployeemasterid}"></td>
																			
																			<td width="15%">${list.employeecode} </td>
																			
																			<td width="15%">${list.employeename}</td>
																			<td width="15%">${list.designation}</td>
																			<td width="15%">${list.employmenttype}</td>
																			<td width="15%">${list.employmentsubtype}</td>
																																						
																		</tr>
																	</c:forEach>
																</c:otherwise>
															</c:choose>
														</table>
													</div>
														</td>
														</tr>
														
														
													</table>
													
												</td>
											</tr>
											<tr>
																<td colspan="5" align="center" valign="top" class="cell_bg">																	
																	<input type="submit" class="btn_medium" value="Submit" name="actionSubmit" onclick="javascript:putValues()"/>
																	</td>
																	</tr>
										
										</table>
									
									</td>
								
								</tr>

								<tr>

								</tr>

							</table></td>
					</tr>
				</table></td>
		</tr>


		<tr>
			<td valign="top" class="msg"></td>
		</tr>

		<tr>
			<td><table width="95%" border="0" align="center" cellpadding="1"
					cellspacing="1">
					<tr>
				</table></td>
		</tr>
	</table>
	
	</td>

	<tr>
		<td height="30" valign="top">&nbsp;</td>
	</tr>

	</table>
	</form>

</body>
</html>