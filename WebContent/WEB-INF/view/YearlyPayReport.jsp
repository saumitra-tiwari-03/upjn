<%@page import="java.util.Iterator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page import="java.util.List"%>
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

<%@page
	import="java.util.Hashtable,com.nic.upjn.spring.entity.ViewHeadNameYearlyPay,com.nic.upjn.spring.entity.ViewLocCode,com.nic.upjn.spring.entity.ViewYearlyPayReport"%>

</head>

<%

    java.text.DecimalFormat formatter = new java.text.DecimalFormat("##,##0.00");
    Hashtable headTotalMap = new Hashtable();
    int columnCount = 0;
    //List headNameList=(java.util.List)request.getAttribute("headNameList");
    //columncount = headNameList.size();
    List locCodeList=(List)request.getAttribute("locCodeList");
    ViewLocCode dto1=new ViewLocCode();
    Iterator itr=locCodeList.iterator();
    
    List empList = (List) request.getAttribute("pp_billdetailList");
    Iterator itr2 = empList.iterator();
    //while(itr.hasNext())
   // {
       // dto1=(YearlyPayReportDTO)itr.next();
    //}
    String headNameListSize = (String) request.getAttribute("headNameListSize");
    columnCount = Integer.parseInt(headNameListSize);
    String startYear = (String) request.getAttribute("startYear");
    String endYear = (String) request.getAttribute("endYear");
    String employeeCode = (String) request.getAttribute("empcode");
    //String register = (String)request.getAttribute("register");
    String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

%>
<%    //System.out.println("@@@@@@@@@@@@@@@@@@@@"+request.getAttribute("employeeNameMap").getClass());
    Hashtable employeeNameMap = (Hashtable) request.getAttribute("employeeNameMap");
    Hashtable employeeValueMap = (Hashtable) request.getAttribute("employeeValueMap");
    Hashtable employeeDesignationMap = (Hashtable) request.getAttribute("employeeDesignationMap");
    Hashtable payCategoryMap = (Hashtable) request.getAttribute("payCategoryMap");
    Hashtable employeeGPFAcNoMap = (Hashtable) request.getAttribute("employeeGPFAcNoMap");
    Hashtable employeePANnoMap = (Hashtable) request.getAttribute("employeePannoMap");
    Hashtable bankAcNoMap = (Hashtable) request.getAttribute("bankAcNoMap");
    Hashtable paybillMap = (Hashtable) request.getAttribute("paybillMap");
    Hashtable payYearMap = (Hashtable) request.getAttribute("payYearMap");
    Hashtable payMonthMap = (Hashtable) request.getAttribute("payMonthMap");
%>

<body>

<div style="overflow-x:auto; width:1400px">

    <table border="1" cellpadding="1" cellspacing="1" width="100%" bordercolor="lightgrey">
        <tr>
            <td align="center" bgcolor="#E2E2E2" width="15%">
                <a href="#" onClick="history.back();">
                   Back
                </a>
            </td>
            <td colspan="<%out.println(columnCount - 1);%>" align="center" bgcolor="#E2E2E2">
                <font size="3" color="#003366"><b>Uttar
						Pradesh Jal Nigam</b></font>
                &nbsp;<font size="3" color="#003366"><b></b></font>
            </td>
        </tr>

        <tr>
            <td colspan="10" align="center" bgcolor="white">
                <font size="2" color="#003366"><b>Yearly Pay Report for ${startYear} -
						${endYear}</b></font>
            </td>
        </tr>
    </table>

    <table border="1" cellpadding="1" cellspacing="1" width="100%" bordercolor="lightgrey">
	
        <tr>
            <td colspan="2" valign="top" bgcolor="#E2E2E2" class="bold">Employee Code</td>
            <td colspan="3" valign="top" bgcolor="#E2E2E2" class="bold">Employee Name</td>
            <td colspan="3" valign="top" bgcolor="#E2E2E2" class="bold">Designation</td>
            <td colspan="2" valign="top" bgcolor="#E2E2E2" class="bold">GPFAcNo</td>
            <td colspan="2" valign="top" bgcolor="#E2E2E2" class="bold">Pay Category</td>
            <td colspan="2" valign="top" bgcolor="#E2E2E2" class="bold">Bank Acc No.</td>
        </tr>
        <tr>
            <td colspan="2" valign="top" bgcolor="#E2E2E2" class="bold"><%=employeeCode%></td>         
            <td colspan="3" valign="top" bgcolor="#E2E2E2" class="bold"><%=employeeNameMap.get(employeeCode)%></td>
            <td colspan="3" valign="top" bgcolor="#E2E2E2" class="bold"><%=employeeDesignationMap.get(employeeCode)%></td>
            <td colspan="2"  valign="top" bgcolor="#E2E2E2" class="bold"><%=employeeGPFAcNoMap.get(employeeCode)%></td>
            <td colspan="2"  valign="top" bgcolor="#E2E2E2" class="bold"><%=payCategoryMap.get(employeeCode)%></td>
            <td colspan="2"  valign="top" bgcolor="#E2E2E2" class="bold"><%=bankAcNoMap.get(employeeCode)%></td>
        </tr>
        <tr>
            <td colspan="14" height="1" bgcolor="black"></td>
        </tr>
        <tr>
            <td width="100px" valign="top" bgcolor="#E2E2E2" class="bold">&nbsp; </td>
			<td width="100px" valign="top" bgcolor="#E2E2E2" class="bold" align="center">Mar-${startYear}</td>
            <td width="100px" valign="top" bgcolor="#E2E2E2" class="bold" align="center">Apr-${startYear}</td>
            <td width="100px" valign="top" bgcolor="#E2E2E2" class="bold" align="center">May-${startYear}</td>
            <td width="100px" valign="top" bgcolor="#E2E2E2" class="bold" align="center">Jun-${startYear}</td>
            <td width="100px" valign="top" bgcolor="#E2E2E2" class="bold" align="center">Jul-${startYear}</td>
            <td width="100px" valign="top" bgcolor="#E2E2E2" class="bold" align="center">Aug-${startYear}</td>
            <td width="100px" valign="top" bgcolor="#E2E2E2" class="bold" align="center">Sep-${startYear}</td>
            <td width="100px" valign="top" bgcolor="#E2E2E2" class="bold" align="center">Oct-${startYear}</td>
            <td width="100px" valign="top" bgcolor="#E2E2E2" class="bold" align="center">Nov-${startYear}</td>
            <td width="100px" valign="top" bgcolor="#E2E2E2" class="bold" align="center">Dec-${startYear}</td>
            <td width="100px" valign="top" bgcolor="#E2E2E2" class="bold" align="center">Jan-${endYear}</td>
            <td width="100px" valign="top" bgcolor="#E2E2E2" class="bold" align="center">Feb-${endYear}</td>            
            <td width="100px" valign="top" bgcolor="#E2E2E2" class="bold" align="center">Total</td>
        </tr>
        <tr>
            <%int counter = 0;%>
            <td width="7.18%" >
                <table width="100%" >
                    <tr>
                        <td align="right" class="bold" bgcolor="#E2E2E2">Loc_Code</td>
                    </tr>
                    
                     <c:if test="${headNameList != null}">
                        <%-- <c:forEach items="${headNameList}" var="headList"> --%>
                            <%
                            List headList = (List) request.getAttribute("headNameList");
                            Iterator itr1 = headList.iterator();
							while (itr1.hasNext()) {
							ViewHeadNameYearlyPay dto=(ViewHeadNameYearlyPay)itr1.next();
							String headType=dto.getHEADTYPE();
							String headName=dto.getHEADNAME();
							headTotalMap.put(headType+"@"+headName, "0");
							counter++;
                                if (counter == 8) {
                                    counter = 1;	
                                }
                                if (!headName.equals("REG_EMLR") && !headName.equals("EMLR_ARR")) { %>
                            <tr>
                                <td align="right" class="bold" bgcolor="#E2E2E2"><%=headName%></td>
                            </tr>
                            <%}
							}
                            %>
                      
                     <%--    </c:forEach> --%>
                        <!--<td width="148">-->
                 
                    </c:if>
                    <%
                        for (; counter < 7; counter++) {
                    %>
                    <!--<td align="center" bgcolor="#E2E2E2">--</td> -->
                    <%
                        }
                    %>
                    <tr>
                        <td class="bold" bgcolor="#E2E2E2" align="right" height="50%">Gross</td>
                    </tr>
                    <tr>
                        <td class="bold" bgcolor="#E2E2E2" align="right" height="50%">Total Ded.</td>
                    </tr>
                    <tr>
                        <td class="bold" bgcolor="#E2E2E2" valign="top" align="right">Net Payable</td>
                    </tr>									
                </table>
            </td>
            <td valign="top" colspan="12">


                <table border="0" cellspacing="0" cellpadding="5">
                    <tr>
                    
                    <c:if test="${employeeList != null}">
                         <c:forEach items="${pp_billdetailList}" var="empList">
                        <%   while(itr2.hasNext())
                        {  %>
                                <%  dto1=(ViewLocCode)itr.next();%>							
                                <td valign="top" width="100%">&nbsp;<%=dto1.getLOC_CODE()%>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <%
                                    int i=0;
                                   
                                        String pp_billdetailid1 = (String) paybillMap.get(employeeCode);
                                        // out.println("#################################"+empList.size());
                                        String pp_billdetail = null ;
                                        System.out.println(employeeCode);
                                        
                                        
                                        
                                                                            	
                                        	 pp_billdetail = itr2.next()+"";

                                      
                                        String pp_billdetailid = (String) paybillMap.get(employeeCode);
                                        long rowGrossTotal = 0;
                                        long rowTotalDeduction = 0;
                                        long npsarr = 0;
                                        long npsreg = 0;
                                        
                                    %>

                                    <table border="0">
                                    
                                    <c:if test="${headNameList != null}">
                                     <%--   <c: forEach items="${headNameList}" var="headList">	 --%>			
                                                <%
                                                List headNameList = (List) request.getAttribute("headNameList");
                                              
        										
        										Iterator itr3 = headNameList.iterator();
        										
        										while (itr3.hasNext()) {
        											
        											ViewHeadNameYearlyPay dto= new ViewHeadNameYearlyPay();
        											 dto=(ViewHeadNameYearlyPay)itr3.next();
        											String headName=dto.getHEADNAME();
        											String headType=dto.getHEADTYPE();
													
                                                    String temp = (String) employeeValueMap.get(pp_billdetail + "@" + employeeCode + "@" + headType + "@" + headName);
                                                    
                                                  
                                                    
                                                    if (temp == null) {
                                                        temp = "0";
                                                    }
                                                    long tempHeadAmount = Long.parseLong(temp);
                                                    headTotalMap.put(headType + "@" + headName, "" + (Long.parseLong((String) headTotalMap.get(headType + "@" + headName)) + tempHeadAmount));
                                                    if (headType.equals("A")) {
                                                        rowGrossTotal += tempHeadAmount;
                                                    } else {
                                                        if (!headName.equals("REG_EMLR") && !headName.equals("EMLR_ARR")) {
                                                            rowTotalDeduction += tempHeadAmount;
                                                        }
                                                    }

                                                    if (headName.equals("EMLR_ARR")) {
                                                        npsarr = tempHeadAmount;
                                                    }
                                                    if (headName.equals("REG_EMLR")) {
                                                        npsreg = tempHeadAmount;
                                                    }

                                                    counter++;

                                                    if (counter == 8) {
                                                        counter = 1;
                                                %>
												<%-- <tr>

                                                    <td height="1" bgcolor="lightgrey"><%=i %></td>

                                                </tr> --%>
                                                <%}
                                                %>
                                                <% if (!headName.equals("REG_EMLR") && !headName.equals("EMLR_ARR")) {%>
                                                <tr>
                                                    <td width="14.5%" align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=tempHeadAmount%></td>
                                                </tr>
                                                <%}
        											
        										
                                               }
        										 
        										
                                        
                                               %>
                                            
                                            <%-- </c:forEach> --%>
                                        
                                        </c:if>
                                        <tr>
                                           <td valign="top" align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=rowGrossTotal%></td>
                                        </tr>
                                        <tr>
                                           <td valign="top" align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=rowTotalDeduction%></td>
                                        </tr>
                                        <tr>
                                            <td valign="top" align="right"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=(rowGrossTotal - rowTotalDeduction)%></b></td>
                                        </tr>
                                      
                                    </table>
                                     <% }%>
                                </td>	
                          
                        </c:forEach>	
                        </c:if>				
                    </tr>

                </table>

            </td>

            <td valign="top">
                <table width="100">
                    <tr><td>&nbsp;</td></tr>

                    <tr>
                        <%   List str1 = (List) request.getAttribute("b_pay");%>

                        <% if (str1 != null) {%>

                       <td align="right"><c:forEach items="${b_pay}" var="a">
                          ${a.AMOUNT}
                       </c:forEach></td>

                        <%}%>
                    </tr>

                    <tr>
                        <%   List str2 = (List) request.getAttribute("PERS_PAY");

                            int count = str2.size(); // In this line error coming
                        %>
                        <% if (count != 0) {%>

                       <td align="right"><c:forEach items="${PERS_PAY}" var="a">
                          ${a.AMOUNT}
                       </c:forEach></td>

                        <%}%>
                    </tr>
                    <tr>
                        <%   List str3 = (List) request.getAttribute("G_PAY");

                            int count1 = str3.size(); // In this line error coming
                        %>
                        <% if (count1 != 0) {%>

                        <td align="right"><c:forEach items="${G_PAY}" var="a">
                          ${a.AMOUNT}
                       </c:forEach></td>

                        <%}%>


                    </tr>
                    <tr>
                        <%   List str4 = (List) request.getAttribute("DA");

                            int count2 = str4.size(); // In this line error coming
                        %>
                        <% if (count2 != 0) {%>

                       <td align="right"><c:forEach items="${DA}" var="a">
                          ${a.AMOUNT}
                       </c:forEach></td>

                        <%}%>


                    </tr>
                    <tr>
                        <%   List str5 = (List) request.getAttribute("CCA");

                            int count3 = str5.size(); // In this line error coming
                        %>
                        <% if (count3 != 0) {%>

                       <td align="right"><c:forEach items="${CCA}" var="a">
                          ${a.AMOUNT}
                       </c:forEach></td>

                        <%}%>


                    </tr>
                    <tr>
                        <%   List str6 = (List) request.getAttribute("HRA");

                            int count4 = str6.size(); // In this line error coming
                        %>
                        <% if (count4 != 0) {%>

                        <td align="right"><c:forEach items="${HRA}" var="a">
                        ${a.AMOUNT}
                     </c:forEach></td>

                        <%}%>


                    </tr>
                    <tr>
                        <%   List str7 = (List) request.getAttribute("MEDALW");

                            int count5 = str7.size(); // In this line error coming
                        %>
                        <% if (count5 != 0) {%>

                       <td align="right"><c:forEach items="${MEDALW}" var="a">
                        ${a.AMOUNT}
                     </c:forEach></td>

                        <%}%>


                    </tr>
                    <tr>
                        <td height="1" bgcolor="lightgrey">
                    </tr>
                   
                    <tr>
                        <%   List str9 = (List) request.getAttribute("GPF");

                            int count7 = str9.size(); // In this line error coming
                        %>
                        <% if (count7 != 0) {%>

                       <td align="right"><c:forEach items="${GPF}" var="a">
                        ${a.AMOUNT}
                     </c:forEach></td>

                        <%}%>
                    </tr>
                    <tr>
                        <%   List str10 = (List) request.getAttribute("GIS");

                            int count8 = str10.size(); // In this line error coming
                        %>
                        <% if (count2 != 0) {%>

                      <td align="right"><c:forEach items="${GIS}" var="a">
                        ${a.AMOUNT}
                     </c:forEach></td>

                        <%}%>
                    </tr>
                    <tr>
                        <%   List str11 = (List) request.getAttribute("ITAX");

                            int count9 = str11.size(); // In this line error coming
                        %>
                        <% if (count9 != 0) {%>

                     <td align="right"><c:forEach items="${ITAX}" var="a">
                        ${a.AMOUNT}
                     </c:forEach></td>

                        <%}%>
                    </tr>
                    <tr>
                      <td align="right"><c:forEach items="${gross}" var="a">
                        ${a.AMOUNT}
                     </c:forEach></td>
                    </tr>
                    <tr>
                        <td align="right"><c:forEach items="${totalded}" var="a">
                        ${a.AMOUNT}
                     </c:forEach></td>

                    </tr>
                    <tr>
                     <td align="right"><b><c:forEach items="${NetPay}" var="a">
                        ${a.AMOUNT}
                     </c:forEach> </b> </td>

                    </tr>
                </table>
            </td>
        </tr>
    </table>
	</div>
	
    <input type="button" value="print" onClick="window.print()">
	
</body>
