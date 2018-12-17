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
@Table(name = "SP_CIVIL_COMPONENTS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SpCivilComponents.findAll", query = "SELECT s FROM SpCivilComponents s"),
		@NamedQuery(name = "SpCivilComponents.findBySpCivilComponentsid", query = "SELECT s FROM SpCivilComponents s WHERE s.spCivilComponentsid = :spCivilComponentsid"),
		@NamedQuery(name = "SpCivilComponents.findByItemDescription", query = "SELECT s FROM SpCivilComponents s WHERE s.itemDescription = :itemDescription"),
		@NamedQuery(name = "SpCivilComponents.findByPhyTotalTarget", query = "SELECT s FROM SpCivilComponents s WHERE s.phyTotalTarget = :phyTotalTarget"),
		@NamedQuery(name = "SpCivilComponents.findByPhyAchTillLfy", query = "SELECT s FROM SpCivilComponents s WHERE s.phyAchTillLfy = :phyAchTillLfy"),
		@NamedQuery(name = "SpCivilComponents.findByPhyTargetThisFy", query = "SELECT s FROM SpCivilComponents s WHERE s.phyTargetThisFy = :phyTargetThisFy"),
		@NamedQuery(name = "SpCivilComponents.findByPhyAchThisFy", query = "SELECT s FROM SpCivilComponents s WHERE s.phyAchThisFy = :phyAchThisFy"),
		@NamedQuery(name = "SpCivilComponents.findByFinTotalTarget", query = "SELECT s FROM SpCivilComponents s WHERE s.finTotalTarget = :finTotalTarget"),
		@NamedQuery(name = "SpCivilComponents.findByFinAchTillLfy", query = "SELECT s FROM SpCivilComponents s WHERE s.finAchTillLfy = :finAchTillLfy"),
		@NamedQuery(name = "SpCivilComponents.findByFinTargetThisFy", query = "SELECT s FROM SpCivilComponents s WHERE s.finTargetThisFy = :finTargetThisFy"),
		@NamedQuery(name = "SpCivilComponents.findByFinAchThisFy", query = "SELECT s FROM SpCivilComponents s WHERE s.finAchThisFy = :finAchThisFy"),
		@NamedQuery(name = "SpCivilComponents.findByLastFy", query = "SELECT s FROM SpCivilComponents s WHERE s.lastFy = :lastFy"),
		@NamedQuery(name = "SpCivilComponents.findByThisFy", query = "SELECT s FROM SpCivilComponents s WHERE s.thisFy = :thisFy"),
		@NamedQuery(name = "SpCivilComponents.findByReportTillDate", query = "SELECT s FROM SpCivilComponents s WHERE s.reportTillDate = :reportTillDate") })
public class SpCivilComponents implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SP_CIVIL_COMPONENTSID")
	private Long spCivilComponentsid;
	@Column(name = "ITEM_DESCRIPTION")
	private String itemDescription;
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
	@JoinColumn(name = "SP_COMPONENTMASTERID", referencedColumnName = "SP_COMPONENTMASTERID")
	@ManyToOne(optional = false)
	private SpComponentmaster spComponentmasterid;
	@JoinColumn(name = "SP_SCHEMEMASTERID", referencedColumnName = "SP_SCHEMEMASTERID")
	@ManyToOne(optional = false)
	private SpSchememaster spSchememasterid;

	public SpCivilComponents() {
	}

	public SpCivilComponents(Long spCivilComponentsid) {
		this.spCivilComponentsid = spCivilComponentsid;
	}

	public SpCivilComponents(Long spCivilComponentsid, BigDecimal phyTotalTarget, BigDecimal phyAchTillLfy,
			BigDecimal phyTargetThisFy, BigDecimal phyAchThisFy, BigDecimal finTotalTarget, BigDecimal finAchTillLfy,
			BigDecimal finTargetThisFy, BigDecimal finAchThisFy) {
		this.spCivilComponentsid = spCivilComponentsid;
		this.phyTotalTarget = phyTotalTarget;
		this.phyAchTillLfy = phyAchTillLfy;
		this.phyTargetThisFy = phyTargetThisFy;
		this.phyAchThisFy = phyAchThisFy;
		this.finTotalTarget = finTotalTarget;
		this.finAchTillLfy = finAchTillLfy;
		this.finTargetThisFy = finTargetThisFy;
		this.finAchThisFy = finAchThisFy;
	}

	public Long getSpCivilComponentsid() {
		return spCivilComponentsid;
	}

	public void setSpCivilComponentsid(Long spCivilComponentsid) {
		this.spCivilComponentsid = spCivilComponentsid;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
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

	public SpComponentmaster getSpComponentmasterid() {
		return spComponentmasterid;
	}

	public void setSpComponentmasterid(SpComponentmaster spComponentmasterid) {
		this.spComponentmasterid = spComponentmasterid;
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
		hash += (spCivilComponentsid != null ? spCivilComponentsid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SpCivilComponents)) {
			return false;
		}
		SpCivilComponents other = (SpCivilComponents) object;
		if ((this.spCivilComponentsid == null && other.spCivilComponentsid != null)
				|| (this.spCivilComponentsid != null && !this.spCivilComponentsid.equals(other.spCivilComponentsid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SpCivilComponents[ spCivilComponentsid=" + spCivilComponentsid + " ]";
	}

}
