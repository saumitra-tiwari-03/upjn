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
@Table(name = "VIEW_PP_EMPLOYEE_ONEL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpEmployeeOnel.findAll", query = "SELECT v FROM ViewPpEmployeeOnel v"),
		@NamedQuery(name = "ViewPpEmployeeOnel.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpEmployeeOnel v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpEmployeeOnel.findByEmployeecode", query = "SELECT v FROM ViewPpEmployeeOnel v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPpEmployeeOnel.findByEmployeename", query = "SELECT v FROM ViewPpEmployeeOnel v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPpEmployeeOnel.findByRmOfficeid", query = "SELECT v FROM ViewPpEmployeeOnel v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPpEmployeeOnel.findByDesignation", query = "SELECT v FROM ViewPpEmployeeOnel v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewPpEmployeeOnel.findByRelorderno", query = "SELECT v FROM ViewPpEmployeeOnel v WHERE v.relorderno = :relorderno"),
		@NamedQuery(name = "ViewPpEmployeeOnel.findByRelorderdate", query = "SELECT v FROM ViewPpEmployeeOnel v WHERE v.relorderdate = :relorderdate"),
		@NamedQuery(name = "ViewPpEmployeeOnel.findByPpEmployeeEldetailid", query = "SELECT v FROM ViewPpEmployeeOnel v WHERE v.ppEmployeeEldetailid = :ppEmployeeEldetailid") })
public class ViewPpEmployeeOnel implements Serializable {
	private static final long serialVersionUID = 1L;
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
	@Column(name = "RELORDERNO")
	private String relorderno;
	@Column(name = "RELORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relorderdate;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEE_ELDETAILID")
	private long ppEmployeeEldetailid;

	public ViewPpEmployeeOnel() {
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

	public String getRelorderno() {
		return relorderno;
	}

	public void setRelorderno(String relorderno) {
		this.relorderno = relorderno;
	}

	public Date getRelorderdate() {
		return relorderdate;
	}

	public void setRelorderdate(Date relorderdate) {
		this.relorderdate = relorderdate;
	}

	public long getPpEmployeeEldetailid() {
		return ppEmployeeEldetailid;
	}

	public void setPpEmployeeEldetailid(long ppEmployeeEldetailid) {
		this.ppEmployeeEldetailid = ppEmployeeEldetailid;
	}

}
