/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "SMM_STOCKMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmStockmaster.findAll", query = "SELECT s FROM SmmStockmaster s"),
		@NamedQuery(name = "SmmStockmaster.findBySmmStockmasterid", query = "SELECT s FROM SmmStockmaster s WHERE s.smmStockmasterid = :smmStockmasterid"),
		@NamedQuery(name = "SmmStockmaster.findByQuantity", query = "SELECT s FROM SmmStockmaster s WHERE s.quantity = :quantity"),
		@NamedQuery(name = "SmmStockmaster.findByCost", query = "SELECT s FROM SmmStockmaster s WHERE s.cost = :cost"),
		@NamedQuery(name = "SmmStockmaster.findByRmOfficeid", query = "SELECT s FROM SmmStockmaster s WHERE s.rmOfficeid = :rmOfficeid") })
public class SmmStockmaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_STOCKMASTERID")
	private Long smmStockmasterid;
	@Basic(optional = false)
	@Column(name = "QUANTITY")
	private long quantity;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "COST")
	private BigDecimal cost;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@JoinColumn(name = "SMM_ITEMMASTERID", referencedColumnName = "SMM_ITEMMASTERID")
	@ManyToOne(optional = false)
	private SmmItemmaster smmItemmasterid;
	@JoinColumn(name = "SP_SCHEMEMASTERID", referencedColumnName = "SP_SCHEMEMASTERID")
	@ManyToOne
	private SpSchememaster spSchememasterid;

	public SmmStockmaster() {
	}

	public SmmStockmaster(Long smmStockmasterid) {
		this.smmStockmasterid = smmStockmasterid;
	}

	public SmmStockmaster(Long smmStockmasterid, long quantity, BigDecimal cost, int rmOfficeid) {
		this.smmStockmasterid = smmStockmasterid;
		this.quantity = quantity;
		this.cost = cost;
		this.rmOfficeid = rmOfficeid;
	}

	public Long getSmmStockmasterid() {
		return smmStockmasterid;
	}

	public void setSmmStockmasterid(Long smmStockmasterid) {
		this.smmStockmasterid = smmStockmasterid;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public SmmItemmaster getSmmItemmasterid() {
		return smmItemmasterid;
	}

	public void setSmmItemmasterid(SmmItemmaster smmItemmasterid) {
		this.smmItemmasterid = smmItemmasterid;
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
		hash += (smmStockmasterid != null ? smmStockmasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmStockmaster)) {
			return false;
		}
		SmmStockmaster other = (SmmStockmaster) object;
		if ((this.smmStockmasterid == null && other.smmStockmasterid != null)
				|| (this.smmStockmasterid != null && !this.smmStockmasterid.equals(other.smmStockmasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmStockmaster[ smmStockmasterid=" + smmStockmasterid + " ]";
	}

}
