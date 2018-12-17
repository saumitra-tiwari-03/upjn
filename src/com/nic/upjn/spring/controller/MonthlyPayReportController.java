package com.nic.upjn.spring.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.miscellaneous.CalenderUtils;
import com.nic.upjn.spring.Service.ReportManagerService;
import com.nic.upjn.spring.dto.MonthlyPayReportDTO;
import com.nic.upjn.spring.entity.PpPaybilldetail;
import com.nic.upjn.spring.entity.PpRegistermaster;
import com.nic.upjn.spring.entity.ViewHeadName;
import com.nic.upjn.spring.entity.ViewHeadNpsName;
import com.nic.upjn.spring.entity.ViewMonthlyPayReport;

@Controller
public class MonthlyPayReportController {

	@Autowired
	ReportManagerService reportManagerService;

	/** by default method **/
	@SuppressWarnings({ "rawtypes", "unused" , "unchecked"})
	@RequestMapping("/MonthlyPayReport")
	public ModelAndView MonthlyPayReport(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("MonthlyPay");

		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");

			List<PpRegistermaster> registerlist = (List<PpRegistermaster>) reportManagerService.getList(null,
					"PpRegistermaster.findAll");

			List months = CalenderUtils.populateMonth();

			List years = CalenderUtils.populateYear();

			System.out.println(years.size() + "--" + months.size() + "--" + registerlist.size());

			target.addObject("registerlist", registerlist);
			target.addObject("months", months);
			target.addObject("years", years);
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
	@RequestMapping("/searchMonPayReport")
	public ModelAndView searchMonPayReport(
			@ModelAttribute("monthlyPayReportDTO") MonthlyPayReportDTO monthlyPayReportDTO, HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView target = new ModelAndView("MonthlyPaySearch");
		String registername = "";
		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			String rmofficeid = rmOfficeid.toString();
			String month = monthlyPayReportDTO.getMonth()+"";
			String year = monthlyPayReportDTO.getYear()+"";
			String ppRegistermasterID = monthlyPayReportDTO.getPpRegistermasterid()+"";

			List<PpPaybilldetail> billdetail = (List<PpPaybilldetail>) reportManagerService.getbillDetail(rmofficeid,
					month, year, ppRegistermasterID, "PpPaybilldetail.findbyCriteria");

			System.out.println(billdetail.size());

			List<PpRegistermaster> registerdetail = (List<PpRegistermaster>) reportManagerService
					.getList(ppRegistermasterID, "PpRegistermaster.findByPpRegistermasterid");

			for (PpRegistermaster ppRegistermaster : registerdetail) {
				registername = ppRegistermaster.getRegistername();
			}

			System.out.println("-------");

			target.addObject("registername", registername);
			target.addObject("billdetail", billdetail);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;

	}

	@SuppressWarnings({ "unchecked", "unused" })
	@RequestMapping("/MonPayReport")
	public ModelAndView MonPayReport(@ModelAttribute("monthlyPayReportDTO") MonthlyPayReportDTO monthlyPayReportDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("MonthlyPayReport");
		String paybilldetailID = null;
		String registername = "";
		String billno = "";

		try {
			HttpSession session = request.getSession();
			Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
			String rmofficeid = rmOfficeid.toString();
			String month = monthlyPayReportDTO.getMonth()+"";
			String year = monthlyPayReportDTO.getYear()+"";
			String ppRegistermasterID = monthlyPayReportDTO.getPpRegistermasterid()+"";
			String ppPaybilldetailid = monthlyPayReportDTO.getPpPaybilldetailid()+"";
			List<MonthlyPayReportDTO> list = new ArrayList<MonthlyPayReportDTO>();
			List<MonthlyPayReportDTO> list1 = new ArrayList<MonthlyPayReportDTO>();

			List<ViewMonthlyPayReport> monthlypayreport = (List<ViewMonthlyPayReport>) reportManagerService
					.getmonthlypayreport(rmofficeid, month, year, ppPaybilldetailid, ppRegistermasterID);
			target.addObject("monthlypayreport", monthlypayreport);
			
			for(ViewMonthlyPayReport viewMonthlyPayReport : monthlypayreport)
			{
				MonthlyPayReportDTO monthlyPayReportDTO2 = new MonthlyPayReportDTO();
				BeanUtils.copyProperties(viewMonthlyPayReport, monthlyPayReportDTO2);
				list.add(monthlyPayReportDTO2);
				request.setAttribute("monthlyPayList", list);
				 request.setAttribute("monthlyPayListSize", Integer.toString(list.size()));
			}
			
			this.prepareReportData(list,target,request);

			List<PpPaybilldetail> billdetail = (List<PpPaybilldetail>) reportManagerService.getbillDetail(rmofficeid,
					month, year, ppRegistermasterID, "PpPaybilldetail.findbyCriteria");
			for(PpPaybilldetail paybilldetail : billdetail){
				billno = paybilldetail.getBillno();
			}
			target.addObject("billdetail", billdetail);
			System.out.println(billdetail.size());
			
			List<PpRegistermaster> registerdetail = (List<PpRegistermaster>) reportManagerService
					.getList(ppRegistermasterID, "PpRegistermaster.findByPpRegistermasterid");

			target.addObject("registerdetail", registerdetail);
			for (PpRegistermaster ppRegistermaster : registerdetail){
				registername = ppRegistermaster.getRegistername();
				System.out.println(registername);
				target.addObject("registername", registername);
				request.setAttribute("register", registername);
			}

			List<ViewHeadName> headNameList = (List<ViewHeadName>)reportManagerService.headName();	
			for(ViewHeadName viewHeadName : headNameList)
			{
				MonthlyPayReportDTO monthlyPayReportDTO3 = new MonthlyPayReportDTO();
				BeanUtils.copyProperties(viewHeadName, monthlyPayReportDTO3);
				list1.add(monthlyPayReportDTO3);
				
				
			}
			request.setAttribute("headNameList12", list1);
			System.out.println(headNameList.size()+"----"+list1.size());
			target.addObject("headNameList", headNameList);
		//	request.setAttribute("headNameList", headNameList);
			System.out.println("HeadList size in controller--"+headNameList.size());
			

			List<ViewHeadNpsName> headNpsNameList = (List<ViewHeadNpsName>)reportManagerService.headNpsName();
			System.out.println(headNpsNameList.size());
			target.addObject("headNpsNameList", headNpsNameList);
			request.setAttribute("headNpsNameList", headNpsNameList);
			
			target.addObject("month", month);
			request.setAttribute("monthName", month);
			
			target.addObject("year", year);	
			request.setAttribute("yearName", year);
			
			target.addObject("rmofficeid", rmofficeid);
			request.setAttribute("rm_OfficeID", rmofficeid);
			
			/*******************/

		
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target;

	}
	
	
	 @SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private void prepareReportData(java.util.List monthlyPayList, ModelAndView target,HttpServletRequest request) {
	        ListIterator listIterator = monthlyPayList.listIterator();
	        String prevEmployee = "";
	        ArrayList employeeList = new ArrayList();
	        ArrayList employeeNameList = new ArrayList();
	        ArrayList empNameList = new ArrayList();
	        ArrayList employeeDesignationList = new ArrayList();
	        ArrayList employeeValueList = new ArrayList();
	        ArrayList employeeinstallmentList = new ArrayList();
	        ConcurrentMap employeeNameMap = new ConcurrentHashMap();
	        ConcurrentMap employeeGPFAcNoMap = new ConcurrentHashMap();
	        ConcurrentMap employeeDesignationMap = new ConcurrentHashMap();
	        ConcurrentMap employeeValueMap = new ConcurrentHashMap();
	        ConcurrentMap payCategoryMap = new ConcurrentHashMap();
	        ConcurrentMap bankAcNoMap = new ConcurrentHashMap();
	        ConcurrentMap installmentMap = new ConcurrentHashMap();
	        ConcurrentMap pannoMap = new ConcurrentHashMap();
	        ConcurrentMap noOfDaysMap= new ConcurrentHashMap();
	                
	        try {
	            String employeeCode;
	            String headType;
	            String headName;
	            String installment;
	            String panno;
	            String noOfDays;
	            for (; listIterator.hasNext(); installmentMap.put((new StringBuilder()).append(employeeCode).append("@").append(headType).append("@").append(headName).toString(), installment)) {
	                MonthlyPayReportDTO dto = (MonthlyPayReportDTO) listIterator.next();
	                employeeCode = dto.getEmployeeCode();
	                String employeeName = dto.getEmpName();
	                String gPFACNO = dto.getGpfAcNo();
	                String payCategory = dto.getPayCategory();
	                String accountNo = dto.getBankAccNo();
	                String designationEmp = dto.getDesignation();
	                String headId = dto.getHeadID()+"";
	                headType = dto.getHeadType();
	                String amount = dto.getAmount()+"";
	                headName = dto.getHeadName();
	                installment = dto.getInstallment();
	                panno = dto.getPanno();
	                noOfDays=dto.getNoOfDays()+"";
	                if (installment == null || installment.trim().equalsIgnoreCase("null")) {
	                    installment = "";
	                }
	                if (!prevEmployee.equals(employeeCode)) {
	                    employeeList.add(employeeCode);
	                    prevEmployee = employeeCode;
	                    empNameList.add(employeeName);
	                    employeeDesignationMap.put(employeeCode, designationEmp);
	                    employeeNameMap.put(employeeCode, employeeName);
	                    payCategoryMap.put(employeeCode, payCategory);
	                    employeeGPFAcNoMap.put(employeeCode, gPFACNO == null || gPFACNO.trim().length() <= 0 ? "--NA--" : ((Object) (gPFACNO)));
	                    bankAcNoMap.put(employeeCode, accountNo == null || accountNo.trim().length() <= 0 ? "--NA--" : ((Object) (accountNo)));
	                    pannoMap.put(employeeCode, panno == null || panno.trim().length() <= 0 ? "--NA--" : ((Object) (panno)));
	                    noOfDaysMap.put(employeeCode, noOfDays);
	                }
	                employeeValueMap.put((new StringBuilder()).append(employeeCode).append("@").append(headType).append("@").append(headName).toString(), amount);
	            }

	            employeeNameList.add(employeeNameMap);
	            employeeinstallmentList.add(installmentMap);
	            employeeDesignationList.add(employeeDesignationMap);
	            employeeValueList.add(employeeValueMap);
	            Collections.sort(employeeList);
	            Collections.sort(empNameList);
	            
	            target.addObject("employeeValueList", employeeValueList);   
		        request.setAttribute("employeeValueList", employeeValueList);
		        System.out.println("employeeValueList size----------->"+employeeValueList.size());
		        
		        target.addObject("employeeinstallmentList", employeeinstallmentList);   
		        request.setAttribute("employeeinstallmentList", employeeinstallmentList);
		        System.out.println("employeeinstallmentList size----------->"+employeeinstallmentList.size());
	            
	            target.addObject("employeeList", employeeList);
	            System.out.println(employeeList.size()+"--Size of Emp List");
	            target.addObject("empNameList", empNameList);
	            target.addObject("employeeNameMap", employeeNameMap);
	            
	           request.setAttribute("employeeList", employeeList);
	           System.out.println("employeeList size----------->"+employeeList.size());
	            
	            target.addObject("employeeGPFAcNoMap", employeeGPFAcNoMap);
	            target.addObject("payCategoryMap", payCategoryMap);
	            target.addObject("bankAcNoMap", bankAcNoMap);
	            target.addObject("employeeValueMap", employeeValueMap);
	            request.setAttribute("employeeValueMap", employeeValueMap);
	            
	            target.addObject("installmentMap", installmentMap);
	            request.setAttribute("installmentMap", installmentMap);
	            
	            target.addObject("employeeDesignationMap", employeeDesignationMap);
	            target.addObject("pannoMap", pannoMap);
	            target.addObject("noOfDaysMap", noOfDaysMap);
	        } catch (Exception e) {
	            System.out.println((new StringBuilder()).append("error inside prepare data for report method of action ").append(e).toString());
	        }
	    }

}
