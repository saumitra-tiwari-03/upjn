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
@Table(name = "PP_RULEMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpRulemaster.findAll", query = "SELECT p FROM PpRulemaster p"),
		@NamedQuery(name = "PpRulemaster.findByPpRulemasterid", query = "SELECT p FROM PpRulemaster p WHERE p.ppRulemasterid = :ppRulemasterid"),
		@NamedQuery(name = "PpRulemaster.findByRuleorderno", query = "SELECT p FROM PpRulemaster p WHERE p.ruleorderno = :ruleorderno"),
		@NamedQuery(name = "PpRulemaster.findByRuleorderdate", query = "SELECT p FROM PpRulemaster p WHERE p.ruleorderdate = :ruleorderdate"),
		@NamedQuery(name = "PpRulemaster.findByDateofeffect", query = "SELECT p FROM PpRulemaster p WHERE p.dateofeffect = :dateofeffect"),
		@NamedQuery(name = "PpRulemaster.findByIstowncatbased", query = "SELECT p FROM PpRulemaster p WHERE p.istowncatbased = :istowncatbased"),
		@NamedQuery(name = "PpRulemaster.findByDuedate", query = "SELECT p FROM PpRulemaster p WHERE p.duedate = :duedate"),
		@NamedQuery(name = "PpRulemaster.findByGpfdate", query = "SELECT p FROM PpRulemaster p WHERE p.gpfdate = :gpfdate"),
		@NamedQuery(name = "PpRulemaster.findByCashdate", query = "SELECT p FROM PpRulemaster p WHERE p.cashdate = :cashdate"),
		@NamedQuery(name = "PpRulemaster.findByUpdatedate", query = "SELECT p FROM PpRulemaster p WHERE p.updatedate = :updatedate") })
public class PpRulemaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_RULEMASTERID")
	private Integer ppRulemasterid;
	@Basic(optional = false)
	@Column(name = "RULEORDERNO")
	private String ruleorderno;
	@Basic(optional = false)
	@Column(name = "RULEORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ruleorderdate;
	@Basic(optional = false)
	@Column(name = "DATEOFEFFECT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofeffect;
	@Basic(optional = false)
	@Column(name = "ISTOWNCATBASED")
	private Character istowncatbased;
	@Column(name = "DUEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date duedate;
	@Column(name = "GPFDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date gpfdate;
	@Column(name = "CASHDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date cashdate;
	@Column(name = "UPDATEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedate;
	@JoinColumn(name = "PP_PAYALWMASTERID", referencedColumnName = "PP_PAYALWMASTERID")
	@ManyToOne(optional = false)
	private PpPayalwmaster ppPayalwmasterid;
	@JoinColumn(name = "SYS_RULECATEGORYID", referencedColumnName = "SYS_RULECATEGORYID")
	@ManyToOne(optional = false)
	private SysRulecategory sysRulecategoryid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppRulemasterid")
	private Collection<PpPayalwComponents> ppPayalwComponentsCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppRulemasterid")
	private Collection<PpRuledetail> ppRuledetailCollection;

	public PpRulemaster() {
	}

	public PpRulemaster(Integer ppRulemasterid) {
		this.ppRulemasterid = ppRulemasterid;
	}

	public PpRulemaster(Integer ppRulemasterid, String ruleorderno, Date ruleorderdate, Date dateofeffect,
			Character istowncatbased) {
		this.ppRulemasterid = ppRulemasterid;
		this.ruleorderno = ruleorderno;
		this.ruleorderdate = ruleorderdate;
		this.dateofeffect = dateofeffect;
		this.istowncatbased = istowncatbased;
	}

	public Integer getPpRulemasterid() {
		return ppRulemasterid;
	}

	public void setPpRulemasterid(Integer ppRulemasterid) {
		this.ppRulemasterid = ppRulemasterid;
	}

	public String getRuleorderno() {
		return ruleorderno;
	}

	public void setRuleorderno(String ruleorderno) {
		this.ruleorderno = ruleorderno;
	}

	public Date getRuleorderdate() {
		return ruleorderdate;
	}

	public void setRuleorderdate(Date ruleorderdate) {
		this.ruleorderdate = ruleorderdate;
	}

	public Date getDateofeffect() {
		return dateofeffect;
	}

	public void setDateofeffect(Date dateofeffect) {
		this.dateofeffect = dateofeffect;
	}

	public Character getIstowncatbased() {
		return istowncatbased;
	}

	public void setIstowncatbased(Character istowncatbased) {
		this.istowncatbased = istowncatbased;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public Date getGpfdate() {
		return gpfdate;
	}

	public void setGpfdate(Date gpfdate) {
		this.gpfdate = gpfdate;
	}

	public Date getCashdate() {
		return cashdate;
	}

	public void setCashdate(Date cashdate) {
		this.cashdate = cashdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public PpPayalwmaster getPpPayalwmasterid() {
		return ppPayalwmasterid;
	}

	public void setPpPayalwmasterid(PpPayalwmaster ppPayalwmasterid) {
		this.ppPayalwmasterid = ppPayalwmasterid;
	}

	public SysRulecategory getSysRulecategoryid() {
		return sysRulecategoryid;
	}

	public void setSysRulecategoryid(SysRulecategory sysRulecategoryid) {
		this.sysRulecategoryid = sysRulecategoryid;
	}

	@XmlTransient
	public Collection<PpPayalwComponents> getPpPayalwComponentsCollection() {
		return ppPayalwComponentsCollection;
	}

	public void setPpPayalwComponentsCollection(Collection<PpPayalwComponents> ppPayalwComponentsCollection) {
		this.ppPayalwComponentsCollection = ppPayalwComponentsCollection;
	}

	@XmlTransient
	public Collection<PpRuledetail> getPpRuledetailCollection() {
		return ppRuledetailCollection;
	}

	public void setPpRuledetailCollection(Collection<PpRuledetail> ppRuledetailCollection) {
		this.ppRuledetailCollection = ppRuledetailCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppRulemasterid != null ? ppRulemasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpRulemaster)) {
			return false;
		}
		PpRulemaster other = (PpRulemaster) object;
		if ((this.ppRulemasterid == null && other.ppRulemasterid != null)
				|| (this.ppRulemasterid != null && !this.ppRulemasterid.equals(other.ppRulemasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpRulemaster[ ppRulemasterid=" + ppRulemasterid + " ]";
	}

}
