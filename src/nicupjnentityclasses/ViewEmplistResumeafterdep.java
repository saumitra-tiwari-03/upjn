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
@Table(name = "VIEW_EMPLIST_RESUMEAFTERDEP")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewEmplistResumeafterdep.findAll", query = "SELECT v FROM ViewEmplistResumeafterdep v"),
		@NamedQuery(name = "ViewEmplistResumeafterdep.findByPpEmployeemasterid", query = "SELECT v FROM ViewEmplistResumeafterdep v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewEmplistResumeafterdep.findByEmployeecode", query = "SELECT v FROM ViewEmplistResumeafterdep v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEmplistResumeafterdep.findByEmployeename", query = "SELECT v FROM ViewEmplistResumeafterdep v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEmplistResumeafterdep.findByDesignation", query = "SELECT v FROM ViewEmplistResumeafterdep v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewEmplistResumeafterdep.findByReturningfrom", query = "SELECT v FROM ViewEmplistResumeafterdep v WHERE v.returningfrom = :returningfrom"),
		@NamedQuery(name = "ViewEmplistResumeafterdep.findByEmploymenttype", query = "SELECT v FROM ViewEmplistResumeafterdep v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewEmplistResumeafterdep.findByEmploymentsubtype", query = "SELECT v FROM ViewEmplistResumeafterdep v WHERE v.employmentsubtype = :employmentsubtype"),
		@NamedQuery(name = "ViewEmplistResumeafterdep.findByRelievedate", query = "SELECT v FROM ViewEmplistResumeafterdep v WHERE v.relievedate = :relievedate"),
		@NamedQuery(name = "ViewEmplistResumeafterdep.findByPpDeputationdetailid", query = "SELECT v FROM ViewEmplistResumeafterdep v WHERE v.ppDeputationdetailid = :ppDeputationdetailid") })
public class ViewEmplistResumeafterdep implements Serializable {
	private static final long serialVersionUID = 1L;
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
	@Basic(optional = false)
	@Column(name = "RETURNINGFROM")
	private String returningfrom;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTSUBTYPE")
	private String employmentsubtype;
	@Column(name = "RELIEVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relievedate;
	@Basic(optional = false)
	@Column(name = "PP_DEPUTATIONDETAILID")
	private long ppDeputationdetailid;

	public ViewEmplistResumeafterdep() {
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

	public String getReturningfrom() {
		return returningfrom;
	}

	public void setReturningfrom(String returningfrom) {
		this.returningfrom = returningfrom;
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

	public Date getRelievedate() {
		return relievedate;
	}

	public void setRelievedate(Date relievedate) {
		this.relievedate = relievedate;
	}

	public long getPpDeputationdetailid() {
		return ppDeputationdetailid;
	}

	public void setPpDeputationdetailid(long ppDeputationdetailid) {
		this.ppDeputationdetailid = ppDeputationdetailid;
	}

}
