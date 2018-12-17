/******************************** LOGIN CONTROLLER CLASS **************************/
 /* ==========================================================================
 * Description 	: This class implements controller operations for Login.
 * Date			: 18/01/2016  
 * Author		: RAM PRAKASH PANDEY
 * Review By 	: 
 * Review Date	:  
 *==========================================================================
 */



/** This is a controller class used for user validation. Controller class get's the request from JSP pages,
 *  based on the requirement , methods of service class are called and finally response is send to the JSP pages.  
**/ 


/** Package name **/
package com.nic.upjn.spring.controller;


/**********************************LIBRARIES USED ********************************/
/** The BeanUtil class copy the properties of Bean class to another class  **/

/**AUTOWIRED Annotation 	 : Used for creating the object of class without using new keyword 
   Controller Annotation 	 : Used to make controller class of any defined simple class . This class is capable to initiate request and response between JSP and Controller 
   ModelAttribute Annotation : It automatically sets the values from JSP to DTO class.Variable name must be same in both JSP and DTO
   RequestMapping annotation : Used for mapping URL to the method of controller class  
   RequestMethod annotation  : Used for identifying type of request generated from JSP  
   SessionStatus class 		 : Represents current status of the Session 
   ModelAndView class		 : It is Responsible for setting views and objects required by JSP Pages 
   LoginService Interface	 : It contains all abstract methods used for services related to login 
   UserDTO class			 : Contains the getter and setter of JSP variables 
   ADMIN entity 			 : It is a reflected object of ADMIN table automatically created by HIBERNATE tool **/


/** Imports required number of classes that are used in this particular class **/
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.spring.Service.EmployeeAppointmentService;
import com.nic.upjn.spring.Service.LoginService;
import com.nic.upjn.spring.Service.LoginServiceImple;
import com.nic.upjn.spring.dto.UserDTO;
import com.nic.upjn.spring.entity.MasDistrict;
import com.nic.upjn.spring.entity.MasOfficelevel;
                                                                   
/** This is a Controller Class for Login **/ 

@Controller
public class Logincontroller {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private EmployeeAppointmentService employeeAppointmentService;
	
	HashMap<Integer, String> officelevel = new HashMap<Integer, String>();
	HashMap<Integer, String> districtlist = new HashMap<Integer, String>();

	/** This method returns Index page for User Login **/
	@RequestMapping("/")
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}
	
	
	/** This method is used to call method of manager class for User Authentication **/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/login", method = RequestMethod.POST)  
	public ModelAndView loginValidator(@ModelAttribute("command")UserDTO userDTO, BindingResult result, Model m,HttpServletRequest request,HttpServletResponse response) 
	{
		HttpSession session = request.getSession();
		
	    boolean isValid = false;
		ModelAndView model = null;
		HashMap<String, String> hm = null;
		String treeItems ="";
		boolean bool = formValidate(userDTO);
	
		
		//modelAndView.addObject("treeItems", treeItems.toString());
    
		if(result.hasErrors())
		{
			 model = new ModelAndView("index");
			 model.addObject("errors", result.getAllErrors());
		}
		
		else
		{
			try {  
				
				if(bool==true)
				{
					isValid = loginService.userAuthentication(userDTO.getEmployeecode(),userDTO.getPassword(), request, response); 
				}
				else
				{
					model.addObject("invalid_user", "Invalid User !");	
				}
	
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
			if(isValid)
			{
				    session.setAttribute("ppEmployeemasterid", LoginServiceImple.hm.get("ppEmployeemasterid").toString());
				    
					
					
					
					
				    if(LoginServiceImple.hm.get("ppEmployeemasterid").toString().equals("0")||LoginServiceImple.hm.get("ppEmployeemasterid").toString().equals("1")||LoginServiceImple.hm.get("ppEmployeemasterid").toString().equals("2"))
				    {
				    	 treeItems = treeItems+loginService.getLinksForTree(LoginServiceImple.hm.get("ppEmployeemasterid").toString());
				    	 session.setAttribute("abc",treeItems);
				    	 
				    	 /*Office Level and District List for Office Selection Page*/
				    	 
				    	 List<MasOfficelevel> list = (List<MasOfficelevel>) employeeAppointmentService.getList(null,
									"MasOfficelevel.findAll");

							for (MasOfficelevel masOfficelevel : list) {
								officelevel.put(masOfficelevel.getMasOfficelevelid(), masOfficelevel.getOfficelevel());
							}
							

							List<MasDistrict> list1 = (List<MasDistrict>) employeeAppointmentService.getList(null,
									"MasDistrict.findAll");
							for (MasDistrict masDistrict : list1) {
								districtlist.put(masDistrict.getMasDistrictid(), masDistrict.getDistrictname());
							}
							
				    	 /*---------*/
				    	 
				    	model = new ModelAndView("OfficeSelection");
				    	if(LoginServiceImple.hm.get("ppEmployeemasterid").toString().equals("0"))
				    	{
				    		model.addObject("mes", "ADMIN "+LoginServiceImple.hm.get("ppEmployeemasterid"));
				    	}
				    	else if(LoginServiceImple.hm.get("ppEmployeemasterid").toString().equals("1"))
				    	{
				    		model.addObject("mes", "SBADM"+LoginServiceImple.hm.get("ppEmployeemasterid"));
				    	}
				    	else
				    	{
				    		model.addObject("mes", "CEZONE36 login"+LoginServiceImple.hm.get("ppEmployeemasterid"));
				    	}
				    	model.addObject("Data", officelevel);
				    	model.addObject("Data1", districtlist);
						
				    }
				    else
				    {
				    	treeItems =treeItems+ loginService.getLinksForTree(LoginServiceImple.hm.get("ppEmployeemasterid").toString());
				    	session.setAttribute("abc",treeItems);
				    	model = new ModelAndView("userPage");
//						
						model.addObject("ppEmployeemasterid", LoginServiceImple.hm.get("ppEmployeemasterid"));
						model.addObject("rm_OfficeID", LoginServiceImple.hm.get("rm_OfficeID"));

						String employeename = (String) session.getAttribute("employeename");
						String designation = (String) session.getAttribute("designation");
						model.addObject("employee_name", employeename);
						model.addObject("designation_", designation);
						model.addObject("userID", userDTO.getEmployeecode());
						
						ModelAndView login_details = new ModelAndView("Header");
						/*login_details.addObject("employee_name", employeename);
						login_details.addObject("designation_", designation);*/
						
						login_details.addObject("employee_name", (String) session.getAttribute("employeename"));
						login_details.addObject("designation_", (String) session.getAttribute("designation"));
						
						login_details.addObject("ppEmployeemasterid", (String) session.getAttribute("ppEmployeemasterid"));
						login_details.addObject("rm_OfficeID",(String) session.getAttribute("rm_OfficeID"));
						
						//request.setAttribute("item", treeItems);	
				    }
					
			      
			}
			else
			{
				model = new ModelAndView("index");
				model.addObject("invalid_user", "Invalid User !");	
			}
			return model;
			
		}
					

 /** This method is used to Validate the UserID and Password **/
	
	private boolean formValidate(UserDTO userDTO) {
		boolean bool=false;
		
		if(userDTO.getEmployeecode()!=null && userDTO.getEmployeecode().length()<=15 && userDTO.getEmployeecode().length()>=5 && userDTO.getPassword()!=null && userDTO.getPassword() != "")
		{
			bool = true;			
		}
	 
	    System.out.println("Value of Bool in Controller form validate method ==== "+bool );
	    
		return bool;
	}
	
	/** This method is used to call method of manager class for User Authentication **/
	@RequestMapping("/logout")  
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response,HttpSession session) 
	{
		 ModelAndView modelAndView = new ModelAndView("index");
		 
		 session.invalidate();
		 modelAndView.addObject("mes", "Logged out Successfully");
		  
	
		return modelAndView;
		
	}
	
}