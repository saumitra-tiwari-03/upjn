/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "SMM_STOCK_TRAN_REQ")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmStockTranReq.findAll", query = "SELECT s FROM SmmStockTranReq s"),
		@NamedQuery(name = "SmmStockTranReq.findBySmmStockTranReqid", query = "SELECT s FROM SmmStockTranReq s WHERE s.smmStockTranReqid = :smmStockTranReqid"),
		@NamedQuery(name = "SmmStockTranReq.findByQuantity", query = "SELECT s FROM SmmStockTranReq s WHERE s.quantity = :quantity"),
		@NamedQuery(name = "SmmStockTranReq.findByRemark", query = "SELECT s FROM SmmStockTranReq s WHERE s.remark = :remark"),
		@NamedQuery(name = "SmmStockTranReq.findByApprovedQuantity", query = "SELECT s FROM SmmStockTranReq s WHERE s.approvedQuantity = :approvedQuantity"),
		@NamedQuery(name = "SmmStockTranReq.findByRateSender", query = "SELECT s FROM SmmStockTranReq s WHERE s.rateSender = :rateSender"),
		@NamedQuery(name = "SmmStockTranReq.findByCostSender", query = "SELECT s FROM SmmStockTranReq s WHERE s.costSender = :costSender") })
public class SmmStockTranReq implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_STOCK_TRAN_REQID")
	private Long smmStockTranReqid;
	@Basic(optional = false)
	@Column(name = "QUANTITY")
	private long quantity;
	@Column(name = "REMARK")
	private String remark;
	@Basic(optional = false)
	@Column(name = "APPROVED_QUANTITY")
	private long approvedQuantity;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "RATE_SENDER")
	private BigDecimal rateSender;
	@Column(name = "COST_SENDER")
	private BigDecimal costSender;
	@JoinColumn(name = "SMM_ITEMMASTERID", referencedColumnName = "SMM_ITEMMASTERID")
	@ManyToOne(optional = false)
	private SmmItemmaster smmItemmasterid;
	@JoinColumn(name = "SMM_STOCK_XFER_INFOID", referencedColumnName = "SMM_STOCK_XFER_INFOID")
	@ManyToOne(optional = false)
	private SmmStockXferInfo smmStockXferInfoid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "smmStockTranReqid")
	private Collection<SmmStockXferTransaction> smmStockXferTransactionCollection;

	public SmmStockTranReq() {
	}

	public SmmStockTranReq(Long smmStockTranReqid) {
		this.smmStockTranReqid = smmStockTranReqid;
	}

	public SmmStockTranReq(Long smmStockTranReqid, long quantity, long approvedQuantity) {
		this.smmStockTranReqid = smmStockTranReqid;
		this.quantity = quantity;
		this.approvedQuantity = approvedQuantity;
	}

	public Long getSmmStockTranReqid() {
		return smmStockTranReqid;
	}

	public void setSmmStockTranReqid(Long smmStockTranReqid) {
		this.smmStockTranReqid = smmStockTranReqid;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getApprovedQuantity() {
		return approvedQuantity;
	}

	public void setApprovedQuantity(long approvedQuantity) {
		this.approvedQuantity = approvedQuantity;
	}

	public BigDecimal getRateSender() {
		return rateSender;
	}

	public void setRateSender(BigDecimal rateSender) {
		this.rateSender = rateSender;
	}

	public BigDecimal getCostSender() {
		return costSender;
	}

	public void setCostSender(BigDecimal costSender) {
		this.costSender = costSender;
	}

	public SmmItemmaster getSmmItemmasterid() {
		return smmItemmasterid;
	}

	public void setSmmItemmasterid(SmmItemmaster smmItemmasterid) {
		this.smmItemmasterid = smmItemmasterid;
	}

	public SmmStockXferInfo getSmmStockXferInfoid() {
		return smmStockXferInfoid;
	}

	public void setSmmStockXferInfoid(SmmStockXferInfo smmStockXferInfoid) {
		this.smmStockXferInfoid = smmStockXferInfoid;
	}

	@XmlTransient
	public Collection<SmmStockXferTransaction> getSmmStockXferTransactionCollection() {
		return smmStockXferTransactionCollection;
	}

	public void setSmmStockXferTransactionCollection(
			Collection<SmmStockXferTransaction> smmStockXferTransactionCollection) {
		this.smmStockXferTransactionCollection = smmStockXferTransactionCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmStockTranReqid != null ? smmStockTranReqid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmStockTranReq)) {
			return false;
		}
		SmmStockTranReq other = (SmmStockTranReq) object;
		if ((this.smmStockTranReqid == null && other.smmStockTranReqid != null)
				|| (this.smmStockTranReqid != null && !this.smmStockTranReqid.equals(other.smmStockTranReqid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmStockTranReq[ smmStockTranReqid=" + smmStockTranReqid + " ]";
	}

}
