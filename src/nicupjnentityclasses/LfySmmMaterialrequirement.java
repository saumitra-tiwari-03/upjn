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
@Table(name = "LFY_SMM_MATERIALREQUIREMENT")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "LfySmmMaterialrequirement.findAll", query = "SELECT l FROM LfySmmMaterialrequirement l"),
		@NamedQuery(name = "LfySmmMaterialrequirement.findByLfySmmMaterialrequirementid", query = "SELECT l FROM LfySmmMaterialrequirement l WHERE l.lfySmmMaterialrequirementid = :lfySmmMaterialrequirementid"),
		@NamedQuery(name = "LfySmmMaterialrequirement.findBySpSchememasterid", query = "SELECT l FROM LfySmmMaterialrequirement l WHERE l.spSchememasterid = :spSchememasterid"),
		@NamedQuery(name = "LfySmmMaterialrequirement.findBySmmItemmasterid", query = "SELECT l FROM LfySmmMaterialrequirement l WHERE l.smmItemmasterid = :smmItemmasterid"),
		@NamedQuery(name = "LfySmmMaterialrequirement.findByQuarter", query = "SELECT l FROM LfySmmMaterialrequirement l WHERE l.quarter = :quarter"),
		@NamedQuery(name = "LfySmmMaterialrequirement.findByQuantity", query = "SELECT l FROM LfySmmMaterialrequirement l WHERE l.quantity = :quantity"),
		@NamedQuery(name = "LfySmmMaterialrequirement.findByFinancialyear", query = "SELECT l FROM LfySmmMaterialrequirement l WHERE l.financialyear = :financialyear"),
		@NamedQuery(name = "LfySmmMaterialrequirement.findByRmOfficeid", query = "SELECT l FROM LfySmmMaterialrequirement l WHERE l.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "LfySmmMaterialrequirement.findByEntrydate", query = "SELECT l FROM LfySmmMaterialrequirement l WHERE l.entrydate = :entrydate"),
		@NamedQuery(name = "LfySmmMaterialrequirement.findByRemark", query = "SELECT l FROM LfySmmMaterialrequirement l WHERE l.remark = :remark"),
		@NamedQuery(name = "LfySmmMaterialrequirement.findByIscentralized", query = "SELECT l FROM LfySmmMaterialrequirement l WHERE l.iscentralized = :iscentralized"),
		@NamedQuery(name = "LfySmmMaterialrequirement.findByStockBegCfy", query = "SELECT l FROM LfySmmMaterialrequirement l WHERE l.stockBegCfy = :stockBegCfy"),
		@NamedQuery(name = "LfySmmMaterialrequirement.findByBalSuppAgainstOrders", query = "SELECT l FROM LfySmmMaterialrequirement l WHERE l.balSuppAgainstOrders = :balSuppAgainstOrders"),
		@NamedQuery(name = "LfySmmMaterialrequirement.findByMatwiseOutstPayments", query = "SELECT l FROM LfySmmMaterialrequirement l WHERE l.matwiseOutstPayments = :matwiseOutstPayments"),
		@NamedQuery(name = "LfySmmMaterialrequirement.findBySmmMaterialrequirementid", query = "SELECT l FROM LfySmmMaterialrequirement l WHERE l.smmMaterialrequirementid = :smmMaterialrequirementid") })
public class LfySmmMaterialrequirement implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_SMM_MATERIALREQUIREMENTID")
	private Long lfySmmMaterialrequirementid;
	@Basic(optional = false)
	@Column(name = "SP_SCHEMEMASTERID")
	private long spSchememasterid;
	@Basic(optional = false)
	@Column(name = "SMM_ITEMMASTERID")
	private long smmItemmasterid;
	@Column(name = "QUARTER")
	private Short quarter;
	@Basic(optional = false)
	@Column(name = "QUANTITY")
	private long quantity;
	@Column(name = "FINANCIALYEAR")
	private String financialyear;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private long rmOfficeid;
	@Basic(optional = false)
	@Column(name = "ENTRYDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date entrydate;
	@Column(name = "REMARK")
	private String remark;
	@Basic(optional = false)
	@Column(name = "ISCENTRALIZED")
	private Character iscentralized;
	@Column(name = "STOCK_BEG_CFY")
	private Long stockBegCfy;
	@Column(name = "BAL_SUPP_AGAINST_ORDERS")
	private Long balSuppAgainstOrders;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "MATWISE_OUTST_PAYMENTS")
	private BigDecimal matwiseOutstPayments;
	@Basic(optional = false)
	@Column(name = "SMM_MATERIALREQUIREMENTID")
	private long smmMaterialrequirementid;

	public LfySmmMaterialrequirement() {
	}

	public LfySmmMaterialrequirement(Long lfySmmMaterialrequirementid) {
		this.lfySmmMaterialrequirementid = lfySmmMaterialrequirementid;
	}

	public LfySmmMaterialrequirement(Long lfySmmMaterialrequirementid, long spSchememasterid, long smmItemmasterid,
			long quantity, long rmOfficeid, Date entrydate, Character iscentralized, long smmMaterialrequirementid) {
		this.lfySmmMaterialrequirementid = lfySmmMaterialrequirementid;
		this.spSchememasterid = spSchememasterid;
		this.smmItemmasterid = smmItemmasterid;
		this.quantity = quantity;
		this.rmOfficeid = rmOfficeid;
		this.entrydate = entrydate;
		this.iscentralized = iscentralized;
		this.smmMaterialrequirementid = smmMaterialrequirementid;
	}

	public Long getLfySmmMaterialrequirementid() {
		return lfySmmMaterialrequirementid;
	}

	public void setLfySmmMaterialrequirementid(Long lfySmmMaterialrequirementid) {
		this.lfySmmMaterialrequirementid = lfySmmMaterialrequirementid;
	}

	public long getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(long spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public long getSmmItemmasterid() {
		return smmItemmasterid;
	}

	public void setSmmItemmasterid(long smmItemmasterid) {
		this.smmItemmasterid = smmItemmasterid;
	}

	public Short getQuarter() {
		return quarter;
	}

	public void setQuarter(Short quarter) {
		this.quarter = quarter;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getFinancialyear() {
		return financialyear;
	}

	public void setFinancialyear(String financialyear) {
		this.financialyear = financialyear;
	}

	public long getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(long rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Character getIscentralized() {
		return iscentralized;
	}

	public void setIscentralized(Character iscentralized) {
		this.iscentralized = iscentralized;
	}

	public Long getStockBegCfy() {
		return stockBegCfy;
	}

	public void setStockBegCfy(Long stockBegCfy) {
		this.stockBegCfy = stockBegCfy;
	}

	public Long getBalSuppAgainstOrders() {
		return balSuppAgainstOrders;
	}

	public void setBalSuppAgainstOrders(Long balSuppAgainstOrders) {
		this.balSuppAgainstOrders = balSuppAgainstOrders;
	}

	public BigDecimal getMatwiseOutstPayments() {
		return matwiseOutstPayments;
	}

	public void setMatwiseOutstPayments(BigDecimal matwiseOutstPayments) {
		this.matwiseOutstPayments = matwiseOutstPayments;
	}

	public long getSmmMaterialrequirementid() {
		return smmMaterialrequirementid;
	}

	public void setSmmMaterialrequirementid(long smmMaterialrequirementid) {
		this.smmMaterialrequirementid = smmMaterialrequirementid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (lfySmmMaterialrequirementid != null ? lfySmmMaterialrequirementid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfySmmMaterialrequirement)) {
			return false;
		}
		LfySmmMaterialrequirement other = (LfySmmMaterialrequirement) object;
		if ((this.lfySmmMaterialrequirementid == null && other.lfySmmMaterialrequirementid != null)
				|| (this.lfySmmMaterialrequirementid != null
						&& !this.lfySmmMaterialrequirementid.equals(other.lfySmmMaterialrequirementid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfySmmMaterialrequirement[ lfySmmMaterialrequirementid="
				+ lfySmmMaterialrequirementid + " ]";
	}

}
