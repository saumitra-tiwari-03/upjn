/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "FWA_BILLMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FwaBillmaster.findAll", query = "SELECT f FROM FwaBillmaster f"),
		@NamedQuery(name = "FwaBillmaster.findByFwaBillmasterid", query = "SELECT f FROM FwaBillmaster f WHERE f.fwaBillmasterid = :fwaBillmasterid"),
		@NamedQuery(name = "FwaBillmaster.findByBillno", query = "SELECT f FROM FwaBillmaster f WHERE f.billno = :billno"),
		@NamedQuery(name = "FwaBillmaster.findByBilldate", query = "SELECT f FROM FwaBillmaster f WHERE f.billdate = :billdate"),
		@NamedQuery(name = "FwaBillmaster.findByBillAmount", query = "SELECT f FROM FwaBillmaster f WHERE f.billAmount = :billAmount"),
		@NamedQuery(name = "FwaBillmaster.findBySysVouchertypeid", query = "SELECT f FROM FwaBillmaster f WHERE f.sysVouchertypeid = :sysVouchertypeid"),
		@NamedQuery(name = "FwaBillmaster.findByTransactiontype", query = "SELECT f FROM FwaBillmaster f WHERE f.transactiontype = :transactiontype"),
		@NamedQuery(name = "FwaBillmaster.findByUpjnRefNo", query = "SELECT f FROM FwaBillmaster f WHERE f.upjnRefNo = :upjnRefNo"),
		@NamedQuery(name = "FwaBillmaster.findByReferenceTableId", query = "SELECT f FROM FwaBillmaster f WHERE f.referenceTableId = :referenceTableId"),
		@NamedQuery(name = "FwaBillmaster.findByBillFrom", query = "SELECT f FROM FwaBillmaster f WHERE f.billFrom = :billFrom"),
		@NamedQuery(name = "FwaBillmaster.findByDescription", query = "SELECT f FROM FwaBillmaster f WHERE f.description = :description"),
		@NamedQuery(name = "FwaBillmaster.findByForTeo", query = "SELECT f FROM FwaBillmaster f WHERE f.forTeo = :forTeo"),
		@NamedQuery(name = "FwaBillmaster.findByIsreceipt", query = "SELECT f FROM FwaBillmaster f WHERE f.isreceipt = :isreceipt"),
		@NamedQuery(name = "FwaBillmaster.findByGoNo", query = "SELECT f FROM FwaBillmaster f WHERE f.goNo = :goNo"),
		@NamedQuery(name = "FwaBillmaster.findByGoDate", query = "SELECT f FROM FwaBillmaster f WHERE f.goDate = :goDate"),
		@NamedQuery(name = "FwaBillmaster.findByPLedgTypecode", query = "SELECT f FROM FwaBillmaster f WHERE f.pLedgTypecode = :pLedgTypecode"),
		@NamedQuery(name = "FwaBillmaster.findByPLedgId", query = "SELECT f FROM FwaBillmaster f WHERE f.pLedgId = :pLedgId"),
		@NamedQuery(name = "FwaBillmaster.findByTeoIssued", query = "SELECT f FROM FwaBillmaster f WHERE f.teoIssued = :teoIssued"),
		@NamedQuery(name = "FwaBillmaster.findByPassedAmount", query = "SELECT f FROM FwaBillmaster f WHERE f.passedAmount = :passedAmount"),
		@NamedQuery(name = "FwaBillmaster.findByReferenceTable", query = "SELECT f FROM FwaBillmaster f WHERE f.referenceTable = :referenceTable"),
		@NamedQuery(name = "FwaBillmaster.findByCdoIssued", query = "SELECT f FROM FwaBillmaster f WHERE f.cdoIssued = :cdoIssued"),
		@NamedQuery(name = "FwaBillmaster.findByCdoNo", query = "SELECT f FROM FwaBillmaster f WHERE f.cdoNo = :cdoNo"),
		@NamedQuery(name = "FwaBillmaster.findByCdoDate", query = "SELECT f FROM FwaBillmaster f WHERE f.cdoDate = :cdoDate"),
		@NamedQuery(name = "FwaBillmaster.findByPaidAmount", query = "SELECT f FROM FwaBillmaster f WHERE f.paidAmount = :paidAmount"),
		@NamedQuery(name = "FwaBillmaster.findByReceiptNo", query = "SELECT f FROM FwaBillmaster f WHERE f.receiptNo = :receiptNo"),
		@NamedQuery(name = "FwaBillmaster.findByReceiptAcId", query = "SELECT f FROM FwaBillmaster f WHERE f.receiptAcId = :receiptAcId") })
public class FwaBillmaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "FWA_BILLMASTERID")
	private Long fwaBillmasterid;
	@Basic(optional = false)
	@Column(name = "BILLNO")
	private String billno;
	@Basic(optional = false)
	@Column(name = "BILLDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date billdate;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "BILL_AMOUNT")
	private BigDecimal billAmount;
	@Column(name = "SYS_VOUCHERTYPEID")
	private String sysVouchertypeid;
	@Basic(optional = false)
	@Column(name = "TRANSACTIONTYPE")
	private Character transactiontype;
	@Column(name = "UPJN_REF_NO")
	private String upjnRefNo;
	@Column(name = "REFERENCE_TABLE_ID")
	private Long referenceTableId;
	@Column(name = "BILL_FROM")
	private String billFrom;
	@Column(name = "DESCRIPTION")
	private String description;
	@Basic(optional = false)
	@Column(name = "FOR_TEO")
	private Character forTeo;
	@Basic(optional = false)
	@Column(name = "ISRECEIPT")
	private Character isreceipt;
	@Column(name = "GO_NO")
	private String goNo;
	@Column(name = "GO_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date goDate;
	@Column(name = "P_LEDG_TYPECODE")
	private String pLedgTypecode;
	@Column(name = "P_LEDG_ID")
	private Long pLedgId;
	@Basic(optional = false)
	@Column(name = "TEO_ISSUED")
	private Character teoIssued;
	@Basic(optional = false)
	@Column(name = "PASSED_AMOUNT")
	private BigDecimal passedAmount;
	@Column(name = "REFERENCE_TABLE")
	private String referenceTable;
	@Basic(optional = false)
	@Column(name = "CDO_ISSUED")
	private Character cdoIssued;
	@Column(name = "CDO_NO")
	private String cdoNo;
	@Column(name = "CDO_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date cdoDate;
	@Basic(optional = false)
	@Column(name = "PAID_AMOUNT")
	private BigDecimal paidAmount;
	@Column(name = "RECEIPT_NO")
	private String receiptNo;
	@Column(name = "RECEIPT_AC_ID")
	private Integer receiptAcId;
	@OneToMany(mappedBy = "fwaBillmasterid")
	private Collection<FwaTransaction> fwaTransactionCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fwaBillmasterid")
	private Collection<FwaChequedetail> fwaChequedetailCollection;
	@JoinColumn(name = "RM_OFFICEID", referencedColumnName = "RM_OFFICEID")
	@ManyToOne(optional = false)
	private RmOffice rmOfficeid;
	@OneToMany(mappedBy = "fwaBillmasterid")
	private Collection<FwaTeo> fwaTeoCollection;

	public FwaBillmaster() {
	}

	public FwaBillmaster(Long fwaBillmasterid) {
		this.fwaBillmasterid = fwaBillmasterid;
	}

	public FwaBillmaster(Long fwaBillmasterid, String billno, Date billdate, BigDecimal billAmount,
			Character transactiontype, Character forTeo, Character isreceipt, Character teoIssued,
			BigDecimal passedAmount, Character cdoIssued, BigDecimal paidAmount) {
		this.fwaBillmasterid = fwaBillmasterid;
		this.billno = billno;
		this.billdate = billdate;
		this.billAmount = billAmount;
		this.transactiontype = transactiontype;
		this.forTeo = forTeo;
		this.isreceipt = isreceipt;
		this.teoIssued = teoIssued;
		this.passedAmount = passedAmount;
		this.cdoIssued = cdoIssued;
		this.paidAmount = paidAmount;
	}

	public Long getFwaBillmasterid() {
		return fwaBillmasterid;
	}

	public void setFwaBillmasterid(Long fwaBillmasterid) {
		this.fwaBillmasterid = fwaBillmasterid;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public Date getBilldate() {
		return billdate;
	}

	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}

	public BigDecimal getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
	}

	public String getSysVouchertypeid() {
		return sysVouchertypeid;
	}

	public void setSysVouchertypeid(String sysVouchertypeid) {
		this.sysVouchertypeid = sysVouchertypeid;
	}

	public Character getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(Character transactiontype) {
		this.transactiontype = transactiontype;
	}

	public String getUpjnRefNo() {
		return upjnRefNo;
	}

	public void setUpjnRefNo(String upjnRefNo) {
		this.upjnRefNo = upjnRefNo;
	}

	public Long getReferenceTableId() {
		return referenceTableId;
	}

	public void setReferenceTableId(Long referenceTableId) {
		this.referenceTableId = referenceTableId;
	}

	public String getBillFrom() {
		return billFrom;
	}

	public void setBillFrom(String billFrom) {
		this.billFrom = billFrom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Character getForTeo() {
		return forTeo;
	}

	public void setForTeo(Character forTeo) {
		this.forTeo = forTeo;
	}

	public Character getIsreceipt() {
		return isreceipt;
	}

	public void setIsreceipt(Character isreceipt) {
		this.isreceipt = isreceipt;
	}

	public String getGoNo() {
		return goNo;
	}

	public void setGoNo(String goNo) {
		this.goNo = goNo;
	}

	public Date getGoDate() {
		return goDate;
	}

	public void setGoDate(Date goDate) {
		this.goDate = goDate;
	}

	public String getPLedgTypecode() {
		return pLedgTypecode;
	}

	public void setPLedgTypecode(String pLedgTypecode) {
		this.pLedgTypecode = pLedgTypecode;
	}

	public Long getPLedgId() {
		return pLedgId;
	}

	public void setPLedgId(Long pLedgId) {
		this.pLedgId = pLedgId;
	}

	public Character getTeoIssued() {
		return teoIssued;
	}

	public void setTeoIssued(Character teoIssued) {
		this.teoIssued = teoIssued;
	}

	public BigDecimal getPassedAmount() {
		return passedAmount;
	}

	public void setPassedAmount(BigDecimal passedAmount) {
		this.passedAmount = passedAmount;
	}

	public String getReferenceTable() {
		return referenceTable;
	}

	public void setReferenceTable(String referenceTable) {
		this.referenceTable = referenceTable;
	}

	public Character getCdoIssued() {
		return cdoIssued;
	}

	public void setCdoIssued(Character cdoIssued) {
		this.cdoIssued = cdoIssued;
	}

	public String getCdoNo() {
		return cdoNo;
	}

	public void setCdoNo(String cdoNo) {
		this.cdoNo = cdoNo;
	}

	public Date getCdoDate() {
		return cdoDate;
	}

	public void setCdoDate(Date cdoDate) {
		this.cdoDate = cdoDate;
	}

	public BigDecimal getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public Integer getReceiptAcId() {
		return receiptAcId;
	}

	public void setReceiptAcId(Integer receiptAcId) {
		this.receiptAcId = receiptAcId;
	}

	@XmlTransient
	public Collection<FwaTransaction> getFwaTransactionCollection() {
		return fwaTransactionCollection;
	}

	public void setFwaTransactionCollection(Collection<FwaTransaction> fwaTransactionCollection) {
		this.fwaTransactionCollection = fwaTransactionCollection;
	}

	@XmlTransient
	public Collection<FwaChequedetail> getFwaChequedetailCollection() {
		return fwaChequedetailCollection;
	}

	public void setFwaChequedetailCollection(Collection<FwaChequedetail> fwaChequedetailCollection) {
		this.fwaChequedetailCollection = fwaChequedetailCollection;
	}

	public RmOffice getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(RmOffice rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	@XmlTransient
	public Collection<FwaTeo> getFwaTeoCollection() {
		return fwaTeoCollection;
	}

	public void setFwaTeoCollection(Collection<FwaTeo> fwaTeoCollection) {
		this.fwaTeoCollection = fwaTeoCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (fwaBillmasterid != null ? fwaBillmasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof FwaBillmaster)) {
			return false;
		}
		FwaBillmaster other = (FwaBillmaster) object;
		if ((this.fwaBillmasterid == null && other.fwaBillmasterid != null)
				|| (this.fwaBillmasterid != null && !this.fwaBillmasterid.equals(other.fwaBillmasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.FwaBillmaster[ fwaBillmasterid=" + fwaBillmasterid + " ]";
	}

}
