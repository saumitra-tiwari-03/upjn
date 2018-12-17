package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaySlipEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "HEADID")
	private String headID;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeeCode;
	@Basic(optional = false)
	@Column(name = "EMPNAME")
	private String empName;
	@Basic(optional = false)
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "PP_MONTHLYPAYID")
	private String pp_MonthlyPayID;
	@Basic(optional = false)
	@Column(name = "NOOFDAYS")
	private String noOfDays;
	@Basic(optional = false)
	@Column(name = "PAYMONTH")
	private String payMonth;
	@Basic(optional = false)
	@Column(name = "PAYYEAR")
	private String payYear;
	@Basic(optional = false)
	@Column(name = "HEADTYPE")
	private String headType;
	@Basic(optional = false)
	@Column(name = "HEADNAME")
	private String headName;
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private String amount;
	@Basic(optional = false)
	@Column(name = "PP_REGISTERMASTERID")
	private String pp_RegisterMasterID;
	@Basic(optional = false)
	@Column(name = "BANKACCNO")
	private String bankACCNo;
	@Basic(optional = false)
	@Column(name = "GPFACNO")
	private String gpfACNo;
	@Basic(optional = false)
	@Column(name = "paymentMode")
	private String paymentMode;
	@Basic(optional = false)
	@Column(name = "payCategory")
	private String payCategory;
	@Basic(optional = false)
	@Column(name = "installment")
	private String installment;
	@Basic(optional = false)
	@Column(name = "PRINT_ORDER")
	private String print_Order;

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPp_MonthlyPayID() {
		return pp_MonthlyPayID;
	}

	public void setPp_MonthlyPayID(String pp_MonthlyPayID) {
		this.pp_MonthlyPayID = pp_MonthlyPayID;
	}

	public String getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getPayMonth() {
		return payMonth;
	}

	public void setPayMonth(String payMonth) {
		this.payMonth = payMonth;
	}

	public String getPayYear() {
		return payYear;
	}

	public void setPayYear(String payYear) {
		this.payYear = payYear;
	}

	public String getHeadID() {
		return headID;
	}

	public void setHeadID(String headID) {
		this.headID = headID;
	}

	public String getHeadType() {
		return headType;
	}

	public void setHeadType(String headType) {
		this.headType = headType;
	}

	public String getHeadName() {
		return headName;
	}

	public void setHeadName(String headName) {
		this.headName = headName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPp_RegisterMasterID() {
		return pp_RegisterMasterID;
	}

	public void setPp_RegisterMasterID(String pp_RegisterMasterID) {
		this.pp_RegisterMasterID = pp_RegisterMasterID;
	}

	public String getBankACCNo() {
		return bankACCNo;
	}

	public void setBankACCNo(String bankACCNo) {
		this.bankACCNo = bankACCNo;
	}

	public String getGpfACNo() {
		return gpfACNo;
	}

	public void setGpfACNo(String gpfACNo) {
		this.gpfACNo = gpfACNo;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPayCategory() {
		return payCategory;
	}

	public void setPayCategory(String payCategory) {
		this.payCategory = payCategory;
	}

	public String getInstallment() {
		return installment;
	}

	public void setInstallment(String installment) {
		this.installment = installment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPrint_Order() {
		return print_Order;
	}

	public void setPrint_Order(String print_Order) {
		this.print_Order = print_Order;
	}

}
