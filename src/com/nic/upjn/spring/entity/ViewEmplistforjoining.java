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
@Table(name = "VIEW_EMPLISTFORJOINING")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewEmplistforjoining.findAll", query = "SELECT v FROM ViewEmplistforjoining v"),
		@NamedQuery(name = "ViewEmplistforjoining.findByPpEmployeemasterid", query = "SELECT v FROM ViewEmplistforjoining v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewEmplistforjoining.findByEmployeecode", query = "SELECT v FROM ViewEmplistforjoining v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEmplistforjoining.findByEmployeename", query = "SELECT v FROM ViewEmplistforjoining v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEmplistforjoining.findByRmOfficeid", query = "FROM ViewEmplistforjoining WHERE rmOfficeid = ? ORDER BY ppPostingdetailid DESC"),
		@NamedQuery(name = "ViewEmplistforjoining.findByEmploymenttype", query = "SELECT v FROM ViewEmplistforjoining v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewEmplistforjoining.findByEmploymentsubtype", query = "SELECT v FROM ViewEmplistforjoining v WHERE v.employmentsubtype = :employmentsubtype"),
		@NamedQuery(name = "ViewEmplistforjoining.findByDesignation", query = "SELECT v FROM ViewEmplistforjoining v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewEmplistforjoining.findByPpPostingdetailid", query = "SELECT v FROM ViewEmplistforjoining v WHERE v.ppPostingdetailid = :ppPostingdetailid"),
		@NamedQuery(name = "ViewEmplistforjoining.findByJoiningagainst", query = "SELECT v FROM ViewEmplistforjoining v WHERE v.joiningagainst = :joiningagainst"),
		@NamedQuery(name = "ViewEmplistforjoining.findByFlagid", query = "SELECT v FROM ViewEmplistforjoining v WHERE v.flagid = :flagid") })
public class ViewEmplistforjoining implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Id
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTSUBTYPE")
	private String employmentsubtype;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "PP_POSTINGDETAILID")
	private long ppPostingdetailid;
	@Basic(optional = false)
	@Column(name = "JOININGAGAINST")
	private String joiningagainst;
	@Column(name = "FLAGID")
	private String flagid;

	public ViewEmplistforjoining() {
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

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getPpPostingdetailid() {
		return ppPostingdetailid;
	}

	public void setPpPostingdetailid(long ppPostingdetailid) {
		this.ppPostingdetailid = ppPostingdetailid;
	}

	public String getJoiningagainst() {
		return joiningagainst;
	}

	public void setJoiningagainst(String joiningagainst) {
		this.joiningagainst = joiningagainst;
	}

	public String getFlagid() {
		return flagid;
	}

	public void setFlagid(String flagid) {
		this.flagid = flagid;
	}

}
