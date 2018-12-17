package com.nic.upjn.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.upjn.spring.entity.ViewOfficeWiseEmpReport;
import com.nic.upjn.spring.entity.ViewRetEmpReport;
import com.nic.upjn.spring.entity.ViewRptOndeputationemp;
import com.nic.upjn.spring.entity.ViewRptSuperannemp;
@Repository("personalReportDAO")
public class PersonalReportDAOimple implements PersonalReportDAO {
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List getList(String where_condtion, String namedQuery) {
		Query query = null;
		List<Object> list = null;

		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction();

			if (where_condtion != null) {
				query = session.getNamedQuery(namedQuery);
				query.setString(0, where_condtion);
				list = (List<Object>) query.list();
			}

			else {

				query = session.getNamedQuery(namedQuery);
				list = (List<Object>) query.list();
			}

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			session.close();
		}

		return list;
	}


	@Override
	public List getReportData(String sql) {
		List results = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewOfficeWiseEmpReport.class);
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
	public List getRetEmpList(String sql) {
		List results = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewRetEmpReport.class);
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
	public List getEmployeeList_toBeSuperAnnutated(String month, String year, String employeementcategory) {
		
		List employeeList=null;
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			String sql="select * FROM VIEW_RPT_SuperAnnEmp where MAS_EMPLOYMENTSUBTYPEID = '"+employeementcategory+
									"' AND (EXTRACT(MONTH from RETIREMENTDATE) = '"+month+"' AND EXTRACT(YEAR from RETIREMENTDATE) = '"+year+"')";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewRptSuperannemp.class);
			employeeList = query.list();
			transaction.commit();
			
			System.out.println("employeeList"+employeeList.size());
		}catch(Exception e){
			System.out.println("error inside getEmployeeList_toBeSuperAnnutated method of dao..."+e);
		}
		finally{
			session.close();
		}
		return employeeList;
	}


	@Override
	public List getEmpOnDeputation(String asondate, String employeementcategory, String noofdays) {
		List employeeList=null;
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			String sql="select employeeName,employeeCode,designation,employmentType,EmploymentSubType,"+
					"TO_CHAR(effectiveDate,'DD/MM/YYYY') as effectiveDate,TARGETOFFICE,RELIEVEORDERNO,TO_CHAR(RELIEVEORDERDATE,'DD/MM/YYYY') as RELIEVEORDERDATE,DeputationORDERNO,TO_CHAR(DeputationORDERDATE,'DD/MM/YYYY') as DeputationORDERDATE,lastOffice as fromOfficeName, "+
					" TO_DATE('"+asondate+"','DD-MM-YYYY')-effectiveDate as daysFromRel "+	
					" FROM VIEW_RPT_ONDEPUTATIONEMP where MAS_EMPLOYMENTSUBTYPEID="+employeementcategory+
					" AND (TO_DATE('"+asondate+"','DD-MM-YYYY')-effectiveDate)>="+noofdays;
			
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewRptOndeputationemp.class);
			employeeList = query.list();
			transaction.commit();
			
			System.out.println("employeeList"+employeeList.size());
		}catch(Exception e){
			System.out.println("error inside getEmployeeList_toBeSuperAnnutated method of dao..."+e);
		}
		finally
		{
			session.close();
		}
		return employeeList;
	}




}
