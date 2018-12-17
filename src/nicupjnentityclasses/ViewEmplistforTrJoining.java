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
@Table(name = "VIEW_EMPLISTFOR_TR_JOINING")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewEmplistforTrJoining.findAll", query = "SELECT v FROM ViewEmplistforTrJoining v"),
		@NamedQuery(name = "ViewEmplistforTrJoining.findByPpEmployeemasterid", query = "SELECT v FROM ViewEmplistforTrJoining v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewEmplistforTrJoining.findByEmployeecode", query = "SELECT v FROM ViewEmplistforTrJoining v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEmplistforTrJoining.findByEmployeename", query = "SELECT v FROM ViewEmplistforTrJoining v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEmplistforTrJoining.findByRmOfficeid", query = "SELECT v FROM ViewEmplistforTrJoining v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewEmplistforTrJoining.findByEmploymenttype", query = "SELECT v FROM ViewEmplistforTrJoining v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewEmplistforTrJoining.findByEmploymentsubtype", query = "SELECT v FROM ViewEmplistforTrJoining v WHERE v.employmentsubtype = :employmentsubtype"),
		@NamedQuery(name = "ViewEmplistforTrJoining.findByDesignation", query = "SELECT v FROM ViewEmplistforTrJoining v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewEmplistforTrJoining.findByPpTransferdetailid", query = "SELECT v FROM ViewEmplistforTrJoining v WHERE v.ppTransferdetailid = :ppTransferdetailid"),
		@NamedQuery(name = "ViewEmplistforTrJoining.findByFlagid", query = "SELECT v FROM ViewEmplistforTrJoining v WHERE v.flagid = :flagid") })
public class ViewEmplistforTrJoining implements Serializable {
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
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTSUBTYPE")
	private String employmentsubtype;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "PP_TRANSFERDETAILID")
	private long ppTransferdetailid;
	@Column(name = "FLAGID")
	private String flagid;

	public ViewEmplistforTrJoining() {
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

	public long getPpTransferdetailid() {
		return ppTransferdetailid;
	}

	public void setPpTransferdetailid(long ppTransferdetailid) {
		this.ppTransferdetailid = ppTransferdetailid;
	}

	public String getFlagid() {
		return flagid;
	}

	public void setFlagid(String flagid) {
		this.flagid = flagid;
	}

}
