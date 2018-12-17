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
@Table(name = "SP_SECTOR")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SpSector.findAll", query = "SELECT s FROM SpSector s"),
		@NamedQuery(name = "SpSector.findBySpSectorid", query = "SELECT s FROM SpSector s WHERE s.spSectorid = :spSectorid"),
		@NamedQuery(name = "SpSector.findBySector", query = "SELECT s FROM SpSector s WHERE s.sector = :sector"),
		@NamedQuery(name = "SpSector.findByRemark", query = "SELECT s FROM SpSector s WHERE s.remark = :remark"),
		@NamedQuery(name = "SpSector.findByIsactive", query = "SELECT s FROM SpSector s WHERE s.isactive = :isactive") })
public class SpSector implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SP_SECTORID")
	private Long spSectorid;
	@Basic(optional = false)
	@Column(name = "SECTOR")
	private String sector;
	@Column(name = "REMARK")
	private String remark;
	@Basic(optional = false)
	@Column(name = "ISACTIVE")
	private Character isactive;
	@JoinColumn(name = "SP_PROGRAMGROUPID", referencedColumnName = "SP_PROGRAMGROUPID")
	@ManyToOne(optional = false)
	private SpProgramgroup spProgramgroupid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "spSectorid")
	private Collection<SpProgram> spProgramCollection;

	public SpSector() {
	}

	public SpSector(Long spSectorid) {
		this.spSectorid = spSectorid;
	}

	public SpSector(Long spSectorid, String sector, Character isactive) {
		this.spSectorid = spSectorid;
		this.sector = sector;
		this.isactive = isactive;
	}

	public Long getSpSectorid() {
		return spSectorid;
	}

	public void setSpSectorid(Long spSectorid) {
		this.spSectorid = spSectorid;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Character getIsactive() {
		return isactive;
	}

	public void setIsactive(Character isactive) {
		this.isactive = isactive;
	}

	public SpProgramgroup getSpProgramgroupid() {
		return spProgramgroupid;
	}

	public void setSpProgramgroupid(SpProgramgroup spProgramgroupid) {
		this.spProgramgroupid = spProgramgroupid;
	}

	@XmlTransient
	public Collection<SpProgram> getSpProgramCollection() {
		return spProgramCollection;
	}

	public void setSpProgramCollection(Collection<SpProgram> spProgramCollection) {
		this.spProgramCollection = spProgramCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (spSectorid != null ? spSectorid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SpSector)) {
			return false;
		}
		SpSector other = (SpSector) object;
		if ((this.spSectorid == null && other.spSectorid != null)
				|| (this.spSectorid != null && !this.spSectorid.equals(other.spSectorid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SpSector[ spSectorid=" + spSectorid + " ]";
	}

}
