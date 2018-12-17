/******************************** ServiceStatusDaoImplementation Class **************************/

/*==========================================================================
 * Description : ServiceStatusDaoImplementation class contains the database operation for the Service Status. 
 * Date:  
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 */

package com.nic.upjn.spring.dao;

/** Description of required classes that are used **/

import java.sql.CallableStatement;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.upjn.spring.dto.ServiceStatusDTO;
import com.nic.upjn.spring.entity.PpCurrentstatus;
import com.nic.upjn.spring.entity.PpDeputationdetail;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.PpSuspensiondetail;
import com.nic.upjn.spring.entity.PpTerminationdetail;
import com.nic.upjn.spring.entity.ViewDeputationlist;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;
import com.nic.upjn.spring.entity.ViewSuspensiondetaillist;

/** Implementation of database operations for Service Status purpose. **/
@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
@Repository("serviceStatusDao")
public class ServiceStatusDaoImplementation implements ServiceStatusDao {

	@Autowired
	private SessionFactory sessionFactory;

	/** Populating Combo when Condition DataType is Integer **/
	@Override
	public List getComboList(int where_condition, String namedQuery) {

		Query query = null;
		List<Object> list = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			if (where_condition != 0) {
				query = session.getNamedQuery(namedQuery);
				query.setInteger(0, where_condition);
				list = (List<Object>) query.list();
			} else {
				query = session.getNamedQuery(namedQuery);
				list = (List<Object>) query.list();
			}
			tx.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;

	}

	/** Populating Combo when Condition DataType is String **/
	@Override
	public List getComboList(String where_condition, String namedQuery) {

		Query query = null;
		List<Object> list = null;
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			if (where_condition != null) {
				query = session.getNamedQuery(namedQuery);
				query.setString(0, where_condition);
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

	/** Populating Combo when Condition DataType is Integer Array **/
	@Override
	public List<?> getComboList(int[] where_condtion, String namedQuery) {
		Query query = null;
		List list = null;

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			if (where_condtion != null) {
				query = session.getNamedQuery(namedQuery);

				for (int i = 0; i < where_condtion.length; i++) {
					query.setInteger(i, where_condtion[i]);

				}

				list = (List<Object>) query.list();
			}
			tx.commit();
		}

		catch (Exception e) {

		} finally {
			session.close();
		}

		return list;

	}

	/** method returns suspension Employee Search List **/

	@Override
	public List<?> suspensionEmployeeSearchList(String SQL) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
			List<?> employeeSearchList = null;
			
			try {
				SQLQuery query = session.createSQLQuery(SQL);
				query.addEntity(ViewEmployeeSearch.class);
				employeeSearchList = query.list();
				
				tx.commit();

			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				session.close();
			}
			return employeeSearchList;
		}


	/** Execute Procedure ProcPpValidateEmpGetInfo and returns Employee Info **/

	@Override
	public String[] ProcPpValidateEmpGetInfo(String employeecode, String Rm_OfficeId, String root, String method_Type) {

		String[] employeeInfo = new String[3];
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int result;

		try {
			
			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection.prepareCall("{call PROC_PP_VALIDATEEMPGETINFO(?,?,?,?,?,?,?,?)}");

			stmt.setString(1, employeecode);
			stmt.setString(2, Rm_OfficeId );
			stmt.setString(3, root);
			stmt.setString(4, method_Type);
			stmt.registerOutParameter(5, Types.VARCHAR);
			stmt.registerOutParameter(6, Types.VARCHAR);
			stmt.registerOutParameter(7, Types.VARCHAR);
			stmt.registerOutParameter(8, Types.VARCHAR);

			result = stmt.executeUpdate();
			String ppEmployeemasterid = stmt.getString(6);
			String employeename = stmt.getString(7);
			String designation = stmt.getString(8);

			employeeInfo[0] = employeename;
			employeeInfo[1] = designation;
			employeeInfo[2] = ppEmployeemasterid;
			
			tx.commit();
		}

		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
		}
		return employeeInfo;

	}

	/** Execute Procedure For AddSuspensionDetail using HIBERNATE **/
	public int executeProcedureForAddSuspensionDetail(ServiceStatusDTO serviceStatusDTO) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		SessionImplementor sessionImplementor = (SessionImplementor) session;
		java.sql.Connection connection = sessionImplementor.connection();

		int result = 0;
		String output = null;

		try {

			CallableStatement stmt = connection.prepareCall("{call PROC_PP_ADDSUSPENSIONDETAIL(?,?,?,?,?,?,?,?,?,?,?)}");
			stmt.setString(1, serviceStatusDTO.getPpEmployeemasterid());
			stmt.setString(2, serviceStatusDTO.getSuspensionordno());
			stmt.setString(3, serviceStatusDTO.getSuspensionorddate());
			stmt.setString(4, serviceStatusDTO.getOrderauthname());
			stmt.setString(5, serviceStatusDTO.getOrderauthdesig());
			stmt.setString(6, serviceStatusDTO.getEffectivedate());
			stmt.setString(7, serviceStatusDTO.getEventofficeid());
			stmt.setString(8, serviceStatusDTO.getReasonForSuspension());
			stmt.setString(9,serviceStatusDTO.getReportingdate());
			stmt.setString(10,serviceStatusDTO.getRelievingoffice());
			stmt.registerOutParameter(11, Types.VARCHAR);

			result = stmt.executeUpdate();
			output = stmt.getString(11);
			System.out.print(output + "---------@@@@@@@@@@@@@");

			tx.commit();
		}

		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
		}
		return Integer.parseInt(output);

	}

	/** Update Suspension-detail Information using HIBERNATE Criteria **/
	public void updateInformation(Object entity) {

		Session session = sessionFactory.openSession();

		if (entity instanceof PpSuspensiondetail) {
			PpSuspensiondetail ppSuspensiondetail = (PpSuspensiondetail) entity;
			ppSuspensiondetail.setIsreinstate("0");
			ppSuspensiondetail.setIsterminated("0");
			
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.createCriteria(ppSuspensiondetail.getPpSuspensiondetailid() + "");
				session.update(ppSuspensiondetail);
				session.flush();

				tx.commit();
			}

			catch (Exception e) {
				System.out.println(e);
			}
			finally {
				session.close();
			}
		}
	}

	/** Executing Procedure For AddTerminationDetail **/
	public int executeProcedureForAddTerminationDetail(ServiceStatusDTO serviceStatusDTO) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		String PpEmployeemasterid = serviceStatusDTO.getPpEmployeemasterid();
		String Terminationordno = serviceStatusDTO.getTerminationordno();
		String Terminationorddate = serviceStatusDTO.getTerminationorddate();
		String Orderauthname = serviceStatusDTO.getOrderauthname();
		String Orderauthdesig = serviceStatusDTO.getOrderauthdesig();
		String Effectivedate = serviceStatusDTO.getEffectivedate();
		String Eventofficeid = serviceStatusDTO.getEventofficeid();
		String Reasonfortermination = serviceStatusDTO.getReasonfortermination();

		int result = 0;

		try {

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection.prepareCall("{call PROC_PP_ADDTERMINATIONDETAIL(?,?,?,?,?,?,?,?,?)}");

			stmt.setString(1, PpEmployeemasterid);
			stmt.setString(2, Terminationordno);
			stmt.setString(3, Terminationorddate);
			stmt.setString(4, Orderauthname);
			stmt.setString(5, Orderauthdesig);
			stmt.setString(6, Effectivedate);
			stmt.setString(7, Eventofficeid);
			stmt.setString(8, Reasonfortermination);

			stmt.registerOutParameter(9, Types.VARCHAR);

			result = stmt.executeUpdate();
			String output = stmt.getString(9);
			System.out.print(output + "-------@@@@@@@@@@@@@@@@@@");

			tx.commit();
		}

		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
		}
		return result;
	}

	/** Executing Procedure For AddTerminationDetail **/
	public int executeProcedureForReinstateSuspentionDetails(ServiceStatusDTO serviceStatusDTO) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int result = 0;

		try {

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection.prepareCall("{call PROC_PP_ADDREINSTATEDETAIL(?,?,?,?,?,?,?)}");

			stmt.setString(1, serviceStatusDTO.getPpEmployeemasterid());
			stmt.setString(2, serviceStatusDTO.getReInstateOrderNo());
			stmt.setString(3, serviceStatusDTO.getRm_OfficeID());
			stmt.setString(4, serviceStatusDTO.getEventofficeid());
			stmt.setString(5, serviceStatusDTO.getReinstateSuspensionOrddate());
			stmt.setString(6, serviceStatusDTO.getReinstateeffectdate()+"");

			stmt.registerOutParameter(7, Types.VARCHAR);

			result = stmt.executeUpdate();
			String output = stmt.getString(7);
			System.out.print(output + "@@@@@@@@@@@@@@@@@@@@@@@@@@@");

			tx.commit();
		}

		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
		}
		return result;

	}

	/** Executing Procedure For ProcedureForAddDeputationDetail **/
	public int executeProcedureForAddDeputationDetail(ServiceStatusDTO serviceStatusDTO) {
		String[] employeeInfo = new String[3];
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		int result = 0;

		try {

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection.prepareCall("{call PROC_PP_ADDDEPUTATIONDETAIL(?,?,?,?,?,?,?,?,?,?)}");

			stmt.setString(1, serviceStatusDTO.getPpEmployeemasterid());
			stmt.setString(2, serviceStatusDTO.getDeputationorderno());
			stmt.setString(3, serviceStatusDTO.getDeputationorderdate());
			stmt.setString(4, serviceStatusDTO.getOfficefromid());
			stmt.setString(5, serviceStatusDTO.getTargetoffice());
			stmt.setString(6, serviceStatusDTO.getRelieveorderno());
			stmt.setString(7, serviceStatusDTO.getRelieveorderdate());
			stmt.setString(8, serviceStatusDTO.getRelievedate());
			stmt.setString(9, serviceStatusDTO.getRelieveanfn());
			stmt.registerOutParameter(10, Types.VARCHAR);

			result = stmt.executeUpdate();
			String output = stmt.getString(10);
			System.out.print(output + "@@@@@@@@@@@@@@@@@@@@@@@@@@@");

			tx.commit();
		}

		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
		}
		return result;
	}

	/**
	 * Executing Procedure For AddResumeAfterDeputationRecord using
	 * CllableSatement
	 **/
	public int executeProcedureForAddResumeAfterDeputationRecord(ServiceStatusDTO serviceStatusDTO) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int result = 0;
		String output = null;

		try {

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection.prepareCall("{call PROC_PP_RESUMEAFTERDEP(?,?,?,?)}");

			stmt.setString(1, serviceStatusDTO.getPpDeputationdetailid());
			stmt.setString(2, serviceStatusDTO.getOrderNumberForJoinUpjn());
			stmt.setString(3, serviceStatusDTO.getDateOfResuming());

			stmt.registerOutParameter(4, Types.VARCHAR);

			result = stmt.executeUpdate();
			output = stmt.getString(4);
			System.out.print(output + "@@@@@@@@@@@@@@@@@@@@@@@@@@@");

			tx.commit();
		}

		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
		}
		return Integer.parseInt(output);

	}

	/**
	 * Executing Procedure PROC_PP_ADDRELIEVEFRMSERVICE using CllableSatement
	 **/
	public int executeProcedureForaddRelieveFromService(ServiceStatusDTO serviceStatusDTO) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int result = 0;
		String output = null;

		try {

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection
					.prepareCall("{call PROC_PP_ADDRELIEVEFRMSERVICE(?,?,?,?,?,?,?,?,?,?,?)}");

			stmt.setString(1, serviceStatusDTO.getPpEmployeemasterid());
			stmt.setString(2, serviceStatusDTO.getSUBPHASENAME());
			stmt.setString(3, serviceStatusDTO.getRelieveorderno());
			stmt.setString(4, serviceStatusDTO.getRelieveorderdate());
			stmt.setString(5, serviceStatusDTO.getDateOfEffect());
			stmt.setString(6, serviceStatusDTO.getRelieveanfn());
			stmt.setString(7, serviceStatusDTO.getPpNoduesdetailid());
			stmt.setString(8, "314");
			stmt.setString(9, serviceStatusDTO.getReferenceOfRelieve());
			stmt.setString(10, serviceStatusDTO.getDateOfReference());

			stmt.registerOutParameter(11, Types.VARCHAR);

			result = stmt.executeUpdate();
			output = stmt.getString(11);
			System.out.print(output + "@@@@@@@@@@@@@@@@@@@@@@@@@@@");

			tx.commit();
		}

		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
		}
		return Integer.parseInt(output);
	}

	/**
	 * Executing Procedure PROC_PP_DELSUSPENSIONDETAIL for delete
	 * SuspensionDetail using CllableSatement
	 **/
	public int executeProcedureFordeleteSuspensionDetail(ServiceStatusDTO serviceStatusDTO) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String output = null;

		try {

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection.prepareCall("{call PROC_PP_DELSUSPENSIONDETAIL(?,?,?)}");

			stmt.setString(1, serviceStatusDTO.getPpSuspensiondetailid() + "");
			stmt.setString(2, serviceStatusDTO.getPpEmployeemasterid());
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.executeUpdate();
			output = stmt.getString(3);
			
			tx.commit();

		}

		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
		}
		return Integer.parseInt(output);
	}

	/** Update updatereliveDeputationRecord using HIBERNATE Criteria **/
	
	public void updatereliveDeputationRecord(Object entity) {
		Session session = sessionFactory.openSession();

		if (entity instanceof ViewDeputationlist) {
			ViewDeputationlist viewDeputationlist = (ViewDeputationlist) entity;
			PpDeputationdetail ppDeputationdetail = new PpDeputationdetail();
			BeanUtils.copyProperties(viewDeputationlist, ppDeputationdetail);
			ppDeputationdetail.setNextpostingid(new String(""));
			ppDeputationdetail.setIsresumed('0');
			ppDeputationdetail.setPpEmployeemasterid(viewDeputationlist.getPpEmployeemasterid());

			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.createCriteria(ppDeputationdetail.getPpDeputationdetailid() + "");
				session.update(ppDeputationdetail);
				session.flush();

				tx.commit();
			}
			catch (Exception e) {
				System.out.println(e);
			}
			finally {
				session.close();
			}
		}
	}

	@Override
	public boolean insertReinstateTermDetail(PpTerminationdetail ppterminationdetail, PpCurrentstatus ppCurrentstatus,PpEmployeemaster ppEmployeemaster) {
			
		boolean result = false;
		Session session = sessionFactory.openSession();
		
		
		try{
			Transaction tx = session.beginTransaction();
			
			PpTerminationdetail pp = (PpTerminationdetail)session.get(PpTerminationdetail.class, ppterminationdetail.getPpTerminationdetailid());
			pp.setReinstateeffectdate(pp.getReinstateeffectdate());
			pp.setPpTerminationdetailid(pp.getPpTerminationdetailid());
			pp.setIsreinstate("1");
			pp.setReinstateorderdetail(pp.getReinstateorderdetail());
			session.update(pp); 
			
			Long id = null;
			
			Criteria cr = session.createCriteria(PpCurrentstatus.class);
			cr.add(Restrictions.eq("ppEmployeemasterid", ppCurrentstatus.getPpEmployeemasterid()));
			List results = cr.list();
			
			Iterator<PpCurrentstatus> itr = results.iterator();
			while(itr.hasNext()){
				PpCurrentstatus a = itr.next();
				id = a.getPpCurrentstatusid();		
			}
			
			PpCurrentstatus pCurrentstatus = (PpCurrentstatus)session.get(PpCurrentstatus.class, id);
			
			pCurrentstatus.setPpExitdetailid(null);
			
			System.out.println("pp exit detail id --- "+pCurrentstatus.getPpExitdetailid());
			
		    session.update(pCurrentstatus);
		    
		    PpEmployeemaster employeemaster = (PpEmployeemaster)session.get(PpEmployeemaster.class, ppEmployeemaster.getPpEmployeemasterid());
		    
		    Character id1 = '1';
		    employeemaster.setIsfunctioning(id1);	 
		    
		    System.out.println(employeemaster.getIsfunctioning()+"--");
		    session.update(employeemaster);
		    
		    tx.commit();
		    result = true;
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		 
		return result;
	}

	@Override
	public boolean updateterminationdetails(PpTerminationdetail ppTerminationdetail) {
		boolean result = false;
		Session session = sessionFactory.openSession();
		try{
			Transaction tx = session.beginTransaction();

			session.createCriteria(ppTerminationdetail.getPpTerminationdetailid()+"");
			session.update(ppTerminationdetail);
			session.flush();

			tx.commit();
		 result = true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return result;
	}

	@Override
	public boolean deleteterminationdetails(String ppTerminationdetailid, String ppEmployeemasterid) {
		boolean result = false;
		String output = null;
		Session session = sessionFactory.openSession();
		try{
			Transaction tx = session.beginTransaction();

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection.prepareCall("{call PROC_PP_DELTERMINATIONDETAIL(?,?,?)}");

			stmt.setString(1, ppTerminationdetailid);
			stmt.setString(2, ppEmployeemasterid);
			stmt.registerOutParameter(3, Types.VARCHAR);

			result = stmt.execute();
			output = stmt.getString(3);
			System.out.print(output + "---This is output of delete termination procedure ");

			tx.commit();
		 result = true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return result;
	}

	@Override
	public boolean execProc_Dele_Deputation(String ppDeputationdetailid, String ppEmployeemasterid,
			String ppNoduesdetailid) {
		
		boolean result = false;
		String output = null;
		Session session = sessionFactory.openSession();
		try{
			Transaction tx = session.beginTransaction();

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection.prepareCall("{call PROC_PP_DELDEPUTATIONDETAIL(?,?,?,?)}");

			stmt.setString(1, ppDeputationdetailid);
			stmt.setString(2, ppEmployeemasterid);
			stmt.setString(3, ppNoduesdetailid);
			stmt.registerOutParameter(4, Types.VARCHAR);

			result = stmt.execute();
			output = stmt.getString(4);
			System.out.print(output + "---This is output of delete deputation procedure ");

			tx.commit();
		 result = true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return result;

	}	
	
}
