/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
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
@Table(name = "SMM_STOCK_XFER_TRANSACTION")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "SmmStockXferTransaction.findAll", query = "SELECT s FROM SmmStockXferTransaction s"),
		@NamedQuery(name = "SmmStockXferTransaction.findBySmmStockXferTransactionid", query = "SELECT s FROM SmmStockXferTransaction s WHERE s.smmStockXferTransactionid = :smmStockXferTransactionid"),
		@NamedQuery(name = "SmmStockXferTransaction.findByQuantity", query = "SELECT s FROM SmmStockXferTransaction s WHERE s.quantity = :quantity"),
		@NamedQuery(name = "SmmStockXferTransaction.findByRate", query = "SELECT s FROM SmmStockXferTransaction s WHERE s.rate = :rate"),
		@NamedQuery(name = "SmmStockXferTransaction.findByCost", query = "SELECT s FROM SmmStockXferTransaction s WHERE s.cost = :cost"),
		@NamedQuery(name = "SmmStockXferTransaction.findByDtrNo", query = "SELECT s FROM SmmStockXferTransaction s WHERE s.dtrNo = :dtrNo"),
		@NamedQuery(name = "SmmStockXferTransaction.findByMbNo", query = "SELECT s FROM SmmStockXferTransaction s WHERE s.mbNo = :mbNo"),
		@NamedQuery(name = "SmmStockXferTransaction.findByPageNo", query = "SELECT s FROM SmmStockXferTransaction s WHERE s.pageNo = :pageNo"),
		@NamedQuery(name = "SmmStockXferTransaction.findByMesurementDate", query = "SELECT s FROM SmmStockXferTransaction s WHERE s.mesurementDate = :mesurementDate"),
		@NamedQuery(name = "SmmStockXferTransaction.findByJeName", query = "SELECT s FROM SmmStockXferTransaction s WHERE s.jeName = :jeName") })
public class SmmStockXferTransaction implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_STOCK_XFER_TRANSACTIONID")
	private Long smmStockXferTransactionid;
	@Basic(optional = false)
	@Column(name = "QUANTITY")
	private long quantity;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "RATE")
	private BigDecimal rate;
	@Column(name = "COST")
	private BigDecimal cost;
	@Column(name = "DTR_NO")
	private String dtrNo;
	@Column(name = "MB_NO")
	private String mbNo;
	@Column(name = "PAGE_NO")
	private String pageNo;
	@Column(name = "MESUREMENT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mesurementDate;
	@Column(name = "JE_NAME")
	private String jeName;
	@JoinColumn(name = "SMM_STOCK_TRAN_REQID", referencedColumnName = "SMM_STOCK_TRAN_REQID")
	@ManyToOne(optional = false)
	private SmmStockTranReq smmStockTranReqid;
	@OneToMany(mappedBy = "smmStockXferTransactionid")
	private Collection<SmmMaterialconsumption> smmMaterialconsumptionCollection;

	public SmmStockXferTransaction() {
	}

	public SmmStockXferTransaction(Long smmStockXferTransactionid) {
		this.smmStockXferTransactionid = smmStockXferTransactionid;
	}

	public SmmStockXferTransaction(Long smmStockXferTransactionid, long quantity) {
		this.smmStockXferTransactionid = smmStockXferTransactionid;
		this.quantity = quantity;
	}

	public Long getSmmStockXferTransactionid() {
		return smmStockXferTransactionid;
	}

	public void setSmmStockXferTransactionid(Long smmStockXferTransactionid) {
		this.smmStockXferTransactionid = smmStockXferTransactionid;
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

	public String getDtrNo() {
		return dtrNo;
	}

	public void setDtrNo(String dtrNo) {
		this.dtrNo = dtrNo;
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

	public Date getMesurementDate() {
		return mesurementDate;
	}

	public void setMesurementDate(Date mesurementDate) {
		this.mesurementDate = mesurementDate;
	}

	public String getJeName() {
		return jeName;
	}

	public void setJeName(String jeName) {
		this.jeName = jeName;
	}

	public SmmStockTranReq getSmmStockTranReqid() {
		return smmStockTranReqid;
	}

	public void setSmmStockTranReqid(SmmStockTranReq smmStockTranReqid) {
		this.smmStockTranReqid = smmStockTranReqid;
	}

	@XmlTransient
	public Collection<SmmMaterialconsumption> getSmmMaterialconsumptionCollection() {
		return smmMaterialconsumptionCollection;
	}

	public void setSmmMaterialconsumptionCollection(
			Collection<SmmMaterialconsumption> smmMaterialconsumptionCollection) {
		this.smmMaterialconsumptionCollection = smmMaterialconsumptionCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmStockXferTransactionid != null ? smmStockXferTransactionid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmStockXferTransaction)) {
			return false;
		}
		SmmStockXferTransaction other = (SmmStockXferTransaction) object;
		if ((this.smmStockXferTransactionid == null && other.smmStockXferTransactionid != null)
				|| (this.smmStockXferTransactionid != null
						&& !this.smmStockXferTransactionid.equals(other.smmStockXferTransactionid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmStockXferTransaction[ smmStockXferTransactionid=" + smmStockXferTransactionid
				+ " ]";
	}

}
