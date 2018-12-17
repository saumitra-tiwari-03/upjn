package com.nic.upjn.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ParseConversionEvent;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.nic.upjn.spring.Service.PayScaleMasterService;
import com.nic.upjn.spring.dto.PayScaleMasterDTO;
import com.nic.upjn.spring.entity.PpPayscalemaster;

@Controller
public class PayScaleMasterController {

	@Autowired
	PayScaleMasterService payscalemasterservice;

	/********************************** By Default method - Called on click by menu *******************************************/
	
	
	@RequestMapping("/PayScaleMaster")
	public ModelAndView begin(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("PayScaleMaster");

		try {
			List payscalelist = null;

			List paycategorylist = payscalemasterservice.paycategorylist(null, "SysPaycategory.findAll");
			System.out.println("size of list --" + paycategorylist.size());

			target.addObject("paycategorylist", paycategorylist);
			target.addObject("payscalelist", payscalelist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}

	/********************************************** Create New PayScale *************************************************************/

	@SuppressWarnings("rawtypes")
	@RequestMapping("/insertPayScale")
	public ModelAndView insertPayScale(@ModelAttribute("dto") PayScaleMasterDTO dto, HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("PayScaleMaster");

		try {
			// Row Count
			boolean lastInsertID = false;

			// check existance of payScale field and min,max Amt
			boolean isExistanceError = this.checkExistance(dto);

			// insert data to database if there is no existance error occured
			if (!isExistanceError) {
				PpPayscalemaster ppPayscalemaster = new PpPayscalemaster();

				BeanUtils.copyProperties(dto, ppPayscalemaster);

				System.out.println("Copy Complete");

				// call manager's method to add value to database
				lastInsertID = payscalemasterservice.AddPayScale(ppPayscalemaster);
				
				target.addObject("msg", "PayScale Created Successfully");
				
				List paycategorylist = payscalemasterservice.paycategorylist(null, "SysPaycategory.findAll");
				target.addObject("paycategorylist", paycategorylist); 
				List<PpPayscalemaster> list = payscalemasterservice.getPayScaleList(dto.getSysPaycategoryid());
				target.addObject("payscalelist", list);
			}

		} catch (Exception e) {
			e.printStackTrace();
			target.addObject("msg", "Error");
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}

/****************************************************** Populate PayScale **************************************************************************/	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/populatePayScale")
	public ModelAndView populatePayScale(@ModelAttribute("dto") PayScaleMasterDTO dto,HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView target = new ModelAndView("PayScaleMaster");
		List payscaledetail = null;

		try {
			   String ppPayscalemasterid= request.getParameter("ppPayscalemasterid");
			   
			   if(ppPayscalemasterid != null){
		  
			   payscaledetail = payscalemasterservice.paycategorylist(ppPayscalemasterid,"PpPayscalemaster.findByPpPayscalemasterid");
			   
			   }
			   
			   target.addObject("payscaledetail", payscaledetail);
			   
			   List paycategorylist = payscalemasterservice.paycategorylist(null, "SysPaycategory.findAll");
			   target.addObject("paycategorylist", paycategorylist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}
	
	/****************************************************** Edit PayScale **************************************************************************/	
	
	@RequestMapping("/editPayScale")
	public ModelAndView editPayScale(@ModelAttribute("dto") PayScaleMasterDTO dto,HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView target = new ModelAndView("PayScaleMaster");

		try {
			// Row Count
			boolean lastInsertID = false;
						
			// check existance of payScale field and min,max Amt
			  boolean isExistanceError = this.checkExistance(dto); 
			  
			// insert data to database if there is no existance error occured
				if (!isExistanceError) {
					PpPayscalemaster ppPayscalemaster = new PpPayscalemaster();

					ppPayscalemaster.setPpPayscalemasterid(Integer.parseInt(dto.getPp_PayScaleMasterID()));
					ppPayscalemaster.setDefaultincrement(dto.getDefaultincrement());
					ppPayscalemaster.setMaxamt(dto.getMaxamt());
					ppPayscalemaster.setMinamt(dto.getMinamt());
					ppPayscalemaster.setPayscale(dto.getPayscale());
					ppPayscalemaster.setSysPaycategoryid(dto.getSysPaycategoryid());
					ppPayscalemaster.setWeight((short)0);

					System.out.println("Copy Complete");

					// call manager's method to add value to database
					lastInsertID = payscalemasterservice.EditPayScale(ppPayscalemaster);
					
					target.addObject("msg", "PayScale Edited Successfully");
					
				}
				List paycategorylist = payscalemasterservice.paycategorylist(null, "SysPaycategory.findAll");
				target.addObject("paycategorylist", paycategorylist); 
				List<PpPayscalemaster> list = payscalemasterservice.getPayScaleList(dto.getSysPaycategoryid());
				target.addObject("payscalelist", list);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			target.addObject("msg", "Error");
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}	

	/****************************************************** Delete PayScale **************************************************************************/	
	@RequestMapping("/deletePayScale")
	public ModelAndView deletePayScale(@ModelAttribute("dto") PayScaleMasterDTO dto,HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView target = new ModelAndView("PayScaleMaster");

		try {
			String ppPayscalemasterid= request.getParameter("ppPayscalemasterid");
			String sysPaycategoryid= request.getParameter("sysPaycategoryid");
			short id = Short.parseShort(sysPaycategoryid);
			 System.out.println(ppPayscalemasterid+"------"+id);   
			 
			 boolean result = payscalemasterservice.deletePayScale(ppPayscalemasterid);
             
             if(result == true){
           	  target.addObject("msg", "PayScale Deleted");
             }else{
           	  target.addObject("msg", "Error");
             }
             List paycategorylist = payscalemasterservice.paycategorylist(null, "SysPaycategory.findAll");
				target.addObject("paycategorylist", paycategorylist); 
				List<PpPayscalemaster> list = payscalemasterservice.getPayScaleList(id);
				target.addObject("payscalelist", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}
	
/****************************************************** PayScale List **************************************************************************/	
	@RequestMapping("/getPayScaleList")
	public void getPayScaleList(@ModelAttribute("dto") PayScaleMasterDTO dto,HttpServletRequest request,
			HttpServletResponse response){

		ModelAndView target = new ModelAndView("PayScaleMaster");
		try {
			
		//	String SysPaycategoryid = request.getParameter("sysPaycategoryid");
			//dto.setSysPaycategoryid(SysPaycategoryid);
			System.out.println("inside getPayScaleList" + dto.getSysPaycategoryid());
			
			List paycategorylist = payscalemasterservice.paycategorylist(null, "SysPaycategory.findAll");
			target.addObject("paycategorylist", paycategorylist); 
			List<PpPayscalemaster> list = payscalemasterservice.getPayScaleList(dto.getSysPaycategoryid());
			target.addObject("payscalelist", list);
		/*	List payscaledetail = payscalemasterservice.paycategorylist(null,"PpPayscalemaster.findAll");
			target.addObject("payscaledetail", payscaledetail);*/
			
			String payscalelist = new Gson().toJson(list);
			response.setContentType("application/json");

			String json =payscalelist;
					
			response.getWriter().write(json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	/********************************************** Checking Existance of PayScale *************************************************************/
	@SuppressWarnings("unused")
	private boolean checkExistance(PayScaleMasterDTO dto) throws Exception {

		int minAmt = dto.getMinamt();
		int maxAmt = dto.getMaxamt();

		// Row Count
		boolean isPayScaleExist = false;
		boolean isMinLargeThanMax = false;
		boolean isExistanceError = false;

		try {

			isPayScaleExist = payscalemasterservice.checkExistanceOfPayScale(dto.getPayscale());
			if (isPayScaleExist) {
				String payScale = dto.getPayscale();
			}
			if (minAmt > maxAmt) {
				isMinLargeThanMax = true;
			}

		} catch (Exception e) {

			System.out.println("Exception raised is " + e);

			throw new Exception(e);

		}
		if (isPayScaleExist || isMinLargeThanMax)
			isExistanceError = true;
		return isExistanceError;
	} // end method	
	
}
