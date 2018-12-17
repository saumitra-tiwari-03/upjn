/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_EMPLOYEEMASTER")
@XmlRootElement

@NamedQueries({ @NamedQuery(name = "PpEmployeemaster.findAll", query = "SELECT p FROM PpEmployeemaster p"),
		@NamedQuery(name = "PpEmployeemaster.findByPpEmployeemasterid", query = "FROM PpEmployeemaster WHERE ppEmployeemasterid = ?"),
		@NamedQuery(name = "PpEmployeemaster.findByEmployeecode", query = "FROM PpEmployeemaster WHERE employeecode = ?"),
		@NamedQuery(name = "PpEmployeemaster.findByFirstname", query = "SELECT p FROM PpEmployeemaster p WHERE p.firstname = :firstname"),
		@NamedQuery(name = "PpEmployeemaster.findByMiddlename", query = "SELECT p FROM PpEmployeemaster p WHERE p.middlename = :middlename"),
		@NamedQuery(name = "PpEmployeemaster.findByLastname", query = "SELECT p FROM PpEmployeemaster p WHERE p.lastname = :lastname"),
		@NamedQuery(name = "PpEmployeemaster.findByPassword", query = "SELECT p FROM PpEmployeemaster p WHERE p.password = :password"),
		@NamedQuery(name = "PpEmployeemaster.findByPpDesignationmasterid", query = "SELECT p FROM PpEmployeemaster p WHERE p.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "PpEmployeemaster.findByIsdisablefinancial", query = "SELECT p FROM PpEmployeemaster p WHERE p.isdisablefinancial = :isdisablefinancial"),
		@NamedQuery(name = "PpEmployeemaster.findByIsretired", query = "SELECT p FROM PpEmployeemaster p WHERE p.isretired = :isretired"),
		@NamedQuery(name = "PpEmployeemaster.findByIsfunctioning", query = "SELECT p FROM PpEmployeemaster p WHERE p.isfunctioning = :isfunctioning"),
		@NamedQuery(name = "PpEmployeemaster.findByEntryOfficeid", query = "SELECT p FROM PpEmployeemaster p WHERE p.entryOfficeid = :entryOfficeid"),
		@NamedQuery(name = "PpEmployeemaster.findByIsloginlocked", query = "SELECT p FROM PpEmployeemaster p WHERE p.isloginlocked = :isloginlocked"),
		@NamedQuery(name = "PpEmployeemaster.findByLastLoginDate", query = "SELECT p FROM PpEmployeemaster p WHERE p.lastLoginDate = :lastLoginDate"),
})



public class PpEmployeemaster implements Serializable {
	private static final long serialVersionUID = 1L;

	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_PP_EMPLOYEEMASTER", allocationSize = 1)
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
	
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
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Integer ppDesignationmasterid;
	@Basic(optional = false)
	@Column(name = "ISDISABLEFINANCIAL"/*,columnDefinition = "CHAR(1 BYTE) DEFAULT '0'"*/)
	private Character isdisablefinancial;
	//@Basic(optional = false)
	@Column(name = "ISRETIRED")
	private Character isretired;
	//@Basic(optional = false)
	@Column(name = "ISFUNCTIONING")
	private Character isfunctioning;
	@Column(name = "ENTRY_OFFICEID")
	private Long entryOfficeid;
	//@Basic(optional = false)
	@Column(name = "ISLOGINLOCKED")
	private Character isloginlocked;
	@Column(name = "LAST_LOGIN_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginDate;
	@Column(name = "MAS_EMPLOYMENTSUBTYPEID")
	private String masEmploymentsubtypeid;
	@Column(name = "RM_OFFICEID")
	private Integer RM_OFFICEID;
	@Column(name = "IS_REG_FORPENSION")
	private Integer IS_REG_FORPENSION;
	

	

	public Integer getRM_OFFICEID() {
		return RM_OFFICEID;
	}

	public void setRM_OFFICEID(Integer rM_OFFICEID) {
		RM_OFFICEID = rM_OFFICEID;
	}

	public String getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(String masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}
		public PpEmployeemaster() {
	}

	public PpEmployeemaster(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	
		
	}

	public PpEmployeemaster(Long ppEmployeemasterid, String employeecode, String firstname,
			Character isdisablefinancial, Character isretired, Character isfunctioning, Character isloginlocked) {
		this.ppEmployeemasterid = ppEmployeemasterid;
		this.employeecode = employeecode;
		this.firstname = firstname;
		this.isdisablefinancial = isdisablefinancial;
		this.isretired = isretired;
		this.isfunctioning = isfunctioning;
		this.isloginlocked = isloginlocked;
	}

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(Integer ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public Character getIsdisablefinancial() {
		return isdisablefinancial;
	}

	public void setIsdisablefinancial(Character isdisablefinancial) {
		this.isdisablefinancial = isdisablefinancial;
	}

	public Character getIsretired() {
		return isretired;
	}

	public void setIsretired(Character isretired) {
		this.isretired = isretired;
	}

	public Character getIsfunctioning() {
		return isfunctioning;
	}

	public void setIsfunctioning(Character isfunctioning) {
		this.isfunctioning = isfunctioning;
	}

	public Long getEntryOfficeid() {
		return entryOfficeid;
	}

	public void setEntryOfficeid(Long entryOfficeid) {
		this.entryOfficeid = entryOfficeid;
	}

	public Character getIsloginlocked() {
		return isloginlocked;
	}

	public void setIsloginlocked(Character isloginlocked) {
		this.isloginlocked = isloginlocked;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Integer getIS_REG_FORPENSION() {
		return IS_REG_FORPENSION;
	}

	public void setIS_REG_FORPENSION(Integer iS_REG_FORPENSION) {
		IS_REG_FORPENSION = iS_REG_FORPENSION;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppEmployeemasterid != null ? ppEmployeemasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpEmployeemaster)) {
			return false;
		}
		PpEmployeemaster other = (PpEmployeemaster) object;
		if ((this.ppEmployeemasterid == null && other.ppEmployeemasterid != null)
				|| (this.ppEmployeemasterid != null && !this.ppEmployeemasterid.equals(other.ppEmployeemasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpEmployeemaster[ ppEmployeemasterid=" + ppEmployeemasterid + " ]";
	}

}
