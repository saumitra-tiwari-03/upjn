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
@Table(name = "VIEW_PENSIONEMPLOYEELIST")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewPensionemployeelist.findAll", query = "SELECT v FROM ViewPensionemployeelist v"),
		@NamedQuery(name = "ViewPensionemployeelist.findByEmployeename", query = "SELECT v FROM ViewPensionemployeelist v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPensionemployeelist.findByRmOfficeid", query = "SELECT v FROM ViewPensionemployeelist v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPensionemployeelist.findByEmployeecode", query = "SELECT v FROM ViewPensionemployeelist v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPensionemployeelist.findByFirstname", query = "SELECT v FROM ViewPensionemployeelist v WHERE v.firstname = :firstname"),
		@NamedQuery(name = "ViewPensionemployeelist.findByMiddlename", query = "SELECT v FROM ViewPensionemployeelist v WHERE v.middlename = :middlename"),
		@NamedQuery(name = "ViewPensionemployeelist.findByLastname", query = "SELECT v FROM ViewPensionemployeelist v WHERE v.lastname = :lastname"),
		@NamedQuery(name = "ViewPensionemployeelist.findByRetirementdate", query = "SELECT v FROM ViewPensionemployeelist v WHERE v.retirementdate = :retirementdate"),
		@NamedQuery(name = "ViewPensionemployeelist.findByAppointmentdate", query = "SELECT v FROM ViewPensionemployeelist v WHERE v.appointmentdate = :appointmentdate"),
		@NamedQuery(name = "ViewPensionemployeelist.findByDateofbirth", query = "SELECT v FROM ViewPensionemployeelist v WHERE v.dateofbirth = :dateofbirth"),
		@NamedQuery(name = "ViewPensionemployeelist.findByFathername", query = "SELECT v FROM ViewPensionemployeelist v WHERE v.fathername = :fathername") })
public class ViewPensionemployeelist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Basic(optional = false)
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "MIDDLENAME")
	private String middlename;
	@Column(name = "LASTNAME")
	private String lastname;
	@Column(name = "RETIREMENTDATE")
	private String retirementdate;
	@Column(name = "APPOINTMENTDATE")
	private String appointmentdate;
	@Column(name = "DATEOFBIRTH")
	private String dateofbirth;
	@Column(name = "FATHERNAME")
	private String fathername;

	public ViewPensionemployeelist() {
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

	public String getRetirementdate() {
		return retirementdate;
	}

	public void setRetirementdate(String retirementdate) {
		this.retirementdate = retirementdate;
	}

	public String getAppointmentdate() {
		return appointmentdate;
	}

	public void setAppointmentdate(String appointmentdate) {
		this.appointmentdate = appointmentdate;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

}
