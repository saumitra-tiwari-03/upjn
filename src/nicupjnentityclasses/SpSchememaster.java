/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SP_SCHEMEMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SpSchememaster.findAll", query = "SELECT s FROM SpSchememaster s"),
		@NamedQuery(name = "SpSchememaster.findBySpSchememasterid", query = "SELECT s FROM SpSchememaster s WHERE s.spSchememasterid = :spSchememasterid"),
		@NamedQuery(name = "SpSchememaster.findByScheme", query = "SELECT s FROM SpSchememaster s WHERE s.scheme = :scheme"),
		@NamedQuery(name = "SpSchememaster.findBySpProgramid", query = "SELECT s FROM SpSchememaster s WHERE s.spProgramid = :spProgramid"),
		@NamedQuery(name = "SpSchememaster.findByRmOfficeid", query = "SELECT s FROM SpSchememaster s WHERE s.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "SpSchememaster.findByStartdate", query = "SELECT s FROM SpSchememaster s WHERE s.startdate = :startdate"),
		@NamedQuery(name = "SpSchememaster.findByEstimatedcompletiondate", query = "SELECT s FROM SpSchememaster s WHERE s.estimatedcompletiondate = :estimatedcompletiondate"),
		@NamedQuery(name = "SpSchememaster.findBySanctionno", query = "SELECT s FROM SpSchememaster s WHERE s.sanctionno = :sanctionno"),
		@NamedQuery(name = "SpSchememaster.findBySanctionDate", query = "SELECT s FROM SpSchememaster s WHERE s.sanctionDate = :sanctionDate"),
		@NamedQuery(name = "SpSchememaster.findByGrantAmount", query = "SELECT s FROM SpSchememaster s WHERE s.grantAmount = :grantAmount"),
		@NamedQuery(name = "SpSchememaster.findByLocalCash", query = "SELECT s FROM SpSchememaster s WHERE s.localCash = :localCash"),
		@NamedQuery(name = "SpSchememaster.findByLocalOther", query = "SELECT s FROM SpSchememaster s WHERE s.localOther = :localOther"),
		@NamedQuery(name = "SpSchememaster.findByCommunityOther", query = "SELECT s FROM SpSchememaster s WHERE s.communityOther = :communityOther"),
		@NamedQuery(name = "SpSchememaster.findByCommunityCash", query = "SELECT s FROM SpSchememaster s WHERE s.communityCash = :communityCash"),
		@NamedQuery(name = "SpSchememaster.findByClosingDate", query = "SELECT s FROM SpSchememaster s WHERE s.closingDate = :closingDate"),
		@NamedQuery(name = "SpSchememaster.findByEditDate", query = "SELECT s FROM SpSchememaster s WHERE s.editDate = :editDate"),
		@NamedQuery(name = "SpSchememaster.findByTotalSanctionedCost", query = "SELECT s FROM SpSchememaster s WHERE s.totalSanctionedCost = :totalSanctionedCost"),
		@NamedQuery(name = "SpSchememaster.findByIscomplete", query = "SELECT s FROM SpSchememaster s WHERE s.iscomplete = :iscomplete"),
		@NamedQuery(name = "SpSchememaster.findByReporttilldate", query = "SELECT s FROM SpSchememaster s WHERE s.reporttilldate = :reporttilldate"),
		@NamedQuery(name = "SpSchememaster.findByFundReceivedTillLfy", query = "SELECT s FROM SpSchememaster s WHERE s.fundReceivedTillLfy = :fundReceivedTillLfy"),
		@NamedQuery(name = "SpSchememaster.findByIsclosed", query = "SELECT s FROM SpSchememaster s WHERE s.isclosed = :isclosed") })
public class SpSchememaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SP_SCHEMEMASTERID")
	private Long spSchememasterid;
	@Basic(optional = false)
	@Column(name = "SCHEME")
	private String scheme;
	@Basic(optional = false)
	@Column(name = "SP_PROGRAMID")
	private int spProgramid;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Basic(optional = false)
	@Column(name = "STARTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startdate;
	@Basic(optional = false)
	@Column(name = "ESTIMATEDCOMPLETIONDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date estimatedcompletiondate;
	@Column(name = "SANCTIONNO")
	private String sanctionno;
	@Column(name = "SANCTION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sanctionDate;
	@Basic(optional = false)
	@Column(name = "GRANT_AMOUNT")
	private long grantAmount;
	@Basic(optional = false)
	@Column(name = "LOCAL_CASH")
	private long localCash;
	@Basic(optional = false)
	@Column(name = "LOCAL_OTHER")
	private long localOther;
	@Basic(optional = false)
	@Column(name = "COMMUNITY_OTHER")
	private long communityOther;
	@Basic(optional = false)
	@Column(name = "COMMUNITY_CASH")
	private long communityCash;
	@Column(name = "CLOSING_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date closingDate;
	@Basic(optional = false)
	@Column(name = "EDIT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date editDate;
	@Basic(optional = false)
	@Column(name = "TOTAL_SANCTIONED_COST")
	private long totalSanctionedCost;
	@Basic(optional = false)
	@Column(name = "ISCOMPLETE")
	private Character iscomplete;
	@Basic(optional = false)
	@Column(name = "REPORTTILLDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reporttilldate;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "FUND_RECEIVED_TILL_LFY")
	private BigDecimal fundReceivedTillLfy;
	@Basic(optional = false)
	@Column(name = "ISCLOSED")
	private Character isclosed;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "spSchememasterid")
	private Collection<SmmM1reportinfo> smmM1reportinfoCollection;
	@JoinColumn(name = "MAS_DISTRICTID", referencedColumnName = "MAS_DISTRICTID")
	@ManyToOne(optional = false)
	private MasDistrict masDistrictid;
	@JoinColumn(name = "SYS_SP_SCHEMECATEGORYID", referencedColumnName = "SYS_SP_SCHEMECATEGORYID")
	@ManyToOne(optional = false)
	private SysSpSchemecategory sysSpSchemecategoryid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "spSchememasterid")
	private Collection<SpEmComponents> spEmComponentsCollection;
	@OneToMany(mappedBy = "spSchememasterid")
	private Collection<SmmStockmaster> smmStockmasterCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "spSchememasterid")
	private Collection<SmmMaterialconsumption> smmMaterialconsumptionCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "spSchememasterid")
	private Collection<SpCivilComponents> spCivilComponentsCollection;

	public SpSchememaster() {
	}

	public SpSchememaster(Long spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public SpSchememaster(Long spSchememasterid, String scheme, int spProgramid, Date startdate,
			Date estimatedcompletiondate, long grantAmount, long localCash, long localOther, long communityOther,
			long communityCash, Date editDate, long totalSanctionedCost, Character iscomplete, Date reporttilldate,
			BigDecimal fundReceivedTillLfy, Character isclosed) {
		this.spSchememasterid = spSchememasterid;
		this.scheme = scheme;
		this.spProgramid = spProgramid;
		this.startdate = startdate;
		this.estimatedcompletiondate = estimatedcompletiondate;
		this.grantAmount = grantAmount;
		this.localCash = localCash;
		this.localOther = localOther;
		this.communityOther = communityOther;
		this.communityCash = communityCash;
		this.editDate = editDate;
		this.totalSanctionedCost = totalSanctionedCost;
		this.iscomplete = iscomplete;
		this.reporttilldate = reporttilldate;
		this.fundReceivedTillLfy = fundReceivedTillLfy;
		this.isclosed = isclosed;
	}

	public Long getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(Long spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public int getSpProgramid() {
		return spProgramid;
	}

	public void setSpProgramid(int spProgramid) {
		this.spProgramid = spProgramid;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEstimatedcompletiondate() {
		return estimatedcompletiondate;
	}

	public void setEstimatedcompletiondate(Date estimatedcompletiondate) {
		this.estimatedcompletiondate = estimatedcompletiondate;
	}

	public String getSanctionno() {
		return sanctionno;
	}

	public void setSanctionno(String sanctionno) {
		this.sanctionno = sanctionno;
	}

	public Date getSanctionDate() {
		return sanctionDate;
	}

	public void setSanctionDate(Date sanctionDate) {
		this.sanctionDate = sanctionDate;
	}

	public long getGrantAmount() {
		return grantAmount;
	}

	public void setGrantAmount(long grantAmount) {
		this.grantAmount = grantAmount;
	}

	public long getLocalCash() {
		return localCash;
	}

	public void setLocalCash(long localCash) {
		this.localCash = localCash;
	}

	public long getLocalOther() {
		return localOther;
	}

	public void setLocalOther(long localOther) {
		this.localOther = localOther;
	}

	public long getCommunityOther() {
		return communityOther;
	}

	public void setCommunityOther(long communityOther) {
		this.communityOther = communityOther;
	}

	public long getCommunityCash() {
		return communityCash;
	}

	public void setCommunityCash(long communityCash) {
		this.communityCash = communityCash;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public long getTotalSanctionedCost() {
		return totalSanctionedCost;
	}

	public void setTotalSanctionedCost(long totalSanctionedCost) {
		this.totalSanctionedCost = totalSanctionedCost;
	}

	public Character getIscomplete() {
		return iscomplete;
	}

	public void setIscomplete(Character iscomplete) {
		this.iscomplete = iscomplete;
	}

	public Date getReporttilldate() {
		return reporttilldate;
	}

	public void setReporttilldate(Date reporttilldate) {
		this.reporttilldate = reporttilldate;
	}

	public BigDecimal getFundReceivedTillLfy() {
		return fundReceivedTillLfy;
	}

	public void setFundReceivedTillLfy(BigDecimal fundReceivedTillLfy) {
		this.fundReceivedTillLfy = fundReceivedTillLfy;
	}

	public Character getIsclosed() {
		return isclosed;
	}

	public void setIsclosed(Character isclosed) {
		this.isclosed = isclosed;
	}

	@XmlTransient
	public Collection<SmmM1reportinfo> getSmmM1reportinfoCollection() {
		return smmM1reportinfoCollection;
	}

	public void setSmmM1reportinfoCollection(Collection<SmmM1reportinfo> smmM1reportinfoCollection) {
		this.smmM1reportinfoCollection = smmM1reportinfoCollection;
	}

	public MasDistrict getMasDistrictid() {
		return masDistrictid;
	}

	public void setMasDistrictid(MasDistrict masDistrictid) {
		this.masDistrictid = masDistrictid;
	}

	public SysSpSchemecategory getSysSpSchemecategoryid() {
		return sysSpSchemecategoryid;
	}

	public void setSysSpSchemecategoryid(SysSpSchemecategory sysSpSchemecategoryid) {
		this.sysSpSchemecategoryid = sysSpSchemecategoryid;
	}

	@XmlTransient
	public Collection<SpEmComponents> getSpEmComponentsCollection() {
		return spEmComponentsCollection;
	}

	public void setSpEmComponentsCollection(Collection<SpEmComponents> spEmComponentsCollection) {
		this.spEmComponentsCollection = spEmComponentsCollection;
	}

	@XmlTransient
	public Collection<SmmStockmaster> getSmmStockmasterCollection() {
		return smmStockmasterCollection;
	}

	public void setSmmStockmasterCollection(Collection<SmmStockmaster> smmStockmasterCollection) {
		this.smmStockmasterCollection = smmStockmasterCollection;
	}

	@XmlTransient
	public Collection<SmmMaterialconsumption> getSmmMaterialconsumptionCollection() {
		return smmMaterialconsumptionCollection;
	}

	public void setSmmMaterialconsumptionCollection(
			Collection<SmmMaterialconsumption> smmMaterialconsumptionCollection) {
		this.smmMaterialconsumptionCollection = smmMaterialconsumptionCollection;
	}

	@XmlTransient
	public Collection<SpCivilComponents> getSpCivilComponentsCollection() {
		return spCivilComponentsCollection;
	}

	public void setSpCivilComponentsCollection(Collection<SpCivilComponents> spCivilComponentsCollection) {
		this.spCivilComponentsCollection = spCivilComponentsCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (spSchememasterid != null ? spSchememasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SpSchememaster)) {
			return false;
		}
		SpSchememaster other = (SpSchememaster) object;
		if ((this.spSchememasterid == null && other.spSchememasterid != null)
				|| (this.spSchememasterid != null && !this.spSchememasterid.equals(other.spSchememasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SpSchememaster[ spSchememasterid=" + spSchememasterid + " ]";
	}

}
