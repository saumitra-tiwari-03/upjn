package com.nic.upjn.spring.controller;

import java.util.List;

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
import com.nic.upjn.spring.dto.LoanAlertReportDTO;

@Controller
public class LoanAlertRepController {
	@Autowired
	ReportManagerService reportManagerService;
	
	 CalenderUtils calenderUtils = new CalenderUtils();

@RequestMapping("/LoanAlertReportForm")	 
public ModelAndView LoanAlertReportForm(HttpServletRequest request, HttpServletResponse response){
	
	ModelAndView target = new ModelAndView("LoanAlertReportForm");
	
	try{
		List months = CalenderUtils.populateMonth();
		List years = CalenderUtils.populateYear();

		System.out.println(years.size() + "--" + months.size() + "--");

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


@SuppressWarnings({ "unused", "static-access", "rawtypes" })
@RequestMapping("/LoanAlertReport")
public ModelAndView LoanAlertReport(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loanalertDTO")LoanAlertReportDTO loanalertDTO){

ModelAndView target = new ModelAndView("LoanAlertReport");
String temp_monthName = "";
String nextmonthName="";
String msg="";
	
	try{
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		String monthName=loanalertDTO.getMonth();
		String yearName=loanalertDTO.getYear();
        String loan_type=loanalertDTO.getLoantype();
		
		if(loan_type.equals("next")){

            nextmonthName= String.valueOf(Integer.parseInt(monthName)+1);
            System.out.println("temp_nextmonthName "+nextmonthName);
        temp_monthName=calenderUtils.getMonth(nextmonthName);
        msg="1";
        }
        else
        {
            msg="0";
       temp_monthName=calenderUtils.getMonth(monthName);
        }
		
		List completedloanList = reportManagerService.getCompletedloanalertList(monthName,loan_type, yearName, rmOfficeid);
		
		target.addObject("completedloanList",completedloanList);
		target.addObject("monthName",monthName);
		target.addObject("yearName",yearName);
		target.addObject("completedloanList",completedloanList);
	}

	catch (Exception e) {
		e.printStackTrace();
	
	}
	
	HttpSession session = request.getSession();

	target.addObject("employee_name", (String) session.getAttribute("employeename"));
	target.addObject("designation_", (String) session.getAttribute("designation"));
	
	return target; 
}
}
