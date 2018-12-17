/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SMM_OUTOFFOC_MRN")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmOutoffocMrn.findAll", query = "SELECT s FROM SmmOutoffocMrn s"),
		@NamedQuery(name = "SmmOutoffocMrn.findBySmmOutoffocMrnid", query = "SELECT s FROM SmmOutoffocMrn s WHERE s.smmOutoffocMrnid = :smmOutoffocMrnid"),
		@NamedQuery(name = "SmmOutoffocMrn.findByQuantityconsumed", query = "SELECT s FROM SmmOutoffocMrn s WHERE s.quantityconsumed = :quantityconsumed"),
		@NamedQuery(name = "SmmOutoffocMrn.findByMrnNo", query = "SELECT s FROM SmmOutoffocMrn s WHERE s.mrnNo = :mrnNo"),
		@NamedQuery(name = "SmmOutoffocMrn.findByMrnDate", query = "SELECT s FROM SmmOutoffocMrn s WHERE s.mrnDate = :mrnDate"),
		@NamedQuery(name = "SmmOutoffocMrn.findByCost", query = "SELECT s FROM SmmOutoffocMrn s WHERE s.cost = :cost"),
		@NamedQuery(name = "SmmOutoffocMrn.findBySysMrntypeid", query = "SELECT s FROM SmmOutoffocMrn s WHERE s.sysMrntypeid = :sysMrntypeid"),
		@NamedQuery(name = "SmmOutoffocMrn.findByIsVerified", query = "SELECT s FROM SmmOutoffocMrn s WHERE s.isVerified = :isVerified") })
public class SmmOutoffocMrn implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_OUTOFFOC_MRNID")
	private Long smmOutoffocMrnid;
	@Basic(optional = false)
	@Column(name = "QUANTITYCONSUMED")
	private long quantityconsumed;
	@Basic(optional = false)
	@Column(name = "MRN_NO")
	private String mrnNo;
	@Basic(optional = false)
	@Column(name = "MRN_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mrnDate;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "COST")
	private BigDecimal cost;
	@Basic(optional = false)
	@Column(name = "SYS_MRNTYPEID")
	private int sysMrntypeid;
	@Basic(optional = false)
	@Column(name = "IS_VERIFIED")
	private Character isVerified;
	@JoinColumn(name = "SMM_MATERIALCONSUMPTIONID", referencedColumnName = "SMM_MATERIALCONSUMPTIONID")
	@ManyToOne(optional = false)
	private SmmMaterialconsumption smmMaterialconsumptionid;

	public SmmOutoffocMrn() {
	}

	public SmmOutoffocMrn(Long smmOutoffocMrnid) {
		this.smmOutoffocMrnid = smmOutoffocMrnid;
	}

	public SmmOutoffocMrn(Long smmOutoffocMrnid, long quantityconsumed, String mrnNo, Date mrnDate, BigDecimal cost,
			int sysMrntypeid, Character isVerified) {
		this.smmOutoffocMrnid = smmOutoffocMrnid;
		this.quantityconsumed = quantityconsumed;
		this.mrnNo = mrnNo;
		this.mrnDate = mrnDate;
		this.cost = cost;
		this.sysMrntypeid = sysMrntypeid;
		this.isVerified = isVerified;
	}

	public Long getSmmOutoffocMrnid() {
		return smmOutoffocMrnid;
	}

	public void setSmmOutoffocMrnid(Long smmOutoffocMrnid) {
		this.smmOutoffocMrnid = smmOutoffocMrnid;
	}

	public long getQuantityconsumed() {
		return quantityconsumed;
	}

	public void setQuantityconsumed(long quantityconsumed) {
		this.quantityconsumed = quantityconsumed;
	}

	public String getMrnNo() {
		return mrnNo;
	}

	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	public Date getMrnDate() {
		return mrnDate;
	}

	public void setMrnDate(Date mrnDate) {
		this.mrnDate = mrnDate;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public int getSysMrntypeid() {
		return sysMrntypeid;
	}

	public void setSysMrntypeid(int sysMrntypeid) {
		this.sysMrntypeid = sysMrntypeid;
	}

	public Character getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Character isVerified) {
		this.isVerified = isVerified;
	}

	public SmmMaterialconsumption getSmmMaterialconsumptionid() {
		return smmMaterialconsumptionid;
	}

	public void setSmmMaterialconsumptionid(SmmMaterialconsumption smmMaterialconsumptionid) {
		this.smmMaterialconsumptionid = smmMaterialconsumptionid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmOutoffocMrnid != null ? smmOutoffocMrnid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmOutoffocMrn)) {
			return false;
		}
		SmmOutoffocMrn other = (SmmOutoffocMrn) object;
		if ((this.smmOutoffocMrnid == null && other.smmOutoffocMrnid != null)
				|| (this.smmOutoffocMrnid != null && !this.smmOutoffocMrnid.equals(other.smmOutoffocMrnid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmOutoffocMrn[ smmOutoffocMrnid=" + smmOutoffocMrnid + " ]";
	}

}
