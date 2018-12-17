/******************************** CONTROLLER CLASS FOR CHANGING OF PASSWORDS **************************/

/* ==========================================================================
 * Description 	: This class implements controller operations for changing of Passwords.
 * Date			: 04/03/2016  
 * Author		: VIKAS SINGH
 * Review By 	: 
 * Review Date	:  
 *==========================================================================
 */

/**This is a controller class used for Changing Passwords. Controller class get's the request from JSP pages,
 *  based on the requirement , methods of service class are called  and finally response is send to the JSP pages.
 * **/

/** Package Name **/
package com.nic.upjn.spring.controller;

/**********************************LIBRARIES USED ********************************/
/** BeanUtils class copy the similar property of Bean class to another class  **/

/**AUTOWIRED Annotation 	: Used for creating the object of class without using new keyword 
 Controller Annotation 		: Used to make controller class of any defined simple class . This class is capable to initiate request and response between JSP and Controller 
 ModelAttribute Annotation 	: It automatically sets the values from JSP to DTO class.Variable name must be same in both JSP and DTO
 RequestMapping annotation 	: Used for mapping URL to the method of controller class  
 RequestMethod annotation 	: Used for identifying type of request generated from JSP  
 SessionStatus class 		: Represents current status of the Session 
 ModelAndView class			: It is Responsible for setting views and objects required by JSP Pages 
 RoleManagementService Interface : It contains all abstract methods used for services related to Change Password.
 ChangePasswordDTO class 	: Contains the getter and setter of JSP variables 

 /** Imports required number of classes that are used in this particular class **/

import java.math.BigInteger;
import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.spring.Service.RoleManagementService;
import com.nic.upjn.spring.dto.ChangePasswordDTO;

@Controller
public class ChangePasswordController{

	@Autowired
	private RoleManagementService roleManagementService;
	

	/** by default method **/
	@RequestMapping("/changepassword")
	public ModelAndView changepassword(
			@ModelAttribute("changePasswordDTO") ChangePasswordDTO changePasswordDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("ChangePassword");
		HttpSession session = request.getSession();

		try {

			
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			String ppEmployeemasterid = (String) session
					.getAttribute("ppEmployeemasterid");

			System.out.println(ppEmployeemasterid);
			System.out.println(rmOfficeid + "-- rmofficeid");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;

	}

	/** This method is used to Change the Password of Users **/
	@RequestMapping("/newpassword")
	public ModelAndView newpassword(
			@ModelAttribute("changePasswordDTO") ChangePasswordDTO changePasswordDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("ChangePassword");
		boolean isValid = false;
		boolean isComplete = false;
		String newpassword = "";
		String error="";
		HttpSession session = request.getSession();
		
		
		if (changePasswordDTO.getNewpassword().equals("")) {
			error = "\n"+ error + "\n" + "Password Field can not be empty.";
		}
		String password = changePasswordDTO.getNewpassword();
		String confirmPassword = changePasswordDTO.getConfirmpassword();
		if (!password.equals(confirmPassword)) {
			error = "\n"+ error + "\n"
					+ "Confirm password not matched with password.";
		}
		if (changePasswordDTO.getNewpassword().toString().length() < 4) {
			error = "\n"+error + "Min length of password should be 4.";
		}
		
       if(error.equals(""))
       {

		try {

			
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			String ppEmployeemasterid = (String) session
					.getAttribute("ppEmployeemasterid");

			System.out.println(ppEmployeemasterid);
			System.out.println(rmOfficeid + "-- rmofficeid");

			String currentpassword = changePasswordDTO.getCurrentpassword();

			isValid = roleManagementService.getOldPassword(ppEmployeemasterid,
					currentpassword);

			if (isValid) {
				newpassword = changePasswordDTO.getNewpassword();

				System.out.println(newpassword);

				isComplete = changePassword(ppEmployeemasterid, newpassword);

				if (isComplete = true) {
					System.out.println("Password changed succesfully");

					target.addObject("msg", "Password changed succesfully");
				} else {
					target.addObject("msg", "Error");
					System.out.println("Error");
				}
			}
			else
			{
				target.addObject("msg", "current Password is not Valid");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
       }
       else
       {
    	   target.addObject("msg", "Current Password and Password should have to same");
       }
       
   	target.addObject("employee_name", (String) session.getAttribute("employeename"));
	target.addObject("designation_", (String) session.getAttribute("designation"));
		return target;

	}

	/** This method is used for encryption of Passwords by using Message Digest 5 (MD5) **/
	public static String md5(String input) {
		String md5 = null;
		if (null == input) {
			return null;
		}
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(input.getBytes(), 0, input.length());
			md5 = (new BigInteger(1, digest.digest())).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5;
	}

	/** This method is called internally by 'NEW PASSWORD' method of this Controller **/
	public boolean changePassword(String ppEmployeemasterid, String newpassword) {

		boolean iscomplete = false;

		iscomplete = roleManagementService.changepassword(ppEmployeemasterid,
				newpassword);

		return iscomplete;
	}
}
