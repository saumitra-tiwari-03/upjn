/******************************** CONTROLLER CLASS FOR CREATING NEW USERS  **************************/

/* ==================================================================================
 * Description  : This class implements controller operations for Creating New Users.
 * Date			: 01/03/2016  
 * Author		: VIKAS SINGH
 * Review By 	: 
 * Review Date	:  
 *====================================================================================
 */

/**This is a controller class used for Creating New Users. Controller class get's the request from JSP pages,
 *  based on the requirement , methods of service class are called  and finally response is send to the JSP pages.
 **/

/** Package Name **/
package com.nic.upjn.spring.controller;

/**********************************LIBRARIES USED ********************************/
/** BeanUtils class is used to copy similar properties of Bean class to another class  **/

/**AUTOWIRED Annotation		 : Used for creating the object of class without using new keyword 
 Controller Annotation		 : Used to make controller class of any defined simple class . This class is capable to initiate request and response between JSP and Controller 
 ModelAttribute Annotation 	 : It automatically sets the values from JSP to DTO class.Variable name must be same in both JSP and DTO
 RequestMapping annotation 	 : Used for mapping URL to the method of controller class  
 RequestMethod annotation 	 : Used for identifying type of request generated from JSP  
 SessionStatus class		 : Represents current status of the Session 
 ModelAndView class			 : It is Responsible for setting views and objects required by JSP Pages 
 RoleManagementService       :It contains all abstract methods used for services related to CreateUser.
 Interface 
 CreateUserDTO class 		 : Contains the getter and setter of JSP variables 


 /** Imports required number of classes that are used in this particular class **/
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.nic.upjn.spring.Service.RoleManagementService;
import com.nic.upjn.spring.dto.CreateUserDTO;
import com.nic.upjn.spring.dto.EmployeeStatusDTO;
import com.nic.upjn.spring.entity.MasDistrict;
import com.nic.upjn.spring.entity.MasOfficelevel;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.PpPlacemaster;
import com.nic.upjn.spring.entity.RmOffice;
import com.nic.upjn.spring.entity.RmRole;
import com.nic.upjn.spring.entity.RmRolemenuitem;
import com.nic.upjn.spring.entity.RmofficeView;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;
import com.nic.upjn.spring.entity.ViewRmEmplistRole;
import com.nic.upjn.spring.entity.ViewRmEmployeelist;
import com.nic.upjn.spring.entity.ViewRmEmployeerolelist;
import com.nic.upjn.spring.entity.ViewRmGetlinkstoassign;
import com.nic.upjn.spring.entity.ViewRmGetofficeadmin;
import com.nic.upjn.spring.entity.ViewRmOfficeadminlist;
import com.nic.upjn.spring.entity.ViewRmOfficelist;
import com.nic.upjn.spring.entity.ViewRmRolesforemployee;
import com.nic.upjn.spring.entity.ViewRmRoleslist;

@SuppressWarnings({ "unchecked", "unused" })
@Controller
public class CreateUser_RMController {

	@Autowired
	RoleManagementService roleManagementService;

	/** by default method **/
	@RequestMapping("/CreateUser")
	public ModelAndView createUser(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		ModelAndView target = new ModelAndView("CreateUser");

		System.out.println(rmOfficeid + "-- rmofficeid");

		List<ViewRmEmployeerolelist> list = (List<ViewRmEmployeerolelist>) roleManagementService.selectquery(rmOfficeid,
				"ViewRmEmployeerolelist.findByRmOfficeid");
		for (ViewRmEmployeerolelist viewRmEmployeerolelist : list) {

			System.out.println(viewRmEmployeerolelist.getIsloginlocked());
		}
		List<ViewRmEmplistRole> list1 = (List<ViewRmEmplistRole>) roleManagementService.selectquery(rmOfficeid,
				"ViewRmEmplistRole.find");
		List<?> list2 = roleManagementService.selectquery(rmOfficeid, "ViewRmRoleslist.findByRmOfficeid");

		int x = 0;

		target.addObject("x", x);
		target.addObject("employeelist", list);
		target.addObject("listName", list1);
		target.addObject("rolelist", list2);

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;
	}

	/** This method is used for creating New users **/
	@RequestMapping("/NewUser")
	public ModelAndView NewUser(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("CreateUser");
		HttpSession session = request.getSession();
		try {

			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			String error = "";
			System.out.println(rmOfficeid + "-- rmofficeid");

			if (createUserDTO.getPpEmployeemasterid().equals("-1")) {
				error = error + "\t" + "Must have to select the EMPLOYEE NAME";

			}

			if (createUserDTO.getPassword().equals("")) {
				error = "\n" + error + "\n" + "Password Field can not be empty.";
			}
			String password = createUserDTO.getPassword();
			String confirmPassword = createUserDTO.getConfirmpassword();
			if (!password.equals(confirmPassword)) {
				error = "\n" + error + "\n" + "Confirm password not matched with password.";
			}
			if (createUserDTO.getPassword().toString().length() < 4) {
				error = "\n" + error + "Min length of password should be 4.";
			}

			if (createUserDTO.getRoles() == null) {
				error = "\n" + error + "You should have to select atleast one checkbox";
			}

			if (error.equals("")) {
				boolean result = roleManagementService.createUser(createUserDTO);
				if (result == true) {
					System.out.println("Success");
					target.addObject("msg", "Success");
				} else {
					target.addObject("msg", "Error");
					System.out.println("Error ");
				}
			}

			else {
				target.addObject("error", error);
			}

			List<?> list = roleManagementService.selectquery(rmOfficeid, "ViewRmEmployeerolelist.findByRmOfficeid");
			List<?> list1 = roleManagementService.selectquery(rmOfficeid, "ViewRmEmplistRole.find");
			List<?> list2 = roleManagementService.selectquery(rmOfficeid, "ViewRmRoleslist.findByRmOfficeid");
			int x = 0;

			target.addObject("x", x);
			target.addObject("employeelist", list);
			target.addObject("listName", list1);
			target.addObject("rolelist", list2);
		}

		catch (Exception e) {

			e.printStackTrace();
		}

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;
	}

	/** This method is used for deleting the Users **/
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("CreateUser");
		HttpSession session = request.getSession();
		try {

			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			System.out.println(rmOfficeid + "-- rmofficeid");

			String ppEmployeemasterid = request.getParameter("ID1");

			boolean result = roleManagementService.deleteUser(ppEmployeemasterid);

			if (result = true) {
				System.out.println("Success");
				target.addObject("msg", "Deleted");
			} else {
				target.addObject("msg", "Error");
				System.out.println("Error ");
			}

			List<?> list = roleManagementService.selectquery(rmOfficeid, "ViewRmEmployeerolelist.findByRmOfficeid");
			List<?> list1 = roleManagementService.selectquery(rmOfficeid, "ViewRmEmplistRole.find");
			List<?> list2 = roleManagementService.selectquery(rmOfficeid, "ViewRmRoleslist.findByRmOfficeid");
			int x = 0;

			target.addObject("x", x);
			target.addObject("employeelist", list);
			target.addObject("listName", list1);
			target.addObject("rolelist", list2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;
	}

	/** This method is to Lock User Password **/
	@RequestMapping("/lockUser")
	public ModelAndView lockUser(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("CreateUser");
		HttpSession session = request.getSession();
		try {

			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			String ppEmployeemasterid = request.getParameter("ID1");

			System.out.println(rmOfficeid + "-- rmofficeid");
			List<PpEmployeemaster> list12 = (List<PpEmployeemaster>) roleManagementService.getList(ppEmployeemasterid,
					"PpEmployeemaster.findByPpEmployeemasterid");
			PpEmployeemaster ppEmployeemasterlock = new PpEmployeemaster();

			for (PpEmployeemaster ppEmployeemaster : list12) {
				BeanUtils.copyProperties(ppEmployeemaster, ppEmployeemasterlock);
			}

			boolean result = roleManagementService.lockUser(ppEmployeemasterlock);

			if (result = true) {
				target.addObject("msg", "User Locked Successfully");
				int x = 1;
				target.addObject("x", x);
			}

			List<ViewRmEmployeerolelist> list = (List<ViewRmEmployeerolelist>) roleManagementService
					.selectquery(rmOfficeid, "ViewRmEmployeerolelist.findByRmOfficeid");

			for (ViewRmEmployeerolelist viewRmEmployeerolelist : list) {
				if (viewRmEmployeerolelist.getIsloginlocked() == 1) {
					target.addObject("isLoginLocked", "Unlock");
				} else {
					target.addObject("isLoginLocked", "lock");
				}
				System.out.println(viewRmEmployeerolelist.getIsloginlocked());
			}
			List<?> list1 = roleManagementService.selectquery(rmOfficeid, "ViewRmEmplistRole.find");
			List<?> list2 = roleManagementService.selectquery(rmOfficeid, "ViewRmRoleslist.findByRmOfficeid");

			target.addObject("employeelist", list);
			target.addObject("listName", list1);
			target.addObject("rolelist", list2);
			target.addObject("ppEmployeemasterid", ppEmployeemasterid);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;

	}

	/** This method is used to Unlock User Password **/
	@RequestMapping("/unlockUser")
	public ModelAndView unlockUser(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("CreateUser");
		HttpSession session = request.getSession();
		try {
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			System.out.println(rmOfficeid + "-- rmofficeid");
			String ppEmployeemasterid = request.getParameter("ID1");

			boolean result = roleManagementService.unlockUser(ppEmployeemasterid);

			System.out.println("Unlocked Successfully");

			List<?> list = roleManagementService.selectquery(rmOfficeid, "ViewRmEmployeerolelist.findByRmOfficeid");
			List<?> list1 = roleManagementService.selectquery(rmOfficeid, "ViewRmEmplistRole.find");
			List<?> list2 = roleManagementService.selectquery(rmOfficeid, "ViewRmRoleslist.findByRmOfficeid");

			int x = 0;

			target.addObject("x", x);
			target.addObject("ppEmployeemasterid", ppEmployeemasterid);
			target.addObject("employeelist", list);
			target.addObject("listName", list1);
			target.addObject("rolelist", list2);
			target.addObject("msg", "User Unlocked Successfully");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;

	}

	/** This method is used for fetching user details for Resetting Password **/
	@RequestMapping("/getresetpassword")
	public ModelAndView getresetpassword(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView target = new ModelAndView("ResetPassword");
		try {
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			System.out.println(rmOfficeid + "-- rmofficeid");
			String ppEmployeemasterid = request.getParameter("ID1");
			target.addObject("ppEmployeemasterid", ppEmployeemasterid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;

	}

	/** This method is used to Reset the Password of any particular user **/

	@RequestMapping("/resetpassword")
	public ModelAndView resetpassword(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("ResetPassword");
		HttpSession session = request.getSession();
		String error = "";

		if (createUserDTO.getPassword().equals("")) {
			error = "\n" + error + "\n" + "Password Field can not be empty.";
		}
		String password = createUserDTO.getPassword();
		String confirmPassword = createUserDTO.getConfirmpassword();
		if (!password.equals(confirmPassword)) {
			error = "\n" + error + "\n" + "Confirm password not matched with password.";
		}
		if (createUserDTO.getPassword().toString().length() < 4) {
			error = "\n" + error + "Min length of password should be 4.";
		}

		if (error.equals("")) {
			try {

				Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

				System.out.println(rmOfficeid + "-- rmofficeid");

				String newpassword = createUserDTO.getPassword();
				String ppEmployeemasterid = createUserDTO.getPpEmployeemasterid();

				boolean iscomplete = changepassword(ppEmployeemasterid, newpassword);

				target.addObject("msg", "Password Changed ");
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			target.addObject("error", "Confirm password and New password should have to same");
		}
		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;

	}

	/**
	 * This method is called internally by 'RESET PASSWORD' method of this
	 * Controller
	 **/
	private boolean changepassword(String ppEmployeemasterid, String newpassword) {

		boolean iscomplete = false;

		iscomplete = roleManagementService.changepassword(ppEmployeemasterid, newpassword);

		return iscomplete;
	}

	@RequestMapping("/officeMaster")
	public ModelAndView officeMaster(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("rmOfficeMaster");
		HttpSession session = request.getSession();
		try {
			System.out.println("Hello .....................................................");
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			HashMap<Integer, String> hm1 = new HashMap<Integer, String>();

			String json = null;

			List<MasOfficelevel> list = (List<MasOfficelevel>) roleManagementService.getList(null,
					"MasOfficelevel.findAll");

			for (MasOfficelevel masOfficelevel : list) {
				hm.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());

			}
			request.setAttribute("str", "hello");
			request.setAttribute("Data", hm);

			List<MasDistrict> list1 = (List<MasDistrict>) roleManagementService.getList(null, "MasDistrict.findAll");

			for (MasDistrict masDistrict : list1) {
				hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());

			}

			modelAndView.addObject("Data", hm);
			modelAndView.addObject("Data1", hm1);

		} catch (Exception ex) {
			System.out.println("Exception:" + ex);

		}

		List<RmofficeView> officeList = (List<RmofficeView>) roleManagementService.getList(null,
				"RmofficeView.findAll");
		for (RmofficeView rmofficeView : officeList) {
			modelAndView.addObject("rmOfficeid", rmofficeView.getRmOfficeid());
		}

		modelAndView.addObject("list", officeList);
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping(value = "/officeMasterWork", params = "searchOffice")
	public ModelAndView searchOfficeMaster(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		String officename = "" + createUserDTO.getOfficename();
		String masOfficeLevelId = createUserDTO.getMasOfficelevelid();
		if (masOfficeLevelId.equals("[Select Level]")) {
			masOfficeLevelId = "";
			createUserDTO.setMasOfficelevelid("");
		}

		else {
			List<MasOfficelevel> officelevelID = (List<MasOfficelevel>) roleManagementService
					.getList(createUserDTO.getMasOfficelevelid(), "MasOfficelevel.findByMasOfficelevelid");
			for (MasOfficelevel masOfficelevel : officelevelID) {
				String officeLevel = masOfficelevel.getOfficelevel();
				createUserDTO.setOfficelevel(officeLevel);
			}
		}
		String masDistrictID = createUserDTO.getMasDistrictid();
		if (masDistrictID.equals("-1")) {
			masDistrictID = "";
			createUserDTO.setMasDistrictid("");

		} else {
			List<MasDistrict> mas_district = (List<MasDistrict>) roleManagementService
					.getList(createUserDTO.getMasDistrictid(), "MasDistrict.findByMasDistrictid");
			for (MasDistrict masDistrict : mas_district) {
				String districtName = masDistrict.getDistrictname();
				createUserDTO.setDistrictname(districtName);
			}
		}

		ModelAndView modelAndView = new ModelAndView("rmOfficeMaster");
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();

		List<MasOfficelevel> list = (List<MasOfficelevel>) roleManagementService.getList(null,
				"MasOfficelevel.findAll");

		for (MasOfficelevel masOfficelevel : list) {
			hm.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());

		}
		request.setAttribute("str", "hello");
		request.setAttribute("Data", hm);

		List<MasDistrict> list1 = (List<MasDistrict>) roleManagementService.getList(null, "MasDistrict.findAll");

		for (MasDistrict masDistrict : list1) {
			hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());

		}

		modelAndView.addObject("Data", hm);
		modelAndView.addObject("Data1", hm1);

		if (masDistrictID.equals("") && masOfficeLevelId.equals("") && officename.equals("")) {

			List<RmofficeView> officeList = (List<RmofficeView>) roleManagementService.getList(null,
					"RmofficeView.findAll");
			modelAndView.addObject("list", officeList);
		}

		else {

			String SQL = roleManagementService.createSearchSQL("", createUserDTO);
			List<RmofficeView> officeInfoList = (List<RmofficeView>) roleManagementService.serachOffices(SQL);

			modelAndView.addObject("list", officeInfoList);
		}
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping(value = "/officeMasterWork", params = "addNewOffice")
	public ModelAndView addNewOffice(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("addNewOffice");
		HttpSession session = request.getSession();
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();

		String str1 = request.getParameter("districtname1");
		System.out.println("value of str1 is..........................................................." + str1);
		String json = null;

		List<MasOfficelevel> list = (List<MasOfficelevel>) roleManagementService.getList(null,
				"MasOfficelevel.findAll");

		for (MasOfficelevel masOfficelevel : list) {
			hm.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());

		}

		List<MasDistrict> list1 = (List<MasDistrict>) roleManagementService.getList(null, "MasDistrict.findAll");

		for (MasDistrict masDistrict : list1) {
			hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());

		}

		modelAndView.addObject("DataOffice", hm);
		modelAndView.addObject("Data1", hm1);
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping(value = "/PlaceMaster")
	public void placeMaster(HttpServletRequest request, HttpServletResponse response) {

		HashMap<String, String> hmap = new HashMap<String, String>();
		String DistrictID = request.getParameter("districtID");
		String json = null;

		List<PpPlacemaster> list = (List<PpPlacemaster>) roleManagementService
				.getComboList(Integer.parseInt(DistrictID), "PpPlacemaster.findByMasDistrictid");

		for (PpPlacemaster placemaster : list) {
			hmap.put(placemaster.getPpPlacemasterid() + "", placemaster.getPlace());

		}

		json = new Gson().toJson(hmap);
		response.setContentType("application/json");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/saveNewOfficeRecord")
	public ModelAndView saveNewOfficeRecord(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = null;
		String rmOfficeid = request.getParameter("rmOfficeid");
		RmOffice rmOffice = new RmOffice();
		BeanUtils.copyProperties(createUserDTO, rmOffice);
		rmOffice.setMas_districtid(createUserDTO.getMasDistrictid());
		rmOffice.setMas_officelevelid(createUserDTO.getMasOfficelevelid());
		rmOffice.setIsdeleted('N');
		rmOffice.setIsfinancialyearclosed('N');
		rmOffice.setParentofficeid(createUserDTO.getPARENTOFFICEID());
		HttpSession session = request.getSession();

		System.out.println(rmOffice);
		String error = "";

		if (createUserDTO.getMasDistrictid().equals("-1") || createUserDTO.getMasOfficelevelid().equals("-1")
				|| createUserDTO.getPpPlacemasterid().equals("-1")) {
			error = error + "\t" + "Must have to select the DISTRICT and OFFICELEVEL ,  and ";

		}
		if (createUserDTO.getOfficename().equals("")) {
			error = error + "\t" + "OFFICENAME can not be empty ,  and ";
		}
		if (createUserDTO.getOfficeaddress().equals("") || createUserDTO.getLocCode() == null) {
			error = error + "\t" + "OFFICE ADDRESS  and LOCATION CODE can be empty";
		}

		if (error.equals("")) {
			modelAndView = new ModelAndView("rmOfficeMaster");

			if (rmOfficeid == null) {
				if (!checkExistanceForOffice(createUserDTO.getOfficename())) {

					modelAndView.addObject("mes", "Process completed successfully");
					PpEmployeemaster ppEmployeemaster = new PpEmployeemaster();
					ppEmployeemaster.setEmployeecode(rmOffice.getLocCode() + "");
					ppEmployeemaster.setFirstname(rmOffice.getOfficename());
					ppEmployeemaster.setPpDesignationmasterid(345);

					if (!checkExistanceLocCode(createUserDTO.getLocCode())) {
						roleManagementService.saveNewOfficeRecord(rmOffice);
					} else {
						modelAndView.addObject("mes", createUserDTO.getLocCode() + " " + "is already exist");
					}

					List<RmOffice> rmOfficeID = (List<RmOffice>) roleManagementService
							.getList(Integer.parseInt("" + rmOffice.getLocCode()), "RmOffice.findByLocCode");
					for (RmOffice rOffice : rmOfficeID) {
						ppEmployeemaster.setRM_OFFICEID(rOffice.getRmOfficeid());
					}

					ppEmployeemaster.setIsfunctioning('1');
					ppEmployeemaster.setIsdisablefinancial('0');
					ppEmployeemaster.setEntryOfficeid(Long.parseLong(createUserDTO.getPARENTOFFICEID() + ""));
					roleManagementService.saveBasicRecordNewOffice(ppEmployeemaster);
				} else {
					modelAndView.addObject("mes", createUserDTO.getOfficename() + " " + "is already exist");
					HashMap<Integer, String> hm = new HashMap<Integer, String>();
					HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
					List<MasOfficelevel> list = (List<MasOfficelevel>) roleManagementService.getList(null,
							"MasOfficelevel.findAll");

					for (MasOfficelevel masOfficelevel : list) {
						hm.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());

					}
					request.setAttribute("str", "hello");
					request.setAttribute("Data", hm);

					List<MasDistrict> list1 = (List<MasDistrict>) roleManagementService.getList(null,
							"MasDistrict.findAll");

					for (MasDistrict masDistrict : list1) {
						hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());

					}

					modelAndView.addObject("Data", hm);
					modelAndView.addObject("Data1", hm1);

					List<RmofficeView> officeList = (List<RmofficeView>) roleManagementService.getList(null,
							"RmofficeView.findAll");
					for (RmofficeView rmofficeView : officeList) {
						modelAndView.addObject("rmOfficeid", rmofficeView.getRmOfficeid());
					}

					modelAndView.addObject("list", officeList);
				}

			}

			else {
				modelAndView.addObject("mes", "Record Updated successfully");
				rmOffice.setParentofficeid(createUserDTO.getPARENTOFFICEID());
				roleManagementService.updateNewOfficeRecord(rmOffice);
			}

			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			HashMap<Integer, String> hm1 = new HashMap<Integer, String>();

			String json = null;

			List<MasOfficelevel> list = (List<MasOfficelevel>) roleManagementService.getList(null,
					"MasOfficelevel.findAll");

			for (MasOfficelevel masOfficelevel : list) {
				hm.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());

			}
			request.setAttribute("str", "hello");
			request.setAttribute("Data", hm);

			List<MasDistrict> list1 = (List<MasDistrict>) roleManagementService.getList(null, "MasDistrict.findAll");

			for (MasDistrict masDistrict : list1) {
				hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());

			}

			modelAndView.addObject("Data", hm);
			modelAndView.addObject("Data1", hm1);

			List<RmofficeView> officeList = (List<RmofficeView>) roleManagementService.getList(null,
					"RmofficeView.findAll");
			for (RmofficeView rmofficeView : officeList) {
				modelAndView.addObject("rmOfficeid", rmofficeView.getRmOfficeid());
			}

			modelAndView.addObject("list", officeList);
		}

		else {
			modelAndView = new ModelAndView("addNewOffice");
			modelAndView.addObject("error", error);

			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			HashMap<Integer, String> hm1 = new HashMap<Integer, String>();

			String str1 = request.getParameter("districtname1");
			System.out.println("value of str1 is..........................................................." + str1);
			String json = null;

			List<MasOfficelevel> list = (List<MasOfficelevel>) roleManagementService.getList(null,
					"MasOfficelevel.findAll");

			for (MasOfficelevel masOfficelevel : list) {
				hm.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());

			}

			List<MasDistrict> list1 = (List<MasDistrict>) roleManagementService.getList(null, "MasDistrict.findAll");

			for (MasDistrict masDistrict : list1) {
				hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());

			}
			modelAndView.addObject("Data", hm);
			modelAndView.addObject("Data1", hm1);

			modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
			modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		}

		return modelAndView;
	}

	private boolean checkExistanceLocCode(Long locCode) {
		boolean b = roleManagementService.checkExistanceLocCode(locCode);
		return b;

	}

	private boolean checkExistanceForOffice(String condition) {
		boolean b = roleManagementService.checkExistanceForOffice(condition);
		return b;

	}

	@RequestMapping(value = "/EditNewOfficeRecord")
	public ModelAndView EditNewOfficeRecord(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("editNewOfficeDetails");

		String mas_officelevelid = null;
		HttpSession session = request.getSession();

		String rmOfficeid = request.getParameter("rmOfficeid");
		HashMap<Integer, String> hm = new HashMap<Integer, String>();

		HashMap<Integer, String> hm3 = new HashMap<Integer, String>();
		HashMap<Integer, String> placedistrict = new HashMap<Integer, String>();

		Long placeMasterId = null;
		String str1 = request.getParameter("districtname1");
		System.out.println("value of str1 is..........................................................." + str1);
		String json = null;
		String districtid = null;
		Integer prentOfficeId = null;

		List<MasOfficelevel> list3 = (List<MasOfficelevel>) roleManagementService.getList(null,
				"MasOfficelevel.findAll");

		for (MasOfficelevel masOfficelevel : list3) {
			hm3.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());

		}

		List<MasDistrict> list5 = (List<MasDistrict>) roleManagementService.getList(null, "MasDistrict.findAll");

		for (MasDistrict masDistrict : list5) {
			placedistrict.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());

		}

		if (!rmOfficeid.equals("")) {
			List<RmOffice> list = (List<RmOffice>) roleManagementService.getList(rmOfficeid,
					"RmOffice.findByRmOfficeid");
			for (RmOffice rmOffice : list) {
				prentOfficeId = rmOffice.getParentofficeid();
				System.out.println(rmOffice.getOfficename());
				System.out.println(rmOffice.getFax());
				placeMasterId = rmOffice.getPpPlacemasterid();
				districtid = rmOffice.getMas_districtid();
				mas_officelevelid = rmOffice.getMas_officelevelid();
			}

			List<MasOfficelevel> list6 = (List<MasOfficelevel>) roleManagementService.getList(mas_officelevelid,
					"MasOfficelevel.findByMasOfficelevelid");
			for (MasOfficelevel masOfficelevel : list6) {
				hm3.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());
			}

			List<PpPlacemaster> Placelist = (List<PpPlacemaster>) roleManagementService.getList(districtid,
					"PpPlacemaster.findByMasDistrictid");
			modelAndView.addObject("Placelist", Placelist);
			System.out.println(Placelist.size() + " i am the size of placelist");
			if (placeMasterId != null) {
				List<PpPlacemaster> Place = (List<PpPlacemaster>) roleManagementService.getList(placeMasterId + "",
						"PpPlacemaster.findByPpPlacemasterid");
				modelAndView.addObject("Place", Place);
				System.out.println(Place.size() + " i am the size of place");
			}

			List<RmOffice> officeList = (List<RmOffice>) roleManagementService.getList(mas_officelevelid,
					"RmOffice.findByIDOfficename");

			for (RmOffice rmOffice : officeList) {
				hm.put(rmOffice.getRmOfficeid(), rmOffice.getOfficename());
			}
			modelAndView.addObject("prentOfficeId", prentOfficeId);
			modelAndView.addObject("Data", hm);
			modelAndView.addObject("levelMap", hm3);
			modelAndView.addObject("districtMap", placedistrict);
			modelAndView.addObject("officeInfo", list);

			modelAndView.addObject("rmOfficeid", rmOfficeid);
			modelAndView.addObject("mas_officelevelid", mas_officelevelid);

		}
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping(value = "/ParentofficeListByID")
	public void ParentofficeListByID(HttpServletRequest request, HttpServletResponse response) {

		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
		String mas_officelevelid = request.getParameter("officeLevelId");
		String json = null;

		List<RmOffice> officeList = (List<RmOffice>) roleManagementService.getList(mas_officelevelid,
				"RmOffice.findByIDOfficename");

		for (RmOffice rmOffice : officeList) {
			hm.put(rmOffice.getRmOfficeid(), rmOffice.getOfficename());
		}

		// hm.put(0, mas_officelevelid);
		request.setAttribute("mas_officelevelid", mas_officelevelid);

		json = new Gson().toJson(hm);

		response.setContentType("application/json");
		try {
			response.getWriter().write(json);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@RequestMapping("/assignOfficeAdmin")
	public ModelAndView assignOfficeAdmin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("assignOfficedmin");
		HttpSession session = request.getSession();

		HashMap<Integer, String> officelevelMap = new HashMap<Integer, String>();
		List<MasOfficelevel> list = (List<MasOfficelevel>) roleManagementService.getList(null,
				"MasOfficelevel.findAll");

		for (MasOfficelevel masOfficelevel : list) {
			officelevelMap.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());

		}

		List<ViewRmOfficeadminlist> employeeInfoList = (List<ViewRmOfficeadminlist>) roleManagementService.getList(null,
				"ViewRmOfficeadminlist.findAll");

		for (ViewRmOfficeadminlist viewRmOfficeadminlist : employeeInfoList) {
			System.out.println(viewRmOfficeadminlist.getEmployeecode() + " " + viewRmOfficeadminlist.getEmployeename());
		}
		modelAndView.addObject("officelevelMap", officelevelMap);
		modelAndView.addObject("employeeInfoList", employeeInfoList);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping("/OfficeNameListByID")
	public void OfficeNameListByID(HttpServletRequest request, HttpServletResponse response) {
		{
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			String mas_officelevelid = request.getParameter("masOfficelevelid");
			String json = null;

			List<ViewRmOfficelist> officeList = (List<ViewRmOfficelist>) roleManagementService
					.getList(mas_officelevelid, "ViewRmOfficelist.findByMasOfficelevelid");

			for (ViewRmOfficelist rmOffice : officeList) {
				hm.put(rmOffice.getRmOfficeid(), rmOffice.getOfficename());
			}

			json = new Gson().toJson(hm);

			response.setContentType("application/json");
			try {
				response.getWriter().write(json);

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	@RequestMapping("/EmployeeNameListByID")
	public void EmployeeNameListByID(HttpServletRequest request, HttpServletResponse response) {
		{
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			String rmOfficeid = request.getParameter("rmOfficeid");
			String json = null;

			List<ViewRmEmployeelist> employeeList = (List<ViewRmEmployeelist>) roleManagementService.getList(rmOfficeid,
					"ViewRmEmployeelist.findByRmOfficeid");

			for (ViewRmEmployeelist viewRmEmployeelist : employeeList) {
				hm.put(Integer.parseInt(viewRmEmployeelist.getPpEmployeemasterid() + ""),
						viewRmEmployeelist.getEmployeename());
			}

			json = new Gson().toJson(hm);

			response.setContentType("application/json");
			try {
				response.getWriter().write(json);

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	@RequestMapping(value = "/executionOfassignOfficeAdmin")
	public ModelAndView executionOfassignOfficeAdmin(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("assignOfficedmin");
		HttpSession session = request.getSession();
		String error = "";
		String rmOfficeid = request.getParameter("rmOfficeid");
		String rmRoleid = request.getParameter("rmRoleid");
		HashMap<Integer, String> officelevelMap = new HashMap<Integer, String>();

		if (createUserDTO.getPassword().equals("")) {
			error = error + "\t" + "Password Field can not be empty.";
		}
		String password = createUserDTO.getPassword();
		String confirmPassword = createUserDTO.getConfirmpassword();
		if (!password.equals(confirmPassword)) {
			error = error + "\t" + "Confirm password not matched with password.";
		}
		if (createUserDTO.getPassword().toString().length() < 4) {
			error = error + "\t" + "Min length of password should be 4.";
		}

		if (rmRoleid.equals("")) {

			if (createUserDTO.getMasOfficelevelid().equals("-1") || createUserDTO.getRmOfficeid().equals("-1")
					|| createUserDTO.getPpEmployeemasterid().equals("[Select Employee Name]")) {
				error = error + "\t" + "Must have to select the OFFICENAME , OFFICELEVEL  and EMPLOYEENAME,  and ";

			}

		}

		if (error.equals("")) {
			if (rmRoleid.equals("")) {
				roleManagementService.executeProcedureForAssignOfficeAdmin(createUserDTO);
				modelAndView.addObject("success", "Process completed successfully");
				List<MasOfficelevel> list = (List<MasOfficelevel>) roleManagementService.getList(null,
						"MasOfficelevel.findAll");

				for (MasOfficelevel masOfficelevel : list) {
					officelevelMap.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());
				}
				modelAndView.addObject("officelevelMap", officelevelMap);
			} else {
				createUserDTO.setRmRoleid(rmRoleid);
				roleManagementService.executeProcedureForUpdateAssignOfficeAdmin(createUserDTO);
				modelAndView.addObject("success", "Record updated successfully");

				List<MasOfficelevel> list = (List<MasOfficelevel>) roleManagementService.getList(null,
						"MasOfficelevel.findAll");

				for (MasOfficelevel masOfficelevel : list) {
					officelevelMap.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());
				}
				modelAndView.addObject("officelevelMap", officelevelMap);
			}

		} else {

			List<ViewRmGetofficeadmin> assignInfo = (List<ViewRmGetofficeadmin>) roleManagementService.getList(rmRoleid,
					"ViewRmGetofficeadmin.findByRmRoleid");
			ViewRmGetofficeadmin viewRmGetofficeadmin = assignInfo.get(0);
			modelAndView.addObject("officelevel", viewRmGetofficeadmin.getOfficelevel());
			modelAndView.addObject("officename", viewRmGetofficeadmin.getOfficename());
			modelAndView.addObject("rmRoleid", rmRoleid);
			HashMap<Integer, String> hm = new HashMap<Integer, String>();

			List<ViewRmEmployeelist> employeeList = (List<ViewRmEmployeelist>) roleManagementService.getList(rmOfficeid,
					"ViewRmEmployeelist.findByRmOfficeid");

			for (ViewRmEmployeelist viewRmEmployeelist : employeeList) {
				hm.put(Integer.parseInt(viewRmEmployeelist.getPpEmployeemasterid() + ""),
						viewRmEmployeelist.getEmployeename());
			}
			modelAndView.addObject("EmpnameList", hm);
			modelAndView.addObject("error", error);
		}

		List<ViewRmOfficeadminlist> employeeInfoList = (List<ViewRmOfficeadminlist>) roleManagementService.getList(null,
				"ViewRmOfficeadminlist.findAll");
		for (ViewRmOfficeadminlist viewRmOfficeadminlist : employeeInfoList) {
			System.out.println(viewRmOfficeadminlist.getEmployeecode() + " " + viewRmOfficeadminlist.getEmployeename());
		}
		System.out.println(employeeInfoList.size());

		modelAndView.addObject("employeeInfoList", employeeInfoList);
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		return modelAndView;
	}

	@RequestMapping(value = "/EditAssignOfficeRecord")
	public ModelAndView EditAssignOfficeRecord(HttpServletRequest request, HttpServletResponse response) {
		{

			ModelAndView modelAndView = new ModelAndView("assignOfficedmin");
			HttpSession session = request.getSession();

			String employeecode = request.getParameter("employeecode");
			Integer rmOfficeid = null;
			String employeename = null;
			String ppEmployeemasterid = null;
			String rmRoleid = null;
			int count = 0;

			List<ViewRmEmployeelist> assignInfoPerticular = null;
			List<ViewRmOfficeadminlist> employeeInfoList = (List<ViewRmOfficeadminlist>) roleManagementService
					.getList(employeecode, "ViewRmOfficeadminlist.findByEmployeecode");
			for (ViewRmOfficeadminlist viewRmOfficeadminlist : employeeInfoList) {
				if (count == 0) {
					rmRoleid = viewRmOfficeadminlist.getRmRoleid() + "";
					employeename = viewRmOfficeadminlist.getEmployeename();
					ppEmployeemasterid = viewRmOfficeadminlist.getPpEmployeemasterid() + "";
					rmOfficeid = viewRmOfficeadminlist.getRmOfficeid();

					assignInfoPerticular = new ArrayList<ViewRmEmployeelist>();
					ViewRmEmployeelist viewRmEmployeelist = new ViewRmEmployeelist();
					viewRmEmployeelist.setPpEmployeemasterid(Long.parseLong("" + ppEmployeemasterid));
					viewRmEmployeelist.setEmployeename(employeename);
					assignInfoPerticular.add(viewRmEmployeelist);

				}
				count = count + 1;
			}

			modelAndView.addObject("assignInfoPerticular", assignInfoPerticular);
			List<ViewRmGetofficeadmin> assignInfo = (List<ViewRmGetofficeadmin>) roleManagementService.getList(rmRoleid,
					"ViewRmGetofficeadmin.findByRmRoleid");
			ViewRmGetofficeadmin viewRmGetofficeadmin = assignInfo.get(0);
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			String json = null;
			List<ViewRmEmployeelist> employeeList = (List<ViewRmEmployeelist>) roleManagementService.getList(rmOfficeid,
					"ViewRmEmployeelist.findByRmOfficeid");
			System.out.println(employeeList.size() + "-------------------------------");
			for (ViewRmEmployeelist viewRmEmployeelist : employeeList) {
				hm.put(Integer.parseInt(viewRmEmployeelist.getPpEmployeemasterid() + ""),
						viewRmEmployeelist.getEmployeename());
			}

			modelAndView.addObject("EmpnameList", hm);
			modelAndView.addObject("employeeInfoList",
					(List<ViewRmOfficeadminlist>) roleManagementService.getList(null, "ViewRmOfficeadminlist.findAll"));
			modelAndView.addObject("officelevel", viewRmGetofficeadmin.getOfficelevel());
			modelAndView.addObject("officename", viewRmGetofficeadmin.getOfficename());
			modelAndView.addObject("rmRoleid", rmRoleid);
			modelAndView.addObject("rmOfficeid", rmOfficeid);

			modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
			modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

			return modelAndView;
		}
	}

	@RequestMapping(value = "/ChangeRightsOfficeRecord")
	public ModelAndView ChangeRightsOfficeRecord(HttpServletRequest request, HttpServletResponse response) {
		{
			ModelAndView modelAndView = new ModelAndView("changeRights");
			HttpSession session = request.getSession();

			String rmOfficeid = request.getParameter("rmOfficeid");
			int count = 0;
			String ppEmployeemasterid = null;
			String employeename = null;
			String rmRoleid = null;
			String office = null;
			List<RmRolemenuitem> menuItemID = null;
			List<ViewRmOfficeadminlist> employeeInfoList = (List<ViewRmOfficeadminlist>) roleManagementService
					.getList(rmOfficeid, "ViewRmOfficeadminlist.findByRmOfficeid");
			for (ViewRmOfficeadminlist viewRmOfficeadminlist : employeeInfoList) {
				if (count == 0) {
					rmRoleid = viewRmOfficeadminlist.getRmRoleid() + "";
					employeename = viewRmOfficeadminlist.getEmployeename();
					ppEmployeemasterid = viewRmOfficeadminlist.getPpEmployeemasterid() + "";
					office = viewRmOfficeadminlist.getOfficename();
				}
				count = count + 1;

			}
			List<ViewRmGetlinkstoassign> menuList = (List<ViewRmGetlinkstoassign>) roleManagementService.getList(null,
					"ViewRmGetlinkstoassign.findAll");

			if (menuList != null) {
				menuItemID = (List<RmRolemenuitem>) roleManagementService.getList(rmRoleid,
						"RmRolemenuitem.findByRmRoleID");

			}

			modelAndView.addObject("employeename", employeename);
			modelAndView.addObject("office", office);
			modelAndView.addObject("roleRightsList", menuItemID);
			modelAndView.addObject("Links", menuList);
			modelAndView.addObject("rmRoleid", rmRoleid);

			modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
			modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

			return modelAndView;
		}

	}

	@RequestMapping(value = "/defineRoleInfo")
	public ModelAndView defineRole(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("defineRole");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		System.out.println(rmOfficeid + "%%%%%%%%%%%%%%%%");

		List<ViewRmRoleslist> roleInfoList = (List<ViewRmRoleslist>) roleManagementService.getList(rmOfficeid,
				"ViewRmRoleslist.findByRmOfficeid");

		modelAndView.addObject("roleInfoList", roleInfoList);
		modelAndView.addObject("rmOfficeid", rmOfficeid);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping(value = "/createNewRole")
	public ModelAndView createNewRole(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("defineRole");
		String rmRoleid = request.getParameter("rmRoleid");
		HttpSession session = request.getSession();

		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		createUserDTO.setRmOfficeid(rmOfficeid);

		String error = "";

		if (createUserDTO.getRolename().equals("")) {
			error = error + "\t" + "Role Name can not be empty";
		}

		if (error.equals("")) {

			if (rmRoleid.equals("")) {
				roleManagementService.addRole(createUserDTO);
				modelAndView.addObject("msg", "Process completed successfully");
			} else {
				createUserDTO.setRmRoleid(rmRoleid);
				roleManagementService.editRole(createUserDTO);
				modelAndView.addObject("msg", "RoleName  updated  successfully");
			}

		}

		else {
			modelAndView.addObject("error", error);

		}

		List<ViewRmRoleslist> roleInfoList = (List<ViewRmRoleslist>) roleManagementService.getList(rmOfficeid,
				"ViewRmRoleslist.findByRmOfficeid");

		modelAndView.addObject("roleInfoList", roleInfoList);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@ModelAttribute
	public ModelAndView addingCommonObjects(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		ModelAndView modelAndView = new ModelAndView("index");
		if (session == null) {
			modelAndView.addObject("msg", "Session Expired");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/EditDefineRole")
	public ModelAndView EditDefineRole(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("defineRole");
		String rmRoleid = request.getParameter("rmRoleid");
		String roleName = null;
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		List<ViewRmRoleslist> roleInfo = (List<ViewRmRoleslist>) roleManagementService.getList(rmRoleid,
				"ViewRmRoleslist.findByRmRoleid");
		for (ViewRmRoleslist viewRmRoleslist : roleInfo) {
			roleName = viewRmRoleslist.getRolename();
		}
		List<ViewRmRoleslist> roleInfoList = (List<ViewRmRoleslist>) roleManagementService.getList(rmOfficeid,
				"ViewRmRoleslist.findByRmOfficeid");

		modelAndView.addObject("roleInfoList", roleInfoList);
		modelAndView.addObject("roleName", roleName);
		modelAndView.addObject("rmRoleid", rmRoleid);
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping(value = "/DeleteRoles")
	public ModelAndView DeleteRoles(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("defineRole");
		String rmRoleid = request.getParameter("rmRoleid");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		roleManagementService.deleteRole(rmRoleid);
		List<ViewRmRoleslist> roleInfoList = (List<ViewRmRoleslist>) roleManagementService.getList(rmOfficeid,
				"ViewRmRoleslist.findByRmOfficeid");

		modelAndView.addObject("roleInfoList", roleInfoList);
		modelAndView.addObject("rmRoleid", rmRoleid);
		modelAndView.addObject("msg", "Record deleted successfully");

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping(value = "/AssignRightsForDefineRole")
	public ModelAndView ChangeRightsForDefineRole(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("assignRights");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		String rmRoleid = request.getParameter("rmRoleid");
		String roleName = null;
		List<RmRolemenuitem> menuItemID = null;
		List<RmRole> roleNameInfo = (List<RmRole>) roleManagementService.getList(rmRoleid, "RmRole.findByRmRoleid");
		for (RmRole rmRole : roleNameInfo) {
			roleName = rmRole.getRolename();
		}
		List<ViewRmGetlinkstoassign> menuList = (List<ViewRmGetlinkstoassign>) roleManagementService.getList(null,
				"ViewRmGetlinkstoassign.findAll");

		if (menuList != null) {
			menuItemID = (List<RmRolemenuitem>) roleManagementService.getList(rmRoleid,
					"RmRolemenuitem.findByRmRoleID");

		}
		modelAndView.addObject("Links", menuList);
		modelAndView.addObject("roleName", roleName);
		modelAndView.addObject("roleRightsList", menuItemID);
		modelAndView.addObject("rmRoleid", rmRoleid);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping(value = "/assignRoles")
	public ModelAndView assignRoles(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("defineRole");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		System.out.println(rmOfficeid + "%%%%%%%%%%%%%%%%");
		String rmRoleid = request.getParameter("rmRoleid");

		List<ViewRmRoleslist> roleInfoList = (List<ViewRmRoleslist>) roleManagementService.getList(rmOfficeid,
				"ViewRmRoleslist.findByRmOfficeid");

		modelAndView.addObject("roleInfoList", roleInfoList);
		modelAndView.addObject("rmOfficeid", rmOfficeid);

		int x = roleManagementService.setRoleRights(createUserDTO);
		modelAndView.addObject("mes", "AssignRoles sucessfully");

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping(value = "/changeRightsRoles")
	public ModelAndView changeRightsRoles(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("assignOfficedmin");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		System.out.println(rmOfficeid + "%%%%%%%%%%%%%%%%");
		String rmRoleid = request.getParameter("rmRoleid");

		List<ViewRmRoleslist> roleInfoList = (List<ViewRmRoleslist>) roleManagementService.getList(rmOfficeid,
				"ViewRmRoleslist.findByRmOfficeid");

		modelAndView.addObject("roleInfoList", roleInfoList);
		modelAndView.addObject("rmOfficeid", rmOfficeid);

		int x = roleManagementService.setRoleRights(createUserDTO);
		modelAndView.addObject("mes", "AssignRoles sucessfully");

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping(value = "/changeAssignRoles")
	public ModelAndView changeAssignRoles(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("assignOfficedmin");

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		System.out.println(rmOfficeid + "%%%%%%%%%%%%%%%%");
		String rmRoleid = request.getParameter("rmRoleid");

		HashMap<Integer, String> officelevelMap = new HashMap<Integer, String>();
		List<MasOfficelevel> list = (List<MasOfficelevel>) roleManagementService.getList(null,
				"MasOfficelevel.findAll");

		for (MasOfficelevel masOfficelevel : list) {
			officelevelMap.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());

		}

		List<ViewRmOfficeadminlist> employeeInfoList = (List<ViewRmOfficeadminlist>) roleManagementService.getList(null,
				"ViewRmOfficeadminlist.findAll");

		for (ViewRmOfficeadminlist viewRmOfficeadminlist : employeeInfoList) {
			System.out.println(viewRmOfficeadminlist.getEmployeecode() + " " + viewRmOfficeadminlist.getEmployeename());
		}
		modelAndView.addObject("officelevelMap", officelevelMap);
		modelAndView.addObject("employeeInfoList", employeeInfoList);

		int x = roleManagementService.setRoleRights(createUserDTO);
		modelAndView.addObject("rmOfficeid", rmOfficeid);
		if (x == 1) {
			modelAndView.addObject("success", "Change Rights sucessfully");
		} else {
			modelAndView.addObject("error", "Some error occured");

		}

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping(value = "/payBill")
	public ModelAndView payBill(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("updatepayBill");
		HttpSession session = request.getSession();
		String ppEmployeemasterid = (String) session.getAttribute("ppEmployeemasterid");

		String treeItems = getLinksForTree(ppEmployeemasterid);
		request.setAttribute("treeItems", treeItems);
		// modelAndView.addObject("treeItems", treeItems.toString());
		modelAndView.addObject("hello", "hello");
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		return modelAndView;

	}

	@RequestMapping(value = "/payBillTest")
	public ModelAndView payBillTest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("PayAllowanceDetail");

		HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping(value = "/login")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("index");

		HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	String getLinksForTree(String ppEmployeemasterid) {
		String innerHtml = "";

		int curLevel = 0;
		int prevLevel = 0;
		String[] inParam = new String[2];
		boolean isShown = true;

		List<ViewRmGetlinkstoassign> list = (List<ViewRmGetlinkstoassign>) roleManagementService
				.getRoleLinksToAssign(Integer.parseInt(ppEmployeemasterid));

		System.out.println("New Debug----1");
		if (list != null) {
			System.out.println("New Debug----2");
			innerHtml = innerHtml + "<script language='javascript'>" + "var TREE_ITEMS = [";
			int listSize = list.size();
			int j = 0;

			for (int i = 0; i < listSize; i++) {

				ViewRmGetlinkstoassign dto = (ViewRmGetlinkstoassign) list.get(i);

				inParam[0] = ppEmployeemasterid;
				inParam[1] = dto.getRmMenuitemid() + "";

				if (isShown) {

					if (i > 0) {

						int k = i - j;
						if (k > 0) {

							ViewRmGetlinkstoassign dtoPrev = (ViewRmGetlinkstoassign) list.get(k - 1);
							curLevel = Integer.parseInt(dto.getLinklevel() + "");
							prevLevel = Integer.parseInt(dtoPrev.getLinklevel() + "");

							if (curLevel == prevLevel) {

								innerHtml = innerHtml + "],";
							} else if (curLevel < prevLevel) {

								innerHtml = innerHtml + "],\n";
								for (int ii = 0; ii < prevLevel - curLevel; ii++) {

									innerHtml = innerHtml + "],\n";

								}

							} else {

								innerHtml = innerHtml + ",";

							} // end if-else
						} // end if

					}

					if (dto.getQuerystring() != null) {

						if (dto.getLinks() != null) {

							innerHtml = innerHtml + "['" + dto.getMenuname().trim() + "','" + dto.getLinks() + "?"
									+ dto.getQuerystring() + "'";

						} else {

							innerHtml = innerHtml + "['" + dto.getMenuname().trim() + "',null";
						} // end nested if

					} else {

						if (dto.getLinks() != null) {

							innerHtml = innerHtml + "['" + dto.getMenuname().trim() + "','" + dto.getLinks() + "'";
						} else {

							innerHtml = innerHtml + "['" + dto.getMenuname().trim() + "',null";

						} // end nested if

					} // end nested if

					j = 0;

				} else {

					j++;
					// System.out.println("In else "+j);
				}

			} // end nested if

		} // end if

		innerHtml = innerHtml + "],";
		for (int i = 0; i < curLevel - 2; i++) {

			innerHtml = innerHtml + "],";
		} // end for
		innerHtml = innerHtml + "]\n];";

		innerHtml = innerHtml + "new tree (TREE_ITEMS, tree_tpl);\n</script>";

		// System.out.println("innerHtml = " + innerHtml);

		return innerHtml;

	}

	@RequestMapping(value = "/ModifyUserRoles")
	public ModelAndView ModifyUserRoles(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView target = new ModelAndView("modifyuserroles");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		List<?> list = roleManagementService.selectquery(rmOfficeid, "ViewRmEmployeerolelist.findByRmOfficeid");
		List<ViewRmEmplistRole> list1 = (List<ViewRmEmplistRole>) roleManagementService.selectquery(rmOfficeid,
				"ViewRmEmplistRole.find");
		List<?> list2 = roleManagementService.selectquery(rmOfficeid, "ViewRmRoleslist.findByRmOfficeid");

		target.addObject("employeelist", list);
		target.addObject("listName", list1);
		target.addObject("rolelist", list2);
		
		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		

		return target;

	}

	@RequestMapping(value = "/modificationOfUserRoles")
	public ModelAndView modificationOfUserRoles(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView target = new ModelAndView("modifyuserroles");
		List<ViewRmRolesforemployee> list3 = new ArrayList<ViewRmRolesforemployee>();
		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		List<Integer> list5 = roleManagementService.getList(ppEmployeemasterid,
				"ViewRmRolesforemployee.findByPpEmployeemasterid");
		Iterator itr = list5.iterator();
		while (itr.hasNext()) {
			ViewRmRolesforemployee viewRmRolesforemployee = new ViewRmRolesforemployee();
			viewRmRolesforemployee.setRmRoleid((int) itr.next());
			list3.add(viewRmRolesforemployee);

		}
		target.addObject("rolelistById", list3);

		List<ViewRmRolesforemployee> list01 = roleManagementService.loadObject(ppEmployeemasterid);

		for (ViewRmRolesforemployee viewRmRolesforemployee : list01) {
			target.addObject("employeename", viewRmRolesforemployee.getEmployeename());

		}

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		List<ViewRmEmplistRole> list1 = (List<ViewRmEmplistRole>) roleManagementService.selectquery(rmOfficeid,
				"ViewRmEmplistRole.find");

		List<?> list = roleManagementService.selectquery(rmOfficeid, "ViewRmEmployeerolelist.findByRmOfficeid");

		target.addObject("employeelist", list);

		List<?> list2 = roleManagementService.selectquery(rmOfficeid, "ViewRmRoleslist.findByRmOfficeid");
		target.addObject("rolelist", list2);
		target.addObject("ppEmployeemasterid", ppEmployeemasterid);
		
		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;

	}

	@RequestMapping(value = "/addModifyRoleOfUser")
	public ModelAndView addModifyRoleOfUser(@ModelAttribute("createUserDTO") CreateUserDTO createUserDTO,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView target = new ModelAndView("modifyuserroles");
		String ppEmployeemasterid = request.getParameter("ppEmployeemasterid");
		createUserDTO.setPpEmployeemasterid(ppEmployeemasterid);
		if (ppEmployeemasterid.equals("0")) {
			ppEmployeemasterid = null;
		}

		String error = null;
		if (ppEmployeemasterid == null || createUserDTO.getRoles() == null) {
			error = "Please CLICK  modify LINK to Modify the USER-ROLES";
		}

		if (error == null) {

			roleManagementService.deleteFromDB(createUserDTO);

		} else {
			target.addObject("error", error);
		}

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

		List<ViewRmEmplistRole> list1 = (List<ViewRmEmplistRole>) roleManagementService.selectquery(rmOfficeid,
				"ViewRmEmplistRole.find");

		List<?> list = roleManagementService.selectquery(rmOfficeid, "ViewRmEmployeerolelist.findByRmOfficeid");

		target.addObject("employeelist", list);

		List<?> list2 = roleManagementService.selectquery(rmOfficeid, "ViewRmRoleslist.findByRmOfficeid");
		target.addObject("rolelist", list2);
		target.addObject("ppEmployeemasterid", ppEmployeemasterid);
		
		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;

	}

}
