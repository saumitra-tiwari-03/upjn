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
@Table(name = "VIEW_PAYROLLSYSTEM")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPayrollsystem.findAll", query = "SELECT v FROM ViewPayrollsystem v"),
		@NamedQuery(name = "ViewPayrollsystem.findByPpEmployeemasterid", query = "SELECT v FROM ViewPayrollsystem v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPayrollsystem.findByEmployeecode", query = "SELECT v FROM ViewPayrollsystem v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPayrollsystem.findByFirstname", query = "SELECT v FROM ViewPayrollsystem v WHERE v.firstname = :firstname"),
		@NamedQuery(name = "ViewPayrollsystem.findByMiddlename", query = "SELECT v FROM ViewPayrollsystem v WHERE v.middlename = :middlename"),
		@NamedQuery(name = "ViewPayrollsystem.findByLastname", query = "SELECT v FROM ViewPayrollsystem v WHERE v.lastname = :lastname"),
		@NamedQuery(name = "ViewPayrollsystem.findByDesignation", query = "SELECT v FROM ViewPayrollsystem v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewPayrollsystem.findByRmOfficeid", query = "SELECT v FROM ViewPayrollsystem v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPayrollsystem.findByFathername", query = "SELECT v FROM ViewPayrollsystem v WHERE v.fathername = :fathername"),
		@NamedQuery(name = "ViewPayrollsystem.findByDateofbirth", query = "SELECT v FROM ViewPayrollsystem v WHERE v.dateofbirth = :dateofbirth"),
		@NamedQuery(name = "ViewPayrollsystem.findByDateofretirement", query = "SELECT v FROM ViewPayrollsystem v WHERE v.dateofretirement = :dateofretirement"),
		@NamedQuery(name = "ViewPayrollsystem.findByAddress", query = "SELECT v FROM ViewPayrollsystem v WHERE v.address = :address"),
		@NamedQuery(name = "ViewPayrollsystem.findByRetirementdate", query = "SELECT v FROM ViewPayrollsystem v WHERE v.retirementdate = :retirementdate"),
		@NamedQuery(name = "ViewPayrollsystem.findByRetirementage", query = "SELECT v FROM ViewPayrollsystem v WHERE v.retirementage = :retirementage"),
		@NamedQuery(name = "ViewPayrollsystem.findByDatejoining", query = "SELECT v FROM ViewPayrollsystem v WHERE v.datejoining = :datejoining"),
		@NamedQuery(name = "ViewPayrollsystem.findByMonth", query = "SELECT v FROM ViewPayrollsystem v WHERE v.month = :month"),
		@NamedQuery(name = "ViewPayrollsystem.findByYear", query = "SELECT v FROM ViewPayrollsystem v WHERE v.year = :year"),
		@NamedQuery(name = "ViewPayrollsystem.findByOfficename", query = "SELECT v FROM ViewPayrollsystem v WHERE v.officename = :officename") })
public class ViewPayrollsystem implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "MIDDLENAME")
	private String middlename;
	@Column(name = "LASTNAME")
	private String lastname;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Column(name = "FATHERNAME")
	private String fathername;
	@Column(name = "DATEOFBIRTH")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofbirth;
	@Column(name = "DATEOFRETIREMENT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofretirement;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "RETIREMENTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date retirementdate;
	@Column(name = "RETIREMENTAGE")
	private Short retirementage;
	@Column(name = "DATEJOINING")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datejoining;
	@Column(name = "MONTH")
	private String month;
	@Column(name = "YEAR")
	private String year;
	@Basic(optional = false)
	@Column(name = "OFFICENAME")
	private String officename;

	public ViewPayrollsystem() {
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public Date getDateofretirement() {
		return dateofretirement;
	}

	public void setDateofretirement(Date dateofretirement) {
		this.dateofretirement = dateofretirement;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRetirementdate() {
		return retirementdate;
	}

	public void setRetirementdate(Date retirementdate) {
		this.retirementdate = retirementdate;
	}

	public Short getRetirementage() {
		return retirementage;
	}

	public void setRetirementage(Short retirementage) {
		this.retirementage = retirementage;
	}

	public Date getDatejoining() {
		return datejoining;
	}

	public void setDatejoining(Date datejoining) {
		this.datejoining = datejoining;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

}
