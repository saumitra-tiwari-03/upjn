package com.nic.upjn.spring.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.spring.Service.EmployeeAppointmentService;
import com.nic.upjn.spring.Service.OfficeBankAccountService;
import com.nic.upjn.spring.dto.OfficeBankAccountDTO;
import com.nic.upjn.spring.entity.FwaBankaccount;
import com.nic.upjn.spring.entity.MasDistrict;
import com.nic.upjn.spring.entity.MasOfficelevel;

@Controller
public class OfficeBankAccountController {

	@Autowired
	private EmployeeAppointmentService employeeAppointmentService;

	@Autowired
	private OfficeBankAccountService officebankaccountservice;

	ModelAndView target = new ModelAndView();
	Integer rmOfficeid;
	HashMap<Integer, String> hm = new HashMap<Integer, String>();
	HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
	List<?> banklist = null;
	List bankaccountList = null;
	String root = "";

	@SuppressWarnings("unchecked")
	@RequestMapping("/OfficeBankAccountbegin")
	public ModelAndView begin(HttpServletRequest request, HttpServletResponse response) {

		try {
			target = new ModelAndView("OfficeBankAccount");

			HttpSession session = request.getSession();
			rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			List<MasOfficelevel> list = (List<MasOfficelevel>) employeeAppointmentService.getList(null,
					"MasOfficelevel.findAll");

			for (MasOfficelevel masOfficelevel : list) {
				hm.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());
			}

			List<MasDistrict> list1 = (List<MasDistrict>) employeeAppointmentService.getList(null,
					"MasDistrict.findAll");

			for (MasDistrict masDistrict : list1) {
				hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());
			}

			/* List of Banks */
			banklist = employeeAppointmentService.getList(null, "MasBank.findAll");

			/* List of Bank Accounts */
			bankaccountList = officebankaccountservice.retrieveBankAccountList(rmOfficeid);

			target.addObject("banklist", banklist);
			target.addObject("bankaccountList", bankaccountList);
			target.addObject("Data", hm);
			target.addObject("Data1", hm1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/OfficeBankAccount")
	public ModelAndView OfficeBankAccount(@ModelAttribute("dto") OfficeBankAccountDTO dto, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			target = new ModelAndView("OfficeBankAccount");
			FwaBankaccount fwabankaccount = new FwaBankaccount();
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			/* Office Combo */
			List<MasOfficelevel> list = (List<MasOfficelevel>) employeeAppointmentService.getList(null,
					"MasOfficelevel.findAll");

			for (MasOfficelevel masOfficelevel : list) {
				hm.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());
			}

			List<MasDistrict> list1 = (List<MasDistrict>) employeeAppointmentService.getList(null,
					"MasDistrict.findAll");

			for (MasDistrict masDistrict : list1) {
				hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());
			}

			/* Insert new Account */
			if (dto.getRoot().equals("add")) {
				
				BeanUtils.copyProperties(dto, fwabankaccount);
				fwabankaccount.setRmOfficeid(rmOfficeid);
				fwabankaccount.setRmOfficeid1(dto.getOfficeid());

				boolean result = officebankaccountservice.saveaccountinfo(fwabankaccount);

				if (result == true) {
					target.addObject("success", "Account Created Successfully");
				} else {
					target.addObject("error", "Error in Opening Account");
				}
			}
			
			/* Edit Account Details */
			if (dto.getRoot().equals("edit")) {
			    BeanUtils.copyProperties(dto, fwabankaccount);
			    fwabankaccount.setRmOfficeid(rmOfficeid);
				fwabankaccount.setRmOfficeid1(dto.getOfficeid());
		        
				int result = officebankaccountservice.editaccountinfo(fwabankaccount);
				if (result == 1) {
					target.addObject("success", "Account Edited Successfully");
				} else {
					target.addObject("error", "Error in Editing Account");
				}
			}
			/* List of Banks */
			banklist = employeeAppointmentService.getList(null, "MasBank.findAll");

			System.out.println(banklist.size() + "-----size of bank list");

			/* List of Bank Accounts */
			bankaccountList = officebankaccountservice.retrieveBankAccountList(rmOfficeid);

			target.addObject("bankaccountList", bankaccountList);
			target.addObject("Data", hm);
			target.addObject("Data1", hm1);
			target.addObject("banklist", banklist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/populateBankAccount")
	public ModelAndView populateBankInfo(HttpServletRequest request, HttpServletResponse response) {

		try {
			target = new ModelAndView("OfficeBankAccount");

			HttpSession session = request.getSession();
			rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			/* Office Combo */
			List<MasOfficelevel> list = (List<MasOfficelevel>) employeeAppointmentService.getList(null,
					"MasOfficelevel.findAll");

			for (MasOfficelevel masOfficelevel : list) {
				hm.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());
			}

			List<MasDistrict> list1 = (List<MasDistrict>) employeeAppointmentService.getList(null,
					"MasDistrict.findAll");

			for (MasDistrict masDistrict : list1) {
				hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());
			}

			/* Retrieve Account Info */
			String id = request.getParameter("fwaBankaccountid");
			List accountinfo = officebankaccountservice.populateofficeaccount(id,
					"FwaBankaccount.findbyfwaBankaccountid");

			/* List of Banks */
			banklist = employeeAppointmentService.getList(null, "MasBank.findAll");

			/* List of Bank Accounts */
			bankaccountList = officebankaccountservice.retrieveBankAccountList(rmOfficeid);

			target.addObject("accountinfo", accountinfo);
			target.addObject("banklist", banklist);
			target.addObject("bankaccountList", bankaccountList);
			target.addObject("Data", hm);
			target.addObject("Data1", hm1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/deleteBankAccount")
	public ModelAndView deleteBankAccount(HttpServletRequest request, HttpServletResponse response) {

		try {
			target = new ModelAndView("OfficeBankAccount");
			String id = request.getParameter("fwaBankaccountid");

			HttpSession session = request.getSession();
			rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			List<MasOfficelevel> list = (List<MasOfficelevel>) employeeAppointmentService.getList(null,
					"MasOfficelevel.findAll");

			for (MasOfficelevel masOfficelevel : list) {
				hm.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());
			}

			List<MasDistrict> list1 = (List<MasDistrict>) employeeAppointmentService.getList(null,
					"MasDistrict.findAll");

			for (MasDistrict masDistrict : list1) {
				hm1.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());
			}

			/* List of Banks */
			banklist = employeeAppointmentService.getList(null, "MasBank.findAll");

			/* Delete Bank Account */
			boolean result = officebankaccountservice.deleteaccountinfo(id);
			if (result == true) {
				target.addObject("success", "Account Deleted Successfully");
			} else {
				target.addObject("error", "Error in Deleting Account");
			}
			/* List of Bank Accounts */
			bankaccountList = officebankaccountservice.retrieveBankAccountList(rmOfficeid);

			target.addObject("banklist", banklist);
			target.addObject("bankaccountList", bankaccountList);
			target.addObject("Data", hm);
			target.addObject("Data1", hm1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}	

}
