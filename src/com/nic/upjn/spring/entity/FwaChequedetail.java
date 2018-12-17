/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "FWA_CHEQUEDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FwaChequedetail.findAll", query = "SELECT f FROM FwaChequedetail f"),
		@NamedQuery(name = "FwaChequedetail.findByFwaChequedetailid", query = "SELECT f FROM FwaChequedetail f WHERE f.fwaChequedetailid = :fwaChequedetailid"),
		@NamedQuery(name = "FwaChequedetail.findByChequeNo", query = "SELECT f FROM FwaChequedetail f WHERE f.chequeNo = :chequeNo"),
		@NamedQuery(name = "FwaChequedetail.findByChequeDate", query = "SELECT f FROM FwaChequedetail f WHERE f.chequeDate = :chequeDate"),
		@NamedQuery(name = "FwaChequedetail.findByAmount", query = "SELECT f FROM FwaChequedetail f WHERE f.amount = :amount"),
		@NamedQuery(name = "FwaChequedetail.findByPresentedToBankDate", query = "SELECT f FROM FwaChequedetail f WHERE f.presentedToBankDate = :presentedToBankDate"),
		@NamedQuery(name = "FwaChequedetail.findByBankDate", query = "SELECT f FROM FwaChequedetail f WHERE f.bankDate = :bankDate"),
		@NamedQuery(name = "FwaChequedetail.findByIscleared", query = "SELECT f FROM FwaChequedetail f WHERE f.iscleared = :iscleared"),
		@NamedQuery(name = "FwaChequedetail.findByReasonForRejection", query = "SELECT f FROM FwaChequedetail f WHERE f.reasonForRejection = :reasonForRejection"),
		@NamedQuery(name = "FwaChequedetail.findByIssueingBankid", query = "SELECT f FROM FwaChequedetail f WHERE f.issueingBankid = :issueingBankid"),
		@NamedQuery(name = "FwaChequedetail.findByInFavourOf", query = "SELECT f FROM FwaChequedetail f WHERE f.inFavourOf = :inFavourOf"),
		@NamedQuery(name = "FwaChequedetail.findByIssuedByUs", query = "SELECT f FROM FwaChequedetail f WHERE f.issuedByUs = :issuedByUs"),
		@NamedQuery(name = "FwaChequedetail.findByIsCash", query = "SELECT f FROM FwaChequedetail f WHERE f.isCash = :isCash"),
		@NamedQuery(name = "FwaChequedetail.findByEntrydate", query = "SELECT f FROM FwaChequedetail f WHERE f.entrydate = :entrydate"),
		@NamedQuery(name = "FwaChequedetail.findByRemark", query = "SELECT f FROM FwaChequedetail f WHERE f.remark = :remark"),
		@NamedQuery(name = "FwaChequedetail.findByCancleDate", query = "SELECT f FROM FwaChequedetail f WHERE f.cancleDate = :cancleDate") })
public class FwaChequedetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "FWA_CHEQUEDETAILID")
	private Long fwaChequedetailid;
	@Column(name = "CHEQUE_NO")
	private String chequeNo;
	@Column(name = "CHEQUE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date chequeDate;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private BigDecimal amount;
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
	@Column(name = "ISSUEING_BANKID")
	private Integer issueingBankid;
	@Column(name = "IN_FAVOUR_OF")
	private String inFavourOf;
	@Basic(optional = false)
	@Column(name = "ISSUED_BY_US")
	private Character issuedByUs;
	@Basic(optional = false)
	@Column(name = "IS_CASH")
	private Character isCash;
	@Basic(optional = false)
	@Column(name = "ENTRYDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date entrydate;
	@Column(name = "REMARK")
	private String remark;
	@Column(name = "CANCLE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date cancleDate;
	@OneToMany(mappedBy = "fwaChequedetailid")
	private Collection<FwaTransaction> fwaTransactionCollection;
	@JoinColumn(name = "FWA_BANKACCOUNTID", referencedColumnName = "FWA_BANKACCOUNTID")
	@ManyToOne
	private FwaBankaccount fwaBankaccountid;
	@JoinColumn(name = "FWA_BILLMASTERID", referencedColumnName = "FWA_BILLMASTERID")
	@ManyToOne(optional = false)
	private FwaBillmaster fwaBillmasterid;

	public FwaChequedetail() {
	}

	public FwaChequedetail(Long fwaChequedetailid) {
		this.fwaChequedetailid = fwaChequedetailid;
	}

	public FwaChequedetail(Long fwaChequedetailid, BigDecimal amount, Character iscleared, Character issuedByUs,
			Character isCash, Date entrydate) {
		this.fwaChequedetailid = fwaChequedetailid;
		this.amount = amount;
		this.iscleared = iscleared;
		this.issuedByUs = issuedByUs;
		this.isCash = isCash;
		this.entrydate = entrydate;
	}

	public Long getFwaChequedetailid() {
		return fwaChequedetailid;
	}

	public void setFwaChequedetailid(Long fwaChequedetailid) {
		this.fwaChequedetailid = fwaChequedetailid;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	public Integer getIssueingBankid() {
		return issueingBankid;
	}

	public void setIssueingBankid(Integer issueingBankid) {
		this.issueingBankid = issueingBankid;
	}

	public String getInFavourOf() {
		return inFavourOf;
	}

	public void setInFavourOf(String inFavourOf) {
		this.inFavourOf = inFavourOf;
	}

	public Character getIssuedByUs() {
		return issuedByUs;
	}

	public void setIssuedByUs(Character issuedByUs) {
		this.issuedByUs = issuedByUs;
	}

	public Character getIsCash() {
		return isCash;
	}

	public void setIsCash(Character isCash) {
		this.isCash = isCash;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCancleDate() {
		return cancleDate;
	}

	public void setCancleDate(Date cancleDate) {
		this.cancleDate = cancleDate;
	}

	@XmlTransient
	public Collection<FwaTransaction> getFwaTransactionCollection() {
		return fwaTransactionCollection;
	}

	public void setFwaTransactionCollection(Collection<FwaTransaction> fwaTransactionCollection) {
		this.fwaTransactionCollection = fwaTransactionCollection;
	}

	public FwaBankaccount getFwaBankaccountid() {
		return fwaBankaccountid;
	}

	public void setFwaBankaccountid(FwaBankaccount fwaBankaccountid) {
		this.fwaBankaccountid = fwaBankaccountid;
	}

	public FwaBillmaster getFwaBillmasterid() {
		return fwaBillmasterid;
	}

	public void setFwaBillmasterid(FwaBillmaster fwaBillmasterid) {
		this.fwaBillmasterid = fwaBillmasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (fwaChequedetailid != null ? fwaChequedetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof FwaChequedetail)) {
			return false;
		}
		FwaChequedetail other = (FwaChequedetail) object;
		if ((this.fwaChequedetailid == null && other.fwaChequedetailid != null)
				|| (this.fwaChequedetailid != null && !this.fwaChequedetailid.equals(other.fwaChequedetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.FwaChequedetail[ fwaChequedetailid=" + fwaChequedetailid + " ]";
	}

}
