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
@Table(name = "VIEW_RM_EMPLOYEEROLELIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewRmEmployeerolelist.findAll", query = "SELECT v FROM ViewRmEmployeerolelist v"),
		@NamedQuery(name = "ViewRmEmployeerolelist.findByPpEmployeemasterid", query = "SELECT v FROM ViewRmEmployeerolelist v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewRmEmployeerolelist.findByEmployeecode", query = "SELECT v FROM ViewRmEmployeerolelist v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewRmEmployeerolelist.findByRmOfficeid", query = "SELECT v FROM ViewRmEmployeerolelist v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewRmEmployeerolelist.findByEmployeename", query = "SELECT v FROM ViewRmEmployeerolelist v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewRmEmployeerolelist.findByDesignation", query = "SELECT v FROM ViewRmEmployeerolelist v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewRmEmployeerolelist.findByRolename", query = "SELECT v FROM ViewRmEmployeerolelist v WHERE v.rolename = :rolename"),
		@NamedQuery(name = "ViewRmEmployeerolelist.findByRoletype", query = "SELECT v FROM ViewRmEmployeerolelist v WHERE v.roletype = :roletype"),
		@NamedQuery(name = "ViewRmEmployeerolelist.findByIsloginlocked", query = "SELECT v FROM ViewRmEmployeerolelist v WHERE v.isloginlocked = :isloginlocked") })
public class ViewRmEmployeerolelist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "ROLENAME")
	private String rolename;
	@Column(name = "ROLETYPE")
	private String roletype;
	@Basic(optional = false)
	@Column(name = "ISLOGINLOCKED")
	private Character isloginlocked;

	public ViewRmEmployeerolelist() {
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoletype() {
		return roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	public Character getIsloginlocked() {
		return isloginlocked;
	}

	public void setIsloginlocked(Character isloginlocked) {
		this.isloginlocked = isloginlocked;
	}

}
