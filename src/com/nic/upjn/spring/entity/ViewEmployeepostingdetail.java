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
@Table(name = "VIEW_EMPLOYEEPOSTINGDETAIL")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewEmployeepostingdetail.findAll", query = "SELECT v FROM ViewEmployeepostingdetail v"),
		@NamedQuery(name = "ViewEmployeepostingdetail.findByPpPostingdetailid", query = "SELECT v FROM ViewEmployeepostingdetail v WHERE v.ppPostingdetailid = :ppPostingdetailid"),
		@NamedQuery(name = "ViewEmployeepostingdetail.findByPpEmployeemasterid", query = "FROM ViewEmployeepostingdetail  WHERE ppEmployeemasterid = ?"),
		@NamedQuery(name = "ViewEmployeepostingdetail.findByModeofposting", query = "SELECT v FROM ViewEmployeepostingdetail v WHERE v.modeofposting = :modeofposting"),
		@NamedQuery(name = "ViewEmployeepostingdetail.findByPpDesignationmasterid", query = "SELECT v FROM ViewEmployeepostingdetail v WHERE v.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "ViewEmployeepostingdetail.findByEffectivedate", query = "SELECT v FROM ViewEmployeepostingdetail v WHERE v.effectivedate = :effectivedate"),
		@NamedQuery(name = "ViewEmployeepostingdetail.findByPostingorderno", query = "SELECT v FROM ViewEmployeepostingdetail v WHERE v.postingorderno = :postingorderno"),
		@NamedQuery(name = "ViewEmployeepostingdetail.findByOrderdate", query = "SELECT v FROM ViewEmployeepostingdetail v WHERE v.orderdate = :orderdate"),
		@NamedQuery(name = "ViewEmployeepostingdetail.findByRmOfficeid", query = "SELECT v FROM ViewEmployeepostingdetail v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewEmployeepostingdetail.findByMasOfficelevelid", query = "SELECT v FROM ViewEmployeepostingdetail v WHERE v.masOfficelevelid = :masOfficelevelid") })
public class ViewEmployeepostingdetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Id
	@Column(name = "PP_POSTINGDETAILID")
	private long ppPostingdetailid;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Column(name = "MODEOFPOSTING")
	private Short modeofposting;
	@Basic(optional = false)
	@Column(name = "PP_DESIGNATIONMASTERID")
	private int ppDesignationmasterid;
	@Column(name = "EFFECTIVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date effectivedate;
	@Basic(optional = false)
	@Column(name = "POSTINGORDERNO")
	private String postingorderno;
	@Basic(optional = false)
	@Column(name = "ORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderdate;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Column(name = "MAS_DISTRICTID")
	private int masDistrictid;
	@Basic(optional = false)
	@Column(name = "MAS_OFFICELEVELID")
	private short masOfficelevelid;

	public ViewEmployeepostingdetail() {
	}

	public long getPpPostingdetailid() {
		return ppPostingdetailid;
	}

	public void setPpPostingdetailid(long ppPostingdetailid) {
		this.ppPostingdetailid = ppPostingdetailid;
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public Short getModeofposting() {
		return modeofposting;
	}

	public void setModeofposting(Short modeofposting) {
		this.modeofposting = modeofposting;
	}

	public int getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(int ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public Date getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}

	public String getPostingorderno() {
		return postingorderno;
	}

	public void setPostingorderno(String postingorderno) {
		this.postingorderno = postingorderno;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public short getMasOfficelevelid() {
		return masOfficelevelid;
	}

	public void setMasOfficelevelid(short masOfficelevelid) {
		this.masOfficelevelid = masOfficelevelid;
	}

	public int getMasDistrictid() {
		return masDistrictid;
	}

	public void setMasDistrictid(int masDistrictid) {
		this.masDistrictid = masDistrictid;
	}

	
	
}
