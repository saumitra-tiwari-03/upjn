/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "SMM_STOCK_XFER_INFO")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmStockXferInfo.findAll", query = "SELECT s FROM SmmStockXferInfo s"),
		@NamedQuery(name = "SmmStockXferInfo.findBySmmStockXferInfoid", query = "SELECT s FROM SmmStockXferInfo s WHERE s.smmStockXferInfoid = :smmStockXferInfoid"),
		@NamedQuery(name = "SmmStockXferInfo.findBySpSchememasterid", query = "SELECT s FROM SmmStockXferInfo s WHERE s.spSchememasterid = :spSchememasterid"),
		@NamedQuery(name = "SmmStockXferInfo.findByRmOfficeid", query = "SELECT s FROM SmmStockXferInfo s WHERE s.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "SmmStockXferInfo.findBySchemeidTransferring", query = "SELECT s FROM SmmStockXferInfo s WHERE s.schemeidTransferring = :schemeidTransferring"),
		@NamedQuery(name = "SmmStockXferInfo.findByRmOfficeidTransferring", query = "SELECT s FROM SmmStockXferInfo s WHERE s.rmOfficeidTransferring = :rmOfficeidTransferring"),
		@NamedQuery(name = "SmmStockXferInfo.findByIsapproved", query = "SELECT s FROM SmmStockXferInfo s WHERE s.isapproved = :isapproved"),
		@NamedQuery(name = "SmmStockXferInfo.findByReferenceletterno", query = "SELECT s FROM SmmStockXferInfo s WHERE s.referenceletterno = :referenceletterno"),
		@NamedQuery(name = "SmmStockXferInfo.findByReferencedate", query = "SELECT s FROM SmmStockXferInfo s WHERE s.referencedate = :referencedate"),
		@NamedQuery(name = "SmmStockXferInfo.findByIndenttype", query = "SELECT s FROM SmmStockXferInfo s WHERE s.indenttype = :indenttype"),
		@NamedQuery(name = "SmmStockXferInfo.findByIsgrnIssued", query = "SELECT s FROM SmmStockXferInfo s WHERE s.isgrnIssued = :isgrnIssued"),
		@NamedQuery(name = "SmmStockXferInfo.findByMtnNo", query = "SELECT s FROM SmmStockXferInfo s WHERE s.mtnNo = :mtnNo"),
		@NamedQuery(name = "SmmStockXferInfo.findByMtnDate", query = "SELECT s FROM SmmStockXferInfo s WHERE s.mtnDate = :mtnDate"),
		@NamedQuery(name = "SmmStockXferInfo.findByGrnNo", query = "SELECT s FROM SmmStockXferInfo s WHERE s.grnNo = :grnNo"),
		@NamedQuery(name = "SmmStockXferInfo.findByGrnDate", query = "SELECT s FROM SmmStockXferInfo s WHERE s.grnDate = :grnDate"),
		@NamedQuery(name = "SmmStockXferInfo.findByIsVerifiedbyFinance", query = "SELECT s FROM SmmStockXferInfo s WHERE s.isVerifiedbyFinance = :isVerifiedbyFinance") })
public class SmmStockXferInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_STOCK_XFER_INFOID")
	private Long smmStockXferInfoid;
	@Column(name = "SP_SCHEMEMASTERID")
	private Long spSchememasterid;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
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
	private Character isVerifiedbyFinance;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "smmStockXferInfoid")
	private Collection<SmmStockTranReq> smmStockTranReqCollection;

	public SmmStockXferInfo() {
	}

	public SmmStockXferInfo(Long smmStockXferInfoid) {
		this.smmStockXferInfoid = smmStockXferInfoid;
	}

	public SmmStockXferInfo(Long smmStockXferInfoid, Character isapproved, String indenttype, Character isgrnIssued,
			Character isVerifiedbyFinance) {
		this.smmStockXferInfoid = smmStockXferInfoid;
		this.isapproved = isapproved;
		this.indenttype = indenttype;
		this.isgrnIssued = isgrnIssued;
		this.isVerifiedbyFinance = isVerifiedbyFinance;
	}

	public Long getSmmStockXferInfoid() {
		return smmStockXferInfoid;
	}

	public void setSmmStockXferInfoid(Long smmStockXferInfoid) {
		this.smmStockXferInfoid = smmStockXferInfoid;
	}

	public Long getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(Long spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
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

	public Character getIsVerifiedbyFinance() {
		return isVerifiedbyFinance;
	}

	public void setIsVerifiedbyFinance(Character isVerifiedbyFinance) {
		this.isVerifiedbyFinance = isVerifiedbyFinance;
	}

	@XmlTransient
	public Collection<SmmStockTranReq> getSmmStockTranReqCollection() {
		return smmStockTranReqCollection;
	}

	public void setSmmStockTranReqCollection(Collection<SmmStockTranReq> smmStockTranReqCollection) {
		this.smmStockTranReqCollection = smmStockTranReqCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmStockXferInfoid != null ? smmStockXferInfoid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmStockXferInfo)) {
			return false;
		}
		SmmStockXferInfo other = (SmmStockXferInfo) object;
		if ((this.smmStockXferInfoid == null && other.smmStockXferInfoid != null)
				|| (this.smmStockXferInfoid != null && !this.smmStockXferInfoid.equals(other.smmStockXferInfoid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmStockXferInfo[ smmStockXferInfoid=" + smmStockXferInfoid + " ]";
	}

}
