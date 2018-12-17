<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>U.P JAL NIGAM-add new office</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet" href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script language="javascript" src="resources/js/validation.js"></script>
<script language="javascript" src="resources/js/popcalendar.js"></script>
<script language="javascript" src="resources/js/NEW_NEW.js"></script>
<script language="javascript" src="resources/js/upjn.js"></script>



<script type="text/javascript" src="resources/js/dhtmlgoodies_calendar.js"></script>

<script type="text/javascript">
    $(document).ready(sortDropDownListByText);
</script>
<script>
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
  </script>

<%-- <% request.getAttribute("Data"); %>
<% request.getAttribute("Data1"); %> --%>
<script type="text/javascript">
function validate() {
	
	var a = document.getElementById("hm").value;
	var b = document.getElementById("ParentOfficeId").value;
	var c = document.getElementById("placedistrict").value;
	var d = document.getElementById("placeName").value;
	
	if(a == -1 || b == -1 || c == -1 || d == -1 ){
		alert("required values cannot be null");
		return false;
	}

}
</script>




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
<form  action="/UPJN/saveNewOfficeRecord" id="myform" onsubmit="return validate()">

	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>  
			<td valign="top" class="msg">
				 
			</td>
		</tr>		
		<tr>  
			<td valign="top" class="error">
						<c:forEach items="${error}" var="item">
                         ${item}<br>
                        </c:forEach>
			</td>
		</tr>		
		<tr>
			<td valign="top"><table width="98%"  border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center" valign="top"><table width="80%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td valign="top"><table width="100%" border="0" cellspacing="1" cellpadding="1">
								<tr>
									<td valign="top" class="table_bg"><table width="100%" border="0" cellspacing="3" cellpadding="1">
										<tr>
											<td colspan="5" align="left" valign="top" class="table_head">
												Office Master - Add New Office
											</td>
										</tr>
										<tr>
											<td  colspan="2" valign="top" class="cell_bg">&nbsp;</td>
											<td  colspan="1" valign="middle" class="error_normal" align="right">
												* Fields are required.
											</td>
										</tr>
										<tr>
											<td colspan="5" valign="top" class="table_bg"></td>
										</tr>
											<input type="hidden" name="rm_OfficeID" value="" />
										<tr>
											<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
											<td width="43%" align="left" valign="top" class="cell_bg">
												Office Name
											</td>
											<td align="left" valign="top" class="cell_bg">
												<input type="text" name="officename" maxlength="100" size="30"  class="txt_medium" required>
												<span class="star"> *</span> 
											</td>
										</tr>
										<tr>
												<td class="cell_bg" valign="top">&nbsp;</td>
												<td class="bold" valign="top" align="left" width="43%">
											             Office Level
												</td> 
												<td class="cell_bg" valign="top" align="left">	
													
													<select id="hm3" name="masOfficelevelid" class="cmb_medium" required>
													   <option value="-1">[Select Level]</option>
													   <c:forEach var="d" items="${DataOffice}">
                                                          <option value="${d.key}">${d.value}</option>
													   </c:forEach>
													</select>
													
													<span class="star"> *</span>								
												</td>
											</tr>
											<tr>
												<td class="cell_bg" valign="top">&nbsp;</td>
												<td class="bold" valign="top" align="left" width="43%">
											           	Parent Office
												</td> 
												<td class="cell_bg" valign="top" align="left">	
												
											
											<select id="ParentOfficeId" name="PARENTOFFICEID" class="cmb_medium">
													   <option value="-1"> [Select Parent Office]</option>
													   <c:forEach var="d" items="${Data}">
                                                          <option value="${d.key}">${d.value}</option>
													   </c:forEach>
													</select>
                                            
                                             
                                         <span class="star"> *</span>
                                            </td>
                                            </tr>
										
										<tr>
											<td width="3%" height="20" valign="top" class="cell_bg">&nbsp;</td>
											<td height="20" align="left" valign="top" class="cell_bg">
												Address
											</td>
											<td height="25" align="left" valign="middle" class="cell_bg">
												<textarea name="officeaddress" cols="30" rows="5" required class="txtarea_small"></textarea>
												<span class="star"> *</span> 
											</td>
										</tr>
										<tr>
											<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
											<td width="43%" align="left" valign="top" class="cell_bg">
												Phone No. 1
											</td>
											<td align="left" valign="top" class="cell_bg">
												<input type="text" name="phno1" maxlength="100" size="30"  class="txt_medium">
											</td>
										</tr>
										<tr>
											<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
											<td width="43%" align="left" valign="top" class="cell_bg">
												Phone No. 2
											</td>
											<td align="left" valign="top" class="cell_bg">
												<input type="text" name="phno2" maxlength="100" size="30"  class="txt_medium">
											</td>
										</tr>
										<tr>
											<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
											<td width="43%" align="left" valign="top" class="cell_bg">
												Fax
											</td>
											<td align="left" valign="top" class="cell_bg">
												<input type="text" name="fax" maxlength="100" size="30"  class="txt_medium">
											</td>
										</tr>
										<tr>
											<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
											<td width="43%" align="left" valign="top" class="cell_bg">
												Location Code
											</td>
											<td align="left" valign="top" class="cell_bg">
												<input type="text" name="locCode" maxlength="10"  required  size="30"  class="txt_medium">
											<span class="star"> *[Max length : 10 digits]</span>
											</td>
											
											
										</tr>
										 <tr>
									<td class="cell_bg" valign="top">&nbsp;</td>
												<td class="bold" valign="top" align="left" width="43%">
													District
										</td>
										<td  align="left" valign="middle" class="cell_bg">
										<select required id="placedistrict" name="masDistrictid"  class="cmb_medium" >
													 <option value="-1">[Select District]</option> 
													 <c:forEach var="d" items="${Data1}">
                                                          <option value="${d.key}">${d.value}</option>
													   </c:forEach>
													 </select>
													 
													  <span class="star"> *</span>
													   	</td>

									</tr>
									
									
											<tr>
												<td class="cell_bg" valign="top">&nbsp;</td>
												<td class="bold" valign="top" align="left" width="43%">
													 Head Quarter
												</td>
												<td class="cell_bg" valign="top" align="left">
												<select required id="placeName" name="ppPlacemasterid" class="cmb_medium">
													 <option value="-1">[Select Head Quarter]</option> 
													<c:forEach var="d" items="${place}">
                                                          <option value="${d.key}">${d.value}</option>
													   </c:forEach>
													 </select>
													 <span class="star"> *</span>
												</td>
											</tr> 
										
										<tr>
											<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
										</tr>
										<tr>
											<td colspan="5" align="center" valign="top" class="cell_bg">
												<input type="submit" value="Submit" class="btn_small" >&nbsp;&nbsp;
												<input type="reset" value="Reset" class="btn_small">
											</td>
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

</div>
</div>
</body>

</html>