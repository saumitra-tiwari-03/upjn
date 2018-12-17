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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "SMM_GRN_PURCHASED")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmGrnPurchased.findAll", query = "SELECT s FROM SmmGrnPurchased s"),
		@NamedQuery(name = "SmmGrnPurchased.findBySmmGrnPurchasedid", query = "SELECT s FROM SmmGrnPurchased s WHERE s.smmGrnPurchasedid = :smmGrnPurchasedid"),
		@NamedQuery(name = "SmmGrnPurchased.findByInvoiceDate", query = "SELECT s FROM SmmGrnPurchased s WHERE s.invoiceDate = :invoiceDate"),
		@NamedQuery(name = "SmmGrnPurchased.findByInvoiceNo", query = "SELECT s FROM SmmGrnPurchased s WHERE s.invoiceNo = :invoiceNo"),
		@NamedQuery(name = "SmmGrnPurchased.findBySpSchememasterid", query = "SELECT s FROM SmmGrnPurchased s WHERE s.spSchememasterid = :spSchememasterid"),
		@NamedQuery(name = "SmmGrnPurchased.findByRmOfficeid", query = "SELECT s FROM SmmGrnPurchased s WHERE s.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "SmmGrnPurchased.findByDtrNo", query = "SELECT s FROM SmmGrnPurchased s WHERE s.dtrNo = :dtrNo"),
		@NamedQuery(name = "SmmGrnPurchased.findByJeName", query = "SELECT s FROM SmmGrnPurchased s WHERE s.jeName = :jeName"),
		@NamedQuery(name = "SmmGrnPurchased.findByPurchaseFolio", query = "SELECT s FROM SmmGrnPurchased s WHERE s.purchaseFolio = :purchaseFolio"),
		@NamedQuery(name = "SmmGrnPurchased.findByGrnNo", query = "SELECT s FROM SmmGrnPurchased s WHERE s.grnNo = :grnNo"),
		@NamedQuery(name = "SmmGrnPurchased.findByPurchasedthrough", query = "SELECT s FROM SmmGrnPurchased s WHERE s.purchasedthrough = :purchasedthrough"),
		@NamedQuery(name = "SmmGrnPurchased.findByIsVerifiedbyFinance", query = "SELECT s FROM SmmGrnPurchased s WHERE s.isVerifiedbyFinance = :isVerifiedbyFinance"),
		@NamedQuery(name = "SmmGrnPurchased.findByGrnDate", query = "SELECT s FROM SmmGrnPurchased s WHERE s.grnDate = :grnDate") })
public class SmmGrnPurchased implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_GRN_PURCHASEDID")
	private Long smmGrnPurchasedid;
	@Basic(optional = false)
	@Column(name = "INVOICE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date invoiceDate;
	@Basic(optional = false)
	@Column(name = "INVOICE_NO")
	private String invoiceNo;
	@Basic(optional = false)
	@Column(name = "SP_SCHEMEMASTERID")
	private long spSchememasterid;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Basic(optional = false)
	@Column(name = "DTR_NO")
	private String dtrNo;
	@Basic(optional = false)
	@Column(name = "JE_NAME")
	private String jeName;
	@Basic(optional = false)
	@Column(name = "PURCHASE_FOLIO")
	private String purchaseFolio;
	@Basic(optional = false)
	@Column(name = "GRN_NO")
	private String grnNo;
	@Basic(optional = false)
	@Column(name = "PURCHASEDTHROUGH")
	private String purchasedthrough;
	@Basic(optional = false)
	@Column(name = "IS_VERIFIEDBY_FINANCE")
	private Character isVerifiedbyFinance;
	@Column(name = "GRN_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date grnDate;
	@JoinColumn(name = "SMM_SUPPLIERID", referencedColumnName = "SMM_SUPPLIERID")
	@ManyToOne
	private SmmSupplier smmSupplierid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "smmGrnPurchasedid")
	private Collection<SmmItempurchase> smmItempurchaseCollection;

	public SmmGrnPurchased() {
	}

	public SmmGrnPurchased(Long smmGrnPurchasedid) {
		this.smmGrnPurchasedid = smmGrnPurchasedid;
	}

	public SmmGrnPurchased(Long smmGrnPurchasedid, Date invoiceDate, String invoiceNo, long spSchememasterid,
			int rmOfficeid, String dtrNo, String jeName, String purchaseFolio, String grnNo, String purchasedthrough,
			Character isVerifiedbyFinance) {
		this.smmGrnPurchasedid = smmGrnPurchasedid;
		this.invoiceDate = invoiceDate;
		this.invoiceNo = invoiceNo;
		this.spSchememasterid = spSchememasterid;
		this.rmOfficeid = rmOfficeid;
		this.dtrNo = dtrNo;
		this.jeName = jeName;
		this.purchaseFolio = purchaseFolio;
		this.grnNo = grnNo;
		this.purchasedthrough = purchasedthrough;
		this.isVerifiedbyFinance = isVerifiedbyFinance;
	}

	public Long getSmmGrnPurchasedid() {
		return smmGrnPurchasedid;
	}

	public void setSmmGrnPurchasedid(Long smmGrnPurchasedid) {
		this.smmGrnPurchasedid = smmGrnPurchasedid;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public long getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(long spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getDtrNo() {
		return dtrNo;
	}

	public void setDtrNo(String dtrNo) {
		this.dtrNo = dtrNo;
	}

	public String getJeName() {
		return jeName;
	}

	public void setJeName(String jeName) {
		this.jeName = jeName;
	}

	public String getPurchaseFolio() {
		return purchaseFolio;
	}

	public void setPurchaseFolio(String purchaseFolio) {
		this.purchaseFolio = purchaseFolio;
	}

	public String getGrnNo() {
		return grnNo;
	}

	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}

	public String getPurchasedthrough() {
		return purchasedthrough;
	}

	public void setPurchasedthrough(String purchasedthrough) {
		this.purchasedthrough = purchasedthrough;
	}

	public Character getIsVerifiedbyFinance() {
		return isVerifiedbyFinance;
	}

	public void setIsVerifiedbyFinance(Character isVerifiedbyFinance) {
		this.isVerifiedbyFinance = isVerifiedbyFinance;
	}

	public Date getGrnDate() {
		return grnDate;
	}

	public void setGrnDate(Date grnDate) {
		this.grnDate = grnDate;
	}

	public SmmSupplier getSmmSupplierid() {
		return smmSupplierid;
	}

	public void setSmmSupplierid(SmmSupplier smmSupplierid) {
		this.smmSupplierid = smmSupplierid;
	}

	@XmlTransient
	public Collection<SmmItempurchase> getSmmItempurchaseCollection() {
		return smmItempurchaseCollection;
	}

	public void setSmmItempurchaseCollection(Collection<SmmItempurchase> smmItempurchaseCollection) {
		this.smmItempurchaseCollection = smmItempurchaseCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmGrnPurchasedid != null ? smmGrnPurchasedid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmGrnPurchased)) {
			return false;
		}
		SmmGrnPurchased other = (SmmGrnPurchased) object;
		if ((this.smmGrnPurchasedid == null && other.smmGrnPurchasedid != null)
				|| (this.smmGrnPurchasedid != null && !this.smmGrnPurchasedid.equals(other.smmGrnPurchasedid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmGrnPurchased[ smmGrnPurchasedid=" + smmGrnPurchasedid + " ]";
	}

}
