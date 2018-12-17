package com.nic.upjn.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.miscellaneous.CalenderUtils;
import com.nic.upjn.spring.Service.ReportManagerService;
import com.nic.upjn.spring.dto.BillAdviceReportDTO;
import com.nic.upjn.spring.entity.AdviceBillBillDetailEntity;
import com.nic.upjn.spring.entity.RmOffice;
import com.nic.upjn.spring.entity.SysPaymentmode;

@SuppressWarnings({ "unchecked", "unused" })
@Controller
public class BillAdviceReportController {

	@Autowired
	ReportManagerService reportManagerService;
	CalenderUtils calenderUtils = new CalenderUtils();

	@RequestMapping("/BillAdvice.do")
	public ModelAndView BillAdviceForm(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("billAdviceReportForm");
		HttpSession session = request.getSession();

		List<SysPaymentmode> paymentModeList = (List<SysPaymentmode>) reportManagerService
				.getList(null, "SysPaymentmode.findAll");

		List<?> months = CalenderUtils.populateMonth();
		List<?> years = CalenderUtils.populateYear();

		modelAndView.addObject("months", months);
		modelAndView.addObject("years", years);
		modelAndView.addObject("paymentModeList", paymentModeList);
		
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping(value = "/getPayBillDetail12", method = RequestMethod.POST)
	public ModelAndView getPayBillDetail12(
			@ModelAttribute("billAdviceReportDTO") BillAdviceReportDTO billAdviceReportDTO,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("adviceBillDetails");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		List<AdviceBillBillDetailEntity> payBillDetailList = (List<AdviceBillBillDetailEntity>) reportManagerService
				.getPayBillDetailForParticularMonthAndYear(
						billAdviceReportDTO.getMonthName(),
						billAdviceReportDTO.getYearName(), rmOfficeid,
						billAdviceReportDTO.getSysPaymentmodeid(), "P");

		String pp_PayBillDetailID[] = new String[payBillDetailList.size()];
		
		modelAndView.addObject("monthName", billAdviceReportDTO.getMonthName());
		modelAndView.addObject("yearName", billAdviceReportDTO.getYearName());
		modelAndView.addObject("sysPaymentmodeid",
				billAdviceReportDTO.getSysPaymentmodeid());
		modelAndView.addObject("payBillDetailList", payBillDetailList);
		request.setAttribute("pp_PayBillDetailID",pp_PayBillDetailID);
		
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping(value = "/generateBillAdviceReport", method = RequestMethod.POST)
	public ModelAndView generateBillAdviceReport(
			@ModelAttribute("billAdviceReportDTO") BillAdviceReportDTO billAdviceReportDTO,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("invoked");
		ModelAndView modelAndView = new ModelAndView("BillAdviceReport");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		String employeecode = (String) session.getAttribute("employeecode");

		List<RmOffice> officeListName = (List<RmOffice>) reportManagerService
				.getList(rmOfficeid + "", "RmOffice.findByRmOfficeid");
		for (RmOffice rmOffice : officeListName) {

			modelAndView.addObject("officeName", rmOffice.getOfficename());
		}
		String monthName = request.getParameter("monthName");
		String yearName = request.getParameter("yearName");
		modelAndView.addObject("yearName", yearName);
		
		String sysPaymentmodeid = request.getParameter("sysPaymentmodeid");
		
		
		String[] pp_PayBillDetailID = billAdviceReportDTO.getPp_PayBillDetailID();
	
		String temp_monthName=calenderUtils.getMonth(request.getParameter("monthName"));
		modelAndView.addObject("monthName", temp_monthName);
		
		List<SysPaymentmode> paymentModeList = (List<SysPaymentmode>) reportManagerService
				.getList(sysPaymentmodeid, "SysPaymentmode.findBySysPaymentmodeid");
		String paymentModeName =null;
		for(SysPaymentmode sePaymentmode :paymentModeList)
		{
			 paymentModeName = sePaymentmode.getPaymentmode();
		}
		
		boolean isBankAdvice=reportManagerService.isBankAdvice(sysPaymentmodeid);
		
		List billAdviceList = reportManagerService.getAdviceList(monthName,yearName,sysPaymentmodeid,rmOfficeid, pp_PayBillDetailID);
		request.setAttribute("billAdviceList", billAdviceList);
		modelAndView.addObject("billAdviceList", billAdviceList);

		  if(isBankAdvice)
          {
			  modelAndView.addObject("visible", "1");
          }
		  
		  modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		   modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

}
