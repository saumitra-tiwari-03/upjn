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
@Table(name = "VIEW_RM_OFFICEADMINLIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewRmOfficeadminlist.findAll", query = "FROM ViewRmOfficeadminlist order by rmRoleid DESC"),
		@NamedQuery(name = "ViewRmOfficeadminlist.findByRmRoleid", query = "SELECT v FROM ViewRmOfficeadminlist v WHERE v.rmRoleid = :rmRoleid"),
		@NamedQuery(name = "ViewRmOfficeadminlist.findByRmOfficeid", query = "FROM ViewRmOfficeadminlist  WHERE rmOfficeid = ? order by employeename desc"),
		@NamedQuery(name = "ViewRmOfficeadminlist.findByOfficename", query = "SELECT v FROM ViewRmOfficeadminlist v WHERE v.officename = :officename"),
		@NamedQuery(name = "ViewRmOfficeadminlist.findByPpEmployeemasterid", query = "SELECT v FROM ViewRmOfficeadminlist v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewRmOfficeadminlist.findByEmployeecode", query = "FROM ViewRmOfficeadminlist WHERE employeecode = ?"),
		@NamedQuery(name = "ViewRmOfficeadminlist.findByEmployeename", query = "SELECT v FROM ViewRmOfficeadminlist v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewRmOfficeadminlist.findByDesignation", query = "SELECT v FROM ViewRmOfficeadminlist v WHERE v.designation = :designation") })
public class ViewRmOfficeadminlist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "RM_ROLEID")
	
	private int rmRoleid;
	@Column(name = "RM_OFFICEID")
    private Integer rmOfficeid;
	@Basic(optional = false)
	@Column(name = "OFFICENAME")
	private String officename;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	@Id
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "DESIGNATION")
	private String designation;

	public ViewRmOfficeadminlist() {
	}

	public int getRmRoleid() {
		return rmRoleid;
	}

	public void setRmRoleid(int rmRoleid) {
		this.rmRoleid = rmRoleid;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
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
	
	public String ToString()
	{
		return(employeename+"  "+employeecode);
	}

}
