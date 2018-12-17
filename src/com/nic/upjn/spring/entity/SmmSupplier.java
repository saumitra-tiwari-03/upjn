/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "SMM_SUPPLIER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmSupplier.findAll", query = "SELECT s FROM SmmSupplier s"),
		@NamedQuery(name = "SmmSupplier.findBySmmSupplierid", query = "SELECT s FROM SmmSupplier s WHERE s.smmSupplierid = :smmSupplierid"),
		@NamedQuery(name = "SmmSupplier.findBySuppliername", query = "SELECT s FROM SmmSupplier s WHERE s.suppliername = :suppliername"),
		@NamedQuery(name = "SmmSupplier.findBySupplieraddress", query = "SELECT s FROM SmmSupplier s WHERE s.supplieraddress = :supplieraddress"),
		@NamedQuery(name = "SmmSupplier.findByRmOfficeid", query = "SELECT s FROM SmmSupplier s WHERE s.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "SmmSupplier.findByRegistNoUpjn", query = "SELECT s FROM SmmSupplier s WHERE s.registNoUpjn = :registNoUpjn"),
		@NamedQuery(name = "SmmSupplier.findByPhoneNo", query = "SELECT s FROM SmmSupplier s WHERE s.phoneNo = :phoneNo"),
		@NamedQuery(name = "SmmSupplier.findByIsactive", query = "SELECT s FROM SmmSupplier s WHERE s.isactive = :isactive"),
		@NamedQuery(name = "SmmSupplier.findByValiddate", query = "SELECT s FROM SmmSupplier s WHERE s.validdate = :validdate") })
public class SmmSupplier implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_SUPPLIERID")
	private Long smmSupplierid;
	@Basic(optional = false)
	@Column(name = "SUPPLIERNAME")
	private String suppliername;
	@Basic(optional = false)
	@Column(name = "SUPPLIERADDRESS")
	private String supplieraddress;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Basic(optional = false)
	@Column(name = "REGIST_NO_UPJN")
	private String registNoUpjn;
	@Column(name = "PHONE_NO")
	private String phoneNo;
	@Basic(optional = false)
	@Column(name = "ISACTIVE")
	private Character isactive;
	@Column(name = "VALIDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validdate;
	@OneToMany(mappedBy = "smmSupplierid")
	private Collection<SmmGrnPurchased> smmGrnPurchasedCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "smmSupplierid")
	private Collection<SmmAssociateItemSupp> smmAssociateItemSuppCollection;

	public SmmSupplier() {
	}

	public SmmSupplier(Long smmSupplierid) {
		this.smmSupplierid = smmSupplierid;
	}

	public SmmSupplier(Long smmSupplierid, String suppliername, String supplieraddress, String registNoUpjn,
			Character isactive) {
		this.smmSupplierid = smmSupplierid;
		this.suppliername = suppliername;
		this.supplieraddress = supplieraddress;
		this.registNoUpjn = registNoUpjn;
		this.isactive = isactive;
	}

	public Long getSmmSupplierid() {
		return smmSupplierid;
	}

	public void setSmmSupplierid(Long smmSupplierid) {
		this.smmSupplierid = smmSupplierid;
	}

	public String getSuppliername() {
		return suppliername;
	}

	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}

	public String getSupplieraddress() {
		return supplieraddress;
	}

	public void setSupplieraddress(String supplieraddress) {
		this.supplieraddress = supplieraddress;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getRegistNoUpjn() {
		return registNoUpjn;
	}

	public void setRegistNoUpjn(String registNoUpjn) {
		this.registNoUpjn = registNoUpjn;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Character getIsactive() {
		return isactive;
	}

	public void setIsactive(Character isactive) {
		this.isactive = isactive;
	}

	public Date getValiddate() {
		return validdate;
	}

	public void setValiddate(Date validdate) {
		this.validdate = validdate;
	}

	@XmlTransient
	public Collection<SmmGrnPurchased> getSmmGrnPurchasedCollection() {
		return smmGrnPurchasedCollection;
	}

	public void setSmmGrnPurchasedCollection(Collection<SmmGrnPurchased> smmGrnPurchasedCollection) {
		this.smmGrnPurchasedCollection = smmGrnPurchasedCollection;
	}

	@XmlTransient
	public Collection<SmmAssociateItemSupp> getSmmAssociateItemSuppCollection() {
		return smmAssociateItemSuppCollection;
	}

	public void setSmmAssociateItemSuppCollection(Collection<SmmAssociateItemSupp> smmAssociateItemSuppCollection) {
		this.smmAssociateItemSuppCollection = smmAssociateItemSuppCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmSupplierid != null ? smmSupplierid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmSupplier)) {
			return false;
		}
		SmmSupplier other = (SmmSupplier) object;
		if ((this.smmSupplierid == null && other.smmSupplierid != null)
				|| (this.smmSupplierid != null && !this.smmSupplierid.equals(other.smmSupplierid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmSupplier[ smmSupplierid=" + smmSupplierid + " ]";
	}

}
