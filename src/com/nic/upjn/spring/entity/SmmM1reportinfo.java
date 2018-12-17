/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "SMM_M1REPORTINFO")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmM1reportinfo.findAll", query = "SELECT s FROM SmmM1reportinfo s"),
		@NamedQuery(name = "SmmM1reportinfo.findBySmmM1reportinfoid", query = "SELECT s FROM SmmM1reportinfo s WHERE s.smmM1reportinfoid = :smmM1reportinfoid"),
		@NamedQuery(name = "SmmM1reportinfo.findByTotalexpLfy", query = "SELECT s FROM SmmM1reportinfo s WHERE s.totalexpLfy = :totalexpLfy"),
		@NamedQuery(name = "SmmM1reportinfo.findByBankerName", query = "SELECT s FROM SmmM1reportinfo s WHERE s.bankerName = :bankerName"),
		@NamedQuery(name = "SmmM1reportinfo.findByTotalcostReqMaterial", query = "SELECT s FROM SmmM1reportinfo s WHERE s.totalcostReqMaterial = :totalcostReqMaterial"),
		@NamedQuery(name = "SmmM1reportinfo.findByFinancialyear", query = "SELECT s FROM SmmM1reportinfo s WHERE s.financialyear = :financialyear"),
		@NamedQuery(name = "SmmM1reportinfo.findByEntrydate", query = "SELECT s FROM SmmM1reportinfo s WHERE s.entrydate = :entrydate") })
public class SmmM1reportinfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_M1REPORTINFOID")
	private Long smmM1reportinfoid;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "TOTALEXP_LFY")
	private BigDecimal totalexpLfy;
	@Column(name = "BANKER_NAME")
	private String bankerName;
	@Basic(optional = false)
	@Column(name = "TOTALCOST_REQ_MATERIAL")
	private BigDecimal totalcostReqMaterial;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;
	@Basic(optional = false)
	@Column(name = "ENTRYDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date entrydate;
	@JoinColumn(name = "SP_SCHEMEMASTERID", referencedColumnName = "SP_SCHEMEMASTERID")
	@ManyToOne(optional = false)
	private SpSchememaster spSchememasterid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "smmM1reportinfoid")
	private Collection<SmmMaterialrequirement> smmMaterialrequirementCollection;

	public SmmM1reportinfo() {
	}

	public SmmM1reportinfo(Long smmM1reportinfoid) {
		this.smmM1reportinfoid = smmM1reportinfoid;
	}

	public SmmM1reportinfo(Long smmM1reportinfoid, BigDecimal totalexpLfy, BigDecimal totalcostReqMaterial,
			String financialyear, Date entrydate) {
		this.smmM1reportinfoid = smmM1reportinfoid;
		this.totalexpLfy = totalexpLfy;
		this.totalcostReqMaterial = totalcostReqMaterial;
		this.financialyear = financialyear;
		this.entrydate = entrydate;
	}

	public Long getSmmM1reportinfoid() {
		return smmM1reportinfoid;
	}

	public void setSmmM1reportinfoid(Long smmM1reportinfoid) {
		this.smmM1reportinfoid = smmM1reportinfoid;
	}

	public BigDecimal getTotalexpLfy() {
		return totalexpLfy;
	}

	public void setTotalexpLfy(BigDecimal totalexpLfy) {
		this.totalexpLfy = totalexpLfy;
	}

	public String getBankerName() {
		return bankerName;
	}

	public void setBankerName(String bankerName) {
		this.bankerName = bankerName;
	}

	public BigDecimal getTotalcostReqMaterial() {
		return totalcostReqMaterial;
	}

	public void setTotalcostReqMaterial(BigDecimal totalcostReqMaterial) {
		this.totalcostReqMaterial = totalcostReqMaterial;
	}

	public String getFinancialyear() {
		return financialyear;
	}

	public void setFinancialyear(String financialyear) {
		this.financialyear = financialyear;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

	public SpSchememaster getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(SpSchememaster spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	@XmlTransient
	public Collection<SmmMaterialrequirement> getSmmMaterialrequirementCollection() {
		return smmMaterialrequirementCollection;
	}

	public void setSmmMaterialrequirementCollection(
			Collection<SmmMaterialrequirement> smmMaterialrequirementCollection) {
		this.smmMaterialrequirementCollection = smmMaterialrequirementCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmM1reportinfoid != null ? smmM1reportinfoid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmM1reportinfo)) {
			return false;
		}
		SmmM1reportinfo other = (SmmM1reportinfo) object;
		if ((this.smmM1reportinfoid == null && other.smmM1reportinfoid != null)
				|| (this.smmM1reportinfoid != null && !this.smmM1reportinfoid.equals(other.smmM1reportinfoid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmM1reportinfo[ smmM1reportinfoid=" + smmM1reportinfoid + " ]";
	}

}
