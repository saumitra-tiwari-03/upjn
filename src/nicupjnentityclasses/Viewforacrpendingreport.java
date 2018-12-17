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
@Table(name = "VIEWFORACRPENDINGREPORT")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Viewforacrpendingreport.findAll", query = "SELECT v FROM Viewforacrpendingreport v"),
		@NamedQuery(name = "Viewforacrpendingreport.findByPpEmployeemasterid", query = "SELECT v FROM Viewforacrpendingreport v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "Viewforacrpendingreport.findByEmployeecode", query = "SELECT v FROM Viewforacrpendingreport v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "Viewforacrpendingreport.findByFirstname", query = "SELECT v FROM Viewforacrpendingreport v WHERE v.firstname = :firstname"),
		@NamedQuery(name = "Viewforacrpendingreport.findByLastname", query = "SELECT v FROM Viewforacrpendingreport v WHERE v.lastname = :lastname"),
		@NamedQuery(name = "Viewforacrpendingreport.findByRmOfficeid", query = "SELECT v FROM Viewforacrpendingreport v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "Viewforacrpendingreport.findByEmployeename", query = "SELECT v FROM Viewforacrpendingreport v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "Viewforacrpendingreport.findByPpDesignationmasterid", query = "SELECT v FROM Viewforacrpendingreport v WHERE v.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "Viewforacrpendingreport.findByDesignation", query = "SELECT v FROM Viewforacrpendingreport v WHERE v.designation = :designation"),
		@NamedQuery(name = "Viewforacrpendingreport.findByEmploymenttype", query = "SELECT v FROM Viewforacrpendingreport v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "Viewforacrpendingreport.findByMasEmploymenttypeid", query = "SELECT v FROM Viewforacrpendingreport v WHERE v.masEmploymenttypeid = :masEmploymenttypeid"),
		@NamedQuery(name = "Viewforacrpendingreport.findByEmploymentsubtype", query = "SELECT v FROM Viewforacrpendingreport v WHERE v.employmentsubtype = :employmentsubtype"),
		@NamedQuery(name = "Viewforacrpendingreport.findByMasEmploymentsubtypeid", query = "SELECT v FROM Viewforacrpendingreport v WHERE v.masEmploymentsubtypeid = :masEmploymentsubtypeid"),
		@NamedQuery(name = "Viewforacrpendingreport.findByPlaceofposting", query = "SELECT v FROM Viewforacrpendingreport v WHERE v.placeofposting = :placeofposting"),
		@NamedQuery(name = "Viewforacrpendingreport.findByPpCurrentstatusid", query = "SELECT v FROM Viewforacrpendingreport v WHERE v.ppCurrentstatusid = :ppCurrentstatusid"),
		@NamedQuery(name = "Viewforacrpendingreport.findByOfficename", query = "SELECT v FROM Viewforacrpendingreport v WHERE v.officename = :officename") })
public class Viewforacrpendingreport implements Serializable {
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
	@Basic(optional = false)
	@Column(name = "OFFICENAME")
	private String officename;

	public Viewforacrpendingreport() {
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

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

}
