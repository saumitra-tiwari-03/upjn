package com.nic.upjn.spring.dto;

public class LockPayBillDTO {

	private String bill_Amount;
	private String net_Pay;
	private String description;
	private String monthName;
	private String yearName;
	private String ppRegistermasterid;
	private String billNo;
	private String billDate;
	private Integer rmOfficeid;
	private Character transactiontype;

	public Character getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(Character transactiontype) {
		this.transactiontype = transactiontype;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getBill_Amount() {
		return bill_Amount;
	}

	public void setBill_Amount(String bill_Amount) {
		this.bill_Amount = bill_Amount;
	}

	public String getNet_Pay() {
		return net_Pay;
	}

	public void setNet_Pay(String net_Pay) {
		this.net_Pay = net_Pay;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getPpRegistermasterid() {
		return ppRegistermasterid;
	}

	public void setPpRegistermasterid(String ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getRegisterName() {
		return registerName;
	}

	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}

	public String getPp_PayBillDetailID() {
		return pp_PayBillDetailID;
	}

	public void setPp_PayBillDetailID(String pp_PayBillDetailID) {
		this.pp_PayBillDetailID = pp_PayBillDetailID;
	}

	private String registerName;
	private String pp_PayBillDetailID;

}
