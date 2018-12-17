<%@page import="java.util.Iterator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.List,com.nic.upjn.spring.entity.OfficeSummaryReportEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script src="resources/js/validation.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/js/popcalendar.js"></script>
<script type="text/javascript"
	src="resources/js/New_Appointment_validation.js"></script>
<script type="text/javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<script src="<c:url value="/resources/js/upjn.js" />"></script>

</head>
<body bgcolor="#ffffff">

    <%
        String type = (String) request.getAttribute("type");
        String msg = (String) request.getAttribute("msg");

        List arrear = (List) request.getAttribute("arrear");
        String monthName = (String) request.getAttribute("monthName");
        String yearName = (String) request.getAttribute("yearName");
        List gross = (List) request.getAttribute("gross");
        List netpay = (List) request.getAttribute("netpay");
        List total_Ded = (List) request.getAttribute("total_Ded");
        List itax = (List) request.getAttribute("itax");
        List gpf = (List) request.getAttribute("gpf");
        List employee = (List) request.getAttribute("employee");
        List paidemp = (List) request.getAttribute("paidemp");
        List totalemp = (List) request.getAttribute("totalemp");
        List employer = (List) request.getAttribute("employer");

        java.util.Date date = new java.util.Date();
        java.text.DateFormat df = java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM, java.util.Locale.ENGLISH);
    %>
    <table border="0" cellpadding="1" cellspacing="3" width="100%">
        <tr>
            <td valign="top">&nbsp;</td>
        </tr>
        <tr>
            <td valign="top">
                <table width="100%" align="center" cellpadding="1" cellspacing="1" border="0">
                    <tr>
                        <td valign="top">
                            <table width="95%" align="center" cellpadding="1" cellspacing="3" border="0" class="table_bg">
                                <tr>
                                    <td valign="top" colspan="7">
                                        <table width="100%" align="center" class="cell_bg" cellpadding="1" cellspacing="3" border="0">
                                            <tr>
                                                <td align="center" bgcolor="#E2E2E2">
                                                   <!--  <font size="3" color="#003366"><b>[</b></font><a href="" onClick="window.print()" >Print PDF</a><font size="3" color="#003366"><b>]</b></font><font size="4" color="#003366"></font> -->
                                                   
                                                   <input type="button" value="Print this page" onClick="window.print()">
                                                   
                                                    &nbsp;<font size="4" color="#003366"><b>UP JAL NIGAM</b> </font> </td>
                                                <td align="center"  valign="middle" class="table_head" >
                                                </td>
                                            </tr>

                                            <tr>
                                                <td colspan="2" width="100%">
                                                    <table width="100%">
                                                        <tr>
                                                            <td align="left" class="bold" width="50%">
                                                                <%if (type.equals("1")) {%>
                                                                Office Wise Summary Report-SALARY FOR
                                                                <%} else if (type.equals("2")) {%>
                                                                Employee Class Wise Summary Report-SALARY FOR 
                                                                <%} else if (type.equals("3")) {%>
                                                                Designation Wise Summary Report-SALARY FOR 
                                                                <%}%>

                                                                <%out.println(" " + monthName + " " + yearName);%>
                                                            <td align="right" class="bold" width="100%">
                                                                Date :<%=df.format(date)%>	</td>
                                                        </tr>
                                                    </table>	</td>
                                            </tr>
                                            
                                         <%-- <c:forEach items="${isArrear}" var="a">
                                          <tr>
                                          <td><c:set value="${a.AMOUNT}" var="arrear"></c:set> </td>
                                          </tr>
                                         </c:forEach>  --%>  
                                         
                                         <c:set value="${isArrear}" var="arrear" />
                                            
                                        </table>
                                        <table width="100%" align="center" class="cell_bg" cellpadding="3" cellspacing="1" border="0">
                                            <tr>
                                                <td width="1%" rowspan="2" bgcolor="#BAB4BA" class="bold">S.No</td>
                                                <%if (type.equals("1")) {%>
                                                <td width="6%" rowspan="2"  bgcolor="#BAB4BA" align="left" class="bold">Office Name</td>  
                                                <%} else if (type.equals("2")) {%>
                                                <td width="6%" rowspan="2"  bgcolor="#BAB4BA" align="left" class="bold">Employee Class</td>  
                                                <%} else if (type.equals("3")) {%>
                                                <td width="6%" rowspan="2"  bgcolor="#BAB4BA" align="left" class="bold">Designation</td>
                                                <%}%>
                                           
                                                <c:if test="${arrear eq '1'}">                                                
                                                <td width="12%" rowspan="2" bgcolor="#BAB4BA" class="bold" >Pay Month</td>
                                                <td width="12%" rowspan="2" bgcolor="#BAB4BA" class="bold">Pay Year</td>
                                                </c:if>
                                                
                                          
                                                <td width="6%" rowspan="2" bgcolor="#BAB4BA" class="bold" align="right">Number of Employees</td>                                                
                                                <td width="6%" rowspan="2" bgcolor="#BAB4BA" class="bold" align="right">Gross Salary</td>
                                                <td width="6%" rowspan="2" bgcolor="#BAB4BA" class="bold" align="right">Deduction</td>
                                                <td width="6%" rowspan="2" bgcolor="#BAB4BA" class="bold" align="right">Net Payable</td>
                                                <td width="6%" rowspan="2" bgcolor="#BAB4BA" class="bold" align="right">Income tax</td>
                                                <td width="6%" rowspan="2" bgcolor="#BAB4BA" class="bold" align="right">GPF Cont'bn</td>
                                                <td width="2%" rowspan="2" bgcolor="#BAB4BA" class="bold" align="right">Status</td>
                                                <td width="5%" colspan="2" bgcolor="#BAB4BA" class="bold" align="center">NPS  Contribution</td>
                                            </tr>
                                            <tr>

                                                <td width="3%" bgcolor="#BAB4BA" class="bold" align="right">Employee</td>
                                                <td width="3%"  bgcolor="#BAB4BA" class="bold" align="right">Employer</td>
                                            </tr>

                                         
                                          <c:if test="${summaryList != null}"> 
                                           
                                                <%
                                                    int i = 0;
                                                %>
                                          
                                               <c:forEach items="${summaryList}" var="list">
                                                    <%
                                                        i++;
                                                    %>
                                                     <tr>
                                                        <td><%=i%></td>
                                                        <%if (type.equals("1")) {%>
                                                        <td align="left">
                                                            ${list.OFFICENAME}
                                                        </td>   
                                                        <%} else if (type.equals("2")) {%>
                                                        <td align="left">
                                                        ${list.EMPLOYMENTSUBTYPE}
                                                      
                                                        </td>  
                                                        <%} else if (type.equals("3")) {%>
                                                        <td align="left">
                                                         ${list.DESIGNATION}
                                                        </td>  
                                                        <%}%>


                                                     
                                                       <c:if test="${arrear eq '1'}">
                                                        <td>
                                                     
                                                        ${list.PAYMONTH}
                                                        </td>
                                                        <td>
                                                         ${list.PAYYEAR}
                                                        </td>
                                                        </c:if>
                                                      
                                                      
                                                        <td align="right">${list.EMPNO}</td>

                                                        <td align="right">${list.GROSS}</td>
                                                        <td align="right">${list.TOTAL_DED}</td>
                                                        <td align="right">${list.NET}</td>
                                                        <td align="right">${list.ITAX}</td>
                                                        <td align="right">${list.GPF}</td>
                                                        <td align="right">${list.STATUS}</td>
                                                        <td align="right">${list.EMPLOYEE}</td>
                                                        <td align="right">${list.EMPLOYER}</td>
                                                    </tr>
                                                </c:forEach>
                                             
                                            </c:if>
                                           
                                            <%
                                                long colempNo = 0;
                                                long coltotalEmployees = 0;
                                                long colgross = 0;
                                                long coltotal_Ded = 0;
                                                long colnet = 0;
                                                long colitax = 0;
                                                long colgpf = 0;
                                                long colemployee = 0;
                                                long colemployer = 0;
                                            %>
                                      
                                            <td width="5%" bgcolor="#BAB4BA" class="bold">Total</td>
                                            <td width="5%" bgcolor="#BAB4BA" class="bold"></td>

                                           
                                            <td width="6%" bgcolor="#BAB4BA" align="right"  class="bold">
                                             <c:forEach items="${paidemp}" var="a">${a.AMOUNT}</c:forEach>
                                            </td>

                                            <td width="10%" bgcolor="#BAB4BA" align="right" class="bold">
                                             <c:forEach items="${gross}" var="a">${a.AMOUNT}</c:forEach>
                                            </td>
                                            <td width="8%" bgcolor="#BAB4BA" align="right" class="bold">
                                             <c:forEach items="${total_Ded}" var="a">${a.AMOUNT}</c:forEach>
                                            </td>
                                            <td width="7%" bgcolor="#BAB4BA" align="right" class="bold">
                                             <c:forEach items="${netpay}" var="a">${a.AMOUNT}</c:forEach>
                                            </td>
                                            <td width="7%" bgcolor="#BAB4BA" align="right" class="bold">
                                             <c:forEach items="${itax}" var="a">${a.AMOUNT}</c:forEach>
                                            </td>
                                            <td width="7%" bgcolor="#BAB4BA"  align="right" class="bold">
                                             <c:forEach items="${gpf}" var="a">${a.AMOUNT}</c:forEach>
                                            </td>
                                            <td width="5%" bgcolor="#BAB4BA" align="right" class="bold"></td>
                                            <td width="5%" bgcolor="#BAB4BA"  align="right"class="bold">
                                             <c:forEach items="${employee}" var="a">${a.AMOUNT}</c:forEach>
                                            </td>
                                            <td width="5%" bgcolor="#BAB4BA"  align="right"class="bold">
                                             <c:forEach items="${employer}" var="a">${a.AMOUNT}</c:forEach>
                                            </td>
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
</body>
</html>

