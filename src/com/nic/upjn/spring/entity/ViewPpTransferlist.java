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
@Table(name = "VIEW_PP_TRANSFERLIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpTransferlist.findAll", query = "SELECT v FROM ViewPpTransferlist v"),
		@NamedQuery(name = "ViewPpTransferlist.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpTransferlist v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpTransferlist.findByEmployeecode", query = "SELECT v FROM ViewPpTransferlist v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPpTransferlist.findByEmployeename", query = "SELECT v FROM ViewPpTransferlist v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPpTransferlist.findByRmOfficeid", query = "FROM ViewPpTransferlist WHERE rmOfficeid = ?"),
		@NamedQuery(name = "ViewPpTransferlist.findByDesignation", query = "SELECT v FROM ViewPpTransferlist v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewPpTransferlist.findByPpDesignationmasterid", query = "SELECT v FROM ViewPpTransferlist v WHERE v.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "ViewPpTransferlist.findByGpfacno", query = "SELECT v FROM ViewPpTransferlist v WHERE v.gpfacno = :gpfacno"),
		@NamedQuery(name = "ViewPpTransferlist.findByPpTransferdetailid", query = "FROM ViewPpTransferlist WHERE ppTransferdetailid = ?"),
		@NamedQuery(name = "ViewPpTransferlist.findByTransferorderno", query = "SELECT v FROM ViewPpTransferlist v WHERE v.transferorderno = :transferorderno"),
		@NamedQuery(name = "ViewPpTransferlist.findByTransferorderdate", query = "SELECT v FROM ViewPpTransferlist v WHERE v.transferorderdate = :transferorderdate"),
		@NamedQuery(name = "ViewPpTransferlist.findByOfficefromid", query = "FROM ViewPpTransferlist  WHERE officefromid = ? ORDER BY ppTransferdetailid DESC"),
		@NamedQuery(name = "ViewPpTransferlist.findByOfficetoid", query = "SELECT v FROM ViewPpTransferlist v WHERE v.officetoid = :officetoid"),
		@NamedQuery(name = "ViewPpTransferlist.findByRelieveorderno", query = "SELECT v FROM ViewPpTransferlist v WHERE v.relieveorderno = :relieveorderno"),
		@NamedQuery(name = "ViewPpTransferlist.findByRelieveorderdate", query = "SELECT v FROM ViewPpTransferlist v WHERE v.relieveorderdate = :relieveorderdate"),
		@NamedQuery(name = "ViewPpTransferlist.findByRelievedate", query = "SELECT v FROM ViewPpTransferlist v WHERE v.relievedate = :relievedate"),
		@NamedQuery(name = "ViewPpTransferlist.findByRelieveanfn", query = "SELECT v FROM ViewPpTransferlist v WHERE v.relieveanfn = :relieveanfn"),
		@NamedQuery(name = "ViewPpTransferlist.findByPpNoduesdetailid", query = "SELECT v FROM ViewPpTransferlist v WHERE v.ppNoduesdetailid = :ppNoduesdetailid"),
		@NamedQuery(name = "ViewPpTransferlist.findByMasOfficelevelid", query = "SELECT v FROM ViewPpTransferlist v WHERE v.masOfficelevelid = :masOfficelevelid") })
public class ViewPpTransferlist implements Serializable {
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
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Integer ppDesignationmasterid;
	@Column(name = "GPFACNO")
	private String gpfacno;
	@Basic(optional = false)
	@Column(name = "PP_TRANSFERDETAILID")
	private long ppTransferdetailid;
	@Basic(optional = false)
	@Column(name = "TRANSFERORDERNO")
	private String transferorderno;
	@Basic(optional = false)
	@Column(name = "TRANSFERORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transferorderdate;
	@Basic(optional = false)
	@Column(name = "OFFICEFROMID")
	private int officefromid;
	@Basic(optional = false)
	@Column(name = "OFFICETOID")
	private int officetoid;
	@Basic(optional = false)
	@Column(name = "RELIEVEORDERNO")
	private String relieveorderno;
	@Basic(optional = false)
	@Column(name = "RELIEVEORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relieveorderdate;
	@Basic(optional = false)
	@Column(name = "RELIEVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relievedate;
	@Basic(optional = false)
	@Column(name = "RELIEVEANFN")
	private String relieveanfn;
	@Basic(optional = false)
	@Column(name = "PP_NODUESDETAILID")
	private long ppNoduesdetailid;
	@Basic(optional = false)
	@Column(name = "MAS_OFFICELEVELID")
	private short masOfficelevelid;
	

	public ViewPpTransferlist() {
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(Integer ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public String getGpfacno() {
		return gpfacno;
	}

	public void setGpfacno(String gpfacno) {
		this.gpfacno = gpfacno;
	}

	public long getPpTransferdetailid() {
		return ppTransferdetailid;
	}

	public void setPpTransferdetailid(long ppTransferdetailid) {
		this.ppTransferdetailid = ppTransferdetailid;
	}

	public String getTransferorderno() {
		return transferorderno;
	}

	public void setTransferorderno(String transferorderno) {
		this.transferorderno = transferorderno;
	}

	public Date getTransferorderdate() {
		return transferorderdate;
	}

	public void setTransferorderdate(Date transferorderdate) {
		this.transferorderdate = transferorderdate;
	}

	public int getOfficefromid() {
		return officefromid;
	}

	public void setOfficefromid(int officefromid) {
		this.officefromid = officefromid;
	}

	public int getOfficetoid() {
		return officetoid;
	}

	public void setOfficetoid(int officetoid) {
		this.officetoid = officetoid;
	}

	public String getRelieveorderno() {
		return relieveorderno;
	}

	public void setRelieveorderno(String relieveorderno) {
		this.relieveorderno = relieveorderno;
	}

	public Date getRelieveorderdate() {
		return relieveorderdate;
	}

	public void setRelieveorderdate(Date relieveorderdate) {
		this.relieveorderdate = relieveorderdate;
	}

	public Date getRelievedate() {
		return relievedate;
	}

	public void setRelievedate(Date relievedate) {
		this.relievedate = relievedate;
	}

	public String getRelieveanfn() {
		return relieveanfn;
	}

	public void setRelieveanfn(String relieveanfn) {
		this.relieveanfn = relieveanfn;
	}

	public long getPpNoduesdetailid() {
		return ppNoduesdetailid;
	}

	public void setPpNoduesdetailid(long ppNoduesdetailid) {
		this.ppNoduesdetailid = ppNoduesdetailid;
	}

	public short getMasOfficelevelid() {
		return masOfficelevelid;
	}

	public void setMasOfficelevelid(short masOfficelevelid) {
		this.masOfficelevelid = masOfficelevelid;
	}
	
}
