package com.nic.upjn.spring.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PayBillDTO {

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
	
	private String[] stop_Alw_Flag;
	
	private String    payValue;
	
	private String    isCalculated;
	
	
	
	public String getIsCalculated() {
		return isCalculated;
	}

	public void setIsCalculated(String isCalculated) {
		this.isCalculated = isCalculated;
	}

	public String getPayValue() {
		return payValue;
	}

	public void setPayValue(String payValue) {
		this.payValue = payValue;
	}

	public BigDecimal getSysPaycategoryid() {
		return sysPaycategoryid;
	}

	public void setSysPaycategoryid(BigDecimal sysPaycategoryid) {
		this.sysPaycategoryid = sysPaycategoryid;
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

	public String getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(String ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
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

	public String[] getStop_Alw_Flag() {
		return stop_Alw_Flag;
	}

	public void setStop_Alw_Flag(String[] stop_Alw_Flag) {
		this.stop_Alw_Flag = stop_Alw_Flag;
	}
	
	

}
