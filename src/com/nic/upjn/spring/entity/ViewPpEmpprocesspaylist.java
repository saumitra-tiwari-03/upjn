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
@Table(name = "VIEW_PP_EMPPROCESSPAYLIST")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findAll", query = "SELECT v FROM ViewPpEmpprocesspaylist v"),
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpEmpprocesspaylist v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findByEmployeename", query = "SELECT v FROM ViewPpEmpprocesspaylist v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findByEmployeecode", query = "SELECT v FROM ViewPpEmpprocesspaylist v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findByDesignation", query = "SELECT v FROM ViewPpEmpprocesspaylist v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findByRmOfficeid", query = "SELECT v FROM ViewPpEmpprocesspaylist v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findByPpPlacemasterid", query = "SELECT v FROM ViewPpEmpprocesspaylist v WHERE v.ppPlacemasterid = :ppPlacemasterid"),
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findByIsretired", query = "SELECT v FROM ViewPpEmpprocesspaylist v WHERE v.isretired = :isretired"),
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findBySysPaycategoryid", query = "SELECT v FROM ViewPpEmpprocesspaylist v WHERE v.sysPaycategoryid = :sysPaycategoryid"),
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findByPpRegistermasterid", query = "SELECT v FROM ViewPpEmpprocesspaylist v WHERE v.ppRegistermasterid = :ppRegistermasterid"),
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findBySalarypercent", query = "SELECT v FROM ViewPpEmpprocesspaylist v WHERE v.salarypercent = :salarypercent"),
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findByNoofdays", query = "SELECT v FROM ViewPpEmpprocesspaylist v WHERE v.noofdays = :noofdays"),
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findByHratowncategoryid", query = "SELECT v FROM ViewPpEmpprocesspaylist v WHERE v.hratowncategoryid = :hratowncategoryid"),
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findByCcatowncategoryid", query = "SELECT v FROM ViewPpEmpprocesspaylist v WHERE v.ccatowncategoryid = :ccatowncategoryid"),
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findByAppointmentfiledate", query = "SELECT v FROM ViewPpEmpprocesspaylist v WHERE v.appointmentfiledate = :appointmentfiledate"),
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findByMasEmploymentsubtypeid", query = "SELECT v FROM ViewPpEmpprocesspaylist v WHERE v.masEmploymentsubtypeid = :masEmploymentsubtypeid"),
		@NamedQuery(name = "ViewPpEmpprocesspaylist.findByIsfunctioning", query = "SELECT v FROM ViewPpEmpprocesspaylist v WHERE v.isfunctioning = :isfunctioning") })
public class ViewPpEmpprocesspaylist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Column(name = "PP_PLACEMASTERID")
	private Long ppPlacemasterid;
	@Basic(optional = false)
	@Column(name = "ISRETIRED")
	private Character isretired;
	@Column(name = "SYS_PAYCATEGORYID")
	private Short sysPaycategoryid;
	@Column(name = "PP_REGISTERMASTERID")
	private Short ppRegistermasterid;
	@Column(name = "SALARYPERCENT")
	private String salarypercent;
	@Column(name = "NOOFDAYS")
	private String noofdays;
	@Column(name = "HRATOWNCATEGORYID")
	private String hratowncategoryid;
	@Column(name = "CCATOWNCATEGORYID")
	private String ccatowncategoryid;
	@Column(name = "APPOINTMENTFILEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date appointmentfiledate;
	@Basic(optional = false)
	@Column(name = "MAS_EMPLOYMENTSUBTYPEID")
	private int masEmploymentsubtypeid;
	@Basic(optional = false)
	@Column(name = "ISFUNCTIONING")
	private Character isfunctioning;

	public ViewPpEmpprocesspaylist() {
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

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Long getPpPlacemasterid() {
		return ppPlacemasterid;
	}

	public void setPpPlacemasterid(Long ppPlacemasterid) {
		this.ppPlacemasterid = ppPlacemasterid;
	}

	public Character getIsretired() {
		return isretired;
	}

	public void setIsretired(Character isretired) {
		this.isretired = isretired;
	}

	public Short getSysPaycategoryid() {
		return sysPaycategoryid;
	}

	public void setSysPaycategoryid(Short sysPaycategoryid) {
		this.sysPaycategoryid = sysPaycategoryid;
	}

	public Short getPpRegistermasterid() {
		return ppRegistermasterid;
	}

	public void setPpRegistermasterid(Short ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public String getSalarypercent() {
		return salarypercent;
	}

	public void setSalarypercent(String salarypercent) {
		this.salarypercent = salarypercent;
	}

	public String getNoofdays() {
		return noofdays;
	}

	public void setNoofdays(String noofdays) {
		this.noofdays = noofdays;
	}

	public String getHratowncategoryid() {
		return hratowncategoryid;
	}

	public void setHratowncategoryid(String hratowncategoryid) {
		this.hratowncategoryid = hratowncategoryid;
	}

	public String getCcatowncategoryid() {
		return ccatowncategoryid;
	}

	public void setCcatowncategoryid(String ccatowncategoryid) {
		this.ccatowncategoryid = ccatowncategoryid;
	}

	public Date getAppointmentfiledate() {
		return appointmentfiledate;
	}

	public void setAppointmentfiledate(Date appointmentfiledate) {
		this.appointmentfiledate = appointmentfiledate;
	}

	public int getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(int masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public Character getIsfunctioning() {
		return isfunctioning;
	}

	public void setIsfunctioning(Character isfunctioning) {
		this.isfunctioning = isfunctioning;
	}

}
