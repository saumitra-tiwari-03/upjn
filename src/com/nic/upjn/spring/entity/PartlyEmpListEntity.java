/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RamPrakash Pandey
 */
@Entity
@Table(name = "PartlyEmpListEntity")
@XmlRootElement
@NamedQueries({})
public class PartlyEmpListEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;

	@Basic(optional = false)
	@Column(name = "EMPLOYEENAME")
	private String employeename;

	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;

	@Basic(optional = false)
	@Column(name = "DESIGNATION")
	private String designation;

	@Basic(optional = false)
	@Column(name = "PP_REGISTERMASTERID")
	private Short ppRegistermasterid;

	@Basic(optional = false)
	@Column(name = "PP_DESIGNATIONMASTERID")
	private BigDecimal ppDesignationmasterid;

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

	public Short getPpRegistermasterid() {
		return ppRegistermasterid;
	}

	public void setPpRegistermasterid(Short ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public BigDecimal getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(BigDecimal ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

}
