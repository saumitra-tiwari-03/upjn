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
import com.nic.upjn.spring.dto.OfficewiseEmpRepDTO;
import com.nic.upjn.spring.entity.MasDistrict;
import com.nic.upjn.spring.entity.MasEmploymentsubtype;
import com.nic.upjn.spring.entity.MasOfficelevel;
import com.nic.upjn.spring.entity.PpDesignationmaster;

@Controller
public class OfficwiseEmployeRprtController {

	@Autowired
	private PersonalReportService personalReportService;

	/** by default method **/
	@SuppressWarnings("unchecked")
	@RequestMapping("/OfficewiseEmpRepForm")
	public ModelAndView OfficewiseEmpRepForm(
			@ModelAttribute("officewiseEmpRepDTO") OfficewiseEmpRepDTO officewiseEmpRepDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("OfficewiseEmpRepForm");

		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			System.out.println(rmOfficeid + "-- rmofficeid");

			List<MasEmploymentsubtype> list = (List<MasEmploymentsubtype>) personalReportService
					.getList(null, "MasEmploymentsubtype.findAll");
			List<PpDesignationmaster> list1 = (List<PpDesignationmaster>) personalReportService
					.getList(null, "PpDesignationmaster.findAll");
			List<MasOfficelevel> list2 = (List<MasOfficelevel>) personalReportService
					.getList(null, "MasOfficelevel.findAll");
			List<MasDistrict> list3 = (List<MasDistrict>) personalReportService
					.getList(null, "MasDistrict.findAll");

			System.out.println(list.size() + "--" + list1.size() + "--"
					+ list2.size());

			target.addObject("employementcategory", list);
			target.addObject("designationlist", list1);
			target.addObject("officelevellist", list2);
			target.addObject("districtlist", list3);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;

	}

	@RequestMapping("/OfficewiseEmpReport")
	public ModelAndView OfficewiseEmpReport(
			@ModelAttribute("officewiseEmpRepDTO") OfficewiseEmpRepDTO officewiseEmpRepDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("OfficewiseEmpReport");

		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			System.out.println(rmOfficeid + "-- rmofficeid");
			String rmid = rmOfficeid.toString();

			List empList = null;

			if (officewiseEmpRepDTO.getEmpcode() != null
					&& officewiseEmpRepDTO.getEmpcode().equals("admin")) {
				empList = personalReportService.getReportData(
						officewiseEmpRepDTO.getEmpcode(),
						officewiseEmpRepDTO.getFirstName(),
						officewiseEmpRepDTO.getLastName(),
						officewiseEmpRepDTO.getEmployeementcategory(),
						officewiseEmpRepDTO.getDesignation(),
						officewiseEmpRepDTO.getOfficename(),
						officewiseEmpRepDTO.getOfficelevel(),
						officewiseEmpRepDTO.getDeteofjoiningfrom(),
						officewiseEmpRepDTO.getDeteofjoiningto(),
						officewiseEmpRepDTO.getDeteofbirthfrom(),
						officewiseEmpRepDTO.getDeteofbirthto());
			} else {
				empList = personalReportService.getReportData(
						officewiseEmpRepDTO.getEmpcode(),
						officewiseEmpRepDTO.getFirstName(),
						officewiseEmpRepDTO.getLastName(),
						officewiseEmpRepDTO.getEmployeementcategory(),
						officewiseEmpRepDTO.getDesignation(),
						officewiseEmpRepDTO.getOfficename(), null,
						officewiseEmpRepDTO.getDeteofjoiningfrom(),
						officewiseEmpRepDTO.getDeteofjoiningto(),
						officewiseEmpRepDTO.getDeteofbirthfrom(),
						officewiseEmpRepDTO.getDeteofbirthto());
			}
			System.out.println("empList size  = " + empList.size());

			// String pdfFileName =
			// personalReportService.createPdf(empList,rmid);

			request.setAttribute("empList", empList);
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
