/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;

import javax.persistence.Basic;
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
@Table(name = "VIEW_EDITEMPLOYEEFORPOSTING")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewEditemployeeforposting.findAll", query = "SELECT v FROM ViewEditemployeeforposting v"),
		@NamedQuery(name = "ViewEditemployeeforposting.findByPpEmployeemasterid", query = "SELECT v FROM ViewEditemployeeforposting v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewEditemployeeforposting.findByEmployeecode", query = "SELECT v FROM ViewEditemployeeforposting v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEditemployeeforposting.findByEmployeename", query = "SELECT v FROM ViewEditemployeeforposting v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEditemployeeforposting.findByEmploymenttype", query = "SELECT v FROM ViewEditemployeeforposting v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewEditemployeeforposting.findByEmploymentsubtype", query = "SELECT v FROM ViewEditemployeeforposting v WHERE v.employmentsubtype = :employmentsubtype"),
		@NamedQuery(name = "ViewEditemployeeforposting.findByDesignation", query = "SELECT v FROM ViewEditemployeeforposting v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewEditemployeeforposting.findByPpPostingdetailid", query = "SELECT v FROM ViewEditemployeeforposting v WHERE v.ppPostingdetailid = :ppPostingdetailid"),
		@NamedQuery(name = "ViewEditemployeeforposting.findByPostingagainst", query = "SELECT v FROM ViewEditemployeeforposting v WHERE v.postingagainst = :postingagainst"),
		@NamedQuery(name = "ViewEditemployeeforposting.findByEntryOfficeid", query = "SELECT v FROM ViewEditemployeeforposting v WHERE v.entryOfficeid = :entryOfficeid"),
		@NamedQuery(name = "ViewEditemployeeforposting.findByFlagid", query = "SELECT v FROM ViewEditemployeeforposting v WHERE v.flagid = :flagid") })
public class ViewEditemployeeforposting implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTSUBTYPE")
	private String employmentsubtype;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "PP_POSTINGDETAILID")
	private long ppPostingdetailid;
	@Basic(optional = false)
	@Column(name = "POSTINGAGAINST")
	private String postingagainst;
	@Column(name = "ENTRY_OFFICEID")
	private Long entryOfficeid;
	@Column(name = "FLAGID")
	private String flagid;

	public ViewEditemployeeforposting() {
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getPpPostingdetailid() {
		return ppPostingdetailid;
	}

	public void setPpPostingdetailid(long ppPostingdetailid) {
		this.ppPostingdetailid = ppPostingdetailid;
	}

	public String getPostingagainst() {
		return postingagainst;
	}

	public void setPostingagainst(String postingagainst) {
		this.postingagainst = postingagainst;
	}

	public Long getEntryOfficeid() {
		return entryOfficeid;
	}

	public void setEntryOfficeid(Long entryOfficeid) {
		this.entryOfficeid = entryOfficeid;
	}

	public String getFlagid() {
		return flagid;
	}

	public void setFlagid(String flagid) {
		this.flagid = flagid;
	}

}
