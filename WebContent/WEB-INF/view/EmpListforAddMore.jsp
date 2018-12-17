<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>U.P JAL NIGAM-Employee List Add More</title>
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<link href="resources/css/upjnBeta.css" rel="stylesheet" type="text/css" />
<script src="resources/js/validation.js" type="text/javascript"></script>
<script src="resources/js/validation.js" type="text/javascript"></script>

<script type="text/javascript">

function closeWindow(){
	 checkBox = document.forms[0].ppEmployeemasterid;   
	employeeName = document.forms[0].employeeName;
	tempTextBox = document.forms[0].ppEmployeemasterid.value; 

	var checkedCount = 0;
	var idStr="";
	var idStr1="";	
	
	if(checkBox.length != null){
		
	for(var i=0; i<checkBox.length; i++){
		
              if(checkBox[i].type == "checkbox" && checkBox[i].checked == true){               

                  checkedCount++;
   					idStr += checkBox(i).value+"|";
                 }
		}
	}

	/* if (checkedCount == 0){		
		alert("Please select any employee");	
		return false;
	}  */

	document.getElementById("addMore").action = "/UPJN/EmplistforAddMore";
	document.getElementById("addMore").method = "post";
	document.getElementById("addMore").submit(); 	
	window.close();	
}

</script>
</head>
<body>
	<form method="POST" id="addMore">
			
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td>
					<table width="95%"  border="0" align="center" cellpadding="1" cellspacing="1">
						<tr>
							<td align="center" class="table_bg" valign="top">
								<table width="100%" border="0" cellspacing="3" cellpadding="3">
									<tr>
										<td colspan="9" valign="top" class="table_head" align="left">
											Employee List <input type="hidden" value="${sectionID}" name="sectionID"> 
										</td>
									</tr>
									<c:choose>
										<c:when test="${emptyList == true }">
											<tr>
												<td colspan="9" valign="top" class="cell_bg" align="center">
												
													No Records Found
												</td>
											</tr>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${emptyList != true }">
											<tr>
												<td>Employee Code</td>
												<td>Employee Name</td>
												<td>Employee Designation</td>
												<td>Select</td>
											</tr>
											<c:forEach var="list" items="${list}">
												<tr>
													<td><c:out value="${list.employeecode }"/></td>
													<td><c:out value="${list.employeeName }"/></td>
													<td><c:out value="${list.designation }"/></td>
													<td>
													<input type="checkbox" value="${list.ppEmployeemasterid}" name="ppEmployeemasterid" id="ppEmployeemasterid"/></td>
													<td><input type="hidden" value="${list.employeeName}" name="employeeName" id="employeeName"> </td>
												</tr>
											</c:forEach>
										</c:when>
									</c:choose>
								<tr>
									<td colspan="9" valign="top" class="cell_bg" align="center">
									
									<input type="submit" value="Submit" class="btn_medium" onclick="return closeWindow();"/>
										
									</td>
								</tr>
							</table></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="30" valign="top">&nbsp;</td>
			</tr>
		</table>
		</form>
</body>
</html>