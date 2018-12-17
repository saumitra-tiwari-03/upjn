package com.nic.upjn.spring.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.upjn.spring.entity.AdviceBillBillDetailEntity;
import com.nic.upjn.spring.entity.BillAdviceReportEntity;
import com.nic.upjn.spring.entity.BillDetailEntity;
import com.nic.upjn.spring.entity.DeductionLoanScheduleEntity;
import com.nic.upjn.spring.entity.MonPaySumRepEntity;
import com.nic.upjn.spring.entity.OfficeSummaryGroupEntity;
import com.nic.upjn.spring.entity.OfficeSummaryReportEntity;
import com.nic.upjn.spring.entity.OfficeSummaryReportEntity1;
import com.nic.upjn.spring.entity.OfficeSummaryReportEntity2;
import com.nic.upjn.spring.entity.PaySlipEntity;
import com.nic.upjn.spring.entity.PaySlipHeadEntity;
import com.nic.upjn.spring.entity.PpPaybilldetail;
import com.nic.upjn.spring.entity.SysPaymentmode;
import com.nic.upjn.spring.entity.ViewAmount;
import com.nic.upjn.spring.entity.ViewChecklist;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;
import com.nic.upjn.spring.entity.ViewHeadName;
import com.nic.upjn.spring.entity.ViewHeadNameYearlyPay;
import com.nic.upjn.spring.entity.ViewHeadNpsName;
import com.nic.upjn.spring.entity.ViewLocCode;
import com.nic.upjn.spring.entity.ViewMonthlyPayReport;
import com.nic.upjn.spring.entity.ViewOfficeWiseEmpReport;
import com.nic.upjn.spring.entity.ViewPayGetscheduleheadlist;
import com.nic.upjn.spring.entity.ViewPpLoandetail;
import com.nic.upjn.spring.entity.ViewYearlyPayReport;
import com.nic.upjn.spring.entity.YearlyPayRepEntity;
import com.nic.upjn.spring.entity.YearlyPayReportEntity;

@Repository("ReportManagerDAO")
public class ReportManagerDAOimple implements ReportManagerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<?> getList(String wherecondition, String namedQuery) {
		Query query = null;
		List<?> list = null;

		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();

			if (wherecondition != null) {
				query = session.getNamedQuery(namedQuery);
				query.setString(0, wherecondition);
				list = (List<?>) query.list();
			}

			else {

				query = session.getNamedQuery(namedQuery);
				list = (List<?>) query.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

		}

		return list;
	}
	
	

	@Override
	public List<PpPaybilldetail> getbillDetail(String rmofficeid, String month, String year, String ppRegistermasterID,
			String namedQuery) {

		Session session = null;
		List<PpPaybilldetail> list = null;
		try {
			session = sessionFactory.openSession();
			String sql = "SELECT * FROM PP_PAYBILLDETAIL WHERE pp_RegisterMasterID='" + ppRegistermasterID
					+ "' AND RM_OFFICEID = '" + rmofficeid + "' AND MONTH = '" + month + "' AND YEAR  = '" + year + "'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(PpPaybilldetail.class);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;

	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List getmonthlypayreport(String rmofficeid, String month, String year, String ppPaybilldetailid,
			String ppRegistermasterID) {
		Session session = null;
		List<ViewMonthlyPayReport> list = null;
		List<ViewMonthlyPayReport> list1 = null;
		List newList = new ArrayList();

		try {
			session = sessionFactory.openSession();

			String sql = "select rownum,PP_PAYSCALEMASTERID,PP_EMPLOYEEPAYDETAILID,PAYCATEGORY, upper(EMPNAME) as EMPNAME, EMPLOYEECODE, DESIGNATION, GPFACNO, BANKACCNO,PANNO, PP_MONTHLYPAYID, nvl(NOOFDAYS,'0') as NOOFDAYS, PAYMONTH, PAYYEAR, HEADID,    HEADNAME, HEADTYPE, PRINT_ORDER, round(AMOUNT,0)as AMOUNT, PP_REGISTERMASTERID, RM_OFFICEID, pp_PayBillDetailID, case when installment='/' then '' when installment is null then ''  else '['||installment||']' end installment   from  ( SELECT    PP_EMPLOYEEPAYDETAIL.PP_PAYSCALEMASTERID,PP_EMPLOYEEPAYDETAIL.PP_EMPLOYEEPAYDETAILID,SYS_PAYCATEGORY.PAYCATEGORY, FIRSTNAME||' '||MIDDLENAME||' '||LASTNAME EMPNAME, PP_EMPLOYEEMASTER.EMPLOYEECODE, (SELECT DESIGNATION FROM PP_DESIGNATIONMASTER WHERE PP_DESIGNATIONMASTERID=PP_EMPLOYEEMASTER.PP_DESIGNATIONMASTERID) DESIGNATION,  PP_EMPLOYEEDETAIL.GPFACNO, PP_EMPLOYEEPAYDETAIL.BANKACCNO,PP_EMPLOYEEDETAIL.PANNO, PP_MONTHLYPAY_TRAN.PP_MONTHLYPAYID, nvl(PP_MONTHLYPAY.NOOFDAYS,'0') as NOOFDAYS,  pp_PayBillDetailID,  PAYMONTH, PAYYEAR, HEADID, HEADNAME, HEADTYPE, PRINT_ORDER, AMOUNT,PP_MONTHLYPAY.PP_REGISTERMASTERID,PP_EMPLOYEEMASTER.RM_OFFICEID, case when A.headType<>'L' then '/' else installment_No  || '/' ||  (select pa_noOfinstallments from PP_LOANDETAIL where PP_LOANDETAIL.PP_LOANMASTERID=A.HEADID and PP_LOANDETAIL.PP_EMPLOYEEMASTERID=PP_MONTHLYPAY.PP_EMPLOYEEMASTERID and PP_LOANDETAIL.pa_isfullyrecovered<>1 ) end installment  FROM PP_MONTHLYPAY_TRAN, PP_MONTHLYPAY, PP_EMPLOYEEMASTER, PP_EMPLOYEEPAYDETAIL, SYS_PAYCATEGORY, PP_EMPLOYEEDETAIL,(SELECT * FROM (SELECT PP_LOANMASTERID HEADID, LOANSHORTNAME HEADNAME, 'L' HEADTYPE, PRINT_ORDER FROM PP_LOANMASTER union all select PP_NPS_ARREARID headid, nps_arrearname headname, npstype headtype, print_order from pp_nps_arrear UNION ALL SELECT PP_PAYALWMASTERID HEADID, PAYALWSHORTNAME HEADNAME, 'A' HEADTYPE,  PRINT_ORDER FROM PP_PAYALWMASTER P, PP_PAYALWHEAD  WHERE PP_PAYALWHEAD.PAYALWHEADID=P.PAYALWHEADID AND PP_PAYALWHEAD.PAY_OR_PEN=0  UNION ALL  SELECT PP_DEDUCTIONMASTERID HEADID, DEDSHORTNAME HEADNAME, 'D' HEADTYPE, PRINT_ORDER FROM PP_DEDUCTIONMASTER))A WHERE PP_MONTHLYPAY.PP_MONTHLYPAYID=PP_MONTHLYPAY_TRAN.PP_MONTHLYPAYID AND PP_MONTHLYPAY_TRAN.TRAN_TYPEID=A.HEADID AND PP_MONTHLYPAY_TRAN.tran_Flag = A.HEADTYPE AND PP_EMPLOYEEMASTER.PP_EMPLOYEEMASTERID=PP_MONTHLYPAY.PP_EMPLOYEEMASTERID AND PP_EMPLOYEEPAYDETAIL.PP_EMPLOYEEMASTERID=PP_EMPLOYEEMASTER.PP_EMPLOYEEMASTERID AND PP_EMPLOYEEDETAIL.PP_EMPLOYEEMASTERID=PP_EMPLOYEEMASTER.PP_EMPLOYEEMASTERID AND SYS_PAYCATEGORY.SYS_PAYCATEGORYID=PP_EMPLOYEEPAYDETAIL.SYS_PAYCATEGORYID ) WHERE PP_REGISTERMASTERID='"
					+ ppRegistermasterID + "' AND PAYMONTH='" + month + "' AND PAYYEAR='" + year
					+ "' AND pp_PayBillDetailID = '" + ppPaybilldetailid + "' ORDER BY EMPLOYEECODE";

			SQLQuery query = session.createSQLQuery(sql);

			query.addEntity(ViewMonthlyPayReport.class);

			list = query.list();

			list1 = getUniqueEmployeePayDetailIDWeightMapping(rmofficeid, month, year, ppRegistermasterID,
					ppPaybilldetailid);
			query.addEntity(ViewMonthlyPayReport.class);
			list1 = query.list();

			ViewMonthlyPayReport a = null;
			String b = "";

			System.out.println("hello");

			Iterator itr = list1.iterator();
			while (itr.hasNext()) {
				a = (ViewMonthlyPayReport) itr.next();
				if (a != null) {
					// System.out.println("hii");
					String ppemployeepaydetailID = a.getPp_EmployeePayDetailID() + "";
					// System.out.println(ppemployeepaydetailID);
					Iterator itr1 = list.iterator();
					while (itr1.hasNext()) {
						ViewMonthlyPayReport report = (ViewMonthlyPayReport) itr1.next();
						if (ppemployeepaydetailID.equals(report.getPp_EmployeePayDetailID() + "")) {
							// System.out.println(report.getPp_EmployeePayDetailID());
							newList.add(report);
							// System.out.println("logic success");
						}
					}

				} // end if

			} // end while loop

			System.out.println("The size of newList = " + newList.size());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newList;

	}

	private List getUniqueEmployeePayDetailIDWeightMapping(String rmofficeid, String month, String year,
			String ppRegistermasterID, String ppPaybilldetailid) {

		Session session = null;
		List<ViewMonthlyPayReport> list = null;
		try {
			session = sessionFactory.openSession();

			String sql = "SELECT DISTINCT PP_EMPLOYEEPAYDETAILID, CASE WHEN WEIGHT IS NULL THEN 0 ELSE WEIGHT END WEIGHT  FROM PP_EMPLOYEEMASTER EMP  INNER JOIN PP_EMPLOYEEPAYDETAIL EMPPAY ON EMP.PP_EMPLOYEEMASTERID = EMPPAY.PP_EMPLOYEEMASTERID  INNER JOIN PP_MONTHLYPAY MP ON MP.PP_EMPLOYEEMASTERID = EMPPAY.PP_EMPLOYEEMASTERID  INNER JOIN PP_PAYBILLDETAIL PD ON MP.PP_PAYBILLDETAILID = PD.PP_PAYBILLDETAILID  LEFT JOIN PP_PAYSCALEMASTER PSCALE ON EMPPAY.PP_PAYSCALEMASTERID = PSCALE.PP_PAYSCALEMASTERID  WHERE  PP_REGISTERMASTERID='"
					+ ppRegistermasterID + "' AND MP.PAYMONTH='" + month + "' AND MP.PAYYEAR='" + year
					+ "' AND MP.pp_PayBillDetailID = '" + ppPaybilldetailid + "' ORDER BY WEIGHT DESC";
			SQLQuery query = session.createSQLQuery(sql);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List headName() {
		Session session = null;
		List<ViewHeadName> list = null;
		try {
			session = sessionFactory.openSession();

			String sql = "SELECT * FROM (SELECT PP_LOANMASTERID HEADID, LOANSHORTNAME HEADNAME, 'L' HEADTYPE, PRINT_ORDER FROM PP_LOANMASTER UNION ALL SELECT (SELECT MAX(PP_PAYALWMASTERID) FROM PP_PAYALWMASTER WHERE PAYALWHEADID=P.PAYALWHEADID) HEADID, PAYALWSHORTNAME HEADNAME, 'A' HEADTYPE, PRINT_ORDER FROM PP_PAYALWHEAD P where  PAY_OR_PEN=0 UNION ALL SELECT PP_DEDUCTIONMASTERID HEADID, DEDSHORTNAME HEADNAME, 'D' HEADTYPE, PRINT_ORDER FROM PP_DEDUCTIONMASTER union all select PP_NPS_ARREARID headid, nps_arrearname headname, npstype headtype, print_order from pp_nps_arrear)where headid not in(38,100)  ORDER BY HEADTYPE, PRINT_ORDER";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewHeadName.class);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List headNpsName() {
		Session session = null;
		List<ViewHeadNpsName> list = null;
		try {
			session = sessionFactory.openSession();

			String sql = "SELECT * FROM (SELECT PP_LOANMASTERID HEADID, LOANSHORTNAME HEADNAME, 'L' HEADTYPE, PRINT_ORDER FROM PP_LOANMASTER UNION ALL SELECT (SELECT MAX(PP_PAYALWMASTERID) FROM PP_PAYALWMASTER WHERE PAYALWHEADID=P.PAYALWHEADID) HEADID, PAYALWSHORTNAME HEADNAME, 'A' HEADTYPE, PRINT_ORDER FROM PP_PAYALWHEAD P where  PAY_OR_PEN=0 UNION ALL SELECT PP_DEDUCTIONMASTERID HEADID, DEDSHORTNAME HEADNAME, 'D' HEADTYPE, PRINT_ORDER FROM PP_DEDUCTIONMASTER union all select PP_NPS_ARREARID headid, nps_arrearname headname, npstype headtype, print_order from pp_nps_arrear)  ORDER BY HEADTYPE, PRINT_ORDER";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewHeadNpsName.class);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List getCheckList(Integer rmOfficeid, String month, String year) {
		Session session = null;
		List<ViewHeadNpsName> list = null;
		try {
			session = sessionFactory.openSession();

			String sql = "select *  from view_checklist where EXTRACT(MONTH from executiondate) = '" + month
					+ "' AND EXTRACT(YEAR from executiondate) = '" + year + "' AND rm_officeid='" + rmOfficeid
					+ "' order by register, executiondate";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewChecklist.class);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List getEmployeeList(String sql) {
		List results = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewEmployeeSearch.class);
			results = query.list();

			tx.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return results;
	}

	@Override
	public List getBillDetailForMonthlyPayReport(String month, String year, Integer rmOfficeid,
			String ppRegistermasterid) {
		List results = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String sql = "SELECT PP_PAYBILLDETAILID, BILLCLERKNAME, BILLNO, MONTH, YEAR, BILLDATE, "
				+ "BILLAMOUNT, BILLTYPE_FLAG, PP_REGISTERMASTERID,(SELECT REGISTERNAME " + " FROM PP_REGISTERMASTER "
				+ " WHERE PP_REGISTERMASTERID=PP_PAYBILLDETAIL.PP_REGISTERMASTERID) REGISTERNAME "
				+ "FROM PP_PAYBILLDETAIL WHERE pp_RegisterMasterID='" + ppRegistermasterid + "' AND RM_OFFICEID = '"
				+ rmOfficeid + "' AND MONTH = '" + month + "' AND YEAR  = '" + year + "' ";
		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(BillDetailEntity.class);
			results = query.list();

			tx.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return results;
	}

	@Override
	public List getPaySlipReportHeads() {

		List list = null;
		String sql = "";
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		sql = "SELECT distinct headName, headType, print_Order FROM ";
		sql += "( ";
		sql += "    SELECT PP_LOANMASTERID HEADID, LOANNAME HEADNAME, 'L' HEADTYPE, ";
		sql += "        PRINT_ORDER FROM PP_LOANMASTER ";
		sql += "    UNION ALL ";
		sql += "    SELECT PP_PAYALWMASTERID HEADID, PAYALWSHORTNAME HEADNAME, 'A' HEADTYPE, ";
		sql += "        PRINT_ORDER FROM PP_PAYALWMASTER P, PP_PAYALWHEAD WHERE PP_PAYALWHEAD.PAYALWHEADID=P.PAYALWHEADID ";
		sql += "    UNION ALL ";
		sql += "    SELECT PP_DEDUCTIONMASTERID HEADID, DEDSHORTNAME HEADNAME, 'D' HEADTYPE, PRINT_ORDER FROM PP_DEDUCTIONMASTER ";
		sql += ")ORDER BY HEADTYPE, PRINT_ORDER ";
		System.out.println(sql);

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(PaySlipHeadEntity.class);
			list = query.list();

			tx.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List getPaySlipReport(Integer rmOfficeid, String pp_RegisterMasterID, String payMonth, String payYear,
			String employeeCode, String pp_PayBillDetailID) {

		List paySlipReport = null;

		String employeeCondition = "";
		if (employeeCode != null && employeeCode.trim().length() > 0) {
			if (employeeCode.indexOf("('-1'") >= 0) {
				employeeCondition = " AND EMPLOYEECODE in " + employeeCode + " ";
			} else {
				employeeCondition = " AND EMPLOYEECODE='" + employeeCode + "' ";
			}
		}

		String sql = "";

		sql = "select EMPLOYEECODE, EMPNAME, DESIGNATION, BANKACCNO, GPFACNO, paymentMode, payCategory, max(PP_MONTHLYPAYID) PP_MONTHLYPAYID, sum(NOOFDAYS) NOOFDAYS, PAYMONTH, PAYYEAR, HEADID, HEADNAME,  HEADTYPE,  ";
		sql += "PRINT_ORDER, sum(AMOUNT) AMOUNT,PP_REGISTERMASTERID, RM_OFFICEID, case when installment='/' then '' else installment end installment from  ";
		sql += "( ";
		sql += "SELECT  pp_PayBillDetailID, PP_EMPLOYEEMASTER.EMPLOYEECODE, FIRSTNAME||' '||MIDDLENAME||' '||LASTNAME EMPNAME,  ";
		sql += "        (SELECT DESIGNATION FROM PP_DESIGNATIONMASTER WHERE PP_DESIGNATIONMASTERID=PP_EMPLOYEEMASTER.PP_DESIGNATIONMASTERID) DESIGNATION,   ";
		sql += "        PP_EMPLOYEEPAYDETAIL.BANKACCNO, PP_MONTHLYPAY_TRAN.PP_MONTHLYPAYID, PP_MONTHLYPAY.NOOFDAYS, PP_MONTHLYPAY.PAYMONTH, PP_MONTHLYPAY.PAYYEAR, HEADID, HEADNAME,   ";
		sql += "        HEADTYPE, PRINT_ORDER, AMOUNT, PP_MONTHLYPAY.PP_REGISTERMASTERID, PP_EMPLOYEEMASTER.RM_OFFICEID, PP_EMPLOYEEDETAIL.GPFACNO, paymentMode, payCategory, ";
		sql += "        case when A.headType<>'L' then '/' else installment_No  ";
		sql += "		    || '/' ||  ";
		sql += "		   (select pa_noOfinstallments from PP_LOANDETAIL where PP_LOANDETAIL.PP_LOANMASTERID=A.HEADID and PP_LOANDETAIL.PP_EMPLOYEEMASTERID=PP_MONTHLYPAY.PP_EMPLOYEEMASTERID) end installment   ";
		sql += "FROM PP_MONTHLYPAY_TRAN, PP_MONTHLYPAY, PP_EMPLOYEEMASTER,  PP_EMPLOYEEPAYDETAIL, PP_EMPLOYEEDETAIL, SYS_PAYMENTMODE, SYS_PAYCATEGORY,  ";
		sql += "(  ";
		sql += "    SELECT * FROM  ";
		sql += "    (  ";
		sql += "        SELECT PP_LOANMASTERID HEADID, LOANNAME HEADNAME, 'L' HEADTYPE, PRINT_ORDER   ";
		sql += "        FROM PP_LOANMASTER  ";
		sql += "        UNION ALL   ";
		sql += "        SELECT PP_PAYALWMASTERID HEADID, PAYALWSHORTNAME HEADNAME, 'A' HEADTYPE,  ";
		sql += "            PRINT_ORDER FROM PP_PAYALWMASTER P, PP_PAYALWHEAD WHERE PP_PAYALWHEAD.PAYALWHEADID=P.PAYALWHEADID  ";
		sql += "        UNION ALL  ";
		sql += "        SELECT PP_DEDUCTIONMASTERID HEADID, DEDSHORTNAME HEADNAME, 'D' HEADTYPE,   ";
		sql += "            PRINT_ORDER FROM PP_DEDUCTIONMASTER  ";
		sql += "    )  ";
		sql += ")A WHERE PP_MONTHLYPAY.PP_MONTHLYPAYID=PP_MONTHLYPAY_TRAN.PP_MONTHLYPAYID   ";
		sql += " AND PP_MONTHLYPAY_TRAN.TRAN_TYPEID=A.HEADID   ";
		sql += " AND PP_EMPLOYEEMASTER.PP_EMPLOYEEMASTERID=PP_MONTHLYPAY.PP_EMPLOYEEMASTERID  ";
		sql += " AND PP_EMPLOYEEMASTER.PP_EMPLOYEEMASTERID=PP_EMPLOYEEPAYDETAIL.PP_EMPLOYEEMASTERID   ";
		sql += " AND PP_EMPLOYEEMASTER.PP_EMPLOYEEMASTERID=PP_EMPLOYEEDETAIL.PP_EMPLOYEEMASTERID ";
		sql += " AND SYS_PAYMENTMODE.SYS_PAYMENTMODEID=PP_EMPLOYEEPAYDETAIL.SYS_PAYMENTMODEID ";
		sql += " AND SYS_PAYCATEGORY.SYS_PAYCATEGORYID=PP_EMPLOYEEPAYDETAIL.SYS_PAYCATEGORYID ";
		sql += " ) ";
		sql += "WHERE RM_OFFICEID=" + rmOfficeid + " ";
		sql += "AND PP_REGISTERMASTERID=" + pp_RegisterMasterID + " ";
		sql += "AND pp_PayBillDetailID = '" + pp_PayBillDetailID + "'";
		sql += "AND PAYMONTH='" + payMonth + "' ";
		sql += "AND PAYYEAR='" + payYear + "' ";
		sql += employeeCondition;
		sql += "group by EMPLOYEECODE, EMPNAME, DESIGNATION, BANKACCNO, GPFACNO, PAYMONTH, PAYYEAR, HEADID, HEADNAME,  HEADTYPE, ";
		sql += "PRINT_ORDER, PP_REGISTERMASTERID, RM_OFFICEID, paymentMode, payCategory, installment ";
		sql += "ORDER BY EMPNAME, HEADTYPE, PRINT_ORDER";

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(PaySlipEntity.class);
			paySlipReport = query.list();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return paySlipReport;
	}

	@Override
	public List getMonthlySummary(Integer rmOfficeid, String month, String year) {

		List scheduleList = null;

		String sql = "select pp_registermasterid registername,count(DISTINCT pp_employeemasterid) empno ,nvl(sum(DECODE(tran_typeid,'570',amount)),0)+nvl(sum(DECODE(tran_typeid,'369',amount)),0)+nvl(sum(DECODE(tran_typeid,'568',amount)),0) b_pay ,\n"
				+ "nvl(sum(DECODE(tran_typeid,'571',amount)),0)+nvl(sum(DECODE(tran_typeid,'415',amount)),0) medalw ,nvl(sum(DECODE(tran_typeid,'572',amount)),0)+nvl(sum(DECODE(tran_typeid,'427',amount)),0) da,\n"
				+ "nvl(sum(DECODE(tran_typeid,'574',amount)),0)+nvl(sum(DECODE(tran_typeid,'530',amount)),0) cca,nvl(sum(DECODE(tran_typeid,'569',amount)),0) d_pay,\n"
				+ "nvl(sum(DECODE(tran_typeid,'573',amount)),0)+nvl(sum(DECODE(tran_typeid,'508',amount)),0) hra ,nvl(sum(DECODE(tran_typeid,'575',amount)),0) g_pay ,\n"
				+ "nvl(sum(DECODE(tran_typeid,'576',amount)),0) pers_pay,\n"
				+ "nvl(sum(DECODE(tran_typeid,'577',amount)),0) spl_pay ,nvl(sum(DECODE(tran_typeid,'578',amount)),0)+nvl(sum(DECODE(tran_typeid,'554',amount)),0) ws_alw ,\n"
				+ "nvl(sum(DECODE(tran_typeid,'579',amount)),0) pg_alw,\n"
				+ "nvl(sum(DECODE(tran_typeid,'580',amount)),0) blg_cmpt ,nvl(sum(DECODE(tran_typeid,'581',amount)),0) oth_alw ,nvl(sum(DECODE(tran_typeid,'1',amount)),0) gpf ,\n"
				+ "nvl(sum(DECODE(tran_typeid,'14',amount)),0) itax,nvl(sum(DECODE(tran_typeid,'12',amount)),0) gpf_adv,nvl(sum(DECODE(tran_typeid,'6',amount)),0) hba,\n"
				+ "nvl(sum(DECODE(tran_typeid,'7',amount)),0) HSREPADV,\n"
				+ "nvl(sum(DECODE(tran_typeid,'8',amount)),0) hba_hdfc,nvl(sum(DECODE(tran_typeid,'10',amount)),0) car_adv,nvl(sum(DECODE(tran_typeid,'3',amount)),0) soc_ded ,\n"
				+ "nvl(sum(DECODE(tran_typeid,'5',amount)),0) hs_rent ,nvl(sum(DECODE(tran_typeid,'31',amount)),0) gis,nvl(sum(DECODE(tran_typeid,'33',amount)),0) clth_ded,\n"
				+ "nvl(sum(DECODE(tran_typeid,'34',amount)),0) kkd_ded,nvl(sum(DECODE(tran_typeid,'35',amount)),0) misc_ded,nvl(sum(DECODE(tran_typeid,'36',amount)),0) lip ,\n"
				+ "nvl(sum(DECODE(tran_typeid,'37',amount)),0) reg_emp,nvl(sum(DECODE(tran_typeid,'99',amount)),0) emp_arr ,nvl(sum(DECODE(tran_typeid,'38',amount)),0) reg_emlr,\n"
				+ "nvl(sum(DECODE(tran_typeid,'100',amount)),0) emlr_arr ,nvl(sum(DECODE(tran_typeid,'570',amount)),0) +nvl(sum(DECODE(tran_typeid,'571',amount)),0) +nvl(sum(DECODE(tran_typeid,'572',amount)),0)\n"
				+ "+nvl(sum(DECODE(tran_typeid,'574',amount)),0) +nvl(sum(DECODE(tran_typeid,'573',amount)),0)  +nvl(sum(DECODE(tran_typeid,'575',amount)),0) + nvl(sum(DECODE(tran_typeid,'576',amount)),0) \n"
				+ "+nvl(sum(DECODE(tran_typeid,'577',amount)),0) +nvl(sum(DECODE(tran_typeid,'578',amount)),0) + nvl(sum(DECODE(tran_typeid,'579',amount)),0) +nvl(sum(DECODE(tran_typeid,'580',amount)),0)\n"
				+ "+nvl(sum(DECODE(tran_typeid,'581',amount)),0)+nvl(sum(DECODE(tran_typeid,'369',amount)),0)+nvl(sum(DECODE(tran_typeid,'427',amount)),0)\n"
				+ "+nvl(sum(DECODE(tran_typeid,'530',amount)),0)+nvl(sum(DECODE(tran_typeid,'508',amount)),0)+nvl(sum(DECODE(tran_typeid,'569',amount)),0)\n"
				+ "+nvl(sum(DECODE(tran_typeid,'415',amount)),0)++nvl(sum(DECODE(tran_typeid,'554',amount)),0)+nvl(sum(DECODE(tran_typeid,'568',amount)),0) as gross  ,\n"
				+ "nvl(sum(DECODE(tran_typeid,'1',amount)),0)+nvl(sum(DECODE(tran_typeid,'14',amount)),0)+nvl(sum(DECODE(tran_typeid,'12',amount)),0)+nvl(sum(DECODE(tran_typeid,'6',amount)),0)\n"
				+ " +nvl(sum(DECODE(tran_typeid,'8',amount)),0)+ nvl(sum(DECODE(tran_typeid,'10',amount)),0) +nvl(sum(DECODE(tran_typeid,'3',amount)),0)+nvl(sum(DECODE(tran_typeid,'5',amount)),0)\n"
				+ " +nvl(sum(DECODE(tran_typeid,'31',amount)),0)+nvl(sum(DECODE(tran_typeid,'33',amount)),0)+ nvl(sum(DECODE(tran_typeid,'34',amount)),0)+nvl(sum(DECODE(tran_typeid,'35',amount)),0)\n"
				+ " +nvl(sum(DECODE(tran_typeid,'36',amount)),0)+nvl(sum(DECODE(tran_typeid,'37',amount)),0)+nvl(sum(DECODE(tran_typeid,'99',amount)),0)\n"
				+ " +nvl(sum(DECODE(tran_typeid,'7',amount)),0) as total_ded ,\n"
				+ " nvl(sum(DECODE(tran_typeid,'570',amount)),0) +nvl(sum(DECODE(tran_typeid,'571',amount)),0) +nvl(sum(DECODE(tran_typeid,'572',amount)),0)+nvl(sum(DECODE(tran_typeid,'574',amount)),0)\n"
				+ " +nvl(sum(DECODE(tran_typeid,'573',amount)),0) +nvl(sum(DECODE(tran_typeid,'575',amount)),0) + nvl(sum(DECODE(tran_typeid,'576',amount)),0) +nvl(sum(DECODE(tran_typeid,'577',amount)),0) \n"
				+ " + nvl(sum(DECODE(tran_typeid,'578',amount)),0) +nvl(sum(DECODE(tran_typeid,'579',amount)),0) +nvl(sum(DECODE(tran_typeid,'580',amount)),0)+ nvl(sum(DECODE(tran_typeid,'581',amount)),0)\n"
				+ " +nvl(sum(DECODE(tran_typeid,'369',amount)),0)+nvl(sum(DECODE(tran_typeid,'427',amount)),0)+nvl(sum(DECODE(tran_typeid,'530',amount)),0)\n"
				+ " +nvl(sum(DECODE(tran_typeid,'508',amount)),0)+nvl(sum(DECODE(tran_typeid,'569',amount)),0)+nvl(sum(DECODE(tran_typeid,'415',amount)),0)++nvl(sum(DECODE(tran_typeid,'554',amount)),0)\n"
				+ " - nvl(sum(DECODE(tran_typeid,'1',amount)),0)-nvl(sum(DECODE(tran_typeid,'14',amount)),0)-nvl(sum(DECODE(tran_typeid,'12',amount)),0)-nvl(sum(DECODE(tran_typeid,'6',amount)),0)\n"
				+ " -nvl(sum(DECODE(tran_typeid,'8',amount)),0)-nvl(sum(DECODE(tran_typeid,'10',amount)),0)- nvl(sum(DECODE(tran_typeid,'3',amount)),0)-nvl(sum(DECODE(tran_typeid,'5',amount)),0)\n"
				+ " -nvl(sum(DECODE(tran_typeid,'31',amount)),0)- nvl(sum(DECODE(tran_typeid,'33',amount)),0)-nvl(sum(DECODE(tran_typeid,'34',amount)),0)-nvl(sum(DECODE(tran_typeid,'35',amount)),0)\n"
				+ " - nvl(sum(DECODE(tran_typeid,'36',amount)),0)-nvl(sum(DECODE(tran_typeid,'37',amount)),0)-nvl(sum(DECODE(tran_typeid,'99',amount)),0)-nvl(sum(DECODE(tran_typeid,'7',amount)),0)+nvl(sum(DECODE(tran_typeid,'568',amount)),0) as net_payable\n"
				+ "  " + " from  view_pay_summary main where payyear='" + year + "' and paymonth='" + month
				+ "' AND rm_officeid=" + rmOfficeid + "  group by pp_registermasterid order by pp_registermasterid";

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(MonPaySumRepEntity.class);
			scheduleList = query.list();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return scheduleList;
	}

	@Override
	public List getCompletedloanalertList(String monthName, String loan_type, String yearName, Integer rmOfficeid) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List loanalertList = null;
		String reco = "";
		if (loan_type.equals("current")) {
			System.out.println("i m in current --" + loan_type);
			reco = " and PA_ISFULLYRECOVERED='1' order by register,EMPLOYEENAME ";

		} else if (loan_type.equals("next")) {

			System.out.println("i m in current --" + loan_type);
			reco = " and PA_NOOFINSTALLMENTS-PA_NEXTINSTALLMENTNO=1 and PA_ISFULLYRECOVERED<>'1' order by register,EMPLOYEENAME ";
		}

		String sqlQuery = "select rownum,EMPLOYEECODE,EMPLOYEENAME,LOANSHORTNAME,LOANAMOUNT,PA_NOOFINSTALLMENTS,PA_NEXTINSTALLMENTNO,PA_INSTALLMENTAMOUNT,LOANSANCTIONORDNO,"
				+ "to_char(SANCTIONDATE,'dd/mm/yyyy') as SANCTIONDATE,PA_RECOVCOMMENCEMONTH,PA_RECOVCOMMENCEYEAR,register from view_pp_loandetail "
				+ "where  paymonth=" + monthName + " and payyear=" + yearName + " " + reco;

		try {
			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.addEntity(ViewPpLoandetail.class);
			loanalertList = query.list();

			tx.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return loanalertList;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getMonthlyPayReport(Integer officeID, String StartYear, String EndYear, String EmployeeCode) {

		List<YearlyPayReportEntity> monthlyPayList = null;
		List newList = new ArrayList();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<ViewYearlyPayReport> yprlist = new ArrayList<ViewYearlyPayReport>();
		String sql = "";
		sql = "select ROWNUM,PP_VIEW_EMP_PAY.EMPLOYEECODE,PP_VIEW_EMP_PAY.PAYCATEGORY,PP_VIEW_EMP_PAY.GPFACNO,PP_VIEW_EMP_PAY.BANKACCNO,PP_VIEW_EMP_PAY.EMPNAME,PP_VIEW_EMP_PAY.DESIGNATION,PP_VIEW_EMP_PAY.NOOFDAYS,PP_VIEW_EMP_PAY.PAYMONTH,PP_VIEW_EMP_PAY.PAYYEAR,PP_VIEW_EMP_PAY.HEADID,PP_VIEW_EMP_PAY.HEADTYPE,PP_VIEW_EMP_PAY.HEADNAME,PP_VIEW_EMP_PAY.AMOUNT,PP_VIEW_EMP_PAY.INSTALLMENT,PP_VIEW_EMP_PAY.PP_PAYSCALEMASTERID,PP_VIEW_EMP_PAY.pp_EmployeePayDetailID,pb.MONTH,pb.YEAR,pb.TOTAL_EMPLOYEE,pb.NETPAY,pb.BILLTYPE_FLAG,pb.BILLDATE,pb.ISLOCKED,pb.BILLAMOUNT,pb.BILLNO,pb.BILLCLERKNAME,pb.BILLCLERKID,pb.PP_PAYBILLDETAILID,pb.RM_OFFICEID,pb.PP_REGISTERMASTERID,PP_VIEW_EMP_PAY.PP_MONTHLYPAYID,PP_VIEW_EMP_PAY.PRINT_ORDER  from PP_VIEW_EMP_PAY inner join PP_PAYBILLDETAIL pb on pb.PP_PAYBILLDET"
				+ "AILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID ";

		sql = (new StringBuilder()).append(sql).append("WHERE ((payyear='").append(StartYear)
				.append("' and paymonth in (3,4,5,6,7,8,9,10,11,12)AND amount not in '0' and employeecode" + "='")
				.append(EmployeeCode).append("')").toString();
		sql = (new StringBuilder()).append(sql).append(" or (payyear='").append(EndYear)
				.append("' and paymonth in (1,2) AND amount not in '0' and employeecode='").append(EmployeeCode)
				.append("')) and pb.ISLOCKED='1' ").toString();
		sql = (new StringBuilder()).append(sql).append("ORDER BY payyear ,paymonth ").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(YearlyPayReportEntity.class);
			monthlyPayList = query.list();

			tx.commit();
			List<YearlyPayRepEntity> list = getUniqueEmployeePayDetailIDWeightMapping(officeID, StartYear, EndYear,
					EmployeeCode);
			int count = 0;
			for (YearlyPayReportEntity yearlyPayReportEntity : monthlyPayList) {
				count = count + 1;
				ViewYearlyPayReport viewYearlyPayReport = new ViewYearlyPayReport();
				BeanUtils.copyProperties(yearlyPayReportEntity, viewYearlyPayReport);
				viewYearlyPayReport.setWEIGHT("0");
				yprlist.add(viewYearlyPayReport);

			}

			/*
			 * ListIterator uniqueItr = list.listIterator();
			 * YearlyPayReportEntity dto = null; while(uniqueItr.hasNext()) {
			 * dto = (YearlyPayReportEntity)uniqueItr.next(); if(dto != null) {
			 * String str = dto.getPP_PAYBILLDETAILID()+"";
			 * 
			 * ListIterator tempItr = monthlyPayList.listIterator();
			 * while(tempItr.hasNext()) { YearlyPayReportEntity tempDTO =
			 * (YearlyPayReportEntity)tempItr.next();
			 * if(str.equals(tempDTO.getPP_PAYBILLDETAILID())) {
			 * newList.add(tempDTO); } } } }
			 */
			System.out
					.println((new StringBuilder()).append("The size of newList = ").append(newList.size()).toString());
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return yprlist;

	}

	private List getUniqueEmployeePayDetailIDWeightMapping(Integer officeID, String startYear, String endYear,
			String employeeCode) {
		List mapList = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String sql = "SELECT DISTINCT PD.PP_PAYBILLDETAILID,";
		sql = (new StringBuilder()).append(sql).append(" CASE WHEN WEIGHT IS NULL THEN 0 ELSE WEIGHT END WEIGHT ")
				.toString();
		sql = (new StringBuilder()).append(sql).append(" FROM PP_EMPLOYEEMASTER EMP ").toString();
		sql = (new StringBuilder()).append(sql).append(
				" INNER JOIN PP_EMPLOYEEPAYDETAIL EMPPAY ON EMP.PP_EMPLOYEEMASTERID = EMPPAY.PP_E" + "MPLOYEEMASTERID ")
				.toString();
		sql = (new StringBuilder()).append(sql)
				.append(" INNER JOIN PP_MONTHLYPAY MP ON MP.PP_EMPLOYEEMASTERID = EMPPAY.PP_EMPLOYEEMASTE" + "RID ")
				.toString();
		sql = (new StringBuilder()).append(sql)
				.append(" INNER JOIN PP_PAYBILLDETAIL PD ON MP.PP_PAYBILLDETAILID = PD.PP_PAYBILLDETAILID" + " ")
				.toString();
		sql = (new StringBuilder()).append(sql).append(
				" LEFT JOIN PP_PAYSCALEMASTER PSCALE ON EMPPAY.PP_PAYSCALEMASTERID = PSCALE.PP_PA" + "YSCALEMASTERID ")
				.toString();
		sql = (new StringBuilder()).append(sql).append("WHERE  (MP.payyear='").append(startYear)
				.append("' and MP.paymonth in (3,4,5,6,7,8,9,10,11,12) and EMP.employeecode='").append(employeeCode)
				.append("')").append(" or (MP.payyear='").append(endYear)
				.append("' and MP.paymonth in (1,2) and EMP.employeecode='").append(employeeCode).append("')")
				.toString();
		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(YearlyPayRepEntity.class);
			mapList = query.list();

			tx.commit();

		} catch (Exception e) {
			System.out.println((new StringBuilder()).append(
					"Exception inside getUniqueEmployeePayDetailIDWeightMapping method of YearlyPayRe" + "portDAO ")
					.append(e).toString());
		} finally {
			session.close();
		}
		return mapList;
	}

	@Override
	public List getLocCode(Integer rmOfficeid, String startYear, String endYear, String empcode) {
		List locCodeList = null;
		String sql = "";
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		sql = (new StringBuilder())
				.append("select loc_code from PP_VIEW_EMP_PAY   inner join PP_PAYBILLDETAIL pb on pb.PP_P"
						+ "AYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID   WHERE ((payyear='")
				.append(startYear)
				.append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) AND amount not in '0' and employeecod" + "e='")
				.append(empcode).append("' AND headname='B_PAY') ").append("  or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) AND amount not in '0' and employeecode='").append(empcode)
				.append("' AND headname='B_PAY')) and pb.ISLOCKED='1' ORDER BY payyear ,paymonth").toString();
		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewLocCode.class);
			locCodeList = query.list();

			tx.commit();

		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return locCodeList;
	}

	@Override
	public List headName(String startYear, String endYear, String empCode) {

		List list = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String sql = "SELECT DISTINCT(HEADID) ,HEADNAME ,HEADTYPE,PRINT_ORDER FROM PP_VIEW_HEAD_TYPELI" + "ST ";
		sql = (new StringBuilder()).append(sql).append("WHERE (payyear='").append(startYear)
				.append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) AND amount not in '0' and employeecod" + "e='")
				.append(empCode).append("')").toString();
		sql = (new StringBuilder()).append(sql).append(" or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) AND amount not in '0'  and employeecode='").append(empCode)
				.append("' ) ").toString();
		sql = (new StringBuilder()).append(sql).append("ORDER BY HEADTYPE, PRINT_ORDER").toString();
		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewHeadNameYearlyPay.class);
			list = query.list();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR IN HEADNAME METHODA SERVICE CLASS");
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List getTotalBpay(String startYear, String endYear, String empcode) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List B_PAY = null;

		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='B_PAY') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='B_PAY')) and pb.ISLOCKED='1'").toString();
		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			B_PAY = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println((new StringBuilder()).append("B_PAY=  ").append(B_PAY).toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return B_PAY;
	}

	@Override
	public List getTotalSPLPAY(String startYear, String endYear, String empcode) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List SPL_PAY = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='SPL_PAY') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='SPL_PAY')) and pb.ISLOCKED='1'").toString();
		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			SPL_PAY = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(SPL_PAY.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return SPL_PAY;
	}

	@Override
	public List getTotalPERSPAY(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List PERS_PAY = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='PERS_PAY') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='PERS_PAY')) and pb.ISLOCKED='1'").toString();
		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			PERS_PAY = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(PERS_PAY.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return PERS_PAY;
	}

	@Override
	public List getNetPay(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List netpay = null;
		String sql = (new StringBuilder())
				.append(" SELECT (x - y) as AMOUNT from (SELECT SUM(AMOUNT) x FROM  pp_view_emp_pay inner"
						+ " join PP_PAYBILLDETAIL pb on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDET"
						+ "AILID  WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and headtype='A') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and headtype='A')) and pb.ISLOCKED='1'),(SELECT SUM(AMOUNT) y FROM  pp_view_em"
						+ "p_pay inner join PP_PAYBILLDETAIL pb on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP"
						+ "_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and headtype='D') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and headtype='D')) and pb.ISLOCKED='1')").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			netpay = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(netpay.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return netpay;
	}

	@Override
	public List getTotalDed(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List totalded = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear)
				.append("' and paymonth in (3,4,5,6,7,8,9,10,11,12)AND amount not in '0' and employeecode" + "='")
				.append(empcode).append("' and headtype='D') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2)AND amount not in '0' and employeecode='").append(empcode)
				.append("' and headtype='D')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			totalded = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(totalded.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return totalded;
	}

	@Override
	public List getTotalGPAY(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List G_PAY = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='G_PAY') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='G_PAY')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			G_PAY = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(G_PAY.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return G_PAY;
	}

	@Override
	public List getGross(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List gross = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL "
						+ "pb on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear)
				.append("' and paymonth in (4,5,6,7,8,9,10,11,12)AND amount not in '0'  and employeecode=" + "'")
				.append(empcode).append("' and headtype='A') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2,3) and amount not in '0' and employeecode='").append(empcode)
				.append("' and headtype='A')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			gross = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(gross.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return gross;
	}

	@Override
	public List getTotalCARADV(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List G_PAY = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='REG_EMP') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='REG_EMP')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			G_PAY = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(G_PAY.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return G_PAY;
	}

	@Override
	public List getTotalCYCADV(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List PERS_PAY = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='CYC_ADV') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='CYC_ADV')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			PERS_PAY = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(PERS_PAY.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return PERS_PAY;
	}

	@Override
	public List getTotalGPF_ADV(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List SPL_PAY = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='GPF_ADV') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='GPF_ADV')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			SPL_PAY = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(SPL_PAY.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return SPL_PAY;
	}

	@Override
	public List getTotalDPAY(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List D_PAY = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='D_PAY') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='D_PAY')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			D_PAY = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(D_PAY.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return D_PAY;
	}

	@Override
	public List getTotalPGALL(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List PG_ALL = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='PG_ALL') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='PG_ALL')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			PG_ALL = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(PG_ALL.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return PG_ALL;
	}

	@Override
	public List getTotalBLGCMPT(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List BLGCMPT = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='BLG/CMPT') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='BLG/CMPT')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			BLGCMPT = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(BLGCMPT.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return BLGCMPT;
	}

	@Override
	public List getTotalDEPU_PAY(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List DEPU_PAY = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='DEPU_PAY') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='DEPU_PAY')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			DEPU_PAY = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(DEPU_PAY.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return DEPU_PAY;
	}

	@Override
	public List getTotalDA(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List DA = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='DA') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='DA')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			DA = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(DA.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return DA;
	}

	@Override
	public List getTotalCCA(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List CCA = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='CCA') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='CCA')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			CCA = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(CCA.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return CCA;
	}

	@Override
	public List getTotalGHRA(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List GHRA = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='HRA') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='HRA')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			GHRA = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(GHRA.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return GHRA;
	}

	@Override
	public List getTotalMEDALW(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List MEDALW = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='MEDALW') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='MEDALW')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			MEDALW = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(MEDALW.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return MEDALW;
	}

	@Override
	public List getTotalWS_ALW(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List WS_ALW = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='WS_ALW') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='WS_ALW')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			WS_ALW = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(WS_ALW.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return WS_ALW;
	}

	@Override
	public List getTotalGIS(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List GIS = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='GIS') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='GIS')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			GIS = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(GIS.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return GIS;
	}

	@Override
	public List getTotalHS_RENT(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List HS_RENT = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='HS_RENT') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='HS_RENT')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			HS_RENT = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(HS_RENT.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return HS_RENT;
	}

	@Override
	public List getTotalITAX(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List ITAX = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='ITAX') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='ITAX')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			ITAX = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(ITAX.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ITAX;
	}

	@Override
	public List getTotalOTH_ALW(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List OTH_ALW = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='OTH_ALW') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='OTH_ALW')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			OTH_ALW = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(OTH_ALW.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return OTH_ALW;
	}

	@Override
	public List getTotalGPF(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List GPF = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='GPF') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='GPF')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			GPF = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(GPF.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return GPF;
	}

	@Override
	public List getTotalSOC_DED(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List SOC_DED = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='SOC_DED') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='SOC_DED')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			SOC_DED = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(SOC_DED.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return SOC_DED;
	}

	@Override
	public List getTotalCLTH_DED(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List CLTH_DED = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='CLTH_DED') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='CLTH_DED')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			CLTH_DED = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(CLTH_DED.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return CLTH_DED;
	}

	@Override
	public List getTotalLIP(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List LIP = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='LIP') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='LIP')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			LIP = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(LIP.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return LIP;
	}

	@Override
	public List getTotalKKD_DED(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List KKD_DED = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='KKD_DED') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='KKD_DED')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			KKD_DED = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(KKD_DED.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return KKD_DED;
	}

	@Override
	public List getTotalMISC_DED(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List MISC_DED = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='MISC_DED') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='MISC_DED')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			MISC_DED = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(MISC_DED.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return MISC_DED;
	}

	@Override
	public List getTotalREG_EMP(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List REG_EMP = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='REG_EMP') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='REG_EMP')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			REG_EMP = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(REG_EMP.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return REG_EMP;
	}

	@Override
	public List getTotalHBA(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List HBA = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='H.B.A.') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='H.B.A.')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			HBA = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(HBA.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return HBA;
	}

	@Override
	public List getTotalSCTR_ADV(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List SCTR_ADV = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='SCTR_ADV') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='SCTR_ADV')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			SCTR_ADV = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(SCTR_ADV.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return SCTR_ADV;
	}

	@Override
	public List getTotalMOP_ADV(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List MOP_ADV = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='MOP_ADV') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='MOP_ADV')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			MOP_ADV = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(MOP_ADV.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return MOP_ADV;
	}

	@Override
	public List getTotalHSREPADV(String startYear, String endYear, String empcode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List HSREPADV = null;
		String sql = (new StringBuilder())
				.append("SELECT SUM(AMOUNT) as AMOUNT FROM  pp_view_emp_pay inner join PP_PAYBILLDETAIL p"
						+ "b on pb.PP_PAYBILLDETAILID=PP_VIEW_EMP_PAY.PP_PAYBILLDETAILID WHERE ((payyear='")
				.append(startYear).append("' and paymonth in (3,4,5,6,7,8,9,10,11,12) and employeecode='")
				.append(empcode).append("' and HEADNAME='HSREPADV') or (payyear='").append(endYear)
				.append("' and paymonth in (1,2) and employeecode='").append(empcode)
				.append("' and HEADNAME='HSREPADV')) and pb.ISLOCKED='1'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			HSREPADV = query.list();

			tx.commit();

			System.out.println((new StringBuilder()).append("sql=  ").append(sql).toString());
			System.out.println(HSREPADV.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return HSREPADV;
	}

	@Override
	public List getGroupList() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List HSREPADV = null;
		String sql = "select officename,loc_code from rm_office where loc_code like '%0000000' and  lo"
				+ "c_code not in (select loc_code from rm_office where loc_code  like '21%') order " + "by loc_code";

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(OfficeSummaryGroupEntity.class);
			HSREPADV = query.list();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return HSREPADV;
	}

	@Override
	public List getMonthlySummary(String month, String year, String isArrear, String isLocked, String isBoth,
			String group, String type) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String selectStatement = "";
		String whereStatement = "";
		String groupByStatement = "";
		String status = "";
		String loc_codeCondition = "";
		String innerJoinE = "";
		String innerJoinD = "";
		String innerJoinC = "";
		String innerJoinB = "";
		String orderBy = "";
		System.out.println((new StringBuilder())
				.append("group and type in dao getMonthlySummary+++++++++++++++++++++++++++++++++++++++++" + "++")
				.append(group).append(" ").append(type).toString());
		String strGroup = group;
		strGroup = strGroup.substring(0, 3);
		if (strGroup.equals("200") || strGroup.equals("314")) {
			System.out
					.println((new StringBuilder()).append("Location Code starting from 2 or 3 ::::::::::::::::::::   ")
							.append(strGroup.substring(0, 1)).toString());
			strGroup = strGroup.substring(0, 1);
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		} else if (strGroup.equals("000")) {
			strGroup = " ";
			loc_codeCondition = "  ";
		} else {
			System.out.println((new StringBuilder())
					.append("Location Code not starting from  2 or 3 :::::::::::::::::: ").append(strGroup).toString());
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		}
		if (type.equals("1")) {
			System.out.println((new StringBuilder()).append("++++++++this is type ").append(type).toString());
			selectStatement = "select a.paymonth,a.payyear, b.LOC_CODE,a.rm_officeid ,b.officename,b.mas_distri"
					+ "ctid,c.districtname,count(DISTINCT a.pp_registermasterid) registername, count(DI"
					+ "STINCT a.pp_employeemasterid) empno  , (select sum( d.total_employee)  from pp_p"
					+ "aybilldetail d where a.rm_officeid=d.rm_officeid and a.paymonth=d.month and a.pa"
					+ "yyear=d.year )employeename, ";
			innerJoinE = " ";
			innerJoinD = " ";
			innerJoinC = " inner join mas_district c on b.mas_districtid=c.mas_districtid ";
			innerJoinB = " inner join rm_office b on a.rm_officeid=b.rm_officeid ";
			orderBy = "b.loc_code";
			if (isArrear != null) {
				System.out.println((new StringBuilder()).append("++++++++++++++++++Arrear+++++++++").append(isArrear)
						.append(" of type+++++++ ").append(type).toString());
				whereStatement = (new StringBuilder()).append(" where a.paymonth!='").append(month)
						.append("'  and a.BILLTYPE_FLAG='A' and LTRIM(TO_char(LOCKBILLDATE, 'mm'),0)='").append(month)
						.append("' and  TO_char(LOCKBILLDATE, 'yy')='").append(year.substring(2, 4)).append("'")
						.append(loc_codeCondition).toString();
			} else {
				whereStatement = (new StringBuilder()).append(" where a.paymonth='").append(month)
						.append("' and a.payyear='").append(year).append("'").append(loc_codeCondition).toString();
				System.out.println((new StringBuilder()).append("++++++++++++++++++This is not Arrear+++++++++")
						.append(isArrear).append(" of type++++++ ").append(type).toString());
			}
			if (isBoth != null) {
				groupByStatement = (new StringBuilder())
						.append("and a.islocked in('1','0')  group by a.paymonth,a.payyear,a.rm_officeid,b.officename,b.LOC_CODE,b.mas_distri"
								+ "ctid,c.districtname,a.islocked  order by ")
						.append(orderBy).toString();
				status = " ,a.islocked as status ";
				System.out.println((new StringBuilder()).append("hey i m both part").append(isBoth).toString());
			} else if (isLocked != null) {
				groupByStatement = (new StringBuilder())
						.append(" and a.islocked=1 group by b.loc_code ,a.paymonth,a.payyear,a.rm_officeid,b.offi"
								+ "cename,b.LOC_CODE,b.mas_districtid,c.districtname,a.islocked  order by ")
						.append(orderBy).toString();
				status = ",a.islocked as status";
				System.out.println("");
			} else {
				groupByStatement = (new StringBuilder())
						.append(" and a.islocked=0 group by b.loc_code ,a.paymonth,a.payyear,a.rm_officeid,b.offi"
								+ "cename,b.LOC_CODE,b.mas_districtid,c.districtname,a.islocked  order by ")
						.append(orderBy).toString();
				status = ",a.islocked as status";
				System.out.println((new StringBuilder()).append("hey isLocked").append(isLocked).toString());
			}
		} else if (type.equals("2")) {
			System.out.println((new StringBuilder()).append("++++++++this is type ").append(type).toString());
			selectStatement = "select a.PAYMONTH,a.PAYYEAR,e.MAS_EMPLOYMENTSUBTYPEID,e.employmentsubtype, count"
					+ "(DISTINCT a.pp_employeemasterid) empno,";
			innerJoinB = " inner join rm_office b on a.rm_officeid=b.rm_officeid ";
			innerJoinC = " inner join pp_monthlypay c on c.pp_monthlypayid=a.PP_MONTHLYPAYID ";
			innerJoinD = " inner join pp_employeemaster d on c.pp_employeemasterid=d.pp_employeemasterid ";
			innerJoinE = " inner join mas_employmentsubtype e on e.MAS_EMPLOYMENTSUBTYPEID=d.MAS_EMPLOYMEN"
					+ "TSUBTYPEID ";
			orderBy = "MAS_EMPLOYMENTSUBTYPEID";
			if (isArrear != null) {
				System.out.println((new StringBuilder()).append("++++++++++++++++++Arrear+++++++++").append(isArrear)
						.append(" of type+++++++ ").append(type).toString());
				whereStatement = (new StringBuilder()).append(" where a.paymonth!='").append(month)
						.append("'  and a.BILLTYPE_FLAG='A' and LTRIM(TO_char(LOCKBILLDATE, 'mm'),0)='").append(month)
						.append("' and  TO_char(LOCKBILLDATE, 'yy')='").append(year.substring(2, 4)).append("'")
						.append(loc_codeCondition).toString();
			} else {
				whereStatement = (new StringBuilder()).append(" where a.paymonth='").append(month)
						.append("' and a.payyear='").append(year).append("'").append(loc_codeCondition).toString();
				System.out.println((new StringBuilder()).append("++++++++++++++++++This is not Arrear+++++++++")
						.append(isArrear).append(" of type++++++ ").append(type).toString());
			}
			if (isBoth != null) {
				groupByStatement = (new StringBuilder())
						.append("and a.islocked in('1','0') group by a.PAYMONTH,a.PAYYEAR,e.MAS_EMPLOYMENTSUBTYPEID,e.employmentsubtype,a.islocked orde"
								+ "r by ")
						.append(orderBy).toString();
				status = " ,a.islocked as status ";
				System.out.println((new StringBuilder()).append("hey i m both part").append(isBoth).toString());
			} else if (isLocked != null) {
				groupByStatement = (new StringBuilder())
						.append(" and a.islocked=1 group by a.PAYMONTH,a.PAYYEAR,e.MAS_EMPLOYMENTSUBTYPEID,e.empl"
								+ "oymentsubtype,a.islocked order by ")
						.append(orderBy).toString();
				status = ",a.islocked as status";
				System.out.println("");
			} else {
				groupByStatement = (new StringBuilder())
						.append(" and a.islocked=0 group by a.PAYMONTH,a.PAYYEAR,e.MAS_EMPLOYMENTSUBTYPEID,e.empl"
								+ "oymentsubtype,a.islocked order by ")
						.append(orderBy).toString();
				status = ",a.islocked as status";
				System.out.println((new StringBuilder()).append("hey isLocked").append(isLocked).toString());
			}
		} else if (type.equals("3")) {
			System.out.println((new StringBuilder()).append("++++++++this is type ").append(type).toString());
			selectStatement = "select a.PAYMONTH,a.PAYYEAR,e.PP_DESIGNATIONMASTERID,e.DESIGNATION, count(DISTIN"
					+ "CT a.pp_employeemasterid) empno,";
			innerJoinB = " inner join rm_office b on a.rm_officeid=b.rm_officeid ";
			innerJoinC = " inner join pp_monthlypay c on c.pp_monthlypayid=a.PP_MONTHLYPAYID ";
			innerJoinD = " inner join pp_employeemaster d on c.pp_employeemasterid=d.pp_employeemasterid ";
			innerJoinE = " inner join PP_DESIGNATIONMASTER e on e.PP_DESIGNATIONMASTERID=d.PP_DESIGNATIONM"
					+ "ASTERID ";
			orderBy = "e.DESIGNATION";
			if (isArrear != null) {
				System.out.println((new StringBuilder()).append("++++++++++++++++++Arrear+++++++++").append(isArrear)
						.append(" of type+++++++ ").append(type).toString());
				whereStatement = (new StringBuilder()).append(" where a.paymonth!='").append(month)
						.append("'  and a.BILLTYPE_FLAG='A' and LTRIM(TO_char(LOCKBILLDATE, 'mm'),0)='").append(month)
						.append("' and  TO_char(LOCKBILLDATE, 'yy')='").append(year.substring(2, 4)).append("'")
						.append(loc_codeCondition).toString();
			} else {
				whereStatement = (new StringBuilder()).append(" where a.paymonth='").append(month)
						.append("' and a.payyear='").append(year).append("'").append(loc_codeCondition).toString();
				System.out.println((new StringBuilder()).append("++++++++++++++++++This is not Arrear+++++++++")
						.append(isArrear).append(" of type++++++ ").append(type).toString());
			}
			if (isBoth != null) {
				groupByStatement = (new StringBuilder())
						.append("and a.islocked in('1','0') group by a.PAYMONTH,a.PAYYEAR,e.PP_DESIGNATIONMASTERID,e.DESIGNATION,a.islocked order by ")
						.append(orderBy).toString();
				status = ",a.islocked as status ";
				System.out.println((new StringBuilder()).append("hey i m both part").append(isBoth).toString());
			} else if (isLocked != null) {
				groupByStatement = (new StringBuilder())
						.append(" and a.islocked=1 group by a.PAYMONTH,a.PAYYEAR,e.PP_DESIGNATIONMASTERID,e.DESIG"
								+ "NATION,a.islocked order by ")
						.append(orderBy).toString();
				status = ",a.islocked as status";
				System.out.println("");
			} else {
				groupByStatement = (new StringBuilder())
						.append(" and a.islocked=0 group by a.PAYMONTH,a.PAYYEAR,e.PP_DESIGNATIONMASTERID,e.DESIG"
								+ "NATION,a.islocked order by ")
						.append(orderBy).toString();
				status = ",a.islocked as status";
				System.out.println((new StringBuilder()).append("hey isLocked").append(isLocked).toString());
			}
		}
		List scheduleList = null;
		String sqlQuery = (new StringBuilder()).append(selectStatement).append(" ")
				.append("nvl(sum(DECODE(tran_typeid,'570',amount)),0) +nvl(sum(DECODE(tran_typeid,'571',a"
						+ "mount)),0) +nvl(sum(DECODE(tran_typeid,'572',amount)),0)")
				.append("+nvl(sum(DECODE(tran_typeid,'574',amount)),0)+nvl(sum(DECODE(tran_typeid,'573',a"
						+ "mount)),0)  +nvl(sum(DECODE(tran_typeid,'575',amount)),0)")
				.append("+ nvl(sum(DECODE(tran_typeid,'576',amount)),0) +nvl(sum(DECODE(tran_typeid,'577'"
						+ ",amount)),0) +nvl(sum(DECODE(tran_typeid,'578',amount)),0)")
				.append("+ nvl(sum(DECODE(tran_typeid,'579',amount)),0) +nvl(sum(DECODE(tran_typeid,'580'"
						+ ",amount)),0) +nvl(sum(DECODE(tran_typeid,'581',amount)),0)")
				.append("+nvl(sum(DECODE(tran_typeid,'369',amount)),0) +nvl(sum(DECODE(tran_typeid,'427',"
						+ "amount)),0)+nvl(sum(DECODE(tran_typeid,'530',amount)),0)")
				.append("+nvl(sum(DECODE(tran_typeid,'508',amount)),0)+nvl(sum(DECODE(tran_typeid,'569',a"
						+ "mount)),0) +nvl(sum(DECODE(tran_typeid,'415',amount)),0)")
				.append("+nvl(sum(DECODE(tran_typeid,'554',amount)),0) +nvl(sum(DECODE(tran_typeid,'568',"
						+ "amount)),0) ")
				.append("as gross,")
				.append("nvl(sum(DECODE(tran_typeid,'1',amount)),0)+nvl(sum(DECODE(tran_typeid,'14',amoun"
						+ "t)),0)+nvl(sum(DECODE(tran_typeid,'12',amount)),0) ")
				.append("+nvl(sum(DECODE(tran_typeid,'6',amount)),0)+nvl(sum(DECODE(tran_typeid,'8',amoun"
						+ "t)),0)+ nvl(sum(DECODE(tran_typeid,'10',amount)),0) ")
				.append("+nvl(sum(DECODE(tran_typeid,'3',amount)),0)+nvl(sum(DECODE(tran_typeid,'5',amoun"
						+ "t)),0)+nvl(sum(DECODE(tran_typeid,'31',amount)),0) ")
				.append("+nvl(sum(DECODE(tran_typeid,'33',amount)),0) ")
				.append("+nvl(sum(DECODE(tran_typeid,'34',amount)),0)+nvl(sum(DECODE(tran_typeid,'35',amo"
						+ "unt)),0)+nvl(sum(DECODE(tran_typeid,'36',amount)),0) ")
				.append("+nvl(sum(DECODE(tran_typeid,'37',amount)),0)+nvl(sum(DECODE(tran_typeid,'99',amo"
						+ "unt)),0)+nvl(sum(DECODE(tran_typeid,'7',amount)),0) ")
				.append("as total_ded ,")
				.append("nvl(sum(DECODE(tran_typeid,'570',amount)),0) +nvl(sum(DECODE(tran_typeid,'571',a"
						+ "mount)),0) +nvl(sum(DECODE(tran_typeid,'572',amount)),0)")
				.append("+nvl(sum(DECODE(tran_typeid,'574',amount)),0)+nvl(sum(DECODE(tran_typeid,'573',a"
						+ "mount)),0) +nvl(sum(DECODE(tran_typeid,'575',amount)),0) ")
				.append("+ nvl(sum(DECODE(tran_typeid,'576',amount)),0) +nvl(sum(DECODE(tran_typeid,'577'"
						+ ",amount)),0) + nvl(sum(DECODE(tran_typeid,'578',amount)),0) ")
				.append("+nvl(sum(DECODE(tran_typeid,'579',amount)),0) +nvl(sum(DECODE(tran_typeid,'580',"
						+ "amount)),0)+ nvl(sum(DECODE(tran_typeid,'581',amount)),0)")
				.append("+nvl(sum(DECODE(tran_typeid,'369',amount)),0) +nvl(sum(DECODE(tran_typeid,'427',"
						+ "amount)),0)+nvl(sum(DECODE(tran_typeid,'530',amount)),0) ")
				.append("+nvl(sum(DECODE(tran_typeid,'508',amount)),0)+nvl(sum(DECODE(tran_typeid,'569',a"
						+ "mount)),0) +nvl(sum(DECODE(tran_typeid,'415',amount)),0)")
				.append("+nvl(sum(DECODE(tran_typeid,'554',amount)),0) +nvl(sum(DECODE(tran_typeid,'568',"
						+ "amount)),0) - nvl(sum(DECODE(tran_typeid,'1',amount)),0)")
				.append("-nvl(sum(DECODE(tran_typeid,'14',amount)),0)-nvl(sum(DECODE(tran_typeid,'12',amo"
						+ "unt)),0)-nvl(sum(DECODE(tran_typeid,'6',amount)),0)")
				.append("-nvl(sum(DECODE(tran_typeid,'8',amount)),0)-nvl(sum(DECODE(tran_typeid,'10',amou"
						+ "nt)),0)- nvl(sum(DECODE(tran_typeid,'3',amount)),0)")
				.append("-nvl(sum(DECODE(tran_typeid,'5',amount)),0)-nvl(sum(DECODE(tran_typeid,'31',amou"
						+ "nt)),0)- nvl(sum(DECODE(tran_typeid,'33',amount)),0)")
				.append("-nvl(sum(DECODE(tran_typeid,'34',amount)),0)-nvl(sum(DECODE(tran_typeid,'35',amo"
						+ "unt)),0)- nvl(sum(DECODE(tran_typeid,'36',amount)),0)")
				.append("-nvl(sum(DECODE(tran_typeid,'37',amount)),0)-nvl(sum(DECODE(tran_typeid,'99',amo"
						+ "unt)),0)-nvl(sum(DECODE(tran_typeid,'7',amount)),0) ")
				.append("as net,").append("nvl(sum(DECODE(tran_typeid,'14',amount)),0)  ").append("itax,")
				.append("nvl(sum(DECODE(tran_typeid,'1',amount)),0)+ nvl(sum(DECODE(tran_typeid,'12',amou"
						+ "nt)),0)  ")
				.append("GPF,").append("nvl(sum(DECODE(tran_typeid,'37',amount)),0) ").append("reg_emp,")
				.append("nvl(sum(DECODE(tran_typeid,'99',amount)),0) ").append("emp_arr ,")
				.append("nvl(sum(DECODE(tran_typeid,'38',amount)),0) ").append("reg_emlr,")
				.append("nvl(sum(DECODE(tran_typeid,'100',amount)),0) ").append("emlr_arr,")
				.append("nvl(sum(DECODE(tran_typeid,'37',amount)),0) +nvl(sum(DECODE(tran_typeid,'99',amo"
						+ "unt)),0) ")
				.append("employee ,")
				.append("nvl(sum(DECODE(tran_typeid,'38',amount)),0) +nvl(sum(DECODE(tran_typeid,'100',am"
						+ "ount)),0) ")
				.append("employer ").append(status).append(" from view_pay_summary a ").append(innerJoinB)
				.append(innerJoinC).append(innerJoinD).append(innerJoinE).append(whereStatement)
				.append(groupByStatement).toString();
		try {
			SQLQuery query = session.createSQLQuery(sqlQuery);
			if (type.equals("1")) {
				query.addEntity(OfficeSummaryReportEntity.class);
			}
			if (type.equals("2")) {
				query.addEntity(OfficeSummaryReportEntity1.class);
			}
			if (type.equals("3")) {
				query.addEntity(OfficeSummaryReportEntity2.class);
			}
			scheduleList = query.list();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return scheduleList;

	}

	@Override
	public List getGross(String month, String year, String isArrear, String isLocked, String isBoth, String group) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String Condition = "";
		String Condition1 = "";
		String demo = "1";
		String loc_codeCondition = "";
		String strGroup = group;
		strGroup = strGroup.substring(0, 3);
		if (strGroup.equals("200") || strGroup.equals("314")) {
			System.out
					.println((new StringBuilder()).append("Location Code starting from 2 or 3 ::::::::::::::::::::   ")
							.append(strGroup.substring(0, 1)).toString());
			strGroup = strGroup.substring(0, 1);
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		} else if (strGroup.equals("000")) {
			strGroup = " ";
			loc_codeCondition = "  ";
		} else {
			System.out.println((new StringBuilder())
					.append("Location Code not starting from  2 or 3 :::::::::::::::::: ").append(strGroup).toString());
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		}
		if (isArrear != null) {
			System.out.println(
					(new StringBuilder()).append("++++++++++++++++++isArrear+++++++++").append(isArrear).toString());
			Condition = (new StringBuilder()).append(" where a.paymonth!='").append(month)
					.append("'  and a.BILLTYPE_FLAG='A' and LTRIM(TO_char(LOCKBILLDATE, 'mm'),0)='").append(month)
					.append("' and  TO_char(LOCKBILLDATE, 'yy')='").append(year.substring(2, 4)).append("'")
					.append(loc_codeCondition).toString();
		} else {
			Condition = (new StringBuilder()).append(" where a.paymonth='").append(month).append("' and a.payyear='")
					.append(year).append("'").append(loc_codeCondition).toString();
			System.out.println((new StringBuilder()).append("++++++++++i m not ++++++++isArrear+++++++++")
					.append(isArrear).toString());
		}
		if (isBoth != null) {
			Condition1 = " ";
			System.out.println((new StringBuilder()).append("hey i m both part").append(isBoth).toString());
		} else if (isLocked != null) {
			Condition1 = " and a.islocked=1 ";
			System.out.println("");
		} else {
			Condition1 = " and a.islocked=0 ";
			System.out.println((new StringBuilder()).append("hey isLocked").append(isLocked).toString());
		}
		List gross = null;
		String sql = (new StringBuilder())
				.append("select nvl(sum(DECODE(tran_typeid,'570',amount)),0)+nvl(sum(DECODE(tran_typeid,'"
						+ "571',amount)),0) +nvl(sum(DECODE(tran_typeid,'572',amount)),0)+nvl(sum(DECODE(tr"
						+ "an_typeid,'574',amount)),0)+nvl(sum(DECODE(tran_typeid,'573',amount)),0)  +nvl(s"
						+ "um(DECODE(tran_typeid,'575',amount)),0) + nvl(sum(DECODE(tran_typeid,'576',amoun"
						+ "t)),0)+nvl(sum(DECODE(tran_typeid,'577',amount)),0) +nvl(sum(DECODE(tran_typeid,"
						+ "'578',amount)),0) + nvl(sum(DECODE(tran_typeid,'579',amount)),0)+nvl(sum(DECODE("
						+ "tran_typeid,'580',amount)),0) +nvl(sum(DECODE(tran_typeid,'581',amount)),0)+nvl("
						+ "sum(DECODE(tran_typeid,'369',amount)),0) +nvl(sum(DECODE(tran_typeid,'427',amoun"
						+ "t)),0)+nvl(sum(DECODE(tran_typeid,'530',amount)),0) +nvl(sum(DECODE(tran_typeid,"
						+ "'508',amount)),0)+nvl(sum(DECODE(tran_typeid,'569',amount)),0) +nvl(sum(DECODE(t"
						+ "ran_typeid,'415',amount)),0)+nvl(sum(DECODE(tran_typeid,'554',amount)),0) +nvl(s"
						+ "um(DECODE(tran_typeid,'568',amount)),0) as AMOUNT   from view_pay_summary a inner"
						+ " join rm_office b on a.rm_officeid=b.rm_officeid  inner join pp_monthlypay c on "
						+ "c.pp_monthlypayid=a.PP_MONTHLYPAYID  inner join pp_employeemaster d on c.pp_empl"
						+ "oyeemasterid=d.pp_employeemasterid  inner join PP_DESIGNATIONMASTER e on e.PP_DE"
						+ "SIGNATIONMASTERID=d.PP_DESIGNATIONMASTERID ")
				.append(Condition).append(Condition1).toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewAmount.class);
			gross = query.list();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return gross;
	}

	@Override
	public List getNetpay(String month, String year, String isArrear, String isLocked, String isBoth, String group) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String Condition = "";
		String Condition1 = "";
		String demo = "1";
		String loc_codeCondition = "";
		String strGroup = group;
		strGroup = strGroup.substring(0, 3);
		if (strGroup.equals("200") || strGroup.equals("314")) {
			System.out
					.println((new StringBuilder()).append("Location Code starting from 2 or 3 ::::::::::::::::::::   ")
							.append(strGroup.substring(0, 1)).toString());
			strGroup = strGroup.substring(0, 1);
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		} else if (strGroup.equals("000")) {
			strGroup = " ";
			loc_codeCondition = "  ";
		} else {
			System.out.println((new StringBuilder())
					.append("Location Code not starting from  2 or 3 :::::::::::::::::: ").append(strGroup).toString());
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		}
		if (isArrear != null) {
			System.out.println(
					(new StringBuilder()).append("++++++++++++++++++isArrear+++++++++").append(isArrear).toString());
			Condition = (new StringBuilder()).append(" where a.paymonth!='").append(month)
					.append("' and a.BILLTYPE_FLAG='A' and LTRIM(TO_char(LOCKBILLDATE, 'mm'),0)='").append(month)
					.append("' and  TO_char(LOCKBILLDATE, 'yy')='").append(year.substring(2, 4)).append("'")
					.append(loc_codeCondition).toString();
		} else {
			Condition = (new StringBuilder()).append(" where a.paymonth='").append(month).append("' and a.payyear='")
					.append(year).append("'").append(loc_codeCondition).toString();
			System.out.println((new StringBuilder()).append("++++++++++i m not ++++++++isArrear+++++++++")
					.append(isArrear).toString());
		}
		if (isBoth != null) {
			Condition1 = " ";
			System.out.println((new StringBuilder()).append("hey i m both part").append(isBoth).toString());
		} else if (isLocked != null) {
			Condition1 = " and a.islocked=1 ";
			System.out.println("");
		} else {
			Condition1 = " and a.islocked=0 ";
			System.out.println((new StringBuilder()).append("hey isLocked").append(isLocked).toString());
		}
		List netpay = null;
		String sqlQuery = (new StringBuilder())
				.append("select nvl(sum(DECODE(tran_typeid,'570',amount)),0) +nvl(sum(DECODE(tran_typeid,"
						+ "'571',amount)),0) +nvl(sum(DECODE(tran_typeid,'572',amount)),0)+nvl(sum(DECODE(t"
						+ "ran_typeid,'574',amount)),0)+nvl(sum(DECODE(tran_typeid,'573',amount)),0) +nvl(s"
						+ "um(DECODE(tran_typeid,'575',amount)),0) + nvl(sum(DECODE(tran_typeid,'576',amoun"
						+ "t)),0) +nvl(sum(DECODE(tran_typeid,'577',amount)),0) + nvl(sum(DECODE(tran_typei"
						+ "d,'578',amount)),0) +nvl(sum(DECODE(tran_typeid,'579',amount)),0) +nvl(sum(DECOD"
						+ "E(tran_typeid,'580',amount)),0)+ nvl(sum(DECODE(tran_typeid,'581',amount)),0)+nv"
						+ "l(sum(DECODE(tran_typeid,'369',amount)),0) +nvl(sum(DECODE(tran_typeid,'427',amo"
						+ "unt)),0)+nvl(sum(DECODE(tran_typeid,'530',amount)),0) +nvl(sum(DECODE(tran_typei"
						+ "d,'508',amount)),0)+nvl(sum(DECODE(tran_typeid,'569',amount)),0) +nvl(sum(DECODE"
						+ "(tran_typeid,'415',amount)),0)+nvl(sum(DECODE(tran_typeid,'554',amount)),0) +nvl"
						+ "(sum(DECODE(tran_typeid,'568',amount)),0)- nvl(sum(DECODE(tran_typeid,'1',amount"
						+ ")),0)-nvl(sum(DECODE(tran_typeid,'14',amount)),0)-nvl(sum(DECODE(tran_typeid,'12"
						+ "',amount)),0)-nvl(sum(DECODE(tran_typeid,'6',amount)),0)-nvl(sum(DECODE(tran_typ"
						+ "eid,'8',amount)),0)-nvl(sum(DECODE(tran_typeid,'10',amount)),0)- nvl(sum(DECODE("
						+ "tran_typeid,'3',amount)),0)-nvl(sum(DECODE(tran_typeid,'5',amount)),0)-nvl(sum(D"
						+ "ECODE(tran_typeid,'31',amount)),0)- nvl(sum(DECODE(tran_typeid,'33',amount)),0)-"
						+ "nvl(sum(DECODE(tran_typeid,'34',amount)),0)-nvl(sum(DECODE(tran_typeid,'35',amou"
						+ "nt)),0)- nvl(sum(DECODE(tran_typeid,'36',amount)),0)-nvl(sum(DECODE(tran_typeid,"
						+ "'37',amount)),0)-nvl(sum(DECODE(tran_typeid,'99',amount)),0)-nvl(sum(DECODE(tran"
						+ "_typeid,'7',amount)),0) as AMOUNT from view_pay_summary a  inner join rm_office b o"
						+ "n a.rm_officeid=b.rm_officeid  inner join pp_monthlypay c on c.pp_monthlypayid=a"
						+ ".PP_MONTHLYPAYID  inner join pp_employeemaster d on c.pp_employeemasterid=d.pp_e"
						+ "mployeemasterid  inner join PP_DESIGNATIONMASTER e on e.PP_DESIGNATIONMASTERID=d"
						+ ".PP_DESIGNATIONMASTERID ")
				.append(Condition).append(Condition1).toString();

		try {
			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.addEntity(ViewAmount.class);
			netpay = query.list();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return netpay;
	}

	@Override
	public List getTotalDed(String month, String year, String isArrear, String isLocked, String isBoth, String group) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String Condition = "";
		String Condition1 = "";
		String demo = "1";
		String loc_codeCondition = "";
		String strGroup = group;
		strGroup = strGroup.substring(0, 3);
		if (strGroup.equals("200") || strGroup.equals("314")) {
			System.out
					.println((new StringBuilder()).append("Location Code starting from 2 or 3 ::::::::::::::::::::   ")
							.append(strGroup.substring(0, 1)).toString());
			strGroup = strGroup.substring(0, 1);
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		} else if (strGroup.equals("000")) {
			strGroup = " ";
			loc_codeCondition = "  ";
		} else {
			System.out.println((new StringBuilder())
					.append("Location Code not starting from  2 or 3 :::::::::::::::::: ").append(strGroup).toString());
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		}
		if (isArrear != null) {
			System.out.println(
					(new StringBuilder()).append("++++++++++++++++++isArrear+++++++++").append(isArrear).toString());
			Condition = (new StringBuilder()).append(" where a.paymonth!='").append(month)
					.append("' and a.BILLTYPE_FLAG='A' and LTRIM(TO_char(LOCKBILLDATE, 'mm'),0)='").append(month)
					.append("' and  TO_char(LOCKBILLDATE, 'yy')='").append(year.substring(2, 4)).append("'")
					.append(loc_codeCondition).toString();
		} else {
			Condition = (new StringBuilder()).append(" where a.paymonth='").append(month).append("' and a.payyear='")
					.append(year).append("'").append(loc_codeCondition).toString();
			System.out.println((new StringBuilder()).append("++++++++++i m not ++++++++isArrear+++++++++")
					.append(isArrear).toString());
		}
		if (isBoth != null) {
			Condition1 = " ";
			System.out.println((new StringBuilder()).append("hey i m both part").append(isBoth).toString());
		} else if (isLocked != null) {
			Condition1 = " and a.islocked=1 ";
			System.out.println("");
		} else {
			Condition1 = " and a.islocked=0 ";
			System.out.println((new StringBuilder()).append("hey isLocked").append(isLocked).toString());
		}
		List total_Ded = null;
		String sqlQuery = (new StringBuilder())
				.append("select nvl(sum(DECODE(tran_typeid,'1',amount)),0)+nvl(sum(DECODE(tran_typeid,'14"
						+ "',amount)),0)+nvl(sum(DECODE(tran_typeid,'12',amount)),0)+nvl(sum(DECODE(tran_ty"
						+ "peid,'6',amount)),0)+nvl(sum(DECODE(tran_typeid,'8',amount)),0)+ nvl(sum(DECODE("
						+ "tran_typeid,'10',amount)),0) +nvl(sum(DECODE(tran_typeid,'3',amount)),0)+nvl(sum"
						+ "(DECODE(tran_typeid,'5',amount)),0)+nvl(sum(DECODE(tran_typeid,'31',amount)),0)+"
						+ "nvl(sum(DECODE(tran_typeid,'33',amount)),0)+ nvl(sum(DECODE(tran_typeid,'34',amo"
						+ "unt)),0)+nvl(sum(DECODE(tran_typeid,'35',amount)),0)+nvl(sum(DECODE(tran_typeid,"
						+ "'36',amount)),0)+nvl(sum(DECODE(tran_typeid,'37',amount)),0)+nvl(sum(DECODE(tran"
						+ "_typeid,'99',amount)),0)+nvl(sum(DECODE(tran_typeid,'7',amount)),0) as AMOUNT"
						+ "  from view_pay_summary a  inner join rm_office b on a.rm_officeid=b.rm_officeid"
						+ "  inner join pp_monthlypay c on c.pp_monthlypayid=a.PP_MONTHLYPAYID  inner join "
						+ "pp_employeemaster d on c.pp_employeemasterid=d.pp_employeemasterid  inner join P"
						+ "P_DESIGNATIONMASTER e on e.PP_DESIGNATIONMASTERID=d.PP_DESIGNATIONMASTERID")
				.append(Condition).append(Condition1).toString();

		try {
			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.addEntity(ViewAmount.class);
			total_Ded = query.list();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return total_Ded;
	}

	@Override
	public List getItax(String month, String year, String isArrear, String isLocked, String isBoth, String group) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String Condition = "";
		String Condition1 = "";
		String demo = "1";
		String loc_codeCondition = "";
		String strGroup = group;
		strGroup = strGroup.substring(0, 3);
		if (strGroup.equals("200") || strGroup.equals("314")) {
			System.out
					.println((new StringBuilder()).append("Location Code starting from 2 or 3 ::::::::::::::::::::   ")
							.append(strGroup.substring(0, 1)).toString());
			strGroup = strGroup.substring(0, 1);
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		} else if (strGroup.equals("000")) {
			strGroup = " ";
			loc_codeCondition = "  ";
		} else {
			System.out.println((new StringBuilder())
					.append("Location Code not starting from  2 or 3 :::::::::::::::::: ").append(strGroup).toString());
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		}
		if (isArrear != null) {
			System.out.println(
					(new StringBuilder()).append("++++++++++++++++++isArrear+++++++++").append(isArrear).toString());
			Condition = (new StringBuilder()).append(" where a.paymonth!='").append(month)
					.append("' and a.BILLTYPE_FLAG='A' and LTRIM(TO_char(LOCKBILLDATE, 'mm'),0)='").append(month)
					.append("' and  TO_char(LOCKBILLDATE, 'yy')='").append(year.substring(2, 4)).append("'")
					.append(loc_codeCondition).toString();
		} else {
			Condition = (new StringBuilder()).append(" where a.paymonth='").append(month).append("' and a.payyear='")
					.append(year).append("'").append(loc_codeCondition).toString();
			System.out.println((new StringBuilder()).append("++++++++++i m not ++++++++isArrear+++++++++")
					.append(isArrear).toString());
		}
		if (isBoth != null) {
			Condition1 = " ";
			System.out.println((new StringBuilder()).append("hey i m both part").append(isBoth).toString());
		} else if (isLocked != null) {
			Condition1 = " and a.islocked=1 ";
			System.out.println("");
		} else {
			Condition1 = " and a.islocked=0 ";
			System.out.println((new StringBuilder()).append("hey isLocked").append(isLocked).toString());
		}
		List itax = null;

		String sqlQuery = (new StringBuilder())
				.append("select nvl(sum(DECODE(tran_typeid,'14',amount)),0) AMOUNT from view_pay_summary a "
						+ " inner join rm_office b on a.rm_officeid=b.rm_officeid  inner join pp_monthlypay"
						+ " c on c.pp_monthlypayid=a.PP_MONTHLYPAYID  inner join pp_employeemaster d on c.p"
						+ "p_employeemasterid=d.pp_employeemasterid  inner join PP_DESIGNATIONMASTER e on e"
						+ ".PP_DESIGNATIONMASTERID=d.PP_DESIGNATIONMASTERID")
				.append(Condition).append(Condition1).toString();

		try {
			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.addEntity(ViewAmount.class);
			itax = query.list();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return itax;
	}

	@Override
	public List getGpf(String month, String year, String isArrear, String isLocked, String isBoth, String group) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String Condition = "";
		String Condition1 = "";
		String demo = "1";
		String loc_codeCondition = "";
		String strGroup = group;
		strGroup = strGroup.substring(0, 3);
		if (strGroup.equals("200") || strGroup.equals("314")) {
			System.out
					.println((new StringBuilder()).append("Location Code starting from 2 or 3 ::::::::::::::::::::   ")
							.append(strGroup.substring(0, 1)).toString());
			strGroup = strGroup.substring(0, 1);
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		} else if (strGroup.equals("000")) {
			strGroup = " ";
			loc_codeCondition = "  ";
		} else {
			System.out.println((new StringBuilder())
					.append("Location Code not starting from  2 or 3 :::::::::::::::::: ").append(strGroup).toString());
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		}
		if (isArrear != null) {
			System.out.println(
					(new StringBuilder()).append("++++++++++++++++++isArrear+++++++++").append(isArrear).toString());
			Condition = (new StringBuilder()).append(" where a.paymonth!='").append(month)
					.append("' and a.BILLTYPE_FLAG='A' and LTRIM(TO_char(LOCKBILLDATE, 'mm'),0)='").append(month)
					.append("' and  TO_char(LOCKBILLDATE, 'yy')='").append(year.substring(2, 4)).append("'")
					.append(loc_codeCondition).toString();
		} else {
			Condition = (new StringBuilder()).append(" where a.paymonth='").append(month).append("' and a.payyear='")
					.append(year).append("'").append(loc_codeCondition).toString();
			System.out.println((new StringBuilder()).append("++++++++++i m not ++++++++isArrear+++++++++")
					.append(isArrear).toString());
		}
		if (isBoth != null) {
			Condition1 = " ";
			System.out.println((new StringBuilder()).append("hey i m both part").append(isBoth).toString());
		} else if (isLocked != null) {
			Condition1 = " and a.islocked=1 ";
			System.out.println("");
		} else {
			Condition1 = " and a.islocked=0 ";
			System.out.println((new StringBuilder()).append("hey isLocked").append(isLocked).toString());
		}
		List gpf = null;
		String sqlQuery = (new StringBuilder())
				.append("select nvl(sum(DECODE(tran_typeid,'1',amount)),0)+ nvl(sum(DECODE(tran_typeid,'1"
						+ "2',amount)),0) AMOUNT from view_pay_summary a inner join rm_office b on a.rm_office"
						+ "id=b.rm_officeid  inner join pp_monthlypay c on c.pp_monthlypayid=a.PP_MONTHLYPA"
						+ "YID  inner join pp_employeemaster d on c.pp_employeemasterid=d.pp_employeemaster"
						+ "id  inner join PP_DESIGNATIONMASTER e on e.PP_DESIGNATIONMASTERID=d.PP_DESIGNATI"
						+ "ONMASTERID")
				.append(Condition).append(Condition1).toString();

		try {
			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.addEntity(ViewAmount.class);
			gpf = query.list();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return gpf;
	}

	@Override
	public List getEmployee(String month, String year, String isArrear, String isLocked, String isBoth, String group) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String Condition = "";
		String Condition1 = "";
		String demo = "1";
		String loc_codeCondition = "";
		String strGroup = group;
		strGroup = strGroup.substring(0, 3);
		if (strGroup.equals("200") || strGroup.equals("314")) {
			System.out
					.println((new StringBuilder()).append("Location Code starting from 2 or 3 ::::::::::::::::::::   ")
							.append(strGroup.substring(0, 1)).toString());
			strGroup = strGroup.substring(0, 1);
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		} else if (strGroup.equals("000")) {
			strGroup = " ";
			loc_codeCondition = "  ";
		} else {
			System.out.println((new StringBuilder())
					.append("Location Code not starting from  2 or 3 :::::::::::::::::: ").append(strGroup).toString());
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		}
		if (isArrear != null) {
			System.out.println(
					(new StringBuilder()).append("++++++++++++++++++isArrear+++++++++").append(isArrear).toString());
			Condition = (new StringBuilder()).append(" where a.paymonth!='").append(month)
					.append("' and a.BILLTYPE_FLAG='A' and LTRIM(TO_char(LOCKBILLDATE, 'mm'),0)='").append(month)
					.append("' and  TO_char(LOCKBILLDATE, 'yy')='").append(year.substring(2, 4)).append("'")
					.append(loc_codeCondition).toString();
		} else {
			Condition = (new StringBuilder()).append(" where a.paymonth='").append(month).append("' and a.payyear='")
					.append(year).append("'").append(loc_codeCondition).toString();
			System.out.println((new StringBuilder()).append("++++++++++i m not ++++++++isArrear+++++++++")
					.append(isArrear).toString());
		}
		if (isBoth != null) {
			Condition1 = " ";
			System.out.println((new StringBuilder()).append("hey i m both part").append(isBoth).toString());
		} else if (isLocked != null) {
			Condition1 = " and a.islocked=1 ";
			System.out.println("");
		} else {
			Condition1 = " and a.islocked=0 ";
			System.out.println((new StringBuilder()).append("hey isLocked").append(isLocked).toString());
		}
		List employee = null;
		String sqlQuery = (new StringBuilder())
				.append("select nvl(sum(DECODE(tran_typeid,'37',amount)),0) +nvl(sum(DECODE(tran_typeid,'"
						+ "99',amount)),0) AMOUNT from view_pay_summary a  inner join rm_office b on a.rm"
						+ "_officeid=b.rm_officeid  inner join pp_monthlypay c on c.pp_monthlypayid=a.PP_MO"
						+ "NTHLYPAYID  inner join pp_employeemaster d on c.pp_employeemasterid=d.pp_employe"
						+ "emasterid  inner join PP_DESIGNATIONMASTER e on e.PP_DESIGNATIONMASTERID=d.PP_DE"
						+ "SIGNATIONMASTERID")
				.append(Condition).append(Condition1).toString();

		try {
			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.addEntity(ViewAmount.class);
			employee = query.list();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employee;
	}

	@Override
	public List getEmployer(String month, String year, String isArrear, String isLocked, String isBoth, String group) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String Condition = "";
		String Condition1 = "";
		String demo = "1";
		String loc_codeCondition = "";
		String strGroup = group;
		strGroup = strGroup.substring(0, 3);
		if (strGroup.equals("200") || strGroup.equals("314")) {
			System.out
					.println((new StringBuilder()).append("Location Code starting from 2 or 3 ::::::::::::::::::::   ")
							.append(strGroup.substring(0, 1)).toString());
			strGroup = strGroup.substring(0, 1);
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		} else if (strGroup.equals("000")) {
			strGroup = " ";
			loc_codeCondition = "  ";
		} else {
			System.out.println((new StringBuilder())
					.append("Location Code not starting from  2 or 3 :::::::::::::::::: ").append(strGroup).toString());
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		}
		if (isArrear != null) {
			System.out.println(
					(new StringBuilder()).append("++++++++++++++++++isArrear+++++++++").append(isArrear).toString());
			Condition = (new StringBuilder()).append(" where a.paymonth!='").append(month)
					.append("' and a.BILLTYPE_FLAG='A' and LTRIM(TO_char(LOCKBILLDATE, 'mm'),0)='").append(month)
					.append("' and  TO_char(LOCKBILLDATE, 'yy')='").append(year.substring(2, 4)).append("'")
					.append(loc_codeCondition).toString();
		} else {
			Condition = (new StringBuilder()).append(" where a.paymonth='").append(month).append("' and a.payyear='")
					.append(year).append("'").append(loc_codeCondition).toString();
			System.out.println((new StringBuilder()).append("++++++++++i m not ++++++++isArrear+++++++++")
					.append(isArrear).toString());
		}
		if (isBoth != null) {
			Condition1 = " ";
			System.out.println((new StringBuilder()).append("hey i m both part").append(isBoth).toString());
		} else if (isLocked != null) {
			Condition1 = " and a.islocked=1 ";
			System.out.println("");
		} else {
			Condition1 = " and a.islocked=0 ";
			System.out.println((new StringBuilder()).append("hey isLocked").append(isLocked).toString());
		}
		List employer = null;
		String sqlQuery = (new StringBuilder())
				.append("select nvl(sum(DECODE(tran_typeid,'38',amount)),0) +nvl(sum(DECODE(tran_typeid,'"
						+ "100',amount)),0) AMOUNT from view_pay_summary a  inner join rm_office b on a.r"
						+ "m_officeid=b.rm_officeid  inner join pp_monthlypay c on c.pp_monthlypayid=a.PP_M"
						+ "ONTHLYPAYID  inner join pp_employeemaster d on c.pp_employeemasterid=d.pp_employ"
						+ "eemasterid  inner join PP_DESIGNATIONMASTER e on e.PP_DESIGNATIONMASTERID=d.PP_D"
						+ "ESIGNATIONMASTERID")
				.append(Condition).append(Condition1).toString();

		try {
			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.addEntity(ViewAmount.class);
			employer = query.list();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employer;
	}

	@Override
	public List getTotalEmp(String month, String year, String isArrear, String isLocked, String isBoth, String group) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String Condition = "";
		String Condition1 = "";
		String demo = "1";
		String loc_codeCondition = "";
		String strGroup = group;
		strGroup = strGroup.substring(0, 3);
		if (strGroup.equals("200") || strGroup.equals("314")) {
			System.out
					.println((new StringBuilder()).append("Location Code starting from 2 or 3 ::::::::::::::::::::   ")
							.append(strGroup.substring(0, 1)).toString());
			strGroup = strGroup.substring(0, 1);
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		} else if (strGroup.equals("000")) {
			strGroup = " ";
			loc_codeCondition = "  ";
		} else {
			System.out.println((new StringBuilder())
					.append("Location Code not starting from  2 or 3 :::::::::::::::::: ").append(strGroup).toString());
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		}
		if (isArrear != null) {
			System.out.println(
					(new StringBuilder()).append("++++++++++++++++++isArrear+++++++++").append(isArrear).toString());
			Condition = (new StringBuilder()).append(" where a.paymonth!='").append(month)
					.append("' and a.BILLTYPE_FLAG='A' and LTRIM(TO_char(LOCKBILLDATE, 'mm'),0)='").append(month)
					.append("' and  TO_char(LOCKBILLDATE, 'yy')='").append(year.substring(2, 4)).append("'")
					.append(loc_codeCondition).toString();
		} else {
			Condition = (new StringBuilder()).append(" where a.paymonth='").append(month).append("' and a.payyear='")
					.append(year).append("'").append(loc_codeCondition).toString();
			System.out.println((new StringBuilder()).append("++++++++++i m not ++++++++isArrear+++++++++")
					.append(isArrear).toString());
		}
		if (isBoth != null) {
			Condition1 = " ";
			System.out.println((new StringBuilder()).append("hey i m both part").append(isBoth).toString());
		} else if (isLocked != null) {
			Condition1 = " and a.islocked=1 ";
			System.out.println("");
		} else {
			Condition1 = " and a.islocked=0 ";
			System.out.println((new StringBuilder()).append("hey isLocked").append(isLocked).toString());
		}
		List totalemp = null;
		String sqlQuery = (new StringBuilder())
				.append("select sum(x.employeename) as AMOUNT from (select (select sum( d.total_emp"
						+ "loyee)  from pp_paybilldetail d where a.rm_officeid=d.rm_officeid and a.paymonth"
						+ "=d.month and a.payyear=d.year ) employeename from  view_pay_summary a inner join"
						+ " rm_office b on a.rm_officeid=b.rm_officeid  inner join pp_monthlypay c on c.pp_"
						+ "monthlypayid=a.PP_MONTHLYPAYID  inner join pp_employeemaster d on c.pp_employeem"
						+ "asterid=d.pp_employeemasterid  inner join PP_DESIGNATIONMASTER e on e.PP_DESIGNA"
						+ "TIONMASTERID=d.PP_DESIGNATIONMASTERID inner join mas_district f on b.mas_distric"
						+ "tid=f.mas_districtid")
				.append(Condition).append(Condition1)
				.append("group by b.loc_code ,a.rm_officeid,b.officename,b.LOC_CODE,b.mas_districtid,f.di"
						+ "strictname,a.islocked,a.paymonth,a.payyear)x")
				.toString();

		try {
			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.addEntity(ViewAmount.class);
			totalemp = query.list();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return totalemp;
	}

	@Override
	public List getPaidEmp(String month, String year, String isArrear, String isLocked, String isBoth, String group) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String Condition = "";
		String Condition1 = "";
		String demo = "1";
		String loc_codeCondition = "";
		String strGroup = group;
		strGroup = strGroup.substring(0, 3);
		if (strGroup.equals("200") || strGroup.equals("314")) {
			System.out
					.println((new StringBuilder()).append("Location Code starting from 2 or 3 ::::::::::::::::::::   ")
							.append(strGroup.substring(0, 1)).toString());
			strGroup = strGroup.substring(0, 1);
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		} else if (strGroup.equals("000")) {
			strGroup = " ";
			loc_codeCondition = "  ";
		} else {
			System.out.println((new StringBuilder())
					.append("Location Code not starting from  2 or 3 :::::::::::::::::: ").append(strGroup).toString());
			loc_codeCondition = (new StringBuilder()).append(" and b.loc_code like '").append(strGroup).append("%' ")
					.toString();
		}
		if (isArrear != null) {
			System.out.println(
					(new StringBuilder()).append("++++++++++++++++++isArrear+++++++++").append(isArrear).toString());
			Condition = (new StringBuilder()).append(" where a.paymonth!='").append(month)
					.append("' and a.BILLTYPE_FLAG='A' and LTRIM(TO_char(LOCKBILLDATE, 'mm'),0)='").append(month)
					.append("' and  TO_char(LOCKBILLDATE, 'yy')='").append(year.substring(2, 4)).append("'")
					.append(loc_codeCondition).toString();
		} else {
			Condition = (new StringBuilder()).append(" where a.paymonth='").append(month).append("' and a.payyear='")
					.append(year).append("'").append(loc_codeCondition).toString();
			System.out.println((new StringBuilder()).append("++++++++++i m not ++++++++isArrear+++++++++")
					.append(isArrear).toString());
		}
		if (isBoth != null) {
			Condition1 = " ";
			System.out.println((new StringBuilder()).append("hey i m both part").append(isBoth).toString());
		} else if (isLocked != null) {
			Condition1 = " and a.islocked=1 ";
			System.out.println("");
		} else {
			Condition1 = " and a.islocked=0 ";
			System.out.println((new StringBuilder()).append("hey isLocked").append(isLocked).toString());
		}
		List paidemp = null;
		String sqlQuery = (new StringBuilder())
				.append("select sum(x.empno)as AMOUNT from (select count(DISTINCT a.pp_employeemasterid) e"
						+ "mpno from  view_pay_summary a  inner join rm_office b on a.rm_officeid=b.rm_offi"
						+ "ceid  inner join pp_monthlypay c on c.pp_monthlypayid=a.PP_MONTHLYPAYID  inner j"
						+ "oin pp_employeemaster d on c.pp_employeemasterid=d.pp_employeemasterid  inner jo"
						+ "in PP_DESIGNATIONMASTER e on e.PP_DESIGNATIONMASTERID=d.PP_DESIGNATIONMASTERID i"
						+ "nner join mas_district f on b.mas_districtid=f.mas_districtid")
				.append(Condition).append(Condition1)
				.append("group by b.loc_code ,a.rm_officeid,b.officename,b.LOC_CODE,b.mas_districtid,f.di"
						+ "strictname,a.islocked,a.paymonth,a.payyear) x")
				.toString();

		try {
			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.addEntity(ViewAmount.class);
			paidemp = query.list();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return paidemp;
	}

	  /**** Loan Deduction Report ***/
	
	@Override
	public List<?> getEmployeeScheduleList(String monthName, String yearName,
			String pp_ScheduleMasterID, String pp_RegisterMasterID,
			Integer rmOfficeid) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String sql = "";
		if (pp_RegisterMasterID.equals("16")) {
			sql = "select * from  view_payroll_getempscheduler where PP_SCHEDULEMASTERID = "
					+ pp_ScheduleMasterID
					+ " and payMonth = "
					+ monthName
					+ " and payYear = "
					+ yearName
					+ " and rm_OfficeID = "
					+ rmOfficeid
					+ "  order by pp_registermasterid,EMPLOYEENAME";
		} else {
			if (pp_ScheduleMasterID.equals("7")) {
				sql = "select * from  view_payroll_getempscheduler where PP_SCHEDULEMASTERID = "
						+ pp_ScheduleMasterID
						+ " and payMonth = "
						+ monthName
						+ " and payYear = "
						+ yearName
						+ " and rm_OfficeID = "
						+ rmOfficeid
						+ " and pp_RegisterMasterID = "
						+ pp_RegisterMasterID
						+ " and amount!=0 order by EMPLOYEENAME";
			} else {
				sql = "select * from  view_payroll_getempscheduler where PP_SCHEDULEMASTERID = "
						+ pp_ScheduleMasterID
						+ " and payMonth = "
						+ monthName
						+ " and payYear = "
						+ yearName
						+ " and rm_OfficeID = "
						+ rmOfficeid
						+ " and pp_RegisterMasterID = "
						+ pp_RegisterMasterID
						+ " and amount!=0 order by EMPLOYEENAME";
			}
		}
		System.out.println("sql==========================" + sql);
		List<?> schedulerList = null;
		try {

			SQLQuery query = session.createSQLQuery(sql);
			schedulerList = query.addEntity(DeductionLoanScheduleEntity.class)
					.list();
			transaction.commit();

		} catch (Exception e) {
			System.out
					.println("error inside getScheduleHeadList method of dao..."
							+ e);
		}
		finally
		{
			session.close();
			
		}
		return schedulerList;
	}

	@Override
	public List getPayBillDetailForParticularMonthAndYear(String monthName,
			String yearName, Integer rmOfficeid, String sysPaymentmodeid,
			String billType) {
		// TODO Auto-generated method stub
		List payBillDetailList = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		String sqlQuery = "SELECT PP_PAYBILLDETAILID, BILLCLERKNAME, BILLNO, MONTH, YEAR,"
				+ " TO_CHAR(BILLDATE, 'DD-Mon-YYYY') BILLDATE, BILLAMOUNT, BILLTYPE_FLAG, PP_REGISTERMASTERID,"
				+ " (SELECT REGISTERNAME FROM PP_REGISTERMASTER WHERE PP_REGISTERMASTERID=PP_PAYBILLDETAIL.PP_REGISTERMASTERID) REGISTERNAME"
				+ " FROM PP_PAYBILLDETAIL WHERE RM_OFFICEID = '"
				+ rmOfficeid
				+ "' AND MONTH = '"
				+ monthName
				+ "' AND YEAR  = '"
				+ yearName
				+ "'";
		if (billType.equals("A")) {
			sqlQuery += " and BILLTYPE_FLAG='A' ";
		}
		if (billType.equals("P")) {
			sqlQuery += " and BILLTYPE_FLAG='P' ";
		}
		sqlQuery += " ORDER BY BILLDATE";
		try {
			

			SQLQuery query = session.createSQLQuery(sqlQuery);
			payBillDetailList = query.addEntity(AdviceBillBillDetailEntity.class)
					.list();
			transaction.commit();
		
		} catch (Exception e) {
			System.out
					.println("error inside getPayBillDetailForParticularMonthAndYear method of dao."
							+ e);
		}
		finally
		{
			session.close();
			
		}
		return payBillDetailList;
	}

	@Override
	public List <?>getAdviceList(String monthName, String yearName,
			String sysPaymentmodeid, Integer rmOfficeid,
			String[] pp_PayBillDetailID) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List adviceList = null;
		try {
			@SuppressWarnings("unchecked")
			List<SysPaymentmode> paymentModeList = (List<SysPaymentmode>) 
					this.getList(sysPaymentmodeid, "SysPaymentmode.findBySysPaymentmodeid");
			String paymentModeName =null;
			for(SysPaymentmode sePaymentmode :paymentModeList)
			{
				 paymentModeName = sePaymentmode.getPaymentmode();
			}
			String str = paymentModeName;
			String temp = "";
			if (str.substring(0, 4).equalsIgnoreCase("bank")) {
				temp = "order by bankname,branchname,employeename";
			} else {
				temp = "order by employeename";
			}

			
			String inValue = "('-1'";
			for (int i = 0; i < pp_PayBillDetailID.length; i++) {
				inValue += ", '" + pp_PayBillDetailID[i] + "'";
			}
			inValue += ")";

			String sql = "";
			sql = "select  ";
			sql += "	pp_employeemasterid,  ";
			sql += "	employeecode,  ";
			sql += "	max(employeename) employeename,  ";
			sql += "	rm_officeid,  ";
			sql += "	sys_paymentmodeid,  ";
			sql += "	bankaccno,  ";
			sql += "	max(paymonth) paymonth,  ";
			sql += "	max(payyear) payyear,  ";
			sql += "	sum(pp_netpay) pp_netpay,  ";
			sql += "	max(billdate) billdate,  ";
			sql += "	max(branchname) branchname,  ";
			sql += "	max(bankname) bankname  ";
			sql += "from ";
			sql += "( ";
			sql += "	select * from VIEW_PAY_FORBILLADVICEREPORT where PP_PAYBILLDETAILID in "
					+ inValue + " ";
			
			sql += " AND PAYMONTH  = '" + monthName + "' ";
			sql += " AND PAYYEAR  = '" + yearName + "' ";
			
			sql += "	and rm_officeid = " + rmOfficeid
					+ " and sys_paymentmodeid = " + sysPaymentmodeid + " ";
			sql += ")A ";
			sql += "group by pp_employeemasterid, employeecode, rm_officeid, sys_paymentmodeid, bankaccno ";
			sql += "" + temp;

			SQLQuery query = session.createSQLQuery(sql);
			adviceList = query.addEntity(
					BillAdviceReportEntity.class).list();
			transaction.commit();
			
		} catch (Exception e) {
			System.out.println("error inside getAdviceList method of dao..."
					+ e);
		}
		finally
		{
			session.close();
			
		}
		return adviceList;
	}// end method   

}
	

