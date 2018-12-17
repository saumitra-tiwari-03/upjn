/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "SP_VIEW_LASTYEARSCHEMESTATUS")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "SpViewLastyearschemestatus.findAll", query = "SELECT s FROM SpViewLastyearschemestatus s") })
public class SpViewLastyearschemestatus implements Serializable {
	private static final long serialVersionUID = 1L;
	@Lob
	@Column(name = "STATUSDATE")
	private Object statusdate;
	@Lob
	@Column(name = "LASTSTATUS")
	private Object laststatus;
	@Id
	@Lob
	@Column(name = "SP_COMPONENTMASTERID")
	private Object spComponentmasterid;
	@Id
	@Lob
	@Column(name = "SP_SCHEMEMASTERID")
	private Object spSchememasterid;

	public SpViewLastyearschemestatus() {
	}

	public SpViewLastyearschemestatus(Object spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public Object getStatusdate() {
		return statusdate;
	}

	public void setStatusdate(Object statusdate) {
		this.statusdate = statusdate;
	}

	public Object getLaststatus() {
		return laststatus;
	}

	public void setLaststatus(Object laststatus) {
		this.laststatus = laststatus;
	}

	public Object getSpComponentmasterid() {
		return spComponentmasterid;
	}

	public void setSpComponentmasterid(Object spComponentmasterid) {
		this.spComponentmasterid = spComponentmasterid;
	}

	public Object getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(Object spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (spSchememasterid != null ? spSchememasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SpViewLastyearschemestatus)) {
			return false;
		}
		SpViewLastyearschemestatus other = (SpViewLastyearschemestatus) object;
		if ((this.spSchememasterid == null && other.spSchememasterid != null)
				|| (this.spSchememasterid != null && !this.spSchememasterid.equals(other.spSchememasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SpViewLastyearschemestatus[ spSchememasterid=" + spSchememasterid + " ]";
	}

}
