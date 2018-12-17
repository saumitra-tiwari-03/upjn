/******************************** EMPLOYEE TRANSFER CONTROLLER **************************/

/* ==========================================================================
 * Description 	: This class implements controller operations for Transfer of Employees.
 * Date			: 
 * Author       : VIKAS SINGH
 * Review By    : 
 * Review Date  :  
 *==========================================================================
 */


/**This is a controller class used for Transfer of Employees. Controller class get's the request from JSP pages,
 *  based on the requirement , methods of service class are called  and finally response is send to the JSP pages.
 * **/

/** Package Name **/
package com.nic.upjn.spring.controller;


import java.util.Date;

/**********************************LIBRARIES USED ********************************/
/** BeanUtils class copy the similar property of Bean class to another class  **/

/**AUTOWIRED Annotation 	: Used for creating the object of class without using new keyword 
  Controller Annotation 	: Used to make controller class of any defined simple class . This class is capable to initiate request and response between JSP and Controller 
 ModelAttribute Annotation 	: It automatically sets the values from JSP to DTO class.Variable name must be same in both JSP and DTO
 RequestMapping annotation 	: Used for mapping URL to the method of controller class  
 RequestMethod annotation 	: Used for identifying type of request generated from JSP  
 SessionStatus class 		: Represents current status of the Session 
 ModelAndView class			: It is Responsible for setting views and objects required by JSP Pages 
 PostingStatusService Interface : It contains all abstract methods used for Posting Status
 TransferEmployeeDTO class	 : Contains the getter and setter of JSP variables 

/** Imports required number of classes that are used in this particular class **/
import java.util.List;

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

import com.nic.upjn.miscellaneous.ComboService;
import com.nic.upjn.spring.Service.PostingStatusService;
import com.nic.upjn.spring.dto.SearchEmployeeDTO;
import com.nic.upjn.spring.dto.TransferEmployeeDTO;
import com.nic.upjn.spring.entity.MasEmploymentsubtype;
import com.nic.upjn.spring.entity.PpDesignationmaster;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;
import com.nic.upjn.spring.entity.ViewNodueslist;

import com.nic.upjn.spring.entity.PpNoduesdetail;


@Controller
public class EmployeeTransferController {

	@Autowired
	private PostingStatusService postingStatusService;

	ComboService comboService = new ComboService();

	/** This method is called by default whenever a click event occurs on form **/
	@RequestMapping(value = "/transferEmployee", method = RequestMethod.GET)
	public ModelAndView begin(HttpServletRequest request,
			HttpServletResponse response) {

		TransferEmployeeDTO transferEmployeeDTO = new TransferEmployeeDTO();

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		System.out.println(rmOfficeid+"--i m rm_office id in transfer");
		
		@SuppressWarnings("unchecked")
		List<ViewNodueslist> list = (List<ViewNodueslist>) postingStatusService
				.getList(rmOfficeid, "ViewNodueslist.findByRmOfficeid");

		for (ViewNodueslist viewNodueslist : list) {

			BeanUtils.copyProperties(viewNodueslist, transferEmployeeDTO);
			System.out.println(transferEmployeeDTO.getNoduesorddate()+" no issue ord date "+viewNodueslist.getNoduesorddate());
		}
		
		ModelAndView target = new ModelAndView("Transfer");
		target.addObject("list", list);

		 target.addObject("employee_name", (String) session.getAttribute("employeename"));
		 target.addObject("designation_", (String) session.getAttribute("designation"));
		 
		return target;
	}

	
	/** This method is used to populate the search employee page with designation and category list **/
	
	@RequestMapping(value = "/SearchEmployee")
	public ModelAndView searchEmployee(HttpServletRequest request,HttpServletResponse response) {

		TransferEmployeeDTO transferEmployeeDTO = new TransferEmployeeDTO();

		@SuppressWarnings("unchecked")
		List<PpDesignationmaster> list = (List<PpDesignationmaster>) postingStatusService
				.getList(null, "PpDesignationmaster.findAll");

		for (PpDesignationmaster PpDesignationmaster : list) {
			transferEmployeeDTO.setDesignation(PpDesignationmaster
					.getDesignation());
			transferEmployeeDTO.setPpDesignationmasterid(PpDesignationmaster
					.getPpDesignationmasterid() + "");
		}

		@SuppressWarnings("unchecked")
		List<MasEmploymentsubtype> list1 = (List<MasEmploymentsubtype>) postingStatusService
				.getList(null, "MasEmploymentsubtype.findAll");

		for (MasEmploymentsubtype MasEmploymentsubtype : list1) {
			BeanUtils.copyProperties(MasEmploymentsubtype, transferEmployeeDTO);
		}

		ModelAndView target = new ModelAndView("SearchEmployee");
		target.addObject("designationlist", list);
		target.addObject("categorylist", list1);
		
		HttpSession session = request.getSession();

		 target.addObject("employee_name", (String) session.getAttribute("employeename"));
		 target.addObject("designation_", (String) session.getAttribute("designation"));
		 
		return target;
	}

	/** This method is used to Search Employees for Transfer **/

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/SearchEmployeebyid")
	public ModelAndView searchEmployeebyid(HttpServletRequest request,
			HttpServletResponse response) {
		String SQL;
		SearchEmployeeDTO searchEmployeeDTO = new SearchEmployeeDTO();

		ModelAndView target = new ModelAndView("searchEmployeeList");
		
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		List<ViewEmployeeSearch> list = null;
		List<ViewEmployeeSearch> list1 = null;
		String employeecode = request.getParameter("employeecode");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String masEmploymentsubtypeid = request
				.getParameter("masEmploymentsubtypeid");
		String ppDesignationmasterid = request
				.getParameter("ppDesignationmasterid");

		if (ppDesignationmasterid.equals("[Select Designation]")) {
			ppDesignationmasterid = "";
		}
		if (masEmploymentsubtypeid.equals("[Select Category]")) {
			masEmploymentsubtypeid = "";
		}

		if (employeecode.equals("") && firstname.equals("")
				&& lastname.equals("") && masEmploymentsubtypeid == ""
				&& ppDesignationmasterid == "") {

			list = (List<ViewEmployeeSearch>) postingStatusService.getList(rmOfficeid, "ViewEmployeeSearch.findByRmOfficeid");

			for (ViewEmployeeSearch viewEmployeeSearch : list) {
				searchEmployeeDTO.setEmployeecode(viewEmployeeSearch
						.getEmployeecode());
				searchEmployeeDTO.setDesignation(viewEmployeeSearch
						.getDesignation());
				searchEmployeeDTO.setEmployeename(viewEmployeeSearch
						.getEmployeename());
				searchEmployeeDTO.setEmploymenttype(viewEmployeeSearch
						.getEmploymenttype());
				searchEmployeeDTO.setEmploymentsubtype(viewEmployeeSearch
						.getEmploymentsubtype());
			}
		}

		else {
			searchEmployeeDTO.setEmployeecode(request
					.getParameter("employeecode"));
			searchEmployeeDTO.setFirstname(request.getParameter("firstname"));
			searchEmployeeDTO.setLastname(request.getParameter("lastname"));
			searchEmployeeDTO.setMasEmploymentsubtypeid(request
					.getParameter("masEmploymentsubtypeid"));
			searchEmployeeDTO.setPpDesignationmasterid(request
					.getParameter("ppDesignationmasterid"));
			String predicate = " ISFUNCTIONING='1'";
			
			searchEmployeeDTO.setRmOfficeid(rmOfficeid);
			
			SQL = postingStatusService.createSearchSQL(predicate, searchEmployeeDTO, rmOfficeid);

			list1 = postingStatusService.getTransferList(SQL);
		}

		target.addObject("list", list);
		target.addObject("employeecode", employeecode);
		target.addObject("list1", list1);

		 target.addObject("employee_name", (String) session.getAttribute("employeename"));
		 target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;
	}

	

	/** This method is used to populate the details of selected Employee **/
	@RequestMapping(value = "/populateTransferDetails", method = RequestMethod.POST)
	public ModelAndView populateTransferDetails(HttpServletRequest request,
			HttpServletResponse response) {

		TransferEmployeeDTO transferEmployeeDTO = new TransferEmployeeDTO();
		ModelAndView target = new ModelAndView("Transfer");

		String empcode = request.getParameter("employee");
		System.out.print("employeecode   ---- " + empcode);

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		if (empcode.equals(null)) {
			target.addObject("msg", "Employee code is invalid");
		}

		@SuppressWarnings("unchecked")
		List<ViewNodueslist> list = (List<ViewNodueslist>) postingStatusService
				.getList(rmOfficeid, "ViewNodueslist.findByRmOfficeid");
		
		String rmID =  Integer.toString(rmOfficeid);
		
		System.out.println(rmID+"--RmID is the String value of rmofficeID");
		
		String[] data = postingStatusService
				.executeProcedurePP_VALIDATEEMPGETINFO(empcode, rmID,
						"noDues", "add");

		System.out.println(data[0] + "---" + data[1] + "---" + data[2]);
		
		if (data[2] == null) {

			target.addObject("msg", "Invalid Employee Code");

		}
		else{

		request.setAttribute("nameofemployee", data[0]);
		transferEmployeeDTO.setEmployeename(data[0]);

		request.setAttribute("designationofemployee", data[1]);
		transferEmployeeDTO.setDesignation(data[1]);

		request.setAttribute("PPEMPLOYEEMASTERID", data[2]);
		transferEmployeeDTO.setPpEmployeemasterid(Long.parseLong(data[2]));
		
		}

		target.addObject("list", list);
		target.addObject("empcode", empcode);
		target.addObject("nameofemployee", transferEmployeeDTO.getEmployeename());
		target.addObject("designationofemployee", transferEmployeeDTO.getDesignation());
		target.addObject("PPEMPLOYEEMASTERID",
				transferEmployeeDTO.getPpEmployeemasterid());


		 target.addObject("employee_name", (String) session.getAttribute("employeename"));
		 target.addObject("designation_", (String) session.getAttribute("designation"));
		 
		return target;
	}

	/** This method is used to Transfer the Selected Employee **/
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	public ModelAndView transfer(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("transferEmployeeDTO") TransferEmployeeDTO transferEmployeeDTO) {

		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		String ppNoduesdetailid = request.getParameter("ppNoduesdetailid");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		transferEmployeeDTO.setPpEmployeemasterid(Long
				.parseLong(ppEmployeemasterid));

		System.out.println(ppEmployeemasterid + "----------"
				+ ppNoduesdetailid);

		ModelAndView target = new ModelAndView("Transfer");

		PpNoduesdetail ppNoduesdetail = new PpNoduesdetail();

		System.out.println(transferEmployeeDTO.getNoduesorddate() + "  "
				+ "-----####");

		transferEmployeeDTO.setIson('1');
	//	transferEmployeeDTO.setIsFunctioning("0");
		transferEmployeeDTO.setEmployeecode(request.getParameter("employee"));

		try {
			BeanUtils.copyProperties(transferEmployeeDTO, ppNoduesdetail);
			List duplicateEmployee = postingStatusService.duplicateEmployee(transferEmployeeDTO.getEmployeecode());
			if(duplicateEmployee.size() < 1){
				if ((transferEmployeeDTO.getPpNoduesdetailid()).equals("")) {
					@SuppressWarnings("unused")
					boolean result = postingStatusService.insertD(ppNoduesdetail);
				} else {
					@SuppressWarnings("unused")
					boolean result = postingStatusService.update(ppNoduesdetail,
							ppNoduesdetailid);
				}
				target.addObject("msg","Employee Transferred successfully");
			}
			else{
				target.addObject("msg","Duplicate Record Found");
			}
			@SuppressWarnings("unchecked")
			List<ViewNodueslist> list = (List<ViewNodueslist>) postingStatusService
					.getList(rmOfficeid, "ViewNodueslist.findByRmOfficeid");
			target.addObject("list", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			target.addObject("msg","Error");
		}

		 target.addObject("employee_name", (String) session.getAttribute("employeename"));
		 target.addObject("designation_", (String) session.getAttribute("designation"));
		 
		return target;
	}

	/** This method is used to Edit the Transfer detail of Employees **/
	@RequestMapping(value = "/edittransfer")
	public ModelAndView edit(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("transferEmployeeDTO") TransferEmployeeDTO transferEmployeeDTO) {

		ModelAndView target = new ModelAndView("Transfer");
		String employeecode = request.getParameter("employeecode1");
		String ppNoduesdetailid = request.getParameter("ppNoduesdetailid1");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		System.out.println(ppNoduesdetailid + "-----gufhs----" + employeecode);

		@SuppressWarnings({ "unchecked" })
		List<ViewNodueslist> list = (List<ViewNodueslist>) postingStatusService
				.getList(ppNoduesdetailid,
						"ViewNodueslist.findByPpNoduesdetailid");

		for (ViewNodueslist viewNodueslist : list) {
			BeanUtils.copyProperties(viewNodueslist, transferEmployeeDTO);
			System.out.println(viewNodueslist.getNoduesorddate());
			target.addObject("noduesorddate", viewNodueslist.getNoduesorddate());
		}

		@SuppressWarnings("unchecked")
		List<ViewNodueslist> list1 = (List<ViewNodueslist>) postingStatusService
				.getList(rmOfficeid, "ViewNodueslist.findByRmOfficeid");

		target.addObject("list", list1);
		target.addObject("ppNoduesdetailid", ppNoduesdetailid);
		target.addObject("empcode", employeecode);
		target.addObject("nameofemployee", transferEmployeeDTO.getEmployeename());
		target.addObject("designationofemployee", transferEmployeeDTO.getDesignation());
		target.addObject("ppEmployeemasterid",
				transferEmployeeDTO.getPpEmployeemasterid());
		target.addObject("noduesordno", transferEmployeeDTO.getNoduesordno());

		 target.addObject("employee_name", (String) session.getAttribute("employeename"));
		 target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}

	/** This method is used for Deletion of Employees from transfer List **/
	@SuppressWarnings({ "unchecked", "unused" })
	@RequestMapping(value = "/deletetransfer")
	public ModelAndView delete(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("transferEmployeeDTO") TransferEmployeeDTO transferEmployeeDTO) {

		ModelAndView target = new ModelAndView("Transfer");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		try {

			String ppEmployeemasterid = request.getParameter("ID");
			String ppNoduesdetailid = request.getParameter("ID1");

			boolean result = postingStatusService.delete(ppNoduesdetailid);

			List<ViewNodueslist> list = (List<ViewNodueslist>) postingStatusService
					.getList(rmOfficeid, "ViewNodueslist.findByRmOfficeid");

			target.addObject("list", list);
			target.addObject("msg","Employee deleted successfully");
		} catch (Exception e) {
			target.addObject("msg","Error");
			e.printStackTrace();
		}

		 target.addObject("employee_name", (String) session.getAttribute("employeename"));
		 target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}

}
