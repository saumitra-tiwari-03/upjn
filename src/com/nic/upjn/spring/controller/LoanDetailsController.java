package com.nic.upjn.spring.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.nic.upjn.miscellaneous.CalenderUtils;
import com.nic.upjn.spring.Service.LoanSanctionService;
import com.nic.upjn.spring.entity.ViewEmployeename;

@Controller
public class LoanDetailsController {
	
	LoanDetailsController()
	{
		System.out.println("called");
	}
	
	
	@Autowired
	LoanSanctionService loanSanctionService;
	
	
	
	/** Method used for Loan Detail   **/
	
	@RequestMapping("/populateEmployee")
	public ModelAndView populateEmployeeDeductionDetail(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("called");
       String empMasterID = null;
       
       
		
		ArrayList<String> monthList;
		ArrayList<String> yearList = null;
		List<ViewEmployeename> employeeInfoList = null;
		
		 ModelAndView modelAndView = new ModelAndView("loanDetails");
		 monthList = CalenderUtils.populateMonth();
		 yearList = CalenderUtils.populateYear();
		 modelAndView.addObject("monthList", monthList);
		 modelAndView.addObject("yearList", yearList);
		 
		 
		 if (request.getParameter("ppEmployemasterID") != null){
				empMasterID = request.getParameter("ppEmployemasterID");
		 
		 employeeInfoList = (List<ViewEmployeename>) loanSanctionService.getComboList(empMasterID,"ViewEmployeename.findByPpEmployeemasterid");
         
		 for(ViewEmployeename viewEmployeename : employeeInfoList)
		 {
			 modelAndView.addObject("employeeName", viewEmployeename.getEmployeename());
			 modelAndView.addObject("designation", viewEmployeename.getDesignation());
			 modelAndView.addObject("ppEmployemasterID", viewEmployeename.getPpEmployeemasterid());
		 }
		 
		 }
		 HttpSession session = request.getSession();

			modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
			modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		return modelAndView;
		
	}

}
