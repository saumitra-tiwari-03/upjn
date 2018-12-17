/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_DED_RULESDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpDedRulesdetail.findAll", query = "SELECT p FROM PpDedRulesdetail p"),
		@NamedQuery(name = "PpDedRulesdetail.findByPpDedRulesdetailid", query = "SELECT p FROM PpDedRulesdetail p WHERE p.ppDedRulesdetailid = :ppDedRulesdetailid"),
		@NamedQuery(name = "PpDedRulesdetail.findByMasEmploymentsubtypeid", query = "SELECT p FROM PpDedRulesdetail p WHERE p.masEmploymentsubtypeid = :masEmploymentsubtypeid"),
		@NamedQuery(name = "PpDedRulesdetail.findByDefaultvalue", query = "SELECT p FROM PpDedRulesdetail p WHERE p.defaultvalue = :defaultvalue") })
public class PpDedRulesdetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_DED_RULESDETAILID")
	private Long ppDedRulesdetailid;
	@Basic(optional = false)
	@Column(name = "MAS_EMPLOYMENTSUBTYPEID")
	private int masEmploymentsubtypeid;
	@Basic(optional = false)
	@Column(name = "DEFAULTVALUE")
	private String defaultvalue;
	@JoinColumn(name = "PP_DEDUCTIONMASTERID", referencedColumnName = "PP_DEDUCTIONMASTERID")
	@ManyToOne(optional = false)
	private PpDeductionmaster ppDeductionmasterid;

	public PpDedRulesdetail() {
	}

	public PpDedRulesdetail(Long ppDedRulesdetailid) {
		this.ppDedRulesdetailid = ppDedRulesdetailid;
	}

	public PpDedRulesdetail(Long ppDedRulesdetailid, int masEmploymentsubtypeid, String defaultvalue) {
		this.ppDedRulesdetailid = ppDedRulesdetailid;
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
		this.defaultvalue = defaultvalue;
	}

	public Long getPpDedRulesdetailid() {
		return ppDedRulesdetailid;
	}

	public void setPpDedRulesdetailid(Long ppDedRulesdetailid) {
		this.ppDedRulesdetailid = ppDedRulesdetailid;
	}

	public int getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(int masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public String getDefaultvalue() {
		return defaultvalue;
	}

	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}

	public PpDeductionmaster getPpDeductionmasterid() {
		return ppDeductionmasterid;
	}

	public void setPpDeductionmasterid(PpDeductionmaster ppDeductionmasterid) {
		this.ppDeductionmasterid = ppDeductionmasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppDedRulesdetailid != null ? ppDedRulesdetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpDedRulesdetail)) {
			return false;
		}
		PpDedRulesdetail other = (PpDedRulesdetail) object;
		if ((this.ppDedRulesdetailid == null && other.ppDedRulesdetailid != null)
				|| (this.ppDedRulesdetailid != null && !this.ppDedRulesdetailid.equals(other.ppDedRulesdetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpDedRulesdetail[ ppDedRulesdetailid=" + ppDedRulesdetailid + " ]";
	}

}
