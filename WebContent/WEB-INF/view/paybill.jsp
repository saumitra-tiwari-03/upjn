<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>U.P JAL NIGAM-Pay Bill</title>
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<link href="resources/css/upjnBeta.css" rel="stylesheet" type="text/css" />
<script src="resources/js/validation.js" type="text/javascript"></script>
<script src="resources/js/validation.js" type="text/javascript"></script>
</head>
<body style="margin: 0px 0px 0px 0px;" onload="setRegister()">
	<script>
		function updateRegister() {
			document.getElementById("update").action = "/UPJN/updateRegister";
			document.getElementById("update").method = "post";
			document.getElementById("update").submit();
		}

		function removeempfromRegister() {
			document.getElementById("update").action = "/UPJN/dropEmpFromthisSection";
			document.getElementById("update").method = "post";
			document.getElementById("update").submit();
		}

		function setRegister() {
			var registerID = document.getElementsByName("registerID");
			for (var i = 0; i < registerID.length; i++) {
				document.getElementsByName("selectedRegister")[i].value = registerID[i].value;
			}

		}
		/* function enableList(flag) {

			if (flag.checked == true) {

				alert("checked");

				var check = document.getElementsByName("ppEmployeemasterid");
				for (var i = 0; i < check.length; i++) {
					if (check[i].checked == true) {
						document.getElementById(check[i].value).disabled = false;
					}
				}
			} else {

				alert("not checked");

				var check = document.getElementsByName("ppEmployeemasterid");
				for (var j = 0; j < check.length; j++) {
					if (check[j].checked == false) {
						document.getElementById(check[j].value).disabled = true;
					}
				}
			}
		} */

		function enableList(flag) {
			if (flag.checked == true) {

				alert("checked");
				
				var check = document.getElementsByName("ppEmployeemasterid");
				
				for (var i = 0; i < check.length; i++) {
					if (check[i].checked == true) {
						alert(document.getElementById(check[i].value));
						document.getElementById(check[i].value).disabled = false;
					}
					
				}
			} else {

				var check = document.getElementsByName("ppEmployeemasterid");
			
				for (var i = 0; i < check.length; i++) {
			
					if (check[i].checked == false) {
						alert(document.getElementById(check[i].value));
						document.getElementById(check[i].value).disabled = true;
						
					}
				}
			}
		} 

		function clickOnCheckBox(flag) {
			var chkBoxArr = document.forms[0].pp_EmployeeMasterID;
			//var chkBoxArr= document.getElementById("pp_EmployeeMasterID")
			var txtSelectArr = document.forms[0].pp_RegisterMasterID;
			// var txtSelectArr=document.getElementById("pp_RegisterMasterID");
			alert("hey" + chkBoxArr.length)
			if (chkBoxArr.length == null) {
				//start deveki
				alert("ohhhhh" + document.getElementById("pp_EmployeeMasterID"))
				if (document.getElementById("pp_EmployeeMasterID") == true) {
					//document.forms[0].pp_RegisterMasterID.disabled=false;
					document.getElementById("pp_EmployeeMasterID").disabled = false;
					alert("hi" + chkBoxArr)
				}
				//end deveki
				if (chkBoxArr.checked == false) {
					txtSelectArr.disabled = true;
					alert("hello" + chkBoxArr)
				}
			} else {
				alert("1234" + chkBoxArr.length);

				for (var i = 0; i < chkBoxArr.length; i++) {
					alert("abhinav" + chkBoxArr.length);
					alert("2224" + chkBoxArr(i).checked);
					if (chkBoxArr(i).checked == false) {
						txtSelectArr(i).disabled = true;
						alert("hgggi" + chkBoxArr)
					} else {
						txtSelectArr(i).disabled = false;
						alert("whatsup" + chkBoxArr)
					}
				}
			}
			return;
		}
	</script>
	<div style="height: 100%; width: 100%;">
		<!-- Page Header -->
		<div
			style="height: 100px; width: 100%; border-bottom: gray solid 4px;">
			<%@ include file="/WEB-INF/view/Header.jsp"%>
		</div>
		<!-- Page Menu -->
		<div
			style="height: 700px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px; overflow-x: auto;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>
		<!-- Page Body -->
		<div
			style="height: 100%; width: 79%; float: left; padding-top: 10px; overflow-x: auto;">
			<span>${msg_sectionMaster}</span>
			<form action="/UPJN/getEmpList" method="post" id="update">
				<div id="sectionMasterTop">

					<table class="table_bg" style="width: 100%;">
						<tr>
							<td class="msg" colspan="4">${msg}</td>
						</tr>


						<tr>
							<th class="table_head" colspan="2" align="left">Master - Pay
								Bill Master</th>
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
							<td><c:choose>
									<c:when test="${displayFlag == false}">
										<select class="cmb_small" style="width: 200px"
											name="sectionID">
											<option value="-1">[Select Section]</option>
											<c:forEach items="${sectionList}" var="list">
												<option value="<c:out value="${list.ppSectionmasterid}"/>"><c:out
														value="${list.sectionname}" /></option>
											</c:forEach>
										</select>
									</c:when>
									<c:otherwise>
										${sectionName}
										<input type="hidden" name="sectionID" value="${sectionID}">


									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class="cell_bg" height="20px;"></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><c:choose>
									<c:when test="${displayFlag == false}">
										<input class="btn_medium" type="submit" value="Submit" />
									</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="cell_bg" height="20px;"></td>
						</tr>
					</table>
				</div>
				<div style="height: 400px; overflow: scroll;">
					<table border="0">
						<c:choose>
							<c:when test="${displayFlag != false}">
								<tr>
									<th align="left">SN</th>
									<th align="left">Employee Code</th>
									<th align="left">Employee Name</th>
									<th align="left">Select Register To Assign</th>
									<th>&nbsp;</th>
									<th align="left">Select</th>
								</tr>
							</c:when>
						</c:choose>
						<%
							int i = 1;
						%>
						<c:forEach var="l" items="${empList}">
							<tr>
								<td><%=i%></td>
								<td><c:out value="${l.employeecode}" /></td>
								<td><c:out value="${l.employeeName}" /></td>
								<td><select class="cmb_small" disabled="disabled"
									name="selectedRegister"
									id="<c:out value="${l.ppEmployeemasterid}"/>">
										<option value="-1">Select Register</option>
										<c:forEach items="${registerList}" var="r">
											<option value="<c:out value="${r.ppRegistermasterid}"/>"><c:out
													value="${r.registername}" /></option>
										</c:forEach>
								</select> <input type="hidden" name="registerID"
									value="<c:out value="${l.ppRegisterMasterid}"/>" /></td>
								<td>&nbsp;</td>
								<td><input type="checkbox" name="ppEmployeemasterid"
									value="${l.ppEmployeemasterid}"
									onclick="return enableList(this);" /></td>
							</tr>
							<%
								i++;
							%>
						</c:forEach>


					</table>
				</div>
				<table>
					<c:choose>
						<c:when test="${displayFlag != false}">
							<tr>
								<td colspan="3"><input type="button" value="Update"
									class="btn_medium" onclick="return updateRegister()" />&nbsp;&nbsp;
									<input type="button" value="Remove" class="btn_medium"
									onclick="return removeempfromRegister()" /> <%-- <input type="button" value="Remove" class="btn_medium"
										onclick="location.href='/UPJN/dropEmpFromthisSection?sectionID=${sectionID}&ppEmployeemasterid=${l.ppEmployeemasterid}'" /> --%>
								</td>
								<td colspan="3"><c:choose>
										<c:when test="${displayFlag != false}">
											<input type="button" value="Add More" class="btn_medium"
												onclick="window.open('/UPJN/showSearch?sectionID=${sectionID}','popup','scrollbars=yes,resizable=no,width=700,height=400')" />
											<input type="button" value="Refresh" class="btn_medium"
												onclick="location.reload()" />
										</c:when>
									</c:choose></td>
							</tr>
						</c:when>
					</c:choose>
				</table>





			</form>
		</div>
	</div>
</body>
</html>