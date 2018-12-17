package com.nic.upjn.spring.dto;

import java.util.Date; 

public class PensionEmployeeVerificationDTO {
	private long ppEmployeemasterid;
	private String employeecode;
	private String firstname;
	private String middlename;
	private String lastname;
	private String designation;
	private String fatherName;
	private String dateOfBirth;
	private String gpfAcNo;
	private String joiningDate;
	private String dateOfRetirement;
	private Character isdisablefinancial;
	private Character isretired;
	private Character isfunctioning;
	private Character isloginlocked;
	private Integer IS_REG_FORPENSION;
	private String password;
	private Integer ppDesignationmasterid;
	private Long entryOfficeid;
	private Date lastLoginDate;
	private String masEmploymentsubtypeid;
	private Integer RM_OFFICEID;

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

	public Character getIsloginlocked() {
		return isloginlocked;
	}

	public void setIsloginlocked(Character isloginlocked) {
		this.isloginlocked = isloginlocked;
	}

	public Integer getIS_REG_FORPENSION() {
		return IS_REG_FORPENSION;
	}

	public void setIS_REG_FORPENSION(Integer iS_REG_FORPENSION) {
		IS_REG_FORPENSION = iS_REG_FORPENSION;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(Integer ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public Long getEntryOfficeid() {
		return entryOfficeid;
	}

	public void setEntryOfficeid(Long entryOfficeid) {
		this.entryOfficeid = entryOfficeid;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(String masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public Integer getRM_OFFICEID() {
		return RM_OFFICEID;
	}

	public void setRM_OFFICEID(Integer rM_OFFICEID) {
		RM_OFFICEID = rM_OFFICEID;
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGpfAcNo() {
		return gpfAcNo;
	}

	public void setGpfAcNo(String gpfAcNo) {
		this.gpfAcNo = gpfAcNo;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getDateOfRetirement() {
		return dateOfRetirement;
	}

	public void setDateOfRetirement(String dateOfRetirement) {
		this.dateOfRetirement = dateOfRetirement;
	}
}
