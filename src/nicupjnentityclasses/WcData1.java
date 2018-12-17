/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "WC_DATA1")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "WcData1.findAll", query = "SELECT w FROM WcData1 w"),
		@NamedQuery(name = "WcData1.findById", query = "SELECT w FROM WcData1 w WHERE w.id = :id"),
		@NamedQuery(name = "WcData1.findByFinalCode", query = "SELECT w FROM WcData1 w WHERE w.finalCode = :finalCode"),
		@NamedQuery(name = "WcData1.findByEmployeeName", query = "SELECT w FROM WcData1 w WHERE w.employeeName = :employeeName"),
		@NamedQuery(name = "WcData1.findByStage", query = "SELECT w FROM WcData1 w WHERE w.stage = :stage"),
		@NamedQuery(name = "WcData1.findByLocCode", query = "SELECT w FROM WcData1 w WHERE w.locCode = :locCode"),
		@NamedQuery(name = "WcData1.findByDobE4", query = "SELECT w FROM WcData1 w WHERE w.dobE4 = :dobE4"),
		@NamedQuery(name = "WcData1.findByCdesig", query = "SELECT w FROM WcData1 w WHERE w.cdesig = :cdesig"),
		@NamedQuery(name = "WcData1.findByNappDate", query = "SELECT w FROM WcData1 w WHERE w.nappDate = :nappDate"),
		@NamedQuery(name = "WcData1.findByFatherName", query = "SELECT w FROM WcData1 w WHERE w.fatherName = :fatherName"),
		@NamedQuery(name = "WcData1.findByCategory", query = "SELECT w FROM WcData1 w WHERE w.category = :category"),
		@NamedQuery(name = "WcData1.findByModeApp", query = "SELECT w FROM WcData1 w WHERE w.modeApp = :modeApp"),
		@NamedQuery(name = "WcData1.findByGender", query = "SELECT w FROM WcData1 w WHERE w.gender = :gender"),
		@NamedQuery(name = "WcData1.findByPpDesignationmasterid", query = "SELECT w FROM WcData1 w WHERE w.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "WcData1.findByMasEmploymenttypeid", query = "SELECT w FROM WcData1 w WHERE w.masEmploymenttypeid = :masEmploymenttypeid"),
		@NamedQuery(name = "WcData1.findByMasEmploymentsubtypeid", query = "SELECT w FROM WcData1 w WHERE w.masEmploymentsubtypeid = :masEmploymentsubtypeid") })
public class WcData1 implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	private BigDecimal id;
	@Column(name = "FINAL_CODE")
	private String finalCode;
	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;
	@Column(name = "STAGE")
	private String stage;
	@Column(name = "LOC_CODE")
	private BigInteger locCode;
	@Column(name = "DOB_E4")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dobE4;
	@Column(name = "CDESIG")
	private String cdesig;
	@Column(name = "NAPP_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date nappDate;
	@Column(name = "FATHER_NAME")
	private String fatherName;
	@Column(name = "CATEGORY")
	private String category;
	@Column(name = "MODE_APP")
	private String modeApp;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Integer ppDesignationmasterid;
	@Column(name = "MAS_EMPLOYMENTTYPEID")
	private Integer masEmploymenttypeid;
	@Column(name = "MAS_EMPLOYMENTSUBTYPEID")
	private Integer masEmploymentsubtypeid;

	public WcData1() {
	}

	public WcData1(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getFinalCode() {
		return finalCode;
	}

	public void setFinalCode(String finalCode) {
		this.finalCode = finalCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public BigInteger getLocCode() {
		return locCode;
	}

	public void setLocCode(BigInteger locCode) {
		this.locCode = locCode;
	}

	public Date getDobE4() {
		return dobE4;
	}

	public void setDobE4(Date dobE4) {
		this.dobE4 = dobE4;
	}

	public String getCdesig() {
		return cdesig;
	}

	public void setCdesig(String cdesig) {
		this.cdesig = cdesig;
	}

	public Date getNappDate() {
		return nappDate;
	}

	public void setNappDate(Date nappDate) {
		this.nappDate = nappDate;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getModeApp() {
		return modeApp;
	}

	public void setModeApp(String modeApp) {
		this.modeApp = modeApp;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(Integer ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public Integer getMasEmploymenttypeid() {
		return masEmploymenttypeid;
	}

	public void setMasEmploymenttypeid(Integer masEmploymenttypeid) {
		this.masEmploymenttypeid = masEmploymenttypeid;
	}

	public Integer getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(Integer masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
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
		if (!(object instanceof WcData1)) {
			return false;
		}
		WcData1 other = (WcData1) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.WcData1[ id=" + id + " ]";
	}

}
