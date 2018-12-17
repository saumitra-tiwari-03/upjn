package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "DeductionLoanScheduleEntity")
@XmlRootElement
@NamedQueries({})
public class DeductionLoanScheduleEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	protected String employeeCode;
	protected String employeeName;
	protected String gPFACNO;
	protected String payMonth;
	protected String payYear;
	protected String pp_RegisterMasterID;
	protected String pp_MonthlyPayID;
	protected String tran_TypeID;
	protected String amount;
	protected String headName;
	protected String pp_ScheduleMasterID;
	protected String panNo;
	protected String headType;
	protected String rm_OfficeID;
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getgPFACNO() {
		return gPFACNO;
	}
	public void setgPFACNO(String gPFACNO) {
		this.gPFACNO = gPFACNO;
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
	public String getPp_RegisterMasterID() {
		return pp_RegisterMasterID;
	}
	public void setPp_RegisterMasterID(String pp_RegisterMasterID) {
		this.pp_RegisterMasterID = pp_RegisterMasterID;
	}
	public String getPp_MonthlyPayID() {
		return pp_MonthlyPayID;
	}
	public void setPp_MonthlyPayID(String pp_MonthlyPayID) {
		this.pp_MonthlyPayID = pp_MonthlyPayID;
	}
	public String getTran_TypeID() {
		return tran_TypeID;
	}
	public void setTran_TypeID(String tran_TypeID) {
		this.tran_TypeID = tran_TypeID;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getHeadName() {
		return headName;
	}
	public void setHeadName(String headName) {
		this.headName = headName;
	}
	public String getPp_ScheduleMasterID() {
		return pp_ScheduleMasterID;
	}
	public void setPp_ScheduleMasterID(String pp_ScheduleMasterID) {
		this.pp_ScheduleMasterID = pp_ScheduleMasterID;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getHeadType() {
		return headType;
	}
	public void setHeadType(String headType) {
		this.headType = headType;
	}
	public String getRm_OfficeID() {
		return rm_OfficeID;
	}
	public void setRm_OfficeID(String rm_OfficeID) {
		this.rm_OfficeID = rm_OfficeID;
	}
	
	
	

}
