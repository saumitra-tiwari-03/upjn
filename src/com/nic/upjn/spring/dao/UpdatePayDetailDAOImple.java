package com.nic.upjn.spring.dao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.miscellaneous.ComboService;
import com.nic.upjn.miscellaneous.UtillException;
import com.nic.upjn.spring.dto.Alw_ForPayCategoryDTO;
import com.nic.upjn.spring.dto.DedDetailDTO;
import com.nic.upjn.spring.dto.EmployeeDedDetailDTO;
import com.nic.upjn.spring.dto.EmployeePayDetailDTO;
import com.nic.upjn.spring.dto.LoanDetailDTO;
import com.nic.upjn.spring.dto.LoanSanctionDTO;
import com.nic.upjn.spring.dto.LockPayBillDTO;
import com.nic.upjn.spring.dto.NPSDetailDTO;
import com.nic.upjn.spring.dto.PayAllowanceComponentsDTO;
import com.nic.upjn.spring.dto.PayAlwDTO;
import com.nic.upjn.spring.dto.PayBillDetailDTO;
import com.nic.upjn.spring.entity.BillMasterEntryEntity;
import com.nic.upjn.spring.entity.DeletePayBillEntity;
import com.nic.upjn.spring.entity.FwaBillmaster;
import com.nic.upjn.spring.entity.LoanSanctionEntity;
import com.nic.upjn.spring.entity.LockEmployeeEntity;
import com.nic.upjn.spring.entity.PartlyEmpListEntity;
import com.nic.upjn.spring.entity.PayBillInfoEntity;
import com.nic.upjn.spring.entity.PayView;
import com.nic.upjn.spring.entity.PpEmpalwcontroller;
import com.nic.upjn.spring.entity.PpEmployeededcontroller;
import com.nic.upjn.spring.entity.PpEmployeepaydetail;
import com.nic.upjn.spring.entity.PpLoanEntity;
import com.nic.upjn.spring.entity.PpLoandetail;
import com.nic.upjn.spring.entity.PpMonthlypay;
import com.nic.upjn.spring.entity.PpNpsdetail;
import com.nic.upjn.spring.entity.PpNpsdetailEntity;
import com.nic.upjn.spring.entity.PpPaybilldetail;
import com.nic.upjn.spring.entity.PpRuledetail;
import com.nic.upjn.spring.entity.PpRulemaster;
import com.nic.upjn.spring.entity.PpTowncategorymaster;
import com.nic.upjn.spring.entity.SysPaycategory;
import com.nic.upjn.spring.entity.ViewPpAllalwlist;
import com.nic.upjn.spring.entity.ViewPpEmpalwlist;
import com.nic.upjn.spring.entity.ViewPpEmpdeddetail;
import com.nic.upjn.spring.entity.ViewPpEmppaydetail;
import com.nic.upjn.spring.entity.ViewPpEmppaydetailList;
import com.nic.upjn.spring.entity.ViewPpEmpprocesspaylist;
import com.nic.upjn.spring.entity.ViewPpNpsdetail;

@Repository("UpdatePayDetailDAO")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class UpdatePayDetailDAOImple implements UpdatePayDetailDAO {

	@Autowired
	SessionFactory sessionFactory;

	private double billAmount = 0.0D;
	private double netpay = 0.0D;
	List list = null;

	@Override
	public List<ViewPpEmppaydetailList> getEmpPayDetailList(Short registerID,
			Integer rmOfficeID) {

		Session session = null;
		List<ViewPpEmppaydetailList> list = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Criteria ctr = session.createCriteria(ViewPpEmppaydetailList.class);
			ctr.add(Restrictions.eq("ppRegistermasterid", registerID));
			ctr.add(Restrictions.eq("rmOfficeid", rmOfficeID));
			ctr.add(Restrictions.eq("isfunctioning", '1'));
			list = ctr.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<ViewPpEmppaydetail> getEmpGenDetail(String ppEmployeeMasterID) {
		Session session = null;
		List<ViewPpEmppaydetail> list = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Criteria ctr = session.createCriteria(ViewPpEmppaydetail.class);
			ctr.add(Restrictions.eq("ppEmployeemasterid",
					Long.parseLong(ppEmployeeMasterID)));
			list = ctr.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
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
				tx.commit();
			}

			else {

				query = session.getNamedQuery(namedQuery);
				list = (List<Object>) query.list();
				tx.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;

	}

	@Override
	/** Populating Combo when Condition datatype is string **/
	public List getComboList(Integer where_condition, String namedQuery) {

		Query query = null;
		List<Object> list = null;

		Session session = sessionFactory.openSession();

		try {
			Transaction transaction = session.beginTransaction();

			if (where_condition != null) {
				query = session.getNamedQuery(namedQuery);
				query.setLong(0, where_condition);
				list = (List<Object>) query.list();
				transaction.commit();
			}

			else {

				query = session.getNamedQuery(namedQuery);
				list = (List<Object>) query.list();
				transaction.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;

	}

	@Override
	public List<?> getList() {
		Session session = null;
		List<SysPaycategory> payCatList = null;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			String sql = "";
			sql += " select distinct sys_PayCategory.sys_PayCategoryID, sys_PayCategory.payCategory,sys_PayCategory.ISPAYSCALEAPPLICABLE "
					+ "from sys_PayCategory ";
			sql += "		inner join pp_PayAlwMaster on pp_PayAlwMaster.sys_PayCategoryID = sys_PayCategory.sys_PayCategoryID ";
			sql += "      inner join pp_PayAlwHead on pp_PayAlwHead.payAlwHeadID = pp_PayAlwMaster.payAlwHeadID ";
			sql += " where pay_Or_Pen = 0 order by sys_PayCategory.sys_PayCategoryID ";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(SysPaycategory.class);
			payCatList = query.list();
			transaction.commit();
			System.out.println("Pay Category List Size : " + payCatList.size());
			session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return payCatList;
	}

	public List<?> getTownCategoryList(String purpose, Short id) {
		Session session = null;
		List<PpTowncategorymaster> list = null;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			String sql = "";
			sql += "SELECT pp_TownCategoryMasterID,categoryType,purpose FROM  pp_TownCategoryMaster WHERE purpose='"
					+ purpose + "' and ";
			sql += "pp_TownCategoryMasterID  in (select pp_TownCategoryMasterID from sys_PayCat_HRACCAMAP where sys_Paycategoryid  = "
					+ id + ") " + "order by CATEGORYTYPE";
			SQLQuery query = session.createSQLQuery(sql);
			System.out.println("SQL : " + sql);
			query.addEntity(PpTowncategorymaster.class);
			list = query.list();
			transaction.commit();
			System.out.println("Size for Towncategory List : " + list.size());
		} catch (Exception e) {
			System.out.println("Exception occured in DAO Class for " + purpose);
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<?> getAlwList(String pp_EmployeeMasterID,
			String sys_PayCategoryID) {
		Session session = null;
		List<ViewPpAllalwlist> empAlwList = null;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			String sql = "select * from ( select distinct * from view_pp_EmpALWList where pp_EmployeeMasterID = '"
					+ pp_EmployeeMasterID
					+ "' and sys_PayCategoryID  = '"
					+ sys_PayCategoryID
					+ "' UNION ALL select  ppah.PayAlwName || '['|| ppah.payAlwShortName ||']' as alwName, "
					+ "GET_PAYALWRULE_CAT(pam.pp_PayAlwMasterID) as alwCategory, pam.pp_PayAlwMasterID, "
					+ pp_EmployeeMasterID
					+ " pp_EmployeeMasterID, pam.sys_PayCategoryID, 0 amount, '1' "
					+ "stop_Alw_Flag from pp_PayAlwMaster pam  inner join pp_PayAlwHead ppah "
					+ "on ppah.payAlwHeadID=pam.payAlwHeadID where pam.sys_PayCategoryID="
					+ sys_PayCategoryID
					+ " AND (ppah.PayAlwName || '['|| ppah.payAlwShortName ||']') "
					+ "not in (select alwName from view_pp_EmpALWList where pp_EmployeeMasterID = '"
					+ pp_EmployeeMasterID
					+ "' and sys_PayCategoryID = '"
					+ sys_PayCategoryID
					+ "'))A  "
					+ "order by pp_PayAlwMasterID";
			SQLQuery query = session.createSQLQuery(sql);
			System.out.println("SQL : " + sql);
			query.addEntity(ViewPpEmpalwlist.class);
			empAlwList = query.list();
			transaction.commit();
			System.out.println("Allowances List Size :" + empAlwList.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return empAlwList;
	}

	@Override
	public boolean updateEmpPayDetail(EmployeePayDetailDTO empPayDetailDTO) {

		Session session = null;
		int result = 0;
		String x = "";

		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection
					.prepareCall("{call PROC_PP_UPDATE_EMPPAYDETAIL(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			stmt.setString(1, empPayDetailDTO.getPp_EmployeeMasterID());
			stmt.setString(2, empPayDetailDTO.getSys_PaymentModeID());
			stmt.setString(3, empPayDetailDTO.getFwa_BankAccountID());
			stmt.setString(4, empPayDetailDTO.getBankAccNo());
			stmt.setString(5, empPayDetailDTO.getSalaryPercent());
			stmt.setString(6, empPayDetailDTO.getNoOfDays());
			stmt.setString(7, empPayDetailDTO.getHeadQuarter());
			stmt.setString(8, empPayDetailDTO.getGpfAcNo());
			stmt.setString(9, empPayDetailDTO.getPanno());
			stmt.setString(10, empPayDetailDTO.getIsnps());
			stmt.setString(11, empPayDetailDTO.getBank_Name());
			stmt.setString(12, empPayDetailDTO.getBranch_Name());
			stmt.setString(13, empPayDetailDTO.getIfsc_code());
			stmt.registerOutParameter(14, Types.VARCHAR);
			boolean result1 = stmt.execute();
			x = stmt.getString(14);
			transaction.commit();
			System.out.println(x + "@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%");
			if (x.equals("1")) {
				return true;
			}

		} catch (Exception e) {

		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public List getList(Long where_condition, String namedQuery) {

		Query query = null;
		List<Object> list = null;

		Session session = sessionFactory.openSession();

		try {
			Transaction transaction = session.beginTransaction();

			if (where_condition != null) {
				query = session.getNamedQuery(namedQuery);
				query.setLong(0, where_condition);
				list = (List<Object>) query.list();
				transaction.commit();
			}

			else {

				query = session.getNamedQuery(namedQuery);
				list = (List<Object>) query.list();
				transaction.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;

	}

	@Override
	public int checkPreviousMonthProcess(String registerID,
			String dateOfEffect, String rmOfficeid, String billType_Flag,
			ModelAndView modelAndView) {
		{
			int isComplete=0;
			String sq = new StringBuilder()
					.append("select count(*) from pp_PayBillDetail where pp_RegisterMasterID='")
					.append(registerID).append("' and rm_OfficeID='")
					.append(rmOfficeid).append("'").toString();

			Session session = sessionFactory.openSession();
			BigDecimal count = null;
			try {

				Query query = session.createSQLQuery(sq);
				List<?> list = query.list();
				Iterator<?> itr = list.iterator();
				while (itr.hasNext()) {
					count = (BigDecimal) itr.next();
				}

				
			
				
				  String sq1 = new StringBuilder() .append(
				 "select count(*) FROM pp_PayBillDetail where TO_DATE('01/'||month||'/'||YEAR,'DD/"
				 + "mm/YYYY') = TO_DATE('").append(dateOfEffect)
				 .append("','DD/MM/YYYY') and billType_Flag='")
				 .append(billType_Flag) .append("' and pp_RegisterMasterId='")
				 .append(registerID).append("' and rm_OfficeID='")
				 .append(rmOfficeid).append("'").toString();
				 

				BigDecimal res = null;
				Query query1 = session.createSQLQuery(sq1);
				List<?> list1 = query1.list();
				Iterator<?> itr1 = list1.iterator();
				while (itr1.hasNext()) {
					res = (BigDecimal) itr1.next();
				}

				String sql = (new StringBuilder())
						.append("select count(*) FROM pp_PayBillDetail where isLocked='0' and pp_RegisterMasterId"
								+ "='").append(registerID)
						.append("' and rm_OfficeID='").append(rmOfficeid)
						.append("'").toString();

				BigDecimal res1 = null;
				Query query2 = session.createSQLQuery(sql);
				List<?> list12 = query2.list();
				Iterator<?> itr2 = list12.iterator();
				while (itr2.hasNext()) {
					res1 = (BigDecimal) itr2.next();
				}
	
	/************  ************/			
				
	String sql4 = "select count(*) from PP_PAYBILLDETAIL where RM_OFFICEID='"+rmOfficeid+"' and PP_REGISTERMASTERID='"+registerID+"' and ISLOCKED='0'"; 

		BigDecimal res4 = null;
		Query query4 = session.createSQLQuery(sql4);
		List<?> list4 = query4.list();
		Iterator<?> itr4 = list4.iterator();
		while (itr4.hasNext()) {
					res4 = (BigDecimal) itr4.next();
	    	}
	
		
		/************  ************/
				String sql2 = "";
				sql2 = (new StringBuilder()).append(sql2)
						.append("select count(*) FROM( ").toString();
				sql2 = (new StringBuilder())
						.append(sql2)
						.append("select pp_PayBillDetailID from pp_PayBillDetail where TO_DATE('01/'||month||"
								+ "'/'||YEAR,'DD/mm/YYYY')=TO_DATE('")
						.append(dateOfEffect)
						.append("','DD/MM/YYYY') AND isLocked='1' and billType_Flag='")
						.append(billType_Flag)
						.append("' and pp_RegisterMasterId='")
						.append(registerID).append("' and rm_OfficeID='")
						.append(rmOfficeid).append("' ").toString();
				sql2 = (new StringBuilder()).append(sql2).append(")")
						.toString();

				BigDecimal res2 = null;
				Query query3 = session.createSQLQuery(sql2);
				List<?> list13 = query3.list();
				Iterator<?> itr3 = list13.iterator();
				while (itr3.hasNext()) {
					res2 = (BigDecimal) itr3.next();
				}
				
				int num = Integer.parseInt(res2 + "");

				if (Integer.parseInt(count + "") > 0) {
					if (Integer.parseInt(res1 + "") > 0 && res.equals("0")) {
						modelAndView
								.addObject("error",
										"Can't Process, As Unlocked Pay Bill For This Register Exists!!");
						System.out
								.println("Can't Process, As Unlocked Pay Bill For This Register Exists!!");
						isComplete = 0;					
					}
								
					else if (num > 0) {
						modelAndView
								.addObject("error",
										"sorry this month salry already processed & locked also !!");
						System.out
								.println("sorry this month salry already processed & locked also !!");
						isComplete = 0;
					}
					
					else if (Integer.parseInt(res4 + "") > 0){
			           modelAndView
			               .addObject("error",
				                 	"Can't Process, An unlocked Bill of this register already exists..!!");
	                   System.out
			               .println("Can't Process, An unlocked Bill of this register already exists..!!");
	                       isComplete = 0;
		            }	
					else
					{
						isComplete = 1;
					}

				} else {
					isComplete = 1;
				}

			} catch (Exception e) {

			} finally {
				session.close();
			}

			return isComplete;

		}
	}

	public List getEmployeeList(String pp_RegisterMasterID, String officeID,
			String payMaonth, String payYear) {
		Query query = null;
		List<ViewPpEmpprocesspaylist> list = null;

		Session session = sessionFactory.openSession();

		String sql = "";
		try {
			sql = (new StringBuilder())
					.append("select * from view_pp_empProcessPayList where pp_RegisterMasterID = ")
					.append(pp_RegisterMasterID)
					.append(" and rm_officeID = '")
					.append(officeID)
					.append("' and (TO_NUMBER(TO_CHAR(appointmentFileDate,'yyyy')) < TO_NUMBER('")
					.append(payYear)
					.append("') or (TO_NUMBER(TO_CHAR(appointmentFileDate,'yyyy')) = TO_NUMBER('")
					.append(payYear)
					.append("')  and TO_NUMBER(TO_CHAR(appointmentFileDate,'mm')) <= TO_NUMBER('")
					.append(payMaonth)
					.append("'))) and isRetired='0' and isFunctioning='1' and salaryPercent<>'0'")
					.toString();
			query = session.createSQLQuery(sql).addEntity(
					ViewPpEmpprocesspaylist.class);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;

	}

	@Override
	public int insertEmployees(String registerID, String rmOfficeid,
			String monthName, String yearName) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int partSalarylist = 0;
		String sql = "";
		sql = " insert into part_salary(PP_EMPLOYEEMASTERID, EMPLOYEECODE, EMPLOYEENAME, RM_OFFICEID, PP_DESIGNATIONMASTERID, DESIGNATION, ISFUNCTIONING, "
				+ "PP_REGISTERMASTERID, MONTH, YEAR) select emp.pp_EmployeeMasterID,emp.employeeCode,emp.FirstName ||' '||emp.MiddleName||' '||emp.LastName as EmployeeName, "
				+ "   emp.rm_officeID,emp.pp_DesignationMasterID,dm.designation,emp.isfunctioning,r.pp_registermasterid,"
				+ monthName
				+ ","
				+ yearName
				+ " from pp_employeemaster emp"
				+ "   INNER JOIN pp_DesignationMaster dm   ON dm.pp_DesignationMasterID=emp.pp_DesignationMasterID "
				+ "   inner join pp_employeepaydetail r on emp.pp_employeemasterid=r.pp_employeemasterid"
				+ "   where emp.rm_officeid="
				+ rmOfficeid
				+ " and emp.isfunctioning=1 and r.pp_registermasterid="
				+ registerID;

		try {
			Query query = session.createSQLQuery(sql);
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return 0;
	}

	@Override
	public String getTotal_employee(String rm_OfficeID,
			String pp_registermasreid) {

		String total_Employee = null;
		List<?> list = null;
		Session session = sessionFactory.openSession();
		String sql = (new StringBuilder())
				.append("select count(employeecode) total_Employee from VIEW_PP_EmpPayDetail_List where P"
						+ "p_RegisterMasterID = '").append(pp_registermasreid)
				.append("' and rm_officeID = '").append(rm_OfficeID)
				.append("' and isfunctioning='1'").toString();
		try {

			Query query = session.createSQLQuery(sql);
			list = query.list();
			Iterator<?> itr = list.iterator();
			while (itr.hasNext()) {
				total_Employee = (BigDecimal) itr.next() + "";
			}
			System.out.print(list.size());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return total_Employee;
	}

	@Override
	public ArrayList<Alw_ForPayCategoryDTO> getAlwEntity(
			String sys_PayCategoryID, String pp_EmployeeMasterID,
			String dateOfEffect) {
		ArrayList<Alw_ForPayCategoryDTO> alwDTOList = new ArrayList<Alw_ForPayCategoryDTO>();
		Session session = sessionFactory.openSession();
		List<PayView> list = null;
		try {

			// list = objDB.findByKey ("PP_PayAlwMaster", "sys_PayCategoryID",
			// sys_PayCategoryID,
			// "com.nic.struts.upjn.ppis.payroll.dto.Alw_ForPayCategoryDTO");
			String sql = "select  pmst.pp_payalwmasterid, phd.payAlwShortName headname, alwctl.STOP_ALW_FLAG ";
			sql += "from pp_payalwmaster pmst inner join pp_payalwhead phd on ";
			sql += "phd.payalwheadid=pmst.payalwheadid left join (SELECT * FROM PP_EMPALWCONTROLLER WHERE ";
			sql += "PP_EMPLOYEEMASTERID="
					+ Integer.parseInt(pp_EmployeeMasterID) + ") alwctl on  ";
			sql += " pmst.pp_payalwmasterid = alwctl.pp_payalwmasterid  where  pmst.sys_paycategoryid="
					+ sys_PayCategoryID;

			Query query = session.createSQLQuery(sql).addEntity(PayView.class);
			list = query.list();

			for (PayView payView : list) {
				Alw_ForPayCategoryDTO alwDTO = new Alw_ForPayCategoryDTO();
				BeanUtils.copyProperties(payView, alwDTO);
				alwDTOList.add(alwDTO);
			}

			for (Alw_ForPayCategoryDTO alwDTO : alwDTOList) {
				alwDTO.setIsCalculated("0");
				alwDTO.setPayValue("0");

				if ((alwDTO.getStop_Alw_Flag() != null)
						&& (alwDTO.getStop_Alw_Flag().equals("1"))) {
					alwDTO.setIsCalculated("1");

				} else {
					String pp_PayAlw_MasterID = alwDTO.getPp_PayAlwMasterID()
							+ "";

					sql = "select sys_RuleCategoryID from pp_RuleMaster where dateOfEffect =(select MAX(dateOfEffect) from pp_RuleMaster where pp_PayAlwMasterID = '"
							+ pp_PayAlw_MasterID
							+ "' And dateOfEffect <= TO_DATE('"
							+ dateOfEffect
							+ "','DD/MM/YYYY')) and pp_PayAlwMasterID = "
							+ pp_PayAlw_MasterID;

					Query query1 = session.createSQLQuery(sql);
					List<?> list1 = query1.list();
					Iterator<?> itr = list1.iterator();
					String Sys_RuleCategoryID = null;
					while (itr.hasNext()) {
						Sys_RuleCategoryID = itr.next() + "";
					}
					alwDTO.setSys_RuleCategoryID(Sys_RuleCategoryID);
					sql = "select PP_RULEMASTERID from pp_RuleMaster where dateOfEffect =(select MAX(dateOfEffect) from pp_RuleMaster where pp_PayAlwMasterID = '"
							+ pp_PayAlw_MasterID
							+ "' And dateOfEffect <= TO_DATE('"
							+ dateOfEffect
							+ "','DD/MM/YYYY')) and pp_PayAlwMasterID = "
							+ pp_PayAlw_MasterID;

					Query query2 = session.createSQLQuery(sql);
					List<?> list2 = query2.list();
					Iterator<?> itr1 = list2.iterator();
					String PP_RULEMASTERID = null;
					while (itr1.hasNext()) {
						PP_RULEMASTERID = itr1.next() + "";
					}

					alwDTO.setPp_RuleMasterID(PP_RULEMASTERID);
					alwDTO.setStop_Alw_Flag("0");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return alwDTOList;

	}

	@Override
	public String getUserInputValue(String pp_EmployeeMasterID,
			String pp_PayAlw_MasterID) {

		Session session = sessionFactory.openSession();
		String amount = null;
		List<PpEmpalwcontroller> list = null;
		try {

			String sql = "select * from pp_EmpAlwController where pp_EmployeeMasterID = '"
					+ pp_EmployeeMasterID
					+ "' And pp_PayAlwMasterID = '"
					+ pp_PayAlw_MasterID + "'";

			Query query = session.createSQLQuery(sql).addEntity(
					PpEmpalwcontroller.class);
			list = query.list();
			for (PpEmpalwcontroller ppEmpalwcontroller : list) {
				amount = ppEmpalwcontroller.getAmount() + "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			amount = "0";
		} finally {
			session.close();
		}

		return amount;

	}

	@Override
	public boolean isSubTypeBased(String sys_RuleCategoryID) {
		boolean subTypeBased = false;

		try {
			if (sys_RuleCategoryID.equals("3")
					|| sys_RuleCategoryID.equals("4"))
				subTypeBased = true;
		} catch (Exception e) {
			System.out.println("Exception Raised while setting isSubTypeBased "
					+ e.toString());
		}
		return subTypeBased;

	}

	@Override
	public List getComponentID(String pp_PayAlwMasterID) {
		List list = null;
		String sql = "";
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		PayAllowanceComponentsDTO pdto = new PayAllowanceComponentsDTO();

		try {

			sql = "select distinct pac.pp_PayAlw_MasterId from pp_RuleMaster rm inner join pp_PayAlw_Components pac on pac.pp_RuleMasterID = rm.pp_RuleMasterID where rm.pp_PayAlwMasterId='"
					+ pp_PayAlwMasterID + "'";

			Query query = session.createSQLQuery(sql);
			list = query.list();
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
	public String getPayAlwName(String pp_PayAlw_MasterID) {
		Session session = sessionFactory.openSession();
		String str = new String();
		String sql = null;
		List list = null;

		Transaction transaction = session.beginTransaction();

		String payAlwName = null;
		try {

			sql = "select ppad.payAlwShortName from pp_PayAlwHead ppad inner join pp_PayAlwMaster ppam on ppam.payAlwHeadID = ppad.payAlwHeadID where pp_PayAlwMasterID='"
					+ pp_PayAlw_MasterID + "'";

			Query query = session.createSQLQuery(sql).addEntity(
					PpEmpalwcontroller.class);
			list = query.list();

			transaction.commit();

			Iterator<?> itr = list.iterator();

			while (itr.hasNext()) {
				payAlwName = (BigDecimal) itr.next() + "";
			}
		} catch (Exception e) {
			System.out.println("Exception Raised in getPayAlwName method "
					+ e.toString());
			payAlwName = "";

		} finally {
			session.close();
		}

		return payAlwName;

	}

	@Override
	public String getStop_Alw_Flag(String pp_EmployeeMasterID,
			String pp_PayAlw_MasterID) {

		List<PpEmpalwcontroller> list = null;

		System.out.println("Inside getStop_Alw_Flag of" + pp_PayAlw_MasterID);
		String stop_Alw_Flag = null;
		String qry;

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		qry = "select * from pp_EmpAlwController where pp_EmployeeMasterID='"
				+ pp_EmployeeMasterID + "' and pp_PayAlwMasterID='"
				+ pp_PayAlw_MasterID + "'";
		System.out.println("Query is this" + qry);
		try {
			Query query = session.createSQLQuery(qry).addEntity(
					PpEmpalwcontroller.class);
			list = query.list();
			transaction.commit();

			for (PpEmpalwcontroller ppEmpalwcontroller : list) {
				stop_Alw_Flag = ppEmpalwcontroller.getStopAlwFlag() + "";
			}

		} catch (Exception e) {
			System.out.println("Exception Raised in getStop_Alw_Flag method "
					+ e.toString());
		}

		finally {
			session.close();
		}
		return stop_Alw_Flag;

	}

	@Override
	public List getRuleMaster(String pp_PayAlwMasterID, String dateOfEffect) {
		List<PpRulemaster> list = null;
		String sql = "";

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {

			sql = "select pp_RuleMasterID,sys_RuleCategoryID,isTownCatBased from pp_RuleMaster where dateOfEffect =(select MAX(dateOfEffect) from pp_RuleMaster where pp_PayAlwMasterID = '"
					+ pp_PayAlwMasterID
					+ "' And dateOfEffect <= TO_DATE('"
					+ dateOfEffect
					+ "','DD/MM/YYYY')) and pp_PayAlwMasterID = "
					+ pp_PayAlwMasterID;

			Query query = session.createSQLQuery(sql).addEntity(
					PpRulemaster.class);
			list = query.list();
			transaction.commit();

		} catch (Exception e) {
			System.out.println("Exception Raised in getStop_Alw_Flag method "
					+ e.toString());
		}

		finally {
			session.close();
		}
		return list;

	}

	@Override
	public String getInputPayRangeAndPercentBased(String payValue,
			String pp_RuleMasterID, Hashtable townCategoryID, String payAlwName) {
		String value = null;
		String percentValue = null;
		List<PpRuledetail> list = null;

		String sql = "";
		String str = new String();
		Session session = sessionFactory.openSession();
		try {

			sql = "select percentValue from pp_RuleDetail where pp_RuleMasterID = '"
					+ pp_RuleMasterID
					+ "' And rangeFrom <= '"
					+ payValue
					+ "' and rangeTo >= '" + payValue + "'";
			System.out.println(sql);
			if (townCategoryID != null) {
				Enumeration enm = townCategoryID.keys();
				while (enm.hasMoreElements()) {
					str = (String) enm.nextElement();
					if (payAlwName.equals(str)) {
						sql = sql + " and pp_TownCategoryMasterID='"
								+ townCategoryID.get(str) + "'";
					}
				}
			}
			Query query = session.createSQLQuery(sql);
			list = query.list();

			Iterator<?> itr = list.iterator();

			while (itr.hasNext()) {
				percentValue = itr.next() + "";
			}

			if (percentValue == null || percentValue.equals("")) {
				percentValue = "0";
			}
			value = ""
					+ ((long) Math.round(Double.parseDouble(payValue)
							* Double.parseDouble(percentValue) / 100));

		} catch (Throwable msqle) {
			System.out.println("MySQLException Raised in " + msqle.toString());

		}

		finally {
			session.close();
		}

		System.out.println("value = " + value);
		return value;

	}

	@Override
	public String getInputPayRangeAndFlatValueBased(String payValue,
			String pp_RuleMasterID, Hashtable townCategoryID,
			String payAlwName, String basicPay) {
		String str = new String();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<?> list = null;
		String flatValue = null;
		String sql = "";
		System.out.println("basic pay" + basicPay);
		try {

			if (townCategoryID != null) {
				Enumeration enm = townCategoryID.keys();
				while (enm.hasMoreElements()) {
					str = (String) enm.nextElement();
					if (payAlwName.equals(str)) {
						if (townCategoryID.get(str).equals("13")
								|| townCategoryID.get(str).equals("14")
								|| townCategoryID.get(str).equals("15")) {
							sql = "select (sum("
									+ payValue
									+ "+"
									+ basicPay
									+ ")*PERCENTAGE/100) value from  PP_OUTSTATE_HRA r where TOWNCATEGORYID='"
									+ townCategoryID.get(str)
									+ "' group by PERCENTAGE ";
							System.out.println("sql++++++++++" + sql);
						} else {
							sql = "select flatAmount from pp_RuleDetail where pp_RuleMasterID = '"
									+ pp_RuleMasterID
									+ "' And rangeFrom <= '"
									+ payValue
									+ "' and rangeTo >= '"
									+ payValue + "' ";
							sql = sql + " and pp_TownCategoryMasterID='"
									+ townCategoryID.get(str) + "'";
						}
					}
				}
			}

			Query query = session.createSQLQuery(sql);

			list = query.list();

			transaction.commit();

			Iterator<?> itr = list.iterator();

			while (itr.hasNext()) {
				flatValue = itr.next() + "";
			}

			if (flatValue == null || flatValue.equals("")) {
				flatValue = "0";
			}

		} catch (Throwable e) {
			System.out
					.println("Exception Raised in getInputPayRangeAndFlatValueBased method "
							+ e.toString());
			flatValue = "0";
		}

		finally {
			session.close();
		}

		return flatValue;
	}

	@Override
	public String getInputEmpCategoryAndPayPercentBased(String payValue,
			String pp_EmploymentSubTypeID, String pp_RuleMasterID,
			Hashtable townCategoryID, String payAlwName) {
		String value = null;
		String percentValue = null;
		String sql = "";
		String str = new String();
		List<PpRuledetail> list = null;

		Session session = sessionFactory.openSession();

		try {

			sql = "select percentValue from pp_RuleDetail where pp_RuleMasterID = '"
					+ pp_RuleMasterID
					+ "' And pp_EmploymentSubTypeID = '"
					+ pp_EmploymentSubTypeID + "'";
			if (townCategoryID != null) {
				Enumeration enm = townCategoryID.keys();
				while (enm.hasMoreElements()) {
					str = (String) enm.nextElement();
					if (payAlwName.equals(str)) {

						sql = sql + " and pp_TownCategoryMasterID='"
								+ townCategoryID.get(str) + "'";
					}
				}
			}

			Query query = session.createSQLQuery(sql);
			list = query.list();

			Iterator<?> itr = list.iterator();

			while (itr.hasNext()) {
				percentValue = itr.next() + "";
			}

			if (percentValue == null || percentValue.equals("")) {
				percentValue = "0";
			}
			value = ""
					+ ((long) Math.round(Double.parseDouble(payValue)
							* Double.parseDouble(percentValue) / 100));

		} catch (Throwable e) {
			System.out
					.println("Exception Raised in getInputEmpCategoryAndPayPercentBased method "
							+ e.toString());
			value = "0";
		} finally {
			session.close();
		}

		return value;

	}

	@Override
	public String getEmpCategoryAndFlatValueBased(
			String pp_EmploymentSubTypeID, String pp_RuleMasterID,
			Hashtable townCategoryID, String payAlwName) {

		String flatValue = null;
		String sql = "";
		String str = new String();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<PpRuledetail> list = null;
		try {

			sql = "select flatAmount from pp_RuleDetail where pp_RuleMasterID = '"
					+ pp_RuleMasterID
					+ "' And pp_EmploymentSubTypeID = '"
					+ pp_EmploymentSubTypeID + "'";

			if (townCategoryID != null) {
				Enumeration enm = townCategoryID.keys();
				while (enm.hasMoreElements()) {
					str = (String) enm.nextElement();
					if (payAlwName.equals(str)) {

						sql = sql + " and pp_TownCategoryMasterID='"
								+ townCategoryID.get(str) + "'";
					}
				}
			}

			Query query = session.createSQLQuery(sql);

			list = query.list();
			transaction.commit();
			Iterator<?> itr = list.iterator();

			while (itr.hasNext()) {
				flatValue = itr.next() + "";
			}

			if (flatValue == null || flatValue.equals("")) {
				flatValue = "0";
			}

		} catch (Throwable e) {
			System.out
					.println("Exception Raised in getEmpCategoryAndFlatValueBased method "
							+ e.toString());
			flatValue = "0";
		}

		finally {
			session.close();
		}

		return flatValue;

	}

	@Override
	public String getFlatForAll(String pp_RuleMasterID,
			Hashtable townCategoryID, String payAlwName) {
		String str = new String();
		String flatValue = null;
		String sql = "";
		Session session = sessionFactory.openSession();

		List<?> list = null;
		try {

			sql = "select flatamount from pp_RuleDetail where pp_RuleMasterID = '"
					+ pp_RuleMasterID + "' ";

			if (townCategoryID != null) {
				Enumeration enm = townCategoryID.keys();
				while (enm.hasMoreElements()) {
					str = (String) enm.nextElement();
					if (payAlwName.equals(str)) {

						sql = sql + " and pp_TownCategoryMasterID='"
								+ townCategoryID.get(str) + "'";
					}
				}
			}

			Query query = session.createSQLQuery(sql);
			list = query.list();

			Iterator<?> itr = list.iterator();

			while (itr.hasNext()) {
				flatValue = itr.next() + "";
			}

			if (flatValue == null || flatValue.equals("")) {
				flatValue = "0";
			}
		} catch (Throwable e) {
			System.out
					.println("Exception Raised in getInputPayRangeAndFlatValueBased method "
							+ e.toString());
			flatValue = "0";
		} finally {
			session.close();
		}

		return flatValue;

	}

	@Override
	public String getNPSvalue(String employeeID, String pp_RuleMasterID) {

		String payAlwName = "";
		String g_pay = "";
		String percentvalue = "";
		String sql = "";
		String sql1 = "";
		String sqlbasic = "";
		String payvalue = "";
		String[] out = null;
		String[] param = new String[2];
		param[0] = employeeID;
		param[1] = pp_RuleMasterID;

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {

			System.out
					.println(" procedure executed ----> PROC_PP_UPDATE_NPS_DED ");

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection
					.prepareCall("{call PROC_PP_UPDATE_NPS_DED(?,?,?)}");
			stmt.setString(1, param[0]);
			stmt.setString(2, param[1]);
			stmt.registerOutParameter(3, Types.VARCHAR);

			int x = stmt.executeUpdate();
			payAlwName = stmt.getString(3);
			transaction.commit();

		} catch (Exception e) {
			System.out.println("Exception Raised in DAO " + e.toString());
		} finally {
			session.close();
		}
		return payAlwName;

	}

	@Override
	public String[] getPayAlwShortName(String[] pp_PayAlw_MasterID,
			String sys_PayCategoryID) {

		String payAlwShortName[] = null;
		String sql = "";

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<?> list = null;

		try {
			sql = "select ppah.payAlwShortName from pp_PayAlwMaster pam inner join pp_payAlwHead pp"
					+ "ah on ppah.payAlwHeadID=pam.payAlwHeadID where pp_PayAlwMasterID in('";
			for (int i = 0; i < pp_PayAlw_MasterID.length; i++) {
				if (i == pp_PayAlw_MasterID.length - 1) {
					sql = (new StringBuilder()).append(sql)
							.append(pp_PayAlw_MasterID[i]).append("')")
							.toString();
				} else {
					sql = (new StringBuilder()).append(sql)
							.append(pp_PayAlw_MasterID[i]).append("','")
							.toString();
				}
			}

			sql = (new StringBuilder()).append(sql)
					.append(" and sys_PayCategoryID = '")
					.append(sys_PayCategoryID).append("'").toString();
			Query query = session.createSQLQuery(sql);

			list = query.list();
			transaction.commit();

			Iterator<?> itr = (Iterator<String>) list.iterator();
			payAlwShortName = new String[list.size()];
			while (itr.hasNext()) {
				for (int i = 0; i < list.size(); i++) {
					payAlwShortName[i] = itr.next() + "";
				}

			}

		} catch (Throwable msqle) {
			throw msqle;
		}

		finally {
			session.close();
		}

		return payAlwShortName;
	}

	@Override
	public List getEmpNPSDetail(String pp_EmployeeMasterID,
			String dateOfEffect, Character billtypeFlag) {

		List<PpNpsdetail> list = null;

		List<NPSDetailDTO> npsList = new ArrayList<NPSDetailDTO>();

		String sql = "";
		Session session = sessionFactory.openSession();

		try {
			sql = (new StringBuilder())
					.append("select * from p"
							+ "p_npsdetail where actual_ded_mon=EXTRACT(month from TO_DATE('")
					.append(dateOfEffect)
					.append("','DD/MM/YYYY')) and actual_ded_year=EXTRACT(year from TO_DATE('")
					.append(dateOfEffect).append("','DD/MM/YYYY'))")
					.append("and pp_employeemasterid='")
					.append(pp_EmployeeMasterID)
					.append("' " + "and IS_STOP_CONTRAMOUNT != 1 ").toString();

			Query query = session.createSQLQuery(sql).addEntity(
					PpNpsdetail.class);

			list = query.list();

			for (PpNpsdetail ppNpsdetail : list) {
				NPSDetailDTO npsDetailDTO = new NPSDetailDTO();
				BeanUtils.copyProperties(ppNpsdetail, npsDetailDTO);
				npsList.add(npsDetailDTO);
			}

		} catch (Throwable sqle) {
		}

		finally {
			session.close();
		}
		return npsList;

	}

	@Override
	public List getEmpLoanDetail(String pp_EmployeeMasterID,
			String dateOfEffect, Character billtypeFlag) {

		List<PpLoandetail> list = null;
		String sql = "";
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		List<LoanDetailDTO> loanList = new ArrayList<LoanDetailDTO>();

		try {
			sql = (new StringBuilder())
					.append("select pp_LoanMasterID, pp_LoanDetailID, Pa_InstallmentAmount, pa_NextInstallmen"
							+ "tNo,firstInstallmentAmount from PP_LoanDetail where pp_EmployeeMasterID='")
					.append(pp_EmployeeMasterID)
					.append("' AND STOP_LOAN='0'  AND STOPINSTALLMENT='0' AND PA_ISFULLYRECOVERED='0' AND TO_DATE('01/'||PA_RECOVCOMME"
							+ "NCEMONTH||'/'||PA_RECOVCOMMENCEYEAR,'DD/MM/YYYY') <= TO_DATE('")
					.append(dateOfEffect)
					.append("','DD/MM/YYYY') and pp_LoanMasterID not in (select tran_TypeID from pp_MonthlyPa"
							+ "y_Tran pmpt inner join pp_MonthlyPay pmp on pmpt.pp_MonthlyPayID=pmp.pp_MonthlyP"
							+ "ayID inner join pp_PayBillDetail on pmp.pp_PayBillDetailID = pp_PayBillDetail.pp"
							+ "_PayBillDetailID where pp_PayBillDetail.billType_Flag <> '")
					.append(billtypeFlag)
					.append("' and pp_EmployeeMasterID='222' and tran_Flag='L' and payMonth=EXTRACT(month fro"
							+ "m TO_DATE('")
					.append(dateOfEffect)
					.append("','DD/MM/YYYY')) and payYear=EXTRACT(year from TO_DATE('")
					.append(dateOfEffect).append("','DD/MM/YYYY')))")
					.toString();

			Query query = session.createSQLQuery(sql).addEntity(
					PpLoandetail.class);

			list = query.list();
			transaction.commit();
			for (PpLoandetail ppLoandetail : list) {
				LoanDetailDTO loanDetailDTO = new LoanDetailDTO();
				BeanUtils.copyProperties(ppLoandetail, loanDetailDTO);
				loanList.add(loanDetailDTO);
			}

			// list = objDB.executeNonQuery(sql,
			// "com.nic.struts.upjn.ppis.payroll.dto.LoanDetailDTO");
		}

		catch (Throwable sqle) {
		} finally {
			session.close();
		}
		return loanList;
	}

	@Override
	public List getEmpDeductionDetail(String pp_EmployeeMasterID,
			String dateOfEffect, Character billtypeFlag) {
		List<PpEmployeededcontroller> list = null;
		String sql = "";
		List<EmployeeDedDetailDTO> dedList = new ArrayList<EmployeeDedDetailDTO>();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			sql = (new StringBuilder())
					.append("select * from pp_EmployeeDedController where pp_EmployeeMasterID=")
					.append(pp_EmployeeMasterID)
					.append("  and stopDeduction!=1 and amount!=0 and pp_DeductionMasterID not in (select tran_TypeID from pp_MonthlyPay_Tran pmp"
							+ "t inner join pp_MonthlyPay pmp on pmpt.pp_MonthlyPayID=pmp.pp_MonthlyPayID inner"
							+ " join pp_PayBillDetail on pmp.pp_PayBillDetailID = pp_PayBillDetail.pp_PayBillDe"
							+ "tailID where pp_PayBillDetail.billType_Flag <> '")
					.append(billtypeFlag)
					.append("' and pp_EmployeeMasterID='")
					.append(pp_EmployeeMasterID)
					.append("' and tran_Flag='D'  and payMonth=EXTRACT(month from TO_DATE('")
					.append(dateOfEffect)
					.append("','DD/MM/YYYY')) and payYear=EXTRACT(year from TO_DATE('")
					.append(dateOfEffect).append("','DD/MM/YYYY')))")
					.toString();

			Query query = session.createSQLQuery(sql).addEntity(
					PpEmployeededcontroller.class);

			list = query.list();
			transaction.commit();
			for (PpEmployeededcontroller ppEmployeededcontroller : list) {
				EmployeeDedDetailDTO employeeDedDetailDTO = new EmployeeDedDetailDTO();
				employeeDedDetailDTO.setAmount(Integer
						.parseInt(ppEmployeededcontroller.getAmnnt() + ""));
				employeeDedDetailDTO
						.setPpEmployeededcontrollerid(ppEmployeededcontroller
								.getPpEmployeecontrollerid());
				employeeDedDetailDTO
						.setPpEmployeemasterid(ppEmployeededcontroller
								.getPpEmployeemasterid());
				employeeDedDetailDTO.setPpDeductionmasterid(Integer
						.parseInt(ppEmployeededcontroller
								.getPp_DeductionMasterID() + ""));
				employeeDedDetailDTO.setStopdeduction(ppEmployeededcontroller
						.getStopDed());
				dedList.add(employeeDedDetailDTO);
			}

		} catch (Throwable msqle) {
			throw msqle;
		}

		finally {
			session.close();
		}

		return dedList;
	}

	@Override
	public boolean insertPayBillDetailIntoDB(PayBillDetailDTO dto, List glist) {
		int lastInsertID = -1000;
		boolean isComplete = false;
		Integer pp_PayBillDetailID = 0;
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
 
		String billTypeFlag = dto.getBilltypeFlag() + "";

		try {

			String sql = "";
			if (billTypeFlag.equals("P")) {

				sql = (new StringBuilder())
						.append("delete from pp_PayBillDetail where year = '")
						.append(dto.getYearName()).append("' and month = '")
						.append(dto.getMonthName())
						.append("' and pp_RegisterMasterID = '")
						.append(dto.getPpRegistermasterid())
						.append("' and rm_OfficeID = '")
						.append(dto.getRmOfficeid())
						.append("' and isLocked = '0' and BILLTYPE_FLAG = '")
						.append(dto.getBilltypeFlag()).append("'").toString();

				Query query = session.createSQLQuery(sql);

				try {

					int result = query.executeUpdate();
					transaction.commit();
					session.clear();
					transaction = session.beginTransaction();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (dto.getBilltypeFlag().equals("A")) {

				sql = (new StringBuilder())
						.append("delete from pp_PayBillDetail where year = '")
						.append(dto.getYearName())
						.append("' and month = '")
						.append(dto.getMonthName())
						.append("' and pp_RegisterMasterID = '")
						.append(dto.getPpRegistermasterid())
						.append("' and rm_OfficeID = '")
						.append(dto.getRmOfficeid())
						.append("' and billClerkID='")
						.append(dto.getBillclerkid())
						.append("' and isLocked = '0' and BILLTYPE_FLAG = '")
						.append(dto.getBilltypeFlag())
						.append("' and pp_PayBillDetailID in (select distinct pp_PayBillDetailID from pp_MonthlyP"
								+ "ay where payMonth='")
						.append(dto.getMonthName()).append("' and payYear='")
						.append(dto.getYearName())
						.append("' and pp_RegisterMasterID='")
						.append(dto.getPp_RegisterMasterID())
						.append("' and pp_EmployeeMasterID='")
						.append(dto.getPp_EmployeeMasterID()).append("')")
						.toString();

				try {
					Query query = session.createSQLQuery(sql);
					int result = query.executeUpdate();
					transaction.commit();
					session.clear();
					transaction = session.beginTransaction();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			Date d = new Date();
			SimpleDateFormat s = new SimpleDateFormat("dd/M/yyyy");
			dto.setBilldate(s.format(d));

			PpPaybilldetail ppPaybilldetail = new PpPaybilldetail();

			BeanUtils.copyProperties(dto, ppPaybilldetail);
			ppPaybilldetail.setMonth(dto.getMonthName());
			ppPaybilldetail.setBilldate(getFormatedDate(dto.getBilldate()));
			ppPaybilldetail.setYear(dto.getYearName());
			ppPaybilldetail.setBillamount("0");
			ppPaybilldetail.setBillclerkid(dto.getBillclerkid());
			ppPaybilldetail.setBillclerkname(dto.getBillclerkname());
			ppPaybilldetail.setPpRegistermasterid(dto.getPpRegistermasterid());
			ppPaybilldetail.setBillno(dto.getBillno());

			ppPaybilldetail.setRmOfficeid(dto.getRmOfficeid());
			session.save(ppPaybilldetail);

			pp_PayBillDetailID = Integer.parseInt(ppPaybilldetail
					.getPpPaybilldetailid() + "");
			pp_PayBillDetailID = pp_PayBillDetailID + 1;
			transaction.commit();
			transaction = session.beginTransaction();

			Iterator iter = glist.iterator();
			PayBillDetailDTO dto1 = null;
			do {
				if (!iter.hasNext()) {
					break;
				}
				isComplete = false;
				dto1 = new PayBillDetailDTO();
				dto1 = (PayBillDetailDTO) iter.next();
				dto1.setPpPaybilldetailid(Long.parseLong(pp_PayBillDetailID
						+ ""));

				dto1.setNetpay(Long.parseLong("0"));
				PpMonthlypay ppMonthlypay = new PpMonthlypay();
				BeanUtils.copyProperties(dto1, ppMonthlypay);

				ppMonthlypay.setPpPaybilldetailid(Long
						.parseLong(pp_PayBillDetailID + ""));
				ppMonthlypay.setPpEmployeemasterid(Long.parseLong(dto1
						.getPpEmployeemasterid() + ""));
				ppMonthlypay.setPaymonth(new Short(dto1.getMonthName() + ""));
				ppMonthlypay.setPayscale(dto1.getPayScale());
				if (dto1.getNoOfDays() != null) {
					ppMonthlypay.setNoofdays(new Short(dto1.getNoOfDays()));
				}

				ppMonthlypay.setPayyear(new Short(dto1.getYearName()));
				ppMonthlypay
						.setPpNetpay(Integer.parseInt(dto1.getNetpay() + ""));
				ppMonthlypay.setPpNetpay(0);
				ppMonthlypay
						.setPpRegistermasterid(dto1.getPpRegistermasterid());
				session.save(ppMonthlypay);
				transaction.commit();
				transaction = session.beginTransaction();
				dto1.setPpPaybilldetailid(Long.parseLong(pp_PayBillDetailID
						+ ""));

				Integer pp_MonthlyPayID = Integer.parseInt(ppMonthlypay
						.getPpMonthlypayid() + "");
				pp_MonthlyPayID = pp_MonthlyPayID + 1;
				isComplete = insertIntoMonthlyPay_Tran(pp_MonthlyPayID + "",
						dto1, session, transaction);
				transaction = session.beginTransaction();

			} while (isComplete);
			if (isComplete) {
				Hashtable hs = new Hashtable();
				hs.put("billAmount",
						(new StringBuilder()).append("")
								.append(Math.round(billAmount)).toString());
				hs.put("netpay",
						(new StringBuilder()).append("")
								.append(Math.round(netpay)).toString());
				isComplete = false;
				PpPaybilldetail paybilldetail = new PpPaybilldetail();
				BeanUtils.copyProperties(dto, paybilldetail);
				paybilldetail.setBillamount(new StringBuilder().append("")
						.append(Math.round(billAmount)).toString());
				paybilldetail.setNetpay(new StringBuilder().append("")
						.append(Math.round(netpay)).toString());
				paybilldetail.setPpPaybilldetailid(Long
						.parseLong(pp_PayBillDetailID + ""));
				paybilldetail.setMonth(dto.getMonthName());
				paybilldetail.setYear(dto.getYearName());
				paybilldetail.setIslocked(dto.getIslocked());
				paybilldetail.setRmOfficeid(dto.getRmOfficeid());
				paybilldetail.setBillno(dto.getBillno());

				paybilldetail.setBilldate(getFormatedDate(dto.getBilldate()));

				session.createCriteria(pp_PayBillDetailID + "");

				session.update(paybilldetail);

				transaction.commit();
				// paybilldetail.setBillamount("0");

				billAmount = 0.0D;
				isComplete = true;
				netpay = 0.0D;
			}

		} catch (Throwable ue) {

			System.out.println("Transaction Failed............." + ue);

		} finally {

			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return isComplete;
	}

	public boolean insertIntoMonthlyPay_Tran(String pp_MonthlyPayID,
			PayBillDetailDTO dto1, Session session, Transaction transaction)
			throws UtillException, Exception {
		int lastInsertID = -1000;
		int lastInsertID1 = -1000;
		boolean flag = true;
		boolean isComplete = false;
		double total = 0.0D;
		double nettotal = 0.0D;
		String insertAllSQL = "INSERT ALL ";
		String subSql = "";

		try {
			for (int x = 0; x < dto1.getPp_PayAlw_MasterID().length; x++) {
				subSql = (new StringBuilder())
						.append(subSql)
						.append(" INTO PP_MONTHLYPAY_TRAN (PP_MONTHLYPAYID,TRAN_TYPEID,RATE,AMOUNT,TRAN_FLAG) VAL"
								+ "UES (").toString();
				subSql = (new StringBuilder()).append(subSql).append("'")
						.append(pp_MonthlyPayID).append("', ").toString();
				subSql = (new StringBuilder()).append(subSql).append("'")
						.append(dto1.getPp_PayAlw_MasterID()[x]).append("', ")
						.toString();
				subSql = (new StringBuilder()).append(subSql).append("'")
						.append(dto1.getPp_PayAlw_Value()[x]).append("', ")
						.toString();
				String amt = calculatePayAmount(dto1.getMonthName(),
						dto1.getYearName(), dto1.getNoOfDays(),
						dto1.getSalaryPercent(), dto1.getPp_PayAlw_Value()[x],
						dto1.getPp_EmployeeMasterID(),
						dto1.getPp_PayAlw_MasterID()[x]);
				subSql = (new StringBuilder()).append(subSql).append("'")
						.append(amt).append("', ").toString();
				subSql = (new StringBuilder()).append(subSql).append("'A'")
						.toString();
				subSql = (new StringBuilder()).append(subSql).append(")")
						.toString();
				total += Double.parseDouble(amt);
			}

			nettotal += total;
			System.out.println((new StringBuilder())
					.append("Gross Total is = ").append(total).toString());
			for (int x = 0; x < dto1.getPp_LoanDetailID().length; x++) {
				subSql = (new StringBuilder())
						.append(subSql)
						.append(" INTO PP_MONTHLYPAY_TRAN (PP_MONTHLYPAYID,TRAN_TYPEID,AMOUNT,TRAN_FLAG,INSTALLME"
								+ "NT_NO) VALUES (").toString();
				subSql = (new StringBuilder()).append(subSql).append("'")
						.append(pp_MonthlyPayID).append("', ").toString();
				subSql = (new StringBuilder()).append(subSql).append("'")
						.append(dto1.getPp_LoanDetailID()[x]).append("', ")
						.toString();
				subSql = (new StringBuilder()).append(subSql).append("'")
						.append(dto1.getLoanAmount()[x]).append("', ")
						.toString();
				subSql = (new StringBuilder()).append(subSql).append("'L', ")
						.toString();
				subSql = (new StringBuilder()).append(subSql).append("'")
						.append(dto1.getPa_NextInstallmentNo()[x]).append("'")
						.toString();
				subSql = (new StringBuilder()).append(subSql).append(")")
						.toString();
				total -= Double.parseDouble(dto1.getLoanAmount()[x]);
			}

			for (int x = 0; x < dto1.getPp_NpsDetailID().length; x++) {
				subSql = (new StringBuilder())
						.append(subSql)
						.append(" INTO PP_MONTHLYPAY_TRAN (PP_MONTHLYPAYID,TRAN_TYPEID,AMOUNT,TRAN_FLAG,INSTALLME"
								+ "NT_NO) VALUES (").toString();
				subSql = (new StringBuilder()).append(subSql).append("'")
						.append(pp_MonthlyPayID).append("', ").toString();
				subSql = (new StringBuilder()).append(subSql).append("'")
						.append(dto1.getPp_NpsDetailID()[x]).append("', ")
						.toString();
				subSql = (new StringBuilder()).append(subSql).append("'")
						.append(dto1.getNpsamount()[x]).append("', ")
						.toString();
				subSql = (new StringBuilder()).append(subSql).append("'N', ")
						.toString();
				subSql = (new StringBuilder()).append(subSql).append("'0'")
						.toString();
				subSql = (new StringBuilder()).append(subSql).append(")")
						.toString();
				if (Integer.parseInt(dto1.getPp_NpsDetailID()[x]) != 100) {
					total -= Double.parseDouble(dto1.getNpsamount()[x]);
				}
			}

			System.out.println((new StringBuilder())
					.append("Gross - Tot.Loan Recovey is = ").append(total)
					.toString());
			for (int x = 0; x < dto1.getPp_DedDetailID().length; x++) {
				subSql = (new StringBuilder())
						.append(subSql)
						.append(" INTO PP_MONTHLYPAY_TRAN (PP_MONTHLYPAYID,TRAN_TYPEID,AMOUNT,TRAN_FLAG,INSTALLME"
								+ "NT_NO) VALUES (").toString();
				subSql = (new StringBuilder()).append(subSql).append("'")
						.append(pp_MonthlyPayID).append("', ").toString();
				subSql = (new StringBuilder()).append(subSql).append("'")
						.append(dto1.getPp_DedDetailID()[x]).append("', ")
						.toString();
				subSql = (new StringBuilder()).append(subSql).append("'")
						.append(dto1.getDedAmount()[x]).append("', ")
						.toString();
				subSql = (new StringBuilder()).append(subSql).append("'D', ")
						.toString();
				subSql = (new StringBuilder()).append(subSql).append("'0') ")
						.toString();
				System.out.println((new StringBuilder())
						.append("to test the value of trn type")
						.append(dto1.getPp_DedDetailID()[x]).toString());
				if (Integer.parseInt(dto1.getPp_DedDetailID()[x]) != 38) {
					total -= Double.parseDouble(dto1.getDedAmount()[x]);
				}
			}

			System.out.println((new StringBuilder()).append("Net Pay is = ")
					.append(total).toString());
			insertAllSQL = (new StringBuilder()).append(insertAllSQL)
					.append(subSql).append(" SELECT * FROM DUAL").toString();
			System.out.println((new StringBuilder()).append("SQL = ")
					.append(insertAllSQL).toString());

			Query query = session.createSQLQuery(insertAllSQL);
			int result = query.executeUpdate();
			transaction.commit();
			transaction = session.beginTransaction();

			flag = true;
			System.out.println("error while inserting transaction records!");

			if (flag && total >= 0.0D) {
				Hashtable hs = new Hashtable();
				hs.put("pp_NetPay",
						(new StringBuilder()).append("")
								.append(Math.round(total)).toString());
				billAmount += total;
				netpay += nettotal;

				String pp_NetPay = new StringBuilder().append("")
						.append(Math.round(total)).toString();

				int pp_netPay = Integer.parseInt(pp_NetPay);
				PpMonthlypay ppMonthlypay = new PpMonthlypay();
				ppMonthlypay.setPpNetpay(pp_netPay);

				ppMonthlypay.setPpMonthlypayid(Long.parseLong(pp_MonthlyPayID));
				ppMonthlypay.setPpPaybilldetailid(dto1.getPpPaybilldetailid());
				ppMonthlypay.setPpEmployeemasterid(Long.parseLong(dto1
						.getPpEmployeemasterid() + ""));
				ppMonthlypay.setPaymonth(new Short(dto1.getMonthName() + ""));
				ppMonthlypay.setPayscale(dto1.getPayScale());
				ppMonthlypay
						.setPpRegistermasterid(dto1.getPpRegistermasterid());
				if (dto1.getNoOfDays() != null) {
					ppMonthlypay.setNoofdays(new Short(dto1.getNoOfDays()));
				}

				ppMonthlypay.setPayyear(new Short(dto1.getYearName()));

				session.createCriteria(pp_MonthlyPayID);
				session.update(ppMonthlypay);
				transaction.commit();

				isComplete = true;

			} else {
				throw new UtillException(
						(new StringBuilder())
								.append("Pay Bill can not be process due to invalid data for EmployeeCode ")
								.append(dto1.getEmployeeCode()).toString());
			}
		} catch (UtillException ue) {
			System.out.println((new StringBuilder()).append("UtilException = ")
					.append(ue.getMessage()).toString());
			throw ue;
		} catch (Exception e) {
			System.out.println((new StringBuilder())
					.append("Exception raised is*** ").append(e.toString())
					.toString());
			throw new UtillException(
					(new StringBuilder())
							.append("Pay Bill can not be process due to invalid data for EmployeeCode ")
							.append(dto1.getEmployeeCode()).toString());
		}

		finally {

		}
		return isComplete;
	}

	public String calculatePayAmount(String month, String year,
			String noOfDays, String salaryPercent, String payAlwRate,
			String pp_EmployeeMasterID, String pp_PayAlw_MasterID) {
		double calAmt = 0.0D;
		boolean isComplete = false;
		try {
			GregorianCalendar cal = new GregorianCalendar(
					Integer.parseInt(year), Integer.parseInt(month) - 1, 1);
			int maxDaysInMonth = cal.getActualMaximum(5);
			int noOfDay = 0;
			try {
				if (noOfDays.equals("")) {
					noOfDay = maxDaysInMonth;
				} else {
					noOfDay = Integer.parseInt(noOfDays);
				}
			} catch (NullPointerException npe) {
				noOfDay = maxDaysInMonth;
			}
			if (noOfDay > maxDaysInMonth) {
				noOfDay = maxDaysInMonth;
			}
			calAmt = ((((Double.parseDouble(payAlwRate) + 0.0D) * Double
					.parseDouble((new StringBuilder()).append("")
							.append(noOfDay).toString())) / Double
					.parseDouble((new StringBuilder()).append("")
							.append(maxDaysInMonth).toString())) * Double
					.parseDouble(salaryPercent)) / 100D;
		} catch (Exception e) {
			calAmt = 0.0D;
			System.out.println((new StringBuilder())
					.append("Exception raised ").append(e.toString())
					.toString());
		}
		return (new StringBuilder()).append("").append(Math.round(calAmt))
				.toString();
	}

	public Date getFormatedDate(String currentDate) {
		Date date = null;
		try {

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			date = df.parse(currentDate);

		} catch (Exception ex) {
			System.out.println("Parse Exception");
		}
		return date;
	}

	/** ------------VIKAS code Starts here----------- **/

	@Override
	public boolean addAllowance(PayAlwDTO payAlwDTO) {

		boolean iscomplete = false;
		int lastDeletedID = 0;
		Session session = null;
		Transaction tx = null;
		boolean result = false;

		try {
			if (this.addEmpPayDetails(payAlwDTO)) {
				String[] ids = payAlwDTO.getPpPayalwmasterid();
				String[] chkAuto = payAlwDTO.getChkAuto();
				String[] amount = payAlwDTO.getAmount();
				session = sessionFactory.openSession();
				tx = session.beginTransaction();
				/* For delete operation */

				String sql = "Delete FROM PP_EMPALWCONTROLLER WHERE pp_EmployeeMasterID= '"
						+ payAlwDTO.getPpEmployeemasterid() + "'";
				SQLQuery query = session.createSQLQuery(sql);
				query.executeUpdate();

				lastDeletedID = 1;
				if (lastDeletedID == 1) {
					for (int kk = 0; kk < amount.length; kk++) {
						String[] params = new String[3];

						params[0] = payAlwDTO.getPpEmployeemasterid() + "";
						params[1] = amount[kk];
						params[2] = ids[kk]; /*
											 * .substring(0,
											 * ids[kk].indexOf("|"));
											 */

						System.out
								.println("procedure execution started ----> PP_PROC_ADD_EMP_ALW");

						SessionImplementor sessionImplementor = (SessionImplementor) session;
						java.sql.Connection connection = sessionImplementor
								.connection();
						CallableStatement stmt = connection
								.prepareCall("{call PP_PROC_ADD_EMP_ALW(?,?,?,?)}");
						stmt.setString(1, params[0]);
						stmt.setString(2, params[1]);
						stmt.setString(3, params[2]);
						stmt.registerOutParameter(4, Types.VARCHAR);

						result = stmt.execute();

						String x = stmt.getString(4);

						System.out.println(x + "-- value of X");

						String y = x;
						System.out.println("The output value is - " + x
								+ "-- y - " + y);
						if (y.equals("1")) {
							if (x.equals("1")) {
								iscomplete = true;
							} else {
								iscomplete = false;
							}
							if (iscomplete == false)
								break;
						}
					}
					// start code for stop alw here

					if (iscomplete == true) {
						String[] params1 = new String[2];
						params1[0] = payAlwDTO.getPpEmployeemasterid() + "";
						params1[1] = payAlwDTO.getStop_Alw_Flag();

						/*
						 * String alwflag[] =payAlwDTO.getStopAlwFlag(); for(int
						 * i=0;i<alwflag.length;i++) { params1[i] =
						 * payAlwDTO.getStopAlwFlag(); }
						 */

						System.out
								.println(" procedure execution started ----> PROC_PP_STOP_ALW"
										+ params1[1]);

						SessionImplementor sessionImplementor1 = (SessionImplementor) session;
						java.sql.Connection connection1 = sessionImplementor1
								.connection();
						CallableStatement stmt1 = connection1
								.prepareCall("{call PROC_PP_STOP_ALW(?,?,?)}");
						stmt1.setString(1, params1[0]);
						stmt1.setString(2, params1[1]);

						stmt1.registerOutParameter(3, Types.VARCHAR);

						result = stmt1.execute();
						String x1 = stmt1.getString(3);
						String y1 = x1;
						System.out.println("The output value is - " + x1
								+ "-- y - " + y1);

						if (y1.equals("1")) {
							if (x1.equals("1")) {
								iscomplete = true;
							} else {
								iscomplete = false;
							}
						}
						// end code for stop alw here

					}

					if (iscomplete == true) {

						String sql2 = "UPDATE PP_EmployeePayDetail Set hraTownCategoryID='"
								+ payAlwDTO.getHraTownCategoryID()
								+ "', ccaTownCategoryID = '"
								+ payAlwDTO.getCcaTownCategoryID()
								+ "' WHERE Pp_EmployeeMasterID ='"
								+ payAlwDTO.getPpEmployeemasterid() + "'";

						Query sql1 = session.createSQLQuery(sql2);

						System.out.println("The Update SQL is -- " + sql1);

						sql1.executeUpdate();

						iscomplete = true;
					}
				}
			}
			tx.commit();
			System.out.println("Transaction completed Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			iscomplete = false;

		} finally {
			session.close();
		}
		return iscomplete;
	}

	private boolean addEmpPayDetails(PayAlwDTO payAlwDTO) {

		boolean iscomplete = false;
		Session session = null;
		try {

			int result = 0;

			System.out
					.println(" procedure execution started ----> PROC_PP_UPDATE_INCREMENT ");

			session = sessionFactory.openSession();
			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection
					.prepareCall("{call PROC_PP_UPDATE_INCREMENT(?,?,?,?,?,?)}");

			stmt.setString(1, payAlwDTO.getPpEmployeemasterid() + "");
			stmt.setString(2, payAlwDTO.getNextIncrementMonth());
			stmt.setString(3, payAlwDTO.getPp_PayScaleMasterID());
			stmt.setString(4, payAlwDTO.getSys_PayCategoryID() + "");
			stmt.setString(5, payAlwDTO.getDefaultIncrementAmount() + "");
			stmt.registerOutParameter(6, Types.VARCHAR);

			result = stmt.executeUpdate();
			String x = stmt.getString(6);
			System.out.println("The output value is - " + x);
			if (result == 1) {
				iscomplete = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return iscomplete;
	}

	@Override
	public boolean addEmpGPFDetails(Long ppEmployeemasterid) {

		boolean iscomplete = false;
		Session session = null;
		try {

			boolean result = false;

			System.out
					.println(" procedure execution started ----> PROC_PP_UPDATE_GPF_DED ");

			session = sessionFactory.openSession();
			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection
					.prepareCall("{call PROC_PP_UPDATE_GPF_DED(?,?)}");

			stmt.setString(1, ppEmployeemasterid + "");
			stmt.registerOutParameter(2, Types.VARCHAR);

			result = stmt.execute();
			String x = stmt.getString(2);
			System.out.println("The output value is - " + x);
			if (result == true) {
				iscomplete = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return iscomplete;
	}

	@Override
	public List getISndpsCompleted(String ppEmployeeMasterID) {
		List isnpscompleted = null;
		Session session = null;

		try {
			session = sessionFactory.openSession();
			String sql = " select count(*) from VIEW_PP_NPSDETAIL where LTRIM(TO_CHAR(STARTMON_FORREGULAR_CONT,'mm'),0)=mon_contr and TO_CHAR(STARTMON_FORREGULAR_CONT,'yyyy')=year_contr and pp_EmployeeMasterID="
					+ ppEmployeeMasterID;

			SQLQuery query = session.createSQLQuery(sql);
			System.out.println("SQL : " + sql);
			/* query.addEntity(ViewPpNpsdetail.class); */
			isnpscompleted = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isnpscompleted;
	}

	@Override
	public List getPayAlwName1(String ppEmployeeMasterID) {
		List payalwname = null;
		Session session = null;
		int result = 0;

		try {
			session = sessionFactory.openSession();
			String sql = "select (pac.amount)*10/100 as amount from pp_PayAlwMaster pam INNER JOIN pp_EmpAlwController pac ON pac.pp_PayAlwMasterID=pam.pp_PayAlwMasterID inner join pp_PayAlwHead ppah on ppah.payAlwHeadID=pam.payAlwHeadID where pp_EmployeeMasterID='"
					+ ppEmployeeMasterID + "' and payalwname='Basic Pay'";

			SQLQuery query = session.createSQLQuery(sql);
			System.out.println("SQL : " + sql);
			payalwname = query.list();

			/* Executing procedure PROC_PP_UPDATE_GPF_DED */
			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection
					.prepareCall("{call PROC_PP_UPDATE_GPF_DED(?,?)}");

			stmt.setString(1, ppEmployeeMasterID);
			stmt.registerOutParameter(2, Types.VARCHAR);

			result = stmt.executeUpdate();
			String x = stmt.getString(2);
			System.out.println("The output value is - " + x);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return payalwname;
	}

	@Override
	public List getEmployeeDedDetail(String ppEmployeeMasterID) {
		List empdedlist = null;
		Session session = null;

		try {
			session = sessionFactory.openSession();
			String sql = "select * from(select * from VIEW_PP_EMPDEDDETAIL where PP_EMPLOYEEMASTERID='"
					+ ppEmployeeMasterID
					+ "' UNION ALL  select "
					+ ppEmployeeMasterID
					+ "  PP_EMPLOYEEMASTERID, pdm.pp_DeductionMasterID, pdm.dedShortName, pdm.DEDUCTIONNAME, pdm.PRINT_ORDER, 0 amount, '0' STOPDEDDUCTION from pp_DeductionMaster pdm where pdm.pp_DeductionMasterID not in(select pp_DeductionMasterID from VIEW_PP_EMPDEDDETAIL where PP_EMPLOYEEMASTERID='"
					+ ppEmployeeMasterID + "'))A order by PRINT_ORDER";

			SQLQuery query = session.createSQLQuery(sql);
			System.out.println("SQL : " + sql);
			query.addEntity(ViewPpEmpdeddetail.class);
			empdedlist = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return empdedlist;
	}

	@Override
	public boolean addEmpDedDetail(DedDetailDTO dedDetailDTO, String[] param) {

		Session session = null;
		boolean isCompleted = false;
		boolean isCompleted1 = false;
		boolean isCompleted2 = false;
		int out = 0;

		try {

			if (dedDetailDTO.getStopDed().length() == 0) {
				System.out
						.println(" procedure executed ----> PROC_PP_UPDATE_EMPDEDDETAIL ");

				/* Executing procedure PROC_PP_UPDATE_EMPDEDDETAIL */
				session = sessionFactory.openSession();
				SessionImplementor sessionImplementor = (SessionImplementor) session;
				java.sql.Connection connection = sessionImplementor
						.connection();
				CallableStatement stmt = connection
						.prepareCall("{call PROC_PP_UPDATE_EMPDEDDETAIL(?,?,?,?)}");

				stmt.setString(1, dedDetailDTO.getPpEmployeemasterid() + "");
				stmt.setString(2, dedDetailDTO.getPp_DeductionMasterID());
				stmt.setString(3, dedDetailDTO.getAmnnt());
				stmt.registerOutParameter(4, Types.VARCHAR);

				out = stmt.executeUpdate();
				String x = stmt.getString(4);
				System.out.println("The output value is - " + x);

				System.out
						.println("--Executing SQL to update PP_EMPLOYEEDEDCONTROLLER--");

				session = sessionFactory.openSession();
				String sql = "update PP_EMPLOYEEDEDCONTROLLER set STOPDEDUCTION=0 where PP_EMPLOYEEMASTERID="
						+ dedDetailDTO.getPpEmployeemasterid();
				SQLQuery query = session.createSQLQuery(sql);
				System.out.println("SQL : " + sql);
				query.addEntity(PpEmployeededcontroller.class);

				System.out.println("---- all done---");
				isCompleted = true;
			} else {
				System.out
						.println(" procedure executed ----> PROC_PP_UPDATE_EMPDEDDETAIL");
				/* Executing procedure PROC_PP_UPDATE_EMPDEDDETAIL */
				session = sessionFactory.openSession();
				SessionImplementor sessionImplementor = (SessionImplementor) session;
				java.sql.Connection connection = sessionImplementor
						.connection();
				CallableStatement stmt = connection
						.prepareCall("{call PROC_PP_UPDATE_EMPDEDDETAIL(?,?,?,?)}");

				stmt.setString(1, dedDetailDTO.getPpEmployeemasterid() + "");
				stmt.setString(2, dedDetailDTO.getPp_DeductionMasterID());
				stmt.setString(3, dedDetailDTO.getAmnnt());
				stmt.registerOutParameter(4, Types.VARCHAR);

				out = stmt.executeUpdate();
				String x = stmt.getString(4);
				System.out.println("The output value is - " + x);

				if (x.equals("1")) {
					isCompleted1 = true;
				} else {
					isCompleted1 = false;
				}

				if (isCompleted1 == true) {
					System.out
							.println(" procedure executed ----> PROC_PP_UNSTOP_DED");

					/* Executing procedure PROC_PP_UNSTOP_DED */
					session = sessionFactory.openSession();
					SessionImplementor sessionImplementor1 = (SessionImplementor) session;
					java.sql.Connection connection1 = sessionImplementor1
							.connection();
					CallableStatement stmt1 = connection1
							.prepareCall("{call PROC_PP_UNSTOP_DED(?,?,?)}");

					stmt1.setString(1, dedDetailDTO.getPpEmployeemasterid()
							+ "");
					stmt1.setString(2, dedDetailDTO.getPp_DeductionMasterID());
					stmt1.registerOutParameter(3, Types.VARCHAR);

					out = stmt1.executeUpdate();
					String x1 = stmt1.getString(3);
					System.out.println("The output value is - " + x1);

					if (x1.equals("1")) {
						isCompleted2 = true;
					} else {
						isCompleted2 = false;
					}
				}

				if (isCompleted2 == true) {
					System.out
							.println(" procedure executed ----> PROC_PP_STOP_DED");

					/* Executing procedure PROC_PP_STOP_DED */
					session = sessionFactory.openSession();
					SessionImplementor sessionImplementor2 = (SessionImplementor) session;
					java.sql.Connection connection2 = sessionImplementor2
							.connection();
					CallableStatement stmt2 = connection2
							.prepareCall("{call PROC_PP_STOP_DED(?,?,?)}");

					stmt2.setString(1, dedDetailDTO.getPpEmployeemasterid()
							+ "");
					stmt2.setString(2, dedDetailDTO.getPp_DeductionMasterID());
					stmt2.registerOutParameter(3, Types.VARCHAR);

					out = stmt2.executeUpdate();
					String x2 = stmt2.getString(3);
					System.out.println("The output value is - " + x2);

					if (x2.equals("1")) {
						isCompleted = true;
					} else {
						isCompleted = false;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isCompleted;

	}

	/** ------------VIKAS code Ends here----------- **/

	/** ------------ Ram Code Start Here ----------- **/

	public List populateLoanMasterCombo(String empMasterID,
			String pp_LoanDetailID) throws Exception {
		List<PpLoanEntity> list = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if (pp_LoanDetailID == null) {
			pp_LoanDetailID = "";
		}

		String sql = "";
		try {

			sql = (new StringBuilder())
					.append("select pp_LoanMasterID,loanName,loanShortName,max_InstallmentNo from pp_LoanMast"
							+ "er where  pp_LoanMasterID not in (select pp_LoanMasterID from pp_LoanDetail wher"
							+ "e pp_EmployeeMasterID='")
					.append(empMasterID)
					.append("' and pa_isfullyrecovered='0') or loanShortName='GPF' or pp_LoanMasterID=(select"
							+ " pp_LoanMasterID from PP_LOANDETAIL where pp_LoanDetailID='")
					.append(pp_LoanDetailID).append("') order by loanName")
					.toString();
			Query query = session.createSQLQuery(sql).addEntity(
					PpLoanEntity.class);
			list = query.list();
			transaction.commit();

		} catch (Exception msqle) {
			throw msqle;
		}

		finally {
			session.close();
		}
		return list;
	}

	public String[] isBearingLoan(String pp_EmployeeMasterID,
			String pp_LoanMasterID) {
		String param[] = new String[2];
		String out[] = new String[2];
		param[0] = pp_EmployeeMasterID;
		param[1] = pp_LoanMasterID;
		Session session = sessionFactory.openSession();
		try {
			System.out
					.println("Procedure execeuted here ---> PROC_EMPLOYEELOANTYPE");

			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection
					.prepareCall("{call PROC_EmployeeLoanType(?,?,?,?)}");
			stmt.setString(1, pp_EmployeeMasterID);
			stmt.setString(2, pp_LoanMasterID);

			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.registerOutParameter(4, Types.VARCHAR);

			boolean result1 = stmt.execute();
			out[0] = stmt.getString(3);
			out[1] = stmt.getString(4);
			transaction.commit();

		} catch (Exception e) {
			System.out.println((new StringBuilder())
					.append("Exception raised is ").append(e).toString());
		}

		finally {
			session.close();
		}
		return out;
	}

	public boolean insertLoanSanction(LoanSanctionDTO dto) {

		boolean isComplete = false;

		Session session = sessionFactory.openSession();

		PpLoandetail ppLoandetail = new PpLoandetail();
		BeanUtils.copyProperties(dto, ppLoandetail);
		ppLoandetail.setPpEmployeemasterid(Long.parseLong(dto
				.getPp_EmployeeMasterID()));
		ppLoandetail.setFirstinstallmentamount(Integer.parseInt(dto
				.getFirstinstallmentamount()));
		ppLoandetail.setLoanamount(Integer.parseInt(dto.getLoanAmount()));
		ppLoandetail.setLoansanctionordno(dto.getLoanSanctionOrdNo());
		ppLoandetail.setLoanshortname(dto.getLoanShortName());
		ppLoandetail.setPaRecovcommencemonth(new Short(dto.getMonthName()));
		ppLoandetail.setPaRecovcommenceyear(new Short(dto.getYearName()));
		if (dto.getPa_IsFullyRecovered().equals("1")) {
			ppLoandetail.setPaIsfullyrecovered('1');
			;
		} else {
			ppLoandetail.setPaIsfullyrecovered('0');
			;
		}
		ppLoandetail.setPaNextinstallmentno(new Short(dto
				.getPaNextinstallmentno()));
		ppLoandetail.setPaRecovered(Integer.parseInt(dto.getPa_Recovered()));
		ppLoandetail.setPaNoofinstallments(new Short(dto
				.getPa_NoOfInstallments()));
		ppLoandetail.setPaInstallmentamount(Integer.parseInt(dto
				.getPaInstallmentamount()));
		ppLoandetail.setSanctiondate(new ComboService().getFormatedDate(dto
				.getSanctionDate()));
		if (dto.getStopInstallment().equals("1")) {
			ppLoandetail.setStopLoan('1');

		}

		else {
			ppLoandetail.setStopLoan('0');
		}

		try {
			ppLoandetail.setPpLoanmasterid(Integer.parseInt(dto
					.getPpLoanmasterid()));
			ppLoandetail.setIsinterest('N');
			ppLoandetail.setIseditable('N');
			Transaction transaction = session.beginTransaction();
			session.createCriteria(ppLoandetail.getPpEmployeemasterid()
					.toString());
			session.save(ppLoandetail);
			transaction.commit();

			if (!ppLoandetail.getPpLoandetailid().equals("")) {
				isComplete = true;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			session.close();
		}
		return isComplete;
	}

	public boolean deleteLoanSanction(String pp_LoanDetailID)

	{
		boolean isComplete = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		PpLoandetail ppLoandetail = new PpLoandetail();
		ppLoandetail.setPpLoandetailid(Long.parseLong(pp_LoanDetailID));
		try {

			session.createCriteria(PpLoandetail.class,
					ppLoandetail.getPpLoandetailid() + "");
			session.delete(ppLoandetail);
			transaction.commit();
			ppLoandetail.setPpLoandetailid(null);

			if (ppLoandetail.getPpLoandetailid() == null) {
				isComplete = true;
			}
			if (isComplete) {
				System.out.println("Transactions done successfully....");

			} else {
				System.out.println(" Transaction failed....");

			}

		} catch (Exception sqle) {
		} finally {
			session.close();
		}
		return isComplete;
	}

	@Override
	public List retrieveLoanSanction(String pp_LoanDetailID) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<LoanSanctionEntity> list = null;

		try {
			String sql = (new StringBuilder())
					.append("SELECT loanAmount, loanSanctionOrdNo, PP_LoanDetail.loanShortName, pa_Installmen"
							+ "tAmount,firstinstallmentAmount, pa_IsFullyRecovered,STOP_LOAN, pa_NextInstallmentNo, pa_NoOfInstallments, pa_Reco"
							+ "vCommenceMonth, pa_RecovCommenceYear, pa_Recovered, pp_EmployeeMasterID, pp_Loan"
							+ "DetailID, PP_LoanDetail.pp_LoanMasterID, TO_CHAR(sanctionDate,'dd/mm/yyyy') sanc"
							+ "tionDate, stop_Loan,max_InstallmentNo, isInterest FROM PP_LoanDetail inner join "
							+ "pp_LoanMaster on PP_LoanDetail.pp_LoanMasterID=pp_LoanMaster.pp_LoanMasterID WHE"
							+ "RE PP_LoanDetailID='").append(pp_LoanDetailID)
					.append("'").toString();

			Query query = session.createSQLQuery(sql).addEntity(
					LoanSanctionEntity.class);
			list = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public boolean updateLoanSanction(LoanSanctionDTO dto) {

		boolean isComplete = false;
		PpLoandetail ppLoandetail = new PpLoandetail();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			BeanUtils.copyProperties(dto, ppLoandetail);
			ppLoandetail.setPpEmployeemasterid(Long.parseLong(dto
					.getPp_EmployeeMasterID()));
			ppLoandetail.setPpLoandetailid(Long.parseLong(dto
					.getPpLoandetailid()));
			ppLoandetail.setFirstinstallmentamount(Integer.parseInt(dto
					.getFirstinstallmentamount()));
			ppLoandetail.setLoanamount(Integer.parseInt(dto.getLoanAmount()));
			ppLoandetail.setLoansanctionordno(dto.getLoanSanctionOrdNo());
			ppLoandetail.setLoanshortname(dto.getLoanShortName());
			ppLoandetail.setPaRecovcommencemonth(new Short(dto.getMonthName()));
			ppLoandetail.setPaRecovcommenceyear(new Short(dto.getYearName()));
			if (dto.getPa_IsFullyRecovered().equals("1")) {
				ppLoandetail.setPaIsfullyrecovered('1');
				;
			} else {
				ppLoandetail.setPaIsfullyrecovered('0');
				;
			}
			ppLoandetail.setPaNextinstallmentno(new Short(dto
					.getPaNextinstallmentno()));
			ppLoandetail
					.setPaRecovered(Integer.parseInt(dto.getPa_Recovered()));
			ppLoandetail.setPaNoofinstallments(new Short(dto
					.getPa_NoOfInstallments()));
			ppLoandetail.setPaInstallmentamount(Integer.parseInt(dto
					.getPaInstallmentamount()));
			ppLoandetail.setSanctiondate(new ComboService().getFormatedDate(dto
					.getSanctionDate()));
			if (dto.getStopInstallment().equals("1")) {
				ppLoandetail.setStopLoan('1');

			}

			else {
				ppLoandetail.setStopLoan('0');
			}

			try {
				ppLoandetail.setPpLoanmasterid(Integer.parseInt(dto
						.getPpLoanmasterid()));
				ppLoandetail.setIsinterest('N');
				ppLoandetail.setIseditable('N');
				session.createCriteria(PpLoandetail.class,
						ppLoandetail.getPpLoandetailid() + "");
				session.update(ppLoandetail);
				session.flush();

				isComplete = true;

				if (isComplete) {
					System.out.println("Transactions done successfully....");
					transaction.commit();
				} else {
					System.out.println(" Transaction failed....");

				}
			} catch (Exception msqle) {
				throw msqle;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isComplete;

	}

	public List getPayBillListForLock(Integer rm_OfficeID,
			String pp_RegisterMasterID, String month, String year) {
		List<BillMasterEntryEntity> payBillList = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String sql = "select year,month,billClerkName,pp_PayBillDetailID , 'Salary for the month of ' ||TRIM(TO_CHAR(TO_DATE('01/' || month || '/' || year, 'dd/mm/yyyy'), 'Month')) ||'- ' || year || ' Register ' || pp_registerMasterID billName, ";
		sql += "    'Pay' billFrom,billAmount as bill_Amount ";
		sql += "	From pp_paybilldetail where rm_OfficeID = " + rm_OfficeID
				+ " and month = " + month + " and year = " + year
				+ " and pp_registermasterid = " + pp_RegisterMasterID
				+ " and (isLocked = '0' or isLocked = 'N')";
		try {
			Query query = session.createSQLQuery(sql).addEntity(
					BillMasterEntryEntity.class);
			payBillList = query.list();
			transaction.commit();
		} catch (Exception e) {
			System.out
					.println("error inside getPayBillListForLock method of BillsSearchDAO "
							+ e);
		} finally {
			session.close();
		}
		return payBillList;
	}// end method

	public List<?> getPayBillInfo(String pp_PayBillDetailID) {
		List<?> list = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String sql = "SELECT (select REGISTERNAME from PP_REGISTERMASTER where PP_REGISTERMASTERID = PP_PAYBILLDETAIL.PP_REGISTERMASTERID) as registerName,pp_registermasterid,month,year,BILLCLERKNAME,BILLAMOUNT AS BILL_AMOUNT, netpay as NET_PAY,PP_PAYBILLDETAILID,'Salary for the month of ' ||TRIM(TO_CHAR(TO_DATE('01/' || month || '/' || year, 'dd/mm/yyyy'), 'Month')) ||'- ' || year || ' Register ' || pp_registerMasterID as description FROM PP_PAYBILLDETAIL WHERE PP_PAYBILLDETAILID = "
					+ pp_PayBillDetailID;
			Query query = session.createSQLQuery(sql).addEntity(
					PayBillInfoEntity.class);
			list = query.list();
			transaction.commit();
		} catch (Exception e) {
			System.out
					.println("error inside getPayBillInfo method of LockPayBillDAO "
							+ e);
		} finally {
			session.close();
		}
		return list;
	}// end method

	@Transactional
	public boolean passSalaryBill(LockPayBillDTO lockPayBillDTO) {
		boolean isPassed = false;
		ComboService comboService = ComboService.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isFirst = true;
		Integer fwa_billmasterid = null;
		String fwabillmasterid = null;
		FwaBillmaster fwaBillmaster = new FwaBillmaster();
		int count = 0;

		try {
			if (isFirst) {
				isFirst = false;

				fwaBillmaster.setBillno(lockPayBillDTO.getBillNo());
				fwaBillmaster.setBilldate(comboService
						.getFormatedDate(lockPayBillDTO.getBillDate()));
				fwaBillmaster.setBillAmount(new BigDecimal(lockPayBillDTO
						.getBill_Amount()));
				fwaBillmaster.setRmOfficeid(lockPayBillDTO.getRmOfficeid());
				fwaBillmaster.setForTeo('Y');
				fwaBillmaster.setSysVouchertypeid("SALA");
				fwaBillmaster.setPassedAmount(new BigDecimal(lockPayBillDTO
						.getBill_Amount()));
				fwaBillmaster.setReferenceTable("PP_PAYBILLDETAIL");
				fwaBillmaster.setReferenceTableId(Long.parseLong(lockPayBillDTO
						.getPp_PayBillDetailID() + ""));
				fwaBillmaster.setBillFrom("PAY");
				fwaBillmaster.setDescription(lockPayBillDTO.getDescription());
				fwaBillmaster.setTransactiontype(lockPayBillDTO
						.getTransactiontype());
				fwaBillmaster.setIsreceipt('N');
				fwaBillmaster.setTeoIssued('N');
				fwaBillmaster.setCdoIssued('N');
				fwaBillmaster.setPaidAmount(new BigDecimal("0"));

				session.save(fwaBillmaster);

				fwa_billmasterid = new Integer(Integer.parseInt(fwaBillmaster
						.getFwaBillmasterid() + ""));
				fwabillmasterid = "" + fwa_billmasterid;
			}
			if (fwabillmasterid.trim().length() > 0
					&& Long.parseLong(fwabillmasterid) > 0) {
				List<LockEmployeeEntity> employeelist = (List<LockEmployeeEntity>) getEmployeelist(lockPayBillDTO
						.getPp_PayBillDetailID());

				String params[] = null;
				for (LockEmployeeEntity lockEmployeeEntity : employeelist)

				{
					count = 0;
					params = new String[4];

					params[0] = lockEmployeeEntity.getPp_EmployeeMasterID()
							+ "";
					params[1] = lockPayBillDTO.getPp_PayBillDetailID() + "";
					params[2] = fwaBillmaster.getBillno();
					params[3] = lockPayBillDTO.getBillDate();

					SessionImplementor sessionImplementor = (SessionImplementor) session;
					java.sql.Connection connection = sessionImplementor
							.connection();
					CallableStatement stmt = connection
							.prepareCall("{call PROC_PP_LOAN_RECOVERY(?,?,?,?,?,?)}");
					stmt.setInt(1, Integer.parseInt(params[0]));
					stmt.setInt(2, Integer.parseInt(params[1]));
					stmt.setString(3, params[2]);
					stmt.setString(4, params[3]);
					stmt.registerOutParameter(5, Types.VARCHAR);
					stmt.registerOutParameter(6, Types.VARCHAR);

					int x = stmt.executeUpdate();

					String a = stmt.getString(5);
					String b = stmt.getString(6);

					String[] out = new String[2];

					out[0] = a;
					out[1] = b;

					System.out.println("Output== " + out[0]);
					if (out != null && out[0].equals("1")) {
						count = 1;
					} else {
						count = 0;
						break;
					}

					params = new String[2];

					String sql = "select MONTH from Pp_Paybilldetail where PP_PAYBILLDETAILID = '"
							+ lockPayBillDTO.getPp_PayBillDetailID() + "' ";

					Query query = session.createSQLQuery(sql);

					List idlist = query.list();

					Iterator<String> itr = idlist.iterator();
					while (itr.hasNext()) {
						params[1] = itr.next().trim();
					}

					params[0] = lockEmployeeEntity.getPp_EmployeeMasterID()
							+ "";

					CallableStatement stmt1 = connection
							.prepareCall("{call PROC_PP_ADD_INCREMENT_TO_ALW(?,?,?)}");
					stmt.setString(1, params[0]);
					stmt.setString(2, params[1]);
					stmt.registerOutParameter(3, Types.VARCHAR);
					int res = stmt.executeUpdate();

					String output = stmt.getString(3);

					if (output != null && out[0].equals("1")) {
						count = 1;
					} else {
						count = 0;
						break;
					}

					PpEmployeepaydetail ppEmployeepaydetail = new PpEmployeepaydetail();
					ppEmployeepaydetail
							.setPpEmployeemasterid(lockEmployeeEntity
									.getPp_EmployeeMasterID());
					ppEmployeepaydetail.setSysPaymentmodeid('1');
					ppEmployeepaydetail.setSalarypercent("100");

					String sql1 = "select PP_EMPLOYEEPAYDETAILID from Pp_Employeepaydetail where PP_EMPLOYEEMASTERID = '"
							+ lockEmployeeEntity.getPp_EmployeeMasterID()
							+ "' ";

					Query query1 = session.createSQLQuery(sql1);
					BigDecimal PP_EMPLOYEEPAYDETAILID = null;
					List idlist1 = query1.list();

					Iterator itr1 = idlist1.iterator();
					while (itr1.hasNext()) {
						PP_EMPLOYEEPAYDETAILID = (BigDecimal) itr1.next();
					}
					ppEmployeepaydetail
							.setPpEmployeepaydetailid(PP_EMPLOYEEPAYDETAILID);

					String sql2 = "UPDATE PP_EmployeePayDetail Set SYS_PAYMENTMODEID='"
							+ '1'
							+ "', SALARYPERCENT = '"
							+ "100"
							+ "', PP_EMPLOYEEPAYDETAILID = '"
							+ PP_EMPLOYEEPAYDETAILID
							+ "' WHERE Pp_EmployeeMasterID ='"
							+ lockEmployeeEntity.getPp_EmployeeMasterID() + "'";

					Query query123 = session.createSQLQuery(sql2);

					System.out.println("The Update SQL is -- " + sql1);

					query123.executeUpdate();

					/*
					 * session.createCriteria(PP_EMPLOYEEPAYDETAILID + "");
					 * session.update(ppEmployeepaydetail);
					 */

					count = 1;

					if (count <= 0)
						break;
				}// end of while

			}
			transaction.commit();
			isPassed = true;

			session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			session.close();
		}
		return isPassed;

	}

	private List<?> getEmployeelist(String Pp_PayBillDetailID) {
		List<LockEmployeeEntity> list = null;

		Session session = sessionFactory.openSession();
		Query query = null;

		try {
			String sql = "select pp_EmployeeMasterID, billType_Flag billFlag from pp_MonthlyPay inner join pp_PayBillDetail on pp_PayBillDetail.pp_PayBillDetailID = pp_MonthlyPay.pp_PayBillDetailID where pp_MonthlyPay.pp_PayBillDetailID = "
					+ Pp_PayBillDetailID;
			query = session.createSQLQuery(sql).addEntity(
					LockEmployeeEntity.class);
			list = query.list();
		} catch (Exception e) {
			System.out.println("Error while getting employee list: " + e);
		}
		return list;
	}

	@Override
	public List<PartlyEmpListEntity> getEmployeeList(
			String pp_RegisterMasterID, int payMonth, int payYear,
			Integer officeID, int numdays) {
		List<PartlyEmpListEntity> list = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {

			String sql = " select DISTINCT x.PP_EMPLOYEEMASTERID as PP_EMPLOYEEMASTERID ,c.firstname || c.middlename || c.lastname as employeename,c.employeecode ,c.pp_designationmasterid,d.designation, "
					+ " x.PP_REGISTERMASTERID from "
					+ " (select pp_employeemasterid,pp_registermasterid from VIEW_PP_EmpPayDetail_List where Pp_RegisterMasterID = "
					+ pp_RegisterMasterID
					+ " and rm_officeID = "
					+ officeID
					+ " "
					+ " and isfunctioning='1' "
					+ " minus "
					+ " select PP_EMPLOYEEMASTERID, PP_REGISTERMASTERID from pp_monthlypay where paymonth="
					+ payMonth
					+ " and payyear="
					+ payYear
					+ " and pp_registermasterid="
					+ pp_RegisterMasterID
					+ " union all "
					+ " select a.pp_employeemasterid,a.pp_registermasterid from VIEW_PP_EmpPayDetail_List a inner join pp_monthlypay b on a.pp_employeemasterid=b.pp_employeemasterid "
					+ " where b.paymonth="
					+ payMonth
					+ " and b.payyear="
					+ payYear
					+ " and a.pp_registermasterid="
					+ pp_RegisterMasterID
					+ " and b.noofdays<"
					+ numdays
					+ " and a.rm_officeid="
					+ officeID
					+ " and a.isfunctioning=1)x inner join pp_employeemaster c "
					+ " on x.pp_employeemasterid=c.pp_EMPLOYEEMASTERID INNER JOIN PP_DESIGNATIONMASTER D ON C.PP_DESIGNATIONMASTERID=D.PP_DESIGNATIONMASTERID ";

			Query query = session.createSQLQuery(sql).addEntity(
					PartlyEmpListEntity.class);
			list = query.list();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	public boolean checkPreviousMonthProcess(String employeeCode,
			String pp_RegisterMasterID, String dateOfEffect,
			String rm_OfficeID, String billType_Flag, ModelAndView modelAndView)

	{
		Session session = sessionFactory.openSession();
		boolean isComplete = false;
		try {
			String employeeSql = "select count(*) from pp_MonthlyPay inner join pp_PayBillDetail on pp_PayBillDeta"
					+ "il.pp_PayBillDetailID = pp_MonthlyPay.pp_PayBillDetailID where pp_EmployeeMaster"
					+ "ID in (select pp_EmployeeMasterID from pp_EmployeeMaster where employeeCode in ('"
					+ employeeCode + "') and isLocked = '0'" + ")";

			BigDecimal count = null;
			try {

				Query query = session.createSQLQuery(employeeSql);
				List<?> list = query.list();
				Iterator<?> itr = list.iterator();
				while (itr.hasNext()) {
					count = (BigDecimal) itr.next();
				}
				if (Integer.parseInt(count + "") > 0) {
					modelAndView.addObject("error",
							"Some unclosed bill found for the employee.");
					throw new UtillException(
							"Some unclosed bill found for the employee.");
				}
				String sql = (new StringBuilder())
						.append("select count(*) FROM pp_PayBillDetail where isLocked='0' and pp_RegisterMasterId"
								+ "='").append(pp_RegisterMasterID)
						.append("' and rm_OfficeID='").append(rm_OfficeID)
						.append("'").toString();

				String sql2 = (new StringBuilder())
						.append("select count(*) FROM pp_PayBillDetail where TO_DATE('01/'||month||'/'||YEAR,'DD/"
								+ "mm/YYYY')=TO_DATE('")
						.append(dateOfEffect)
						.append("','DD/MM/YYYY') AND isLocked='1' and billType_Flag='")
						.append(billType_Flag)
						.append("' and pp_RegisterMasterId='")
						.append(pp_RegisterMasterID)
						.append("' and rm_OfficeID='").append(rm_OfficeID)
						.append("'").toString();

				String msql = (new StringBuilder())
						.append("select count(*) from pp_PayBillDetail where pp_RegisterMasterID='")
						.append(pp_RegisterMasterID)
						.append("' and rm_OfficeID='").append(rm_OfficeID)
						.append("'").toString();

				Query query1 = session.createSQLQuery(msql);
				List<?> list1 = query1.list();
				Iterator<?> itr1 = list1.iterator();
				while (itr1.hasNext()) {
					count = (BigDecimal) itr1.next();
				}
				if (Integer.parseInt(count + "") > 0) {

					Query query2 = session.createSQLQuery(sql);
					List<?> list2 = query2.list();
					Iterator<?> itr2 = list2.iterator();
					while (itr2.hasNext()) {
						count = (BigDecimal) itr2.next();
					}

					String msqla = ((new StringBuilder())
							.append("select count(*) FROM pp_PayBillDetail where TO_DATE('01/'||month||'/'||YEAR,'DD/"
									+ "mm/YYYY') = TO_DATE('")
							.append(dateOfEffect)
							.append("','DD/MM/YYYY') and billType_Flag='")
							.append(billType_Flag)
							.append("' and pp_RegisterMasterId='")
							.append(pp_RegisterMasterID)
							.append("' and rm_OfficeID='").append(rm_OfficeID)
							.append("'").toString());

					Query query3 = session.createSQLQuery(sql);
					List<?> list3 = query3.list();
					Iterator<?> itr3 = list3.iterator();
					BigDecimal count1 = null;
					while (itr3.hasNext()) {
						count1 = (BigDecimal) itr3.next();
					}
					if (Integer.parseInt(count + "") > 0
							&& Integer.parseInt(count1 + "") == 0) {
						modelAndView
								.addObject("error",
										"Can't Process, As Unlocked Pay Bill For This Register Exists!!");
						throw new UtillException(
								"Can't Process, As Unlocked Pay Bill For This Register Exists!!");
					}

					Query query4 = session.createSQLQuery(sql2);
					List<?> list4 = query4.list();
					Iterator<?> itr4 = list4.iterator();

					while (itr4.hasNext()) {
						count = (BigDecimal) itr4.next();
					}

					if (Integer.parseInt(count + "") > 0) {
						modelAndView
								.addObject("error",
										"sorry this month salry already processed & locked also !!");
						throw new UtillException(
								"sorry this month salry already processed & locked also !!");
					}
					isComplete = false;

				} else {
					System.out
							.println("No record found in pay bill detail table for this register and office.....");
					isComplete = true;
				}
				sql = (new StringBuilder())
						.append("select count(*) from pp_PayBillDetail where TO_DATE('01/'||month||'/'||YEAR,'DD/"
								+ "mm/YYYY')=TO_DATE('")
						.append(dateOfEffect)
						.append("','DD/MM/YYYY') and billType_Flag='P' and pp_RegisterMasterId='")
						.append(pp_RegisterMasterID)
						.append("' and rm_OfficeID='").append(rm_OfficeID)
						.append("'").toString();

				Query query5 = session.createSQLQuery(sql);
				List<?> list5 = query5.list();
				Iterator<?> itr5 = list5.iterator();

				while (itr5.hasNext()) {
					count = (BigDecimal) itr5.next();
				}

				if (Integer.parseInt(count + "") <= 0) {
					isComplete = false;
					modelAndView
							.addObject("error",
									"Individual salary can be processed after monthly pay process of register.");

					throw new UtillException(
							"Individual salary can be processed after monthly pay process of register.");
				}
			} catch (UtillException ue) {
				throw ue;
			} catch (Exception e) {
				System.out.println((new StringBuilder())
						.append("Exception raised is*** ").append(e.toString())
						.toString());
				throw e;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
		return isComplete;

	}

	public List<?> getEmployeeList(String employeeCode,
			String pp_RegisterMasterID, String officeID, String payMaonth,
			String payYear) {

		List<ViewPpEmpprocesspaylist> list = null;
		String sql = "";
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		int month1 = Integer.parseInt(payMaonth);
		int year1 = Integer.parseInt(payYear);
		System.out.println("whichhhhmonthhhhhhhhh" + month1);
		System.out.println("whichhhhhhhhhhhhyearrrrrrrrrrrrr" + year1);

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year1);
		calendar.set(Calendar.MONTH, month1 - 1);
		int numDays = calendar.getActualMaximum(Calendar.DATE);
		System.out.println("numDays+++++++++" + numDays + "++++++++++++");

		try {
			sql = "select * from view_pp_empProcessPayList where employeeCode in ('"
					+ employeeCode
					+ "') and pp_RegisterMasterID = "
					+ pp_RegisterMasterID
					+ " and rm_officeID = '"
					+ officeID
					+ "' and (TO_NUMBER(TO_CHAR(appointmentFileDate,'yyyy')) < TO_NUMBER('"
					+ payYear
					+ "') or (TO_NUMBER(TO_CHAR(appointmentFileDate,'yyyy')) = TO_NUMBER('"
					+ payYear
					+ "') and TO_NUMBER(TO_CHAR(appointmentFileDate,'dd')) <=TO_NUMBER('"
					+ numDays
					+ "')and TO_NUMBER(TO_CHAR(appointmentFileDate,'mm')) <=TO_NUMBER('"
					+ payMaonth
					+ "'))) and isRetired='0' and isFunctioning='1'";
			Query query = session.createSQLQuery(sql).addEntity(
					ViewPpEmpprocesspaylist.class);
			list = query.list();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	} // end method

	public String checkNoOfDays(String pp_EmployeeMasterID,
			String pp_RegisterMasterID, String officeID, String payMaonth,
			String payYear) {

		String noOfDays = "";
		List list = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {

			String sql = "select count(*) from pp_PaybillDetail ppbd inner join pp_MonthlyPay pmp on pmp.pp_PayBillDetailID=ppbd.pp_PaybillDetailID where pp_employeeMasterID='"
					+ pp_EmployeeMasterID
					+ "'  and year='"
					+ payYear
					+ "' and month='" + payMaonth + "' and billType_Flag='P'";
			System.out.println("query1:" + sql);

			Query query = session.createSQLQuery(sql);
			List<?> list12 = query.list();
			Iterator<?> itr = list12.iterator();
			BigDecimal count = null;
			while (itr.hasNext()) {
				count = (BigDecimal) itr.next();
			}

			if (Integer.parseInt(count + "") == 0) {
				sql = "select noOfDays from pp_PaybillDetail ppbd inner join pp_MonthlyPay pmp on pmp.pp_PayBillDetailID=ppbd.pp_PaybillDetailID where pp_employeeMasterID='"
						+ pp_EmployeeMasterID
						+ "'  and year='"
						+ payYear
						+ "' and month='"
						+ payMaonth
						+ "' and billType_Flag='P'";
				System.out.println("query2:" + sql);

				Query query1 = session.createSQLQuery(sql);
				List<?> list123 = query1.list();
				Iterator<?> itr1 = list123.iterator();

				while (itr1.hasNext()) {
					noOfDays = itr.next() + "";
				}
			} else {
				noOfDays = "0";
			}

			transaction.commit();

		} catch (Exception e) {
			System.out.println("Exception Raised in " + e.toString());
		} finally {
			session.close();
		}
		return noOfDays;

	}

	public boolean updateBillDateAndBillNo(String billDate, String billNo,
			String employeeCode, String payMonth, String payYear) {
		boolean isUpdated = false;
		String sql = "";
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			sql = "update pp_PayBillDetail set billDate = TO_DATE('"
					+ billDate
					+ "', 'dd/mm/yyyy'), billNo = '"
					+ billNo
					+ "' where pp_PayBillDetailID = (select max(pp_PayBillDetailID) from pp_MonthlyPay where pp_EmployeeMasterID = (select pp_EmployeeMasterID from pp_EmployeeMaster where employeeCode = '"
					+ employeeCode + "') and payMonth = " + payMonth
					+ " and payYear = " + payYear + ")";

			Query query = session.createSQLQuery(sql);
			int count = query.executeUpdate();
			transaction.commit();
			if (count > 0) {
				isUpdated = true;
			} else {
			}

		} catch (Exception e) {
			System.out.println("Exception while updating bill date and no : "
					+ e);
		} finally {
			session.close();
		}
		return isUpdated;
	}

	public List<ViewPpNpsdetail> getNPSArrearList(String pp_EmployeeMasterID) {

		List<ViewPpNpsdetail> list = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String sql = "SELECT distinct actual_ded_mon,actual_ded_year,emp_cont_amt,mon_contr,npsdetailid,pp_EmployeeMasterID,pp_nps_arrearid,year_contr FROM VIEW_PP_NPSDETAIL WHERE pp_EmployeeMasterID="
				+ pp_EmployeeMasterID
				+ " order by  actual_ded_year,actual_ded_mon";

		try {

			Query query = session.createSQLQuery(sql).addEntity(
					ViewPpNpsdetail.class);
			list = query.list();
			transaction.commit();

			System.out.println("QUERY:" + sql);

		} catch (Exception ex) {
			System.out.println(ex);

		} finally {
			session.close();
		}
		return list;

	} // end method

	public List<PpNpsdetailEntity> getnpsDetail(String employeeID) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<PpNpsdetailEntity> list = null;
		String sql = "";

		try {
			sql = "select pp_npsdetailid , pp_employeemasterid,mon_contr, year_contr, actual_ded_mon, actual_ded_year, "
					+ "emp_cont_amt,to_char(joining_mnth,'DD/MM/YYYY') joining_mnth,to_char(startmon_forregular_cont,'DD/MM/YYYY') startmon_forregular_cont "
					+ "from pp_npsdetail where pp_npsdetailid=(select max(pp_npsdetailid) from pp_npsdetail where pp_employeemasterid='"
					+ employeeID
					+ "') "
					+ "and pp_employeemasterid='"
					+ employeeID + "'";
			list = session.createSQLQuery(sql)
					.addEntity(PpNpsdetailEntity.class).list();

			transaction.commit();

		} catch (Exception exception) {

			exception.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	} // end method

	public String getPP_Paybilldetailid(String actual_ded_mon,
			String actual_ded_year, String pp_EmployeeMasterID) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String isnpscompleted = "";
		String sql = "";
		System.out.println("i m dao blow");
		try {
			sql = " Select PP_PAYBILLDETAILID FROM PP_MONTHLYPAY    where pp_employeemasterid='"
					+ pp_EmployeeMasterID
					+ "'   and paymonth='"
					+ actual_ded_mon
					+ "'and  payyear='"
					+ actual_ded_year
					+ "'";
			List list = session.createSQLQuery(sql).list();
			Iterator<?> itr = list.iterator();
			while (itr.hasNext()) {
				isnpscompleted = itr.next() + "";
			}
			transaction.commit();

		} catch (Exception e) {
			System.out.println("Exception Raised in DAO " + e.toString());
		} finally {
			session.close();
		}
		return isnpscompleted;
	}

	public String addNPSContrCheck(String MON_CONTR, String YEAR_CONTR,
			String pp_employeemasterid, String pp_paybilldetailid) {
		System.out.println("i m dao above");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String condition = "";
		if (pp_paybilldetailid == null) {
			System.out.println("hey pp_paybilldetail is null");
			condition = " ";
		} else {
			System.out.println("hey pp_paybilldetail is not null");
			condition = " and billid='" + pp_paybilldetailid + "'";
		}

		String isnpscompleted = "";
		String sql = "";
		System.out.println("i m dao blow");
		try {
			sql = " Select count(*)  from VIEW_PP_NPSDETAIL where pp_employeemasterid='"
					+ pp_employeemasterid
					+ "' and PP_NPS_ARREARID=99 "
					+ "  and MON_CONTR='"
					+ MON_CONTR
					+ "'and  YEAR_CONTR='"
					+ YEAR_CONTR + "' " + condition;
			System.out.println("sql in DAO " + sql);
			List<?> list = session.createSQLQuery(sql).list();
			transaction.commit();
			Iterator<?> itr = list.iterator();
			while (itr.hasNext()) {

				isnpscompleted = itr.next() + "";
			}
		} catch (Exception e) {
			System.out.println("Exception Raised in DAO " + e.toString());
		} finally {
			session.close();
		}
		return isnpscompleted;
	}

	public String addNPSActualDedCheck(String actual_ded_mon,
			String actual_ded_year, String pp_employeemasterid,
			String pp_paybilldetailid) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("i m dao above");
		String condition = "";
		if (pp_paybilldetailid == null) {
			System.out.println("hey pp_paybilldetail is null");
			condition = " ";
		} else {
			System.out.println("hey pp_paybilldetail is not null");
			condition = " and billid='" + pp_paybilldetailid + "'";
		}
		String isnpscompleted = "";
		String sql = "";
		System.out.println("i m dao blow");
		try {
			sql = " Select count(*)  from VIEW_PP_NPSDETAIL where pp_employeemasterid='"
					+ pp_employeemasterid
					+ "' and PP_NPS_ARREARID=99 and actual_ded_mon='"
					+ actual_ded_mon
					+ "'"
					+ " and actual_ded_year='"
					+ actual_ded_year + "'" + condition;
			List<?> list = session.createSQLQuery(sql).list();
			transaction.commit();
			Iterator<?> itr = list.iterator();
			while (itr.hasNext()) {

				isnpscompleted = itr.next() + "";
			}
		} catch (Exception e) {
			System.out.println("Exception Raised in DAO " + e.toString());
		} finally {
			session.close();
		}
		return isnpscompleted;
	}

	public String getNpsStop(String pp_EmployeeMasterID, String MON_CONTR,
			String YEAR_CONTR, String actdedmonth, String actdedyear) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String isNpsStop = "";
		String sql = "";
		System.out.println("i m dao blow");
		try {
			sql = " Select IS_STOP_CONTRAMOUNT FROM PP_NPSDETAIL   where pp_employeemasterid='"
					+ pp_EmployeeMasterID
					+ "'   and ((MON_CONTR='"
					+ MON_CONTR
					+ "'and  YEAR_CONTR='"
					+ YEAR_CONTR
					+ "') and"
					+ "(ACTUAL_DED_MON='"
					+ actdedmonth
					+ "'and ACTUAL_DED_YEAR='" + actdedyear + "'))";
			List<?> list = session.createSQLQuery(sql).list();

			Iterator<?> itr = list.iterator();
			while (itr.hasNext()) {

				isNpsStop = itr.next() + "";
			}

			transaction.commit();
		} catch (Exception e) {
			System.out.println("Exception Raised in DAO " + e.toString());
		} finally {
			session.close();
		}
		return isNpsStop;
	}

	public int updateNpsStop(String pp_EmployeeMasterID, String MON_CONTR,
			String YEAR_CONTR, String actdedmonth, String actdedyear,
			String changeisstopnps) {
		int value = 0;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String updateSQL = "update PP_NPSDETAIL set is_stop_contramount='"
					+ changeisstopnps + "'where pp_employeemasterid='"
					+ pp_EmployeeMasterID + "'   and ((MON_CONTR='" + MON_CONTR
					+ "'and  YEAR_CONTR='" + YEAR_CONTR + "') and"
					+ "(ACTUAL_DED_MON='" + actdedmonth
					+ "'and ACTUAL_DED_YEAR='" + actdedyear + "'))";
			System.out
					.println(".................abcd................................");
			Query query = session.createSQLQuery(updateSQL);
			value = query.executeUpdate();
			transaction.commit();

		} catch (Exception e) {
			System.out.println("Exception Raised in DAO " + e.toString());
		}

		finally {
			session.close();
		}
		return value;

	}

	@Override
	public boolean addNPSDetail(String[] param) {
		boolean isCompleted = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			System.out
					.println(" procedure executed ----> PROC_PP_ADDNPSDETAIL ");

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection
					.prepareCall("{call PROC_PP_ADDNPSDETAIL(?,?,?,?,?,?,?,?,?,?)}");
			stmt.setString(1, param[0]);
			stmt.setString(2, param[1]);
			stmt.setString(3, param[2]);
			stmt.setString(4, param[3]);
			stmt.setString(5, param[4]);
			stmt.setString(6, param[5]);
			stmt.setString(7, param[6]);
			stmt.setString(8, param[7]);
			stmt.setString(9, param[8]);
			stmt.registerOutParameter(10, Types.VARCHAR);

			int x = stmt.executeUpdate();
			String result = stmt.getString(10);

			if (result != null) {

				if (param[0].equals("1")) {
					isCompleted = true;
				} else {
					System.out.println((new StringBuilder())
							.append("PROC_PP_UPDATE_EMPDEDDETAIL out[0] = ")
							.append(param[0]).toString());

				}

			}
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public List<DeletePayBillEntity> getPayBillListToDelete(Integer rm_OfficeID) {
		List<DeletePayBillEntity> payBillList = null;

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String sql = "";
		sql += "	SELECT PP_PAYBILLDETAILID, BILLCLERKNAME, BILLNO, TO_CHAR(TO_DATE('01/' || MONTH || '/2006', 'dd/mm/yyyy'), 'Month') month, YEAR, TO_CHAR(BILLDATE, 'DD-Mon-YYYY') BILLDATE, BILLAMOUNT, BILLTYPE_FLAG, ";
		sql += "	PP_REGISTERMASTERID,(SELECT REGISTERNAME FROM PP_REGISTERMASTER WHERE PP_REGISTERMASTERID=PP_PAYBILLDETAIL.PP_REGISTERMASTERID) REGISTERNAME FROM PP_PAYBILLDETAIL ";
		sql += "	WHERE ISLOCKED='0' AND RM_OFFICEID = '" + rm_OfficeID
				+ "'  ORDER BY BILLDATE ";
		try {

			payBillList = session.createSQLQuery(sql)
					.addEntity(DeletePayBillEntity.class).list();

			transaction.commit();
		} catch (Exception e) {
			System.out
					.println("error inside getPayBillListToDelete method of dao "
							+ e);
		} finally {
			session.close();
		}
		return payBillList;
	}

	public boolean deletePayBill(String pp_PayBillDetailID) {
		boolean isDeleted = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		PpPaybilldetail paybilldetail = new PpPaybilldetail();
		try {

			paybilldetail.setPpPaybilldetailid(Long
					.parseLong(pp_PayBillDetailID));
			session.createCriteria(pp_PayBillDetailID);
			session.delete(paybilldetail);
			transaction.commit();

			isDeleted = true;
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isDeleted;

	}
}
