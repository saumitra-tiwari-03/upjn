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
@Table(name = "VIEW_EMPLISTFORREINS_SUSP")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewEmplistforreinsSusp.findAll", query = "SELECT v FROM ViewEmplistforreinsSusp v"),
		@NamedQuery(name = "ViewEmplistforreinsSusp.findByPpEmployeemasterid", query = "FROM ViewEmplistforreinsSusp WHERE ppEmployeemasterid = ?"),
		@NamedQuery(name = "ViewEmplistforreinsSusp.findByRmOfficeid", query = "FROM ViewEmplistforreinsSusp WHERE rmOfficeid = ?"),
		@NamedQuery(name = "ViewEmplistforreinsSusp.findByPpSuspensiondetailid", query = "SELECT v FROM ViewEmplistforreinsSusp v WHERE v.ppSuspensiondetailid = :ppSuspensiondetailid"),
		@NamedQuery(name = "ViewEmplistforreinsSusp.findByEmployeecode", query = "SELECT v FROM ViewEmplistforreinsSusp v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEmplistforreinsSusp.findByEmployeename", query = "SELECT v FROM ViewEmplistforreinsSusp v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEmplistforreinsSusp.findByDesignation", query = "SELECT v FROM ViewEmplistforreinsSusp v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewEmplistforreinsSusp.findByCurrentposting", query = "SELECT v FROM ViewEmplistforreinsSusp v WHERE v.currentposting = :currentposting"),
		@NamedQuery(name = "ViewEmplistforreinsSusp.findByEmploymenttype", query = "SELECT v FROM ViewEmplistforreinsSusp v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewEmplistforreinsSusp.findByEmploymentsubtype", query = "SELECT v FROM ViewEmplistforreinsSusp v WHERE v.employmentsubtype = :employmentsubtype") })
public class ViewEmplistforreinsSusp implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Basic(optional = false)
	@Column(name = "PP_SUSPENSIONDETAILID")
	private long ppSuspensiondetailid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "CURRENTPOSTING")
	private String currentposting;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTSUBTYPE")
	private String employmentsubtype;

	public ViewEmplistforreinsSusp() {
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

	public long getPpSuspensiondetailid() {
		return ppSuspensiondetailid;
	}

	public void setPpSuspensiondetailid(long ppSuspensiondetailid) {
		this.ppSuspensiondetailid = ppSuspensiondetailid;
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

	public String getCurrentposting() {
		return currentposting;
	}

	public void setCurrentposting(String currentposting) {
		this.currentposting = currentposting;
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
