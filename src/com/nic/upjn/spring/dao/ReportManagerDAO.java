package com.nic.upjn.spring.dao;

import java.util.List;

import com.nic.upjn.spring.entity.ViewPayGetscheduleheadlist;

public interface ReportManagerDAO {

	List<?> getList(String wherecondition, String namedQuery);

	List getbillDetail(String rmofficeid, String month, String year, String ppRegistermasterID, String namedQuery);

	List getmonthlypayreport(String rmofficeid, String month, String year, String ppPaybilldetailid,
			String ppRegistermasterID);

	List headName();

	List headNpsName();

	List getCheckList(Integer rmOfficeid, String month, String year);

	List getEmployeeList(String sql);

	List getBillDetailForMonthlyPayReport(String month, String year, Integer rmOfficeid, String ppRegistermasterid);

	List getPaySlipReportHeads();

	List getPaySlipReport(Integer rmOfficeid, String pp_RegisterMasterID, String payMonth, String payYear,
			String employeeCode, String pp_PayBillDetailID);

	List getMonthlySummary(Integer rmOfficeid, String month, String year);

	List getCompletedloanalertList(String monthName, String loan_type, String yearName, Integer rmOfficeid);

	List getMonthlyPayReport(Integer rmOfficeid, String string, String string2, String empcode);

	List getLocCode(Integer rmOfficeid, String startYear, String endYear, String empcode);

	List headName(String startYear, String endYear, String empCode);

	List getTotalBpay(String startYear, String endYear, String empcode);

	List getTotalSPLPAY(String startYear, String endYear, String empcode);

	List getTotalPERSPAY(String startYear, String endYear, String empcode);

	List getNetPay(String startYear, String endYear, String empcode);

	List getTotalDed(String startYear, String endYear, String empcode);

	List getTotalGPAY(String startYear, String endYear, String empcode);

	List getGross(String startYear, String endYear, String empcode);

	List getTotalCARADV(String startYear, String endYear, String empcode);

	List getTotalCYCADV(String startYear, String endYear, String empcode);

	List getTotalGPF_ADV(String startYear, String endYear, String empcode);

	List getTotalDPAY(String startYear, String endYear, String empcode);

	List getTotalPGALL(String startYear, String endYear, String empcode);

	List getTotalBLGCMPT(String startYear, String endYear, String empcode);

	List getTotalDEPU_PAY(String startYear, String endYear, String empcode);

	List getTotalDA(String startYear, String endYear, String empcode);

	List getTotalCCA(String startYear, String endYear, String empcode);

	List getTotalGHRA(String startYear, String endYear, String empcode);

	List getTotalMEDALW(String startYear, String endYear, String empcode);

	List getTotalWS_ALW(String startYear, String endYear, String empcode);

	List getTotalGIS(String startYear, String endYear, String empcode);

	List getTotalHS_RENT(String startYear, String endYear, String empcode);

	List getTotalITAX(String startYear, String endYear, String empcode);

	List getTotalOTH_ALW(String startYear, String endYear, String empcode);

	List getTotalGPF(String startYear, String endYear, String empcode);

	List getTotalSOC_DED(String startYear, String endYear, String empcode);

	List getTotalCLTH_DED(String startYear, String endYear, String empcode);

	List getTotalLIP(String startYear, String endYear, String empcode);

	List getTotalKKD_DED(String startYear, String endYear, String empcode);

	List getTotalMISC_DED(String startYear, String endYear, String empcode);

	List getTotalREG_EMP(String startYear, String endYear, String empcode);

	List getTotalHBA(String startYear, String endYear, String empcode);

	List getTotalSCTR_ADV(String startYear, String endYear, String empcode);

	List getTotalMOP_ADV(String startYear, String endYear, String empcode);

	List getTotalHSREPADV(String startYear, String endYear, String empcode);
	
	/**** oFFICE WISE rEPORT ****/

	List getGroupList();

	List getGross(String month, String year, String isArrear, String isLocked, String isBoth, String group);

	List getMonthlySummary(String month, String year, String isArrear, String isLocked, String isBoth, String group,
			String type);

	List getNetpay(String month, String year, String isArrear, String isLocked, String isBoth, String group);

	List getTotalDed(String month, String year, String isArrear, String isLocked, String isBoth, String group);

	List getItax(String month, String year, String isArrear, String isLocked, String isBoth, String group);

	List getGpf(String month, String year, String isArrear, String isLocked, String isBoth, String group);

	List getEmployee(String month, String year, String isArrear, String isLocked, String isBoth, String group);

	List getEmployer(String month, String year, String isArrear, String isLocked, String isBoth, String group);

	List getTotalEmp(String month, String year, String isArrear, String isLocked, String isBoth, String group);

	List getPaidEmp(String month, String year, String isArrear, String isLocked, String isBoth, String group);

  /**** Loan Deduction Report ***/

	List<?> getEmployeeScheduleList(String monthName, String yearName,
			String pp_ScheduleMasterID, String pp_RegisterMasterID,
			Integer rmOfficeid);

	List getPayBillDetailForParticularMonthAndYear(String monthName,
			String yearName, Integer rmOfficeid, String sysPaymentmodeid,
			String billType);

	/**** Bill Advice ***/

	List getAdviceList(String monthName, String yearName,
			String sysPaymentmodeid, Integer rmOfficeid, 
			String[] pp_PayBillDetailID); // bill Advice Report 
	
}
