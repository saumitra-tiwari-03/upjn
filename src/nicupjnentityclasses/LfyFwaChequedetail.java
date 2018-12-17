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
@Table(name = "LFY_FWA_CHEQUEDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfyFwaChequedetail.findAll", query = "SELECT l FROM LfyFwaChequedetail l"),
		@NamedQuery(name = "LfyFwaChequedetail.findByLfyFwaChequedetailid", query = "SELECT l FROM LfyFwaChequedetail l WHERE l.lfyFwaChequedetailid = :lfyFwaChequedetailid"),
		@NamedQuery(name = "LfyFwaChequedetail.findByFwaBillmasterid", query = "SELECT l FROM LfyFwaChequedetail l WHERE l.fwaBillmasterid = :fwaBillmasterid"),
		@NamedQuery(name = "LfyFwaChequedetail.findByFwaBankaccountid", query = "SELECT l FROM LfyFwaChequedetail l WHERE l.fwaBankaccountid = :fwaBankaccountid"),
		@NamedQuery(name = "LfyFwaChequedetail.findByChequeNo", query = "SELECT l FROM LfyFwaChequedetail l WHERE l.chequeNo = :chequeNo"),
		@NamedQuery(name = "LfyFwaChequedetail.findByChequeDate", query = "SELECT l FROM LfyFwaChequedetail l WHERE l.chequeDate = :chequeDate"),
		@NamedQuery(name = "LfyFwaChequedetail.findByInFavourOf", query = "SELECT l FROM LfyFwaChequedetail l WHERE l.inFavourOf = :inFavourOf"),
		@NamedQuery(name = "LfyFwaChequedetail.findByAmount", query = "SELECT l FROM LfyFwaChequedetail l WHERE l.amount = :amount"),
		@NamedQuery(name = "LfyFwaChequedetail.findByVoucherno", query = "SELECT l FROM LfyFwaChequedetail l WHERE l.voucherno = :voucherno"),
		@NamedQuery(name = "LfyFwaChequedetail.findByPresentedToBankDate", query = "SELECT l FROM LfyFwaChequedetail l WHERE l.presentedToBankDate = :presentedToBankDate"),
		@NamedQuery(name = "LfyFwaChequedetail.findByBankDate", query = "SELECT l FROM LfyFwaChequedetail l WHERE l.bankDate = :bankDate"),
		@NamedQuery(name = "LfyFwaChequedetail.findByIscleared", query = "SELECT l FROM LfyFwaChequedetail l WHERE l.iscleared = :iscleared"),
		@NamedQuery(name = "LfyFwaChequedetail.findByReasonForRejection", query = "SELECT l FROM LfyFwaChequedetail l WHERE l.reasonForRejection = :reasonForRejection"),
		@NamedQuery(name = "LfyFwaChequedetail.findByFwaChequedetailid", query = "SELECT l FROM LfyFwaChequedetail l WHERE l.fwaChequedetailid = :fwaChequedetailid"),
		@NamedQuery(name = "LfyFwaChequedetail.findByFinancialyear", query = "SELECT l FROM LfyFwaChequedetail l WHERE l.financialyear = :financialyear") })
public class LfyFwaChequedetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_FWA_CHEQUEDETAILID")
	private Long lfyFwaChequedetailid;
	@Basic(optional = false)
	@Column(name = "FWA_BILLMASTERID")
	private long fwaBillmasterid;
	@Basic(optional = false)
	@Column(name = "FWA_BANKACCOUNTID")
	private long fwaBankaccountid;
	@Basic(optional = false)
	@Column(name = "CHEQUE_NO")
	private String chequeNo;
	@Basic(optional = false)
	@Column(name = "CHEQUE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date chequeDate;
	@Basic(optional = false)
	@Column(name = "IN_FAVOUR_OF")
	private String inFavourOf;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Basic(optional = false)
	@Column(name = "VOUCHERNO")
	private String voucherno;
	@Column(name = "PRESENTED_TO_BANK_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date presentedToBankDate;
	@Column(name = "BANK_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date bankDate;
	@Basic(optional = false)
	@Column(name = "ISCLEARED")
	private Character iscleared;
	@Column(name = "REASON_FOR_REJECTION")
	private String reasonForRejection;
	@Basic(optional = false)
	@Column(name = "FWA_CHEQUEDETAILID")
	private long fwaChequedetailid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfyFwaChequedetail() {
	}

	public LfyFwaChequedetail(Long lfyFwaChequedetailid) {
		this.lfyFwaChequedetailid = lfyFwaChequedetailid;
	}

	public LfyFwaChequedetail(Long lfyFwaChequedetailid, long fwaBillmasterid, long fwaBankaccountid, String chequeNo,
			Date chequeDate, String inFavourOf, BigDecimal amount, String voucherno, Character iscleared,
			long fwaChequedetailid, String financialyear) {
		this.lfyFwaChequedetailid = lfyFwaChequedetailid;
		this.fwaBillmasterid = fwaBillmasterid;
		this.fwaBankaccountid = fwaBankaccountid;
		this.chequeNo = chequeNo;
		this.chequeDate = chequeDate;
		this.inFavourOf = inFavourOf;
		this.amount = amount;
		this.voucherno = voucherno;
		this.iscleared = iscleared;
		this.fwaChequedetailid = fwaChequedetailid;
		this.financialyear = financialyear;
	}

	public Long getLfyFwaChequedetailid() {
		return lfyFwaChequedetailid;
	}

	public void setLfyFwaChequedetailid(Long lfyFwaChequedetailid) {
		this.lfyFwaChequedetailid = lfyFwaChequedetailid;
	}

	public long getFwaBillmasterid() {
		return fwaBillmasterid;
	}

	public void setFwaBillmasterid(long fwaBillmasterid) {
		this.fwaBillmasterid = fwaBillmasterid;
	}

	public long getFwaBankaccountid() {
		return fwaBankaccountid;
	}

	public void setFwaBankaccountid(long fwaBankaccountid) {
		this.fwaBankaccountid = fwaBankaccountid;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public Date getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	public String getInFavourOf() {
		return inFavourOf;
	}

	public void setInFavourOf(String inFavourOf) {
		this.inFavourOf = inFavourOf;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getVoucherno() {
		return voucherno;
	}

	public void setVoucherno(String voucherno) {
		this.voucherno = voucherno;
	}

	public Date getPresentedToBankDate() {
		return presentedToBankDate;
	}

	public void setPresentedToBankDate(Date presentedToBankDate) {
		this.presentedToBankDate = presentedToBankDate;
	}

	public Date getBankDate() {
		return bankDate;
	}

	public void setBankDate(Date bankDate) {
		this.bankDate = bankDate;
	}

	public Character getIscleared() {
		return iscleared;
	}

	public void setIscleared(Character iscleared) {
		this.iscleared = iscleared;
	}

	public String getReasonForRejection() {
		return reasonForRejection;
	}

	public void setReasonForRejection(String reasonForRejection) {
		this.reasonForRejection = reasonForRejection;
	}

	public long getFwaChequedetailid() {
		return fwaChequedetailid;
	}

	public void setFwaChequedetailid(long fwaChequedetailid) {
		this.fwaChequedetailid = fwaChequedetailid;
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
		hash += (lfyFwaChequedetailid != null ? lfyFwaChequedetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfyFwaChequedetail)) {
			return false;
		}
		LfyFwaChequedetail other = (LfyFwaChequedetail) object;
		if ((this.lfyFwaChequedetailid == null && other.lfyFwaChequedetailid != null)
				|| (this.lfyFwaChequedetailid != null
						&& !this.lfyFwaChequedetailid.equals(other.lfyFwaChequedetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfyFwaChequedetail[ lfyFwaChequedetailid=" + lfyFwaChequedetailid + " ]";
	}

}
