<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM-Employee Joining Details</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script language="javascript" src="resources/js/validation.js"></script>
<script language="javascript" src="resources/js/popcalendar.js"></script>
<script language="javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<script src="<c:url value="/resources/js/upjn.js" />"></script>
<script type="text/javascript">
	function datevalidate(){
		var w = document.getElementById("currentdate").value;
		var x = document.getElementById("joiningdate").value;
		var y = document.getElementById("joiningorderdate").value;

		if(
				new Date(w).getTime()< new Date(x).getTime()		
		){
                alert(" Date of joining cannot be greater than current date");
                return false;
			}
		if(new Date(w).getTime()< new Date(y).getTime()){
            alert("Joining Order Date cannot be greater than current date");
            return false;
		}
		else{
                return true;
			}
	}
	
	</script>
</head>

<body style="margin: 0px 0px 0px 0px;">

	<div style="height: 100%; width: 100%;">

		<div
			style="height: 100px; width: 100%; border-bottom: gray solid 4px;">
			<%@ include file="/WEB-INF/view/Header.jsp"%>
		</div>

		<div
			style="height: 600px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div style="height: 100%; width: 79%; float: left; padding-top: 10px;">

			<form action="/UPJN/joinEmployee" method="post">
				<table cellSpacing=1 cellPadding=1 width="70%" border="0"
					align="center">
					<tr>
						<td align="left" valign="top" class="error">${msg}</td>
					</tr>
					<tr>
						<c:set var="currentdate" value="<%=new java.util.Date()%>" />
						<td><input type="hidden" name="currentdate" id="currentdate"
							value="<fmt:formatDate pattern="dd/MM/yyyy" value="${currentdate}" />">
						</td>
					</tr>
					<tr>
						<td class="table_bg" valign="top">
							<table cellSpacing=1 cellPadding=3 width="100%" border="0"
								align="center">

								<tr>
									<td class="table_head" valign="top" align="left" width="95%">
										Employee Joining - Add Joining Details</td>
									<td align="center" valign="middle" class="table_head"><a
										href="/UPJN/joinEmployeeList"><img height="16" hspace="0"
											src="resources/images/cross.jpeg" width="16" border="0">
									</a></td>
								</tr>
							</table>

							<table cellSpacing="1" cellPadding="3" width="100%" border="0"
								align="center">
								<tr>
									<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
									<td colspan="1" valign="middle" class="error_normal"
										align="right">* Fields are required.</td>
								</tr>

								<tr>
									<c:forEach items="${list}" var="a">
										<input type="hidden" id="ppEmployeemasterid"
											value="${a.ppEmployeemasterid}" name="ppEmployeemasterid" />
									</c:forEach>
								</tr>
								<tr>
									<td><input type="hidden" id="ppTransferdetailid"
										value="${ppTransferdetailid}" name="ppTransferdetailid" /></td>
								</tr>

								<tr>

									<td class="cell_bg" valign="top" align="center">Employee
										Code</td>
									<td class="cell_bg" valign="top" align="left"><c:forEach
											items="${list}" var="a">
									     ${a.employeecode}
									</c:forEach></td>
								</tr>

								<tr>
									<td class="cell_bg" valign="top" colspan="4"></td>
								</tr>

								<tr>
									<td class="cell_bg" valign="top" align="center">Employee
										Name</td>
									<td class="cell_bg" valign="top" align="left"><c:forEach
											items="${list}" var="a">
									     ${a.employeename}
									</c:forEach></td>
								</tr>

								<tr>
									<td class="cell_bg" valign="top" colspan="4"></td>
								</tr>

								<tr>
									<td class="cell_bg" valign="top" align="center">
										Designation</td>
									<td class="cell_bg" valign="top" align="left"><c:forEach
											items="${list}" var="a">
									     ${a.designation}
									</c:forEach></td>
								</tr>

								<tr>
									<td class="cell_bg" valign="top" colspan="4"></td>
								</tr>

								<tr>
									<td align="center" valign="top" class="cell_bg">Date of
										Joining</td>
									<td align="left" valign="top" class="cell_bg"><input
										type="text" class="txt_date" name="joiningdate" id="joiningdate"
										readonly="readonly" required> <a href="javascript:;"
										onclick="displayCalendar(document.forms[0].joiningdate,'dd/mm/yyyy',document.forms[0].joiningdate)">
											<img height="16" hspace="0"
											src="resources/images/calendar-icon.gif" width="16"
											border="0" />
									</a> <span class="star">*</span></td>
								</tr>

								<tr>
									<td class="cell_bg" valign="top" colspan="4"></td>
								</tr>

								<tr>
									<td class="cell_bg" valign="top" align="center">Joining
										Order No.</td>
									<td class="cell_bg" valign="top" align="left"><input
										type="text" name="joiningorderno" class="txt_medium" size="11"
										maxlength="50" required> <span class="star">*</span></td>
								</tr>

								<tr>
									<td class="cell_bg" valign="top" colspan="4"></td>
								</tr>

								<tr>
									<td align="center" valign="top" class="cell_bg">Joining
										Order Date</td>
									<td align="left" valign="top" class="cell_bg"><input
										type="text" class="txt_date" name="joiningorderdate" id="joiningorderdate"
										readonly="readonly" required> <a href="javascript:;"
										onclick="displayCalendar(document.forms[0].joiningorderdate,'dd/mm/yyyy',document.forms[0].joiningorderdate)">
											<img height="16" hspace="0"
											src="resources/images/calendar-icon.gif" width="16"
											border="0" />
									</a> <span class="star">*</span></td>
								</tr>

								<tr>
									<td class="cell_bg" valign="top" colspan="4"></td>
								</tr>

								<tr>
									<td width="43%" align="center" valign="top" class="cell_bg">
										Relieving Time</td>
									<td align="left" valign="top" class="cell_bg"><select
										required name="relieveanfn" class="cmb_small">
											<option value="-1">[Select Time]</option>
											<option value="FN">Fore Noon</option>
											<option value="AN">After Noon</option>
									</select> <span class="star">*</span></td>
								</tr>

								<tr>
									<td class="cell_bg" valign="top" colspan="4"></td>
								</tr>

								<tr>
									<td colspan="5" align="center" valign="top" class="cell_bg">
										<input type="submit" class="btn_medium" value="Submit" onclick="return datevalidate()"/> <input
										type="reset" class="btn_medium" value="Reset" />

									</td>
								</tr>

								<tr>
									<td class="cell_bg" valign="top" colspan="4"></td>
								</tr>
								<tr>
									<td class="cell_bg" valign="top" colspan="4"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>