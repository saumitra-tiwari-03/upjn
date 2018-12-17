/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "LFY_SMM_ITEMPURCHASE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfySmmItempurchase.findAll", query = "SELECT l FROM LfySmmItempurchase l"),
		@NamedQuery(name = "LfySmmItempurchase.findByLfySmmItempurchaseid", query = "SELECT l FROM LfySmmItempurchase l WHERE l.lfySmmItempurchaseid = :lfySmmItempurchaseid"),
		@NamedQuery(name = "LfySmmItempurchase.findBySmmItemmasterid", query = "SELECT l FROM LfySmmItempurchase l WHERE l.smmItemmasterid = :smmItemmasterid"),
		@NamedQuery(name = "LfySmmItempurchase.findByQuantity", query = "SELECT l FROM LfySmmItempurchase l WHERE l.quantity = :quantity"),
		@NamedQuery(name = "LfySmmItempurchase.findByRate", query = "SELECT l FROM LfySmmItempurchase l WHERE l.rate = :rate"),
		@NamedQuery(name = "LfySmmItempurchase.findByCost", query = "SELECT l FROM LfySmmItempurchase l WHERE l.cost = :cost"),
		@NamedQuery(name = "LfySmmItempurchase.findByQuantityAsperChallan", query = "SELECT l FROM LfySmmItempurchase l WHERE l.quantityAsperChallan = :quantityAsperChallan"),
		@NamedQuery(name = "LfySmmItempurchase.findByInvoiceRate", query = "SELECT l FROM LfySmmItempurchase l WHERE l.invoiceRate = :invoiceRate"),
		@NamedQuery(name = "LfySmmItempurchase.findByMbNo", query = "SELECT l FROM LfySmmItempurchase l WHERE l.mbNo = :mbNo"),
		@NamedQuery(name = "LfySmmItempurchase.findByPageNo", query = "SELECT l FROM LfySmmItempurchase l WHERE l.pageNo = :pageNo"),
		@NamedQuery(name = "LfySmmItempurchase.findByMeasurementDate", query = "SELECT l FROM LfySmmItempurchase l WHERE l.measurementDate = :measurementDate"),
		@NamedQuery(name = "LfySmmItempurchase.findBySmmGrnPurchasedid", query = "SELECT l FROM LfySmmItempurchase l WHERE l.smmGrnPurchasedid = :smmGrnPurchasedid"),
		@NamedQuery(name = "LfySmmItempurchase.findByQuantityRejected", query = "SELECT l FROM LfySmmItempurchase l WHERE l.quantityRejected = :quantityRejected"),
		@NamedQuery(name = "LfySmmItempurchase.findBySmmItempurchaseid", query = "SELECT l FROM LfySmmItempurchase l WHERE l.smmItempurchaseid = :smmItempurchaseid"),
		@NamedQuery(name = "LfySmmItempurchase.findByFinancialyear", query = "SELECT l FROM LfySmmItempurchase l WHERE l.financialyear = :financialyear") })
public class LfySmmItempurchase implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_SMM_ITEMPURCHASEID")
	private Long lfySmmItempurchaseid;
	@Basic(optional = false)
	@Column(name = "SMM_ITEMMASTERID")
	private long smmItemmasterid;
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
	@Column(name = "SMM_GRN_PURCHASEDID")
	private long smmGrnPurchasedid;
	@Basic(optional = false)
	@Column(name = "QUANTITY_REJECTED")
	private long quantityRejected;
	@Basic(optional = false)
	@Column(name = "SMM_ITEMPURCHASEID")
	private long smmItempurchaseid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfySmmItempurchase() {
	}

	public LfySmmItempurchase(Long lfySmmItempurchaseid) {
		this.lfySmmItempurchaseid = lfySmmItempurchaseid;
	}

	public LfySmmItempurchase(Long lfySmmItempurchaseid, long smmItemmasterid, long quantity, BigDecimal rate,
			BigDecimal cost, long quantityAsperChallan, BigDecimal invoiceRate, String mbNo, String pageNo,
			long smmGrnPurchasedid, long quantityRejected, long smmItempurchaseid, String financialyear) {
		this.lfySmmItempurchaseid = lfySmmItempurchaseid;
		this.smmItemmasterid = smmItemmasterid;
		this.quantity = quantity;
		this.rate = rate;
		this.cost = cost;
		this.quantityAsperChallan = quantityAsperChallan;
		this.invoiceRate = invoiceRate;
		this.mbNo = mbNo;
		this.pageNo = pageNo;
		this.smmGrnPurchasedid = smmGrnPurchasedid;
		this.quantityRejected = quantityRejected;
		this.smmItempurchaseid = smmItempurchaseid;
		this.financialyear = financialyear;
	}

	public Long getLfySmmItempurchaseid() {
		return lfySmmItempurchaseid;
	}

	public void setLfySmmItempurchaseid(Long lfySmmItempurchaseid) {
		this.lfySmmItempurchaseid = lfySmmItempurchaseid;
	}

	public long getSmmItemmasterid() {
		return smmItemmasterid;
	}

	public void setSmmItemmasterid(long smmItemmasterid) {
		this.smmItemmasterid = smmItemmasterid;
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

	public long getSmmGrnPurchasedid() {
		return smmGrnPurchasedid;
	}

	public void setSmmGrnPurchasedid(long smmGrnPurchasedid) {
		this.smmGrnPurchasedid = smmGrnPurchasedid;
	}

	public long getQuantityRejected() {
		return quantityRejected;
	}

	public void setQuantityRejected(long quantityRejected) {
		this.quantityRejected = quantityRejected;
	}

	public long getSmmItempurchaseid() {
		return smmItempurchaseid;
	}

	public void setSmmItempurchaseid(long smmItempurchaseid) {
		this.smmItempurchaseid = smmItempurchaseid;
	}

	public String getFinancialyear() {
		return financialyear;
	}

	public void setFinancialyear(String financialyear) {
		this.financialyear = financialyear;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (lfySmmItempurchaseid != null ? lfySmmItempurchaseid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfySmmItempurchase)) {
			return false;
		}
		LfySmmItempurchase other = (LfySmmItempurchase) object;
		if ((this.lfySmmItempurchaseid == null && other.lfySmmItempurchaseid != null)
				|| (this.lfySmmItempurchaseid != null
						&& !this.lfySmmItempurchaseid.equals(other.lfySmmItempurchaseid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfySmmItempurchase[ lfySmmItempurchaseid=" + lfySmmItempurchaseid + " ]";
	}

}
