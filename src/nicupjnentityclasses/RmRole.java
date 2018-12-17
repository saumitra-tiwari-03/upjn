/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "RM_ROLE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "RmRole.findAll", query = "SELECT r FROM RmRole r"),
		@NamedQuery(name = "RmRole.findByRmRoleid", query = "SELECT r FROM RmRole r WHERE r.rmRoleid = :rmRoleid"),
		@NamedQuery(name = "RmRole.findByRolename", query = "SELECT r FROM RmRole r WHERE r.rolename = :rolename"),
		@NamedQuery(name = "RmRole.findByRoletype", query = "SELECT r FROM RmRole r WHERE r.roletype = :roletype"),
		@NamedQuery(name = "RmRole.findByIssystem", query = "SELECT r FROM RmRole r WHERE r.issystem = :issystem") })
public class RmRole implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "RM_ROLEID")
	private Integer rmRoleid;
	@Column(name = "ROLENAME")
	private String rolename;
	@Column(name = "ROLETYPE")
	private String roletype;
	@Column(name = "ISSYSTEM")
	private String issystem;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rmRoleid")
	private Collection<RmLoginrole> rmLoginroleCollection;
	@JoinColumn(name = "RM_OFFICEID", referencedColumnName = "RM_OFFICEID")
	@ManyToOne
	private RmOffice rmOfficeid;
	@OneToMany(mappedBy = "rmRoleid")
	private Collection<ViewRmGetlinksfortree1> viewRmGetlinksfortree1Collection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rmRoleid")
	private Collection<RmRolemenuitem> rmRolemenuitemCollection;

	public RmRole() {
	}

	public RmRole(Integer rmRoleid) {
		this.rmRoleid = rmRoleid;
	}

	public Integer getRmRoleid() {
		return rmRoleid;
	}

	public void setRmRoleid(Integer rmRoleid) {
		this.rmRoleid = rmRoleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoletype() {
		return roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	public String getIssystem() {
		return issystem;
	}

	public void setIssystem(String issystem) {
		this.issystem = issystem;
	}

	@XmlTransient
	public Collection<RmLoginrole> getRmLoginroleCollection() {
		return rmLoginroleCollection;
	}

	public void setRmLoginroleCollection(Collection<RmLoginrole> rmLoginroleCollection) {
		this.rmLoginroleCollection = rmLoginroleCollection;
	}

	public RmOffice getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(RmOffice rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	@XmlTransient
	public Collection<ViewRmGetlinksfortree1> getViewRmGetlinksfortree1Collection() {
		return viewRmGetlinksfortree1Collection;
	}

	public void setViewRmGetlinksfortree1Collection(
			Collection<ViewRmGetlinksfortree1> viewRmGetlinksfortree1Collection) {
		this.viewRmGetlinksfortree1Collection = viewRmGetlinksfortree1Collection;
	}

	@XmlTransient
	public Collection<RmRolemenuitem> getRmRolemenuitemCollection() {
		return rmRolemenuitemCollection;
	}

	public void setRmRolemenuitemCollection(Collection<RmRolemenuitem> rmRolemenuitemCollection) {
		this.rmRolemenuitemCollection = rmRolemenuitemCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (rmRoleid != null ? rmRoleid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof RmRole)) {
			return false;
		}
		RmRole other = (RmRole) object;
		if ((this.rmRoleid == null && other.rmRoleid != null)
				|| (this.rmRoleid != null && !this.rmRoleid.equals(other.rmRoleid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.RmRole[ rmRoleid=" + rmRoleid + " ]";
	}

}
