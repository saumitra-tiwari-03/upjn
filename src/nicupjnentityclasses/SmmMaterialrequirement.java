/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

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
@Table(name = "SMM_MATERIALREQUIREMENT")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmMaterialrequirement.findAll", query = "SELECT s FROM SmmMaterialrequirement s"),
		@NamedQuery(name = "SmmMaterialrequirement.findBySmmMaterialrequirementid", query = "SELECT s FROM SmmMaterialrequirement s WHERE s.smmMaterialrequirementid = :smmMaterialrequirementid"),
		@NamedQuery(name = "SmmMaterialrequirement.findByStockBegCfy", query = "SELECT s FROM SmmMaterialrequirement s WHERE s.stockBegCfy = :stockBegCfy"),
		@NamedQuery(name = "SmmMaterialrequirement.findByBalSuppAgainstOrders", query = "SELECT s FROM SmmMaterialrequirement s WHERE s.balSuppAgainstOrders = :balSuppAgainstOrders"),
		@NamedQuery(name = "SmmMaterialrequirement.findByMatwiseOutstPayments", query = "SELECT s FROM SmmMaterialrequirement s WHERE s.matwiseOutstPayments = :matwiseOutstPayments"),
		@NamedQuery(name = "SmmMaterialrequirement.findByQtyProcSofar", query = "SELECT s FROM SmmMaterialrequirement s WHERE s.qtyProcSofar = :qtyProcSofar"),
		@NamedQuery(name = "SmmMaterialrequirement.findByQuantityReqQ1", query = "SELECT s FROM SmmMaterialrequirement s WHERE s.quantityReqQ1 = :quantityReqQ1"),
		@NamedQuery(name = "SmmMaterialrequirement.findByQuantityReqQ2", query = "SELECT s FROM SmmMaterialrequirement s WHERE s.quantityReqQ2 = :quantityReqQ2"),
		@NamedQuery(name = "SmmMaterialrequirement.findByQuantityReqQ3", query = "SELECT s FROM SmmMaterialrequirement s WHERE s.quantityReqQ3 = :quantityReqQ3"),
		@NamedQuery(name = "SmmMaterialrequirement.findByQuantityReqQ4", query = "SELECT s FROM SmmMaterialrequirement s WHERE s.quantityReqQ4 = :quantityReqQ4") })
public class SmmMaterialrequirement implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_MATERIALREQUIREMENTID")
	private Long smmMaterialrequirementid;
	@Column(name = "STOCK_BEG_CFY")
	private Long stockBegCfy;
	@Column(name = "BAL_SUPP_AGAINST_ORDERS")
	private Long balSuppAgainstOrders;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "MATWISE_OUTST_PAYMENTS")
	private BigDecimal matwiseOutstPayments;
	@Basic(optional = false)
	@Column(name = "QTY_PROC_SOFAR")
	private long qtyProcSofar;
	@Basic(optional = false)
	@Column(name = "QUANTITY_REQ_Q1")
	private long quantityReqQ1;
	@Basic(optional = false)
	@Column(name = "QUANTITY_REQ_Q2")
	private long quantityReqQ2;
	@Basic(optional = false)
	@Column(name = "QUANTITY_REQ_Q3")
	private long quantityReqQ3;
	@Basic(optional = false)
	@Column(name = "QUANTITY_REQ_Q4")
	private long quantityReqQ4;
	@JoinColumn(name = "SMM_ITEMMASTERID", referencedColumnName = "SMM_ITEMMASTERID")
	@ManyToOne(optional = false)
	private SmmItemmaster smmItemmasterid;
	@JoinColumn(name = "SMM_M1REPORTINFOID", referencedColumnName = "SMM_M1REPORTINFOID")
	@ManyToOne(optional = false)
	private SmmM1reportinfo smmM1reportinfoid;

	public SmmMaterialrequirement() {
	}

	public SmmMaterialrequirement(Long smmMaterialrequirementid) {
		this.smmMaterialrequirementid = smmMaterialrequirementid;
	}

	public SmmMaterialrequirement(Long smmMaterialrequirementid, long qtyProcSofar, long quantityReqQ1,
			long quantityReqQ2, long quantityReqQ3, long quantityReqQ4) {
		this.smmMaterialrequirementid = smmMaterialrequirementid;
		this.qtyProcSofar = qtyProcSofar;
		this.quantityReqQ1 = quantityReqQ1;
		this.quantityReqQ2 = quantityReqQ2;
		this.quantityReqQ3 = quantityReqQ3;
		this.quantityReqQ4 = quantityReqQ4;
	}

	public Long getSmmMaterialrequirementid() {
		return smmMaterialrequirementid;
	}

	public void setSmmMaterialrequirementid(Long smmMaterialrequirementid) {
		this.smmMaterialrequirementid = smmMaterialrequirementid;
	}

	public Long getStockBegCfy() {
		return stockBegCfy;
	}

	public void setStockBegCfy(Long stockBegCfy) {
		this.stockBegCfy = stockBegCfy;
	}

	public Long getBalSuppAgainstOrders() {
		return balSuppAgainstOrders;
	}

	public void setBalSuppAgainstOrders(Long balSuppAgainstOrders) {
		this.balSuppAgainstOrders = balSuppAgainstOrders;
	}

	public BigDecimal getMatwiseOutstPayments() {
		return matwiseOutstPayments;
	}

	public void setMatwiseOutstPayments(BigDecimal matwiseOutstPayments) {
		this.matwiseOutstPayments = matwiseOutstPayments;
	}

	public long getQtyProcSofar() {
		return qtyProcSofar;
	}

	public void setQtyProcSofar(long qtyProcSofar) {
		this.qtyProcSofar = qtyProcSofar;
	}

	public long getQuantityReqQ1() {
		return quantityReqQ1;
	}

	public void setQuantityReqQ1(long quantityReqQ1) {
		this.quantityReqQ1 = quantityReqQ1;
	}

	public long getQuantityReqQ2() {
		return quantityReqQ2;
	}

	public void setQuantityReqQ2(long quantityReqQ2) {
		this.quantityReqQ2 = quantityReqQ2;
	}

	public long getQuantityReqQ3() {
		return quantityReqQ3;
	}

	public void setQuantityReqQ3(long quantityReqQ3) {
		this.quantityReqQ3 = quantityReqQ3;
	}

	public long getQuantityReqQ4() {
		return quantityReqQ4;
	}

	public void setQuantityReqQ4(long quantityReqQ4) {
		this.quantityReqQ4 = quantityReqQ4;
	}

	public SmmItemmaster getSmmItemmasterid() {
		return smmItemmasterid;
	}

	public void setSmmItemmasterid(SmmItemmaster smmItemmasterid) {
		this.smmItemmasterid = smmItemmasterid;
	}

	public SmmM1reportinfo getSmmM1reportinfoid() {
		return smmM1reportinfoid;
	}

	public void setSmmM1reportinfoid(SmmM1reportinfo smmM1reportinfoid) {
		this.smmM1reportinfoid = smmM1reportinfoid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmMaterialrequirementid != null ? smmMaterialrequirementid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmMaterialrequirement)) {
			return false;
		}
		SmmMaterialrequirement other = (SmmMaterialrequirement) object;
		if ((this.smmMaterialrequirementid == null && other.smmMaterialrequirementid != null)
				|| (this.smmMaterialrequirementid != null
						&& !this.smmMaterialrequirementid.equals(other.smmMaterialrequirementid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmMaterialrequirement[ smmMaterialrequirementid=" + smmMaterialrequirementid
				+ " ]";
	}

}
