package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VIEW_RETEMPREPORT")
public class ViewRetEmpReport implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Basic(optional = false)
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Basic(optional = false)
	@Column(name = "LASTNAME")
	private String lastname;
	@Basic(optional = false)
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Id
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Short ppemployeemasterid;
	@Basic(optional = false)
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RELIEVEORDDATE")
	private String relieveorderdate;
	@Basic(optional = false)
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATEOFEFFECT")
	private String dateofeffect;
	@Basic(optional = false)
	@Column(name = "SUBPHASENAME")
	private String  subphasename;
	@Basic(optional = false)
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "OFFICENAME")
	private String officename;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private Short rmofficeid;
	@Basic(optional = false)
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Short ppdesignationmasterid;
	
	
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
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public Short getPpemployeemasterid() {
		return ppemployeemasterid;
	}
	public void setPpemployeemasterid(Short ppemployeemasterid) {
		this.ppemployeemasterid = ppemployeemasterid;
	}

	public String getRelieveorderdate() {
		return relieveorderdate;
	}
	public void setRelieveorderdate(String relieveorderdate) {
		this.relieveorderdate = relieveorderdate;
	}
	public String getDateofeffect() {
		return dateofeffect;
	}
	public void setDateofeffect(String dateofeffect) {
		this.dateofeffect = dateofeffect;
	}
	public String getSubphasename() {
		return subphasename;
	}
	public void setSubphasename(String subphasename) {
		this.subphasename = subphasename;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getOfficename() {
		return officename;
	}
	public void setOfficename(String officename) {
		this.officename = officename;
	}
	public Short getRmofficeid() {
		return rmofficeid;
	}
	public void setRmofficeid(Short rmofficeid) {
		this.rmofficeid = rmofficeid;
	}
	public Short getPpdesignationmasterid() {
		return ppdesignationmasterid;
	}
	public void setPpdesignationmasterid(Short ppdesignationmasterid) {
		this.ppdesignationmasterid = ppdesignationmasterid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}

