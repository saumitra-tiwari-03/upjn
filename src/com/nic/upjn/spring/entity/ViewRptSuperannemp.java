/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_RPT_SUPERANNEMP")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewRptSuperannemp.findAll", query = "SELECT v FROM ViewRptSuperannemp v"),
		@NamedQuery(name = "ViewRptSuperannemp.findByPpEmployeemasterid", query = "SELECT v FROM ViewRptSuperannemp v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewRptSuperannemp.findByEmployeecode", query = "SELECT v FROM ViewRptSuperannemp v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewRptSuperannemp.findByEmployeename", query = "SELECT v FROM ViewRptSuperannemp v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewRptSuperannemp.findByDesignation", query = "SELECT v FROM ViewRptSuperannemp v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewRptSuperannemp.findByEmploymenttype", query = "SELECT v FROM ViewRptSuperannemp v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewRptSuperannemp.findByEmploymentsubtype", query = "SELECT v FROM ViewRptSuperannemp v WHERE v.employmentsubtype = :employmentsubtype"),
		@NamedQuery(name = "ViewRptSuperannemp.findByRetirementdate", query = "SELECT v FROM ViewRptSuperannemp v WHERE v.retirementdate = :retirementdate"),
		@NamedQuery(name = "ViewRptSuperannemp.findByRetirementage", query = "SELECT v FROM ViewRptSuperannemp v WHERE v.retirementage = :retirementage"),
		@NamedQuery(name = "ViewRptSuperannemp.findByMasEmploymentsubtypeid", query = "SELECT v FROM ViewRptSuperannemp v WHERE v.masEmploymentsubtypeid = :masEmploymentsubtypeid") })
public class ViewRptSuperannemp implements Serializable {
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
	@Column(name = "RETIREMENTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date retirementdate;
	@Column(name = "RETIREMENTAGE")
	private Short retirementage;
	@Basic(optional = false)
	@Column(name = "MAS_EMPLOYMENTSUBTYPEID")
	private int masEmploymentsubtypeid;

	public ViewRptSuperannemp() {
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

	public Date getRetirementdate() {
		return retirementdate;
	}

	public void setRetirementdate(Date retirementdate) {
		this.retirementdate = retirementdate;
	}

	public Short getRetirementage() {
		return retirementage;
	}

	public void setRetirementage(Short retirementage) {
		this.retirementage = retirementage;
	}

	public int getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(int masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

}
