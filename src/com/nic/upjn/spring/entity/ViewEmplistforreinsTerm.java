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
@Table(name = "VIEW_EMPLISTFORREINS_TERM")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewEmplistforreinsTerm.findAll", query = "SELECT v FROM ViewEmplistforreinsTerm v"),
		@NamedQuery(name = "ViewEmplistforreinsTerm.findByPpEmployeemasterid", query = "SELECT v FROM ViewEmplistforreinsTerm v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewEmplistforreinsTerm.findByRmOfficeid", query = "FROM ViewEmplistforreinsTerm WHERE rmOfficeid = ? ORDER BY ppTerminationdetailid DESC"),
		@NamedQuery(name = "ViewEmplistforreinsTerm.findByPpTerminationdetailid", query = " FROM ViewEmplistforreinsTerm WHERE ppTerminationdetailid = ? "),
		@NamedQuery(name = "ViewEmplistforreinsTerm.findByEmployeecode", query = "SELECT v FROM ViewEmplistforreinsTerm v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEmplistforreinsTerm.findByEmployeename", query = "SELECT v FROM ViewEmplistforreinsTerm v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEmplistforreinsTerm.findByDesignation", query = "SELECT v FROM ViewEmplistforreinsTerm v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewEmplistforreinsTerm.findByEmploymenttype", query = "SELECT v FROM ViewEmplistforreinsTerm v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewEmplistforreinsTerm.findByEmploymentsubtype", query = "SELECT v FROM ViewEmplistforreinsTerm v WHERE v.employmentsubtype = :employmentsubtype") })
public class ViewEmplistforreinsTerm implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Basic(optional = false)
	@Column(name = "PP_TERMINATIONDETAILID")
	private long ppTerminationdetailid;
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

	public ViewEmplistforreinsTerm() {
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public long getPpTerminationdetailid() {
		return ppTerminationdetailid;
	}

	public void setPpTerminationdetailid(long ppTerminationdetailid) {
		this.ppTerminationdetailid = ppTerminationdetailid;
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

}
