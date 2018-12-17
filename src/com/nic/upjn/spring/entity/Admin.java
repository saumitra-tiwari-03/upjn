/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

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
@Table(name = "ADMIN")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
		@NamedQuery(name = "Admin.findByAdminid", query = "SELECT a FROM Admin a WHERE a.adminid = :adminid"),
		@NamedQuery(name = "Admin.findByAdminname", query = "FROM Admin WHERE adminname = ?"),
		@NamedQuery(name = "Admin.findByPassword", query = "SELECT a FROM Admin a WHERE a.password = :password") })
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "ADMINID")
	private short adminid;
	
	
	@Basic(optional = false)
	@Column(name = "ADMINNAME")
	private String adminname;
	@Basic(optional = false)
	@Column(name = "PASSWORD")
	private String password;

	public Admin() {
	}

	public Admin(String adminname) {
		this.adminname = adminname;
	}

	public Admin(String adminname, short adminid, String password) {
		this.adminname = adminname;
		this.adminid = adminid;
		this.password = password;
	}

	public short getAdminid() {
		return adminid;
	}

	public void setAdminid(short adminid) {
		this.adminid = adminid;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (adminname != null ? adminname.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Admin)) {
			return false;
		}
		Admin other = (Admin) object;
		if ((this.adminname == null && other.adminname != null)
				|| (this.adminname != null && !this.adminname.equals(other.adminname))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.Admin[ adminname=" + adminname + " ]";
	}

}
