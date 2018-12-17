/******************************** SERVICE STATUS  CONTROLLER **************************/
/* ==========================================================================
 * Description : This class implements controller operations for SERVICE STATUS OF EMPLOYEE.
 * Date:18/01/2016  
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 */

/** This is a controller class used for Service Status of a particular Employee.
 *  Controller class get's the request from JSP pages,
 *  based on the requirement , methods of service class are called  and finally response is send to the JSP pages.
 * **/

/** Package Name **/
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
 ServiceStatusService Interface : It contains all abstract methods used for ServiceStatus 
 ServiceStatusDTO class 	: Contains the getter and setter of JSP variables 


/** Imports required number of classes that are used in this particular class **/
import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import com.nic.upjn.spring.Service.ServiceStatusService;
import com.nic.upjn.spring.dto.ServiceStatusDTO;
import com.nic.upjn.spring.dto.TransferEmployeeDTO;
import com.nic.upjn.spring.entity.MasDistrict;
import com.nic.upjn.spring.entity.MasEmploymentsubtype;
import com.nic.upjn.spring.entity.PpCurrentstatus;
import com.nic.upjn.spring.entity.PpDesignationmaster;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.PpSuspensiondetail;
import com.nic.upjn.spring.entity.PpTerminationdetail;
import com.nic.upjn.spring.entity.RmOffice;
import com.nic.upjn.spring.entity.SysSubservicephasemaster;
import com.nic.upjn.spring.entity.ViewDeputationlist;
import com.nic.upjn.spring.entity.ViewEmpinfoforreinsSusp;
import com.nic.upjn.spring.entity.ViewEmpinfoforreinsTerm;
import com.nic.upjn.spring.entity.ViewEmplistResumeafterdep;
import com.nic.upjn.spring.entity.ViewEmplistforreinsSusp;
import com.nic.upjn.spring.entity.ViewEmplistforreinsTerm;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;
import com.nic.upjn.spring.entity.ViewGetempnoduesdetail;
import com.nic.upjn.spring.entity.ViewRmGettopinfo;
import com.nic.upjn.spring.entity.ViewSuspensiondetaillist;
import com.nic.upjn.spring.entity.ViewTerminationdetaillist;

@SuppressWarnings({ "unchecked", "unused" })
@Controller
public class ServiceStatusController {

	@Autowired
	private ServiceStatusService serviceStatusService;
	static ComboService comboService;
	String root = "suspDetail";
	Integer rmOfficeid;

	/** Get the Reference of DTO class using the Reflection **/

	static {
		Class<?> ref;
		try {
			ref = Class.forName("com.nic.upjn.miscellaneous.ComboService");
			try {
				comboService = (ComboService) ref.newInstance();
			} catch (InstantiationException e) {

				e.printStackTrace();
			} catch (IllegalAccessException e) {

				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method will provide the Suspension detail List on the basis of
	 * RmOfficeid
	 **/
	@RequestMapping(value = "/suspensionDetails")
	public ModelAndView saveEmployee(HttpServletRequest request, HttpServletResponse respon)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		Class<?> ref = Class.forName("com.nic.upjn.spring.dto.ServiceStatusDTO");
		ServiceStatusDTO serviceStatusDTO = (ServiceStatusDTO) ref.newInstance();
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();

		HttpSession session = request.getSession();
		rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		List<ViewSuspensiondetaillist> list1 = (List<ViewSuspensiondetaillist>) serviceStatusService.getList(rmOfficeid,
				"ViewSuspensiondetaillist.findByRmOfficeid");
		for (ViewSuspensiondetaillist viewSuspensiondetaillist : list1) {
			BeanUtils.copyProperties(viewSuspensiondetaillist, serviceStatusDTO);

		}
		hm = comboService.officeAndDistrict(serviceStatusService);
		request.setAttribute("str", "hello");
		List<MasDistrict> list2 = (List<MasDistrict>) serviceStatusService.getList(null, "MasDistrict.findAll");
		for (MasDistrict masDistrict : list2) {
			hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());

		}
		ModelAndView modelAndView = new ModelAndView("employeeSuspensionDetails");
		modelAndView.addObject("list", list1);
		modelAndView.addObject("Data", hm);
		modelAndView.addObject("Data1", hm1);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;
	}

	/**
	 * This method is used to Populate the List of OfficeName on the basis of
	 * DistrictID and officeLevelID
	 **/
	@RequestMapping(value = "/OfficeSelectionController1", method = RequestMethod.TRACE)
	public void getofficeName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!controller 1");
		try {
			HashMap<String, String> hmap = new HashMap<String, String>();
			String json = null;
			String district = request.getParameter("districtname");
			int districtid = Integer.parseInt(district);
			System.out.println("Id  of  is district is     ........        " + districtid);
			String str = request.getParameter("ofname");
			int officeid = Integer.parseInt(str);
			System.out.println("ID of office is     ........        " + officeid);
			int[] where_condtion = new int[] { officeid, districtid };
			hmap = comboService.office(where_condtion, serviceStatusService);
			json = new Gson().toJson(hmap);
			response.setContentType("application/json");
			response.getWriter().write(json);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** This method is used to search Employee for Suspension **/

	@RequestMapping(value = "/suspensionEmployeeSearch")
	public ModelAndView suspensionEmployeeSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<PpDesignationmaster> list = null;
		List<MasEmploymentsubtype> list1 = null;

		try {
			Class<?> ref = Class.forName("com.nic.upjn.spring.dto.ServiceStatusDTO");
			ServiceStatusDTO serviceStatusDTO = (ServiceStatusDTO) ref.newInstance();

			list1 = (List<MasEmploymentsubtype>) serviceStatusService.getList(null, "MasEmploymentsubtype.findAll");
			for (MasEmploymentsubtype MasEmploymentsubtype : list1) {
				BeanUtils.copyProperties(MasEmploymentsubtype, serviceStatusDTO);
			}

			list = (List<PpDesignationmaster>) serviceStatusService.getList(null, "PpDesignationmaster.findAll");
			for (PpDesignationmaster PpDesignationmaster : list) {
				BeanUtils.copyProperties(PpDesignationmaster, serviceStatusDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("suspensionEmployeeSearch");
		modelAndView.addObject("designationlist", list);
		modelAndView.addObject("categorylist", list1);
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** This method will search Employee on the basis of user Input **/
	@RequestMapping(value = "/suspensionEmployeeSearchByCondtion")
	public ModelAndView suspensionEmployeeSearchByCondtion(
			@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String SQL;
		ModelAndView target = new ModelAndView("suspensionEmployeeSearchList");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		List<ViewEmployeeSearch> list = null;
		String ppDesignationmasterid = "" + serviceStatusDTO.getPpDesignationmasterid();
		String masEmploymentsubtypeid = "" + serviceStatusDTO.getMasEmploymentsubtypeid();
		String employeecode = "" + serviceStatusDTO.getEmployeecode();
		String firstname = serviceStatusDTO.getFirstname();
		String lastname = serviceStatusDTO.getLastname();
		if (employeecode.equals("") && firstname.equals("") && lastname.equals("")
				&& masEmploymentsubtypeid.equals("-1") && ppDesignationmasterid.equals("-1")) {

			list = (List<ViewEmployeeSearch>) serviceStatusService.getList(rmOfficeid, "ViewEmployeeSearch.findByRmOfficeid");

			for (ViewEmployeeSearch viewEmployeeSearch : list) {
				serviceStatusDTO.setEmployeecode(viewEmployeeSearch.getEmployeecode());
				serviceStatusDTO.setDesignation(viewEmployeeSearch.getDesignation());
				serviceStatusDTO.setEmployeename(viewEmployeeSearch.getEmployeename());
				serviceStatusDTO.setEmploymenttype(viewEmployeeSearch.getEmploymenttype());
				serviceStatusDTO.setEmploymentsubtype(viewEmployeeSearch.getEmploymentsubtype());
			}
		}

		else {

			serviceStatusDTO.setEmployeecode(employeecode);
			serviceStatusDTO.setFirstname(firstname);
			serviceStatusDTO.setLastname(lastname);
			serviceStatusDTO.setMasEmploymentsubtypeid(masEmploymentsubtypeid);
			serviceStatusDTO.setPpDesignationmasterid(Integer.parseInt(ppDesignationmasterid));
			String predicate = " PP_DEPUTATIONDETAILID IS NULL AND " + "PP_SUSPENSIONDETAILID IS NULL AND "
					+ "PP_EXITDETAILID IS NULL";
			
			SQL = serviceStatusService.createSearchSQL(predicate, serviceStatusDTO, rmOfficeid);
			list = (List<ViewEmployeeSearch>) serviceStatusService.suspensionEmployeeSearchList(SQL);
		}

		target.addObject("list", list);
		target.addObject("employeecode", employeecode);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}

	/**
	 * This method is used to populate the Suspension details of selected
	 * Employee and Suspension detail list on the basis of RmOfficeID
	 **/
	@RequestMapping(value = "/populateemployeeSuspensionDetails")
	public ModelAndView populateEmployeeSuspensionDetails(
			@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		{

			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
			List<ViewEmployeeSearch> suspentionEmployeeInfoList = null;
			String employeeInfo[];

			try {
				/*
				 * Class<?> ref =
				 * Class.forName("com.nic.upjn.spring.dto.ServiceStatusDTO");
				 * serviceStatusDTO = (ServiceStatusDTO) ref.newInstance();
				 */

				HttpSession session = request.getSession();
				Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
				String rmID = Integer.toString(rmOfficeid);

				String employeecode = serviceStatusDTO.getEmployeecode();
				if (employeecode.equals("")) {
					employeecode = request.getParameter("employee");
				}
				System.out.println(employeecode);
				employeeInfo = serviceStatusService.ProcPpValidateEmpGetInfo(employeecode, rmID, root, "add");

				if (employeeInfo != null) {
					suspentionEmployeeInfoList = (List<ViewEmployeeSearch>) serviceStatusService.getList(employeecode,
							"ViewEmployeeSearch.findByEmployeecode");

				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}

			hm = comboService.officeAndDistrict(serviceStatusService);
			request.setAttribute("str", "hello");
			List<MasDistrict> list2 = (List<MasDistrict>) serviceStatusService.getList(null, "MasDistrict.findAll");
			for (MasDistrict masDistrict : list2) {
				hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());

			}

			List<ViewSuspensiondetaillist> list1 = (List<ViewSuspensiondetaillist>) serviceStatusService
					.getList(rmOfficeid, "ViewSuspensiondetaillist.findByRmOfficeid");

			ModelAndView modelAndView = new ModelAndView("employeeSuspensionDetails");
			modelAndView.addObject("Data", hm);
			modelAndView.addObject("Data1", hm1);
			modelAndView.addObject("list", list1);

			System.out.println(suspentionEmployeeInfoList.size()
					+ "@@@@@@@@@@@@@@@@@@@@^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^#############");
			modelAndView.addObject("suspentionEmployeeInfoList", suspentionEmployeeInfoList);
			
			HttpSession session = request.getSession();
			modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
			modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
			
			return modelAndView;

		}
	}

	/** This method is used to Save and Edit Employee Suspension details **/
	@RequestMapping(value = "/saveRecordOfEmployeeSuspension", method = RequestMethod.POST)
	public ModelAndView saveRecordOfEmployeeSuspension(
			@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO, HttpServletRequest request,
			HttpServletResponse response)
		{
			ModelAndView modelAndView = new ModelAndView("employeeSuspensionDetails");
			try {
				List<ViewEmployeeSearch> suspentionEmployeeInfoList = null;
				PpSuspensiondetail ppSuspensiondetail = new PpSuspensiondetail();
				String PP_EmployeeMasterID_in = request.getParameter("ppEmployeemasterid");
				System.out.print(PP_EmployeeMasterID_in);
				
				Long Suspensiondetailid = null;
				int result = 0;

				HttpSession session = request.getSession();
				Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
				String rmID = Integer.toString(rmOfficeid);

				serviceStatusDTO.setEventofficeid(rmID);

				if (serviceStatusDTO.getEmployeecode() != null) {
					suspentionEmployeeInfoList = (List<ViewEmployeeSearch>) serviceStatusService
							.getList(serviceStatusDTO.getEmployeecode(), "ViewEmployeeSearch.findByEmployeecode");
					for (ViewEmployeeSearch viewEmployeeSearch : suspentionEmployeeInfoList) {
						serviceStatusDTO.setPpEmployeemasterid(viewEmployeeSearch.getPpEmployeemasterid() + "");

					}
				}

				List<ViewSuspensiondetaillist> list3 = (List<ViewSuspensiondetaillist>) serviceStatusService
						.getList(serviceStatusDTO.getEmployeecode(), "ViewSuspensiondetaillist.findByEmployeecode");

				for (ViewSuspensiondetaillist viewSuspensiondetaillist : list3) {
					Suspensiondetailid = viewSuspensiondetaillist.getPpSuspensiondetailid();
					serviceStatusDTO.setPpEmployeemasterid(viewSuspensiondetaillist.getPpEmployeemasterid() + "");
					BeanUtils.copyProperties(serviceStatusDTO, viewSuspensiondetaillist);
					/* Change of date format */
					viewSuspensiondetaillist
							.setEffectivedate(comboService.getFormatedDate(serviceStatusDTO.getEffectivedate()));
					viewSuspensiondetaillist
							.setSuspensionorddate(comboService.getFormatedDate(serviceStatusDTO.getSuspensionorddate()));

					System.out.println(viewSuspensiondetaillist.getEffectivedate() + "-- Effective date-- "
							+ viewSuspensiondetaillist.getSuspensionorddate());
					viewSuspensiondetaillist.setReasonforsuspension(serviceStatusDTO.getReasonForSuspension());
					viewSuspensiondetaillist.setPpSuspensiondetailid(Suspensiondetailid);
					Suspensiondetailid = viewSuspensiondetaillist.getPpSuspensiondetailid();

					System.out.println(Suspensiondetailid + "-- Suspension detail id ");

					BeanUtils.copyProperties(viewSuspensiondetaillist, ppSuspensiondetail);
					ppSuspensiondetail.setReportingdate(comboService.getFormatedDate(serviceStatusDTO.getReportingdate()));
					ppSuspensiondetail.setRelievingoffice(serviceStatusDTO.getRelievingoffice());
					System.out.println(ppSuspensiondetail.getReportingdate() + "-- Reporting date--and relieving office--"
							+ ppSuspensiondetail.getRelievingoffice());
					ppSuspensiondetail.setEventofficeid(rmID);
					if (Suspensiondetailid != null) {
						serviceStatusService.updateInformation(ppSuspensiondetail);
					}

				}

				if (Suspensiondetailid == null) {

					result = serviceStatusService.executeProcedureForAddSuspensionDetail(serviceStatusDTO);

				}

				modelAndView.addObject("app_msg", "Process completed successfully");
				List<ViewSuspensiondetaillist> list1 = (List<ViewSuspensiondetaillist>) serviceStatusService
						.getList(rmOfficeid, "ViewSuspensiondetaillist.findByRmOfficeid");
				modelAndView.addObject("list", list1);
			} catch (Exception e) {
				modelAndView.addObject("app_msg", "Error..!! Please fill all the mandatory fields");
				e.printStackTrace();
			}
			
			HttpSession session = request.getSession();
			modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
			modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
			
			return modelAndView;

		}

	

	/**
	 * This method is used to retrieve the termination details of selected
	 * employee
	 **/

	@RequestMapping(value = "/employeeTerminationDetails")
	public ModelAndView employeeTerminationDetails(HttpServletRequest request, HttpServletResponse respon)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		Class<?> ref = Class.forName("com.nic.upjn.spring.dto.ServiceStatusDTO");
		ServiceStatusDTO serviceStatusDTO = (ServiceStatusDTO) ref.newInstance();
		ModelAndView modelAndView = new ModelAndView("addEmployeeTerminationDetails");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		String rmID = Integer.toString(rmOfficeid);

		System.out.println(rmOfficeid);

		List<ViewTerminationdetaillist> list1 = (List<ViewTerminationdetaillist>) serviceStatusService
				.getList(rmOfficeid, "ViewTerminationdetaillist.findByRmOfficeid");
		for (ViewTerminationdetaillist viewTerminationdetaillist : list1) {
			BeanUtils.copyProperties(viewTerminationdetaillist, serviceStatusDTO);

		}
		modelAndView.addObject("list", list1);
		
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/**
	 * This method is used to populate the details of employee for editing the
	 * Termination details
	 **/
	@RequestMapping("/editTerminationdetails")
	public ModelAndView editTerminationdetails(@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("editEmployeeTerminationDetails");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		String rmID = Integer.toString(rmOfficeid);
	
		String ppTerminationdetailid = request.getParameter("ppTerminationdetailid");
		String employeecode = request.getParameter("employeecode");

		try{
			List<ViewTerminationdetaillist> empinfo = (List<ViewTerminationdetaillist>) serviceStatusService
					.getList(ppTerminationdetailid, "ViewTerminationdetaillist.findByPpTerminationdetailid");
			
			target.addObject("terminationEmployeeInfoList",empinfo);
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		List<ViewTerminationdetaillist> list1 = (List<ViewTerminationdetaillist>) serviceStatusService
				.getList(rmOfficeid, "ViewTerminationdetaillist.findByRmOfficeid");
		
		target.addObject("list", list1);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}
	
	@RequestMapping("/deleteTerminationdetails")
	public ModelAndView deleteTerminationdetails(@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("addEmployeeTerminationDetails");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		String rmID = Integer.toString(rmOfficeid);
	
		String ppTerminationdetailid = request.getParameter("ppTerminationdetailid");
		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");

		try{
			
		boolean result = serviceStatusService.deleteterminationdetails(ppTerminationdetailid,ppEmployeemasterid);
			if(result==true){
				target.addObject("app_msg","Employee Deleted Successfully");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		List<ViewTerminationdetaillist> list1 = (List<ViewTerminationdetaillist>) serviceStatusService
				.getList(rmOfficeid, "ViewTerminationdetaillist.findByRmOfficeid");
		
		target.addObject("list", list1);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}


	/**
	 * The method is used to Search Employee Termination details with
	 * designation and category list
	 **/
	@RequestMapping(value = "/terminationEmployeeSearch")
	public ModelAndView terminationEmployeeSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<PpDesignationmaster> list = null;
		List<MasEmploymentsubtype> list1 = null;

		try {
			Class<?> ref = Class.forName("com.nic.upjn.spring.dto.ServiceStatusDTO");
			ServiceStatusDTO serviceStatusDTO = (ServiceStatusDTO) ref.newInstance();

			list1 = (List<MasEmploymentsubtype>) serviceStatusService.getList(null, "MasEmploymentsubtype.findAll");
			for (MasEmploymentsubtype MasEmploymentsubtype : list1) {
				BeanUtils.copyProperties(MasEmploymentsubtype, serviceStatusDTO);
			}

			list = (List<PpDesignationmaster>) serviceStatusService.getList(null, "PpDesignationmaster.findAll");
			for (PpDesignationmaster PpDesignationmaster : list) {
				BeanUtils.copyProperties(PpDesignationmaster, serviceStatusDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("terminationEmployeeSearch");
		modelAndView.addObject("designationlist", list);
		modelAndView.addObject("categorylist", list1);
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** Search The Termination Employee on the basis of conditions **/
	@RequestMapping(value = "/terminationEmployeeSearchByCondtion")
	public ModelAndView terminationEmployeeSearchByCondtion(
			@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String SQL;
		ModelAndView target = new ModelAndView("terminationEmployeeSearchList");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		List<ViewEmployeeSearch> list = null;
		String ppDesignationmasterid = "" + serviceStatusDTO.getPpDesignationmasterid();
		String masEmploymentsubtypeid = "" + serviceStatusDTO.getMasEmploymentsubtypeid();
		String employeecode = "" + serviceStatusDTO.getEmployeecode();
		String firstname = serviceStatusDTO.getFirstname();
		String lastname = serviceStatusDTO.getLastname();
		if (employeecode.equals("") && firstname.equals("") && lastname.equals("")
				&& masEmploymentsubtypeid.equals("-1") && ppDesignationmasterid.equals("-1")) {

			list = (List<ViewEmployeeSearch>) serviceStatusService.getList(rmOfficeid, "ViewEmployeeSearch.findByRmOfficeid");

			for (ViewEmployeeSearch viewEmployeeSearch : list) {
				serviceStatusDTO.setEmployeecode(viewEmployeeSearch.getEmployeecode());
				serviceStatusDTO.setDesignation(viewEmployeeSearch.getDesignation());
				serviceStatusDTO.setEmployeename(viewEmployeeSearch.getEmployeename());
				serviceStatusDTO.setEmploymenttype(viewEmployeeSearch.getEmploymenttype());
				serviceStatusDTO.setEmploymentsubtype(viewEmployeeSearch.getEmploymentsubtype());
			}
		}

		else {

			serviceStatusDTO.setEmployeecode(employeecode);
			serviceStatusDTO.setFirstname(firstname);
			serviceStatusDTO.setLastname(lastname);
			serviceStatusDTO.setMasEmploymentsubtypeid(masEmploymentsubtypeid);
			serviceStatusDTO.setPpDesignationmasterid(Integer.parseInt(ppDesignationmasterid));
			String predicate = " PP_DEPUTATIONDETAILID IS NULL AND "
					+ "PP_EXITDETAILID IS NULL and pp_EmployeeMasterID not in (select pp_EmployeeMasterID from pp_TerminationDetail where isReinState = '0')";
			SQL = serviceStatusService.createSearchSQL(predicate, serviceStatusDTO, rmOfficeid);
			list = (List<ViewEmployeeSearch>) serviceStatusService.suspensionEmployeeSearchList(SQL);
		}

		target.addObject("list", list);
		target.addObject("employeecode", employeecode);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}

	/**
	 * Populated Employee TerminationDetails on the basis of EmployeeCode and
	 * also get the Termination Details list on the basis of RmOfficeID
	 **/
	@RequestMapping(value = "/populateemployeeTerminationDetails")
	public ModelAndView populateEmployeeTerminationDetails(
			@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String root = "termDetail";
		List<ViewEmployeeSearch> terminationEmployeeInfoList = null;
		String employeeInfo[];

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		try {
			/*
			 * Class<?> ref =
			 * Class.forName("com.nic.upjn.spring.dto.ServiceStatusDTO");
			 * serviceStatusDTO = (ServiceStatusDTO) ref.newInstance();
			 */

			String employeecode = serviceStatusDTO.getEmployeecode();
			if (employeecode.equals("")) {
				employeecode = request.getParameter("employee");
			}
			System.out.println(employeecode);
			employeeInfo = serviceStatusService.ProcPpValidateEmpGetInfo(employeecode, rmOfficeid + "", root, "add");

			if (employeeInfo != null) {
				terminationEmployeeInfoList = (List<ViewEmployeeSearch>) serviceStatusService.getList(employeecode,
						"ViewEmployeeSearch.findByEmployeecode");

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		List<ViewTerminationdetaillist> list1 = (List<ViewTerminationdetaillist>) serviceStatusService
				.getList(rmOfficeid, "ViewTerminationdetaillist.findByRmOfficeid");

		ModelAndView modelAndView = new ModelAndView("addEmployeeTerminationDetails");
		modelAndView.addObject("list", list1);

		String test = null;
		System.out.println(terminationEmployeeInfoList.size()
				+ "@@@@@@@@@@@@@@@@@@@@^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^#############");
		modelAndView.addObject("terminationEmployeeInfoList", terminationEmployeeInfoList);
		modelAndView.addObject("test",test);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/**
	 * Save and Edit Employee Termination record list on the basis of
	 * Termination detail id
	 **/
	@RequestMapping(value = "/EmployeeTermination", params = "saveTerminationRecord", method = RequestMethod.POST)
	public ModelAndView saveRecordOfEmployeeForTermination(
			@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		{
			List<ViewEmployeeSearch> suspentionTerminationInfoList = null;
			String PP_EmployeeMasterID_in = request.getParameter("ppEmployeemasterid");
			System.out.print(PP_EmployeeMasterID_in);
			int result = 0;
			ModelAndView modelAndView = new ModelAndView("addEmployeeTerminationDetails");
			
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			if (serviceStatusDTO.getEmployeecode() != null) {
				suspentionTerminationInfoList = (List<ViewEmployeeSearch>) serviceStatusService
						.getList(serviceStatusDTO.getEmployeecode(), "ViewEmployeeSearch.findByEmployeecode");
				for (ViewEmployeeSearch viewEmployeeSearch : suspentionTerminationInfoList) {
					serviceStatusDTO.setPpEmployeemasterid(viewEmployeeSearch.getPpEmployeemasterid() + "");

				}
			}

			serviceStatusDTO.setEventofficeid("" + rmOfficeid);
			
			if(serviceStatusDTO.getPpTerminationdetailid()==null){
			 result = serviceStatusService.executeProcedureForAddTerminationDetail(serviceStatusDTO);
			if (result == 1) {
				modelAndView.addObject("app_msg", "Process completed successfully");
			}
		}
			if(serviceStatusDTO.getPpTerminationdetailid()!=null){
				PpTerminationdetail ppTerminationdetail = new PpTerminationdetail();
				BeanUtils.copyProperties(serviceStatusDTO, ppTerminationdetail);
				ppTerminationdetail.setEffectivedate(comboService.getFormatedDate(serviceStatusDTO.getEffectivedate()));
				ppTerminationdetail.setTerminationorddate(comboService.getFormatedDate(serviceStatusDTO.getTerminationorddate()));
				ppTerminationdetail.setIsreinstate("0");
				ppTerminationdetail.setPpEmployeemasterid(Long.parseLong(serviceStatusDTO.getPpEmployeemasterid()));
				
				System.out.println(ppTerminationdetail.getEffectivedate()+" Inside edit termination "+ppTerminationdetail.getTerminationorddate());
				boolean iscomplete = serviceStatusService.updateterminationdetails(ppTerminationdetail);
				if (iscomplete == true) {
					modelAndView.addObject("app_msg", "Process completed successfully");
				}
			}
			List<ViewTerminationdetaillist> list1 = (List<ViewTerminationdetaillist>) serviceStatusService
					.getList(rmOfficeid, "ViewTerminationdetaillist.findByRmOfficeid");
			
			modelAndView.addObject("list", list1);

			modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
			modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
			
			return modelAndView;
		}
	}

	/**
	 * Get the ReinstateSuspentionList from ViewEmplistforreinsSusp on the basis
	 * of RmOfficeID
	 **/
	@RequestMapping(value = "/reinstateSuspentionEmpList")
	public ModelAndView reinstateSuspentionEmpList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		List<ViewEmplistforreinsSusp> list1 = (List<ViewEmplistforreinsSusp>) serviceStatusService.getList(rmOfficeid,
				"ViewEmplistforreinsSusp.findByRmOfficeid");
		ModelAndView modelAndView = new ModelAndView("reinstateSuspentionEmpList");
		modelAndView.addObject("list", list1);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;
	}

	/**
	 * populate ReinstateSuspDetails on the basis of ppSuspensiondetailid and
	 * populating the District and OfficveLevel Combo
	 **/
	@RequestMapping("/populateReinstateSuspDetails")
	public ModelAndView addSuspentionReinstateRecord(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ppSuspensiondetailid = request.getParameter("ppSuspensiondetailid");
		String ppEmployeemasterid  = null;

		System.out.println("jgdbhmx ");
		ServiceStatusDTO serviceStatusDTO;
		List<ViewEmpinfoforreinsSusp> list = null;
		ModelAndView modelAndView = new ModelAndView("addReinstateSuspentionDetails");

		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
		HashMap<String, String> hm2 = new HashMap<String, String>();
		HashMap<Integer, String> hm3 = new HashMap<Integer, String>();
		HashMap<String, String> hmap = new HashMap<String, String>();
		
		int rmofficeid = 0;
		String districtid = null;
		String Officelevel = null;

		try {
			Class<?> ref = Class.forName("com.nic.upjn.spring.dto.ServiceStatusDTO");
			serviceStatusDTO = (ServiceStatusDTO) ref.newInstance();

			list = (List<ViewEmpinfoforreinsSusp>) serviceStatusService.getList(ppSuspensiondetailid,
					"ViewEmpinfoforreinsSusp.findByPpSuspensiondetailid");
			for (ViewEmpinfoforreinsSusp viewEmpinfoforreinsSusp : list) {
				serviceStatusDTO.setPpEmployeemasterid(viewEmpinfoforreinsSusp.getPpEmployeemasterid() + "");
				
				ppEmployeemasterid = serviceStatusDTO.getPpEmployeemasterid();
				
				modelAndView.addObject("PpEmployeemasterid", serviceStatusDTO.getPpEmployeemasterid());
				System.out.println(serviceStatusDTO.getPpEmployeemasterid() + "DEDTRDCDCDCHGJVVH");
			}
			
			System.out.println(list.size() + "----- value of ppEmployeemasterid-----"+ppEmployeemasterid);
			
			List<ViewEmplistforreinsSusp> lis = (List<ViewEmplistforreinsSusp>) serviceStatusService.getList(ppEmployeemasterid,
					"ViewEmplistforreinsSusp.findByPpEmployeemasterid");
			for(ViewEmplistforreinsSusp viewEmplistforreinsSusp : lis){
				rmofficeid = viewEmplistforreinsSusp.getRmOfficeid();
				modelAndView.addObject("rmofficeid",rmofficeid);
			}
			
			hm = comboService.officeAndDistrict(serviceStatusService);
			request.setAttribute("str", "hello");
			List<MasDistrict> list2 = (List<MasDistrict>) serviceStatusService.getList(null, "MasDistrict.findAll");
			for (MasDistrict masDistrict : list2) {
				hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());
			}
			
			List<RmOffice> list3 = (List<RmOffice>) serviceStatusService.getList(rmofficeid, "RmOffice.findByRmOfficeid");
			for (RmOffice rmOffice : list3) {
				 districtid = rmOffice.getMas_districtid();
				 modelAndView.addObject("districtid", districtid);
			}
			
			List<RmOffice> list4 = (List<RmOffice>) serviceStatusService.getList(rmofficeid, "RmOffice.findByRmOfficeid");
			for (RmOffice rmOffice : list4) {
				 Officelevel = rmOffice.getMas_officelevelid();
				 modelAndView.addObject("Officelevelid", Officelevel);
			}
			int[] where_condtion = new int[] { Integer.parseInt(Officelevel), Integer.parseInt(districtid)};
			hmap = comboService.office(where_condtion, serviceStatusService);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		modelAndView.addObject("list", list);
		modelAndView.addObject("Data", hm);
		modelAndView.addObject("officename", hmap);
		modelAndView.addObject("Data1", hm1);
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	/**
	 * called the ProcedureForReinstateSuspentionDetails for save
	 * RecordofReinstateEmployeeSuspention
	 **/
	@RequestMapping(value = "/saveRecordofReinstateEmployeeSuspension")
	public ModelAndView saveRecordofReinstateEmployeeSuspention(
			@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO, HttpServletRequest request,
			HttpServletResponse response) {
		
		ModelAndView modelAndView = null;

		try{
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		List<ViewEmpinfoforreinsSusp> reinstaeSuspentionInfoList = null;

		String PpEmployeemasterid = request.getParameter("PpEmployeemasterid");

		if (PpEmployeemasterid != null) {
			reinstaeSuspentionInfoList = (List<ViewEmpinfoforreinsSusp>) serviceStatusService
					.getList(PpEmployeemasterid, "ViewEmpinfoforreinsSusp.findByPpEmployeemasterid");
			for (ViewEmpinfoforreinsSusp viewEmpinfoforreinsSusp : reinstaeSuspentionInfoList) {
				BeanUtils.copyProperties(viewEmpinfoforreinsSusp, serviceStatusDTO);
				serviceStatusDTO.setPpEmployeemasterid(viewEmpinfoforreinsSusp.getPpEmployeemasterid() + "");

			}
		}
		serviceStatusDTO.setEventofficeid(rmOfficeid + "");
		int result = serviceStatusService.executeProcedureForReinstateSuspentionDetails(serviceStatusDTO);

		if (result == 1) {
			List<ViewEmplistforreinsSusp> list1 = (List<ViewEmplistforreinsSusp>) serviceStatusService.getList(rmOfficeid,
					"ViewEmplistforreinsSusp.findByRmOfficeid");
		  
			modelAndView.addObject("list", list1);
            modelAndView.addObject("msg","Process Completed Successfully");
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** Simply redirect relieve for DEPUTATION page with DEPUTATION List **/
	@RequestMapping(value = "/relievefordeputation")
	public ModelAndView relieveForDeputation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView modelAndView = new ModelAndView("relievefordeputation");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		List<ViewDeputationlist> Deputationlist = (List<ViewDeputationlist>) serviceStatusService.getList(rmOfficeid,
				"ViewDeputationlist.findByRmOfficeid");
		modelAndView.addObject("list", Deputationlist);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/**
	 * Search The Relieve ForDeputation Employee on the basis of conditions with
	 * Designation-list and categoryList
	 **/
	@RequestMapping(value = "/relieveForDeputationEmployeeSearch")
	public ModelAndView relieveForDeputationEmployeeSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<PpDesignationmaster> list = null;
		List<MasEmploymentsubtype> list1 = null;

		try {
			Class<?> ref = Class.forName("com.nic.upjn.spring.dto.ServiceStatusDTO");
			ServiceStatusDTO serviceStatusDTO = (ServiceStatusDTO) ref.newInstance();

			list1 = (List<MasEmploymentsubtype>) serviceStatusService.getList(null, "MasEmploymentsubtype.findAll");
			for (MasEmploymentsubtype MasEmploymentsubtype : list1) {
				BeanUtils.copyProperties(MasEmploymentsubtype, serviceStatusDTO);
			}

			list = (List<PpDesignationmaster>) serviceStatusService.getList(null, "PpDesignationmaster.findAll");
			for (PpDesignationmaster PpDesignationmaster : list) {
				BeanUtils.copyProperties(PpDesignationmaster, serviceStatusDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("relieveForDeputationEmployeeSearch");
		modelAndView.addObject("designationlist", list);
		modelAndView.addObject("categorylist", list1);
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** Search The DeputationEmploye on the basis of conditions **/
	@RequestMapping(value = "/relieveDeputationEmployeeSearchByCondtion")
	public ModelAndView relieveDeputationEmployeeSearchByCondtion(
			@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String SQL;
		ModelAndView target = new ModelAndView("deputationEmployeeSearchList");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		List<ViewEmployeeSearch> list = null;
		String ppDesignationmasterid = "" + serviceStatusDTO.getPpDesignationmasterid();
		String masEmploymentsubtypeid = "" + serviceStatusDTO.getMasEmploymentsubtypeid();
		String employeecode = "" + serviceStatusDTO.getEmployeecode();
		String firstname = serviceStatusDTO.getFirstname();
		String lastname = serviceStatusDTO.getLastname();
		if (employeecode.equals("") && firstname.equals("") && lastname.equals("")
				&& masEmploymentsubtypeid.equals("-1") && ppDesignationmasterid.equals("-1")) {

			list = (List<ViewEmployeeSearch>) serviceStatusService.getList(rmOfficeid, "ViewEmployeeSearch.findByRmOfficeid");

			for (ViewEmployeeSearch viewEmployeeSearch : list) {
				serviceStatusDTO.setEmployeecode(viewEmployeeSearch.getEmployeecode());
				serviceStatusDTO.setDesignation(viewEmployeeSearch.getDesignation());
				serviceStatusDTO.setEmployeename(viewEmployeeSearch.getEmployeename());
				serviceStatusDTO.setEmploymenttype(viewEmployeeSearch.getEmploymenttype());
				serviceStatusDTO.setEmploymentsubtype(viewEmployeeSearch.getEmploymentsubtype());
			}
		}

		else {

			serviceStatusDTO.setEmployeecode(employeecode);
			serviceStatusDTO.setFirstname(firstname);
			serviceStatusDTO.setLastname(lastname);
			serviceStatusDTO.setMasEmploymentsubtypeid(masEmploymentsubtypeid);
			serviceStatusDTO.setPpDesignationmasterid(Integer.parseInt(ppDesignationmasterid));
			String predicate = " ISFUNCTIONING = '1'";
			SQL = serviceStatusService.createSearchSQL(predicate, serviceStatusDTO, rmOfficeid);
			list = (List<ViewEmployeeSearch>) serviceStatusService.suspensionEmployeeSearchList(SQL);
		}

		target.addObject("list", list);
		target.addObject("employeecode", employeecode);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}

	/**
	 * populate RelieveDeputationDetails on the basis of EmployeeCode and Get
	 * the View_Deputation-list on the basis of rmofficeID
	 **/
	@RequestMapping("/populateemployeeRelieveDeputationDetails")
	public ModelAndView populateEmployeeRelieveDeputationDetails(
			@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("jgdbhmx ");
		String root = "relForDep";
		List<ViewEmployeeSearch> deputationInfo = null;
		ModelAndView modelAndView = new ModelAndView("relievefordeputation");

		String employeeInfo[];

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		try {
			/*
			 * Class<?> ref =
			 * Class.forName("com.nic.upjn.spring.dto.ServiceStatusDTO");
			 * serviceStatusDTO = (ServiceStatusDTO) ref.newInstance();
			 */

			String employeecode = serviceStatusDTO.getEmployeecode();
			if (employeecode.equals("")) {
				employeecode = request.getParameter("employee");
			}
			System.out.println(employeecode);
			employeeInfo = serviceStatusService.ProcPpValidateEmpGetInfo(employeecode, rmOfficeid + "", root, "add");

			if (employeeInfo != null) {
				List<ViewDeputationlist> Deputationlist = (List<ViewDeputationlist>) serviceStatusService
						.getList(rmOfficeid, "ViewDeputationlist.findByRmOfficeid");
				modelAndView.addObject("list", Deputationlist);

				deputationInfo = (List<ViewEmployeeSearch>) serviceStatusService.getList(employeecode,
						"ViewEmployeeSearch.findByEmployeecode");
				modelAndView.addObject("deputationInfo", deputationInfo);

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/**
	 * Save and Update the Relive-DEPUTATION-Record on the basis of
	 * Pp_DeputationDetailsId and also get The Relieve DeputationList
	 **/
	@RequestMapping("/savereliveDeputationRecord")
	public ModelAndView savereliveDeputationRecord(
			@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelAndView modelAndView = new ModelAndView("relievefordeputation");
		List<ViewEmployeeSearch> deputationEmployeeInfoList;
		String Pp_DeputationDetailsId;
		Long Id = null;

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		if (serviceStatusDTO.getEmployeecode() != null) {
			deputationEmployeeInfoList = (List<ViewEmployeeSearch>) serviceStatusService
					.getList(serviceStatusDTO.getEmployeecode(), "ViewEmployeeSearch.findByEmployeecode");
			for (ViewEmployeeSearch viewEmployeeSearch : deputationEmployeeInfoList) {
				serviceStatusDTO.setPpEmployeemasterid(viewEmployeeSearch.getPpEmployeemasterid() + "");
			}
		}
		List<ViewDeputationlist> list = (List<ViewDeputationlist>) serviceStatusService
				.getList(serviceStatusDTO.getEmployeecode(), "ViewDeputationlist.findByEmployeecode");
		

		for (ViewDeputationlist viewDeputationlist : list) {
			Pp_DeputationDetailsId = viewDeputationlist.getPpDeputationdetailid() +"";
			serviceStatusDTO.setPpEmployeemasterid(viewDeputationlist.getPpEmployeemasterid() + "");
			BeanUtils.copyProperties(serviceStatusDTO, viewDeputationlist);
			viewDeputationlist.setDeputationorderdate(comboService.getFormatedDate(serviceStatusDTO.getDeputationorderdate()));
			viewDeputationlist.setRelievedate(comboService.getFormatedDate(serviceStatusDTO.getRelievedate()));
			viewDeputationlist.setRelieveorderdate(comboService.getFormatedDate(serviceStatusDTO.getRelieveorderdate()));
			

			viewDeputationlist.setPpDeputationdetailid(Long.parseLong(Pp_DeputationDetailsId));
			Id = viewDeputationlist.getPpDeputationdetailid();
			if (Id != null) {
				serviceStatusService.updatereliveDeputationRecord(viewDeputationlist);
			}

		}

		serviceStatusDTO.setEventofficeid(rmOfficeid + "");
		serviceStatusDTO.setOfficefromid(rmOfficeid + "");

		if (Id == null) {
			int result = serviceStatusService.executeProcedureForAddDeputationDetail(serviceStatusDTO);

		}
		List<ViewDeputationlist> Deputationlist = (List<ViewDeputationlist>) serviceStatusService.getList(rmOfficeid,
				"ViewDeputationlist.findByRmOfficeid");
		modelAndView.addObject("list", Deputationlist);
		modelAndView.addObject("app_msg", "Process completed successfully");

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;
	}

	
	
	@RequestMapping("/deleteDeputationDetails")
	public ModelAndView deleteDeputationDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView modelAndView = new ModelAndView("relievefordeputation");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		String ppNoduesdetailid = request.getParameter("ppNoduesdetailid");
		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		String ppDeputationdetailid = request.getParameter("ppDeputationdetailid");
		
		try{
			 boolean result = serviceStatusService.execProc_Dele_Deputation(ppDeputationdetailid,ppEmployeemasterid,ppNoduesdetailid);
			 if(result==true){
				 modelAndView.addObject("app_msg", "Process completed successfully");
			 }
			 List<ViewDeputationlist> Deputationlist = (List<ViewDeputationlist>) serviceStatusService.getList(rmOfficeid,
						"ViewDeputationlist.findByRmOfficeid");
				modelAndView.addObject("list", Deputationlist);
		}
		catch(Exception e){
		      e.printStackTrace();
		}

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}
	
	
	/**
	 * Get the EmplistResumeAfterdep and redirect resumeAfterDeputation Page
	 **/
	@RequestMapping("/resumeAfterDeuptation")
	public ModelAndView resumeAfterDeuptation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView modelAndView = new ModelAndView("resumeAfterDeputation");
		List<ViewEmplistResumeafterdep> resumeAfterDeputationList = (List<ViewEmplistResumeafterdep>) serviceStatusService
				.getList(null, "ViewEmplistResumeafterdep.findAll");
		modelAndView.addObject("list", resumeAfterDeputationList);
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/**
	 * populateResumeAfterDeuptatio Page on the basis of ppDeputationdetailid
	 **/
	@RequestMapping("/populateResumeAfterDeuptation")
	public ModelAndView populateResumeAfterDeuptation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ppDeputationdetailid = request.getParameter("ppDeputationdetailid");

		ModelAndView modelAndView = new ModelAndView("resumeAfterDeputationPage");

		List<ViewEmplistResumeafterdep> resumeAfterDeputationEmpInfo = (List<ViewEmplistResumeafterdep>) serviceStatusService
				.getList(ppDeputationdetailid, "ViewEmplistResumeafterdep.findByPpDeputationdetailid");
		for (ViewEmplistResumeafterdep viewEmplistResumeafterdep : resumeAfterDeputationEmpInfo) {
			modelAndView.addObject("ppEmployeemasterid", viewEmplistResumeafterdep.getPpEmployeemasterid());
		}

		modelAndView.addObject("list", resumeAfterDeputationEmpInfo);
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** Save ResumeAfter DeputationRecord on the Basis ppEmployeemasterid **/
	@RequestMapping("/saveResumeAfterDeputationRecord")
	public ModelAndView saveResumeAfterDeputationRecord(
			@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		ModelAndView modelAndView = new ModelAndView("resumeAfterDeputationPage");

		if (ppEmployeemasterid != null) {
			List<ViewEmplistResumeafterdep> resumeAfterDeputationEmpInfo = (List<ViewEmplistResumeafterdep>) serviceStatusService
					.getList(ppEmployeemasterid, "ViewEmplistResumeafterdep.findByPpEmployeemasterid");
			for (ViewEmplistResumeafterdep viewEmplistResumeafterdep : resumeAfterDeputationEmpInfo) {
				serviceStatusDTO.setPpDeputationdetailid(viewEmplistResumeafterdep.getPpDeputationdetailid() + "");

			}
		}

		int result = serviceStatusService.executeProcedureForAddResumeAfterDeputationRecord(serviceStatusDTO);
		if (result == 1) {
			modelAndView.addObject("app_msg", "Process completed successfully");
		}

		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** simply redirect relieveFromService page **/
	@RequestMapping("/relieveFromService")
	public ModelAndView relieveFromService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ModelAndView modelAndView = new ModelAndView("relieveFromService");
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/**
	 * simply redirect relieveServiceSearch with DROPDOWNS designation-list and
	 * Category-List
	 **/

	@RequestMapping("/relieveFromServiceEmployeeSearch")
	public ModelAndView relieveFromServiceEmployeeSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<PpDesignationmaster> list = null;
		List<MasEmploymentsubtype> list1 = null;

		try {
			Class<?> ref = Class.forName("com.nic.upjn.spring.dto.ServiceStatusDTO");
			ServiceStatusDTO serviceStatusDTO = (ServiceStatusDTO) ref.newInstance();

			list1 = (List<MasEmploymentsubtype>) serviceStatusService.getList(null, "MasEmploymentsubtype.findAll");
			for (MasEmploymentsubtype MasEmploymentsubtype : list1) {
				BeanUtils.copyProperties(MasEmploymentsubtype, serviceStatusDTO);
			}

			list = (List<PpDesignationmaster>) serviceStatusService.getList(null, "PpDesignationmaster.findAll");
			for (PpDesignationmaster PpDesignationmaster : list) {
				BeanUtils.copyProperties(PpDesignationmaster, serviceStatusDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("relieveServiceSearch");
		modelAndView.addObject("designationlist", list);
		modelAndView.addObject("categorylist", list1);
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** Search The RelieveFrom ServiceEmployee on the basis of conditions **/
	@RequestMapping("/relieveFromServiceEmployeeSearchByCondtion")
	public ModelAndView relieveFromServiceEmployeeSearchByCondtion(
			@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String SQL;
		ModelAndView target = new ModelAndView("relieveFromServiceEmployeeSearchList");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		List<ViewEmployeeSearch> list = null;
		String ppDesignationmasterid = "" + serviceStatusDTO.getPpDesignationmasterid();
		String masEmploymentsubtypeid = "" + serviceStatusDTO.getMasEmploymentsubtypeid();
		String employeecode = "" + serviceStatusDTO.getEmployeecode();
		String firstname = serviceStatusDTO.getFirstname();
		String lastname = serviceStatusDTO.getLastname();
		if (employeecode.equals("") && firstname.equals("") && lastname.equals("")
				&& masEmploymentsubtypeid.equals("-1") && ppDesignationmasterid.equals("-1")) {

			list = (List<ViewEmployeeSearch>) serviceStatusService.getList(rmOfficeid, "ViewEmployeeSearch.findByRmOfficeid");

			for (ViewEmployeeSearch viewEmployeeSearch : list) {
				serviceStatusDTO.setEmployeecode(viewEmployeeSearch.getEmployeecode());
				serviceStatusDTO.setDesignation(viewEmployeeSearch.getDesignation());
				serviceStatusDTO.setEmployeename(viewEmployeeSearch.getEmployeename());
				serviceStatusDTO.setEmploymenttype(viewEmployeeSearch.getEmploymenttype());
				serviceStatusDTO.setEmploymentsubtype(viewEmployeeSearch.getEmploymentsubtype());
			}
		}

		else {

			serviceStatusDTO.setEmployeecode(employeecode);
			serviceStatusDTO.setFirstname(firstname);
			serviceStatusDTO.setLastname(lastname);
			serviceStatusDTO.setMasEmploymentsubtypeid(masEmploymentsubtypeid);
			serviceStatusDTO.setPpDesignationmasterid(Integer.parseInt(ppDesignationmasterid));
			String predicate = " ISFUNCTIONING='1'";
			SQL = serviceStatusService.createSearchSQL(predicate, serviceStatusDTO, rmOfficeid);
			list = (List<ViewEmployeeSearch>) serviceStatusService.suspensionEmployeeSearchList(SQL);
		}

		target.addObject("list", list);
		target.addObject("employeecode", employeecode);
		
		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;

	}

	/** populateRelieveFromService Page **/

	@RequestMapping("/populateRelieveFromServiceEmployee")
	public ModelAndView populateRelieveFromServiceEmployee(
			@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HashMap<String, String> hm = new HashMap<String, String>();
		String employeecode;
		String[] employeeInfo = null;

		ModelAndView modelAndView = new ModelAndView("relieveFromService");
		String root = "relServ";

		employeecode = serviceStatusDTO.getEmployeecode();
		if (employeecode.equals("")) {
			employeecode = request.getParameter("employee");
		}
		System.out.println(employeecode + "--- I am employee code of relieve from service");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		if (employeecode != null) {
			employeeInfo = serviceStatusService.ProcPpValidateEmpGetInfo(employeecode, rmOfficeid + "", root, "add");
			for (int i = 0; i < employeeInfo.length; i++) {
				System.out.println(employeeInfo[i]);
			}
		}

		try {
			Class<?> ref = Class.forName("com.nic.upjn.spring.dto.ServiceStatusDTO");
			serviceStatusDTO = (ServiceStatusDTO) ref.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<ViewRmGettopinfo> viewRelievefromservicelist = (List<ViewRmGettopinfo>) serviceStatusService
				.getList(employeecode, "ViewRmGettopinfo.findByEmployeecode");
		List<ViewEmployeeSearch> view_EmpSerachInfo = (List<ViewEmployeeSearch>) serviceStatusService
				.getList(employeecode, "ViewEmployeeSearch.findByEmployeecode");
		for (ViewEmployeeSearch viewEmployeeSearch : view_EmpSerachInfo) {
			serviceStatusDTO.setPpEmployeemasterid(viewEmployeeSearch.getPpEmployeemasterid() + "");
		}

		List<SysSubservicephasemaster> casuseOfRelieve = (List<SysSubservicephasemaster>) serviceStatusService
				.getList("Exit", "SysSubservicephasemaster.findByServicephasename");
		for (SysSubservicephasemaster sysSubservicephasemaster : casuseOfRelieve) {
			hm.put(sysSubservicephasemaster.getSysSubservicephasemasterid() + "",
					sysSubservicephasemaster.getSubphasename());

		}

		modelAndView.addObject("list", viewRelievefromservicelist);
		modelAndView.addObject("Data", hm);
		if (employeeInfo[2] == null) {
			modelAndView.addObject("PpEmployeemasterid", serviceStatusDTO.getPpEmployeemasterid());

		} else {
			modelAndView.addObject("PpEmployeemasterid", employeeInfo[2]);
		}
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** Save RelieveFromService Record on the Basis ppEmployeemasterid **/
	@RequestMapping("/addRelieveFromServiceRecord")
	public ModelAndView addRelieveFromServiceRecord(
			@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String PpEmployeemasterid = request.getParameter("PpEmployeemasterid");

		ModelAndView modelAndView = new ModelAndView("relieveFromService");

		if (PpEmployeemasterid != null) {
			List<ViewGetempnoduesdetail> relieveEmpInfo = (List<ViewGetempnoduesdetail>) serviceStatusService
					.getList(PpEmployeemasterid, "ViewGetempnoduesdetail.findByPpEmployeemasterid");
			for (ViewGetempnoduesdetail viewGetempnoduesdetail : relieveEmpInfo) {
				serviceStatusDTO.setPpNoduesdetailid(viewGetempnoduesdetail.getPpNoduesdetailid() + "");
			}
		}

		serviceStatusDTO.setPpEmployeemasterid(PpEmployeemasterid);
		int result = serviceStatusService.executeProcedureForaddRelieveFromService(serviceStatusDTO);
		if (result == 1) {
			modelAndView.addObject("app_msg", "Process completed successfully");
		}

		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** edit Suspension Details **/
	@RequestMapping("/editSuspentionDetails")
	public ModelAndView editSuspentionDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
		String ppSuspensiondetailid = request.getParameter("ppSuspensiondetailid");
		ModelAndView modelAndView = new ModelAndView("employeeSuspensionDetails");

		String employeeInfo[];
		List<ViewEmployeeSearch> suspentionEmployeeInfoList = new ArrayList<ViewEmployeeSearch>();
		ViewEmployeeSearch viewEmployeeSearch = new ViewEmployeeSearch();

		List<PpSuspensiondetail> detailslist = (List<PpSuspensiondetail>) serviceStatusService
				.getList(ppSuspensiondetailid, "PpSuspensiondetail.findByPpSuspensiondetailid");

		List<ViewSuspensiondetaillist> list1 = (List<ViewSuspensiondetaillist>) serviceStatusService
				.getList(ppSuspensiondetailid, "ViewSuspensiondetaillist.findByPpSuspensiondetailid");
		for (ViewSuspensiondetaillist viewSuspensiondetaillist : list1) {
			employeeInfo = serviceStatusService.ProcPpValidateEmpGetInfo(viewSuspensiondetaillist.getEmployeecode(),
					rmOfficeid + "", "suspDetail", "edit");
			viewEmployeeSearch.setEmployeecode(viewSuspensiondetaillist.getEmployeecode());
			viewEmployeeSearch.setEmployeename(viewSuspensiondetaillist.getEmployeename());
			viewEmployeeSearch.setDesignation(viewSuspensiondetaillist.getDesignation());
			suspentionEmployeeInfoList.add(viewEmployeeSearch);

		}
		List<ViewSuspensiondetaillist> list3 = (List<ViewSuspensiondetaillist>) serviceStatusService.getList(rmOfficeid,
				"ViewSuspensiondetaillist.findByRmOfficeid");

		hm = comboService.officeAndDistrict(serviceStatusService);
		request.setAttribute("str", "hello");
		List<MasDistrict> list2 = (List<MasDistrict>) serviceStatusService.getList(null, "MasDistrict.findAll");
		for (MasDistrict masDistrict : list2) {
			hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());

		}

		modelAndView.addObject("Data", hm);
		modelAndView.addObject("detailslist", detailslist);
		modelAndView.addObject("Data1", hm1);
		modelAndView.addObject("ppSuspensiondetailid", ppSuspensiondetailid);
		modelAndView.addObject("suspentionEmployeeInfo", list1);
		modelAndView.addObject("list", list3);
		modelAndView.addObject("suspentionEmployeeInfoList", suspentionEmployeeInfoList);

		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** Delete suspension details **/
	@RequestMapping("/deleteSuspentionDetails")
	public ModelAndView deleteSuspentionDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServiceStatusDTO serviceStatusDTO = null;
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();

		try {
			Class<?> ref = Class.forName("com.nic.upjn.spring.dto.ServiceStatusDTO");
			serviceStatusDTO = (ServiceStatusDTO) ref.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ppSuspensiondetailid = request.getParameter("ppSuspensiondetailid");

		List<ViewSuspensiondetaillist> list1 = (List<ViewSuspensiondetaillist>) serviceStatusService
				.getList(ppSuspensiondetailid, "ViewSuspensiondetaillist.findByPpSuspensiondetailid");
		for (ViewSuspensiondetaillist viewSuspensiondetaillist : list1) {
			serviceStatusDTO.setPpEmployeemasterid(viewSuspensiondetaillist.getPpEmployeemasterid() + "");
		}
		serviceStatusDTO.setPpSuspensiondetailid(Long.parseLong(ppSuspensiondetailid));

		int result = serviceStatusService.executeProcedureFordeleteSuspensionDetail(serviceStatusDTO);
		ModelAndView modelAndView = new ModelAndView("employeeSuspensionDetails");

		if (result == 1) {
			List<ViewSuspensiondetaillist> list3 = (List<ViewSuspensiondetaillist>) serviceStatusService
					.getList(rmOfficeid, "ViewSuspensiondetaillist.findByRmOfficeid");

			modelAndView.addObject("app_msg", "Deleted successfully");
			hm = comboService.officeAndDistrict(serviceStatusService);
			request.setAttribute("str", "hello");
			List<MasDistrict> list2 = (List<MasDistrict>) serviceStatusService.getList(null, "MasDistrict.findAll");
			for (MasDistrict masDistrict : list2) {
				hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());

			}
			modelAndView.addObject("Data", hm);
			modelAndView.addObject("Data1", hm1);
			modelAndView.addObject("list", list3);
		}
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** edit DepuatationDetails **/

	@RequestMapping("/editDepuatationDetails")
	public ModelAndView editDepuatationDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("jgdbhmx ");
		String root = "relForDep";
		ServiceStatusDTO serviceStatusDTO;
		List<ViewDeputationlist> deputationInfoList = null;
		ModelAndView modelAndView = new ModelAndView("relievefordeputation");
		String ppDeputationdetailid = request.getParameter("ppDeputationdetailid");

		List<ViewEmployeeSearch> deputationInfo = new ArrayList<ViewEmployeeSearch>();
		ViewEmployeeSearch viewEmployeeSearch = new ViewEmployeeSearch();

		String employeeInfo[];

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		try {
			Class<?> ref = Class.forName("com.nic.upjn.spring.dto.ServiceStatusDTO");
			serviceStatusDTO = (ServiceStatusDTO) ref.newInstance();

			String employeecode = request.getParameter("employee");
			System.out.println(employeecode);
			employeeInfo = serviceStatusService.ProcPpValidateEmpGetInfo(employeecode, rmOfficeid + "", "relForDep",
					"edit");

			if (employeeInfo != null) {
				List<ViewDeputationlist> Deputationlist = (List<ViewDeputationlist>) serviceStatusService
						.getList(rmOfficeid, "ViewDeputationlist.findByRmOfficeid");
				modelAndView.addObject("list", Deputationlist);

				deputationInfoList = (List<ViewDeputationlist>) serviceStatusService.getList(ppDeputationdetailid,
						"ViewDeputationlist.findByPpDeputationdetailid");
				for (ViewDeputationlist viewDeputationlist : deputationInfoList) {
					viewEmployeeSearch.setEmployeecode(viewDeputationlist.getEmployeecode());
					viewEmployeeSearch.setEmployeename(viewDeputationlist.getEmployeename());
					viewEmployeeSearch.setDesignation(viewDeputationlist.getDesignation());
					deputationInfo.add(viewEmployeeSearch);
				}
				modelAndView.addObject("deputationInfoList", deputationInfoList);
				modelAndView.addObject("deputationInfo", deputationInfo);

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** This method populate the list of employees for Re-Instate **/

	@RequestMapping("/reinstateEmployeeTerminationDetails")
	public ModelAndView reinstateEmployeeTerminationDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ModelAndView modelAndView = new ModelAndView("ReinstateTermination");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		List<ViewEmplistforreinsTerm> list = (List<ViewEmplistforreinsTerm>) serviceStatusService.getList(rmOfficeid,
				"ViewEmplistforreinsTerm.findByRmOfficeid");

		modelAndView.addObject("list", list);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;
	}

	/** This method populate the details of selected employee for Re-Instate **/

	@RequestMapping("/reinstateTerminationdetails")
	public ModelAndView reinstateTerminationdetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ModelAndView modelAndView = new ModelAndView("ReinstateTerminationDetails");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		String ppTerminationdetailid = request.getParameter("ppTerminationdetailid");

		List<ViewEmpinfoforreinsTerm> list = (List<ViewEmpinfoforreinsTerm>) serviceStatusService
				.getList(ppTerminationdetailid, "ViewEmpinfoforreinsTerm.findByPpTerminationdetailid");

		modelAndView.addObject("list", list);
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		return modelAndView;

	}

	/**
	 * This method populate the details of selected employee for Re-Instate
	 * 
	 * @throws ParseException
	 **/

	@RequestMapping("/ReinstateTermination")
	public ModelAndView ReinstateTermination(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("serviceStatusDTO") ServiceStatusDTO serviceStatusDTO)
					throws ServletException, IOException, ParseException {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		ModelAndView modelAndView = new ModelAndView("ReinstateTermination");

		try {
			PpTerminationdetail ppterminationdetail = new PpTerminationdetail();
			PpCurrentstatus ppCurrentstatus = new PpCurrentstatus();
			PpEmployeemaster ppEmployeemaster = new PpEmployeemaster();
			String str = request.getParameter("reinstateeffectdate");
			System.out.println("........................" + str);

			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			Date d = df.parse(serviceStatusDTO.getReinstateeffectdate());

			BeanUtils.copyProperties(serviceStatusDTO, ppterminationdetail);

			ppterminationdetail.setReinstateeffectdate(d);

			ppterminationdetail.setPpEmployeemasterid(Long.parseLong(serviceStatusDTO.getPpEmployeemasterid()));
			BeanUtils.copyProperties(serviceStatusDTO, ppCurrentstatus);
			ppCurrentstatus.setPpEmployeemasterid(Long.parseLong(serviceStatusDTO.getPpEmployeemasterid()));
			/* serviceStatusDTO.setIsfunctioning('1'); */
			BeanUtils.copyProperties(serviceStatusDTO, ppEmployeemaster);
			ppEmployeemaster.setPpEmployeemasterid(Long.parseLong(serviceStatusDTO.getPpEmployeemasterid()));

			System.out.println(ppterminationdetail.getPpEmployeemasterid() + "----"
					+ ppterminationdetail.getPpTerminationdetailid() + "---"
					+ ppterminationdetail.getReinstateeffectdate() + "---"
					+ ppterminationdetail.getReinstateorderdetail());

			boolean result = serviceStatusService.insertReinstateTermDetail(ppterminationdetail, ppCurrentstatus,
					ppEmployeemaster);

			if (result == true) {
				modelAndView.addObject("msg", "Employee Reinstated Successfully");
			} else {
				modelAndView.addObject("msg", "Error");
			}

			List<ViewEmplistforreinsTerm> list = (List<ViewEmplistforreinsTerm>) serviceStatusService
					.getList(rmOfficeid, "ViewEmplistforreinsTerm.findByRmOfficeid");

			modelAndView.addObject("list", list);
		} catch (Exception e) {
			modelAndView.addObject("msg", "Error");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		return modelAndView;

	}

}
