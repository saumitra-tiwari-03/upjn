package com.nic.upjn.spring.dao;

import java.util.List;

public interface PersonalReportDAO {

	List getList(String where_condtion, String namedQuery);

	List getReportData(String sql);
	
	List getRetEmpList(String sql);

	List getEmployeeList_toBeSuperAnnutated(String month, String year, String employeementcategory);

	List getEmpOnDeputation(String asondate, String employeementcategory, String noofdays);

	

}
