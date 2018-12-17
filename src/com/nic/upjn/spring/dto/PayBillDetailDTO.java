package com.nic.upjn.spring.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PayBillDetailDTO implements Serializable {

	private Long ppPaybilldetailid;

	private long billclerkid;

	private String billclerkname;

	private String billno;

	private long billamount;

	private Character islocked;

	private String billdate;

	private short ppRegistermasterid;

	private Character billtypeFlag;

	private Long netpay;

	private String totalEmployee;

	private Integer rmOfficeid;
	private String ppEmployeemasterid;

	private String monthName;

	private String yearName;

	private BigDecimal sysPaycategoryid;

	private String payValue;

	private String isCalculated;

	public String[] pp_PayAlw_MasterID;
	public String[] pp_PayAlw_Value;
	public String[] payAlwShortName;

	public String[] pp_LoanDetailID;
	public String[] loanAmount;
	public String[] Pp_NpsDetailID;
	public String[] Npsamount;
	
	
	
	public String pp_EmployeeMasterID;
	public String payCommisionNo;
	public String payScale;
	public String salaryPercent;
	public String noOfDays;
	public String hraTownCategoryID;
	public String ccaTownCategoryID;
	public String pp_RegisterMasterID;
	
	
	
	
	
	public PayBillDetailDTO()
	{
		billtypeFlag = 'P';
	}
	
	
	public String employeeCode;
	
	 public String[] pp_DedDetailID;
		public String[] dedAmount;
		public String[] pa_NextInstallmentNo;
	
	
	

	public String[] getPp_DedDetailID() {
			return pp_DedDetailID;
		}

		public void setPp_DedDetailID(String[] pp_DedDetailID) {
			this.pp_DedDetailID = pp_DedDetailID;
		}

		public String[] getDedAmount() {
			return dedAmount;
		}

		public void setDedAmount(String[] dedAmount) {
			this.dedAmount = dedAmount;
		}

		public String[] getPa_NextInstallmentNo() {
			return pa_NextInstallmentNo;
		}

		public void setPa_NextInstallmentNo(String[] pa_NextInstallmentNo) {
			this.pa_NextInstallmentNo = pa_NextInstallmentNo;
		}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getPp_EmployeeMasterID() {
		return pp_EmployeeMasterID;
	}

	public void setPp_EmployeeMasterID(String pp_EmployeeMasterID) {
		this.pp_EmployeeMasterID = pp_EmployeeMasterID;
	}

	public String getPayCommisionNo() {
		return payCommisionNo;
	}

	public void setPayCommisionNo(String payCommisionNo) {
		this.payCommisionNo = payCommisionNo;
	}

	public String getPayScale() {
		return payScale;
	}

	public void setPayScale(String payScale) {
		this.payScale = payScale;
	}

	public String getSalaryPercent() {
		return salaryPercent;
	}

	public void setSalaryPercent(String salaryPercent) {
		this.salaryPercent = salaryPercent;
	}

	public String getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getHraTownCategoryID() {
		return hraTownCategoryID;
	}

	public void setHraTownCategoryID(String hraTownCategoryID) {
		this.hraTownCategoryID = hraTownCategoryID;
	}

	public String getCcaTownCategoryID() {
		return ccaTownCategoryID;
	}

	public void setCcaTownCategoryID(String ccaTownCategoryID) {
		this.ccaTownCategoryID = ccaTownCategoryID;
	}

	public String getPp_RegisterMasterID() {
		return pp_RegisterMasterID;
	}

	public void setPp_RegisterMasterID(String pp_RegisterMasterID) {
		this.pp_RegisterMasterID = pp_RegisterMasterID;
	}

	public String[] getPp_PayAlw_MasterID() {
		return pp_PayAlw_MasterID;
	}

	public void setPp_PayAlw_MasterID(String[] pp_PayAlw_MasterID) {
		this.pp_PayAlw_MasterID = pp_PayAlw_MasterID;
	}

	public String[] getPp_PayAlw_Value() {
		return pp_PayAlw_Value;
	}

	public void setPp_PayAlw_Value(String[] pp_PayAlw_Value) {
		this.pp_PayAlw_Value = pp_PayAlw_Value;
	}

	public String[] getPayAlwShortName() {
		return payAlwShortName;
	}

	public void setPayAlwShortName(String[] payAlwShortName) {
		this.payAlwShortName = payAlwShortName;
	}

	public String[] getPp_LoanDetailID() {
		return pp_LoanDetailID;
	}

	public void setPp_LoanDetailID(String[] pp_LoanDetailID) {
		this.pp_LoanDetailID = pp_LoanDetailID;
	}

	public String[] getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String[] loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String[] getPp_NpsDetailID() {
		return Pp_NpsDetailID;
	}

	public void setPp_NpsDetailID(String[] pp_NpsDetailID) {
		Pp_NpsDetailID = pp_NpsDetailID;
	}

	public String[] getNpsamount() {
		return Npsamount;
	}

	public void setNpsamount(String[] npsamount) {
		Npsamount = npsamount;
	}

	public Long getPpPaybilldetailid() {
		return ppPaybilldetailid;
	}

	public void setPpPaybilldetailid(Long ppPaybilldetailid) {
		this.ppPaybilldetailid = ppPaybilldetailid;
	}

	public long getBillclerkid() {
		return billclerkid;
	}

	public void setBillclerkid(long billclerkid) {
		this.billclerkid = billclerkid;
	}

	public String getBillclerkname() {
		return billclerkname;
	}

	public void setBillclerkname(String billclerkname) {
		this.billclerkname = billclerkname;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public long getBillamount() {
		return billamount;
	}

	public void setBillamount(long billamount) {
		this.billamount = billamount;
	}

	public Character getIslocked() {
		return islocked;
	}

	public void setIslocked(Character islocked) {
		this.islocked = islocked;
	}

	public String getBilldate() {
		return billdate;
	}

	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}

	public short getPpRegistermasterid() {
		return ppRegistermasterid;
	}

	public void setPpRegistermasterid(short ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public Character getBilltypeFlag() {
		return billtypeFlag;
	}

	public void setBilltypeFlag(Character billtypeFlag) {
		this.billtypeFlag = billtypeFlag;
	}

	public Long getNetpay() {
		return netpay;
	}

	public void setNetpay(Long netpay) {
		this.netpay = netpay;
	}

	public String getTotalEmployee() {
		return totalEmployee;
	}

	public void setTotalEmployee(String totalEmployee) {
		this.totalEmployee = totalEmployee;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(String ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public String getYearName() {
		return yearName;
	}

	public void setYearName(String yearName) {
		this.yearName = yearName;
	}

	public BigDecimal getSysPaycategoryid() {
		return sysPaycategoryid;
	}

	public void setSysPaycategoryid(BigDecimal sysPaycategoryid) {
		this.sysPaycategoryid = sysPaycategoryid;
	}

	public String getPayValue() {
		return payValue;
	}

	public void setPayValue(String payValue) {
		this.payValue = payValue;
	}

	public String getIsCalculated() {
		return isCalculated;
	}

	public void setIsCalculated(String isCalculated) {
		this.isCalculated = isCalculated;
	}

}
