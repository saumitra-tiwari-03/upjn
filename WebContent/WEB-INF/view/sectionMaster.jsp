<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>U.P JAL NIGAM-Section Master</title>
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<link href="resources/css/upjnBeta.css" rel="stylesheet" type="text/css" />
<script src="resources/js/validation.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		  $("#myTable").tablesorter();
	});
</script>
</head>
<body style="margin: 0px 0px 0px 0px;">
	<div style="height: 100%; width: 100%;">
		<!-- Page Header -->
		<div
			style="height: 100px; width: 100%; border-bottom: gray solid 4px;">
			<%@ include file="/WEB-INF/view/Header.jsp"%>
		</div>
		<!-- Page Menu -->
		<div
			style="height: 600px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px; overflow-x: auto;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>
		<!-- Page Body -->
		<div
			style="height: 100%; width: 79%; float: left; padding-top: 10px; overflow-x: auto;">
			
			<!-- <div id="sectionMasterTop"> -->
			<c:choose>
				<c:when test="${updateFlag == false}">
					<form action="/UPJN/saveSectionMaster" method="post">
				</c:when>
				<c:otherwise>
					<form action="/UPJN/updateSectionMaster" method="post">
				</c:otherwise>
			</c:choose>
			<table class="table_bg" style="width: 100%;">
			<tr>
					<td valign="top" class="msg">${msg_sectionMaster}</td>
				</tr>
			
				<tr>
					<th class="table_head" colspan="2" align="left">Section Master</th>
				</tr>
				<tr>
					<td class="table_bg" colspan="2"></td>
				</tr>
				<tr>
					<td class="cell_bg" height="20px;"></td>
				</tr>
				<tr>
					<td class="cell_bg space_td" width="40%" align="left" style=>Section
						Name</td>
					<td><input id="sectionName" class="txt_medium" type="text"
						name="sectionname" value="<c:out value="${sectionname}" />" /><span
						class="star">*</span></td>
				</tr>
				<tr>
					<td class="cell_bg" height="20px;"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input class="btn_medium"
						type="submit" value="Submit" /></td>
				</tr>
				<tr>
					<td class="cell_bg" height="20px;"></td>
				</tr>
			</table>
			<table>
				<tr>
					<td></td>
				</tr>

				<tr>
					<td></td>
				</tr>
			</table>

			<!-- ----------------------------------------------------- -->

			<br>
			<script type="text/javascript" src="resources/js/tablesorter.js"></script>
			<table width="90%" class="table_bg" cellpadding="3" cellspacing="3"
				border="0" align="center">
				<tr>
					<td>
						<div style="overflow-y: scroll; height: 400px">
							<table width="100%" id="myTable" cellpadding="0" cellspacing="1"
								border="0" class="tablesorter">

								<thead id="h" align="center">
									<tr>
										<th id="t" width="40%"><img alt=""
											src="resources/images/sort.gif">Office Name</th>
										<th id="t" width="40%">Action</th>
									</tr>
								</thead>

								<tbody id="b" align="center">
									<c:forEach items="${sectionList}" var="list">
										<tr align="center">

											<td>${list.sectionname}</td>
											<td><a
												href="/UPJN/populateSectionMaster?ppSectionMasterID=<c:out value="${list.ppSectionmasterid}"/>">Edit</a>|
												<a
												href="/UPJN/deleteSectionMaster?ppSectionMasterID=<c:out value="${list.ppSectionmasterid}"/>">Delete</a>
											</td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</td>
				</tr>
			</table>
			<!-- ----------------------------------------------------- -->
</body>
</html>