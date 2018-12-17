/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
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
@Table(name = "SMM_ITEMCATEGORY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmItemcategory.findAll", query = "SELECT s FROM SmmItemcategory s"),
		@NamedQuery(name = "SmmItemcategory.findBySmmItemcategoryid", query = "SELECT s FROM SmmItemcategory s WHERE s.smmItemcategoryid = :smmItemcategoryid"),
		@NamedQuery(name = "SmmItemcategory.findByIsconsumable", query = "SELECT s FROM SmmItemcategory s WHERE s.isconsumable = :isconsumable"),
		@NamedQuery(name = "SmmItemcategory.findByCategoryname", query = "SELECT s FROM SmmItemcategory s WHERE s.categoryname = :categoryname"),
		@NamedQuery(name = "SmmItemcategory.findByDescription", query = "SELECT s FROM SmmItemcategory s WHERE s.description = :description") })
public class SmmItemcategory implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_ITEMCATEGORYID")
	private Long smmItemcategoryid;
	@Basic(optional = false)
	@Column(name = "ISCONSUMABLE")
	private Character isconsumable;
	@Basic(optional = false)
	@Column(name = "CATEGORYNAME")
	private String categoryname;
	@Column(name = "DESCRIPTION")
	private String description;
	@OneToMany(mappedBy = "smmItemcategoryid")
	private Collection<SmmItemmaster> smmItemmasterCollection;

	public SmmItemcategory() {
	}

	public SmmItemcategory(Long smmItemcategoryid) {
		this.smmItemcategoryid = smmItemcategoryid;
	}

	public SmmItemcategory(Long smmItemcategoryid, Character isconsumable, String categoryname) {
		this.smmItemcategoryid = smmItemcategoryid;
		this.isconsumable = isconsumable;
		this.categoryname = categoryname;
	}

	public Long getSmmItemcategoryid() {
		return smmItemcategoryid;
	}

	public void setSmmItemcategoryid(Long smmItemcategoryid) {
		this.smmItemcategoryid = smmItemcategoryid;
	}

	public Character getIsconsumable() {
		return isconsumable;
	}

	public void setIsconsumable(Character isconsumable) {
		this.isconsumable = isconsumable;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlTransient
	public Collection<SmmItemmaster> getSmmItemmasterCollection() {
		return smmItemmasterCollection;
	}

	public void setSmmItemmasterCollection(Collection<SmmItemmaster> smmItemmasterCollection) {
		this.smmItemmasterCollection = smmItemmasterCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmItemcategoryid != null ? smmItemcategoryid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmItemcategory)) {
			return false;
		}
		SmmItemcategory other = (SmmItemcategory) object;
		if ((this.smmItemcategoryid == null && other.smmItemcategoryid != null)
				|| (this.smmItemcategoryid != null && !this.smmItemcategoryid.equals(other.smmItemcategoryid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmItemcategory[ smmItemcategoryid=" + smmItemcategoryid + " ]";
	}

}
