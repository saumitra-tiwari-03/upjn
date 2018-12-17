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
@Table(name = "RM_MENUITEM")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "RmMenuitem.findAll", query = "SELECT r FROM RmMenuitem r"),
		@NamedQuery(name = "RmMenuitem.findByRmMenuitemid", query = "SELECT r FROM RmMenuitem r WHERE r.rmMenuitemid = :rmMenuitemid"),
		@NamedQuery(name = "RmMenuitem.findByMenuname", query = "SELECT r FROM RmMenuitem r WHERE r.menuname = :menuname"),
		@NamedQuery(name = "RmMenuitem.findByParentid", query = "SELECT r FROM RmMenuitem r WHERE r.parentid = :parentid"),
		@NamedQuery(name = "RmMenuitem.findByLinks", query = "SELECT r FROM RmMenuitem r WHERE r.links = :links"),
		@NamedQuery(name = "RmMenuitem.findBySortid", query = "SELECT r FROM RmMenuitem r WHERE r.sortid = :sortid"),
		@NamedQuery(name = "RmMenuitem.findByIsvisible", query = "SELECT r FROM RmMenuitem r WHERE r.isvisible = :isvisible"),
		@NamedQuery(name = "RmMenuitem.findByQuerystring", query = "SELECT r FROM RmMenuitem r WHERE r.querystring = :querystring"),
		@NamedQuery(name = "RmMenuitem.findByIsDefaultRole", query = "SELECT r FROM RmMenuitem r WHERE r.isDefaultRole = :isDefaultRole"),
		@NamedQuery(name = "RmMenuitem.findByIsDefaultOaRole", query = "SELECT r FROM RmMenuitem r WHERE r.isDefaultOaRole = :isDefaultOaRole") })
public class RmMenuitem implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "RM_MENUITEMID")
	private Integer rmMenuitemid;
	@Basic(optional = false)
	@Column(name = "MENUNAME")
	private String menuname;
	@Basic(optional = false)
	@Column(name = "PARENTID")
	private int parentid;
	@Column(name = "LINKS")
	private String links;
	@Basic(optional = false)
	@Column(name = "SORTID")
	private String sortid;
	@Basic(optional = false)
	@Column(name = "ISVISIBLE")
	private String isvisible;
	@Column(name = "QUERYSTRING")
	private String querystring;
	@Basic(optional = false)
	@Column(name = "IS_DEFAULT_ROLE")
	private Character isDefaultRole;
	@Basic(optional = false)
	@Column(name = "IS_DEFAULT_OA_ROLE")
	private Character isDefaultOaRole;
	@OneToMany(mappedBy = "rmMenuitemid")
	private Collection<ViewRmGetlinksfortree> viewRmGetlinksfortreeCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rmMenuitemid")
	private Collection<RmRolemenuitem> rmRolemenuitemCollection;

	public RmMenuitem() {
	}

	public RmMenuitem(Integer rmMenuitemid) {
		this.rmMenuitemid = rmMenuitemid;
	}

	public RmMenuitem(Integer rmMenuitemid, String menuname, int parentid, String sortid, String isvisible,
			Character isDefaultRole, Character isDefaultOaRole) {
		this.rmMenuitemid = rmMenuitemid;
		this.menuname = menuname;
		this.parentid = parentid;
		this.sortid = sortid;
		this.isvisible = isvisible;
		this.isDefaultRole = isDefaultRole;
		this.isDefaultOaRole = isDefaultOaRole;
	}

	public Integer getRmMenuitemid() {
		return rmMenuitemid;
	}

	public void setRmMenuitemid(Integer rmMenuitemid) {
		this.rmMenuitemid = rmMenuitemid;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public String getSortid() {
		return sortid;
	}

	public void setSortid(String sortid) {
		this.sortid = sortid;
	}

	public String getIsvisible() {
		return isvisible;
	}

	public void setIsvisible(String isvisible) {
		this.isvisible = isvisible;
	}

	public String getQuerystring() {
		return querystring;
	}

	public void setQuerystring(String querystring) {
		this.querystring = querystring;
	}

	public Character getIsDefaultRole() {
		return isDefaultRole;
	}

	public void setIsDefaultRole(Character isDefaultRole) {
		this.isDefaultRole = isDefaultRole;
	}

	public Character getIsDefaultOaRole() {
		return isDefaultOaRole;
	}

	public void setIsDefaultOaRole(Character isDefaultOaRole) {
		this.isDefaultOaRole = isDefaultOaRole;
	}

	@XmlTransient
	public Collection<ViewRmGetlinksfortree> getViewRmGetlinksfortreeCollection() {
		return viewRmGetlinksfortreeCollection;
	}

	public void setViewRmGetlinksfortreeCollection(Collection<ViewRmGetlinksfortree> viewRmGetlinksfortreeCollection) {
		this.viewRmGetlinksfortreeCollection = viewRmGetlinksfortreeCollection;
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
		hash += (rmMenuitemid != null ? rmMenuitemid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof RmMenuitem)) {
			return false;
		}
		RmMenuitem other = (RmMenuitem) object;
		if ((this.rmMenuitemid == null && other.rmMenuitemid != null)
				|| (this.rmMenuitemid != null && !this.rmMenuitemid.equals(other.rmMenuitemid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.RmMenuitem[ rmMenuitemid=" + rmMenuitemid + " ]";
	}

}
