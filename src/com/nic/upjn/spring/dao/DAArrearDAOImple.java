package com.nic.upjn.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.upjn.spring.entity.PpNoduesdetail;
import com.nic.upjn.spring.entity.ViewDAArrearDetail;
import com.nic.upjn.spring.entity.ViewDAArrearPayDetail;

@Repository("DAArrearDAO")
public class DAArrearDAOImple implements DAArrearDAO{

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public List getList(String wherecondition, String namedQuery) {
		Query query = null;
		List list = null;
		
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			if(wherecondition == null){
				query = session.getNamedQuery(namedQuery);
				list = query.list();
			}
			else{
				query = session.getNamedQuery(namedQuery);
				query.setString(0, wherecondition);
				list = query.list();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		 finally {
				session.close();
			}
		
		return list;
	}

	@Override
	public List getDADetails(String startDate, String endDate) {
		List list = null;

		Session session = null;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

			String sql = "select rm.PP_RULEMASTERID,rm.RULEORDERNO,rm.RULEORDERDATE,rm.DATEOFEFFECT,rm.DUEDATE,rm.GPFDATE,rm.CASHDATE,EXTRACT(month from rm.DUEDATE) as dueMonth,EXTRACT(year from rm.DUEDATE) as dueYear,"+
" rd.PERCENTVALUE from PP_RULEMASTER rm "+
" inner join PP_RULEDETAIL rd on rd.PP_RULEMASTERID=rm.PP_RULEMASTERID "+
" where PP_PAYALWMASTERID='572' and (EXTRACT(YEAR FROM rm.DUEDATE)='"+startDate+"' and extract(MONTH from rm.DUEDATE) "
+ " in ('4','5','6','7','8','9','10','11','12') or "+
" EXTRACT(YEAR FROM rm.DUEDATE)='"+endDate +"' and extract(MONTH from rm.DUEDATE) in ('1','2','3'))" ;
			
			SQLQuery query = session
					.createSQLQuery(sql);
			query.addEntity(ViewDAArrearDetail.class);
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
	public List getpayamount(String employeecode, String startYear, String endYear) {
		List list = null;

		Session session = null;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

			String sql = "select mpt.AMOUNT as basic,vgp.AMOUNT as gradePay,vda.AMOUNT as DA, mp.PAYMONTH,"+
			" (SELECT TO_CHAR(TO_DATE(mp.PAYMONTH,'MM'),'MONTH') FROM DUAL)AS monthname, "+
			" mp.PAYYEAR from PP_MONTHLYPAY_TRAN mpt "+
			" inner join PP_MONTHLYPAY mp on mp.PP_MONTHLYPAYID=mpt.PP_MONTHLYPAYID  "+
			" inner join PP_EMPLOYEEMASTER emp on emp.PP_EMPLOYEEMASTERID=mp.PP_EMPLOYEEMASTERID "+
			" inner join view_gradePay vgp on vgp.PP_MONTHLYPAYID=mp.PP_MONTHLYPAYID "+
			" inner join view_DA vda on vda.PP_MONTHLYPAYID=mp.PP_MONTHLYPAYID "+
			" where mpt.TRAN_TYPEID in '570' and emp.EMPLOYEECODE='"+employeecode+"' and "+
			" (mp.PAYYEAR='"+startYear+"' and mp.PAYMONTH in ('4','5','6','7','8','9','10','11','12') or mp.PAYYEAR='"+endYear+"' and mp.PAYMONTH in ('1','2','3')) order by mp.PAYYEAR";
			
			SQLQuery query = session
					.createSQLQuery(sql);
			query.addEntity(ViewDAArrearPayDetail.class);
			list = query.list();

			t.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}
	
}
