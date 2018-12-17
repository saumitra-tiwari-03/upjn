<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM</title>
</head>

<body>
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td><input type="hidden" value="${ppEmployeemasterid}"
				name="ppEmployeemasterid"></td>
			<td><input type="hidden" value="${rm_OfficeID}"
				name="rm_OfficeID"></td>
			<td width="83" valign="top"><img name="home_r1_c1"
				src="resources/images/home_r1_c1.jpg" width="83" height="82"
				border="0" alt=""></td>
			<td width="284" valign="top"><img name="home_r1_c2"
				src="resources/images/home_r1_c2.jpg" width="284" height="82"
				border="0" alt=""></td>
			<td width="50" valign="top"><img name="home_r1_c4"
				src="resources/images/home_r1_c4.jpg" width="50" height="82"
				border="0" alt=""></td>
			<td valign="top" background="resources/images/home_r1_c5.jpg"
				class="fix_bg" style="padding-top: 5px;"><font size="2">Welcome
					- <c:choose>
						<c:when test="${ppEmployeemasterid == 0}">
							<b>Super Admin</b> |${Office_Name}|
						<a href="/UPJN/OfficeSelectionController"><b>Change Office</b>
							</a>
						</c:when>
						<c:otherwise>
							<b> ${employee_name}</b>||
				 ${designation_}
					
					</c:otherwise>

					</c:choose>
			</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
				
				
				<b> <a href="/UPJN/logout"><b>Sign Out</b> </a>
			</b></td>
		</tr>
	</table>



</body>

</html>