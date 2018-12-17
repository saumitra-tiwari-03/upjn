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
@Table(name = "PP_PERMANENCY_VIEW")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpPermanencyView.findAll", query = "SELECT p FROM PpPermanencyView p"),
		@NamedQuery(name = "PpPermanencyView.findByPpEmployeemasterid", query = "FROM PpPermanencyView WHERE ppEmployeemasterid = ?"),
		@NamedQuery(name = "PpPermanencyView.findByEmployeecode", query = "FROM PpPermanencyView WHERE employeecode = ?"),
		@NamedQuery(name = "PpPermanencyView.findByEmployeename", query = "SELECT p FROM PpPermanencyView p WHERE p.employeename = :employeename"),
		@NamedQuery(name = "PpPermanencyView.findByEmployeedesignation", query = "SELECT p FROM PpPermanencyView p WHERE p.employeedesignation = :employeedesignation"),
		@NamedQuery(name = "PpPermanencyView.findByIspermanent", query = "SELECT p FROM PpPermanencyView p WHERE p.ispermanent = :ispermanent"),
		@NamedQuery(name = "PpPermanencyView.findByPermanentorderno", query = "SELECT p FROM PpPermanencyView p WHERE p.permanentorderno = :permanentorderno"),
		@NamedQuery(name = "PpPermanencyView.findByPermanentorderdate", query = "SELECT p FROM PpPermanencyView p WHERE p.permanentorderdate = :permanentorderdate") })
public class PpPermanencyView implements Serializable {
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
	@Column(name = "EMPLOYEEDESIGNATION")
	private String employeedesignation;
	@Column(name = "ISPERMANENT")
	private Character ispermanent;
	@Column(name = "PERMANENTORDERNO")
	private String permanentorderno;
	@Column(name = "PERMANENTORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date permanentorderdate;

	public PpPermanencyView() {
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

	public String getEmployeedesignation() {
		return employeedesignation;
	}

	public void setEmployeedesignation(String employeedesignation) {
		this.employeedesignation = employeedesignation;
	}

	public Character getIspermanent() {
		return ispermanent;
	}

	public void setIspermanent(Character ispermanent) {
		this.ispermanent = ispermanent;
	}

	public String getPermanentorderno() {
		return permanentorderno;
	}

	public void setPermanentorderno(String permanentorderno) {
		this.permanentorderno = permanentorderno;
	}

	public Date getPermanentorderdate() {
		return permanentorderdate;
	}

	public void setPermanentorderdate(Date permanentorderdate) {
		this.permanentorderdate = permanentorderdate;
	}

}
