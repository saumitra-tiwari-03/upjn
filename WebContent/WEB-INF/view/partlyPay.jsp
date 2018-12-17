
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM-Partly Pay</title>

<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script language="javascript" src="resources/js/validation.js"></script>
<script language="javascript" src="resources/js/popcalendar.js"></script>
<script language="javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>

<script>
function submitForm(){
	var str = "";
	if(document.forms[0].employeecode.length==null){
	if(document.forms[0].employeecode.checked==true)
	str+="'"+document.forms[0].employeecode.value+"',";
	alert("STTTRRRRRR"+str);
	}else{
	for(var i=0; i < document.forms[0].employeecode.length; i++){
	if(document.forms[0].employeecode[i].checked==true)	
	str+="'"+document.forms[0].employeecode[i].value+"',";
	alert("STTTRRRRRRiii"+str);
	}
	}
	if(str==''){
	alert('Please Select Atleast One Program.');
	return false;
	}
	                               
	                              
	document.forms[0].str.value=str;
	document.forms[0].submit();
	}//end method
</script>


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

		<div style="height: 100%; width: 79%; float: left; padding-top: 10px;">
			<form action="/UPJN/parltlyPayprocess" method="post">
				<td><input type="hidden" name="monthName" value="${monthName}"></td>
				<td><input type="hidden" name="yearName" value="${yearName}"></td>
				<td><input type="hidden" name="str" ></td>


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
									<td valign="top"><table width="65%" align="center"
											cellpadding="0" cellspacing="1" border="0" class="table_bg">
											<tr>
												<td valign="top"><table width="100%" align="center"
														class="cell_bg" cellpadding="3" cellspacing="3" border="0">
														<tr>
															<td colspan="3" valign="top" class="table_head"
																align="left">Individual Pay Process Form</td>
															<td align="center" valign="middle" class="table_head">
																<a href="ProcessPay.do?pbt=&amp;ID=2&amp;method=begin"><img
																	src="images/cross.jpeg" height="16" width="16"
																	border="0" hspace="0"></a>
															</td>
														</tr>
														<tr>
															<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
															<td colspan="1" valign="middle" class="error_normal"
																align="right">* Fields are required.</td>
														</tr>

														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="35%" align="left" valign="top" class="cell_bg">
																Month</td>
															<td align="left" valign="middle" class="cell_bg"><input
																type="text" name="monthName" value= "${monthName}" "readonly"
																class="txt_noborder"></td>
														</tr>
														<tr>
															<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
															<td width="35%" align="left" valign="top" class="cell_bg">
																Year</td>
															<td align="left" valign="middle" class="cell_bg"><input
																type="text" name="yearName" value="${yearName}" readonly="readonly"
																class="txt_noborder"></td>
														</tr>
														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">
																Voucher Date</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" name="billDate" readonly="readonly"
																class="txt_noborder"></td>
														</tr>
														<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">
																Voucher No.</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" name="billNo" readonly="readonly"
																class="txt_noborder"></td>
														</tr>

													</table></td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>



					<tr>
						<td valign="top">
							<table width="100%" border="0" cellspacing="1" cellpadding="1">
								<tr>
									<td valign="top" class="table_bg">




										<table cellspacing="0" cellpadding="0" border="0"
											align="CENTER" class="FORM">
											<tr>
												<td id="t"><img alt="" src="resources/images/sort.gif">Employee
													Code</td>
												<td id="t"><img alt="" src="resources/images/sort.gif">Employee
													Name</td>
												<td id="t"><img alt="" src="resources/images/sort.gif">Employee
													Designation</td>

												<td id="t">Select</td>
											</tr>
											<c:forEach items="${employeeList}" var="list">
												<tr>

													<td>${list.employeecode}</td>
													<td>${list.employeename}</td>
													<td>${list.ppDesignationmasterid}</td>

													<td><input type="hidden" name="ppEmployeemasterid"
														value="${list.ppEmployeemasterid}"></td>


													<td><input type="hidden" name="ppRegistermasterid"
														value="${list.ppRegistermasterid}"></td>

													<td><input type="checkbox" name="employeecode"
														value="${list.employeecode}"></td>

												</tr>
											</c:forEach>
										</table>
									</td>
							</table>




						</td>
					</tr>


				</table>

       

				<tr>
					<td valign="top" class="cell_bg">&nbsp;</td>
					<td align="center" valign="top" class="cell_bg"><input
						type="submit" value="Submit" onclick="submitForm();"
						class="btn_medium"></td>
				</tr>



			</form>
		</div>
	</div>

</body>
</html>