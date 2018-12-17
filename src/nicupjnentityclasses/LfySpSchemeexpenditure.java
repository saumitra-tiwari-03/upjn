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
@Table(name = "LFY_SP_SCHEMEEXPENDITURE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfySpSchemeexpenditure.findAll", query = "SELECT l FROM LfySpSchemeexpenditure l"),
		@NamedQuery(name = "LfySpSchemeexpenditure.findByLfySpSchemeexpenditureid", query = "SELECT l FROM LfySpSchemeexpenditure l WHERE l.lfySpSchemeexpenditureid = :lfySpSchemeexpenditureid"),
		@NamedQuery(name = "LfySpSchemeexpenditure.findByFromdate", query = "SELECT l FROM LfySpSchemeexpenditure l WHERE l.fromdate = :fromdate"),
		@NamedQuery(name = "LfySpSchemeexpenditure.findByTodate", query = "SELECT l FROM LfySpSchemeexpenditure l WHERE l.todate = :todate"),
		@NamedQuery(name = "LfySpSchemeexpenditure.findByAmount", query = "SELECT l FROM LfySpSchemeexpenditure l WHERE l.amount = :amount"),
		@NamedQuery(name = "LfySpSchemeexpenditure.findByRemark", query = "SELECT l FROM LfySpSchemeexpenditure l WHERE l.remark = :remark"),
		@NamedQuery(name = "LfySpSchemeexpenditure.findBySpSchememasterid", query = "SELECT l FROM LfySpSchemeexpenditure l WHERE l.spSchememasterid = :spSchememasterid"),
		@NamedQuery(name = "LfySpSchemeexpenditure.findByReferenceletterno", query = "SELECT l FROM LfySpSchemeexpenditure l WHERE l.referenceletterno = :referenceletterno"),
		@NamedQuery(name = "LfySpSchemeexpenditure.findByFwaTransactionid", query = "SELECT l FROM LfySpSchemeexpenditure l WHERE l.fwaTransactionid = :fwaTransactionid"),
		@NamedQuery(name = "LfySpSchemeexpenditure.findByFwaBillmasterid", query = "SELECT l FROM LfySpSchemeexpenditure l WHERE l.fwaBillmasterid = :fwaBillmasterid"),
		@NamedQuery(name = "LfySpSchemeexpenditure.findByVoucherno", query = "SELECT l FROM LfySpSchemeexpenditure l WHERE l.voucherno = :voucherno"),
		@NamedQuery(name = "LfySpSchemeexpenditure.findBySpSchemeexpenditureid", query = "SELECT l FROM LfySpSchemeexpenditure l WHERE l.spSchemeexpenditureid = :spSchemeexpenditureid"),
		@NamedQuery(name = "LfySpSchemeexpenditure.findByFinancialyear", query = "SELECT l FROM LfySpSchemeexpenditure l WHERE l.financialyear = :financialyear") })
public class LfySpSchemeexpenditure implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_SP_SCHEMEEXPENDITUREID")
	private Long lfySpSchemeexpenditureid;
	@Basic(optional = false)
	@Column(name = "FROMDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromdate;
	@Basic(optional = false)
	@Column(name = "TODATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date todate;
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private BigInteger amount;
	@Column(name = "REMARK")
	private String remark;
	@Basic(optional = false)
	@Column(name = "SP_SCHEMEMASTERID")
	private long spSchememasterid;
	@Column(name = "REFERENCELETTERNO")
	private String referenceletterno;
	@Column(name = "FWA_TRANSACTIONID")
	private Long fwaTransactionid;
	@Column(name = "FWA_BILLMASTERID")
	private Long fwaBillmasterid;
	@Basic(optional = false)
	@Column(name = "VOUCHERNO")
	private String voucherno;
	@Basic(optional = false)
	@Column(name = "SP_SCHEMEEXPENDITUREID")
	private long spSchemeexpenditureid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfySpSchemeexpenditure() {
	}

	public LfySpSchemeexpenditure(Long lfySpSchemeexpenditureid) {
		this.lfySpSchemeexpenditureid = lfySpSchemeexpenditureid;
	}

	public LfySpSchemeexpenditure(Long lfySpSchemeexpenditureid, Date fromdate, Date todate, BigInteger amount,
			long spSchememasterid, String voucherno, long spSchemeexpenditureid, String financialyear) {
		this.lfySpSchemeexpenditureid = lfySpSchemeexpenditureid;
		this.fromdate = fromdate;
		this.todate = todate;
		this.amount = amount;
		this.spSchememasterid = spSchememasterid;
		this.voucherno = voucherno;
		this.spSchemeexpenditureid = spSchemeexpenditureid;
		this.financialyear = financialyear;
	}

	public Long getLfySpSchemeexpenditureid() {
		return lfySpSchemeexpenditureid;
	}

	public void setLfySpSchemeexpenditureid(Long lfySpSchemeexpenditureid) {
		this.lfySpSchemeexpenditureid = lfySpSchemeexpenditureid;
	}

	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	public Date getTodate() {
		return todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

	public BigInteger getAmount() {
		return amount;
	}

	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(long spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public String getReferenceletterno() {
		return referenceletterno;
	}

	public void setReferenceletterno(String referenceletterno) {
		this.referenceletterno = referenceletterno;
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

	public long getSpSchemeexpenditureid() {
		return spSchemeexpenditureid;
	}

	public void setSpSchemeexpenditureid(long spSchemeexpenditureid) {
		this.spSchemeexpenditureid = spSchemeexpenditureid;
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
		hash += (lfySpSchemeexpenditureid != null ? lfySpSchemeexpenditureid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfySpSchemeexpenditure)) {
			return false;
		}
		LfySpSchemeexpenditure other = (LfySpSchemeexpenditure) object;
		if ((this.lfySpSchemeexpenditureid == null && other.lfySpSchemeexpenditureid != null)
				|| (this.lfySpSchemeexpenditureid != null
						&& !this.lfySpSchemeexpenditureid.equals(other.lfySpSchemeexpenditureid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfySpSchemeexpenditure[ lfySpSchemeexpenditureid=" + lfySpSchemeexpenditureid
				+ " ]";
	}

}
