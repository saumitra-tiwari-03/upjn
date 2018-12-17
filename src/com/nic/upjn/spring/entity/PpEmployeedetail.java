/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "PP_EMPLOYEEDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpEmployeedetail.findAll", query = "SELECT p FROM PpEmployeedetail p"),
		@NamedQuery(name = "PpEmployeedetail.findByPpEmployeedetailid", query = "SELECT p FROM PpEmployeedetail p WHERE p.ppEmployeedetailid = :ppEmployeedetailid"),
		@NamedQuery(name = "PpEmployeedetail.findByPpEmployeemasterid", query = "FROM PpEmployeedetail WHERE ppEmployeemasterid = ?"),
		@NamedQuery(name = "PpEmployeedetail.findByConfirmorderno", query = "SELECT p FROM PpEmployeedetail p WHERE p.confirmorderno = :confirmorderno"),
		@NamedQuery(name = "PpEmployeedetail.findByPermanentorderno", query = "SELECT p FROM PpEmployeedetail p WHERE p.permanentorderno = :permanentorderno"),
		@NamedQuery(name = "PpEmployeedetail.findByPermanentorderdate", query = "SELECT p FROM PpEmployeedetail p WHERE p.permanentorderdate = :permanentorderdate"),
		@NamedQuery(name = "PpEmployeedetail.findByGpfacno", query = "SELECT p FROM PpEmployeedetail p WHERE p.gpfacno = :gpfacno"),
		@NamedQuery(name = "PpEmployeedetail.findByBankaccno", query = "SELECT p FROM PpEmployeedetail p WHERE p.bankaccno = :bankaccno"),
		@NamedQuery(name = "PpEmployeedetail.findByConfirmorderdate", query = "SELECT p FROM PpEmployeedetail p WHERE p.confirmorderdate = :confirmorderdate"),
		@NamedQuery(name = "PpEmployeedetail.findByConfirmeffectivedate", query = "SELECT p FROM PpEmployeedetail p WHERE p.confirmeffectivedate = :confirmeffectivedate"),
		@NamedQuery(name = "PpEmployeedetail.findByRetirementdate", query = "SELECT p FROM PpEmployeedetail p WHERE p.retirementdate = :retirementdate"),
		@NamedQuery(name = "PpEmployeedetail.findByRetirementage", query = "SELECT p FROM PpEmployeedetail p WHERE p.retirementage = :retirementage"),
		@NamedQuery(name = "PpEmployeedetail.findByMaxmedicalleave", query = "SELECT p FROM PpEmployeedetail p WHERE p.maxmedicalleave = :maxmedicalleave"),
		@NamedQuery(name = "PpEmployeedetail.findByPpPlacemasterid", query = "SELECT p FROM PpEmployeedetail p WHERE p.ppPlacemasterid = :ppPlacemasterid"),
		@NamedQuery(name = "PpEmployeedetail.findByIsconfirm", query = "SELECT p FROM PpEmployeedetail p WHERE p.isconfirm = :isconfirm"),
		@NamedQuery(name = "PpEmployeedetail.findByIspermanent", query = "SELECT p FROM PpEmployeedetail p WHERE p.ispermanent = :ispermanent"),
		@NamedQuery(name = "PpEmployeedetail.findByPpCurrentstatusid", query = "SELECT p FROM PpEmployeedetail p WHERE p.ppCurrentstatusid = :ppCurrentstatusid"),
		@NamedQuery(name = "PpEmployeedetail.findByGpfNomdate", query = "SELECT p FROM PpEmployeedetail p WHERE p.gpfNomdate = :gpfNomdate"),
		@NamedQuery(name = "PpEmployeedetail.findByGratNomdate", query = "SELECT p FROM PpEmployeedetail p WHERE p.gratNomdate = :gratNomdate"),
		@NamedQuery(name = "PpEmployeedetail.findByInsuNomdate", query = "SELECT p FROM PpEmployeedetail p WHERE p.insuNomdate = :insuNomdate"),
		@NamedQuery(name = "PpEmployeedetail.findByPensNomdate", query = "SELECT p FROM PpEmployeedetail p WHERE p.pensNomdate = :pensNomdate"),
		@NamedQuery(name = "PpEmployeedetail.findByMasBankbranchid", query = "SELECT p FROM PpEmployeedetail p WHERE p.masBankbranchid = :masBankbranchid"),
		@NamedQuery(name = "PpEmployeedetail.findByPanno", query = "SELECT p FROM PpEmployeedetail p WHERE p.panno = :panno"),
		@NamedQuery(name = "PpEmployeedetail.findByIsnps", query = "SELECT p FROM PpEmployeedetail p WHERE p.isnps = :isnps") })
public class PpEmployeedetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_PP_EMPLOYEEDETAIL")
	
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEDETAILID")
	private Long ppEmployeedetailid;
	@Column(name = "CONFIRMORDERNO")
	private String confirmorderno;
	@Column(name = "PERMANENTORDERNO")
	private String permanentorderno;
	@Column(name = "PERMANENTORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date permanentorderdate;
	@Column(name = "GPFACNO")
	private String gpfacno;
	@Column(name = "BANKACCNO")
	private String bankaccno;
	@Column(name = "CONFIRMORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date confirmorderdate;
	@Column(name = "CONFIRMEFFECTIVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date confirmeffectivedate;
	@Column(name = "RETIREMENTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date retirementdate;
	@Column(name = "RETIREMENTAGE")
	private Short retirementage;
	@Column(name = "MAXMEDICALLEAVE")
	private Short maxmedicalleave;
	@Column(name = "PP_PLACEMASTERID")
	private Integer ppPlacemasterid;
	@Basic(optional = false)
	@Column(name = "ISCONFIRM")
	private Character isconfirm;
	@Basic(optional = false)
	@Column(name = "ISPERMANENT")
	private Character ispermanent;
	@Column(name = "PP_CURRENTSTATUSID")
	private String ppCurrentstatusid;
	@Column(name = "GPF_NOMDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date gpfNomdate;
	@Column(name = "GRAT_NOMDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date gratNomdate;
	@Column(name = "INSU_NOMDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insuNomdate;
	@Column(name = "PENS_NOMDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date pensNomdate;
	@Column(name = "MAS_BANKBRANCHID")
	private Integer masBankbranchid;
	@Column(name = "PANNO")
	private String panno;
	@Column(name = "ISNPS")
	private String isnps;
	@Id
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;

	public PpEmployeedetail() {
	}

	public PpEmployeedetail(Long ppEmployeedetailid) {
		this.ppEmployeedetailid = ppEmployeedetailid;
	}

	public PpEmployeedetail(Long ppEmployeedetailid, Character isconfirm, Character ispermanent) {
		this.ppEmployeedetailid = ppEmployeedetailid;
		this.isconfirm = isconfirm;
		this.ispermanent = ispermanent;
	}

	public Long getPpEmployeedetailid() {
		return ppEmployeedetailid;
	}

	public void setPpEmployeedetailid(Long ppEmployeedetailid) {
		this.ppEmployeedetailid = ppEmployeedetailid;
	}

	public String getConfirmorderno() {
		return confirmorderno;
	}

	public void setConfirmorderno(String confirmorderno) {
		this.confirmorderno = confirmorderno;
	}

	public String getPermanentorderno() {
		return permanentorderno;
	}

	public void setPermanentorderno(String permanentorderno) {
		this.permanentorderno = permanentorderno;
	}

	public Date getPermanentorderdate() {
		return permanentorderdate;
	}

	public void setPermanentorderdate(Date permanentorderdate) {
		this.permanentorderdate = permanentorderdate;
	}

	public String getGpfacno() {
		return gpfacno;
	}

	public void setGpfacno(String gpfacno) {
		this.gpfacno = gpfacno;
	}

	public String getBankaccno() {
		return bankaccno;
	}

	public void setBankaccno(String bankaccno) {
		this.bankaccno = bankaccno;
	}

	public Date getConfirmorderdate() {
		return confirmorderdate;
	}

	public void setConfirmorderdate(Date confirmorderdate) {
		this.confirmorderdate = confirmorderdate;
	}

	public Date getConfirmeffectivedate() {
		return confirmeffectivedate;
	}

	public void setConfirmeffectivedate(Date confirmeffectivedate) {
		this.confirmeffectivedate = confirmeffectivedate;
	}

	public Date getRetirementdate() {
		return retirementdate;
	}

	public void setRetirementdate(Date retirementdate) {
		this.retirementdate = retirementdate;
	}

	public Short getRetirementage() {
		return retirementage;
	}

	public void setRetirementage(Short retirementage) {
		this.retirementage = retirementage;
	}

	public Short getMaxmedicalleave() {
		return maxmedicalleave;
	}

	public void setMaxmedicalleave(Short maxmedicalleave) {
		this.maxmedicalleave = maxmedicalleave;
	}

	public Integer getPpPlacemasterid() {
		return ppPlacemasterid;
	}

	public void setPpPlacemasterid(Integer ppPlacemasterid) {
		this.ppPlacemasterid = ppPlacemasterid;
	}

	public Character getIsconfirm() {
		return isconfirm;
	}

	public void setIsconfirm(Character isconfirm) {
		this.isconfirm = isconfirm;
	}

	public Character getIspermanent() {
		return ispermanent;
	}

	public void setIspermanent(Character ispermanent) {
		this.ispermanent = ispermanent;
	}

	public String getPpCurrentstatusid() {
		return ppCurrentstatusid;
	}

	public void setPpCurrentstatusid(String ppCurrentstatusid) {
		this.ppCurrentstatusid = ppCurrentstatusid;
	}

	public Date getGpfNomdate() {
		return gpfNomdate;
	}

	public void setGpfNomdate(Date gpfNomdate) {
		this.gpfNomdate = gpfNomdate;
	}

	public Date getGratNomdate() {
		return gratNomdate;
	}

	public void setGratNomdate(Date gratNomdate) {
		this.gratNomdate = gratNomdate;
	}

	public Date getInsuNomdate() {
		return insuNomdate;
	}

	public void setInsuNomdate(Date insuNomdate) {
		this.insuNomdate = insuNomdate;
	}

	public Date getPensNomdate() {
		return pensNomdate;
	}

	public void setPensNomdate(Date pensNomdate) {
		this.pensNomdate = pensNomdate;
	}

	public Integer getMasBankbranchid() {
		return masBankbranchid;
	}

	public void setMasBankbranchid(Integer masBankbranchid) {
		this.masBankbranchid = masBankbranchid;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public String getIsnps() {
		return isnps;
	}

	public void setIsnps(String isnps) {
		this.isnps = isnps;
	}

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppEmployeedetailid != null ? ppEmployeedetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpEmployeedetail)) {
			return false;
		}
		PpEmployeedetail other = (PpEmployeedetail) object;
		if ((this.ppEmployeedetailid == null && other.ppEmployeedetailid != null)
				|| (this.ppEmployeedetailid != null && !this.ppEmployeedetailid.equals(other.ppEmployeedetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpEmployeedetail[ ppEmployeedetailid=" + ppEmployeedetailid + " ]";
	}

}
