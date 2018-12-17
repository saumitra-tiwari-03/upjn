package com.nic.upjn.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.upjn.spring.entity.AdvRecDetailsEntity;
import com.nic.upjn.spring.entity.EmployeeDetailEntity;
import com.nic.upjn.spring.entity.GPFLedgerEntity;
import com.nic.upjn.spring.entity.GPFOpeningBalanceEntity;
import com.nic.upjn.spring.entity.GPFValuesEntity;
import com.nic.upjn.spring.entity.GPFWithdrawalEntity;
import com.nic.upjn.spring.entity.GpfArrearEntity;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

@Repository("GPFLedgerArrearDAO")
public class GPFLedgerArrearDAOImple implements GPFLedgerArrearDAO {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public List getList(String condition, String namedQuery) {
		Query query = null;
		List list = null;

		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			if (condition == null) {
				query = session.getNamedQuery(namedQuery);
				list = query.list();
			} else {
				query = session.getNamedQuery(namedQuery);
				query.setString(0, condition);
				list = query.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List getgpfvalue(String pp_EmployeemasterID, String startYear, String endYear) {
		List<?> list = null;

		Session session = null;
		Query query = null;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

			String sql = "select nvl(mpt.amount,0) as gpfAmount,"
					+ " SUBSTR((SELECT TO_CHAR(TO_DATE(mp.PAYMONTH, 'MM'), 'MONTH')  FROM DUAL),1,3)AS monthname, "
					+ " mp.PAYMONTH,mp.PAYYEAR,ROWNUM " + " from PP_MONTHLYPAY_TRAN mpt "
					+ " inner join PP_MONTHLYPAY mp on mp.PP_MONTHLYPAYID=mpt.PP_MONTHLYPAYID"
					+ " where ((mp.PAYMONTH in ('4','5','6','7','8','9','10','11','12') and mp.PAYYEAR='" + startYear
					+ "') or (mp.PAYMONTH in ('1','2','3')" + "and mp.PAYYEAR='" + endYear
					+ "')) and mp.PP_EMPLOYEEMASTERID='" + pp_EmployeemasterID + "' and mpt.TRAN_TYPEID='1' ORDER BY mp.PAYYEAR,mp.PAYMONTH";

			query = session.createSQLQuery(sql);

			((SQLQuery) query).addEntity(GPFValuesEntity.class);
			list = query.list();

			t.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List getarrearamount(String pp_EmployeemasterID, String month, String year) {
		List list = null;

		Session session = null;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

			Query query = session.createSQLQuery("select * from GPF_ARREAR where PP_EMPLOYEEMASTERID='"
					+ pp_EmployeemasterID + "' and ARREAR_MONTH='" + month + "' and ARREAR_YEAR='" + year + "'");

			((SQLQuery) query).addEntity(GpfArrearEntity.class);
			list = query.list();

			t.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List getwithdrawals(String pp_EmployeemasterID, String month, String year) {
		List list = null;

		Session session = null;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

			Query query = session.createSQLQuery("select * from GPF_WITHDRAWAL where PP_EMPLOYEEMASTERID='"
					+ pp_EmployeemasterID + "' and MONTH='" + month + "' and YEAR='" + year + "'");

			((SQLQuery) query).addEntity(GPFWithdrawalEntity.class);
			list = query.list();

			t.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List getinterestrate(String month, String year) {
		List interestrate = null;

		Session session = null;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

			Query query = session.createSQLQuery(
					"select distinct(rd.PERCENTVALUE) from PP_RULEDETAIL rd inner join PP_RULEMASTER rm on rm.PP_RULEMASTERID=rd.PP_RULEMASTERID"
							+ " inner join PP_PAYALWMASTER alwmas on alwmas.PP_PAYALWMASTERID=rm.PP_PAYALWMASTERID"
							+ " inner join PP_PAYALWHEAD alwhd on alwhd.PAYALWHEADID=alwmas.PAYALWHEADID"
							+ " inner join PP_MONTHLYPAY mp on mp.PAYYEAR=extract(year from rm.DATEOFEFFECT) and mp.PAYMONTH=EXTRACT(MONTH from rm.DATEOFEFFECT)"
							+ " where rd.PP_RULEMASTERID in (select PP_RULEMASTERID from PP_RULEMASTER "
							+ " where PP_PAYALWMASTERID=(select PP_PAYALWMASTERID from PP_PAYALWMASTER where PAYALWHEADID = '49')) and mp.PAYMONTH='"
							+ month + "' and mp.PAYYEAR='" + year + "'");

			interestrate = query.list();

			t.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return interestrate;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getadvrec(String pp_EmployeemasterID, String month, String year) {

		List list = null;
		Session session = null;

		try {
			session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();

			Query query = session.createSQLQuery(
					"SELECT rownum,mp.payyear,mp.PAYMONTH, mp.PP_MONTHLYPAYID, nvl(mpt.amount,0) as gpf_adv_amount, mpt.INSTALLMENT_NO,ld.PA_NOOFINSTALLMENTS,"
							+ " ld.LOANAMOUNT from PP_MONTHLYPAY_TRAN mpt inner join PP_MONTHLYPAY mp on mpt.PP_MONTHLYPAYID=mp.PP_MONTHLYPAYID"
							+ " inner join PP_LOANDETAIL ld on ld.PP_EMPLOYEEMASTERID=mp.PP_EMPLOYEEMASTERID where mp.PP_EMPLOYEEMASTERID='"
							+ pp_EmployeemasterID + "'" + " and mpt.TRAN_TYPEID='12' and (mp.PAYYEAR='" + year
							+ "' and mp.PAYMONTH ='" + month + "')");

			((SQLQuery) query).addEntity(AdvRecDetailsEntity.class);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List gettempwithdrawal(String pp_EmployeemasterID, String month, String year) {
		List list = null;
		Session session = null;

		try {
			session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();

			Query query = session.createSQLQuery("select LOANAMOUNT from PP_LOANDETAIL" + " where PP_EMPLOYEEMASTERID='"
					+ pp_EmployeemasterID + "' and EXTRACT(month from SANCTIONDATE)='" + month
					+ "' and EXTRACT(year from SANCTIONDATE)='" + year + "'");

			list = query.list();
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public int insertintoGPFledger(GPFLedgerEntity gpfLedgerEntity) {
		Session session = null;
		int result = 0;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

			session.saveOrUpdate(gpfLedgerEntity);
			t.commit();
			result = 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List getgpfledgerreport(String ppemployeemasterid, String startyear, String endyear) {
		List list = null;
		Session session = null;

		try {
			session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();

			Query query = session.createSQLQuery(
					"select YEAR,TOTALDEPOSIT,TEMP_WITHDRAWAL,SALARY,PP_GPFLEDGERID,PP_EMPLOYEEMASTERID,nvl(PA_NOOFINSTALLMENTS,'-') as PA_NOOFINSTALLMENTS,MONTHNAME,MONTH,INTEREST_RATE,nvl(INSTL_NO,'-') as INSTL_NO,FINAL_WITHDRAWAL,ARREAR,AMOUNT from GPFLEDGER where PP_EMPLOYEEMASTERID='"
							+ ppemployeemasterid + "' and ((YEAR='" + startyear
							+ "' and MONTH in (4,5,6,7,8,9,10,11,12)) or (YEAR='" + endyear
							+ "' and MONTH in (1,2,3))) ORDER BY PP_GPFLEDGERID");

			((SQLQuery) query).addEntity(GPFLedgerEntity.class);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List getemployeedetails(String employeecode) {
		List list = null;
		Session session = null;

		try {
			session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();

			Query query = session.createSQLQuery(
					"select emp.PP_EMPLOYEEMASTERID,emp.FIRSTNAME||' '||emp.MIDDLENAME||' '||emp.LASTNAME as employeename,dm.DESIGNATION,ed.GPFACNO,rm.OFFICENAME"
							+ " from PP_EMPLOYEEMASTER emp"
							+ " inner join PP_DESIGNATIONMASTER dm on dm.PP_DESIGNATIONMASTERID=emp.PP_DESIGNATIONMASTERID"
							+ " inner join RM_OFFICE rm on rm.RM_OFFICEID=emp.RM_OFFICEID"
							+ " inner join PP_EMPLOYEEDETAIL ed on ed.PP_EMPLOYEEMASTERID=emp.PP_EMPLOYEEMASTERID"
							+ " where emp.EMPLOYEECODE='" + employeecode + "'");

			((SQLQuery) query).addEntity(EmployeeDetailEntity.class);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List getopeningbalance(String ppemployeemasterid, String year) {
		List list = null;
		Session session = null;

		try {
			session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();

			Query query = session.createSQLQuery("select * from GPF_OPENINGBALANCE where PP_EMPLOYEEMASTERID='"
					+ ppemployeemasterid + "' and FINANCIAL_YEAR='" + year + "'");

			((SQLQuery) query).addEntity(GPFOpeningBalanceEntity.class);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public int insertopeningbalance(GPFOpeningBalanceEntity entity) {
		Session session = null;
		int result = 0;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

			session.saveOrUpdate(entity);
			t.commit();
			result = 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int insertArrear(GpfArrearEntity entity) {
		Session session = null;
		int result = 0;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

			session.saveOrUpdate(entity);
			t.commit();
			result = 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int insertwithdrawal(GPFWithdrawalEntity entity) {
		Session session = null;
		int result = 0;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

			session.saveOrUpdate(entity);
			t.commit();
			result = 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int updatearrearingpfledger(long pP_EMPLOYEEMASTERID, long month, long year,long arrearamount) {
		Session session = null;
		int result = 0;
		Query query = null;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

		    String sql = "update GPFLEDGER set ARREAR='"+arrearamount+"'  where PP_EMPLOYEEMASTERID='"+pP_EMPLOYEEMASTERID+"' and MONTH='"+month+"' and YEAR ='"+year+"'";
		    
		 query = session.createSQLQuery(sql);
		 
		result = query.executeUpdate();
			
			t.commit();
			
			System.out.println(result);
			//result = 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int updatewithdrawalingpfledger(long pp_EMPLOYEEMASTERID, long month, long year, long amount) {
		Session session = null;
		int result = 0;
		Query query = null;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

		    String sql = "update GPFLEDGER set FINAL_WITHDRAWAL='"+amount+"' where PP_EMPLOYEEMASTERID='"+pp_EMPLOYEEMASTERID+"' and MONTH='"+month+"' and YEAR ='"+year+"'";
		    
		 query = session.createSQLQuery(sql);
		 
		result = query.executeUpdate();
			
			t.commit();
			
			System.out.println(result);
			//result = 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

}
