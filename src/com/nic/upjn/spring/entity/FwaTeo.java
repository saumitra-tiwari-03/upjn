/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "FWA_TEO")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FwaTeo.findAll", query = "SELECT f FROM FwaTeo f"),
		@NamedQuery(name = "FwaTeo.findByFwaTeoid", query = "SELECT f FROM FwaTeo f WHERE f.fwaTeoid = :fwaTeoid"),
		@NamedQuery(name = "FwaTeo.findByTeoNo", query = "SELECT f FROM FwaTeo f WHERE f.teoNo = :teoNo"),
		@NamedQuery(name = "FwaTeo.findByTeoDate", query = "SELECT f FROM FwaTeo f WHERE f.teoDate = :teoDate"),
		@NamedQuery(name = "FwaTeo.findByParticular", query = "SELECT f FROM FwaTeo f WHERE f.particular = :particular"),
		@NamedQuery(name = "FwaTeo.findByIslocked", query = "SELECT f FROM FwaTeo f WHERE f.islocked = :islocked") })
public class FwaTeo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "FWA_TEOID")
	private Long fwaTeoid;
	@Basic(optional = false)
	@Column(name = "TEO_NO")
	private String teoNo;
	@Basic(optional = false)
	@Column(name = "TEO_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date teoDate;
	@Basic(optional = false)
	@Column(name = "PARTICULAR")
	private String particular;
	@Basic(optional = false)
	@Column(name = "ISLOCKED")
	private Character islocked;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fwaTeoid")
	private Collection<FwaTeoTran> fwaTeoTranCollection;
	@JoinColumn(name = "FWA_BILLMASTERID", referencedColumnName = "FWA_BILLMASTERID")
	@ManyToOne
	private FwaBillmaster fwaBillmasterid;
	@JoinColumn(name = "RM_OFFICEID", referencedColumnName = "RM_OFFICEID")
	@ManyToOne(optional = false)
	private RmOffice rmOfficeid;

	public FwaTeo() {
	}

	public FwaTeo(Long fwaTeoid) {
		this.fwaTeoid = fwaTeoid;
	}

	public FwaTeo(Long fwaTeoid, String teoNo, Date teoDate, String particular, Character islocked) {
		this.fwaTeoid = fwaTeoid;
		this.teoNo = teoNo;
		this.teoDate = teoDate;
		this.particular = particular;
		this.islocked = islocked;
	}

	public Long getFwaTeoid() {
		return fwaTeoid;
	}

	public void setFwaTeoid(Long fwaTeoid) {
		this.fwaTeoid = fwaTeoid;
	}

	public String getTeoNo() {
		return teoNo;
	}

	public void setTeoNo(String teoNo) {
		this.teoNo = teoNo;
	}

	public Date getTeoDate() {
		return teoDate;
	}

	public void setTeoDate(Date teoDate) {
		this.teoDate = teoDate;
	}

	public String getParticular() {
		return particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public Character getIslocked() {
		return islocked;
	}

	public void setIslocked(Character islocked) {
		this.islocked = islocked;
	}

	@XmlTransient
	public Collection<FwaTeoTran> getFwaTeoTranCollection() {
		return fwaTeoTranCollection;
	}

	public void setFwaTeoTranCollection(Collection<FwaTeoTran> fwaTeoTranCollection) {
		this.fwaTeoTranCollection = fwaTeoTranCollection;
	}

	public FwaBillmaster getFwaBillmasterid() {
		return fwaBillmasterid;
	}

	public void setFwaBillmasterid(FwaBillmaster fwaBillmasterid) {
		this.fwaBillmasterid = fwaBillmasterid;
	}

	public RmOffice getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(RmOffice rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (fwaTeoid != null ? fwaTeoid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof FwaTeo)) {
			return false;
		}
		FwaTeo other = (FwaTeo) object;
		if ((this.fwaTeoid == null && other.fwaTeoid != null)
				|| (this.fwaTeoid != null && !this.fwaTeoid.equals(other.fwaTeoid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.FwaTeo[ fwaTeoid=" + fwaTeoid + " ]";
	}

}
