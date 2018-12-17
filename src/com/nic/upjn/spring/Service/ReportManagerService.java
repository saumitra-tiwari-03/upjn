package com.nic.upjn.spring.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.spring.dto.PaySlipReportDTO;
import com.nic.upjn.spring.entity.PpPaybilldetail;
import com.nic.upjn.spring.entity.PpRegistermaster;
import com.nic.upjn.spring.entity.RmOffice;
import com.nic.upjn.spring.entity.ViewChecklist;
import com.nic.upjn.spring.entity.ViewHeadName;
import com.nic.upjn.spring.entity.ViewHeadNpsName;
import com.nic.upjn.spring.entity.ViewMonthlyPayReport;
import com.nic.upjn.spring.entity.ViewPayGetscheduleheadlist;

public interface ReportManagerService {

	List<?> getList(String wherecondition, String namedQuery);

	List<PpPaybilldetail> getbillDetail(String rmofficeid, String month, String year, String ppRegistermasterID,
			String namedQuery);

	List getmonthlypayreport(String rmofficeid, String month, String year, String ppPaybilldetailid,
			String ppRegistermasterID);

	List<PpPaybilldetail> getListpaybill(String paybilldetailID, String namedQuery);

	List headName();

	List headNpsName();

	List<?> prepareReportData(List<ViewMonthlyPayReport> monthlypayreport);

	List<ViewChecklist> getCheckList(Integer rmOfficeid, String month, String year);

	String createPredicate(PaySlipReportDTO paySlipReportDTO);

	List getEmployeeList(String sql);

	List getBillDetailForMonthlyPayReport(String month, String year, Integer rmOfficeid, String ppRegistermasterid);

	List getPaySlipHeads();

	List getPaySlipReport(Integer rmOfficeid, String pp_RegisterMasterID, String payMonth, String payYear,
			String employeeCode, String pp_PayBillDetailID);

	String prepareDataForReport(List reportList, List reportHeadList, Integer rmOfficeid, String pp_RegisterMasterID,
			String employeeCode);

	List getMonthlySummary(Integer rmOfficeid, String month, String year);

	List getCompletedloanalertList(String monthName, String loan_type, String yearName, Integer rmOfficeid);

	List getMonthlyPayReport(Integer rmOfficeid, String string, String string2, String empcode);

	List getLocCode(Integer rmOfficeid, String startYear, String endYear, String empcode);

	List headName(String string, String string2, String empcode);

	void prepareReportData(List list, HttpServletRequest request, ModelAndView target);

	List getTotalBpay(String string, String string2, String empcode);

	List getTotalSPLPAY(String string, String string2, String empcode);

	List getTotalPERSPAY(String string, String string2, String empcode);

	List getTotalGPAY(String string, String string2, String empcode);

	List getTotalDPAY(String string, String string2, String empcode);

	List getTotalPGALL(String string, String string2, String empcode);

	List getTotalBLGCMPT(String string, String string2, String empcode);

	List getTotalDEPU_PAY(String string, String string2, String empcode);

	List getTotalDA(String string, String string2, String empcode);

	List getTotalCCA(String string, String string2, String empcode);

	List getTotalGHRA(String string, String string2, String empcode);

	List getTotalMEDALW(String string, String string2, String empcode);

	List getTotalWS_ALW(String string, String string2, String empcode);

	List getTotalOTH_ALW(String string, String string2, String empcode);

	List getTotalGPF(String string, String string2, String empcode);

	List getTotalGIS(String string, String string2, String empcode);

	List getTotalHS_RENT(String string, String string2, String empcode);

	List getTotalITAX(String string, String string2, String empcode);

	List getTotalSOC_DED(String string, String string2, String empcode);

	List getTotalCLTH_DED(String string, String string2, String empcode);

	List getTotalLIP(String string, String string2, String empcode);

	List getTotalKKD_DED(String string, String string2, String empcode);

	List getTotalMISC_DED(String string, String string2, String empcode);

	List getTotalREG_EMP(String string, String string2, String empcode);

	List getTotalMOP_ADV(String string, String string2, String empcode);

	List getTotalHSREPADV(String string, String string2, String empcode);

	List getTotalHBA(String string, String string2, String empcode);

	List getTotalSCTR_ADV(String string, String string2, String empcode);

	List getTotalGPF_ADV(String string, String string2, String empcode);

	List getTotalCYCADV(String string, String string2, String empcode);

	List getTotalCARADV(String string, String string2, String empcode);

	List getGross(String string, String string2, String empcode);

	List getTotalDed(String string, String string2, String empcode);

	List getNetPay(String string, String string2, String empcode);

	/*** Office Wise Summary Report ***/
	
	List getGroupList();

	List getMonthlySummary(String month, String year, String isArrear, String isLocked, String isBoth, String group,
			String type);

	List getGross(String month, String year, String isArrear, String isLocked, String isBoth, String group);

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

	boolean isGPFSchedule(String pp_ScheduleMasterID,String scheduleName);

	boolean isNPSSchedule(String pp_ScheduleMasterID, String scheduleName);

	List getPayBillDetailForParticularMonthAndYear(String monthName,
			String yearName, Integer rmOfficeid, String sysPaymentmodeid,
			String string);

	// Bill Advice Report 
	
	boolean isBankAdvice(String sysPaymentmodeid); 

	List getAdviceList(String monthName, String yearName,
			String sysPaymentmodeid, Integer rmOfficeid, 
			String[] pp_PayBillDetailID); // bill Advice Report 
}
