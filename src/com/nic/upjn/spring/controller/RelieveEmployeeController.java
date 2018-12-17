/******************************** RELIEVE EMPLOYEE CONTROLLER **************************/
/* ==========================================================================
 * Description : This class implements controller operations for Relieving Employee in Posting Status.
 * Date:  
 * Author: VIKAS SINGH
 * Review By : 
 * Review Date:  
 *==========================================================================
 */

/** This is a controller class used for Relieve Employee in Posting Status. 
 *  Controller class get's the request from JSP pages,
 *  based on the requirement , methods of service class are called  and finally response is send to the JSP pages.
 * **/

/** Package Name **/
package com.nic.upjn.spring.controller;


/**********************************LIBRARIES USED ********************************/
/** BeanUtils class copy the similar property of Bean class to another class  **/

/**AUTOWIRED Annotation     : Used for creating the object of class without using new keyword 
 Controller Annotation      : Used to make controller class of any defined simple class . This class is capable to initiate request and response between JSP and Controller 
 ModelAttribute Annotation  : It automatically sets the values from JSP to DTO class.Variable name must be same in both JSP and DTO
 RequestMapping annotation  : Used for mapping URL to the method of controller class  
 RequestMethod annotation   : Used for identifying type of request generated from JSP  
 SessionStatus class        : Represents current status of the Session 
 ModelAndView class         : It is Responsible for setting views and objects required by JSP Pages 
 PostingStatusService Interface : It contains all abstract methods used for Posting Status
 RelieveEmployeeDTO class   : Contains the getter and setter of JSP variables 


/** Imports required number of classes that are used in this particular class **/
import java.io.IOException;
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
import com.nic.upjn.spring.Service.PostingStatusService;
import com.nic.upjn.spring.dto.RelieveEmployeeDTO;
import com.nic.upjn.spring.entity.MasDistrict;
import com.nic.upjn.spring.entity.MasEmploymentsubtype;
import com.nic.upjn.spring.entity.PpDesignationmaster;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;
import com.nic.upjn.spring.entity.ViewGetempnoduesdetail;
import com.nic.upjn.spring.entity.ViewPpTransferlist;

@Controller
public class RelieveEmployeeController {

	@Autowired
	private PostingStatusService postingStatusService;

	ComboService comboService = new ComboService();


	/** This method is used to populate Office Selection Combo **/
	@RequestMapping(value = "/OfficeSelectionController1", method = RequestMethod.PUT)
	public void getofficeName(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			HashMap<String, String> hmap = new HashMap<String, String>();
			String json = null;
			String district = request.getParameter("districtname");
			int districtid = Integer.parseInt(district);
			System.out.println("Id  of  is district is  ........   "
					+ districtid);
			String str = request.getParameter("ofname");
			int officeid = Integer.parseInt(str);
			System.out.println("ID of office is   ........        " + officeid);
			int[] where_condtion = new int[] { officeid, districtid };
			hmap = comboService.office(where_condtion, postingStatusService);
			json = new Gson().toJson(hmap);
			response.setContentType("application/json");
			response.getWriter().write(json);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** This method is called by default whenever a click event occurs on form  **/
	@RequestMapping(value = "/relievefortransfer")
	public ModelAndView relievefortransfer(HttpServletRequest request,
			HttpServletResponse response) {

		RelieveEmployeeDTO relieveEmployeeDTO = new RelieveEmployeeDTO();
		ModelAndView target = new ModelAndView("RelieveforTransfer");
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
		
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		@SuppressWarnings("unchecked")
		List<ViewPpTransferlist> list = (List<ViewPpTransferlist>) postingStatusService
				.getList(rmOfficeid, "ViewPpTransferlist.findByOfficefromid");

		for (ViewPpTransferlist viewPpTransferlist : list) {
			BeanUtils.copyProperties(viewPpTransferlist, relieveEmployeeDTO);
		}

		hm = comboService.officeAndDistrict(postingStatusService);
		request.setAttribute("str", "hello");
		@SuppressWarnings("unchecked")
		List<MasDistrict> list2 = (List<MasDistrict>) postingStatusService
				.getList(null, "MasDistrict.findAll");
		for (MasDistrict masDistrict : list2) {
			hm1.put(masDistrict.getMasDistrictid(),
					masDistrict.getDistrictname());

		}

		int list1size = 0;

		target.addObject("list1size", list1size);
		target.addObject("list", list);
		target.addObject("Data", hm);
		target.addObject("Data1", hm1);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;

	}

	/** This method is used to populate the search employee page with designation and category list **/

	@RequestMapping(value = "/SearchEmployeeforRelieve")
	public ModelAndView SearchEmployeeforRelieve(HttpServletRequest request,
			HttpServletResponse response) {

		RelieveEmployeeDTO relieveEmployeeDTO = new RelieveEmployeeDTO();

		@SuppressWarnings("unchecked")
		List<PpDesignationmaster> list = (List<PpDesignationmaster>) postingStatusService
				.getList(null, "PpDesignationmaster.findAll");

		for (PpDesignationmaster PpDesignationmaster : list) {
			relieveEmployeeDTO.setDesignation(PpDesignationmaster
					.getDesignation());
			relieveEmployeeDTO.setPpDesignationmasterid(PpDesignationmaster
					.getPpDesignationmasterid() + "");
		}

		@SuppressWarnings("unchecked")
		List<MasEmploymentsubtype> list1 = (List<MasEmploymentsubtype>) postingStatusService
				.getList(null, "MasEmploymentsubtype.findAll");

		for (MasEmploymentsubtype MasEmploymentsubtype : list1) {

			BeanUtils.copyProperties(MasEmploymentsubtype, relieveEmployeeDTO);

		}

		ModelAndView target = new ModelAndView("SearchEmployeeforRelieve");
		target.addObject("designationlist", list);
		target.addObject("categorylist", list1);
		
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}

	/** This method is used to Search Employees to Relieve **/
	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value = "/SearchEmployeebyidforRelieve", method = RequestMethod.POST)
	public ModelAndView SearchEmployeebyidforRelieve(
			HttpServletRequest request, HttpServletResponse response) {

		String SQL;
		RelieveEmployeeDTO relieveEmployeeDTO = new RelieveEmployeeDTO();

		ModelAndView target = new ModelAndView("SearchEmployeeListforRelieve");
		List<ViewEmployeeSearch> list = null;
		List<ViewEmployeeSearch> list1 = null;
		String empcode = request.getParameter("employeecode");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
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

		if (empcode.equals("") && firstname.equals("")
				&& lastname.equals("") && masEmploymentsubtypeid == ""
				&& ppDesignationmasterid == "") {

			list = (List<ViewEmployeeSearch>) postingStatusService.getList(rmOfficeid, "ViewEmployeeSearch.findByRmOfficeid");

			for (ViewEmployeeSearch viewEmployeeSearch : list) {
				relieveEmployeeDTO.setEmployeecode(viewEmployeeSearch
						.getEmployeecode());
				relieveEmployeeDTO.setDesignation(viewEmployeeSearch
						.getDesignation());
				relieveEmployeeDTO.setEmployeename(viewEmployeeSearch
						.getEmployeename());
				relieveEmployeeDTO.setEmploymenttype(viewEmployeeSearch
						.getEmploymenttype());
				relieveEmployeeDTO.setEmploymentsubtype(viewEmployeeSearch
						.getEmploymentsubtype());
			}
		}

		else {
			relieveEmployeeDTO.setEmployeecode(request
					.getParameter("employeecode"));
			relieveEmployeeDTO.setFirstname(request.getParameter("firstname"));
			relieveEmployeeDTO.setLastname(request.getParameter("lastname"));
			relieveEmployeeDTO.setMasEmploymentsubtypeid(request
					.getParameter("masEmploymentsubtypeid"));
			relieveEmployeeDTO.setPpDesignationmasterid(request
					.getParameter("ppDesignationmasterid"));
			String predicate = " ISFUNCTIONING = '1'";

			SQL = postingStatusService.createSearchSQL(predicate, relieveEmployeeDTO, rmOfficeid);

			list1 = postingStatusService.getTransferList(SQL);
		}

		target.addObject("list", list);
		target.addObject("empcode", empcode);
		target.addObject("list1", list1);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}


	/** This method is used to populate the details of selected Employee **/
	@SuppressWarnings({ "unused", "unchecked" })
	@RequestMapping(value = "/populateRelieveDetails", method = RequestMethod.POST)
	public ModelAndView populateRelieveDetails(HttpServletRequest request,
			HttpServletResponse response) {

		RelieveEmployeeDTO relieveEmployeeDTO = new RelieveEmployeeDTO();
		ModelAndView target = new ModelAndView("RelieveforTransfer");
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();

		String empcode = request.getParameter("employee");
		System.out.print("employeecode   ---- " + empcode);
		
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		List<ViewPpTransferlist> list = (List<ViewPpTransferlist>) postingStatusService
				.getList(rmOfficeid, "ViewPpTransferlist.findByOfficefromid");

		/* code for office combo */
		hm = comboService.officeAndDistrict(postingStatusService);
		request.setAttribute("str", "hello");

		List<MasDistrict> list2 = (List<MasDistrict>) postingStatusService
				.getList(null, "MasDistrict.findAll");
		for (MasDistrict masDistrict : list2) {
			hm1.put(masDistrict.getMasDistrictid(),
					masDistrict.getDistrictname());
		}

		/* Code to select employee */
		
        String rmID =  Integer.toString(rmOfficeid);
		
		System.out.println(rmID+"--RmID is the String value of rmofficeID");

		String[] data = postingStatusService
				.executeProcedurePP_VALIDATEEMPGETINFO(empcode, rmID,
						"relForTra", "add");

		int size = data.length;

		request.setAttribute("nameofemployee", data[0]);
		relieveEmployeeDTO.setEmployeename(data[0]);

		request.setAttribute("designationofemployee", data[1]);
		relieveEmployeeDTO.setDesignation(data[1]);

		request.setAttribute("ppEmployeemasterid", data[2]);
		relieveEmployeeDTO.setPpEmployeemasterid(data[2]);

		if (data[2] == null) {

			target.addObject("msg", "Invalid Employee Code");

		}

		else {
			/* For retrieving transfer order no and date */
			String[] data1 = postingStatusService
					.executePROC_PP_NODUESEMPGETINFO(data[2]);

			int size1 = data1.length;
			System.out.println(size1 + " i am size of data1 array");

			request.setAttribute("noduesordno", data1[0]);
			relieveEmployeeDTO.setNoduesordno(data1[0]);

			request.setAttribute("noduesorddate", data1[1]);
			relieveEmployeeDTO.setNoduesorddate(data1[1]);

			List<ViewGetempnoduesdetail> list1 = (List<ViewGetempnoduesdetail>) postingStatusService.getList(data[2],
					"ViewGetempnoduesdetail.findByPpEmployeemasterid");

			for (ViewGetempnoduesdetail viewGetempnoduesdetail : list1) {
				BeanUtils.copyProperties(viewGetempnoduesdetail,
						relieveEmployeeDTO);
			}

			relieveEmployeeDTO.setEmployeecode(empcode);
			relieveEmployeeDTO.setIsJoined("0");
			relieveEmployeeDTO.setOfficefromid(rmID);

			int list1size = 0;

			target.addObject("list1size", list1size);
			target.addObject("Data", hm);
			target.addObject("Data1", hm1);
			target.addObject("list", list);
			target.addObject("ppNoduesdetail", list1);
			target.addObject("empcode", empcode);
			target.addObject("nameofemployee",
					relieveEmployeeDTO.getEmployeename());
			target.addObject("designationofemployee", relieveEmployeeDTO.getDesignation());
			target.addObject("ppEmployeemasterid",
					relieveEmployeeDTO.getPpEmployeemasterid());
			target.addObject("noduesordno", relieveEmployeeDTO.getNoduesordno());
			target.addObject("officefromid",
					relieveEmployeeDTO.getOfficefromid());
			target.addObject("noduesorddate",
					relieveEmployeeDTO.getNoduesorddate());
			target.addObject("msg", "");
		}

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}

	/** This method is used to Relieve the Selected Employee **/
	@RequestMapping(value = "/EmployeeRelieved", method = RequestMethod.POST)
	public ModelAndView EmployeeRelieved(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("relieveEmployeeDTO") RelieveEmployeeDTO relieveEmployeeDTO) {
		ModelAndView target = new ModelAndView("RelieveforTransfer");
		String employeecode = request.getParameter("employee");
		System.out.print("employeecode ---- " + employeecode);

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		String rmID =  Integer.toString(rmOfficeid);
		
		relieveEmployeeDTO.setRmOfficeid(rmID);
		relieveEmployeeDTO.setEmployeecode(employeecode);
		relieveEmployeeDTO.setIsJoined("0");
		relieveEmployeeDTO.setRelieveorderno(relieveEmployeeDTO
				.getTransferorderno());
		relieveEmployeeDTO.setRelieveorderdate(relieveEmployeeDTO
				.getTransferorderdate());
		relieveEmployeeDTO.setTransferorderno(relieveEmployeeDTO
				.getNoduesordno());
		relieveEmployeeDTO.setTransferorderdate(relieveEmployeeDTO
				.getNoduesorddate() + "");

		int result = postingStatusService.insert(relieveEmployeeDTO);

		@SuppressWarnings("unchecked")
		List<ViewPpTransferlist> list = (List<ViewPpTransferlist>) postingStatusService
				.getList(rmOfficeid, "ViewPpTransferlist.findByOfficefromid");

		if (result == 1) {
			target.addObject("msg", "record inserted successfully");
		} else {
			target.addObject("msg", "Error");
		}
		target.addObject("list", list);
		
		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}

	/** This method is used to populate the details of Employee for Edit **/
	@RequestMapping(value = "/editRelieve")
	public ModelAndView editRelieve(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("relieveEmployeeDTO") RelieveEmployeeDTO relieveEmployeeDTO) {

		ModelAndView target = new ModelAndView("RelieveforTransfer");
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<String, String> hmap = new HashMap<String, String>();
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
		int officelevelid = 0;
		int districtid = 0;
		String employeecode = request.getParameter("ID");
		String ppTransferdetailid = request.getParameter("ID1");
		String ppNoduesdetailid = request.getParameter("ID2");
		
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		String rmID =  Integer.toString(rmOfficeid);

		System.out.println(employeecode + "------" + ppNoduesdetailid + "-----"
				+ ppTransferdetailid);

		String[] data = postingStatusService
				.executeProcedurePP_VALIDATEEMPGETINFO(employeecode,rmID,
						"relForTra", "edit");

		@SuppressWarnings("unused")
		int size = data.length;

		request.setAttribute("employeename", data[0]);
		relieveEmployeeDTO.setEmployeename(data[0]);

		request.setAttribute("designation", data[1]);
		relieveEmployeeDTO.setDesignation(data[1]);

		request.setAttribute("ppEmployeemasterid", data[2]);
		relieveEmployeeDTO.setPpEmployeemasterid(data[2]);

		System.out.println(relieveEmployeeDTO.getEmployeename() + "--0---0--"
				+ relieveEmployeeDTO.getDesignation() + "--0---0--"
				+ relieveEmployeeDTO.getPpEmployeemasterid());

		@SuppressWarnings("unchecked")
		List<ViewPpTransferlist> list1 = (List<ViewPpTransferlist>) postingStatusService
				.getList(ppTransferdetailid, 
						"ViewPpTransferlist.findByPpTransferdetailid");
		for(ViewPpTransferlist transferlist : list1){
			officelevelid = transferlist.getMasOfficelevelid();
			//districtid = transferlist.getMasDistrictid();
			System.out.println(officelevelid + "-------------------"  + districtid);
		}

		int[] where_condtion = new int[] { officelevelid, districtid };
		hmap = comboService.office(where_condtion, postingStatusService);
		int list1size = list1.size();

		/* code for office combo */
		hm = comboService.officeAndDistrict(postingStatusService);
		request.setAttribute("str", "hello");
		@SuppressWarnings("unchecked")
		List<MasDistrict> list2 = (List<MasDistrict>) postingStatusService
				.getList(null, "MasDistrict.findAll");
		for (MasDistrict masDistrict : list2) {
			hm1.put(masDistrict.getMasDistrictid(),
					masDistrict.getDistrictname());
		}

		@SuppressWarnings("unchecked")
		List<ViewPpTransferlist> list = (List<ViewPpTransferlist>) postingStatusService
				.getList(rmOfficeid, "ViewPpTransferlist.findByOfficefromid");

		target.addObject("list", list);
		target.addObject("Data", hm);
		target.addObject("Data1", hm1);
		target.addObject("officename",hmap);
		target.addObject("list1size", list1size);
		target.addObject("list1", list1);
		target.addObject("empcode", employeecode);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}

	/** This method is used to Edit the Relieve detail of Employees **/
	@RequestMapping(value = "/EditRelievedEmployee")
	public ModelAndView EditRelievedEmployee(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("relieveEmployeeDTO") RelieveEmployeeDTO relieveEmployeeDTO) {

		ModelAndView target = new ModelAndView("RelieveforTransfer");
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		relieveEmployeeDTO.setOfficefromid(rmOfficeid+"");

		try {

			String ppEmployeemasterid = request
					.getParameter("ppEmployeemasterid");
			
			relieveEmployeeDTO.setPpEmployeemasterid(ppEmployeemasterid);

			System.out.println(relieveEmployeeDTO.getPpEmployeemasterid()
					+ "--" + relieveEmployeeDTO.getTransferorderno() + "--"
					+ relieveEmployeeDTO.getTransferorderdate() + "--"
					+ relieveEmployeeDTO.getOfficefromid() + "--"
					+ relieveEmployeeDTO.getOfficetoid() + "--"
					+ relieveEmployeeDTO.getRelieveorderno() + "--"
					+ relieveEmployeeDTO.getRelieveorderdate() + "--"
					+ relieveEmployeeDTO.getRelievedate() + "--"
					+ relieveEmployeeDTO.getRelieveanfn() + "--"
					+ relieveEmployeeDTO.getPpTransferdetailid());

			int result = postingStatusService
					.PROC_PP_EDITTRANSFER(relieveEmployeeDTO);

			if (result == 1) {
				System.out.println("Success");
				target.addObject("msg", "Data Edited successfully");
			} else {
				System.out.println("error");
				target.addObject("msg",
						" Oops ! Something wrong... error occurred");
			}

			@SuppressWarnings("unchecked")
			List<ViewPpTransferlist> list = (List<ViewPpTransferlist>) postingStatusService
					.getList(rmOfficeid, "ViewPpTransferlist.findByOfficefromid");

			/* code for office combo */
			hm = comboService.officeAndDistrict(postingStatusService);
			request.setAttribute("str", "hello");
			@SuppressWarnings("unchecked")
			List<MasDistrict> list2 = (List<MasDistrict>) postingStatusService
					.getList(null, "MasDistrict.findAll");
			for (MasDistrict masDistrict : list2) {
				hm1.put(masDistrict.getMasDistrictid(),
						masDistrict.getDistrictname());
			}

			int list1size = 0;

			target.addObject("list1size", list1size);
			target.addObject("Data", hm);
			target.addObject("Data1", hm1);
			target.addObject("list", list);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}

	/** This method is used for Deletion of Employees from Relieve List **/
	@RequestMapping(value = "/deleteRelieve")
	public ModelAndView deleteRelieve(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("relieveEmployeeDTO") RelieveEmployeeDTO relieveEmployeeDTO) {

		ModelAndView target = new ModelAndView("RelieveforTransfer");
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
		
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		String ppTransferdetailid = request.getParameter("ID");
		String ppEmployeemasterid = request.getParameter("ID1");
		String ppNoduesdetailid = request.getParameter("ID2");

		int result = postingStatusService
				.executeProcedurePP_DELTRANSFERDETAILS(ppTransferdetailid,
						ppEmployeemasterid, ppNoduesdetailid);

		if (result == 1) {
			System.out.println("success");
			target.addObject("msg", "Data deleted successfully");
		} else {
			target.addObject("msg", " Oops ! Something wrong... error occurred");
			System.out.println("error");
		}

		@SuppressWarnings("unchecked")
		List<ViewPpTransferlist> list = (List<ViewPpTransferlist>) postingStatusService
				.getList(rmOfficeid, "ViewPpTransferlist.findByOfficefromid");

		/* code for office combo */
		hm = comboService.officeAndDistrict(postingStatusService);
		request.setAttribute("str", "hello");
		@SuppressWarnings("unchecked")
		List<MasDistrict> list2 = (List<MasDistrict>) postingStatusService
				.getList(null, "MasDistrict.findAll");
		for (MasDistrict masDistrict : list2) {
			hm1.put(masDistrict.getMasDistrictid(),
					masDistrict.getDistrictname());
		}

		target.addObject("Data", hm);
		target.addObject("Data1", hm1);
		target.addObject("list", list);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}
}
