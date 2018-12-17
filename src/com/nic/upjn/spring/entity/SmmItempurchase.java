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
@Table(name = "SMM_ITEMPURCHASE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmItempurchase.findAll", query = "SELECT s FROM SmmItempurchase s"),
		@NamedQuery(name = "SmmItempurchase.findBySmmItempurchaseid", query = "SELECT s FROM SmmItempurchase s WHERE s.smmItempurchaseid = :smmItempurchaseid"),
		@NamedQuery(name = "SmmItempurchase.findByQuantity", query = "SELECT s FROM SmmItempurchase s WHERE s.quantity = :quantity"),
		@NamedQuery(name = "SmmItempurchase.findByRate", query = "SELECT s FROM SmmItempurchase s WHERE s.rate = :rate"),
		@NamedQuery(name = "SmmItempurchase.findByCost", query = "SELECT s FROM SmmItempurchase s WHERE s.cost = :cost"),
		@NamedQuery(name = "SmmItempurchase.findByQuantityAsperChallan", query = "SELECT s FROM SmmItempurchase s WHERE s.quantityAsperChallan = :quantityAsperChallan"),
		@NamedQuery(name = "SmmItempurchase.findByInvoiceRate", query = "SELECT s FROM SmmItempurchase s WHERE s.invoiceRate = :invoiceRate"),
		@NamedQuery(name = "SmmItempurchase.findByMbNo", query = "SELECT s FROM SmmItempurchase s WHERE s.mbNo = :mbNo"),
		@NamedQuery(name = "SmmItempurchase.findByPageNo", query = "SELECT s FROM SmmItempurchase s WHERE s.pageNo = :pageNo"),
		@NamedQuery(name = "SmmItempurchase.findByMeasurementDate", query = "SELECT s FROM SmmItempurchase s WHERE s.measurementDate = :measurementDate"),
		@NamedQuery(name = "SmmItempurchase.findByQuantityRejected", query = "SELECT s FROM SmmItempurchase s WHERE s.quantityRejected = :quantityRejected") })
public class SmmItempurchase implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_ITEMPURCHASEID")
	private Long smmItempurchaseid;
	@Basic(optional = false)
	@Column(name = "QUANTITY")
	private long quantity;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "RATE")
	private BigDecimal rate;
	@Basic(optional = false)
	@Column(name = "COST")
	private BigDecimal cost;
	@Basic(optional = false)
	@Column(name = "QUANTITY_ASPER_CHALLAN")
	private long quantityAsperChallan;
	@Basic(optional = false)
	@Column(name = "INVOICE_RATE")
	private BigDecimal invoiceRate;
	@Basic(optional = false)
	@Column(name = "MB_NO")
	private String mbNo;
	@Basic(optional = false)
	@Column(name = "PAGE_NO")
	private String pageNo;
	@Column(name = "MEASUREMENT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date measurementDate;
	@Basic(optional = false)
	@Column(name = "QUANTITY_REJECTED")
	private long quantityRejected;
	@JoinColumn(name = "SMM_GRN_PURCHASEDID", referencedColumnName = "SMM_GRN_PURCHASEDID")
	@ManyToOne(optional = false)
	private SmmGrnPurchased smmGrnPurchasedid;
	@JoinColumn(name = "SMM_ITEMMASTERID", referencedColumnName = "SMM_ITEMMASTERID")
	@ManyToOne(optional = false)
	private SmmItemmaster smmItemmasterid;

	public SmmItempurchase() {
	}

	public SmmItempurchase(Long smmItempurchaseid) {
		this.smmItempurchaseid = smmItempurchaseid;
	}

	public SmmItempurchase(Long smmItempurchaseid, long quantity, BigDecimal rate, BigDecimal cost,
			long quantityAsperChallan, BigDecimal invoiceRate, String mbNo, String pageNo, long quantityRejected) {
		this.smmItempurchaseid = smmItempurchaseid;
		this.quantity = quantity;
		this.rate = rate;
		this.cost = cost;
		this.quantityAsperChallan = quantityAsperChallan;
		this.invoiceRate = invoiceRate;
		this.mbNo = mbNo;
		this.pageNo = pageNo;
		this.quantityRejected = quantityRejected;
	}

	public Long getSmmItempurchaseid() {
		return smmItempurchaseid;
	}

	public void setSmmItempurchaseid(Long smmItempurchaseid) {
		this.smmItempurchaseid = smmItempurchaseid;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public long getQuantityAsperChallan() {
		return quantityAsperChallan;
	}

	public void setQuantityAsperChallan(long quantityAsperChallan) {
		this.quantityAsperChallan = quantityAsperChallan;
	}

	public BigDecimal getInvoiceRate() {
		return invoiceRate;
	}

	public void setInvoiceRate(BigDecimal invoiceRate) {
		this.invoiceRate = invoiceRate;
	}

	public String getMbNo() {
		return mbNo;
	}

	public void setMbNo(String mbNo) {
		this.mbNo = mbNo;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public Date getMeasurementDate() {
		return measurementDate;
	}

	public void setMeasurementDate(Date measurementDate) {
		this.measurementDate = measurementDate;
	}

	public long getQuantityRejected() {
		return quantityRejected;
	}

	public void setQuantityRejected(long quantityRejected) {
		this.quantityRejected = quantityRejected;
	}

	public SmmGrnPurchased getSmmGrnPurchasedid() {
		return smmGrnPurchasedid;
	}

	public void setSmmGrnPurchasedid(SmmGrnPurchased smmGrnPurchasedid) {
		this.smmGrnPurchasedid = smmGrnPurchasedid;
	}

	public SmmItemmaster getSmmItemmasterid() {
		return smmItemmasterid;
	}

	public void setSmmItemmasterid(SmmItemmaster smmItemmasterid) {
		this.smmItemmasterid = smmItemmasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmItempurchaseid != null ? smmItempurchaseid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmItempurchase)) {
			return false;
		}
		SmmItempurchase other = (SmmItempurchase) object;
		if ((this.smmItempurchaseid == null && other.smmItempurchaseid != null)
				|| (this.smmItempurchaseid != null && !this.smmItempurchaseid.equals(other.smmItempurchaseid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmItempurchase[ smmItempurchaseid=" + smmItempurchaseid + " ]";
	}

}
