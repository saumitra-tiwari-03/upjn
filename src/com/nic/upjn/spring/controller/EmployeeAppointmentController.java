/******************************** CONTROLLER CLASS FOR APPOINTMENT OF NEW EMPLOYEES  **************************/
/* ==========================================================================
 * Description : This class implements controller operations for Appointment of New Employees.
 * Date:
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 */

/**This is a controller class used for Appointment of New Employees. Controller class get's the request from JSP pages,
 *  based on the requirement , methods of service class are called  and finally response is send to the JSP pages.
 * **/

/**Package name**/

package com.nic.upjn.spring.controller;

/**********************************LIBRARIES USED ********************************/
/** BeanUtils class copy the similar property of Bean class to another class  **/

/**AUTOWIRED Annotation 		: Used for creating the object of class without using new keyword 
 Controller Annotation		    : Used to make controller class of any defined simple class . This class is capable to initiate request and response between JSP and Controller 
 ModelAttribute Annotation 		: It automatically sets the values from JSP to DTO class.Variable name must be same in both JSP and DTO
 RequestMapping annotation 		: Used for mapping URL to the method of controller class  
 RequestMethod annotation 		: Used for identifying type of request generated from JSP  
 SessionStatus class 			: Represents current status of the Session 
 ModelAndView class				: It is Responsible for setting views and objects required by JSP Pages 
 EmployeeAppointmentService Interface : It contains all abstract methods used for services related to Employee Appointment
 EmployeeAppointmentDTO class 	: Contains the getter and setter of JSP variables 


 /** Imports required number of classes that are used in this particular class **/
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.nic.upjn.miscellaneous.ComboService;
import com.nic.upjn.spring.Service.EmployeeAppointmentService;
import com.nic.upjn.spring.dto.EmployeeAppointmentDTO;
import com.nic.upjn.spring.entity.MasEmploymenttype;
import com.nic.upjn.spring.entity.PpEmployeeappointmentdetail;
import com.nic.upjn.spring.entity.PpEmployeedetail;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.PpEmployeepaydetail;
import com.nic.upjn.spring.entity.PpEmployeepersonaldetail;
import com.nic.upjn.spring.entity.SysSubservicephasemaster;
import com.nic.upjn.spring.entity.ViewNewappointmentlist;
import com.sun.el.parser.ParseException;

@SuppressWarnings({ "unchecked", "unused" })
@Controller
public class EmployeeAppointmentController {

	@Autowired
	private EmployeeAppointmentService employeeAppointmentService;

	@Autowired
	ComboService comboService;
	
	ModelAndView modelAndView;
	EmployeeAppointmentDTO employeeAppointmentDTO;
	static Long PpEmployeemasterid;
	static String employementtypeid;

	/** This method is used to save the record of New Employees **/
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(
			@Valid @ModelAttribute("employeeAppointmentDTO") EmployeeAppointmentDTO employeeAppointmentDTO,
			BindingResult result, HttpServletRequest request, HttpServletResponse response) {

		modelAndView = new ModelAndView("New_Appointment");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		System.out.println(rmOfficeid + "-- i am rmofficeID");

		List<String> empcode = new ArrayList<String>();

		try {
			PpEmployeemaster ppEmployeemaster = new PpEmployeemaster();
			PpEmployeepersonaldetail ppEmployeepersonaldetail = new PpEmployeepersonaldetail();
			PpEmployeeappointmentdetail ppEmployeeappointmentdetail = new PpEmployeeappointmentdetail();
			PpEmployeedetail ppEmployeedetail = new PpEmployeedetail();
			PpEmployeepaydetail ppEmployeepaydetail = new PpEmployeepaydetail();

			employeeAppointmentDTO.setPpEmployeemasterid(PpEmployeemasterid);
			employeeAppointmentDTO.setEntryOfficeid(Long.parseLong(rmOfficeid + ""));
			employeeAppointmentDTO.setRm_officeid(rmOfficeid + "");
			employeeAppointmentDTO.setIsdisablefinancial('0');
			employeeAppointmentDTO.setIsretired('0');
			employeeAppointmentDTO.setIsfunctioning('0');
			employeeAppointmentDTO.setIsloginlocked('0');

			BeanUtils.copyProperties(employeeAppointmentDTO, ppEmployeemaster);
			BeanUtils.copyProperties(employeeAppointmentDTO, ppEmployeepersonaldetail);
	        
			ppEmployeepersonaldetail.setDateofbirth(comboService.getFormatedDate(employeeAppointmentDTO.getDateofbirth()));

			BeanUtils.copyProperties(employeeAppointmentDTO, ppEmployeeappointmentdetail);

			ppEmployeeappointmentdetail
					.setAppointmentfiledate(comboService.getFormatedDate(employeeAppointmentDTO.getAppointmentfiledate()));
			ppEmployeeappointmentdetail.setDatejoining(comboService.getFormatedDate(employeeAppointmentDTO.getDatejoining()));

			System.out.println(ppEmployeeappointmentdetail.getAppointmentfiledate() + "------------"
					+ ppEmployeeappointmentdetail.getDatejoining());

			BeanUtils.copyProperties(employeeAppointmentDTO, ppEmployeedetail);
			BeanUtils.copyProperties(employeeAppointmentDTO, ppEmployeepaydetail);

			/* First we check the existance of employee code */
			Boolean iscomplete = employeeAppointmentService
					.checkEmployeecodeExistance(employeeAppointmentDTO.getEmployeecode(), "", "add");

			if (!iscomplete) {
				iscomplete = employeeAppointmentService.insertNewEmployeeintoDB(ppEmployeemaster,
						ppEmployeepersonaldetail, ppEmployeeappointmentdetail, ppEmployeedetail, ppEmployeepaydetail);

				if (iscomplete) {
					modelAndView.addObject("app_msg", "Process Completed Successfully");
				} else {
					modelAndView.addObject("app_msg", "Error..! Please fill all the Mandatory Fields.");
				}
			} else {
				modelAndView.addObject("app_msg", "Employee Code already exists");
			}
			HashMap<Integer, String> hmap = comboService.populateCombo(employeeAppointmentService);

			modelAndView.addObject("Data", hmap);

			hmap = comboService.getmasEmploymenttype();

			modelAndView.addObject("Data1", hmap);
			
			modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
			modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;

	}

	/** This method populate the Combo List of OfficeLevel and District **/
	
	@RequestMapping("/getcombolist")
	protected ModelAndView getComboList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		modelAndView = new ModelAndView("New_Appointment");
		HttpSession session = request.getSession();
		
		HashMap<Integer, String> hmap = comboService.populateCombo(employeeAppointmentService);

		request.setAttribute("str", "str");
		request.setAttribute("Data", hmap);
		try {
			hmap = comboService.getmasEmploymenttype();
			request.setAttribute("Data1", hmap);

		} catch (Exception e){
			 e.printStackTrace();
		}
		
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;
	}
	
	/*@RequestMapping("/getcombolist")
	protected void getComboList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HashMap<Integer, String> hmap = comboService.populateCombo(employeeAppointmentService);

		request.setAttribute("str", "str");
		request.setAttribute("Data", hmap);

		try {

			hmap = comboService.getmasEmploymenttype();

			request.setAttribute("Data1", hmap);

			request.getRequestDispatcher("/WEB-INF/view/New_Appointment.jsp").forward(request, response);

		} catch (Exception e){
			 e.printStackTrace();
		}

	}*/

	/** This method populate the List of Employment Type **/
	private void getmasEmploymenttype(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HashMap<Integer, String> hmap1 = new HashMap<Integer, String>();
		List<MasEmploymenttype> list1 = (List<MasEmploymenttype>) employeeAppointmentService.getList(null,
				"MasEmploymenttype");
		for (MasEmploymenttype masEmploymenttype : list1) {
			hmap1.put(Integer.parseInt(masEmploymenttype.getMasEmploymenttypeid() + ""),
					masEmploymenttype.getEmploymenttype());

		}

		request.setAttribute("Data1", hmap1);

		request.getRequestDispatcher("/WEB-INF/view/New_Appointment.jsp").forward(request, response);

	}

	/**
	 * This method populates the List of Designations on the basis of Employment
	 * type
	 **/
	@RequestMapping("/getDesignationcombolist")
	protected void getDesignationcombolist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String json = null;
		HashMap<Integer, String> hmap2 = new HashMap<Integer, String>();

		employementtypeid = request.getParameter("employementtype");
		hmap2 = comboService.pupulatetDesignationCombo(employementtypeid, employeeAppointmentService);

		request.setAttribute("designation", hmap2);

		json = new Gson().toJson(hmap2);
		response.setContentType("application/json");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method populates the List of Employment Categories on the basis of
	 * Designation
	 **/
	@RequestMapping("/getDesignationcombocategorylist")
	protected void getDesignationcombocategoryList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String json = null;
		String designationid = request.getParameter("designationid");
		HashMap<Integer, String> hmap2 = new HashMap<Integer, String>();

		hmap2 = comboService.getDesignationcombocategoryList(designationid, employeeAppointmentService);

		request.setAttribute("employeementcategory", hmap2);

		json = new Gson().toJson(hmap2);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	/** This method is used to retrieve the list of Employees for Editing **/
	@RequestMapping(value = "/getEmployeeList")
	public ModelAndView getEmployeeList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		List<ViewNewappointmentlist> list2 = (List<ViewNewappointmentlist>) employeeAppointmentService.getList(rmOfficeid,
				"ViewNewappointmentlist.findByEntryOfficeid");

		ArrayList<EmployeeAppointmentDTO> al = new ArrayList<EmployeeAppointmentDTO>();
		for (ViewNewappointmentlist viewNewappointmentlist : list2) {

			EmployeeAppointmentDTO employeeAppointmentDTO = new EmployeeAppointmentDTO();

			BeanUtils.copyProperties(viewNewappointmentlist, employeeAppointmentDTO);

			al.add(employeeAppointmentDTO);

		}
		System.out.println(list2.size()+"--"+(String)session.getAttribute("employeename")+"--"+(String)session.getAttribute("designation"));

		modelAndView = new ModelAndView("EditAppointment");
		modelAndView.addObject("edit", al);
		
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;
	}

	/** This method is used to populate the List of Service Phase **/
	private void populateCombo(EmployeeAppointmentController employeeAppointmentController, HttpServletRequest request,
			HttpServletResponse response) {

		String str = "data";

		try {
			String str1 = request.getParameter("districtname1");
			System.out.println("value of ramprakash" + str1);
			String json = null;

			HashMap<Integer, String> hmap = new HashMap<Integer, String>();

			List<SysSubservicephasemaster> list = (List<SysSubservicephasemaster>) employeeAppointmentService
					.getList("Appointment", "SysSubservicephasemaster.findByServicephasename");

			for (SysSubservicephasemaster sysSubservicephasemaster : list) {
				hmap.put(Integer.parseInt(sysSubservicephasemaster.getSysSubservicephasemasterid() + ""),
						sysSubservicephasemaster.getSubphasename());
			}

			request.setAttribute("str", "str");
			request.setAttribute("Data", hmap);

			try {

				getmasEmploymenttype(request, response);

			} catch (Exception e) {

				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/** This method is used for editing Employee Appointment details **/
	@RequestMapping(value = "/populateEditAppointment", method = RequestMethod.GET)
	public ModelAndView populateEditAppointment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeAppointmentDTO employeeAppointmentDTO = new EmployeeAppointmentDTO();
		Integer ID = null;
		String employment_type = null;
		List employment_type_id = null;
		int flag = 1;
		modelAndView = new ModelAndView("New_Appointment");
		HttpSession session = request.getSession();

		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		Integer designationid = null;
		String designation = request.getParameter("designation");
		String employmenttype = request.getParameter("employmenttype");
		String employmentsubtype = request.getParameter("employmentsubtype");

		employeeAppointmentDTO.setDesignation(designation);
		employeeAppointmentDTO.setEmploymenttype(employmenttype);
		employeeAppointmentDTO.setEmploymentsubtype(employmentsubtype);
		PpEmployeemasterid = Long.parseLong(ppEmployeemasterid);
		// View_EditEmployeeForPosting

		try {
			ID = Integer.parseInt(ppEmployeemasterid);
		}

		catch (Exception e) {
		}

		List<PpEmployeemaster> list = (List<PpEmployeemaster>) employeeAppointmentService.getList(ID,
				"PpEmployeemaster.findByPpEmployeemasterid");

		for (PpEmployeemaster ppEmployeemaster : list) {
			BeanUtils.copyProperties(ppEmployeemaster, employeeAppointmentDTO);
		}

		List<PpEmployeepersonaldetail> list1 = (List<PpEmployeepersonaldetail>) employeeAppointmentService.getList(ID,
				"PpEmployeepersonaldetail.findByPpEmployeepersonaldetailid");
		for (PpEmployeepersonaldetail ppEmployeepersonaldetail : list1) {
			employeeAppointmentDTO.setFathername(ppEmployeepersonaldetail.getFathername());

            employeeAppointmentDTO.setDateofbirth(ppEmployeepersonaldetail.getDateofbirth()+"");
            
			employeeAppointmentDTO.setSexcode(ppEmployeepersonaldetail.getSexcode());
			
			employeeAppointmentDTO.setPpEmployeepersonaldetailid(ppEmployeepersonaldetail.getPpEmployeepersonaldetailid());
		}
		
		List<PpEmployeedetail> lis = (List<PpEmployeedetail>) employeeAppointmentService.getList(ID,
				"PpEmployeedetail.findByPpEmployeemasterid");
		for (PpEmployeedetail ppEmployeedetail : lis) {
			employeeAppointmentDTO.setPpEmployeedetailid(ppEmployeedetail.getPpEmployeedetailid());
		}
		List<PpEmployeepaydetail> lis1 = (List<PpEmployeepaydetail>) employeeAppointmentService.getList(ID,
				"PpEmployeepaydetail.findByPpEmployeemasterid");
		for (PpEmployeepaydetail ppEmployeepaydetail : lis1) {
			employeeAppointmentDTO.setPpEmployeepaydetailid(ppEmployeepaydetail.getPpEmployeepaydetailid());
		}

		List<PpEmployeeappointmentdetail> list2 = (List<PpEmployeeappointmentdetail>) employeeAppointmentService
				.getList(ID, "PpEmployeeappointmentdetail.findByppEmployeemasterid");
		for (PpEmployeeappointmentdetail ppEmployeeappointmentdetail : list2) {
			employeeAppointmentDTO.setPpEmployeeappointmentdetailid(ppEmployeeappointmentdetail.getPpEmployeeappointmentdetailid());
			
			employeeAppointmentDTO.setAppointmentauthority(ppEmployeeappointmentdetail.getAppointmentauthority());

			employeeAppointmentDTO.setAppointmentfileno(ppEmployeeappointmentdetail.getAppointmentfileno());

			employeeAppointmentDTO.setAppointmentfiledate(ppEmployeeappointmentdetail.getAppointmentfiledate() + "");

			employeeAppointmentDTO.setDatejoining(ppEmployeeappointmentdetail.getDatejoining() + "");

			employeeAppointmentDTO.setEffectivedatjoin(ppEmployeeappointmentdetail.getEffectivedatjoin());
		
			employeeAppointmentDTO.setPpDesignationmasterid(ppEmployeeappointmentdetail.getPpDesignationmasterid());
			designationid = ppEmployeeappointmentdetail.getPpDesignationmasterid();
			
			employeeAppointmentDTO.setPpEmployeemasterid(ppEmployeeappointmentdetail.getPpEmployeemasterid());
			employeeAppointmentDTO
					.setSysSubservicephasemasterid(ppEmployeeappointmentdetail.getSysSubservicephasemasterid());

		}

		comboService.getDesignationcombocategoryList(designationid + "", employeeAppointmentService);

		List<ViewNewappointmentlist> list3 = (List<ViewNewappointmentlist>) employeeAppointmentService.getList(ID,
				"ViewNewappointmentlist.findByPpEmployeemasterid");
		ArrayList<EmployeeAppointmentDTO> al = new ArrayList<EmployeeAppointmentDTO>();
		for (ViewNewappointmentlist viewNewappointmentlist : list3) {

			employeeAppointmentDTO.setDesignation(viewNewappointmentlist.getDesignation());
			employeeAppointmentDTO.setEmploymenttype(viewNewappointmentlist.getEmploymenttype());

			employment_type = employeeAppointmentDTO.getEmploymenttype();
			
			System.out.println(employment_type+"-- Value of Employment_Type");
			
		    employment_type_id = employeeAppointmentService.getList(employment_type, "MasEmploymenttype.findByEmploymenttype");
			
		    System.out.println(employment_type_id.size()+" Size of Emp Type ID ");
		    
			employeeAppointmentDTO.setEmploymentsubtype(viewNewappointmentlist.getEmploymentsubtype());

			employeeAppointmentDTO.setEntryOfficeid(viewNewappointmentlist.getEntryOfficeid());

		}

		request.setAttribute("list", list);
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("lis", lis);
		request.setAttribute("lis1", lis1);
		request.setAttribute("flag", flag);
        request.setAttribute("employment_type_id", employment_type_id);
		
		modelAndView.addObject("list", list);
		modelAndView.addObject("list1", list1);
		modelAndView.addObject("list2", list2);
		modelAndView.addObject("list3", list3);
		modelAndView.addObject("flag", flag);
		populateCombo(this, request, response);
		
		
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;
	}

	@RequestMapping("/editAppointment")
	public ModelAndView editAppointment(
			@ModelAttribute("employeeAppointmentDTO") EmployeeAppointmentDTO employeeAppointmentDTO,
			HttpServletRequest request, HttpServletResponse response) {

		 modelAndView = new ModelAndView("New_Appointment");

		try {
			PpEmployeemaster ppEmployeemaster = new PpEmployeemaster();
			PpEmployeepersonaldetail ppEmployeepersonaldetail = new PpEmployeepersonaldetail();
			PpEmployeeappointmentdetail ppEmployeeappointmentdetail = new PpEmployeeappointmentdetail();
			PpEmployeedetail ppEmployeedetail = new PpEmployeedetail();
			PpEmployeepaydetail ppEmployeepaydetail = new PpEmployeepaydetail();

			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			
			employeeAppointmentDTO.setEntryOfficeid(Long.parseLong(rmOfficeid + ""));
			employeeAppointmentDTO.setRm_officeid(rmOfficeid + "");
			employeeAppointmentDTO.setIsdisablefinancial('0');
			employeeAppointmentDTO.setIsretired('0');
			employeeAppointmentDTO.setIsfunctioning('0');
			employeeAppointmentDTO.setIsloginlocked('0');
								
			BeanUtils.copyProperties(employeeAppointmentDTO, ppEmployeemaster);
			BeanUtils.copyProperties(employeeAppointmentDTO, ppEmployeepersonaldetail);
			ppEmployeepersonaldetail.setDateofbirth(comboService.getFormatedDate(employeeAppointmentDTO.getDateofbirth()));
			BeanUtils.copyProperties(employeeAppointmentDTO, ppEmployeeappointmentdetail);
			ppEmployeeappointmentdetail
					.setAppointmentfiledate(comboService.getFormatedDate(employeeAppointmentDTO.getAppointmentfiledate()));
			ppEmployeeappointmentdetail.setDatejoining(comboService.getFormatedDate(employeeAppointmentDTO.getDatejoining()));
			BeanUtils.copyProperties(employeeAppointmentDTO, ppEmployeedetail);
			BeanUtils.copyProperties(employeeAppointmentDTO, ppEmployeepaydetail);

			System.out.println("In edit");

			String ppEmployeemasterID = Long.toString(employeeAppointmentDTO.getPpEmployeemasterid());

			Boolean iscomplete = employeeAppointmentService
					.checkEmployeecodeExistance(employeeAppointmentDTO.getEmployeecode(), ppEmployeemasterID, "edit");
			
			if(!iscomplete){
				
				iscomplete = employeeAppointmentService.editAppointment(ppEmployeemaster,ppEmployeepersonaldetail,ppEmployeeappointmentdetail,ppEmployeedetail,ppEmployeepaydetail);

			           if(!iscomplete){
			        	   modelAndView.addObject("app_msg", "Process Completed Successfully");
						} else {
							// modelAndView.addObject("app_msg", "Successful");
							modelAndView.addObject("app_msg", "Error");
						}
			}
			           else{
			        	   modelAndView.addObject("app_msg", "Employee Code already exists");
			           }	
			modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
			modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}
	
	
@RequestMapping("/checkemployeecode")
public ModelAndView checkemployeecode(
			@ModelAttribute("employeeAppointmentDTO") EmployeeAppointmentDTO employeeAppointmentDTO,
			HttpServletRequest request, HttpServletResponse response) {
	
	ModelAndView target = new ModelAndView("New_Appointment");
	HttpSession session = request.getSession();
	
   try{
		String employeecode = request.getParameter("employeecode");
		
		List<PpEmployeemaster> list = (List<PpEmployeemaster>)employeeAppointmentService.getList(employeecode, "PpEmployeemaster.findByEmployeecode");
		if(list.size()==0){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}
	  }
   catch(Exception e){
		e.printStackTrace();
	  }
   target.addObject("employee_name", (String) session.getAttribute("employeename"));
   target.addObject("designation_", (String) session.getAttribute("designation"));
	return target; 
		
     }
	
}
