package com.nic.upjn.spring.dao;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.upjn.spring.entity.PpRegistermaster;
import com.nic.upjn.spring.entity.PpSectionmaster;
import com.nic.upjn.spring.entity.ViewListForAssignRegister;
import com.nic.upjn.spring.entity.ViewSearchResult;

@Repository("ManagePayBillDAO")
public class ManagePayBillDAOImple implements ManagePayBillDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ViewListForAssignRegister> getEmpList(int rmOfficeID,
			String ppSectionMasterID) {
		Session session = null;
		List<ViewListForAssignRegister> list = null;
		try{
			session = sessionFactory.openSession();
			Criteria ctr = session.createCriteria(ViewListForAssignRegister.class);
			ctr.add(Restrictions.eq("ppSectionMasterid", Integer.parseInt(ppSectionMasterID)));
			ctr.add(Restrictions.eq("rmOfficeid", rmOfficeID));
			list = ctr.list();
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PpRegistermaster> getRegisterList() {
		
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from PpRegistermaster order by ppRegistermasterid");
			List<PpRegistermaster> list = q.list();
			System.out.println(list.size());
			tx.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ViewSearchResult> getEmpListForAddSection(String rmOfficeID,
			String predicate) {
		Session session = null;
		List<ViewSearchResult> list = null;
		try{
			session = sessionFactory.openSession();
			String sql = "SELECT EMP.PP_EMPLOYEEMASTERID, EMP.EMPLOYEECODE,EMP.FIRSTNAME,EMP.LASTNAME,EMP.RM_OFFICEID,EMP.FIRSTNAME || ' ' ||  "
					+ "EMP.MIDDLENAME || ' ' || EMP.LASTNAME AS EMPLOYEENAME, epm.pp_RegisterMasterID, epm.pp_SectionMasterID, pdm.designation "
					+ "FROM PP_EMPLOYEEMASTER EMP inner join pp_EmployeePayDetail epm on EMP.pp_EmployeeMasterID = epm.pp_EmployeeMasterID "
					+ "inner join pp_DesignationMaster pdm on pdm.pp_DesignationMasterID = EMP.pp_DesignationMasterID where rm_officeID='" + rmOfficeID +
					"' and EMP.isFunctioning = '1' and epm.pp_employeemasterid not in (select pp_EmployeeMasterID from pp_employeepaydetail "
					+ "where pp_sectionMasterID in (select pp_sectionmasterid from pp_sectionMaster)) " + predicate + " order by employeeName";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewSearchResult.class);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public List<PpSectionmaster> getList(Integer rmOfficeid, String sectionname, String string) {
		Query query = null;
		List<PpSectionmaster> list = null;

		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();

		

		if (rmOfficeid != null) {
			query = session.getNamedQuery(string);
			query.setString(0, rmOfficeid+"");
			query.setString(1, sectionname);
			list = (List<PpSectionmaster>) query.list();
		}

		else {

			query = session.getNamedQuery(string);
			list = (List<PpSectionmaster>) query.list();
		}

		// session.getTransaction().commit();
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}

		session.close();

		return list;

	}

	@Override
	public boolean setSectionID(String ppEmployeeMasterID, String sectionID) {
		boolean isComplete = false;
		String x = null;
		Session session = sessionFactory.openSession();
		
		try{
			String[] inParam =new String[2];
			inParam[0] = ppEmployeeMasterID.substring(0,ppEmployeeMasterID.lastIndexOf("|"));
			inParam[1] = sectionID;
			
			SessionImplementor sessionImplementor = (SessionImplementor) session;
			
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection
					.prepareCall("{call PROC_PP_CHANGE_EMP_SECTION(?,?,?)}");
			stmt.setString(1, inParam[0]);
			stmt.setString(2, inParam[1]);
			stmt.registerOutParameter(3, Types.VARCHAR);
			isComplete = stmt.execute();
			x = stmt.getString(3);
			System.out.println(x);
			isComplete = true;
			System.out.println(isComplete);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
			
		return isComplete;
	}
	

}
