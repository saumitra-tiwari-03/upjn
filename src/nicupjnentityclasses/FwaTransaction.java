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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "FWA_TRANSACTION")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FwaTransaction.findAll", query = "SELECT f FROM FwaTransaction f"),
		@NamedQuery(name = "FwaTransaction.findByFwaTransactionid", query = "SELECT f FROM FwaTransaction f WHERE f.fwaTransactionid = :fwaTransactionid"),
		@NamedQuery(name = "FwaTransaction.findByAmount", query = "SELECT f FROM FwaTransaction f WHERE f.amount = :amount"),
		@NamedQuery(name = "FwaTransaction.findByTranType", query = "SELECT f FROM FwaTransaction f WHERE f.tranType = :tranType"),
		@NamedQuery(name = "FwaTransaction.findByTransactionDate", query = "SELECT f FROM FwaTransaction f WHERE f.transactionDate = :transactionDate"),
		@NamedQuery(name = "FwaTransaction.findByIslocked", query = "SELECT f FROM FwaTransaction f WHERE f.islocked = :islocked") })
public class FwaTransaction implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "FWA_TRANSACTIONID")
	private Long fwaTransactionid;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Basic(optional = false)
	@Column(name = "TRAN_TYPE")
	private String tranType;
	@Basic(optional = false)
	@Column(name = "TRANSACTION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	@Basic(optional = false)
	@Column(name = "ISLOCKED")
	private Character islocked;
	@JoinColumn(name = "FWA_AC_CODE_MASTERID", referencedColumnName = "FWA_AC_CODE_MASTERID")
	@ManyToOne(optional = false)
	private FwaAcCodeMaster fwaAcCodeMasterid;
	@JoinColumn(name = "FWA_BILLMASTERID", referencedColumnName = "FWA_BILLMASTERID")
	@ManyToOne
	private FwaBillmaster fwaBillmasterid;
	@JoinColumn(name = "FWA_CHEQUEDETAILID", referencedColumnName = "FWA_CHEQUEDETAILID")
	@ManyToOne
	private FwaChequedetail fwaChequedetailid;

	public FwaTransaction() {
	}

	public FwaTransaction(Long fwaTransactionid) {
		this.fwaTransactionid = fwaTransactionid;
	}

	public FwaTransaction(Long fwaTransactionid, BigDecimal amount, String tranType, Date transactionDate,
			Character islocked) {
		this.fwaTransactionid = fwaTransactionid;
		this.amount = amount;
		this.tranType = tranType;
		this.transactionDate = transactionDate;
		this.islocked = islocked;
	}

	public Long getFwaTransactionid() {
		return fwaTransactionid;
	}

	public void setFwaTransactionid(Long fwaTransactionid) {
		this.fwaTransactionid = fwaTransactionid;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Character getIslocked() {
		return islocked;
	}

	public void setIslocked(Character islocked) {
		this.islocked = islocked;
	}

	public FwaAcCodeMaster getFwaAcCodeMasterid() {
		return fwaAcCodeMasterid;
	}

	public void setFwaAcCodeMasterid(FwaAcCodeMaster fwaAcCodeMasterid) {
		this.fwaAcCodeMasterid = fwaAcCodeMasterid;
	}

	public FwaBillmaster getFwaBillmasterid() {
		return fwaBillmasterid;
	}

	public void setFwaBillmasterid(FwaBillmaster fwaBillmasterid) {
		this.fwaBillmasterid = fwaBillmasterid;
	}

	public FwaChequedetail getFwaChequedetailid() {
		return fwaChequedetailid;
	}

	public void setFwaChequedetailid(FwaChequedetail fwaChequedetailid) {
		this.fwaChequedetailid = fwaChequedetailid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (fwaTransactionid != null ? fwaTransactionid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof FwaTransaction)) {
			return false;
		}
		FwaTransaction other = (FwaTransaction) object;
		if ((this.fwaTransactionid == null && other.fwaTransactionid != null)
				|| (this.fwaTransactionid != null && !this.fwaTransactionid.equals(other.fwaTransactionid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.FwaTransaction[ fwaTransactionid=" + fwaTransactionid + " ]";
	}

}
