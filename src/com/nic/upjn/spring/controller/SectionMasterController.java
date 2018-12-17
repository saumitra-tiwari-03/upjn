/******************************** LOGIN CONTROLLER CLASS **************************/
/* ==========================================================================
 * Description 	: This class implements controller operations for Login.
 * Date			: 29/03/2016  
 * Author		: Saumitra Tiwari
 * Review By 	: 
 * Review Date	:  
 *==========================================================================
 */

/**
 * This controller class is used for Section Master entry, update and delete.  Controller class get's the request from JSP pages,
 *  based on the requirement , methods of service class are called and finally response is send to the JSP pages.  
 * */

/** Package Name **/
package com.nic.upjn.spring.controller;

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

import com.nic.upjn.spring.Service.SectionMasterService;
import com.nic.upjn.spring.dto.SectionMasterDTO;
import com.nic.upjn.spring.entity.PpSectionmaster;

@Controller
public class SectionMasterController {

	String returnPage = "sectionMaster";
	
	@Autowired
	SectionMasterService sectionMasterService;

	@RequestMapping("/sectionMaster")
	public ModelAndView SectionMaster(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView sectionMasterModel = new ModelAndView(returnPage);
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		List<PpSectionmaster> sectionList = sectionMasterService.getSectionList(""+rmOfficeid);
		sectionMasterModel.addObject("sectionList", sectionList);
		sectionMasterModel.addObject("updateFlag","false");

		sectionMasterModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		sectionMasterModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		return sectionMasterModel;
	}

	@RequestMapping(value = "/saveSectionMaster", method = RequestMethod.POST)
	public ModelAndView saveSectionMaster(
			@ModelAttribute("sectionMasterDTO") SectionMasterDTO sectionMasterDTO,
			HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView saveSectionMasterModel = new ModelAndView(returnPage);
		PpSectionmaster ppSectionmaster = new PpSectionmaster();
		String sectionName = sectionMasterDTO.getSectionname();

		HttpSession session = request.getSession();

		saveSectionMasterModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		saveSectionMasterModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		boolean returnFlag = false;

		try {

			if (sectionName == null) {
				saveSectionMasterModel.addObject("msg_sectionMaster",
						"Section Master Cannot be empty");
				return saveSectionMasterModel;
			}

			BeanUtils.copyProperties(sectionMasterDTO, ppSectionmaster);
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			System.out.println(rmOfficeid);
			ppSectionmaster.setRmOfficeid("" + rmOfficeid);
			returnFlag = sectionMasterService.saveSectionMaster(ppSectionmaster);
			
			List<PpSectionmaster> sectionList = sectionMasterService.getSectionList(""+rmOfficeid);
			saveSectionMasterModel.addObject("sectionList", sectionList);

			if (returnFlag == false) {
				saveSectionMasterModel.addObject("msg_sectionMaster",
						"Some Error Occured");
				return saveSectionMasterModel;
			} else {
				saveSectionMasterModel.addObject("msg_sectionMaster",
						"Data Submitted Successfully");
				return saveSectionMasterModel;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return saveSectionMasterModel;
		}

	}
	
	@RequestMapping(value = "/populateSectionMaster", method = RequestMethod.GET)
	public ModelAndView populateSectionMaster(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView populateSectionModal = new ModelAndView(returnPage);	
		String ppSectionMasterID = request.getParameter("ppSectionMasterID");
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		
		try {
			session.setAttribute("sectionID", ppSectionMasterID);
			
			String sectionName = sectionMasterService.populateSectionMaster(ppSectionMasterID);
			
			List<PpSectionmaster> sectionList = sectionMasterService.getSectionList(""+rmOfficeid);
			populateSectionModal.addObject("sectionList", sectionList);
			
			populateSectionModal.addObject("sectionname",sectionName);
			populateSectionModal.addObject("updateURL","updateSectionMaster");
			populateSectionModal.addObject("updateFlag","true");
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		populateSectionModal.addObject("employee_name", (String) session.getAttribute("employeename"));
		populateSectionModal.addObject("designation_", (String) session.getAttribute("designation"));
		
		return populateSectionModal;
		
	}
	
	@RequestMapping(value = "/updateSectionMaster", method = RequestMethod.POST)
	public ModelAndView updateSectionMaster(@ModelAttribute("sectionMasterDTO") SectionMasterDTO sectionMasterDTO,
			HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView updateSectionModel = new ModelAndView(returnPage);		
		PpSectionmaster ppSectionmaster = new PpSectionmaster();
		String sectionName = sectionMasterDTO.getSectionname();
		boolean returnFlag = false;
		
		HttpSession session = request.getSession();
		updateSectionModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		updateSectionModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		try {
			if (sectionName == null) {
				updateSectionModel.addObject("msg_sectionMaster",
						"Section Master Cannot be empty");
				return updateSectionModel;
			}

			BeanUtils.copyProperties(sectionMasterDTO, ppSectionmaster);
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			System.out.println(rmOfficeid);

			ppSectionmaster.setRmOfficeid("" + rmOfficeid);

			returnFlag = sectionMasterService.updateSectionMaster((String) session.getAttribute("sectionID"), ppSectionmaster);

			List<PpSectionmaster> sectionList = sectionMasterService.getSectionList(""+rmOfficeid);
			updateSectionModel.addObject("sectionList", sectionList);
			
			if (returnFlag == false) {
				updateSectionModel.addObject("msg_sectionMaster",
						"Some Error Occured");
				return updateSectionModel;
			} else {
				updateSectionModel.addObject("msg_sectionMaster",
						"Data Updated Successfully");
				return updateSectionModel;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return updateSectionModel;
		}
	}
	
	@RequestMapping(value = "/deleteSectionMaster", method = RequestMethod.GET)
	public ModelAndView deleteSectionMaster(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView deleteSectionModel = new ModelAndView(returnPage);
		boolean returnFlag = false;
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		List<PpSectionmaster> sectionList = sectionMasterService.getSectionList(""+rmOfficeid);
		
		String sectionID = request.getParameter("ppSectionMasterID");
		
		returnFlag = sectionMasterService.deleteSectionMaster(sectionID);
		
		deleteSectionModel.addObject("sectionList", sectionList);
		
		if(returnFlag == true){
			deleteSectionModel.addObject("msg_sectionMaster","Section Deleted Successfully");
			return deleteSectionModel;
		}else if(returnFlag == false){
			deleteSectionModel.addObject("msg_sectionMaster","Some Error Occured");
			return deleteSectionModel;
		}

		deleteSectionModel.addObject("employee_name", (String) session.getAttribute("employeename"));
		deleteSectionModel.addObject("designation_", (String) session.getAttribute("designation"));
		
		return deleteSectionModel;
	}

}
