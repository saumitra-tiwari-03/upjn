package com.nic.upjn.spring.dao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.upjn.spring.dto.DesignationMasterDTO;
import com.nic.upjn.spring.dto.LoanMasterDTO;
import com.nic.upjn.spring.entity.DADEntity;
import com.nic.upjn.spring.entity.PpDesignationmaster;
import com.nic.upjn.spring.entity.PpLoandetail;
import com.nic.upjn.spring.entity.PpLoanmaster;

@Repository("daMasterDao")
public class DAMasterDaoImpl implements DAMasterDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List getDAList() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		List<DADEntity> list = null;
		try {
			String sql = "select rownum,sys_paycategory.sys_paycategoryid,sys_paycategory.paycategory,PP_PAYALWMASTER.PP_PAYALWMASTERID,PP_RULEMASTER.RULEORDERNO,\n"
					+ "nvl(TO_CHAR( PP_RULEMASTER.RULEORDERDATE,'dd-mm-yyyy'),'N.A.') as RULEORDERDATE ,\n"
					+ "nvl(TO_CHAR(PP_RULEMASTER.DATEOFEFFECT,'dd-mm-yyyy'),'N.A') as DATEOFEFFECT,\n"
					+ "nvl(TO_CHAR(PP_RULEMASTER.DUEDATE,'dd-mm-yyyy'),'N.A.') as DUEDATE,\n"
					+ "nvl(TO_CHAR(PP_RULEMASTER.GPFDATE,'dd-mm-yyyy'),'N.A.') as GPFDATE,\n"
					+ "nvl(TO_CHAR(PP_RULEMASTER.CASHDATE,'dd-mm-yyyy'),'N.A.') as CASHDATE , \n"
					+ "PP_RULEDETAIL.PERCENTVALUE    FROM PP_PAYALWMASTER\n"
					+ "INNER JOIN SYS_PAYCATEGORY ON SYS_PAYCATEGORY.SYS_PAYCATEGORYID =PP_PAYALWMASTER.SYS_PAYCATEGORYID\n"
					+ "INNER JOIN PP_RULEMASTER ON PP_RULEMASTER.PP_PAYALWMASTERID=PP_PAYALWMASTER.PP_PAYALWMASTERID\n"
					+ "INNER JOIN PP_RULEDETAIL ON PP_RULEDETAIL.PP_RULEMASTERID =PP_RULEMASTER.PP_RULEMASTERID\n"
					+ "WHERE SYS_PAYCATEGORY.SYS_PAYCATEGORYID IN (2,12) AND  PP_PAYALWMASTER.PP_PAYALWMASTERID IN (572,427) order by sys_paycategory.paycategory asc, PP_RULEDETAIL.PERCENTVALUE desc";

			Query query = session.createSQLQuery(sql)
					.addEntity(DADEntity.class);
			list = query.list();
			transaction.commit();
		} catch (Exception ex) {
			System.out.println("Exdception in DADAO CLASS" + ex);
		} finally {
			session.close();
		}
		return list;

	}

	@Override
	public boolean insertDA(String[] inParam) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		boolean isComplete = false;

		try {
			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection
					.prepareCall("{call PROC_DA_MASTER(?,?,?,?,?,?,?,?,?)}");

			stmt.setString(1, inParam[0]);
			stmt.setString(2, inParam[1]);
			stmt.setString(3, inParam[2]);
			stmt.setString(4, inParam[3]);
			stmt.setString(5, inParam[4]);
			stmt.setString(6, inParam[5]);
			stmt.setString(7, inParam[6]);
			stmt.setString(8, inParam[7]);

			stmt.registerOutParameter(9, Types.VARCHAR);
			int result = stmt.executeUpdate();
			String x = stmt.getString(9);
			transaction.commit();

			if (x != null
					&& (x.equalsIgnoreCase("1") || x.equalsIgnoreCase("1"))) {
				isComplete = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return isComplete;
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

	@Override
	public boolean insertLoanMaster(LoanMasterDTO loanMasterDTO) {
		boolean isComplete = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {

			PpLoanmaster ppLoanmaster = new PpLoanmaster();
			ppLoanmaster.setLoanname(loanMasterDTO.getLoanName());
			ppLoanmaster.setLoanshortname(loanMasterDTO.getLoanShortName());

			ppLoanmaster.setMaxInstallmentno(new Short(loanMasterDTO
					.getMax_InstallmentNo() + ""));
			ppLoanmaster.setPpSchedulemasterid(loanMasterDTO
					.getPp_ScheduleMasterID());
			ppLoanmaster.setPrintOrder(new Short("100"));
			ppLoanmaster.setAcCode("47");
			Short id = (Short) session.save(ppLoanmaster);
			if (id != null) {
				isComplete = true;
			}

			transaction.commit();

		} catch (Exception exp) {
			System.out.println("sioe = " + exp.toString());
		} finally {
			session.close();
		}
		return isComplete;
	}

	@Override
	public boolean updateLoanMaster(LoanMasterDTO loanMasterDTO) {

		boolean isComplete = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {

			PpLoanmaster ppLoanmaster = new PpLoanmaster();
			ppLoanmaster.setLoanname(loanMasterDTO.getLoanName());
			ppLoanmaster.setLoanshortname(loanMasterDTO.getLoanShortName());

			ppLoanmaster.setMaxInstallmentno(new Short(loanMasterDTO
					.getMax_InstallmentNo() + ""));
			ppLoanmaster.setPpSchedulemasterid(loanMasterDTO
					.getPp_ScheduleMasterID());
			ppLoanmaster.setPrintOrder(new Short("100"));
			ppLoanmaster.setAcCode("47");
			ppLoanmaster.setPpLoanmasterid(new Short(loanMasterDTO
					.getPp_LoanMasterID() + ""));
			session.createCriteria(PpLoanmaster.class,
					ppLoanmaster.getPpLoanmasterid() + "");
			session.update(ppLoanmaster);
			session.flush();
			transaction.commit();
			isComplete = true;

		} catch (Exception exp) {
			System.out.println("sioe = " + exp.toString());
		} finally {
			session.close();
		}
		return isComplete;
	}

	@Override
	public boolean deleteLoanMaster(String ppLoanmasterid) {

		boolean isComplete = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {

			PpLoanmaster ppLoanmaster = new PpLoanmaster();
			ppLoanmaster.setPpLoanmasterid(new Short(ppLoanmasterid+""));
			session.createCriteria(PpLoanmaster.class,ppLoanmasterid);
			session.delete(ppLoanmaster);
			transaction.commit();
			isComplete = true;

		} catch (Exception exp) {
			System.out.println("ram = " + exp.toString());
		} finally {
			session.close();
		}
		return isComplete;
	}

	@Override
	public boolean insertDesignationIntoDB(
			DesignationMasterDTO designationMasterDTO) {
		
		boolean isComplete = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {

			PpDesignationmaster ppDesignationmaster = new PpDesignationmaster();
			ppDesignationmaster.setDesignation(designationMasterDTO.getDesignation());
			ppDesignationmaster.setMasEmploymenttypeid(Integer.parseInt(designationMasterDTO.getMas_EmploymentTypeID()));
			ppDesignationmaster.setMasEmploymentsubtypeid(Integer.parseInt(designationMasterDTO.getMas_EmploymentSubTypeID()));
			
			session.save(ppDesignationmaster);
			BigDecimal id = (BigDecimal) session.save(ppDesignationmaster);
			if (id != null) {
				isComplete = true;
			}
			transaction.commit();
			

			

		} catch (Exception exp) {
			System.out.println("sioe = " + exp.toString());
		} finally {
			session.close();
		}
		return isComplete;
	}

	@Override
	public boolean editDesignation(DesignationMasterDTO designationMasterDTO) {
		
		boolean isComplete = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {

			PpDesignationmaster ppDesignationmaster = new PpDesignationmaster();
			ppDesignationmaster.setDesignation(designationMasterDTO.getDesignation());
			ppDesignationmaster.setMasEmploymenttypeid(Integer.parseInt(designationMasterDTO.getMas_EmploymentTypeID()));
			ppDesignationmaster.setMasEmploymentsubtypeid(Integer.parseInt(designationMasterDTO.getMas_EmploymentSubTypeID()));
			ppDesignationmaster.setPpDesignationmasterid(new BigDecimal(designationMasterDTO.getPp_DesignationMasterID()));
			session.createCriteria(PpDesignationmaster.class,
					designationMasterDTO.getPp_DesignationMasterID()+ "");
			 session.update(ppDesignationmaster);
				isComplete = true;
			

			transaction.commit();

		} catch (Exception exp) {
			System.out.println("sioe = " + exp.toString());
		} finally {
			session.close();
		}
		return isComplete;	}

	@Override
	public boolean deleteDesignation(String ppDesignationmasterid) {

		boolean isComplete = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {

			PpDesignationmaster ppDesignationmaster = new PpDesignationmaster();
			ppDesignationmaster.setPpDesignationmasterid(new BigDecimal(ppDesignationmasterid));
		
			session.createCriteria(PpDesignationmaster.class,ppDesignationmasterid);
			session.delete(ppDesignationmaster);
			transaction.commit();
			isComplete = true;

		} catch (Exception exp) {
			System.out.println("ram = " + exp.toString());
		} finally {
			session.close();
		}
		return isComplete;
	}

}
