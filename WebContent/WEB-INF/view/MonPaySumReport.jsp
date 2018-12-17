<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.nic.upjn.spring.entity.MonPaySumRepEntity"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#ffffff">

			<%
				java.util.Date date = new java.util.Date();
				int total_Number_Of_Employees = 0;
			%>
			<table border="1" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td align="center" bgcolor="#E2E2E2"><a href="#"
						onClick="history.back();"> Back </a></td>
					<td colspan="4" align="center" bgcolor="#E2E2E2"><font
						size="4" color="#003366"><b>Uttar Pradesh Jal Nigam <%-- ,<c:forEach items="${list}" var="a">{a.officename}</c:forEach> --%>
						</b></font> &nbsp;<font size="3" color="#003366"></font>
						
						<input type="button" value="Print this page" onClick="window.print()">
						
						<!-- <a href=""
						onClick="window.print()">Print PDF</a><font size="3"
						color="#003366"></font>-->
						
						</td>
				</tr>
			</table>
			<table width="100%" border="0">
				<tr>
					<td colspan="13" align="center"><font size="2" color="#003366">
							<b> Monthly Pay Summary Report For ${monthName}--${year} </b>
					</font></td>
				</tr>
				<tr>
					<td height="1" colspan="10" bgcolor="lightgrey"></td>
					<td height="1" colspan="3" bgcolor="lightgrey"><font size="1"
						color="#003366">Run Date : <%=date%></font></td>
				</tr>
				<tr>
					<td colspan="13" height="1" bgcolor="lightgrey"></td>
				</tr>
				<tr>
					<td colspan="13" height="1" bgcolor="black"></td>
				</tr>
				<tr>
					<td width="3%" rowspan="5" bgcolor="#BAB4BA" class="bold">S.No</td>
					<td width="8%" rowspan="5" bgcolor="#BAB4BA" class="bold">Register
						Name</td>
					<td width="6%" rowspan="5" bgcolor="#BAB4BA" class="bold"><div
							align="center">Total No. of Employee</div></td>
					<td width="8%" bgcolor="#BAB4BA" class="bold">B_Pay</td>
					<td width="8%" bgcolor="#BAB4BA" class="bold">Spl_Pay</td>
					<td width="8%" bgcolor="#BAB4BA" class="bold">Pers_pay</td>
					<td width="7%" bgcolor="#BAB4BA" class="bold">G_Pay</td>
					<td width="8%" bgcolor="#BAB4BA" class="bold">D_Pay</td>
					<td width="9%" bgcolor="#BAB4BA" class="bold">PG_Alw</td>
					<td width="9%" bgcolor="#BAB4BA" class="bold">BLG/CMPT</td>
					<td width="10%" rowspan="2" bgcolor="#BAB4BA" class="bold">Gross</td>
					<td width="8%" rowspan="5" bgcolor="#BAB4BA" class="bold"><div
							align="center">Net Payable</div></td>
					<td width="8%" rowspan="2" bgcolor="#BAB4BA" class="bold"><div
							align="center">NPS Employer Contribution</div></td>
				</tr>
				<tr>
					<td bgcolor="#BAB4BA" class="bold">Depu_Pay</td>
					<td width="8%" bgcolor="#BAB4BA" class="bold">DA</td>
					<td width="8%" bgcolor="#BAB4BA" class="bold">CCA</td>
					<td bgcolor="#BAB4BA" class="bold">HRA</td>
					<td bgcolor="#BAB4BA" class="bold">Med_Alw</td>
					<td bgcolor="#BAB4BA" class="bold">Ws_Alw</td>
					<td bgcolor="#BAB4BA" class="bold">Oth_Alw</td>
				</tr>
				<tr>
					<td bgcolor="#BAB4BA" class="bold">GPF</td>
					<td width="8%" bgcolor="#BAB4BA" class="bold">GIS</td>
					<td width="8%" bgcolor="#BAB4BA" class="bold">HS_RENT</td>
					<td bgcolor="#BAB4BA" class="bold">ITAX</td>
					<td bgcolor="#BAB4BA" class="bold">SOC_DED</td>
					<td bgcolor="#BAB4BA" class="bold">CLTH_DED</td>
					<td bgcolor="#BAB4BA" class="bold">LIP</td>
					<td width="10%" rowspan="3" bgcolor="#BAB4BA" class="bold">Total
						Ded.</td>
					<td width="8%" bgcolor="#BAB4BA" class="bold"><div
							align="right">Regular</div></td>
				</tr>
				<tr>
					<td bgcolor="#BAB4BA" class="bold">KKD_DED</td>
					<td width="8%" bgcolor="#BAB4BA" class="bold">MISC_DED</td>
					<td width="8%" bgcolor="#BAB4BA" class="bold">SCTR_ADV</td>
					<td bgcolor="#BAB4BA" class="bold">H.B.A</td>
					<td bgcolor="#BAB4BA" class="bold">GPF_ADV</td>
					<td bgcolor="#BAB4BA" class="bold">MOP_ADV</td>
					<td bgcolor="#BAB4BA" class="bold">HBA_HDFC</td>
					<td width="8%" bgcolor="#BAB4BA" class="bold"><div
							align="right">Arrear</div></td>
				</tr>
				<tr>
					<td bgcolor="#BAB4BA" class="bold">COMP_ADV</td>
					<td width="8%" bgcolor="#BAB4BA" class="bold">CAR ADV</td>
					<td width="8%" bgcolor="#BAB4BA" class="bold">CYC ADV</td>
					<td bgcolor="#BAB4BA" class="bold">HSREPADV</td>
					<td bgcolor="#BAB4BA" class="bold">NPS Reg</td>
					<td bgcolor="#BAB4BA" class="bold">NPS Arrear</td>
					<td bgcolor="#BAB4BA" class="bold">--</td>
					<td width="8%" bgcolor="#BAB4BA" class="bold"><div
							align="right"></div></td>
				</tr>
				<tr>
					<td colspan="13" height="1" bgcolor="black"></td>
				</tr>
				<%
					int i = 1;
				%>
				<c:forEach items="${summaryList}" var="a">
					<%
						total_Number_Of_Employees++;
					%>
					<tr>
						<td rowspan="5" bgcolor="#E8E8E8" style="border: groove"><%=i%></td>
						<td rowspan="5" bgcolor="#E8E8E8">Register ${a.registername}
						</td>
						<td rowspan="5" bgcolor="#E8E8E8">${a.empno}</td>
						<td bgcolor="#E8E8E8"><div align="right">${a.b_pay}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.spl_pay}</div></td>
						<td bgcolor="#E8E8E8">
							<div align="right">${a.pers_pay}</div>
						</td>
						<td bgcolor="#E8E8E8"><div align="right">${a.g_pay}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">0</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.pg_alw}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.blg_cmpt}
							</div></td>
						<td rowspan="2" bgcolor="#E8E8E8"><div align="right">
								${a.gross}</div></td>
						<td rowspan="5" bgcolor="#E8E8E8"><div align="right">
								${a.net_payable}</div></td>
						<td rowspan="2" bgcolor="#E8E8E8">&nbsp;</td>
					</tr>
					<tr>
						<td bgcolor="#E8E8E8"><div align="right">0</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.da}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.cca}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.hra}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.medalw}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.ws_alw}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.oth_alw}</div></td>
					</tr>
					<tr>
						<td bgcolor="#E8E8E8"><div align="right">${a.gpf}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.gis}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.hs_rent}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.itax}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.soc_ded}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.clth_ded}
							</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.lip}</div></td>
						<td rowspan="3" bgcolor="#E8E8E8"><div align="right">
								${a.total_ded}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.reg_emlr}
							</div></td>
					</tr>
					<tr>
						<td bgcolor="#E8E8E8"><div align="right">${a.kkd_ded}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.misc_ded}
							</div></td>
						<td bgcolor="#E8E8E8"><div align="right">0</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.hba}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.gpf_adv}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">0</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.hba_hdfc}
							</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.emlr_arr}
							</div></td>
					</tr>
					<tr>
						<td bgcolor="#E8E8E8"><div align="right">0</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.car_adv}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">0</div></td>
						<td bgcolor="#E8E8E8"><div align="right">0</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.reg_emp}</div></td>
						<td bgcolor="#E8E8E8"><div align="right">${a.emp_arr}</div></td>
						<td width="0%" bgcolor="#E8E8E8"><div align="right"></div></td>
						<td width="0%" bgcolor="#E8E8E8">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="13" height="1" bgcolor="black"></td>
					</tr>
					<%
						i++;
					%>
				</c:forEach>
				<tr>
					<td colspan="13" height="1" bgcolor="black"></td>
				</tr>
				<%
					long colbpay = 0;
					long colspay = 0;
					long colPpay = 0;
					long colGpay = 0;
					long colDpay = 0;
					long colpg_alw = 0;
					long colblg_cmt = 0;
					long colgross = 0;
					long colnetpay = 0;
					long colda = 0;
					long colcca = 0;
					long colhra = 0;
					long colmedalw = 0;
					long colws_alw = 0;
					long coloth_alw = 0;
					long colgpf = 0;
					long colgis = 0;
					long colhs_rent = 0;
					long colitax = 0;
					long colsoc_ded = 0;
					long colclth_ded = 0;
					long collip = 0;
					long colkkd_ded = 0;
					long colmisc_ded = 0;
					long colhba = 0;
					long colgpf_adv = 0;
					long colhba_hdfc = 0;
					long colcar_adv = 0;
					long colreg_emp = 0;
					long colemp_arr = 0;
					long coltotal_ded = 0;
					long colreg_emlr = 0;
					long colemlr_arr = 0;
				%>

				<c:forEach items="${summaryList}" var="a">
					<%
						try {

								List headNameList = (List) request.getAttribute("summaryList");

								Iterator itr = headNameList.iterator();
								while (itr.hasNext()) {
									MonPaySumRepEntity dto = (MonPaySumRepEntity) itr.next();
									String total_ded = "0";
									String bpay = dto.getB_pay();
									String spay = dto.getSpl_pay();
									String Ppay = dto.getPers_pay();
									String Gpay = dto.getG_pay();
									String blg_cmt = dto.getBlg_cmpt();
									String pg_alw = dto.getPg_alw();
									String gross = dto.getGross();
									String netpay = dto.getNet_payable();
									String da = dto.getDa();
									String cca = dto.getCca();
									String hra = dto.getHra();
									String medalw = dto.getMedalw();
									String ws_alw = dto.getWs_alw();
									String oth_alw = dto.getOth_alw();
									String gpf = dto.getGpf();
									String gis = dto.getGis();
									String hs_rent = dto.getHs_rent();
									String itax = dto.getItax();
									String soc_ded = dto.getSoc_ded();
									String clth_ded = dto.getClth_ded();
									String lip = dto.getLip();
									String kkd_ded = dto.getKkd_ded();
									String misc_ded = dto.getMisc_ded();
									String hba = dto.getHba();
									String gpf_adv = dto.getGpf_adv();
									String hba_hdfc = dto.getHba_hdfc();
									String car_adv = dto.getCar_adv();
									String reg_emp = dto.getReg_emp();
									String emp_arr = dto.getEmp_arr();
									if (dto.getTotal_ded() != null) {
										total_ded = dto.getTotal_ded();
									}

									//out.println("total deduction........."+total_ded);
									String reg_emlr = dto.getReg_emlr();
									String emlr_arr = dto.getEmlr_arr();
									//String headName=dto.getHeadName();

									colbpay = colbpay + Long.parseLong((String) bpay);
									//out.println("colbpay........."+colbpay);
									colspay = colspay + Long.parseLong((String) spay);
									//out.println("colspay........."+colspay);
									colPpay = colPpay + Long.parseLong((String) Ppay);
									//out.println("colPpay........."+colPpay);
									colGpay = colGpay + Long.parseLong((String) Gpay);
									//out.println("colGpay........."+colGpay);
									colpg_alw = colpg_alw + Long.parseLong((String) pg_alw);

									colblg_cmt = colblg_cmt + Long.parseLong((String) blg_cmt);
									//out.println("colblg_cmt........."+colblg_cmt);
									colgross = colgross + Long.parseLong((String) gross);
									//out.println("colgross........."+colgross);
									colnetpay = colnetpay + Long.parseLong((String) netpay);

									colda = colda + Long.parseLong((String) da);
									colcca = colcca + Long.parseLong((String) cca);
									colhra = colhra + Long.parseLong((String) hra);
									colmedalw = colmedalw + Long.parseLong((String) medalw);
									colws_alw = colws_alw + Long.parseLong((String) ws_alw);
									coloth_alw = coloth_alw + Long.parseLong((String) oth_alw);
									colgpf = colgpf + Long.parseLong((String) gpf);
									colgis = colgis + Long.parseLong((String) gis);
									colhs_rent = colhs_rent + Long.parseLong((String) hs_rent);
									colitax = colitax + Long.parseLong((String) itax);
									colsoc_ded = colsoc_ded + Long.parseLong((String) soc_ded);
									colclth_ded = colclth_ded + Long.parseLong((String) clth_ded);
									collip = collip + Long.parseLong((String) lip);
									colkkd_ded = colkkd_ded + Long.parseLong((String) kkd_ded);
									colmisc_ded = colmisc_ded + Long.parseLong((String) misc_ded);
									colhba = colhba + Long.parseLong((String) hba);
									colgpf_adv = colgpf_adv + Long.parseLong((String) gpf_adv);
									colhba_hdfc = colhba_hdfc + Long.parseLong((String) hba_hdfc);
									colcar_adv = colcar_adv + Long.parseLong((String) car_adv);
									colreg_emp = colreg_emp + Long.parseLong((String) reg_emp);
									colemp_arr = colemp_arr + Long.parseLong((String) emp_arr);
									coltotal_ded = coltotal_ded + Long.parseLong((String) total_ded);
									colreg_emlr = colreg_emlr + Long.parseLong((String) reg_emlr);
									//out.println("colreg_emlr.."+colreg_emlr);
									colemlr_arr = colemlr_arr + Long.parseLong((String) emlr_arr);
								}
							} catch (Exception e) {
								out.println("            Exception....." + e);
							}
					%>
				</c:forEach>

				<tr>


					<td colspan="3" rowspan="5" bgcolor="#BAB4BA" class="bold"><div
							align="right"></div></td>
					<td width="8%" bgcolor="#BAB4BA" align="right" class="bold"><%=colbpay%></td>
					<td width="8%" bgcolor="#BAB4BA" align="right" class="bold"><%=colspay%></td>
					<td width="8%" bgcolor="#BAB4BA" align="right" class="bold"><%=colPpay%></td>
					<td width="7%" bgcolor="#BAB4BA" align="right" class="bold"><%=colGpay%></td>
					<td width="8%" bgcolor="#BAB4BA" align="right" class="bold">0</td>
					<td width="9%" bgcolor="#BAB4BA" align="right" class="bold"><%=colpg_alw%></td>
					<td width="9%" bgcolor="#BAB4BA" align="right" class="bold"><%=colblg_cmt%></td>
					<td width="10%" rowspan="2" align="right" bgcolor="#BAB4BA"
						class="bold"><%=colgross%></td>
					<td width="8%" rowspan="5" bgcolor="#BAB4BA" class="bold"><div
							align="right"><%=colnetpay%></div></td>
					<td width="8%" rowspan="2" bgcolor="#BAB4BA" class="bold"><div
							align="right"></div></td>
				</tr>
				<tr>
					<td bgcolor="#BAB4BA" class="bold"><div align="right">0</div></td>
					<td width="8%" bgcolor="#BAB4BA" align="right" class="bold"><%=colda%></td>
					<td width="8%" bgcolor="#BAB4BA" align="right" class="bold"><%=colcca%></td>
					<td bgcolor="#BAB4BA" align="right" class="bold"><%=colhra%></td>
					<td bgcolor="#BAB4BA" align="right" class="bold"><%=colmedalw%></td>
					<td bgcolor="#BAB4BA" align="right" class="bold"><%=colws_alw%></td>
					<td bgcolor="#BAB4BA" align="right" class="bold"><%=coloth_alw%></td>
				</tr>
				<tr>
					<td bgcolor="#BAB4BA" align="right" class="bold"><%=colgpf%></td>
					<td width="8%" bgcolor="#BAB4BA" align="right" class="bold"><%=colgis%></td>
					<td width="8%" bgcolor="#BAB4BA" align="right" class="bold"><%=colhs_rent%></td>
					<td bgcolor="#BAB4BA" align="right" class="bold"><%=colitax%></td>
					<td bgcolor="#BAB4BA" align="right" class="bold"><%=colsoc_ded%></td>
					<td bgcolor="#BAB4BA" align="right" class="bold"><%=colclth_ded%></td>
					<td bgcolor="#BAB4BA" align="right" class="bold"><%=collip%></td>
					<td width="10%" rowspan="3" align="right" bgcolor="#BAB4BA"
						class="bold"><%=coltotal_ded%></td>
					<td width="8%" bgcolor="#BAB4BA" align="right" class="bold"><div
							align="right"><%=colreg_emlr%></div></td>
				</tr>
				<tr>
					<td bgcolor="#BAB4BA" align="right" class="bold"><%=colkkd_ded%></td>
					<td width="8%" bgcolor="#BAB4BA" align="right" class="bold"><%=colmisc_ded%></td>
					<td width="8%" bgcolor="#BAB4BA" align="right" class="bold"><div
							align="right">0</div></td>
					<td bgcolor="#BAB4BA" align="right" class="bold"><%=colhba%></td>
					<td bgcolor="#BAB4BA" align="right" class="bold"><%=colgpf_adv%></td>
					<td bgcolor="#BAB4BA" align="right" class="bold"><div
							align="right">0</div></td>
					<td bgcolor="#BAB4BA" align="right" class="bold"><%=colhba_hdfc%></td>
					<td width="8%" bgcolor="#BAB4BA" align="right" class="bold"><div
							align="right"><%=colemlr_arr%></div></td>
				</tr>
				<tr>
					<td bgcolor="#BAB4BA" class="bold"><div align="right">0</div></td>
					<td width="8%" bgcolor="#BAB4BA" align="right" class="bold"><%=colcar_adv%></td>
					<td width="8%" bgcolor="#BAB4BA" class="bold"><div
							align="right">0</div></td>
					<td bgcolor="#BAB4BA" align="right" class="bold"><div
							align="right">0</div></td>
					<td bgcolor="#BAB4BA" align="right" class="bold"><%=colreg_emp%></td>
					<td bgcolor="#BAB4BA" align="right" class="bold"><%=colemp_arr%></td>
					<td bgcolor="#BAB4BA" align="right" class="bold">--</td>
					<td width="8%" bgcolor="#BAB4BA" class="bold"><div
							align="right"></div></td>
				</tr>

				<tr>
					<td colspan="13" height="1" bgcolor="black"></td>
				</tr>
				<tr>
					<td colspan="13" class="bold">Total No of Registers <%=total_Number_Of_Employees%></td>
				</tr>
			</table>

</body>
</html>