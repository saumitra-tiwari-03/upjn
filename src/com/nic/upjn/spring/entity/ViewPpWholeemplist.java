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
@Table(name = "VIEW_PP_WHOLEEMPLIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpWholeemplist.findAll", query = "FROM ViewPpWholeemplist "),
		@NamedQuery(name = "ViewPpWholeemplist.findByPpEmployeemasterid", query = "FROM ViewPpWholeemplist WHERE ppEmployeemasterid = ? "),
		@NamedQuery(name = "ViewPpWholeemplist.findByEmployeecode", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPpWholeemplist.findByEmployeename", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPpWholeemplist.findByDesignation", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewPpWholeemplist.findByFathername", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.fathername = :fathername"),
		@NamedQuery(name = "ViewPpWholeemplist.findByDateofbirth", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.dateofbirth = :dateofbirth"),
		@NamedQuery(name = "ViewPpWholeemplist.findByOfficename", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.officename = :officename"),
		@NamedQuery(name = "ViewPpWholeemplist.findByRmOfficeid", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPpWholeemplist.findByPostingOffice", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.postingOffice = :postingOffice"),
		@NamedQuery(name = "ViewPpWholeemplist.findByPostingofficeName", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.postingofficeName = :postingofficeName"),
		@NamedQuery(name = "ViewPpWholeemplist.findByIsfunctioning", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.isfunctioning = :isfunctioning"),
		@NamedQuery(name = "ViewPpWholeemplist.findByIsretired", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.isretired = :isretired"),
		@NamedQuery(name = "ViewPpWholeemplist.findBySectionname", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.sectionname = :sectionname"),
		@NamedQuery(name = "ViewPpWholeemplist.findByPpEmployeepersonaldetailid", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.ppEmployeepersonaldetailid = :ppEmployeepersonaldetailid"),
		@NamedQuery(name = "ViewPpWholeemplist.findByPpEmployeeappointmentdetailid", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.ppEmployeeappointmentdetailid = :ppEmployeeappointmentdetailid"),
		@NamedQuery(name = "ViewPpWholeemplist.findByPpEmployeepaydetailid", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.ppEmployeepaydetailid = :ppEmployeepaydetailid"),
		@NamedQuery(name = "ViewPpWholeemplist.findByPpEmployeedetailid", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.ppEmployeedetailid = :ppEmployeedetailid"),
		@NamedQuery(name = "ViewPpWholeemplist.findByPpPostingdetailid", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.ppPostingdetailid = :ppPostingdetailid"),
		@NamedQuery(name = "ViewPpWholeemplist.findByPpCurrentstatusid", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.ppCurrentstatusid = :ppCurrentstatusid"),
		@NamedQuery(name = "ViewPpWholeemplist.findByCurrentstatus", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.currentstatus = :currentstatus"),
		@NamedQuery(name = "ViewPpWholeemplist.findByOfficefromid", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.officefromid = :officefromid"),
		@NamedQuery(name = "ViewPpWholeemplist.findByOfficefromname", query = "SELECT v FROM ViewPpWholeemplist v WHERE v.officefromname = :officefromname") })
public class ViewPpWholeemplist implements Serializable {
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
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "FATHERNAME")
	private String fathername;
	@Column(name = "DATEOFBIRTH")
	private String dateofbirth;
	@Column(name = "OFFICENAME")
	private String officename;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Column(name = "POSTING_OFFICE")
	private Integer postingOffice;
	@Column(name = "POSTINGOFFICE_NAME")
	private String postingofficeName;
	@Basic(optional = false)
	@Column(name = "ISFUNCTIONING")
	private Character isfunctioning;
	@Basic(optional = false)
	@Column(name = "ISRETIRED")
	private Character isretired;
	@Column(name = "SECTIONNAME")
	private String sectionname;
	@Column(name = "PP_EMPLOYEEPERSONALDETAILID")
	private String ppEmployeepersonaldetailid;
	@Column(name = "PP_EMPLOYEEAPPOINTMENTDETAILID")
	private String ppEmployeeappointmentdetailid;
	@Column(name = "PP_EMPLOYEEPAYDETAILID")
	private String ppEmployeepaydetailid;
	@Column(name = "PP_EMPLOYEEDETAILID")
	private String ppEmployeedetailid;
	@Column(name = "PP_POSTINGDETAILID")
	private String ppPostingdetailid;
	@Column(name = "PP_CURRENTSTATUSID")
	private String ppCurrentstatusid;
	@Column(name = "CURRENTSTATUS")
	private String currentstatus;
	@Column(name = "OFFICEFROMID")
	private Integer officefromid;
	@Column(name = "OFFICEFROMNAME")
	private String officefromname;

	public ViewPpWholeemplist() {
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

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Integer getPostingOffice() {
		return postingOffice;
	}

	public void setPostingOffice(Integer postingOffice) {
		this.postingOffice = postingOffice;
	}

	public String getPostingofficeName() {
		return postingofficeName;
	}

	public void setPostingofficeName(String postingofficeName) {
		this.postingofficeName = postingofficeName;
	}

	public Character getIsfunctioning() {
		return isfunctioning;
	}

	public void setIsfunctioning(Character isfunctioning) {
		this.isfunctioning = isfunctioning;
	}

	public Character getIsretired() {
		return isretired;
	}

	public void setIsretired(Character isretired) {
		this.isretired = isretired;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

	public String getPpEmployeepersonaldetailid() {
		return ppEmployeepersonaldetailid;
	}

	public void setPpEmployeepersonaldetailid(String ppEmployeepersonaldetailid) {
		this.ppEmployeepersonaldetailid = ppEmployeepersonaldetailid;
	}

	public String getPpEmployeeappointmentdetailid() {
		return ppEmployeeappointmentdetailid;
	}

	public void setPpEmployeeappointmentdetailid(String ppEmployeeappointmentdetailid) {
		this.ppEmployeeappointmentdetailid = ppEmployeeappointmentdetailid;
	}

	public String getPpEmployeepaydetailid() {
		return ppEmployeepaydetailid;
	}

	public void setPpEmployeepaydetailid(String ppEmployeepaydetailid) {
		this.ppEmployeepaydetailid = ppEmployeepaydetailid;
	}

	public String getPpEmployeedetailid() {
		return ppEmployeedetailid;
	}

	public void setPpEmployeedetailid(String ppEmployeedetailid) {
		this.ppEmployeedetailid = ppEmployeedetailid;
	}

	public String getPpPostingdetailid() {
		return ppPostingdetailid;
	}

	public void setPpPostingdetailid(String ppPostingdetailid) {
		this.ppPostingdetailid = ppPostingdetailid;
	}

	public String getPpCurrentstatusid() {
		return ppCurrentstatusid;
	}

	public void setPpCurrentstatusid(String ppCurrentstatusid) {
		this.ppCurrentstatusid = ppCurrentstatusid;
	}

	public String getCurrentstatus() {
		return currentstatus;
	}

	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}

	public Integer getOfficefromid() {
		return officefromid;
	}

	public void setOfficefromid(Integer officefromid) {
		this.officefromid = officefromid;
	}

	public String getOfficefromname() {
		return officefromname;
	}

	public void setOfficefromname(String officefromname) {
		this.officefromname = officefromname;
	}

}
