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
@Table(name = "MAS_ACCOUNTTYPE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "MasAccounttype.findAll", query = "SELECT m FROM MasAccounttype m"),
		@NamedQuery(name = "MasAccounttype.findByName", query = "SELECT m FROM MasAccounttype m WHERE m.name = :name"),
		@NamedQuery(name = "MasAccounttype.findByMasAccounttypeid", query = "SELECT m FROM MasAccounttype m WHERE m.masAccounttypeid = :masAccounttypeid"),
		@NamedQuery(name = "MasAccounttype.findByParentMasAccounttypeid", query = "SELECT m FROM MasAccounttype m WHERE m.parentMasAccounttypeid = :parentMasAccounttypeid") })
public class MasAccounttype implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "NAME")
	private String name;
	@Id
	@Basic(optional = false)
	@Column(name = "MAS_ACCOUNTTYPEID")
	private Short masAccounttypeid;
	@Column(name = "PARENT_MAS_ACCOUNTTYPEID")
	private Short parentMasAccounttypeid;

	public MasAccounttype() {
	}

	public MasAccounttype(Short masAccounttypeid) {
		this.masAccounttypeid = masAccounttypeid;
	}

	public MasAccounttype(Short masAccounttypeid, String name) {
		this.masAccounttypeid = masAccounttypeid;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getMasAccounttypeid() {
		return masAccounttypeid;
	}

	public void setMasAccounttypeid(Short masAccounttypeid) {
		this.masAccounttypeid = masAccounttypeid;
	}

	public Short getParentMasAccounttypeid() {
		return parentMasAccounttypeid;
	}

	public void setParentMasAccounttypeid(Short parentMasAccounttypeid) {
		this.parentMasAccounttypeid = parentMasAccounttypeid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (masAccounttypeid != null ? masAccounttypeid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof MasAccounttype)) {
			return false;
		}
		MasAccounttype other = (MasAccounttype) object;
		if ((this.masAccounttypeid == null && other.masAccounttypeid != null)
				|| (this.masAccounttypeid != null && !this.masAccounttypeid.equals(other.masAccounttypeid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.MasAccounttype[ masAccounttypeid=" + masAccounttypeid + " ]";
	}

}
