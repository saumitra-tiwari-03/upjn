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
@Table(name = "SP_FINANCIALPROGRESS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SpFinancialprogress.findAll", query = "SELECT s FROM SpFinancialprogress s"),
		@NamedQuery(name = "SpFinancialprogress.findBySpFinancialprogressid", query = "SELECT s FROM SpFinancialprogress s WHERE s.spFinancialprogressid = :spFinancialprogressid"),
		@NamedQuery(name = "SpFinancialprogress.findBySpProgramid", query = "SELECT s FROM SpFinancialprogress s WHERE s.spProgramid = :spProgramid"),
		@NamedQuery(name = "SpFinancialprogress.findBySysSpSchemecategoryid", query = "SELECT s FROM SpFinancialprogress s WHERE s.sysSpSchemecategoryid = :sysSpSchemecategoryid"),
		@NamedQuery(name = "SpFinancialprogress.findByMonth", query = "SELECT s FROM SpFinancialprogress s WHERE s.month = :month"),
		@NamedQuery(name = "SpFinancialprogress.findByYear", query = "SELECT s FROM SpFinancialprogress s WHERE s.year = :year"),
		@NamedQuery(name = "SpFinancialprogress.findByOpeningbalance", query = "SELECT s FROM SpFinancialprogress s WHERE s.openingbalance = :openingbalance"),
		@NamedQuery(name = "SpFinancialprogress.findByHqAmount", query = "SELECT s FROM SpFinancialprogress s WHERE s.hqAmount = :hqAmount"),
		@NamedQuery(name = "SpFinancialprogress.findByDmOtherAmount", query = "SELECT s FROM SpFinancialprogress s WHERE s.dmOtherAmount = :dmOtherAmount"),
		@NamedQuery(name = "SpFinancialprogress.findByPublicContribution", query = "SELECT s FROM SpFinancialprogress s WHERE s.publicContribution = :publicContribution"),
		@NamedQuery(name = "SpFinancialprogress.findByWorksAmount", query = "SELECT s FROM SpFinancialprogress s WHERE s.worksAmount = :worksAmount"),
		@NamedQuery(name = "SpFinancialprogress.findByWcAmount", query = "SELECT s FROM SpFinancialprogress s WHERE s.wcAmount = :wcAmount"),
		@NamedQuery(name = "SpFinancialprogress.findByContiAmount", query = "SELECT s FROM SpFinancialprogress s WHERE s.contiAmount = :contiAmount"),
		@NamedQuery(name = "SpFinancialprogress.findByCentageAmount", query = "SELECT s FROM SpFinancialprogress s WHERE s.centageAmount = :centageAmount"),
		@NamedQuery(name = "SpFinancialprogress.findByRmOfficeid", query = "SELECT s FROM SpFinancialprogress s WHERE s.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "SpFinancialprogress.findByMasDistrictid", query = "SELECT s FROM SpFinancialprogress s WHERE s.masDistrictid = :masDistrictid"),
		@NamedQuery(name = "SpFinancialprogress.findByWorksAmountnonchargeable", query = "SELECT s FROM SpFinancialprogress s WHERE s.worksAmountnonchargeable = :worksAmountnonchargeable") })
public class SpFinancialprogress implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SP_FINANCIALPROGRESSID")
	private Long spFinancialprogressid;
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

	public SpFinancialprogress() {
	}

	public SpFinancialprogress(Long spFinancialprogressid) {
		this.spFinancialprogressid = spFinancialprogressid;
	}

	public SpFinancialprogress(Long spFinancialprogressid, long spProgramid, long sysSpSchemecategoryid, short month,
			short year, BigDecimal openingbalance, BigDecimal hqAmount, BigDecimal dmOtherAmount,
			BigDecimal publicContribution, BigDecimal worksAmount, BigDecimal wcAmount, BigDecimal contiAmount,
			BigDecimal centageAmount, BigDecimal rmOfficeid, BigDecimal masDistrictid,
			BigDecimal worksAmountnonchargeable) {
		this.spFinancialprogressid = spFinancialprogressid;
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
	}

	public Long getSpFinancialprogressid() {
		return spFinancialprogressid;
	}

	public void setSpFinancialprogressid(Long spFinancialprogressid) {
		this.spFinancialprogressid = spFinancialprogressid;
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

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (spFinancialprogressid != null ? spFinancialprogressid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SpFinancialprogress)) {
			return false;
		}
		SpFinancialprogress other = (SpFinancialprogress) object;
		if ((this.spFinancialprogressid == null && other.spFinancialprogressid != null)
				|| (this.spFinancialprogressid != null
						&& !this.spFinancialprogressid.equals(other.spFinancialprogressid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SpFinancialprogress[ spFinancialprogressid=" + spFinancialprogressid + " ]";
	}

}
