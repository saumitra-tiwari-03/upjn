<%@page import="com.nic.upjn.spring.entity.ViewHeadName"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM-Monthly Pay Report</title>
<script type="text/javascript">
	
</script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />

<%@page
	import="com.nic.upjn.spring.dto.MonthlyPayReportDTO,com.nic.upjn.spring.entity.ViewHeadName,java.util.concurrent.ConcurrentHashMap, java.util.List"%>
<%
	/*@ page contentType="application/vnd.ms-excel" */
%>
<%
	//@ page contentType="application/pdf"
%>

</head>



<body bgcolor="#ffffff">

			<%
				String pdfFileName = (String) request.getAttribute("pdfFileName");
				java.text.DecimalFormat formatter = new java.text.DecimalFormat("##,##0.00");
				ConcurrentHashMap headTotalMap = new ConcurrentHashMap();
				List monthlyPayList = (List) request.getAttribute("monthlyPayList");
				List employeeList = (List) request.getAttribute("employeeList");
				int columnCount = ((java.util.List) request.getAttribute("headNameList")).size();
				String monthName = (String) request.getAttribute("monthName");
				String yearName = (String) request.getAttribute("yearName");
				String register = (String) request.getAttribute("register");
				String paybillno = (String) request.getAttribute("paybillno");
				String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
						"October", "November", "December" };
			%>
			<%
				ConcurrentHashMap employeeNameMap = (ConcurrentHashMap) request.getAttribute("employeeNameMap");
				ConcurrentHashMap employeeValueMap = (ConcurrentHashMap) request.getAttribute("employeeValueMap");
				ConcurrentHashMap installmentMap = (ConcurrentHashMap) request.getAttribute("installmentMap");
				ConcurrentHashMap employeeDesignationMap = (ConcurrentHashMap) request
						.getAttribute("employeeDesignationMap");
				ConcurrentHashMap payCategoryMap = (ConcurrentHashMap) request.getAttribute("payCategoryMap");
				ConcurrentHashMap employeeGPFAcNoMap = (ConcurrentHashMap) request.getAttribute("employeeGPFAcNoMap");
				ConcurrentHashMap employeePANnoMap = (ConcurrentHashMap) request.getAttribute("employeePannoMap");
				ConcurrentHashMap bankAcNoMap = (ConcurrentHashMap) request.getAttribute("bankAcNoMap");
				ConcurrentHashMap pannoMap = (ConcurrentHashMap) request.getAttribute("pannoMap");
			%>

			<table border="1" cellpadding="1" cellspacing="1" width="100%"
				bordercolor="lightgrey">
				<tr>
					<td align="center" bgcolor="#E2E2E2"><a href="#"
						onClick="history.back();"> Back </a></td>
					<td colspan="<%out.println(columnCount - 1);%>" align="center"
						bgcolor="#E2E2E2"><font size="3" color="#003366"><b>Uttar
								Pradesh Jal Nigam</b></font> &nbsp; <input type="button"
						value="Print this page" onClick="window.print()"> <%-- 	<font size="3" color="#003366"><b>[</b></font><a
				href="<%=pdfFileName%>" target="_blank">Download PDF</a><font
				size="3" color="#003366"><b>]</b></font></td> --%>
				</tr>
				<tr>
					<td colspan="10" align="center" bgcolor="white"><font size="2"
						color="#003366"><b>Monthly Pay Report ${registername}</b></font> <b>
							Bill No </b> <c:forEach items="${billdetail}" var="a">
															${a.billno}
															</c:forEach></td>

				</tr>

			</table>

			<table border="1" cellpadding="1" cellspacing="1" width="100%"
				bordercolor="lightgrey">
				<tr>
					<td class="bold" bgcolor="#E2E2E2" valign="top">S.No</td>
					<td class="bold" bgcolor="#E2E2E2" valign="top">
						<table border="1" cellpadding="1" cellspacing="1" width="100%"
							bordercolor="lightgrey">
							<tr>
								<td class="bold" bgcolor="#E2E2E2" valign="top">Employee
									Code</td>
							</tr>
							<tr>
								<td class="bold" bgcolor="#E2E2E2" valign="top">Employee
									Name</td>
							</tr>
							<tr>
								<td class="bold" bgcolor="#E2E2E2" valign="top">Designation</td>
							</tr>

							<tr>
								<td class="bold" bgcolor="#E2E2E2" valign="top">Pay
									Category</td>

							</tr>

						</table>
					</td>

					<td class="bold" bgcolor="#E2E2E2" valign="top">
						<table border="1" cellpadding="1" cellspacing="1" width="100%"
							bordercolor="lightgrey">

							<tr></tr>
							<tr>
								<td class="bold" bgcolor="#E2E2E2" valign="top">Employee
									Bank A/c No.
							</tr>
							<tr>
								<td class="bold" bgcolor="#E2E2E2" valign="top">GPF AC /
									PRAN</td>
							</tr>
							<tr>
								<td class="bold" bgcolor="#E2E2E2" valign="top">PAN.
							</tr>
						</table>

					</td>
					<!--  -->
					<td class="bold" valign="top">
						<%
							int counter = 0;
						%>
						<table cellspacing="1" cellpadding="1" width="100%" border="0"
							height="100%">

							<c:if test="${headNameList != null}">
								<tr>
									<%
										List headNameList = (List) request.getAttribute("headNameList12");

											Iterator itr = headNameList.iterator();
											while (itr.hasNext()) {
												MonthlyPayReportDTO monthlyPayReportDTO = (MonthlyPayReportDTO) itr.next();

												String headType = monthlyPayReportDTO.getHeadType();
												String headName = monthlyPayReportDTO.getHeadName();

												headTotalMap.put(headType + "@" + headName, "0");

												counter++;
												if (counter == 8) {
													counter = 1;
									%>
								</tr>
								<tr>
									<td colspan="7" height="1" bgcolor="lightgrey">
								</tr>
								<tr>
									<%
										}
									%>
									<%
										if (!headName.equals("REG_EMLR") && !headName.equals("EMLR_ARR")) {
									%>
									<td width="14.5%" align="right" class="bold" bgcolor="#E2E2E2">
										<%=headName%>
									</td>
									<%
										}

											}
									%>
								
							</c:if>
							<%
								for (; counter < 7; counter++) {
							%>
							<td align="center" bgcolor="#E2E2E2">--</td>
							<%
								}
							%>
							</tr>

						</table>
					</td>


					<!--  -->

					<%
						counter = 0;
					%>


					<td class="bold" bgcolor="#E2E2E2" valign="top" border='1'>
						<table border="0" cellspacing="0" cellpadding="0" width="100%"
							height="100%">
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td class="bold" align="right" height="50%">Gross total</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td height="1" bgcolor="black"></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td class="bold" align="right" height="50%">Total Deduction</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td class="bold" bgcolor="#E2E2E2" valign="top" align="right">
									NetPayable</td>
							</tr>
						</table>
					</td>

					<td valign="top" align="right" bgcolor="#E2E2E2" border='1'>
						<table width="90%" height="100%" border="1" cellpadding="1"
							cellspacing="1" bordercolor="lightgrey">
							<tr>
								<td height="10" colspan="2" align="center" valign="top"
									bgcolor="#E2E2E2" class="bold"><p>JN Cont.</p></td>
							</tr>
							<tr>
								<td width="100" align="right" valign="top" bgcolor="#E2E2E2"
									class="bold">NPS_reg</td>
							</tr>
							<tr>
								<td width="100" align="right" valign="top" bgcolor="#E2E2E2"
									class="bold">NPS_arr</td>
							</tr>
							<tr>
								<td width="100" align="right" valign="top" bgcolor="#E2E2E2"
									class="bold">Total</td>
							</tr>
						</table>
					</td>
				</tr>
				<%
					int i = 0;
					int j = 1;
				%>

				<c:if test="${employeeList != null}">
					<c:forEach items="${employeeList}" var="empList">
						<tr>
							<td><%=j%></td>

							<td>
								<table cellspacing="1" cellpadding="1" width="100%">


									<!-- Column EmployeeCode -->
									<%
										List employeeName = (List) request.getAttribute("employeeList");
												String employeeCode = employeeName.get(i).toString();
												//out.print(employeeCode);
												i++;
												j++;
									%>
									<!-- Column EmployeeCode -->
									<tr>
										<td><%=employeeCode%></td>
									</tr>
									<tr>
										<td><%=employeeNameMap.get(employeeCode)%></td>
									</tr>
									<!-- Column Designation -->
									<tr>
										<td><%=employeeDesignationMap.get(employeeCode)%></td>
									</tr>

									<tr>
										<td><%=payCategoryMap.get(employeeCode)%></td>
									</tr>

								</table>
							</td>
							<td valign="top">
								<table cellspacing="1" cellpadding="1" width="100%">

									<tr></tr>
									<tr>
										<td><%=employeeGPFAcNoMap.get(employeeCode)%></td>
									</tr>
									<tr>
									<tr>
										<td><%=bankAcNoMap.get(employeeCode)%></td>
									</tr>

									<tr>
										<td><%=pannoMap.get(employeeCode)%></td>
									</tr>

								</table>

							</td>

							<%
								double rowGrossTotal = 0;
										double rowTotalDeduction = 0;
										double npsarr = 0;
										double npsreg = 0;
							%>


							<td>
								<table cellspacing="1" cellpadding="1" width="100%" border="0">

									<%
										counter = 0;
									%>
									<c:if test="${headNameList != null}">
										<%-- <c:forEach items="${headNameList}" var="headList"> --%>
										<%
											List headNameList = (List) request.getAttribute("headNameList12");

														Iterator itr = headNameList.iterator();
														while (itr.hasNext()) {
															MonthlyPayReportDTO monthlyPayReportDTO = (MonthlyPayReportDTO) itr.next();

															String headType = monthlyPayReportDTO.getHeadType();
															String headName = monthlyPayReportDTO.getHeadName();

															//headTotalMap.put(headType + "@" + headName, "0");

															String installmentNo = "";
															//out.print(headType);
															if (headType.equals("L")) {
																installmentNo = (String) installmentMap
																		.get(employeeCode + "@" + headType + "@" + headName);
																if (installmentNo == null)
																	installmentNo = "";
															}
															String temp = (String) employeeValueMap.get(employeeCode + "@" + headType + "@" + headName);
															if (temp == null) {
																temp = "0";
															}
															double tempHeadAmount = Double.parseDouble(temp);
															headTotalMap
																	.put(headType + "@" + headName,
																			"" + (Double
																					.parseDouble((String) headTotalMap.get(headType + "@" + headName))
																					+ tempHeadAmount));
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
																out.println("##################" + npsreg);

															}
															counter++;
															if (counter == 8) {
																counter = 1;
										%>


										<tr>
											<td colspan="14" height="1" bgcolor="lightgrey"></td>
										</tr>
										<tr>
											<%
												}

																if (!headName.equals("REG_EMLR") && !headName.equals("EMLR_ARR")) {
											%>
											<td width="7.14%" align="right"><%=tempHeadAmount%></td>

											<%
												}
																if (!headName.equals("REG_EMLR") && !headName.equals("EMLR_ARR")) {
											%>
											<td width="7.14%" align="right"><%=installmentNo%></td>
											<%
												}
															} //end of while
											%>
										</tr>

										<%
											//out.print(counter);
														for (; counter < 7; counter++) {
										%>
										<tr>
											<td align="center">--</td>
										</tr>

										<%
											}
										%>
										<%-- </c:forEach> --%>
									</c:if>
								</table>
							</td>


							<td class="bold" valign="top">
								<table cellspacing="0" cellpadding="0" width="100%"
									height="100%">
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td align="right"><%=rowGrossTotal%></td>

									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td height="1" bgcolor="black"></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td align="right"><%=rowTotalDeduction%></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td valign="top" align="right"><%=(rowGrossTotal - rowTotalDeduction)%>
										</td>
									</tr>
								</table>
							</td>


							<td valign="top" align="right">

								<table cellspacing="0" cellpadding="0" width="100%"
									height="100%" \+i bordercolor="lightgrey">
									<tr>
										<td width="14.5%" align="right"><%=npsreg%></td>
									</tr>
									<tr>
										<td height="1" bgcolor="lightgrey"></td>
									</tr>
									<tr>
										<td width="14.5%" align="right"><%=npsarr%></td>
									</tr>
									<tr>
										<td height="1" bgcolor="lightgrey"></td>
									</tr>
									<tr>
										<td width="14.5%" align="right"><b><%=npsreg + npsarr%></b></td>

									</tr>
								</table>
							</td>

						</tr>
						<%
							
						%>
					</c:forEach>
				</c:if>

				<tr>
					<td valign="top" colspan="3" class="bold">Total</td>
					<td valign="top">
						<%
							counter = 0;
							double colGrossTotal = 0;
							double colTotalDeduction = 0;
							double colTotalnpsreg = 0;
							double colTotalarr = 0;
						%>
						<table cellspacing="1" cellpadding="1" width="100%" border="0">
							<c:if test="${headNameList != null}">
								<%-- <c:forEach items="${headnameList}" var="headList"> --%>
								<tr>

									<%
										List headNameList = (List) request.getAttribute("headNameList12");

											Iterator itr = headNameList.iterator();
											while (itr.hasNext()) {
												MonthlyPayReportDTO monthlyPayReportDTO = (MonthlyPayReportDTO) itr.next();

												String headType = monthlyPayReportDTO.getHeadType();
												String headName = monthlyPayReportDTO.getHeadName();
												double amount = Double.parseDouble((String) headTotalMap.get(headType + "@" + headName));
												if (headType.equals("A")) {
													colGrossTotal += amount;
												} else {
													if (!headName.equals("REG_EMLR") && !headName.equals("EMLR_ARR")) {
														colTotalDeduction += amount;
													}
												}

												if (headName.equals("EMLR_ARR")) {
													colTotalarr += amount;
												}
												if (headName.equals("REG_EMLR")) {
													colTotalnpsreg += amount;
												}

												counter++;
												if (counter == 8) {
													counter = 1;
									%>

								</tr>
								<tr>
									<td colspan="7" height="1" bgcolor="lightgrey">
								</tr>
								<tr>
									<%
										}
									%>
									<%
										if (!headName.equals("REG_EMLR") && !headName.equals("EMLR_ARR")) {
									%>
									<td width="14.5%" align="right" class="bold"><%=amount%></td>
									<%
										}
											}
									%>

									<%-- </c:forEach> --%>
							</c:if>
							<%
								for (; counter < 7; counter++) {
							%>
							<td align="center">--</td>
							<%
								}
							%>
							</tr>
						</table>
					<td class="bold" valign="top">
						<table cellspacing="0" cellpadding="0" width="100%" height="100%">
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align="right" class="bold"><%=colGrossTotal%></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td height="1" bgcolor="black"></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align="right" class="bold"><%=colTotalDeduction%></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td valign="top" align="right" class="bold"><%=(colGrossTotal - colTotalDeduction)%>
								</td>
							</tr>
						</table>
					</td>

					<td valign="top" align="right">
						<table cellspacing="0" cellpadding="0" width="100%" height="100%">
							<tr>
								<td align="right" class="bold"><%=colTotalnpsreg%></td>
							</tr>
							<tr>
								<td height="1" bgcolor="lightgrey"></td>
							</tr>
							<tr>
								<td align="right" class="bold"><%=colTotalarr%></td>
							</tr>
							<tr>
								<td height="1" bgcolor="lightgrey"></td>
							</tr>
							<tr>
								<td align="right" class="bold"><%=(colTotalnpsreg+colTotalarr)%></td>

							</tr>
						</table>
					</td>
				</tr>
				<!-- end -->
			</table>
</body>
</html>