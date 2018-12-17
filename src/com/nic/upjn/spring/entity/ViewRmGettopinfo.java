/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;

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
@Table(name = "VIEW_RM_GETTOPINFO")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewRmGettopinfo.findAll", query = "SELECT v FROM ViewRmGettopinfo v"),
		@NamedQuery(name = "ViewRmGettopinfo.findByEmployeecode", query = "FROM ViewRmGettopinfo WHERE employeecode = ?"),
		@NamedQuery(name = "ViewRmGettopinfo.findByEmployeename", query = "SELECT v FROM ViewRmGettopinfo v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewRmGettopinfo.findByDesignation", query = "SELECT v FROM ViewRmGettopinfo v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewRmGettopinfo.findByOfficename", query = "SELECT v FROM ViewRmGettopinfo v WHERE v.officename = :officename") })
public class ViewRmGettopinfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "OFFICENAME")
	private String officename;

	public ViewRmGettopinfo() {
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

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

}
