<!DOCTYPE HTML >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM-New Posting</title>

<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script type="text/javascript" src="resources/js/validation.js"></script>
<script type="text/javascript" src="resources/js/popcalendar.js"></script>
<script type="text/javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<script src="<c:url value="/resources/js/upjn.js" />"></script>
<!-- <script type="text/javascript">
	$(document).ready(sortDropDownListByText);
</script> -->

<script type="text/javascript">
function validatedate(){
	 var pod = document.getElementById("orderdate").value;
	 var ed = document.getElementById("effectivedate").value;       
	 var curr_date = document.getElementById("currentdate").value;
     
	 var msg = new String();
	 var retVal = compareDates_in(pod, ed);
		if ((retVal == 1)) { // 'Posting Order Date' > 'Effective Date'
			msg = "Posting Order Date should be less than Effective date";
			alert(msg);
			return false;
		}
	  
		retVal = compareDates_in(pod,curr_date);

		if ((retVal == 1)) { // If 'Posting Order Date' < 'Current Date'	
			msg = "Posting Order Date should be greater than or equal to Current Date";
			alert(msg);
			return false;
		}	
		
        var office_level = document.getElementById("hm").value;
		
		if (office_level == -1) {
			alert("Please select Office Level");
			return false;
		}
		
		 var district = document.getElementById("district").value;
			
			if (district == -1) {
				alert("Please select District");
				return false;
			}
			
			 var office_name = document.getElementById("hmap").value;
				
				if (office_name == -1) {
					alert("Please select Office Name");
					return false;
				}
	}
</script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#hm_edit").val($("#officelevelID").val());
		$("#district_edit").val($("#districtID").val());
		$("#hmap_edit").val($("#officeID").val());
		
	});
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
			<form action="/UPJN/SavePosting" method="post" onsubmit="return validatedate()">
				<input type="hidden" name="ppEmployeemasterid"
					value="${PPEMPLOYEEMASTERID}">

				<table style="border: 0px; width: 100%;">

					<tr>
						<td valign="top" class="msg"></td>
					</tr>
					<tr>
						<td align="left" valign="top" class="error"></td>
					</tr>
					<tr>
					<c:set var="currentdate" value="<%=new java.util.Date()%>" />
					<td><input type="hidden" name="currentdate" id="currentdate"
						value="<fmt:formatDate pattern="dd/MM/yyyy" value="${currentdate}" />">
					</td>
				</tr>
					<tr>
						<td valign="top">
							<table style="border: 0px; width: 100%;">
								<tr>
									<td valign="top" align="center"><table
											style="border: 0px; width: 100%;">
											<tr>
												<td valign="top" align="center"><table
														style="border: 0px; width: 100%;">
														<tr>
															<td class="table_bg" valign="top"><table
																	style="border: 0px; width: 100%;">
																	<tr>
																		<td class=table_head valign="top" align="left"
																			width="95%">Posting - Add Posting Details</td>
																		<td align="center" valign="middle" class="table_head">
																			<a href="/UPJN/getPostingListForEdit"> <img alt=""
																				src="resources/images/cross.jpeg">
																		</a>
																		</td>
																	</tr>
																</table>

																<table style="border: 0px; width: 100%;">
																	<tr>
																		<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
																		<td colspan="1" valign="middle" class="error_normal"
																			align="right">* Fields are required.</td>
																	</tr>
																	<tr>
																		<td class="cell_bg" valign="top" colSpan="5"
																			align="left"><b> Posting Against-Appointment
																		</b></td>
																	</tr>

																	<tr>
																		<td>&nbsp;</td>
																	</tr>

																	<tr>
																		<td class="cell_bg" valign="top">&nbsp;</td>
																		<td class="cell_bg" valign="top" align="left">
																			Employee Name</td>
																		<td class="cell_bg" valign="top" align="left"><c:forEach
																				items="${basicInfo}" var="a">
							                                ${a.employeename}</c:forEach></td>
																	</tr>
																	<tr>
																		<td colspan="3"></td>
																	</tr>
																	<tr>
																		<td class="cell_bg" valign="top" width="3%">&nbsp;</td>
																		<td class="cell_bg" valign="top" align="left">
																			Designation</td>
																		<td class="cell_bg" valign="middle" align="left">

																			<c:forEach items="${basicInfo}" var="a">
							                                            ${a.designation}</c:forEach>
																		</td>
																	</tr>
																	<tr>
																		<td>&nbsp;</td>
																	</tr>


                                                                <!-- Select Office Level -->
																	
																	<tr>
																		<td class="cell_bg" valign="top">&nbsp;</td>
																		<td class="cell_bg" valign="top" align="left">
																			Office Level</td>
																		<td class="cell_bg" valign="top" align="left">
																		
																		<c:choose>
																		<c:when test="${list == null}">	
																			<select
																			id="hm" name="mas_OfficeLevelID" class="cmb_medium"
																			required>
																				<option value="-1">[Select Level]</option>
																				<c:forEach var="d" items="${Data}">
																					<option value="${d.key}">${d.value}</option>
																				</c:forEach>
																		</select>
																		</c:when>
																		<c:otherwise>
																		<select
																			id="hm_edit" name="mas_OfficeLevelID" class="cmb_medium"
																			required>
																				<option value="-1">[Select Level]</option>
																				<c:forEach var="d" items="${Data}">
																					<option value="${d.key}">${d.value}</option>
																				</c:forEach>
																		</select></c:otherwise>
																		</c:choose>
																		
																		
																		
																		</td>
																	</tr>

                                                                 <!-- Select District Name -->
																	<tr>
																		<td class="cell_bg" valign="top">&nbsp;</td>
																		<td class="cell_bg" valign="top" align="left">
																			District</td>
																		<td align="left" valign="middle" class="cell_bg">
																		
																	<c:choose>
																		<c:when test="${list == null}">	
																			<select id="district" name="mas_DistrictID"
																			class="cmb_medium">
																				<option value="-1">[Select District]</option>
																				<c:forEach var="d" items="${Data1}">
																					<option value="${d.key}">${d.value}</option>
																				</c:forEach>
																		</select>
																		</c:when>
																		<c:otherwise>
																		<select id="district_edit" name="mas_DistrictID"
																			class="cmb_medium">
																				<option value="-1">[Select District]</option>
																				<c:forEach var="d" items="${Data1}">
																					<option value="${d.key}">${d.value}</option>
																				</c:forEach>
																		</select></c:otherwise>
																		</c:choose>
																		
									 									</td>
																	</tr>
														
								<!--  -->
								
								<c:forEach items="${list}" var="a">								    
								    <tr><td>
								    <input type="hidden" id="officeID" value="${a.rmOfficeid}">
								     <input type="hidden" id="districtID" value="${a.masDistrictid}">
								    <input type="hidden" id="officelevelID" value="${a.masOfficelevelid}">
								     </td>  
								</tr></c:forEach>
								
  								<!--  -->						
																<!-- Select Office Name -->	
																	<tr>
																		<td class="cell_bg" valign="top">&nbsp;</td>
																		<td class="cell_bg" valign="top" align="left">
																			Office Name</td>
																		<td class="cell_bg" valign="top" id="officename"
																			align="left">
											                    	<c:choose>
																		<c:when test="${list == null}">
																		<select
																			id="hmap" name="rmOfficeid" class="cmb_medium"
																			required>
																				<option value="-1">[Select Office Name]</option>
																				<c:forEach var="d" items="${officename}">
																					<option value="${d.key}">${d.value}</option>
																				</c:forEach>
																		</select>
																		</c:when>
																		<c:otherwise>
																		<select
																			id="hmap_edit" name="rmOfficeid" class="cmb_medium"
																			required>
																				<option value="-1">[Select Office Name]</option>
																				<c:forEach var="d" items="${officename}">
																					<option value="${d.key}">${d.value}</option>
																				</c:forEach>
																		</select>
																		</c:otherwise>
																		</c:choose>							
																			
																			</td>
																	</tr>
																	<tr>
																		<td valign="top" class="cell_bg">&nbsp;</td>
																		<td align="left" valign="top" class="cell_bg">Posting
																			Order Date (dd/mm/yyyy)</td>

																		<td align="left" valign="top" class="cell_bg"><c:choose>
																				<c:when test="${list==null}">
																					<input type="text" class="txt_date" id="orderdate"
																						readonly="readonly" name="orderdate" required>
																					<a href="javascript:;"
																						onclick="displayCalendar(document.forms[0].orderdate,'dd/mm/yyyy',document.forms[0].orderdate)">

																						<img height="16" hspace="0"
																						src="resources/images/calendar-icon.gif"
																						width="16" border="0" />
																					</a>
																					<span class="star">*</span>
																				</c:when>
																				<c:otherwise>
																					<c:forEach items="${list}" var="a">
																						<input type="text" class="txt_date"  id="orderdate"
																							readonly="readonly" name="orderdate"
																							value='<fmt:formatDate pattern="dd/MM/yyyy" value="${a.orderdate}"/>' required>
																						<a href="javascript:;"
																							onclick="displayCalendar(document.forms[0].orderdate,'dd/mm/yyyy',document.forms[0].orderdate)">

																							<img height="16" hspace="0"
																							src="resources/images/calendar-icon.gif"
																							width="16" border="0" />
																						</a>
																						<span class="star">*</span>
																					</c:forEach>
																				</c:otherwise>
																			</c:choose></td>
																	</tr>

																	<tr>
																		<td class="cell_bg" valign="top">&nbsp;</td>
																		<td class="cell_bg" valign="top" align="left">
																			Posting Order No.</td>
																		<td class="cell_bg" valign="top" align="left"
																			colspan="3"><c:choose>
																				<c:when test="${list==null}">
																					<input type="text" name="postingorderno"
																						class="txt_medium" maxlength="50" required>
																				</c:when>
																				<c:otherwise>
																					<c:forEach items="${list}" var="a">
																						<input type="text" name="postingorderno"
																							class="txt_medium" required maxlength="50"
																							value="${a.postingorderno}">
																					</c:forEach>
																				</c:otherwise>
																			</c:choose> <span class="star">*[Max 50 char.]</span></td>
																	</tr>
																	<tr>
																		<td class="cell_bg" valign="top">&nbsp;</td>
																		<td class="cell_bg" valign="top" align="left"
																			width="43%">Effective Date (dd/mm/yyyy)</td>
																		<td class="cell_bg" valign="top" align="left"><c:choose>
																				<c:when test="${list==null}">
																					<input type="text" class="txt_date" id="effectivedate"
																						readonly="readonly" name="effectivedate" required>
																					<a href="javascript:;"
																						onclick="displayCalendar(document.forms[0].effectivedate,'dd/mm/yyyy',document.forms[0].effectivedate)">
																						<img height="16" hspace="0"
																						src="resources/images/calendar-icon.gif"
																						width="16" border="0" />
																					</a>
																				</c:when>
																				<c:otherwise>
																					<c:forEach items="${list}" var="a">
																						<input type="text" class="txt_date" id="effectivedate"
																							readonly="readonly" name="effectivedate"
																							value='<fmt:formatDate pattern="dd/MM/yyyy" value="${a.effectivedate}"/>' required>
																						<a href="javascript:;"
																							onclick="displayCalendar(document.forms[0].effectivedate,'dd/mm/yyyy',document.forms[0].effectivedate)">
																							<img height="16" hspace="0"
																							src="resources/images/calendar-icon.gif"
																							width="16" border="0" />
																						</a>
																					</c:forEach>
																				</c:otherwise>
																			</c:choose> <span class="star">*</span></td>
																	</tr>

																	<tr>
																		<td class="cell_bg" valign="top" colSpan=5>&nbsp;</td>
																	</tr>
																	<tr>
																		<td class="cell_bg" valign="top" align="center"
																			colSpan="5"><input type="submit"
																			class="btn_medium" value="Submit" /> <input
																			type="reset" class="btn_medium" value="Reset" /></td>
																	</tr>
																</table></td>
														</tr>
													</table></td>
											</tr>
										</table></td>
								</tr>
							</table>
					<tr>
						<td valign="top" height=30>&nbsp;</td>
					</tr>
				</table>
			</form>

		</div>
	</div>
</body>
</html>