package com.nic.upjn.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.spring.Service.DAArrearService;
import com.nic.upjn.spring.Service.ManagePayBillService;
import com.nic.upjn.spring.dto.DAArrearDTO;
import com.nic.upjn.spring.entity.PpDesignationmaster;
import com.nic.upjn.spring.entity.PpEmpalwcontroller;
import com.nic.upjn.spring.entity.PpEmployeedetail;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.PpRegistermaster;
import com.nic.upjn.spring.entity.ViewDAArrearDetail;
import com.nic.upjn.spring.entity.ViewDAArrearPayDetail;

import nicupjnentityclasses.PpEmployeeEldetail;

@Controller
public class DAArrearController {

	@Autowired
	private DAArrearService service;

	@Autowired
	private ManagePayBillService managePayBillService;

	ModelAndView target = null;
	String ppEmployeemasterId = null;

	@RequestMapping("/DAArrearEmployeeWiseForm")
	public ModelAndView DAArrearEmployeeWiseForm() {

		try {
			target = new ModelAndView("DAArrearEmployeeWiseForm");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}

	@SuppressWarnings({"unchecked"})
	@RequestMapping("/empwiseDAArrear")
	public ModelAndView empwiseDAArrear(@ModelAttribute("dto") DAArrearDTO dto) {


		String percentvalue1 = null;
		Date dateofeffect1 = null;
		Date duedate1 = null;
		Date gpfdate1 = null;
		Date cashdate1 = null;
		String duemonth1 = null;
		String dueyear1 = null;
		
		String percentvalue = null;
		Date dateofeffect = null;
		Date duedate = null;
		Date gpfdate = null;
		Date cashdate = null;
		String duemonth = null;
		String dueyear = null;

		String designationid = null;

		try {

			String year = dto.getFinanceYear();
			String yearrange[] = year.split("-");
			String startYear = yearrange[0];
			String endYear = yearrange[1];

			target = new ModelAndView("DAArrearEmployeeWise");

			List<PpEmployeemaster> list = service.getList(dto.getEmployeecode(), "PpEmployeemaster.findByEmployeecode");
			for (PpEmployeemaster ppEmployeemaster : list) {
				ppEmployeemasterId = ppEmployeemaster.getPpEmployeemasterid() + "";
				designationid = ppEmployeemaster.getPpDesignationmasterid() + "";
			}

			List<PpDesignationmaster> designationlist = service.getList(designationid,
					"PpDesignationmaster.findByPpDesignationmasterid");
			for (PpDesignationmaster ppDesignationmaster : designationlist) {
				String designation = ppDesignationmaster.getDesignation();
				target.addObject("designation", designation);
			}

			List<PpEmployeedetail> list1 = service.getList(ppEmployeemasterId,
					"PpEmployeedetail.findByPpEmployeemasterid");

			List<ViewDAArrearPayDetail> paydetail = service.getpayamount(dto.getEmployeecode(), startYear, endYear);

			/*previous DA data list*/
			List<ViewDAArrearDetail> DAList1 = service.getDADetails(startYear, endYear);
			for (ViewDAArrearDetail viewDAArrearDetail : DAList1) {
				dateofeffect1 = viewDAArrearDetail.getDateofeffect();
				duedate1 = viewDAArrearDetail.getDuedate();

				System.out.println("Due Date----" + duedate1);

				duemonth1 = viewDAArrearDetail.getDUEMONTH() + "";
				dueyear1 = viewDAArrearDetail.getDUEYEAR() + "";

				System.out.println("Due Month----" + duemonth1 + "---dueyear----" + dueyear1);

				gpfdate1 = viewDAArrearDetail.getGpfdate();
				cashdate1 = viewDAArrearDetail.getCashdate();
				percentvalue1 = viewDAArrearDetail.getPercentvalue();
				break;
			}

			System.out.println("I am 1st percent value------" + percentvalue1);
			
			/*next DA data list*/
			  List<ViewDAArrearDetail> DAList = service.getDADetails(startYear,endYear);
			   for(ViewDAArrearDetail viewDAArrearDetail : DAList){ 
			  
				  dateofeffect = viewDAArrearDetail.getDateofeffect();   
				  duedate = viewDAArrearDetail.getDuedate();
			  
			  System.out.println("Due Date----"+duedate);
			  
			  duemonth = viewDAArrearDetail.getDUEMONTH()+""; 
			  dueyear =viewDAArrearDetail.getDUEYEAR()+"";
			    
			  System.out.println("Due Month----"
			  +duemonth+"---dueyear----"+dueyear);
			  
			  gpfdate = viewDAArrearDetail.getGpfdate();
			  cashdate =viewDAArrearDetail.getCashdate(); 
			  percentvalue =  viewDAArrearDetail.getPercentvalue(); 
			  }

			target.addObject("dateofeffect", dateofeffect);
			target.addObject("duedate", duedate);
			target.addObject("gpfdate", gpfdate);
			target.addObject("cashdate", cashdate);
			target.addObject("percentvalue", percentvalue);
			target.addObject("duemonth", duemonth);
			target.addObject("dueyear", dueyear);
			
			target.addObject("dateofeffect1", dateofeffect1);
			target.addObject("duedate1", duedate1);
			target.addObject("gpfdate1", gpfdate1);
			target.addObject("cashdate1", cashdate1);
			target.addObject("percentvalue1", percentvalue1);
			target.addObject("duemonth1", duemonth1);
			target.addObject("dueyear1", dueyear1);

			System.out.println("PP Employee Master ID ===" + ppEmployeemasterId);

			System.out.println("size of list ===" + list.size());
			System.out.println("size of list1 ===" + list1.size());
			// System.out.println("size of list2 ==="+list2.size());

			target.addObject("empdetail", list);
			target.addObject("gpfdetail", list1);
			target.addObject("paydetail", paydetail);
			// target.addObject("DAList", DAList);
			// target.addObject("basicpay", basicpay);
			// target.addObject("gradepay", gradepay);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}

	@RequestMapping("/DAArrearRegisterWiseForm")
	public ModelAndView DAArrearRegisterWiseForm() {

		try {
			target = new ModelAndView("DAArrearRegisterWiseForm");
			List<PpRegistermaster> list = managePayBillService.getRegisterList();
			target.addObject("registerList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}

}
