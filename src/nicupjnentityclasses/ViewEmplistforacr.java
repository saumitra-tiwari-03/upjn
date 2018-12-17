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
@Table(name = "VIEW_EMPLISTFORACR")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewEmplistforacr.findAll", query = "SELECT v FROM ViewEmplistforacr v"),
		@NamedQuery(name = "ViewEmplistforacr.findByPpEmployeemasterid", query = "SELECT v FROM ViewEmplistforacr v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewEmplistforacr.findByEmployeecode", query = "SELECT v FROM ViewEmplistforacr v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEmplistforacr.findByEmployeename", query = "SELECT v FROM ViewEmplistforacr v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEmplistforacr.findByDesignation", query = "SELECT v FROM ViewEmplistforacr v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewEmplistforacr.findByEmploymenttype", query = "SELECT v FROM ViewEmplistforacr v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewEmplistforacr.findByEmploymentsubtype", query = "SELECT v FROM ViewEmplistforacr v WHERE v.employmentsubtype = :employmentsubtype") })
public class ViewEmplistforacr implements Serializable {
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
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTSUBTYPE")
	private String employmentsubtype;

	public ViewEmplistforacr() {
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

}
