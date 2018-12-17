package com.nic.upjn.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIEW_LISTFORASSIGNREGISTER")
public class ViewListForAssignRegister {

	@Id
	@Column(name = "PP_EMPLOYEEMASTERID")
	private int ppEmployeemasterid;
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "LASTNAME")
	private String lastname;
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Column(name = "EMPLOYEENAME")
	private String employeeName;
	@Column(name = "PP_REGISTERMASTERID")
	private Integer ppRegisterMasterid;
	@Column(name = "PP_SECTIONMASTERID")
	private int ppSectionMasterid;
	
	public int getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}
	public void setPpEmployeemasterid(int ppEmployeemasterid) {
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
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getRmOfficeid() {
		return rmOfficeid;
	}
	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getPpRegisterMasterid() {
		return ppRegisterMasterid;
	}
	public void setPpRegisterMasterid(Integer ppRegisterMasterid) {
		this.ppRegisterMasterid = ppRegisterMasterid;
	}
	public int getPpSectionMasterid() {
		return ppSectionMasterid;
	}
	public void setPpSectionMasterid(int ppSectionMasterid) {
		this.ppSectionMasterid = ppSectionMasterid;
	}
	
	
}
