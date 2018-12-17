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
@Table(name = "VIEW_DEPUTATIONLIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewDeputationlist.findAll", query = "SELECT v FROM ViewDeputationlist v"),
		@NamedQuery(name = "ViewDeputationlist.findByPpEmployeemasterid", query = "SELECT v FROM ViewDeputationlist v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewDeputationlist.findByEmployeecode", query = "FROM ViewDeputationlist WHERE employeecode = ?"),
		@NamedQuery(name = "ViewDeputationlist.findByEmployeename", query = "SELECT v FROM ViewDeputationlist v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewDeputationlist.findByRmOfficeid", query = "FROM ViewDeputationlist WHERE rmOfficeid = ?"),
		@NamedQuery(name = "ViewDeputationlist.findByDesignation", query = "SELECT v FROM ViewDeputationlist v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewDeputationlist.findByPpDesignationmasterid", query = "SELECT v FROM ViewDeputationlist v WHERE v.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "ViewDeputationlist.findByGpfacno", query = "SELECT v FROM ViewDeputationlist v WHERE v.gpfacno = :gpfacno"),
		@NamedQuery(name = "ViewDeputationlist.findByPpDeputationdetailid", query = "FROM ViewDeputationlist WHERE ppDeputationdetailid = ?"),
		@NamedQuery(name = "ViewDeputationlist.findByDeputationorderno", query = "SELECT v FROM ViewDeputationlist v WHERE v.deputationorderno = :deputationorderno"),
		@NamedQuery(name = "ViewDeputationlist.findByDeputationorderdate", query = "SELECT v FROM ViewDeputationlist v WHERE v.deputationorderdate = :deputationorderdate"),
		@NamedQuery(name = "ViewDeputationlist.findByTargetoffice", query = "SELECT v FROM ViewDeputationlist v WHERE v.targetoffice = :targetoffice"),
		@NamedQuery(name = "ViewDeputationlist.findByRelieveorderno", query = "SELECT v FROM ViewDeputationlist v WHERE v.relieveorderno = :relieveorderno"),
		@NamedQuery(name = "ViewDeputationlist.findByRelieveorderdate", query = "SELECT v FROM ViewDeputationlist v WHERE v.relieveorderdate = :relieveorderdate"),
		@NamedQuery(name = "ViewDeputationlist.findByRelievedate", query = "SELECT v FROM ViewDeputationlist v WHERE v.relievedate = :relievedate"),
		@NamedQuery(name = "ViewDeputationlist.findByRelieveanfn", query = "SELECT v FROM ViewDeputationlist v WHERE v.relieveanfn = :relieveanfn"),
		@NamedQuery(name = "ViewDeputationlist.findByPpNoduesdetailid", query = "SELECT v FROM ViewDeputationlist v WHERE v.ppNoduesdetailid = :ppNoduesdetailid"),
		@NamedQuery(name = "ViewDeputationlist.findByOfficefromid", query = "SELECT v FROM ViewDeputationlist v WHERE v.officefromid = :officefromid"),
		@NamedQuery(name = "ViewDeputationlist.findByFromofficename", query = "SELECT v FROM ViewDeputationlist v WHERE v.fromofficename = :fromofficename") })
public class ViewDeputationlist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Integer ppDesignationmasterid;
	@Column(name = "GPFACNO")
	private String gpfacno;
	@Basic(optional = false)
	@Column(name = "PP_DEPUTATIONDETAILID")
	private long ppDeputationdetailid;
	@Column(name = "DEPUTATIONORDERNO")
	private String deputationorderno;
	@Column(name = "DEPUTATIONORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deputationorderdate;
	@Column(name = "TARGETOFFICE")
	private String targetoffice;
	@Column(name = "RELIEVEORDERNO")
	private String relieveorderno;
	@Column(name = "RELIEVEORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relieveorderdate;
	@Column(name = "RELIEVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relievedate;
	@Column(name = "RELIEVEANFN")
	private String relieveanfn;
	@Column(name = "PP_NODUESDETAILID")
	private Long ppNoduesdetailid;
	@Column(name = "OFFICEFROMID")
	private Integer officefromid;
	@Basic(optional = false)
	@Column(name = "FROMOFFICENAME")
	private String fromofficename;

	public ViewDeputationlist() {
	}

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

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(Integer ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public String getGpfacno() {
		return gpfacno;
	}

	public void setGpfacno(String gpfacno) {
		this.gpfacno = gpfacno;
	}

	public long getPpDeputationdetailid() {
		return ppDeputationdetailid;
	}

	public void setPpDeputationdetailid(long ppDeputationdetailid) {
		this.ppDeputationdetailid = ppDeputationdetailid;
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

	public Date getRelievedate() {
		return relievedate;
	}

	public void setRelievedate(Date relievedate) {
		this.relievedate = relievedate;
	}

	public String getRelieveanfn() {
		return relieveanfn;
	}

	public void setRelieveanfn(String relieveanfn) {
		this.relieveanfn = relieveanfn;
	}

	public Long getPpNoduesdetailid() {
		return ppNoduesdetailid;
	}

	public void setPpNoduesdetailid(Long ppNoduesdetailid) {
		this.ppNoduesdetailid = ppNoduesdetailid;
	}

	public Integer getOfficefromid() {
		return officefromid;
	}

	public void setOfficefromid(Integer officefromid) {
		this.officefromid = officefromid;
	}

	public String getFromofficename() {
		return fromofficename;
	}

	public void setFromofficename(String fromofficename) {
		this.fromofficename = fromofficename;
	}

}
