/******************************** SERVICEBOOK CONTROLLER **************************/

/* ==========================================================================
 * Description   : This class implements controller operations for ServiceBook of Employee.
 * Date			 :18/01/2016  
 * Author		 : RAM PRAKASH PANDEY
 * Review By 	 : 
 * Review Date	 :  
 *==========================================================================
 */

/** This is a controller class used for ServiceBook of Employee. 
 *  Controller class get's the request from JSP pages,
 *  based on the requirement , methods of service class are called  and finally response is send to the JSP pages.
 * **/

/** Package Name **/
package com.nic.upjn.spring.controller;

/**********************************LIBRARIES USED ********************************/
/** BeanUtils class copy the similar property of Bean class to another class  **/

/**AUTOWIRED Annotation : Used for creating the object of class without using new keyword 
 Controller Annotation : Used to make controller class of any defined simple class . This class is capable to initiate request and response between JSP and Controller 
 ModelAttribute Annotation : It automatically sets the values from JSP to DTO class.Variable name must be same in both JSP and DTO
 RequestMapping annotation : Used for mapping URL to the method of controller class  
 RequestMethod annotation : Used for identifying type of request generated from JSP  
 SessionStatus class : Represents current status of the Session 
 ModelAndView class: It is Responsible for setting views and objects required by JSP Pages 
 ServiceBookService Interface : It contains all abstract methods used for ServiceBook 
 EmployeeStatusDTO class : Contains the getter and setter of JSP variables 


 /** Imports required number of classes that are used in this particular class **/
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.rule.Mode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.miscellaneous.ComboService;
import com.nic.upjn.spring.Service.ServiceBookService;
import com.nic.upjn.spring.dto.EmployeeStatusDTO;
import com.nic.upjn.spring.entity.MasCaste;
import com.nic.upjn.spring.entity.MasEmploymentsubtype;
import com.nic.upjn.spring.entity.MasMaritalstatus;
import com.nic.upjn.spring.entity.MasReligion;
import com.nic.upjn.spring.entity.PpDesignationmaster;
import com.nic.upjn.spring.entity.PpEmployeedetail;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.PpEmployeequalification;
import com.nic.upjn.spring.entity.PpEmployeequalificationView;
import com.nic.upjn.spring.entity.PpEmployeetraining;
import com.nic.upjn.spring.entity.PpPermanencyView;
import com.nic.upjn.spring.entity.PpQualificationmaster;
import com.nic.upjn.spring.entity.PpTrainingtypemaster;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;
import com.nic.upjn.spring.entity.ViewPpEmployeePromotion;
import com.nic.upjn.spring.entity.ViewPpEmployeeconfirmation;
import com.nic.upjn.spring.entity.ViewPpEmployeepersonaldetail;
import com.nic.upjn.spring.entity.ViewPpEmployeetraining;

@SuppressWarnings({ "unchecked", "unused" })
@Controller
public class ServiceBookController {

	@Autowired
	private ServiceBookService serviceBookService;

	static ComboService comboService;
	String root = "suspDetail";

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
	 * This method is used to populate the search page with designation and
	 * category list
	 **/

	@RequestMapping(value = "/serviceBookEmployeeSearch")
	public ModelAndView suspensionEmployeeSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<PpDesignationmaster> list = null;
		List<MasEmploymentsubtype> list1 = null;

		try {
			Class<?> ref = Class.forName("com.nic.upjn.spring.dto.EmployeeStatusDTO");
			EmployeeStatusDTO employeeStatusDTO = (EmployeeStatusDTO) ref.newInstance();

			list1 = (List<MasEmploymentsubtype>) serviceBookService.getList(null, "MasEmploymentsubtype.findAll");
			for (MasEmploymentsubtype MasEmploymentsubtype : list1) {
				BeanUtils.copyProperties(MasEmploymentsubtype, employeeStatusDTO);
			}

			list = (List<PpDesignationmaster>) serviceBookService.getList(null, "PpDesignationmaster.findAll");
			for (PpDesignationmaster PpDesignationmaster : list) {
				BeanUtils.copyProperties(PpDesignationmaster, employeeStatusDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("serviceBookSerach");
		modelAndView.addObject("designationlist", list);
		modelAndView.addObject("categorylist", list1);
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/**
	 * This method is used to search the Employee ServiceBook on the basis of
	 * user input
	 **/

	@RequestMapping(value = "/employeeServiceBookSearchByCondtion")
	public ModelAndView employeeServiceBookSearchByCondtion(
			@ModelAttribute("employeeStatusDTO") EmployeeStatusDTO employeeStatusDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String SQL;
		ModelAndView target = new ModelAndView("serviceBookSearchList");
		List<ViewEmployeeSearch> list = null;
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		try{
		String ppDesignationmasterid = "" + employeeStatusDTO.getPpDesignationmasterid();
		String masEmploymentsubtypeid = "" + employeeStatusDTO.getMasEmploymentsubtypeid();
		String employeecode = "" + employeeStatusDTO.getEmployeecode();
		
		target.addObject("employeecode", employeecode);
		
		String firstname = employeeStatusDTO.getFirstname();
		String lastname = employeeStatusDTO.getLastname();
		if (employeecode.equals("") && firstname.equals("") && lastname.equals("")
				&& masEmploymentsubtypeid.equals("-1") && ppDesignationmasterid.equals("-1")) {

			list = (List<ViewEmployeeSearch>) serviceBookService.getList(rmOfficeid, "ViewEmployeeSearch.findByRmOfficeid");
			
		}

		else {

			employeeStatusDTO.setEmployeecode(employeecode);
			employeeStatusDTO.setFirstname(firstname);
			employeeStatusDTO.setLastname(lastname);
			employeeStatusDTO.setMasEmploymentsubtypeid(masEmploymentsubtypeid);
			employeeStatusDTO.setPpDesignationmasterid(Integer.parseInt(ppDesignationmasterid));
			String predicate = " ISFUNCTIONING = '1'";
			SQL = serviceBookService.createSearchSQL(predicate, employeeStatusDTO);
			list = (List<ViewEmployeeSearch>) serviceBookService.suspensionEmployeeSearchList(SQL);
		}
		
		System.out.println(list.size()+"----list size");
		
		target.addObject("list", list);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}

	/** This method will populate the Personal Information of Employees **/

	@RequestMapping(value = "/ServiceBook", params = "actionPersonalInfo", method = RequestMethod.POST)
	public ModelAndView actionPersionalInfo(HttpServletRequest request, HttpServletResponse response) {

		EmployeeStatusDTO employeeStausDTO = null;
		HashMap<Integer, String> religionMap = new HashMap<Integer, String>();
		HashMap<Integer, String> reservationCategoryMap = new HashMap<Integer, String>();
		HashMap<Integer, String> maritalStatusMap = new HashMap<Integer, String>();

		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");

		List<ViewPpEmployeepersonaldetail> ppEmployeepersonaldetailList = null;
		List<MasReligion> religionList = null;
		List<MasCaste> reservationCategoryList = null;
		List<MasMaritalstatus> maritalStatusList = null;
		Long PpEmployeemasterid = null;

		System.out.println("ppEmployeemasterid...." + ppEmployeemasterid);
		ModelAndView modelAndView = new ModelAndView("serviceBookPersonalInformation");

		try {
			Class<?> ref = Class.forName("com.nic.upjn.spring.dto.EmployeeStatusDTO");
			employeeStausDTO = (EmployeeStatusDTO) ref.newInstance();

			ppEmployeepersonaldetailList = (List<ViewPpEmployeepersonaldetail>) serviceBookService
					.getList(ppEmployeemasterid, "ViewPpEmployeepersonaldetail.findByPpEmployeemasterid");

			for (ViewPpEmployeepersonaldetail ViewPpEmployeepersonaldetail : ppEmployeepersonaldetailList) {
				employeeStausDTO.setSexcode(ViewPpEmployeepersonaldetail.getSexcode());
				System.out.println(ViewPpEmployeepersonaldetail.getSexcode() + "---------####");

				PpEmployeemasterid = ViewPpEmployeepersonaldetail.getPpEmployeemasterid();
			}

			religionList = (List<MasReligion>) serviceBookService.getList(null, "MasReligion.findAll");
			for (MasReligion masReligion : religionList) {
				System.out.println(masReligion.getMasReligionid() + "    " + masReligion.getReligion());
				religionMap.put(masReligion.getMasReligionid(), masReligion.getReligion());

			}
			reservationCategoryList = (List<MasCaste>) serviceBookService.getList(null, "MasCaste.findAll");
			for (MasCaste masCaste : reservationCategoryList) {
				reservationCategoryMap.put((int) masCaste.getMasCasteid().shortValue(), masCaste.getCaste());
			}

			maritalStatusList = (List<MasMaritalstatus>) serviceBookService.getList(null, "MasMaritalstatus.findAll");
			for (MasMaritalstatus masMaritalstatus : maritalStatusList) {
				maritalStatusMap.put((int) masMaritalstatus.getMasMaritalstatusid().shortValue(),
						masMaritalstatus.getMaritalstatus());
			}
			
			System.out.println("--------------fhkuhikdh------------");

		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("religionMap", religionMap);
		modelAndView.addObject("reservationCategoryMap", reservationCategoryMap);
		modelAndView.addObject("maritalStatusMap", maritalStatusMap);
		modelAndView.addObject("list", ppEmployeepersonaldetailList);
		modelAndView.addObject("sexcode", employeeStausDTO.getSexcode());
		modelAndView.addObject("PpEmployeemasterid", PpEmployeemasterid);
		System.out.println("Multiple action calling in same JSP using Spring MVC");
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;
	}

	/** This method is used to save the Personal detail of Employees **/

	@RequestMapping(value = "/insertEmployeePersonalDetails", method = RequestMethod.POST)
	public ModelAndView insertEmployeePersonalDetails(
			@ModelAttribute("employeeStatusDTO") EmployeeStatusDTO employeeStatusDTO, HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("serviceBookPersonalInformation");
		
		List<MasReligion> religionList = null;
		List<MasCaste> reservationCategoryList = null;
		List<MasMaritalstatus> maritalStatusList = null;
		
		HashMap<Integer, String> religionMap = new HashMap<Integer, String>();
		HashMap<Integer, String> reservationCategoryMap = new HashMap<Integer, String>();
		HashMap<Integer, String> maritalStatusMap = new HashMap<Integer, String>();
		
		String PpEmployeemasterid = request.getParameter("PpEmployeemasterid");
		List<ViewPpEmployeepersonaldetail> ppEmployeepersonaldetailList;
		employeeStatusDTO.setPpEmployeemasterid(PpEmployeemasterid);
		ppEmployeepersonaldetailList = (List<ViewPpEmployeepersonaldetail>) serviceBookService
				.getList(PpEmployeemasterid, "ViewPpEmployeepersonaldetail.findByPpEmployeemasterid");
		for (ViewPpEmployeepersonaldetail viewPpEmployeepersonaldetail : ppEmployeepersonaldetailList) {

			System.out.println(viewPpEmployeepersonaldetail);
			employeeStatusDTO.setBloodgroup(viewPpEmployeepersonaldetail.getBloodgroup());
			if(employeeStatusDTO.getBloodgroup() == null){
				employeeStatusDTO.setBloodgroup("");
			}
			String appointmentfiledate = viewPpEmployeepersonaldetail.getAppointmentfiledate()+"";
			
			if(appointmentfiledate.equals("null")){
				employeeStatusDTO.setAppointmentfiledate("");
			}
			else{
			employeeStatusDTO.setAppointmentfiledate(appointmentfiledate);
			}
			employeeStatusDTO.setAppointmentauthority(viewPpEmployeepersonaldetail.getAppointmentauthority());
			if(employeeStatusDTO.getAppointmentauthority() == null){
				employeeStatusDTO.setAppointmentauthority("");
			}
			employeeStatusDTO.setAppointmentfileno(viewPpEmployeepersonaldetail.getAppointmentfileno());
			employeeStatusDTO.setDatejoining(viewPpEmployeepersonaldetail.getDatejoining() + "");
			employeeStatusDTO.setSubphasename(viewPpEmployeepersonaldetail.getSubphasename());
			employeeStatusDTO.setEmploymenttype(viewPpEmployeepersonaldetail.getEmploymenttype());
			employeeStatusDTO.setDesignation(viewPpEmployeepersonaldetail.getDesignation());
			employeeStatusDTO.setPpDesignationmasterid(viewPpEmployeepersonaldetail.getPpDesignationmasterid());
			employeeStatusDTO.setEmploymentsubtype(viewPpEmployeepersonaldetail.getEmploymentsubtype());
			employeeStatusDTO.setEmployeecode(viewPpEmployeepersonaldetail.getEmployeecode());
		}
		
		System.out.println(employeeStatusDTO + "^^^^^^^^^^^^^^^^^^^^^^^##############");
	
		int result = serviceBookService.executeProcedureForeditEmployeePersonalDetails(employeeStatusDTO);
		
		if(result==1){
			modelAndView.addObject("msg","Data processed Successfully");
		}
		else{
			modelAndView.addObject("error","Error... Check the required values and format of values");
		}

		System.out.println(PpEmployeemasterid + "^^^^-------#####");
		
		ppEmployeepersonaldetailList = (List<ViewPpEmployeepersonaldetail>) serviceBookService
				.getList(PpEmployeemasterid, "ViewPpEmployeepersonaldetail.findByPpEmployeemasterid");

		for (ViewPpEmployeepersonaldetail ViewPpEmployeepersonaldetail : ppEmployeepersonaldetailList) {
			employeeStatusDTO.setSexcode(ViewPpEmployeepersonaldetail.getSexcode());
			System.out.println(ViewPpEmployeepersonaldetail.getSexcode() + "---------####");
		}

		religionList = (List<MasReligion>) serviceBookService.getList(null, "MasReligion.findAll");
		for (MasReligion masReligion : religionList) {
			System.out.println(masReligion.getMasReligionid() + "    " + masReligion.getReligion());
			religionMap.put(masReligion.getMasReligionid(), masReligion.getReligion());

		}
		reservationCategoryList = (List<MasCaste>) serviceBookService.getList(null, "MasCaste.findAll");
		for (MasCaste masCaste : reservationCategoryList) {
			reservationCategoryMap.put((int) masCaste.getMasCasteid().shortValue(), masCaste.getCaste());
		}

		maritalStatusList = (List<MasMaritalstatus>) serviceBookService.getList(null, "MasMaritalstatus.findAll");
		for (MasMaritalstatus masMaritalstatus : maritalStatusList) {
			maritalStatusMap.put((int) masMaritalstatus.getMasMaritalstatusid().shortValue(),
					masMaritalstatus.getMaritalstatus());
		}

		modelAndView.addObject("religionMap", religionMap);
		modelAndView.addObject("reservationCategoryMap", reservationCategoryMap);
		modelAndView.addObject("maritalStatusMap", maritalStatusMap);
		modelAndView.addObject("list", ppEmployeepersonaldetailList);	
		modelAndView.addObject("sexcode", employeeStatusDTO.getSexcode());
		modelAndView.addObject("PpEmployeemasterid", PpEmployeemasterid);

		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/**
	 * This method is used to populate all Personal PromotionInfo of selected
	 * Employee
	 **/

	@RequestMapping(value = "/ServiceBook", params = "actionPromotionInfo")
	public ModelAndView actionPromotionInfo(HttpServletRequest request, HttpServletResponse response) {

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		
		String mas_EmploymentSubTypeID = null;
		String mas_EmploymentTypeID = null;

		List<ViewEmployeeSearch> list3 = (List<ViewEmployeeSearch>) serviceBookService.getList(ppEmployeemasterid,
				"ViewEmployeeSearch.findByPpEmployeemasterid");
		for (ViewEmployeeSearch viewEmployeeSearch : list3) {
			
		}

		List<PpEmployeemaster> list = (List<PpEmployeemaster>) serviceBookService.getList(ppEmployeemasterid + "",
				"PpEmployeemaster.findByPpEmployeemasterid");
		for (PpEmployeemaster ppEmployeemaster : list) {
			mas_EmploymentSubTypeID = ppEmployeemaster.getMasEmploymentsubtypeid();
		}

		List<MasEmploymentsubtype> list1 = (List<MasEmploymentsubtype>) serviceBookService
				.getList(mas_EmploymentSubTypeID, "MasEmploymentsubtype.findByMasEmploymentsubtypeid");
		for (MasEmploymentsubtype masEmploymentsubtype : list1) {
			mas_EmploymentTypeID = masEmploymentsubtype.getMasEmploymenttypeid();
		}

		List<PpDesignationmaster> list2 = (List<PpDesignationmaster>) serviceBookService.getList(mas_EmploymentTypeID,
				"PpDesignationmaster.findByemployementtype");
		for (PpDesignationmaster ppDesignationmaster : list2) {
			map.put(Integer.parseInt(ppDesignationmaster.getPpDesignationmasterid() + ""),
					ppDesignationmaster.getDesignation());
		}

		List<ViewPpEmployeePromotion> list4 = (List<ViewPpEmployeePromotion>) serviceBookService
				.getList(ppEmployeemasterid + "", "ViewPpEmployeePromotion.findByPpEmployeemasterid");

		ModelAndView modelAndView = new ModelAndView("promotionmanagement");
		modelAndView.addObject("designationMap", map);
		modelAndView.addObject("list", list3);
		modelAndView.addObject("LastPromotionDetail", list4);
		modelAndView.addObject("ppEmployeemasterid", ppEmployeemasterid);

		System.out.println("called");
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/**
	 * this method is used for Saving the Promotion Details of Selected Employee
	 **/
	@RequestMapping(value = "/ManageEmpPromotionInfo")
	public ModelAndView ManageEmpPromotion(@ModelAttribute("command") EmployeeStatusDTO employeeStatusDTO,
			HttpServletRequest request, HttpServletResponse response) {

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		ModelAndView modelAndView = new ModelAndView("promotionmanagement");

		System.out.println("yesssssssssssss");

		String mas_EmploymentSubTypeID = null;
		String mas_EmploymentTypeID = null;

		try {

			int result = serviceBookService.executeProcedureForaddEmployeePromotion(employeeStatusDTO);

			if (result == 1) {

				modelAndView.addObject("msg", "Process completed successfully");
			} else {
				modelAndView.addObject("error", "Error in Procedure Execution");
			}

		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.addObject("error", e);
		}
		List<PpEmployeemaster> list = (List<PpEmployeemaster>) serviceBookService.getList(ppEmployeemasterid,
				"PpEmployeemaster.findByPpEmployeemasterid");
		for (PpEmployeemaster ppEmployeemaster : list) {
			mas_EmploymentSubTypeID = ppEmployeemaster.getMasEmploymentsubtypeid();
		}

		List<MasEmploymentsubtype> list1 = (List<MasEmploymentsubtype>) serviceBookService
				.getList(mas_EmploymentSubTypeID, "MasEmploymentsubtype.findByMasEmploymentsubtypeid");
		for (MasEmploymentsubtype masEmploymentsubtype : list1) {
			mas_EmploymentTypeID = masEmploymentsubtype.getMasEmploymenttypeid();
		}

		List<PpDesignationmaster> list2 = (List<PpDesignationmaster>) serviceBookService.getList(mas_EmploymentTypeID,
				"PpDesignationmaster.findByemployementtype");
		for (PpDesignationmaster ppDesignationmaster : list2) {
			map.put(Integer.parseInt(ppDesignationmaster.getPpDesignationmasterid() + ""),
					ppDesignationmaster.getDesignation());
		}

		List<ViewEmployeeSearch> list3 = (List<ViewEmployeeSearch>) serviceBookService.getList(ppEmployeemasterid,
				"ViewEmployeeSearch.findByPpEmployeemasterid");

		List<ViewPpEmployeePromotion> list4 = (List<ViewPpEmployeePromotion>) serviceBookService
				.getList(ppEmployeemasterid, "ViewPpEmployeePromotion.findByPpEmployeemasterid");

		modelAndView.addObject("designationMap", map);
		modelAndView.addObject("list", list3);
		modelAndView.addObject("LastPromotionDetail", list4);
		modelAndView.addObject("ppEmployeemasterid", ppEmployeemasterid);

		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** This method will populate Permanency Info of selected Employee **/
	@RequestMapping(value = "/ServiceBook", params = "actionPermanencyInfo")
	public ModelAndView actionPermanencyInfo(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("sbpermanency");
		System.out.println("called");
		String ppEmpID = request.getParameter("ppEmployeemasterid");
		List<PpPermanencyView> list3 = null;

		String employeecode = request.getParameter("employeecode");
		Long ppEmployeemasterid = null;
		if (ppEmpID == null) {
			list3 = (List<PpPermanencyView>) serviceBookService.getList(employeecode,
					"PpPermanencyView.findByEmployeecode");
			for (PpPermanencyView permanencyView : list3) {
				ppEmployeemasterid = permanencyView.getPpEmployeemasterid();
				modelAndView.addObject("ppEmployeemasterid", ppEmployeemasterid);
			}
		} else {
			list3 = (List<PpPermanencyView>) serviceBookService.getList(ppEmpID,
					"PpPermanencyView.findByPpEmployeemasterid");
			modelAndView.addObject("ppEmployeemasterid", ppEmpID);
		}

		modelAndView.addObject("list", list3);

		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** This method is used to save the PermanencyInfo of Employees **/

	@RequestMapping(value = "/UpdatePermanency")
	public ModelAndView UpdatePermanency(@ModelAttribute("command") EmployeeStatusDTO employeeStatusDTO,
			HttpServletRequest request, HttpServletResponse response) {
		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		Character ispermanent;

		System.out.println(employeeStatusDTO.getIsPermanent());

		List<ViewEmployeeSearch> list3 = (List<ViewEmployeeSearch>) serviceBookService.getList(ppEmployeemasterid + "",
				"ViewEmployeeSearch.findByPpEmployeemasterid");
		if (employeeStatusDTO.getIsPermanent().equals("true")) {
			ispermanent = '1';
		} else {
			ispermanent = '0';
		}

		PpEmployeedetail ppEmployeedetail = new PpEmployeedetail();

		List<PpEmployeedetail> list = (List<PpEmployeedetail>) serviceBookService.getList(ppEmployeemasterid + "",
				"PpEmployeedetail.findByPpEmployeemasterid");

		for (PpEmployeedetail pEmployeedetail : list) {
			ppEmployeedetail.setPpEmployeedetailid(pEmployeedetail.getPpEmployeedetailid());
		}
		ppEmployeedetail.setPpEmployeemasterid(Long.parseLong(ppEmployeemasterid));
		ppEmployeedetail.setPermanentorderno(employeeStatusDTO.getPERMANENTORDERNO());
		ppEmployeedetail.setPermanentorderdate(employeeStatusDTO.getPERMANENTORDERDATE());
		ppEmployeedetail.setIspermanent(ispermanent);

		serviceBookService.updatePermanencyInformation(ppEmployeedetail);

		System.out.println("called Again");
		ModelAndView modelAndView = new ModelAndView("sbpermanency");
		modelAndView.addObject("ppEmployeemasterid", ppEmployeemasterid);
		modelAndView.addObject("list", list3);

		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/**
	 * This method will return confirmation Details and personal info of
	 * Employee
	 **/
	@RequestMapping(value = "/confirmationEmployeeDetails")
	public ModelAndView confirmationEmployeeDetails(HttpServletRequest request, HttpServletResponse response) {

		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		ModelAndView modelAndView = new ModelAndView("confirmationDetails");

		List<ViewEmployeeSearch> list3 = (List<ViewEmployeeSearch>) serviceBookService.getList(ppEmployeemasterid + "",
				"ViewEmployeeSearch.findByPpEmployeemasterid");

		modelAndView.addObject("list", list3);
		modelAndView.addObject("ppEmployeemasterid", ppEmployeemasterid);

		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/**
	 * This method will save the confirmation details into PpEmployeedetail
	 * table
	 **/
	@RequestMapping(value = "/saveConfirmationDetails")
	public ModelAndView saveConfirmationDetails(@ModelAttribute("command") EmployeeStatusDTO employeeStatusDTO,
			HttpServletRequest request, HttpServletResponse response) {

		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		ModelAndView modelAndView = new ModelAndView("confirmationDetails");
		PpEmployeedetail ppEmployeedetail = new PpEmployeedetail();

		List<ViewPpEmployeeconfirmation> list3 = (List<ViewPpEmployeeconfirmation>) serviceBookService
				.getList(ppEmployeemasterid + "", "ViewPpEmployeeconfirmation.findByPpEmployeemasterid");

		List<PpEmployeedetail> list = (List<PpEmployeedetail>) serviceBookService.getList(ppEmployeemasterid + "",
				"PpEmployeedetail.findByPpEmployeemasterid");

		for (PpEmployeedetail pEmployeedetail : list) {
			ppEmployeedetail.setPpEmployeedetailid(pEmployeedetail.getPpEmployeedetailid());
		}

		ppEmployeedetail.setPpEmployeemasterid(Long.parseLong(ppEmployeemasterid));
		ppEmployeedetail.setConfirmorderno(employeeStatusDTO.getConfirmorderno());
		ppEmployeedetail.setConfirmorderdate(employeeStatusDTO.getConfirmorderdate());
		ppEmployeedetail.setConfirmeffectivedate(employeeStatusDTO.getConfirmeffectivedate());
		ppEmployeedetail.setIsconfirm('1');
		ppEmployeedetail.setIspermanent('1');

		serviceBookService.updatePermanencyInformation(ppEmployeedetail);
		modelAndView.addObject("msg", "Process completed successfully");
		modelAndView.addObject("list", list3);
		modelAndView.addObject("ppEmployeemasterid", ppEmployeemasterid);

		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** This method will return the Service Book - Permanency page **/
	@RequestMapping(value = "/actionPermanencyInfo")
	public ModelAndView actionPermanencyInfoLink(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("sbpermanency");
		System.out.println("called");
		String ppEmpID = request.getParameter("ppEmployeemasterid");
		List<PpPermanencyView> list3 = null;

		String employeecode = request.getParameter("employeecode");
		Long ppEmployeemasterid = null;
		if (ppEmpID == null) {
			list3 = (List<PpPermanencyView>) serviceBookService.getList(employeecode,
					"PpPermanencyView.findByPpEmployeemasterid");
			for (PpPermanencyView permanencyView : list3) {
				ppEmployeemasterid = permanencyView.getPpEmployeemasterid();
				modelAndView.addObject("ppEmployeemasterid", ppEmployeemasterid);
			}
		} else {
			list3 = (List<PpPermanencyView>) serviceBookService.getList(ppEmpID,
					"PpPermanencyView.findByPpEmployeemasterid");
			modelAndView.addObject("ppEmployeemasterid", ppEmpID);
		}

		modelAndView.addObject("list", list3);

		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/**
	 * This method will return the Service Book - TrainingInfo page with
	 * Employee Training List
	 **/
	@RequestMapping(value = "/ServiceBook", params = "actionTrainingInfo")
	public ModelAndView actionTrainingInfo(HttpServletRequest request, HttpServletResponse response) {

		List<ViewPpEmployeetraining> employeeTrainingList;

		ModelAndView modelAndView = new ModelAndView("empTraining");
		String employeecode = request.getParameter("employeecode");

		HashMap<Integer, String> trainingTypeMap = new HashMap<Integer, String>();
		List<ViewEmployeeSearch> list;

		List<PpTrainingtypemaster> trainingTypeList = (List<PpTrainingtypemaster>) serviceBookService.getList(null,
				"PpTrainingtypemaster.findAll");
		for (PpTrainingtypemaster ppTrainingtypemaster : trainingTypeList) {
			trainingTypeMap.put(ppTrainingtypemaster.getPpTrainingtypemasterid(),
					ppTrainingtypemaster.getTrainingtype());
		}

		Long ppEmployeemasterid = null;

		list = (List<ViewEmployeeSearch>) serviceBookService.getList(employeecode,
				"ViewEmployeeSearch.findByEmployeecode");
		for (ViewEmployeeSearch viewEmployeeSearch : list) {
			ppEmployeemasterid = viewEmployeeSearch.getPpEmployeemasterid();
			modelAndView.addObject("ppEmployeemasterid", ppEmployeemasterid);
		}
		employeeTrainingList = (List<ViewPpEmployeetraining>) serviceBookService.getList("" + ppEmployeemasterid,
				"ViewPpEmployeetraining.findByPpEmployeemasterid");

		modelAndView.addObject("list", list);
		modelAndView.addObject("employeeTrainingList", employeeTrainingList);
		modelAndView.addObject("trainingTypeMap", trainingTypeMap);
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** This method will save the Training details of Employee **/
	@RequestMapping(value = "/saveEmployeeTrainingRecord")
	public ModelAndView saveEmployeeTrainingRecord(@ModelAttribute("command") EmployeeStatusDTO employeeStatusDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("empTraining");
		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");

		HashMap<Integer, String> trainingTypeMap = new HashMap<Integer, String>();
		List<ViewEmployeeSearch> list;
		List<ViewPpEmployeetraining> employeeTrainingList;
		List<PpTrainingtypemaster> TrainingName;

		List<PpTrainingtypemaster> trainingTypeList = (List<PpTrainingtypemaster>) serviceBookService.getList(null,
				"PpTrainingtypemaster.findAll");
		for (PpTrainingtypemaster ppTrainingtypemaster : trainingTypeList) {
			trainingTypeMap.put(ppTrainingtypemaster.getPpTrainingtypemasterid(),
					ppTrainingtypemaster.getTrainingtype());
		}

		list = (List<ViewEmployeeSearch>) serviceBookService.getList(ppEmployeemasterid,
				"ViewEmployeeSearch.findByPpEmployeemasterid");

		PpEmployeetraining ppEmployeetraining = new PpEmployeetraining();
		BeanUtils.copyProperties(employeeStatusDTO, ppEmployeetraining);
		ppEmployeetraining.setOrderdate(employeeStatusDTO.getOrderdate());
		ppEmployeetraining.setPpEmployeemasterid(ppEmployeemasterid);

		serviceBookService.saveTrainingInfoEmployee(ppEmployeetraining);

		employeeTrainingList = (List<ViewPpEmployeetraining>) serviceBookService.getList(ppEmployeemasterid,
				"ViewPpEmployeetraining.findByPpEmployeemasterid");

		modelAndView.addObject("list", list);
		modelAndView.addObject("employeeTrainingList", employeeTrainingList);
		modelAndView.addObject("trainingTypeMap", trainingTypeMap);
		modelAndView.addObject("msg", "Process completed successfully");
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/** This method will edit the Training Details of Employee **/
	@RequestMapping(value = "/editTrainingDetails")
	public ModelAndView editTrainingDetails(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("empTraining");
		List<ViewPpEmployeetraining> employeeTrainingInfoList;
		String ppEmployeetrainingid = request.getParameter("ppEmployeetrainingid");

		Long ppEmployeemasterid = null;
		HashMap<Integer, String> trainingTypeMap = new HashMap<Integer, String>();

		List<PpTrainingtypemaster> trainingTypeList = (List<PpTrainingtypemaster>) serviceBookService.getList(null,
				"PpTrainingtypemaster.findAll");
		for (PpTrainingtypemaster ppTrainingtypemaster : trainingTypeList) {
			trainingTypeMap.put(ppTrainingtypemaster.getPpTrainingtypemasterid(),
					ppTrainingtypemaster.getTrainingtype());
		}

		employeeTrainingInfoList = (List<ViewPpEmployeetraining>) serviceBookService.getList(ppEmployeetrainingid,
				"ViewPpEmployeetraining.findByPpEmployeetrainingid");
		for (ViewPpEmployeetraining viewPpEmployeetraining : employeeTrainingInfoList) {
			ppEmployeemasterid = viewPpEmployeetraining.getPpEmployeemasterid();
		}

		List<ViewEmployeeSearch> list = (List<ViewEmployeeSearch>) serviceBookService.getList(ppEmployeemasterid + "",
				"ViewEmployeeSearch.findByPpEmployeemasterid");

		modelAndView.addObject("trainingTypeMap", trainingTypeMap);
		modelAndView.addObject("employeeTrainingInfoList", employeeTrainingInfoList);
		modelAndView.addObject("list", list);

		System.out.println("called");
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	/**
	 * This method is used to populate the qualification detail of Employees
	 **/
	@RequestMapping(value = "/qualificationDetails")
	public ModelAndView qualificationDetails(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView("qualificationDetails");
		
		try{
			HashMap<Integer, String> QualificationMap = new HashMap<Integer, String>();
			String PpEmployeemasterid = request.getParameter("PpEmployeemasterid");
			
			System.out.println(PpEmployeemasterid);
			
			modelAndView.addObject("PpEmployeemasterid", PpEmployeemasterid);
			
			List<ViewEmployeeSearch> list = (List<ViewEmployeeSearch>) serviceBookService.getList(PpEmployeemasterid,
					"ViewEmployeeSearch.findByPpEmployeemasterid");			
			
			modelAndView.addObject("list", list);
			
			List<PpQualificationmaster> QualificationList = (List<PpQualificationmaster>) serviceBookService
					.getComboList("PpQualificationmaster.findAll");
			for (PpQualificationmaster ppQualificationmaster : QualificationList) {
				QualificationMap.put(ppQualificationmaster.getPpQualificationmasterid(),
						ppQualificationmaster.getQualification());
			}
			
			modelAndView.addObject("QualificationMap", QualificationMap);
			
			List<PpEmployeequalificationView> qualificationInfo = (List<PpEmployeequalificationView>) serviceBookService
					.getList(PpEmployeemasterid, "PpEmployeequalificationView.findByPpEmployeemasterid");
			
			modelAndView.addObject("qualificationInfo", qualificationInfo);
			
			Iterator<PpEmployeequalificationView> itr =  qualificationInfo.iterator();
			while(itr.hasNext()){
				System.out.println(itr.next()); 
			}
			
			System.out.println("size of qualificationInfo list -- "+qualificationInfo.size());
		}
		catch(Exception e){
			e.printStackTrace();			
		}
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;
	}

	/**
	 * This method is used to save the Qualification details of selected
	 * Employee
	 **/
	
	@RequestMapping(value = "/insertQualificationDetails")
	public ModelAndView insertQualificationDetails(@ModelAttribute("employeeStatusDTO") EmployeeStatusDTO employeeStatusDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("qualificationDetails");
		String PpEmployeemasterid = request.getParameter("PpEmployeemasterid");

		HashMap<Integer, String> QualificationMap = new HashMap<Integer, String>();
		Character isIsatjoining;

		PpEmployeequalification ppEmployeequalification = new PpEmployeequalification();

		try {
			if (employeeStatusDTO.getIsatjoining().equals("true")) {
				isIsatjoining = '1';
			} else {
				isIsatjoining = '0';
			}

			BeanUtils.copyProperties(employeeStatusDTO, ppEmployeequalification);
			ppEmployeequalification.setPpEmployeemasterid(PpEmployeemasterid);
			ppEmployeequalification.setIsatjoining(isIsatjoining);

			serviceBookService.insertQualificationDetails(ppEmployeequalification);

			List<ViewEmployeeSearch> list = (List<ViewEmployeeSearch>) serviceBookService.getList(PpEmployeemasterid + "",
					"ViewEmployeeSearch.findByPpEmployeemasterid");

			List<PpEmployeequalificationView> qualificationInfo = (List<PpEmployeequalificationView>) serviceBookService
					.getList(PpEmployeemasterid + "", "PpEmployeequalificationView.findByPpEmployeemasterid");

			List<PpQualificationmaster> QualificationList = (List<PpQualificationmaster>) serviceBookService
					.getComboList("PpQualificationmaster.findAll");
			for (PpQualificationmaster ppQualificationmaster : QualificationList) {
				QualificationMap.put(ppQualificationmaster.getPpQualificationmasterid(),
						ppQualificationmaster.getQualification());
			}
			modelAndView.addObject("list", list);
			modelAndView.addObject("qualificationInfo", qualificationInfo);
			modelAndView.addObject("QualificationMap", QualificationMap);
			modelAndView.addObject("PpEmployeemasterid", PpEmployeemasterid);
			modelAndView.addObject("msg","Data processed Successfully");
		}
		
		catch (BeansException e) {
			modelAndView.addObject("error","Error");
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;
	}

	
	@RequestMapping(value = "/NomineeDetails")
	public ModelAndView NomineeDetails(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView("NomineeDetails");
		
		try{
			String PpEmployeemasterid = request.getParameter("PpEmployeemasterid");
			modelAndView.addObject("PpEmployeemasterid", PpEmployeemasterid);
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/DependentDetails")
	public ModelAndView DependentDetails(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView("DependentDetails");
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;
		
	}

	
	@RequestMapping(value = "/search")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<PpDesignationmaster> list = null;
		List<MasEmploymentsubtype> list1 = null;

		try {
			Class<?> ref = Class.forName("com.nic.upjn.spring.dto.EmployeeStatusDTO");
			EmployeeStatusDTO employeeStatusDTO = (EmployeeStatusDTO) ref.newInstance();

			list1 = (List<MasEmploymentsubtype>) serviceBookService.getList(null, "MasEmploymentsubtype.findAll");
			for (MasEmploymentsubtype MasEmploymentsubtype : list1) {
				BeanUtils.copyProperties(MasEmploymentsubtype, employeeStatusDTO);
			}

			list = (List<PpDesignationmaster>) serviceBookService.getList(null, "PpDesignationmaster.findAll");
			for (PpDesignationmaster PpDesignationmaster : list) {
				BeanUtils.copyProperties(PpDesignationmaster, employeeStatusDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("search");
		modelAndView.addObject("designationlist", list);
		modelAndView.addObject("categorylist", list1);
		
		HttpSession session = request.getSession();
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}
	
	@RequestMapping(value = "/searchList")
	public ModelAndView searchList(
			@ModelAttribute("employeeStatusDTO") EmployeeStatusDTO employeeStatusDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String SQL;
		ModelAndView target = new ModelAndView("serviceBookSearchList");
		List<ViewEmployeeSearch> list = null;
		String ppDesignationmasterid = "" + employeeStatusDTO.getPpDesignationmasterid();
		String masEmploymentsubtypeid = "" + employeeStatusDTO.getMasEmploymentsubtypeid();
		String employeecode = "" + employeeStatusDTO.getEmployeecode();
		String firstname = employeeStatusDTO.getFirstname();
		String lastname = employeeStatusDTO.getLastname();
		if (employeecode.equals("") && firstname.equals("") && lastname.equals("")
				&& masEmploymentsubtypeid.equals("-1") && ppDesignationmasterid.equals("-1")) {

			list = (List<ViewEmployeeSearch>) serviceBookService.getList(null, "ViewEmployeeSearch.findAll");

		}

		else {

			employeeStatusDTO.setEmployeecode(employeecode);
			employeeStatusDTO.setFirstname(firstname);
			employeeStatusDTO.setLastname(lastname);
			employeeStatusDTO.setMasEmploymentsubtypeid(masEmploymentsubtypeid);
			employeeStatusDTO.setPpDesignationmasterid(Integer.parseInt(ppDesignationmasterid));
			String predicate = " ISFUNCTIONING = '1'";
			SQL = serviceBookService.createSearchSQL(predicate, employeeStatusDTO);
			list = (List<ViewEmployeeSearch>) serviceBookService.suspensionEmployeeSearchList(SQL);
		}

		target.addObject("list", list);
		target.addObject("employeecode", employeecode);
		
		HttpSession session = request.getSession();
		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}
}
