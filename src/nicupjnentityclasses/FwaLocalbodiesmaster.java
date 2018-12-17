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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "FWA_LOCALBODIESMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FwaLocalbodiesmaster.findAll", query = "SELECT f FROM FwaLocalbodiesmaster f"),
		@NamedQuery(name = "FwaLocalbodiesmaster.findByFwaLocalbodiesmasterid", query = "SELECT f FROM FwaLocalbodiesmaster f WHERE f.fwaLocalbodiesmasterid = :fwaLocalbodiesmasterid"),
		@NamedQuery(name = "FwaLocalbodiesmaster.findByLocalbody", query = "SELECT f FROM FwaLocalbodiesmaster f WHERE f.localbody = :localbody") })
public class FwaLocalbodiesmaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "FWA_LOCALBODIESMASTERID")
	private Long fwaLocalbodiesmasterid;
	@Basic(optional = false)
	@Column(name = "LOCALBODY")
	private String localbody;
	@JoinColumn(name = "RM_OFFICEID", referencedColumnName = "RM_OFFICEID")
	@ManyToOne(optional = false)
	private RmOffice rmOfficeid;

	public FwaLocalbodiesmaster() {
	}

	public FwaLocalbodiesmaster(Long fwaLocalbodiesmasterid) {
		this.fwaLocalbodiesmasterid = fwaLocalbodiesmasterid;
	}

	public FwaLocalbodiesmaster(Long fwaLocalbodiesmasterid, String localbody) {
		this.fwaLocalbodiesmasterid = fwaLocalbodiesmasterid;
		this.localbody = localbody;
	}

	public Long getFwaLocalbodiesmasterid() {
		return fwaLocalbodiesmasterid;
	}

	public void setFwaLocalbodiesmasterid(Long fwaLocalbodiesmasterid) {
		this.fwaLocalbodiesmasterid = fwaLocalbodiesmasterid;
	}

	public String getLocalbody() {
		return localbody;
	}

	public void setLocalbody(String localbody) {
		this.localbody = localbody;
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
		hash += (fwaLocalbodiesmasterid != null ? fwaLocalbodiesmasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof FwaLocalbodiesmaster)) {
			return false;
		}
		FwaLocalbodiesmaster other = (FwaLocalbodiesmaster) object;
		if ((this.fwaLocalbodiesmasterid == null && other.fwaLocalbodiesmasterid != null)
				|| (this.fwaLocalbodiesmasterid != null
						&& !this.fwaLocalbodiesmasterid.equals(other.fwaLocalbodiesmasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.FwaLocalbodiesmaster[ fwaLocalbodiesmasterid=" + fwaLocalbodiesmasterid + " ]";
	}

}
