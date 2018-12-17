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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
		@NamedQuery(name = "RmRolemenuitem.findByRmRolemenuitemid", query = "SELECT r FROM RmRolemenuitem r WHERE r.rmRolemenuitemid = :rmRolemenuitemid"),
		@NamedQuery(name = "RmRolemenuitem.findByRmRoleID", query = "FROM RmRolemenuitem WHERE rmRoleid = ?") })

public class RmRolemenuitem implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_RM_ROLEMENUITEM", allocationSize = 1)
	@Id
	@Basic(optional = false)
	@Column(name = "RM_ROLEMENUITEMID")
	private Long rmRolemenuitemid;
	
	
	@Column(name = "RM_MENUITEMID")
	private String  rmMenuitemid;
	
	@Column(name = "RM_ROLEID")
	private String rmRoleid;

	public String getRmMenuitemid() {
		return rmMenuitemid;
	}

	public void setRmMenuitemid(String rmMenuitemid) {
		this.rmMenuitemid = rmMenuitemid;
	}

	public String getRmRoleid() {
		return rmRoleid;
	}

	public void setRmRoleid(String rmRoleid) {
		this.rmRoleid = rmRoleid;
	}

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
