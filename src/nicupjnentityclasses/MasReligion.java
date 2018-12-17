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
@Table(name = "MAS_RELIGION")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "MasReligion.findAll", query = "SELECT m FROM MasReligion m"),
		@NamedQuery(name = "MasReligion.findByReligion", query = "SELECT m FROM MasReligion m WHERE m.religion = :religion"),
		@NamedQuery(name = "MasReligion.findByMasReligionid", query = "SELECT m FROM MasReligion m WHERE m.masReligionid = :masReligionid") })
public class MasReligion implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "RELIGION")
	private String religion;
	@Id
	@Basic(optional = false)
	@Column(name = "MAS_RELIGIONID")
	private Short masReligionid;

	public MasReligion() {
	}

	public MasReligion(Short masReligionid) {
		this.masReligionid = masReligionid;
	}

	public MasReligion(Short masReligionid, String religion) {
		this.masReligionid = masReligionid;
		this.religion = religion;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public Short getMasReligionid() {
		return masReligionid;
	}

	public void setMasReligionid(Short masReligionid) {
		this.masReligionid = masReligionid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (masReligionid != null ? masReligionid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof MasReligion)) {
			return false;
		}
		MasReligion other = (MasReligion) object;
		if ((this.masReligionid == null && other.masReligionid != null)
				|| (this.masReligionid != null && !this.masReligionid.equals(other.masReligionid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.MasReligion[ masReligionid=" + masReligionid + " ]";
	}

}
