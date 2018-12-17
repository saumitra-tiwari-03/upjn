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
@Table(name = "MAS_OFFICELEVEL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "MasOfficelevel.findAll", query = "SELECT m FROM MasOfficelevel m"),
		@NamedQuery(name = "MasOfficelevel.findByMasOfficelevelid", query = "FROM MasOfficelevel  WHERE masOfficelevelid = ?"),
		@NamedQuery(name = "MasOfficelevel.findByOfficelevel", query = "SELECT m FROM MasOfficelevel m WHERE m.officelevel = :officelevel") })
public class MasOfficelevel implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "MAS_OFFICELEVELID")
	private int masOfficelevelid;
	public void setMasOfficelevelid(int masOfficelevelid) {
		this.masOfficelevelid = masOfficelevelid;
	}

	@Basic(optional = false)
	@Column(name = "OFFICELEVEL")
	private String officelevel;
	
	private String parentofficelevel;
	
	public String getParentofficelevel() {
		return parentofficelevel;
	}

	public void setParentofficelevel(String parentofficelevel) {
		this.parentofficelevel = parentofficelevel;
	}

	public MasOfficelevel() {
	}

	public MasOfficelevel(Integer masOfficelevelid) {
		this.masOfficelevelid = masOfficelevelid;
	}

	public MasOfficelevel(Integer masOfficelevelid, String officelevel) {
		this.masOfficelevelid = masOfficelevelid;
		this.officelevel = officelevel;
	}

	public Integer getMasOfficelevelid() {
		return masOfficelevelid;
	}

	public void setMasOfficelevelid(Integer masOfficelevelid) {
		this.masOfficelevelid = masOfficelevelid;
	}

	public String getOfficelevel() {
		return officelevel;
	}

	public void setOfficelevel(String officelevel) {
		this.officelevel = officelevel;
	}

	/*@XmlTransient
	public Collection<RmOffice> getRmOfficeCollection() {
		return rmOfficeCollection;
	}

	public void setRmOfficeCollection(Collection<RmOffice> rmOfficeCollection) {
		this.rmOfficeCollection = rmOfficeCollection;
	}

	@XmlTransient
	public Collection<MasOfficelevel> getMasOfficelevelCollection() {
		return masOfficelevelCollection;
	}

	public void setMasOfficelevelCollection(Collection<MasOfficelevel> masOfficelevelCollection) {
		this.masOfficelevelCollection = masOfficelevelCollection;
	}

	public MasOfficelevel getParentofficelevel() {
		return parentofficelevel;
	}

	public void setParentofficelevel(MasOfficelevel parentofficelevel) {
		this.parentofficelevel = parentofficelevel;
	}*/

	/*@Override
	public int hashCode() {
		int hash = 0;
		hash += (masOfficelevelid != null ? masOfficelevelid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof MasOfficelevel)) {
			return false;
		}
		MasOfficelevel other = (MasOfficelevel) object;
		if ((this.masOfficelevelid == null && other.masOfficelevelid != null)
				|| (this.masOfficelevelid != null && !this.masOfficelevelid.equals(other.masOfficelevelid))) {
			return false;
		}
		return true;
	}
*/
	@Override
	public String toString() {
		return "nicupjnentityclasses.MasOfficelevel[ masOfficelevelid=" + masOfficelevelid + " ]";
	}

}
