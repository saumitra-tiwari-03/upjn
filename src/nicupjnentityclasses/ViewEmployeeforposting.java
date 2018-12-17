/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_EMPLOYEEFORPOSTING")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewEmployeeforposting.findAll", query = "SELECT v FROM ViewEmployeeforposting v"),
		@NamedQuery(name = "ViewEmployeeforposting.findByPpEmployeemasterid", query = "SELECT v FROM ViewEmployeeforposting v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewEmployeeforposting.findByEmployeecode", query = "SELECT v FROM ViewEmployeeforposting v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEmployeeforposting.findByEmployeename", query = "SELECT v FROM ViewEmployeeforposting v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEmployeeforposting.findByDesignation", query = "SELECT v FROM ViewEmployeeforposting v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewEmployeeforposting.findByEmploymenttype", query = "SELECT v FROM ViewEmployeeforposting v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewEmployeeforposting.findByEmploymentsubtype", query = "SELECT v FROM ViewEmployeeforposting v WHERE v.employmentsubtype = :employmentsubtype"),
		@NamedQuery(name = "ViewEmployeeforposting.findByPostingagainst", query = "SELECT v FROM ViewEmployeeforposting v WHERE v.postingagainst = :postingagainst"),
		@NamedQuery(name = "ViewEmployeeforposting.findByEntryOfficeid", query = "SELECT v FROM ViewEmployeeforposting v WHERE v.entryOfficeid = :entryOfficeid"),
		@NamedQuery(name = "ViewEmployeeforposting.findByFlagid", query = "SELECT v FROM ViewEmployeeforposting v WHERE v.flagid = :flagid") })
public class ViewEmployeeforposting implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;
	@Column(name = "EMPLOYMENTSUBTYPE")
	private String employmentsubtype;
	@Column(name = "POSTINGAGAINST")
	private String postingagainst;
	@Column(name = "ENTRY_OFFICEID")
	private BigInteger entryOfficeid;
	@Column(name = "FLAGID")
	private BigInteger flagid;

	public ViewEmployeeforposting() {
	}

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
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

	public String getEmploymenttype() {
		return employmenttype;
	}

	public void setEmploymenttype(String employmenttype) {
		this.employmenttype = employmenttype;
	}

	public String getEmploymentsubtype() {
		return employmentsubtype;
	}

	public void setEmploymentsubtype(String employmentsubtype) {
		this.employmentsubtype = employmentsubtype;
	}

	public String getPostingagainst() {
		return postingagainst;
	}

	public void setPostingagainst(String postingagainst) {
		this.postingagainst = postingagainst;
	}

	public BigInteger getEntryOfficeid() {
		return entryOfficeid;
	}

	public void setEntryOfficeid(BigInteger entryOfficeid) {
		this.entryOfficeid = entryOfficeid;
	}

	public BigInteger getFlagid() {
		return flagid;
	}

	public void setFlagid(BigInteger flagid) {
		this.flagid = flagid;
	}

}
