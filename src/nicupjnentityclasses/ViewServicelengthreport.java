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
@Table(name = "VIEW_SERVICELENGTHREPORT")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewServicelengthreport.findAll", query = "SELECT v FROM ViewServicelengthreport v"),
		@NamedQuery(name = "ViewServicelengthreport.findByEmployeename", query = "SELECT v FROM ViewServicelengthreport v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewServicelengthreport.findByEmployeecode", query = "SELECT v FROM ViewServicelengthreport v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewServicelengthreport.findByMasEmploymenttypeid", query = "SELECT v FROM ViewServicelengthreport v WHERE v.masEmploymenttypeid = :masEmploymenttypeid"),
		@NamedQuery(name = "ViewServicelengthreport.findByRmOfficeid", query = "SELECT v FROM ViewServicelengthreport v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewServicelengthreport.findByDatejoining", query = "SELECT v FROM ViewServicelengthreport v WHERE v.datejoining = :datejoining"),
		@NamedQuery(name = "ViewServicelengthreport.findByDesignation", query = "SELECT v FROM ViewServicelengthreport v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewServicelengthreport.findByEmploymenttype", query = "SELECT v FROM ViewServicelengthreport v WHERE v.employmenttype = :employmenttype") })
public class ViewServicelengthreport implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Basic(optional = false)
	@Column(name = "MAS_EMPLOYMENTTYPEID")
	private int masEmploymenttypeid;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Column(name = "DATEJOINING")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datejoining;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;

	public ViewServicelengthreport() {
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

	public int getMasEmploymenttypeid() {
		return masEmploymenttypeid;
	}

	public void setMasEmploymenttypeid(int masEmploymenttypeid) {
		this.masEmploymenttypeid = masEmploymenttypeid;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Date getDatejoining() {
		return datejoining;
	}

	public void setDatejoining(Date datejoining) {
		this.datejoining = datejoining;
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

}
