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
@Table(name = "SYS_RULECATEGORY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SysRulecategory.findAll", query = "SELECT s FROM SysRulecategory s"),
		@NamedQuery(name = "SysRulecategory.findBySysRulecategoryid", query = "SELECT s FROM SysRulecategory s WHERE s.sysRulecategoryid = :sysRulecategoryid"),
		@NamedQuery(name = "SysRulecategory.findByRulecategory", query = "SELECT s FROM SysRulecategory s WHERE s.rulecategory = :rulecategory") })
public class SysRulecategory implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SYS_RULECATEGORYID")
	private Short sysRulecategoryid;
	@Basic(optional = false)
	@Column(name = "RULECATEGORY")
	private String rulecategory;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sysRulecategoryid")
	private Collection<PpRulemaster> ppRulemasterCollection;

	public SysRulecategory() {
	}

	public SysRulecategory(Short sysRulecategoryid) {
		this.sysRulecategoryid = sysRulecategoryid;
	}

	public SysRulecategory(Short sysRulecategoryid, String rulecategory) {
		this.sysRulecategoryid = sysRulecategoryid;
		this.rulecategory = rulecategory;
	}

	public Short getSysRulecategoryid() {
		return sysRulecategoryid;
	}

	public void setSysRulecategoryid(Short sysRulecategoryid) {
		this.sysRulecategoryid = sysRulecategoryid;
	}

	public String getRulecategory() {
		return rulecategory;
	}

	public void setRulecategory(String rulecategory) {
		this.rulecategory = rulecategory;
	}

	@XmlTransient
	public Collection<PpRulemaster> getPpRulemasterCollection() {
		return ppRulemasterCollection;
	}

	public void setPpRulemasterCollection(Collection<PpRulemaster> ppRulemasterCollection) {
		this.ppRulemasterCollection = ppRulemasterCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (sysRulecategoryid != null ? sysRulecategoryid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SysRulecategory)) {
			return false;
		}
		SysRulecategory other = (SysRulecategory) object;
		if ((this.sysRulecategoryid == null && other.sysRulecategoryid != null)
				|| (this.sysRulecategoryid != null && !this.sysRulecategoryid.equals(other.sysRulecategoryid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SysRulecategory[ sysRulecategoryid=" + sysRulecategoryid + " ]";
	}

}
