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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "SYS_FINANCEYEAR")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SysFinanceyear.findAll", query = "FROM SysFinanceyear ORDER BY startyear"),
		@NamedQuery(name = "SysFinanceyear.findByStartyear", query = "SELECT s FROM SysFinanceyear s WHERE s.startyear = :startyear"),
		@NamedQuery(name = "SysFinanceyear.findByFinyear", query = "SELECT s FROM SysFinanceyear s WHERE s.finyear = :finyear") })
public class SysFinanceyear implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "STARTYEAR")
	private String startyear;
	@Column(name = "FINYEAR")
	private String finyear;

	public SysFinanceyear() {
	}

	public SysFinanceyear(String startyear) {
		this.startyear = startyear;
	}

	public String getStartyear() {
		return startyear;
	}

	public void setStartyear(String startyear) {
		this.startyear = startyear;
	}

	public String getFinyear() {
		return finyear;
	}

	public void setFinyear(String finyear) {
		this.finyear = finyear;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (startyear != null ? startyear.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SysFinanceyear)) {
			return false;
		}
		SysFinanceyear other = (SysFinanceyear) object;
		if ((this.startyear == null && other.startyear != null)
				|| (this.startyear != null && !this.startyear.equals(other.startyear))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SysFinanceyear[ startyear=" + startyear + " ]";
	}

}
