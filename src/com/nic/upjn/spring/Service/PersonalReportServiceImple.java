package com.nic.upjn.spring.Service;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nic.upjn.spring.dao.PersonalReportDAO;
import com.nic.upjn.spring.entity.MasEmploymentsubtype;

@Service("personalReportService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PersonalReportServiceImple implements PersonalReportService {

	@Autowired
	private PersonalReportDAO personalReportDAO;

	@Override
	public List<?> getList(String where_condtion, String namedQuery) {
		List list;

		list = personalReportDAO.getList(where_condtion, namedQuery);

		return list;
	}

	@Override
	public List getReportData(String empcode, String firstName, String lastName, String employeementcategory,
			String designation, String rmOfficeid, String officelevel, String deteofjoiningfrom, String deteofjoiningto,
			String deteofbirthfrom, String deteofbirthto) {

		List list = null;

		try {

			String sql = this.createSql(empcode, firstName, lastName, employeementcategory, designation, rmOfficeid,
					officelevel, deteofjoiningfrom, deteofjoiningto, deteofbirthfrom, deteofbirthto);
			if (sql != null && sql.trim().length() > 0)
				list = personalReportDAO.getReportData(sql);
		} catch (Exception e) {
			System.out.println("error inside getReportData method of manager " + e);
		}
		return list;
	}

	public String createSql(String employeeCode, String firstName, String lastName, String MAS_EMPLOYMENTSUBTYPEID,
			String pp_DesignationMasterID, String rm_OfficeID, String mas_OfficeLevelID, String deteofjoiningfrom,
			String deteofjoiningto, String deteofbirthfrom, String deteofbirthto) {

		String sql = "select * from VIEW_OFFICEWISEEMPREPORT where ISRETIRED='0'";
		try {
			if (employeeCode != null && employeeCode.trim().length() > 0) {
				sql += " and employeeCode like '" + employeeCode + "%'";
			}

			if (firstName != null && firstName.trim().length() > 0) {
				sql += " and FIRSTNAME like '" + firstName + "%'";
			}

			if (lastName != null && lastName.trim().length() > 0) {
				sql += " and lastName like '" + lastName + "%'";
			}
			if (deteofjoiningfrom != null && deteofjoiningfrom.trim().length() > 0) {
				sql += " and DATEJOINING>= TO_DATE('" + deteofjoiningfrom + "', 'dd-mm-yyyy')";
			}
			if (deteofjoiningto != null && deteofjoiningto.trim().length() > 0) {
				sql += " and DATEJOINING<= TO_DATE('" + deteofjoiningto + "', 'dd-mm-yyyy')";
			}
			if (deteofbirthfrom != null && deteofbirthfrom.trim().length() > 0) {
				sql += " and DATEOFBIRTH >=  TO_DATE('" + deteofbirthfrom + "', 'dd-mm-yyyy')";
			}
			if (deteofbirthto != null && deteofbirthto.trim().length() > 0) {
				sql += " and DATEOFBIRTH<=  TO_DATE('" + deteofbirthto + "', 'dd-mm-yyyy')";
			}

			if (pp_DesignationMasterID != null && pp_DesignationMasterID.trim().length() > 0
					&& !pp_DesignationMasterID.equals("-1")) {
				sql += " and pp_DesignationMasterID = '" + pp_DesignationMasterID + "'";
			}

			if (MAS_EMPLOYMENTSUBTYPEID != null && MAS_EMPLOYMENTSUBTYPEID.trim().length() > 0
					&& !MAS_EMPLOYMENTSUBTYPEID.equals("-1")) {
				sql += " and MAS_EMPLOYMENTSUBTYPEID = '" + MAS_EMPLOYMENTSUBTYPEID + "'";
			}

			if (rm_OfficeID != null && rm_OfficeID.trim().length() > 0 && !rm_OfficeID.equals("-1")) {
				sql += " and rm_OfficeID = '" + rm_OfficeID + "'";
			}

			if (mas_OfficeLevelID != null && mas_OfficeLevelID.trim().length() > 0 && !mas_OfficeLevelID.equals("-1")) {
				if (rm_OfficeID != null && rm_OfficeID.trim().length() > 0 && rm_OfficeID.equals("-1")) {
					sql += " and rm_OfficeID in (select rm_OfficeID from rm_Office where mas_OfficeLevelID = '"
							+ mas_OfficeLevelID + "')";
				}
			}
			sql += " order by lower(employeeName)";

			System.out.println("Sql -- " + sql);

		} catch (Exception e) {
			System.out.println("error inside createSql method of OfficeEmployeeReportManager " + e);
		}
		return sql;
	}// end method

	@Override
	public List getEmployeeList_toBeSuperAnnutated(String month, String year, String employeementcategory) {

		List employeeList = null;

		try {

			employeeList = personalReportDAO.getEmployeeList_toBeSuperAnnutated(month, year, employeementcategory);
		} catch (Exception e) {
			System.out.println("error inside getEmployeeList_toBeSuperAnnutated method of manager..." + e);
		}
		return employeeList;
	}

	@Override
	public List getEmploymentSubType(String employeementcategory, String namedQuery) {
		List employmentSubType = null;
		try {

			employmentSubType = personalReportDAO.getList(employeementcategory, namedQuery);
		} catch (Exception e) {
			System.out.println("error inside getEmploymentSubType method of dao...." + e);
		}
		return employmentSubType;
	}

	@Override
	public List getEmpOnDeputation(String asondate, String employeementcategory, String noofdays) {
		List list = null;

		list = personalReportDAO.getEmpOnDeputation(asondate, employeementcategory, noofdays);

		return list;
	}

	@Override
	public List getRetiredemplist(String empcode, String firstName, String lastName, String designationid,
			String relieveafterdate, Integer rmofficeid) {

		List list = null;

		try {

			String sql = this.createSqlRetEmpReport(empcode, firstName, lastName, designationid, relieveafterdate,
					rmofficeid);

			if (sql != null && sql.trim().length() > 0)

				list = personalReportDAO.getRetEmpList(sql);

		} catch (Exception e) {
			System.out.println("error inside getRetiredemplist method of manager " + e);
		}
		return list;
	}

	public String createSqlRetEmpReport(String employeeCode, String firstName, String lastName,
			String pp_DesignationMasterID, String relieveOrdDate, Integer rmofficeid) {

		//String sql = "select E.employeeCode, E.firstName, E.lastName,E.firstName||' '||E.middleName||' '||E.lastName AS EMPLOYEENAME, R.pp_EmployeeMasterID, TO_CHAR(R.relieveOrdDate, 'dd/mm/yyyy') relieveOrdDate,TO_CHAR(R.DATEOFEFFECT, 'dd/mm/yyyy') dateOfEffect, S.subPhaseName, D.designation, O.officeName,E.RM_OFFICEID,E.PP_DESIGNATIONMASTERID from pp_RelieveFromService R inner join sys_SubServicePhaseMaster S on S.sys_SubServicePhaseMasterID = R.causeOfRelieveID inner join pp_EmployeeMaster E on E.pp_EmployeeMasterID = R.pp_EmployeeMasterID inner join pp_DesignationMaster D on D.pp_DesignationMasterID = E.pp_DesignationMasterID inner join rm_Office O on O.rm_OfficeID = E.rm_OfficeID where E.isRetired = '1' AND E.ISFUNCTIONING='0'";

		 String sql="select* from VIEW_RETEMPREPORT where RM_OFFICEID='"+rmofficeid+"'";
		 
		System.out.print("");
		try {
			if (employeeCode != null && employeeCode.trim().length() > 0) {
				sql += " and lower(employeeCode) like '" + employeeCode.toLowerCase() + "%'";
			}

			if (firstName != null && firstName.trim().length() > 0) {
				sql += " and lower(FIRSTNAME) like '" + firstName.toLowerCase() + "%'";
			}

			if (lastName != null && lastName.trim().length() > 0) {
				sql += " and lower(lastName) like '" + lastName.toLowerCase() + "%'";
			}

			if (pp_DesignationMasterID != null && pp_DesignationMasterID.trim().length() > 0
					&& !pp_DesignationMasterID.equals("-1")) {
				sql += " and pp_DesignationMasterID = '" + pp_DesignationMasterID + "'";
			}
			if (relieveOrdDate != null && relieveOrdDate.trim().length() == 10) {
				  sql += " and relieveOrdDate >= TO_DATE('" + relieveOrdDate + "', 'dd/mm/yyyy')";
			}
			sql += " order by lower(employeeName)";
		} catch (Exception e) {
			System.out.println("error inside createSql method of OfficeEmployeeReportManager " + e);
		}
		return sql;
	}

}
