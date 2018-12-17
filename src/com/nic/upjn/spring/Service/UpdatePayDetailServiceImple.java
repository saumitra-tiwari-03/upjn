package com.nic.upjn.spring.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.spring.dao.UpdatePayDetailDAO;
import com.nic.upjn.spring.dto.Alw_ForPayCategoryDTO;
import com.nic.upjn.spring.dto.DedDetailDTO;
import com.nic.upjn.spring.dto.EmployeeDedDetailDTO;
import com.nic.upjn.spring.dto.EmployeePayDetailDTO;
import com.nic.upjn.spring.dto.LoanDetailDTO;
import com.nic.upjn.spring.dto.LoanSanctionDTO;
import com.nic.upjn.spring.dto.LockPayBillDTO;
import com.nic.upjn.spring.dto.NPSDetailDTO;
import com.nic.upjn.spring.dto.PayAlwDTO;
import com.nic.upjn.spring.dto.PayBillDTO;
import com.nic.upjn.spring.dto.PayBillDetailDTO;
import com.nic.upjn.spring.entity.DeletePayBillEntity;
import com.nic.upjn.spring.entity.PartlyEmpListEntity;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.PpEmployeepaydetail;
import com.nic.upjn.spring.entity.PpIncrementdetail;
import com.nic.upjn.spring.entity.PpLoanEntity;
import com.nic.upjn.spring.entity.PpNpsdetailEntity;
import com.nic.upjn.spring.entity.ViewPpEmppaydetail;
import com.nic.upjn.spring.entity.ViewPpEmppaydetailList;
import com.nic.upjn.spring.entity.ViewPpEmpprocesspaylist;
import com.nic.upjn.spring.entity.ViewPpNpsdetail;

@Service("UpdatePayDetailService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UpdatePayDetailServiceImple implements UpdatePayDetailService {

	@Autowired
	UpdatePayDetailDAO updatePayDetailDAO;
	public PayBillDetailDTO pbdto = null;
	ViewPpEmpprocesspaylist viewPpEmpprocesspaylist;

	@Override
	public List<ViewPpEmppaydetailList> getEmpPayDetailList(Short registerID, Integer rmOfficeID) {

		return updatePayDetailDAO.getEmpPayDetailList(registerID, rmOfficeID);
	}

	@Override
	public List<ViewPpEmppaydetail> getEmpGenDetail(String ppEmployeeMasterID) {

		return updatePayDetailDAO.getEmpGenDetail(ppEmployeeMasterID);
	}

	public List<?> getComboList(String where_condition, String namedQuery) {
		return updatePayDetailDAO.getComboList(where_condition, namedQuery);
	}

	@Override
	public List<?> getList() {

		return updatePayDetailDAO.getList();
	}

	@Override
	public List<?> getTownCategoryList(String purpose, Short id) {

		return updatePayDetailDAO.getTownCategoryList(purpose, id);
	}

	@Override
	public List<?> getAlwList(String pp_EmployeeMasterID, String sys_PayCategoryID) {

		return updatePayDetailDAO.getAlwList(pp_EmployeeMasterID, sys_PayCategoryID);
	}

	@Override
	public boolean updateEmpPayDetail(EmployeePayDetailDTO empPayDetailDTO) {
		return updatePayDetailDAO.updateEmpPayDetail(empPayDetailDTO);
	}

	@Override
	public List<PpEmployeemaster> getList(Long where_condition, String namedQuery) {

		List list;

		list = updatePayDetailDAO.getList(where_condition, namedQuery);
		return list;
	}

	@Override
	public int checkPreviousMonthProcess(String registerID, String dateOfEffect, String rmOfficeid, String mes,
			ModelAndView modelAndView) {
		int isComplete = 0;
		try {
			isComplete = updatePayDetailDAO.checkPreviousMonthProcess(registerID, dateOfEffect, rmOfficeid, mes,
					modelAndView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isComplete;
	}

	@Override
	public List getEmployeeList(String pp_RegisterMasterID, String officeID, String payMaonth, String payYear) {

		List list;

		list = updatePayDetailDAO.getEmployeeList(pp_RegisterMasterID, officeID, payMaonth, payYear);
		return list;
	}

	@Override
	public int insertEmployees(String registerID, String rmOfficeid, String monthName, String yearName) {

		int result = updatePayDetailDAO.insertEmployees(registerID, rmOfficeid, monthName, yearName);
		return result;
	}

	@Override
	public String getTotal_employee(String rmOfficeid, String registerID) {
		String totalemployee;

		totalemployee = updatePayDetailDAO.getTotal_employee(rmOfficeid, registerID);
		return totalemployee;
	}

	@Override
	public boolean calculatePayAlw(List<ViewPpEmpprocesspaylist> employeeList, String dateOfEffect, PayBillDTO pbddto,
			String total_employee, String stopnps) {
		boolean isComplete = false;
		List glist = new ArrayList();
		String sys_PayCategoryID = "";
		// int partSalarylist = 0;
		System.out.println("......................value of nps is..................." + stopnps);

		glist = new ArrayList();

		sys_PayCategoryID = "";
		double totals = 0;
		int lastInsertID = -1000;

		Iterator iter = employeeList.iterator();

		String pp_EmployeeMasterID;
		String incrementAmount;
		String salaryPercent;
		String noOfDays;
		String hraTownCategoryID;
		String ccaTownCategoryID;
		String employeeCode;

		AllowancesManager amanager;

		List<Alw_ForPayCategoryDTO> alwDTOList;
		String pp_PayalwMasterID[];
		String pp_PayalwValue[];
		double total;
		String b_pay = "";
		while (iter.hasNext()) {
			pbdto = new PayBillDetailDTO();
			String month = pbddto.getMonthName();
			String year = pbddto.getYearName();

			int month1 = Integer.parseInt(month);
			int year1 = Integer.parseInt(year);
			System.out.println("MONTHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH" + month);
			System.out.println("YEARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR" + year);

			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, year1);
			calendar.set(Calendar.MONTH, month1 - 1);
			int numDays = calendar.getActualMaximum(Calendar.DATE);

			System.out.println("KITNEEEDINNNNNNNNNNNNNNNNNNNNNNNNNNNNNN" + numDays);

			BeanUtils.copyProperties(pbddto, pbdto);
			pbdto.setPpRegistermasterid(pbddto.getPpRegistermasterid());
			pbdto.setRmOfficeid(pbddto.getRmOfficeid());
			pbdto.setNoOfDays(numDays + "");
			pbdto.setBilltypeFlag(pbddto.getBilltypeFlag());
			pbdto.setBilldate(pbddto.getBilldate());

			viewPpEmpprocesspaylist = (ViewPpEmpprocesspaylist) iter.next();
			pp_EmployeeMasterID = viewPpEmpprocesspaylist.getPpEmployeemasterid() + "";

			if (viewPpEmpprocesspaylist.getNoofdays() != null) {
				pbdto.setNoOfDays(viewPpEmpprocesspaylist.getNoofdays());
			}
			pbdto.setPp_EmployeeMasterID(pp_EmployeeMasterID);
			incrementAmount = "0";
			String incrementMonth = null;
			@SuppressWarnings("unchecked")
			List<PpEmployeepaydetail> list = (List<PpEmployeepaydetail>) updatePayDetailDAO
					.getComboList(pp_EmployeeMasterID, "PpEmployeepaydetail.findByPpEmployeemasterid");
			for (PpEmployeepaydetail employeepaydetail : list) {
				incrementMonth = employeepaydetail.getNextincrementmonth();
			}

			if (Integer.parseInt(incrementMonth) < 10)
				incrementMonth = "0" + incrementMonth;
			if (incrementMonth != null && dateOfEffect.substring(3, 5).equals(incrementMonth)) {

				@SuppressWarnings("unchecked")
				List<PpIncrementdetail> list1 = (List<PpIncrementdetail>) updatePayDetailDAO
						.getComboList(pp_EmployeeMasterID, "PpIncrementdetail.findByPpEmployeematerId");
				for (PpIncrementdetail ppIncrementdetail : list1) {
					incrementAmount = ppIncrementdetail.getIncrementamount() + "";
				}

			}
			salaryPercent = viewPpEmpprocesspaylist.getSalarypercent();
			noOfDays = viewPpEmpprocesspaylist.getNoofdays();
			System.out.println("NUMMMBERRRROFFFFDAYYYYYSSSSSSSSSSSSSSSS" + noOfDays);

			ccaTownCategoryID = viewPpEmpprocesspaylist.getCcatowncategoryid();
			hraTownCategoryID = viewPpEmpprocesspaylist.getHratowncategoryid();
			sys_PayCategoryID = viewPpEmpprocesspaylist.getSysPaycategoryid() + "";
			String employeeName = viewPpEmpprocesspaylist.getEmployeename();
			employeeCode = viewPpEmpprocesspaylist.getEmployeecode();
			String mas_EmploymentSubTypeID = viewPpEmpprocesspaylist.getMasEmploymentsubtypeid() + "";
			Hashtable townCategoryID = new Hashtable();
			if (ccaTownCategoryID != null && !ccaTownCategoryID.equals("-1") && !ccaTownCategoryID.equals("")) {
				townCategoryID.put("CCA", ccaTownCategoryID);
			}
			if (hraTownCategoryID != null && !hraTownCategoryID.equals("-1") && !hraTownCategoryID.equals("")) {
				townCategoryID.put("HRA", hraTownCategoryID);
			}

			alwDTOList = updatePayDetailDAO.getAlwEntity(sys_PayCategoryID, pp_EmployeeMasterID, dateOfEffect);
			pp_PayalwMasterID = new String[alwDTOList.size()];
			pp_PayalwValue = new String[alwDTOList.size()];
			try {

				int i = 0;
				System.out.println((new StringBuilder()).append("Calculating Non-Auto allowances for EMPID: ")
						.append(pp_EmployeeMasterID).toString());
				for (Alw_ForPayCategoryDTO alwDTO : alwDTOList) {

					String sys_RuleCategoryID = alwDTO.getSys_RuleCategoryID();
					String pp_PayAlw_MasterID = alwDTO.getPp_PayAlwMasterID() + "";
					String stop_Alw_Flag_Result = alwDTO.getStop_Alw_Flag();
					if (sys_RuleCategoryID == null && stop_Alw_Flag_Result.equals("0")) {
						System.out.println((new StringBuilder()).append("SysRuleCategory Not found for AlwID ")
								.append(alwDTO.getPp_PayAlwMasterID()).append(" For EmpId ").append(pp_EmployeeMasterID)
								.toString());
						throw new Exception();
					}
					pp_PayalwMasterID[i] = pp_PayAlw_MasterID;
					pp_PayalwValue[i] = "0";
					if (sys_RuleCategoryID != null && sys_RuleCategoryID.equals("0")
							&& stop_Alw_Flag_Result.equals("0")) {
						String value = "";
						String headName = alwDTO.getHeadName();
						value = updatePayDetailDAO.getUserInputValue(pp_EmployeeMasterID, pp_PayAlw_MasterID);
						if (headName.equalsIgnoreCase("B_PAY")) {
							System.out.println("");
							value = (new StringBuilder()).append("")
									.append(Double.parseDouble(incrementAmount) + Double.parseDouble(value)).toString();
							b_pay = (new StringBuilder()).append("")
									.append(Double.parseDouble(incrementAmount) + Double.parseDouble(value)).toString();
							System.out.println("value++++++++++++++++++++" + value);
						}
						alwDTO.setPayValue(value);
						alwDTO.setIsCalculated("1");
						System.out.println("value" + value);
						pp_PayalwValue[i] = value;
					}
					i++;
				}
			} catch (Exception e) {
				System.out.println("Error inside Sys_RuleCategory=0 block");
			}
			total = 0.0D;
			amanager = new AllowancesManager(pp_EmployeeMasterID, townCategoryID, mas_EmploymentSubTypeID, dateOfEffect,
					b_pay, updatePayDetailDAO);

			System.out.println((new StringBuilder()).append("Calculating AUTO allowances for EMPID: ")
					.append(pp_EmployeeMasterID).toString());

			try {

				int i = 0;
				System.out.println((new StringBuilder()).append("Calculating Non-Auto allowances for EMPID: ")
						.append(pp_EmployeeMasterID).toString());
				for (Alw_ForPayCategoryDTO alwDTO : alwDTOList) {

					String sys_RuleCategoryID = alwDTO.getSys_RuleCategoryID();
					String pp_PayAlw_MasterID = alwDTO.getPp_PayAlwMasterID() + "";
					String stop_Alw_Flag_Result = alwDTO.getStop_Alw_Flag();
					System.out.println(
							(new StringBuilder()).append("Going to calculate").append(alwDTO.getHeadName()).toString());
					System.out.println((new StringBuilder()).append(alwDTO.getPp_PayAlwMasterID())
							.append(", pay value:").append(alwDTO.getPayValue()).append(", iscalculated")
							.append(alwDTO.getIsCalculated()).append(" XXX").toString());
					if (sys_RuleCategoryID == null && stop_Alw_Flag_Result.equals("0")) {
						throw new Exception();
					}
					String isAlreadyCalculated = alwDTO.getIsCalculated();
					System.out.println((new StringBuilder()).append(alwDTO.getHeadName())
							.append(" is already calculated? ").append(isAlreadyCalculated).toString());
					String payValue = "0";
					if (!isAlreadyCalculated.equals("1")) {
						String headName = alwDTO.getHeadName();
						amanager.getRuleMasterAndSetValues(alwDTO, updatePayDetailDAO);
						payValue = amanager.getPayProcessValue(alwDTOList, updatePayDetailDAO);

						if (headName.equals("B_PAY")) {
							payValue = (new StringBuilder()).append("")
									.append(Double.parseDouble(incrementAmount) + Double.parseDouble(payValue))
									.toString();
						}
						alwDTO.setPayValue(payValue);
						alwDTO.setIsCalculated("1");
						pp_PayalwValue[i] = payValue;
					} else {
						pp_PayalwValue[i] = alwDTO.getPayValue();
						payValue = pp_PayalwValue[i];
					}

					if (payValue == null) {

					} else {
						total += Double.parseDouble(payValue + "");
					}

					i++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println((new StringBuilder()).append("value of total allowneces").append(total).toString());
			pbdto.setPpEmployeemasterid(pp_EmployeeMasterID);

			pbdto.setPp_PayAlw_MasterID(pp_PayalwMasterID);
			pbdto.setPayAlwShortName(updatePayDetailDAO.getPayAlwShortName(pp_PayalwMasterID, sys_PayCategoryID));
			pbdto.setPp_PayAlw_Value(pp_PayalwValue);
			pbdto.setPayScale("0");
			pbdto.setSalaryPercent(salaryPercent);

			System.out.println("++hraTownCategoryID" + hraTownCategoryID + "ccaTownCategoryID" + ccaTownCategoryID);
			pbdto.setHraTownCategoryID(hraTownCategoryID);
			pbdto.setCcaTownCategoryID(ccaTownCategoryID);
			pbdto.setEmployeeCode(employeeCode);
			List npsList = updatePayDetailDAO.getEmpNPSDetail(pp_EmployeeMasterID, dateOfEffect,
					pbdto.getBilltypeFlag());
			String npsMasterid[] = new String[npsList.size()];
			String npsamount[] = new String[npsList.size()];
			NPSDetailDTO npDTO = null;
			int j = 0;
			for (Iterator npsIter = npsList.iterator(); npsIter.hasNext(); System.out.println(
					(new StringBuilder()).append("NPSamount........").append(npDTO.getEmpContAmt()).toString())) {
				npDTO = new NPSDetailDTO();
				npDTO = (NPSDetailDTO) npsIter.next();
				npsMasterid[j] = npDTO.getPpNpsArrearid() + "";
				npsamount[j++] = npDTO.getEmpContAmt() + "";
			}

			pbdto.setPp_NpsDetailID(npsMasterid);
			pbdto.setNpsamount(npsamount);

			System.out.println("NPS arrear system done his job........");
			System.out.println("i m just above the loan list........");
			List loanList = updatePayDetailDAO.getEmpLoanDetail(pp_EmployeeMasterID, dateOfEffect,
					pbdto.getBilltypeFlag());
			String loanMasterID[] = new String[loanList.size()];
			String loanAmount[] = new String[loanList.size()];
			String pa_NextInstallmentNo[] = new String[loanList.size()];

			LoanDetailDTO ldDTO = null;
			int i = 0;
			Iterator loanIter = loanList.iterator();
			System.out.println(
					(new StringBuilder()).append("Going to identify loan list: ").append(loanList.size()).toString());
			while (loanIter.hasNext()) {
				ldDTO = new LoanDetailDTO();
				ldDTO = (LoanDetailDTO) loanIter.next();
				loanMasterID[i] = ldDTO.getPpLoanmasterid();
				System.out.println((new StringBuilder()).append("ldDTO.getPa_NextInstallmentNo(): ")
						.append(ldDTO.getPaNextinstallmentno()).toString());
				pa_NextInstallmentNo[i] = ldDTO.getPaNextinstallmentno() + "";
				System.out
						.println((new StringBuilder()).append("loanMasterID[i] = ").append(loanMasterID[i]).toString());
				pa_NextInstallmentNo[i] = ldDTO.getPaNextinstallmentno() + "";

				System.out
						.println((new StringBuilder()).append("loanMasterID[i] = ").append(loanMasterID[i]).toString());
				System.out.println("+++++ hey abhinavv i m " + ldDTO.getPaNextinstallmentno());
				System.out.println("+++++ hey pa_NextInstallmentNo[i] i m " + pa_NextInstallmentNo[i]);

				System.out.println("++++++++++ldDTO.above()+++++++" + ldDTO.getFirstinstallmentamount());
				String demo = "1";
				String paNextinstallmentno = ldDTO.getPaNextinstallmentno() + "";
				if (paNextinstallmentno.equals(demo)) {
					System.out.println(
							"++++++++++ldDTO.getFirstInstallmentAmount()+++++++" + ldDTO.getFirstinstallmentamount());
					loanAmount[i++] = ldDTO.getFirstinstallmentamount() + "";
				} else {
					System.out.println("+++++++++++++++ldDTO.getPa_InstallmentAmount()++++++++++++++++++"
							+ ldDTO.getPaInstallmentamount());
					loanAmount[i++] = Integer.toString(ldDTO.getPaInstallmentamount());
				}

			}

			pbdto.setPp_LoanDetailID(loanMasterID);
			pbdto.setLoanAmount(loanAmount);
			pbdto.setPa_NextInstallmentNo(pa_NextInstallmentNo);

			System.out.println("i am above the ded list  ");
			System.out.println("NUMMMBERRRROFFFFDAYYYYYSSSSSSSSSSSSSSSS" + noOfDays);

			List dedList = updatePayDetailDAO.getEmpDeductionDetail(pp_EmployeeMasterID, dateOfEffect,
					pbdto.getBilltypeFlag());

			System.out.println((new StringBuilder()).append("Calculating AUTO allowances for EMPID: ")
					.append(pp_EmployeeMasterID).toString());

			System.out.println((new StringBuilder()).append("dedList size = ").append(dedList.size()).toString());
			String dedDetailID[] = new String[dedList.size()];
			String dedAmount[] = new String[dedList.size()];
			EmployeeDedDetailDTO eddDTO = null;
			i = 0;
			Iterator dedIter = dedList.iterator();
			while (dedIter.hasNext()) {
				eddDTO = new EmployeeDedDetailDTO();
				eddDTO = (EmployeeDedDetailDTO) dedIter.next();
				dedDetailID[i] = eddDTO.getPpDeductionmasterid() + "";
				System.out.println((new StringBuilder()).append("dedDetailID[i] = ").append(dedDetailID[i]).toString());
				dedAmount[i++] = eddDTO.getAmount() + "";
			}

			pbdto.setPp_DedDetailID(dedDetailID);
			pbdto.setDedAmount(dedAmount);

			pbdto.setTotalEmployee(total_employee);
			System.out.println((new StringBuilder()).append("total........").append(total).toString());
			totals += total;
			glist.add(pbdto);

		}
		pbdto.setBillamount((long) Math.round(totals));
		isComplete = updatePayDetailDAO.insertPayBillDetailIntoDB(pbdto, glist);
		return isComplete;
	}

	/* ----------------------VIKAS CODE START HERE---------------------- */
	@Override
	public boolean addAllowance(PayAlwDTO payAlwDTO) {

		boolean iscomplete = updatePayDetailDAO.addAllowance(payAlwDTO);

		return iscomplete;
	}

	@Override
	public boolean addEmpGPFDetails(Long ppEmployeemasterid) {
		boolean iscomplete = updatePayDetailDAO.addEmpGPFDetails(ppEmployeemasterid);

		return iscomplete;
	}

	@Override
	public List getISndpsCompleted(String ppEmployeeMasterID) {

		List isndpscompleted = null;

		isndpscompleted = updatePayDetailDAO.getISndpsCompleted(ppEmployeeMasterID);

		return isndpscompleted;
	}

	@Override
	public List getPayAlwName1(String ppEmployeeMasterID) {
		List isndpscompleted = null;

		isndpscompleted = updatePayDetailDAO.getPayAlwName1(ppEmployeeMasterID);

		return isndpscompleted;
	}

	@Override
	public List getEmployeeDedDetail(String ppEmployeeMasterID) {
		List empdedlist = null;

		empdedlist = updatePayDetailDAO.getEmployeeDedDetail(ppEmployeeMasterID);

		return empdedlist;
	}

	@Override
	public boolean addEmpDedDetail(DedDetailDTO dedDetailDTO) {
		boolean iscomplete = false;

		String[] param = dedDetailDTO.getParam();

		return iscomplete = updatePayDetailDAO.addEmpDedDetail(dedDetailDTO, param);
	}

	/* ----------------------VIKAS CODE END HERE---------------------- */

	public List<PpLoanEntity> populateLoanMasterCombo(String empMasterID, String pp_LoanDetailID) {

		List<PpLoanEntity> list = null;

		try {

			list = updatePayDetailDAO.populateLoanMasterCombo(empMasterID, pp_LoanDetailID);

		} catch (Exception e) {
		}

		return list;

	}

	public String[] isBearingLoan(String pp_EmployeeMasterID, String pp_LoanMasterID) {
		String[] out = new String[2];
		try {
			out = updatePayDetailDAO.isBearingLoan(pp_EmployeeMasterID, pp_LoanMasterID);
		} catch (Exception e) {
			System.out.println("Errors : " + e);
		}
		return out;
	} // end method

	public boolean insertLoanSanction(LoanSanctionDTO dto) {
		boolean isComplete = false;
		try {
			isComplete = updatePayDetailDAO.insertLoanSanction(dto);

		} catch (Exception me) {
		}
		return isComplete;
	}

	/****************** deleteLoanSanction ****************/
	public boolean deleteLoanSanction(String pp_LoanDetailID) {

		boolean isComplete = false;
		try {
			// Calling DAO's method to get Employee's Info
			isComplete = updatePayDetailDAO.deleteLoanSanction(pp_LoanDetailID);

		} catch (Exception e) {
			System.out.println("Exception raised is " + e);
		}
		return isComplete;

	} // end method

	/****************** retrieveLoanSanction ****************/
	public List retrieveLoanSanction(String pp_LoanDetailID) {

		List list = null;

		list = updatePayDetailDAO.retrieveLoanSanction(pp_LoanDetailID);

		return list;

	} // end method

	/****************** updateLoanSanction ****************/
	public boolean updateLoanSanction(LoanSanctionDTO dto) {

		boolean isComplete = false;
		try {

			// Calling method of DAO to edit a district information
			isComplete = updatePayDetailDAO.updateLoanSanction(dto);

		} catch (Exception e) {
			System.out.println("Exception raised is " + e);
		}

		return isComplete;
	} // end method

	@Override
	public List getPayBillListForLock(Integer rmOfficeid, String ppRegistermasterid, String monthName,
			String yearName) {
		return updatePayDetailDAO.getPayBillListForLock(rmOfficeid, ppRegistermasterid, monthName, yearName);
	}

	public List<?> getPayBillInfo(String pp_PayBillDetailID) {
		return updatePayDetailDAO.getPayBillInfo(pp_PayBillDetailID);
	}// end method

	public boolean passSalaryBill(LockPayBillDTO lockPayBillDTO) {
		return updatePayDetailDAO.passSalaryBill(lockPayBillDTO);
	}

	@Override
	public List<PartlyEmpListEntity> getAddPayEmployeeList(String pp_RegisterMasterID, int month1, int year1,
			Integer rmOfficeid, int numDays) {

		List<PartlyEmpListEntity> list = null;
		try {
			list = updatePayDetailDAO.getEmployeeList(pp_RegisterMasterID, month1, year1, rmOfficeid, numDays);
		} catch (Exception e) {
			System.out.println((new StringBuilder()).append("Exception Raised in ").append(e.toString()).toString());
		}
		return list;

	}

	public boolean checkPreviousMonthProcess(String employeeCode, String pp_RegisterMasterID, String dateOfEffect,
			String rm_OfficeID, String billType_Flag, ModelAndView modelAndView) {
		boolean isComplete = false;
		try {
			isComplete = updatePayDetailDAO.checkPreviousMonthProcess(employeeCode, pp_RegisterMasterID, dateOfEffect,
					rm_OfficeID, billType_Flag, modelAndView);
		} catch (Exception ue) {
			System.out.println((new StringBuilder()).append("Exception raised while checking previous month process: ")
					.append(ue.getMessage()).toString());

		}
		return isComplete;
	}

	public List getEmployeeList(String employeeCode, String pp_RegisterMasterID, String officeID, String payMaonth,
			String payYear) {

		List list = null;

		try {
			list = updatePayDetailDAO.getEmployeeList(employeeCode, pp_RegisterMasterID, officeID, payMaonth, payYear);
		} catch (Exception e) {
			System.out.println("Exception Raised in " + e.toString());
		}

		return list;

	} // end method

	public boolean checkNoOfDays(String pp_EmployeeMasterID, String pp_RegisterMasterID, String officeID,
			String payMaonth, String payYear, String curNoOfDays) {

		boolean isComplete = false;
		List list = null;
		try {
			int totalNoOfDays = 0;
			String noOfDays = updatePayDetailDAO.checkNoOfDays(pp_EmployeeMasterID, pp_RegisterMasterID, officeID,
					payMaonth, payYear);
			GregorianCalendar cal = new GregorianCalendar(Integer.parseInt(payYear), Integer.parseInt(payMaonth) - 1,
					1);
			int maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			int noOfDay = 0;
			try {
				if (noOfDays == null || noOfDays.equals(""))
					noOfDay = maxDaysInMonth;
				else
					noOfDay = Integer.parseInt(noOfDays);
			} catch (NullPointerException npe) {
				noOfDay = maxDaysInMonth;
			}

			if (curNoOfDays == null || curNoOfDays.trim().length() <= 0) {
				curNoOfDays = "" + maxDaysInMonth;
			}

			if (noOfDay > maxDaysInMonth)
				noOfDay = maxDaysInMonth;
			totalNoOfDays = Integer.parseInt(curNoOfDays) + noOfDay;
			if (totalNoOfDays > maxDaysInMonth)
				isComplete = false;
			else
				isComplete = true;

		} catch (Exception e) {
			System.out.println("Exception Raised in " + e.toString());
		}
		return isComplete;

	}

	public boolean updateBillDateAndBillNo(String billDate, String billNo, String employeeCode, String payMonth,
			String payYear) {

		return updatePayDetailDAO.updateBillDateAndBillNo(billDate, billNo, employeeCode, payMonth, payYear);
	}

	public List<ViewPpNpsdetail> getNPSArrearList(String pp_EmployeeMasterID) {

		List<ViewPpNpsdetail> list = null;

		try {

			list = updatePayDetailDAO.getNPSArrearList(pp_EmployeeMasterID);

		} catch (Exception e) {
		}

		return list;

	} // end method

	public List<PpNpsdetailEntity> getnpsDetail(String pp_EmployeeMasterID) {
		List<PpNpsdetailEntity> list = null;
		Object obj = null;

		try {

			// Calling DAO's FN to get the Employee's List
			list = updatePayDetailDAO.getnpsDetail(pp_EmployeeMasterID);

		} catch (Exception e) {
		}

		return list;

	} // end method

	public String getPP_Paybilldetailid(String actual_ded_mon, String actual_ded_year, String pp_EmployeeMasterID) {
		String isnps_value = null;

		System.out.println("i m above addNPSContrCheck " + pp_EmployeeMasterID);
		try {

			isnps_value = updatePayDetailDAO.getPP_Paybilldetailid(actual_ded_mon, actual_ded_year,
					pp_EmployeeMasterID);
			System.out.println("i m  down addNPSContrCheck ");

		} catch (NullPointerException e) {
			System.out.println("i m is manager Exception Throws in manager " + "  getmessage()-->" + e.getMessage()
					+ e.toString());
			throw e;
		}

		return isnps_value;
	}

	public String getPP_PaybilldetailidformonthCont(String MON_CONTR, String YEAR_CONTR, String pp_EmployeeMasterID) {
		String isnps_value = null;

		System.out.println("i m above addNPSContrCheck " + pp_EmployeeMasterID);
		try {

			isnps_value = updatePayDetailDAO.getPP_Paybilldetailid(MON_CONTR, YEAR_CONTR, pp_EmployeeMasterID);
			System.out.println("i m  down addNPSContrCheck ");

		} catch (NullPointerException e) {
			System.out.println("i m is manager Exception Throws in manager " + "  getmessage()-->" + e.getMessage()
					+ e.toString());
			throw e;
		}

		return isnps_value;
	}

	public String addNPSContrCheck(String MON_CONTR, String YEAR_CONTR, String pp_employeemasterid,
			String pp_paybilldetailid) {
		String isnps_value = null;

		try {

			isnps_value = updatePayDetailDAO.addNPSContrCheck(MON_CONTR, YEAR_CONTR, pp_employeemasterid,
					pp_paybilldetailid);

		} catch (NullPointerException e) {
			System.out.println("i m is manager Exception Throws in manager " + "  getmessage()-->" + e.getMessage()
					+ e.toString());
			throw e;
		}

		return isnps_value;

	}

	@Override
	public String addNPSActualDedCheck(String actual_ded_mon, String actual_ded_year, String ppEmployeeMasterID,
			String pp_paybilldetailid) {

		String isnps_value = null;

		try {

			isnps_value = updatePayDetailDAO.addNPSActualDedCheck(actual_ded_mon, actual_ded_year, ppEmployeeMasterID,
					pp_paybilldetailid);

		} catch (NullPointerException e) {
			System.out.println("i m is manager Exception Throws in manager " + "  getmessage()-->" + e.getMessage()
					+ e.toString());
			throw e;
		}

		return isnps_value;

	}// end method

	@Override
	public String getIsStop(String ppEmployeeMasterID, String mon_contr, String year_contr, String actual_ded_mon,
			String actual_ded_year) {
		String isnpsstop = null;

		try {

			// Calling DAO's FN to get the Employee's List
			isnpsstop = updatePayDetailDAO.getNpsStop(ppEmployeeMasterID, mon_contr, year_contr, actual_ded_mon,
					actual_ded_year);
			System.out.println("i m  isnps stop value is........................//////////////// " + isnpsstop);

		} catch (NullPointerException e) {
			System.out.println("i m is manager Exception Throws in manager " + "  getmessage()-->" + e.getMessage()
					+ e.toString());
			throw e;
		}

		return isnpsstop;

	}

	@Override
	public int updatenpsstopvalue(String ppEmployeeMasterID, String mon_contr, String year_contr, String actual_ded_mon,
			String actual_ded_year, String changeisstopnps) {

		int updatevalue = 0;

		try {

			updatevalue = updatePayDetailDAO.updateNpsStop(ppEmployeeMasterID, mon_contr, year_contr, actual_ded_mon,
					actual_ded_year, changeisstopnps);
			System.out.println("change value of nps stop  " + updatevalue);

		} catch (Exception e) {
			System.out.println("i m is manager Exception Throws in manager " + "  getmessage()-->" + e.getMessage()
					+ e.toString());

		}

		return updatevalue;
	}

	public boolean addNPSDetail(NPSDetailDTO npsDetailDTO, Integer rmOfficeid, String stopcontr) {

		boolean isCompleted = false;
		try {
			String[] param = new String[10];
			param[0] = npsDetailDTO.getPpEmployeemasterid() + "";
			param[1] = npsDetailDTO.getStartmon_forregular_cont();
			param[2] = npsDetailDTO.getJoining_mnth();
			param[3] = npsDetailDTO.getYear_contr();
			param[4] = npsDetailDTO.getMon_contr();
			param[5] = npsDetailDTO.getEmpContAmt() + "";
			param[6] = npsDetailDTO.getActual_ded_mon();
			param[7] = npsDetailDTO.getActual_ded_year();
			param[8] = rmOfficeid + "";
			param[9] = stopcontr;

			isCompleted = updatePayDetailDAO.addNPSDetail(param);

		} catch (Exception e) {
			System.out.println("Exception Throws in manager " + e.toString());
			throw e;
		}

		return isCompleted;
	}

	public List<DeletePayBillEntity> getPayBillListToDelete(Integer rm_OfficeID) {
		List<DeletePayBillEntity> payBillList = null;
		try {
			payBillList = updatePayDetailDAO.getPayBillListToDelete(rm_OfficeID);
		} catch (Exception e) {
			System.out.println("error inside getPayBillListToDelete method of manager " + e);
		}
		return payBillList;
	}//

	public boolean deletePayBill(String pp_PayBillDetailID) {
		boolean isDeleted = false;
		try {
			isDeleted = updatePayDetailDAO.deletePayBill(pp_PayBillDetailID);
		} catch (Exception e) {
			System.out.println("Exception while deleting pay bill: in manager " + e);
		}
		return isDeleted;
	}

}
