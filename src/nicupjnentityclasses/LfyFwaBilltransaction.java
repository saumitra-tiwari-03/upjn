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
@Table(name = "LFY_FWA_BILLTRANSACTION")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfyFwaBilltransaction.findAll", query = "SELECT l FROM LfyFwaBilltransaction l"),
		@NamedQuery(name = "LfyFwaBilltransaction.findByLfyFwaBilltransactionid", query = "SELECT l FROM LfyFwaBilltransaction l WHERE l.lfyFwaBilltransactionid = :lfyFwaBilltransactionid"),
		@NamedQuery(name = "LfyFwaBilltransaction.findByFwaBillmasterid", query = "SELECT l FROM LfyFwaBilltransaction l WHERE l.fwaBillmasterid = :fwaBillmasterid"),
		@NamedQuery(name = "LfyFwaBilltransaction.findByFwaAcCodeMasterid", query = "SELECT l FROM LfyFwaBilltransaction l WHERE l.fwaAcCodeMasterid = :fwaAcCodeMasterid"),
		@NamedQuery(name = "LfyFwaBilltransaction.findByAmount", query = "SELECT l FROM LfyFwaBilltransaction l WHERE l.amount = :amount"),
		@NamedQuery(name = "LfyFwaBilltransaction.findBySpSchememasterid", query = "SELECT l FROM LfyFwaBilltransaction l WHERE l.spSchememasterid = :spSchememasterid"),
		@NamedQuery(name = "LfyFwaBilltransaction.findByTranFlag", query = "SELECT l FROM LfyFwaBilltransaction l WHERE l.tranFlag = :tranFlag"),
		@NamedQuery(name = "LfyFwaBilltransaction.findByFwaBilltransactionid", query = "SELECT l FROM LfyFwaBilltransaction l WHERE l.fwaBilltransactionid = :fwaBilltransactionid"),
		@NamedQuery(name = "LfyFwaBilltransaction.findByFinancialyear", query = "SELECT l FROM LfyFwaBilltransaction l WHERE l.financialyear = :financialyear") })
public class LfyFwaBilltransaction implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_FWA_BILLTRANSACTIONID")
	private Long lfyFwaBilltransactionid;
	@Basic(optional = false)
	@Column(name = "FWA_BILLMASTERID")
	private long fwaBillmasterid;
	@Basic(optional = false)
	@Column(name = "FWA_AC_CODE_MASTERID")
	private long fwaAcCodeMasterid;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Column(name = "SP_SCHEMEMASTERID")
	private Long spSchememasterid;
	@Column(name = "TRAN_FLAG")
	private Character tranFlag;
	@Basic(optional = false)
	@Column(name = "FWA_BILLTRANSACTIONID")
	private long fwaBilltransactionid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfyFwaBilltransaction() {
	}

	public LfyFwaBilltransaction(Long lfyFwaBilltransactionid) {
		this.lfyFwaBilltransactionid = lfyFwaBilltransactionid;
	}

	public LfyFwaBilltransaction(Long lfyFwaBilltransactionid, long fwaBillmasterid, long fwaAcCodeMasterid,
			BigDecimal amount, long fwaBilltransactionid, String financialyear) {
		this.lfyFwaBilltransactionid = lfyFwaBilltransactionid;
		this.fwaBillmasterid = fwaBillmasterid;
		this.fwaAcCodeMasterid = fwaAcCodeMasterid;
		this.amount = amount;
		this.fwaBilltransactionid = fwaBilltransactionid;
		this.financialyear = financialyear;
	}

	public Long getLfyFwaBilltransactionid() {
		return lfyFwaBilltransactionid;
	}

	public void setLfyFwaBilltransactionid(Long lfyFwaBilltransactionid) {
		this.lfyFwaBilltransactionid = lfyFwaBilltransactionid;
	}

	public long getFwaBillmasterid() {
		return fwaBillmasterid;
	}

	public void setFwaBillmasterid(long fwaBillmasterid) {
		this.fwaBillmasterid = fwaBillmasterid;
	}

	public long getFwaAcCodeMasterid() {
		return fwaAcCodeMasterid;
	}

	public void setFwaAcCodeMasterid(long fwaAcCodeMasterid) {
		this.fwaAcCodeMasterid = fwaAcCodeMasterid;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Long getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(Long spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public Character getTranFlag() {
		return tranFlag;
	}

	public void setTranFlag(Character tranFlag) {
		this.tranFlag = tranFlag;
	}

	public long getFwaBilltransactionid() {
		return fwaBilltransactionid;
	}

	public void setFwaBilltransactionid(long fwaBilltransactionid) {
		this.fwaBilltransactionid = fwaBilltransactionid;
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
		hash += (lfyFwaBilltransactionid != null ? lfyFwaBilltransactionid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfyFwaBilltransaction)) {
			return false;
		}
		LfyFwaBilltransaction other = (LfyFwaBilltransaction) object;
		if ((this.lfyFwaBilltransactionid == null && other.lfyFwaBilltransactionid != null)
				|| (this.lfyFwaBilltransactionid != null
						&& !this.lfyFwaBilltransactionid.equals(other.lfyFwaBilltransactionid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfyFwaBilltransaction[ lfyFwaBilltransactionid=" + lfyFwaBilltransactionid + " ]";
	}

}
