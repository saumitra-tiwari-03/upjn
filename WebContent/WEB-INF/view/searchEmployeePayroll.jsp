
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">





<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM-Search Employee PayRoll</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<style type="text/css">
.txt_bitSmall {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-weight: normal;
	color: #000000;
	text-decoration: none;
	background-color: #F0F0F0;
	border: 1px #4390E2 solid;
	width: 80px;
}

.txt_Smallest {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-weight: normal;
	color: #000000;
	text-decoration: none;
	background-color: #F0F0F0;
	text-align: right;
	border: 1px #4390E2 solid;
	width: 40px;
}
</style>
<script language="javascript" src="js/popcalendar.js"></script>
<script language="javascript">
	function validate() {
		try {
			var empcode = document.forms[0].employeeCode.value;
			if (empcode == '') {
				alert('Employee Code is required .');
				return false;
			} else {
				document.forms[0].method.value = "getEmployeeInformation";
				document.forms[0].submit();
				return true;
			}
		} catch (e) {
			alert("Following Error is encountered : " + e.description);
			return false;
		}
	}//End Function
	function goBack() {
		self.history.location('-1');
		return true;
	}
	function showTotalList() {
		document.forms[0].method.value = "getWholeOfficeListing";
		document.forms[0].submit();
		return true;
	}

	function MM_openBrWindow(theURL, winName, features) { //v2.0
		window.open(theURL, winName, features);
	}
</script>
<style type="text/css"></style>
</head>
<body>
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
			<form method="post" action="/UPJN/searchEmployeePayList">
				


				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td valign="top" class="msg"></td>
					</tr>
					<tr>
						<td valign="top" class="error"></td>
					</tr>
					<tr>
						<td valign="top"><table width="100%" align="center"
								cellpadding="0" cellspacing="0" border="0">
								<tr>
									<td valign="top"><table width="60%" align="center"
											cellpadding="0" cellspacing="1" border="0" class="table_bg">
											<tr>
												<td valign="top"><table width="100%" align="center"
														class="cell_bg" cellpadding="3" cellspacing="3" border="0">
														<tr>
															<td align="left" valign="top" class="table_head"
																colspan="4">Search Employee in Section and
																Registers.</td>
														</tr>

														<tr>
															<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
															<td colspan="2" valign="middle" class="error_normal"
																align="right">* Fields are required.</td>
														</tr>
														<tr>
															<strong><td>&nbsp;</td>
																<td align="left" valign="top">Employee Code :</td>
																<td align="left"><input type="text"
																	name="employeecode" value="${employeecode1}"
																	class="txt_small"> <span class="star">*</span>
																	<input type="submit" value="Go"
																	class="btn_go"> <a
																	href="/UPJN/searchEmployeePayRollList" class="bold">
																		<u>Select Employee </u>
																</a></td>
														</tr>
													</table></td>

											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table>
				<br> <br>
				<table width="100%" align="center" cellpadding="0" cellspacing="0"
					border="0">
					<tr>
						<td valign="top"><table width="90%" align="center"
								cellpadding="0" cellspacing="1" border="0" class="table_bg">
								<tr>
									<td valign="top"><table width="100%" align="center"
											class="cell_bg" cellpadding="3" cellspacing="3" border="0">
											<tr>
												<td align="left" valign="top" class="table_head" colspan="5">Employee
													Pay details in this Office.</td>
												<td align="right" class="table_head"><a href="/UPJN/payRollAllEmpInfo"
													onclick="return showTotalList();"> <u>Click here
															for whole list. </u>
												</a></td>
											</tr>
											<tr>
												<td id="t"><img alt="" src="resources/images/sort.gif">EMPLOYEECODE</td>
												<td id="t"><img alt="" src="resources/images/sort.gif">EMPLOYEE NAME</td>
												<td id="t"><img alt="" src="resources/images/sort.gif">FATHER NAME</td>
												<td id="t"><img alt="" src="resources/images/sort.gif">DATE OF BIRTH</td>
												<td id="t"><img alt="" src="resources/images/sort.gif">DESIGNATION</td>
												<td id="t"><img alt="" src="resources/images/sort.gif">SECTION NAME</td>
												<td id="t"><img alt="" src="resources/images/sort.gif">REGISTERNAME</td>
												<td id="t"><img alt="" src="resources/images/sort.gif">OFFICE NAME</td>




											</tr>
											<c:forEach items="${resultlist}" var="list">
												<tr>

													<td>${list.employeeCode}</td>
													<td>${list.employeename}</td>
													<td>${list.fathername}</td>
													<td>${list.dateofbirth}</td>
													<td>${list.designation}</td>
													<td>${list.sectionname}</td>
													<td>${list.registername}</td>
													<td>${list.officename}</td>



													<td>
												</tr>
											</c:forEach>













										</table></td>
								</tr>
							</table></td>
					</tr>
				</table>
			</form>
			<script type="text/javascript" language="JavaScript">
				
			</script>
		</div>
	</div>

</body>
</html>



