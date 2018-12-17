/******************************** EMPLOYEEPOSTING  CONTROLLER **************************/

/* ==========================================================================
 * Description   : This class implements controller operations for Employee Posting.
 * Date			 :18/01/2016  
 * Author		 : RAM PRAKASH PANDEY
 * Review By	 : 
 * Review Date	 :  
 *==========================================================================
 */

/**This is a controller class used for Posting of Employees. Controller class get's the request from JSP pages,
 *  based on the requirement , methods of service class are called  and finally response is send to the JSP pages.
 * **/

/**Package name**/
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
 EmployeeAppointmentService Interface : It contains all abstract methods used for EmployeePosting 
 EmployeePostingDTO class   : Contains the getter and setter of JSP variables 

/** Imports required number of classes that are used in this particular class **/
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
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
import com.nic.upjn.spring.entity.MasOfficelevel;
import com.nic.upjn.spring.entity.PpEmployeeappointmentdetail;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.PpPostingdetail;
import com.nic.upjn.spring.entity.ViewEditemployeeforposting;
import com.nic.upjn.spring.entity.ViewEmployeeforposting;
import com.nic.upjn.spring.entity.ViewEmployeename;
import com.nic.upjn.spring.entity.ViewEmployeepostingdetail;

@SuppressWarnings({ "unchecked", "unused" })
@Controller
public class EmployeePostingController {

	@Autowired
	private EmployeeAppointmentService employeeAppointmentService;

	ComboService comboService = new ComboService();
	Integer rmOfficeid;

	/**
	 * This method is called by default whenever a click event occurs on form
	 **/
	@RequestMapping("/getPostingList")
	public ModelAndView getPostingList(HttpServletRequest request, HttpServletResponse response) {

		EmployeePostingDTO employeePostingDTO = new EmployeePostingDTO();
		HttpSession session = request.getSession();
		rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		List<ViewEmployeeforposting> list3 = (List<ViewEmployeeforposting>) employeeAppointmentService
				.getList(rmOfficeid, "ViewEmployeeforposting.findByEntryOfficeid");
		ArrayList<ViewEmployeeforposting> al = new ArrayList<ViewEmployeeforposting>();

		for (ViewEmployeeforposting viewEmployeeforposting : list3) {
			BeanUtils.copyProperties(viewEmployeeforposting, employeePostingDTO);
		}

		ModelAndView modelAndView = new ModelAndView("PostingList");
		modelAndView.addObject("list", list3);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	/**
	 * This method is used to populate the details of a particular Employee on
	 * the basis of ppEmployeemasterid for Posting
	 **/
	@RequestMapping("/EmployeePosting")
	public ModelAndView EmployeePosting(HttpServletRequest request, HttpServletResponse response) {

		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		ModelAndView target = new ModelAndView("NewPosting");
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();

		HttpSession session = request.getSession();
		rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		List<ViewEmployeeforposting> basicInfo = (List<ViewEmployeeforposting>) employeeAppointmentService
				.getList(ppEmployeemasterid, "ViewEmployeeforposting.findByPpEmployeemasterid");

		try {

			String str1 = request.getParameter("districtname1");
			String json = null;

			hm = comboService.officeAndDistrict(employeeAppointmentService);
			request.setAttribute("str", "hello");

			List<MasDistrict> list1 = (List<MasDistrict>) employeeAppointmentService.getList(null,
					"MasDistrict.findAll");

			for (MasDistrict masDistrict : list1) {
				hm1.put(Integer.valueOf(masDistrict.getMasDistrictid()), masDistrict.getDistrictname());

			}

			target.addObject("PPEMPLOYEEMASTERID", ppEmployeemasterid);
			target.addObject("basicInfo", basicInfo);
			target.addObject("Data", hm);
			target.addObject("Data1", hm1);

		} catch (Exception ex) {
			System.out.println("Exception:" + ex);

		}
		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;
	}

	/**
	 * This method is used for Populating OfficeName on the basis of DistrictID
	 * and officeLevelID
	 **/
	@RequestMapping(value = "/OfficeSelectionController1")
	public void officeName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			HashMap<String, String> hmap = new HashMap<String, String>();

			String json = null;
			String district = request.getParameter("districtname");
			String str = request.getParameter("ofname");

			if (district != null && str != null) {
				int districtid = Integer.parseInt(district);
				int officeid = Integer.parseInt(str);
				int[] where_condtion = new int[] { officeid, districtid };
				hmap = comboService.office(where_condtion, employeeAppointmentService);
			}

			json = new Gson().toJson(hmap);
			response.setContentType("application/json");
			response.getWriter().write(json);

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used for adding the Details for Posting on the basis of
	 * Pp_PostingDetailID
	 **/

	@RequestMapping(value = "/SavePosting", method = RequestMethod.POST)
	public ModelAndView SavePosting(@ModelAttribute("employeePostingDTO") EmployeePostingDTO employeePostingDTO,
			HttpServletRequest request, HttpServletResponse response) {

		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		Long PP_POSTINGDETAILID = null;
		PpPostingdetail postingdetaildata = new PpPostingdetail();
		PpEmployeemaster ppEmployeemaster = new PpEmployeemaster();
		int result = 0;

		List<PpEmployeemaster> lis = (List<PpEmployeemaster>) employeeAppointmentService.getList(ppEmployeemasterid,
				"PpEmployeemaster.findByPpEmployeemasterid");
		for (PpEmployeemaster employeemaster : lis) {
			BeanUtils.copyProperties(employeemaster, ppEmployeemaster);
			ppEmployeemaster.setRM_OFFICEID(employeePostingDTO.getRmOfficeid());
			System.out.println(ppEmployeemaster.getPpEmployeemasterid() + "  " + ppEmployeemaster.getFirstname() + "  "
					+ ppEmployeemaster.getIsdisablefinancial() + "  " + ppEmployeemaster.getIsfunctioning() + "  "
					+ ppEmployeemaster.getIsloginlocked() + "  " + ppEmployeemaster.getIsretired() + "  "
					+ ppEmployeemaster.getEmployeecode() + "  " + ppEmployeemaster.getRM_OFFICEID());
		}

		List<PpEmployeeappointmentdetail> list1 = (List<PpEmployeeappointmentdetail>) employeeAppointmentService
				.getList(ppEmployeemasterid, "PpEmployeeappointmentdetail.findByppEmployeemasterid");
		for (PpEmployeeappointmentdetail ppEmployeeappointmentdetail : list1) {
			employeePostingDTO.setPpDesignationmasterid(ppEmployeeappointmentdetail.getPpDesignationmasterid() + "");
			employeePostingDTO.setSYS_SUBSERVICEPHASEMASTERID(
					String.valueOf(ppEmployeeappointmentdetail.getSysSubservicephasemasterid()));

			System.out.println(String.valueOf(ppEmployeeappointmentdetail.getSysSubservicephasemasterid()));
		}

		List<PpPostingdetail> postingInfo = (List<PpPostingdetail>) employeeAppointmentService
				.getList(ppEmployeemasterid, "PpPostingdetail.findByPpEmployeemasterid");
		for (PpPostingdetail postingdetail : postingInfo) {
			PP_POSTINGDETAILID = postingdetail.getPpPostingdetailid();
			employeePostingDTO.setPpPostingdetailid(PP_POSTINGDETAILID);
			postingdetail = new PpPostingdetail();
			BeanUtils.copyProperties(employeePostingDTO, postingdetaildata);
			Date date = comboService.getFormatedDate(employeePostingDTO.getEffectivedate());
			postingdetaildata.setEffectivedate(date);
			postingdetaildata.setPpDesignationmasterid(Integer.parseInt(employeePostingDTO.getPpDesignationmasterid()));
			postingdetaildata.setPpEmployeemasterid(employeePostingDTO.getPpEmployeemasterid() + "");
			postingdetaildata.setOrderdate(comboService.getFormatedDate(employeePostingDTO.getOrderdate()));
		}

		postingdetaildata.setModeofposting(new Short("1"));

		if (PP_POSTINGDETAILID != null) {
			result = employeeAppointmentService.updatePostingDetailsInfo(postingdetaildata, ppEmployeemaster);
		} else {
			result = employeeAppointmentService.executeProcedure(employeePostingDTO);
		}

		ModelAndView modelAndView;
		if (result == 1) {
			modelAndView = new ModelAndView("PostingListForEdit");
			List<ViewEditemployeeforposting> list = (List<ViewEditemployeeforposting>) employeeAppointmentService
					.getList(rmOfficeid, "ViewEditemployeeforposting.findByEntryOfficeid");
			modelAndView.addObject("list", list);
			modelAndView.addObject("app_msg", "Data Submited");
		} else {
			modelAndView = new ModelAndView("PostingListForEdit");
			List<ViewEditemployeeforposting> list = (List<ViewEditemployeeforposting>) employeeAppointmentService
					.getList(rmOfficeid, "ViewEditemployeeforposting.findByEntryOfficeid");
			modelAndView.addObject("list", list);
			modelAndView.addObject("app_msg", "error");
		}
		
		HttpSession session = request.getSession();

		 modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		 modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;
	}

	/**
	 * This method provide list of Employees to Edit the record on the basis of
	 * RmOfficeID
	 **/

	@RequestMapping("/getPostingListForEdit")
	public ModelAndView getPostingListForEdit(HttpServletRequest request, HttpServletResponse response) {

		EmployeePostingDTO employeePostingDTO = new EmployeePostingDTO();
		System.out.println("demo");
		HttpSession session = request.getSession();
		rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		List<ViewEditemployeeforposting> list = (List<ViewEditemployeeforposting>) employeeAppointmentService
				.getList(rmOfficeid, "ViewEditemployeeforposting.findByEntryOfficeid");

		for (ViewEditemployeeforposting viewEditemployeeforposting : list) {
			employeePostingDTO.setDesignation(viewEditemployeeforposting.getDesignation());
			employeePostingDTO.setEmployeecode(viewEditemployeeforposting.getEmployeecode());
			employeePostingDTO.setEmployeename(viewEditemployeeforposting.getEmployeename());
			employeePostingDTO.setEmploymentsubtype(viewEditemployeeforposting.getEmploymentsubtype());
			employeePostingDTO.setEmploymenttype(viewEditemployeeforposting.getEmploymenttype());
			employeePostingDTO.setPostingagainst(viewEditemployeeforposting.getPostingagainst());

			System.out.println(viewEditemployeeforposting.getDesignation() + "    "
					+ viewEditemployeeforposting.getEmployeecode());
		}

		ModelAndView modelAndView = new ModelAndView("PostingListForEdit");
		modelAndView.addObject("list", list);


		 modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		 modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	/**
	 * This method is used to edit the Posting record of Employee on the basis
	 * of ppEmployeemasterid
	 **/

	@RequestMapping(value = "/editEmployeePostingDetails")
	public ModelAndView editEmployeePostingDetails(
			@ModelAttribute("employeePostingDTO") EmployeePostingDTO employeePostingDTO, HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("NewPosting");

		try {
			String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
			System.out.println(ppEmployeemasterid + "------@@@");

			List<ViewEditemployeeforposting> basicInfo = (List<ViewEditemployeeforposting>) employeeAppointmentService
					.getList(ppEmployeemasterid, "ViewEditemployeeforposting.findByPpEmployeemasterid");

			List<ViewEmployeename> basicInfo1 = (List<ViewEmployeename>) employeeAppointmentService
					.getList(ppEmployeemasterid, "ViewEmployeename.findByPpEmployeemasterid");

			String officeLevel = null;
			int officelevelid = 0;
			int districtid = 0;

			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
			HashMap<String, String> hmap = new HashMap<String, String>();

			System.out.println("Hello .....................................................");

			String str1 = request.getParameter("districtname1");
			System.out.println("value of str1 is..........................................................." + str1);
			String json = null;

			hm = comboService.officeAndDistrict(employeeAppointmentService);
			request.setAttribute("str", "hello");

			List<MasDistrict> list1 = (List<MasDistrict>) employeeAppointmentService.getList(null,
					"MasDistrict.findAll");

			for (MasDistrict masDistrict : list1) {
				hm1.put(Integer.valueOf(masDistrict.getMasDistrictid()), masDistrict.getDistrictname());
			}

			List<ViewEmployeepostingdetail> list = (List<ViewEmployeepostingdetail>) employeeAppointmentService
					.getList(ppEmployeemasterid, "ViewEmployeepostingdetail.findByPpEmployeemasterid");
			for (ViewEmployeepostingdetail viewEmployeepostingdetail : list) {
				officelevelid = viewEmployeepostingdetail.getMasOfficelevelid();
				districtid = viewEmployeepostingdetail.getMasDistrictid();

				System.out.println(officelevelid + "-------------------" + districtid);
			}

			List<MasOfficelevel> list3 = (List<MasOfficelevel>) employeeAppointmentService
					.getList(employeePostingDTO.getMasOfficelevelid() + "", "MasOfficelevel.findByMasOfficelevelid");

			int[] where_condtion = new int[] { officelevelid, districtid };
			hmap = comboService.office(where_condtion, employeeAppointmentService);

			modelAndView.addObject("PPEMPLOYEEMASTERID", ppEmployeemasterid);
			modelAndView.addObject("officelevel", list3);
			modelAndView.addObject("list", list);
			modelAndView.addObject("Data", hm);
			modelAndView.addObject("Data1", hm1);
			modelAndView.addObject("officename", hmap);
			modelAndView.addObject("basicInfo", basicInfo);
			modelAndView.addObject("basicInfo1", basicInfo1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();

		 modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		 modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		return modelAndView;
	}

	/** This method is used to delete the Posting details of Employee **/
	@RequestMapping(value = "/revertposting")
	public ModelAndView revertposting(@ModelAttribute("employeePostingDTO") EmployeePostingDTO employeePostingDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("PostingListForEdit");

		String ppEmployeemasterid = request.getParameter("ID");
		String ppPostingdetailid = request.getParameter("ID1");
		String postingagainst = request.getParameter("ID2");

		System.out.println(ppEmployeemasterid + "----" + ppPostingdetailid + "----" + postingagainst);

		boolean result = employeeAppointmentService.deletePostingDetail(ppPostingdetailid, ppEmployeemasterid,
				postingagainst);

		if (result == true) {
			target.addObject("app_msg", "Data Deleted Successfully");
		} else {
			target.addObject("app_msg", "Error !!");
		}

		HttpSession session = request.getSession();
		rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		List<ViewEditemployeeforposting> list = (List<ViewEditemployeeforposting>) employeeAppointmentService
				.getList(rmOfficeid, "ViewEditemployeeforposting.findByEntryOfficeid");

		for (ViewEditemployeeforposting viewEditemployeeforposting : list) {
			employeePostingDTO.setDesignation(viewEditemployeeforposting.getDesignation());
			employeePostingDTO.setEmployeecode(viewEditemployeeforposting.getEmployeecode());
			employeePostingDTO.setEmployeename(viewEditemployeeforposting.getEmployeename());
			employeePostingDTO.setEmploymentsubtype(viewEditemployeeforposting.getEmploymentsubtype());
			employeePostingDTO.setEmploymenttype(viewEditemployeeforposting.getEmploymenttype());
			employeePostingDTO.setPostingagainst(viewEditemployeeforposting.getPostingagainst());

			System.out.println(viewEditemployeeforposting.getDesignation() + "    "
					+ viewEditemployeeforposting.getEmployeecode());
		}

		target.addObject("list", list);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		 
		return target;
	}
}
