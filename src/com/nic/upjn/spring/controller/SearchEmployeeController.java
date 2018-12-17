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

import com.nic.upjn.spring.Service.ServiceBookService;
import com.nic.upjn.spring.dto.EmployeeStatusDTO;
import com.nic.upjn.spring.entity.MasEmploymentsubtype;
import com.nic.upjn.spring.entity.PpDesignationmaster;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;
import com.nic.upjn.spring.entity.ViewPpWholeemplist;

@Controller
public class SearchEmployeeController {

	@Autowired
	private ServiceBookService serviceBookService;

	@RequestMapping("/SearchEmployeeDetails")
	public ModelAndView SearchEmployeeDetails(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView target = new ModelAndView("SearchEmployeeDetails");

		try {

			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			System.out.println(rmOfficeid + "-- rmofficeid");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;

	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/searchEmployee")
	public ModelAndView searchEmployee(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView target = new ModelAndView("SearchEmployeeES");

		try {
			List<PpDesignationmaster> list = null;
			List<MasEmploymentsubtype> list1 = null;

			Class<?> ref = Class
					.forName("com.nic.upjn.spring.dto.EmployeeStatusDTO");
			EmployeeStatusDTO employeeStatusDTO = (EmployeeStatusDTO) ref
					.newInstance();

			list1 = (List<MasEmploymentsubtype>) serviceBookService.getList(
					null, "MasEmploymentsubtype.findAll");
			for (MasEmploymentsubtype MasEmploymentsubtype : list1) {
				BeanUtils.copyProperties(MasEmploymentsubtype,
						employeeStatusDTO);
			}

			list = (List<PpDesignationmaster>) serviceBookService.getList(null,
					"PpDesignationmaster.findAll");
			for (PpDesignationmaster PpDesignationmaster : list) {
				BeanUtils
						.copyProperties(PpDesignationmaster, employeeStatusDTO);
			}

			target.addObject("designationlist", list);
			target.addObject("categorylist", list1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/EmployeeSearchList")
	public ModelAndView EmployeeSearchList(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("employeeStatusDTO") EmployeeStatusDTO employeeStatusDTO) {

		ModelAndView target = new ModelAndView("EmployeeSearchList");

		String SQL;
		List<ViewPpWholeemplist> list = null;
		/*
		 * HttpSession session = request.getSession(); Integer rmOfficeid =
		 * (Integer) session.getAttribute("rmOfficeid");
		 */

		try {
			/*
			 * String ppDesignationmasterid = "" +
			 * employeeStatusDTO.getPpDesignationmasterid(); String
			 * masEmploymentsubtypeid = "" +
			 * employeeStatusDTO.getMasEmploymentsubtypeid();
			 */
			String fathername = employeeStatusDTO.getFathername();
			String dateofbirth = employeeStatusDTO.getDateofbirth();
			String employeecode = "" + employeeStatusDTO.getEmployeecode();

			target.addObject("employeecode", employeecode);

			String employeename = employeeStatusDTO.getEmployeename();

			if (employeecode.equals("") && employeename.equals("")
					&& fathername.equals("") && dateofbirth.equals("")) {

				list = (List<ViewPpWholeemplist>) serviceBookService.getList(
						null, "ViewPpWholeemplist.findAll");
				System.out.println(list.size()
						+ " -- I am size of list of all employees");
				target.addObject("list", list);
			}

			else {

				employeeStatusDTO.setEmployeecode(employeecode);
				employeeStatusDTO.setEmployeename(employeename);

				employeeStatusDTO.setFathername(fathername);
				employeeStatusDTO.setDateofbirth(dateofbirth);
				String predicate = " ISFUNCTIONING = '1'";
				SQL = serviceBookService.createSearchSQL_ES(predicate,
						employeeStatusDTO);
				list = (List<ViewPpWholeemplist>) serviceBookService
						.suspensionEmployeeSearchList_ES(SQL);
			}
			System.out.println(list.size()
					+ " -- I am size of list of all employees");
			target.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;
	}

	@RequestMapping("/searchEmployeePayroll")
	public ModelAndView searchEmployeePayroll(@ModelAttribute("employeeStatusDTO") EmployeeStatusDTO employeeStatusDTO,HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("searchEmployeePayroll");
		
		if (employeeStatusDTO.getEmployeecode() != null) {
			modelAndView.addObject("employeecode1", employeeStatusDTO.getEmployeecode());
		}
		
		HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		
		return modelAndView;

	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/searchEmployeePayRollList")
	public ModelAndView searchEmployeePayRoll(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView target = new ModelAndView("searchPayroll");

		try {
			List<PpDesignationmaster> list = null;
			List<MasEmploymentsubtype> list1 = null;

			Class<?> ref = Class
					.forName("com.nic.upjn.spring.dto.EmployeeStatusDTO");
			EmployeeStatusDTO employeeStatusDTO = (EmployeeStatusDTO) ref
					.newInstance();

			list1 = (List<MasEmploymentsubtype>) serviceBookService.getList(
					null, "MasEmploymentsubtype.findAll");
			for (MasEmploymentsubtype MasEmploymentsubtype : list1) {
				BeanUtils.copyProperties(MasEmploymentsubtype,
						employeeStatusDTO);
			}

			list = (List<PpDesignationmaster>) serviceBookService.getList(null,
					"PpDesignationmaster.findAll");
			for (PpDesignationmaster PpDesignationmaster : list) {
				BeanUtils
						.copyProperties(PpDesignationmaster, employeeStatusDTO);
			}

			target.addObject("designationlist", list);
			target.addObject("categorylist", list1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/searchPayrollList")
	public ModelAndView searchPayrollList(
			@ModelAttribute("employeeStatusDTO") EmployeeStatusDTO employeeStatusDTO,
			HttpServletRequest request, HttpServletResponse response) {
		String SQL;
		ModelAndView target = new ModelAndView("PayRollSearchList");
		List<ViewEmployeeSearch> list = null;
		String ppDesignationmasterid = ""
				+ employeeStatusDTO.getPpDesignationmasterid();
		String masEmploymentsubtypeid = ""
				+ employeeStatusDTO.getMasEmploymentsubtypeid();
		String employeecode = "" + employeeStatusDTO.getEmployeecode();
		String firstname = employeeStatusDTO.getFirstname();
		String lastname = employeeStatusDTO.getLastname();
		if (employeecode.equals("") && firstname.equals("")
				&& lastname.equals("") && masEmploymentsubtypeid.equals("-1")
				&& ppDesignationmasterid.equals("-1")) {

			list = (List<ViewEmployeeSearch>) serviceBookService.getList(null,
					"ViewEmployeeSearch.findAll");

		}

		else {

			employeeStatusDTO.setEmployeecode(employeecode);
			employeeStatusDTO.setFirstname(firstname);
			employeeStatusDTO.setLastname(lastname);
			employeeStatusDTO.setMasEmploymentsubtypeid(masEmploymentsubtypeid);
			employeeStatusDTO.setPpDesignationmasterid(Integer
					.parseInt(ppDesignationmasterid));
			String predicate = " ISFUNCTIONING = '1'";
			SQL = serviceBookService.createSearchSQL(predicate,
					employeeStatusDTO);
			list = (List<ViewEmployeeSearch>) serviceBookService
					.suspensionEmployeeSearchList(SQL);
		}

		target.addObject("list", list);
		target.addObject("employeecode1", employeecode);
		
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;

	}

	@RequestMapping("/searchEmployeePayList")
	public ModelAndView searchEmployeePayList(
			@ModelAttribute("employeeStatusDTO") EmployeeStatusDTO employeeStatusDTO,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("searchEmployeePayroll");
	
		
		List <?> resultlist=null;
        try{
            resultlist=serviceBookService.getEmployeeInformation(employeeStatusDTO.getEmployeecode());
            modelAndView.addObject("resultlist", resultlist);
            modelAndView.addObject("employeecode1", employeeStatusDTO.getEmployeecode());
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;
	}
	
	
	@RequestMapping("/payRollAllEmpInfo")
	public ModelAndView payRollAllEmpInfo(
			@ModelAttribute("employeeStatusDTO") EmployeeStatusDTO employeeStatusDTO,
			HttpServletRequest request, HttpServletResponse response) {
		
		String employeecode = request.getParameter("employeeCode");
		ModelAndView modelAndView = new ModelAndView("searchEmployeePayroll");
	
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		List <?> resultlist=null;
        try{
            resultlist=serviceBookService.getWholeOfficeListing(rmOfficeid+"");
            modelAndView.addObject("resultlist", resultlist);
            modelAndView.addObject("employeecode1", employeecode);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
        
		return modelAndView;
				
		
	}
	
	

}
