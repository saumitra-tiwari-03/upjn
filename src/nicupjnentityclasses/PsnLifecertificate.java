/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PSN_LIFECERTIFICATE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PsnLifecertificate.findAll", query = "SELECT p FROM PsnLifecertificate p"),
		@NamedQuery(name = "PsnLifecertificate.findByPsnLifecertificateid", query = "SELECT p FROM PsnLifecertificate p WHERE p.psnLifecertificateid = :psnLifecertificateid"),
		@NamedQuery(name = "PsnLifecertificate.findByLifevaliddate", query = "SELECT p FROM PsnLifecertificate p WHERE p.lifevaliddate = :lifevaliddate"),
		@NamedQuery(name = "PsnLifecertificate.findByIslive", query = "SELECT p FROM PsnLifecertificate p WHERE p.islive = :islive"),
		@NamedQuery(name = "PsnLifecertificate.findByBlockpension", query = "SELECT p FROM PsnLifecertificate p WHERE p.blockpension = :blockpension") })
public class PsnLifecertificate implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PSN_LIFECERTIFICATEID")
	private Long psnLifecertificateid;
	@Basic(optional = false)
	@Column(name = "LIFEVALIDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lifevaliddate;
	@Basic(optional = false)
	@Column(name = "ISLIVE")
	private Character islive;
	@Basic(optional = false)
	@Column(name = "BLOCKPENSION")
	private Character blockpension;
	@JoinColumn(name = "PSN_EMPLOYEEPENSION_MASTERID", referencedColumnName = "PSN_EMPLOYEEPENSION_MASTERID")
	@OneToOne(optional = false)
	private PsnEmployeepensionMaster psnEmployeepensionMasterid;

	public PsnLifecertificate() {
	}

	public PsnLifecertificate(Long psnLifecertificateid) {
		this.psnLifecertificateid = psnLifecertificateid;
	}

	public PsnLifecertificate(Long psnLifecertificateid, Date lifevaliddate, Character islive, Character blockpension) {
		this.psnLifecertificateid = psnLifecertificateid;
		this.lifevaliddate = lifevaliddate;
		this.islive = islive;
		this.blockpension = blockpension;
	}

	public Long getPsnLifecertificateid() {
		return psnLifecertificateid;
	}

	public void setPsnLifecertificateid(Long psnLifecertificateid) {
		this.psnLifecertificateid = psnLifecertificateid;
	}

	public Date getLifevaliddate() {
		return lifevaliddate;
	}

	public void setLifevaliddate(Date lifevaliddate) {
		this.lifevaliddate = lifevaliddate;
	}

	public Character getIslive() {
		return islive;
	}

	public void setIslive(Character islive) {
		this.islive = islive;
	}

	public Character getBlockpension() {
		return blockpension;
	}

	public void setBlockpension(Character blockpension) {
		this.blockpension = blockpension;
	}

	public PsnEmployeepensionMaster getPsnEmployeepensionMasterid() {
		return psnEmployeepensionMasterid;
	}

	public void setPsnEmployeepensionMasterid(PsnEmployeepensionMaster psnEmployeepensionMasterid) {
		this.psnEmployeepensionMasterid = psnEmployeepensionMasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (psnLifecertificateid != null ? psnLifecertificateid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PsnLifecertificate)) {
			return false;
		}
		PsnLifecertificate other = (PsnLifecertificate) object;
		if ((this.psnLifecertificateid == null && other.psnLifecertificateid != null)
				|| (this.psnLifecertificateid != null
						&& !this.psnLifecertificateid.equals(other.psnLifecertificateid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PsnLifecertificate[ psnLifecertificateid=" + psnLifecertificateid + " ]";
	}

}
