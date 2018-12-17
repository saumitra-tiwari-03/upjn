
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
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

		<div align="center" style="height: 100%; width: 79%; float: left; padding-top: 150px;">


			<input type="hidden" value="${ppEmployeemasterid}"
				name="ppEmployeemasterid">
			<c:choose>
				<c:when test="${ppEmployeemasterid == 0}">
					
					<font size="7" color="#33A2FF">
					<b>WELCOME -</b> ${Office_Name}
						</font>
						</c:when>
				<c:otherwise>
					<b>WELCOME - ${employee_name}</b> ||
				 ${designation_}				
					</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>