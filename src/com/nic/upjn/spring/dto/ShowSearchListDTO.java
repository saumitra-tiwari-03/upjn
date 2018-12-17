package com.nic.upjn.spring.dto;

public class ShowSearchListDTO {
	private String employeeCode;
	private String pp_EmployeeMasterID;
	private String firstName;
	private String lastName;
	private String mas_EmploymentSubTypeID;
	private String pp_DesignationMasterID;
	private String sectionname;
	private String sectionID;
	
	
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMas_EmploymentSubTypeID() {
		return mas_EmploymentSubTypeID;
	}
	public void setMas_EmploymentSubTypeID(String mas_EmploymentSubTypeID) {
		this.mas_EmploymentSubTypeID = mas_EmploymentSubTypeID;
	}
	public String getPp_DesignationMasterID() {
		return pp_DesignationMasterID;
	}
	public void setPp_DesignationMasterID(String pp_DesignationMasterID) {
		this.pp_DesignationMasterID = pp_DesignationMasterID;
	}
	public String getPp_EmployeeMasterID() {
		return pp_EmployeeMasterID;
	}
	public void setPp_EmployeeMasterID(String pp_EmployeeMasterID) {
		this.pp_EmployeeMasterID = pp_EmployeeMasterID;
	}
	public String getSectionname() {
		return sectionname;
	}
	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}
	public String getSectionID() {
		return sectionID;
	}
	public void setSectionID(String sectionID) {
		this.sectionID = sectionID;
	}
	
	
	
}
