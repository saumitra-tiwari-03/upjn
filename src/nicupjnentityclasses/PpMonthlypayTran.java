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
@Table(name = "PP_MONTHLYPAY_TRAN")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpMonthlypayTran.findAll", query = "SELECT p FROM PpMonthlypayTran p"),
		@NamedQuery(name = "PpMonthlypayTran.findByPpMonthlypayTranid", query = "SELECT p FROM PpMonthlypayTran p WHERE p.ppMonthlypayTranid = :ppMonthlypayTranid"),
		@NamedQuery(name = "PpMonthlypayTran.findByTranTypeid", query = "SELECT p FROM PpMonthlypayTran p WHERE p.tranTypeid = :tranTypeid"),
		@NamedQuery(name = "PpMonthlypayTran.findByAmount", query = "SELECT p FROM PpMonthlypayTran p WHERE p.amount = :amount"),
		@NamedQuery(name = "PpMonthlypayTran.findByRate", query = "SELECT p FROM PpMonthlypayTran p WHERE p.rate = :rate"),
		@NamedQuery(name = "PpMonthlypayTran.findByTranFlag", query = "SELECT p FROM PpMonthlypayTran p WHERE p.tranFlag = :tranFlag"),
		@NamedQuery(name = "PpMonthlypayTran.findByInstallmentNo", query = "SELECT p FROM PpMonthlypayTran p WHERE p.installmentNo = :installmentNo") })
public class PpMonthlypayTran implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_MONTHLYPAY_TRANID")
	private Long ppMonthlypayTranid;
	@Basic(optional = false)
	@Column(name = "TRAN_TYPEID")
	private int tranTypeid;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Column(name = "RATE")
	private BigDecimal rate;
	@Basic(optional = false)
	@Column(name = "TRAN_FLAG")
	private Character tranFlag;
	@Column(name = "INSTALLMENT_NO")
	private Short installmentNo;
	@JoinColumn(name = "PP_MONTHLYPAYID", referencedColumnName = "PP_MONTHLYPAYID")
	@ManyToOne(optional = false)
	private PpMonthlypay ppMonthlypayid;

	public PpMonthlypayTran() {
	}

	public PpMonthlypayTran(Long ppMonthlypayTranid) {
		this.ppMonthlypayTranid = ppMonthlypayTranid;
	}

	public PpMonthlypayTran(Long ppMonthlypayTranid, int tranTypeid, BigDecimal amount, Character tranFlag) {
		this.ppMonthlypayTranid = ppMonthlypayTranid;
		this.tranTypeid = tranTypeid;
		this.amount = amount;
		this.tranFlag = tranFlag;
	}

	public Long getPpMonthlypayTranid() {
		return ppMonthlypayTranid;
	}

	public void setPpMonthlypayTranid(Long ppMonthlypayTranid) {
		this.ppMonthlypayTranid = ppMonthlypayTranid;
	}

	public int getTranTypeid() {
		return tranTypeid;
	}

	public void setTranTypeid(int tranTypeid) {
		this.tranTypeid = tranTypeid;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Character getTranFlag() {
		return tranFlag;
	}

	public void setTranFlag(Character tranFlag) {
		this.tranFlag = tranFlag;
	}

	public Short getInstallmentNo() {
		return installmentNo;
	}

	public void setInstallmentNo(Short installmentNo) {
		this.installmentNo = installmentNo;
	}

	public PpMonthlypay getPpMonthlypayid() {
		return ppMonthlypayid;
	}

	public void setPpMonthlypayid(PpMonthlypay ppMonthlypayid) {
		this.ppMonthlypayid = ppMonthlypayid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppMonthlypayTranid != null ? ppMonthlypayTranid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpMonthlypayTran)) {
			return false;
		}
		PpMonthlypayTran other = (PpMonthlypayTran) object;
		if ((this.ppMonthlypayTranid == null && other.ppMonthlypayTranid != null)
				|| (this.ppMonthlypayTranid != null && !this.ppMonthlypayTranid.equals(other.ppMonthlypayTranid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpMonthlypayTran[ ppMonthlypayTranid=" + ppMonthlypayTranid + " ]";
	}

}
