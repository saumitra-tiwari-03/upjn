<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
<body onload="javascript:getLeaveAndDate();">
		
          	<form action="/UPJN/getEmpListForAddSection" method="POST" onsubmit="return validateForm();">
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				
				<tr>
					<td valign="top" class="msg" height="30"></td>
				</tr>
				<tr>
					<td valign="top"><table width="80%"  border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td align="center" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td valign="top"><table width="100%" border="0" cellspacing="1" cellpadding="1">
										<tr>
											<td valign="top" class="table_bg"><table width="100%" border="0" cellspacing="1" cellpadding="3">                      
												<tr>
													<td align="left" valign="top" class="table_head">
														Employee List 
														<input type="hidden" value="${sectionID}" name="sectionID"> 
													</td>
												</tr>
											</table>
											<table width="100%" border="0" cellspacing="1" cellpadding="3">
												<tr>
													<td colspan="5" valign="top" class="table_bg"></td>
												</tr>
												<tr>
													<td  colspan="5" valign="top" class="cell_bg">&nbsp;</td>
												</tr>
												<tr>
													<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
													<td width="43%" align="left" valign="top" class="cell_bg">
														Employee Code
													</td>
													<td align="left" valign="top" class="cell_bg">
														<input type="text" name="employeeCode" class="txt_medium"/>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">
														First Name</td>
													<td align="left" valign="top" class="cell_bg">
														<input type="text" name="firstName" class="txt_medium"/>
													</td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">
														Last Name
													<td align="left" valign="top" class="cell_bg">
														<input type="text" name="lastName" class="txt_medium"/>
													</td>
												</tr>
												<tr>
													<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
													<td width="43%" align="left" valign="top" class="cell_bg">
														Employee Category
													</td>
													<td align="left" valign="top" class="cell_bg">
														<select name="mas_EmploymentSubTypeID" class="cmb_medium">
															<option value="-1" >[Select Category]</option>
															<c:forEach var="empCat" items="${empCatList}">
																<option value="<c:out value="${empCat.masEmploymentsubtypeid }"/>">
																	<c:out value="${empCat.employmentsubtype }"/>
																</option>
															</c:forEach>
														</select>
													</td>  
												</tr>
												<tr>
													<td width="3%"  valign="top" class="cell_bg">&nbsp;</td>
													<td  align="left" valign="top" class="cell_bg">
														Designation
													<td  align="left" valign="middle" class="cell_bg" >
															<select name="pp_DesignationMasterID" class="cmb_medium">
																<option value="-1">
																	[Select Designation]
																</option>
																<c:forEach var="dlist" items="${designationList}">
																<option value="<c:out value="${dlist.ppDesignationmasterid}"/>">
																	<c:out value="${dlist.designation}"/>
																</option>
															</c:forEach>
															</select>
													</td>
												</tr>                        
												<tr>
													<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
												</tr>
												<tr>
													<td colspan="5" align="center" valign="top" class="cell_bg">
														<input type="submit" value="Submit" class="btn_medium"/>
													</td>
												</tr>
											</table></td>
										</tr>
									</table></td>
								</tr>
							</table></td>
						</tr>
					</table></td>
				</tr>
				<tr>
					<td height="30" valign="top">&nbsp;</td>
				</tr>
			</table>
			</form>
		
	</body>
</html>