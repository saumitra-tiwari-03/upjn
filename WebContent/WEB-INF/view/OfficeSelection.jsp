<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>U.P JAL NIGAM-Section Master</title>
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

<%-- <% request.getAttribute("Data"); %>
<% request.getAttribute("Data1"); %> --%>


<title>Insert title here</title>
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<script src="<c:url value="/resources/js/upjn.js" />"></script>
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

<%-- 

<script type="text/javascript">
<% String str = (String)request.getAttribute("str");
      if(str==null){  %>
    	  function callAction(){
    		  document.getElementById("helloworld").action="/UPJN/OfficeSelectionController";
    		  document.getElementById("helloworld").Method="GET";
    		  document.getElementById("helloworld").submit();
    	  }
     <% }
      %>
</script> --%>

</head>
<body style="margin: 0px 0px 0px 0px;">

<div style="height: 100%; width: 100%;">

<div style="height:100px; width: 100%;border-bottom: gray solid 4px;">
<%@ include file="/WEB-INF/view/Header.jsp" %>
</div>
<div style="height:700px;width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px;">
<%@ include file="/WEB-INF/view/Menu.jsp" %>
</div>
				 
			 <div  id="dialog-form" title="Select Office" style="height: 100%; width: 79%;float: left;padding-top: 10px;">
<!-- <div  style="height: 100%; width: 70%;float: left;padding-top: 10px; margin-left: 180px; margin-top: 50px;  "> -->

<form id="helloworld" action="/UPJN/OfficeSelection" method="get">

			<table style="margin-top: 80px" border="0" cellpadding="0" cellspacing="0" width="70%" align="center">
				<tr>
					<td valign="top" class="msg">
					
					</td>
					
				<tr>
					<td align="left" valign="top" class="error">					
						
					</td>
				</tr>
										
			<tr>		
					<td><table width="95%"  border="0" align="center" cellpadding="1" cellspacing="4">
						<tr>
							<td align="center" class="table_bg" valign="top"><table width="100%" border="0" cellspacing="3" cellpadding="3">
								<tr>
									<td colspan="9" valign="top" class="table_head" align="left">
										 Login on behalf of different Office
										
									</td>
									
							    </tr>								
								<tr>
									<td colspan="9" valign="top" class="table_head" align="left">
										<table width="100%" border="0"  align="center" class="cell_bg" cellpadding="3" cellspacing="3">
											<tr>
												<td class="cell_bg" valign="top">&nbsp;</td>
												<td class="bold" valign="top" align="center" width="43%">
											             Office Level
												</td> 
												<td class="cell_bg" valign="top" align="left">	
													
													<select id="hm" name="masOfficelevelid" class="cmb_medium">
													   <option>[Select Level]</option>
													   <c:forEach var="d" items="${Data}">
                                                          <option value="${d.key}">${d.value}</option>
													   </c:forEach>
													</select>
													
																								
												</td>
											</tr>

                               <tr>
									<td class="cell_bg" valign="top">&nbsp;</td>
												<td class="bold" valign="top" align="center" width="43%">
													District
										</td>
										<td  align="left" valign="middle" class="cell_bg" >
										<select id="district" name="masDistrictid"  class="cmb_medium" >
													 <option value="-1">[Select District]</option> 
													 <c:forEach var="d" items="${Data1}">
                                                          <option value="${d.key}">${d.value}</option>
													   </c:forEach>
													 </select>
													 
													 
													   	</td>

									</tr>
											<tr>
												<td class="cell_bg" valign="top">&nbsp;</td>
												<td class="bold" valign="top" align="center" width="43%">
													 Office Name
												</td>
												<td class="cell_bg" valign="top" id="officename" align="left">
												<select id= hmap name="rmOfficeid" class="cmb_medium">
													 <option value="-1">[Select Office Name]</option> 
													<c:forEach var="d" items="${officename}">
                                                          <option value="${d.key}">${d.value}</option>
                                                          <!-- alert(d.key) -->
													   </c:forEach>
													 </select>
													
												</td>
											</tr>
						    
						    <tr>
								 <td colspan="2" align="right">
									 <input type="submit" value="Submit" Class="btn_medium" />	</td>
									  <td colspan="2">
									 <input type="reset" value="Reset" Class="btn_medium" />	</td>						
							   </tr>
						    															
                                    </table>
                               
                      </table>
                  </td>
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