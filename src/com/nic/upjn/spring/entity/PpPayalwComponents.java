/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;

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
@Table(name = "PP_PAYALW_COMPONENTS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpPayalwComponents.findAll", query = "SELECT p FROM PpPayalwComponents p"),
		@NamedQuery(name = "PpPayalwComponents.findByPpPayalwComponentid", query = "SELECT p FROM PpPayalwComponents p WHERE p.ppPayalwComponentid = :ppPayalwComponentid"),
		@NamedQuery(name = "PpPayalwComponents.findByComponentpercentvalue", query = "SELECT p FROM PpPayalwComponents p WHERE p.componentpercentvalue = :componentpercentvalue") })
public class PpPayalwComponents implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_PAYALW_COMPONENTID")
	private Integer ppPayalwComponentid;
	@Basic(optional = false)
	@Column(name = "COMPONENTPERCENTVALUE")
	private int componentpercentvalue;
	@JoinColumn(name = "PP_PAYALW_MASTERID", referencedColumnName = "PP_PAYALWMASTERID")
	@ManyToOne(optional = false)
	private PpPayalwmaster ppPayalwMasterid;
	@JoinColumn(name = "PP_RULEMASTERID", referencedColumnName = "PP_RULEMASTERID")
	@ManyToOne(optional = false)
	private PpRulemaster ppRulemasterid;

	public PpPayalwComponents() {
	}

	public PpPayalwComponents(Integer ppPayalwComponentid) {
		this.ppPayalwComponentid = ppPayalwComponentid;
	}

	public PpPayalwComponents(Integer ppPayalwComponentid, int componentpercentvalue) {
		this.ppPayalwComponentid = ppPayalwComponentid;
		this.componentpercentvalue = componentpercentvalue;
	}

	public Integer getPpPayalwComponentid() {
		return ppPayalwComponentid;
	}

	public void setPpPayalwComponentid(Integer ppPayalwComponentid) {
		this.ppPayalwComponentid = ppPayalwComponentid;
	}

	public int getComponentpercentvalue() {
		return componentpercentvalue;
	}

	public void setComponentpercentvalue(int componentpercentvalue) {
		this.componentpercentvalue = componentpercentvalue;
	}

	public PpPayalwmaster getPpPayalwMasterid() {
		return ppPayalwMasterid;
	}

	public void setPpPayalwMasterid(PpPayalwmaster ppPayalwMasterid) {
		this.ppPayalwMasterid = ppPayalwMasterid;
	}

	public PpRulemaster getPpRulemasterid() {
		return ppRulemasterid;
	}

	public void setPpRulemasterid(PpRulemaster ppRulemasterid) {
		this.ppRulemasterid = ppRulemasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppPayalwComponentid != null ? ppPayalwComponentid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpPayalwComponents)) {
			return false;
		}
		PpPayalwComponents other = (PpPayalwComponents) object;
		if ((this.ppPayalwComponentid == null && other.ppPayalwComponentid != null)
				|| (this.ppPayalwComponentid != null && !this.ppPayalwComponentid.equals(other.ppPayalwComponentid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpPayalwComponents[ ppPayalwComponentid=" + ppPayalwComponentid + " ]";
	}

}
