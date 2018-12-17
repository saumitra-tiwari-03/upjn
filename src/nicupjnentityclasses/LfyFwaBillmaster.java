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
@Table(name = "LFY_FWA_BILLMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfyFwaBillmaster.findAll", query = "SELECT l FROM LfyFwaBillmaster l"),
		@NamedQuery(name = "LfyFwaBillmaster.findByLfyFwaBillmasterid", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.lfyFwaBillmasterid = :lfyFwaBillmasterid"),
		@NamedQuery(name = "LfyFwaBillmaster.findByBillno", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.billno = :billno"),
		@NamedQuery(name = "LfyFwaBillmaster.findByBilldate", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.billdate = :billdate"),
		@NamedQuery(name = "LfyFwaBillmaster.findByBillAmount", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.billAmount = :billAmount"),
		@NamedQuery(name = "LfyFwaBillmaster.findByPaidAmount", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.paidAmount = :paidAmount"),
		@NamedQuery(name = "LfyFwaBillmaster.findByRmOfficeid", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "LfyFwaBillmaster.findBySmmSupplierid", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.smmSupplierid = :smmSupplierid"),
		@NamedQuery(name = "LfyFwaBillmaster.findBySysVouchertypeid", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.sysVouchertypeid = :sysVouchertypeid"),
		@NamedQuery(name = "LfyFwaBillmaster.findByIspassed", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.ispassed = :ispassed"),
		@NamedQuery(name = "LfyFwaBillmaster.findByPpEmployeemasterid", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "LfyFwaBillmaster.findByTransactiontype", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.transactiontype = :transactiontype"),
		@NamedQuery(name = "LfyFwaBillmaster.findByUpjnRefNo", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.upjnRefNo = :upjnRefNo"),
		@NamedQuery(name = "LfyFwaBillmaster.findByReferenceTableId", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.referenceTableId = :referenceTableId"),
		@NamedQuery(name = "LfyFwaBillmaster.findByBillFrom", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.billFrom = :billFrom"),
		@NamedQuery(name = "LfyFwaBillmaster.findByDescription", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.description = :description"),
		@NamedQuery(name = "LfyFwaBillmaster.findByIstransfered", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.istransfered = :istransfered"),
		@NamedQuery(name = "LfyFwaBillmaster.findByIsreceipt", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.isreceipt = :isreceipt"),
		@NamedQuery(name = "LfyFwaBillmaster.findByFwaBillmasterid", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.fwaBillmasterid = :fwaBillmasterid"),
		@NamedQuery(name = "LfyFwaBillmaster.findByFinancialyear", query = "SELECT l FROM LfyFwaBillmaster l WHERE l.financialyear = :financialyear") })
public class LfyFwaBillmaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_FWA_BILLMASTERID")
	private Long lfyFwaBillmasterid;
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
	@Basic(optional = false)
	@Column(name = "PAID_AMOUNT")
	private BigDecimal paidAmount;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Column(name = "SMM_SUPPLIERID")
	private Long smmSupplierid;
	@Column(name = "SYS_VOUCHERTYPEID")
	private Long sysVouchertypeid;
	@Column(name = "ISPASSED")
	private Character ispassed;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
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
	@Column(name = "ISTRANSFERED")
	private Character istransfered;
	@Basic(optional = false)
	@Column(name = "ISRECEIPT")
	private Character isreceipt;
	@Basic(optional = false)
	@Column(name = "FWA_BILLMASTERID")
	private long fwaBillmasterid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfyFwaBillmaster() {
	}

	public LfyFwaBillmaster(Long lfyFwaBillmasterid) {
		this.lfyFwaBillmasterid = lfyFwaBillmasterid;
	}

	public LfyFwaBillmaster(Long lfyFwaBillmasterid, String billno, Date billdate, BigDecimal billAmount,
			BigDecimal paidAmount, int rmOfficeid, Character transactiontype, Character istransfered,
			Character isreceipt, long fwaBillmasterid, String financialyear) {
		this.lfyFwaBillmasterid = lfyFwaBillmasterid;
		this.billno = billno;
		this.billdate = billdate;
		this.billAmount = billAmount;
		this.paidAmount = paidAmount;
		this.rmOfficeid = rmOfficeid;
		this.transactiontype = transactiontype;
		this.istransfered = istransfered;
		this.isreceipt = isreceipt;
		this.fwaBillmasterid = fwaBillmasterid;
		this.financialyear = financialyear;
	}

	public Long getLfyFwaBillmasterid() {
		return lfyFwaBillmasterid;
	}

	public void setLfyFwaBillmasterid(Long lfyFwaBillmasterid) {
		this.lfyFwaBillmasterid = lfyFwaBillmasterid;
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

	public BigDecimal getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Long getSmmSupplierid() {
		return smmSupplierid;
	}

	public void setSmmSupplierid(Long smmSupplierid) {
		this.smmSupplierid = smmSupplierid;
	}

	public Long getSysVouchertypeid() {
		return sysVouchertypeid;
	}

	public void setSysVouchertypeid(Long sysVouchertypeid) {
		this.sysVouchertypeid = sysVouchertypeid;
	}

	public Character getIspassed() {
		return ispassed;
	}

	public void setIspassed(Character ispassed) {
		this.ispassed = ispassed;
	}

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
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

	public Character getIstransfered() {
		return istransfered;
	}

	public void setIstransfered(Character istransfered) {
		this.istransfered = istransfered;
	}

	public Character getIsreceipt() {
		return isreceipt;
	}

	public void setIsreceipt(Character isreceipt) {
		this.isreceipt = isreceipt;
	}

	public long getFwaBillmasterid() {
		return fwaBillmasterid;
	}

	public void setFwaBillmasterid(long fwaBillmasterid) {
		this.fwaBillmasterid = fwaBillmasterid;
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
		hash += (lfyFwaBillmasterid != null ? lfyFwaBillmasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfyFwaBillmaster)) {
			return false;
		}
		LfyFwaBillmaster other = (LfyFwaBillmaster) object;
		if ((this.lfyFwaBillmasterid == null && other.lfyFwaBillmasterid != null)
				|| (this.lfyFwaBillmasterid != null && !this.lfyFwaBillmasterid.equals(other.lfyFwaBillmasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfyFwaBillmaster[ lfyFwaBillmasterid=" + lfyFwaBillmasterid + " ]";
	}

}
