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
@Table(name = "VIEW_RM_EMPLOYEELIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewRmEmployeelist.findAll", query = "SELECT v FROM ViewRmEmployeelist v"),
		@NamedQuery(name = "ViewRmEmployeelist.findByPpEmployeemasterid", query = "SELECT v FROM ViewRmEmployeelist v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewRmEmployeelist.findByEmployeename", query = "SELECT v FROM ViewRmEmployeelist v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewRmEmployeelist.findByRmOfficeid", query = "FROM ViewRmEmployeelist WHERE rmOfficeid = ?") })
public class ViewRmEmployeelist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	@Id
	private long ppEmployeemasterid;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;

	public ViewRmEmployeelist() {
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

}
