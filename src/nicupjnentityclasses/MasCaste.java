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
@Table(name = "MAS_CASTE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "MasCaste.findAll", query = "SELECT m FROM MasCaste m"),
		@NamedQuery(name = "MasCaste.findByCaste", query = "SELECT m FROM MasCaste m WHERE m.caste = :caste"),
		@NamedQuery(name = "MasCaste.findByMasCasteid", query = "SELECT m FROM MasCaste m WHERE m.masCasteid = :masCasteid") })
public class MasCaste implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "CASTE")
	private String caste;
	@Id
	@Basic(optional = false)
	@Column(name = "MAS_CASTEID")
	private Short masCasteid;

	public MasCaste() {
	}

	public MasCaste(Short masCasteid) {
		this.masCasteid = masCasteid;
	}

	public MasCaste(Short masCasteid, String caste) {
		this.masCasteid = masCasteid;
		this.caste = caste;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public Short getMasCasteid() {
		return masCasteid;
	}

	public void setMasCasteid(Short masCasteid) {
		this.masCasteid = masCasteid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (masCasteid != null ? masCasteid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof MasCaste)) {
			return false;
		}
		MasCaste other = (MasCaste) object;
		if ((this.masCasteid == null && other.masCasteid != null)
				|| (this.masCasteid != null && !this.masCasteid.equals(other.masCasteid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.MasCaste[ masCasteid=" + masCasteid + " ]";
	}

}
