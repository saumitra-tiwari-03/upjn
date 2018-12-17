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
@Table(name = "VIEW_EMPINFOFORREINS_SUSP")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewEmpinfoforreinsSusp.findAll", query = "SELECT v FROM ViewEmpinfoforreinsSusp v"),
		@NamedQuery(name = "ViewEmpinfoforreinsSusp.findByPpSuspensiondetailid", query = "FROM ViewEmpinfoforreinsSusp WHERE ppSuspensiondetailid = ?"),
		@NamedQuery(name = "ViewEmpinfoforreinsSusp.findByEmployeecode", query = "FROM ViewEmpinfoforreinsSusp WHERE employeecode = ?"),
		@NamedQuery(name = "ViewEmpinfoforreinsSusp.findByPpEmployeemasterid", query = "FROM ViewEmpinfoforreinsSusp WHERE ppEmployeemasterid = ?"),
		@NamedQuery(name = "ViewEmpinfoforreinsSusp.findByEmployeename", query = "SELECT v FROM ViewEmpinfoforreinsSusp v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEmpinfoforreinsSusp.findByDesignation", query = "SELECT v FROM ViewEmpinfoforreinsSusp v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewEmpinfoforreinsSusp.findBySuspensionordno", query = "SELECT v FROM ViewEmpinfoforreinsSusp v WHERE v.suspensionordno = :suspensionordno"),
		@NamedQuery(name = "ViewEmpinfoforreinsSusp.findBySuspensionorddate", query = "SELECT v FROM ViewEmpinfoforreinsSusp v WHERE v.suspensionorddate = :suspensionorddate"),
		@NamedQuery(name = "ViewEmpinfoforreinsSusp.findByEffectivedate", query = "SELECT v FROM ViewEmpinfoforreinsSusp v WHERE v.effectivedate = :effectivedate"),
		@NamedQuery(name = "ViewEmpinfoforreinsSusp.findByOrderauthname", query = "SELECT v FROM ViewEmpinfoforreinsSusp v WHERE v.orderauthname = :orderauthname"),
		@NamedQuery(name = "ViewEmpinfoforreinsSusp.findByOrderauthdesig", query = "SELECT v FROM ViewEmpinfoforreinsSusp v WHERE v.orderauthdesig = :orderauthdesig") })
public class ViewEmpinfoforreinsSusp implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_SUSPENSIONDETAILID")
	private long ppSuspensiondetailid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "SUSPENSIONORDNO")
	private String suspensionordno;
	@Basic(optional = false)
	@Column(name = "SUSPENSIONORDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date suspensionorddate;
	@Basic(optional = false)
	@Column(name = "EFFECTIVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date effectivedate;
	@Basic(optional = false)
	@Column(name = "ORDERAUTHNAME")
	private String orderauthname;
	@Basic(optional = false)
	@Column(name = "ORDERAUTHDESIG")
	private String orderauthdesig;

	public ViewEmpinfoforreinsSusp() {
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSuspensionordno() {
		return suspensionordno;
	}

	public void setSuspensionordno(String suspensionordno) {
		this.suspensionordno = suspensionordno;
	}

	public Date getSuspensionorddate() {
		return suspensionorddate;
	}

	public void setSuspensionorddate(Date suspensionorddate) {
		this.suspensionorddate = suspensionorddate;
	}

	public Date getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}

	public String getOrderauthname() {
		return orderauthname;
	}

	public void setOrderauthname(String orderauthname) {
		this.orderauthname = orderauthname;
	}

	public String getOrderauthdesig() {
		return orderauthdesig;
	}

	public void setOrderauthdesig(String orderauthdesig) {
		this.orderauthdesig = orderauthdesig;
	}

}
