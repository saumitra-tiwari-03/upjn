

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>






<html>
	<head>
	
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Promotion Management Info</title>
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
<script>
function fillDateOfJoiningNewAutomatic(){
	document.forms[0].joinDate.value=document.forms[0].effectiveDate.value;
}
function customValidation(form){
	var isValid=true;
	var msg="";
	var orderDate,effectiveDate,joiningDate;
	isValid=validateEmpPromotionForm(form)
	if (isValid){
		orderDate = document.forms[0].orderDate.value;
		effectiveDate=document.forms[0].effectiveDate.value;
		joiningDate=document.forms[0].joinDate.value;
			
		effJoinDiff=compareDates_in(effectiveDate, joiningDate);	
		if (effJoinDiff==1 && document.forms[0].is_Promotion_ForeGo.checked == false){
			msg=msg+"'Joining Date' should be on or after 'Effective From Date'\n";
			isValid=false;
		}
		orderJoinDiff=compareDates_in(orderDate, joiningDate);/*
		if (orderJoinDiff==1 && document.forms[0].is_Promotion_ForeGo.checked == false ){
			msg=msg+"'Joining Date' should be on or after 'Order Date'\n";
			isValid=false;
		} */

	}
	if (msg!=""){
		alert(msg);
	}
	return isValid;
}
/* function fun_DisableExtraFields(){
	//alert(document.forms[0].is_Promotion_ForeGo.value);
	if(document.forms[0].is_Promotion_ForeGo.checked == true){
		document.forms[0].effectiveDate.disabled=true;
		document.forms[0].joinDate.disabled=true;
		document.forms[0].joinAnFn.disabled=true;

	}else{
		document.forms[0].effectiveDate.disabled=false;	
		document.forms[0].joinDate.disabled=false;
		document.forms[0].joinAnFn.disabled=false;
	}
	if(document.forms[0].method.value=="editEmpPromotion"){
		//alert(document.forms[0].is_Promotion_ForeGo.value);
		//document.forms[0].is_Promotion_ForeGo.disabled = true;
		rowID.style.display="none";
		//alert(document.forms[0].is_Promotion_ForeGo.value);
	} */


</script>
</head>


<script type="text/javascript" language="Javascript1.1"> 

<!-- Begin 

     var bCancel = false; 

    function validateEmpPromotionForm(form) {                                                                   
        if (bCancel) 
      return true; 
        else 
 var formValidationResult;
       formValidationResult = validateRequired(form); 
     return (formValidationResult == 1);
   } 

    function empPromotionForm_required () { 
     this.a0 = new Array("postingOrderNo", "Promotion Order Number is required.", new Function ("varName", " return this[varName];"));
     this.a1 = new Array("orderDate", "Order Date  is required.", new Function ("varName", " return this[varName];"));
     this.a2 = new Array("pp_DesignationMasterID", "Promoted To is required.", new Function ("varName", " return this[varName];"));
    } 


//End --> 
</script>


<form action="/UPJN/ManageEmpPromotionInfo" method="post">
     <input type="hidden" name="ppEmployeemasterid" value="${ppEmployeemasterid}">
	
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>
		<td valign="top">&nbsp;</td>
	</tr>
			<tr>
				<td valign="top" class="msg">
				${msg}		
					 
				</td>
			</tr>
			<tr>
				<td valign="top" class="error">	
				${error}				
					
			</td>
			</tr>

	<tr>
		<td valign="top">&nbsp;</td>
	</tr>
	<tr>
		<td valign="top">
			<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center" valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td valign="top" align="center">
									<table width="70%" border="0" cellspacing="1" cellpadding="1">
										<tr>
											<td valign="top" class="table_bg">
												<table width="100%" border="0" cellspacing="3" cellpadding="3">                      
													<tr>
														<td width="95%" align="left" valign="top" class="table_head">
															Add Promotion Detail
														</td>
														
													</tr>
												</table>
												<table width="100%" border="0" cellspacing="1" cellpadding="3">
													<tr>
													<td  colspan="3" valign="middle" align="right" class="error_normal" align="right">
														* Fields are required.
													</tr>
													
                                                <tr>
	                                             <td width="2%" valign="top" class="cell_bg">&nbsp;</td>
                                                 <td width="44%" align="left" valign="top" class="cell_bg">
		                                             Employee Code 
	                                           </td>
	                                              <td width="54%" align="left" valign="top" class="cell_bg">
		                                         <c:forEach items="${list}" var="a">
                                                  ${a.employeecode}</c:forEach> 		
	                                             </td>
                                               </tr>
                                               <tr>
	                                             <td width="2%" valign="top" class="cell_bg">&nbsp;</td>
	                                             <td width="44%" align="left" valign="top" class="cell_bg">
		                                            Employee Name 
	                                            </td>
	                                            <td align="left" valign="top" class="cell_bg">
		                                        <c:forEach items="${list}" var="a">
                                                ${a.employeename}</c:forEach> 	
	                                            </td>
                                               </tr>
                                               <tr>
	                                            <td valign="top" class="cell_bg">&nbsp;</td>
	                                           <td align="left" valign="top" class="cell_bg">
	 	                                          Employee Designation 
	                                          </td>
	                                              <td align="left" valign="top" class="cell_bg">
                                                  <c:forEach items="${list}" var="a">
                                                   ${a.designation}</c:forEach> 	</td>
                                                </tr>

													<tr>
														<td width="2%"  valign="top" class="cell_bg">&nbsp;</td>
														<td  align="left" valign="top" class="cell_bg">
															Promotion Order Number
														</td>
														<td  align="left" valign="middle" class="cell_bg" >
															<input type="text" name="postingorderno" maxlength="50" size="30"  class="txt_medium">
															<span class="star">*[Max 50 char.]</span>
														</td>
													</tr>
													
													
													
													<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

																 Order Date 
															(dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date" name="orderdate"
																size="11" maxlength="10" readonly="readonly" required><a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].orderdate,'dd/mm/yyyy', document.forms[0].orderdate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
														</tr>
													
																<!-- <tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

															 Order Date 
															(dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date" name="orderdate"
																size="11" maxlength="10"> <a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].orderdate,'dd/mm/yyyy', document.forms[0].orderdate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
														</tr>
														 -->
														
														<tr>
									<td class="cell_bg" valign="top">&nbsp;</td>
												<td class="bold" valign="top" align="center" width="43%">
													Promoted To
										</td>
										<td  align="left" valign="middle" class="cell_bg" >
										<select id="ppDesignationmasterid" name="ppDesignationmasterid"  class="cmb_medium" >
													 <option value="-1">[Select Designation]</option> 
													 <c:forEach var="d" items="${designationMap}">
                                                          <option value="${d.key}">${d.value}</option>
													   </c:forEach>
													 </select>
													 
													 
													   	</td>
                                   
                                              

													<tr>
														<td width="2%"  valign="top" class="cell_bg">&nbsp;</td>
														<td  align="left" valign="top" class="cell_bg">
															Promotion Forego ?
														</td>
														<td  align="left"  class="cell_small" >
															<input type="checkbox" name="isPromotionForego">
														</td>
													</tr> 
													
																			<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

																Effective From Date
															(dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date" name="effectivedate"
																size="11" maxlength="10" readonly="readonly" required><a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].effectivedate,'dd/mm/yyyy', document.forms[0].effectivedate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
														</tr>
													<!-- 
													<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

															Effective From Date
															(dd/mm/yyyy)	</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date" name="effectivedate"
																size="11" maxlength="10" > <a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].effectivedate,'dd/mm/yyyy', document.forms[0].effectivedate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
														</tr>
													
													<tr>
													 -->
													
																										<tr>
															<td valign="top" class="cell_bg">&nbsp;</td>
															<td align="left" valign="top" class="cell_bg">

															Date of Joining New Post
															(dd/mm/yyyy)</td>
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date" name="joindate"
																size="11" maxlength="10" readonly="readonly" required><a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].joindate,'dd/mm/yyyy', document.forms[0].joindate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
														</tr>
													<!-- <tr>
														<td width="2%"  valign="top" class="cell_bg">&nbsp;</td>
														<td  align="left" valign="top" class="cell_bg">
															Date of Joining New Post
															(dd/mm/yyyy)	
															
															
															<td align="left" valign="top" class="cell_bg"><input
																type="text" class="txt_date" name="joindate"
																size="11" maxlength="10" > <a
																href="javascript:;"
																onclick="displayCalendar(document.forms[0].joindate,'dd/mm/yyyy', document.forms[0].joindate);">
																	<img alt="" src="resources/images/calendar-icon.gif"
																	height="16" hspace="0" width="16">
															</a> <span class="star">*</span></td>
														
													</tr>
													 -->
													
													<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">
																Select Time</td>
															<td align="left" valign="middle" class="cell_bg"><select
																id="joining_time" name="joinanfn" class="cmb_medium">
																	<option selected="selected" disabled>
																		Select Time</option>
																	<option value="FN">FN</option>
																	<option value="AN">AN</option>
																	<%-- <c:forEach var="d" items="${Data1}">
																		<option value="${d.key}">${d.value}</option>
																	</c:forEach> --%>
															</select></td>

														</tr>
								
													<tr>
														<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
													</tr>
													<tr>
														<td colspan="5" align="center" valign="top" class="cell_bg"> 						  	
														
															
															
																<input type="submit" value="Submit" class="btn_medium">	
															
															
														
															&nbsp;								
															<input type="reset" value="Reset" class="btn_medium">
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
			<br>
			<table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center" valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td valign="top">
									<table width="100%" border="0" cellspacing="1" cellpadding="1">
										<tr>
											<td valign="top" class="table_bg">
												<table width="100%" border="0" cellpadding="3" cellspacing="1">                     
													<tr>
														<td valign="top" align="left" colspan="7" class="table_head">
															
															Last Promotion Detail
														</td>
													</tr>
					  								<tr>
														<td colspan="9" valign="top" class="" align="left">
													<table width="100%" align="center" class="cell_bg"
														cellpadding="3" cellspacing="3">


														<table width="100%" cellpadding="3" cellspacing="3">
															<tr>
																<td id="t"><img alt=""
																	src="resources/images/sort.gif">Promotion Order Number</td>
																<td id="t"><img alt=""
																	src="resources/images/sort.gif">Order Date</td>
																<td id="t"><img alt=""
																	src="resources/images/sort.gif">Effective From Date</td>
																<td id="t"><img alt=""
																	src="resources/images/sort.gif">Promoted To</td>
																<td id="t"><img alt=""
																	src="resources/images/sort.gif">Promotion Forego ?</td>
																
																<td id="t">Action</td>
															</tr>
															<c:forEach items="${LastPromotionDetail}" var="list">
																<tr>
																	
																	<td>${list.postingorderno}</td>
																	<td>${list.orderdate}</td>
																	<td>${list.effectivedate}</td>
																	<td>${list.designation}</td>
																	<td>${list.isPromotionForego}</td>
																	
																	<td>
																	<%-- <td><a
														href="/UPJN/populateResumeAfterDeuptation?ppDeputationdetailid=<c:out value="${list.ppDeputationdetailid}"/>"><u>Edit</u></a></td> --%>

																</tr>
															</c:forEach>

														</table>
													</table>
												</td>
											</tr>

											<tr>

											</tr>

										</table></td>
								</tr>
							</table></td>
					</tr>


					<tr>
						<td valign="top" class="msg"></td>
					</tr>

					<tr>
						<td><table width="95%" border="0" align="center"
								cellpadding="1" cellspacing="1">
								<tr>
							</table></td>
					</tr>
				</table>
				</td>

				<tr>
					<td height="30" valign="top">&nbsp;</td>
				</tr>

				</table>
				</td>
				</tr>
				</table>
				</form>

	
</body>
</html>