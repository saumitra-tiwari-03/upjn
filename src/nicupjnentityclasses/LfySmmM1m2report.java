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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "LFY_SMM_M1M2REPORT")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfySmmM1m2report.findAll", query = "SELECT l FROM LfySmmM1m2report l"),
		@NamedQuery(name = "LfySmmM1m2report.findBySmmM1reportinfoid", query = "SELECT l FROM LfySmmM1m2report l WHERE l.smmM1reportinfoid = :smmM1reportinfoid"),
		@NamedQuery(name = "LfySmmM1m2report.findByLfySmmM1m2reportid", query = "SELECT l FROM LfySmmM1m2report l WHERE l.lfySmmM1m2reportid = :lfySmmM1m2reportid"),
		@NamedQuery(name = "LfySmmM1m2report.findBySmmItemmasterid", query = "SELECT l FROM LfySmmM1m2report l WHERE l.smmItemmasterid = :smmItemmasterid"),
		@NamedQuery(name = "LfySmmM1m2report.findByStockAtBeginingCfy", query = "SELECT l FROM LfySmmM1m2report l WHERE l.stockAtBeginingCfy = :stockAtBeginingCfy"),
		@NamedQuery(name = "LfySmmM1m2report.findByMaterialProcuredCfy", query = "SELECT l FROM LfySmmM1m2report l WHERE l.materialProcuredCfy = :materialProcuredCfy"),
		@NamedQuery(name = "LfySmmM1m2report.findByBalanceSupplies", query = "SELECT l FROM LfySmmM1m2report l WHERE l.balanceSupplies = :balanceSupplies"),
		@NamedQuery(name = "LfySmmM1m2report.findByOutstandingPayment", query = "SELECT l FROM LfySmmM1m2report l WHERE l.outstandingPayment = :outstandingPayment"),
		@NamedQuery(name = "LfySmmM1m2report.findBySmmM1m2reportid", query = "SELECT l FROM LfySmmM1m2report l WHERE l.smmM1m2reportid = :smmM1m2reportid"),
		@NamedQuery(name = "LfySmmM1m2report.findByFinancialyear", query = "SELECT l FROM LfySmmM1m2report l WHERE l.financialyear = :financialyear") })
public class LfySmmM1m2report implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "SMM_M1REPORTINFOID")
	private long smmM1reportinfoid;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_SMM_M1M2REPORTID")
	private Long lfySmmM1m2reportid;
	@Basic(optional = false)
	@Column(name = "SMM_ITEMMASTERID")
	private long smmItemmasterid;
	@Basic(optional = false)
	@Column(name = "STOCK_AT_BEGINING_CFY")
	private long stockAtBeginingCfy;
	@Basic(optional = false)
	@Column(name = "MATERIAL_PROCURED_CFY")
	private long materialProcuredCfy;
	@Basic(optional = false)
	@Column(name = "BALANCE_SUPPLIES")
	private long balanceSupplies;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "OUTSTANDING_PAYMENT")
	private BigDecimal outstandingPayment;
	@Basic(optional = false)
	@Column(name = "SMM_M1M2REPORTID")
	private long smmM1m2reportid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfySmmM1m2report() {
	}

	public LfySmmM1m2report(Long lfySmmM1m2reportid) {
		this.lfySmmM1m2reportid = lfySmmM1m2reportid;
	}

	public LfySmmM1m2report(Long lfySmmM1m2reportid, long smmM1reportinfoid, long smmItemmasterid,
			long stockAtBeginingCfy, long materialProcuredCfy, long balanceSupplies, BigDecimal outstandingPayment,
			long smmM1m2reportid, String financialyear) {
		this.lfySmmM1m2reportid = lfySmmM1m2reportid;
		this.smmM1reportinfoid = smmM1reportinfoid;
		this.smmItemmasterid = smmItemmasterid;
		this.stockAtBeginingCfy = stockAtBeginingCfy;
		this.materialProcuredCfy = materialProcuredCfy;
		this.balanceSupplies = balanceSupplies;
		this.outstandingPayment = outstandingPayment;
		this.smmM1m2reportid = smmM1m2reportid;
		this.financialyear = financialyear;
	}

	public long getSmmM1reportinfoid() {
		return smmM1reportinfoid;
	}

	public void setSmmM1reportinfoid(long smmM1reportinfoid) {
		this.smmM1reportinfoid = smmM1reportinfoid;
	}

	public Long getLfySmmM1m2reportid() {
		return lfySmmM1m2reportid;
	}

	public void setLfySmmM1m2reportid(Long lfySmmM1m2reportid) {
		this.lfySmmM1m2reportid = lfySmmM1m2reportid;
	}

	public long getSmmItemmasterid() {
		return smmItemmasterid;
	}

	public void setSmmItemmasterid(long smmItemmasterid) {
		this.smmItemmasterid = smmItemmasterid;
	}

	public long getStockAtBeginingCfy() {
		return stockAtBeginingCfy;
	}

	public void setStockAtBeginingCfy(long stockAtBeginingCfy) {
		this.stockAtBeginingCfy = stockAtBeginingCfy;
	}

	public long getMaterialProcuredCfy() {
		return materialProcuredCfy;
	}

	public void setMaterialProcuredCfy(long materialProcuredCfy) {
		this.materialProcuredCfy = materialProcuredCfy;
	}

	public long getBalanceSupplies() {
		return balanceSupplies;
	}

	public void setBalanceSupplies(long balanceSupplies) {
		this.balanceSupplies = balanceSupplies;
	}

	public BigDecimal getOutstandingPayment() {
		return outstandingPayment;
	}

	public void setOutstandingPayment(BigDecimal outstandingPayment) {
		this.outstandingPayment = outstandingPayment;
	}

	public long getSmmM1m2reportid() {
		return smmM1m2reportid;
	}

	public void setSmmM1m2reportid(long smmM1m2reportid) {
		this.smmM1m2reportid = smmM1m2reportid;
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
		hash += (lfySmmM1m2reportid != null ? lfySmmM1m2reportid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfySmmM1m2report)) {
			return false;
		}
		LfySmmM1m2report other = (LfySmmM1m2report) object;
		if ((this.lfySmmM1m2reportid == null && other.lfySmmM1m2reportid != null)
				|| (this.lfySmmM1m2reportid != null && !this.lfySmmM1m2reportid.equals(other.lfySmmM1m2reportid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfySmmM1m2report[ lfySmmM1m2reportid=" + lfySmmM1m2reportid + " ]";
	}

}
