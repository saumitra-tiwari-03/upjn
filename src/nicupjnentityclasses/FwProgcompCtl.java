/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

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
@Table(name = "FW_PROGCOMP_CTL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FwProgcompCtl.findAll", query = "SELECT f FROM FwProgcompCtl f"),
		@NamedQuery(name = "FwProgcompCtl.findByFwProgcompCtlid", query = "SELECT f FROM FwProgcompCtl f WHERE f.fwProgcompCtlid = :fwProgcompCtlid"),
		@NamedQuery(name = "FwProgcompCtl.findByMonth", query = "SELECT f FROM FwProgcompCtl f WHERE f.month = :month"),
		@NamedQuery(name = "FwProgcompCtl.findByYear", query = "SELECT f FROM FwProgcompCtl f WHERE f.year = :year"),
		@NamedQuery(name = "FwProgcompCtl.findByIslocked", query = "SELECT f FROM FwProgcompCtl f WHERE f.islocked = :islocked"),
		@NamedQuery(name = "FwProgcompCtl.findByIsobenable", query = "SELECT f FROM FwProgcompCtl f WHERE f.isobenable = :isobenable") })
public class FwProgcompCtl implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "FW_PROGCOMP_CTLID")
	private Long fwProgcompCtlid;
	@Basic(optional = false)
	@Column(name = "MONTH")
	private short month;
	@Basic(optional = false)
	@Column(name = "YEAR")
	private int year;
	@Basic(optional = false)
	@Column(name = "ISLOCKED")
	private Character islocked;
	@Column(name = "ISOBENABLE")
	private Character isobenable;

	public FwProgcompCtl() {
	}

	public FwProgcompCtl(Long fwProgcompCtlid) {
		this.fwProgcompCtlid = fwProgcompCtlid;
	}

	public FwProgcompCtl(Long fwProgcompCtlid, short month, int year, Character islocked) {
		this.fwProgcompCtlid = fwProgcompCtlid;
		this.month = month;
		this.year = year;
		this.islocked = islocked;
	}

	public Long getFwProgcompCtlid() {
		return fwProgcompCtlid;
	}

	public void setFwProgcompCtlid(Long fwProgcompCtlid) {
		this.fwProgcompCtlid = fwProgcompCtlid;
	}

	public short getMonth() {
		return month;
	}

	public void setMonth(short month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Character getIslocked() {
		return islocked;
	}

	public void setIslocked(Character islocked) {
		this.islocked = islocked;
	}

	public Character getIsobenable() {
		return isobenable;
	}

	public void setIsobenable(Character isobenable) {
		this.isobenable = isobenable;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (fwProgcompCtlid != null ? fwProgcompCtlid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof FwProgcompCtl)) {
			return false;
		}
		FwProgcompCtl other = (FwProgcompCtl) object;
		if ((this.fwProgcompCtlid == null && other.fwProgcompCtlid != null)
				|| (this.fwProgcompCtlid != null && !this.fwProgcompCtlid.equals(other.fwProgcompCtlid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.FwProgcompCtl[ fwProgcompCtlid=" + fwProgcompCtlid + " ]";
	}

}
