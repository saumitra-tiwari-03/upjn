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
@Table(name = "PP_TOWNCATEGORYMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpTowncategorymaster.findAll", query = "SELECT p FROM PpTowncategorymaster p"),
		@NamedQuery(name = "PpTowncategorymaster.findByPpTowncategorymasterid", query = "SELECT p FROM PpTowncategorymaster p WHERE p.ppTowncategorymasterid = :ppTowncategorymasterid"),
		@NamedQuery(name = "PpTowncategorymaster.findByCategorytype", query = "SELECT p FROM PpTowncategorymaster p WHERE p.categorytype = :categorytype"),
		@NamedQuery(name = "PpTowncategorymaster.findByPurpose", query = "SELECT p FROM PpTowncategorymaster p WHERE p.purpose = :purpose") })
public class PpTowncategorymaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_TOWNCATEGORYMASTERID")
	private Integer ppTowncategorymasterid;
	@Basic(optional = false)
	@Column(name = "CATEGORYTYPE")
	private String categorytype;
	@Basic(optional = false)
	@Column(name = "PURPOSE")
	private String purpose;

	public PpTowncategorymaster() {
	}

	public PpTowncategorymaster(Integer ppTowncategorymasterid) {
		this.ppTowncategorymasterid = ppTowncategorymasterid;
	}

	public PpTowncategorymaster(Integer ppTowncategorymasterid, String categorytype, String purpose) {
		this.ppTowncategorymasterid = ppTowncategorymasterid;
		this.categorytype = categorytype;
		this.purpose = purpose;
	}

	public Integer getPpTowncategorymasterid() {
		return ppTowncategorymasterid;
	}

	public void setPpTowncategorymasterid(Integer ppTowncategorymasterid) {
		this.ppTowncategorymasterid = ppTowncategorymasterid;
	}

	public String getCategorytype() {
		return categorytype;
	}

	public void setCategorytype(String categorytype) {
		this.categorytype = categorytype;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppTowncategorymasterid != null ? ppTowncategorymasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpTowncategorymaster)) {
			return false;
		}
		PpTowncategorymaster other = (PpTowncategorymaster) object;
		if ((this.ppTowncategorymasterid == null && other.ppTowncategorymasterid != null)
				|| (this.ppTowncategorymasterid != null
						&& !this.ppTowncategorymasterid.equals(other.ppTowncategorymasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpTowncategorymaster[ ppTowncategorymasterid=" + ppTowncategorymasterid + " ]";
	}

}
