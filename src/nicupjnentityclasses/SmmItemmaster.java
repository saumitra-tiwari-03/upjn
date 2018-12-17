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
@Table(name = "SMM_ITEMMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmItemmaster.findAll", query = "SELECT s FROM SmmItemmaster s"),
		@NamedQuery(name = "SmmItemmaster.findBySmmItemmasterid", query = "SELECT s FROM SmmItemmaster s WHERE s.smmItemmasterid = :smmItemmasterid"),
		@NamedQuery(name = "SmmItemmaster.findByItemname", query = "SELECT s FROM SmmItemmaster s WHERE s.itemname = :itemname"),
		@NamedQuery(name = "SmmItemmaster.findByItemclass", query = "SELECT s FROM SmmItemmaster s WHERE s.itemclass = :itemclass"),
		@NamedQuery(name = "SmmItemmaster.findByUnit", query = "SELECT s FROM SmmItemmaster s WHERE s.unit = :unit"),
		@NamedQuery(name = "SmmItemmaster.findByPurchasetype", query = "SELECT s FROM SmmItemmaster s WHERE s.purchasetype = :purchasetype"),
		@NamedQuery(name = "SmmItemmaster.findByItemcode", query = "SELECT s FROM SmmItemmaster s WHERE s.itemcode = :itemcode") })
public class SmmItemmaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_ITEMMASTERID")
	private Long smmItemmasterid;
	@Basic(optional = false)
	@Column(name = "ITEMNAME")
	private String itemname;
	@Column(name = "ITEMCLASS")
	private String itemclass;
	@Column(name = "UNIT")
	private String unit;
	@Column(name = "PURCHASETYPE")
	private Character purchasetype;
	@Column(name = "ITEMCODE")
	private String itemcode;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "smmItemmasterid")
	private Collection<SmmStockTranReq> smmStockTranReqCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "smmItemmasterid")
	private Collection<SmmMaterialrequirement> smmMaterialrequirementCollection;
	@JoinColumn(name = "SMM_ITEMCATEGORYID", referencedColumnName = "SMM_ITEMCATEGORYID")
	@ManyToOne
	private SmmItemcategory smmItemcategoryid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "smmItemmasterid")
	private Collection<SmmStockmaster> smmStockmasterCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "smmItemmasterid")
	private Collection<SmmAssociateItemSupp> smmAssociateItemSuppCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "smmItemmasterid")
	private Collection<SmmItempurchase> smmItempurchaseCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "smmItemmasterid")
	private Collection<SmmMaterialconsumption> smmMaterialconsumptionCollection;

	public SmmItemmaster() {
	}

	public SmmItemmaster(Long smmItemmasterid) {
		this.smmItemmasterid = smmItemmasterid;
	}

	public SmmItemmaster(Long smmItemmasterid, String itemname) {
		this.smmItemmasterid = smmItemmasterid;
		this.itemname = itemname;
	}

	public Long getSmmItemmasterid() {
		return smmItemmasterid;
	}

	public void setSmmItemmasterid(Long smmItemmasterid) {
		this.smmItemmasterid = smmItemmasterid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemclass() {
		return itemclass;
	}

	public void setItemclass(String itemclass) {
		this.itemclass = itemclass;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Character getPurchasetype() {
		return purchasetype;
	}

	public void setPurchasetype(Character purchasetype) {
		this.purchasetype = purchasetype;
	}

	public String getItemcode() {
		return itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	@XmlTransient
	public Collection<SmmStockTranReq> getSmmStockTranReqCollection() {
		return smmStockTranReqCollection;
	}

	public void setSmmStockTranReqCollection(Collection<SmmStockTranReq> smmStockTranReqCollection) {
		this.smmStockTranReqCollection = smmStockTranReqCollection;
	}

	@XmlTransient
	public Collection<SmmMaterialrequirement> getSmmMaterialrequirementCollection() {
		return smmMaterialrequirementCollection;
	}

	public void setSmmMaterialrequirementCollection(
			Collection<SmmMaterialrequirement> smmMaterialrequirementCollection) {
		this.smmMaterialrequirementCollection = smmMaterialrequirementCollection;
	}

	public SmmItemcategory getSmmItemcategoryid() {
		return smmItemcategoryid;
	}

	public void setSmmItemcategoryid(SmmItemcategory smmItemcategoryid) {
		this.smmItemcategoryid = smmItemcategoryid;
	}

	@XmlTransient
	public Collection<SmmStockmaster> getSmmStockmasterCollection() {
		return smmStockmasterCollection;
	}

	public void setSmmStockmasterCollection(Collection<SmmStockmaster> smmStockmasterCollection) {
		this.smmStockmasterCollection = smmStockmasterCollection;
	}

	@XmlTransient
	public Collection<SmmAssociateItemSupp> getSmmAssociateItemSuppCollection() {
		return smmAssociateItemSuppCollection;
	}

	public void setSmmAssociateItemSuppCollection(Collection<SmmAssociateItemSupp> smmAssociateItemSuppCollection) {
		this.smmAssociateItemSuppCollection = smmAssociateItemSuppCollection;
	}

	@XmlTransient
	public Collection<SmmItempurchase> getSmmItempurchaseCollection() {
		return smmItempurchaseCollection;
	}

	public void setSmmItempurchaseCollection(Collection<SmmItempurchase> smmItempurchaseCollection) {
		this.smmItempurchaseCollection = smmItempurchaseCollection;
	}

	@XmlTransient
	public Collection<SmmMaterialconsumption> getSmmMaterialconsumptionCollection() {
		return smmMaterialconsumptionCollection;
	}

	public void setSmmMaterialconsumptionCollection(
			Collection<SmmMaterialconsumption> smmMaterialconsumptionCollection) {
		this.smmMaterialconsumptionCollection = smmMaterialconsumptionCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmItemmasterid != null ? smmItemmasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmItemmaster)) {
			return false;
		}
		SmmItemmaster other = (SmmItemmaster) object;
		if ((this.smmItemmasterid == null && other.smmItemmasterid != null)
				|| (this.smmItemmasterid != null && !this.smmItemmasterid.equals(other.smmItemmasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmItemmaster[ smmItemmasterid=" + smmItemmasterid + " ]";
	}

}
