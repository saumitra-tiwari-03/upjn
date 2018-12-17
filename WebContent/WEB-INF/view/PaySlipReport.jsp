<%@page
	import="com.nic.upjn.spring.dto.PaySlipReportDTO , java.util.List , com.nic.upjn.spring.entity.PaySlipEntity , com.nic.upjn.spring.entity.PaySlipHeadEntity"%>
<%@page import="com.nic.upjn.miscellaneous.CalenderUtils"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<style type='text/css'>
@media print {
	.pagestart {
		page-break-before: always;
	}
}
</style>
</head>
<body bgcolor="#ffffff" topmargin="0" leftmargin="0" rightmargin="0"
	bottommargin="0">

	<table width="100%" align="center" cellpadding="1" cellspacing="1">
		<tr>
			<td align="center">
				<%-- [<a href="<%=request.getAttribute("pdfFileName")%>" target="_blank"  onClick="window.print()">Download PDF</a>] --%>
				<input type="button" value="Print this page"
				onClick="window.print()"> <a href="#"
				onClick="history.back();"> Back </a>&nbsp;&nbsp;&nbsp; <%	java.util.Date date = new java.util.Date(); %>
				<div align="center">
					<b>Run Date: </b>
					<%=date%></div>
			</td>

		</tr>
		<%
        String headPrinted="N";
        String prevEmployee="";
		int count = 0;
    %>

		<c:if test="${reportList != null}">
			<c:forEach items="${reportList}" var="a">
				<tr>
					<td width="100%">
						<table cellpadding='1' cellspacing='1' width='100%' border='1'
							bordercolor="1">
							<%
                        List reportList = (List) request.getAttribute("reportList");
                        
                        Iterator itr = reportList.iterator();
						while (itr.hasNext()) {
							PaySlipEntity dto=(PaySlipEntity)itr.next();
                        String employeeCode=dto.getEmployeeCode();
						
                         if(!employeeCode.equals(prevEmployee)){
                          prevEmployee=employeeCode;
                          headPrinted="N";
                         }

                            if(headPrinted.equals("N")){
                                headPrinted="Y";
                            %>
							<tr>
								<td colspan='2' class='bold' align=center bgcolor='#E2E2E2'>
									Uttar Pradesh Jal Nigam - Pay Slip Report</td>
							</tr>

							<tr>
								<td colspan='2'>
									<table cellpadding='1' cellspacing='1' width='100%'>
										<tr>
											<td width='25%' class='bold'>Employee Code</td>
											<td width='1%' class='bold'>:</td>
											<td width='24%'>
												<%--  <%= employeeCode %> --%> ${a.employeeCode}
											</td>
											<td width='25%' class='bold'>Pay Category</td>
											<td width='1%' class='bold'>:</td>
											<td width='24%'>
												<%--   <%= payCategory %> --%> ${a.payCategory}
											</td>
										</tr>
										<tr>
											<td colspan='6' height='1' bgcolor='lightgrey'>
										</tr>
										<tr>
											<td class='bold'>Employee Name</td>
											<td class='bold'>:</td>
											<td>
												<%-- <%=empName %> --%> ${a.empName}
											</td>
											<td class='bold'>Pay Month</td>
											<td class='bold'>:</td>
											<td><%=CalenderUtils.getMonth(dto.getPayMonth())%></td>
										</tr>
										<tr>
											<td colspan='6' height='1' bgcolor='lightgrey'>
										</tr>
										<tr>
											<td class='bold'>Designation</td>
											<td class='bold'>:</td>
											<td>
												<%-- <%=designation %> --%> ${a.designation}
											</td>
											<td class='bold'>Pay Year</td>
											<td class='bold'>:</td>
											<td>
												<%-- <%=year %> --%> ${a.payYear}
											</td>
										</tr>
										<tr>
											<td colspan='6' height='1' bgcolor='lightgrey'>
										</tr>
										<tr>
											<td class='bold'>Payment Mode</td>
											<td class='bold'>:</td>
											<td>
												<%--  <%=paymentMode %> --%> ${a.paymentMode}
											</td>
											<td class='bold'>No of Days</td>
											<td class='bold'>:</td>
											<td>${a.noOfDays} <%-- <%=noOfDays %>  --%>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td class='bold' align=center bgcolor='#E2E2E2'>Allowances
								</td>
								<td class='bold' align=center bgcolor='#E2E2E2'>Deductions
								</td>
							</tr>
							<tr>
								<td width='50%' valign=top>
									<table width='100%' cellpadding='0' cellspacing='1'>
										<c:forEach items="${reportList}" var="a">
											<%--  <%
                                       List reportList1 = (List) request.getAttribute("reportList");
                                   
                                   Iterator itr1 = reportList1.iterator();
           						while (itr1.hasNext()) {
           							PaySlipEntity dto1=(PaySlipEntity)itr1.next();                                
                                       String empCode=dto1.getEmployeeCode();
                                       if(empCode.equals(employeeCode)){
                                    %>  --%>



											<c:if test="${a.headType eq 'A'}">
												<tr>
													<td width='30%'>
														<%--  <%=headName %> --%> ${a.headName}
													</td>
													<td align=right>${a.amount} <%-- <%=amount %> --%>
													</td>
												</tr>
												<tr>
													<td height='1' colspan='2' bgcolor='lightgrey'></td>
												</tr>
											</c:if>
											<%--    <%
                                            }
           						 } 
                                        %> --%>
										</c:forEach>
									</table>
								</td>
								<td width='50%' valign=top>
									<table width='100%' cellpadding='0' cellspacing='1'>
										<c:forEach items="${reportList}" var="a">
											<%-- <%
                                       List reportList2 = (List) request.getAttribute("reportList");
                                   
                                   Iterator itr2 = reportList2.iterator();
              						while (itr2.hasNext()) {
              							PaySlipEntity dto1=(PaySlipEntity)itr2.next();
                                   
                                  /*  PaySlipReportDTO dto1=(PaySlipReportDTO)reportList2; */
                                       String empCode=dto1.getEmployeeCode();
                                       if(empCode.equals(employeeCode)){
                                    %> 
                                     --%>

											<c:if test="${a.headType eq 'D'}">
												<tr>
													<td width='30%'>
														<%--  <%=headName %> --%> ${a.headName}
													</td>
													<td align=right>
														<%--  <%=amount %> --%> ${a.amount}
													</td>
												</tr>
												<tr>
													<td height='1' colspan='2' bgcolor='lightgrey'></td>
												</tr>
											</c:if>
											<%--    <%
                                            }
              						}
                                        %> --%>
										</c:forEach>
									</table>
								</td>
							</tr>

							<%
                                java.util.HashMap tempMap=null;
                            %>
							<tr>
								<%
									if(request.getAttribute("allowanceList")!=null)
										tempMap = (java.util.HashMap)request.getAttribute("allowanceList");
									%>

								<td>
									<table width='100%' cellpadding='0' cellspacing='1'>
										<tr>
											<td class='bold'>Total</td>
											<td align=right><%=tempMap.get(employeeCode)%></td>
										</tr>
									</table>
								</td>
								<%
									if(request.getAttribute("deductionList")!=null)
										tempMap = (java.util.HashMap)request.getAttribute("deductionList");
									%>

								<td>
									<table width='100%' cellpadding='0' cellspacing='1'>
										<tr>
											<td class='bold'>Total Ded.</td>
											<td align=right><%=tempMap.get(employeeCode)%></td>
									</table>
								</td>
							</tr>
							<tr>


								<%
									if(request.getAttribute("netPayableList")!=null)
										tempMap = (java.util.HashMap)request.getAttribute("netPayableList");
									%>

								<td colspan='2'>
									<table width='100%' cellpadding='0' cellspacing='1'
										bgcolor='#E2E2E2'>
										<tr>
											<td class='bold'>Net Payable</td>
											<td align=right class='bold'><%=tempMap.get(employeeCode)%>
											</td>
									</table>
								</td>

							</tr>
							<%
                            }
						}
                        %>
						</table>
					</td>
				</tr>

			</c:forEach>
		</c:if>

	</table>

</body>
</html>