/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;


import java.io.Serializable;
import java.util.Collection;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_PAYALWMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpPayalwmaster.findAll", query = "SELECT p FROM PpPayalwmaster p"),
		@NamedQuery(name = "PpPayalwmaster.findByPpPayalwmasterid", query = "SELECT p FROM PpPayalwmaster p WHERE p.ppPayalwmasterid = :ppPayalwmasterid") })
public class PpPayalwmaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_PAYALWMASTERID")
	private Integer ppPayalwmasterid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppPayalwmasterid")
	private Collection<PpRulemaster> ppRulemasterCollection;
	@JoinColumn(name = "PAYALWHEADID", referencedColumnName = "PAYALWHEADID")
	@ManyToOne(optional = false)
	private PpPayalwhead payalwheadid;
	@JoinColumn(name = "SYS_PAYCATEGORYID", referencedColumnName = "SYS_PAYCATEGORYID")
	@ManyToOne(optional = false)
	private SysPaycategory sysPaycategoryid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppPayalwMasterid")
	private Collection<PpPayalwComponents> ppPayalwComponentsCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppPayalwmasterid")
	private Collection<PpEmpalwcontroller> ppEmpalwcontrollerCollection;

	public PpPayalwmaster() {
	}

	public PpPayalwmaster(Integer ppPayalwmasterid) {
		this.ppPayalwmasterid = ppPayalwmasterid;
	}

	public Integer getPpPayalwmasterid() {
		return ppPayalwmasterid;
	}

	public void setPpPayalwmasterid(Integer ppPayalwmasterid) {
		this.ppPayalwmasterid = ppPayalwmasterid;
	}

	@XmlTransient
	public Collection<PpRulemaster> getPpRulemasterCollection() {
		return ppRulemasterCollection;
	}

	public void setPpRulemasterCollection(Collection<PpRulemaster> ppRulemasterCollection) {
		this.ppRulemasterCollection = ppRulemasterCollection;
	}

	public PpPayalwhead getPayalwheadid() {
		return payalwheadid;
	}

	public void setPayalwheadid(PpPayalwhead payalwheadid) {
		this.payalwheadid = payalwheadid;
	}

	public SysPaycategory getSysPaycategoryid() {
		return sysPaycategoryid;
	}

	public void setSysPaycategoryid(SysPaycategory sysPaycategoryid) {
		this.sysPaycategoryid = sysPaycategoryid;
	}

	@XmlTransient
	public Collection<PpPayalwComponents> getPpPayalwComponentsCollection() {
		return ppPayalwComponentsCollection;
	}

	public void setPpPayalwComponentsCollection(Collection<PpPayalwComponents> ppPayalwComponentsCollection) {
		this.ppPayalwComponentsCollection = ppPayalwComponentsCollection;
	}

	@XmlTransient
	public Collection<PpEmpalwcontroller> getPpEmpalwcontrollerCollection() {
		return ppEmpalwcontrollerCollection;
	}

	public void setPpEmpalwcontrollerCollection(Collection<PpEmpalwcontroller> ppEmpalwcontrollerCollection) {
		this.ppEmpalwcontrollerCollection = ppEmpalwcontrollerCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppPayalwmasterid != null ? ppPayalwmasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpPayalwmaster)) {
			return false;
		}
		PpPayalwmaster other = (PpPayalwmaster) object;
		if ((this.ppPayalwmasterid == null && other.ppPayalwmasterid != null)
				|| (this.ppPayalwmasterid != null && !this.ppPayalwmasterid.equals(other.ppPayalwmasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpPayalwmaster[ ppPayalwmasterid=" + ppPayalwmasterid + " ]";
	}

}
