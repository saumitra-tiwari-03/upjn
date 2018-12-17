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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "LFY_SP_FINANCIALPROGRESS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfySpFinancialprogress.findAll", query = "SELECT l FROM LfySpFinancialprogress l"),
		@NamedQuery(name = "LfySpFinancialprogress.findByLfySpFinancialprogressid", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.lfySpFinancialprogressid = :lfySpFinancialprogressid"),
		@NamedQuery(name = "LfySpFinancialprogress.findBySpProgramid", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.spProgramid = :spProgramid"),
		@NamedQuery(name = "LfySpFinancialprogress.findBySysSpSchemecategoryid", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.sysSpSchemecategoryid = :sysSpSchemecategoryid"),
		@NamedQuery(name = "LfySpFinancialprogress.findByMonth", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.month = :month"),
		@NamedQuery(name = "LfySpFinancialprogress.findByYear", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.year = :year"),
		@NamedQuery(name = "LfySpFinancialprogress.findByOpeningbalance", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.openingbalance = :openingbalance"),
		@NamedQuery(name = "LfySpFinancialprogress.findByHqAmount", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.hqAmount = :hqAmount"),
		@NamedQuery(name = "LfySpFinancialprogress.findByDmOtherAmount", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.dmOtherAmount = :dmOtherAmount"),
		@NamedQuery(name = "LfySpFinancialprogress.findByPublicContribution", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.publicContribution = :publicContribution"),
		@NamedQuery(name = "LfySpFinancialprogress.findByWorksAmount", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.worksAmount = :worksAmount"),
		@NamedQuery(name = "LfySpFinancialprogress.findByWcAmount", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.wcAmount = :wcAmount"),
		@NamedQuery(name = "LfySpFinancialprogress.findByContiAmount", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.contiAmount = :contiAmount"),
		@NamedQuery(name = "LfySpFinancialprogress.findByCentageAmount", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.centageAmount = :centageAmount"),
		@NamedQuery(name = "LfySpFinancialprogress.findByRmOfficeid", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "LfySpFinancialprogress.findByMasDistrictid", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.masDistrictid = :masDistrictid"),
		@NamedQuery(name = "LfySpFinancialprogress.findByWorksAmountnonchargeable", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.worksAmountnonchargeable = :worksAmountnonchargeable"),
		@NamedQuery(name = "LfySpFinancialprogress.findBySpFinancialprogressid", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.spFinancialprogressid = :spFinancialprogressid"),
		@NamedQuery(name = "LfySpFinancialprogress.findByFinancialyear", query = "SELECT l FROM LfySpFinancialprogress l WHERE l.financialyear = :financialyear") })
public class LfySpFinancialprogress implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_SP_FINANCIALPROGRESSID")
	private Long lfySpFinancialprogressid;
	@Basic(optional = false)
	@Column(name = "SP_PROGRAMID")
	private long spProgramid;
	@Basic(optional = false)
	@Column(name = "SYS_SP_SCHEMECATEGORYID")
	private long sysSpSchemecategoryid;
	@Basic(optional = false)
	@Column(name = "MONTH")
	private short month;
	@Basic(optional = false)
	@Column(name = "YEAR")
	private short year;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "OPENINGBALANCE")
	private BigDecimal openingbalance;
	@Basic(optional = false)
	@Column(name = "HQ_AMOUNT")
	private BigDecimal hqAmount;
	@Basic(optional = false)
	@Column(name = "DM_OTHER_AMOUNT")
	private BigDecimal dmOtherAmount;
	@Basic(optional = false)
	@Column(name = "PUBLIC_CONTRIBUTION")
	private BigDecimal publicContribution;
	@Basic(optional = false)
	@Column(name = "WORKS_AMOUNT")
	private BigDecimal worksAmount;
	@Basic(optional = false)
	@Column(name = "WC_AMOUNT")
	private BigDecimal wcAmount;
	@Basic(optional = false)
	@Column(name = "CONTI_AMOUNT")
	private BigDecimal contiAmount;
	@Basic(optional = false)
	@Column(name = "CENTAGE_AMOUNT")
	private BigDecimal centageAmount;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private BigDecimal rmOfficeid;
	@Basic(optional = false)
	@Column(name = "MAS_DISTRICTID")
	private BigDecimal masDistrictid;
	@Basic(optional = false)
	@Column(name = "WORKS_AMOUNTNONCHARGEABLE")
	private BigDecimal worksAmountnonchargeable;
	@Basic(optional = false)
	@Column(name = "SP_FINANCIALPROGRESSID")
	private long spFinancialprogressid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfySpFinancialprogress() {
	}

	public LfySpFinancialprogress(Long lfySpFinancialprogressid) {
		this.lfySpFinancialprogressid = lfySpFinancialprogressid;
	}

	public LfySpFinancialprogress(Long lfySpFinancialprogressid, long spProgramid, long sysSpSchemecategoryid,
			short month, short year, BigDecimal openingbalance, BigDecimal hqAmount, BigDecimal dmOtherAmount,
			BigDecimal publicContribution, BigDecimal worksAmount, BigDecimal wcAmount, BigDecimal contiAmount,
			BigDecimal centageAmount, BigDecimal rmOfficeid, BigDecimal masDistrictid,
			BigDecimal worksAmountnonchargeable, long spFinancialprogressid, String financialyear) {
		this.lfySpFinancialprogressid = lfySpFinancialprogressid;
		this.spProgramid = spProgramid;
		this.sysSpSchemecategoryid = sysSpSchemecategoryid;
		this.month = month;
		this.year = year;
		this.openingbalance = openingbalance;
		this.hqAmount = hqAmount;
		this.dmOtherAmount = dmOtherAmount;
		this.publicContribution = publicContribution;
		this.worksAmount = worksAmount;
		this.wcAmount = wcAmount;
		this.contiAmount = contiAmount;
		this.centageAmount = centageAmount;
		this.rmOfficeid = rmOfficeid;
		this.masDistrictid = masDistrictid;
		this.worksAmountnonchargeable = worksAmountnonchargeable;
		this.spFinancialprogressid = spFinancialprogressid;
		this.financialyear = financialyear;
	}

	public Long getLfySpFinancialprogressid() {
		return lfySpFinancialprogressid;
	}

	public void setLfySpFinancialprogressid(Long lfySpFinancialprogressid) {
		this.lfySpFinancialprogressid = lfySpFinancialprogressid;
	}

	public long getSpProgramid() {
		return spProgramid;
	}

	public void setSpProgramid(long spProgramid) {
		this.spProgramid = spProgramid;
	}

	public long getSysSpSchemecategoryid() {
		return sysSpSchemecategoryid;
	}

	public void setSysSpSchemecategoryid(long sysSpSchemecategoryid) {
		this.sysSpSchemecategoryid = sysSpSchemecategoryid;
	}

	public short getMonth() {
		return month;
	}

	public void setMonth(short month) {
		this.month = month;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public BigDecimal getOpeningbalance() {
		return openingbalance;
	}

	public void setOpeningbalance(BigDecimal openingbalance) {
		this.openingbalance = openingbalance;
	}

	public BigDecimal getHqAmount() {
		return hqAmount;
	}

	public void setHqAmount(BigDecimal hqAmount) {
		this.hqAmount = hqAmount;
	}

	public BigDecimal getDmOtherAmount() {
		return dmOtherAmount;
	}

	public void setDmOtherAmount(BigDecimal dmOtherAmount) {
		this.dmOtherAmount = dmOtherAmount;
	}

	public BigDecimal getPublicContribution() {
		return publicContribution;
	}

	public void setPublicContribution(BigDecimal publicContribution) {
		this.publicContribution = publicContribution;
	}

	public BigDecimal getWorksAmount() {
		return worksAmount;
	}

	public void setWorksAmount(BigDecimal worksAmount) {
		this.worksAmount = worksAmount;
	}

	public BigDecimal getWcAmount() {
		return wcAmount;
	}

	public void setWcAmount(BigDecimal wcAmount) {
		this.wcAmount = wcAmount;
	}

	public BigDecimal getContiAmount() {
		return contiAmount;
	}

	public void setContiAmount(BigDecimal contiAmount) {
		this.contiAmount = contiAmount;
	}

	public BigDecimal getCentageAmount() {
		return centageAmount;
	}

	public void setCentageAmount(BigDecimal centageAmount) {
		this.centageAmount = centageAmount;
	}

	public BigDecimal getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(BigDecimal rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public BigDecimal getMasDistrictid() {
		return masDistrictid;
	}

	public void setMasDistrictid(BigDecimal masDistrictid) {
		this.masDistrictid = masDistrictid;
	}

	public BigDecimal getWorksAmountnonchargeable() {
		return worksAmountnonchargeable;
	}

	public void setWorksAmountnonchargeable(BigDecimal worksAmountnonchargeable) {
		this.worksAmountnonchargeable = worksAmountnonchargeable;
	}

	public long getSpFinancialprogressid() {
		return spFinancialprogressid;
	}

	public void setSpFinancialprogressid(long spFinancialprogressid) {
		this.spFinancialprogressid = spFinancialprogressid;
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
		hash += (lfySpFinancialprogressid != null ? lfySpFinancialprogressid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfySpFinancialprogress)) {
			return false;
		}
		LfySpFinancialprogress other = (LfySpFinancialprogress) object;
		if ((this.lfySpFinancialprogressid == null && other.lfySpFinancialprogressid != null)
				|| (this.lfySpFinancialprogressid != null
						&& !this.lfySpFinancialprogressid.equals(other.lfySpFinancialprogressid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfySpFinancialprogress[ lfySpFinancialprogressid=" + lfySpFinancialprogressid
				+ " ]";
	}

}
