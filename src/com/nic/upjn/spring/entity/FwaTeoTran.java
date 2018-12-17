/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "FWA_TEO_TRAN")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FwaTeoTran.findAll", query = "SELECT f FROM FwaTeoTran f"),
		@NamedQuery(name = "FwaTeoTran.findByFwaTeoTranid", query = "SELECT f FROM FwaTeoTran f WHERE f.fwaTeoTranid = :fwaTeoTranid"),
		@NamedQuery(name = "FwaTeoTran.findByAmount", query = "SELECT f FROM FwaTeoTran f WHERE f.amount = :amount"),
		@NamedQuery(name = "FwaTeoTran.findByPLedgTypecode", query = "SELECT f FROM FwaTeoTran f WHERE f.pLedgTypecode = :pLedgTypecode"),
		@NamedQuery(name = "FwaTeoTran.findByPLedgId", query = "SELECT f FROM FwaTeoTran f WHERE f.pLedgId = :pLedgId"),
		@NamedQuery(name = "FwaTeoTran.findByCrdr", query = "SELECT f FROM FwaTeoTran f WHERE f.crdr = :crdr") })
public class FwaTeoTran implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "FWA_TEO_TRANID")
	private Long fwaTeoTranid;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Column(name = "P_LEDG_TYPECODE")
	private String pLedgTypecode;
	@Column(name = "P_LEDG_ID")
	private Long pLedgId;
	@Basic(optional = false)
	@Column(name = "CRDR")
	private String crdr;
	@JoinColumn(name = "FWA_AC_CODE_MASTERID", referencedColumnName = "FWA_AC_CODE_MASTERID")
	@ManyToOne(optional = false)
	private FwaAcCodeMaster fwaAcCodeMasterid;
	@JoinColumn(name = "FWA_TEOID", referencedColumnName = "FWA_TEOID")
	@ManyToOne(optional = false)
	private FwaTeo fwaTeoid;

	public FwaTeoTran() {
	}

	public FwaTeoTran(Long fwaTeoTranid) {
		this.fwaTeoTranid = fwaTeoTranid;
	}

	public FwaTeoTran(Long fwaTeoTranid, BigDecimal amount, String crdr) {
		this.fwaTeoTranid = fwaTeoTranid;
		this.amount = amount;
		this.crdr = crdr;
	}

	public Long getFwaTeoTranid() {
		return fwaTeoTranid;
	}

	public void setFwaTeoTranid(Long fwaTeoTranid) {
		this.fwaTeoTranid = fwaTeoTranid;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPLedgTypecode() {
		return pLedgTypecode;
	}

	public void setPLedgTypecode(String pLedgTypecode) {
		this.pLedgTypecode = pLedgTypecode;
	}

	public Long getPLedgId() {
		return pLedgId;
	}

	public void setPLedgId(Long pLedgId) {
		this.pLedgId = pLedgId;
	}

	public String getCrdr() {
		return crdr;
	}

	public void setCrdr(String crdr) {
		this.crdr = crdr;
	}

	public FwaAcCodeMaster getFwaAcCodeMasterid() {
		return fwaAcCodeMasterid;
	}

	public void setFwaAcCodeMasterid(FwaAcCodeMaster fwaAcCodeMasterid) {
		this.fwaAcCodeMasterid = fwaAcCodeMasterid;
	}

	public FwaTeo getFwaTeoid() {
		return fwaTeoid;
	}

	public void setFwaTeoid(FwaTeo fwaTeoid) {
		this.fwaTeoid = fwaTeoid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (fwaTeoTranid != null ? fwaTeoTranid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof FwaTeoTran)) {
			return false;
		}
		FwaTeoTran other = (FwaTeoTran) object;
		if ((this.fwaTeoTranid == null && other.fwaTeoTranid != null)
				|| (this.fwaTeoTranid != null && !this.fwaTeoTranid.equals(other.fwaTeoTranid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.FwaTeoTran[ fwaTeoTranid=" + fwaTeoTranid + " ]";
	}

}
