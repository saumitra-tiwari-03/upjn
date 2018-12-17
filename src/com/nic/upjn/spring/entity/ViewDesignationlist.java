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
@Table(name = "VIEW_DESIGNATIONLIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewDesignationlist.findAll", query = "SELECT v FROM ViewDesignationlist v"),
		@NamedQuery(name = "ViewDesignationlist.findByPpDesignationmasterid", query = "SELECT v FROM ViewDesignationlist v WHERE v.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "ViewDesignationlist.findByDesignation", query = "SELECT v FROM ViewDesignationlist v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewDesignationlist.findByEmploymenttype", query = "SELECT v FROM ViewDesignationlist v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewDesignationlist.findByMasEmploymenttypeid", query = "SELECT v FROM ViewDesignationlist v WHERE v.masEmploymenttypeid = :masEmploymenttypeid"),
		@NamedQuery(name = "ViewDesignationlist.findByEmploymentsubtype", query = "SELECT v FROM ViewDesignationlist v WHERE v.employmentsubtype = :employmentsubtype"),
		@NamedQuery(name = "ViewDesignationlist.findByMasEmploymentsubtypeid", query = "SELECT v FROM ViewDesignationlist v WHERE v.masEmploymentsubtypeid = :masEmploymentsubtypeid") })
public class ViewDesignationlist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Integer ppDesignationmasterid;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;
	@Basic(optional = false)
	@Column(name = "MAS_EMPLOYMENTTYPEID")
	private int masEmploymenttypeid;
	@Column(name = "EMPLOYMENTSUBTYPE")
	private String employmentsubtype;
	@Column(name = "MAS_EMPLOYMENTSUBTYPEID")
	private Integer masEmploymentsubtypeid;

	public ViewDesignationlist() {
	}

	public Integer getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(Integer ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
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

	public int getMasEmploymenttypeid() {
		return masEmploymenttypeid;
	}

	public void setMasEmploymenttypeid(int masEmploymenttypeid) {
		this.masEmploymenttypeid = masEmploymenttypeid;
	}

	public String getEmploymentsubtype() {
		return employmentsubtype;
	}

	public void setEmploymentsubtype(String employmentsubtype) {
		this.employmentsubtype = employmentsubtype;
	}

	public Integer getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(Integer masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

}
