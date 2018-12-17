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
@Table(name = "SMM_TRAN_STOCK")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmTranStock.findAll", query = "SELECT s FROM SmmTranStock s"),
		@NamedQuery(name = "SmmTranStock.findBySmmTranStockid", query = "SELECT s FROM SmmTranStock s WHERE s.smmTranStockid = :smmTranStockid"),
		@NamedQuery(name = "SmmTranStock.findBySmmItemmasterid", query = "SELECT s FROM SmmTranStock s WHERE s.smmItemmasterid = :smmItemmasterid"),
		@NamedQuery(name = "SmmTranStock.findByReferencedate", query = "SELECT s FROM SmmTranStock s WHERE s.referencedate = :referencedate"),
		@NamedQuery(name = "SmmTranStock.findByReferenceletterno", query = "SELECT s FROM SmmTranStock s WHERE s.referenceletterno = :referenceletterno"),
		@NamedQuery(name = "SmmTranStock.findByQuantity", query = "SELECT s FROM SmmTranStock s WHERE s.quantity = :quantity"),
		@NamedQuery(name = "SmmTranStock.findByRate", query = "SELECT s FROM SmmTranStock s WHERE s.rate = :rate"),
		@NamedQuery(name = "SmmTranStock.findByCost", query = "SELECT s FROM SmmTranStock s WHERE s.cost = :cost"),
		@NamedQuery(name = "SmmTranStock.findBySpSchememasterid", query = "SELECT s FROM SmmTranStock s WHERE s.spSchememasterid = :spSchememasterid"),
		@NamedQuery(name = "SmmTranStock.findByRmOfficeid", query = "SELECT s FROM SmmTranStock s WHERE s.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "SmmTranStock.findBySpSchememasteridsource", query = "SELECT s FROM SmmTranStock s WHERE s.spSchememasteridsource = :spSchememasteridsource"),
		@NamedQuery(name = "SmmTranStock.findByRmOfficeidsource", query = "SELECT s FROM SmmTranStock s WHERE s.rmOfficeidsource = :rmOfficeidsource") })
public class SmmTranStock implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_TRAN_STOCKID")
	private Long smmTranStockid;
	@Column(name = "SMM_ITEMMASTERID")
	private Long smmItemmasterid;
	@Basic(optional = false)
	@Column(name = "REFERENCEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date referencedate;
	@Basic(optional = false)
	@Column(name = "REFERENCELETTERNO")
	private String referenceletterno;
	@Basic(optional = false)
	@Column(name = "QUANTITY")
	private long quantity;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "RATE")
	private BigDecimal rate;
	@Basic(optional = false)
	@Column(name = "COST")
	private BigDecimal cost;
	@Basic(optional = false)
	@Column(name = "SP_SCHEMEMASTERID")
	private long spSchememasterid;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Column(name = "SP_SCHEMEMASTERIDSOURCE")
	private Long spSchememasteridsource;
	@Column(name = "RM_OFFICEIDSOURCE")
	private Integer rmOfficeidsource;

	public SmmTranStock() {
	}

	public SmmTranStock(Long smmTranStockid) {
		this.smmTranStockid = smmTranStockid;
	}

	public SmmTranStock(Long smmTranStockid, Date referencedate, String referenceletterno, long quantity,
			BigDecimal rate, BigDecimal cost, long spSchememasterid) {
		this.smmTranStockid = smmTranStockid;
		this.referencedate = referencedate;
		this.referenceletterno = referenceletterno;
		this.quantity = quantity;
		this.rate = rate;
		this.cost = cost;
		this.spSchememasterid = spSchememasterid;
	}

	public Long getSmmTranStockid() {
		return smmTranStockid;
	}

	public void setSmmTranStockid(Long smmTranStockid) {
		this.smmTranStockid = smmTranStockid;
	}

	public Long getSmmItemmasterid() {
		return smmItemmasterid;
	}

	public void setSmmItemmasterid(Long smmItemmasterid) {
		this.smmItemmasterid = smmItemmasterid;
	}

	public Date getReferencedate() {
		return referencedate;
	}

	public void setReferencedate(Date referencedate) {
		this.referencedate = referencedate;
	}

	public String getReferenceletterno() {
		return referenceletterno;
	}

	public void setReferenceletterno(String referenceletterno) {
		this.referenceletterno = referenceletterno;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public long getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(long spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Long getSpSchememasteridsource() {
		return spSchememasteridsource;
	}

	public void setSpSchememasteridsource(Long spSchememasteridsource) {
		this.spSchememasteridsource = spSchememasteridsource;
	}

	public Integer getRmOfficeidsource() {
		return rmOfficeidsource;
	}

	public void setRmOfficeidsource(Integer rmOfficeidsource) {
		this.rmOfficeidsource = rmOfficeidsource;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmTranStockid != null ? smmTranStockid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmTranStock)) {
			return false;
		}
		SmmTranStock other = (SmmTranStock) object;
		if ((this.smmTranStockid == null && other.smmTranStockid != null)
				|| (this.smmTranStockid != null && !this.smmTranStockid.equals(other.smmTranStockid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmTranStock[ smmTranStockid=" + smmTranStockid + " ]";
	}

}
