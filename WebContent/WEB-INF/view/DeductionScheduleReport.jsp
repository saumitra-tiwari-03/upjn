<%@page import="java.util.Iterator,com.nic.upjn.spring.entity.ViewPayGetscheduleheadlist"%>
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

</head>
<body bgcolor="#ffffff">

    <table border="1" cellpadding="1" cellspacing="1" width="100%" bordercolor="lightgrey">
        <%

            String pdfFileName = (String) request.getAttribute("pdfFileName");
            java.util.Date date = new java.util.Date();
            int columnSize = 8;
            String registerName = (String) request.getAttribute("registerName");
            String scheduleName = (String) request.getAttribute("scheduleName");
            String monthName = (String) request.getAttribute("monthName");
            String yearName = (String) request.getAttribute("yearName");
            int headSize = 3;
                //java.text.DecimalFormat formatter=new java.text.DecimalFormat("##,##0.00");
        %>
     
         <c:if test="${visible eq '1'}">   
                
                <%
                    columnSize++;
                    headSize = 4;
                %>
                
          </c:if>      
            
            <c:if test="${scheduleHeadList != null}">
             <c:forEach items="${scheduleHeadList}" var="a">
            
                <%
                    columnSize++;
                    System.out.println("column size " + columnSize);
                %>
                </c:forEach>
                </c:if>
                
        <tr>
            <td colspan="<%out.println(columnSize);%>" align="center" bgcolor="#E2E2E2">
                <font size="4" color="#003366"><b>Uttar
						Pradesh Jal Nigam</b>, ${officeName}</font>
                &nbsp;<!-- <font size="3" color="#003366"><b>[</b></font><a onClick="window.print()" target="_blank">Download PDF</a><font size="3" color="#003366"><b>]</b></font> -->
                
                <input type="button" value="Print this page" onClick="window.print()">
            </td>
        </tr>
        <tr>
            <td colspan="<%out.println(columnSize);%>" align="center">
                <font size="2" color="#003366">
                <b>
                    Statement of ${scheduleName} For ${monthName}-${yearName}
                </b>
                </font>
            </td>
        </tr>
        <tr>
            <td colspan="<%out.println(columnSize);%>">
                <table cellspacing=0 cellpadding=0 width='100%'>
                    <tr>
                        <td colspan="<%out.println(columnSize - 1);%>" align="left">
                            <font size="2" color="#003366">Register No : ${registerName}</font>
                        </td>
                        <td></td>
                        <td align="right">
                            <font size="2" color="#003366">Run Date : <%=date%></font>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <%
            java.util.HashMap employeeNameMap = (java.util.HashMap) request.getAttribute("employeeNameMap");
            java.util.HashMap employeeDesignationMap = (java.util.HashMap) request.getAttribute("employeeDesignationMap");
            java.util.HashMap employeeRegisterMap = (java.util.HashMap) request.getAttribute("employeeRegisterMap");
            java.util.HashMap employeeBillNoMap = (java.util.HashMap) request.getAttribute("employeeBillNoMap");
            java.util.HashMap employeePANNoMap = (java.util.HashMap) request.getAttribute("employeePANNoMap");
            java.util.HashMap employeeGPFAcNoMap = (java.util.HashMap) request.getAttribute("employeeGPFAcNoMap");
            java.util.HashMap employeeValueMap = (java.util.HashMap) request.getAttribute("employeeValueMap");
            //java.util.HashMap installmentMap=(java.util.HashMap)request.getAttribute("installmentMap");
            java.util.Hashtable totalTable = new java.util.Hashtable();
                //Hashtable installmentMap=(Hashtable)request.getAttribute("installmentMap");
        %>
     
        <c:if test="${scheduleHeadList != null}">
            <tr>
                <td class="bold" bgcolor="#e2e2e2" width="50">Sl. No.</td>
                <td class="bold" bgcolor="#e2e2e2" width="100">Employee Code</td>
                <td class="bold" bgcolor="#e2e2e2">Employee Name</td>
                <td class="bold" bgcolor="#e2e2e2">Register No</td>
                <td class="bold" bgcolor="#e2e2e2">Pan No</td>
                <c:forEach items="${scheduleHeadList}" var="a">
                <td class="bold" bgcolor="#e2e2e2">${a.headname}</td>
                </c:forEach>
                <c:if test="${visible eq '1'}">                 
                      <td class="bold" bgcolor="#e2e2e2">GPF A/C</td>                  
               </c:if>
               
                 <%
                 List<ViewPayGetscheduleheadlist> headList =(List<ViewPayGetscheduleheadlist>) request.getAttribute("scheduleHeadList");
                 
                 for(ViewPayGetscheduleheadlist viewPayGetscheduleheadlist :headList)
                 {
                	 ViewPayGetscheduleheadlist dedDTO = (ViewPayGetscheduleheadlist) viewPayGetscheduleheadlist;
                	 System.out.println(dedDTO.getHeadid()+" "+dedDTO.getHeadtype());
                     totalTable.put(dedDTO.getHeadid() + "@" + dedDTO.getHeadtype(), "0");
                 }       
                    %>
                 <%--   <td class="bold" bgcolor="#e2e2e2" align="right"> 
                   <c:forEach items="${scheduleHeadList}" var="a">
                   
                   <c:set value="${a.headname}" var="headname"/>
                   <c:set value="${a.headtype}" var="headtype"/>
                 
                  <c:if test="${visible eq '1'}">
                               <c:if test="${headtype eq 'D'}">Deduction</c:if>
                               <c:if test="${headtype eq 'L'}">Recovery</c:if>
                       </c:if>
                 
                    </c:forEach>
                                       
                   </td> --%>
                
                <td class="bold" bgcolor="#e2e2e2" align=right>Total</td>
            </tr>
            </c:if>
     <%
					int i = 1;
				%>

                <%
                   List empList = (List)request.getAttribute("employeeList");
                
                String employeeCode="";
                Iterator itr1 = empList.iterator();
                
                while(itr1.hasNext())
                {                                        	
                	employeeCode =(String) itr1.next(); 
                	
                	System.out.println(employeeCode);
               
                
                %>
                
                <tr>
                   
                    <td align="left"><%=i%></td>
                   
                    <td>
                        <%=employeeCode%>
                    </td>
                   
                    <td>
                        <%=employeeNameMap.get(employeeCode)%>
                    </td>
                 
                    <td>
                        <%=employeeRegisterMap.get(employeeCode)%>
                    </td>
                   
                    <td>
                        <%=employeePANNoMap.get(employeeCode)%>
                    </td>
                   
                        
                        <c:if test="${visible eq '1'}">
                            <td>
                                <%
                                    String str = (String) employeeGPFAcNoMap.get(employeeCode);
                                    if (str == null) {
                                        str = "&nbsp";
                                    }
                                    out.println(str);
                                %>
                            </td>
                           </c:if> 
                    
                    <%
                        int total_All = 0;
                    %>
                
                   <c:forEach items="${scheduleHeadList}" var="headList">  <td align=right>
                        <%
                        
                        List<ViewPayGetscheduleheadlist>  headList =(List<ViewPayGetscheduleheadlist>) request.getAttribute("scheduleHeadList");
                        
                        for(ViewPayGetscheduleheadlist viewPayGetscheduleheadlist :headList)
                        {
                       	 ViewPayGetscheduleheadlist dto = (ViewPayGetscheduleheadlist) viewPayGetscheduleheadlist;

                       	String headId = dto.getHeadid()+"";
                        String headType = dto.getHeadtype();

                        %>
                        
                            <%
                                String temp = (String) employeeValueMap.get(employeeCode + "@" + headType + "@" + headId);
                                int tempAmount = (temp != null) ? Integer.parseInt(temp) : 0;
                                            
                                if (temp != null) {
                                    total_All += Integer.parseInt(temp);
                                }

                                if (temp == null) {
                                    temp = "&nbsp;";
                                }

                                totalTable.put(headId + "@" + headType, "" + (Integer.parseInt((String) totalTable.get(headId + "@" + headType)) + tempAmount));

                                out.println(((temp != null && !temp.equals("&nbsp;")) ? Integer.parseInt(temp) : temp));
                        }
                            %>
                        </td>
                        </c:forEach>
                    <td align=right><%out.println(total_All);%></td>
                </tr>
                <%
						
                i++;
                }
					%>
            
        <c:if test="${scheduleHeadList != null}">
            <tr>
                <td class="bold" bgcolor="#e2e2e2" colspan="<%=headSize%>">Grand Total</td>
                <%
                    int grandTotal = 0;
                %>
             
                <td class="bold" bgcolor="#e2e2e2"></td>
                <td class="bold" bgcolor="#e2e2e2"></td>              
                
                 <c:forEach items="${scheduleHeadList}" var="headList">
                    <%
                    List<ViewPayGetscheduleheadlist>  headList =(List<ViewPayGetscheduleheadlist>) request.getAttribute("scheduleHeadList");
                    String totalValue = "";
                    for(ViewPayGetscheduleheadlist viewPayGetscheduleheadlist :headList)
                    {
                   	 ViewPayGetscheduleheadlist dedDTO = (ViewPayGetscheduleheadlist) viewPayGetscheduleheadlist;                 
                 
                         totalValue = (String) totalTable.get(dedDTO.getHeadid() + "@" + dedDTO.getHeadtype());
                        grandTotal += Integer.parseInt(totalValue);
                    %> <%} %>
                    <td class="bold" bgcolor="#e2e2e2" align=right>
                        <%=Integer.parseInt(totalValue)%>
                    </td>
                   
                  </c:forEach>  

                <td class="bold" bgcolor="#e2e2e2" align=right><%=grandTotal%></td>
            </tr>
            </c:if>

    </table>

</body>
</html>