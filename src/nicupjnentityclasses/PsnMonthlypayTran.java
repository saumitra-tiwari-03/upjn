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
@Table(name = "PSN_MONTHLYPAY_TRAN")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PsnMonthlypayTran.findAll", query = "SELECT p FROM PsnMonthlypayTran p"),
		@NamedQuery(name = "PsnMonthlypayTran.findByPsnMonthlypayTranid", query = "SELECT p FROM PsnMonthlypayTran p WHERE p.psnMonthlypayTranid = :psnMonthlypayTranid"),
		@NamedQuery(name = "PsnMonthlypayTran.findByTranTypename", query = "SELECT p FROM PsnMonthlypayTran p WHERE p.tranTypename = :tranTypename"),
		@NamedQuery(name = "PsnMonthlypayTran.findByAmount", query = "SELECT p FROM PsnMonthlypayTran p WHERE p.amount = :amount"),
		@NamedQuery(name = "PsnMonthlypayTran.findByRate", query = "SELECT p FROM PsnMonthlypayTran p WHERE p.rate = :rate"),
		@NamedQuery(name = "PsnMonthlypayTran.findByTranFlag", query = "SELECT p FROM PsnMonthlypayTran p WHERE p.tranFlag = :tranFlag"),
		@NamedQuery(name = "PsnMonthlypayTran.findByAcCode", query = "SELECT p FROM PsnMonthlypayTran p WHERE p.acCode = :acCode") })
public class PsnMonthlypayTran implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PSN_MONTHLYPAY_TRANID")
	private Integer psnMonthlypayTranid;
	@Basic(optional = false)
	@Column(name = "TRAN_TYPENAME")
	private String tranTypename;
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
	@Column(name = "AC_CODE")
	private String acCode;
	@JoinColumn(name = "PSN_MONTHLYPAYID", referencedColumnName = "PSN_MONTHLYPAYID")
	@ManyToOne(optional = false)
	private PsnMonthlypay psnMonthlypayid;

	public PsnMonthlypayTran() {
	}

	public PsnMonthlypayTran(Integer psnMonthlypayTranid) {
		this.psnMonthlypayTranid = psnMonthlypayTranid;
	}

	public PsnMonthlypayTran(Integer psnMonthlypayTranid, String tranTypename, BigDecimal amount, Character tranFlag) {
		this.psnMonthlypayTranid = psnMonthlypayTranid;
		this.tranTypename = tranTypename;
		this.amount = amount;
		this.tranFlag = tranFlag;
	}

	public Integer getPsnMonthlypayTranid() {
		return psnMonthlypayTranid;
	}

	public void setPsnMonthlypayTranid(Integer psnMonthlypayTranid) {
		this.psnMonthlypayTranid = psnMonthlypayTranid;
	}

	public String getTranTypename() {
		return tranTypename;
	}

	public void setTranTypename(String tranTypename) {
		this.tranTypename = tranTypename;
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

	public String getAcCode() {
		return acCode;
	}

	public void setAcCode(String acCode) {
		this.acCode = acCode;
	}

	public PsnMonthlypay getPsnMonthlypayid() {
		return psnMonthlypayid;
	}

	public void setPsnMonthlypayid(PsnMonthlypay psnMonthlypayid) {
		this.psnMonthlypayid = psnMonthlypayid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (psnMonthlypayTranid != null ? psnMonthlypayTranid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PsnMonthlypayTran)) {
			return false;
		}
		PsnMonthlypayTran other = (PsnMonthlypayTran) object;
		if ((this.psnMonthlypayTranid == null && other.psnMonthlypayTranid != null)
				|| (this.psnMonthlypayTranid != null && !this.psnMonthlypayTranid.equals(other.psnMonthlypayTranid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PsnMonthlypayTran[ psnMonthlypayTranid=" + psnMonthlypayTranid + " ]";
	}

}
