/******************************** EmployeeAppointmentDaoImple Class **************************/

/*==========================================================================
 * Description : EmployeeAppointmentDaoImple class contains the database operation for the Employee Appointment. 
 * Date:  
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 */

package com.nic.upjn.spring.dao;

/** Description of required classes that are used **/
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List; // using for collection the objects in the form of list
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory; //SessionFactory is responsible for making the connection and also used for created the Session for the execution of Oracle query  
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired; //@Autowired annotation automatically set the object from spring_servelt.xml to class label   
import org.springframework.stereotype.Repository; // This is data access layer of application which used to get data from database. i.e. all the Database related operations are done by repository.
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.Connection;
import com.nic.upjn.spring.dto.EmployeePostingDTO;
import com.nic.upjn.spring.entity.PpDeputationdetail;
import com.nic.upjn.spring.entity.PpEmployeeappointmentdetail;
import com.nic.upjn.spring.entity.PpEmployeedetail;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.PpEmployeepaydetail;
import com.nic.upjn.spring.entity.PpEmployeepersonaldetail;
import com.nic.upjn.spring.entity.PpPostingdetail;
import com.nic.upjn.spring.entity.PpTerminationdetail;
import com.nic.upjn.spring.entity.SysSubservicephasemaster;
import com.nic.upjn.spring.entity.ViewDeputationlist;

/** Implementation of database operations for Employee Appointment purpose. * */
@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
@Repository("employeeAppointmentDao")
public class EmployeeAppointmentDaoImple implements EmployeeAppointmentDao {

	@Autowired
	private SessionFactory sessionFactory;

	Long id;

	/**
	 * Method used to add new employee into database using HIBERNATE
	 **/
	public void addEmployeeAppointment(Object object, Long long1, String string) {

		Session session = null;
		if (long1 != null && string != null) {
			try {
				if (object instanceof PpEmployeemaster) {
					 session = sessionFactory.getCurrentSession();

					session.createCriteria("ppEmployeemasterid", long1 + "");
					session.createCriteria("employeecode", string);

					session.update(object);

					PpEmployeemaster ppEmployeemaster = (PpEmployeemaster) object;
					// id = id + 1;*/
				}

				else if (object instanceof PpEmployeepersonaldetail) {

					PpEmployeepersonaldetail ppEmployeepersonaldetail = (PpEmployeepersonaldetail) object;
				    session = sessionFactory.getCurrentSession();
					ppEmployeepersonaldetail.setPpEmployeemasterid(long1);

					Query query = session.createSQLQuery("update Pp_Employeepersonaldetail set fathername = :fathername"
							+ " where PP_EMPLOYEEMASTERID = :PP_EMPLOYEEMASTERID");
					query.setParameter("PP_EMPLOYEEMASTERID", long1);
					query.setParameter("fathername", ppEmployeepersonaldetail.getFathername());

					int result = query.executeUpdate();

				}

				else if (object instanceof PpEmployeedetail) {
					PpEmployeedetail ppEmployeedetail = (PpEmployeedetail) object;
					ppEmployeedetail.setPpEmployeemasterid(id);
					ppEmployeedetail.setIsconfirm('0');
					ppEmployeedetail.setIspermanent('0');
				    session = sessionFactory.getCurrentSession();

					Query query = session
							.createSQLQuery("update Pp_Employeedetail set PP_EMPLOYEEMASTERID = :PP_EMPLOYEEMASTERID"
									+ " where PP_EMPLOYEEMASTERID = :PP_EMPLOYEEMASTERID");
					query.setParameter("PP_EMPLOYEEMASTERID", long1);
					query.setParameter("PP_EMPLOYEEMASTERID", long1);
					;
					int result = query.executeUpdate();

				}

				else if (object instanceof PpEmployeepaydetail)

				{
					PpEmployeepaydetail ppEmployeepaydetail = (PpEmployeepaydetail) object;
					ppEmployeepaydetail.setPpEmployeemasterid(id);
					ppEmployeepaydetail.setSysPaymentmodeid('1');
					ppEmployeepaydetail.setSalarypercent("100");
					session = sessionFactory.getCurrentSession();
					Query query = session
							.createSQLQuery("update Pp_Employeepaydetail set PP_EMPLOYEEMASTERID = :PP_EMPLOYEEMASTERID"
									+ " where PP_EMPLOYEEMASTERID = :PP_EMPLOYEEMASTERID");
					query.setParameter("PP_EMPLOYEEMASTERID", long1);
					query.setParameter("PP_EMPLOYEEMASTERID", long1);
					;
					int result = query.executeUpdate();

				}

				else {
					PpEmployeeappointmentdetail ppEmployeeappointmentdetail = (PpEmployeeappointmentdetail) object;
					ppEmployeeappointmentdetail.setPpEmployeemasterid(id);
					session = sessionFactory.getCurrentSession();
					Query query = session.createSQLQuery(
							"update Pp_Employeeappointmentdetail set PP_EMPLOYEEMASTERID = :PP_EMPLOYEEMASTERID"
									+ " where PP_EMPLOYEEMASTERID = :PP_EMPLOYEEMASTERID");
					query.setParameter("PP_EMPLOYEEMASTERID", long1);
					query.setParameter("PP_EMPLOYEEMASTERID", long1);
					;
					int result = query.executeUpdate();

				}
			} catch (Exception e) {
				System.out.println("Exception In EmployeeAppointmentDaoImple Class");
				e.printStackTrace();
			}
		}

		else {
			try {
				if (object instanceof PpEmployeemaster) {

					sessionFactory.getCurrentSession().saveOrUpdate(object);
					PpEmployeemaster ppEmployeemaster = (PpEmployeemaster) object;

					id = ppEmployeemaster.getPpEmployeemasterid();
					id = id + 1;
				}

				else if (object instanceof PpEmployeepersonaldetail) {
					PpEmployeepersonaldetail ppEmployeepersonaldetail = (PpEmployeepersonaldetail) object;
					ppEmployeepersonaldetail.setPpEmployeemasterid(id);
					sessionFactory.getCurrentSession().save(ppEmployeepersonaldetail);

				}

				else if (object instanceof PpEmployeedetail) {
					PpEmployeedetail ppEmployeedetail = (PpEmployeedetail) object;
					ppEmployeedetail.setPpEmployeemasterid(id);
					ppEmployeedetail.setIsconfirm('0');
					ppEmployeedetail.setIspermanent('0');
					session = sessionFactory.getCurrentSession();
					session.save(ppEmployeedetail);

				}

				else if (object instanceof PpEmployeepaydetail)

				{
					PpEmployeepaydetail ppEmployeepaydetail = (PpEmployeepaydetail) object;
					ppEmployeepaydetail.setPpEmployeemasterid(id);
					ppEmployeepaydetail.setSysPaymentmodeid('1');
					ppEmployeepaydetail.setSalarypercent("100");
					sessionFactory.getCurrentSession().save(ppEmployeepaydetail);

				}

				else {
					PpEmployeeappointmentdetail ppEmployeeappointmentdetail = (PpEmployeeappointmentdetail) object;
					ppEmployeeappointmentdetail.setPpEmployeemasterid(id);
					sessionFactory.getCurrentSession().save(ppEmployeeappointmentdetail);

				}
			} catch (Exception e) {
				System.out.println("Exception In EmployeeAppointmentDaoImple Class");
				e.printStackTrace();
			} finally {
				session.close();
			}
		}

	}

	/** Executing Procedure for Employee Posting **/
	public int executeProcedure(EmployeePostingDTO employeePostingDTO) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int c = 0;
		String x = null;

		try {

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			System.out.println(employeePostingDTO.getPpEmployeemasterid() + "   " + employeePostingDTO.getOrderdate()
					+ "    " + employeePostingDTO.getPostingorderno() + "    " + employeePostingDTO.getRmOfficeid() + "     "
					+ employeePostingDTO.getSYS_SUBSERVICEPHASEMASTERID() + "     " + employeePostingDTO.getEffectivedate() + "      "
					+ employeePostingDTO.getPpDesignationmasterid() + "          " + "Appointment" + "     ");
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection.prepareCall("{call Proc_PP_AddPostingDetail(?,?,?,?,?,?,?,?,?,?)}");
			stmt.setString(1, employeePostingDTO.getPpEmployeemasterid() + "");
			stmt.setString(2, employeePostingDTO.getOrderdate());
			stmt.setString(3, employeePostingDTO.getPostingorderno());
			stmt.setString(4, employeePostingDTO.getRmOfficeid()+"");
			stmt.setString(5, employeePostingDTO.getSYS_SUBSERVICEPHASEMASTERID());
			stmt.setString(6, employeePostingDTO.getEffectivedate() + "");
			stmt.setString(7, employeePostingDTO.getPpDesignationmasterid() + "");
			stmt.setString(8, "Appointment");
			stmt.setString(9, "");
			stmt.registerOutParameter(10, Types.VARCHAR);
			c = stmt.executeUpdate();
			x = stmt.getString(10);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			session.close();
		}
		if (Integer.parseInt(x) == 1) {
			return Integer.parseInt(x);
		} else {

			return 0;
		}

	}

	/** This method save the New Appointment details using HIBERNATE **/

	public List<PpEmployeemaster> listEmployeess() {
		Session session = null;
		List<PpEmployeemaster> employeemasters = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			employeemasters = (List<PpEmployeemaster>) session.createCriteria(PpEmployeemaster.class).list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeemasters;
	}

	public PpEmployeemaster getEmployee(int empid) {
		Session session = null;
		PpEmployeemaster ppEmployeemaster = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			ppEmployeemaster = (PpEmployeemaster) session.get(PpEmployeemaster.class, empid);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ppEmployeemaster;
	}

	public void deleteEmployeeAppointment(PpEmployeemaster ppEmployeemaster) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			session.createQuery(
					"DELETE FROM PpEmployeemaster WHERE empid = " + ppEmployeemaster.getPpEmployeemasterid())
					.executeUpdate();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	/** Populating Combo when Condition datatype is string **/
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

	/** Populating Combo when Condition datatype is Integar Array **/
	public List getComboList(int[] where_condtion, String namedQuery) {
		Query query = null;
		List<Object> list = null;

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
		} catch (Exception e) {

		} finally {
			session.close();
		}

		return list;

	}

	/** Populating Combo when Condition datatype is Integar **/
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
			}

			else {

				query = session.getNamedQuery(namedQuery);
				list = (List<Object>) query.list();
			}

			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;

	}

	/** Executing procedure for AddJoiningDetail **/
	public int executeProcedureForADDJOININGDETAIL(EmployeePostingDTO employeePostingDTO) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String joining_Time;
		if (employeePostingDTO.getJoinANFN_in().equals("Fore Noon")) {
			joining_Time = "FN";
		} else {
			joining_Time = "AN";
		}
		int result = 0;

		try {

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection.prepareCall("{call PROC_PP_ADDJOININGDETAIL(?,?,?,?,?)}");
			stmt.setString(1, employeePostingDTO.getPpEmployeemasterid() + "");
			stmt.setString(2, employeePostingDTO.getPpPostingdetailid() + "");
			stmt.setString(3, employeePostingDTO.getDatejoining());
			stmt.setString(4, joining_Time);

			stmt.registerOutParameter(5, Types.VARCHAR);
			result = stmt.executeUpdate();
			String x = stmt.getString(5);
			System.out.println(x + "****-----Output of employee joining Procedure----****");

			tx.commit();
			
			result = 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	/** Update Posting Information of employee **/
	public int updatePostingDetailsInfo(PpPostingdetail ppPostingdetail, PpEmployeemaster ppEmployeemaster){
		Session session = sessionFactory.openSession();
	   int a=0;

			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				
				session.createCriteria(ppPostingdetail.getPpPostingdetailid() + "");
				session.update(ppPostingdetail);
				
				session.createCriteria(ppEmployeemaster.getPpEmployeemasterid()+"");
				session.update(ppEmployeemaster);
				
				session.flush();  
				tx.commit();
				a = 1;
			} catch (Exception e) {

				e.printStackTrace();

			} finally {
				session.close();
			}

		return a;
	}

	@Override
	public boolean deletePostingDetails(String ppPostingdetailid, String ppEmployeemasterid, String postingagainst) {

		boolean result = false;
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();

			if (postingagainst.equals("Appointment")) {

				CallableStatement stmt = connection.prepareCall("{call PROC_PP_DELPOSTINGAGNSTAPTMT(?,?,?,?)}");

				stmt.setString(1, ppPostingdetailid);
				stmt.setString(2, ppEmployeemasterid);
				stmt.setString(3, postingagainst);
				stmt.registerOutParameter(4, Types.VARCHAR);

				result = stmt.execute();

				String output = stmt.getString(4);
				System.out.println(output + " -----PROC_PP_DELPOSTINGAGNSTAPTMT------");
				result = true;
			}

			else {
				CallableStatement stmt = connection.prepareCall("{call PROC_PP_DELPOSTING(?,?,?,?)}");

				stmt.setString(1, ppPostingdetailid);
				stmt.setString(2, ppEmployeemasterid);
				stmt.setString(3, postingagainst);
				stmt.registerOutParameter(4, Types.VARCHAR);

				result = stmt.execute();

				String output = stmt.getString(4);
				System.out.println(output + " -----PROC_PP_DELPOSTING------");
				result = true;
			}

			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public List listofempcodes(String namedquery) {

		Query query = null;
		List<Object> list = null;

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			query = session.getNamedQuery(namedquery);

			list = (List<Object>) query.list();

			tx.commit();

		} catch (Exception e) {

		} finally {
			session.close();
		}

		return list;

	}

	@Override
	public boolean checkEmployeecodeExistance(String employeecode) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		boolean isexists = false;
		List<String> empcode = new ArrayList<String>();

		try {
			List<PpEmployeemaster> list = (List<PpEmployeemaster>) listofempcodes("PpEmployeemaster.findAll");
			for (PpEmployeemaster
					  ppEmployeemaster : list) {
					  empcode.add(ppEmployeemaster.getEmployeecode()); 
					  }				  
					  if (empcode.contains(employeecode)) {	  
						  isexists = true;
					  }
					  tx.commit();					
		} 
		catch (Exception e) {
              e.printStackTrace();
		}finally {
			session.close();
		}
		return isexists;
}

	@Override
	public List getEmployeeMaster(String ppEmployeemasterid, String namedQuery) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Object> list = null;
		Query query = null;
		
		try{
			query = session.getNamedQuery(namedQuery);

			list = (List<Object>) query.list();	
			
			System.out.println(list.size()+"--- size of list");
			
			System.out.println("ok");
			
			tx.commit();
		}
		catch(Exception e){
			
		}finally {
			session.close();
		}
		return list;

	}

	@Override
	public boolean insertNewEmployeeintoDB(PpEmployeemaster ppEmployeemaster,
			PpEmployeepersonaldetail ppEmployeepersonaldetail, PpEmployeeappointmentdetail ppEmployeeappointmentdetail,
			PpEmployeedetail ppEmployeedetail, PpEmployeepaydetail ppEmployeepaydetail) {
		
		boolean iscomplete = false;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try{
	
			/* Inserting data into PP_EMPLOYEEMASTER */
		
			session.saveOrUpdate(ppEmployeemaster);
			
            id = ppEmployeemaster.getPpEmployeemasterid();
			id = id + 1;
			
			/* Inserting data into PP_EMPLOYEEPERSONALDETAIL */	
			
			ppEmployeepersonaldetail = (PpEmployeepersonaldetail) ppEmployeepersonaldetail;
			ppEmployeepersonaldetail.setPpEmployeemasterid(id);
			System.out.println(id+"---"+ppEmployeepersonaldetail.getPpEmployeemasterid());
			
			session.saveOrUpdate(ppEmployeepersonaldetail);
			
            /* Inserting data into PP_EMPLOYEEAPPOINTMENTDETAIL */	
			
			ppEmployeeappointmentdetail = (PpEmployeeappointmentdetail) ppEmployeeappointmentdetail;
			ppEmployeeappointmentdetail.setPpEmployeemasterid(id);
			
			System.out.println(id+"---"+ppEmployeeappointmentdetail.getPpEmployeemasterid());
			
			session.saveOrUpdate(ppEmployeeappointmentdetail);

			/* Inserting data into PP_EMPLOYEEDETAIL */
			ppEmployeedetail = (PpEmployeedetail) ppEmployeedetail;
			ppEmployeedetail.setPpEmployeemasterid(id);
			ppEmployeedetail.setIsconfirm('0');
			ppEmployeedetail.setIspermanent('0');
			
			session.saveOrUpdate(ppEmployeedetail);

			/* Inserting data into PP_EMPLOYEEPAYDETAIL */
			
			ppEmployeepaydetail = (PpEmployeepaydetail) ppEmployeepaydetail;
			ppEmployeepaydetail.setPpEmployeemasterid(id);
			ppEmployeepaydetail.setSysPaymentmodeid('1');
			ppEmployeepaydetail.setSalarypercent("100");
			session.saveOrUpdate(ppEmployeepaydetail);
			
			/*PpEmployeemaster pp = (PpEmployeemaster)session.get(PpEmployeemaster.class, ppEmployeemaster.getPpEmployeemasterid());
			pp.setPpEmployeemasterid(pp.getPpEmployeemasterid());
			session.update(pp);
			
			PpEmployeepersonaldetail pp1 = (PpEmployeepersonaldetail)session.get(PpEmployeepersonaldetail.class, ppEmployeepersonaldetail.getPpEmployeemasterid());
			pp1.setPpEmployeemasterid(pp1.getPpEmployeemasterid());
			session.update(pp1);
			
			PpEmployeeappointmentdetail pp2 = (PpEmployeeappointmentdetail)session.get(PpEmployeeappointmentdetail.class, ppEmployeeappointmentdetail.getPpEmployeemasterid());
			pp2.setPpEmployeemasterid(pp2.getPpEmployeemasterid());
			session.update(pp2);
			
			PpEmployeedetail pp3 = (PpEmployeedetail)session.get(PpEmployeedetail.class, ppEmployeedetail.getPpEmployeemasterid());
			pp3.setPpEmployeemasterid(pp3.getPpEmployeemasterid());
			session.update(pp3);
			
			PpEmployeepaydetail pp4 = (PpEmployeepaydetail)session.get(PpEmployeepaydetail.class, ppEmployeepaydetail.getPpEmployeemasterid());
			pp4.setPpEmployeemasterid(pp4.getPpEmployeemasterid());
			session.update(pp4);*/
			
			tx.commit();
			iscomplete = true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return iscomplete;
	}

	@Override
	public boolean editAppointment(PpEmployeemaster ppEmployeemaster, PpEmployeepersonaldetail ppEmployeepersonaldetail,
			PpEmployeeappointmentdetail ppEmployeeappointmentdetail, PpEmployeedetail ppEmployeedetail,
			PpEmployeepaydetail ppEmployeepaydetail) {
		
		boolean iscomplete = false;
		Session session = sessionFactory.openSession();
		
		
		try{
			Transaction tx = session.beginTransaction();
			session.createCriteria(ppEmployeemaster.getPpEmployeemasterid()+"");
			session.update(ppEmployeemaster);
			
					
			session.createCriteria(ppEmployeepersonaldetail.getPpEmployeepersonaldetailid()+"");
			session.update(ppEmployeepersonaldetail);
			
			
			session.createCriteria(ppEmployeeappointmentdetail.getPpEmployeeappointmentdetailid()+ "");
			session.update(ppEmployeeappointmentdetail);
			
			
			ppEmployeedetail.setIsconfirm('0');
			ppEmployeedetail.setIspermanent('0');
			session.createCriteria(ppEmployeedetail.getPpEmployeedetailid()+"");
			session.update(ppEmployeedetail);
		
			
			ppEmployeepaydetail.setSysPaymentmodeid('1');
			ppEmployeepaydetail.setSalarypercent("100");
			session.createCriteria(ppEmployeepaydetail.getPpEmployeepaydetailid()+"");
			session.update(ppEmployeepaydetail);
			
			
			session.flush();
			tx.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return iscomplete;
		
	}

}