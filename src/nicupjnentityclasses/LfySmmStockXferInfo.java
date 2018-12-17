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
@Table(name = "LFY_SMM_STOCK_XFER_INFO")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfySmmStockXferInfo.findAll", query = "SELECT l FROM LfySmmStockXferInfo l"),
		@NamedQuery(name = "LfySmmStockXferInfo.findByLfySmmStockXferInfoid", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.lfySmmStockXferInfoid = :lfySmmStockXferInfoid"),
		@NamedQuery(name = "LfySmmStockXferInfo.findBySpSchememasterid", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.spSchememasterid = :spSchememasterid"),
		@NamedQuery(name = "LfySmmStockXferInfo.findByRmOfficeid", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "LfySmmStockXferInfo.findBySchemeidTransferring", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.schemeidTransferring = :schemeidTransferring"),
		@NamedQuery(name = "LfySmmStockXferInfo.findByRmOfficeidTransferring", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.rmOfficeidTransferring = :rmOfficeidTransferring"),
		@NamedQuery(name = "LfySmmStockXferInfo.findByIsapproved", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.isapproved = :isapproved"),
		@NamedQuery(name = "LfySmmStockXferInfo.findByReferenceletterno", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.referenceletterno = :referenceletterno"),
		@NamedQuery(name = "LfySmmStockXferInfo.findByReferencedate", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.referencedate = :referencedate"),
		@NamedQuery(name = "LfySmmStockXferInfo.findByIndenttype", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.indenttype = :indenttype"),
		@NamedQuery(name = "LfySmmStockXferInfo.findByIsgrnIssued", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.isgrnIssued = :isgrnIssued"),
		@NamedQuery(name = "LfySmmStockXferInfo.findByMtnNo", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.mtnNo = :mtnNo"),
		@NamedQuery(name = "LfySmmStockXferInfo.findByMtnDate", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.mtnDate = :mtnDate"),
		@NamedQuery(name = "LfySmmStockXferInfo.findByGrnNo", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.grnNo = :grnNo"),
		@NamedQuery(name = "LfySmmStockXferInfo.findByGrnDate", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.grnDate = :grnDate"),
		@NamedQuery(name = "LfySmmStockXferInfo.findByIsVerifiedbyFinance", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.isVerifiedbyFinance = :isVerifiedbyFinance"),
		@NamedQuery(name = "LfySmmStockXferInfo.findBySmmStockXferInfoid", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.smmStockXferInfoid = :smmStockXferInfoid"),
		@NamedQuery(name = "LfySmmStockXferInfo.findByFinancialyear", query = "SELECT l FROM LfySmmStockXferInfo l WHERE l.financialyear = :financialyear") })
public class LfySmmStockXferInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_SMM_STOCK_XFER_INFOID")
	private Long lfySmmStockXferInfoid;
	@Column(name = "SP_SCHEMEMASTERID")
	private Long spSchememasterid;
	@Column(name = "RM_OFFICEID")
	private Long rmOfficeid;
	@Column(name = "SCHEMEID_TRANSFERRING")
	private Long schemeidTransferring;
	@Column(name = "RM_OFFICEID_TRANSFERRING")
	private Long rmOfficeidTransferring;
	@Basic(optional = false)
	@Column(name = "ISAPPROVED")
	private Character isapproved;
	@Column(name = "REFERENCELETTERNO")
	private String referenceletterno;
	@Column(name = "REFERENCEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date referencedate;
	@Basic(optional = false)
	@Column(name = "INDENTTYPE")
	private String indenttype;
	@Basic(optional = false)
	@Column(name = "ISGRN_ISSUED")
	private Character isgrnIssued;
	@Column(name = "MTN_NO")
	private String mtnNo;
	@Column(name = "MTN_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mtnDate;
	@Column(name = "GRN_NO")
	private String grnNo;
	@Column(name = "GRN_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date grnDate;
	@Basic(optional = false)
	@Column(name = "IS_VERIFIEDBY_FINANCE")
	private String isVerifiedbyFinance;
	@Basic(optional = false)
	@Column(name = "SMM_STOCK_XFER_INFOID")
	private long smmStockXferInfoid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfySmmStockXferInfo() {
	}

	public LfySmmStockXferInfo(Long lfySmmStockXferInfoid) {
		this.lfySmmStockXferInfoid = lfySmmStockXferInfoid;
	}

	public LfySmmStockXferInfo(Long lfySmmStockXferInfoid, Character isapproved, String indenttype,
			Character isgrnIssued, String isVerifiedbyFinance, long smmStockXferInfoid, String financialyear) {
		this.lfySmmStockXferInfoid = lfySmmStockXferInfoid;
		this.isapproved = isapproved;
		this.indenttype = indenttype;
		this.isgrnIssued = isgrnIssued;
		this.isVerifiedbyFinance = isVerifiedbyFinance;
		this.smmStockXferInfoid = smmStockXferInfoid;
		this.financialyear = financialyear;
	}

	public Long getLfySmmStockXferInfoid() {
		return lfySmmStockXferInfoid;
	}

	public void setLfySmmStockXferInfoid(Long lfySmmStockXferInfoid) {
		this.lfySmmStockXferInfoid = lfySmmStockXferInfoid;
	}

	public Long getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(Long spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public Long getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Long rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Long getSchemeidTransferring() {
		return schemeidTransferring;
	}

	public void setSchemeidTransferring(Long schemeidTransferring) {
		this.schemeidTransferring = schemeidTransferring;
	}

	public Long getRmOfficeidTransferring() {
		return rmOfficeidTransferring;
	}

	public void setRmOfficeidTransferring(Long rmOfficeidTransferring) {
		this.rmOfficeidTransferring = rmOfficeidTransferring;
	}

	public Character getIsapproved() {
		return isapproved;
	}

	public void setIsapproved(Character isapproved) {
		this.isapproved = isapproved;
	}

	public String getReferenceletterno() {
		return referenceletterno;
	}

	public void setReferenceletterno(String referenceletterno) {
		this.referenceletterno = referenceletterno;
	}

	public Date getReferencedate() {
		return referencedate;
	}

	public void setReferencedate(Date referencedate) {
		this.referencedate = referencedate;
	}

	public String getIndenttype() {
		return indenttype;
	}

	public void setIndenttype(String indenttype) {
		this.indenttype = indenttype;
	}

	public Character getIsgrnIssued() {
		return isgrnIssued;
	}

	public void setIsgrnIssued(Character isgrnIssued) {
		this.isgrnIssued = isgrnIssued;
	}

	public String getMtnNo() {
		return mtnNo;
	}

	public void setMtnNo(String mtnNo) {
		this.mtnNo = mtnNo;
	}

	public Date getMtnDate() {
		return mtnDate;
	}

	public void setMtnDate(Date mtnDate) {
		this.mtnDate = mtnDate;
	}

	public String getGrnNo() {
		return grnNo;
	}

	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}

	public Date getGrnDate() {
		return grnDate;
	}

	public void setGrnDate(Date grnDate) {
		this.grnDate = grnDate;
	}

	public String getIsVerifiedbyFinance() {
		return isVerifiedbyFinance;
	}

	public void setIsVerifiedbyFinance(String isVerifiedbyFinance) {
		this.isVerifiedbyFinance = isVerifiedbyFinance;
	}

	public long getSmmStockXferInfoid() {
		return smmStockXferInfoid;
	}

	public void setSmmStockXferInfoid(long smmStockXferInfoid) {
		this.smmStockXferInfoid = smmStockXferInfoid;
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
		hash += (lfySmmStockXferInfoid != null ? lfySmmStockXferInfoid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfySmmStockXferInfo)) {
			return false;
		}
		LfySmmStockXferInfo other = (LfySmmStockXferInfo) object;
		if ((this.lfySmmStockXferInfoid == null && other.lfySmmStockXferInfoid != null)
				|| (this.lfySmmStockXferInfoid != null
						&& !this.lfySmmStockXferInfoid.equals(other.lfySmmStockXferInfoid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfySmmStockXferInfo[ lfySmmStockXferInfoid=" + lfySmmStockXferInfoid + " ]";
	}

}
