/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "DESIGNATION_CLASS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "DesignationClass.findAll", query = "SELECT d FROM DesignationClass d"),
		@NamedQuery(name = "DesignationClass.findById", query = "SELECT d FROM DesignationClass d WHERE d.id = :id"),
		@NamedQuery(name = "DesignationClass.findByPpEmployeemasterid", query = "SELECT d FROM DesignationClass d WHERE d.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "DesignationClass.findByEmployeecode", query = "SELECT d FROM DesignationClass d WHERE d.employeecode = :employeecode"),
		@NamedQuery(name = "DesignationClass.findByFirstname", query = "SELECT d FROM DesignationClass d WHERE d.firstname = :firstname"),
		@NamedQuery(name = "DesignationClass.findByDesignation", query = "SELECT d FROM DesignationClass d WHERE d.designation = :designation"),
		@NamedQuery(name = "DesignationClass.findByEmploymentsubtype", query = "SELECT d FROM DesignationClass d WHERE d.employmentsubtype = :employmentsubtype") })
public class DesignationClass implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	private BigDecimal id;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private BigInteger ppEmployeemasterid;
	@Column(name = "EMPLOYEECODE")
	private BigInteger employeecode;
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "EMPLOYMENTSUBTYPE")
	private String employmentsubtype;

	public DesignationClass() {
	}

	public DesignationClass(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigInteger getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(BigInteger ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public BigInteger getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(BigInteger employeecode) {
		this.employeecode = employeecode;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmploymentsubtype() {
		return employmentsubtype;
	}

	public void setEmploymentsubtype(String employmentsubtype) {
		this.employmentsubtype = employmentsubtype;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof DesignationClass)) {
			return false;
		}
		DesignationClass other = (DesignationClass) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.DesignationClass[ id=" + id + " ]";
	}

}
