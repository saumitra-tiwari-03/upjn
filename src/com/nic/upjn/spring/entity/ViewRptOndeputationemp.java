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
@Table(name = "VIEW_RPT_ONDEPUTATIONEMP")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewRptOndeputationemp.findAll", query = "SELECT v FROM ViewRptOndeputationemp v"),
		@NamedQuery(name = "ViewRptOndeputationemp.findByPpEmployeemasterid", query = "SELECT v FROM ViewRptOndeputationemp v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewRptOndeputationemp.findByEmployeecode", query = "SELECT v FROM ViewRptOndeputationemp v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewRptOndeputationemp.findByEmployeename", query = "SELECT v FROM ViewRptOndeputationemp v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewRptOndeputationemp.findByDesignation", query = "SELECT v FROM ViewRptOndeputationemp v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewRptOndeputationemp.findByEmploymenttype", query = "SELECT v FROM ViewRptOndeputationemp v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewRptOndeputationemp.findByEmploymentsubtype", query = "SELECT v FROM ViewRptOndeputationemp v WHERE v.employmentsubtype = :employmentsubtype"),
		@NamedQuery(name = "ViewRptOndeputationemp.findByEffectivedate", query = "SELECT v FROM ViewRptOndeputationemp v WHERE v.effectivedate = :effectivedate"),
		@NamedQuery(name = "ViewRptOndeputationemp.findByTargetoffice", query = "SELECT v FROM ViewRptOndeputationemp v WHERE v.targetoffice = :targetoffice"),
		@NamedQuery(name = "ViewRptOndeputationemp.findByRelieveorderno", query = "SELECT v FROM ViewRptOndeputationemp v WHERE v.relieveorderno = :relieveorderno"),
		@NamedQuery(name = "ViewRptOndeputationemp.findByRelieveorderdate", query = "SELECT v FROM ViewRptOndeputationemp v WHERE v.relieveorderdate = :relieveorderdate"),
		@NamedQuery(name = "ViewRptOndeputationemp.findByDeputationorderno", query = "SELECT v FROM ViewRptOndeputationemp v WHERE v.deputationorderno = :deputationorderno"),
		@NamedQuery(name = "ViewRptOndeputationemp.findByDeputationorderdate", query = "SELECT v FROM ViewRptOndeputationemp v WHERE v.deputationorderdate = :deputationorderdate"),
		@NamedQuery(name = "ViewRptOndeputationemp.findByLastoffice", query = "SELECT v FROM ViewRptOndeputationemp v WHERE v.lastoffice = :lastoffice"),
		@NamedQuery(name = "ViewRptOndeputationemp.findByMasEmploymentsubtypeid", query = "SELECT v FROM ViewRptOndeputationemp v WHERE v.masEmploymentsubtypeid = :masEmploymentsubtypeid") })
public class ViewRptOndeputationemp implements Serializable {
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
	@Column(name = "EFFECTIVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date effectivedate;
	@Column(name = "TARGETOFFICE")
	private String targetoffice;
	@Column(name = "RELIEVEORDERNO")
	private String relieveorderno;
	@Column(name = "RELIEVEORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relieveorderdate;
	@Column(name = "DEPUTATIONORDERNO")
	private String deputationorderno;
	@Column(name = "DEPUTATIONORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deputationorderdate;
	@Basic(optional = false)
	@Column(name = "LASTOFFICE")
	private String lastoffice;
	@Basic(optional = false)
	@Column(name = "MAS_EMPLOYMENTSUBTYPEID")
	private int masEmploymentsubtypeid;
	@Basic(optional = false)
	@Column(name = "DAYSFROMREL")
	private int daysFromRel;

	public ViewRptOndeputationemp() {
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

	public Date getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}

	public String getTargetoffice() {
		return targetoffice;
	}

	public void setTargetoffice(String targetoffice) {
		this.targetoffice = targetoffice;
	}

	public String getRelieveorderno() {
		return relieveorderno;
	}

	public void setRelieveorderno(String relieveorderno) {
		this.relieveorderno = relieveorderno;
	}

	public Date getRelieveorderdate() {
		return relieveorderdate;
	}

	public void setRelieveorderdate(Date relieveorderdate) {
		this.relieveorderdate = relieveorderdate;
	}

	public String getDeputationorderno() {
		return deputationorderno;
	}

	public void setDeputationorderno(String deputationorderno) {
		this.deputationorderno = deputationorderno;
	}

	public Date getDeputationorderdate() {
		return deputationorderdate;
	}

	public void setDeputationorderdate(Date deputationorderdate) {
		this.deputationorderdate = deputationorderdate;
	}

	public String getLastoffice() {
		return lastoffice;
	}

	public void setLastoffice(String lastoffice) {
		this.lastoffice = lastoffice;
	}

	public int getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(int masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public int getDaysFromRel() {
		return daysFromRel;
	}

	public void setDaysFromRel(int daysFromRel) {
		this.daysFromRel = daysFromRel;
	}

	
	
}
