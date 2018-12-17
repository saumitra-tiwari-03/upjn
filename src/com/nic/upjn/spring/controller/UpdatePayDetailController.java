package com.nic.upjn.spring.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.nic.upjn.miscellaneous.CalenderUtils;
import com.nic.upjn.miscellaneous.UtillException;
import com.nic.upjn.spring.Service.ManagePayBillService;
import com.nic.upjn.spring.Service.UpdatePayDetailService;
import com.nic.upjn.spring.dto.DedDetailDTO;
import com.nic.upjn.spring.dto.EmployeePayDetailDTO;
import com.nic.upjn.spring.dto.LoanSanctionDTO;
import com.nic.upjn.spring.dto.LockPayBillDTO;
import com.nic.upjn.spring.dto.NPSDetailDTO;
import com.nic.upjn.spring.dto.PayAlwDTO;
import com.nic.upjn.spring.dto.PayBillDTO;
import com.nic.upjn.spring.dto.RegisterDTO;
import com.nic.upjn.spring.entity.BillMasterEntryEntity;
import com.nic.upjn.spring.entity.DeletePayBillEntity;
import com.nic.upjn.spring.entity.FwaBankaccount;
import com.nic.upjn.spring.entity.LoanSanctionEntity;
import com.nic.upjn.spring.entity.PartlyEmpListEntity;
import com.nic.upjn.spring.entity.PayBillInfoEntity;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.PpLoanEntity;
import com.nic.upjn.spring.entity.PpLoandetail;
import com.nic.upjn.spring.entity.PpLoanmaster;
import com.nic.upjn.spring.entity.PpNpsdetailEntity;
import com.nic.upjn.spring.entity.PpPayscalemaster;
import com.nic.upjn.spring.entity.PpRegistermaster;
import com.nic.upjn.spring.entity.PpTowncategorymaster;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;
import com.nic.upjn.spring.entity.ViewEmployeename;
import com.nic.upjn.spring.entity.ViewLoandetail;
import com.nic.upjn.spring.entity.ViewPpEmpalwlist;
import com.nic.upjn.spring.entity.ViewPpEmpdeddetail;
import com.nic.upjn.spring.entity.ViewPpEmppaydetail;
import com.nic.upjn.spring.entity.ViewPpEmpprocesspaylist;
import com.nic.upjn.spring.entity.ViewPpNpsValid;
import com.nic.upjn.spring.entity.ViewPpNpsdetail;

@SuppressWarnings({ "unchecked", "unused" })
@Controller
public class UpdatePayDetailController {

	String returnPage = "updatepaydetail";
	List<PartlyEmpListEntity> employeeList = null;

	@Autowired
	ManagePayBillService managePayBillService;

	@Autowired
	UpdatePayDetailService updatePayDetailService;

	@RequestMapping("/selectRegister")
	public ModelAndView selectRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView selectRegisterModel = new ModelAndView(returnPage);
		List<PpRegistermaster> list = managePayBillService.getRegisterList();
		selectRegisterModel.addObject("registerList", list);
		selectRegisterModel.addObject("selectRegister", true);
		
		HttpSession session = request.getSession();
		selectRegisterModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		selectRegisterModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		return selectRegisterModel;
	}

	@RequestMapping(value = "/PayBill" , params = "updatePayDetails", method = RequestMethod.POST)
	public ModelAndView getAddPayEmployeeList(@ModelAttribute("registerDTO") RegisterDTO registerDTO,HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView getEmpListModel = new ModelAndView(returnPage);
		HttpSession session = request.getSession();
		
		Integer rmOfficeID = (Integer) session.getAttribute("rmOfficeid");
		System.out.println(registerDTO.getPpRegistermasterid());
		System.out.println(updatePayDetailService.getEmpPayDetailList(
				Short.parseShort(registerDTO.getPpRegistermasterid()), rmOfficeID).size());
		getEmpListModel.addObject(
				"empList",
				updatePayDetailService.getEmpPayDetailList(
						Short.parseShort(registerDTO.getPpRegistermasterid()), rmOfficeID));
		getEmpListModel.addObject("registerName", registerDTO.getPpRegistermasterid());
		
		getEmpListModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		getEmpListModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		return getEmpListModel;
	}

	@RequestMapping("/populateEmployeePayDetail")
	public ModelAndView populateEmployeePayDetail(
			@ModelAttribute("payBillDTO") PayBillDTO payBillDTO,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView populateEmpPayModel = new ModelAndView("EmpGenPayDetail");
		String ppEmployeeMasterID = request.getParameter("ppEmployemasterID");
		HttpSession session = request.getSession();
		Integer rmOfficeID = (Integer) session.getAttribute("rmOfficeid");
		System.out.println(ppEmployeeMasterID);
		List<ViewPpEmppaydetail> list = (List<ViewPpEmppaydetail>) updatePayDetailService
				.getComboList(ppEmployeeMasterID,
						"ViewPpEmppaydetail.findByPpEmployeemasterid");
		List<ViewEmployeeSearch> list1 = (List<ViewEmployeeSearch>) updatePayDetailService
				.getComboList(ppEmployeeMasterID,
						"ViewEmployeeSearch.findByPpEmployeemasterid");
		List<FwaBankaccount> acc = (List<FwaBankaccount>) updatePayDetailService
				.getComboList(rmOfficeID + "",
						"FwaBankaccount.findByRMofficeid");
		System.out.println(acc.size());
		for (ViewEmployeeSearch viewEmployeeSearch : list1) {
			populateEmpPayModel.addObject("employeecode",
					viewEmployeeSearch.getEmployeecode());
			populateEmpPayModel.addObject("employeename",
					viewEmployeeSearch.getEmployeename());
			populateEmpPayModel.addObject("designation",
					viewEmployeeSearch.getDesignation());
			populateEmpPayModel.addObject("emptype",
					viewEmployeeSearch.getEmploymenttype());
			populateEmpPayModel.addObject("ppempmasterid",
					viewEmployeeSearch.getPpEmployeemasterid());
		}
		for (ViewPpEmppaydetail viewPpEmppaydetail : list) {
			/***    ***/
	
			populateEmpPayModel.addObject("isnps",
					viewPpEmppaydetail.getIsnps());
			System.out.println("IS NPS VALUE IN GENERAL PAY DETAIL FORM -- "+viewPpEmppaydetail.getIsnps());
			
			if(viewPpEmppaydetail.getIsnps() != null){
				if(viewPpEmppaydetail.getIsnps().equals("N")){
					populateEmpPayModel.addObject("ISNPSCOL", "PRAN NO");
				}
				if(viewPpEmppaydetail.getIsnps().equals("G")){
					populateEmpPayModel.addObject("ISNPSCOL", "GPF NO");
				}
			}else{
				populateEmpPayModel.addObject("ISNPSCOL", "GPF NO");
			}
			
			
		
			/***    ***/
			populateEmpPayModel.addObject("sectionname",
					viewPpEmppaydetail.getSectionname());
			populateEmpPayModel.addObject("registername",
					viewPpEmppaydetail.getRegistername());
			populateEmpPayModel.addObject("gpfacno",
					viewPpEmppaydetail.getGpfacno());
			populateEmpPayModel.addObject("panno",
					viewPpEmppaydetail.getPanno());
			populateEmpPayModel.addObject("bankaccno",
					viewPpEmppaydetail.getBankaccno());
			populateEmpPayModel.addObject("bankname",
					viewPpEmppaydetail.getBankname());
			populateEmpPayModel.addObject("branchname",
					viewPpEmppaydetail.getBranchname());
			populateEmpPayModel.addObject("ifsccode",
					viewPpEmppaydetail.getIfsccode());
			populateEmpPayModel.addObject("salarypercent",
					viewPpEmppaydetail.getSalarypercent());
			populateEmpPayModel.addObject("paymentmode",
					viewPpEmppaydetail.getPaymentmode());
			populateEmpPayModel.addObject("sysPaymentmodeid",
					viewPpEmppaydetail.getSysPaymentmodeid());
			System.out.println("payment mode iD --"
					+ viewPpEmppaydetail.getSysPaymentmodeid());
			populateEmpPayModel.addObject("hq",
					viewPpEmppaydetail.getHeadquarter());
			String nod = viewPpEmppaydetail.getNoofdays();
			if (nod == null)
				nod = "";
			populateEmpPayModel.addObject("nod", nod);
            System.out.println("Value of No of Days == "+nod);
		}
		populateEmpPayModel.addObject("fwabankaccount", acc);

		populateEmpPayModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		populateEmpPayModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		return populateEmpPayModel;
	}

	@RequestMapping("/updateEmpPayDetail")
	public ModelAndView updateEmpPayDetail(
			@ModelAttribute("employeePayDetailDTO") EmployeePayDetailDTO employeePayDetailDTO,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView updateEmpPayDetailModel = new ModelAndView(
				"EmpGenPayDetail");
		String ppEmployeeMasterID = employeePayDetailDTO
				.getPp_EmployeeMasterID();
		boolean flag = updatePayDetailService
				.updateEmpPayDetail(employeePayDetailDTO);
		System.out.println(flag);
		updateEmpPayDetailModel.addObject("isComplete", flag);
		HttpSession session = request.getSession();
		Integer rmOfficeID = (Integer) session.getAttribute("rmOfficeid");
		System.out.println("!!!!!!!!!!!!!!" + ppEmployeeMasterID);
		List<ViewPpEmppaydetail> list = (List<ViewPpEmppaydetail>) updatePayDetailService
				.getComboList(ppEmployeeMasterID,
						"ViewPpEmppaydetail.findByPpEmployeemasterid");
		List<ViewEmployeeSearch> list1 = (List<ViewEmployeeSearch>) updatePayDetailService
				.getComboList(ppEmployeeMasterID,
						"ViewEmployeeSearch.findByPpEmployeemasterid");
		List<FwaBankaccount> acc = (List<FwaBankaccount>) updatePayDetailService
				.getComboList(rmOfficeID + "",
						"FwaBankaccount.findByRMofficeid");
		System.out.println(acc.size());
		for (ViewEmployeeSearch viewEmployeeSearch : list1) {
			updateEmpPayDetailModel.addObject("employeecode",
					viewEmployeeSearch.getEmployeecode());
			updateEmpPayDetailModel.addObject("employeename",
					viewEmployeeSearch.getEmployeename());
			updateEmpPayDetailModel.addObject("designation",
					viewEmployeeSearch.getDesignation());
			updateEmpPayDetailModel.addObject("emptype",
					viewEmployeeSearch.getEmploymenttype());
			updateEmpPayDetailModel.addObject("ppempmasterid",
					viewEmployeeSearch.getPpEmployeemasterid());
		}
		for (ViewPpEmppaydetail viewPpEmppaydetail : list) {
			updateEmpPayDetailModel.addObject("isnps",
					viewPpEmppaydetail.getIsnps());	
			
			/**  **/
			 if(viewPpEmppaydetail.getIsnps().equals("N")){
				 updateEmpPayDetailModel.addObject("ISNPSCOL", "PRAN NO");
				}
				if(viewPpEmppaydetail.getIsnps().equals("G")){
					updateEmpPayDetailModel.addObject("ISNPSCOL", "GPF NO");
				}
			 /** **/
			updateEmpPayDetailModel.addObject("sectionname",
					viewPpEmppaydetail.getSectionname());
			updateEmpPayDetailModel.addObject("registername",
					viewPpEmppaydetail.getRegistername());
			updateEmpPayDetailModel.addObject("gpfacno",
					viewPpEmppaydetail.getGpfacno());
			updateEmpPayDetailModel.addObject("panno",
					viewPpEmppaydetail.getPanno());
			updateEmpPayDetailModel.addObject("bankaccno",
					viewPpEmppaydetail.getBankaccno());
			updateEmpPayDetailModel.addObject("bankname",
					viewPpEmppaydetail.getBankname());
			updateEmpPayDetailModel.addObject("branchname",
					viewPpEmppaydetail.getBranchname());
			updateEmpPayDetailModel.addObject("ifsccode",
					viewPpEmppaydetail.getIfsccode());
			updateEmpPayDetailModel.addObject("salarypercent",
					viewPpEmppaydetail.getSalarypercent());
			updateEmpPayDetailModel.addObject("paymentmode",
					viewPpEmppaydetail.getPaymentmode());
			updateEmpPayDetailModel.addObject("sysPaymentmodeid",
					viewPpEmppaydetail.getSysPaymentmodeid());

			updateEmpPayDetailModel.addObject("hq",
					viewPpEmppaydetail.getHeadquarter());
			String nod = viewPpEmppaydetail.getNoofdays();
			if (nod == null)
				nod = "";
			updateEmpPayDetailModel.addObject("nod", nod);
            System.out.println("Value of No of Days == "+nod);
		}
		updateEmpPayDetailModel.addObject("fwabankaccount", acc);
		
		updateEmpPayDetailModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		updateEmpPayDetailModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		return updateEmpPayDetailModel;

	}

	/**************************
	 * 
	 * VIKAS Code Started
	 * 
	 **********************************/

	@RequestMapping("/payandalwdetails")
	public ModelAndView payandalwdetails(
			@ModelAttribute("payBillDTO") PayBillDTO payBillDTO,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView payandalwdetailsModel = new ModelAndView(
				"EmployeeAlwDetail");
		String ppEmployeeMasterID = request.getParameter("ppEmployeeMasterID");
		String sectionname = request.getParameter("sectionname");
		String registerName = request.getParameter("register");
		Short paySysCatID = null;
		String increment_monthID = null;
		Integer defaultIncrementAmount = 0;

		List<ViewEmployeeSearch> empList = null;
		List<ViewPpEmppaydetail> empPayList = null;
		List<PpPayscalemaster> empPayScaleList = null;
		List<ViewPpEmpalwlist> empAlwList = null;
		ArrayList<String> months = null;
		try {
			empList = (List<ViewEmployeeSearch>) updatePayDetailService
					.getComboList(ppEmployeeMasterID,
							"ViewEmployeeSearch.findByPpEmployeemasterid");
			empPayList = (List<ViewPpEmppaydetail>) updatePayDetailService
					.getComboList(ppEmployeeMasterID,
							"ViewPpEmppaydetail.findByPpEmployeemasterid");
			Iterator<ViewPpEmppaydetail> itr = empPayList.iterator();
			while (itr.hasNext()) {
				ViewPpEmppaydetail tempPayDeatil = itr.next();
				paySysCatID = tempPayDeatil.getSysPaycategoryid();
				increment_monthID = tempPayDeatil.getNextincrementmonth();
				defaultIncrementAmount = tempPayDeatil
						.getDefaultincrementamount();
			}

			months = CalenderUtils.populateMonth();
			System.out.println("Size of list of months --" + months.size());

			/******************/
			if (paySysCatID != null) {
				System.out.println("pay category is not null");
			} else {
				System.out.println("pay category is null");
			}

			if (paySysCatID != null) {
				empPayScaleList = (List<PpPayscalemaster>) updatePayDetailService
						.getComboList(paySysCatID + "",
								"PpPayscalemaster.findBySysPaycategoryid");

				empAlwList = (List<ViewPpEmpalwlist>) updatePayDetailService
						.getAlwList(ppEmployeeMasterID, paySysCatID + "");
			}

			if (empAlwList != null) {
				payandalwdetailsModel.addObject("empAlwList", empAlwList);
				payBillDTO.setStop_Alw_Flag(new String[empAlwList.size()]);


				ViewPpEmpalwlist viewPpEmpalwlist = null;
				int i = 0;
				Iterator<?> itr1 = empAlwList.iterator();
				do {
					if (!itr1.hasNext()) {
						break;
					}
					viewPpEmpalwlist = new ViewPpEmpalwlist();
					viewPpEmpalwlist = (ViewPpEmpalwlist) itr1.next();
					if (viewPpEmpalwlist.getStopAlwFlag() == '1') {
						payBillDTO.getStop_Alw_Flag()[i++] = viewPpEmpalwlist
								.getPpPayalwmasterid() + "";
					}
				} while (true);
			}

			if (empAlwList == null) {
				payBillDTO.setStop_Alw_Flag(new String[0]);
			}

			payandalwdetailsModel.addObject("empList", empList);
			payandalwdetailsModel.addObject("sectionName", sectionname);
			payandalwdetailsModel.addObject("registerName", registerName);
			payandalwdetailsModel.addObject("payCatList",
					updatePayDetailService.getList());
			payandalwdetailsModel.addObject("hraList", updatePayDetailService
					.getTownCategoryList("HRA", paySysCatID));
			payandalwdetailsModel.addObject("ccaList", updatePayDetailService
					.getTownCategoryList("CCA", paySysCatID));
			payandalwdetailsModel.addObject("sysPayScaleList", empPayScaleList);
			payandalwdetailsModel.addObject("empPayList", empPayList);

			payandalwdetailsModel.addObject("ppEmployeeMasterID",
					ppEmployeeMasterID);
			payandalwdetailsModel.addObject("Data", months);
			payandalwdetailsModel.addObject("increment_monthID",
					increment_monthID);
			payandalwdetailsModel.addObject("defaultIncrementAmount",
					defaultIncrementAmount);

		} catch (Exception e) {
			e.printStackTrace();
			return payandalwdetailsModel;

		}
		
		HttpSession session = request.getSession();
		payandalwdetailsModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		payandalwdetailsModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		return payandalwdetailsModel;
	}

	/* This method is Updating the records of Employee */

	@RequestMapping("/UpdatePay&AlwDetails")
	public ModelAndView UpdatePay(
			@ModelAttribute("payAlwDTO") PayAlwDTO payAlwDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView payandalwdetailsModel = new ModelAndView(
				"EmployeeAlwDetail");
		Short paySysCatID = null;
		String increment_monthID = null;
		int defaultIncrementAmount = 0;

		try {
			boolean iscomplete = false;
			String stopAlwFlag = "";

			if (payAlwDTO.getStopAlwFlag() != null) {
				for (int i = 0; i < payAlwDTO.getStopAlwFlag().length; i++) {
					if (i + 1 < payAlwDTO.getStopAlwFlag().length) {
						stopAlwFlag += payAlwDTO.getStopAlwFlag()[i] + "|";
					} else {
						stopAlwFlag += payAlwDTO.getStopAlwFlag()[i];
					}
				}
			}
			payAlwDTO.setStop_Alw_Flag(stopAlwFlag);

			iscomplete = updatePayDetailService.addAllowance(payAlwDTO);

			if (iscomplete) {
				boolean EmpGPF = updatePayDetailService
						.addEmpGPFDetails(payAlwDTO.getPpEmployeemasterid());
				System.out.println("all done");
				payandalwdetailsModel.addObject("msg",
						"Process Completed Successfully");
			} else {
				System.out
						.println("Error in DAO while executing method addEmpGPFDetails");
				payandalwdetailsModel.addObject("error", "Error");
			}

			/* Field values */
			System.out.println(payAlwDTO.getRegisterName() + "----"
					+ payAlwDTO.getSectionName());
			List<ViewEmployeeSearch> empList = (List<ViewEmployeeSearch>) updatePayDetailService
					.getComboList(payAlwDTO.getPpEmployeemasterid() + "",
							"ViewEmployeeSearch.findByPpEmployeemasterid");
			List<ViewPpEmppaydetail> empPayList = (List<ViewPpEmppaydetail>) updatePayDetailService
					.getComboList(payAlwDTO.getPpEmployeemasterid() + "",
							"ViewPpEmppaydetail.findByPpEmployeemasterid");
			Iterator<ViewPpEmppaydetail> itr = empPayList.iterator();
			while (itr.hasNext()) {
				ViewPpEmppaydetail tempPayDeatil = itr.next();
				paySysCatID = tempPayDeatil.getSysPaycategoryid();
				increment_monthID = tempPayDeatil.getNextincrementmonth();
				defaultIncrementAmount = tempPayDeatil
						.getDefaultincrementamount();
			}
			List<PpPayscalemaster> empPayScaleList = (List<PpPayscalemaster>) updatePayDetailService
					.getComboList(paySysCatID + "",
							"PpPayscalemaster.findBySysPaycategoryid");
			List<ViewPpEmpalwlist> empAlwList = (List<ViewPpEmpalwlist>) updatePayDetailService
					.getAlwList(payAlwDTO.getPpEmployeemasterid() + "",
							paySysCatID + "");

			ArrayList<String> months = CalenderUtils.populateMonth();
			System.out.println("Size of list of months --" + months.size());

			payandalwdetailsModel.addObject("empList", empList);
			payandalwdetailsModel.addObject("sectionName",
					payAlwDTO.getSectionName());
			payandalwdetailsModel.addObject("registerName",
					payAlwDTO.getRegisterName());
			payandalwdetailsModel.addObject("payCatList",
					updatePayDetailService.getList());
			payandalwdetailsModel.addObject("hraList", updatePayDetailService
					.getTownCategoryList("HRA", paySysCatID));
			payandalwdetailsModel.addObject("ccaList", updatePayDetailService
					.getTownCategoryList("CCA", paySysCatID));
			payandalwdetailsModel.addObject("sysPayScaleList", empPayScaleList);
			payandalwdetailsModel.addObject("empPayList", empPayList);
			payandalwdetailsModel.addObject("empAlwList", empAlwList);
			payandalwdetailsModel.addObject("ppEmployeeMasterID",
					payAlwDTO.getPpEmployeemasterid());
			payandalwdetailsModel.addObject("Data", months);
			payandalwdetailsModel.addObject("increment_monthID",
					increment_monthID);
			payandalwdetailsModel.addObject("defaultIncrementAmount",
					defaultIncrementAmount);

		} catch (Exception e) {

			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		payandalwdetailsModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		payandalwdetailsModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		return payandalwdetailsModel;
	}

	@RequestMapping("/populateEmployeeDeductionDetail")
	public ModelAndView populateEmployeeDeductionDetail(
			@ModelAttribute("dedDetailDTO") DedDetailDTO dedDetailDTO,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView deddetailsModel = new ModelAndView("EmployeeDedDetail");
		String ppEmployeeMasterID = request.getParameter("ppEmployemasterID");
		String sectionname = request.getParameter("sectionname");
		String registerName = request.getParameter("register");
		String isnpsvalid = null;
		String isnps = null;

		try {
			List<ViewEmployeeSearch> empList = (List<ViewEmployeeSearch>) updatePayDetailService
					.getComboList(ppEmployeeMasterID,
							"ViewEmployeeSearch.findByPpEmployeemasterid");

			List<ViewPpEmppaydetail> empPayList = (List<ViewPpEmppaydetail>) updatePayDetailService
					.getComboList(ppEmployeeMasterID,
							"ViewPpEmppaydetail.findByPpEmployeemasterid");
			for (ViewPpEmppaydetail emppaydetail : empPayList) {
				isnps = emppaydetail.getIsnps();
			}

			List<ViewPpNpsValid> npsvalidlist = (List<ViewPpNpsValid>) updatePayDetailService
					.getComboList(ppEmployeeMasterID,
							"ViewPpNpsValid.findByPpEmployeemasterid");
			for (ViewPpNpsValid viewPpNpsValid : npsvalidlist) {
				isnpsvalid = viewPpNpsValid.getIsnpsvalid() + "";
			}

			List<?> payalwname = updatePayDetailService
					.getPayAlwName1(ppEmployeeMasterID);

			java.math.BigDecimal basicpay = (java.math.BigDecimal) payalwname
					.get(0);

			String dedname="";
			
			List<ViewPpEmpdeddetail> dedList = updatePayDetailService
					.getEmployeeDedDetail(ppEmployeeMasterID);
			for(ViewPpEmpdeddetail viewPpEmpdeddetail : dedList){
				dedname = viewPpEmpdeddetail.getDeductionname();
				 System.out.println(dedname+"------ Ded name");
			}   
			
			deddetailsModel.addObject("ppEmployeeMasterID", ppEmployeeMasterID);
			deddetailsModel.addObject("sectionName", sectionname);
			deddetailsModel.addObject("registerName", registerName);
			deddetailsModel.addObject("empList", empList);
			deddetailsModel.addObject("basicpay", basicpay);
			deddetailsModel.addObject("dedList", dedList);
			deddetailsModel.addObject("empPayList", empPayList);
			deddetailsModel.addObject("isnpsvalid", isnpsvalid);
			deddetailsModel.addObject("isnps", isnps);
			
			request.setAttribute("dedList", dedList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		deddetailsModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		deddetailsModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		return deddetailsModel;
	}

	@RequestMapping(value = "/EmployeeDeductions", params = "saveDetuctionDetails", method = RequestMethod.POST)
	public ModelAndView AddEmployeeDeductionDetails(
			@ModelAttribute("dedDetailDTO") DedDetailDTO dedDetailDTO,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView deddetailsModel = new ModelAndView("EmployeeDedDetail");
		String pp_DeductionMasterID = "";
		String amount = "";
		String stopDeduction = "";
		String ppEmployeeMasterID = request.getParameter("ppEmployemasterID");
		String sectionname = request.getParameter("sectionname");
		String registerName = request.getParameter("register");
		String isnpsvalid = null;
		boolean iscomplete = false;

		try {
			for (int i = 0; i < dedDetailDTO.getAmount().length; i++) {
				if (i + 1 < dedDetailDTO.getAmount().length) {
					pp_DeductionMasterID += dedDetailDTO
							.getPpDeductionmasterid()[i] + "|";
					amount += dedDetailDTO.getAmount()[i] + "|";
				} else {
					pp_DeductionMasterID += dedDetailDTO
							.getPpDeductionmasterid()[i];
					amount += dedDetailDTO.getAmount()[i];
				}
			}

			if (dedDetailDTO.getStopDeduction() != null) {
				for (int i = 0; i < dedDetailDTO.getStopDeduction().length; i++) {
					if (i + 1 < dedDetailDTO.getStopDeduction().length) {
						stopDeduction += dedDetailDTO.getStopDeduction()[i]
								+ "|";
					} else {
						stopDeduction += dedDetailDTO.getStopDeduction()[i];
					}
				}
			}

			dedDetailDTO.setPp_DeductionMasterID(pp_DeductionMasterID);
			dedDetailDTO.setAmnnt(amount);
			dedDetailDTO.setStopDed(stopDeduction);

			iscomplete = updatePayDetailService.addEmpDedDetail(dedDetailDTO);
			if (iscomplete == true) {
				System.out.println(" Deduction Process Completed ");
				deddetailsModel.addObject("msg",
						"Process Completed Successfully");
			} else {
				deddetailsModel
						.addObject("error", "Error in Deduction Process");
				System.out.println(" Error in Deduction Process ");
			}

			/* Data Fields */

			List<ViewEmployeeSearch> empList = (List<ViewEmployeeSearch>) updatePayDetailService
					.getComboList(dedDetailDTO.getPpEmployeemasterid() + "",
							"ViewEmployeeSearch.findByPpEmployeemasterid");

			List<ViewPpEmppaydetail> empPayList = (List<ViewPpEmppaydetail>) updatePayDetailService
					.getComboList(dedDetailDTO.getPpEmployeemasterid() + "",
							"ViewPpEmppaydetail.findByPpEmployeemasterid");

			List<ViewPpNpsValid> npsvalidlist = (List<ViewPpNpsValid>) updatePayDetailService
					.getComboList(dedDetailDTO.getPpEmployeemasterid() + "",
							"ViewPpNpsValid.findByPpEmployeemasterid");
			for (ViewPpNpsValid viewPpNpsValid : npsvalidlist) {
				isnpsvalid = viewPpNpsValid.getIsnpsvalid() + "";
			}

			List<?> payalwname = updatePayDetailService
					.getPayAlwName1(dedDetailDTO.getPpEmployeemasterid() + "");
			java.math.BigDecimal basicpay = (java.math.BigDecimal) payalwname
					.get(0);

			List<?> dedList = updatePayDetailService
					.getEmployeeDedDetail(dedDetailDTO.getPpEmployeemasterid()
							+ "");

			deddetailsModel.addObject("ppEmployeeMasterID",dedDetailDTO.getPpEmployeemasterid() + "");
			deddetailsModel.addObject("sectionName", dedDetailDTO.getSectionName());
			deddetailsModel.addObject("registerName", dedDetailDTO.getRegisterName());
			deddetailsModel.addObject("empList", empList);
			deddetailsModel.addObject("basicpay", basicpay);
			deddetailsModel.addObject("dedList", dedList);
			deddetailsModel.addObject("empPayList", empPayList);
			deddetailsModel.addObject("isnpsvalid", isnpsvalid);
			deddetailsModel.addObject("isnps", dedDetailDTO.getIsnps());

		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		deddetailsModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		deddetailsModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		return deddetailsModel;
	}

	@RequestMapping(value = "/populateHRA", method = RequestMethod.POST)
	public void populateHRA(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HashMap<Integer, String> hraList = new HashMap<Integer, String>();
		HashMap<Integer, String> ccaList = new HashMap<Integer, String>();
		HashMap<Integer, String> sysPayScaleList = new HashMap<Integer, String>();
		List<PpPayscalemaster> empPayScaleList = null;

		List<HashMap<Integer, String>> dropdownList = new ArrayList<HashMap<Integer, String>>();

		try {

			String json1 = null;
			String syspayID = request.getParameter("syspayID");

			System.out.println(syspayID);

			List<PpTowncategorymaster> hraList1 = (List<PpTowncategorymaster>) updatePayDetailService
					.getTownCategoryList("HRA", Short.valueOf(syspayID));

			for (PpTowncategorymaster ppTowncategorymaster : hraList1) {
				hraList.put(ppTowncategorymaster.getPpTowncategorymasterid(),
						ppTowncategorymaster.getCategorytype());
			}

			List<PpTowncategorymaster> ccaList1 = (List<PpTowncategorymaster>) updatePayDetailService
					.getTownCategoryList("CCA", Short.valueOf(syspayID));
			System.out.println(ccaList1.size() + "--CCA list size");

			for (PpTowncategorymaster ppTowncategorymaster : ccaList1) {
				ccaList.put(ppTowncategorymaster.getPpTowncategorymasterid(),
						ppTowncategorymaster.getCategorytype());
			}

			empPayScaleList = (List<PpPayscalemaster>) updatePayDetailService
					.getComboList(syspayID,
							"PpPayscalemaster.findBySysPaycategoryid");
			System.out.println(empPayScaleList.size()
					+ "--empPayScaleList list size");

			for (PpPayscalemaster ppPayscalemaster : empPayScaleList) {
				sysPayScaleList.put(ppPayscalemaster.getPpPayscalemasterid(),
						ppPayscalemaster.getPayscale());
			}
			// dropdownList.add(hraList);
			// dropdownList.add(ccaList);
			// dropdownList.add(sysPayScaleList);
			String hralist = new Gson().toJson(hraList);
			String ccalist = new Gson().toJson(ccaList);
			String payscalelist = new Gson().toJson(sysPayScaleList);
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			String json = "[" + hralist + "," + ccalist + "," + payscalelist
					+ "]";
			response.getWriter().write(json);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @RequestMapping(value = "/populateCCA", method = RequestMethod.POST)
	 * public void populateCCA(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * HashMap<Integer, String> ccaList = new HashMap<Integer, String>();
	 * System.out.println("HELLOO");
	 * 
	 * try { String json2 = null; String syspayID =
	 * request.getParameter("syspayID");
	 * 
	 * System.out.println(syspayID);
	 * 
	 * List<PpTowncategorymaster> ccaList1 = (List<PpTowncategorymaster>)
	 * updatePayDetailService .getTownCategoryList("CCA",
	 * Short.valueOf(syspayID)); System.out.println(ccaList1.size() +
	 * "--CCA list size");
	 * 
	 * for (PpTowncategorymaster ppTowncategorymaster : ccaList1) {
	 * ccaList.put(ppTowncategorymaster.getPpTowncategorymasterid(),
	 * ppTowncategorymaster.getCategorytype()); }
	 * 
	 * json2 = new Gson().toJson(ccaList);
	 * response.setContentType("application/json");
	 * response.getWriter().write(json2); }
	 * 
	 * catch (Exception e) { e.printStackTrace(); } }*/
	 
	  @RequestMapping(value = "/populatePayScale", method = RequestMethod.POST)
	 public void populatePayScale(HttpServletRequest request,
	  HttpServletResponse response) throws ServletException, IOException {
	  
	  HashMap<Integer, String> sysPayScaleList = new HashMap<Integer,
	  String>(); List<PpPayscalemaster> empPayScaleList = null;
	  
	 try { String json2 = null; String syspayID =
	  request.getParameter("syspayID");
	  
	  System.out.println(syspayID);
	  
	 empPayScaleList = (List<PpPayscalemaster>) updatePayDetailService
	  .getComboList(syspayID, "PpPayscalemaster.findBySysPaycategoryid");
	  System.out.println(empPayScaleList.size() +
	  "--empPayScaleList list size");
	  
	  for (PpPayscalemaster ppPayscalemaster : empPayScaleList) {
	  sysPayScaleList.put(ppPayscalemaster.getPpPayscalemasterid(),
	  ppPayscalemaster.getPayscale());
	  
	  System.out.println(ppPayscalemaster.getPpPayscalemasterid() + "----" +
	  ppPayscalemaster.getPayscale()); }
	  
	  json2 = new Gson().toJson(sysPayScaleList);
	  response.setContentType("application/json");
	  response.getWriter().write(json2); }
	  
	  catch (Exception e) { e.printStackTrace(); } }
	 

	@RequestMapping("/ShowAlwforNewUser	")
	public ModelAndView ShowAlwforNewUser(
			@ModelAttribute("payAlwDTO") PayAlwDTO payAlwDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView payandalwdetailsModel = new ModelAndView(
				"EmployeeAlwDetail");
		List<ViewPpEmpalwlist> empAlwList = null;
		List<ViewEmployeeSearch> empList = null;
		List<ViewPpEmppaydetail> empPayList = null;
		ArrayList<String> months = null;

		try {

			empList = (List<ViewEmployeeSearch>) updatePayDetailService
					.getComboList(payAlwDTO.getPpEmployeemasterid() + "",
							"ViewEmployeeSearch.findByPpEmployeemasterid");
			empPayList = (List<ViewPpEmppaydetail>) updatePayDetailService
					.getComboList(payAlwDTO.getPpEmployeemasterid() + "",
							"ViewPpEmppaydetail.findByPpEmployeemasterid");

			months = CalenderUtils.populateMonth();

			payandalwdetailsModel.addObject("ppEmployeeMasterID",
					payAlwDTO.getPpEmployeemasterid() + "");
			payandalwdetailsModel.addObject("Data", months);
			payandalwdetailsModel.addObject("empList", empList);
			payandalwdetailsModel.addObject("empPayList", empPayList);
			payandalwdetailsModel.addObject("registerName",
					payAlwDTO.getRegisterName());
			payandalwdetailsModel.addObject("sectionName",
					payAlwDTO.getSectionName());
			payandalwdetailsModel.addObject("payCatList",
					updatePayDetailService.getList());

			if (payAlwDTO.getSys_PayCategoryID() == null) {
				System.out.println("Sys apy category is null");
				payandalwdetailsModel.addObject("error",
						"Please Select Pay Category");
			} else {
				empAlwList = (List<ViewPpEmpalwlist>) updatePayDetailService
						.getAlwList(payAlwDTO.getPpEmployeemasterid() + "",
								payAlwDTO.getSys_PayCategoryID() + "");

				payandalwdetailsModel.addObject("empAlwList", empAlwList);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		payandalwdetailsModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		payandalwdetailsModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		return payandalwdetailsModel;

	}

	/**************************
	 * VIKAS Code Ended
	 **********************************/

	/*****************************
	 * RAM Code Started
	 *************************************/

	@RequestMapping(value = "/PayBill", params = "monthlyPayBill", method = RequestMethod.POST)
	public ModelAndView monthlyPayBill(
			@ModelAttribute("payBillDTO") PayBillDTO payBillDTO, HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("monthlypaybill");

		ArrayList<String> monthList;
		ArrayList<String> yearList = null;
		List<PpRegistermaster> SelectedRegistor = (List<PpRegistermaster>) updatePayDetailService
				.getComboList(payBillDTO.getPpRegistermasterid() + "",
						"PpRegistermaster.findByPpRegistermasterid");
		for (PpRegistermaster ppRegistermaster : SelectedRegistor) {
			modelAndView.addObject("registername",
					ppRegistermaster.getRegistername());

		}
		monthList = CalenderUtils.populateMonth();
		yearList = CalenderUtils.populateYear();
		modelAndView.addObject("monthList", monthList);
		modelAndView.addObject("yearList", yearList);
		modelAndView
				.addObject("registerID", payBillDTO.getPpRegistermasterid());
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	@RequestMapping(value = "/payBillExection", params = "ProcessPayLogicExecuetion", method = RequestMethod.POST)
	public ModelAndView ProcessPayLogicExecuetion(
			@ModelAttribute("payBillDTO") PayBillDTO payBillDTO,
			HttpServletRequest request, HttpServletResponse response) {
		String registerID = request.getParameter("registerID");
		String dateOfEffect;
		ArrayList<String> monthList;
		ArrayList<String> yearList = null;
		List<ViewPpEmpprocesspaylist> employeeList = null;
		int payProcessFlag = 0;

		ModelAndView modelAndView = new ModelAndView("monthlypaybill");

		List<PpRegistermaster> SelectedRegistor1 = (List<PpRegistermaster>) updatePayDetailService
				.getComboList(registerID,
						"PpRegistermaster.findByPpRegistermasterid");
		for (PpRegistermaster ppRegistermaster : SelectedRegistor1) {
			modelAndView.addObject("registername",
					ppRegistermaster.getRegistername());

		}

		monthList = CalenderUtils.populateMonth();
		yearList = CalenderUtils.populateYear();
		modelAndView.addObject("monthList", monthList);
		modelAndView.addObject("yearList", yearList);

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		String ppEmployeemasterid = (String) session
				.getAttribute("ppEmployeemasterid");
		boolean isComplete = false;
		Date date = new Date();
		SimpleDateFormat sDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		payBillDTO.setRmOfficeid(rmOfficeid);
		payBillDTO.setIslocked('0');

		payBillDTO.setBillclerkid(Long.parseLong(ppEmployeemasterid));
		payBillDTO.setBilldate(sDateFormat.format(date));
		payBillDTO.setPpRegistermasterid(new Short(registerID));

		if (ppEmployeemasterid.equals("0")) {
			payBillDTO.setBillclerkname("ADMIN");

		} else if (ppEmployeemasterid.equals("1")) {
			payBillDTO.setBillclerkname("SBADM");
		} else {
			List<PpEmployeemaster> SelectedRegistor = (List<PpEmployeemaster>) updatePayDetailService
					.getList(Long.parseLong(ppEmployeemasterid),
							"PpEmployeemaster.findByPpEmployeemasterid");
			for (PpEmployeemaster ppEmployeemaster : SelectedRegistor) {
				payBillDTO.setBillclerkname(ppEmployeemaster.getFirstname()
						+ " " + ppEmployeemaster.getMiddlename() + " "
						+ ppEmployeemaster.getLastname());
			}

		}

		dateOfEffect = "01/"
				+ ((payBillDTO.getMonthName().trim().length() > 1) ? payBillDTO
						.getMonthName() : "0" + payBillDTO.getMonthName())
				+ "/" + payBillDTO.getYearName();

		try {

			if (CalenderUtils.isGreaterThanCurrentDate(dateOfEffect) == true) {
				throw new UtillException(
						"Salary for future month can not be proccessed!!");
			} else {
				payProcessFlag = updatePayDetailService
						.checkPreviousMonthProcess(registerID, dateOfEffect,
								rmOfficeid + "", "P", modelAndView);

				String values[] = new String[4];
				values[0] = registerID;
				values[1] = rmOfficeid + "";
				values[2] = payBillDTO.getMonthName();
				values[3] = payBillDTO.getYearName();
				employeeList = (List<ViewPpEmpprocesspaylist>) updatePayDetailService
						.getEmployeeList(registerID, rmOfficeid + "",
								payBillDTO.getMonthName(),
								payBillDTO.getYearName());

				for (ViewPpEmpprocesspaylist viewPpEmpprocesspaylist : employeeList) {

					if (viewPpEmpprocesspaylist.getSysPaycategoryid() == null
							|| viewPpEmpprocesspaylist.getSysPaycategoryid()
									+ "".trim().length() <= 0) {
						throw new UtillException((new StringBuilder())
								.append("Pay Category not found for ")
								.append(viewPpEmpprocesspaylist
										.getEmployeename())
								.append(" (")
								.append(viewPpEmpprocesspaylist
										.getEmployeecode()).append(")")
								.toString());
					}

				}

				if (employeeList != null && employeeList.size() > 0) {

					int partSalarylist = 0;
					partSalarylist = updatePayDetailService
							.insertEmployees(registerID, rmOfficeid + "",
									payBillDTO.getMonthName(),
									payBillDTO.getYearName());
					request.setAttribute("employeeList", employeeList);
					String total_employee = updatePayDetailService
							.getTotal_employee(rmOfficeid + "", registerID);
					payBillDTO.setBilldate(sDateFormat.format(date));
					payBillDTO.setBilltypeFlag('P');

					if (payProcessFlag == 1) {
						payBillDTO.setBilltypeFlag('P');
						isComplete = updatePayDetailService.calculatePayAlw(
								employeeList, dateOfEffect, payBillDTO,
								total_employee, "0");
					}
					if (isComplete == true && payProcessFlag == 1) {
						modelAndView.addObject("mes",
								"Process pay executed successfully");

					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		modelAndView.addObject("registerID", registerID);
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	/** Method used for Loan Detail **/
	@RequestMapping("/populateEmployeeLoanDetail")
	public ModelAndView populateEmployeeDeductionDetail(
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("called");
		String empMasterID = null;

		String pp_LoanDetailID = null;
		ArrayList<String> monthList;
		ArrayList<String> yearList = null;
		List<ViewEmployeename> employeeInfoList = null;
		List<PpLoandetail> ppLoandetailList = null;
		HashMap<Integer, String> loanMasterMap = new HashMap<Integer, String>();

		ModelAndView modelAndView = new ModelAndView("loanDetails");
		monthList = CalenderUtils.populateMonth();
		yearList = CalenderUtils.populateYear();
		modelAndView.addObject("monthList", monthList);
		modelAndView.addObject("yearList", yearList);

		if (request.getParameter("ppEmployemasterID") != null) {
			empMasterID = request.getParameter("ppEmployemasterID");

			employeeInfoList = (List<ViewEmployeename>) updatePayDetailService
					.getComboList(empMasterID,
							"ViewEmployeename.findByPpEmployeemasterid");

			for (ViewEmployeename viewEmployeename : employeeInfoList) {
				modelAndView.addObject("employeeName",
						viewEmployeename.getEmployeename());
				modelAndView.addObject("designation",
						viewEmployeename.getDesignation());
				modelAndView.addObject("ppEmployemasterID",
						viewEmployeename.getPpEmployeemasterid());
			}
			ppLoandetailList = (List<PpLoandetail>) updatePayDetailService
					.getComboList(empMasterID,
							"PpLoandetail.findByPpEmployeemasterid");
			for (PpLoandetail ppLoandetail : ppLoandetailList) {
				pp_LoanDetailID = ppLoandetail.getPpLoandetailid() + "";
			}

			List<PpLoanEntity> lst = updatePayDetailService
					.populateLoanMasterCombo(empMasterID, pp_LoanDetailID);
			for (PpLoanEntity ppLoanEntity : lst) {
				loanMasterMap.put(ppLoanEntity.getPp_LoanMasterID(),
						ppLoanEntity.getLoanName());
			}

			List<ViewLoandetail> loanSanctionList = (List<ViewLoandetail>) updatePayDetailService
					.getComboList(empMasterID,
							"ViewLoandetail.findByPpEmployeemasterid");

			modelAndView.addObject("loanSanctionList", loanSanctionList);

			modelAndView.addObject("loanMasterList", loanMasterMap);
			modelAndView.addObject("paNextinstallmentno", new Integer(1));
			modelAndView.addObject("pa_Recovered", new Integer(0));
			modelAndView.addObject("paInstallmentamount", new Integer(0));
			modelAndView.addObject("pp_EmployeeMasterID", empMasterID);

		}
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	/**
	 * Method used for Loan Detail
	 * 
	 * @throws IOException
	 **/
	@RequestMapping(value = "/getLoanShortName", method = RequestMethod.POST)
	public void getLoanShortName(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String LoanShortName = null;

		String pp_LoanMasterID = request.getParameter("pp_LoanMasterID");
		System.out.println(pp_LoanMasterID);
		List<PpLoanmaster> loanMasterList = (List<PpLoanmaster>) updatePayDetailService
				.getComboList(pp_LoanMasterID,
						"PpLoanmaster.findByPpLoanmasterid");

		for (PpLoanmaster ppLoanmaster : loanMasterList) {
			LoanShortName = ppLoanmaster.getLoanshortname();
		}
		System.out.println(LoanShortName);
		String json = null;
		json = new Gson().toJson(LoanShortName);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	@RequestMapping("/insertLoanSanctionDetails")
	public ModelAndView insertLoanSanction(
			@ModelAttribute("loanSanctionDTO") LoanSanctionDTO loanSanctionDTO,
			HttpServletRequest request, HttpServletResponse response) {

		String[] out = new String[2];
		String pp_LoanMasterID = null;
		String pp_LoanDetailID = null;
		String isBearing = null;
		pp_LoanMasterID = loanSanctionDTO.getPpLoanmasterid();

		ArrayList<String> monthList;
		ArrayList<String> yearList = null;
		List<ViewEmployeename> employeeInfoList = null;
		List<PpLoandetail> ppLoandetailList = null;
		HashMap<Integer, String> loanMasterMap = new HashMap<Integer, String>();
		if (loanSanctionDTO.getPpLoandetailid().equals("")) {
			loanSanctionDTO.setPpLoandetailid(null);
		}

		ModelAndView modelAndView = new ModelAndView("loanDetails");

		if (loanSanctionDTO.getPpLoandetailid() == null) {
			String event = loanSanctionDTO.getPa_IsFullyRecovered();
			if (event == null) {
				loanSanctionDTO.setPa_IsFullyRecovered("0");
			} else {
				loanSanctionDTO.setPa_IsFullyRecovered("1");
			}

			if (loanSanctionDTO.getStopInstallment() == null) {
				loanSanctionDTO.setStopInstallment("0");
			} else {
				loanSanctionDTO.setStopInstallment("1");
			}

			if (loanSanctionDTO.getSanctionDate() == null
					|| loanSanctionDTO.getSanctionDate().trim().length() <= 0)
				loanSanctionDTO.setSanctionDate("01/01/2000");
			if (loanSanctionDTO.getLoanSanctionOrdNo() == null
					&& loanSanctionDTO.getLoanSanctionOrdNo().trim().length() <= 0)
				loanSanctionDTO.setLoanSanctionOrdNo("Not Available");

			out = updatePayDetailService.isBearingLoan(
					loanSanctionDTO.getPp_EmployeeMasterID(), pp_LoanMasterID);

			isBearing = out[0];
			pp_LoanDetailID = out[1];

			if (isBearing.equals("1")) {

				List<ViewLoandetail> loanMasterList = (List<ViewLoandetail>) updatePayDetailService
						.getComboList(pp_LoanDetailID,
								"ViewLoandetail.findByPpLoandetailid");
				for (ViewLoandetail viewLoandetail : loanMasterList)
					BeanUtils.copyProperties(viewLoandetail, loanSanctionDTO);

			} else if (isBearing.equals("3")) {
				boolean isComplete = updatePayDetailService
						.insertLoanSanction(loanSanctionDTO);

				modelAndView.addObject("mes", "Process Completed successfully");
			} else {
				modelAndView.addObject("error",
						"Process does not Completed successfully");
			}
		}

		else {
			boolean isComplete = false;
			try {

				String event = loanSanctionDTO.getPa_IsFullyRecovered();
				if (event == null) {
					loanSanctionDTO.setPa_IsFullyRecovered("0");
				} else {
					loanSanctionDTO.setPa_IsFullyRecovered("1");
				}

				if (loanSanctionDTO.getSanctionDate() == null
						&& loanSanctionDTO.getSanctionDate().trim().length() <= 0)
					loanSanctionDTO.setSanctionDate("01/01/2000");
				if (loanSanctionDTO.getLoanSanctionOrdNo() == null
						&& loanSanctionDTO.getLoanSanctionOrdNo().trim()
								.length() <= 0)
					loanSanctionDTO.setLoanSanctionOrdNo("Not Available");
				//
				String stopInstallment = loanSanctionDTO.getStopInstallment();
				System.out.println("stopInstallment++++++++" + stopInstallment
						+ "stopInstallment");
				if (null == stopInstallment || stopInstallment == ""
						|| stopInstallment.equals(null)) {
					loanSanctionDTO.setStopInstallment("0");
					System.out.println("i m else condition");
				} else {
					if (stopInstallment.equals("1")) {
						loanSanctionDTO.setStopInstallment("1");
						System.out.println("hey  i m in if condition");
					}
				}

				isComplete = updatePayDetailService
						.updateLoanSanction(loanSanctionDTO);

				if (isComplete) {
					modelAndView.addObject("mes",
							"LoanSanction updated successfully");
				} else {
					modelAndView
							.addObject("mes", "something wrong in updation");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		List<PpLoanEntity> lst = updatePayDetailService
				.populateLoanMasterCombo(
						loanSanctionDTO.getPp_EmployeeMasterID(),
						pp_LoanDetailID);
		for (PpLoanEntity ppLoanEntity : lst) {
			loanMasterMap.put(ppLoanEntity.getPp_LoanMasterID(),
					ppLoanEntity.getLoanName());
		}

		monthList = CalenderUtils.populateMonth();
		yearList = CalenderUtils.populateYear();
		modelAndView.addObject("monthList", monthList);
		modelAndView.addObject("yearList", yearList);

		employeeInfoList = (List<ViewEmployeename>) updatePayDetailService
				.getComboList(loanSanctionDTO.getPp_EmployeeMasterID(),
						"ViewEmployeename.findByPpEmployeemasterid");

		for (ViewEmployeename viewEmployeename : employeeInfoList) {
			modelAndView.addObject("employeeName",
					viewEmployeename.getEmployeename());
			modelAndView.addObject("designation",
					viewEmployeename.getDesignation());
			modelAndView.addObject("pp_EmployeeMasterID",
					viewEmployeename.getPpEmployeemasterid());
		}

		List<ViewLoandetail> loanSanctionList = (List<ViewLoandetail>) updatePayDetailService
				.getComboList(loanSanctionDTO.getPp_EmployeeMasterID(),
						"ViewLoandetail.findByPpEmployeemasterid");

		modelAndView.addObject("loanSanctionList", loanSanctionList);
		modelAndView.addObject("ppEmployeemasterid",
				loanSanctionDTO.getPp_EmployeeMasterID());

		modelAndView.addObject("loanMasterList", loanMasterMap);

		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/* deleteLoanSanction */

	@RequestMapping("/deleteLoanSanction")
	public ModelAndView deleteLoanSanction(HttpServletRequest request,
			HttpServletResponse response) {

		String pp_LoanDetailID = request.getParameter("pp_LoanDetailID");
		String Pp_EmployeeMasterID = null;

		ModelAndView modelAndView = new ModelAndView("loanDetails");

		List<PpLoandetail> ppLoandetailList = (List<PpLoandetail>) updatePayDetailService
				.getComboList(pp_LoanDetailID,
						"PpLoandetail.findByPpLoandetailid");
		for (PpLoandetail ppLoandetail : ppLoandetailList) {
			Pp_EmployeeMasterID = ppLoandetail.getPpEmployeemasterid() + "";
		}
		HashMap<Integer, String> loanMasterMap = new HashMap<Integer, String>();

		List<ViewEmployeename> employeeInfoList = (List<ViewEmployeename>) updatePayDetailService
				.getComboList(Pp_EmployeeMasterID,
						"ViewEmployeename.findByPpEmployeemasterid");

		for (ViewEmployeename viewEmployeename : employeeInfoList) {
			modelAndView.addObject("employeeName",
					viewEmployeename.getEmployeename());
			modelAndView.addObject("designation",
					viewEmployeename.getDesignation());
			modelAndView.addObject("ppEmployemasterID",
					viewEmployeename.getPpEmployeemasterid());
		}

		modelAndView.addObject("pp_EmployeeMasterID", Pp_EmployeeMasterID);

		List<PpLoanEntity> lst = updatePayDetailService
				.populateLoanMasterCombo(Pp_EmployeeMasterID, pp_LoanDetailID);
		for (PpLoanEntity ppLoanEntity : lst) {
			loanMasterMap.put(ppLoanEntity.getPp_LoanMasterID(),
					ppLoanEntity.getLoanName());
		}

		modelAndView.addObject("loanMasterList", loanMasterMap);

		boolean isComplete = updatePayDetailService
				.deleteLoanSanction(pp_LoanDetailID);

		List<ViewLoandetail> loanSanctionList = (List<ViewLoandetail>) updatePayDetailService
				.getComboList(Pp_EmployeeMasterID,
						"ViewLoandetail.findByPpEmployeemasterid");

		modelAndView.addObject("loanSanctionList", loanSanctionList);

		if (isComplete) {
			modelAndView.addObject("mes", "Record deleted successfully");
		}
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping("/retrieveLoanSanction")
	public ModelAndView retrieveLoanSanction(HttpServletRequest request,
			HttpServletResponse response) {

		String pp_LoanDetailID = request.getParameter("pp_LoanDetailID");
		String Pp_EmployeeMasterID = null;

		ArrayList<String> monthList;
		ArrayList<String> yearList = null;

		ModelAndView modelAndView = new ModelAndView("loanDetails");

		List<PpLoandetail> ppLoandetailList = (List<PpLoandetail>) updatePayDetailService
				.getComboList(pp_LoanDetailID,
						"PpLoandetail.findByPpLoandetailid");
		for (PpLoandetail ppLoandetail : ppLoandetailList) {
			Pp_EmployeeMasterID = ppLoandetail.getPpEmployeemasterid() + "";
		}
		HashMap<Integer, String> loanMasterMap = new HashMap<Integer, String>();

		List<PpLoanEntity> lst = updatePayDetailService
				.populateLoanMasterCombo(Pp_EmployeeMasterID, pp_LoanDetailID);
		for (PpLoanEntity ppLoanEntity : lst) {
			loanMasterMap.put(ppLoanEntity.getPp_LoanMasterID(),
					ppLoanEntity.getLoanName());
		}

		String shortName = null;
		String loanMasterId = null;
		monthList = CalenderUtils.populateMonth();
		yearList = CalenderUtils.populateYear();
		modelAndView.addObject("monthList", monthList);
		modelAndView.addObject("yearList", yearList);
		List<ViewEmployeename> employeeInfoList = (List<ViewEmployeename>) updatePayDetailService
				.getComboList(Pp_EmployeeMasterID,
						"ViewEmployeename.findByPpEmployeemasterid");

		for (ViewEmployeename viewEmployeename : employeeInfoList) {
			modelAndView.addObject("employeeName",
					viewEmployeename.getEmployeename());
			modelAndView.addObject("designation",
					viewEmployeename.getDesignation());
			modelAndView.addObject("pp_EmployeeMasterID",
					viewEmployeename.getPpEmployeemasterid());
		}

		List<LoanSanctionEntity> ppLoanEntities = updatePayDetailService
				.retrieveLoanSanction(pp_LoanDetailID);
		for (LoanSanctionEntity loanSanctionEntity : ppLoanEntities) {
			modelAndView.addObject("loanShortName",
					loanSanctionEntity.getLoanShortName());
			modelAndView.addObject("loanAmount",
					loanSanctionEntity.getLoanAmount());
			modelAndView.addObject("loanSanctionOrdNo",
					loanSanctionEntity.getLoanSanctionOrdNo());
			modelAndView.addObject("sanctionDate",
					loanSanctionEntity.getSanctionDate());
			modelAndView.addObject("pa_NoOfInstallments",
					loanSanctionEntity.getPa_NoOfInstallments());
			modelAndView.addObject("firstinstallmentamount",
					loanSanctionEntity.getFirstinstallmentAmount());
			modelAndView.addObject("paInstallmentamount",
					loanSanctionEntity.getPa_InstallmentAmount());
			modelAndView.addObject("monthName",
					loanSanctionEntity.getPa_RecovCommenceMonth());
			modelAndView.addObject("yearName",
					loanSanctionEntity.getPa_RecovCommenceYear());
			modelAndView.addObject("paNextinstallmentno",
					loanSanctionEntity.getPa_NextInstallmentNo());
			modelAndView.addObject("stopInstallment",
					loanSanctionEntity.getStop_Loan());
			modelAndView.addObject("pa_Recovered",
					loanSanctionEntity.getPa_Recovered());
			modelAndView.addObject("pa_IsFullyRecovered",
					loanSanctionEntity.getPa_IsFullyRecovered());
			shortName = loanSanctionEntity.getLoanShortName();
			loanMasterId = loanSanctionEntity.getPpLoanmasterid();

		}

		List<PpLoanmaster> ppLoanMasterList = (List<PpLoanmaster>) updatePayDetailService
				.getComboList(loanMasterId, "PpLoanmaster.findByPpLoanmasterid");

		modelAndView.addObject("ppLoanMasterList1", ppLoanMasterList);
		modelAndView.addObject("ppLoanEntities", ppLoanEntities);
		List<ViewLoandetail> loanSanctionList = (List<ViewLoandetail>) updatePayDetailService
				.getComboList(Pp_EmployeeMasterID,
						"ViewLoandetail.findByPpEmployeemasterid");
		modelAndView.addObject("loanMasterList", loanMasterMap);
		modelAndView.addObject("loanSanctionList", loanSanctionList);
		modelAndView.addObject("ppLoandetailid", pp_LoanDetailID);

		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	@RequestMapping("/lockPayBill")
	public ModelAndView populateLockPayBill(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("lockPayBillSelect");
		HashMap<Integer, String> registerMap = new HashMap<Integer, String>();
		ArrayList<String> monthList;
		ArrayList<String> yearList = null;
		monthList = CalenderUtils.populateMonth();
		yearList = CalenderUtils.populateYear();
		modelAndView.addObject("monthList", monthList);
		modelAndView.addObject("yearList", yearList);
		List<PpRegistermaster> registerList = (List<PpRegistermaster>) updatePayDetailService
				.getComboList(null, "PpRegistermaster.findAll");
		for (PpRegistermaster ppRegistermaster : registerList) {
			registerMap.put(
					Integer.parseInt(ppRegistermaster.getPpRegistermasterid()
							+ ""), ppRegistermaster.getRegistername());
		}

		modelAndView.addObject("registerList", registerMap);
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	@RequestMapping("/getPayBillList")
	public ModelAndView getPayBillList(

	@ModelAttribute("LockPayBillDTO") LockPayBillDTO lockPayBillDTO,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("lockpaybillList");
		HashMap<Integer, String> registerMap = new HashMap<Integer, String>();

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		List<BillMasterEntryEntity> billList = null;
		billList = updatePayDetailService.getPayBillListForLock(rmOfficeid,
				lockPayBillDTO.getPpRegistermasterid(),
				lockPayBillDTO.getMonthName(), lockPayBillDTO.getYearName());
		if (billList != null && billList.size() > 0)
			modelAndView.addObject("billList", billList);
		ArrayList<String> monthList;
		ArrayList<String> yearList = null;
		monthList = CalenderUtils.populateMonth();
		yearList = CalenderUtils.populateYear();
		modelAndView.addObject("monthList", monthList);
		modelAndView.addObject("yearList", yearList);
		List<PpRegistermaster> registerList = (List<PpRegistermaster>) updatePayDetailService
				.getComboList(null, "PpRegistermaster.findAll");
		for (PpRegistermaster ppRegistermaster : registerList) {
			registerMap.put(
					Integer.parseInt(ppRegistermaster.getPpRegistermasterid()
							+ ""), ppRegistermaster.getRegistername());
		}

		modelAndView.addObject("registerList", registerMap);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	@RequestMapping("/populateEmployeePayBillInfo")
	public ModelAndView getPayBillInfo(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("hello");
		String ppPaybilldetailid = request.getParameter("ppPaybilldetailid");
		ModelAndView modelAndView = new ModelAndView("payBillInfo");

		List<PayBillInfoEntity> list = updatePayDetailService
				.getPayBillInfo(ppPaybilldetailid);
		for (PayBillInfoEntity billInfoEntity : list) {
			modelAndView.addObject("year", billInfoEntity.getYear());
						
			/*String monthname = CalenderUtils.getMonth(billInfoEntity.getMonth());
			modelAndView.addObject("month", monthname);*/
			
			modelAndView.addObject("month",
					billInfoEntity.getMonth());
			modelAndView.addObject("registername",
					billInfoEntity.getRegistername());
			modelAndView.addObject("description",
					billInfoEntity.getDescription());
			modelAndView.addObject("netpay", billInfoEntity.getNetpay());
			modelAndView
					.addObject("billamount", billInfoEntity.getBillamount());

		}
		modelAndView.addObject("ppPaybilldetailid", ppPaybilldetailid);
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	@RequestMapping("/InsertLockPayBillDetailForLock")
	public ModelAndView InsertLockPayBillDetailForLock(
			@ModelAttribute("lockPayBillDTO") LockPayBillDTO lockPayBillDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("payBillInfo");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		lockPayBillDTO.setRmOfficeid(rmOfficeid);

		String ppPaybilldetailid = request.getParameter("ppPaybilldetailid");

		List<PayBillInfoEntity> list = updatePayDetailService
				.getPayBillInfo(ppPaybilldetailid);
		for (PayBillInfoEntity billInfoEntity : list) {
			modelAndView.addObject("year", billInfoEntity.getYear());
			modelAndView.addObject("month", billInfoEntity.getMonth());
			modelAndView.addObject("registername",
					billInfoEntity.getRegistername());
			modelAndView.addObject("description",
					billInfoEntity.getDescription());
			modelAndView.addObject("netpay", billInfoEntity.getNetpay());
			modelAndView
					.addObject("billamount", billInfoEntity.getBillamount());
			lockPayBillDTO.setPp_PayBillDetailID(ppPaybilldetailid);
			lockPayBillDTO.setTransactiontype('O');
		}
		boolean isLocked = updatePayDetailService
				.passSalaryBill(lockPayBillDTO);
		if (isLocked) {
			modelAndView.addObject("mes", "Process Completed successfully");
		} else {
			modelAndView.addObject("error",
					"Process not  Completed successfully");
		}

		modelAndView.addObject("ppPaybilldetailid", ppPaybilldetailid);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	@RequestMapping(value = "/payBillExection", params = "partlyProcessPayLogicExecuetion", method = RequestMethod.POST)
	public ModelAndView partlyProcessPayLogicExecuetion(
			@ModelAttribute("payBillDTO") PayBillDTO payBillDTO,
			HttpServletRequest request, HttpServletResponse response) {

		System.out.println("invoked");
		List<PartlyEmpListEntity> employeeList = null;
		ModelAndView modelAndView = new ModelAndView("partlyPay");
		String registerID = request.getParameter("registerID");
		payBillDTO.setPpRegistermasterid(new Short(registerID));

		try {

			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			int month1 = Integer.parseInt(payBillDTO.getMonthName());
			int year1 = Integer.parseInt(payBillDTO.getYearName());
			System.out.println("whichhhhmonthhhhhhhhh" + month1);
			System.out.println("whichhhhhhhhhhhhyearrrrrrrrrrrrr" + year1);

			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, year1);
			calendar.set(Calendar.MONTH, month1 - 1);
			int numDays = calendar.getActualMaximum(Calendar.DATE);

			employeeList = updatePayDetailService.getAddPayEmployeeList(
					payBillDTO.getPpRegistermasterid() + "", month1, year1,
					rmOfficeid, numDays);
			this.employeeList = employeeList;
			modelAndView.addObject("employeeList", employeeList);
			modelAndView.addObject("monthName", payBillDTO.getMonthName());
			modelAndView.addObject("yearName", payBillDTO.getYearName());
			modelAndView.addObject("registerID", registerID);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	@RequestMapping(value = "/parltlyPayprocess", method = RequestMethod.POST)
	public ModelAndView parltlyPayprocess(
			@ModelAttribute("partlyEmpListEntity") PartlyEmpListEntity partlyEmpListEntity,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("monthlypaybill");
		ArrayList<String> monthList;
		ArrayList<String> yearList = null;
		String registerID = request.getParameter("registerID");

		String employeecode = request.getParameter("employeecode");
		String str = request.getParameter("str");
		System.out.println("gdsjhgdsh @@@@@@@@@@@@@@@@@@@@@@@@@" + str);
		String numberrr = str.substring(1, str.length() - 2);
		String monthName = request.getParameter("monthName");
		String yearName = request.getParameter("yearName");
		System.out.println("invoked" + employeecode);

		List<ViewPpEmpprocesspaylist> employeeList = null;
		List placeList = null;
		boolean isComplete = false;
		String dateOfEffect = "";
		Date date = new Date();
		SimpleDateFormat sDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		PayBillDTO pbddto = new PayBillDTO();

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		String ppEmployeemasterid = (String) session
				.getAttribute("ppEmployeemasterid");

		pbddto.setRmOfficeid(rmOfficeid);
		pbddto.setIslocked('0');

		pbddto.setBillclerkid(Long.parseLong(ppEmployeemasterid));
		pbddto.setBilldate(sDateFormat.format(date));
		pbddto.setPpRegistermasterid(new Short(partlyEmpListEntity
				.getPpRegistermasterid()));
		pbddto.setMonthName(monthName);
		pbddto.setYearName(yearName);
		partlyEmpListEntity.setEmployeecode(numberrr);

		if (ppEmployeemasterid.equals("0")) {
			pbddto.setBillclerkname("ADMIN");

		} else if (ppEmployeemasterid.equals("1")) {
			pbddto.setBillclerkname("SBADM");
		} else {
			List<PpEmployeemaster> SelectedRegistor = (List<PpEmployeemaster>) updatePayDetailService
					.getList(Long.parseLong(ppEmployeemasterid),
							"PpEmployeemaster.findByPpEmployeemasterid");
			for (PpEmployeemaster ppEmployeemaster : SelectedRegistor) {
				pbddto.setBillclerkname(ppEmployeemaster.getFirstname() + " "
						+ ppEmployeemaster.getMiddlename() + " "
						+ ppEmployeemaster.getLastname());
			}

		}
		String empcode1 = null;
		dateOfEffect = "01/" + pbddto.getMonthName() + "/"
				+ pbddto.getYearName();
		int count = 0;

		try {
			boolean isValidBillDate = true;
			if (CalenderUtils.isGreaterThanCurrentDate(dateOfEffect) == true) {
				modelAndView.addObject("error",
						"Salary for future month can not be proccessed !!");
				throw new UtillException(
						"Salary for future month can not be proccessed !!");

			} else {
				boolean payProcessFlag = updatePayDetailService
						.checkPreviousMonthProcess(numberrr,
								partlyEmpListEntity.getPpRegistermasterid()
										+ "", dateOfEffect, rmOfficeid + "",
								"N", modelAndView);

				employeeList = updatePayDetailService.getEmployeeList(numberrr,
						pbddto.getPpRegistermasterid() + "", rmOfficeid + "",
						monthName, yearName);

				for (ViewPpEmpprocesspaylist viewPpEmpprocesspaylist : employeeList) {

					if (viewPpEmpprocesspaylist.getSysPaycategoryid() == null
							|| viewPpEmpprocesspaylist.getSysPaycategoryid()
									+ "".trim().length() <= 0) {
						modelAndView.addObject("error",
								"Pay Category not found for ");
						throw new UtillException((new StringBuilder())
								.append("Pay Category not found for ")
								.append(viewPpEmpprocesspaylist
										.getEmployeename())
								.append(" (")
								.append(viewPpEmpprocesspaylist
										.getEmployeecode()).append(")")
								.toString());
					}

					else {

						boolean isCompleted = updatePayDetailService
								.checkNoOfDays(
										viewPpEmpprocesspaylist
												.getPpEmployeemasterid() + "",
										viewPpEmpprocesspaylist
												.getPpRegistermasterid() + "",
										rmOfficeid + "", monthName, yearName,
										viewPpEmpprocesspaylist.getNoofdays()
												+ "");
						if (isCompleted == false) {
							modelAndView.addObject(
									"error",
									"Total No. of Days Exceed Days in Month. "
											+ viewPpEmpprocesspaylist
													.getEmployeename()
											+ " ("
											+ viewPpEmpprocesspaylist
													.getEmployeecode());
							throw new UtillException(
									"Total No. of Days Exceed Days in Month. "
											+ viewPpEmpprocesspaylist
													.getEmployeename()
											+ " ("
											+ viewPpEmpprocesspaylist
													.getEmployeecode() + ")");
						}
					}

				}

				if (employeeList != null) {
					request.setAttribute("employeeList", employeeList);
					String total_employee = updatePayDetailService
							.getTotal_employee(rmOfficeid + "",
									pbddto.getPpRegistermasterid() + "");
					pbddto.setBilltypeFlag('A');
					isComplete = updatePayDetailService.calculatePayAlw(
							employeeList, dateOfEffect, pbddto, total_employee,
							"0");

					if (isComplete) {
						modelAndView.addObject("mes",
								"Process pay executed successfully");

						isComplete = updatePayDetailService
								.updateBillDateAndBillNo(pbddto.getBilldate(),
										pbddto.getBillno(),
										partlyEmpListEntity.getEmployeecode(),
										monthName, yearName);

					}

				} else {
					modelAndView.addObject("error",
							"in this office & register there is no employee exists of this employeeCode "
									+ " (" + numberrr);
					throw new UtillException(
							"in this office & register there is no employee exists of this employeeCode "
									+ " (" + numberrr + ")");
				}

			}

		} catch (Exception e) {

		}

		List<PpRegistermaster> SelectedRegistor = (List<PpRegistermaster>) updatePayDetailService
				.getComboList(partlyEmpListEntity.getPpRegistermasterid() + "",
						"PpRegistermaster.findByPpRegistermasterid");
		for (PpRegistermaster ppRegistermaster : SelectedRegistor) {
			modelAndView.addObject("registername",
					ppRegistermaster.getRegistername());

		}
		monthList = CalenderUtils.populateMonth();
		yearList = CalenderUtils.populateYear();
		modelAndView.addObject("monthList", monthList);
		modelAndView.addObject("yearList", yearList);
		modelAndView.addObject("registerID",
				partlyEmpListEntity.getPpRegistermasterid());
		
		
		modelAndView.addObject("registerID", registerID);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	@RequestMapping(value = "/EmployeeDeductions", params = "NpsArrearDetails", method = RequestMethod.POST)
	public ModelAndView AddEmployeeDeductionDetails(HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("invoked");
		String ppEmployeeMasterID = request.getParameter("ppEmployeeMasterID");

		ModelAndView modelAndView = new ModelAndView("npsArrearDetails");

		ArrayList<String> monthList = null;
		ArrayList<String> yearList = null;

		monthList = CalenderUtils.populateMonth();
		yearList = CalenderUtils.populateYear();
		modelAndView.addObject("monthList", monthList);
		modelAndView.addObject("yearList", yearList);
		modelAndView.addObject("monthListCON", monthList);
		modelAndView.addObject("yearListCON", yearList);

		List<ViewEmployeeSearch> infoList = (List<ViewEmployeeSearch>) updatePayDetailService
				.getComboList(ppEmployeeMasterID + "",
						"ViewEmployeeSearch.findByPpEmployeemasterid");

		for (ViewEmployeeSearch viewEmployeeSearch : infoList) {
			modelAndView.addObject("employeename",
					viewEmployeeSearch.getEmployeename());
			modelAndView.addObject("employeecode",
					viewEmployeeSearch.getEmployeecode());
			modelAndView.addObject("designation",
					viewEmployeeSearch.getDesignation());

			modelAndView.addObject("employmenttype",
					viewEmployeeSearch.getEmploymenttype());
			modelAndView.addObject("designation",
					viewEmployeeSearch.getDesignation());

		}

		List<ViewPpNpsdetail> npsarrearList = updatePayDetailService
				.getNPSArrearList(ppEmployeeMasterID);
		List<ViewPpEmppaydetail> empPayDetailList = (List<ViewPpEmppaydetail>) updatePayDetailService
				.getComboList(ppEmployeeMasterID + "",
						"ViewPpEmppaydetail.findByPpEmployeemasterid");
		for (ViewPpEmppaydetail viewPpEmppaydetail : empPayDetailList) {
			modelAndView.addObject("registerName",
					viewPpEmppaydetail.getRegistername());
			modelAndView.addObject("sectionname",
					viewPpEmppaydetail.getSectionname());
		}

		List<PpNpsdetailEntity> npsdetailsList = updatePayDetailService
				.getnpsDetail(ppEmployeeMasterID);
		for (PpNpsdetailEntity npsdetail : npsdetailsList) {
			modelAndView.addObject("joining_mnth", npsdetail.getJoining_mnth());
			modelAndView.addObject("startmon_forregular_cont",
					npsdetail.getStartmon_forregular_cont());
			modelAndView.addObject("mon_contr", npsdetail.getMon_contr());
			modelAndView.addObject("year_contr", npsdetail.getYear_contr());
			System.out.println(npsdetail.getYear_contr());
			modelAndView.addObject("actual_ded_mon",
					npsdetail.getActual_ded_mon());
			modelAndView.addObject("actual_ded_year",
					npsdetail.getActual_ded_year());
			modelAndView.addObject("emp_cont_amt", npsdetail.getEmp_cont_amt());
		}

		modelAndView.addObject("npsarrearList", npsarrearList);
		modelAndView.addObject("npsdetailsList", npsdetailsList);
		modelAndView.addObject("ppEmployeeMasterID", ppEmployeeMasterID);
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	@RequestMapping(value = "/addNPSErrearDetails", method = RequestMethod.POST)
	public ModelAndView addNPSErrearDetails(
			@ModelAttribute("npsDetailDTO") NPSDetailDTO npsDetailDTO,
			HttpServletRequest request, HttpServletResponse response) {

		String ppEmployeeMasterID = request.getParameter("ppEmployeeMasterID");
		npsDetailDTO.setPpEmployeemasterid(Long.parseLong(ppEmployeeMasterID
				+ ""));

		ModelAndView modelAndView = new ModelAndView("npsArrearDetails");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		ArrayList<String> monthList = null;
		ArrayList<String> yearList = null;

		monthList = CalenderUtils.populateMonth();
		yearList = CalenderUtils.populateYear();
		modelAndView.addObject("monthList", monthList);
		modelAndView.addObject("yearList", yearList);
		modelAndView.addObject("monthListCON", monthList);
		modelAndView.addObject("yearListCON", yearList);

		boolean isComplete = false;
		try {
			if (npsDetailDTO.getStopcontr() == null
					|| npsDetailDTO.getStopcontr().equals("")) {
				npsDetailDTO.setStopcontr("0");
			} else {
				npsDetailDTO.setStopcontr("1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String pp_paybilldetailid = updatePayDetailService
				.getPP_Paybilldetailid(npsDetailDTO.getActual_ded_mon(),
						npsDetailDTO.getActual_ded_year(), ppEmployeeMasterID);

		String billid = updatePayDetailService
				.getPP_PaybilldetailidformonthCont(npsDetailDTO.getMon_contr(),
						npsDetailDTO.getYear_contr(), ppEmployeeMasterID);

		String isNpsContrCheck = updatePayDetailService.addNPSContrCheck(
				npsDetailDTO.getMon_contr(), npsDetailDTO.getYear_contr(),
				ppEmployeeMasterID, billid);

		String isNpsActualDedCheck = updatePayDetailService
				.addNPSActualDedCheck(npsDetailDTO.getActual_ded_mon(),
						npsDetailDTO.getActual_ded_year(), ppEmployeeMasterID,
						pp_paybilldetailid);

		int isNpsActDed = Integer.parseInt(isNpsActualDedCheck);
		int isNpsContDed = Integer.parseInt(isNpsContrCheck);
		if (isNpsActDed >= 1 || isNpsContDed >= 1) {
			int updateisnpsstop = 0;
			String changeisstopnps = null;
			String Is_stopNps = updatePayDetailService.getIsStop(
					ppEmployeeMasterID, npsDetailDTO.getMon_contr(),
					npsDetailDTO.getYear_contr(),
					npsDetailDTO.getActual_ded_mon(),
					npsDetailDTO.getActual_ded_year());
			if (Is_stopNps != null) {
				changeisstopnps = npsDetailDTO.getStopcontr();
				updateisnpsstop = updatePayDetailService.updatenpsstopvalue(
						ppEmployeeMasterID, npsDetailDTO.getMon_contr(),
						npsDetailDTO.getYear_contr(),
						npsDetailDTO.getActual_ded_mon(),
						npsDetailDTO.getActual_ded_year(), changeisstopnps);
				if (updateisnpsstop == 1) {
					modelAndView.addObject("mes",
							"Process completed successfully");
				}
			}
		} else {
			isComplete = updatePayDetailService.addNPSDetail(npsDetailDTO,
					rmOfficeid, npsDetailDTO.getStopcontr());
			if (isComplete) {
				modelAndView.addObject("mes", "Process completed successfully");

			} else {
				modelAndView.addObject("error",
						"Process not completed successfully");
			}
		}

		List<ViewEmployeeSearch> infoList = (List<ViewEmployeeSearch>) updatePayDetailService
				.getComboList(ppEmployeeMasterID + "",
						"ViewEmployeeSearch.findByPpEmployeemasterid");

		for (ViewEmployeeSearch viewEmployeeSearch : infoList) {
			modelAndView.addObject("employeename",
					viewEmployeeSearch.getEmployeename());
			modelAndView.addObject("employeecode",
					viewEmployeeSearch.getEmployeecode());
			modelAndView.addObject("designation",
					viewEmployeeSearch.getDesignation());

			modelAndView.addObject("employmenttype",
					viewEmployeeSearch.getEmploymenttype());
			modelAndView.addObject("designation",
					viewEmployeeSearch.getDesignation());

		}

		List<ViewPpNpsdetail> npsarrearList = updatePayDetailService
				.getNPSArrearList(ppEmployeeMasterID);
		List<ViewPpEmppaydetail> empPayDetailList = (List<ViewPpEmppaydetail>) updatePayDetailService
				.getComboList(ppEmployeeMasterID + "",
						"ViewPpEmppaydetail.findByPpEmployeemasterid");
		for (ViewPpEmppaydetail viewPpEmppaydetail : empPayDetailList) {
			modelAndView.addObject("registerName",
					viewPpEmppaydetail.getRegistername());
			modelAndView.addObject("sectionname",
					viewPpEmppaydetail.getSectionname());
		}

		List<PpNpsdetailEntity> npsdetailsList = updatePayDetailService
				.getnpsDetail(ppEmployeeMasterID);
		for (PpNpsdetailEntity npsdetail : npsdetailsList) {
			modelAndView.addObject("joining_mnth", npsdetail.getJoining_mnth());
			modelAndView.addObject("startmon_forregular_cont",
					npsdetail.getStartmon_forregular_cont());
			modelAndView.addObject("mon_contr", npsdetail.getMon_contr());
			modelAndView.addObject("year_contr", npsdetail.getYear_contr());
			System.out.println(npsdetail.getYear_contr());
			modelAndView.addObject("actual_ded_mon",
					npsdetail.getActual_ded_mon());
			modelAndView.addObject("actual_ded_year",
					npsdetail.getActual_ded_year());
			modelAndView.addObject("emp_cont_amt", npsdetail.getEmp_cont_amt());
		}

		modelAndView.addObject("npsarrearList", npsarrearList);
		modelAndView.addObject("npsdetailsList", npsdetailsList);
		modelAndView.addObject("ppEmployeeMasterID", ppEmployeeMasterID);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;
	}

	@RequestMapping(value = "/deletePayBill")
	public ModelAndView deletePayBill(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("deletePayBillList");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		List<DeletePayBillEntity> payBillList = (List<DeletePayBillEntity>) updatePayDetailService
				.getPayBillListToDelete(rmOfficeid);
		modelAndView.addObject("payBillList", payBillList);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	@RequestMapping(value = "/deletePayBillLogic")
	public ModelAndView deletePayBillLogic(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("deletePayBillList");
		String pp_PayBillDetailID = request.getParameter("pp_PayBillDetailID");
		HttpSession session = request.getSession();

		boolean isDelete = updatePayDetailService
				.deletePayBill(pp_PayBillDetailID);

		if (isDelete) {
			modelAndView.addObject("mes", "PayBill Deleted  successfully");
		}

		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		List<DeletePayBillEntity> payBillList = (List<DeletePayBillEntity>) updatePayDetailService
				.getPayBillListToDelete(rmOfficeid);
		modelAndView.addObject("payBillList", payBillList);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

}
