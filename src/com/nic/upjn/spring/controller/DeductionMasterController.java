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

import com.nic.upjn.spring.Service.DeductionMasterService;
import com.nic.upjn.spring.dto.DeductionMasterDTO;

@Controller
public class DeductionMasterController{
	
	@Autowired
	DeductionMasterService service;
	
List deductionlist = null;
List Employmenttypelist = null;
	
/********************************** By Default method - Called on click by menu *******************************************/
	
	@RequestMapping("/DeductionMaster")
	public ModelAndView begin(HttpServletRequest request, HttpServletResponse response){

		ModelAndView target = new ModelAndView("DeductionMaster");
		try {
			
			deductionlist = service.getList(null,"PpDeductionmaster.findAll");
			Employmenttypelist = service.getList(null,"MasEmploymenttype");
			
			System.out.println(deductionlist.size()+"----------"+Employmenttypelist.size());
			
			target.addObject("deductionlist",deductionlist);
			target.addObject("Employmenttypelist",Employmenttypelist);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
				target.addObject("designation_", (String) session.getAttribute("designation"));
				
		return target;
	}

	/********************************** To insert new Deduction *******************************************/

	@RequestMapping("/insertDeductionMaster")
	public ModelAndView insertQualificationTrainingMaster(@ModelAttribute("dto")DeductionMasterDTO dto,HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("DeductionMaster");
		
		try 
		{
			HttpSession session = request.getSession();
			target.addObject("employee_name", (String) session.getAttribute("employeename"));
			target.addObject("designation_", (String) session.getAttribute("designation"));	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	  }	
	
}
