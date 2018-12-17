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
@Table(name = "PP_REGISTERMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpRegistermaster.findAll", query = "SELECT p FROM PpRegistermaster p"),
		@NamedQuery(name = "PpRegistermaster.findByPpRegistermasterid", query = "SELECT p FROM PpRegistermaster p WHERE p.ppRegistermasterid = :ppRegistermasterid"),
		@NamedQuery(name = "PpRegistermaster.findByRegistername", query = "SELECT p FROM PpRegistermaster p WHERE p.registername = :registername") })
public class PpRegistermaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_REGISTERMASTERID")
	private Short ppRegistermasterid;
	@Basic(optional = false)
	@Column(name = "REGISTERNAME")
	private String registername;

	public PpRegistermaster() {
	}

	public PpRegistermaster(Short ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public PpRegistermaster(Short ppRegistermasterid, String registername) {
		this.ppRegistermasterid = ppRegistermasterid;
		this.registername = registername;
	}

	public Short getPpRegistermasterid() {
		return ppRegistermasterid;
	}

	public void setPpRegistermasterid(Short ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public String getRegistername() {
		return registername;
	}

	public void setRegistername(String registername) {
		this.registername = registername;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppRegistermasterid != null ? ppRegistermasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpRegistermaster)) {
			return false;
		}
		PpRegistermaster other = (PpRegistermaster) object;
		if ((this.ppRegistermasterid == null && other.ppRegistermasterid != null)
				|| (this.ppRegistermasterid != null && !this.ppRegistermasterid.equals(other.ppRegistermasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpRegistermaster[ ppRegistermasterid=" + ppRegistermasterid + " ]";
	}

}
