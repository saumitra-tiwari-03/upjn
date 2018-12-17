package com.nic.upjn.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.spring.Service.QualificationTrainingMasterService;
import com.nic.upjn.spring.dto.QualificationTrainingMasterDTO;
import com.nic.upjn.spring.entity.PpQualificationmaster;
import com.nic.upjn.spring.entity.PpTrainingtypemaster;

@Controller
public class QualificationTrainingMasterController {

	@Autowired
	QualificationTrainingMasterService service;

	List list = null;
	List info = null;
	boolean result = false;

	/**********************************
	 * By Default method - Called on click by menu
	 *******************************************/

	@RequestMapping("/QualificationTrainingMaster")
	public ModelAndView begin(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("QualificationTrainingMaster");
		String selectedtype = "Training";
		try {
			list = service.getList(null, "PpTrainingtypemaster.findAll");
			target.addObject("list", list);
			target.addObject("selectedtype", selectedtype);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}

	/**********************************
	 * To insert new Qualification or Training
	 *******************************************/

	@RequestMapping("/insertQualificationTrainingMaster")
	public ModelAndView insertQualificationTrainingMaster(@ModelAttribute("dto") QualificationTrainingMasterDTO dto, HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("QualificationTrainingMaster");
		int insert = 0;

		try {
			String selectedtype = dto.getCategory();

			if (selectedtype.equals("Qualification")) {

				PpQualificationmaster ppQualificationmaster = new PpQualificationmaster();
				ppQualificationmaster.setQualification(dto.getName());

				insert = service.AddQualification(ppQualificationmaster);

				if (insert == 1) {
					target.addObject("msg", "Qualification Added Successfully");
				} else {
					target.addObject("msg", "Error in adding Qualification");
				}
				list = service.getList(null, "PpQualificationmaster.findAll");
			} else {
				PpTrainingtypemaster ppTrainingtypemaster = new PpTrainingtypemaster();
				insert = service.AddTraining(ppTrainingtypemaster);

				if (insert == 1) {
					target.addObject("msg", "Training Added Successfully");
				} else {
					target.addObject("msg", "Error in adding Training");
				}
				list = service.getList(null, "PpTrainingtypemaster.findAll");
			}

			target.addObject("list", list);
			target.addObject("selectedtype", selectedtype);
			System.out.println(list.size() + "----Size of list of Qualification and training");
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}

	/****************************************
	 * Populate Qualification Form -Details
	 *****************************************************/

	@RequestMapping("/populateQualification")
	public ModelAndView populateQualification(@ModelAttribute("dto") QualificationTrainingMasterDTO dto,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("QualificationTrainingMaster");

		try {
			String ppQualificationmasterid = request.getParameter("ppQualificationmasterid");
			info = service.getList(ppQualificationmasterid, "PpQualificationmaster.findByPpQualificationmasterid");

			list = service.getList(null, "PpQualificationmaster.findAll");

			String selectedtype = "Qualification";

			target.addObject("list", list);
			target.addObject("selectedtype", selectedtype);
			target.addObject("info", info);

		} catch (Exception e) {
			e.printStackTrace();
			target.addObject("msg", "Error");
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}

	/****************************************
	 * Populate Training Form -Details
	 *****************************************************/

	@RequestMapping("/populateTraining")
	public ModelAndView populateTraining(@ModelAttribute("dto") QualificationTrainingMasterDTO dto,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("QualificationTrainingMaster");

		try {
			String ppTrainingtypemasterid = request.getParameter("ppTrainingtypemasterid");
			info = service.getList(ppTrainingtypemasterid, "PpTrainingtypemaster.findByPpTrainingtypemasterid");

			list = service.getList(null, "PpTrainingtypemaster.findAll");

			String selectedtype = "Training";

			target.addObject("list", list);
			target.addObject("selectedtype", selectedtype);
			target.addObject("info", info);
		} catch (Exception e) {
			e.printStackTrace();
			target.addObject("msg", "Error");
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}

	/*************************************************
	 * Edit Qualification Training Master
	 **********************************************************/

	@RequestMapping("/editQualificationTrainingMaster")
	public ModelAndView editheadquarter(@ModelAttribute("dto") QualificationTrainingMasterDTO dto,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("QualificationTrainingMaster");
		int insert = 0;
		try {
			String selectedtype = dto.getSelectedtype();

			if (selectedtype.equals("Qualification")) {
				PpQualificationmaster ppQualificationmaster = new PpQualificationmaster();
				ppQualificationmaster.setPpQualificationmasterid(dto.getMasterid());
				ppQualificationmaster.setQualification(dto.getName());
				
				insert = service.editQualification(ppQualificationmaster);
				if(insert == 1){
				target.addObject("msg", "Record Updated Successfully");
				}
				else{
				target.addObject("msg", "Error in editing Qualification");
				}
				
				list = service.getList(null, "PpQualificationmaster.findAll");		
				
			} else {
				PpTrainingtypemaster ppTrainingtypemaster = new PpTrainingtypemaster();
				ppTrainingtypemaster.setTrainingtype(dto.getName());
				ppTrainingtypemaster.setPpTrainingtypemasterid(dto.getMasterid());
				
				insert = service.editTraining(ppTrainingtypemaster);
				if(insert == 1){
					target.addObject("msg", "Record Updated Successfully");
					}
					else{
					target.addObject("msg", "Error in editing Training");
					}
				
				list = service.getList(null, "PpTrainingtypemaster.findAll");
			}
			
			target.addObject("list", list);
			target.addObject("selectedtype", selectedtype);
			
		} catch (Exception e) {
			e.printStackTrace();
			target.addObject("msg", "Error");
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}

	/**********************************
	 * Delete Qualification
	 *******************************************/

	@RequestMapping("/deleteQualification")
	public ModelAndView deleteQualification(@ModelAttribute("dto") QualificationTrainingMasterDTO dto,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("QualificationTrainingMaster");
		String selectedtype = "Qualification";
		try {		
			
			String ppQualificationmasterid = request.getParameter("ppQualificationmasterid");
			 result = service.deleteQualification(ppQualificationmasterid);
			 
			 if(result == true){
           	  target.addObject("msg", "Qualification Deleted");
             }else{
           	  target.addObject("msg", "Error in deleting Qualification");
             }
			
			list = service.getList(null, "PpQualificationmaster.findAll");
			target.addObject("list", list);
			target.addObject("selectedtype", selectedtype);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}	
	
	/**********************************
	 * Delete Training
	 *******************************************/

	@RequestMapping("/deleteTraining")
	public ModelAndView deleteTraining(@ModelAttribute("dto") QualificationTrainingMasterDTO dto,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("QualificationTrainingMaster");
		String selectedtype = "Training";
		try {			
			String ppTrainingtypemasterid = request.getParameter("ppTrainingtypemasterid");
			result = service.deleteTraining(ppTrainingtypemasterid);
			
			 if(result == true){
	           	  target.addObject("msg", "Training Type Deleted");
	             }else{
	           	  target.addObject("msg", "Error in deleting Training Type");
	             }
			
			list = service.getList(null, "PpTrainingtypemaster.findAll");
			target.addObject("list", list);
			target.addObject("selectedtype", selectedtype);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}		
	
}
