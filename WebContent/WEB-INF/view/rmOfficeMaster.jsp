<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>U.P JAL NIGAM-RM Office Master</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script language="javascript" src="resources/js/validation.js"></script>
<script language="javascript" src="resources/js/popcalendar.js"></script>
<script language="javascript" src="resources/js/NEW_NEW.js"></script>
<script language="javascript" src="resources/js/upjn.js"></script>

<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
<script type="text/javascript" src="resources/js/jquery-latest.js"></script>
<script type="text/javascript" src="resources/js/tablesorter.js"></script>
<script type="text/javascript">
    $(document).ready(sortDropDownListByText);
	$(document).ready(function() {
		  $("#myTable").tablesorter();
	});
</script>
<!-- <script>
  $(function() {
    $( "#dialog-form" ).dialog({
      modal: true,
      buttons: {
        Ok: function() {
          $( this ).dialog( "close" );
        }
      }
    });
  });
  </script> -->

</head>

<body>
	<script type="text/javascript" language="Javascript1.1"> 


</script>
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
			<form action="/UPJN/officeMasterWork">
				<input type="hidden" name="rmOfficeid" value="${rmOfficeid}">
				<table border="0" cellpadding="0" cellspacing="0" width="100%">

					<tr>
						<td valign="top" class="msg">${mes}</td>
					</tr>
					<tr>
						<td align="left" valign="top" class="error">${error}</td>
					</tr>
					<tr>
						<td valign="top"><table width="98%" border="0" align="center"
								cellpadding="0" cellspacing="0">
								<tr>
									<td align="center" valign="top"><table width="60%"
											border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td valign="top"><table width="100%" border="0"
														cellspacing="1" cellpadding="1">
														<tr>
															<td valign="top" class="table_bg"><table
																	width="100%" border="0" cellspacing="0" cellpadding="3">
																	<tr>
																		<td colspan="3" valign="top" class="table_head"
																			align="left">Role Management - Office Master</td>
																	</tr>
																	<tr>
																		<td align="left" valign="top" class="cell_bg"
																			colspan="4">&nbsp;</td>
																	</tr>
																	<tr>
																		<td colspan="3" valign="top" class="table_bg"></td>
																	</tr>

																	<tr>
																		<td class="cell_bg" valign="top">&nbsp;</td>
																		<td class="bold" valign="top" align="center"
																			width="43%">Office Name</td>
																		<td class="cell_bg" valign="top" id="officename"
																			align="left"><input type="text"
																			name="officename" maxlength="50" size="30"
																			class="txt_medium"> <span class="star">*[Max
																				100 char.]</span></td>
																	</tr>



																	<tr>
																		<td class="cell_bg" valign="top">&nbsp;</td>
																		<td class="bold" valign="top" align="center"
																			width="43%">Office Level</td>
																		<td class="cell_bg" valign="top" align="left"><select
																			name="masOfficelevelid" class="cmb_medium">
																				<option>[Select Level]</option>
																				<c:forEach var="d" items="${Data}">
																					<option value="${d.key}">${d.value}</option>
																				</c:forEach>
																		</select> <!-- 
													<select name="mas_OfficeLevelID" class="cmb_medium">
													 <option value="-1">[Select Level]</option> 
													 <option>List of Office Level</option>													 
													 </select> --></td>
																	</tr>
																	<tr>
																		<td class="cell_bg" valign="top">&nbsp;</td>
																		<td class="bold" valign="top" align="center"
																			width="43%">District</td>
																		<td align="left" valign="middle" class="cell_bg">
																			<select name="masDistrictid" class="cmb_medium">
																				<option value="-1">[Select District]</option>
																				<c:forEach var="d" items="${Data1}">
																					<option value="${d.key}">${d.value}</option>
																				</c:forEach>
																		</select>


																		</td>

																	</tr>


																	<tr>
																		<td colspan="3" valign="top" class="cell_bg">&nbsp;</td>
																	</tr>
																	<tr>
																		<td colspan="3" align="center" valign="top"
																			class="cell_bg"><input type="submit"
																			value="Add More" name="addNewOffice"
																			class="btn_medium">&nbsp;&nbsp; <input
																			type="submit" value="Search" name="searchOffice"
																			class="btn_small">&nbsp;&nbsp; <input
																			type="reset" value="Reset" class="btn_small">&nbsp;&nbsp;</td>
																	</tr>
																	<tr>
																		<td colspan="9" valign="top" class="cell_bg"
																			align="right"></td>
																	</tr>
																</table></td>
														</tr>
													</table></td>
											</tr>
										</table></td>
								</tr>
							</table>
						<td height="30" valign="top">&nbsp;</td>

					</tr>
				</table>
				<BR>
				<script type="text/javascript" src="resources/js/tablesorter.js"></script>

				<!--  -->

				<table width="90%" class="table_bg" cellpadding="3" cellspacing="3"
					border="0" align="center">
					<tr>
						<td>
							<div style="overflow-y: scroll; height: 400px">
								<table width="100%" id="myTable" cellpadding="0" cellspacing="1"
									border="0" class="tablesorter">

									<thead id="h" align="center">
										<tr>
											<th id="t" width="20%"><img alt=""
												src="resources/images/sort.gif">Office Name</th>
											<th id="t" width="20%"><img alt=""
												src="resources/images/sort.gif">Office Level</th>
											<th id="t" width="20%"><img alt=""
												src="resources/images/sort.gif">District</th>
											<th id="t" width="20%"><img alt=""
												src="resources/images/sort.gif">Address</th>
											<th id="t" width="20%">Action</th>
										</tr>
									</thead>

									<tbody id="b" align="center">
										<c:forEach items="${list}" var="list">
											<tr>

												<td>${list.officename}</td>
												<td>${list.officelevel}</td>
												<td>${list.districtname}</td>
												<td>${list.officeaddress}</td>
												<td><a
													href="/UPJN/EditNewOfficeRecord?rmOfficeid=<c:out value="${list.rmOfficeid}"/>"><u>Edit</u></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>


</html>
