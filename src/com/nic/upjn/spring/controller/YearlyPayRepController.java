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

import com.nic.upjn.spring.Service.ReportManagerService;
import com.nic.upjn.spring.dto.YearlyPayRepDTO;

@Controller
public class YearlyPayRepController {
	
	@Autowired
	ReportManagerService reportManagerService;
	
	@RequestMapping("/YearlyPayReportForm")	 
	public ModelAndView YearlyPayReportForm(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView target = new ModelAndView("YearlyPayReportForm");
		
		try{
			List<?> financeYearList = reportManagerService.getList(null,"SysFinanceyear.findAll");
			
			target.addObject("financeYearList", financeYearList);
		
		}

		catch (Exception e) {
			e.printStackTrace();
		
		}
		
		HttpSession session = request.getSession();
		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));
		
		return target; 
	}

	
@SuppressWarnings({"rawtypes" })
@RequestMapping("/YearlyPayReport")
public ModelAndView YearlyPayReport(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("yearlyPayRepDTO")YearlyPayRepDTO yearlyPayRepDTO){
	
	ModelAndView target = new ModelAndView("YearlyPayReport");
	List headNameList = null;
	
	try{
		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");  
		
		String empcode = yearlyPayRepDTO.getEmpcode();
        String year = yearlyPayRepDTO.getFinanceYear();
        
        String yearrange[] = year.split("-");
        String startYear = yearrange[0];
        String endYear = yearrange[1];
        
       List list = reportManagerService.getMonthlyPayReport(rmOfficeid, yearrange[0], yearrange[1], empcode);
       target.addObject("list", list);
       request.setAttribute("list", list);
       
       List locCodeList = null;
       locCodeList = reportManagerService.getLocCode(rmOfficeid, startYear, endYear, empcode);
       
       System.out.println("List Size for location code is-----"+locCodeList.size());
       if(locCodeList.size()>0)
       {
    	   target.addObject("locCodeList", locCodeList); 
    	   request.setAttribute("locCodeList", locCodeList);
       }
       headNameList = reportManagerService.headName(yearrange[0], yearrange[1], empcode);
       target.addObject("headNameList", headNameList);
       request.setAttribute("headNameList", headNameList);
       
       target.addObject("startYear", startYear);
       target.addObject("endYear", endYear);
       
       request.setAttribute("headNameListSize", Integer.toString(headNameList.size()));
       
       reportManagerService.prepareReportData(list, request,target);
       
       target.addObject("empcode", empcode);
       
       List b_pay = reportManagerService.getTotalBpay(yearrange[0], yearrange[1], empcode);
       target.addObject("b_pay", b_pay);
       request.setAttribute("b_pay", b_pay);
       
       List SPL_PAY = reportManagerService.getTotalSPLPAY(yearrange[0], yearrange[1], empcode);
       if(SPL_PAY != null)
       {
    	   target.addObject("SPL_PAY", SPL_PAY);
       }
       
       List PERS_PAY = reportManagerService.getTotalPERSPAY(yearrange[0], yearrange[1], empcode);
       if(PERS_PAY != null)
       {
    	   target.addObject("PERS_PAY", PERS_PAY);
       }
       
       List G_PAY = reportManagerService.getTotalGPAY(yearrange[0], yearrange[1], empcode);
       if(G_PAY != null)
       {
    	   target.addObject("G_PAY", G_PAY);
       }
       
       List D_PAY = reportManagerService.getTotalDPAY(yearrange[0], yearrange[1], empcode);
       target.addObject("D_PAY", D_PAY);
       
       List PG_ALL = reportManagerService.getTotalPGALL(yearrange[0], yearrange[1], empcode);
       target.addObject("PG_ALL", PG_ALL);
       
       List BLGCMPT = reportManagerService.getTotalBLGCMPT(yearrange[0], yearrange[1], empcode);
       target.addObject("BLGCMPT", BLGCMPT);
       
       List DEPU_PAY = reportManagerService.getTotalDEPU_PAY(yearrange[0], yearrange[1], empcode);
       target.addObject("DEPU_PAY", DEPU_PAY);
       
       List DA = reportManagerService.getTotalDA(yearrange[0], yearrange[1], empcode);
       target.addObject("DA", DA);
       
       List CCA = reportManagerService.getTotalCCA(yearrange[0], yearrange[1], empcode);
       target.addObject("CCA", CCA);
       
       List HRA = reportManagerService.getTotalGHRA(yearrange[0], yearrange[1], empcode);
       target.addObject("HRA", HRA);
       
       List MEDALW = reportManagerService.getTotalMEDALW(yearrange[0], yearrange[1], empcode);
       target.addObject("MEDALW", MEDALW);
       
       List WS_ALW = reportManagerService.getTotalWS_ALW(yearrange[0], yearrange[1], empcode);
       target.addObject("WS_ALW", WS_ALW);
       
       List OTH_ALW = reportManagerService.getTotalOTH_ALW(yearrange[0], yearrange[1], empcode);
       target.addObject("OTH_ALW", OTH_ALW);
       
       List GPF = reportManagerService.getTotalGPF(yearrange[0], yearrange[1], empcode);
       target.addObject("GPF", GPF);
       
       List GIS = reportManagerService.getTotalGIS(yearrange[0], yearrange[1], empcode);
       target.addObject("GIS", GIS);
       
       List HS_RENT = reportManagerService.getTotalHS_RENT(yearrange[0], yearrange[1], empcode);
       target.addObject("HS_RENT", HS_RENT);
       
       List ITAX = reportManagerService.getTotalITAX(yearrange[0], yearrange[1], empcode);
       target.addObject("ITAX", ITAX);
       
       List SOC_DED = reportManagerService.getTotalSOC_DED(yearrange[0], yearrange[1], empcode);
       target.addObject("SOC_DED", SOC_DED);
       
       List CLTH_DED = reportManagerService.getTotalCLTH_DED(yearrange[0], yearrange[1], empcode);
       target.addObject("CLTH_DED", CLTH_DED);
       
       List LIP = reportManagerService.getTotalLIP(yearrange[0], yearrange[1], empcode);
       target.addObject("LIP", LIP);
       
       List KKD_DED = reportManagerService.getTotalKKD_DED(yearrange[0], yearrange[1], empcode);
       target.addObject("KKD_DED", KKD_DED);
       
       List MISC_DED = reportManagerService.getTotalMISC_DED(yearrange[0], yearrange[1], empcode);
       target.addObject("MISC_DED", MISC_DED);
       
       List REG_EMP = reportManagerService.getTotalREG_EMP(yearrange[0], yearrange[1], empcode);
       target.addObject("REG_EMP", REG_EMP);
       
       List MOP_ADV = reportManagerService.getTotalMOP_ADV(yearrange[0], yearrange[1], empcode);
       target.addObject("MOP_ADV", MOP_ADV);
       
       List HSREPADV = reportManagerService.getTotalHSREPADV(yearrange[0], yearrange[1], empcode);
       target.addObject("HSREPADV", HSREPADV);
       
       List HBA = reportManagerService.getTotalHBA(yearrange[0], yearrange[1], empcode);
       target.addObject("HBA", HBA);
       
       List SCTR_ADV = reportManagerService.getTotalSCTR_ADV(yearrange[0], yearrange[1], empcode);
       target.addObject("SCTR_ADV", SCTR_ADV);
       
       List GPF_ADV = reportManagerService.getTotalGPF_ADV(yearrange[0], yearrange[1], empcode);
       target.addObject("GPF_ADV", GPF_ADV);
       
       List CYCADV = reportManagerService.getTotalCYCADV(yearrange[0], yearrange[1], empcode);
       target.addObject("CYCADV", CYCADV);
       
       List CARADV = reportManagerService.getTotalCARADV(yearrange[0], yearrange[1], empcode);
       target.addObject("CARADV", CARADV);
       
       List gross = reportManagerService.getGross(yearrange[0], yearrange[1], empcode);
       target.addObject("gross", gross);
       
       List totalded = reportManagerService.getTotalDed(yearrange[0], yearrange[1], empcode);
       target.addObject("totalded", totalded);
       
       List NetPay = reportManagerService.getNetPay(yearrange[0], yearrange[1], empcode);
       target.addObject("NetPay", NetPay);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	HttpSession session = request.getSession();
	target.addObject("employee_name", (String) session.getAttribute("employeename"));
	target.addObject("designation_", (String) session.getAttribute("designation"));
	
	
	return target; 
  }

}
