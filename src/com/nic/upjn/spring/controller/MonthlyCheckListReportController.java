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
import com.nic.upjn.spring.dto.MonthlyCheckListDTO;
import com.nic.upjn.spring.entity.ViewChecklist;

@Controller
@SuppressWarnings({"unused", "rawtypes"})
public class MonthlyCheckListReportController {

	@Autowired
	ReportManagerService reportManagerService;

	@RequestMapping("/MonthlyCheckListForm")
	public ModelAndView MonthlyCheckListForm(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("MonthlyCheckListForm");

		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

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

	@RequestMapping("/MonthlyChecklist")
	public ModelAndView MonthlyChecklist(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("monthlyCheckListDTO") MonthlyCheckListDTO monthlyCheckListDTO) {

		ModelAndView target = new ModelAndView("MonthlyCheckListReport");

		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			List<ViewChecklist> list = (List<ViewChecklist>) reportManagerService.getCheckList(rmOfficeid,
					monthlyCheckListDTO.getMonth(), monthlyCheckListDTO.getYear());

			System.out.println(list.size());

			target.addObject("month", monthlyCheckListDTO.getMonth());
			target.addObject("year", monthlyCheckListDTO.getYear());
			target.addObject("list", list);

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
