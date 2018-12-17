package com.nic.upjn.spring.dto;

import java.io.Serializable;

public class DesignationMasterDTO implements Serializable {

	protected String pp_DesignationMasterID;

	/** designation property */
	protected String designation;

	/** employmentSubType property */
	protected String employmentSubType;

	/** employmentType property */
	protected String employmentType;

	/** mas_EmploymentSubTypeID property */
	protected String mas_EmploymentSubTypeID;

	/** mas_EmploymentTypeID property */
	protected String mas_EmploymentTypeID;

	public String getPp_DesignationMasterID() {
		return pp_DesignationMasterID;
	}

	public void setPp_DesignationMasterID(String pp_DesignationMasterID) {
		this.pp_DesignationMasterID = pp_DesignationMasterID;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmploymentSubType() {
		return employmentSubType;
	}

	public void setEmploymentSubType(String employmentSubType) {
		this.employmentSubType = employmentSubType;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getMas_EmploymentSubTypeID() {
		return mas_EmploymentSubTypeID;
	}

	public void setMas_EmploymentSubTypeID(String mas_EmploymentSubTypeID) {
		this.mas_EmploymentSubTypeID = mas_EmploymentSubTypeID;
	}

	public String getMas_EmploymentTypeID() {
		return mas_EmploymentTypeID;
	}

	public void setMas_EmploymentTypeID(String mas_EmploymentTypeID) {
		this.mas_EmploymentTypeID = mas_EmploymentTypeID;
	}

}
