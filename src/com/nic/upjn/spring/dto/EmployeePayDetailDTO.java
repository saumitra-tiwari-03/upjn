package com.nic.upjn.spring.dto;

import java.io.Serializable;

public class EmployeePayDetailDTO
    implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String pp_EmployeeMasterID;
    protected String sys_PayCommissionID;
    protected String sys_PayCategoryID;
    protected String pp_PayScaleMasterID;
    protected String nextIncrementMonth;
    protected String defaultIncrementAmount;
    protected String pp_PayAlwMasterID;
    protected String amount;
    protected String sys_PaymentModeID;
    protected String paymentMode;
    protected String gpfAcNo;
    protected String panno;
    protected String isnps;
    protected String mas_BankID;
    protected String mas_BankBranchID;
    protected String pp_RegisterMasterID;
    protected String registerName;
    protected String pp_SectionMasterID;
    protected String sectionName;
    protected String bankAccNo;
    protected String salaryPercent;
    protected String noOfDays;
    protected String headQuarter;
    protected String hraTownCategoryID;
    protected String ccaTownCategoryID;
    protected String bankName;
    protected String branchName;
    protected String fwa_BankAccountID;
    protected String joining_mnth;
    protected String startmon_forregular_cont;
    protected String mon_contr;
    protected String year_contr;
    protected String emp_cont_amt;
    protected String emplr_cont_amt;
    protected String branch_Name;
    protected String bank_Name;
        protected String ifsc_code;

    public EmployeePayDetailDTO()
    {
    }

    public String getBank_Name() {
        return bank_Name;
    }

    public void setBank_Name(String bank_Name) {
        this.bank_Name = bank_Name;
    }

    public String getBranch_Name() {
        return branch_Name;
    }

    public void setBranch_Name(String branch_Name) {
        this.branch_Name = branch_Name;
    }

    public String getIfsc_code() {
        return ifsc_code;
    }

    public void setIfsc_code(String ifsc_code) {
        this.ifsc_code = ifsc_code;
    }



    public String getFwa_BankAccountID()
    {
        return fwa_BankAccountID;
    }

    public void setFwa_BankAccountID(String fwa_BankAccountID)
    {
        this.fwa_BankAccountID = fwa_BankAccountID;
    }

    public String getEmp_cont_amt()
    {
        return emp_cont_amt;
    }

    public void setEmp_cont_amt(String emp_cont_amt)
    {
        this.emp_cont_amt = emp_cont_amt;
    }

    public String getEmplr_cont_amt()
    {
        return emplr_cont_amt;
    }

    public void setEmplr_cont_amt(String emplr_cont_amt)
    {
        this.emplr_cont_amt = emplr_cont_amt;
    }

    public String getJoining_mnth()
    {
        return joining_mnth;
    }

    public void setJoining_mnth(String joining_mnth)
    {
        this.joining_mnth = joining_mnth;
    }

    public String getMon_contr()
    {
        return mon_contr;
    }

    public void setMon_contr(String mon_contr)
    {
        this.mon_contr = mon_contr;
    }

    public String getStartmon_forregular_cont()
    {
        return startmon_forregular_cont;
    }

    public void setStartmon_forregular_cont(String startmon_forregular_cont)
    {
        this.startmon_forregular_cont = startmon_forregular_cont;
    }

    public String getYear_contr()
    {
        return year_contr;
    }

    public void setYear_contr(String year_contr)
    {
        this.year_contr = year_contr;
    }

    public String getIsnps()
    {
        return isnps;
    }

    public void setIsnps(String isnps)
    {
        this.isnps = isnps;
    }

    public String getBankName()
    {
        return bankName;
    }

    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }

    public String getBranchName()
    {
        return branchName;
    }

    public void setBranchName(String branchName)
    {
        this.branchName = branchName;
    }

    public String getPp_EmployeeMasterID()
    {
        return pp_EmployeeMasterID;
    }

    public void setPp_EmployeeMasterID(String pp_EmployeeMasterID)
    {
        this.pp_EmployeeMasterID = pp_EmployeeMasterID;
    }

    public String getSys_PayCommissionID()
    {
        return sys_PayCommissionID;
    }

    public void setSys_PayCommissionID(String sys_PayCommissionID)
    {
        this.sys_PayCommissionID = sys_PayCommissionID;
    }

    public String getPp_PayScaleMasterID()
    {
        return pp_PayScaleMasterID;
    }

    public void setPp_PayScaleMasterID(String pp_PayScaleMasterID)
    {
        this.pp_PayScaleMasterID = pp_PayScaleMasterID;
    }

    public String getNextIncrementMonth()
    {
        return nextIncrementMonth;
    }

    public void setNextIncrementMonth(String nextIncrementMonth)
    {
        this.nextIncrementMonth = nextIncrementMonth;
    }

    public String getDefaultIncrementAmount()
    {
        return defaultIncrementAmount;
    }

    public void setDefaultIncrementAmount(String defaultIncrementAmount)
    {
        this.defaultIncrementAmount = defaultIncrementAmount;
    }

    public String getPp_PayAlwMasterID()
    {
        return pp_PayAlwMasterID;
    }

    public void setPp_PayAlwMasterID(String pp_PayAlwMasterID)
    {
        this.pp_PayAlwMasterID = pp_PayAlwMasterID;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public String getSys_PayCategoryID()
    {
        return sys_PayCategoryID;
    }

    public void setSys_PayCategoryID(String sys_PayCategoryID)
    {
        this.sys_PayCategoryID = sys_PayCategoryID;
    }

    public String getSys_PaymentModeID()
    {
        return sys_PaymentModeID;
    }

    public void setSys_PaymentModeID(String sys_PaymentModeID)
    {
        this.sys_PaymentModeID = sys_PaymentModeID;
    }

    public String getGpfAcNo()
    {
        return gpfAcNo;
    }

    public void setGpfAcNo(String gpfAcNo)
    {
        this.gpfAcNo = gpfAcNo;
    }

    public String getPanno()
    {
        return panno;
    }

    public void setPanno(String panno)
    {
        this.panno = panno;
    }

    public String getPaymentMode()
    {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode)
    {
        this.paymentMode = paymentMode;
    }

    public String getMas_BankID()
    {
        return mas_BankID;
    }

    public void setMas_BankID(String mas_BankID)
    {
        this.mas_BankID = mas_BankID;
    }

    public String getMas_BankBranchID()
    {
        return mas_BankBranchID;
    }

    public void setMas_BankBranchID(String mas_BankBranchID)
    {
        this.mas_BankBranchID = mas_BankBranchID;
    }

    public String getPp_RegisterMasterID()
    {
        return pp_RegisterMasterID;
    }

    public void setPp_RegisterMasterID(String pp_RegisterMasterID)
    {
        this.pp_RegisterMasterID = pp_RegisterMasterID;
    }

    public String getRegisterName()
    {
        return registerName;
    }

    public void setRegisterName(String registerName)
    {
        this.registerName = registerName;
    }

    public String getPp_SectionMasterID()
    {
        return pp_SectionMasterID;
    }

    public void setPp_SectionMasterID(String pp_SectionMasterID)
    {
        this.pp_SectionMasterID = pp_SectionMasterID;
    }

    public String getSectionName()
    {
        return sectionName;
    }

    public void setSectionName(String sectionName)
    {
        this.sectionName = sectionName;
    }

    public String getBankAccNo()
    {
        return bankAccNo;
    }

    public void setBankAccNo(String bankAccNo)
    {
        this.bankAccNo = bankAccNo;
    }

    public String getSalaryPercent()
    {
        return salaryPercent;
    }

    public void setSalaryPercent(String salaryPercent)
    {
        this.salaryPercent = salaryPercent;
    }

    public String getNoOfDays()
    {
        return noOfDays;
    }

    public void setNoOfDays(String noOfDays)
    {
        this.noOfDays = noOfDays;
    }

    public String getHeadQuarter()
    {
        return headQuarter;
    }

    public void setHeadQuarter(String headQuarter)
    {
        this.headQuarter = headQuarter;
    }

    public String getHraTownCategoryID()
    {
        return hraTownCategoryID;
    }

    public void setHraTownCategoryID(String hraTownCategoryID)
    {
        this.hraTownCategoryID = hraTownCategoryID;
    }

    public String getCcaTownCategoryID()
    {
        return ccaTownCategoryID;
    }

    public void setCcaTownCategoryID(String ccaTownCategoryID)
    {
        this.ccaTownCategoryID = ccaTownCategoryID;
    }

    public String[] getParam()
    {
        String param[] = new String[13];
        param[0] = this.pp_EmployeeMasterID;
        param[1] = this.sys_PaymentModeID;
        param[2] = this.fwa_BankAccountID;
        param[3] = this.bankAccNo;
        param[4] = this.salaryPercent;
        param[5] = this.noOfDays;
        param[6] = this.headQuarter;
        param[7] = this.gpfAcNo;
        param[8] = this.panno;
        param[9] = this.isnps;
        param[10] = this.bank_Name;
        param[11] = this.branch_Name;
        param[12] = this.ifsc_code;
        return param;
    }
}