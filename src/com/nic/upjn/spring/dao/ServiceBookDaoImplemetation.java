/******************************** ServiceBookDaoImplemetation Class **************************/

/*==========================================================================
 * Description : ServiceStatusDaoImplementation class contains the database operation for the Service Status. 
 * Date:  
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 */

package com.nic.upjn.spring.dao;

import java.sql.CallableStatement;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.upjn.spring.dto.EmployeeStatusDTO;
import com.nic.upjn.spring.entity.PayRollIEmpInfoEntity;
import com.nic.upjn.spring.entity.PpEmployeedetail;
import com.nic.upjn.spring.entity.PpEmployeequalification;
import com.nic.upjn.spring.entity.PpEmployeetraining;
import com.nic.upjn.spring.entity.PpSuspensiondetail;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;
import com.nic.upjn.spring.entity.ViewPpWholeemplist;
import com.nic.upjn.spring.entity.ViewSuspensiondetaillist;

@SuppressWarnings({ "unused" })
@Repository("serviceBookDao")
public class ServiceBookDaoImplemetation implements ServiceBookDao {

	@Autowired
	private SessionFactory sessionFactory;

	/** Populating Combo when Condition DataType is Integer **/
	@Override
	public List<?> getComboList(int where_condition, String namedQuery) {

		Query query = null;
		List<?> list = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			if (where_condition != 0) {
				query = session.getNamedQuery(namedQuery);
				query.setInteger(0, where_condition);
				list = (List<?>) query.list();
			} else {
				query = session.getNamedQuery(namedQuery);
				list = (List<?>) query.list();
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
	public List<?> getComboList(String where_condition, String namedQuery) {
		Query query = null;
		List<?> list = null;
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			if (where_condition != null) {
				query = session.getNamedQuery(namedQuery);
				query.setString(0, where_condition);

				list = (List<?>) query.list();
			}

			else {

				query = session.getNamedQuery(namedQuery);
				list = (List<?>) query.list();
			}

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	/** Populating Combo when Condition DataType is Integer Array **/
	@Override
	public List<?> getComboList(int[] where_condtion, String namedQuery) {
		Query query = null;
		List<?> list = null;

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			if (where_condtion != null) {
				query = session.getNamedQuery(namedQuery);

				for (int i = 0; i < where_condtion.length; i++) {
					query.setInteger(i, where_condtion[i]);

				}

				list = (List<?>) query.list();

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

	/** This method is Responsible for all Search **/
	@Override
	public List<?> suspensionEmployeeSearchList(String SQL) {
		{
			List<?> employeeSearchList = null;
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

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
	}

	@Override
	public List<ViewPpWholeemplist> suspensionEmployeeSearchList_ES(String sQL) {
		List<ViewPpWholeemplist> employeeSearchList = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			SQLQuery query = session.createSQLQuery(sQL);
			query.addEntity(ViewPpWholeemplist.class);
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

	/** Executing Procedure for Employee personal Details **/

	public int executeProcedureForeditEmployeePersonalDetails(
			EmployeeStatusDTO employeeStatusDTO) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int result = 0;
		String output = null;
		// employeeStatusDTO.getRetirementdate()

		try {

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection
					.prepareCall("{call PROC_PP_INSERT_EMP_PERSOANLS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			stmt.setInt(1,
					Integer.parseInt(employeeStatusDTO.getPpEmployeemasterid()));
			stmt.setString(2, employeeStatusDTO.getEmployeecode());
			stmt.setString(3, employeeStatusDTO.getFirstname());
			stmt.setString(4, employeeStatusDTO.getMiddlename());
			stmt.setString(5, employeeStatusDTO.getLastname());
			stmt.setString(6, employeeStatusDTO.getSexcode() + "");
			stmt.setString(7, employeeStatusDTO.getFathername());
			stmt.setInt(8, Integer.parseInt(employeeStatusDTO.getMasCasteid()));
			stmt.setInt(9,
					Integer.parseInt(employeeStatusDTO.getMasReligionid()));
			stmt.setInt(10,
					Integer.parseInt(employeeStatusDTO.getMasMaritalstatusid()));
			stmt.setString(11, employeeStatusDTO.getDateofbirth());
			stmt.setString(12, employeeStatusDTO.getPermanentaddress());
			stmt.setString(13, employeeStatusDTO.getHeight());
			stmt.setString(14,
					employeeStatusDTO.getPersonalidentificationmark());
			stmt.setString(15, employeeStatusDTO.getPanno());
			stmt.setString(16, employeeStatusDTO.getSpouseworkingwithgovt()
					+ "");
			stmt.setString(17, employeeStatusDTO.getDatejoining());
			stmt.setString(18, employeeStatusDTO.getAppointmentfileno());
			stmt.setString(19, employeeStatusDTO.getAppointmentfiledate());
			stmt.setInt(
					20,
					Integer.parseInt(employeeStatusDTO
							.getPpDesignationmasterid() + ""));
			stmt.setString(21, employeeStatusDTO.getPresentaddress());
			stmt.setString(22, employeeStatusDTO.getHomephno());
			stmt.setString(23, employeeStatusDTO.getOfficephno());
			stmt.setString(24, employeeStatusDTO.getMobileno());
			stmt.setString(25, employeeStatusDTO.getEmailid());
			stmt.setString(26, employeeStatusDTO.getDistrict());
			stmt.setString(27, employeeStatusDTO.getHometown());
			stmt.setString(28, employeeStatusDTO.getPincode());
			stmt.setString(29, employeeStatusDTO.getRetirementdate());
			stmt.setString(30, employeeStatusDTO.getRetirementage());
			stmt.setString(31, employeeStatusDTO.getHusbandname());
			stmt.setString(32, employeeStatusDTO.getBloodgroup());
			stmt.setString(33, employeeStatusDTO.getMlOpenbalance());
			stmt.setString(34, employeeStatusDTO.getMlOpenbaldate());
			stmt.registerOutParameter(35, Types.VARCHAR);

			result = stmt.executeUpdate();
			output = stmt.getString(35);
			System.out.print(output + "----------@@@@@@@@@@@@");

			if (output.equals("error")) {
				result = 0;
			} else {
				result = 1;
			}

			tx.commit();
		}

		catch (Exception e) {
			;
			System.out.println(e);
		} finally {
			session.close();
		}
		return result;
	}

	/** Executing Procedure for EmployeePromotion Details **/

	public int executeProcedureForaddEmployeePromotion(
			EmployeeStatusDTO employeeStatusDTO) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int result = 0;
		String output;
		String promotion;

		if (employeeStatusDTO.getIsPromotionForego() == true) {
			promotion = "1";
		} else {
			promotion = "0";
		}

		try {

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection
					.prepareCall("{call PROC_PP_EMP_PROMOTION(?,?,?,?,?,?,?,?,?)}");

			stmt.setString(1, employeeStatusDTO.getPpEmployeemasterid());
			stmt.setString(2, employeeStatusDTO.getPpDesignationmasterid() + "");
			stmt.setString(3, employeeStatusDTO.getEffectivedate() + "");
			stmt.setString(4, employeeStatusDTO.getPostingorderno());
			stmt.setString(5, employeeStatusDTO.getOrderdate() + "");
			stmt.setString(6, employeeStatusDTO.getJoindate() + "");
			stmt.setString(7, employeeStatusDTO.getJoinanfn());
			stmt.setString(8, promotion);

			stmt.registerOutParameter(9, Types.VARCHAR);
			result = stmt.executeUpdate();
			output = stmt.getString(9);
			if (output.equals("success")) {
				result = 1;

			}

			tx.commit();
		}

		catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return result;
	}

	public void updatePermanencyInformation(Object entity) {

		Session session = sessionFactory.openSession();

		if (entity instanceof PpEmployeedetail) {
			PpEmployeedetail ppEmployeedetail = (PpEmployeedetail) entity;

			ppEmployeedetail.setIsconfirm('1');

			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.createCriteria(ppEmployeedetail.getPpEmployeemasterid()
						+ "");
				session.update(ppEmployeedetail);
				session.flush();

				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
	}

	public void saveTrainingInfoEmployee(PpEmployeetraining ppEmployeetraining) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(ppEmployeetraining);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void insertQualificationDetails(
			PpEmployeequalification ppEmployeequalification) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.save(ppEmployeequalification);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * Convert String Date into java.sql Date
	 * 
	 * @throws ParseException
	 **/
	Date getFormatedDate(String currentDate) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd", Locale.US);
		Calendar cal = Calendar.getInstance(Locale.US);
		// cal.get(currentDate);
		sdf.set2DigitYearStart(cal.getTime());
		Date date = sdf.parse("16/07/23");
		return null;

	}

	/** Populating Combo **/
	@Override
	public List<?> getComboList(String namedQuery) {
		Query query = null;
		List<?> list = null;

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		query = session.getNamedQuery(namedQuery);

		try {
			list = (List<?>) query.list();

			tx.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			session.close();
		}

		return list;
	}

	@Override
	public List getEmployeeInformation(String empcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getEmployeeInformationpPayRoll(String empcode) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<?> list = null;
		try {
			String sql = "select  em.employeecode,nvl(em.firstname||' '|| em.middlename ||' ' || em.lastname,'N/A') as EmployeeName,";
			sql += " epersd.fathername,TO_CHAR(TO_DATE(epersd.dateofbirth,'DD/MM/YYYY')) as dateofbirth ,dm.designation,";
			sql += " sm.sectionname,rm.registername,rmof.officename ";
			sql += " from PP_EMPLOYEEMASTER em ";
			sql += " inner join PP_EMPLOYEEPAYDETAIL  epd on epd.pp_employeemasterid=em.pp_employeemasterid";
			sql += " inner join pp_sectionmaster sm on sm.pp_sectionmasterid=epd.pp_sectionmasterid ";
			sql += " inner join PP_REGISTERMASTER rm on epd.PP_REGISTERMASTERID=rm.PP_REGISTERMASTERID";
			sql += " inner join PP_DESIGNATIONMASTER dm on dm.PP_DESIGNATIONMASTERID=em.PP_DESIGNATIONMASTERID ";
			sql += " inner join rm_office rmof on rmof.rm_officeid=em.rm_officeid ";
			sql += " inner join PP_EMPLOYEEPERSONALDETAIL epersd on epersd.pp_employeemasterid=epd.pp_employeemasterid";
			sql += " where em.employeecode='" + empcode + "'";

			Query query = session.createSQLQuery(sql).addEntity(PayRollIEmpInfoEntity.class);
			list = query.list();
			transaction.commit();
			
		

			// Calling Generic DAO's method to extract List
			// list = objDB.executeNonQuery(sql,
			// "com.nic.struts.upjn.ppis.payroll.dto.SearchEmployee_PayrollDTO");

		} catch (Exception msqle) {
			System.out
					.println("Excetion raised in  getEmployeeInformation SearchEmployee_PayrollDAO method :"
							+ msqle);
		}
		finally
		{
			session.close();
		}

		return list;
	}

	@Override
	public List<?> getWholeOfficeListing(String rm_OfficeID) {
		List<?> list=null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
            String sql="select  em.employeecode,nvl(em.firstname||' '|| em.middlename ||' ' || em.lastname,'N/A') as EmployeeName,";
            sql+=" epersd.fathername,TO_CHAR(TO_DATE(epersd.dateofbirth,'DD/MM/YYYY')) as dateofbirth ,dm.designation,";
            sql+=" sm.sectionname,rm.registername,rmof.officename ";
            sql+=" from PP_EMPLOYEEMASTER em ";
            sql+=" inner join PP_EMPLOYEEPAYDETAIL  epd on epd.pp_employeemasterid=em.pp_employeemasterid";
            sql+=" inner join pp_sectionmaster sm on sm.pp_sectionmasterid=epd.pp_sectionmasterid ";
            sql+=" inner join PP_REGISTERMASTER rm on epd.PP_REGISTERMASTERID=rm.PP_REGISTERMASTERID";
            sql+=" inner join PP_DESIGNATIONMASTER dm on dm.PP_DESIGNATIONMASTERID=em.PP_DESIGNATIONMASTERID ";
            sql+=" inner join rm_office rmof on rmof.rm_officeid=em.rm_officeid ";
            sql+=" inner join PP_EMPLOYEEPERSONALDETAIL epersd on epersd.pp_employeemasterid=epd.pp_employeemasterid";
            sql+=" where em.rm_officeid="+rm_OfficeID+" order by rm.registername,employeename,sm.sectionname ";


            Query query = session.createSQLQuery(sql).addEntity(PayRollIEmpInfoEntity.class);
			list = query.list();
			transaction.commit();
			

		} catch (Exception msqle){System.out.println("Excetion raised in  getWholeOfficeListing SearchEmployee_PayrollDAO method :"+msqle); }

		finally
		{
			session.close();
		}
		return list;
	}

}
