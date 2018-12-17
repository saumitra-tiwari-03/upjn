package com.nic.upjn.spring.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.spring.dto.Alw_ForPayCategoryDTO;
import com.nic.upjn.spring.dto.DedDetailDTO;
import com.nic.upjn.spring.dto.EmployeePayDetailDTO;
import com.nic.upjn.spring.dto.LoanSanctionDTO;
import com.nic.upjn.spring.dto.LockPayBillDTO;
import com.nic.upjn.spring.dto.PayAlwDTO;
import com.nic.upjn.spring.dto.PayBillDetailDTO;
import com.nic.upjn.spring.entity.DeletePayBillEntity;
import com.nic.upjn.spring.entity.PartlyEmpListEntity;
import com.nic.upjn.spring.entity.PpNpsdetailEntity;
import com.nic.upjn.spring.entity.ViewPpEmppaydetail;
import com.nic.upjn.spring.entity.ViewPpEmppaydetailList;
import com.nic.upjn.spring.entity.ViewPpNpsdetail;

public interface UpdatePayDetailDAO {
	
	public List<ViewPpEmppaydetailList> getEmpPayDetailList(Short registerID,Integer rmOfficeID);
	
	public List<ViewPpEmppaydetail> getEmpGenDetail(String ppEmployeeMasterID);
	public List<?> getComboList(String where_condition, String namedQuery);
	public List<?> getComboList(Integer where_condition, String namedQuery);
	public List<?> getList();
	public List<?> getTownCategoryList(String purpose, Short id);
	public List<?> getAlwList(String pp_EmployeeMasterID, String sys_PayCategoryID);
	public boolean updateEmpPayDetail(EmployeePayDetailDTO empPayDetailDTO);

	public List getList(Long where_condition, String namedQuery);

	public int checkPreviousMonthProcess(String registerID,
			String dateOfEffect, String rmOfficeid, String mes, ModelAndView modelAndView);
	
	public List getEmployeeList(String pp_RegisterMasterID, String officeID, String payMaonth, String payYear);

	public int insertEmployees(String registerID, String rmOfficeid,
			String monthName, String yearName);

	public String getTotal_employee(String rmOfficeid, String registerID);

	public ArrayList<Alw_ForPayCategoryDTO> getAlwEntity(String sys_PayCategoryID,
			String pp_EmployeeMasterID, String dateOfEffect);

	public String getUserInputValue(String pp_EmployeeMasterID,
			String pp_PayAlw_MasterID);

	public boolean isSubTypeBased(String sys_RuleCategoryID);

	public List getComponentID(String pp_PayAlwMasterID);

	public String getPayAlwName(String pp_PayAlw_MasterID);

	public String getStop_Alw_Flag(String pp_EmployeeMasterID, String pp_PayAlw_MasterID);

	public List getRuleMaster(String pp_PayAlwMasterID, String dateOfEffect);

	public String getInputPayRangeAndPercentBased(String payValue, String pp_RuleMasterID, Hashtable townCategoryID,
			String payAlwName);

	public String getInputPayRangeAndFlatValueBased(String payValue, String pp_RuleMasterID, Hashtable townCategoryID,
			String payAlwName, String b_pay);

	public String getInputEmpCategoryAndPayPercentBased(String payValue, String pp_EmploymentSubTypeID,
			String pp_RuleMasterID, Hashtable townCategoryID, String payAlwName);

	public String getEmpCategoryAndFlatValueBased(String pp_EmploymentSubTypeID, String pp_RuleMasterID,
			Hashtable townCategoryID, String payAlwName);

	public String getFlatForAll(String pp_RuleMasterID, Hashtable townCategoryID, String payAlwName);

	public String getNPSvalue(String pp_EmployeeMasterID, String pp_RuleMasterID);

	public String[] getPayAlwShortName(String[] pp_PayalwMasterID, String sys_PayCategoryID);

	public List getEmpNPSDetail(String pp_EmployeeMasterID, String dateOfEffect, Character billtypeFlag);

	public List getEmpLoanDetail(String pp_EmployeeMasterID, String dateOfEffect, Character billtypeFlag);

	public List getEmpDeductionDetail(String pp_EmployeeMasterID, String dateOfEffect, Character billtypeFlag);

	public boolean insertPayBillDetailIntoDB(PayBillDetailDTO pbdto, List glist);

	/*-------------------------------------------------*/
	
	public boolean addAllowance(PayAlwDTO payAlwDTO);

	public boolean addEmpGPFDetails(Long ppEmployeemasterid);

	public List getISndpsCompleted(String ppEmployeeMasterID);

	public List getPayAlwName1(String ppEmployeeMasterID);

	public List getEmployeeDedDetail(String ppEmployeeMasterID);

	public boolean addEmpDedDetail(DedDetailDTO dedDetailDTO, String[] param);
	
	public List populateLoanMasterCombo(String empMasterID, String pp_LoanDetailID) throws  Exception;

	public String[] isBearingLoan(String pp_EmployeeMasterID, String pp_LoanMasterID);

	public boolean insertLoanSanction(LoanSanctionDTO dto);

	public boolean deleteLoanSanction(String pp_LoanDetailID);

	public List retrieveLoanSanction(String pp_LoanDetailID);

	public boolean updateLoanSanction(LoanSanctionDTO dto);

	public List getPayBillListForLock(Integer rmOfficeid,
			String pp_RegisterMasterID, String month, String year);

	public List<?> getPayBillInfo(String pp_PayBillDetailID);

	public boolean passSalaryBill(LockPayBillDTO lockPayBillDTO);

	public List<PartlyEmpListEntity> getEmployeeList(
			String pp_RegisterMasterID, int month1, int year1,
			Integer rmOfficeid, int numDays);

	public boolean checkPreviousMonthProcess(String employeeCode,
			String pp_RegisterMasterID, String dateOfEffect,
			String rm_OfficeID, String billType_Flag,ModelAndView modelAndView);

	public List getEmployeeList(String employeeCode,
			String pp_RegisterMasterID, String officeID, String payMaonth,
			String payYear);

	public String checkNoOfDays(String pp_EmployeeMasterID,
			String pp_RegisterMasterID, String officeID, String payMaonth,
			String payYear);

	public boolean updateBillDateAndBillNo(String billDate, String billNo,
			String employeeCode, String payMonth, String payYear);

	public List<ViewPpNpsdetail> getNPSArrearList(String pp_EmployeeMasterID);

	public List<PpNpsdetailEntity> getnpsDetail(String pp_EmployeeMasterID);

	public String getPP_Paybilldetailid(String actual_ded_mon,
			String actual_ded_year, String pp_EmployeeMasterID);

	public String addNPSContrCheck(String mON_CONTR, String yEAR_CONTR,
			String pp_employeemasterid, String pp_paybilldetailid);

	public String addNPSActualDedCheck(String actual_ded_mon,
			String actual_ded_year, String ppEmployeeMasterID,
			String pp_paybilldetailid);

	public String getNpsStop(String ppEmployeeMasterID, String mon_contr,
			String year_contr, String actual_ded_mon, String actual_ded_year);

	public int updateNpsStop(String ppEmployeeMasterID, String mon_contr,
			String year_contr, String actual_ded_mon, String actual_ded_year,
			String changeisstopnps);

	public boolean addNPSDetail(String[] param);

	public List<DeletePayBillEntity> getPayBillListToDelete(Integer rm_OfficeID);

	public boolean deletePayBill(String pp_PayBillDetailID);
	
	/*-------------------------------------------------*/
}
