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
@Table(name = "LFY_PP_MONTHLYPAY_TRAN")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfyPpMonthlypayTran.findAll", query = "SELECT l FROM LfyPpMonthlypayTran l"),
		@NamedQuery(name = "LfyPpMonthlypayTran.findByLfyPpMonthlypayTranid", query = "SELECT l FROM LfyPpMonthlypayTran l WHERE l.lfyPpMonthlypayTranid = :lfyPpMonthlypayTranid"),
		@NamedQuery(name = "LfyPpMonthlypayTran.findByPpMonthlypayid", query = "SELECT l FROM LfyPpMonthlypayTran l WHERE l.ppMonthlypayid = :ppMonthlypayid"),
		@NamedQuery(name = "LfyPpMonthlypayTran.findByTranTypeid", query = "SELECT l FROM LfyPpMonthlypayTran l WHERE l.tranTypeid = :tranTypeid"),
		@NamedQuery(name = "LfyPpMonthlypayTran.findByAmount", query = "SELECT l FROM LfyPpMonthlypayTran l WHERE l.amount = :amount"),
		@NamedQuery(name = "LfyPpMonthlypayTran.findByRate", query = "SELECT l FROM LfyPpMonthlypayTran l WHERE l.rate = :rate"),
		@NamedQuery(name = "LfyPpMonthlypayTran.findByTranFlag", query = "SELECT l FROM LfyPpMonthlypayTran l WHERE l.tranFlag = :tranFlag"),
		@NamedQuery(name = "LfyPpMonthlypayTran.findByInstallmentNo", query = "SELECT l FROM LfyPpMonthlypayTran l WHERE l.installmentNo = :installmentNo"),
		@NamedQuery(name = "LfyPpMonthlypayTran.findByPpMonthlypayTranid", query = "SELECT l FROM LfyPpMonthlypayTran l WHERE l.ppMonthlypayTranid = :ppMonthlypayTranid"),
		@NamedQuery(name = "LfyPpMonthlypayTran.findByFinancialyear", query = "SELECT l FROM LfyPpMonthlypayTran l WHERE l.financialyear = :financialyear") })
public class LfyPpMonthlypayTran implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_PP_MONTHLYPAY_TRANID")
	private Integer lfyPpMonthlypayTranid;
	@Basic(optional = false)
	@Column(name = "PP_MONTHLYPAYID")
	private int ppMonthlypayid;
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
	private Long installmentNo;
	@Basic(optional = false)
	@Column(name = "PP_MONTHLYPAY_TRANID")
	private long ppMonthlypayTranid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfyPpMonthlypayTran() {
	}

	public LfyPpMonthlypayTran(Integer lfyPpMonthlypayTranid) {
		this.lfyPpMonthlypayTranid = lfyPpMonthlypayTranid;
	}

	public LfyPpMonthlypayTran(Integer lfyPpMonthlypayTranid, int ppMonthlypayid, int tranTypeid, BigDecimal amount,
			Character tranFlag, long ppMonthlypayTranid, String financialyear) {
		this.lfyPpMonthlypayTranid = lfyPpMonthlypayTranid;
		this.ppMonthlypayid = ppMonthlypayid;
		this.tranTypeid = tranTypeid;
		this.amount = amount;
		this.tranFlag = tranFlag;
		this.ppMonthlypayTranid = ppMonthlypayTranid;
		this.financialyear = financialyear;
	}

	public Integer getLfyPpMonthlypayTranid() {
		return lfyPpMonthlypayTranid;
	}

	public void setLfyPpMonthlypayTranid(Integer lfyPpMonthlypayTranid) {
		this.lfyPpMonthlypayTranid = lfyPpMonthlypayTranid;
	}

	public int getPpMonthlypayid() {
		return ppMonthlypayid;
	}

	public void setPpMonthlypayid(int ppMonthlypayid) {
		this.ppMonthlypayid = ppMonthlypayid;
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

	public Long getInstallmentNo() {
		return installmentNo;
	}

	public void setInstallmentNo(Long installmentNo) {
		this.installmentNo = installmentNo;
	}

	public long getPpMonthlypayTranid() {
		return ppMonthlypayTranid;
	}

	public void setPpMonthlypayTranid(long ppMonthlypayTranid) {
		this.ppMonthlypayTranid = ppMonthlypayTranid;
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
		hash += (lfyPpMonthlypayTranid != null ? lfyPpMonthlypayTranid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfyPpMonthlypayTran)) {
			return false;
		}
		LfyPpMonthlypayTran other = (LfyPpMonthlypayTran) object;
		if ((this.lfyPpMonthlypayTranid == null && other.lfyPpMonthlypayTranid != null)
				|| (this.lfyPpMonthlypayTranid != null
						&& !this.lfyPpMonthlypayTranid.equals(other.lfyPpMonthlypayTranid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfyPpMonthlypayTran[ lfyPpMonthlypayTranid=" + lfyPpMonthlypayTranid + " ]";
	}

}
