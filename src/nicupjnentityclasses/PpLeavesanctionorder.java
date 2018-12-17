/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

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
@Table(name = "PP_LEAVESANCTIONORDER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpLeavesanctionorder.findAll", query = "SELECT p FROM PpLeavesanctionorder p"),
		@NamedQuery(name = "PpLeavesanctionorder.findByPpLeavesanctionorderid", query = "SELECT p FROM PpLeavesanctionorder p WHERE p.ppLeavesanctionorderid = :ppLeavesanctionorderid"),
		@NamedQuery(name = "PpLeavesanctionorder.findBySanctionorderno", query = "SELECT p FROM PpLeavesanctionorder p WHERE p.sanctionorderno = :sanctionorderno"),
		@NamedQuery(name = "PpLeavesanctionorder.findBySanctionorderdate", query = "SELECT p FROM PpLeavesanctionorder p WHERE p.sanctionorderdate = :sanctionorderdate"),
		@NamedQuery(name = "PpLeavesanctionorder.findBySanctioningauthority", query = "SELECT p FROM PpLeavesanctionorder p WHERE p.sanctioningauthority = :sanctioningauthority") })
public class PpLeavesanctionorder implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_LEAVESANCTIONORDERID")
	private Long ppLeavesanctionorderid;
	@Basic(optional = false)
	@Column(name = "SANCTIONORDERNO")
	private String sanctionorderno;
	@Basic(optional = false)
	@Column(name = "SANCTIONORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sanctionorderdate;
	@Basic(optional = false)
	@Column(name = "SANCTIONINGAUTHORITY")
	private String sanctioningauthority;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppLeavesanctionorderid")
	private Collection<PpAvailedleavedetail> ppAvailedleavedetailCollection;

	public PpLeavesanctionorder() {
	}

	public PpLeavesanctionorder(Long ppLeavesanctionorderid) {
		this.ppLeavesanctionorderid = ppLeavesanctionorderid;
	}

	public PpLeavesanctionorder(Long ppLeavesanctionorderid, String sanctionorderno, Date sanctionorderdate,
			String sanctioningauthority) {
		this.ppLeavesanctionorderid = ppLeavesanctionorderid;
		this.sanctionorderno = sanctionorderno;
		this.sanctionorderdate = sanctionorderdate;
		this.sanctioningauthority = sanctioningauthority;
	}

	public Long getPpLeavesanctionorderid() {
		return ppLeavesanctionorderid;
	}

	public void setPpLeavesanctionorderid(Long ppLeavesanctionorderid) {
		this.ppLeavesanctionorderid = ppLeavesanctionorderid;
	}

	public String getSanctionorderno() {
		return sanctionorderno;
	}

	public void setSanctionorderno(String sanctionorderno) {
		this.sanctionorderno = sanctionorderno;
	}

	public Date getSanctionorderdate() {
		return sanctionorderdate;
	}

	public void setSanctionorderdate(Date sanctionorderdate) {
		this.sanctionorderdate = sanctionorderdate;
	}

	public String getSanctioningauthority() {
		return sanctioningauthority;
	}

	public void setSanctioningauthority(String sanctioningauthority) {
		this.sanctioningauthority = sanctioningauthority;
	}

	@XmlTransient
	public Collection<PpAvailedleavedetail> getPpAvailedleavedetailCollection() {
		return ppAvailedleavedetailCollection;
	}

	public void setPpAvailedleavedetailCollection(Collection<PpAvailedleavedetail> ppAvailedleavedetailCollection) {
		this.ppAvailedleavedetailCollection = ppAvailedleavedetailCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppLeavesanctionorderid != null ? ppLeavesanctionorderid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpLeavesanctionorder)) {
			return false;
		}
		PpLeavesanctionorder other = (PpLeavesanctionorder) object;
		if ((this.ppLeavesanctionorderid == null && other.ppLeavesanctionorderid != null)
				|| (this.ppLeavesanctionorderid != null
						&& !this.ppLeavesanctionorderid.equals(other.ppLeavesanctionorderid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpLeavesanctionorder[ ppLeavesanctionorderid=" + ppLeavesanctionorderid + " ]";
	}

}
