package com.nic.upjn.spring.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.spring.dao.ReportManagerDAO;
import com.nic.upjn.spring.dto.PaySlipReportDTO;
import com.nic.upjn.spring.entity.PaySlipEntity;
import com.nic.upjn.spring.entity.PaySlipHeadEntity;
import com.nic.upjn.spring.entity.PpPaybilldetail;
import com.nic.upjn.spring.entity.PpRegistermaster;
import com.nic.upjn.spring.entity.RmOffice;
import com.nic.upjn.spring.entity.SysPaymentmode;
import com.nic.upjn.spring.entity.ViewChecklist;
import com.nic.upjn.spring.entity.ViewHeadName;
import com.nic.upjn.spring.entity.ViewHeadNpsName;
import com.nic.upjn.spring.entity.ViewMonthlyPayReport;
import com.nic.upjn.spring.entity.ViewPayGetscheduleheadlist;
import com.nic.upjn.spring.entity.ViewYearlyPayReport;

import oracle.net.aso.s;


@Service("ReportManagerService")
public class ReportManagerServiceImple implements ReportManagerService {

	@Autowired 
	ReportManagerDAO reportManagerDAO;
	
	
	HashMap allowanceMap = null;
	HashMap deductionMap = null;
	HashMap netPayableMap = null;
	public static List allowanceList = null;
	public static List deductionList = null;
	public static List netPayableList = null;
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<?> getList(String wherecondition, String namedQuery) {
		
		List list = reportManagerDAO.getList(wherecondition, namedQuery);
		return list;
	}


	@Override
	public List<PpPaybilldetail> getbillDetail(String rmofficeid, String month, String year, String ppRegistermasterID,
			String namedQuery) {
		List list = reportManagerDAO.getbillDetail(rmofficeid,month,year, ppRegistermasterID,namedQuery);
		return list;
	}

	@Override
	public List getmonthlypayreport(String rmofficeid, String month, String year, String ppPaybilldetailid,
			String ppRegistermasterID) {
		List list = reportManagerDAO.getmonthlypayreport(rmofficeid,month,year,ppPaybilldetailid, ppRegistermasterID);
		return list;
	}

	@Override
	public List<PpPaybilldetail> getListpaybill(String wherecondition, String namedQuery) {
		List list = reportManagerDAO.getList(wherecondition, namedQuery);
		return list;
	}

	@Override
	public List headName() {
		List list = reportManagerDAO.headName();
		return list;
	}

	@Override
	public List headNpsName() {
		List list = reportManagerDAO.headNpsName();
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	@Override
	public List<Object> prepareReportData(List<ViewMonthlyPayReport> monthlypayreport) {
		
		List<Object> result = null;
		Iterator itr = monthlypayreport.iterator();
		String prevEmployee = "";
		Hashtable installmentMap = new Hashtable();
		ArrayList employeeList = new ArrayList();
		ArrayList employeeNameList = new ArrayList();	
		ArrayList employeeDesignationList = new ArrayList();
		ArrayList empNameList = new ArrayList();
		ArrayList employeeValueList = new ArrayList();
        ArrayList employeeinstallmentList = new ArrayList();
		Hashtable employeeDesignationMap = new Hashtable();
		Hashtable employeeNameMap = new Hashtable();
		Hashtable payCategoryMap = new Hashtable();
		Hashtable employeeGPFAcNoMap = new Hashtable();
		Hashtable bankAcNoMap = new Hashtable();
		Hashtable pannoMap = new Hashtable();
		Hashtable noOfDaysMap = new Hashtable();
		Hashtable employeeValueMap = new Hashtable();
		
		try{
			 String employeeCode;
	            String headType;
	            String headName;
	            String installment;
	            String panno;
	            String noOfDays;
			for (;itr.hasNext();installmentMap.put((new StringBuilder()).append(employeeCode).append("@").append(headType).append("@").append(headName).toString(), installment)){
				ViewMonthlyPayReport dto = (ViewMonthlyPayReport)itr.next();
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
		}

		catch(Exception e){
			e.printStackTrace();
		}
		
		result = new ArrayList<Object>();
		result.add(employeeValueMap);
		result.add(employeeList);
		result.add(empNameList);
		result.add(employeeNameMap);
		result.add(employeeGPFAcNoMap);
		result.add(payCategoryMap);
		result.add(bankAcNoMap);
		result.add(installmentMap);
		result.add(employeeDesignationMap);
		result.add(pannoMap);
		result.add(noOfDaysMap);
		
		return result;
	}

	@Override
	public List<ViewChecklist> getCheckList(Integer rmOfficeid, String month, String year) {
		List list = reportManagerDAO.getCheckList( rmOfficeid,  month,  year) ;
		return list;
	}

	@Override
	public String createPredicate(PaySlipReportDTO paySlipReportDTO) {
		String predicate = "";
		try{
			if(paySlipReportDTO.getPpRegistermasterid() != null && !paySlipReportDTO.getPpRegistermasterid().equals("-1"))
				predicate += " and pp_RegisterMasterID = '" + paySlipReportDTO.getPpRegistermasterid() + "' ";
			if(paySlipReportDTO.getEmpcode() != null && paySlipReportDTO.getEmpcode().trim().length() > 0)
				predicate += " and lower(EmployeeCode) like '" +  paySlipReportDTO.getEmpcode().trim().toLowerCase() + "%' ";
			if(paySlipReportDTO.getFirstname() != null && paySlipReportDTO.getFirstname().trim().length() > 0)
				predicate += " and lower(FirstName) like '" +  paySlipReportDTO.getFirstname().trim().toLowerCase() + "%' ";
			if(paySlipReportDTO.getLastname() != null && paySlipReportDTO.getLastname().trim().length() > 0)
				predicate += " and lower(LastName) like '" +  paySlipReportDTO.getLastname().toLowerCase() + "%'  ";
			if(paySlipReportDTO.getEmployeementcategory() != null && !paySlipReportDTO.getEmployeementcategory().equals("-1"))
				predicate += " and Mas_EmploymentSubTypeID = '" +  paySlipReportDTO.getEmployeementcategory() + "' ";
			if(paySlipReportDTO.getDesignation() != null && !paySlipReportDTO.getDesignation().equals("-1"))
				predicate += " and pp_DesignationMasterID = '" +  paySlipReportDTO.getDesignation() + "' ";
		}catch(Exception e){
			System.out.println("Exception Raised in " + e.toString());
		}
		return predicate;
	}

	@Override
	public List getEmployeeList(String sql) {
		List list = null;
		try{			
			list = reportManagerDAO.getEmployeeList(sql);
		}catch (Exception e){}
		return list;
	}

	@Override
	public List getBillDetailForMonthlyPayReport(String month, String year, Integer rmOfficeid,
			String ppRegistermasterid) {
		List list = null;
		try{
			list = reportManagerDAO.getBillDetailForMonthlyPayReport(month,year,rmOfficeid,ppRegistermasterid);
		}catch(Exception e){System.out.println("error inside getBillDetailForMonthlyPayReport method of MonthlyPayReportManager "+e);}
		return list;
	}

	@Override
	public List getPaySlipHeads() {
		List list = null;
        try{
            list = reportManagerDAO.getPaySlipReportHeads();
        }catch (Exception e){
            System.out.println("Exception in manager+getPaySlipHeads= " + e.toString());
            throw e;
        }
        return list;
	}

	@Override
	public List getPaySlipReport(Integer rmOfficeid, String pp_RegisterMasterID, String payMonth, String payYear,
			String employeeCode, String pp_PayBillDetailID) {
		List list = null;
        try{
            list = reportManagerDAO.getPaySlipReport(rmOfficeid, pp_RegisterMasterID, payMonth, payYear, employeeCode, pp_PayBillDetailID);
        }catch (Exception e){
            System.out.println("Exception in manager+getPaySlipReport= " + e.toString());
            throw e;
        }
        return list;
	}



	@Override
	public List getMonthlySummary(Integer rmOfficeid, String month, String year) {
		
		List checkList=null;
		try{
                    
			checkList=reportManagerDAO.getMonthlySummary(rmOfficeid,month,year);
		}catch(Exception e){
			System.out.println("error inside the getScheduleList of manager..."+e);
		}
		return checkList;
		
	}

	@Override
	public List getCompletedloanalertList(String monthName, String loan_type, String yearName, Integer rmOfficeid) {
		List checkList=null;
		try{
			checkList=reportManagerDAO.getCompletedloanalertList(monthName,loan_type, yearName, rmOfficeid);
		}catch(Exception e){
			System.out.println("error inside the getScheduleList of manager..."+e);
		}
		return checkList;
	}

	@Override
	public List getMonthlyPayReport(Integer rmOfficeid, String string, String string2, String empcode) {
		 List list = null;
	        try
	        {
	            list = reportManagerDAO.getMonthlyPayReport(rmOfficeid, string, string2, empcode);
	        }
	        catch(Exception e)
	        {
	            System.out.println((new StringBuilder()).append("Exception Raised in = ").append(e.toString()).toString());
	            throw e;
	        }
	        return list;
	}

	@Override
	public List getLocCode(Integer rmOfficeid, String startYear, String endYear, String empcode) {
		 List locCodeList = null;
	        try
	        {
	            locCodeList = reportManagerDAO.getLocCode(rmOfficeid, startYear, endYear, empcode);
	        }
	        catch(Exception e)
	        {
	            System.out.println((new StringBuilder()).append("Exception Raised in = ").append(e.toString()).toString());
	            throw e;
	        }
	        return locCodeList;
	}

	@Override
	public List headName(String StartYear, String EndYear, String empCode) {
		 List list = null;
	        try
	        {
	            list = reportManagerDAO.headName(StartYear, EndYear, empCode);
	        }
	        catch(Exception e)
	        {
	           e.printStackTrace();
	        }
	        return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void prepareReportData(List monthlyPayList, HttpServletRequest request, ModelAndView target ) {
		ListIterator listIterator = monthlyPayList.listIterator();
        String prevBill = "";
        ArrayList employeeList = new ArrayList();
        List pp_billdetailList = new ArrayList();
        ArrayList employeeNameList = new ArrayList();
        ArrayList employeeDesignationList = new ArrayList();
        ArrayList employeeValueList = new ArrayList();
        int count = 0;
        Hashtable employeeNameMap = new Hashtable();
        Hashtable employeeGPFAcNoMap = new Hashtable();
        Hashtable employeeDesignationMap = new Hashtable();
        Hashtable employeeValueMap = new Hashtable();
        Hashtable payCategoryMap = new Hashtable();
        Hashtable bankAcNoMap = new Hashtable();
        Hashtable paybillMap = new Hashtable();
        Hashtable payYearMap = new Hashtable();
        Hashtable payMonthMap = new Hashtable();
        try
        {
            String employeeCode;
            String pp_billdetail;
            String headType;
            String amount;
            String headName;
            for(; listIterator.hasNext(); System.out.println((new StringBuilder()).append("--------Values:  ").append(pp_billdetail).append("@").append(employeeCode).append("@").append(headType).append("@").append(headName).append("----------").append(amount).toString()))
            {
                ViewYearlyPayReport dto = (ViewYearlyPayReport)listIterator.next();
 	
                employeeCode = dto.getEMPLOYEECODE();
                String employeeName = dto.getEMPNAME();
                pp_billdetail = dto.getPP_PAYBILLDETAILID()+"";
                String gPFACNO = dto.getGPFACNO();
                String payCategory = dto.getPAYCATEGORY();
                String accountNo = dto.getBANKACCNO();
                String designationEmp = dto.getDESIGNATION();
                String headId = dto.getHEADID()+"";
                headType = dto.getHEADTYPE();
                amount = dto.getAMOUNT()+"";
                headName = dto.getHEADNAME();
                String installment = dto.getINSTALLMENT();
                String payYear = dto.getPAYYEAR()+"";
                String payMonth = dto.getPAYMONTH()+"";
                if(!prevBill.equals(pp_billdetail))
                {
                    employeeList.add(employeeCode);
                    prevBill = pp_billdetail;
                    pp_billdetailList.add(pp_billdetail);
                    employeeDesignationMap.put(employeeCode, designationEmp);
                    employeeNameMap.put(employeeCode, employeeName);
                    payCategoryMap.put(employeeCode, payCategory);
                    employeeGPFAcNoMap.put(employeeCode, gPFACNO != null && gPFACNO.trim().length() > 0 ? ((Object) (gPFACNO)) : "--NA--");
                    bankAcNoMap.put(employeeCode, accountNo != null && accountNo.trim().length() > 0 ? ((Object) (accountNo)) : "--NA--");
                    System.out.println((new StringBuilder()).append("==================").append(employeeCode).append("===========").append(employeeName).toString());
                    paybillMap.put(employeeCode, pp_billdetail);
                    payYearMap.put(pp_billdetail, payYear);
                    payMonthMap.put(pp_billdetail, payMonth);
                    System.out.println((new StringBuilder()).append("==================").append(payYear).append("===========").append(payMonth).toString());
                }
                employeeValueMap.put((new StringBuilder()).append(pp_billdetail).append("@").append(employeeCode).append("@").append(headType).append("@").append(headName).toString(), amount);
            }

            employeeNameList.add(employeeNameMap);
            employeeDesignationList.add(employeeDesignationMap);
            employeeValueList.add(employeeValueMap);
            Collections.sort(pp_billdetailList);
            request.setAttribute("employeeList", employeeList);
            target.addObject("employeeList", employeeList);
            
            request.setAttribute("pp_billdetailList", pp_billdetailList);
            target.addObject("pp_billdetailList", pp_billdetailList);
            
            request.setAttribute("employeeNameMap", employeeNameMap);
            target.addObject("employeeNameMap", employeeNameMap);
            
            request.setAttribute("employeeGPFAcNoMap", employeeGPFAcNoMap);
            target.addObject("employeeGPFAcNoMap", employeeGPFAcNoMap);
            
            request.setAttribute("payCategoryMap", payCategoryMap);
            target.addObject("payCategoryMap", payCategoryMap);
            
            request.setAttribute("bankAcNoMap", bankAcNoMap);
            target.addObject("bankAcNoMap", bankAcNoMap);
            
            request.setAttribute("employeeValueMap", employeeValueMap);
            target.addObject("employeeValueMap", employeeValueMap);
            
            request.setAttribute("employeeDesignationMap", employeeDesignationMap);
            target.addObject("employeeDesignationMap", employeeDesignationMap);
            
            request.setAttribute("paybillMap", paybillMap);
            target.addObject("paybillMap", paybillMap);
            
            request.setAttribute("payYearMap", payYearMap);
            target.addObject("payYearMap", payYearMap);
            
            request.setAttribute("payMonthMap", payMonthMap);
            target.addObject("payMonthMap", payMonthMap);
        }
        catch(Exception e)
        {
            System.out.println((new StringBuilder()).append("error inside prepare data for report method of action ").append(e).toString());
        }
    }

	@Override
	public List getTotalBpay(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalBpay(StartYear, EndYear, empcode);
        }
        
        catch(Exception e)
        {
            System.out.println((new StringBuilder()).append("Exception Raised here ").append(e.toString()).toString());
        }
        return list;
	}

	@Override
	public List getTotalSPLPAY(String StartYear, String EndYear, String empcode) {
		List list = null;
	        try
	        {
	            list = reportManagerDAO.getTotalSPLPAY(StartYear, EndYear, empcode);
	        }
	        catch(Exception e)
	        {
	            System.out.println((new StringBuilder()).append("Exception Raised here ").append(e.toString()).toString());
	        }
	        return list;
	}

	@Override
	public List getTotalPERSPAY(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalPERSPAY(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalGPAY(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalGPAY(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalDPAY(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalDPAY(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalPGALL(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalPGALL(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalBLGCMPT(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalBLGCMPT(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalDEPU_PAY(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalDEPU_PAY(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalDA(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalDA(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalCCA(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalCCA(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalGHRA(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalGHRA(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalMEDALW(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalMEDALW(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalWS_ALW(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalWS_ALW(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalOTH_ALW(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalOTH_ALW(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalGPF(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalGPF(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalGIS(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalGIS(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalHS_RENT(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalHS_RENT(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalITAX(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalITAX(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalSOC_DED(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalSOC_DED(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalCLTH_DED(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalCLTH_DED(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalLIP(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalLIP(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalKKD_DED(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalKKD_DED(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalMISC_DED(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalMISC_DED(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalREG_EMP(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalREG_EMP(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalMOP_ADV(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalMOP_ADV(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalHSREPADV(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalHSREPADV(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalHBA(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalHBA(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalSCTR_ADV(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalSCTR_ADV(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalGPF_ADV(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalGPF_ADV(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalCYCADV(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalCYCADV(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalCARADV(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalCARADV(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getGross(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getGross(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getTotalDed(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getTotalDed(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public List getNetPay(String StartYear, String EndYear, String empcode) {
		List list = null;
        try
        {
            list = reportManagerDAO.getNetPay(StartYear, EndYear, empcode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public String prepareDataForReport(List reportList, List reportHeadList, Integer rmOfficeid,
			String register, String empCode) {
		
		ListIterator reportListIterator = reportList.listIterator();
		
		String pdfFileName = "";
		
		DecimalFormat formatter = new DecimalFormat("##,##0.00");
		
		String prevEmployee = "";
		String employeeCode = null;
        String empName = null;
        String designation = null;
        String pp_MonthlyPayID = null;
        String noOfDays = null;
        String payMonth = null;
        String payYear = null;
        String headID = null;
        String headType = null;
        String headName = null;
        String amount = null;
        String pp_RegisterMasterID = null;
		String bankACCNo = null;
		String gpfACNo = null;
		String paymentMode = null;
		String payCategory = null;
		String installment = null;
		 
		allowanceList = new ArrayList();
        deductionList = new ArrayList();
        netPayableList = new ArrayList();
        
        double totalAllowances = 0;
        double totalDeductions = 0;
        double netPayable = 0;
        
        HashMap	employeeInfoMap = new HashMap();
        HashMap employeeDataMap = new HashMap();
        
        ArrayList employeeCodeList = new ArrayList();
        
        try{
        
        while(reportListIterator.hasNext()){
           PaySlipEntity dto = (PaySlipEntity)reportListIterator.next();
            //tempDto = new PaySlipDTO();

            employeeCode = dto.getEmployeeCode();
            
            if(prevEmployee.trim().length() == 0)
				prevEmployee = employeeCode; 
            
            if(!prevEmployee.equals(employeeCode) && (prevEmployee.trim().length() > 0)){

				netPayable = totalAllowances-totalDeductions;

				//add in employeecode List
				employeeCodeList.add(prevEmployee);

				employeeInfoMap.put(prevEmployee + "@empName", empName);
				employeeInfoMap.put(prevEmployee + "@designation", designation);
				employeeInfoMap.put(prevEmployee + "@noOfDays", noOfDays);
				employeeInfoMap.put(prevEmployee + "@bankACCNo", bankACCNo);
				employeeInfoMap.put(prevEmployee + "@gpfACNo", gpfACNo);
				employeeInfoMap.put(prevEmployee + "@payCategory", payCategory);
				employeeInfoMap.put(prevEmployee + "@paymentMode", paymentMode);
				employeeInfoMap.put(prevEmployee + "@payMonth", payMonth);
				employeeInfoMap.put(prevEmployee + "@payYear", payYear);
				employeeInfoMap.put(prevEmployee + "@noOfDays", noOfDays);
				employeeInfoMap.put(prevEmployee+ "@grossPay", formatter.format(totalAllowances));
				employeeInfoMap.put(prevEmployee+"@totalDed", formatter.format(totalDeductions));
				employeeInfoMap.put(prevEmployee+ "@netPay", formatter.format(netPayable));
				//////////
				java.util.HashMap x,y,z;
				x =new HashMap() ;y =new HashMap() ;z =new HashMap() ;
				x.put(prevEmployee, formatter.format(totalAllowances));
				y.put(prevEmployee, formatter.format(totalDeductions));
				z.put(prevEmployee, formatter.format(netPayable));
				allowanceList.add(x);
				deductionList.add(y);
				netPayableList.add(z);
				
				totalAllowances = 0;
				totalDeductions = 0;
				prevEmployee = employeeCode;
            }  // if
            
            empName = dto.getEmpName();
            designation = dto.getDesignation();
            pp_MonthlyPayID = dto.getPp_MonthlyPayID();

			if (dto.getNoOfDays()==null) 
				noOfDays = "Full Month";
			else 
				noOfDays = dto.getNoOfDays();
            
			payMonth = dto.getPayMonth();
            payYear = dto.getPayYear();
            headID = dto.getHeadID();
            headType = dto.getHeadType();
            headName = dto.getHeadName();
            amount = dto.getAmount();
            pp_RegisterMasterID = dto.getPp_RegisterMasterID();
			bankACCNo = dto.getBankACCNo();
			gpfACNo = dto.getGpfACNo();
			paymentMode = dto.getPaymentMode();
			payCategory = dto.getPayCategory();
			installment = dto.getInstallment();

			if(headType.trim().equals("A")){
				totalAllowances += Integer.parseInt(amount);
				employeeDataMap.put(employeeCode+"@"+headName+"@"+headType, amount);
			}else{
				totalDeductions += Integer.parseInt(amount);
				if(headType.trim().equals("D"))
					employeeDataMap.put(employeeCode+"@"+headName+"@"+headType, amount);
				else
					employeeDataMap.put(employeeCode+"@"+headName+"@"+headType, amount+"["+installment+"]");
			}
		
	}
        
        netPayable = totalAllowances-totalDeductions;

        employeeCodeList.add(prevEmployee);
		
		employeeInfoMap.put(prevEmployee + "@empName", empName);
		employeeInfoMap.put(prevEmployee + "@designation", designation);
		employeeInfoMap.put(prevEmployee + "@noOfDays", noOfDays);
		employeeInfoMap.put(prevEmployee + "@bankACCNo", bankACCNo);
		employeeInfoMap.put(prevEmployee + "@gpfACNo", gpfACNo);
		employeeInfoMap.put(prevEmployee + "@payCategory", payCategory);
		employeeInfoMap.put(prevEmployee + "@paymentMode", paymentMode);
		employeeInfoMap.put(prevEmployee + "@payMonth", payMonth);
		employeeInfoMap.put(prevEmployee + "@payYear", payYear);
	//  employeeInfoMap.put(prevEmployee + "@noOfDays", noOfDays);
		employeeInfoMap.put(prevEmployee+ "@grossPay", formatter.format(totalAllowances));
		employeeInfoMap.put(prevEmployee+"@totalDed", formatter.format(totalDeductions));
		employeeInfoMap.put(prevEmployee+ "@netPay", formatter.format(netPayable));
		HashMap x,y,z = null;
		x =new HashMap() ;y =new HashMap() ;z =new HashMap() ;
		x.put(prevEmployee, formatter.format(totalAllowances));	
		y.put(prevEmployee, formatter.format(totalDeductions));
		z.put(prevEmployee, formatter.format(netPayable));
		allowanceList.add(x);
		deductionList.add(y);
		netPayableList.add(z);

        }
        catch(Exception e){
        	e.printStackTrace();
        }
		return pdfFileName;


	}

	/********* Office Wise Summary Report   ******/
	
	@Override
	public List getGroupList() {
		List groupList = null;
		try{
		groupList = reportManagerDAO.getGroupList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return groupList;
	}

	@Override
	public List getMonthlySummary(String month, String year, String isArrear, String isLocked, String isBoth,
			String group, String type) {
		 List checkList = null;
	        try
	        {
	            checkList = reportManagerDAO.getMonthlySummary(month, year, isArrear, isLocked, isBoth, group, type);
	        }
	        catch(Exception e)
	        {
	            System.out.println((new StringBuilder()).append("error inside the getMonthlySummary of manager...").append(e).toString());
	        }
	        return checkList;
	}

	@Override
	public List getGross(String month, String year, String isArrear, String isLocked, String isBoth, String group) {
		List gross = null;
	        try
	        {
	            gross = reportManagerDAO.getGross(month, year, isArrear, isLocked, isBoth, group);
	            System.out.println((new StringBuilder()).append("gross in manager::::::::::::::::::").append(gross).toString());
	        }
	        catch(Exception e)
	        {
	            System.out.println((new StringBuilder()).append("error inside getGross method of manager. ").append(e).toString());
	        }
	        return gross;
	}

	@Override
	public List getNetpay(String month, String year, String isArrear, String isLocked, String isBoth, String group) {
		List netpay = null;
	        try
	        {
	            netpay = reportManagerDAO.getNetpay(month, year, isArrear, isLocked, isBoth, group);
	        }
	        catch(Exception e)
	        {
	            System.out.println((new StringBuilder()).append("error inside getNetpay method of manager. ").append(e).toString());
	        }
	        return netpay;
	}

	@Override
	public List getTotalDed(String month, String year, String isArrear, String isLocked, String isBoth,
			String group) {
		List total_Ded = null;
        try
        {
            total_Ded = reportManagerDAO.getTotalDed(month, year, isArrear, isLocked, isBoth, group);
        }
        catch(Exception e)
        {
            System.out.println((new StringBuilder()).append("error inside getTotalDed method of manager. ").append(e).toString());
        }
        return total_Ded;
	}

	@Override
	public List getItax(String month, String year, String isArrear, String isLocked, String isBoth, String group) {
		List itex = null;
        try
        {
            itex = reportManagerDAO.getItax(month, year, isArrear, isLocked, isBoth, group);
        }
        catch(Exception e)
        {
            System.out.println((new StringBuilder()).append("error inside getItex method of manager. ").append(e).toString());
        }
        return itex;
	}

	@Override
	public List getGpf(String month, String year, String isArrear, String isLocked, String isBoth, String group) {
		List gpf = null;
        try
        {
            gpf = reportManagerDAO.getGpf(month, year, isArrear, isLocked, isBoth, group);
        }
        catch(Exception e)
        {
            System.out.println((new StringBuilder()).append("error inside getItex method of manager. ").append(e).toString());
        }
        return gpf;
	}

	@Override
	public List getEmployee(String month, String year, String isArrear, String isLocked, String isBoth,
			String group) {
		List employee = null;
        try
        {
        	employee = reportManagerDAO.getEmployee(month, year, isArrear, isLocked, isBoth, group);
        }
        catch(Exception e)
        {
            System.out.println((new StringBuilder()).append("error inside getItex method of manager. ").append(e).toString());
        }
        return employee;
	}

	@Override
	public List getEmployer(String month, String year, String isArrear, String isLocked, String isBoth,
			String group) {
		List employer = null;
        try
        {
        	employer = reportManagerDAO.getEmployer(month, year, isArrear, isLocked, isBoth, group);
        }
        catch(Exception e)
        {
            System.out.println((new StringBuilder()).append("error inside getItex method of manager. ").append(e).toString());
        }
        return employer;
	}

	@Override
	public List getTotalEmp(String month, String year, String isArrear, String isLocked, String isBoth,
			String group) {
		List totalemp = null;
        try
        {
        	totalemp = reportManagerDAO.getTotalEmp(month, year, isArrear, isLocked, isBoth, group);
        }
        catch(Exception e)
        {
            System.out.println((new StringBuilder()).append("error inside getItex method of manager. ").append(e).toString());
        }
        return totalemp;
	}

	@Override
	public List getPaidEmp(String month, String year, String isArrear, String isLocked, String isBoth, String group) {
		List paidemp = null;
        try
        {
        	paidemp = reportManagerDAO.getPaidEmp(month, year, isArrear, isLocked, isBoth, group);
        }
        catch(Exception e)
        {
            System.out.println((new StringBuilder()).append("error inside getItex method of manager. ").append(e).toString());
        }
        return paidemp;
	}
	
	/*** Loan Deduction Report **/
	
	@Override
	public List<?> getEmployeeScheduleList(String monthName, String yearName,
			String pp_ScheduleMasterID, String pp_RegisterMasterID,
			Integer rmOfficeid) {
		List <?>schedulerList = null;
		try {
			schedulerList = reportManagerDAO.getEmployeeScheduleList(monthName, yearName,
					pp_ScheduleMasterID, pp_RegisterMasterID, rmOfficeid);
		} catch (Exception e) {
			System.out
					.println((new StringBuilder())
							.append("error inside getScheduleHeadList method of manager...")
							.append(e).toString());
		}
		return schedulerList;
	}
	
	
	public boolean isGPFSchedule(String pp_ScheduleMasterID,String scheduleName)
    {
        boolean isGPF = false;
        try
        {
            String str = scheduleName;
            if(str.substring(0, 3).equalsIgnoreCase("gpf") || str.substring(0, 3).equalsIgnoreCase("nps"))
            {
                isGPF = true;
            } else
            {
                isGPF = false;
            }
        }
        catch(Exception e) { }
        return isGPF;
    }
	
	
	 public boolean isNPSSchedule(String pp_ScheduleMasterID, String scheduleName)
	    {
	        boolean isNPS = false;
	        try
	        {
	            String str = scheduleName;
	            if(str.substring(0, 3).equalsIgnoreCase("nps"))
	            {
	                isNPS = true;
	            } else
	            {
	                isNPS = false;
	            }
	        }
	        catch(Exception e) { }
	        return isNPS;
	    }

	@Override
	public List getPayBillDetailForParticularMonthAndYear(String monthName,
			String yearName, Integer rmOfficeid, String sysPaymentmodeid,
			String billType) {
		
		List payBillDetailList=null;
		try{
			payBillDetailList = reportManagerDAO.getPayBillDetailForParticularMonthAndYear(monthName,yearName,rmOfficeid,sysPaymentmodeid,billType);	
		}catch(Exception e){
			System.out.println("error inside getPayBillDetailForParticularMonthAndYear method of manager."+e);
		}
	return payBillDetailList;	
	
		
	}


	@Override
	public boolean isBankAdvice(String sysPaymentmodeid) {

		boolean isBankAdvice=false;
		try{
			@SuppressWarnings("unchecked")
			List<SysPaymentmode> paymentModeList = (List<SysPaymentmode>) reportManagerDAO
					.getList(sysPaymentmodeid, "SysPaymentmode.findBySysPaymentmodeid");
			String paymentModeName =null;
			for(SysPaymentmode sePaymentmode :paymentModeList)
			{
				 paymentModeName = sePaymentmode.getPaymentmode();
			}
			String str = paymentModeName;
			if(str.substring(0,4).equalsIgnoreCase("bank")){
				 isBankAdvice=true;
			}else{
				 isBankAdvice=false;
			}
		}catch(Exception e){
		
		}
		return isBankAdvice;		
	}

	@Override
	public List getAdviceList(String monthName, String yearName,
			String sysPaymentmodeid, Integer rmOfficeid,
			String[] pp_PayBillDetailID) {
		List adviceList = null;
		try{
			adviceList=reportManagerDAO.getAdviceList(monthName,yearName,sysPaymentmodeid,rmOfficeid, pp_PayBillDetailID);
		}catch(Exception e){
			System.out.println("error inside getAdviceList method of manager..."+e);
		}
		return adviceList;
		
	}

	

}