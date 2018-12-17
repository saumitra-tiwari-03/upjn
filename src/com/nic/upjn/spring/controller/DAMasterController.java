package com.nic.upjn.spring.controller;

import java.io.IOException;
import java.util.HashMap;
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

import com.google.gson.Gson;
import com.nic.upjn.spring.Service.DAMasterService;
import com.nic.upjn.spring.dto.DAActionDTO;
import com.nic.upjn.spring.dto.DesignationMasterDTO;
import com.nic.upjn.spring.dto.LoanMasterDTO;
import com.nic.upjn.spring.entity.DADEntity;
import com.nic.upjn.spring.entity.MasEmploymentsubtype;
import com.nic.upjn.spring.entity.MasEmploymenttype;
import com.nic.upjn.spring.entity.PpDesignationmaster;
import com.nic.upjn.spring.entity.PpLoanmaster;
import com.nic.upjn.spring.entity.PpPlacemaster;
import com.nic.upjn.spring.entity.ViewDesignationlist;

@SuppressWarnings({ "unchecked", "unused" })
@Controller
public class DAMasterController {

	@Autowired
	DAMasterService daMasterService;

	@RequestMapping("/DAForm.do")
	public ModelAndView DAForm(HttpServletRequest request, HttpServletResponse response) {
		List<DADEntity> list;
		HttpSession session = request.getSession();

		System.out.println("DA invoked");
		ModelAndView modelAndView = new ModelAndView("damaster");
		list = daMasterService.getDAList();
		modelAndView.addObject("dalist", list);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;
	}

	@RequestMapping(value = "/addDARecord", method = RequestMethod.POST)
	public ModelAndView NewUser(@ModelAttribute("daActionDTO") DAActionDTO daActionDTO, HttpServletRequest request,
			HttpServletResponse response) {

		List<DADEntity> list;

		ModelAndView modelAndView = new ModelAndView("damaster");
		boolean isComplete = true;
		HttpSession session = request.getSession();

		isComplete = daMasterService.insertDA(daActionDTO);
		if (isComplete) {
			modelAndView.addObject("success", "Item Added successfully");
		} else {
			modelAndView.addObject("error", "Something went wrong");
		}

		list = daMasterService.getDAList();
		modelAndView.addObject("dalist", list);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;
	}

	/** Loan Master started here **/

	@RequestMapping("/LoanMaster.do")
	public ModelAndView loanMaster(HttpServletRequest request, HttpServletResponse response) {

		List<PpLoanmaster> loanMasterList = null;
		int listSize;
		HttpSession session = request.getSession();
		loanMasterList = daMasterService.getList(null, "PpLoanmaster.findAll");

		ModelAndView modelAndView = new ModelAndView("loanMaster");
		modelAndView.addObject("loanMasterList", loanMasterList);

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;
	}

	@RequestMapping(value = "/addNewLoanDetails", method = RequestMethod.POST)
	public ModelAndView addNewLoanRecord(@ModelAttribute("loanMasterDTO") LoanMasterDTO loanMasterDTO,
			HttpServletRequest request, HttpServletResponse response) {
		boolean isComplete = false;
		HttpSession session = request.getSession();
		List<PpLoanmaster> loanMasterList = null;
		ModelAndView modelAndView = new ModelAndView("loanMaster");
		System.out.println("invoked");

		if (loanMasterDTO.getPp_LoanMasterID() == null || loanMasterDTO.getPp_LoanMasterID() == "") {
			isComplete = daMasterService.insertLoanMaster(loanMasterDTO);
			if (isComplete) {
				modelAndView.addObject("success", "New Loan record  added successfully");
			} else {
				modelAndView.addObject("error", "Something went wrong");
			}
		} else {
			isComplete = daMasterService.updateLoanMaster(loanMasterDTO);
			if (isComplete) {
				modelAndView.addObject("success", "Update New Loan record successfully");
			} else {
				modelAndView.addObject("error", "Something went wrong");
			}

		}
		loanMasterList = daMasterService.getList(null, "PpLoanmaster.findAll");

		modelAndView.addObject("loanMasterList", loanMasterList);
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		return modelAndView;

	}

	@RequestMapping("/editLoan")
	public ModelAndView editLoanNEW(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("loanMaster");
		HttpSession session = request.getSession();
		String ppLoanmasterid = request.getParameter("ppLoanmasterid");
		List<PpLoanmaster> loanMasterDetails = daMasterService.getList(ppLoanmasterid,
				"PpLoanmaster.findByPpLoanmasterid");

		List<PpLoanmaster> loanMasterList = null;
		loanMasterList = daMasterService.getList(null, "PpLoanmaster.findAll");
		modelAndView.addObject("loanMasterList", loanMasterList);
		modelAndView.addObject("list", loanMasterDetails);
		modelAndView.addObject("pp_LoanMasterID", ppLoanmasterid);
		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		return modelAndView;

	}

	@RequestMapping("/deleteNewLoanInfo")
	public ModelAndView deleteNewLoanInfo(HttpServletRequest request, HttpServletResponse response) {
		boolean isComplete;
		ModelAndView modelAndView = new ModelAndView("loanMaster");
		String ppLoanmasterid = request.getParameter("ppLoanmasterid");
		List<PpLoanmaster> loanMasterList = null;
		loanMasterList = daMasterService.getList(null, "PpLoanmaster.findAll");
		modelAndView.addObject("loanMasterList", loanMasterList);
		isComplete = daMasterService.deleteLoanMaster(ppLoanmasterid);
		if (isComplete) {
			modelAndView.addObject("success", "New Loan record  deleted successfully");
		} else {
			modelAndView.addObject("success", "something error");
		}
		HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		return modelAndView;

	}

	/** Designation Master Master started here **/

	@RequestMapping("/designation.do")
	public ModelAndView designationMaster(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("designationMaster");
		HashMap<Integer, String> masEmploymenttypeMap = new HashMap<Integer, String>();

		List<MasEmploymenttype> masEmploymenttypeList = null;
		masEmploymenttypeList = daMasterService.getList(null, "MasEmploymenttype");
		for (MasEmploymenttype masEmploymenttype : masEmploymenttypeList) {
			masEmploymenttypeMap.put(masEmploymenttype.getMasEmploymenttypeid(), masEmploymenttype.getEmploymenttype());
		}
		List<ViewDesignationlist> designationList = null;
		designationList = daMasterService.getList(null, "ViewDesignationlist.findAll");

		modelAndView.addObject("masEmploymenttypeMap", masEmploymenttypeMap);
		modelAndView.addObject("designationList", designationList);

		HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		return modelAndView;

	}

	@RequestMapping(value = "/addNewDesignationDetails", method = RequestMethod.POST)
	public ModelAndView addNewDesignation(
			@ModelAttribute("designationMasterDTO") DesignationMasterDTO designationMasterDTO,
			HttpServletRequest request, HttpServletResponse response) {
		boolean isComplete = false;

		ModelAndView modelAndView = new ModelAndView("designationMaster");
		HashMap<Integer, String> masEmploymenttypeMap = new HashMap<Integer, String>();

		List<MasEmploymenttype> masEmploymenttypeList = null;
		masEmploymenttypeList = daMasterService.getList(null, "MasEmploymenttype");
		for (MasEmploymenttype masEmploymenttype : masEmploymenttypeList) {
			masEmploymenttypeMap.put(masEmploymenttype.getMasEmploymenttypeid(), masEmploymenttype.getEmploymenttype());
		}
		List<ViewDesignationlist> designationList = null;
		designationList = daMasterService.getList(null, "ViewDesignationlist.findAll");

		modelAndView.addObject("masEmploymenttypeMap", masEmploymenttypeMap);
		modelAndView.addObject("designationList", designationList);

		if (designationMasterDTO.getPp_DesignationMasterID() == null
				|| designationMasterDTO.getPp_DesignationMasterID().equals("")) {
			isComplete = daMasterService.addDesignation(designationMasterDTO);
			modelAndView.addObject("ppDesignationmasterid", designationMasterDTO.getPp_DesignationMasterID());
			if (isComplete) {
				modelAndView.addObject("success", "Add designation record  successfully");
			} else {
				modelAndView.addObject("error", "Something went wrong");
			}
		} else {
			isComplete = daMasterService.editDesignation(designationMasterDTO);
			if (isComplete) {
				modelAndView.addObject("success", "Update designation  record successfully");
			} else {
				modelAndView.addObject("error", "Something went wrong");
			}
		}

		HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping(value = "/getMasEmploymentsubtyList", method = RequestMethod.POST)
	public void getMasEmploymentsubtyList(HttpServletRequest request, HttpServletResponse response) {

		HashMap<String, String> hmap = new HashMap<String, String>();
		String _mas_EmploymentTypeID = request.getParameter("_mas_EmploymentTypeID");
		String json = null;

		List<MasEmploymentsubtype> MasEmploymentsubtypeList = (List<MasEmploymentsubtype>) daMasterService
				.getList(_mas_EmploymentTypeID, "MasEmploymentsubtype.findByMasEmploymenttypeid");

		for (MasEmploymentsubtype masEmploymentsubtype : MasEmploymentsubtypeList) {
			hmap.put(masEmploymentsubtype.getMasEmploymentsubtypeid() + "",
					masEmploymentsubtype.getEmploymentsubtype());

		}

		json = new Gson().toJson(hmap);
		response.setContentType("application/json");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@RequestMapping("/editDesignation")
	public ModelAndView editDesignation(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("designationMaster");
		String ppDesignationmasterid = request.getParameter("ppDesignationmasterid");
		HashMap<Integer, String> masEmploymenttypeMap = new HashMap<Integer, String>();

		List<MasEmploymenttype> masEmploymenttypeList = null;
		masEmploymenttypeList = daMasterService.getList(null, "MasEmploymenttype");
		for (MasEmploymenttype masEmploymenttype : masEmploymenttypeList) {
			masEmploymenttypeMap.put(masEmploymenttype.getMasEmploymenttypeid(), masEmploymenttype.getEmploymenttype());
		}
		List<ViewDesignationlist> designationList = null;
		designationList = daMasterService.getList(null, "ViewDesignationlist.findAll");

		modelAndView.addObject("masEmploymenttypeMap", masEmploymenttypeMap);
		modelAndView.addObject("designationList", designationList);

		List<PpDesignationmaster> designationInfiList = (List<PpDesignationmaster>) daMasterService
				.getList(ppDesignationmasterid, "PpDesignationmaster.findByPpDesignationmasterid");

		modelAndView.addObject("ppDesignationmasterid", ppDesignationmasterid);
		modelAndView.addObject("designationInfiList", designationInfiList);

		HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	@RequestMapping("/deleteDesignation")
	public ModelAndView deleteDesignationDetails(HttpServletRequest request, HttpServletResponse response) {
		boolean isComplete;
		ModelAndView modelAndView = new ModelAndView("designationMaster");
		String ppDesignationmasterid = request.getParameter("ppDesignationmasterid");
		HashMap<Integer, String> masEmploymenttypeMap = new HashMap<Integer, String>();

		List<MasEmploymenttype> masEmploymenttypeList = null;
		masEmploymenttypeList = daMasterService.getList(null, "MasEmploymenttype");
		for (MasEmploymenttype masEmploymenttype : masEmploymenttypeList) {
			masEmploymenttypeMap.put(masEmploymenttype.getMasEmploymenttypeid(), masEmploymenttype.getEmploymenttype());
		}
		List<ViewDesignationlist> designationList = null;
		designationList = daMasterService.getList(null, "ViewDesignationlist.findAll");

		modelAndView.addObject("masEmploymenttypeMap", masEmploymenttypeMap);
		modelAndView.addObject("designationList", designationList);

		isComplete = daMasterService.deleteDesignation(ppDesignationmasterid);

		if (isComplete) {
			modelAndView.addObject("success", "New New designation record  deleted successfully");
		} else {
			modelAndView.addObject("success", "something error");
		}

		HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

}
