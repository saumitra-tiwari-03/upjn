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
@Table(name = "VIEW_PP_LEAVETYPE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpLeavetype.findAll", query = "SELECT v FROM ViewPpLeavetype v"),
		@NamedQuery(name = "ViewPpLeavetype.findBySysLeavetypemasterid", query = "SELECT v FROM ViewPpLeavetype v WHERE v.sysLeavetypemasterid = :sysLeavetypemasterid"),
		@NamedQuery(name = "ViewPpLeavetype.findByLeavetype", query = "SELECT v FROM ViewPpLeavetype v WHERE v.leavetype = :leavetype") })
public class ViewPpLeavetype implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SYS_LEAVETYPEMASTERID")
	private Short sysLeavetypemasterid;
	@Basic(optional = false)
	@Column(name = "LEAVETYPE")
	private String leavetype;

	public ViewPpLeavetype() {
	}

	public ViewPpLeavetype(Short sysLeavetypemasterid) {
		this.sysLeavetypemasterid = sysLeavetypemasterid;
	}

	public ViewPpLeavetype(Short sysLeavetypemasterid, String leavetype) {
		this.sysLeavetypemasterid = sysLeavetypemasterid;
		this.leavetype = leavetype;
	}

	public Short getSysLeavetypemasterid() {
		return sysLeavetypemasterid;
	}

	public void setSysLeavetypemasterid(Short sysLeavetypemasterid) {
		this.sysLeavetypemasterid = sysLeavetypemasterid;
	}

	public String getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (sysLeavetypemasterid != null ? sysLeavetypemasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ViewPpLeavetype)) {
			return false;
		}
		ViewPpLeavetype other = (ViewPpLeavetype) object;
		if ((this.sysLeavetypemasterid == null && other.sysLeavetypemasterid != null)
				|| (this.sysLeavetypemasterid != null
						&& !this.sysLeavetypemasterid.equals(other.sysLeavetypemasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.ViewPpLeavetype[ sysLeavetypemasterid=" + sysLeavetypemasterid + " ]";
	}

}
