/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "LFY_SP_FUNDALLOTMENT")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfySpFundallotment.findAll", query = "SELECT l FROM LfySpFundallotment l"),
		@NamedQuery(name = "LfySpFundallotment.findByLfySpFundallotmentid", query = "SELECT l FROM LfySpFundallotment l WHERE l.lfySpFundallotmentid = :lfySpFundallotmentid"),
		@NamedQuery(name = "LfySpFundallotment.findBySpSchememasterid", query = "SELECT l FROM LfySpFundallotment l WHERE l.spSchememasterid = :spSchememasterid"),
		@NamedQuery(name = "LfySpFundallotment.findByAmount", query = "SELECT l FROM LfySpFundallotment l WHERE l.amount = :amount"),
		@NamedQuery(name = "LfySpFundallotment.findByReferencevoucherno", query = "SELECT l FROM LfySpFundallotment l WHERE l.referencevoucherno = :referencevoucherno"),
		@NamedQuery(name = "LfySpFundallotment.findByReferencedate", query = "SELECT l FROM LfySpFundallotment l WHERE l.referencedate = :referencedate"),
		@NamedQuery(name = "LfySpFundallotment.findBySource", query = "SELECT l FROM LfySpFundallotment l WHERE l.source = :source"),
		@NamedQuery(name = "LfySpFundallotment.findByFwaTransactionid", query = "SELECT l FROM LfySpFundallotment l WHERE l.fwaTransactionid = :fwaTransactionid"),
		@NamedQuery(name = "LfySpFundallotment.findByFwaBillmasterid", query = "SELECT l FROM LfySpFundallotment l WHERE l.fwaBillmasterid = :fwaBillmasterid"),
		@NamedQuery(name = "LfySpFundallotment.findByVoucherno", query = "SELECT l FROM LfySpFundallotment l WHERE l.voucherno = :voucherno"),
		@NamedQuery(name = "LfySpFundallotment.findBySpFundallotmentid", query = "SELECT l FROM LfySpFundallotment l WHERE l.spFundallotmentid = :spFundallotmentid"),
		@NamedQuery(name = "LfySpFundallotment.findByFinancialyear", query = "SELECT l FROM LfySpFundallotment l WHERE l.financialyear = :financialyear") })
public class LfySpFundallotment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_SP_FUNDALLOTMENTID")
	private Long lfySpFundallotmentid;
	@Basic(optional = false)
	@Column(name = "SP_SCHEMEMASTERID")
	private long spSchememasterid;
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private BigInteger amount;
	@Basic(optional = false)
	@Column(name = "REFERENCEVOUCHERNO")
	private String referencevoucherno;
	@Basic(optional = false)
	@Column(name = "REFERENCEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date referencedate;
	@Column(name = "SOURCE")
	private String source;
	@Column(name = "FWA_TRANSACTIONID")
	private Long fwaTransactionid;
	@Column(name = "FWA_BILLMASTERID")
	private Long fwaBillmasterid;
	@Column(name = "VOUCHERNO")
	private String voucherno;
	@Basic(optional = false)
	@Column(name = "SP_FUNDALLOTMENTID")
	private long spFundallotmentid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfySpFundallotment() {
	}

	public LfySpFundallotment(Long lfySpFundallotmentid) {
		this.lfySpFundallotmentid = lfySpFundallotmentid;
	}

	public LfySpFundallotment(Long lfySpFundallotmentid, long spSchememasterid, BigInteger amount,
			String referencevoucherno, Date referencedate, long spFundallotmentid, String financialyear) {
		this.lfySpFundallotmentid = lfySpFundallotmentid;
		this.spSchememasterid = spSchememasterid;
		this.amount = amount;
		this.referencevoucherno = referencevoucherno;
		this.referencedate = referencedate;
		this.spFundallotmentid = spFundallotmentid;
		this.financialyear = financialyear;
	}

	public Long getLfySpFundallotmentid() {
		return lfySpFundallotmentid;
	}

	public void setLfySpFundallotmentid(Long lfySpFundallotmentid) {
		this.lfySpFundallotmentid = lfySpFundallotmentid;
	}

	public long getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(long spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public BigInteger getAmount() {
		return amount;
	}

	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}

	public String getReferencevoucherno() {
		return referencevoucherno;
	}

	public void setReferencevoucherno(String referencevoucherno) {
		this.referencevoucherno = referencevoucherno;
	}

	public Date getReferencedate() {
		return referencedate;
	}

	public void setReferencedate(Date referencedate) {
		this.referencedate = referencedate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getFwaTransactionid() {
		return fwaTransactionid;
	}

	public void setFwaTransactionid(Long fwaTransactionid) {
		this.fwaTransactionid = fwaTransactionid;
	}

	public Long getFwaBillmasterid() {
		return fwaBillmasterid;
	}

	public void setFwaBillmasterid(Long fwaBillmasterid) {
		this.fwaBillmasterid = fwaBillmasterid;
	}

	public String getVoucherno() {
		return voucherno;
	}

	public void setVoucherno(String voucherno) {
		this.voucherno = voucherno;
	}

	public long getSpFundallotmentid() {
		return spFundallotmentid;
	}

	public void setSpFundallotmentid(long spFundallotmentid) {
		this.spFundallotmentid = spFundallotmentid;
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
		hash += (lfySpFundallotmentid != null ? lfySpFundallotmentid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfySpFundallotment)) {
			return false;
		}
		LfySpFundallotment other = (LfySpFundallotment) object;
		if ((this.lfySpFundallotmentid == null && other.lfySpFundallotmentid != null)
				|| (this.lfySpFundallotmentid != null
						&& !this.lfySpFundallotmentid.equals(other.lfySpFundallotmentid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfySpFundallotment[ lfySpFundallotmentid=" + lfySpFundallotmentid + " ]";
	}

}
