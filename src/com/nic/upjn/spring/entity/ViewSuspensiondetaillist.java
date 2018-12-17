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
@Table(name = "VIEW_SUSPENSIONDETAILLIST")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewSuspensiondetaillist.findAll", query = "SELECT v FROM ViewSuspensiondetaillist v"),
		@NamedQuery(name = "ViewSuspensiondetaillist.findByPpEmployeemasterid", query = "SELECT v FROM ViewSuspensiondetaillist v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewSuspensiondetaillist.findByEmployeecode", query = "FROM ViewSuspensiondetaillist WHERE employeecode = ?"),
		@NamedQuery(name = "ViewSuspensiondetaillist.findByEmployeename", query = "SELECT v FROM ViewSuspensiondetaillist v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewSuspensiondetaillist.findByRmOfficeid", query = "FROM ViewSuspensiondetaillist WHERE rmOfficeid = ?"),
		@NamedQuery(name = "ViewSuspensiondetaillist.findByIsfunctioning", query = "SELECT v FROM ViewSuspensiondetaillist v WHERE v.isfunctioning = :isfunctioning"),
		@NamedQuery(name = "ViewSuspensiondetaillist.findByDesignation", query = "SELECT v FROM ViewSuspensiondetaillist v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewSuspensiondetaillist.findByPpSuspensiondetailid", query = "FROM ViewSuspensiondetaillist WHERE ppSuspensiondetailid = ?"),
		@NamedQuery(name = "ViewSuspensiondetaillist.findBySuspensionordno", query = "SELECT v FROM ViewSuspensiondetaillist v WHERE v.suspensionordno = :suspensionordno"),
		@NamedQuery(name = "ViewSuspensiondetaillist.findBySuspensionorddate", query = "SELECT v FROM ViewSuspensiondetaillist v WHERE v.suspensionorddate = :suspensionorddate"),
		@NamedQuery(name = "ViewSuspensiondetaillist.findByOrderauthname", query = "SELECT v FROM ViewSuspensiondetaillist v WHERE v.orderauthname = :orderauthname"),
		@NamedQuery(name = "ViewSuspensiondetaillist.findByEffectivedate", query = "SELECT v FROM ViewSuspensiondetaillist v WHERE v.effectivedate = :effectivedate"),
		@NamedQuery(name = "ViewSuspensiondetaillist.findByOrderauthdesig", query = "SELECT v FROM ViewSuspensiondetaillist v WHERE v.orderauthdesig = :orderauthdesig"),
		@NamedQuery(name = "ViewSuspensiondetaillist.findByReasonforsuspension", query = "SELECT v FROM ViewSuspensiondetaillist v WHERE v.reasonforsuspension = :reasonforsuspension") })
public class ViewSuspensiondetaillist implements Serializable {
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
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Basic(optional = false)
	@Column(name = "ISFUNCTIONING")
	private Character isfunctioning;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "PP_SUSPENSIONDETAILID")
	private long ppSuspensiondetailid;
	@Basic(optional = false)
	@Column(name = "SUSPENSIONORDNO")
	private String suspensionordno;
	@Basic(optional = false)
	@Column(name = "SUSPENSIONORDDATE")
	/*@Temporal(TemporalType.TIMESTAMP)*/
	private Date suspensionorddate;
	@Basic(optional = false)
	@Column(name = "ORDERAUTHNAME")
	private String orderauthname;
	@Basic(optional = false)
	@Column(name = "EFFECTIVEDATE")
	/*@Temporal(TemporalType.TIMESTAMP)*/
	private Date effectivedate;
	@Basic(optional = false)
	@Column(name = "ORDERAUTHDESIG")
	private String orderauthdesig;
	@Column(name = "REASONFORSUSPENSION")
	private String reasonforsuspension;

	public ViewSuspensiondetaillist() {
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

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Character getIsfunctioning() {
		return isfunctioning;
	}

	public void setIsfunctioning(Character isfunctioning) {
		this.isfunctioning = isfunctioning;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getPpSuspensiondetailid() {
		return ppSuspensiondetailid;
	}

	public void setPpSuspensiondetailid(long ppSuspensiondetailid) {
		this.ppSuspensiondetailid = ppSuspensiondetailid;
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

	public String getOrderauthname() {
		return orderauthname;
	}

	public void setOrderauthname(String orderauthname) {
		this.orderauthname = orderauthname;
	}

	public Date getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}

	public String getOrderauthdesig() {
		return orderauthdesig;
	}

	public void setOrderauthdesig(String orderauthdesig) {
		this.orderauthdesig = orderauthdesig;
	}

	public String getReasonforsuspension() {
		return reasonforsuspension;
	}

	public void setReasonforsuspension(String reasonforsuspension) {
		this.reasonforsuspension = reasonforsuspension;
	}

}
