package com.nic.upjn.spring.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.miscellaneous.CalenderUtils;
import com.nic.upjn.spring.Service.ReportManagerService;
import com.nic.upjn.spring.dto.OfficeSumReportDTO;

@Controller
public class OfficeSummaryRepController {

	List list;
	List gross;
	List netpay;
	List total_Ded;
    List itax;
    List gpf;
    List employee;
    List employer;
    List totalemp;
    List paidemp;
    String group;
    String type;
	
	@Autowired
	ReportManagerService reportManagerService;
	
@RequestMapping("/OfficeSummaryRepForm")
public ModelAndView OfficeSummaryRepForm(HttpServletRequest request, HttpServletResponse response){
	
	ModelAndView target =new ModelAndView("OfficeSummaryRepForm");
	
	try{
		
	List groupList = reportManagerService.getGroupList();
		
	target.addObject("groupList", groupList);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	HttpSession session = request.getSession();

	target.addObject("employee_name", (String) session.getAttribute("employeename"));
	target.addObject("designation_", (String) session.getAttribute("designation"));
	return target;
}

@RequestMapping("/OfficeSummaryRep")
public ModelAndView OfficeSummaryRep(@ModelAttribute("dto")OfficeSumReportDTO dto, HttpServletRequest request, HttpServletResponse response){
	
	ModelAndView target =new ModelAndView("OfficeSummaryRep");
	
	try{
		String group = dto.getGroup();
		String type = dto.getType();
		
		List months = CalenderUtils.populateMonth();

		List years = CalenderUtils.populateYear();

		target.addObject("months", months);
		target.addObject("years", years);
		target.addObject("group", group);
		target.addObject("type", type);
	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	HttpSession session = request.getSession();

	target.addObject("employee_name", (String) session.getAttribute("employeename"));
	target.addObject("designation_", (String) session.getAttribute("designation"));
	
	return target;
}

@RequestMapping("/OfficeSummaryReport")
public ModelAndView OfficeSummaryReport(@ModelAttribute("dto")OfficeSumReportDTO dto, HttpServletRequest request, HttpServletResponse response){
	
	ModelAndView target =new ModelAndView("OfficeSummaryReport");
	HttpSession session = request.getSession();
	Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
	
	try{
		 String msg = "";
		 List summaryList = null;
		 
		String group = dto.getGroup();
		String type = dto.getType();
		String month = dto.getMonth();
		String isArrear = dto.getIsArrear();
		String isBoth = dto.getIsBoth();
		String isLocked = dto.getIsLocked();
		String isUnlocked = dto.getIsUnlocked();
		String year = dto.getYear();
		
		if(isArrear!=null)
        {
            msg = "Employee Class Wise Suumary Report-SALARY FOR Partly/Unpaid Locked During";
        } else
        {
            msg = "Employee Class Wise Suumary Report-SALARY FOR";
        }
		
		target.addObject("msg", msg);
		target.addObject("isArrear", isArrear);
		
		String temp_monthName = CalenderUtils.getMonth(month);
		target.addObject("temp_monthName", temp_monthName);
		
		String username = (String) session.getAttribute("employeecode");
		System.out.println(username);
		
		target.addObject("username", username);
		
        if(username.equals("admin"))
        {
            System.out.println("hey admin how r u");
            
            summaryList = reportManagerService.getMonthlySummary(month, year, isArrear, isLocked, isBoth, group, type);
            gross = reportManagerService.getGross(month, year, isArrear, isLocked, isBoth, group);                   
            netpay = reportManagerService.getNetpay(month, year, isArrear, isLocked, isBoth, group);
            total_Ded = reportManagerService.getTotalDed(month, year, isArrear, isLocked, isBoth, group);
            itax = reportManagerService.getItax(month, year, isArrear, isLocked, isBoth, group);
            gpf = reportManagerService.getGpf(month, year, isArrear, isLocked, isBoth, group);
            employee = reportManagerService.getEmployee(month, year, isArrear, isLocked, isBoth, group);
            employer = reportManagerService.getEmployer(month, year, isArrear, isLocked, isBoth, group);
            totalemp = reportManagerService.getTotalEmp(month, year, isArrear, isLocked, isBoth, group);
            paidemp = reportManagerService.getPaidEmp(month, year, isArrear, isLocked, isBoth, group);
        }
		
        else
        {
            String headoffice = username.substring(1, 10);
            System.out.println((new StringBuilder()).append("hey admin").append(headoffice).toString());
            if(headoffice.equals("000000000"))
            {
                summaryList = reportManagerService.getMonthlySummary(month, year, isArrear, isLocked, isBoth, group, type);
                System.out.println("i m in headoffece");
                System.out.println("i m in head office");
                gross = reportManagerService.getGross(month, year, isArrear, isLocked, isBoth, group);
                netpay = reportManagerService.getNetpay(month, year, isArrear, isLocked, isBoth, group);
                total_Ded = reportManagerService.getTotalDed(month, year, isArrear, isLocked, isBoth, group);
                itax = reportManagerService.getItax(month, year, isArrear, isLocked, isBoth, group);
                gpf = reportManagerService.getGpf(month, year, isArrear, isLocked, isBoth, group);
                employee = reportManagerService.getEmployee(month, year, isArrear, isLocked, isBoth, group);
                employer = reportManagerService.getEmployer(month, year, isArrear, isLocked, isBoth, group);
                totalemp = reportManagerService.getTotalEmp(month, year, isArrear, isLocked, isBoth, group);
                paidemp = reportManagerService.getPaidEmp(month, year, isArrear, isLocked, isBoth, group);
            } else
            {
                String zonecode = username.substring(3, 10);
                System.out.println((new StringBuilder()).append("zonecode..FFFF..").append(zonecode).toString());
                if(zonecode.equals("0000000"))
                {
                    String name = username.substring(1, 3);
                    String name1 = username.substring(2);
                    System.out.println((new StringBuilder()).append("ttt....").append(name).toString());
                    System.out.println("i m in zone office");
                    summaryList = reportManagerService.getMonthlySummary(month, year, isArrear, isLocked, isBoth, group, type);
                    System.out.println((new StringBuilder()).append("i m in zaonecode").append(name).toString());
                    gross = reportManagerService.getGross(month, year, isArrear, isLocked, isBoth, group);
                    netpay = reportManagerService.getNetpay(month, year, isArrear, isLocked, isBoth, group);
                    total_Ded = reportManagerService.getTotalDed(month, year, isArrear, isLocked, isBoth, group);
                    itax = reportManagerService.getItax(month, year, isArrear, isLocked, isBoth, group);
                    gpf = reportManagerService.getGpf(month, year, isArrear, isLocked, isBoth, group);
                    employee = reportManagerService.getEmployee(month, year, isArrear, isLocked, isBoth, group);
                    employer = reportManagerService.getEmployer(month, year, isArrear, isLocked, isBoth, group);
                    totalemp = reportManagerService.getTotalEmp(month, year, isArrear, isLocked, isBoth, group);
                    paidemp = reportManagerService.getPaidEmp(month, year, isArrear, isLocked, isBoth, group);
                } else
                {
                    String circle = username.substring(5, 10);
                    System.out.println((new StringBuilder()).append("circle..FFFF..").append(circle).toString());
                    if(circle.equals("00000"))
                    {
                        String circleCode = username.substring(3, 5);
                        summaryList = reportManagerService.getMonthlySummary(month, year, isArrear, isLocked, isBoth, group, type);
                        System.out.println((new StringBuilder()).append("i m in circleCode").append(circleCode).toString());
                        gross = reportManagerService.getGross(month, year, isArrear, isLocked, isBoth, group);
                        netpay = reportManagerService.getNetpay(month, year, isArrear, isLocked, isBoth, group);
                        total_Ded = reportManagerService.getTotalDed(month, year, isArrear, isLocked, isBoth, group);
                        itax = reportManagerService.getItax(month, year, isArrear, isLocked, isBoth, group);
                        gpf = reportManagerService.getGpf(month, year, isArrear, isLocked, isBoth, group);
                        employee = reportManagerService.getEmployee(month, year, isArrear, isLocked, isBoth, group);
                        employer = reportManagerService.getEmployer(month, year, isArrear, isLocked, isBoth, group);
                        totalemp = reportManagerService.getTotalEmp(month, year, isArrear, isLocked, isBoth, group);
                        paidemp = reportManagerService.getPaidEmp(month, year, isArrear, isLocked, isBoth, group);
                        System.out.println((new StringBuilder()).append("i m in circle office").append(circleCode).toString());
                    }
                    System.out.println((new StringBuilder()).append("Size of List@@@@@%%%%%%%%%%%%%%%%^^^^^^^^^^!!!!!!!!!!!++++++++++======").append(summaryList.size()).toString());
                    System.out.println("nddddd..FFFF..");
                }
            }
        }
        
        request.setAttribute("type", type);
        System.out.println((new StringBuilder()).append("type in action class while setting:::::::::::::::::: ").append(type).toString());
        request.setAttribute("gross", gross);
        target.addObject("gross", gross);
        
        System.out.println((new StringBuilder()).append("Gross").append(gross).toString());
        request.setAttribute("itax", itax);
        target.addObject("itax", itax);
        
        request.setAttribute("employer", employer);
        target.addObject("employer", employer);
        
        request.setAttribute("gpf", gpf);
        target.addObject("gpf", gpf);
        
        request.setAttribute("employee", employee);
        target.addObject("employee", employee);
        
        request.setAttribute("totalemp", totalemp);
        target.addObject("totalemp", totalemp);
        
        request.setAttribute("paidemp", paidemp);
        target.addObject("paidemp", paidemp);
        
        request.setAttribute("netpay", netpay);
        target.addObject("netpay", netpay);
        
        request.setAttribute("total_Ded", total_Ded);
        target.addObject("total_Ded", total_Ded);
        
        System.out.println((new StringBuilder()).append("total_Ded").append(total_Ded).toString());
        request.setAttribute("monthName", temp_monthName);
        target.addObject("monthName", temp_monthName);
        
       
        request.setAttribute("yearName", year);
        target.addObject("yearName", year);
        
        request.setAttribute("summaryList", summaryList);
        target.addObject("summaryList", summaryList);
        
       /* Iterator itr = summaryList.iterator();
        System.out.println("Iterator:::::::::::::::::::::");*/
      /*  OfficeSummaryReportEntity dto1;
        for(; itr.hasNext();
        		//System.out.println((new StringBuilder()).append(dto1.getPAYYEAR()).append(" ").append(dto1.getEmploymentsubtype()).append("  ").append(dto1.getGROSS()).append(" ").append(dto1.getSTATUS()).toString())
        		)
        {
            dto1 = (OfficeSummaryReportEntity)itr.next();
            System.out.println("iterator k andr:::::::::::::::::::");
        }*/
		
	}
	catch(Exception e){
		e.printStackTrace();
	}

	target.addObject("employee_name", (String) session.getAttribute("employeename"));
	target.addObject("designation_", (String) session.getAttribute("designation"));
	
	return target;
}
}
