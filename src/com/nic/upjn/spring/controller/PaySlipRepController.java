package com.nic.upjn.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.miscellaneous.CalenderUtils;
import com.nic.upjn.spring.Service.ReportManagerService;
import com.nic.upjn.spring.Service.ReportManagerServiceImple;
import com.nic.upjn.spring.dto.PaySlipReportDTO;
import com.nic.upjn.spring.entity.PaySlipEntity;
import com.nic.upjn.spring.entity.PpRegistermaster;

@Controller
public class PaySlipRepController {
	
	@Autowired
	ReportManagerService reportManagerService;
	
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	@RequestMapping("/PaySlipRepForm")
	public ModelAndView PaySlipRepForm(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("PaySlipRepForm");

		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			List<PpRegistermaster> registerlist = (List<PpRegistermaster>) reportManagerService.getList(null,
					"PpRegistermaster.findAll");

			List months = CalenderUtils.populateMonth();

			List years = CalenderUtils.populateYear();

			System.out.println(years.size() + "--" + months.size() + "--" + registerlist.size());

			target.addObject("registerlist", registerlist);
			target.addObject("months", months);
			target.addObject("years", years);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;

	}

	
	@SuppressWarnings("unchecked")
	@RequestMapping("/selectEmpforPaySlip")
	public ModelAndView selectEmpforPaySlip(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("selectEmpforPaySlip");

		try {
			List<PpRegistermaster> registerlist = (List<PpRegistermaster>) reportManagerService.getList(null,"PpRegistermaster.findAll");
			List<?> list = (List<?>)reportManagerService.getList(null, "MasEmploymentsubtype.findAll");
			List<?> list1 = (List<?>)reportManagerService.getList(null, "PpDesignationmaster.findAll");
			
			target.addObject("registerlist", registerlist);
			target.addObject("employementcategory",list);
			target.addObject("designationlist",list1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;

	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/searchEmpforPaySlip")
	public ModelAndView searchEmpforPaySlip(@ModelAttribute("paySlipReportDTO")PaySlipReportDTO paySlipReportDTO,HttpServletRequest request, HttpServletResponse response){
		ModelAndView target = new ModelAndView("searchEmpforPaySlip");
		
		try {
			String sql = "";
			String predicate = "";
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			
			predicate = reportManagerService.createPredicate(paySlipReportDTO);
			System.out.println("predicate = " + predicate);
			
			sql = "select * from VIEW_EMPLOYEE_SEARCH where  rm_officeID = '" + rmOfficeid + "' and isfunctioning='1' " + predicate;
			
			List employeeList = reportManagerService.getEmployeeList(sql);
			
			target.addObject("employeeList",employeeList);
			target.addObject("ppRegistermasterid",paySlipReportDTO.getPpRegistermasterid());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target; 
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/selEmpPaySlip")
	public ModelAndView selEmpPaySlip(@ModelAttribute("paySlipReportDTO")PaySlipReportDTO paySlipReportDTO,HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("PaySlipRepForm");

		try {
			List<PpRegistermaster> registerlist = (List<PpRegistermaster>) reportManagerService.getList(null,
					"PpRegistermaster.findAll");

			List months = CalenderUtils.populateMonth();
			List years = CalenderUtils.populateYear();

			System.out.println(years.size() + "--" + months.size() + "--" + registerlist.size());

			target.addObject("registerlist", registerlist);
			target.addObject("empcode", paySlipReportDTO.getEmpcode());
			target.addObject("ppEmployeemasterid", paySlipReportDTO.getPpEmployeemasterid());
			target.addObject("registerno", paySlipReportDTO.getPpRegistermasterid());
			target.addObject("months", months);
			target.addObject("years", years);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;

	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/BillDetailForPaySlipReport")
	public ModelAndView getBillDetailForPaySlipReport(@ModelAttribute("paySlipReportDTO")PaySlipReportDTO paySlipReportDTO,HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView target = new ModelAndView("PaySlipBillDetail");
		try{
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			
			List billDetail = reportManagerService.getBillDetailForMonthlyPayReport(paySlipReportDTO.getMonth(), paySlipReportDTO.getYear(), rmOfficeid,paySlipReportDTO.getPpRegistermasterid());
			
			target.addObject("billdetail", billDetail);
			target.addObject("empcode", paySlipReportDTO.getEmpcode());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/PaySlipReport")
	public ModelAndView PaySlipReport(@ModelAttribute("paySlipReportDTO")PaySlipReportDTO paySlipReportDTO,HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView target = new ModelAndView("PaySlipReport");
		
		List reportHeadList = null;
		List reportList = null;
		String pdfFileName="";
		
		try{
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			
			String employeeCode = paySlipReportDTO.getEmpcode();
            String payMonth = paySlipReportDTO.getMonth();
            String payYear = paySlipReportDTO.getYear();
            String pp_RegisterMasterID = paySlipReportDTO.getPpRegistermasterid();
			String pp_PayBillDetailID = paySlipReportDTO.getPpPaybilldetailid();
			
			 reportHeadList = reportManagerService.getPaySlipHeads();
	          reportList = reportManagerService.getPaySlipReport(rmOfficeid, pp_RegisterMasterID, payMonth, payYear, employeeCode,pp_PayBillDetailID);
	         
	         System.out.println("size of report head list -- "+reportHeadList.size()+"---- size of report list--"+reportList.size());
	         
	         pdfFileName = reportManagerService.prepareDataForReport(reportList,reportHeadList, rmOfficeid, pp_RegisterMasterID, employeeCode);
	         
	           ListIterator itr = null;
				HashMap mapA = new HashMap();
				HashMap mapD = new HashMap();
				HashMap mapN = new HashMap();
				
				itr = ReportManagerServiceImple.allowanceList.listIterator();
				while(itr.hasNext()){ HashMap temp = (HashMap)itr.next(); mapA.putAll(temp); }
				
				itr = ReportManagerServiceImple.deductionList.listIterator();
				while(itr.hasNext()){ HashMap temp = (HashMap)itr.next(); mapD.putAll(temp); }
				
				itr = ReportManagerServiceImple.netPayableList.listIterator();
				while(itr.hasNext()){ HashMap temp = (HashMap)itr.next(); mapN.putAll(temp); }
	         
				
			  request.setAttribute("reportHeadList", reportHeadList);
		      request.setAttribute("reportList", reportList);
		      request.setAttribute("allowanceList", mapA);
	          request.setAttribute("deductionList", mapD);
	          request.setAttribute("netPayableList", mapN);
	          request.setAttribute("pdfFileName", pdfFileName);
	          
	          target.addObject("reportHeadList", reportHeadList);
	          target.addObject("reportList", reportList);
	          target.addObject("allowanceList", mapA);
	          target.addObject("deductionList", mapD);
	          target.addObject("netPayableList", mapN);
	          target.addObject("pdfFileName", pdfFileName);
				
		}
		catch(Exception e){
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}
	
}
