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
@Table(name = "LFY_FWA_TRANSACTION")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfyFwaTransaction.findAll", query = "SELECT l FROM LfyFwaTransaction l"),
		@NamedQuery(name = "LfyFwaTransaction.findByLfyFwaTransactionid", query = "SELECT l FROM LfyFwaTransaction l WHERE l.lfyFwaTransactionid = :lfyFwaTransactionid"),
		@NamedQuery(name = "LfyFwaTransaction.findByFwaAcCodeMasterid", query = "SELECT l FROM LfyFwaTransaction l WHERE l.fwaAcCodeMasterid = :fwaAcCodeMasterid"),
		@NamedQuery(name = "LfyFwaTransaction.findBySourceTranId", query = "SELECT l FROM LfyFwaTransaction l WHERE l.sourceTranId = :sourceTranId"),
		@NamedQuery(name = "LfyFwaTransaction.findByAmount", query = "SELECT l FROM LfyFwaTransaction l WHERE l.amount = :amount"),
		@NamedQuery(name = "LfyFwaTransaction.findByMasTransactionModeid", query = "SELECT l FROM LfyFwaTransaction l WHERE l.masTransactionModeid = :masTransactionModeid"),
		@NamedQuery(name = "LfyFwaTransaction.findByFwaBankaccountid", query = "SELECT l FROM LfyFwaTransaction l WHERE l.fwaBankaccountid = :fwaBankaccountid"),
		@NamedQuery(name = "LfyFwaTransaction.findByRefLetterno", query = "SELECT l FROM LfyFwaTransaction l WHERE l.refLetterno = :refLetterno"),
		@NamedQuery(name = "LfyFwaTransaction.findByFwaTransactionBookid", query = "SELECT l FROM LfyFwaTransaction l WHERE l.fwaTransactionBookid = :fwaTransactionBookid"),
		@NamedQuery(name = "LfyFwaTransaction.findByRemark", query = "SELECT l FROM LfyFwaTransaction l WHERE l.remark = :remark"),
		@NamedQuery(name = "LfyFwaTransaction.findByTranType", query = "SELECT l FROM LfyFwaTransaction l WHERE l.tranType = :tranType"),
		@NamedQuery(name = "LfyFwaTransaction.findByTransactionDate", query = "SELECT l FROM LfyFwaTransaction l WHERE l.transactionDate = :transactionDate"),
		@NamedQuery(name = "LfyFwaTransaction.findByRmOfficeid", query = "SELECT l FROM LfyFwaTransaction l WHERE l.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "LfyFwaTransaction.findByIslocked", query = "SELECT l FROM LfyFwaTransaction l WHERE l.islocked = :islocked"),
		@NamedQuery(name = "LfyFwaTransaction.findByVoucherno", query = "SELECT l FROM LfyFwaTransaction l WHERE l.voucherno = :voucherno"),
		@NamedQuery(name = "LfyFwaTransaction.findBySysVouchertypeid", query = "SELECT l FROM LfyFwaTransaction l WHERE l.sysVouchertypeid = :sysVouchertypeid"),
		@NamedQuery(name = "LfyFwaTransaction.findByBilldate", query = "SELECT l FROM LfyFwaTransaction l WHERE l.billdate = :billdate"),
		@NamedQuery(name = "LfyFwaTransaction.findByEntrydate", query = "SELECT l FROM LfyFwaTransaction l WHERE l.entrydate = :entrydate"),
		@NamedQuery(name = "LfyFwaTransaction.findByVoucheramount", query = "SELECT l FROM LfyFwaTransaction l WHERE l.voucheramount = :voucheramount"),
		@NamedQuery(name = "LfyFwaTransaction.findByFwaBillmasterid", query = "SELECT l FROM LfyFwaTransaction l WHERE l.fwaBillmasterid = :fwaBillmasterid"),
		@NamedQuery(name = "LfyFwaTransaction.findByAmountAdjusted", query = "SELECT l FROM LfyFwaTransaction l WHERE l.amountAdjusted = :amountAdjusted"),
		@NamedQuery(name = "LfyFwaTransaction.findByAdjustmentDesc", query = "SELECT l FROM LfyFwaTransaction l WHERE l.adjustmentDesc = :adjustmentDesc"),
		@NamedQuery(name = "LfyFwaTransaction.findByIspaymentconfirmed", query = "SELECT l FROM LfyFwaTransaction l WHERE l.ispaymentconfirmed = :ispaymentconfirmed"),
		@NamedQuery(name = "LfyFwaTransaction.findByIsreverseentry", query = "SELECT l FROM LfyFwaTransaction l WHERE l.isreverseentry = :isreverseentry"),
		@NamedQuery(name = "LfyFwaTransaction.findByReferenceGoNo", query = "SELECT l FROM LfyFwaTransaction l WHERE l.referenceGoNo = :referenceGoNo"),
		@NamedQuery(name = "LfyFwaTransaction.findByReferenceGoDate", query = "SELECT l FROM LfyFwaTransaction l WHERE l.referenceGoDate = :referenceGoDate"),
		@NamedQuery(name = "LfyFwaTransaction.findByFwaTransactionid", query = "SELECT l FROM LfyFwaTransaction l WHERE l.fwaTransactionid = :fwaTransactionid"),
		@NamedQuery(name = "LfyFwaTransaction.findByFinancialyear", query = "SELECT l FROM LfyFwaTransaction l WHERE l.financialyear = :financialyear") })
public class LfyFwaTransaction implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_FWA_TRANSACTIONID")
	private Integer lfyFwaTransactionid;
	@Basic(optional = false)
	@Column(name = "FWA_AC_CODE_MASTERID")
	private int fwaAcCodeMasterid;
	@Column(name = "SOURCE_TRAN_ID")
	private Long sourceTranId;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Column(name = "MAS_TRANSACTION_MODEID")
	private Short masTransactionModeid;
	@Column(name = "FWA_BANKACCOUNTID")
	private Integer fwaBankaccountid;
	@Column(name = "REF_LETTERNO")
	private String refLetterno;
	@Basic(optional = false)
	@Column(name = "FWA_TRANSACTION_BOOKID")
	private int fwaTransactionBookid;
	@Column(name = "REMARK")
	private String remark;
	@Basic(optional = false)
	@Column(name = "TRAN_TYPE")
	private String tranType;
	@Basic(optional = false)
	@Column(name = "TRANSACTION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	@Column(name = "RM_OFFICEID")
	private Long rmOfficeid;
	@Basic(optional = false)
	@Column(name = "ISLOCKED")
	private Character islocked;
	@Basic(optional = false)
	@Column(name = "VOUCHERNO")
	private String voucherno;
	@Column(name = "SYS_VOUCHERTYPEID")
	private Long sysVouchertypeid;
	@Column(name = "BILLDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date billdate;
	@Basic(optional = false)
	@Column(name = "ENTRYDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date entrydate;
	@Basic(optional = false)
	@Column(name = "VOUCHERAMOUNT")
	private BigDecimal voucheramount;
	@Column(name = "FWA_BILLMASTERID")
	private Long fwaBillmasterid;
	@Basic(optional = false)
	@Column(name = "AMOUNT_ADJUSTED")
	private BigDecimal amountAdjusted;
	@Column(name = "ADJUSTMENT_DESC")
	private String adjustmentDesc;
	@Column(name = "ISPAYMENTCONFIRMED")
	private Character ispaymentconfirmed;
	@Column(name = "ISREVERSEENTRY")
	private Character isreverseentry;
	@Column(name = "REFERENCE_GO_NO")
	private String referenceGoNo;
	@Column(name = "REFERENCE_GO_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date referenceGoDate;
	@Basic(optional = false)
	@Column(name = "FWA_TRANSACTIONID")
	private long fwaTransactionid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfyFwaTransaction() {
	}

	public LfyFwaTransaction(Integer lfyFwaTransactionid) {
		this.lfyFwaTransactionid = lfyFwaTransactionid;
	}

	public LfyFwaTransaction(Integer lfyFwaTransactionid, int fwaAcCodeMasterid, BigDecimal amount,
			int fwaTransactionBookid, String tranType, Date transactionDate, Character islocked, String voucherno,
			Date entrydate, BigDecimal voucheramount, BigDecimal amountAdjusted, long fwaTransactionid,
			String financialyear) {
		this.lfyFwaTransactionid = lfyFwaTransactionid;
		this.fwaAcCodeMasterid = fwaAcCodeMasterid;
		this.amount = amount;
		this.fwaTransactionBookid = fwaTransactionBookid;
		this.tranType = tranType;
		this.transactionDate = transactionDate;
		this.islocked = islocked;
		this.voucherno = voucherno;
		this.entrydate = entrydate;
		this.voucheramount = voucheramount;
		this.amountAdjusted = amountAdjusted;
		this.fwaTransactionid = fwaTransactionid;
		this.financialyear = financialyear;
	}

	public Integer getLfyFwaTransactionid() {
		return lfyFwaTransactionid;
	}

	public void setLfyFwaTransactionid(Integer lfyFwaTransactionid) {
		this.lfyFwaTransactionid = lfyFwaTransactionid;
	}

	public int getFwaAcCodeMasterid() {
		return fwaAcCodeMasterid;
	}

	public void setFwaAcCodeMasterid(int fwaAcCodeMasterid) {
		this.fwaAcCodeMasterid = fwaAcCodeMasterid;
	}

	public Long getSourceTranId() {
		return sourceTranId;
	}

	public void setSourceTranId(Long sourceTranId) {
		this.sourceTranId = sourceTranId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Short getMasTransactionModeid() {
		return masTransactionModeid;
	}

	public void setMasTransactionModeid(Short masTransactionModeid) {
		this.masTransactionModeid = masTransactionModeid;
	}

	public Integer getFwaBankaccountid() {
		return fwaBankaccountid;
	}

	public void setFwaBankaccountid(Integer fwaBankaccountid) {
		this.fwaBankaccountid = fwaBankaccountid;
	}

	public String getRefLetterno() {
		return refLetterno;
	}

	public void setRefLetterno(String refLetterno) {
		this.refLetterno = refLetterno;
	}

	public int getFwaTransactionBookid() {
		return fwaTransactionBookid;
	}

	public void setFwaTransactionBookid(int fwaTransactionBookid) {
		this.fwaTransactionBookid = fwaTransactionBookid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Long getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Long rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Character getIslocked() {
		return islocked;
	}

	public void setIslocked(Character islocked) {
		this.islocked = islocked;
	}

	public String getVoucherno() {
		return voucherno;
	}

	public void setVoucherno(String voucherno) {
		this.voucherno = voucherno;
	}

	public Long getSysVouchertypeid() {
		return sysVouchertypeid;
	}

	public void setSysVouchertypeid(Long sysVouchertypeid) {
		this.sysVouchertypeid = sysVouchertypeid;
	}

	public Date getBilldate() {
		return billdate;
	}

	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

	public BigDecimal getVoucheramount() {
		return voucheramount;
	}

	public void setVoucheramount(BigDecimal voucheramount) {
		this.voucheramount = voucheramount;
	}

	public Long getFwaBillmasterid() {
		return fwaBillmasterid;
	}

	public void setFwaBillmasterid(Long fwaBillmasterid) {
		this.fwaBillmasterid = fwaBillmasterid;
	}

	public BigDecimal getAmountAdjusted() {
		return amountAdjusted;
	}

	public void setAmountAdjusted(BigDecimal amountAdjusted) {
		this.amountAdjusted = amountAdjusted;
	}

	public String getAdjustmentDesc() {
		return adjustmentDesc;
	}

	public void setAdjustmentDesc(String adjustmentDesc) {
		this.adjustmentDesc = adjustmentDesc;
	}

	public Character getIspaymentconfirmed() {
		return ispaymentconfirmed;
	}

	public void setIspaymentconfirmed(Character ispaymentconfirmed) {
		this.ispaymentconfirmed = ispaymentconfirmed;
	}

	public Character getIsreverseentry() {
		return isreverseentry;
	}

	public void setIsreverseentry(Character isreverseentry) {
		this.isreverseentry = isreverseentry;
	}

	public String getReferenceGoNo() {
		return referenceGoNo;
	}

	public void setReferenceGoNo(String referenceGoNo) {
		this.referenceGoNo = referenceGoNo;
	}

	public Date getReferenceGoDate() {
		return referenceGoDate;
	}

	public void setReferenceGoDate(Date referenceGoDate) {
		this.referenceGoDate = referenceGoDate;
	}

	public long getFwaTransactionid() {
		return fwaTransactionid;
	}

	public void setFwaTransactionid(long fwaTransactionid) {
		this.fwaTransactionid = fwaTransactionid;
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
		hash += (lfyFwaTransactionid != null ? lfyFwaTransactionid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfyFwaTransaction)) {
			return false;
		}
		LfyFwaTransaction other = (LfyFwaTransaction) object;
		if ((this.lfyFwaTransactionid == null && other.lfyFwaTransactionid != null)
				|| (this.lfyFwaTransactionid != null && !this.lfyFwaTransactionid.equals(other.lfyFwaTransactionid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfyFwaTransaction[ lfyFwaTransactionid=" + lfyFwaTransactionid + " ]";
	}

}
