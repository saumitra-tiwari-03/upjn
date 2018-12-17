package com.nic.upjn.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.spring.Service.PensionEmployeeVerificationService;
import com.nic.upjn.spring.dto.PensionEmployeeVerificationDTO;
import com.nic.upjn.spring.entity.MasDistrict;
import com.nic.upjn.spring.entity.MasOfficelevel;
import com.nic.upjn.spring.entity.PensionEmployeeVerificationEntity;
import com.nic.upjn.spring.entity.PpEmployeemaster;

@Controller
public class PensionEmployeeVerificationController {

	@Autowired
	PensionEmployeeVerificationService pensionEmployeeVerificationService;

	@SuppressWarnings("unchecked")
	@RequestMapping("/pensionEmployeeVerification")
	public ModelAndView begin(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView target = new ModelAndView("PensionEmployeeVerification");
		List<MasOfficelevel> officeLevel = null;
		List<MasDistrict> district = null;
		List<PensionEmployeeVerificationEntity> employeeList = null;

		try {
			officeLevel = (List<MasOfficelevel>) pensionEmployeeVerificationService
					.getList(null, "MasOfficelevel.findAll");
			System.out.println("Size of OfficeLevel " + officeLevel.size());

			district = (List<MasDistrict>) pensionEmployeeVerificationService
					.getList(null, "MasDistrict.findAll");
			System.out.println("Size of district " + district.size());

			employeeList = (List<PensionEmployeeVerificationEntity>) pensionEmployeeVerificationService
					.employeeList();
			System.out.println("Size of employeeLit : " + employeeList.size());

			target.addObject("employeeList", employeeList);
			target.addObject("officeLevel", officeLevel);
			target.addObject("district", district);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return target;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/selectEmployeeForPensionVerification")
	public ModelAndView selectEmployeeForPensionVerification(
			HttpServletRequest request, HttpServletResponse response,
			@RequestParam("employeecode") String employeecode) {

		System.out.println("employeecode : " + employeecode);
		List<MasOfficelevel> officeLevel = null;
		List<MasDistrict> district = null;
		List<PensionEmployeeVerificationEntity> employeeInfo = null;
		List<PensionEmployeeVerificationEntity> employeeList = null;
		PensionEmployeeVerificationDTO pensionEmployeeVerificationDTO = new PensionEmployeeVerificationDTO();
		ModelAndView target = new ModelAndView("PensionEmployeeVerification");
		try {
			officeLevel = (List<MasOfficelevel>) pensionEmployeeVerificationService
					.getList(null, "MasOfficelevel.findAll");
			System.out.println("Size of OfficeLevel " + officeLevel.size());

			district = (List<MasDistrict>) pensionEmployeeVerificationService
					.getList(null, "MasDistrict.findAll");
			System.out.println("Size of district " + district.size());

			employeeList = (List<PensionEmployeeVerificationEntity>) pensionEmployeeVerificationService
					.employeeList();
			System.out.println("Size of employeeLit : " + employeeList.size());

			employeeInfo = (List<PensionEmployeeVerificationEntity>) pensionEmployeeVerificationService
					.employeeInfo(employeecode);

			for (PensionEmployeeVerificationEntity pensionEmployeeVerificationEntity : employeeInfo) {
				BeanUtils.copyProperties(pensionEmployeeVerificationEntity,
						pensionEmployeeVerificationDTO);
				System.out.println("employeeCode in DTO : "
						+ pensionEmployeeVerificationDTO.getEmployeecode());
			}

			target.addObject("employeeCode",
					pensionEmployeeVerificationDTO.getEmployeecode());
			target.addObject("firstname",
					pensionEmployeeVerificationDTO.getFirstname());
			target.addObject("middlename",
					pensionEmployeeVerificationDTO.getMiddlename());
			target.addObject("lastname",
					pensionEmployeeVerificationDTO.getLastname());
			target.addObject("fathername",
					pensionEmployeeVerificationDTO.getFatherName());
			target.addObject("dateofbirth",
					pensionEmployeeVerificationDTO.getDateOfBirth());
			target.addObject("dateofjoining",
					pensionEmployeeVerificationDTO.getJoiningDate());
			target.addObject("dateofretirement",
					pensionEmployeeVerificationDTO.getDateOfRetirement());
			target.addObject("designation",
					pensionEmployeeVerificationDTO.getDesignation());
			target.addObject("employeeInfo", employeeInfo);
			target.addObject("employeeList", employeeList);
			target.addObject("officeLevel", officeLevel);
			target.addObject("district", district);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/insertPensionerDetails")
	public ModelAndView insertPensionerDetails(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("employeecode") String employeecode) {
	
		System.out.println("EmployeeCode is------------- : " + employeecode);

		ModelAndView target = new ModelAndView("PensionEmployeeVerification");
		PensionEmployeeVerificationDTO pensionEmployeeVerificationDTO = new PensionEmployeeVerificationDTO();
		List<PensionEmployeeVerificationEntity> employeeInfo = null;
		List<PensionEmployeeVerificationEntity> employeeList = null;
		List<MasOfficelevel> officeLevel = null;
		List<MasDistrict> district = null;
		boolean isComplete = false;
		try {

			employeeInfo = (List<PensionEmployeeVerificationEntity>) pensionEmployeeVerificationService
					.employeeInfo(employeecode);

			for (PensionEmployeeVerificationEntity pensionEmployeeVerificationEntity : employeeInfo) {
				BeanUtils.copyProperties(pensionEmployeeVerificationEntity,
						pensionEmployeeVerificationDTO);
				System.out.println("employeeCode in DTO : "
						+ pensionEmployeeVerificationDTO.getEmployeecode()+"-- pp_employeeMasterID in DTO :"+pensionEmployeeVerificationDTO.getPpEmployeemasterid());
			}
			
			List<PpEmployeemaster> empdetailmaster = (List<PpEmployeemaster>) pensionEmployeeVerificationService.getList(employeecode, "PpEmployeemaster.findByEmployeecode");			
			
			for (PpEmployeemaster ppEmployeemaster : empdetailmaster) {
				BeanUtils.copyProperties(ppEmployeemaster,
						pensionEmployeeVerificationDTO);
				System.out.println("employeeCode in DTO : "
						+ pensionEmployeeVerificationDTO.getEmployeecode()+"-- pp_employeeMasterID in DTO :"+pensionEmployeeVerificationDTO.getPpEmployeemasterid());
			}			
			isComplete = pensionEmployeeVerificationService
					.insertPensionerDetails(pensionEmployeeVerificationDTO);
			
			officeLevel = (List<MasOfficelevel>) pensionEmployeeVerificationService
					.getList(null, "MasOfficelevel.findAll");
			System.out.println("Size of OfficeLevel " + officeLevel.size());

			district = (List<MasDistrict>) pensionEmployeeVerificationService
					.getList(null, "MasDistrict.findAll");
			System.out.println("Size of district " + district.size());
			
			if(isComplete == true){
				System.out.println("Updation Successfull");
				target.addObject("msg", "Form Submitted Successfully");
			}else{
				System.out.println("Updation unsuccessfull");
				target.addObject("error", "Error in Submitting Form");
			}
			 
			System.out.println(isComplete);
			
			employeeList = (List<PensionEmployeeVerificationEntity>) pensionEmployeeVerificationService
					.employeeList();
			System.out.println("Size of employeeLit : " + employeeList.size());
			
			target.addObject("employeeList", employeeList);
			target.addObject("officeLevel", officeLevel);
			target.addObject("district", district);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return target;

	}

}
