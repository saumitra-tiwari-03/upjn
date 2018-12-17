package com.nic.upjn.spring.Service;

import java.util.List;

public interface PersonalReportService {

	List<?> getList(String string, String string2);

	List getReportData(String empcode, String firstName, String lastName, String employeementcategory,
			String designation, String rmid, String officelevel, String deteofjoiningfrom,
			String deteofjoiningto, String deteofbirthfrom, String deteofbirthto);

	List getEmployeeList_toBeSuperAnnutated(String month, String year, String employeementcategory);

	List getEmploymentSubType(String employeementcategory, String namedQuery);

	List getEmpOnDeputation(String asondate, String employeementcategory, String noofdays);

	List getRetiredemplist(String empcode, String firstName, String lastName, String designationid,
			String relieveafterdate, Integer rmOfficeid);

//	String createPdf(List empList, String rmid);

}
