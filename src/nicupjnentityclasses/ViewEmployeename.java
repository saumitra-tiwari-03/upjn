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
@Table(name = "VIEW_EMPLOYEENAME")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewEmployeename.findAll", query = "SELECT v FROM ViewEmployeename v"),
		@NamedQuery(name = "ViewEmployeename.findByPpEmployeemasterid", query = "SELECT v FROM ViewEmployeename v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewEmployeename.findByEmployeecode", query = "SELECT v FROM ViewEmployeename v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEmployeename.findByEmployeename", query = "SELECT v FROM ViewEmployeename v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEmployeename.findByPpDesignationmasterid", query = "SELECT v FROM ViewEmployeename v WHERE v.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "ViewEmployeename.findByDesignation", query = "SELECT v FROM ViewEmployeename v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewEmployeename.findByOfficename", query = "SELECT v FROM ViewEmployeename v WHERE v.officename = :officename") })
public class ViewEmployeename implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Integer ppDesignationmasterid;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "OFFICENAME")
	private String officename;

	public ViewEmployeename() {
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

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

}
