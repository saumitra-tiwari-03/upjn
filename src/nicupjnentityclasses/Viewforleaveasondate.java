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
@Table(name = "VIEWFORLEAVEASONDATE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Viewforleaveasondate.findAll", query = "SELECT v FROM Viewforleaveasondate v"),
		@NamedQuery(name = "Viewforleaveasondate.findByLeavecredited", query = "SELECT v FROM Viewforleaveasondate v WHERE v.leavecredited = :leavecredited"),
		@NamedQuery(name = "Viewforleaveasondate.findByBalance", query = "SELECT v FROM Viewforleaveasondate v WHERE v.balance = :balance"),
		@NamedQuery(name = "Viewforleaveasondate.findByCreditdate", query = "SELECT v FROM Viewforleaveasondate v WHERE v.creditdate = :creditdate"),
		@NamedQuery(name = "Viewforleaveasondate.findBySysLeavetypemasterid", query = "SELECT v FROM Viewforleaveasondate v WHERE v.sysLeavetypemasterid = :sysLeavetypemasterid"),
		@NamedQuery(name = "Viewforleaveasondate.findByPpEmployeemasterid", query = "SELECT v FROM Viewforleaveasondate v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "Viewforleaveasondate.findByEmployeecode", query = "SELECT v FROM Viewforleaveasondate v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "Viewforleaveasondate.findByDesignation", query = "SELECT v FROM Viewforleaveasondate v WHERE v.designation = :designation"),
		@NamedQuery(name = "Viewforleaveasondate.findByEmployeename", query = "SELECT v FROM Viewforleaveasondate v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "Viewforleaveasondate.findByRmOfficeid", query = "SELECT v FROM Viewforleaveasondate v WHERE v.rmOfficeid = :rmOfficeid") })
public class Viewforleaveasondate implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "LEAVECREDITED")
	private Short leavecredited;
	@Column(name = "BALANCE")
	private Short balance;
	@Column(name = "CREDITDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creditdate;
	@Basic(optional = false)
	@Column(name = "SYS_LEAVETYPEMASTERID")
	private short sysLeavetypemasterid;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;

	public Viewforleaveasondate() {
	}

	public Short getLeavecredited() {
		return leavecredited;
	}

	public void setLeavecredited(Short leavecredited) {
		this.leavecredited = leavecredited;
	}

	public Short getBalance() {
		return balance;
	}

	public void setBalance(Short balance) {
		this.balance = balance;
	}

	public Date getCreditdate() {
		return creditdate;
	}

	public void setCreditdate(Date creditdate) {
		this.creditdate = creditdate;
	}

	public short getSysLeavetypemasterid() {
		return sysLeavetypemasterid;
	}

	public void setSysLeavetypemasterid(short sysLeavetypemasterid) {
		this.sysLeavetypemasterid = sysLeavetypemasterid;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

}
