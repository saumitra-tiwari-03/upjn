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
@Table(name = "LFY_FWA_GENERAL_LEDGER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfyFwaGeneralLedger.findAll", query = "SELECT l FROM LfyFwaGeneralLedger l"),
		@NamedQuery(name = "LfyFwaGeneralLedger.findByLfyFwaGeneralLedgerid", query = "SELECT l FROM LfyFwaGeneralLedger l WHERE l.lfyFwaGeneralLedgerid = :lfyFwaGeneralLedgerid"),
		@NamedQuery(name = "LfyFwaGeneralLedger.findByFwaAcCodeMasterid", query = "SELECT l FROM LfyFwaGeneralLedger l WHERE l.fwaAcCodeMasterid = :fwaAcCodeMasterid"),
		@NamedQuery(name = "LfyFwaGeneralLedger.findByTranType", query = "SELECT l FROM LfyFwaGeneralLedger l WHERE l.tranType = :tranType"),
		@NamedQuery(name = "LfyFwaGeneralLedger.findByBillmonth", query = "SELECT l FROM LfyFwaGeneralLedger l WHERE l.billmonth = :billmonth"),
		@NamedQuery(name = "LfyFwaGeneralLedger.findByBillyear", query = "SELECT l FROM LfyFwaGeneralLedger l WHERE l.billyear = :billyear"),
		@NamedQuery(name = "LfyFwaGeneralLedger.findByBillamount", query = "SELECT l FROM LfyFwaGeneralLedger l WHERE l.billamount = :billamount"),
		@NamedQuery(name = "LfyFwaGeneralLedger.findByParticulars", query = "SELECT l FROM LfyFwaGeneralLedger l WHERE l.particulars = :particulars"),
		@NamedQuery(name = "LfyFwaGeneralLedger.findByFwaBillmasterid", query = "SELECT l FROM LfyFwaGeneralLedger l WHERE l.fwaBillmasterid = :fwaBillmasterid"),
		@NamedQuery(name = "LfyFwaGeneralLedger.findByVoucherno", query = "SELECT l FROM LfyFwaGeneralLedger l WHERE l.voucherno = :voucherno"),
		@NamedQuery(name = "LfyFwaGeneralLedger.findByTransactionDate", query = "SELECT l FROM LfyFwaGeneralLedger l WHERE l.transactionDate = :transactionDate"),
		@NamedQuery(name = "LfyFwaGeneralLedger.findByFwaGeneralLedgerid", query = "SELECT l FROM LfyFwaGeneralLedger l WHERE l.fwaGeneralLedgerid = :fwaGeneralLedgerid"),
		@NamedQuery(name = "LfyFwaGeneralLedger.findByFinancialyear", query = "SELECT l FROM LfyFwaGeneralLedger l WHERE l.financialyear = :financialyear") })
public class LfyFwaGeneralLedger implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_FWA_GENERAL_LEDGERID")
	private Long lfyFwaGeneralLedgerid;
	@Basic(optional = false)
	@Column(name = "FWA_AC_CODE_MASTERID")
	private long fwaAcCodeMasterid;
	@Basic(optional = false)
	@Column(name = "TRAN_TYPE")
	private String tranType;
	@Column(name = "BILLMONTH")
	private Short billmonth;
	@Column(name = "BILLYEAR")
	private Short billyear;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "BILLAMOUNT")
	private BigDecimal billamount;
	@Column(name = "PARTICULARS")
	private String particulars;
	@Basic(optional = false)
	@Column(name = "FWA_BILLMASTERID")
	private long fwaBillmasterid;
	@Basic(optional = false)
	@Column(name = "VOUCHERNO")
	private String voucherno;
	@Basic(optional = false)
	@Column(name = "TRANSACTION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	@Basic(optional = false)
	@Column(name = "FWA_GENERAL_LEDGERID")
	private long fwaGeneralLedgerid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfyFwaGeneralLedger() {
	}

	public LfyFwaGeneralLedger(Long lfyFwaGeneralLedgerid) {
		this.lfyFwaGeneralLedgerid = lfyFwaGeneralLedgerid;
	}

	public LfyFwaGeneralLedger(Long lfyFwaGeneralLedgerid, long fwaAcCodeMasterid, String tranType,
			BigDecimal billamount, long fwaBillmasterid, String voucherno, Date transactionDate,
			long fwaGeneralLedgerid, String financialyear) {
		this.lfyFwaGeneralLedgerid = lfyFwaGeneralLedgerid;
		this.fwaAcCodeMasterid = fwaAcCodeMasterid;
		this.tranType = tranType;
		this.billamount = billamount;
		this.fwaBillmasterid = fwaBillmasterid;
		this.voucherno = voucherno;
		this.transactionDate = transactionDate;
		this.fwaGeneralLedgerid = fwaGeneralLedgerid;
		this.financialyear = financialyear;
	}

	public Long getLfyFwaGeneralLedgerid() {
		return lfyFwaGeneralLedgerid;
	}

	public void setLfyFwaGeneralLedgerid(Long lfyFwaGeneralLedgerid) {
		this.lfyFwaGeneralLedgerid = lfyFwaGeneralLedgerid;
	}

	public long getFwaAcCodeMasterid() {
		return fwaAcCodeMasterid;
	}

	public void setFwaAcCodeMasterid(long fwaAcCodeMasterid) {
		this.fwaAcCodeMasterid = fwaAcCodeMasterid;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public Short getBillmonth() {
		return billmonth;
	}

	public void setBillmonth(Short billmonth) {
		this.billmonth = billmonth;
	}

	public Short getBillyear() {
		return billyear;
	}

	public void setBillyear(Short billyear) {
		this.billyear = billyear;
	}

	public BigDecimal getBillamount() {
		return billamount;
	}

	public void setBillamount(BigDecimal billamount) {
		this.billamount = billamount;
	}

	public String getParticulars() {
		return particulars;
	}

	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}

	public long getFwaBillmasterid() {
		return fwaBillmasterid;
	}

	public void setFwaBillmasterid(long fwaBillmasterid) {
		this.fwaBillmasterid = fwaBillmasterid;
	}

	public String getVoucherno() {
		return voucherno;
	}

	public void setVoucherno(String voucherno) {
		this.voucherno = voucherno;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public long getFwaGeneralLedgerid() {
		return fwaGeneralLedgerid;
	}

	public void setFwaGeneralLedgerid(long fwaGeneralLedgerid) {
		this.fwaGeneralLedgerid = fwaGeneralLedgerid;
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
		hash += (lfyFwaGeneralLedgerid != null ? lfyFwaGeneralLedgerid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfyFwaGeneralLedger)) {
			return false;
		}
		LfyFwaGeneralLedger other = (LfyFwaGeneralLedger) object;
		if ((this.lfyFwaGeneralLedgerid == null && other.lfyFwaGeneralLedgerid != null)
				|| (this.lfyFwaGeneralLedgerid != null
						&& !this.lfyFwaGeneralLedgerid.equals(other.lfyFwaGeneralLedgerid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfyFwaGeneralLedger[ lfyFwaGeneralLedgerid=" + lfyFwaGeneralLedgerid + " ]";
	}

}
