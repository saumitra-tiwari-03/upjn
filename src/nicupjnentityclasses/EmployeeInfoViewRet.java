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
@Table(name = "EMPLOYEE_INFO_VIEW_RET")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "EmployeeInfoViewRet.findAll", query = "SELECT e FROM EmployeeInfoViewRet e"),
		@NamedQuery(name = "EmployeeInfoViewRet.findByPpEmployeemasterid", query = "SELECT e FROM EmployeeInfoViewRet e WHERE e.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "EmployeeInfoViewRet.findByEmployeecode", query = "SELECT e FROM EmployeeInfoViewRet e WHERE e.employeecode = :employeecode"),
		@NamedQuery(name = "EmployeeInfoViewRet.findByFirstname", query = "SELECT e FROM EmployeeInfoViewRet e WHERE e.firstname = :firstname"),
		@NamedQuery(name = "EmployeeInfoViewRet.findByLastname", query = "SELECT e FROM EmployeeInfoViewRet e WHERE e.lastname = :lastname"),
		@NamedQuery(name = "EmployeeInfoViewRet.findByRmOfficeid", query = "SELECT e FROM EmployeeInfoViewRet e WHERE e.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "EmployeeInfoViewRet.findByEmployeename", query = "SELECT e FROM EmployeeInfoViewRet e WHERE e.employeename = :employeename"),
		@NamedQuery(name = "EmployeeInfoViewRet.findByPpDesignationmasterid", query = "SELECT e FROM EmployeeInfoViewRet e WHERE e.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "EmployeeInfoViewRet.findByDesignation", query = "SELECT e FROM EmployeeInfoViewRet e WHERE e.designation = :designation"),
		@NamedQuery(name = "EmployeeInfoViewRet.findByEmploymenttype", query = "SELECT e FROM EmployeeInfoViewRet e WHERE e.employmenttype = :employmenttype"),
		@NamedQuery(name = "EmployeeInfoViewRet.findByMasEmploymenttypeid", query = "SELECT e FROM EmployeeInfoViewRet e WHERE e.masEmploymenttypeid = :masEmploymenttypeid"),
		@NamedQuery(name = "EmployeeInfoViewRet.findByEmploymentsubtype", query = "SELECT e FROM EmployeeInfoViewRet e WHERE e.employmentsubtype = :employmentsubtype"),
		@NamedQuery(name = "EmployeeInfoViewRet.findByMasEmploymentsubtypeid", query = "SELECT e FROM EmployeeInfoViewRet e WHERE e.masEmploymentsubtypeid = :masEmploymentsubtypeid"),
		@NamedQuery(name = "EmployeeInfoViewRet.findByPlaceofposting", query = "SELECT e FROM EmployeeInfoViewRet e WHERE e.placeofposting = :placeofposting"),
		@NamedQuery(name = "EmployeeInfoViewRet.findByPpCurrentstatusid", query = "SELECT e FROM EmployeeInfoViewRet e WHERE e.ppCurrentstatusid = :ppCurrentstatusid") })
public class EmployeeInfoViewRet implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Basic(optional = false)
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "LASTNAME")
	private String lastname;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Integer ppDesignationmasterid;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;
	@Basic(optional = false)
	@Column(name = "MAS_EMPLOYMENTTYPEID")
	private int masEmploymenttypeid;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTSUBTYPE")
	private String employmentsubtype;
	@Basic(optional = false)
	@Column(name = "MAS_EMPLOYMENTSUBTYPEID")
	private int masEmploymentsubtypeid;
	@Column(name = "PLACEOFPOSTING")
	private String placeofposting;
	@Column(name = "PP_CURRENTSTATUSID")
	private String ppCurrentstatusid;

	public EmployeeInfoViewRet() {
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public Integer getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(Integer ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
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

	public int getMasEmploymenttypeid() {
		return masEmploymenttypeid;
	}

	public void setMasEmploymenttypeid(int masEmploymenttypeid) {
		this.masEmploymenttypeid = masEmploymenttypeid;
	}

	public String getEmploymentsubtype() {
		return employmentsubtype;
	}

	public void setEmploymentsubtype(String employmentsubtype) {
		this.employmentsubtype = employmentsubtype;
	}

	public int getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(int masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public String getPlaceofposting() {
		return placeofposting;
	}

	public void setPlaceofposting(String placeofposting) {
		this.placeofposting = placeofposting;
	}

	public String getPpCurrentstatusid() {
		return ppCurrentstatusid;
	}

	public void setPpCurrentstatusid(String ppCurrentstatusid) {
		this.ppCurrentstatusid = ppCurrentstatusid;
	}

}
