/******************************** CONTROLLER FOR JOINING OF EMPLOYEES AND RELIEVE EMPLOYEES ON EL IN POSTING STATUS **************************/
/* ==========================================================================
 * Description  : This class implements controller operations for Joining of Employees and Relieve Employees on EL in Posting Status.
 * Date         : 
 *  Author      : VIKAS SINGH
 * Review By    : 
 * Review Date  :  
 *==========================================================================
 */

/** This is a controller class used for Joining of Employees and Relieve Employees on EL in Posting Status. 
 *  Controller class get's the request from JSP pages,
 *  based on the requirement , methods of service class are called  and finally response is send to the JSP pages.
 * **/

/** Package Name **/
package com.nic.upjn.spring.controller;

/**********************************LIBRARIES USED ********************************/
/** BeanUtils class copy the similar property of Bean class to another class  **/

/**AUTOWIRED Annotation      : Used for creating the object of class without using new keyword 
 Controller Annotation		 : Used to make controller class of any defined simple class . This class is capable to initiate request and response between JSP and Controller 
 ModelAttribute Annotation 	 : It automatically sets the values from JSP to DTO class.Variable name must be same in both JSP and DTO
 RequestMapping annotation 	 : Used for mapping URL to the method of controller class  
 RequestMethod annotation 	 : Used for identifying type of request generated from JSP  
 SessionStatus class 		 : Represents current status of the Session 
 ModelAndView class			 : It is Responsible for setting views and objects required by JSP Pages 
 PostingStatusService Interface : It contains all abstract methods used for Posting Status
 JoinEmployeeDTO             : Contains the getter and setter of JSP variables
 RelieveELDTO class 		 : Contains the getter and setter of JSP variables 


/** Imports required number of classes that are used in this particular class **/
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.miscellaneous.ComboService;
import com.nic.upjn.spring.Service.PostingStatusService;
import com.nic.upjn.spring.dto.JoinEmployeeDTO;
import com.nic.upjn.spring.dto.RelieveELDTO;
import com.nic.upjn.spring.entity.MasDistrict;
import com.nic.upjn.spring.entity.MasEmploymentsubtype;
import com.nic.upjn.spring.entity.PpDesignationmaster;
import com.nic.upjn.spring.entity.ViewEmplistforTrJoining;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;
import com.nic.upjn.spring.entity.ViewPpEmployeeOnel;

@Controller
public class JoinEmployeeController {

	ComboService comboService = new ComboService();

	@Autowired
	private PostingStatusService postingStatusService;

	/***************************************************
	 * JOIN Employee In Posting Status
	 ***************************************************/

	/**
	 * This method is called by default whenever a click event occurs on form
	 **/

	@RequestMapping(value = "/joinEmployeeList")
	public ModelAndView joinemployeeList(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("joinEmployeeDTO") JoinEmployeeDTO joinEmployeeDTO) {

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		System.out.println(rmOfficeid);
		@SuppressWarnings("unchecked")
		List<ViewEmplistforTrJoining> list = (List<ViewEmplistforTrJoining>) postingStatusService.getList(rmOfficeid,
				"ViewEmplistforTrJoining.findByRmOfficeid");

		ModelAndView target = new ModelAndView("JoiningListing");
		target.addObject("edit", list);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}

	/** This method is used to populate the details of employee for joining **/

	@RequestMapping(value = "/joinEmployeeDetails")
	public ModelAndView joinemployeeDetails(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("joinEmployeeDTO") JoinEmployeeDTO joinEmployeeDTO) {

		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		String ppTransferdetailid = request.getParameter("ppTransferdetailid");

		@SuppressWarnings("unchecked")
		List<ViewEmployeeSearch> list = (List<ViewEmployeeSearch>) postingStatusService.getList(ppEmployeemasterid,
				"ViewEmployeeSearch.findByPpEmployeemasterid");

		for (ViewEmployeeSearch viewEmployeeSearch : list) {

			BeanUtils.copyProperties(viewEmployeeSearch, joinEmployeeDTO);
		}

		ModelAndView target = new ModelAndView("JoiningDetails");
		target.addObject("list", list);
		target.addObject("ppTransferdetailid", ppTransferdetailid);
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}

	/**
	 * This method is used to Join the Employee on the basis of
	 * ppTransferdetailid
	 **/
	@RequestMapping("/joinEmployee")
	public ModelAndView joinemployee(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("joinEmployeeDTO") JoinEmployeeDTO joinEmployeeDTO) {

		ModelAndView target = new ModelAndView("JoiningListing");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		@SuppressWarnings("unused")
		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		String ppTransferdetailid = request.getParameter("ppTransferdetailid");

		joinEmployeeDTO.setPpTransferdetailid(ppTransferdetailid);

		int result = postingStatusService.proc_execute(joinEmployeeDTO);

		if (result == 1) {
			target.addObject("msg", "Record inserted successfully");
		} else {
			target.addObject("msg", "error occurred");
		}

		@SuppressWarnings("unchecked")
		List<ViewEmplistforTrJoining> list = (List<ViewEmplistforTrJoining>) postingStatusService.getList(rmOfficeid,
				"ViewEmplistforTrJoining.findByRmOfficeid");

		target.addObject("edit", list);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;
	}

	/***************************************************************
	 * RelieveEL in Posting Status
	 ***************************************************************************/

	/**
	 * This method is called by default whenever a click event occurs on form
	 **/
	@RequestMapping("/RelieveEL")
	public ModelAndView RelieveEL(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("relieveELDTO") RelieveELDTO relieveELDTO) {

		ModelAndView target = new ModelAndView("RelieveEL");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		@SuppressWarnings("unchecked")
		List<ViewPpEmployeeOnel> list = (List<ViewPpEmployeeOnel>) postingStatusService.getList(rmOfficeid,
				"ViewPpEmployeeOnel.findByRmOfficeid");

		for (ViewPpEmployeeOnel viewPpEmployeeOnel : list) {
			BeanUtils.copyProperties(viewPpEmployeeOnel, relieveELDTO);
		}

		int empdetailsize = 0;
		int empdetailsizetransfer = 0;
		int listsize = list.size();
		if (listsize == 0) {
			target.addObject("list_msg", "No record found");
		}

		target.addObject("list", list);
		target.addObject("empdetailsize", empdetailsize);
		target.addObject("empdetailsizetransfer", empdetailsizetransfer);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;
	}

	/**
	 * This method is used to populate the Search Employee Page with Designation
	 * and Category List
	 **/
	@RequestMapping("/SearchEmployeeforRelieveEL")
	public ModelAndView SearchEmployeeforRelieveEL(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("relieveELDTO") RelieveELDTO relieveELDTO) {

		@SuppressWarnings("unchecked")
		List<PpDesignationmaster> list = (List<PpDesignationmaster>) postingStatusService.getList(null,
				"PpDesignationmaster.findAll");

		for (PpDesignationmaster PpDesignationmaster : list) {
			relieveELDTO.setDesignation(PpDesignationmaster.getDesignation());
			relieveELDTO.setPpDesignationmasterid(PpDesignationmaster.getPpDesignationmasterid() + "");
		}

		@SuppressWarnings("unchecked")
		List<MasEmploymentsubtype> list1 = (List<MasEmploymentsubtype>) postingStatusService.getList(null,
				"MasEmploymentsubtype.findAll");

		for (MasEmploymentsubtype MasEmploymentsubtype : list1) {

			BeanUtils.copyProperties(MasEmploymentsubtype, relieveELDTO);

		}

		ModelAndView target = new ModelAndView("SearchEmployeeforRelieveEL");
		target.addObject("designationlist", list);
		target.addObject("categorylist", list1);

		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}

	/**
	 * This method is used to search a particular employee on the basis of
	 * user's input
	 **/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/SearchEmployeebyidRelieveEL")
	public ModelAndView searchEmployeebyid(HttpServletRequest request, HttpServletResponse response) {
		String SQL;
		RelieveELDTO relieveELDTO = new RelieveELDTO();

		ModelAndView target = new ModelAndView("SearchEmployeeListRelieveEL");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		List<ViewEmployeeSearch> list = null;
		List<ViewEmployeeSearch> list1 = null;
		String empcode = request.getParameter("employeecode");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String masEmploymentsubtypeid = request.getParameter("masEmploymentsubtypeid");
		String ppDesignationmasterid = request.getParameter("ppDesignationmasterid");

		if (ppDesignationmasterid.equals("[Select Designation]")) {
			ppDesignationmasterid = "";
		}
		if (masEmploymentsubtypeid.equals("[Select Category]")) {
			masEmploymentsubtypeid = "";
		}

		if (empcode.equals("") && firstname.equals("") && lastname.equals("") && masEmploymentsubtypeid == ""
				&& ppDesignationmasterid == "") {

			list = (List<ViewEmployeeSearch>) postingStatusService.getList(rmOfficeid,
					"ViewEmployeeSearch.findByRmOfficeid");

			for (ViewEmployeeSearch viewEmployeeSearch : list) {
				relieveELDTO.setEmployeecode(viewEmployeeSearch.getEmployeecode());
				relieveELDTO.setDesignation(viewEmployeeSearch.getDesignation());
				relieveELDTO.setEmployeename(viewEmployeeSearch.getEmployeename());
				relieveELDTO.setEmploymenttype(viewEmployeeSearch.getEmploymenttype());
				relieveELDTO.setEmploymentsubtype(viewEmployeeSearch.getEmploymentsubtype());
			}
		}

		else {
			System.out.println("----!!!!12222 " + ppDesignationmasterid);

			relieveELDTO.setEmployeecode(request.getParameter("employeecode"));
			relieveELDTO.setFirstname(request.getParameter("firstname"));
			relieveELDTO.setLastname(request.getParameter("lastname"));
			relieveELDTO.setMasEmploymentsubtypeid(request.getParameter("masEmploymentsubtypeid"));
			relieveELDTO.setPpDesignationmasterid(request.getParameter("ppDesignationmasterid"));
			String predicate = " ISFUNCTIONING='1'";
			SQL = postingStatusService.createSearchSQL(predicate, relieveELDTO, rmOfficeid);

			list1 = postingStatusService.getTransferList(SQL);
		}

		target.addObject("list", list);
		target.addObject("empcode", empcode);
		target.addObject("list1", list1);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;
	}

	/** This method is used to populate details of selected Employee **/
	@RequestMapping("/populateRelieveELDetails")
	public ModelAndView populateRelieveELDetails(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("relieveELDTO") RelieveELDTO relieveELDTO) {
		String empcode = null;
		ModelAndView target = new ModelAndView("RelieveEL");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		if (relieveELDTO.getEmployeecode() != null) {
			empcode = relieveELDTO.getEmployeecode();
			System.out.println("relieveELDTO emp  code----------" + relieveELDTO.getEmployeecode());
		}
		if (request.getParameter("employee") != null) {
			empcode = request.getParameter("employee");
			System.out.print("employeecode by selection  ---- " + empcode);
		}

		String rmID = Integer.toString(rmOfficeid);
		System.out.println(rmID + "--RmID is the String value of rmofficeID");

		String[] data = postingStatusService.executeProcedurePP_VALIDATEEMPGETINFO(empcode, rmID, "relOnEl", "add");

		int size = data.length;
		System.out.println("I am size of Employee details array--" + size);

		request.setAttribute("nameofemployee", data[0]);
		relieveELDTO.setEmployeename(data[0]);

		request.setAttribute("designationofemployee", data[1]);
		relieveELDTO.setDesignation(data[1]);

		request.setAttribute("ppEmployeemasterid", data[2]);
		relieveELDTO.setPpEmployeemasterid(data[2]);

		if (data[0] == null) {
			target.addObject("msg", "Invalid Employee code");
		}

		System.out.print(relieveELDTO.getEmployeename() + "---" + relieveELDTO.getDesignation() + "employeecode--"
				+ empcode + "--dataa--" + data[2]);

		relieveELDTO.setEmployeecode(empcode);

		@SuppressWarnings("unchecked")
		List<ViewPpEmployeeOnel> list = (List<ViewPpEmployeeOnel>) postingStatusService.getList(rmOfficeid,
				"ViewPpEmployeeOnel.findByRmOfficeid");

		int empdetailsize = 0;
		int empdetailsizetransfer = 0;

		target.addObject("list", list);
		target.addObject("empdetailsize", empdetailsize);
		target.addObject("empdetailsizetransfer", empdetailsizetransfer);
		target.addObject("empcode", empcode);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;
	}

	/**
	 * This method is used to add a New Employee for "Relieve on Earn Leave"
	 * process
	 **/
	@RequestMapping("/addRelieveEL")
	public ModelAndView addRelieveEL(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("relieveELDTO") RelieveELDTO relieveELDTO) {

		ModelAndView target = new ModelAndView("RelieveEL");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		relieveELDTO.setRmOfficeid(Integer.toString(rmOfficeid));
		relieveELDTO.setIsJoined("0");

		System.out.print(relieveELDTO.getPpEmployeemasterid() + "---" + relieveELDTO.getRelorderno() + "---"
				+ relieveELDTO.getRelorderdate() + "---" + relieveELDTO.getIsJoined() + "---"
				+ relieveELDTO.getRmOfficeid());

		int result = postingStatusService.proc_executePROC_PP_ADDELDETAIL(relieveELDTO);

		if (result == 1) {

			target.addObject("msg", "Data Submitted Successfully");
		} else {

			target.addObject("msg", "error");
		}

		@SuppressWarnings("unchecked")
		List<ViewPpEmployeeOnel> list = (List<ViewPpEmployeeOnel>) postingStatusService.getList(rmOfficeid,
				"ViewPpEmployeeOnel.findByRmOfficeid");

		target.addObject("list", list);

		int empdetailsize = 0;
		int empdetailsizetransfer = 0;
		target.addObject("empdetailsize", empdetailsize);
		target.addObject("empdetailsizetransfer", empdetailsizetransfer);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}

	/**
	 * This method will Delete the selected Employee from
	 * "Relieve on Earn Leave" process List
	 **/
	@SuppressWarnings("unused")
	@RequestMapping("/deleteRelieveEL")
	public ModelAndView deleteRelieveEL(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("relieveELDTO") RelieveELDTO relieveELDTO) {

		ModelAndView target = new ModelAndView("RelieveEL");

		try {

			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			String ppEmployeeEldetailid = request.getParameter("ID");
			String ppEmployeemasterid = request.getParameter("ID1");

			boolean result = postingStatusService.deleteRelieveEL(ppEmployeeEldetailid);

			System.out.println(result + "---result");

			if (result == true) {
				System.out.println("Data Deleted Successfully");
				target.addObject("msg", "Data Deleted Successfully");
			}

			@SuppressWarnings("unchecked")
			List<ViewPpEmployeeOnel> list = (List<ViewPpEmployeeOnel>) postingStatusService.getList(rmOfficeid,
					"ViewPpEmployeeOnel.findByRmOfficeid");

			target.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}

	/**
	 * This method is used to provide Details of Employee for Joining after
	 * "Relieve on Earn Leave" process
	 */
	@RequestMapping("/EmpJoinRelieveELdetail")
	public ModelAndView EmpJoinRelieveEL(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("relieveELDTO") RelieveELDTO relieveELDTO) {

		ModelAndView target = new ModelAndView("RelieveEL");

		try {
			String ppEmployeeEldetailid = request.getParameter("ID");
			String employeecode = request.getParameter("ID1");

			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			String rmID = Integer.toString(rmOfficeid);

			System.out.println(employeecode + "--data---" + ppEmployeeEldetailid);

			String[] data = postingStatusService.executeProcedurePP_VALIDATEEMPGETINFO(employeecode, rmID, "relOnEl",
					"add");

			request.setAttribute("nameofemployeename", data[0]);
			relieveELDTO.setEmployeename(data[0]);

			request.setAttribute("designationofemployee", data[1]);
			relieveELDTO.setDesignation(data[1]);

			request.setAttribute("ppEmployeemasterid", data[2]);
			relieveELDTO.setPpEmployeemasterid(data[2]);

			System.out
					.print(relieveELDTO.getEmployeename() + "---" + relieveELDTO.getDesignation() + "---employeecode--"
							+ employeecode + "--ppEmployeemasterid--" + relieveELDTO.getPpEmployeemasterid());

			relieveELDTO.setEmployeecode(employeecode);

			@SuppressWarnings("unchecked")
			List<ViewPpEmployeeOnel> empdetail = (List<ViewPpEmployeeOnel>) postingStatusService
					.getList(ppEmployeeEldetailid, "ViewPpEmployeeOnel.findByPpEmployeeEldetailid");

			int empdetailsize = empdetail.size();
			int empdetailsizetransfer = 0;

			System.out.println(empdetailsize);

			@SuppressWarnings("unchecked")
			List<ViewPpEmployeeOnel> list = (List<ViewPpEmployeeOnel>) postingStatusService.getList(rmOfficeid,
					"ViewPpEmployeeOnel.findByRmOfficeid");

			target.addObject("list", list);
			target.addObject("empdetail", empdetail);
			target.addObject("empdetailsize", empdetailsize);
			target.addObject("empdetailsizetransfer", empdetailsizetransfer);
			target.addObject("empcode", employeecode);

		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}

	/**
	 * This method will Join the Employee after "Relieve on Earn Leave" process
	 **/
	@RequestMapping("/joinRelieveEL")
	public ModelAndView joinRelieveEL(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("relieveELDTO") RelieveELDTO relieveELDTO) {
		ModelAndView target = new ModelAndView("RelieveEL");

		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			System.out.println(relieveELDTO.getPpEmployeemasterid() + "  " + relieveELDTO.getPpEmployeeEldetailid()
					+ "  " + relieveELDTO.getJoiningorderdate() + "  " + relieveELDTO.getJoiningorder() + "  "
					+ relieveELDTO.getJoiningdate() + "  " + relieveELDTO.getJoininganfn());

			int result = postingStatusService.PROC_PP_JOINELDETAIL(relieveELDTO);

			if (result == 1) {
				target.addObject("msg", "Employee joined successfully");
			} else {
				target.addObject("msg", "Error");
			}

			@SuppressWarnings("unchecked")
			List<ViewPpEmployeeOnel> list = (List<ViewPpEmployeeOnel>) postingStatusService.getList(rmOfficeid,
					"ViewPpEmployeeOnel.findByRmOfficeid");
			int listsize = list.size();
			if (listsize == 0) {
				target.addObject("record_msg", "No record found");
			}
			target.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}

	/**
	 * This method is used to provide details of Employee for Transfer after
	 * "Relieve on Earn Leave" process
	 */
	@RequestMapping("/transferRelieveELdetail")
	public ModelAndView transferRelieveELdetail(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("relieveELDTO") RelieveELDTO relieveELDTO) {

		ModelAndView target = new ModelAndView("RelieveEL");

		System.out.println("transfer EL detail");
		try {
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			HashMap<Integer, String> hm1 = new HashMap<Integer, String>();

			String ppEmployeeEldetailid = request.getParameter("ID");
			String employeecode = request.getParameter("ID1");

			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			String rmID = Integer.toString(rmOfficeid);

			System.out.println(employeecode + "--data---" + ppEmployeeEldetailid);

			String[] data = postingStatusService.executeProcedurePP_VALIDATEEMPGETINFO(employeecode, rmID, "relOnEl",
					"add");

			request.setAttribute("employeename", data[0]);
			relieveELDTO.setEmployeename(data[0]);

			request.setAttribute("designation", data[1]);
			relieveELDTO.setDesignation(data[1]);

			request.setAttribute("ppEmployeemasterid", data[2]);
			relieveELDTO.setPpEmployeemasterid(data[2]);

			System.out
					.print(relieveELDTO.getEmployeename() + "---" + relieveELDTO.getDesignation() + "---employeecode--"
							+ employeecode + "--ppEmployeemasterid--" + relieveELDTO.getPpEmployeemasterid());

			@SuppressWarnings("unchecked")
			List<ViewPpEmployeeOnel> empdetail = (List<ViewPpEmployeeOnel>) postingStatusService
					.getList(ppEmployeeEldetailid, "ViewPpEmployeeOnel.findByPpEmployeeEldetailid");

			int empdetailsize = empdetail.size();

			System.out.println(empdetailsize);

			@SuppressWarnings("unchecked")
			List<ViewPpEmployeeOnel> list = (List<ViewPpEmployeeOnel>) postingStatusService.getList(rmOfficeid,
					"ViewPpEmployeeOnel.findByRmOfficeid");

			/* code for office combo */
			hm = comboService.officeAndDistrict(postingStatusService);
			request.setAttribute("str", "hello");
			@SuppressWarnings("unchecked")
			List<MasDistrict> list2 = (List<MasDistrict>) postingStatusService.getList(null, "MasDistrict.findAll");
			for (MasDistrict masDistrict : list2) {
				hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());
			}

			target.addObject("Data", hm);
			target.addObject("Data1", hm1);
			target.addObject("list", list);
			target.addObject("empdetailtransfer", empdetail);
			target.addObject("empdetailsizetransfer", empdetailsize);
			target.addObject("empcode", employeecode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}

	/**
	 * This method is used for Transfer employee after "Relieve on Earn Leave"
	 * process
	 **/
	@RequestMapping("/transferRelieveEL")
	public ModelAndView transferRelieveEL(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("relieveELDTO") RelieveELDTO relieveELDTO) {

		ModelAndView target = new ModelAndView("RelieveEL");

		try {
			System.out.println("i m in transfer method");

			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			String rmID = Integer.toString(rmOfficeid);

			relieveELDTO.setRmOfficeid(rmID);

			System.out.println(relieveELDTO.getPpEmployeeEldetailid() + " -- " + relieveELDTO.getPpEmployeemasterid()
					+ " -- " + relieveELDTO.getTransferordno() + " -- " + relieveELDTO.getTransferorderdate() + " -- "
					+ relieveELDTO.getOfficeto() + " -- " + relieveELDTO.getRmOfficeid());

			int result = postingStatusService.executeProc(relieveELDTO);

			if (result == 1) {
				target.addObject("msg", "Employee transferred successfully");
			} else {
				target.addObject("msg", "Error");
			}

			@SuppressWarnings("unchecked")
			List<ViewPpEmployeeOnel> list = (List<ViewPpEmployeeOnel>) postingStatusService.getList(rmOfficeid,
					"ViewPpEmployeeOnel.findByRmOfficeid");

			target.addObject("list", list);

			int empdetailsize = 0;
			int empdetailsizetransfer = 0;

			target.addObject("empdetailsize", empdetailsize);
			target.addObject("empdetailsizetransfer", empdetailsizetransfer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}
}