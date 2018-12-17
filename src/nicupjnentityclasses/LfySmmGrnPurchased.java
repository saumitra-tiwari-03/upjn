/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
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
@Table(name = "LFY_SMM_GRN_PURCHASED")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfySmmGrnPurchased.findAll", query = "SELECT l FROM LfySmmGrnPurchased l"),
		@NamedQuery(name = "LfySmmGrnPurchased.findByLfySmmGrnPurchasedid", query = "SELECT l FROM LfySmmGrnPurchased l WHERE l.lfySmmGrnPurchasedid = :lfySmmGrnPurchasedid"),
		@NamedQuery(name = "LfySmmGrnPurchased.findByInvoiceDate", query = "SELECT l FROM LfySmmGrnPurchased l WHERE l.invoiceDate = :invoiceDate"),
		@NamedQuery(name = "LfySmmGrnPurchased.findByInvoiceNo", query = "SELECT l FROM LfySmmGrnPurchased l WHERE l.invoiceNo = :invoiceNo"),
		@NamedQuery(name = "LfySmmGrnPurchased.findBySmmSupplierid", query = "SELECT l FROM LfySmmGrnPurchased l WHERE l.smmSupplierid = :smmSupplierid"),
		@NamedQuery(name = "LfySmmGrnPurchased.findBySpSchememasterid", query = "SELECT l FROM LfySmmGrnPurchased l WHERE l.spSchememasterid = :spSchememasterid"),
		@NamedQuery(name = "LfySmmGrnPurchased.findByRmOfficeid", query = "SELECT l FROM LfySmmGrnPurchased l WHERE l.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "LfySmmGrnPurchased.findByDtrNo", query = "SELECT l FROM LfySmmGrnPurchased l WHERE l.dtrNo = :dtrNo"),
		@NamedQuery(name = "LfySmmGrnPurchased.findByJeName", query = "SELECT l FROM LfySmmGrnPurchased l WHERE l.jeName = :jeName"),
		@NamedQuery(name = "LfySmmGrnPurchased.findByPurchaseFolio", query = "SELECT l FROM LfySmmGrnPurchased l WHERE l.purchaseFolio = :purchaseFolio"),
		@NamedQuery(name = "LfySmmGrnPurchased.findByGrnNo", query = "SELECT l FROM LfySmmGrnPurchased l WHERE l.grnNo = :grnNo"),
		@NamedQuery(name = "LfySmmGrnPurchased.findByPurchasedthrough", query = "SELECT l FROM LfySmmGrnPurchased l WHERE l.purchasedthrough = :purchasedthrough"),
		@NamedQuery(name = "LfySmmGrnPurchased.findByIsVerifiedbyFinance", query = "SELECT l FROM LfySmmGrnPurchased l WHERE l.isVerifiedbyFinance = :isVerifiedbyFinance"),
		@NamedQuery(name = "LfySmmGrnPurchased.findByGrnDate", query = "SELECT l FROM LfySmmGrnPurchased l WHERE l.grnDate = :grnDate"),
		@NamedQuery(name = "LfySmmGrnPurchased.findBySmmGrnPurchasedid", query = "SELECT l FROM LfySmmGrnPurchased l WHERE l.smmGrnPurchasedid = :smmGrnPurchasedid"),
		@NamedQuery(name = "LfySmmGrnPurchased.findByFinancialyear", query = "SELECT l FROM LfySmmGrnPurchased l WHERE l.financialyear = :financialyear") })
public class LfySmmGrnPurchased implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_SMM_GRN_PURCHASEDID")
	private Long lfySmmGrnPurchasedid;
	@Basic(optional = false)
	@Column(name = "INVOICE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date invoiceDate;
	@Basic(optional = false)
	@Column(name = "INVOICE_NO")
	private String invoiceNo;
	@Basic(optional = false)
	@Column(name = "SMM_SUPPLIERID")
	private long smmSupplierid;
	@Basic(optional = false)
	@Column(name = "SP_SCHEMEMASTERID")
	private long spSchememasterid;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private long rmOfficeid;
	@Basic(optional = false)
	@Column(name = "DTR_NO")
	private String dtrNo;
	@Basic(optional = false)
	@Column(name = "JE_NAME")
	private String jeName;
	@Basic(optional = false)
	@Column(name = "PURCHASE_FOLIO")
	private String purchaseFolio;
	@Basic(optional = false)
	@Column(name = "GRN_NO")
	private String grnNo;
	@Basic(optional = false)
	@Column(name = "PURCHASEDTHROUGH")
	private String purchasedthrough;
	@Basic(optional = false)
	@Column(name = "IS_VERIFIEDBY_FINANCE")
	private Character isVerifiedbyFinance;
	@Column(name = "GRN_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date grnDate;
	@Basic(optional = false)
	@Column(name = "SMM_GRN_PURCHASEDID")
	private long smmGrnPurchasedid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfySmmGrnPurchased() {
	}

	public LfySmmGrnPurchased(Long lfySmmGrnPurchasedid) {
		this.lfySmmGrnPurchasedid = lfySmmGrnPurchasedid;
	}

	public LfySmmGrnPurchased(Long lfySmmGrnPurchasedid, Date invoiceDate, String invoiceNo, long smmSupplierid,
			long spSchememasterid, long rmOfficeid, String dtrNo, String jeName, String purchaseFolio, String grnNo,
			String purchasedthrough, Character isVerifiedbyFinance, long smmGrnPurchasedid, String financialyear) {
		this.lfySmmGrnPurchasedid = lfySmmGrnPurchasedid;
		this.invoiceDate = invoiceDate;
		this.invoiceNo = invoiceNo;
		this.smmSupplierid = smmSupplierid;
		this.spSchememasterid = spSchememasterid;
		this.rmOfficeid = rmOfficeid;
		this.dtrNo = dtrNo;
		this.jeName = jeName;
		this.purchaseFolio = purchaseFolio;
		this.grnNo = grnNo;
		this.purchasedthrough = purchasedthrough;
		this.isVerifiedbyFinance = isVerifiedbyFinance;
		this.smmGrnPurchasedid = smmGrnPurchasedid;
		this.financialyear = financialyear;
	}

	public Long getLfySmmGrnPurchasedid() {
		return lfySmmGrnPurchasedid;
	}

	public void setLfySmmGrnPurchasedid(Long lfySmmGrnPurchasedid) {
		this.lfySmmGrnPurchasedid = lfySmmGrnPurchasedid;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public long getSmmSupplierid() {
		return smmSupplierid;
	}

	public void setSmmSupplierid(long smmSupplierid) {
		this.smmSupplierid = smmSupplierid;
	}

	public long getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(long spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public long getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(long rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getDtrNo() {
		return dtrNo;
	}

	public void setDtrNo(String dtrNo) {
		this.dtrNo = dtrNo;
	}

	public String getJeName() {
		return jeName;
	}

	public void setJeName(String jeName) {
		this.jeName = jeName;
	}

	public String getPurchaseFolio() {
		return purchaseFolio;
	}

	public void setPurchaseFolio(String purchaseFolio) {
		this.purchaseFolio = purchaseFolio;
	}

	public String getGrnNo() {
		return grnNo;
	}

	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}

	public String getPurchasedthrough() {
		return purchasedthrough;
	}

	public void setPurchasedthrough(String purchasedthrough) {
		this.purchasedthrough = purchasedthrough;
	}

	public Character getIsVerifiedbyFinance() {
		return isVerifiedbyFinance;
	}

	public void setIsVerifiedbyFinance(Character isVerifiedbyFinance) {
		this.isVerifiedbyFinance = isVerifiedbyFinance;
	}

	public Date getGrnDate() {
		return grnDate;
	}

	public void setGrnDate(Date grnDate) {
		this.grnDate = grnDate;
	}

	public long getSmmGrnPurchasedid() {
		return smmGrnPurchasedid;
	}

	public void setSmmGrnPurchasedid(long smmGrnPurchasedid) {
		this.smmGrnPurchasedid = smmGrnPurchasedid;
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
		hash += (lfySmmGrnPurchasedid != null ? lfySmmGrnPurchasedid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfySmmGrnPurchased)) {
			return false;
		}
		LfySmmGrnPurchased other = (LfySmmGrnPurchased) object;
		if ((this.lfySmmGrnPurchasedid == null && other.lfySmmGrnPurchasedid != null)
				|| (this.lfySmmGrnPurchasedid != null
						&& !this.lfySmmGrnPurchasedid.equals(other.lfySmmGrnPurchasedid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfySmmGrnPurchased[ lfySmmGrnPurchasedid=" + lfySmmGrnPurchasedid + " ]";
	}

}
