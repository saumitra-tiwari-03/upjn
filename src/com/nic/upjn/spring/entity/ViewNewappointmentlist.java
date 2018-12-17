/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_NEWAPPOINTMENTLIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewNewappointmentlist.findAll", query = "FROM ViewNewappointmentlist ORDER BY ppEmployeemasterid DESC"),
		@NamedQuery(name = "ViewNewappointmentlist.findByPpEmployeemasterid", query = "SELECT v FROM ViewNewappointmentlist v WHERE v.ppEmployeemasterid = ?"),
		@NamedQuery(name = "ViewNewappointmentlist.findByEmployeecode", query = "SELECT v FROM ViewNewappointmentlist v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewNewappointmentlist.findByEmployeename", query = "SELECT v FROM ViewNewappointmentlist v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewNewappointmentlist.findByDesignation", query = "SELECT v FROM ViewNewappointmentlist v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewNewappointmentlist.findByEmploymenttype", query = "SELECT v FROM ViewNewappointmentlist v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewNewappointmentlist.findByEmploymentsubtype", query = "SELECT v FROM ViewNewappointmentlist v WHERE v.employmentsubtype = :employmentsubtype"),
		@NamedQuery(name = "ViewNewappointmentlist.findByEntryOfficeid", query = "FROM ViewNewappointmentlist WHERE entryOfficeid = ?") })
public class ViewNewappointmentlist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTSUBTYPE")
	private String employmentsubtype;
	@Column(name = "ENTRY_OFFICEID")
	private Long entryOfficeid;

	public ViewNewappointmentlist() {
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

	public String getEmploymentsubtype() {
		return employmentsubtype;
	}

	public void setEmploymentsubtype(String employmentsubtype) {
		this.employmentsubtype = employmentsubtype;
	}

	public Long getEntryOfficeid() {
		return entryOfficeid;
	}

	public void setEntryOfficeid(Long entryOfficeid) {
		this.entryOfficeid = entryOfficeid;
	}

}
