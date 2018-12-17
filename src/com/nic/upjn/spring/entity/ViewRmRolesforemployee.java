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
@Table(name = "VIEW_RM_ROLESFOREMPLOYEE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewRmRolesforemployee.findAll", query = "SELECT v FROM ViewRmRolesforemployee v"),
		@NamedQuery(name = "ViewRmRolesforemployee.findByPpEmployeemasterid", query = "SELECT DISTINCT(rmRoleid) FROM ViewRmRolesforemployee WHERE ppEmployeemasterid = ?"),
		@NamedQuery(name = "ViewRmRolesforemployee.findByEmployeename", query = "SELECT v FROM ViewRmRolesforemployee v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewRmRolesforemployee.findByRmOfficeid", query = "SELECT v FROM ViewRmRolesforemployee v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewRmRolesforemployee.findByRmRoleid", query = "SELECT v FROM ViewRmRolesforemployee v WHERE v.rmRoleid = :rmRoleid"),
		@NamedQuery(name = "ViewRmRolesforemployee.findByRolename", query = "SELECT v FROM ViewRmRolesforemployee v WHERE v.rolename = :rolename") })
public class ViewRmRolesforemployee implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Basic(optional = false)
	@Column(name = "RM_ROLEID")
	private int rmRoleid;
	@Column(name = "ROLENAME")
	private String rolename;

	public ViewRmRolesforemployee() {
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
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

	public int getRmRoleid() {
		return rmRoleid;
	}

	public void setRmRoleid(int rmRoleid) {
		this.rmRoleid = rmRoleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
