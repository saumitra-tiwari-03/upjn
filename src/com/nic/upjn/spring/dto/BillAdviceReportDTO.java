package com.nic.upjn.spring.dto;

public class BillAdviceReportDTO {
	
	
	 protected String monthName;

	 protected String yearName;

	 protected String sysPaymentmodeid;

	 protected String paymentmode;

	 protected String billType;

	 protected String pp_PayBillDetailID[];

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

	public String getSysPaymentmodeid() {
		return sysPaymentmodeid;
	}

	public void setSysPaymentmodeid(String sysPaymentmodeid) {
		this.sysPaymentmodeid = sysPaymentmodeid;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String[] getPp_PayBillDetailID() {
		return pp_PayBillDetailID;
	}

	public void setPp_PayBillDetailID(String[] pp_PayBillDetailID) {
		this.pp_PayBillDetailID = pp_PayBillDetailID;
	}


	 

}
