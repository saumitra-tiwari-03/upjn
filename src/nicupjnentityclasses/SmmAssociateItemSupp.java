/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "SMM_ASSOCIATE_ITEM_SUPP")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmAssociateItemSupp.findAll", query = "SELECT s FROM SmmAssociateItemSupp s"),
		@NamedQuery(name = "SmmAssociateItemSupp.findBySmmAssociateItemSuppid", query = "SELECT s FROM SmmAssociateItemSupp s WHERE s.smmAssociateItemSuppid = :smmAssociateItemSuppid") })
public class SmmAssociateItemSupp implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_ASSOCIATE_ITEM_SUPPID")
	private Long smmAssociateItemSuppid;
	@JoinColumn(name = "SMM_ITEMMASTERID", referencedColumnName = "SMM_ITEMMASTERID")
	@ManyToOne(optional = false)
	private SmmItemmaster smmItemmasterid;
	@JoinColumn(name = "SMM_SUPPLIERID", referencedColumnName = "SMM_SUPPLIERID")
	@ManyToOne(optional = false)
	private SmmSupplier smmSupplierid;

	public SmmAssociateItemSupp() {
	}

	public SmmAssociateItemSupp(Long smmAssociateItemSuppid) {
		this.smmAssociateItemSuppid = smmAssociateItemSuppid;
	}

	public Long getSmmAssociateItemSuppid() {
		return smmAssociateItemSuppid;
	}

	public void setSmmAssociateItemSuppid(Long smmAssociateItemSuppid) {
		this.smmAssociateItemSuppid = smmAssociateItemSuppid;
	}

	public SmmItemmaster getSmmItemmasterid() {
		return smmItemmasterid;
	}

	public void setSmmItemmasterid(SmmItemmaster smmItemmasterid) {
		this.smmItemmasterid = smmItemmasterid;
	}

	public SmmSupplier getSmmSupplierid() {
		return smmSupplierid;
	}

	public void setSmmSupplierid(SmmSupplier smmSupplierid) {
		this.smmSupplierid = smmSupplierid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmAssociateItemSuppid != null ? smmAssociateItemSuppid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmAssociateItemSupp)) {
			return false;
		}
		SmmAssociateItemSupp other = (SmmAssociateItemSupp) object;
		if ((this.smmAssociateItemSuppid == null && other.smmAssociateItemSuppid != null)
				|| (this.smmAssociateItemSuppid != null
						&& !this.smmAssociateItemSuppid.equals(other.smmAssociateItemSuppid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmAssociateItemSupp[ smmAssociateItemSuppid=" + smmAssociateItemSuppid + " ]";
	}

}
