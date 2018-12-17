package com.nic.upjn.spring.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.spring.Service.EmployeeAppointmentService;
import com.nic.upjn.spring.Service.ManagePayBillService;
import com.nic.upjn.spring.Service.SectionMasterService;
import com.nic.upjn.spring.dto.SectionMasterDTO;
import com.nic.upjn.spring.dto.ShowSearchListDTO;
import com.nic.upjn.spring.entity.MasEmploymentsubtype;
import com.nic.upjn.spring.entity.PpDesignationmaster;
import com.nic.upjn.spring.entity.PpRegistermaster;
import com.nic.upjn.spring.entity.PpSectionmaster;
import com.nic.upjn.spring.entity.ViewListForAssignRegister;
import com.nic.upjn.spring.entity.ViewSearchResult;

@Controller
public class ManagePayBillController {

	String returnPage = "paybill";

	@Autowired
	SectionMasterService sectionMasterService;

	@Autowired
	ManagePayBillService managePayBillService;

	@Autowired
	EmployeeAppointmentService employeeAppointmentService;

	/****************
	 * BY DEFAULT METHOD, CALLED ON CLICK FROM MENU
	 ***************************/
	
	@RequestMapping("/assignSectionandRegister")
	public ModelAndView payBillMaster(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView payBillModel = new ModelAndView(returnPage);
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		List<PpSectionmaster> sectionList = sectionMasterService.getSectionList("" + rmOfficeid);
		payBillModel.addObject("sectionList", sectionList);
		payBillModel.addObject("displayFlag", false);

		payBillModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		payBillModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		return payBillModel;
	}

	/****************
	 * SECTION NAME, EMPLOYEE LIST AND REGISTER LIST
	 ***************************/
	
	@RequestMapping(value = "/getEmpList", method = RequestMethod.POST)
	public ModelAndView getEmpList(@ModelAttribute("sectionMasterDTO") SectionMasterDTO sectionMasterDTO,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView EmpListModel = new ModelAndView(returnPage);
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		String sectionName = sectionMasterService.populateSectionMaster(sectionMasterDTO.getSectionID());
		System.out.println(sectionMasterDTO.getSectionID() + "---------" + sectionName + "--zzzz--");
		List<ViewListForAssignRegister> list = managePayBillService.getEmpList(rmOfficeid,
				sectionMasterDTO.getSectionID());
		List<PpRegistermaster> registerList = managePayBillService.getRegisterList();
		try {
			System.out.println(list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		EmpListModel.addObject("sectionName", sectionName);
		EmpListModel.addObject("sectionID", sectionMasterDTO.getSectionID());
		EmpListModel.addObject("empList", list);
		EmpListModel.addObject("registerList", registerList);

		EmpListModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		EmpListModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		return EmpListModel;

	}

	/****************
	 * TO REMOVE EMPLOYEE FROM SECTION
	 ***************************/

	@RequestMapping(value = "/dropEmpFromthisSection")
	public ModelAndView dropEmpForThisBillType(@ModelAttribute("sectionMasterDTO") SectionMasterDTO sectionMasterDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView EmpListModel = new ModelAndView(returnPage);
		boolean isComplete = false;

		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			/*String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
			String sectionID = request.getParameter("sectionID");*/

			System.out.println("ppemp id-----"+sectionMasterDTO.getPpEmployeemasterid()+"-----section id-----"+sectionMasterDTO.getSectionID());
			System.out.println(rmOfficeid);

			String sectionName = sectionMasterService.populateSectionMaster(sectionMasterDTO.getSectionID());

			isComplete = sectionMasterService.dropEmpForThisBillType(sectionMasterDTO.getPpEmployeemasterid(), sectionMasterDTO.getSectionID());

			if (isComplete == true) {
				EmpListModel.addObject("msg", "Employee removed from Section");
			} else {
				EmpListModel.addObject("msg", "Error in removing Employee");
			}

			List<ViewListForAssignRegister> list = managePayBillService.getEmpList(rmOfficeid,
					sectionMasterDTO.getSectionID());
			List<PpRegistermaster> registerList = managePayBillService.getRegisterList();

			EmpListModel.addObject("sectionName", sectionName);
		//	EmpListModel.addObject("sectionID", sectionID);
			EmpListModel.addObject("empList", list);
			EmpListModel.addObject("registerList", registerList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		EmpListModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		EmpListModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		return EmpListModel;

	}

	/****************
	 * SHOW EMPLOYEE LIST FOR ASSIGNING REGISTER
	 ***************************/

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/showSearch")
	public ModelAndView showSearch(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView showSearchModel = new ModelAndView("showSearch");
		String sectionID = request.getParameter("sectionID");

		List<MasEmploymentsubtype> empCatList = employeeAppointmentService.getList(null,
				"MasEmploymentsubtype.findAll");
		List<PpDesignationmaster> designationList = employeeAppointmentService.getList(null,
				"PpDesignationmaster.findAll");

		System.out.println("List Size : " + empCatList.size());
		showSearchModel.addObject("empCatList", empCatList);
		showSearchModel.addObject("designationList", designationList);
		showSearchModel.addObject("showForm", true);
		showSearchModel.addObject("sectionID", sectionID);
		
		HttpSession session = request.getSession();

		showSearchModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		showSearchModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		return showSearchModel;
	}
	
	/****************
	 * POPULATE LIST OF EMPLOYEES
	 ***************************/

	@RequestMapping(value = "/getEmpListForAddSection", method = RequestMethod.POST)
	public ModelAndView getEmpListForAddSection(
			@ModelAttribute("showSearchListDTO") ShowSearchListDTO showSearchListDTO, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView getEmpListForAddSectionModel = new ModelAndView("EmpListforAddMore");
		// String sectionname= request.getParameter("sectionname");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		List<ViewSearchResult> list = managePayBillService.getEmpListForAddSection(rmOfficeid + "",
				this.createPredicate(showSearchListDTO));
		System.out.println("List Size : " + list.size());
		getEmpListForAddSectionModel.addObject("list", list);
		getEmpListForAddSectionModel.addObject("showList", true);
		getEmpListForAddSectionModel.addObject("sectionname", showSearchListDTO.getSectionname());
		getEmpListForAddSectionModel.addObject("sectionID", showSearchListDTO.getSectionID());

		getEmpListForAddSectionModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		getEmpListForAddSectionModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		return getEmpListForAddSectionModel;
	}

	/****************
	 * ADD EMPLOYEE IN SECTION
	 ***************************/

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/EmplistforAddMore", method = RequestMethod.POST)
	public ModelAndView EmplistforAddMore(@ModelAttribute("sectionMasterDTO") SectionMasterDTO sectionMasterDTO,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView EmplistforAddMore = new ModelAndView(returnPage);
		String a = "";
		String ppEmployeeMasterID = "";

		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			System.out.println(rmOfficeid + "--" + sectionMasterDTO.getSectionID());

			ArrayList<String> list1 = sectionMasterDTO.getPpEmployeemasterid();
			Iterator itr = list1.iterator();

			while (itr.hasNext()) {
				a = (String) itr.next();
				ppEmployeeMasterID = a + "|" + ppEmployeeMasterID;
			}

			System.out.println(ppEmployeeMasterID);

			boolean isComplete = managePayBillService.setSectionID(ppEmployeeMasterID, sectionMasterDTO.getSectionID());

			if (isComplete == true) {
				EmplistforAddMore.addObject("msg", "Procedure PROC_PP_CHANGE_EMP_SECTION executed");
				System.out.println("PROC_PP_CHANGE_EMP_SECTION executed successfully");
			} else {
				EmplistforAddMore.addObject("msg", "error");
				System.out.println("exception in PROC_PP_CHANGE_EMP_SECTION");
			}

			String sectionName = sectionMasterService.populateSectionMaster(sectionMasterDTO.getSectionID());
			System.out.println(sectionMasterDTO.getSectionID() + "---------" + sectionName + "---zzzz--");
			List<ViewListForAssignRegister> list = managePayBillService.getEmpList(rmOfficeid,
					sectionMasterDTO.getSectionID());
			List<PpRegistermaster> registerList = managePayBillService.getRegisterList();

			EmplistforAddMore.addObject("sectionName", sectionName);
			EmplistforAddMore.addObject("sectionID", sectionMasterDTO.getSectionID());
			EmplistforAddMore.addObject("empList", list);
			EmplistforAddMore.addObject("registerList", registerList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();

		EmplistforAddMore.addObject("employee_name", (String) session.getAttribute("employeename"));
		EmplistforAddMore.addObject("designation_", (String) session.getAttribute("designation"));
		
		return EmplistforAddMore;
	}

	/****************
	 * CHANGE REGISTER
	 ***************************/

	@RequestMapping(value = "/updateRegister", method = RequestMethod.POST)
	public ModelAndView updateRegister(@ModelAttribute("sectionMasterDTO") SectionMasterDTO sectionMasterDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView UpdateRegister = new ModelAndView(returnPage);
		Boolean isComplete = false;
		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			System.out.println(rmOfficeid + "--" + sectionMasterDTO.getSectionID());
			
			System.out.println("pp_EmployeeMasterID --- "+sectionMasterDTO.getPpEmployeemasterid()+" --- selected Register --- "+sectionMasterDTO.getSelectedRegister());

			isComplete = sectionMasterService.updateEmpRegister(sectionMasterDTO.getPpEmployeemasterid(),
					sectionMasterDTO.getSelectedRegister());

			if (isComplete == true) {
				UpdateRegister.addObject("msg", "Record Updated Successfully");
				System.out.println("PROC_PP_UPDATE_EMP_REGISTER executed successfully");
			} else {
				UpdateRegister.addObject("msg", "Error");
				System.out.println("exception in PROC_PP_UPDATE_EMP_REGISTER");
			}

			String sectionName = sectionMasterService.populateSectionMaster(sectionMasterDTO.getSectionID());
			System.out.println(sectionMasterDTO.getSectionID() + "---------" + sectionName + "---zzzz--");
			List<ViewListForAssignRegister> list = managePayBillService.getEmpList(rmOfficeid,
					sectionMasterDTO.getSectionID());
			List<PpRegistermaster> registerList = managePayBillService.getRegisterList();
			System.out.println(list.size());
			UpdateRegister.addObject("sectionName", sectionName);
			UpdateRegister.addObject("sectionID", sectionMasterDTO.getSectionID());
			UpdateRegister.addObject("empList", list);
			UpdateRegister.addObject("registerList", registerList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();

		UpdateRegister.addObject("employee_name", (String) session.getAttribute("employeename"));
		UpdateRegister.addObject("designation_", (String) session.getAttribute("designation"));
		
		return UpdateRegister;
	}

	/* ------------------------------------------------ */

	private String createPredicate(ShowSearchListDTO form) {
		String predicate = "";
		try {
			if (form.getEmployeeCode() != null && form.getEmployeeCode().trim().length() > 0)
				predicate += " and lower(EmployeeCode) like '" + form.getEmployeeCode().trim().toLowerCase() + "%' ";
			if (form.getFirstName() != null && form.getFirstName().trim().length() > 0)
				predicate += " and lower(FirstName) like '" + form.getFirstName().trim().toLowerCase() + "%' ";
			if (form.getLastName() != null && form.getLastName().trim().length() > 0)
				predicate += " and lower(LastName) like '" + form.getLastName().toLowerCase() + "%'  ";
			if (form.getMas_EmploymentSubTypeID() != null && !form.getMas_EmploymentSubTypeID().equals("-1"))
				predicate += " and emp.Mas_EmploymentSubTypeID = '" + form.getMas_EmploymentSubTypeID() + "' ";
			if (form.getPp_DesignationMasterID() != null && !form.getPp_DesignationMasterID().equals("-1"))
				predicate += " and emp.pp_DesignationMasterID = '" + form.getPp_DesignationMasterID() + "' ";
		} catch (Exception e) {
			System.out.println("Exception Raised in " + e.toString());
		}
		return predicate;
	}

}
