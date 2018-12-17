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
@Table(name = "SMM_MATERIALCONSUMPTION")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmMaterialconsumption.findAll", query = "SELECT s FROM SmmMaterialconsumption s"),
		@NamedQuery(name = "SmmMaterialconsumption.findBySmmMaterialconsumptionid", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.smmMaterialconsumptionid = :smmMaterialconsumptionid"),
		@NamedQuery(name = "SmmMaterialconsumption.findByQuantityconsumped", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.quantityconsumped = :quantityconsumped"),
		@NamedQuery(name = "SmmMaterialconsumption.findByMrnDate", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.mrnDate = :mrnDate"),
		@NamedQuery(name = "SmmMaterialconsumption.findByDtrNo", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.dtrNo = :dtrNo"),
		@NamedQuery(name = "SmmMaterialconsumption.findByIstransfered", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.istransfered = :istransfered"),
		@NamedQuery(name = "SmmMaterialconsumption.findByPageNo", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.pageNo = :pageNo"),
		@NamedQuery(name = "SmmMaterialconsumption.findByMbNo", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.mbNo = :mbNo"),
		@NamedQuery(name = "SmmMaterialconsumption.findByJeName", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.jeName = :jeName"),
		@NamedQuery(name = "SmmMaterialconsumption.findByMeasurementDate", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.measurementDate = :measurementDate"),
		@NamedQuery(name = "SmmMaterialconsumption.findByMrnNo", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.mrnNo = :mrnNo"),
		@NamedQuery(name = "SmmMaterialconsumption.findByRemark", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.remark = :remark"),
		@NamedQuery(name = "SmmMaterialconsumption.findByQuantityavailable", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.quantityavailable = :quantityavailable"),
		@NamedQuery(name = "SmmMaterialconsumption.findByIssuevalue", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.issuevalue = :issuevalue"),
		@NamedQuery(name = "SmmMaterialconsumption.findByQuantityRequired", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.quantityRequired = :quantityRequired"),
		@NamedQuery(name = "SmmMaterialconsumption.findBySpComponentmasterid", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.spComponentmasterid = :spComponentmasterid"),
		@NamedQuery(name = "SmmMaterialconsumption.findByCost", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.cost = :cost"),
		@NamedQuery(name = "SmmMaterialconsumption.findByIsVerified", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.isVerified = :isVerified"),
		@NamedQuery(name = "SmmMaterialconsumption.findByRate", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.rate = :rate"),
		@NamedQuery(name = "SmmMaterialconsumption.findByIssuerate", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.issuerate = :issuerate"),
		@NamedQuery(name = "SmmMaterialconsumption.findBySysMrntypeid", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.sysMrntypeid = :sysMrntypeid"),
		@NamedQuery(name = "SmmMaterialconsumption.findByIsTransferEntryDone", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.isTransferEntryDone = :isTransferEntryDone"),
		@NamedQuery(name = "SmmMaterialconsumption.findBySmmContractorid", query = "SELECT s FROM SmmMaterialconsumption s WHERE s.smmContractorid = :smmContractorid") })
public class SmmMaterialconsumption implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_MATERIALCONSUMPTIONID")
	private Long smmMaterialconsumptionid;
	@Basic(optional = false)
	@Column(name = "QUANTITYCONSUMPED")
	private long quantityconsumped;
	@Column(name = "MRN_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mrnDate;
	@Basic(optional = false)
	@Column(name = "DTR_NO")
	private String dtrNo;
	@Basic(optional = false)
	@Column(name = "ISTRANSFERED")
	private Character istransfered;
	@Column(name = "PAGE_NO")
	private String pageNo;
	@Column(name = "MB_NO")
	private String mbNo;
	@Column(name = "JE_NAME")
	private String jeName;
	@Column(name = "MEASUREMENT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date measurementDate;
	@Column(name = "MRN_NO")
	private String mrnNo;
	@Column(name = "REMARK")
	private String remark;
	@Basic(optional = false)
	@Column(name = "QUANTITYAVAILABLE")
	private long quantityavailable;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "ISSUEVALUE")
	private BigDecimal issuevalue;
	@Basic(optional = false)
	@Column(name = "QUANTITY_REQUIRED")
	private long quantityRequired;
	@Column(name = "SP_COMPONENTMASTERID")
	private Long spComponentmasterid;
	@Basic(optional = false)
	@Column(name = "COST")
	private BigDecimal cost;
	@Basic(optional = false)
	@Column(name = "IS_VERIFIED")
	private Character isVerified;
	@Basic(optional = false)
	@Column(name = "RATE")
	private BigDecimal rate;
	@Basic(optional = false)
	@Column(name = "ISSUERATE")
	private BigDecimal issuerate;
	@Column(name = "SYS_MRNTYPEID")
	private Integer sysMrntypeid;
	@Basic(optional = false)
	@Column(name = "IS_TRANSFER_ENTRY_DONE")
	private Character isTransferEntryDone;
	@Column(name = "SMM_CONTRACTORID")
	private Long smmContractorid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "smmMaterialconsumptionid")
	private Collection<SmmOutoffocMrn> smmOutoffocMrnCollection;
	@JoinColumn(name = "SMM_ITEMMASTERID", referencedColumnName = "SMM_ITEMMASTERID")
	@ManyToOne(optional = false)
	private SmmItemmaster smmItemmasterid;
	@JoinColumn(name = "SMM_STOCK_XFER_TRANSACTIONID", referencedColumnName = "SMM_STOCK_XFER_TRANSACTIONID")
	@ManyToOne
	private SmmStockXferTransaction smmStockXferTransactionid;
	@JoinColumn(name = "SP_SCHEMEMASTERID", referencedColumnName = "SP_SCHEMEMASTERID")
	@ManyToOne(optional = false)
	private SpSchememaster spSchememasterid;

	public SmmMaterialconsumption() {
	}

	public SmmMaterialconsumption(Long smmMaterialconsumptionid) {
		this.smmMaterialconsumptionid = smmMaterialconsumptionid;
	}

	public SmmMaterialconsumption(Long smmMaterialconsumptionid, long quantityconsumped, String dtrNo,
			Character istransfered, long quantityavailable, long quantityRequired, BigDecimal cost,
			Character isVerified, BigDecimal rate, BigDecimal issuerate, Character isTransferEntryDone) {
		this.smmMaterialconsumptionid = smmMaterialconsumptionid;
		this.quantityconsumped = quantityconsumped;
		this.dtrNo = dtrNo;
		this.istransfered = istransfered;
		this.quantityavailable = quantityavailable;
		this.quantityRequired = quantityRequired;
		this.cost = cost;
		this.isVerified = isVerified;
		this.rate = rate;
		this.issuerate = issuerate;
		this.isTransferEntryDone = isTransferEntryDone;
	}

	public Long getSmmMaterialconsumptionid() {
		return smmMaterialconsumptionid;
	}

	public void setSmmMaterialconsumptionid(Long smmMaterialconsumptionid) {
		this.smmMaterialconsumptionid = smmMaterialconsumptionid;
	}

	public long getQuantityconsumped() {
		return quantityconsumped;
	}

	public void setQuantityconsumped(long quantityconsumped) {
		this.quantityconsumped = quantityconsumped;
	}

	public Date getMrnDate() {
		return mrnDate;
	}

	public void setMrnDate(Date mrnDate) {
		this.mrnDate = mrnDate;
	}

	public String getDtrNo() {
		return dtrNo;
	}

	public void setDtrNo(String dtrNo) {
		this.dtrNo = dtrNo;
	}

	public Character getIstransfered() {
		return istransfered;
	}

	public void setIstransfered(Character istransfered) {
		this.istransfered = istransfered;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getMbNo() {
		return mbNo;
	}

	public void setMbNo(String mbNo) {
		this.mbNo = mbNo;
	}

	public String getJeName() {
		return jeName;
	}

	public void setJeName(String jeName) {
		this.jeName = jeName;
	}

	public Date getMeasurementDate() {
		return measurementDate;
	}

	public void setMeasurementDate(Date measurementDate) {
		this.measurementDate = measurementDate;
	}

	public String getMrnNo() {
		return mrnNo;
	}

	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getQuantityavailable() {
		return quantityavailable;
	}

	public void setQuantityavailable(long quantityavailable) {
		this.quantityavailable = quantityavailable;
	}

	public BigDecimal getIssuevalue() {
		return issuevalue;
	}

	public void setIssuevalue(BigDecimal issuevalue) {
		this.issuevalue = issuevalue;
	}

	public long getQuantityRequired() {
		return quantityRequired;
	}

	public void setQuantityRequired(long quantityRequired) {
		this.quantityRequired = quantityRequired;
	}

	public Long getSpComponentmasterid() {
		return spComponentmasterid;
	}

	public void setSpComponentmasterid(Long spComponentmasterid) {
		this.spComponentmasterid = spComponentmasterid;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Character getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Character isVerified) {
		this.isVerified = isVerified;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getIssuerate() {
		return issuerate;
	}

	public void setIssuerate(BigDecimal issuerate) {
		this.issuerate = issuerate;
	}

	public Integer getSysMrntypeid() {
		return sysMrntypeid;
	}

	public void setSysMrntypeid(Integer sysMrntypeid) {
		this.sysMrntypeid = sysMrntypeid;
	}

	public Character getIsTransferEntryDone() {
		return isTransferEntryDone;
	}

	public void setIsTransferEntryDone(Character isTransferEntryDone) {
		this.isTransferEntryDone = isTransferEntryDone;
	}

	public Long getSmmContractorid() {
		return smmContractorid;
	}

	public void setSmmContractorid(Long smmContractorid) {
		this.smmContractorid = smmContractorid;
	}

	@XmlTransient
	public Collection<SmmOutoffocMrn> getSmmOutoffocMrnCollection() {
		return smmOutoffocMrnCollection;
	}

	public void setSmmOutoffocMrnCollection(Collection<SmmOutoffocMrn> smmOutoffocMrnCollection) {
		this.smmOutoffocMrnCollection = smmOutoffocMrnCollection;
	}

	public SmmItemmaster getSmmItemmasterid() {
		return smmItemmasterid;
	}

	public void setSmmItemmasterid(SmmItemmaster smmItemmasterid) {
		this.smmItemmasterid = smmItemmasterid;
	}

	public SmmStockXferTransaction getSmmStockXferTransactionid() {
		return smmStockXferTransactionid;
	}

	public void setSmmStockXferTransactionid(SmmStockXferTransaction smmStockXferTransactionid) {
		this.smmStockXferTransactionid = smmStockXferTransactionid;
	}

	public SpSchememaster getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(SpSchememaster spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmMaterialconsumptionid != null ? smmMaterialconsumptionid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmMaterialconsumption)) {
			return false;
		}
		SmmMaterialconsumption other = (SmmMaterialconsumption) object;
		if ((this.smmMaterialconsumptionid == null && other.smmMaterialconsumptionid != null)
				|| (this.smmMaterialconsumptionid != null
						&& !this.smmMaterialconsumptionid.equals(other.smmMaterialconsumptionid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmMaterialconsumption[ smmMaterialconsumptionid=" + smmMaterialconsumptionid
				+ " ]";
	}

}
