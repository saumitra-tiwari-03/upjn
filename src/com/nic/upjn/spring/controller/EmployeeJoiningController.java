/********************************  CONTROLLER FOR JOINING OF EMPLOYEES **************************/

/* ==========================================================================
 * Description   : This class implements controller operations for Joining of Employees.
 * Date			 :18/01/2016  
 * Author		 : RAM PRAKASH PANDEY
 * Review By 	 : 
 * Review Date	 :  
 *==========================================================================
 */

/**This is a controller class used for Joining of Employees. Controller class get's the request from JSP pages,
 *  based on the requirement , methods of service class are called  and finally response is send to the JSP pages.
 * **/

/**Package name**/
package com.nic.upjn.spring.controller;

/**********************************LIBRARIES USED ********************************/
/** BeanUtils class copy the similar property of Bean class to another class  **/

/**AUTOWIRED Annotation 	: Used for creating the object of class without using new keyword 
 Controller Annotation 		: Used to make controller class of any defined simple class . This class is capable to initiate request and response between JSP and Controller 
 ModelAttribute Annotation 	: It automatically sets the values from JSP to DTO class.Variable name must be same in both JSP and DTO
 RequestMapping annotation 	: Used for mapping URL to the method of controller class  
 RequestMethod annotation 	: Used for identifying type of request generated from JSP  
 SessionStatus class 		: Represents current status of the Session 
 ModelAndView class			: It is Responsible for setting views and objects required by JSP Pages 
 EmployeeAppointmentService Interface : It contains all abstract methods used for Office Selection
 EmployeePostingDTO class 	: Contains the getter and setter of JSP variables 


 /** Imports required number of classes that are used in this particular class **/
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.nic.upjn.miscellaneous.ComboService;
import com.nic.upjn.spring.Service.EmployeeAppointmentService;
import com.nic.upjn.spring.dto.EmployeePostingDTO;
import com.nic.upjn.spring.entity.MasDistrict;
import com.nic.upjn.spring.entity.ViewEmplistforjoining;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;

@SuppressWarnings({ "unchecked", "unused" })
@Controller
public class EmployeeJoiningController {

	@Autowired
	private EmployeeAppointmentService employeeAppointmentService;
	@Autowired
	ComboService comboService;

	/**
	 * This method is called by default whenever a click event occurs on form
	 **/
	@RequestMapping("/EmployeeJoining")
	public ModelAndView employeeJoining(@ModelAttribute("employeePostingDTO") EmployeePostingDTO employeePostingDTO,
			HttpServletRequest request, HttpServletResponse response) {

		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
		List<ViewEmplistforjoining> list = null;

		ModelAndView modelAndView = null;

		HttpSession session = request.getSession();
		String ppEmployeemasterid = (String) session.getAttribute("ppEmployeemasterid");

		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		if (ppEmployeemasterid.equals("0") || ppEmployeemasterid.equals("1") || ppEmployeemasterid.equals("2")) {

			modelAndView = new ModelAndView("EmployeeJoining");
			try {
				String json = null;

				hm = comboService.officeAndDistrict(employeeAppointmentService);
				request.setAttribute("str", "hello");

				List<MasDistrict> list1 = (List<MasDistrict>) employeeAppointmentService.getList(null,
						"MasDistrict.findAll");

				for (MasDistrict masDistrict : list1) {
					hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());
				}

				modelAndView.addObject("Data", hm);
				modelAndView.addObject("Data1", hm1);

			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}

		else {
			modelAndView = new ModelAndView("EmployeeJoiningbyUser");

			System.out.println(rmOfficeid + "-----" + ppEmployeemasterid);

			try {
				list = (List<ViewEmplistforjoining>) employeeAppointmentService.getList(rmOfficeid,
						"ViewEmplistforjoining.findByRmOfficeid");

				for (ViewEmplistforjoining viewEmplistforjoining : list) {
					BeanUtils.copyProperties(viewEmplistforjoining, employeePostingDTO);
				}

				modelAndView.addObject("list", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		return modelAndView;
	}

	@RequestMapping("/EmployeeJoininglist")
	public ModelAndView employeeJoininglist(@ModelAttribute("employeePostingDTO") EmployeePostingDTO employeePostingDTO,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = null;
		List<ViewEmplistforjoining> list = null;
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();

		String OfficeID = request.getParameter("OfficeID");
		if (OfficeID != null) {
			list = (List<ViewEmplistforjoining>) employeeAppointmentService.getList(OfficeID,
					"ViewEmplistforjoining.findByRmOfficeid");

			for (ViewEmplistforjoining viewEmplistforjoining : list) {
				BeanUtils.copyProperties(viewEmplistforjoining, employeePostingDTO);
			}
		}
		hm = comboService.officeAndDistrict(employeeAppointmentService);
		request.setAttribute("str", "hello");

		List<MasDistrict> list1 = (List<MasDistrict>) employeeAppointmentService.getList(null, "MasDistrict.findAll");

		for (MasDistrict masDistrict : list1) {
			hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());
		}
		modelAndView = new ModelAndView("EmployeeJoining");
		modelAndView.addObject("Data", hm);
		modelAndView.addObject("Data1", hm1);
		modelAndView.addObject("OfficeID", OfficeID);
		modelAndView.addObject("list", list);

		HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;
	}

	/**
	 * This method is used to provide list of Office Names on the basis of
	 * DistrictID and OfficeLevelID
	 **/

	@RequestMapping(value = "/OfficeSelectionController1", method = RequestMethod.OPTIONS)
	public void officeName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!controller 1");

		HashMap<String, String> hmap = new HashMap<String, String>();

		String json = null;

		String district = request.getParameter("districtname");

		int districtid = Integer.parseInt(district);

		System.out.println("Id  of  is district is........" + districtid);

		String str = request.getParameter("ofname");

		int officeid = Integer.parseInt(str);

		System.out.println("ID of office is     ........        " + officeid);

		try {

			int[] where_condtion = new int[] { officeid, districtid };
			hmap = comboService.office(where_condtion, employeeAppointmentService);
			json = new Gson().toJson(hmap);
			response.setContentType("application/json");
			response.getWriter().write(json);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** This method is used to Retrieve List of newly joined Employees **/

	@RequestMapping(value = "/saveEmployeeJoiningRecord")
	public ModelAndView saveEmployeeJoiningRecord(
			@ModelAttribute("employeePostingDTO") EmployeePostingDTO employeePostingDTO, HttpServletRequest request,
			HttpServletResponse response) {
		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		ModelAndView modelAndView = new ModelAndView("addJoiningDetails");
		System.out.println(ppEmployeemasterid + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		List<ViewEmployeeSearch> list = null;

		try {
			if (ppEmployeemasterid != null) {
				list = (List<ViewEmployeeSearch>) employeeAppointmentService
						.getList(Integer.parseInt(ppEmployeemasterid), "ViewEmployeeSearch.findByPpEmployeemasterid");
			}

			for (ViewEmployeeSearch viewEmployeeSearch : list) {
				BeanUtils.copyProperties(viewEmployeeSearch, employeePostingDTO);
			}
			employeePostingDTO.setPpEmployeemasterid(Long.parseLong(ppEmployeemasterid + ""));

		} catch (Exception e) {

			e.printStackTrace();
		}
		modelAndView.addObject("list", list);
		modelAndView.addObject("ppEmployeemasterid", ppEmployeemasterid);

		HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;
	}

	/** This method is used to save records for Joining of Employees **/

	@RequestMapping(value = "/saveRecordOfJoining", method = RequestMethod.POST)
	public ModelAndView saveRecordOfJoining(@ModelAttribute("employeePostingDTO") EmployeePostingDTO employeePostingDTO,
			HttpServletRequest request, HttpServletResponse response) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
		ModelAndView modelAndView = new ModelAndView("EmployeeJoining");
		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		List<ViewEmployeeSearch> list = null;

		hm = comboService.officeAndDistrict(employeeAppointmentService);
		try {
			List<MasDistrict> list1 = (List<MasDistrict>) employeeAppointmentService.getList(null,
					"MasDistrict.findAll");

			for (MasDistrict masDistrict : list1) {
				hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());
			}

			if (ppEmployeemasterid != null) {
				list = (List<ViewEmployeeSearch>) employeeAppointmentService
						.getList(Integer.parseInt(ppEmployeemasterid), "ViewEmployeeSearch.findByPpEmployeemasterid");

			}

			if (ppEmployeemasterid != null) {
				list = (List<ViewEmployeeSearch>) employeeAppointmentService
						.getList(Integer.parseInt(ppEmployeemasterid), "ViewEmployeeSearch.findByPpEmployeemasterid");
			}

			for (ViewEmployeeSearch viewEmployeeSearch : list) {
				employeePostingDTO.setPpPostingdetailid(viewEmployeeSearch.getPpPostingdetailid());
			}
			employeePostingDTO.setPpEmployeemasterid(Long.parseLong(ppEmployeemasterid));

			int result = employeeAppointmentService.executeProcedureForADDJOININGDETAIL(employeePostingDTO);
			if (result == 1) {
				modelAndView.addObject("app_msg", "Process completed successfully");
			}
			modelAndView.addObject("Data", hm);
			modelAndView.addObject("Data1", hm1);

			HttpSession session = request.getSession();

			String pp_Employeemasterid = (String) session.getAttribute("ppEmployeemasterid");
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			if (pp_Employeemasterid.equals("0") || pp_Employeemasterid.equals("1") || pp_Employeemasterid.equals("2")) {

				modelAndView = new ModelAndView("EmployeeJoining");
			} else {
				modelAndView = new ModelAndView("EmployeeJoiningbyUser");
				List<ViewEmplistforjoining> lis = (List<ViewEmplistforjoining>) employeeAppointmentService
						.getList(rmOfficeid, "ViewEmplistforjoining.findByRmOfficeid");
				if (lis.size() == 0) {
					modelAndView.addObject("record_msg", "No record Found");
				}
				for (ViewEmplistforjoining viewEmplistforjoining : lis) {
					BeanUtils.copyProperties(viewEmplistforjoining, employeePostingDTO);
				}

				modelAndView.addObject("list", lis);
				modelAndView.addObject("app_msg", "Process completed successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		hm = comboService.officeAndDistrict(employeeAppointmentService);
		request.setAttribute("str", "hello");

		List<MasDistrict> list1 = (List<MasDistrict>) employeeAppointmentService.getList(null, "MasDistrict.findAll");

		for (MasDistrict masDistrict : list1) {
			hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());
		}

		modelAndView.addObject("Data", hm);
		modelAndView.addObject("Data1", hm1);

		HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}
}
