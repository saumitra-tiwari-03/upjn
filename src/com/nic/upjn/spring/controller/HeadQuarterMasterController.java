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
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.spring.Service.HeadQuarterMasterService;
import com.nic.upjn.spring.dto.HeadQuarterMasterDTO;
import com.nic.upjn.spring.entity.PpPlacemaster;

@Controller
public class HeadQuarterMasterController {

	@Autowired
	HeadQuarterMasterService service;

	
	List districtlist = null;
	List towncategorylist = null;
	List placemasterlist = null;
	boolean isExistanceError = false;
	
	/********************************** By Default method - Called on click by menu *******************************************/
	
	@RequestMapping("/HeadQuarterMaster")
	public ModelAndView begin(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("HeadQuartermaster");

		try {
			   districtlist = service.getList(null,"MasDistrict.findAll");			   
			   towncategorylist = service.getList(null, "PpTowncategorymaster.findAll");			   
			   placemasterlist = service.getList(null, "PlacemasterView.findAll");
			   
			   List placeinfo = null;
			   target.addObject("placeinfo",placeinfo );
			   
			   System.out.println(districtlist.size()+"-----------"+towncategorylist.size()+"-----------"+placemasterlist.size());
			   
			   target.addObject("districtlist",districtlist );
			   target.addObject("towncategorylist", towncategorylist);
			   target.addObject("placemaster", placemasterlist);	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		 target.addObject("employee_name", (String) session.getAttribute("employeename"));
		 target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;
	}
	
/************************************************ Insert New Head Quarter  *****************************************************/
	
	@RequestMapping("/insertHeadQuarter")
	public ModelAndView insertHeadQuarter(@ModelAttribute("dto")HeadQuarterMasterDTO dto, HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("HeadQuartermaster");

		try {
			
          // Check existance of Place   
			   isExistanceError = this.checkexistance(dto);	
               
          //insert data to database if there is no existance error occured
   			if(!isExistanceError){
   				
   				PpPlacemaster placemaster = new PpPlacemaster();
   				
   			//Copying actionform values to DTO
   				BeanUtils.copyProperties(dto, placemaster);
   				
   				int insert = service.AddPlace(placemaster);

   					target.addObject("msg", "headQuarter Created Successfully");
	
   			}		
   			districtlist = service.getList(null,"MasDistrict.findAll");			   
			   towncategorylist = service.getList(null, "PpTowncategorymaster.findAll");			   
			   placemasterlist = service.getList(null, "PlacemasterView.findAll");
			   
			 List placeinfo= null;
			target.addObject("placeinfo",placeinfo );
			   
			   target.addObject("districtlist",districtlist );
			   target.addObject("towncategorylist", towncategorylist);
			   target.addObject("placemaster", placemasterlist);		
			  
		} 
		catch (Exception e) {
			e.printStackTrace();
			target.addObject("msg", "Error");
		}
		
		HttpSession session = request.getSession();

		 target.addObject("employee_name", (String) session.getAttribute("employeename"));
		 target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}
	
/****************************************Edit Head Quarter Form -Details *****************************************************/
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/populatePlace")
	public ModelAndView populatePlace(@ModelAttribute("dto")HeadQuarterMasterDTO dto,  HttpServletRequest request, HttpServletResponse response ) {

		ModelAndView target = new ModelAndView("HeadQuartermaster");

		try {
                String ppPlacemasterid = request.getParameter("ppPlacemasterid");
                
                 List placeinfo = service.getList(ppPlacemasterid, "PpPlacemaster.findByPpPlacemasterid");
                
                //PpPlacemaster ppPlacemaster = service.getPlaceInfo(ppPlacemasterid);
			
   				   districtlist = service.getList(null,"MasDistrict.findAll");			   
   				   towncategorylist = service.getList(null, "PpTowncategorymaster.findAll");			   
   				   placemasterlist = service.getList(null, "PlacemasterView.findAll");
   				   
   				
   				   
   				   target.addObject("districtlist",districtlist );
   				   target.addObject("towncategorylist", towncategorylist);
   				   target.addObject("placemaster", placemasterlist);	
   				target.addObject("placeinfo",placeinfo );
			  
		} 
		catch (Exception e) {
			e.printStackTrace();
			target.addObject("msg", "Error");
		}
		
		HttpSession session = request.getSession();

		 target.addObject("employee_name", (String) session.getAttribute("employeename"));
		 target.addObject("designation_", (String) session.getAttribute("designation"));
		 
		return target;
	}	
	
/*************************************************Edit Head Quarter **********************************************************/	
	
	@SuppressWarnings("unused")
	@RequestMapping("/editheadquarter")
	public ModelAndView editheadquarter(@ModelAttribute("dto")HeadQuarterMasterDTO dto,  HttpServletRequest request, HttpServletResponse response ) {

		ModelAndView target = new ModelAndView("HeadQuartermaster");

		try {
                String ppPlacemasterid = request.getParameter("ppPlacemasterid");
                
                // Check existance of Place   
 			   isExistanceError = this.checkexistance(dto);	
 			   
 			  //insert data to database if there is no existance error occured
 	   			if(!isExistanceError){
 	   				
 	   				PpPlacemaster placemaster = new PpPlacemaster();
 	   				
 	   			//Copying actionform values to DTO
 	   				BeanUtils.copyProperties(dto, placemaster);
 	   				
 	   				int insert = service.editPlace(placemaster);

 	   					target.addObject("msg", "Success");
 		
 	   			}	
                
   				   districtlist = service.getList(null,"MasDistrict.findAll");			   
   				   towncategorylist = service.getList(null, "PpTowncategorymaster.findAll");			   
   				   placemasterlist = service.getList(null, "PlacemasterView.findAll");
   				   
   				   target.addObject("districtlist",districtlist );
   				   target.addObject("towncategorylist", towncategorylist);
   				   target.addObject("placemaster", placemasterlist);					
			  
		} 
		catch (Exception e) {
			e.printStackTrace();
			target.addObject("msg", "Error");
		}
		
		HttpSession session = request.getSession();

		 target.addObject("employee_name", (String) session.getAttribute("employeename"));
		 target.addObject("designation_", (String) session.getAttribute("designation"));
		 
		return target;
	}	
	
/********************************************** Delete Head Quarter **********************************************************/
	
	@RequestMapping("/deleteHeadQuarter")
	public ModelAndView deleteHeadQuarter(@ModelAttribute("dto")HeadQuarterMasterDTO dto,  HttpServletRequest request, HttpServletResponse response ) {

		ModelAndView target = new ModelAndView("HeadQuartermaster");

		try {
                String ppPlacemasterid = request.getParameter("ppPlacemasterid");
                
                 boolean result = service.deleteHeadQuarter(ppPlacemasterid);
                 
                  if(result == true){
                	  target.addObject("msg", "Head Quarter Deleted");
                  }else{
                	  target.addObject("msg", "Error");
                  }
			
   				   districtlist = service.getList(null,"MasDistrict.findAll");			   
   				   towncategorylist = service.getList(null, "PpTowncategorymaster.findAll");			   
   				   placemasterlist = service.getList(null, "PlacemasterView.findAll");
   				   
   				   target.addObject("districtlist",districtlist );
   				   target.addObject("towncategorylist", towncategorylist);
   				   target.addObject("placemaster", placemasterlist);					
			  
		} 
		catch (Exception e) {
			e.printStackTrace();
			target.addObject("msg", "Error");
		}
		
		HttpSession session = request.getSession();

		 target.addObject("employee_name", (String) session.getAttribute("employeename"));
		 target.addObject("designation_", (String) session.getAttribute("designation"));
		 
		return target;
	}	

/************************************************ Check Existence of HeadQuarter  *****************************************************/	

	private boolean checkexistance(HeadQuarterMasterDTO dto) {
		boolean isPlaceNameExist=false;
	
	try{
		  isPlaceNameExist = service.checkExistanceOfPlaceName(dto);
		  
		  if(isPlaceNameExist){
			  isExistanceError=true;
			}
		  
		
	}catch(Exception e){
	   e.printStackTrace();
	}
	
	return isExistanceError;
}
	
}
