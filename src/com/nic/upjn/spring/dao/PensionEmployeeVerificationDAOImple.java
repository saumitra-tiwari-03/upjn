package com.nic.upjn.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.upjn.spring.dto.PensionEmployeeVerificationDTO;
import com.nic.upjn.spring.entity.PensionEmployeeVerificationEntity;
import com.nic.upjn.spring.entity.PpEmployeemaster;

@Repository("PensionEmployeeVerificationDAO")
public class PensionEmployeeVerificationDAOImple implements
		PensionEmployeeVerificationDAO {
	@Autowired
	SessionFactory sessionfactory;

	@SuppressWarnings({ "rawtypes", "unused" })
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

	@SuppressWarnings("rawtypes")
	@Override
	public List employeeList() {
		List employeeList = null;
		Session session = null;
		Query query = null;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

			String sql = "select em.PP_EMPLOYEEMASTERID,em.firstname,em.middlename,em.lastname,em.employeecode,desg.DESIGNATION,eper.fathername,to_char(eper.dateofbirth,'dd-mm-yyyy') as dateOfBirth,"
					+ " to_char(empapp.datejoining,'dd-mm-yyyy') as joiningDate,to_char(empdet.retirementdate,'dd-mm-yyyy') as dateOfRetirement,empdet.GPFACNO from pp_employeemaster em "
					+ " inner join pp_employeepersonaldetail eper on em.pp_employeemasterid=eper.pp_employeemasterid"
					+ " inner join pp_employeedetail  empdet on empdet.pp_employeemasterid=em.pp_employeemasterid"
					+ " inner join PP_EMPLOYEEAPPOINTMENTDETAIL empapp on empapp.PP_EMPLOYEEMASTERID=em.PP_EMPLOYEEMASTERID"
					+ " inner join PP_DESIGNATIONMASTER desg on desg.PP_DESIGNATIONMASTERID=em.PP_DESIGNATIONMASTERID"
					+ " where ((em.ISRETIRED='1')  or (months_between(sysdate, eper.DATEOFBIRTH)/12>59.5 and months_between(sysdate, eper.DATEOFBIRTH)/12<60))"
					+ " and empdet.ISNPS='G' and em.IS_REG_FORPENSION='0' order by em.FIRSTNAME , eper.DATEOFBIRTH";
			query = session.createSQLQuery(sql);

			((SQLQuery) query)
					.addEntity(PensionEmployeeVerificationEntity.class);
			employeeList = query.list();

			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return employeeList;
	}

	@Override
	public List employeeInfo(String employeecode) {
		List employeeList = null;
		Session session = null;
		Query query = null;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

			String sql = "select em.PP_EMPLOYEEMASTERID,em.firstname,em.middlename,em.lastname,em.employeecode,desg.DESIGNATION,eper.fathername,to_char(eper.dateofbirth,'dd-mm-yyyy') as dateOfBirth,"
					+ " to_char(empapp.datejoining,'dd-mm-yyyy') as joiningDate,to_char(empdet.retirementdate,'dd-mm-yyyy') as dateOfRetirement,empdet.GPFACNO from pp_employeemaster em "
					+ " inner join pp_employeepersonaldetail eper on em.pp_employeemasterid=eper.pp_employeemasterid"
					+ " inner join pp_employeedetail  empdet on empdet.pp_employeemasterid=em.pp_employeemasterid"
					+ " inner join PP_EMPLOYEEAPPOINTMENTDETAIL empapp on empapp.PP_EMPLOYEEMASTERID=em.PP_EMPLOYEEMASTERID"
					+ " inner join PP_DESIGNATIONMASTER desg on desg.PP_DESIGNATIONMASTERID=em.PP_DESIGNATIONMASTERID"
					+ " where ((em.ISRETIRED='1')  or (months_between(sysdate, eper.DATEOFBIRTH)/12>59.5 and months_between(sysdate, eper.DATEOFBIRTH)/12<60))"
					+ " and empdet.ISNPS='G' and em.IS_REG_FORPENSION='0' and em.employeecode='"
					+ employeecode
					+ "' order by em.FIRSTNAME , eper.DATEOFBIRTH";
			query = session.createSQLQuery(sql);

			((SQLQuery) query)
					.addEntity(PensionEmployeeVerificationEntity.class);
			employeeList = query.list();

			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeList;
	}

	

	@Override
	public boolean insertPensionerDetails(PensionEmployeeVerificationDTO dto) {
		Session session = null;
		PpEmployeemaster ppEmployeemaster = new PpEmployeemaster();
		boolean result = false;

		try {
			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();
			
			BeanUtils.copyProperties(dto, ppEmployeemaster);
			
			ppEmployeemaster.setIS_REG_FORPENSION(1);
			session.createCriteria(ppEmployeemaster.getPpEmployeemasterid()+""); 
			session.update(ppEmployeemaster);
			
			t.commit();
			
			t.commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	

}
