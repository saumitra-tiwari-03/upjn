/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "VIEW_PP_EMPLOYEECONFIRMATION")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewPpEmployeeconfirmation.findAll", query = "SELECT v FROM ViewPpEmployeeconfirmation v"),
		@NamedQuery(name = "ViewPpEmployeeconfirmation.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpEmployeeconfirmation v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpEmployeeconfirmation.findByEmployeecode", query = "SELECT v FROM ViewPpEmployeeconfirmation v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPpEmployeeconfirmation.findByEmployeename", query = "SELECT v FROM ViewPpEmployeeconfirmation v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPpEmployeeconfirmation.findByDesignation", query = "SELECT v FROM ViewPpEmployeeconfirmation v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewPpEmployeeconfirmation.findByIsconfirm", query = "SELECT v FROM ViewPpEmployeeconfirmation v WHERE v.isconfirm = :isconfirm"),
		@NamedQuery(name = "ViewPpEmployeeconfirmation.findByConfirmorderno", query = "SELECT v FROM ViewPpEmployeeconfirmation v WHERE v.confirmorderno = :confirmorderno"),
		@NamedQuery(name = "ViewPpEmployeeconfirmation.findByConfirmorderdate", query = "SELECT v FROM ViewPpEmployeeconfirmation v WHERE v.confirmorderdate = :confirmorderdate"),
		@NamedQuery(name = "ViewPpEmployeeconfirmation.findByConfirmeffectivedate", query = "SELECT v FROM ViewPpEmployeeconfirmation v WHERE v.confirmeffectivedate = :confirmeffectivedate") })
public class ViewPpEmployeeconfirmation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "ISCONFIRM")
	private Character isconfirm;
	@Column(name = "CONFIRMORDERNO")
	private String confirmorderno;
	@Column(name = "CONFIRMORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date confirmorderdate;
	@Column(name = "CONFIRMEFFECTIVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date confirmeffectivedate;

	public ViewPpEmployeeconfirmation() {
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

	public Character getIsconfirm() {
		return isconfirm;
	}

	public void setIsconfirm(Character isconfirm) {
		this.isconfirm = isconfirm;
	}

	public String getConfirmorderno() {
		return confirmorderno;
	}

	public void setConfirmorderno(String confirmorderno) {
		this.confirmorderno = confirmorderno;
	}

	public Date getConfirmorderdate() {
		return confirmorderdate;
	}

	public void setConfirmorderdate(Date confirmorderdate) {
		this.confirmorderdate = confirmorderdate;
	}

	public Date getConfirmeffectivedate() {
		return confirmeffectivedate;
	}

	public void setConfirmeffectivedate(Date confirmeffectivedate) {
		this.confirmeffectivedate = confirmeffectivedate;
	}

}
