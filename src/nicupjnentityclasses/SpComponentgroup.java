/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

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
@Table(name = "SP_COMPONENTGROUP")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SpComponentgroup.findAll", query = "SELECT s FROM SpComponentgroup s"),
		@NamedQuery(name = "SpComponentgroup.findBySpComponentgroupid", query = "SELECT s FROM SpComponentgroup s WHERE s.spComponentgroupid = :spComponentgroupid"),
		@NamedQuery(name = "SpComponentgroup.findByName", query = "SELECT s FROM SpComponentgroup s WHERE s.name = :name"),
		@NamedQuery(name = "SpComponentgroup.findByRemark", query = "SELECT s FROM SpComponentgroup s WHERE s.remark = :remark") })
public class SpComponentgroup implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SP_COMPONENTGROUPID")
	private Integer spComponentgroupid;
	@Basic(optional = false)
	@Column(name = "NAME")
	private String name;
	@Column(name = "REMARK")
	private String remark;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "spComponentgroupid")
	private Collection<SpComponentmaster> spComponentmasterCollection;

	public SpComponentgroup() {
	}

	public SpComponentgroup(Integer spComponentgroupid) {
		this.spComponentgroupid = spComponentgroupid;
	}

	public SpComponentgroup(Integer spComponentgroupid, String name) {
		this.spComponentgroupid = spComponentgroupid;
		this.name = name;
	}

	public Integer getSpComponentgroupid() {
		return spComponentgroupid;
	}

	public void setSpComponentgroupid(Integer spComponentgroupid) {
		this.spComponentgroupid = spComponentgroupid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@XmlTransient
	public Collection<SpComponentmaster> getSpComponentmasterCollection() {
		return spComponentmasterCollection;
	}

	public void setSpComponentmasterCollection(Collection<SpComponentmaster> spComponentmasterCollection) {
		this.spComponentmasterCollection = spComponentmasterCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (spComponentgroupid != null ? spComponentgroupid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SpComponentgroup)) {
			return false;
		}
		SpComponentgroup other = (SpComponentgroup) object;
		if ((this.spComponentgroupid == null && other.spComponentgroupid != null)
				|| (this.spComponentgroupid != null && !this.spComponentgroupid.equals(other.spComponentgroupid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SpComponentgroup[ spComponentgroupid=" + spComponentgroupid + " ]";
	}

}
