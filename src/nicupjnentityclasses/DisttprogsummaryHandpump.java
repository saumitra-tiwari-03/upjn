/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigInteger;

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
@Table(name = "DISTTPROGSUMMARY_HANDPUMP")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "DisttprogsummaryHandpump.findAll", query = "SELECT d FROM DisttprogsummaryHandpump d"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByDisttprogsummaryHandpumpid", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.disttprogsummaryHandpumpid = :disttprogsummaryHandpumpid"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByMasDistrictid", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.masDistrictid = :masDistrictid"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findBySpProgramCode", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.spProgramCode = :spProgramCode"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByMonth", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.month = :month"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByYear", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.year = :year"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByPwsType", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.pwsType = :pwsType"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByNhpBalance", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.nhpBalance = :nhpBalance"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByNhpCfy", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.nhpCfy = :nhpCfy"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByNhpAchievement", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.nhpAchievement = :nhpAchievement"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByHprBalance", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.hprBalance = :hprBalance"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByHprCfy", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.hprCfy = :hprCfy"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByHprAchievement", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.hprAchievement = :hprAchievement"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByHpmrTarget", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.hpmrTarget = :hpmrTarget"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByHpmrAchievement", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.hpmrAchievement = :hpmrAchievement"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByHpmlaTotal", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.hpmlaTotal = :hpmlaTotal"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByHpmlaSites", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.hpmlaSites = :hpmlaSites"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByHpmlaContr", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.hpmlaContr = :hpmlaContr"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByHpmlaInstalled", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.hpmlaInstalled = :hpmlaInstalled"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByPlatformCons", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.platformCons = :platformCons"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByEmbossingDone", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.embossingDone = :embossingDone"),
		@NamedQuery(name = "DisttprogsummaryHandpump.findByRmOfficeid", query = "SELECT d FROM DisttprogsummaryHandpump d WHERE d.rmOfficeid = :rmOfficeid") })
public class DisttprogsummaryHandpump implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "DISTTPROGSUMMARY_HANDPUMPID")
	private Long disttprogsummaryHandpumpid;
	@Column(name = "MAS_DISTRICTID")
	private Long masDistrictid;
	@Basic(optional = false)
	@Column(name = "SP_PROGRAM_CODE")
	private String spProgramCode;
	@Basic(optional = false)
	@Column(name = "MONTH")
	private short month;
	@Basic(optional = false)
	@Column(name = "YEAR")
	private short year;
	@Basic(optional = false)
	@Column(name = "PWS_TYPE")
	private String pwsType;
	@Basic(optional = false)
	@Column(name = "NHP_BALANCE")
	private BigInteger nhpBalance;
	@Basic(optional = false)
	@Column(name = "NHP_CFY")
	private BigInteger nhpCfy;
	@Basic(optional = false)
	@Column(name = "NHP_ACHIEVEMENT")
	private BigInteger nhpAchievement;
	@Basic(optional = false)
	@Column(name = "HPR_BALANCE")
	private long hprBalance;
	@Basic(optional = false)
	@Column(name = "HPR_CFY")
	private long hprCfy;
	@Basic(optional = false)
	@Column(name = "HPR_ACHIEVEMENT")
	private long hprAchievement;
	@Basic(optional = false)
	@Column(name = "HPMR_TARGET")
	private long hpmrTarget;
	@Basic(optional = false)
	@Column(name = "HPMR_ACHIEVEMENT")
	private long hpmrAchievement;
	@Basic(optional = false)
	@Column(name = "HPMLA_TOTAL")
	private long hpmlaTotal;
	@Basic(optional = false)
	@Column(name = "HPMLA_SITES")
	private long hpmlaSites;
	@Basic(optional = false)
	@Column(name = "HPMLA_CONTR")
	private long hpmlaContr;
	@Basic(optional = false)
	@Column(name = "HPMLA_INSTALLED")
	private long hpmlaInstalled;
	@Basic(optional = false)
	@Column(name = "PLATFORM_CONS")
	private long platformCons;
	@Basic(optional = false)
	@Column(name = "EMBOSSING_DONE")
	private long embossingDone;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private long rmOfficeid;

	public DisttprogsummaryHandpump() {
	}

	public DisttprogsummaryHandpump(Long disttprogsummaryHandpumpid) {
		this.disttprogsummaryHandpumpid = disttprogsummaryHandpumpid;
	}

	public DisttprogsummaryHandpump(Long disttprogsummaryHandpumpid, String spProgramCode, short month, short year,
			String pwsType, BigInteger nhpBalance, BigInteger nhpCfy, BigInteger nhpAchievement, long hprBalance,
			long hprCfy, long hprAchievement, long hpmrTarget, long hpmrAchievement, long hpmlaTotal, long hpmlaSites,
			long hpmlaContr, long hpmlaInstalled, long platformCons, long embossingDone, long rmOfficeid) {
		this.disttprogsummaryHandpumpid = disttprogsummaryHandpumpid;
		this.spProgramCode = spProgramCode;
		this.month = month;
		this.year = year;
		this.pwsType = pwsType;
		this.nhpBalance = nhpBalance;
		this.nhpCfy = nhpCfy;
		this.nhpAchievement = nhpAchievement;
		this.hprBalance = hprBalance;
		this.hprCfy = hprCfy;
		this.hprAchievement = hprAchievement;
		this.hpmrTarget = hpmrTarget;
		this.hpmrAchievement = hpmrAchievement;
		this.hpmlaTotal = hpmlaTotal;
		this.hpmlaSites = hpmlaSites;
		this.hpmlaContr = hpmlaContr;
		this.hpmlaInstalled = hpmlaInstalled;
		this.platformCons = platformCons;
		this.embossingDone = embossingDone;
		this.rmOfficeid = rmOfficeid;
	}

	public Long getDisttprogsummaryHandpumpid() {
		return disttprogsummaryHandpumpid;
	}

	public void setDisttprogsummaryHandpumpid(Long disttprogsummaryHandpumpid) {
		this.disttprogsummaryHandpumpid = disttprogsummaryHandpumpid;
	}

	public Long getMasDistrictid() {
		return masDistrictid;
	}

	public void setMasDistrictid(Long masDistrictid) {
		this.masDistrictid = masDistrictid;
	}

	public String getSpProgramCode() {
		return spProgramCode;
	}

	public void setSpProgramCode(String spProgramCode) {
		this.spProgramCode = spProgramCode;
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

	public String getPwsType() {
		return pwsType;
	}

	public void setPwsType(String pwsType) {
		this.pwsType = pwsType;
	}

	public BigInteger getNhpBalance() {
		return nhpBalance;
	}

	public void setNhpBalance(BigInteger nhpBalance) {
		this.nhpBalance = nhpBalance;
	}

	public BigInteger getNhpCfy() {
		return nhpCfy;
	}

	public void setNhpCfy(BigInteger nhpCfy) {
		this.nhpCfy = nhpCfy;
	}

	public BigInteger getNhpAchievement() {
		return nhpAchievement;
	}

	public void setNhpAchievement(BigInteger nhpAchievement) {
		this.nhpAchievement = nhpAchievement;
	}

	public long getHprBalance() {
		return hprBalance;
	}

	public void setHprBalance(long hprBalance) {
		this.hprBalance = hprBalance;
	}

	public long getHprCfy() {
		return hprCfy;
	}

	public void setHprCfy(long hprCfy) {
		this.hprCfy = hprCfy;
	}

	public long getHprAchievement() {
		return hprAchievement;
	}

	public void setHprAchievement(long hprAchievement) {
		this.hprAchievement = hprAchievement;
	}

	public long getHpmrTarget() {
		return hpmrTarget;
	}

	public void setHpmrTarget(long hpmrTarget) {
		this.hpmrTarget = hpmrTarget;
	}

	public long getHpmrAchievement() {
		return hpmrAchievement;
	}

	public void setHpmrAchievement(long hpmrAchievement) {
		this.hpmrAchievement = hpmrAchievement;
	}

	public long getHpmlaTotal() {
		return hpmlaTotal;
	}

	public void setHpmlaTotal(long hpmlaTotal) {
		this.hpmlaTotal = hpmlaTotal;
	}

	public long getHpmlaSites() {
		return hpmlaSites;
	}

	public void setHpmlaSites(long hpmlaSites) {
		this.hpmlaSites = hpmlaSites;
	}

	public long getHpmlaContr() {
		return hpmlaContr;
	}

	public void setHpmlaContr(long hpmlaContr) {
		this.hpmlaContr = hpmlaContr;
	}

	public long getHpmlaInstalled() {
		return hpmlaInstalled;
	}

	public void setHpmlaInstalled(long hpmlaInstalled) {
		this.hpmlaInstalled = hpmlaInstalled;
	}

	public long getPlatformCons() {
		return platformCons;
	}

	public void setPlatformCons(long platformCons) {
		this.platformCons = platformCons;
	}

	public long getEmbossingDone() {
		return embossingDone;
	}

	public void setEmbossingDone(long embossingDone) {
		this.embossingDone = embossingDone;
	}

	public long getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(long rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (disttprogsummaryHandpumpid != null ? disttprogsummaryHandpumpid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof DisttprogsummaryHandpump)) {
			return false;
		}
		DisttprogsummaryHandpump other = (DisttprogsummaryHandpump) object;
		if ((this.disttprogsummaryHandpumpid == null && other.disttprogsummaryHandpumpid != null)
				|| (this.disttprogsummaryHandpumpid != null
						&& !this.disttprogsummaryHandpumpid.equals(other.disttprogsummaryHandpumpid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.DisttprogsummaryHandpump[ disttprogsummaryHandpumpid=" + disttprogsummaryHandpumpid
				+ " ]";
	}

}
