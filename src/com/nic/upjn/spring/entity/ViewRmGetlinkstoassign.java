/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.math.BigInteger;

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
@Table(name = "VIEW_RM_GETLINKSTOASSIGN")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewRmGetlinkstoassign.findAll", query = "SELECT v FROM ViewRmGetlinkstoassign v"),
		@NamedQuery(name = "ViewRmGetlinkstoassign.findByRmMenuitemid", query = "SELECT v FROM ViewRmGetlinkstoassign v WHERE v.rmMenuitemid = :rmMenuitemid"),
		@NamedQuery(name = "ViewRmGetlinkstoassign.findByMenuname", query = "SELECT v FROM ViewRmGetlinkstoassign v WHERE v.menuname = :menuname"),
		@NamedQuery(name = "ViewRmGetlinkstoassign.findByLinks", query = "SELECT v FROM ViewRmGetlinkstoassign v WHERE v.links = :links"),
		@NamedQuery(name = "ViewRmGetlinkstoassign.findByLinklevel", query = "SELECT v FROM ViewRmGetlinkstoassign v WHERE v.linklevel = :linklevel"),
		@NamedQuery(name = "ViewRmGetlinkstoassign.findByParentid", query = "SELECT v FROM ViewRmGetlinkstoassign v WHERE v.parentid = :parentid"),
		@NamedQuery(name = "ViewRmGetlinkstoassign.findBySortid", query = "SELECT v FROM ViewRmGetlinkstoassign v WHERE v.sortid = :sortid"),
		@NamedQuery(name = "ViewRmGetlinkstoassign.findByQuerystring", query = "SELECT v FROM ViewRmGetlinkstoassign v WHERE v.querystring = :querystring") })
public class ViewRmGetlinkstoassign implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "RM_MENUITEMID")
	private Integer rmMenuitemid;
	@Column(name = "MENUNAME")
	private String menuname;
	@Column(name = "LINKS")
	private String links;
	@Column(name = "LINKLEVEL")
	private BigInteger linklevel;
	@Basic(optional = false)
	@Column(name = "PARENTID")
	private int parentid;
	@Basic(optional = false)
	@Column(name = "SORTID")
	private String sortid;
	@Column(name = "QUERYSTRING")
	private String querystring;
	

	public ViewRmGetlinkstoassign() {
	}

	public ViewRmGetlinkstoassign(Integer rmMenuitemid) {
		this.rmMenuitemid = rmMenuitemid;
	}

	public ViewRmGetlinkstoassign(Integer rmMenuitemid, int parentid, String sortid) {
		this.rmMenuitemid = rmMenuitemid;
		this.parentid = parentid;
		this.sortid = sortid;
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

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public BigInteger getLinklevel() {
		return linklevel;
	}

	public void setLinklevel(BigInteger linklevel) {
		this.linklevel = linklevel;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public String getSortid() {
		return sortid;
	}

	public void setSortid(String sortid) {
		this.sortid = sortid;
	}

	public String getQuerystring() {
		return querystring;
	}

	public void setQuerystring(String querystring) {
		this.querystring = querystring;
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
		if (!(object instanceof ViewRmGetlinkstoassign)) {
			return false;
		}
		ViewRmGetlinkstoassign other = (ViewRmGetlinkstoassign) object;
		if ((this.rmMenuitemid == null && other.rmMenuitemid != null)
				|| (this.rmMenuitemid != null && !this.rmMenuitemid.equals(other.rmMenuitemid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.ViewRmGetlinkstoassign[ rmMenuitemid=" + rmMenuitemid + " ]";
	}

}
