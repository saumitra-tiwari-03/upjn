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
@Table(name = "MAS_MARITALSTATUS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "MasMaritalstatus.findAll", query = "SELECT m FROM MasMaritalstatus m"),
		@NamedQuery(name = "MasMaritalstatus.findByMaritalstatus", query = "SELECT m FROM MasMaritalstatus m WHERE m.maritalstatus = :maritalstatus"),
		@NamedQuery(name = "MasMaritalstatus.findByMasMaritalstatusid", query = "SELECT m FROM MasMaritalstatus m WHERE m.masMaritalstatusid = :masMaritalstatusid") })
public class MasMaritalstatus implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "MARITALSTATUS")
	private String maritalstatus;
	@Id
	@Basic(optional = false)
	@Column(name = "MAS_MARITALSTATUSID")
	private Short masMaritalstatusid;

	public MasMaritalstatus() {
	}

	public MasMaritalstatus(Short masMaritalstatusid) {
		this.masMaritalstatusid = masMaritalstatusid;
	}

	public MasMaritalstatus(Short masMaritalstatusid, String maritalstatus) {
		this.masMaritalstatusid = masMaritalstatusid;
		this.maritalstatus = maritalstatus;
	}

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public Short getMasMaritalstatusid() {
		return masMaritalstatusid;
	}

	public void setMasMaritalstatusid(Short masMaritalstatusid) {
		this.masMaritalstatusid = masMaritalstatusid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (masMaritalstatusid != null ? masMaritalstatusid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof MasMaritalstatus)) {
			return false;
		}
		MasMaritalstatus other = (MasMaritalstatus) object;
		if ((this.masMaritalstatusid == null && other.masMaritalstatusid != null)
				|| (this.masMaritalstatusid != null && !this.masMaritalstatusid.equals(other.masMaritalstatusid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.MasMaritalstatus[ masMaritalstatusid=" + masMaritalstatusid + " ]";
	}

}
