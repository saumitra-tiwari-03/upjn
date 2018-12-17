/*=======================================================
 * Author: RAM PRAKASH PANDEY

 *=======================================================
 */

/**
 * This class holds the data from the form input.

 * Jsp associated with this form is ...

 */

package com.nic.upjn.spring.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
@SuppressWarnings({"unused" })

public class EmployeeAppointmentDTO {

	private Long ppEmployeemasterid;

	@NotEmpty
	@Size(min = 4, max = 15, message = "employeecode  could not be null")
	private String employeecode;

	private String employeename;
	@NotEmpty
	@Size(min = 4, max = 15, message = "firstname name could not be null")
	private String firstname;

	@NotEmpty
	@Size(min = 4, max = 15, message = "middlename name could not be null")
	private String middlename;

	private String designation;
	
	private Long ppEmployeedetailid;
	
	private Character isconfirm;
	
	private Character ispermanent;
	
	

	public Character getIsconfirm() {
		return isconfirm;
	}

	public void setIsconfirm(Character isconfirm) {
		this.isconfirm = isconfirm;
	}

	public Character getIspermanent() {
		return ispermanent;
	}

	public void setIspermanent(Character ispermanent) {
		this.ispermanent = ispermanent;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmploymenttype() {
		return employmenttype;
	}

	public void setEmploymenttype(String employmenttype) {
		this.employmenttype = employmenttype;
	}

	@NotEmpty
	@Size(min = 4, max = 15, message = "lastname name could not be null")
	private String lastname;

	private String employmenttype;

	private String password;

	@NotEmpty
	@Size(min = 4, max = 15, message = "appointmentfileno name could not be null")
	private String appointmentfileno;

	private int ppDesignationmasterid;

	
	private String dateofbirth;

	private Short sysSubservicephasemasterid;
	@NotEmpty
	private String fathername;
	
	private Long ppEmployeeappointmentdetailid;
	
	private Long ppEmployeepersonaldetailid;
	
	private BigDecimal ppEmployeepaydetailid;
	
	

	
	public BigDecimal getPpEmployeepaydetailid() {
		return ppEmployeepaydetailid;
	}

	public void setPpEmployeepaydetailid(BigDecimal ppEmployeepaydetailid) {
		this.ppEmployeepaydetailid = ppEmployeepaydetailid;
	}

	public Long getPpEmployeeappointmentdetailid() {
		return ppEmployeeappointmentdetailid;
	}

	public void setPpEmployeeappointmentdetailid(Long ppEmployeeappointmentdetailid) {
		this.ppEmployeeappointmentdetailid = ppEmployeeappointmentdetailid;
	}

	public Long getPpEmployeepersonaldetailid() {
		return ppEmployeepersonaldetailid;
	}

	public void setPpEmployeepersonaldetailid(Long ppEmployeepersonaldetailid) {
		this.ppEmployeepersonaldetailid = ppEmployeepersonaldetailid;
	}

	public String getPp_designationmasterid() {
		return pp_designationmasterid;
	}

	public void setPp_designationmasterid(String pp_designationmasterid) {
		this.pp_designationmasterid = pp_designationmasterid;
	}

	
	
	public Long getPpEmployeedetailid() {
		return ppEmployeedetailid;
	}

	public void setPpEmployeedetailid(Long ppEmployeedetailid) {
		this.ppEmployeedetailid = ppEmployeedetailid;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public Short getSysSubservicephasemasterid() {
		return sysSubservicephasemasterid;
	}

	public void setSysSubservicephasemasterid(Short sysSubservicephasemasterid) {
		this.sysSubservicephasemasterid = sysSubservicephasemasterid;
	}

	

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public char getSexcode() {
		return sexcode;
	}

	public void setSexcode(char sexcode) {
		this.sexcode = sexcode;
	}

	private char sexcode;

	public int getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(int ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public String getAppointmentfileno() {
		return appointmentfileno;
	}

	public void setAppointmentfileno(String appointmentfileno) {
		this.appointmentfileno = appointmentfileno;
	}

	private String effectivedatjoin;

	public String getEffectivedatjoin() {
		return effectivedatjoin;
	}

	public void setEffectivedatjoin(String effectivedatjoin) {
		this.effectivedatjoin = effectivedatjoin;
	}


	public String getAppointmentfiledate() {
		return appointmentfiledate;
	}

	public void setAppointmentfiledate(String appointmentfiledate) {
		this.appointmentfiledate = appointmentfiledate;
	}

	public String getAppointmentauthority() {
		return appointmentauthority;
	}

	public void setAppointmentauthority(String appointmentauthority) {
		this.appointmentauthority = appointmentauthority;
	}

	public String getAppointmentfileNo() {
		return appointmentfileNo;
	}

	public void setAppointmentfileNo(String appointmentfileNo) {
		this.appointmentfileNo = appointmentfileNo;
	}

	public String getSys_subservicephasemasterid() {
		return sys_subservicephasemasterid;
	}

	public void setSys_subservicephasemasterid(
			String sys_subservicephasemasterid) {
		this.sys_subservicephasemasterid = sys_subservicephasemasterid;
	}

	

	public String getDatejoining() {
		return datejoining;
	}

	public void setDatejoining(String datejoining) {
		this.datejoining = datejoining;
	}

	public String getMas_employmenttypeid() {
		return mas_employmenttypeid;
	}

	public void setMas_employmenttypeid(String mas_employmenttypeid) {
		this.mas_employmenttypeid = mas_employmenttypeid;
	}

	public String getEmploymentsubtype() {
		return employmentsubtype;
	}

	public void setEmploymentsubtype(String employmentsubtype) {
		this.employmentsubtype = employmentsubtype;
	}

	public String getMas_officelevelid() {
		return mas_officelevelid;
	}

	public void setMas_officelevelid(String mas_officelevelid) {
		this.mas_officelevelid = mas_officelevelid;
	}

	public String getRm_officeid() {
		return rm_officeid;
	}

	public void setRm_officeid(String rm_officeid) {
		this.rm_officeid = rm_officeid;
	}

	private Character isdisablefinancial;
	private Character isretired;

	/** appointmentFileDate property */
	private String appointmentfiledate;

	/** appointmentAuthority property */
	private String appointmentauthority;

	/** appointmentFileNo property */
	private String appointmentfileNo;

	/** sys_SubServicePhaseMasterID property */
	private String sys_subservicephasemasterid;

	/** dateJoining property */
	private String datejoining;

	/** pp_DesignationMasterID property */
	private String pp_designationmasterid;

	/** mas_EmploymentSubTypeID property */
	private String masEmploymentsubtypeid;

	/** mas_EmploymentTypeID property */
	private String mas_employmenttypeid;

	public String getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(String masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	/** employmentSubType property */
	private String employmentsubtype;
	private String mas_officelevelid;
	private String rm_officeid;

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;

	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Character getIsdisablefinancial() {
		return isdisablefinancial;
	}

	public void setIsdisablefinancial(Character isdisablefinancial) {
		this.isdisablefinancial = isdisablefinancial;
	}

	public Character getIsretired() {
		return isretired;
	}

	public void setIsretired(Character isretired) {
		this.isretired = isretired;
	}

	public Character getIsfunctioning() {
		return isfunctioning;
	}

	public void setIsfunctioning(Character isfunctioning) {
		this.isfunctioning = isfunctioning;
	}

	public Long getEntryOfficeid() {
		return entryOfficeid;
	}

	public void setEntryOfficeid(Long entryOfficeid) {
		this.entryOfficeid = entryOfficeid;
	}

	public Character getIsloginlocked() {
		return isloginlocked;
	}

	public void setIsloginlocked(Character isloginlocked) {
		this.isloginlocked = isloginlocked;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	private Character isfunctioning;
	private Long entryOfficeid;
	private Character isloginlocked;
	private Date lastLoginDate;
}