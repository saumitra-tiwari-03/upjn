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
@Table(name = "LFY_PSN_MONTHLYPAY_TRAN")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfyPsnMonthlypayTran.findAll", query = "SELECT l FROM LfyPsnMonthlypayTran l"),
		@NamedQuery(name = "LfyPsnMonthlypayTran.findByLfyPsnMonthlypayTranid", query = "SELECT l FROM LfyPsnMonthlypayTran l WHERE l.lfyPsnMonthlypayTranid = :lfyPsnMonthlypayTranid"),
		@NamedQuery(name = "LfyPsnMonthlypayTran.findByPsnMonthlypayid", query = "SELECT l FROM LfyPsnMonthlypayTran l WHERE l.psnMonthlypayid = :psnMonthlypayid"),
		@NamedQuery(name = "LfyPsnMonthlypayTran.findByTranTypename", query = "SELECT l FROM LfyPsnMonthlypayTran l WHERE l.tranTypename = :tranTypename"),
		@NamedQuery(name = "LfyPsnMonthlypayTran.findByAmount", query = "SELECT l FROM LfyPsnMonthlypayTran l WHERE l.amount = :amount"),
		@NamedQuery(name = "LfyPsnMonthlypayTran.findByRate", query = "SELECT l FROM LfyPsnMonthlypayTran l WHERE l.rate = :rate"),
		@NamedQuery(name = "LfyPsnMonthlypayTran.findByTranFlag", query = "SELECT l FROM LfyPsnMonthlypayTran l WHERE l.tranFlag = :tranFlag"),
		@NamedQuery(name = "LfyPsnMonthlypayTran.findByAcCode", query = "SELECT l FROM LfyPsnMonthlypayTran l WHERE l.acCode = :acCode"),
		@NamedQuery(name = "LfyPsnMonthlypayTran.findByPsnMonthlypayTranid", query = "SELECT l FROM LfyPsnMonthlypayTran l WHERE l.psnMonthlypayTranid = :psnMonthlypayTranid"),
		@NamedQuery(name = "LfyPsnMonthlypayTran.findByFinancialyear", query = "SELECT l FROM LfyPsnMonthlypayTran l WHERE l.financialyear = :financialyear") })
public class LfyPsnMonthlypayTran implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_PSN_MONTHLYPAY_TRANID")
	private Integer lfyPsnMonthlypayTranid;
	@Basic(optional = false)
	@Column(name = "PSN_MONTHLYPAYID")
	private int psnMonthlypayid;
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
	@Basic(optional = false)
	@Column(name = "PSN_MONTHLYPAY_TRANID")
	private long psnMonthlypayTranid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfyPsnMonthlypayTran() {
	}

	public LfyPsnMonthlypayTran(Integer lfyPsnMonthlypayTranid) {
		this.lfyPsnMonthlypayTranid = lfyPsnMonthlypayTranid;
	}

	public LfyPsnMonthlypayTran(Integer lfyPsnMonthlypayTranid, int psnMonthlypayid, String tranTypename,
			BigDecimal amount, Character tranFlag, long psnMonthlypayTranid, String financialyear) {
		this.lfyPsnMonthlypayTranid = lfyPsnMonthlypayTranid;
		this.psnMonthlypayid = psnMonthlypayid;
		this.tranTypename = tranTypename;
		this.amount = amount;
		this.tranFlag = tranFlag;
		this.psnMonthlypayTranid = psnMonthlypayTranid;
		this.financialyear = financialyear;
	}

	public Integer getLfyPsnMonthlypayTranid() {
		return lfyPsnMonthlypayTranid;
	}

	public void setLfyPsnMonthlypayTranid(Integer lfyPsnMonthlypayTranid) {
		this.lfyPsnMonthlypayTranid = lfyPsnMonthlypayTranid;
	}

	public int getPsnMonthlypayid() {
		return psnMonthlypayid;
	}

	public void setPsnMonthlypayid(int psnMonthlypayid) {
		this.psnMonthlypayid = psnMonthlypayid;
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

	public long getPsnMonthlypayTranid() {
		return psnMonthlypayTranid;
	}

	public void setPsnMonthlypayTranid(long psnMonthlypayTranid) {
		this.psnMonthlypayTranid = psnMonthlypayTranid;
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
		hash += (lfyPsnMonthlypayTranid != null ? lfyPsnMonthlypayTranid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfyPsnMonthlypayTran)) {
			return false;
		}
		LfyPsnMonthlypayTran other = (LfyPsnMonthlypayTran) object;
		if ((this.lfyPsnMonthlypayTranid == null && other.lfyPsnMonthlypayTranid != null)
				|| (this.lfyPsnMonthlypayTranid != null
						&& !this.lfyPsnMonthlypayTranid.equals(other.lfyPsnMonthlypayTranid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfyPsnMonthlypayTran[ lfyPsnMonthlypayTranid=" + lfyPsnMonthlypayTranid + " ]";
	}

}
