package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "VIEW_MONTHLYPAYREPORT")
@XmlRootElement
//@NamedQueries({ @NamedQuery(name = "ViewMonthlyPayReport.findListtoDisplay", query = "SELECT DISTINCT(employeecode),empname FROM ViewMonthlyPayReport")})
public class ViewMonthlyPayReport implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ROWNUM")
	@Basic(optional = false)
	private long rownum;
	@Column(name = "PP_MONTHLYPAYID")
	@Basic(optional = false)
	private long pp_MonthlyPayID;
	@Column(name = "PP_PAYSCALEMASTERID")
	private String pp_PayScaleMasterID;
	@Column(name = "PP_EMPLOYEEPAYDETAILID")
	private long pp_EmployeePayDetailID;
	@Column(name = "PAYCATEGORY")
	@Basic(optional = false)
	private String payCategory;
	@Column(name = "EMPNAME")
	private String empName;
	@Column(name = "EMPLOYEECODE")
	@Basic(optional = false)
	private String employeeCode;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "GPFACNO")
	private String gpfAcNo;
	@Column(name = "BANKACCNO")
	private String bankAccNo;
	@Column(name = "PANNO")
	private String panno;
	@Column(name = "NOOFDAYS")
	private long noOfDays;
	@Column(name = "PAYMONTH")
	@Basic(optional = false)
	private long month;
	@Column(name = "PAYYEAR")
	@Basic(optional = false)
	private long year;
	@Column(name = "HEADID")
	private long headID;
	@Column(name = "HEADNAME")
	private String headName;
	@Column(name = "HEADTYPE")
	private String headType;
	@Column(name = "PRINT_ORDER")
	private long printorder;
	@Column(name = "AMOUNT")
	private long amount;
	@Column(name = "PP_REGISTERMASTERID")
	@Basic(optional = false)
	private long ppRegistermasterid;
	@Column(name = "RM_OFFICEID")
	private long rmofficeID;
	@Column(name = "PP_PAYBILLDETAILID")
	@Basic(optional = false)
	private long ppPaybilldetailid;
	@Column(name = "INSTALLMENT")
	private String installment;
	
	public long getPp_MonthlyPayID() {
		return pp_MonthlyPayID;
	}
	public void setPp_MonthlyPayID(long pp_MonthlyPayID) {
		this.pp_MonthlyPayID = pp_MonthlyPayID;
	}
	public String getPp_PayScaleMasterID() {
		return pp_PayScaleMasterID;
	}
	public void setPp_PayScaleMasterID(String pp_PayScaleMasterID) {
		this.pp_PayScaleMasterID = pp_PayScaleMasterID;
	}
	public long getPp_EmployeePayDetailID() {
		return pp_EmployeePayDetailID;
	}
	public void setPp_EmployeePayDetailID(long pp_EmployeePayDetailID) {
		this.pp_EmployeePayDetailID = pp_EmployeePayDetailID;
	}
	public String getPayCategory() {
		return payCategory;
	}
	public void setPayCategory(String payCategory) {
		this.payCategory = payCategory;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getGpfAcNo() {
		return gpfAcNo;
	}
	public void setGpfAcNo(String gpfAcNo) {
		this.gpfAcNo = gpfAcNo;
	}
	public String getBankAccNo() {
		return bankAccNo;
	}
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	public String getPanno() {
		return panno;
	}
	public void setPanno(String panno) {
		this.panno = panno;
	}
	public long getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(long noOfDays) {
		this.noOfDays = noOfDays;
	}
	public long getMonth() {
		return month;
	}
	public void setMonth(long month) {
		this.month = month;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public long getHeadID() {
		return headID;
	}
	public void setHeadID(long headID) {
		this.headID = headID;
	}
	public String getHeadName() {
		return headName;
	}
	public void setHeadName(String headName) {
		this.headName = headName;
	}
	public String getHeadType() {
		return headType;
	}
	public void setHeadType(String headType) {
		this.headType = headType;
	}
	public long getPrintorder() {
		return printorder;
	}
	public void setPrintorder(long printorder) {
		this.printorder = printorder;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getPpRegistermasterid() {
		return ppRegistermasterid;
	}
	public void setPpRegistermasterid(long ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}
	public long getRmofficeID() {
		return rmofficeID;
	}
	public void setRmofficeID(long rmofficeID) {
		this.rmofficeID = rmofficeID;
	}
	public long getPpPaybilldetailid() {
		return ppPaybilldetailid;
	}
	public void setPpPaybilldetailid(long ppPaybilldetailid) {
		this.ppPaybilldetailid = ppPaybilldetailid;
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

	
	


}
