package com.nic.upjn.spring.controller;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.miscellaneous.CalenderUtils;
import com.nic.upjn.spring.Service.GPFLedgerArrearService;
import com.nic.upjn.spring.Service.ServiceBookService;
import com.nic.upjn.spring.dto.EmployeeStatusDTO;
import com.nic.upjn.spring.dto.GPFArrearDTO;
import com.nic.upjn.spring.dto.GPFLedgerArrearDTO;
import com.nic.upjn.spring.dto.GPFWithdrawalDTO;
import com.nic.upjn.spring.entity.AdvRecDetailsEntity;
import com.nic.upjn.spring.entity.EmployeeDetailEntity;
import com.nic.upjn.spring.entity.GPFLedgerEntity;
import com.nic.upjn.spring.entity.GPFOpeningBalanceEntity;
import com.nic.upjn.spring.entity.GPFValuesEntity;
import com.nic.upjn.spring.entity.GPFWithdrawalEntity;
import com.nic.upjn.spring.entity.GpfArrearEntity;
import com.nic.upjn.spring.entity.MasEmploymentsubtype;
import com.nic.upjn.spring.entity.PpDesignationmaster;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.ViewPpWholeemplist;

@Controller
public class GPFLedgerArrearController {

	@Autowired
	GPFLedgerArrearService service;

	@Autowired
	ServiceBookService serviceBookService;

	ModelAndView target = new ModelAndView();

	@RequestMapping("/gpfledgeropeningbalanceform")
	public ModelAndView gpfledgeropeningbalanceform() {

		try {
			target = new ModelAndView("gpfledgeropeningbalanceform");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return target;
	}

	@SuppressWarnings({ "unchecked" })
	@RequestMapping("/insertnewopeningbalance")
	public ModelAndView insertnewopeningbalance(@ModelAttribute("dto") GPFLedgerArrearDTO dto) {

		target = new ModelAndView("gpfledgeropeningbalanceform");
		String pp_EmployeemasterID = "";
		long openingbalance = 0;
		String year = dto.getFinanceYear();
		String yearrange[] = year.split("-");
		String startYear = yearrange[0];
		String endYear = yearrange[1];

		/**/
		String arrearmonth = "";
		String arrearyear = "";
		BigDecimal a = null;
		int temp_withdrawal = 0;

		try {
			List<PpEmployeemaster> employeedetail = (List<PpEmployeemaster>) service.getList(dto.getEmployeecode(),
					"PpEmployeemaster.findByEmployeecode");
			for (PpEmployeemaster employeemaster : employeedetail) {
				pp_EmployeemasterID = employeemaster.getPpEmployeemasterid().toString();
			}

			/* GPF Value */
			List<GPFValuesEntity> list = service.getgpfvalue(pp_EmployeemasterID, startYear, endYear);

			/* Opening Balance */
			List<GPFOpeningBalanceEntity> list1 = (List<GPFOpeningBalanceEntity>) service.getList(pp_EmployeemasterID,
					"GPFOpeningBalance.findbyppemployeemasterid");
			for (GPFOpeningBalanceEntity gpfOpeningBalanceEntity : list1) {
				openingbalance = gpfOpeningBalanceEntity.getOPENING_BALANCE();
			}

			System.out.println("value of opening balance --" + openingbalance);

			/* If opening balance is not available */
			if (list1.size() == 0) {
				String gpfacno = "";
				List<EmployeeDetailEntity> employeedata = service.getemployeedetails(dto.getEmployeecode());
				for (EmployeeDetailEntity entity : employeedata) {
					gpfacno = entity.getGPFACNO();
				}
				int insertopeningbalance = service.insertopeningbalance(dto, gpfacno, pp_EmployeemasterID);
				System.out.println("Return Value of insertopeningbalance method ::::" + insertopeningbalance);

				if (insertopeningbalance == 1) {
					target.addObject("msg", "Opening Balance Added Successfully");
				} else {
					target.addObject("error", "Error in adding Opening Balance");
				}

			}
			/* If opening balance is available already */
			else {
				target.addObject("msg", "Opening Balance of this Employee for this financial Year Already Exist");
			}

			/************
			 * Insert Data in GPF Ledger Table for Report
			 ***************************************/

			for (GPFValuesEntity entity : list) {

				long amount = entity.getGPFAMOUNT();
				arrearmonth = entity.getPAYMONTH();
				String monthname = entity.getMonthname();
				arrearyear = entity.getPAYYEAR();

				List<GpfArrearEntity> list2 = service.getarrearamount(pp_EmployeemasterID, arrearmonth, arrearyear);

				System.out.println(list2.size() + "---size of arrear list");

				long arrearamount = 0;
				for (GpfArrearEntity gpfArrearEntity : list2) {
					arrearamount = gpfArrearEntity.getAMOUNT();
				}

				String installment_no = "";
				int rec_amount = 0;
				String totalnoofinstallments = "";

				List<AdvRecDetailsEntity> advrecoveryList = service.getadvrec(pp_EmployeemasterID, arrearmonth,
						arrearyear);
				for (AdvRecDetailsEntity advRecDetailsEntity : advrecoveryList) {
					installment_no = advRecDetailsEntity.getINSTALLMENT_NO() + "";
					rec_amount = (int) advRecDetailsEntity.getGPF_ADV_AMOUNT();
					totalnoofinstallments = advRecDetailsEntity.getPA_NOOFINSTALLMENTS() + "";
				}

				long totaldeposit = 0;
				totaldeposit = arrearamount + amount + rec_amount;
				System.out.println("totaldeposit = " + totaldeposit);

				/* Temp Withdrawal */
				List temp_withdrawalList = service.gettempwithdrawal(pp_EmployeemasterID, arrearmonth, arrearyear);

				if (temp_withdrawalList.size() > 0) {
					Iterator itr = temp_withdrawalList.iterator();

					BigDecimal b = null;
					while (itr.hasNext()) {
						b = (BigDecimal) itr.next();
					}

					temp_withdrawal = b.intValue();
				}

				List<GPFWithdrawalEntity> withdrawallist = service.getwithdrawals(pp_EmployeemasterID, arrearmonth,
						arrearyear);

				long finalwithdrawal = 0;
				for (GPFWithdrawalEntity gpfWithdrawalEntity : withdrawallist) {
					finalwithdrawal = gpfWithdrawalEntity.getAMOUNT();
				}
				System.out.println("Value of Final Withdrawal = " + finalwithdrawal);

				// long total_withdrawal = temp_withdrawal +
				// finalwithdrawal;

				long balance = 0;
				balance = totaldeposit + openingbalance;
				long balanceamount = balance - finalwithdrawal;

				System.out.println("value of balance = " + balance);
				System.out.println("value of balance amount = " + balanceamount);

				List interestratelist = service.getinterestrate(arrearmonth, arrearyear);

				Iterator iterator = interestratelist.iterator();
				while (iterator.hasNext()) {
					a = (BigDecimal) iterator.next();
				}

				long interestrate = a.longValue();
				System.out.println("Value of Interest Rate=================" + interestrate);

				int interestAmount = ((int) balanceamount * (int) interestrate) / (100 * 12);
				System.out.println("Value of Interest Amount ==" + interestAmount);

				GPFLedgerEntity gpfLedgerEntity = new GPFLedgerEntity();
				gpfLedgerEntity.setAMOUNT(rec_amount);
				gpfLedgerEntity.setARREAR(arrearamount);
				//gpfLedgerEntity.setBALANCE(balanceamount);
				gpfLedgerEntity.setFINAL_WITHDRAWAL(finalwithdrawal);
				gpfLedgerEntity.setINSTL_NO(installment_no);
				//gpfLedgerEntity.setINTEREST_AMOUNT(interestAmount);
				gpfLedgerEntity.setINTEREST_RATE(interestrate);
				gpfLedgerEntity.setMONTH(arrearmonth);
				gpfLedgerEntity.setPP_EMPLOYEEMASTERID(Long.parseLong(pp_EmployeemasterID));
				gpfLedgerEntity.setSALARY(amount);
				gpfLedgerEntity.setTEMP_WITHDRAWAL(temp_withdrawal);
				gpfLedgerEntity.setTOTALDEPOSIT(totaldeposit);
				gpfLedgerEntity.setYEAR(arrearyear);
				gpfLedgerEntity.setPA_NOOFINSTALLMENTS(totalnoofinstallments);
				gpfLedgerEntity.setMONTHNAME(monthname);

				int result = service.insertintoGPFledger(gpfLedgerEntity);

				openingbalance = balanceamount;
				temp_withdrawal = 0;
				System.out.println("value of new opening balance = " + openingbalance
						+ " and value of temp-withdrawal =" + temp_withdrawal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return target;
	}

	@RequestMapping("/gpfledgerReportbegin")
	public ModelAndView gpfledgerReportbegin() {

		try {
			target = new ModelAndView("GPFLedgerReportForm");

			System.out.println("gpfledgerReportbegin");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return target;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/gpfledgerarrearform")
	public ModelAndView gpfledgerarrearform() {

		try {
			target = new ModelAndView("GPFArrearForm");

			/* Month and Year List */
			List months = CalenderUtils.populateMonth();
			List years = CalenderUtils.populateYear();

			target.addObject("months", months);
			target.addObject("years", years);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/insertArrear")
	public ModelAndView insertArrear(@ModelAttribute("dto") GPFArrearDTO dto) {

		try {
			target = new ModelAndView("GPFArrearForm");
			long pP_EMPLOYEEMASTERID = 0;

			List<PpEmployeemaster> employeedetail = (List<PpEmployeemaster>) service.getList(dto.getEmp_code() + "",
					"PpEmployeemaster.findByEmployeecode");
			for (PpEmployeemaster employeemaster : employeedetail) {
				pP_EMPLOYEEMASTERID = employeemaster.getPpEmployeemasterid();
			}

			GpfArrearEntity entity = new GpfArrearEntity();

			entity.setAMOUNT(dto.getAmount());
			entity.setARREAR_FROM(dto.getArrearfrom());
			entity.setARREAR_MONTH(dto.getMonth());
			entity.setARREAR_TO(dto.getArrearto());
			entity.setARREAR_YEAR(dto.getYear());
			entity.setARREARTYPE(dto.getArreartype());
			entity.setBILL_NUMBER(dto.getBillnumber());
			entity.setDATE_OF_ENTRY(dto.getDateofentry());
			entity.setPP_EMPLOYEEMASTERID(pP_EMPLOYEEMASTERID);

			int result = service.insertArrear(entity);

			if (result == 1) {
				target.addObject("msg", "Arrear Added Successfully");
			} else {
				target.addObject("error", "Arrear Not Added ");
			}

			int updatearrear = service.updatearrearingpfledger(pP_EMPLOYEEMASTERID, dto.getMonth(), dto.getYear(),
					dto.getAmount());

			if (updatearrear == 1) {
				System.out.println("GPF LEdger table updated successfully after inserting Arrear Values");
			} else {
				System.out.println("GPF LEdger table not updated successfully after inserting Arrear Values");
			}
			/* Month and Year List */
			List months = CalenderUtils.populateMonth();
			List years = CalenderUtils.populateYear();

			target.addObject("months", months);
			target.addObject("years", years);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return target;
	}

	@RequestMapping("/gpfwithdrawalbegin")
	public ModelAndView gpfwithdrawalbegin() {

		try {
			target = new ModelAndView("GPFWithdrawalForm");

			/* Month and Year List */
			List months = CalenderUtils.populateMonth();
			List years = CalenderUtils.populateYear();

			target.addObject("months", months);
			target.addObject("years", years);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return target;
	}

	
	@SuppressWarnings("unchecked")
	@RequestMapping("/insertWithdrawal")
	public ModelAndView insertWithdrawal(@ModelAttribute("dto") GPFWithdrawalDTO dto, HttpServletRequest request,
			HttpServletResponse response) {

		long pP_EMPLOYEEMASTERID = 0;

		try {
			target = new ModelAndView("GPFWithdrawalForm");

			GPFWithdrawalEntity entity = new GPFWithdrawalEntity();

			BeanUtils.copyProperties(dto, entity);

			List<PpEmployeemaster> employeedetail = (List<PpEmployeemaster>) service.getList(dto.getEmp_code() + "",
					"PpEmployeemaster.findByEmployeecode");
			for (PpEmployeemaster employeemaster : employeedetail) {
				pP_EMPLOYEEMASTERID = employeemaster.getPpEmployeemasterid();
			}

			entity.setPP_EMPLOYEEMASTERID(pP_EMPLOYEEMASTERID);

			int result = service.insertwithdrawal(entity);

			if (result == 1) {
				target.addObject("msg", "Withdrawal Added Successfully");
			} else {
				target.addObject("error", "Error in adding Withdrawal");
			}

			int updatewithdrawal = service.updatewithdrawalingpfledger(pP_EMPLOYEEMASTERID, dto.getMONTH(),
					dto.getYEAR(), dto.getAMOUNT());

			if (updatewithdrawal == 1) {
				System.out.println("GPF LEdger table updated successfully after inserting WITHDRAWAL Values");
			} else {
				System.out.println("GPF LEdger table not updated successfully after inserting WITHDRAWAL Values");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return target;
	}

	
	@SuppressWarnings("unchecked")
	@RequestMapping("/getgpfledgerreport")
	public ModelAndView getgpfledgerreport(@ModelAttribute("dto") GPFLedgerArrearDTO dto) {

		try {
			String year = dto.getFinanceYear();
			String yearrange[] = year.split("-");
			String startYear = yearrange[0];
			String endYear = yearrange[1];

			target = new ModelAndView("GPFReport1");

			System.out.println("gpfledgerReport");

			String ppemployeemasterid = "";
			List<EmployeeDetailEntity> employeedata = service.getemployeedetails(dto.getEmployeecode());
			for (EmployeeDetailEntity entity : employeedata) {
				ppemployeemasterid = entity.getPP_EMPLOYEEMASTERID();
			}

			String openingbalance = "";
			List<GPFOpeningBalanceEntity> getopeningbalance = service.getopeningbalance(ppemployeemasterid, year);
			for (GPFOpeningBalanceEntity entity : getopeningbalance) {
				openingbalance = entity.getOPENING_BALANCE() + "";
			}
			List<GPFLedgerEntity> reportdata = service.getgpfledgerreport(ppemployeemasterid, startYear, endYear);
			
			

			target.addObject("ecode", dto.getEmployeecode());
			target.addObject("reportdata", reportdata);
			target.addObject("employeedata", employeedata);
			target.addObject("openingbalance", openingbalance);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return target;
	}

	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	@RequestMapping("/getgpfledgerreport1")
	public ModelAndView getgpfledgerreport1(@ModelAttribute("dto") GPFLedgerArrearDTO dto) {

		try {
			int rec_amount = 0;
			String arrearmonth = "";
			String arrearyear = "";
			String installment_no = "";
			String totalnoofinstallments = "";
			int temp_withdrawal = 0;
			BigDecimal a = null;

			String year = dto.getFinanceYear();
			String yearrange[] = year.split("-");
			String startYear = yearrange[0];
			String endYear = yearrange[1];
			
			List interestratelist = null;
			List<GpfArrearEntity> list2 = null;
			List<AdvRecDetailsEntity> advrecoveryList = null;
			List temp_withdrawalList  = null;
			List<GPFWithdrawalEntity> withdrawallist = null;
			

			target = new ModelAndView("GPFReport1");

			String ppemployeemasterid = "";
			List<EmployeeDetailEntity> employeedata = service.getemployeedetails(dto.getEmployeecode());
			for (EmployeeDetailEntity entity : employeedata) {
				ppemployeemasterid = entity.getPP_EMPLOYEEMASTERID();
			}

			String openingbalance = "";
			List<GPFOpeningBalanceEntity> getopeningbalance = service.getopeningbalance(ppemployeemasterid, year);
			for (GPFOpeningBalanceEntity entity : getopeningbalance) {
				openingbalance = entity.getOPENING_BALANCE() + "";
			}
			// List<GPFLedgerEntity> reportdata =
			// service.getgpfledgerreport(ppemployeemasterid, startYear,
			// endYear);

			/* GPF Value */
			List<GPFValuesEntity> list = service.getgpfvalue(ppemployeemasterid, startYear, endYear);

			for (GPFValuesEntity entity : list) {

				long amount = entity.getGPFAMOUNT();
				arrearmonth = entity.getPAYMONTH();
				String monthname = entity.getMonthname();
				arrearyear = entity.getPAYYEAR();

				 list2 = service.getarrearamount(ppemployeemasterid, arrearmonth, arrearyear);

				System.out.println(list2.size() + "---size of arrear list");

				long arrearamount = 0;
				for (GpfArrearEntity gpfArrearEntity : list2) {
					arrearamount = gpfArrearEntity.getAMOUNT();
				}

			 advrecoveryList = service.getadvrec(ppemployeemasterid, arrearmonth,
						arrearyear);
				for (AdvRecDetailsEntity advRecDetailsEntity : advrecoveryList) {
					installment_no = advRecDetailsEntity.getINSTALLMENT_NO() + "";
					rec_amount = (int) advRecDetailsEntity.getGPF_ADV_AMOUNT();
					totalnoofinstallments = advRecDetailsEntity.getPA_NOOFINSTALLMENTS() + "";
				}

			/*	long totaldeposit = 0;
				totaldeposit = arrearamount + amount + rec_amount;
				System.out.println("totaldeposit = " + totaldeposit);
*/
				/* Temp Withdrawal */
				 temp_withdrawalList = service.gettempwithdrawal(ppemployeemasterid, arrearmonth, arrearyear);

				if (temp_withdrawalList.size() > 0) {
					Iterator itr = temp_withdrawalList.iterator();

					BigDecimal b = null;
					while (itr.hasNext()) {
						b = (BigDecimal) itr.next();
					}

					temp_withdrawal = b.intValue();
				}

			withdrawallist = service.getwithdrawals(ppemployeemasterid, arrearmonth,
						arrearyear);

				long finalwithdrawal = 0;
				for (GPFWithdrawalEntity gpfWithdrawalEntity : withdrawallist) {
					finalwithdrawal = gpfWithdrawalEntity.getAMOUNT();
				}
				System.out.println("Value of Final Withdrawal = " + finalwithdrawal);

				/*long balance = 0;
				balance = totaldeposit + openingbalance;
				long balanceamount = balance - finalwithdrawal;

				System.out.println("value of balance = " + balance);
				System.out.println("value of balance amount = " + balanceamount);*/
				
				 interestratelist = service.getinterestrate(arrearmonth, arrearyear);

				Iterator iterator = interestratelist.iterator();
				while (iterator.hasNext()) {
					a = (BigDecimal) iterator.next();
				}

				long interestrate = a.longValue();
				System.out.println("Value of Interest Rate=================" + interestrate);

			}
			target.addObject("getopeningbalance", getopeningbalance);
			target.addObject("list", list);
			target.addObject("list2", list2);
			
			target.addObject("advrecoveryList", advrecoveryList);
			target.addObject("temp_withdrawalList", temp_withdrawalList);
			target.addObject("withdrawallist", withdrawallist);
			target.addObject("interestratelist", interestratelist);
			
			
			target.addObject("ecode", dto.getEmployeecode());
			target.addObject("employeedata", employeedata);
			target.addObject("openingbalance", openingbalance);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return target;
	}

}
