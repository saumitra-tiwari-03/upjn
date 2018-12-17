
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM-Service Book Personal Information</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">


<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script language="javascript" src="resources/js/validation.js"></script>
<script language="javascript" src="resources/js/popcalendar.js"></script>
<script language="javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>

<script type="text/javascript">
	
    $(document).ready(sortDropDownListByText);
</script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script language="javascript">
			// this function is added by deveki n mishra on 11 february 2008
			function numbersonly(e){
				var unicode=e.charCode? e.charCode : e.keyCode
				if (unicode!=8){ //if the key isn't the backspace key (which we should allow)
				if (unicode<48||unicode>57) //if not a number
					return false //disable key press
				}
			}
			// end function numbersonly
			function validateForm(value){
				if(IsNumeric(document.forms[0].retirementAge.value)==false){
					alert('The Retirement Age Should be numeric');
					return false;
				}
				if(IsNumeric(document.forms[0].ml_OpenBalance.value)==false){
					alert('The Medical Leave Balance Should be numeric');
					return false;
				}
				return validateEmployeePersonalForm(value);
			}
			/* This function is used to check the a numeric value.*/
			function IsNumeric(sText){
				var ValidChars = "0123456789.";
   				var IsNumber=true;
   				var Char;
				for (i = 0; i < sText.length && IsNumber == true; i++) { 
      				Char = sText.charAt(i); 
      				if (ValidChars.indexOf(Char) == -1){
         				IsNumber = false;
         			}
      			}// end of for loop	
   				if(IsNumber==false){
					//alert('Only Numberic Value Required Here.');
					return false;	
				}// end of if
			}// end of function.

			function fun_onload(){
				var sexcode=document.forms[0].${sexcode};
				var husbandName=document.forms[0].husbandName;
				if ( sexcode[0].checked == true && sexcode[0].value == 'm'){
					husbandName.value="";
					husbandName.readOnly = true;
				}
				else{
					husbandName.readOnly = false;
				}
 			}

</script>
<body bgcolor="#ffffff" onload="return fun_onload();">

	<form action="/UPJN/insertEmployeePersonalDetails" method="post">
		<input type="hidden" name="PpEmployeemasterid"
			value="${PpEmployeemasterid}">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top" class="msg">${msg}</td>
			</tr>
			<tr>
				<td valign="top" class="error">${error}</td>
			</tr>
			<tr>
				<td valign="top">
					<table width="90%" align="center" cellpadding="0" cellspacing="0"
						border="0">
						<tr>
							<td valign="top">
								<table width="100%" align="center" cellpadding="0"
									cellspacing="0" border="0" class="table_bg">
									<tr>
										<td valign="top">
											<table width="100%" align="center" class="cell_bg"
												cellpadding="0" cellspacing="1" border="0">
												<tr>
													<td width="95%" align="left" valign="top"
														class="table_head">Service Book-Personal Information
													</td>
													<td align="center" valign="middle" class="table_head">
														<a href="/upjn3/SearchEmployee.do?method=searchEmployeeSB"><img
															src="images/cross.jpeg" height="16" width="16" border="0"
															hspace="0"></a>
													</td>
												</tr>

											</table>
											<table width="100%" align="center" class="cell_bg"
												cellpadding="0" cellspacing="1" border="0">
												<tr>
													<td colspan="4">&nbsp;</td>
												</tr>
												<tr>
													<td colspan="1" valign="middle" class="tabdefault"
														bordercolor="#4390E0" bgcolor="#FFFFFF" width="25%">
														<strong> Personal Details </strong>
													</td>

													<td colspan="1" valign="middle" class="tabdefault"
														bordercolor="#4390E0" bgcolor="#4390E0" width="25%">
														<a
														href="/UPJN/qualificationDetails?PpEmployeemasterid=<c:out value="${PpEmployeemasterid}"/>"><strong>Qualification
																Details</strong> </a>
													</td>
													<td colspan="1" valign="middle" class="tabdefault"
														bordercolor="#4390E0" bgcolor="#4390E0" width="25%">
														<a
														href="/UPJN/NomineeDetails?PpEmployeemasterid=<c:out value="${PpEmployeemasterid}"/>"><strong>Nominee
																Details</strong></a>
													</td>
													<td colspan="1" valign="middle" class="tabdefault"
														bordercolor="#4390E0" bgcolor="#4390E0" width="25%">
														<a
														href="/UPJN/DependentDetails?PpEmployeemasterid=<c:out value="${PpEmployeemasterid}"/>"><strong>Dependent
																Details</strong></a>

													</td>
												</tr>
												<tr>
													<td colspan="4" valign="top" class="cell_bg">&nbsp;</td>
												</tr>
											</table>
											 <!-- Inner Table No 2	-->

											<table width="100%" border="0" cellspacing="1"
												cellpadding="3">
												<tr>
													<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
													<td colspan="1" valign="middle" class="error_normal"
														align="right">* Fields are required.</td>
												</tr>
												<tr>
													<td colspan="5" valign="top" class="table_bg"></td>
												</tr>
												<tr>
													<td align="left" colspan="3" class="bold">Personal
														Details:</td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">
														Employee Code</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
							                              ${a.employeecode}</c:forEach></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">First
														Name</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
															<input type="text" class="txt_medium" maxlength="16"
																name="firstname" readonly="readonly"
																value="${a.firstname}">
														</c:forEach></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Middle
														Name</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
															<input type="text" class="txt_medium" maxlength="16"
																name="middlename" value="${a.middlename}">
														</c:forEach></td>
												</tr>
												<tr>
													<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Last
														Name</td>
													<td align="left" valign="middle" class="cell_bg"><c:forEach
															items="${list}" var="a">
															<input type="text" class="txt_medium" maxlength="16"
																name="lastname" readonly="readonly"
																value="${a.lastname}">
														</c:forEach></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Sex</td>
													<td align="left" valign="top" class="cell_bg"><input
														type="radio" name="sexcode" value="m" checked="checked"
														onclick="return fun_onload();">Male <input
														type="radio" name="sexcode" value="f"
														onclick="return fun_onload();">Female <span
														class="star">*</span></td>
												</tr>
												<tr>
													<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">
														Designation</td>
													<td align="left" valign="middle" class="cell_bg"><c:forEach
															items="${list}" var="a">
							                              ${a.designation}</c:forEach></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">
														Father's Name</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
															<input type="text" class="txt_medium" maxlength="16"
																name="fathername" readonly="readonly"
																value="${a.fathername}">
														</c:forEach> <span class="star">*[Max 30 char.]</span></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">
														Husband's Name</td>
													<td align="left" valign="top" class="cell_bg"><input
														type="text" name="husbandname" readonly="readonly"
														maxlength="30" size="30" class="txt_medium"></td>
												</tr>
												<tr>
													<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
													<td width="43%" align="left" valign="top" class="cell_bg">
														Reservation Category</td>
													<td align="left" valign="top" class="cell_bg"><select
														name="masCasteid" class="cmb_medium"><option
																value="-1">[Select Category]</option>
															<c:forEach var="rc" items="${reservationCategoryMap}">
																<option value="${rc.key}">${rc.value}</option>
															</c:forEach>
													</select> <span class="star">*</span></td>
												</tr>
												<tr>
													<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
													<td width="43%" align="left" valign="top" class="cell_bg">
														Religion</td>
													<td align="left" valign="top" class="cell_bg"><select
														id="religionMap" name="masReligionid" class="cmb_medium"><option
																value="-1">[Select Religion]</option>
															<c:forEach var="r" items="${religionMap}">
																<option value="${r.key}">${r.value}</option>
															</c:forEach>
													</select> <span class="star">*</span></td>
												</tr>
												<tr>
													<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
													<td width="43%" align="left" valign="top" class="cell_bg">
														Marital Status</td>
													<td align="left" valign="top" class="cell_bg"><select
														name="masMaritalstatusid" class="cmb_medium" required>

															<option value="-1">[Select Marital Status]</option>
															<c:forEach var="ms" items="${maritalStatusMap}">
																<option value="${ms.key}">${ms.value}</option>
															</c:forEach>
													</select> <span class="star">*</span></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Date of
														Birth (dd/mm/yyyy)</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
															<input type="text" class="txt_medium" maxlength="16"
																name="dateofbirth"
																value='<fmt:formatDate value="${a.dateofbirth}" pattern="dd/MM/yyyy"/>'
																>
															<a href="javascript:;"
																onclick="displayCalendar(document.forms[0].dateofbirth,'dd/mm/yyyy',document.forms[0].dateofbirth)">

																<img height="16" hspace="0"
																src="resources/images/calendar-icon.gif" width="16"
																border="0" />
															</a>
														</c:forEach> <span class="star">*(dd/mm/yyyy)</span></td>
												</tr>
												<tr>
													<td align="left" colspan="3" class="bold">Address:</td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">
														Permanent Address</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">

															<textarea name="permanentaddress" required
																class="txtarea_small">${a.permanentaddress}</textarea>
														</c:forEach> <span class="star">*[Max 150 char.]</span></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">
														District</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
															<input type="text" class="txt_medium" maxlength="16"
																name="district" value="${a.district}" required>
														</c:forEach> <span class="star">*[Max 30 char.]</span></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">
														Pin-Code</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
															<input type="text" class="txt_medium" maxlength="16"
																name="pincode" size="30"
																onkeypress="return numbersonly(event);"
																value="${a.pincode}" class="txt_medium">
														</c:forEach></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Present
														Address</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
															<textarea p name="presentaddress" required
																class="txtarea_small">${a.presentaddress}</textarea>
														</c:forEach> <span class="star">*[Max 150 char.]</span></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Ph No
														(Home)</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
															<input type="text" class="txt_medium" maxlength="16"
																name="homephno" size="30" value="${a.homephno}">
														</c:forEach> <span class="star">[Max 15 char.]</span></td>
												</tr>
												<tr>

													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Ph No
														(Office)</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
															<input type="text" class="txt_medium" maxlength="16"
																name="officephno" size="30" value="${a.officephno}">
														</c:forEach></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Mobile
														No.</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
															<input type="text" class="txt_medium" maxlength="16"
																name="mobileno" size="30" value="${a.mobileno}">
														</c:forEach>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Email</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
															<input type="text" class="txt_medium" maxlength="16"
																name="emailid" size="30" value="${a.emailid}">
														</c:forEach> <span class="star">[Max 50 char.]</span></td>
												</tr>
												<tr>
													<td align="left" colspan="3" class="bold">General
														Information:</td>
												</tr>



												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Date of
														Retirement</td>

													<td align="left" valign="top" class="cell_bg"><c:choose>
															<c:when test="${list==null}">
																<input type="text" class="txt_date"
																	name="retirementdate">
																<a href="javascript:;"
																	onclick="displayCalendar(document.forms[0].retirementdate,'dd/mm/yyyy',document.forms[0].retirementdate)">

																	<img height="16" hspace="0"
																	src="resources/images/calendar-icon.gif" width="16"
																	border="0" />
																</a>
																<span class="star">*(dd/mm/yyyy)</span>
															</c:when>
															<c:otherwise>
																<c:forEach items="${list}" var="a">
																	<input type="text" class="txt_date"
																		name="retirementdate"
																		value='<fmt:formatDate value="${a.retirementdate}" pattern="dd/MM/yyyy"/>'
																		 >
																	<a href="javascript:;"
																		onclick="displayCalendar(document.forms[0].retirementdate,'dd/mm/yyyy',document.forms[0].retirementdate)">

																		<img height="16" hspace="0"
																		src="resources/images/calendar-icon.gif" width="16"
																		border="0" />
																	</a>
																	<span class="star">*(dd/mm/yyyy) </span>
																</c:forEach>
															</c:otherwise>
														</c:choose></td>
												</tr>

										<!-- Age of Retirement -->
												
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Age of
														Retirement</td>
													<td align="left" valign="top" class="cell_bg">
													
													<c:choose>
													<c:when test="${list==null}">
													<input
														type="text" name="retirementage" maxlength="2" size="30"
														onkeypress="return numbersonly(event);" class="txt_no"
														required>
														</c:when>
														<c:otherwise>
														<c:forEach items="${list}" var="a">
														<input
														type="text" name="retirementage" maxlength="2" size="30"
														onkeypress="return numbersonly(event);" class="txt_no" value="${a.retirementage}"
														required>
														</c:forEach>
														</c:otherwise>
														</c:choose>
														 <span class="star">*</span></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">PAN No.
													</td>
													<td align="left" valign="top" class="cell_bg"><input
														type="text" name="panno" maxlength="10" size="30"
														class="txt_medium"></td>
												</tr>

												<tr>
													<td class="cell_bg" valign="top">&nbsp;</td>
													<td class="cell_bg" valign="top" align="left">Blood
														Group</td>
													<td align="left" valign="middle" class="cell_bg"><select
														name="bloodgroup" class="cmb_medium">
															<option selected="selected" disabled>Select
																Blood Group</option>
															<option value="A-">A-</option>
															<option value="A+">A+</option>
															<option value="B-">B-</option>
															<option value="B+">B+</option>
															<option value="O-">O-</option>
															<option value="O+">O+</option>
															<option value="AB-">AB-</option>
															<option value="AB+">AB+</option>
															<option value="not available">not available</option>

													</select></td>

												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Home
														Town</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
															<input type="text" class="txt_medium" maxlength="30"
																name="hometown" size="30" value="${a.hometown}" required>
														</c:forEach> <span class="star">*[Max 30 char.]</span></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Height
														(in cm)</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
															<input type="text" class="txt_no" maxlength="3"
																name="height" size="10"
																onkeypress="return numbersonly(event);"
																value="${a.height}">
														</c:forEach> <span class="star">[Max 3 char.]</span></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">
														Personal Identification Mark</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
															<input type="text" class="txt_medium" maxlength="30"
																name="personalidentificationmark"
																value="${a.personalidentificationmark}" required>
														</c:forEach> <span class="star">*[Max 30 char.]</span></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Is
														Spouse working with Government?</td>
													<td align="left" valign="top" class="cell_bg" required>
														<input type="radio" name="spouseworkingwithgovt" value="1">Yes
														<input type="radio" name="spouseworkingwithgovt" value="0">No
														<span class="star">*</span>
													</td>
												</tr>
												<tr>
													<td align="left" colspan="3" class="bold">Medical
														Leave Opening Balance</td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Medical
														Leave Balance</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">


															<input type="text" class="txt_no" maxlength="3"
																name="mlOpenbalance"
																onkeypress="return numbersonly(event);"
																value="${a.mlOpenbalance}">
														</c:forEach></td>
												</tr>


												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">As On
														Date</td>

													<td align="left" valign="top" class="cell_bg"><c:choose>
															<c:when test="${list==null}">
																<input type="text" class="txt_date" name="mlOpenbaldate">
																<a href="javascript:;"
																	onclick="displayCalendar(document.forms[0].mlOpenbaldate,'dd/mm/yyyy',document.forms[0].mlOpenbaldate)">

																	<img height="16" hspace="0"
																	src="resources/images/calendar-icon.gif" width="16"
																	border="0" />
																</a>
																<span class="star">*</span>
															</c:when>
															<c:otherwise>
																<c:forEach items="${list}" var="a">
																	<input type="text" class="txt_date"
																		name="mlOpenbaldate" 
																		value='<fmt:formatDate value="${a.mlOpenbaldate}" pattern="dd/MM/yyyy"/>'
																		>
																	<a href="javascript:;"
																		onclick="displayCalendar(document.forms[0].mlOpenbaldate,'dd/mm/yyyy',document.forms[0].mlOpenbaldate)">

																		<img height="16" hspace="0"
																		src="resources/images/calendar-icon.gif" width="16"
																		border="0" />
																	</a>
																	<span class="star">* (dd/mm/yyyy)</span>
																</c:forEach>
															</c:otherwise>
														</c:choose></td>
												</tr>

												<tr>

													<!--**************************************************************************************************************-->
												<tr>
													<td align="left" colspan="3" class="bold"></td>
												</tr>
												<tr>
													<td align="left" colspan="3" class="bold">Appointment
														Details</td>
												</tr>
												<tr>
													<td align="left" colspan="3" class="bold"></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">
														Appointment Letter Date (dd/mm/yyyy)</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
							                            <fmt:formatDate value="${a.appointmentfiledate}" pattern="dd/MM/yyyy"/>
							                              </c:forEach></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">
														Appointment Letter No.</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
							                              ${a.appointmentfileno}</c:forEach></td>
												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">
														Appointing Authority</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
							                              ${a.appointmentauthority}</c:forEach></td>


												</tr>
												<tr>
													<td valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Date of
														Joining (dd/mm/yyyy)</td>
													<td align="left" valign="top" class="cell_bg"><c:forEach
															items="${list}" var="a">
															<fmt:formatDate value="${a.datejoining}" pattern="dd/MM/yyyy"/>
							                            </c:forEach></td>
												</tr>
												<tr>
													<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">Mode of
														Appointment</td>
													<td align="left" valign="middle" class="cell_bg"><c:forEach
															items="${list}" var="a">
							                              ${a.subphasename}</c:forEach></td>
												</tr>
												<tr>
													<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">
														Employment Type</td>
													<td align="left" valign="middle" class="cell_bg"><c:forEach
															items="${list}" var="a">
							                              ${a.employmenttype}</c:forEach></td>
												</tr>
												<!--	Apearance of this combo depends upon above combo -->

												<tr>
													<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">
														Designation</td>
													<td align="left" valign="middle" class="cell_bg"><c:forEach
															items="${list}" var="a">
							                              ${a.firstdesignation}</c:forEach></td>
												</tr>

												<!--	Apearance of this combo depends upon above combo -->

												<tr>
													<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
													<td align="left" valign="top" class="cell_bg">
														Employment Category</td>
													<td align="left" valign="middle" class="cell_bg"><c:forEach
															items="${list}" var="a">
							                              ${a.employmentsubtype}</c:forEach></td>
												</tr>

												<!--**************************************************************************************************************-->

												<tr>
													<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
												</tr>
												<tr>
													<td colspan="1" align="center" valign="top" class="cell_bg">&nbsp;
													</td>
													<td colspan="2" align="center" valign="middle"
														class="cell_bg"><input type="submit" value="Submit"
														class="btn_medium">&nbsp; <input type="reset"
														value="Reset" class="btn_medium"></td>
													<td colspan="1" align="right" valign="top" class="cell_bg">
														<!-- 	<a href="ManageEmpQualification.do?method=begin&amp;pp_EmployeeMasterID=1053">next >></a>		 -->
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>