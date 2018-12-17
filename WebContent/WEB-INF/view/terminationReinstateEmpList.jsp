	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<%@ page import="java.util.ArrayList" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
		<title>U.P JAL NIGAM-Termination Reinstate EmployeeList</title>
		<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">	
		
		
		<script type="text/javascript">
		$.ajax({
		    type: "POST",  
		    url: someUrl,
		    data: someData, 
		    success: function(data){  
		        windows.href.location = someNewLocation;
		    },
		    error: function(X) { 
		    }       
		});
</script>	
	</head>
	

	
	<body style="margin:0px 0px 0px 0px;">
	
	<div style="height: 100%; width: 100%;">

<div style="height:100px; width: 100%;border-bottom: gray solid 4px;">
<%@ include file="/WEB-INF/view/Header.jsp" %>
</div>

<div style="height:600px;width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px;">
<%@ include file="/WEB-INF/view/Menu.jsp" %>
</div>
	
	
			 
			 <div style="height: 100%; width: 79%;float: left;padding-top: 10px;">
		<form >
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td valign="top" class="msg">
					</td>
				</tr>
				<tr>
					<td align="left" valign="top" class="error">					
						
					</td>
				</tr>
				<tr>		
					<td><table width="95%"  border="0" align="center" cellpadding="1" cellspacing="1">
						<tr>
							<td align="center" class="table_bg" valign="top"><table width="100%" border="0" cellspacing="3" cellpadding="3">
								<tr>
									<td colspan="9" valign="top" class="table_head" align="left">
										 Re-instate Suspension - List of Employees	
									</td>
							    </tr>								
								<tr>
									<td colspan="9" valign="top" class="" align="left">
										<table width="100%" align="center" class="cell_bg" cellpadding="3" cellspacing="3">
											
											
                    			<table width="100%" cellpadding="3" cellspacing="3">
							<tr> 
      							<td id="t"><img alt="" src="resources/images/sort.gif" >Employee Code</td>
								<td id="t"><img alt="" src="resources/images/sort.gif" >Employee Name</td>
								<td id="t"><img alt="" src="resources/images/sort.gif" >Employee Designation</td>
								<td id="t"><img alt="" src="resources/images/sort.gif" >Employment Type</td>
								<td id="t"><img alt="" src="resources/images/sort.gif" >Employment Category</td>
					            <td id="t"><img alt="" src="resources/images/sort.gif" >Current Posting</td>								
																
								<td id="t">Action</td>																		
					    	</tr>
					    <c:forEach items="${list}" var="list">
                                    <tr>                                      
                                        <input type="hidden" id="ppSuspensiondetailid" value="${list.ppSuspensiondetailid}" name="ppEmployeemasterid" />   
                                                 <td>${list.employeecode}</td>
                                                 <td>${list.employeename}</td>
                                                 <td>${list.designation}</td>
                                                 <td>${list.employmenttype}</td>
                                                 <td>${list.employmentsubtype}</td>
                                                 
                                                 
       <!--   <td><a href="/UPJN/populateReinstateSuspDetails">Re-Instate</a></td> --> 
       
       <td><a href="/UPJN/populateReinstateSuspDetails?ppSuspensiondetailid=<c:out value="${list.ppSuspensiondetailid}"/>"><u>Re-instate</u></a></td>


                                       </tr></c:forEach>				
	    	    	
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
					<td valign="top" class="msg">
					</td>
				</tr>
		</table>
		</form>
	</body>
</html>l>