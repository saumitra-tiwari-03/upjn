package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_OFFICEWISEEMPREPORT")
public class ViewOfficeWiseEmpReport implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "PP_EMPLOYEEMASTERID")
	@Basic(optional = false)
	private String pp_EmployeeMasterID;
	@Column(name = "EMPLOYEECODE")
	@Basic(optional = false)
	private String employeeCode;
	@Column(name = "EMPLOYEENAME")
	@Basic(optional = false)
	private String employeename;	
	@Column(name = "FIRSTNAME")
	@Basic(optional = false)
	private String FIRSTNAME;	
	@Column(name = "LASTNAME")
	@Basic(optional = false)
	private String LASTNAME;	
	@Column(name = "RM_OFFICEID")
	@Basic(optional = false)
	private String rm_officeid;
	@Column(name = "OFFICENAME")
	@Basic(optional = false)
	private String officeName;
	@Column(name = "DESIGNATION")
	@Basic(optional = false)
	private String designation;
	@Column(name = "FATHERNAME")
	@Basic(optional = false)
	private String fathername;
	@Column(name = "DATEOFBIRTH")
	@Basic(optional = false)
	private String dateofbirth;
	@Column(name = "DATEJOINING")
	@Basic(optional = false)
	private String datejoining;
	@Column(name = "MAS_CASTEID")
	@Basic(optional = false)
	private String mas_casteid;
	@Column(name = "HOMETOWN")
	@Basic(optional = false)
	private String HOMETOWN;
	@Column(name = "CASTE")
	@Basic(optional = false)
	private String CASTE;
	@Column(name = "MODEOFAPPOINTMENT")
	@Basic(optional = false)
	private String MODEOFAPPOINTMENT;
	@Column(name = "LOC_CODE")
	@Basic(optional = false)
	private String loc_code;
	@Column(name = "ISFUNCTIONING")
	@Basic(optional = false)
	private String ISFUNCTIONING;
	@Column(name = "ISRETIRED")
	@Basic(optional = false)
	private String ISRETIRED;
	@Column(name = "MAS_EMPLOYMENTSUBTYPEID")
	@Basic(optional = false)
	private String MAS_EMPLOYMENTSUBTYPEID;
	@Column(name = "EMPLOYMENTSUBTYPE")
	@Basic(optional = false)
	private String EMPLOYMENTSUBTYPE;
	@Column(name = "PP_DESIGNATIONMASTERID")
	@Basic(optional = false)
	private String PP_DESIGNATIONMASTERID;

	
	public String getPp_EmployeeMasterID() {
		return pp_EmployeeMasterID;
	}
	public void setPp_EmployeeMasterID(String pp_EmployeeMasterID) {
		this.pp_EmployeeMasterID = pp_EmployeeMasterID;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getRm_officeid() {
		return rm_officeid;
	}
	public void setRm_officeid(String rm_officeid) {
		this.rm_officeid = rm_officeid;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getDatejoining() {
		return datejoining;
	}
	public void setDatejoining(String datejoining) {
		this.datejoining = datejoining;
	}
	public String getMas_casteid() {
		return mas_casteid;
	}
	public void setMas_casteid(String mas_casteid) {
		this.mas_casteid = mas_casteid;
	}
	public String getHOMETOWN() {
		return HOMETOWN;
	}
	public void setHOMETOWN(String hOMETOWN) {
		HOMETOWN = hOMETOWN;
	}
	public String getCASTE() {
		return CASTE;
	}
	public void setCASTE(String cASTE) {
		CASTE = cASTE;
	}
	public String getMODEOFAPPOINTMENT() {
		return MODEOFAPPOINTMENT;
	}
	public void setMODEOFAPPOINTMENT(String mODEOFAPPOINTMENT) {
		MODEOFAPPOINTMENT = mODEOFAPPOINTMENT;
	}
	public String getLoc_code() {
		return loc_code;
	}
	public void setLoc_code(String loc_code) {
		this.loc_code = loc_code;
	}
	public String getISFUNCTIONING() {
		return ISFUNCTIONING;
	}
	public void setISFUNCTIONING(String iSFUNCTIONING) {
		ISFUNCTIONING = iSFUNCTIONING;
	}
	public String getISRETIRED() {
		return ISRETIRED;
	}
	public void setISRETIRED(String iSRETIRED) {
		ISRETIRED = iSRETIRED;
	}
	public String getMAS_EMPLOYMENTSUBTYPEID() {
		return MAS_EMPLOYMENTSUBTYPEID;
	}
	public void setMAS_EMPLOYMENTSUBTYPEID(String mAS_EMPLOYMENTSUBTYPEID) {
		MAS_EMPLOYMENTSUBTYPEID = mAS_EMPLOYMENTSUBTYPEID;
	}
	public String getEMPLOYMENTSUBTYPE() {
		return EMPLOYMENTSUBTYPE;
	}
	public void setEMPLOYMENTSUBTYPE(String eMPLOYMENTSUBTYPE) {
		EMPLOYMENTSUBTYPE = eMPLOYMENTSUBTYPE;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getFIRSTNAME() {
		return FIRSTNAME;
	}
	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}
	public String getLASTNAME() {
		return LASTNAME;
	}
	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}
	public String getPP_DESIGNATIONMASTERID() {
		return PP_DESIGNATIONMASTERID;
	}
	public void setPP_DESIGNATIONMASTERID(String pP_DESIGNATIONMASTERID) {
		PP_DESIGNATIONMASTERID = pP_DESIGNATIONMASTERID;
	}
	
	
	

}
