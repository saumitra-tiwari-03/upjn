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
import com.nic.upjn.spring.dto.RetEmpReportDTO;
import com.nic.upjn.spring.entity.PpDesignationmaster;

@Controller
public class RetiredEmpRepController {
	
	@Autowired
	private PersonalReportService personalReportService;
	
	/** by default method **/
	@SuppressWarnings("unchecked")
	@RequestMapping("/RetEmpRepForm")
	public ModelAndView RetEmpRepForm(
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("RetEmpRepForm");

		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			System.out.println(rmOfficeid + "-- rmofficeid");
			
			List<PpDesignationmaster> list = (List<PpDesignationmaster>)personalReportService.getList(null, "PpDesignationmaster.findAll");
		
			target.addObject("designationlist",list);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;

	}
	

	@RequestMapping("/RetiredEmpReport")
	public ModelAndView RetEmpReport(@ModelAttribute("retEmpReportDTO") RetEmpReportDTO retEmpReportDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("RetiredEmpReport");
		List empList = null;

		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			System.out.println(rmOfficeid + "-- rmofficeid");

			empList = personalReportService.getRetiredemplist(retEmpReportDTO.getEmpcode(), retEmpReportDTO.getFirstName(), retEmpReportDTO.getLastName(),retEmpReportDTO.getDesignationid(), retEmpReportDTO.getRelieveafterdate(), rmOfficeid);

			System.out.println("empList size  = "+empList.size());
			
			System.out.println("al d");
			
			target.addObject("empList", empList);
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
