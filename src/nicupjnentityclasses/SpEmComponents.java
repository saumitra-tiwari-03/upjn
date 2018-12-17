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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SP_EM_COMPONENTS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SpEmComponents.findAll", query = "SELECT s FROM SpEmComponents s"),
		@NamedQuery(name = "SpEmComponents.findBySpEmComponentsid", query = "SELECT s FROM SpEmComponents s WHERE s.spEmComponentsid = :spEmComponentsid"),
		@NamedQuery(name = "SpEmComponents.findByItemDescription", query = "SELECT s FROM SpEmComponents s WHERE s.itemDescription = :itemDescription"),
		@NamedQuery(name = "SpEmComponents.findByQuantityDesc", query = "SELECT s FROM SpEmComponents s WHERE s.quantityDesc = :quantityDesc"),
		@NamedQuery(name = "SpEmComponents.findByPhyTotalTarget", query = "SELECT s FROM SpEmComponents s WHERE s.phyTotalTarget = :phyTotalTarget"),
		@NamedQuery(name = "SpEmComponents.findByPhyAchTillLfy", query = "SELECT s FROM SpEmComponents s WHERE s.phyAchTillLfy = :phyAchTillLfy"),
		@NamedQuery(name = "SpEmComponents.findByPhyTargetThisFy", query = "SELECT s FROM SpEmComponents s WHERE s.phyTargetThisFy = :phyTargetThisFy"),
		@NamedQuery(name = "SpEmComponents.findByPhyAchThisFy", query = "SELECT s FROM SpEmComponents s WHERE s.phyAchThisFy = :phyAchThisFy"),
		@NamedQuery(name = "SpEmComponents.findByFinTotalTarget", query = "SELECT s FROM SpEmComponents s WHERE s.finTotalTarget = :finTotalTarget"),
		@NamedQuery(name = "SpEmComponents.findByFinAchTillLfy", query = "SELECT s FROM SpEmComponents s WHERE s.finAchTillLfy = :finAchTillLfy"),
		@NamedQuery(name = "SpEmComponents.findByFinTargetThisFy", query = "SELECT s FROM SpEmComponents s WHERE s.finTargetThisFy = :finTargetThisFy"),
		@NamedQuery(name = "SpEmComponents.findByFinAchThisFy", query = "SELECT s FROM SpEmComponents s WHERE s.finAchThisFy = :finAchThisFy"),
		@NamedQuery(name = "SpEmComponents.findByLastFy", query = "SELECT s FROM SpEmComponents s WHERE s.lastFy = :lastFy"),
		@NamedQuery(name = "SpEmComponents.findByThisFy", query = "SELECT s FROM SpEmComponents s WHERE s.thisFy = :thisFy"),
		@NamedQuery(name = "SpEmComponents.findByReportTillDate", query = "SELECT s FROM SpEmComponents s WHERE s.reportTillDate = :reportTillDate") })
public class SpEmComponents implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SP_EM_COMPONENTSID")
	private Long spEmComponentsid;
	@Column(name = "ITEM_DESCRIPTION")
	private String itemDescription;
	@Column(name = "QUANTITY_DESC")
	private String quantityDesc;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "PHY_TOTAL_TARGET")
	private BigDecimal phyTotalTarget;
	@Basic(optional = false)
	@Column(name = "PHY_ACH_TILL_LFY")
	private BigDecimal phyAchTillLfy;
	@Basic(optional = false)
	@Column(name = "PHY_TARGET_THIS_FY")
	private BigDecimal phyTargetThisFy;
	@Basic(optional = false)
	@Column(name = "PHY_ACH_THIS_FY")
	private BigDecimal phyAchThisFy;
	@Basic(optional = false)
	@Column(name = "FIN_TOTAL_TARGET")
	private BigDecimal finTotalTarget;
	@Basic(optional = false)
	@Column(name = "FIN_ACH_TILL_LFY")
	private BigDecimal finAchTillLfy;
	@Basic(optional = false)
	@Column(name = "FIN_TARGET_THIS_FY")
	private BigDecimal finTargetThisFy;
	@Basic(optional = false)
	@Column(name = "FIN_ACH_THIS_FY")
	private BigDecimal finAchThisFy;
	@Column(name = "LAST_FY")
	private String lastFy;
	@Column(name = "THIS_FY")
	private String thisFy;
	@Column(name = "REPORT_TILL_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reportTillDate;
	@JoinColumn(name = "SP_SCHEMEMASTERID", referencedColumnName = "SP_SCHEMEMASTERID")
	@ManyToOne(optional = false)
	private SpSchememaster spSchememasterid;

	public SpEmComponents() {
	}

	public SpEmComponents(Long spEmComponentsid) {
		this.spEmComponentsid = spEmComponentsid;
	}

	public SpEmComponents(Long spEmComponentsid, BigDecimal phyTotalTarget, BigDecimal phyAchTillLfy,
			BigDecimal phyTargetThisFy, BigDecimal phyAchThisFy, BigDecimal finTotalTarget, BigDecimal finAchTillLfy,
			BigDecimal finTargetThisFy, BigDecimal finAchThisFy) {
		this.spEmComponentsid = spEmComponentsid;
		this.phyTotalTarget = phyTotalTarget;
		this.phyAchTillLfy = phyAchTillLfy;
		this.phyTargetThisFy = phyTargetThisFy;
		this.phyAchThisFy = phyAchThisFy;
		this.finTotalTarget = finTotalTarget;
		this.finAchTillLfy = finAchTillLfy;
		this.finTargetThisFy = finTargetThisFy;
		this.finAchThisFy = finAchThisFy;
	}

	public Long getSpEmComponentsid() {
		return spEmComponentsid;
	}

	public void setSpEmComponentsid(Long spEmComponentsid) {
		this.spEmComponentsid = spEmComponentsid;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getQuantityDesc() {
		return quantityDesc;
	}

	public void setQuantityDesc(String quantityDesc) {
		this.quantityDesc = quantityDesc;
	}

	public BigDecimal getPhyTotalTarget() {
		return phyTotalTarget;
	}

	public void setPhyTotalTarget(BigDecimal phyTotalTarget) {
		this.phyTotalTarget = phyTotalTarget;
	}

	public BigDecimal getPhyAchTillLfy() {
		return phyAchTillLfy;
	}

	public void setPhyAchTillLfy(BigDecimal phyAchTillLfy) {
		this.phyAchTillLfy = phyAchTillLfy;
	}

	public BigDecimal getPhyTargetThisFy() {
		return phyTargetThisFy;
	}

	public void setPhyTargetThisFy(BigDecimal phyTargetThisFy) {
		this.phyTargetThisFy = phyTargetThisFy;
	}

	public BigDecimal getPhyAchThisFy() {
		return phyAchThisFy;
	}

	public void setPhyAchThisFy(BigDecimal phyAchThisFy) {
		this.phyAchThisFy = phyAchThisFy;
	}

	public BigDecimal getFinTotalTarget() {
		return finTotalTarget;
	}

	public void setFinTotalTarget(BigDecimal finTotalTarget) {
		this.finTotalTarget = finTotalTarget;
	}

	public BigDecimal getFinAchTillLfy() {
		return finAchTillLfy;
	}

	public void setFinAchTillLfy(BigDecimal finAchTillLfy) {
		this.finAchTillLfy = finAchTillLfy;
	}

	public BigDecimal getFinTargetThisFy() {
		return finTargetThisFy;
	}

	public void setFinTargetThisFy(BigDecimal finTargetThisFy) {
		this.finTargetThisFy = finTargetThisFy;
	}

	public BigDecimal getFinAchThisFy() {
		return finAchThisFy;
	}

	public void setFinAchThisFy(BigDecimal finAchThisFy) {
		this.finAchThisFy = finAchThisFy;
	}

	public String getLastFy() {
		return lastFy;
	}

	public void setLastFy(String lastFy) {
		this.lastFy = lastFy;
	}

	public String getThisFy() {
		return thisFy;
	}

	public void setThisFy(String thisFy) {
		this.thisFy = thisFy;
	}

	public Date getReportTillDate() {
		return reportTillDate;
	}

	public void setReportTillDate(Date reportTillDate) {
		this.reportTillDate = reportTillDate;
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
		hash += (spEmComponentsid != null ? spEmComponentsid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SpEmComponents)) {
			return false;
		}
		SpEmComponents other = (SpEmComponents) object;
		if ((this.spEmComponentsid == null && other.spEmComponentsid != null)
				|| (this.spEmComponentsid != null && !this.spEmComponentsid.equals(other.spEmComponentsid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SpEmComponents[ spEmComponentsid=" + spEmComponentsid + " ]";
	}

}
