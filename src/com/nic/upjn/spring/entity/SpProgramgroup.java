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
@Table(name = "SP_PROGRAMGROUP")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SpProgramgroup.findAll", query = "SELECT s FROM SpProgramgroup s"),
		@NamedQuery(name = "SpProgramgroup.findBySpProgramgroupid", query = "SELECT s FROM SpProgramgroup s WHERE s.spProgramgroupid = :spProgramgroupid"),
		@NamedQuery(name = "SpProgramgroup.findByProgramgroupname", query = "SELECT s FROM SpProgramgroup s WHERE s.programgroupname = :programgroupname"),
		@NamedQuery(name = "SpProgramgroup.findByRemark", query = "SELECT s FROM SpProgramgroup s WHERE s.remark = :remark") })
public class SpProgramgroup implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SP_PROGRAMGROUPID")
	private Long spProgramgroupid;
	@Basic(optional = false)
	@Column(name = "PROGRAMGROUPNAME")
	private String programgroupname;
	@Column(name = "REMARK")
	private String remark;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "spProgramgroupid")
	private Collection<SpSector> spSectorCollection;

	public SpProgramgroup() {
	}

	public SpProgramgroup(Long spProgramgroupid) {
		this.spProgramgroupid = spProgramgroupid;
	}

	public SpProgramgroup(Long spProgramgroupid, String programgroupname) {
		this.spProgramgroupid = spProgramgroupid;
		this.programgroupname = programgroupname;
	}

	public Long getSpProgramgroupid() {
		return spProgramgroupid;
	}

	public void setSpProgramgroupid(Long spProgramgroupid) {
		this.spProgramgroupid = spProgramgroupid;
	}

	public String getProgramgroupname() {
		return programgroupname;
	}

	public void setProgramgroupname(String programgroupname) {
		this.programgroupname = programgroupname;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@XmlTransient
	public Collection<SpSector> getSpSectorCollection() {
		return spSectorCollection;
	}

	public void setSpSectorCollection(Collection<SpSector> spSectorCollection) {
		this.spSectorCollection = spSectorCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (spProgramgroupid != null ? spProgramgroupid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SpProgramgroup)) {
			return false;
		}
		SpProgramgroup other = (SpProgramgroup) object;
		if ((this.spProgramgroupid == null && other.spProgramgroupid != null)
				|| (this.spProgramgroupid != null && !this.spProgramgroupid.equals(other.spProgramgroupid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SpProgramgroup[ spProgramgroupid=" + spProgramgroupid + " ]";
	}

}
