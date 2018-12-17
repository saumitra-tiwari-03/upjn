package com.nic.upjn.spring.Service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.spring.dto.DedDetailDTO;
import com.nic.upjn.spring.dto.EmployeePayDetailDTO;
import com.nic.upjn.spring.dto.LoanSanctionDTO;
import com.nic.upjn.spring.dto.LockPayBillDTO;
import com.nic.upjn.spring.dto.NPSDetailDTO;
import com.nic.upjn.spring.dto.PayAlwDTO;
import com.nic.upjn.spring.dto.PayBillDTO;
import com.nic.upjn.spring.entity.DeletePayBillEntity;
import com.nic.upjn.spring.entity.LoanSanctionEntity;
import com.nic.upjn.spring.entity.PartlyEmpListEntity;
import com.nic.upjn.spring.entity.PpNpsdetailEntity;
import com.nic.upjn.spring.entity.ViewPpEmppaydetail;
import com.nic.upjn.spring.entity.ViewPpEmppaydetailList;
import com.nic.upjn.spring.entity.ViewPpEmpprocesspaylist;
import com.nic.upjn.spring.entity.ViewPpNpsdetail;

public interface UpdatePayDetailService {

	public List<ViewPpEmppaydetailList> getEmpPayDetailList(Short registerID,
			Integer rmOfficeID);

	public List<ViewPpEmppaydetail> getEmpGenDetail(String ppEmployeeMasterID);

	public List<?> getComboList(String where_condition, String namedQuery);

	public List<?> getList();

	public List<?> getTownCategoryList(String purpose, Short id);

	public List<?> getAlwList(String pp_EmployeeMasterID,
			String sys_PayCategoryID);

	public boolean updateEmpPayDetail(EmployeePayDetailDTO empPayDetailDTO);

	public List<?> getList(Long where_condition, String namedQuery);

	public int checkPreviousMonthProcess(String registerID,
			String dateOfEffect, String rmOfficeid, String mes, ModelAndView modelAndView);

	public List getEmployeeList(String pp_RegisterMasterID, String officeID,
			String payMaonth, String payYear);

	public int insertEmployees(String registerID, String rmOfficeid,
			String monthName, String yearName);

	public String getTotal_employee(String string, String registerID);

	public boolean calculatePayAlw(List<ViewPpEmpprocesspaylist> employeeList,
			String dateOfEffect, PayBillDTO payBillDTO, String total_employee,
			String string);

	/* ------------------------ */

	public boolean addAllowance(PayAlwDTO payAlwDTO);

	public boolean addEmpGPFDetails(Long ppEmployeemasterid);

	public List getISndpsCompleted(String ppEmployeeMasterID);

	public List getPayAlwName1(String ppEmployeeMasterID);

	public List getEmployeeDedDetail(String ppEmployeeMasterID);

	public boolean addEmpDedDetail(DedDetailDTO dedDetailDTO);

	public List populateLoanMasterCombo(String empMasterID,
			String pp_LoanDetailID);

	public String[] isBearingLoan(String pp_EmployeeMasterID,
			String pp_LoanMasterID);

	public boolean insertLoanSanction(LoanSanctionDTO loanSanctionDTO);

	public boolean deleteLoanSanction(String pp_LoanDetailID);

	public List<LoanSanctionEntity> retrieveLoanSanction(String pp_LoanDetailID);

	public boolean updateLoanSanction(LoanSanctionDTO loanSanctionDTO);

	public List getPayBillListForLock(Integer rmOfficeid,
			String ppRegistermasterid, String monthName, String yearName);

	public List getPayBillInfo(String ppPaybilldetailid);

	public boolean passSalaryBill(LockPayBillDTO lockPayBillDTO);

	public List<PartlyEmpListEntity> getAddPayEmployeeList(String string,
			int month1, int year1, Integer rmOfficeid, int numDays);

	public boolean checkPreviousMonthProcess(String employeecode,
			String string, String dateOfEffect, String string2, String string3,ModelAndView modelAndView);

	public List getEmployeeList(String empcode1, String string,
			String rmOfficeid, String monthName, String yearName);

	public boolean checkNoOfDays(String string, String string2, String string3,
			String monthName, String yearName, String string4);

	public boolean updateBillDateAndBillNo(String billdate, String billno,
			String employeecode, String monthName, String yearName);

	public List<ViewPpNpsdetail> getNPSArrearList(String ppEmployeeMasterID);

	public List<PpNpsdetailEntity> getnpsDetail(String ppEmployeeMasterID);

	public String getPP_Paybilldetailid(String actual_ded_mon,
			String actual_ded_year, String ppEmployeeMasterID);

	public String getPP_PaybilldetailidformonthCont(String mon_contr,
			String year_contr, String ppEmployeeMasterID);

	public String addNPSContrCheck(String mon_contr, String year_contr,
			String ppEmployeeMasterID, String billid);

	public String addNPSActualDedCheck(String actual_ded_mon,
			String actual_ded_year, String ppEmployeeMasterID,
			String pp_paybilldetailid);

	public String getIsStop(String ppEmployeeMasterID, String mon_contr,
			String year_contr, String actual_ded_mon, String actual_ded_year);

	public int updatenpsstopvalue(String ppEmployeeMasterID, String mon_contr,
			String year_contr, String actual_ded_mon, String actual_ded_year,
			String changeisstopnps);

	public boolean addNPSDetail(NPSDetailDTO npsDetailDTO, Integer rmOfficeid,
			String stopcontr);

	public List<DeletePayBillEntity> getPayBillListToDelete(Integer rmOfficeid);

	public boolean deletePayBill(String pp_PayBillDetailID);

}
