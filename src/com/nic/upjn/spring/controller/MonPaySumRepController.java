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
import com.nic.upjn.spring.dto.MonPaySumRepDTO;

@Controller
public class MonPaySumRepController {

	@Autowired
	ReportManagerService reportManagerService;

	@SuppressWarnings("rawtypes")
	@RequestMapping("/MonPaySumRepForm")
	public ModelAndView MonPaySumRepForm(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("MonPaySumRepForm");

		try {
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

	@RequestMapping("/MonPaySumReport")
	public ModelAndView MonPaySumReport(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("monPaySumRepDTO") MonPaySumRepDTO monPaySumRepDTO) {

		ModelAndView target = new ModelAndView("MonPaySumReport");

		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			
			List summaryList = reportManagerService.getMonthlySummary(rmOfficeid, monPaySumRepDTO.getMonth(), monPaySumRepDTO.getYear());
            
			String temp_monthName= CalenderUtils.getMonth(monPaySumRepDTO.getMonth());
			
			List<?> list = (List<?>)reportManagerService.getList(rmOfficeid.toString(),"RmOffice.findByRmOfficeid");
			
			System.out.println("size of sum list--"+summaryList.size()+"-- size of list --"+list.size()+"--val of temp month -- "+temp_monthName);
			
			target.addObject("summaryList", summaryList);
			target.addObject("monthName", temp_monthName);
			target.addObject("year",monPaySumRepDTO.getYear());
			target.addObject("list",list);
			
			request.setAttribute("summaryList", summaryList);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}
}
