<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

<script type="text/javascript">
	$(document).ready(sortDropDownListByText);
</script>
<script>
	$(function() {
		$("#dialog-form").dialog({
			modal : true,
			buttons : {
				Ok : function() {
					$(this).dialog("close");
				}
			}
		});
	});
</script>
<script type="text/javascript">
	function validatedetails() {

		var officelevel = document.getElementById("hm3").value;
		if (officelevel == -1) {
			alert("Select Office Level");
			return false;
		}
		var ParentOfficeId = document.getElementById("ParentOfficeId").value;
		if (ParentOfficeId == -1) {
			alert("Select Parent Office");
			return false;
		}
		var placedistrict = document.getElementById("placedistrict").value;
		if (placedistrict == -1) {
			alert("Select District");
			return false;
		}
		var placeName = document.getElementById("placeName").value;
		if (placeName == -1) {
			alert("Select HeadQuarter");
			return false;
		}

	}
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#hm3").val($("#mas_officelevelid").val());
		$("#ParentOfficeId_edit").val($("#parentoffice").val());
		$("#placedistrict").val($("#mas_districtid").val());
		$("#placeName").val($("#ppPlacemasterid").val());
	});
</script>

<%-- <% request.getAttribute("Data"); %>
<% request.getAttribute("Data1"); %> --%>





</head>
<body>



	<form action="/UPJN/saveNewOfficeRecord">
		<input type="hidden" name="rmOfficeid" value="${rmOfficeid}">


		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td valign="top" class="msg"></td>
			</tr>
			<tr>
				<td valign="top" class="error"><c:forEach items="${error}"
						var="item">
                         ${item}<br>
					</c:forEach></td>
			</tr>
			<tr>
				<td valign="top"><table width="98%" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td align="center" valign="top"><table width="80%"
									border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td valign="top"><table width="100%" border="0"
												cellspacing="1" cellpadding="1">
												<tr>
													<td valign="top" class="table_bg"><table width="100%"
															border="0" cellspacing="3" cellpadding="1">
															<tr>
																<td colspan="5" align="left" valign="top"
																	class="table_head">Office Master - Edit Office</td>
															</tr>
															<tr>
																<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
																<td colspan="1" valign="middle" class="error_normal"
																	align="right">* Fields are required.</td>
															</tr>
															<tr>
																<td colspan="5" valign="top" class="table_bg"></td>
															</tr>
															<input type="hidden" name="rm_OfficeID" value="">
															<tr>
																<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																<td width="43%" align="left" valign="top"
																	class="cell_bg">Office Name</td>
																<td align="left" valign="top" class="cell_bg"><c:forEach
																		items="${officeInfo}" var="a">
																		<input type="text" name="officename"
																			value="${a.officename}" maxlength="100" size="30"
																			class="txt_medium">
																		<span class="star"> *</span>
																	</c:forEach></td>
															</tr>
															<tr>
																<td class="cell_bg" valign="top">&nbsp;</td>
																<td class="bold" valign="top" align="left" width="43%">
																	Office Level</td>
																<td class="cell_bg" valign="top" align="left"><c:if
																		test="${officeInfo == null}">
																		<select id="hm3" name="masOfficelevelid"
																			class="cmb_medium">
																			<option value="-1">[Select Level]</option>
																			<c:forEach var="l" items="${levelMap}">
																				<option value="${l.key}">${l.value}</option>
																			</c:forEach>
																		</select>
																	</c:if> <c:if test="${officeInfo != null}">
																		<c:forEach items="${officeInfo}" var="a">
																			<input type="hidden" value="${a.mas_officelevelid}"
																				id="mas_officelevelid" name="mas_officelevelid">
																		</c:forEach>
																		<select id="hm3" name="masOfficelevelid"
																			class="cmb_medium">
																			<option value="-1">[Select Level]</option>
																			<c:forEach var="l" items="${levelMap}">
																				<option value="${l.key}">${l.value}</option>
																			</c:forEach>
																		</select>
																	</c:if></td>
															</tr>

															<tr>

															</tr>

															<tr>
																<td class="cell_bg" valign="top">&nbsp;</td>
																<td class="bold" valign="top" align="left" width="43%">
																	Parent Office</td>
																<td class="cell_bg" valign="top" align="left"><c:if
																		test="${officeInfo == null}">
																		<select id="ParentOfficeId" name="PARENTOFFICEID"
																			class="cmb_medium">
																			<option value="-1">[Select Parent Office]</option>
																			<c:forEach var="d" items="${Data}">
																				<option value="${d.key}">${d.value}</option>
																			</c:forEach>
																		</select>
																	</c:if> <c:if test="${officeInfo != null}">
																		<c:forEach items="${officeInfo}" var="a">
																			<input type="hidden" value="${a.parentofficeid}"
																				id="parentoffice" name="parentoffice">
																		</c:forEach>
																		<select id="ParentOfficeId_edit" name="PARENTOFFICEID"
																			class="cmb_medium">
																			<option value="-1">[Select Parent Office]</option>
																			<c:forEach var="d" items="${Data}">
																				<option value="${d.key}">${d.value}</option>
																			</c:forEach>
																		</select>
																	</c:if></td>
															</tr>






															<%-- <tr>
												<td class="cell_bg" valign="top">&nbsp;</td>
												<td class="bold" valign="top" align="left" width="43%">
											           	Parent Office
												</td> 
												<td class="cell_bg" valign="top" align="left">	
												<c:when test="${list==null}">
													
													<select id="hm" name="rmOfficeid" class="cmb_medium">
													   <option>[Select Parent Office]</option>
													   <c:forEach var="d" items="${Data}">
                                                          <option value="${d.key}">${d.value}</option>
													   </c:forEach>
													</select>
													</c:when>
													<c:otherwise>
													
													<%out.println("No Parent office for this OfficeLevel");%>
													</c:otherwise>
													
																							
												</td>
											</tr> --%>

															<tr>
																<td width="3%" height="20" valign="top" class="cell_bg">&nbsp;</td>
																<td height="20" align="left" valign="top"
																	class="cell_bg">Address</td>
																<td height="25" align="left" valign="middle"
																	class="cell_bg"><c:forEach items="${officeInfo}"
																		var="a">
																		<textarea name="officeaddress" cols="30" rows="5"
																			class="txtarea_small">${a.officeaddress}</textarea>
																		<span class="star"> *</span>
																	</c:forEach></td>
															</tr>
															<tr>
																<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																<td width="43%" align="left" valign="top"
																	class="cell_bg">Phone No. 1</td>
																<td align="left" valign="top" class="cell_bg"><c:forEach
																		items="${officeInfo}" var="a">
																		<input type="text" name="phno1" maxlength="100"
																			size="30" class="txt_medium" value="${a.phno1}"
																			maxlength="16" required>
																	</c:forEach></td>
															</tr>
															<tr>
																<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																<td width="43%" align="left" valign="top"
																	class="cell_bg">Phone No. 2</td>
																<td align="left" valign="top" class="cell_bg"><c:forEach
																		items="${officeInfo}" var="a">
																		<input type="text" name="phno2" value="${a.phno2}"
																			maxlength="100" size="30" class="txt_medium">
																	</c:forEach></td>
															</tr>
															<tr>
																<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																<td width="43%" align="left" valign="top"
																	class="cell_bg">Fax</td>
																<td align="left" valign="top" class="cell_bg"><c:forEach
																		items="${officeInfo}" var="a">
																		<input type="text" name="fax" value="${a.fax}"
																			maxlength="100" size="30" class="txt_medium">
																	</c:forEach></td>
															</tr>
															<tr>
																<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																<td width="43%" align="left" valign="top"
																	class="cell_bg">Location Code</td>
																<td align="left" valign="top" class="cell_bg"><c:forEach
																		items="${officeInfo}" var="a">
																		<input type="text" name="locCode" value="${a.locCode}"
																			maxlength="100" size="30" class="txt_medium">
																	</c:forEach></td>
															</tr>
															<tr>
																<td class="cell_bg" valign="top">&nbsp;</td>
																<td class="bold" valign="top" align="left" width="43%">
																	District</td>
																<td align="left" valign="middle" class="cell_bg"><c:if
																		test="${officeInfo == null}">
																		<select id="placedistrict" name="masDistrictid"
																			class="cmb_medium">
																			<option value="-1">[Select District]</option>
																			<c:forEach var="d" items="${districtMap}">
																				<option value="${d.key}">${d.value}</option>
																			</c:forEach>
																		</select>
																	</c:if> <c:if test="${officeInfo != null}">
																		<c:forEach items="${officeInfo}" var="a">
																			<input type="hidden" value="${a.mas_districtid}"
																				id="mas_districtid" name="mas_districtid">
																		</c:forEach>
																		<select id="placedistrict" name="masDistrictid"
																			class="cmb_medium">
																			<option value="-1">[Select District]</option>
																			<c:forEach var="d" items="${districtMap}">
																				<option value="${d.key}">${d.value}</option>
																			</c:forEach>
																		</select>
																	</c:if></td>

															</tr>


															<tr>
																<td class="cell_bg" valign="top">&nbsp;</td>
																<td class="bold" valign="top" align="left" width="43%">
																	Head Quarter</td>
																<td class="cell_bg" valign="top" align="left">
																	<%-- <select id= "placeName" name="ppPlacemasterid" class="cmb_medium">
													 <option value="-1">[Select Head Quarter]</option> 
													<c:forEach var="d" items="${place}">
                                                          <option value="${d.key}">${d.value}</option>
													   </c:forEach>
													 </select> --%> <c:if test="${Placelist == null}">
																		<select id="placeName" name="ppPlacemasterid"
																			class="cmb_medium">
																			<option value="-1">[Select Head Quarter]</option>
																			<c:forEach var="d" items="${place}">
																				<option value="${d.key}">${d.value}</option>
																			</c:forEach>
																		</select>
																	</c:if> <c:if test="${Placelist != null}">
																		<c:forEach items="${Place}" var="a">
																			<input type="hidden" value="${a.ppPlacemasterid}"
																				id="ppPlacemasterid" name="ppPlacemasterid">
																		</c:forEach>
																		<select id="placeName" name="ppPlacemasterid"
																			class="cmb_medium">
																			<option value="-1">[Select Head Quarter]</option>
																			<c:forEach var="d" items="${Placelist}">
																				<option value="${d.ppPlacemasterid}">${d.place}</option>
																			</c:forEach>
																		</select>
																	</c:if>
																</td>
															</tr>

															<tr>
																<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
															</tr>
															<tr>
																<td colspan="5" align="center" valign="top"
																	class="cell_bg"><input type="submit"
																	value="Submit" onclick="return validatedetails()"
																	class="btn_small">&nbsp;&nbsp; <input
																	type="reset" value="Reset" class="btn_small"></td>
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