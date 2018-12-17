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
@Table(name = "VIEW_EMPLISTFORPAYBILL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewEmplistforpaybill.findAll", query = "SELECT v FROM ViewEmplistforpaybill v"),
		@NamedQuery(name = "ViewEmplistforpaybill.findByPpEmployeemasterid", query = "SELECT v FROM ViewEmplistforpaybill v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewEmplistforpaybill.findByEmployeecode", query = "SELECT v FROM ViewEmplistforpaybill v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEmplistforpaybill.findByFirstname", query = "SELECT v FROM ViewEmplistforpaybill v WHERE v.firstname = :firstname"),
		@NamedQuery(name = "ViewEmplistforpaybill.findByLastname", query = "SELECT v FROM ViewEmplistforpaybill v WHERE v.lastname = :lastname"),
		@NamedQuery(name = "ViewEmplistforpaybill.findByRmOfficeid", query = "SELECT v FROM ViewEmplistforpaybill v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewEmplistforpaybill.findByEmployeename", query = "SELECT v FROM ViewEmplistforpaybill v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEmplistforpaybill.findBySysPaycategoryid", query = "SELECT v FROM ViewEmplistforpaybill v WHERE v.sysPaycategoryid = :sysPaycategoryid") })
public class ViewEmplistforpaybill implements Serializable {
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
	@Column(name = "SYS_PAYCATEGORYID")
	private Short sysPaycategoryid;

	public ViewEmplistforpaybill() {
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

	public Short getSysPaycategoryid() {
		return sysPaycategoryid;
	}

	public void setSysPaycategoryid(Short sysPaycategoryid) {
		this.sysPaycategoryid = sysPaycategoryid;
	}

}
