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
@Table(name = "RM_ROLEMENUITEM")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "RmRolemenuitem.findAll", query = "SELECT r FROM RmRolemenuitem r"),
		@NamedQuery(name = "RmRolemenuitem.findByRmRolemenuitemid", query = "SELECT r FROM RmRolemenuitem r WHERE r.rmRolemenuitemid = :rmRolemenuitemid") })
public class RmRolemenuitem implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "RM_ROLEMENUITEMID")
	private Long rmRolemenuitemid;
	@JoinColumn(name = "RM_MENUITEMID", referencedColumnName = "RM_MENUITEMID")
	@ManyToOne(optional = false)
	private RmMenuitem rmMenuitemid;
	@JoinColumn(name = "RM_ROLEID", referencedColumnName = "RM_ROLEID")
	@ManyToOne(optional = false)
	private RmRole rmRoleid;

	public RmRolemenuitem() {
	}

	public RmRolemenuitem(Long rmRolemenuitemid) {
		this.rmRolemenuitemid = rmRolemenuitemid;
	}

	public Long getRmRolemenuitemid() {
		return rmRolemenuitemid;
	}

	public void setRmRolemenuitemid(Long rmRolemenuitemid) {
		this.rmRolemenuitemid = rmRolemenuitemid;
	}

	public RmMenuitem getRmMenuitemid() {
		return rmMenuitemid;
	}

	public void setRmMenuitemid(RmMenuitem rmMenuitemid) {
		this.rmMenuitemid = rmMenuitemid;
	}

	public RmRole getRmRoleid() {
		return rmRoleid;
	}

	public void setRmRoleid(RmRole rmRoleid) {
		this.rmRoleid = rmRoleid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (rmRolemenuitemid != null ? rmRolemenuitemid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof RmRolemenuitem)) {
			return false;
		}
		RmRolemenuitem other = (RmRolemenuitem) object;
		if ((this.rmRolemenuitemid == null && other.rmRolemenuitemid != null)
				|| (this.rmRolemenuitemid != null && !this.rmRolemenuitemid.equals(other.rmRolemenuitemid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.RmRolemenuitem[ rmRolemenuitemid=" + rmRolemenuitemid + " ]";
	}

}
