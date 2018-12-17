package com.nic.upjn.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class PensionEmployeeVerificationEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "MIDDLENAME")
	private String middlename;
	@Column(name = "LASTNAME")
	private String lastname;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "FATHERNAME")
	private String fatherName;
	@Column(name = "DATEOFBIRTH")
	// @Temporal(TemporalType.DATE)
	private String dateOfBirth;
	@Column(name = "GPFACNO")
	private String gpfAcNo;
	@Column(name = "JOININGDATE")
	// @Temporal(TemporalType.DATE)
	private String joiningDate;
	@Column(name = "DATEOFRETIREMENT")
	// @Temporal(TemporalType.DATE)
	private String dateOfRetirement;

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

	public String getGpfAcNo() {
		return gpfAcNo;
	}

	public void setGpfAcNo(String gpfAcNo) {
		this.gpfAcNo = gpfAcNo;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
