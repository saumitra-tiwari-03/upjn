package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DeletePayBillEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -239366558712661320L;
	@Id
	private String pp_PayBillDetailID;
    private String billClerkName;
    private String billNO;
    private String month;
    private String year;
    private String billDate;
    private String billAmount;
    private String billType_Flag;
	private String pp_RegisterMasterID;
	private String registerName;

	public String getPp_PayBillDetailID() {
		return pp_PayBillDetailID;
	}

	public void setPp_PayBillDetailID(String pp_PayBillDetailID) {
		this.pp_PayBillDetailID = pp_PayBillDetailID;
	}

	public String getBillClerkName() {
		return billClerkName;
	}

	public void setBillClerkName(String billClerkName) {
		this.billClerkName = billClerkName;
	}

	public String getBillNO() {
		return billNO;
	}

	public void setBillNO(String billNO) {
		this.billNO = billNO;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}

	public String getBillType_Flag() {
		return billType_Flag;
	}

	public void setBillType_Flag(String billType_Flag) {
		this.billType_Flag = billType_Flag;
	}

	public String getPp_RegisterMasterID() {
		return pp_RegisterMasterID;
	}

	public void setPp_RegisterMasterID(String pp_RegisterMasterID) {
		this.pp_RegisterMasterID = pp_RegisterMasterID;
	}

	public String getRegisterName() {
		return registerName;
	}

	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}

}
