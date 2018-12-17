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
 * 
 */
@Entity
@Table(name = "MAS_STATE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "MasState.findAll", query = "FROM MasState order by statename"),
		@NamedQuery(name = "MasState.findByMasStateid", query = "SELECT m FROM MasState m WHERE m.masStateid = :masStateid"),
		@NamedQuery(name = "MasState.findByStatename", query = "SELECT m FROM MasState m WHERE m.statename = :statename"),
		@NamedQuery(name = "MasState.findByDepartmentname", query = "SELECT m FROM MasState m WHERE m.departmentname = :departmentname"),
		@NamedQuery(name = "MasState.findByCensusstatecode", query = "SELECT m FROM MasState m WHERE m.censusstatecode = :censusstatecode") })
public class MasState implements Serializable {
	private static final long serialVersionUID = 1L;                                                                                                                                                                                                                    
	@Id
	@Basic(optional = false)
	@Column(name = "MAS_STATEID")
	private Long masStateid;
	@Basic(optional = false)
	@Column(name = "STATENAME")
	private String statename;
	@Column(name = "DEPARTMENTNAME")
	private String departmentname;
	@Column(name = "CENSUSSTATECODE")
	private String censusstatecode;
	
	public MasState() {
	}

	public MasState(Long masStateid) {
		this.masStateid = masStateid;
	}

	public MasState(Long masStateid, String statename) {
		this.masStateid = masStateid;
		this.statename = statename;
	}

	public Long getMasStateid() {
		return masStateid;
	}

	public void setMasStateid(Long masStateid) {
		this.masStateid = masStateid;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getCensusstatecode() {
		return censusstatecode;
	}

	public void setCensusstatecode(String censusstatecode) {
		this.censusstatecode = censusstatecode;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (masStateid != null ? masStateid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof MasState)) {
			return false;
		}
		MasState other = (MasState) object;
		if ((this.masStateid == null && other.masStateid != null)
				|| (this.masStateid != null && !this.masStateid.equals(other.masStateid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.MasState[ masStateid=" + masStateid + " ]";
	}

}
