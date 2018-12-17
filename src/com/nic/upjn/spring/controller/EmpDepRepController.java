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

import com.nic.upjn.spring.Service.PersonalReportService;
import com.nic.upjn.spring.dto.EmpDepReportDTO;
import com.nic.upjn.spring.entity.MasEmploymentsubtype;

@Controller
public class EmpDepRepController {
	
	@Autowired
	private PersonalReportService personalReportService;
	
	/** by default method **/
	@SuppressWarnings("unchecked")
	@RequestMapping("/EmpDepRepForm")
	public ModelAndView EmpDepRepForm(
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("EmpDepRepForm");

		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			System.out.println(rmOfficeid + "-- rmofficeid");
			
			List<MasEmploymentsubtype> list = (List<MasEmploymentsubtype>)personalReportService.getList(null, "MasEmploymentsubtype.findAll");
		
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/EmpDepReport")
	public ModelAndView EmpDepReport( @ModelAttribute("empDepReportDTO") EmpDepReportDTO empDepReportDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("EmpDepReport");
		List empList;

		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			System.out.println(rmOfficeid + "-- rmofficeid");
			
			empList=personalReportService.getEmpOnDeputation(empDepReportDTO.getAsondate(),empDepReportDTO.getEmployeementcategory(),empDepReportDTO.getNoofdays());
		
			List<MasEmploymentsubtype> list = (List<MasEmploymentsubtype>)personalReportService.getList(empDepReportDTO.getEmployeementcategory(), "MasEmploymentsubtype.findByMasEmploymentsubtypeid");
			
			System.out.println(empList.size()+"----size of emplist-----"+list.size()+"-----size of list");
			
			target.addObject("empList", empList);
			target.addObject("list", list);
			target.addObject("asondate", empDepReportDTO.getAsondate());
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
