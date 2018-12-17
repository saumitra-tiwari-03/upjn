/******************************** Office Selection  CONTROLLER **************************/
/* ==========================================================================
 * Description    : This class implements controller operations for Office Selection.
 * Date			  :18/01/2016  
 * Author		  : RAM PRAKASH PANDEY
 * Review By 	  : 
 * Review Date    :  
 *==========================================================================
 */

/** This is a controller class used for Office Selection. 
 *  Controller class get's the request from JSP pages,
 *  based on the requirement , methods of service class are called  and finally response is send to the JSP pages.
 * **/

/** Package Name **/
package com.nic.upjn.spring.controller;

/**********************************LIBRARIES USED ********************************/
/** BeanUtils class copy the similar property of Bean class to another class  **/

/**AUTOWIRED Annotation 	: Used for creating the object of class without using new keyword 
 Controller Annotation 		: Used to make controller class of any defined simple class . This class is capable to initiate request and response between JSP and Controller 
 ModelAttribute Annotation  : It automatically sets the values from JSP to DTO class.Variable name must be same in both JSP and DTO
 RequestMapping annotation  : Used for mapping URL to the method of controller class  
 RequestMethod annotation   : Used for identifying type of request generated from JSP  
 SessionStatus class        : Represents current status of the Session 
 ModelAndView class         : It is Responsible for setting views and objects required by JSP Pages 
 EmployeeAppointmentService Interface : It contains all abstract methods used for Office Selection 
 OfficeDTO class            : Contains the getter and setter of JSP variables 


/** Imports required number of classes that are used in this particular class **/
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.nic.upjn.spring.Service.EmployeeAppointmentService;
import com.nic.upjn.spring.dto.OfficeDTO;
import com.nic.upjn.spring.entity.MasDistrict;
import com.nic.upjn.spring.entity.MasOfficelevel;
import com.nic.upjn.spring.entity.RmOffice;

@SuppressWarnings({ "unchecked" })
@Controller
public class OfficeSelectionController {
	@Autowired
	private EmployeeAppointmentService employeeAppointmentService;

	public OfficeSelectionController() {
		super();

	}

	/**
	 * This method is used to save the selected office into Session Attribute
	 * and to return Office Selection Page
	 **/

	@RequestMapping(value = "/OfficeSelection", method = RequestMethod.GET)
	protected ModelAndView OfficeSelectonCont(@ModelAttribute("officeDTO") OfficeDTO officeDTO,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		session.setAttribute("rmOfficeid", officeDTO.getRmOfficeid());
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		System.out.println(rmOfficeid + " - This is rmofficeID");

		List<RmOffice> list = (List<RmOffice>) employeeAppointmentService.getList(rmOfficeid,
				"RmOffice.findByRmOfficeid");
		for (RmOffice rmOffice : list) {
			session.setAttribute("Office_Name", rmOffice.getOfficename());
			ModelAndView header_details = new ModelAndView("Header");
			header_details.addObject("Office_Name", rmOffice.getOfficename());
		}

		ModelAndView modelAndView = new ModelAndView("welcome");

		return modelAndView;
	}

	/** This method will populate the office Level and District List **/

	@RequestMapping(value = "/OfficeSelectionController", method = RequestMethod.GET)
	protected ModelAndView officeAndDistrict(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("OfficeSelection");
		HashMap<Integer, String> officelevel = new HashMap<Integer, String>();
		HashMap<Integer, String> districtlist = new HashMap<Integer, String>();

		try {
			List<MasOfficelevel> list = (List<MasOfficelevel>) employeeAppointmentService.getList(null,
					"MasOfficelevel.findAll");

			for (MasOfficelevel masOfficelevel : list) {
				officelevel.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());
			}
			modelAndView.addObject("Data", officelevel);

			List<MasDistrict> list1 = (List<MasDistrict>) employeeAppointmentService.getList(null,
					"MasDistrict.findAll");
			for (MasDistrict masDistrict : list1) {
				districtlist.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());

			}
			modelAndView.addObject("Data1", districtlist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}

	
	 /* @RequestMapping(value = "/OfficeSelectionController", method =
	  RequestMethod.GET) protected void officeAndDistrict(HttpServletRequest
	  request, HttpServletResponse response) throws ServletException,
	  IOException {
	  
	  try { System.out .println(
	  "Hello .....................................................");
	  HashMap<Integer, String> hm = new HashMap<Integer, String>();
	  HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
	  
	  String str1 = request.getParameter("districtname1"); System.out .println(
	  "value of str1 is..........................................................."
	  + str1); String json = null;
	  
	  
	  List<MasOfficelevel> list = (List<MasOfficelevel>)
	  employeeAppointmentService .getList(null, "MasOfficelevel.findAll");
	  
	  for (MasOfficelevel masOfficelevel : list) {
	  hm.put(masOfficelevel.getMasOfficelevelid(),
	  masOfficelevel.getOfficelevel());
	  
	  } request.setAttribute("str", "hello"); request.setAttribute("Data", hm);
	  
	  List<MasDistrict> list1 = (List<MasDistrict>) employeeAppointmentService
	  .getList(null, "MasDistrict.findAll");
	  
	  for (MasDistrict masDistrict : list1) {
	  hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());
	  
	  } request.setAttribute("Data1", hm1);
	  
	  request.getRequestDispatcher("/WEB-INF/view/OfficeSelection.jsp")
	  .forward(request, response);
	  
	  } catch (Exception ex) { System.out.println("Exception:" + ex);
	  
	  } }*/
	 

	/**
	 * This method will populate the list of OfficeName on the basis of
	 * DistrictID and officeLevelID
	 **/

	@RequestMapping(value = "/OfficeSelectionController1", method = RequestMethod.GET)
	protected void office(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!controller 1");
		try {

			HashMap<String, String> hmap = new HashMap<String, String>();

			String json = null;
			String district = request.getParameter("districtname");
			int districtid = Integer.parseInt(district);
			System.out.println("Id  of  is district is     ........  " + districtid);
			String str = request.getParameter("ofname");
			int officeid = Integer.parseInt(str);
			System.out.println("ID of office is     ........        " + officeid);

			int[] where_condtion = new int[] { officeid, districtid };

			List<RmOffice> list1 = (List<RmOffice>) employeeAppointmentService.getOfficeCombo(where_condtion,
					"RmOffice.findByOfficename");

			for (RmOffice rmOffice : list1) {
				hmap.put(rmOffice.getRmOfficeid() + "", rmOffice.getOfficename());

			}

			json = new Gson().toJson(hmap);
			response.setContentType("application/json");
			response.getWriter().write(json);

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
