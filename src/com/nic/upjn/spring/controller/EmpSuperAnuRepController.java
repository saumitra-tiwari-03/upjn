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
import com.nic.upjn.spring.Service.PersonalReportService;
import com.nic.upjn.spring.dto.EmpSupAnuRepDTO;
import com.nic.upjn.spring.entity.MasEmploymentsubtype;

@Controller
public class EmpSuperAnuRepController {
	
	@Autowired
	private PersonalReportService personalReportService;
	
	/** by default method **/
	@SuppressWarnings({ "unchecked", "rawtypes"})
	@RequestMapping("/EmpSupAnuRepForm")
	public ModelAndView EmpSupAnuRepForm(
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("EmpSupAnuRepForm");

		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			System.out.println(rmOfficeid + "-- rmofficeid");
			
			List months = CalenderUtils.populateMonth();
			List years = CalenderUtils.populateYear();
			List<MasEmploymentsubtype> list = (List<MasEmploymentsubtype>)personalReportService.getList(null, "MasEmploymentsubtype.findAll");
			
			target.addObject("months", months);
			target.addObject("years", years);
			target.addObject("employementcategory",list);
		
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();

		 target.addObject("employee_name", (String) session.getAttribute("employeename"));
		 target.addObject("designation_", (String) session.getAttribute("designation"));
		 
		return target;

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/EmpSupAnuReport")
	public ModelAndView EmpSupAnuReport(
		  @ModelAttribute("empSupAnuRepDTO") EmpSupAnuRepDTO empSupAnuRepDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("EmpSupAnuReport");
        List empList;
		
		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			System.out.println(rmOfficeid + "-- rmofficeid");
			
			empList=personalReportService.getEmployeeList_toBeSuperAnnutated(empSupAnuRepDTO.getMonth(),empSupAnuRepDTO.getYear(),empSupAnuRepDTO.getEmployeementcategory());
			
			List<MasEmploymentsubtype> list = (List<MasEmploymentsubtype>)personalReportService.getList(empSupAnuRepDTO.getEmployeementcategory(), "MasEmploymentsubtype.findByMasEmploymentsubtypeid");
			
			System.out.println(empList.size()+"----size of emplist-----"+list.size()+"-----size of list");
			
			target.addObject("empList", empList);
			target.addObject("list", list);
			
		}

		catch (Exception e) {
			e.printStackTrace();
			target = new ModelAndView("EmpSupAnuRepForm");
			
			List months = CalenderUtils.populateMonth();
			List years = CalenderUtils.populateYear();
			List<MasEmploymentsubtype> list = (List<MasEmploymentsubtype>)personalReportService.getList(null, "MasEmploymentsubtype.findAll");
			
			target.addObject("months", months);
			target.addObject("years", years);
			target.addObject("employementcategory",list);
			
			target.addObject("msg", "Select all values");
		}
		
		HttpSession session = request.getSession();

		 target.addObject("employee_name", (String) session.getAttribute("employeename"));
		 target.addObject("designation_", (String) session.getAttribute("designation"));
		 
		return target;

	}

}
