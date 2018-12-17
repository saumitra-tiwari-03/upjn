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
@Table(name = "SP_COMPONENTMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SpComponentmaster.findAll", query = "SELECT s FROM SpComponentmaster s"),
		@NamedQuery(name = "SpComponentmaster.findBySpComponentmasterid", query = "SELECT s FROM SpComponentmaster s WHERE s.spComponentmasterid = :spComponentmasterid"),
		@NamedQuery(name = "SpComponentmaster.findByComponent", query = "SELECT s FROM SpComponentmaster s WHERE s.component = :component"),
		@NamedQuery(name = "SpComponentmaster.findByRemark", query = "SELECT s FROM SpComponentmaster s WHERE s.remark = :remark"),
		@NamedQuery(name = "SpComponentmaster.findByInputtype", query = "SELECT s FROM SpComponentmaster s WHERE s.inputtype = :inputtype"),
		@NamedQuery(name = "SpComponentmaster.findByUnit", query = "SELECT s FROM SpComponentmaster s WHERE s.unit = :unit") })
public class SpComponentmaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SP_COMPONENTMASTERID")
	private Integer spComponentmasterid;
	@Basic(optional = false)
	@Column(name = "COMPONENT")
	private String component;
	@Column(name = "REMARK")
	private String remark;
	@Basic(optional = false)
	@Column(name = "INPUTTYPE")
	private String inputtype;
	@Column(name = "UNIT")
	private String unit;
	@JoinColumn(name = "SP_COMPONENTGROUPID", referencedColumnName = "SP_COMPONENTGROUPID")
	@ManyToOne(optional = false)
	private SpComponentgroup spComponentgroupid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "spComponentmasterid")
	private Collection<SpCivilComponents> spCivilComponentsCollection;

	public SpComponentmaster() {
	}

	public SpComponentmaster(Integer spComponentmasterid) {
		this.spComponentmasterid = spComponentmasterid;
	}

	public SpComponentmaster(Integer spComponentmasterid, String component, String inputtype) {
		this.spComponentmasterid = spComponentmasterid;
		this.component = component;
		this.inputtype = inputtype;
	}

	public Integer getSpComponentmasterid() {
		return spComponentmasterid;
	}

	public void setSpComponentmasterid(Integer spComponentmasterid) {
		this.spComponentmasterid = spComponentmasterid;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getInputtype() {
		return inputtype;
	}

	public void setInputtype(String inputtype) {
		this.inputtype = inputtype;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public SpComponentgroup getSpComponentgroupid() {
		return spComponentgroupid;
	}

	public void setSpComponentgroupid(SpComponentgroup spComponentgroupid) {
		this.spComponentgroupid = spComponentgroupid;
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
		hash += (spComponentmasterid != null ? spComponentmasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SpComponentmaster)) {
			return false;
		}
		SpComponentmaster other = (SpComponentmaster) object;
		if ((this.spComponentmasterid == null && other.spComponentmasterid != null)
				|| (this.spComponentmasterid != null && !this.spComponentmasterid.equals(other.spComponentmasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SpComponentmaster[ spComponentmasterid=" + spComponentmasterid + " ]";
	}

}
