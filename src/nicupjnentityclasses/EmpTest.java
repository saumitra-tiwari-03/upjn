/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "EMP_TEST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "EmpTest.findAll", query = "SELECT e FROM EmpTest e"),
		@NamedQuery(name = "EmpTest.findById", query = "SELECT e FROM EmpTest e WHERE e.id = :id"),
		@NamedQuery(name = "EmpTest.findByEmpMasterid", query = "SELECT e FROM EmpTest e WHERE e.empMasterid = :empMasterid"),
		@NamedQuery(name = "EmpTest.findByLocationName", query = "SELECT e FROM EmpTest e WHERE e.locationName = :locationName"),
		@NamedQuery(name = "EmpTest.findByFinalCode", query = "SELECT e FROM EmpTest e WHERE e.finalCode = :finalCode"),
		@NamedQuery(name = "EmpTest.findByEmpName", query = "SELECT e FROM EmpTest e WHERE e.empName = :empName"),
		@NamedQuery(name = "EmpTest.findByFathersName", query = "SELECT e FROM EmpTest e WHERE e.fathersName = :fathersName"),
		@NamedQuery(name = "EmpTest.findByCurrentDesignation", query = "SELECT e FROM EmpTest e WHERE e.currentDesignation = :currentDesignation"),
		@NamedQuery(name = "EmpTest.findByDob", query = "SELECT e FROM EmpTest e WHERE e.dob = :dob"),
		@NamedQuery(name = "EmpTest.findByAppDate", query = "SELECT e FROM EmpTest e WHERE e.appDate = :appDate"),
		@NamedQuery(name = "EmpTest.findByCasteCat", query = "SELECT e FROM EmpTest e WHERE e.casteCat = :casteCat"),
		@NamedQuery(name = "EmpTest.findByEmpCode1", query = "SELECT e FROM EmpTest e WHERE e.empCode1 = :empCode1"),
		@NamedQuery(name = "EmpTest.findByEmpCode", query = "SELECT e FROM EmpTest e WHERE e.empCode = :empCode"),
		@NamedQuery(name = "EmpTest.findByEmpCode2", query = "SELECT e FROM EmpTest e WHERE e.empCode2 = :empCode2") })
public class EmpTest implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	private BigDecimal id;
	@Column(name = "EMP_MASTERID")
	private String empMasterid;
	@Column(name = "LOCATION_NAME")
	private String locationName;
	@Column(name = "FINAL_CODE")
	private String finalCode;
	@Column(name = "EMP_NAME")
	private String empName;
	@Column(name = "FATHERS_NAME")
	private String fathersName;
	@Column(name = "CURRENT_DESIGNATION")
	private String currentDesignation;
	@Column(name = "DOB")
	private String dob;
	@Column(name = "APP_DATE")
	private String appDate;
	@Column(name = "CASTE_CAT")
	private String casteCat;
	@Column(name = "EMP_CODE1")
	private String empCode1;
	@Column(name = "EMP_CODE")
	private String empCode;
	@Column(name = "EMP_CODE2")
	private String empCode2;

	public EmpTest() {
	}

	public EmpTest(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getEmpMasterid() {
		return empMasterid;
	}

	public void setEmpMasterid(String empMasterid) {
		this.empMasterid = empMasterid;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getFinalCode() {
		return finalCode;
	}

	public void setFinalCode(String finalCode) {
		this.finalCode = finalCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getCurrentDesignation() {
		return currentDesignation;
	}

	public void setCurrentDesignation(String currentDesignation) {
		this.currentDesignation = currentDesignation;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAppDate() {
		return appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	public String getCasteCat() {
		return casteCat;
	}

	public void setCasteCat(String casteCat) {
		this.casteCat = casteCat;
	}

	public String getEmpCode1() {
		return empCode1;
	}

	public void setEmpCode1(String empCode1) {
		this.empCode1 = empCode1;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpCode2() {
		return empCode2;
	}

	public void setEmpCode2(String empCode2) {
		this.empCode2 = empCode2;
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
		if (!(object instanceof EmpTest)) {
			return false;
		}
		EmpTest other = (EmpTest) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.EmpTest[ id=" + id + " ]";
	}

}
