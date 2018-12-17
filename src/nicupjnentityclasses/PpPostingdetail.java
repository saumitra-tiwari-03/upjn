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
@Table(name = "PP_POSTINGDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpPostingdetail.findAll", query = "SELECT p FROM PpPostingdetail p"),
		@NamedQuery(name = "PpPostingdetail.findByPpPostingdetailid", query = "SELECT p FROM PpPostingdetail p WHERE p.ppPostingdetailid = :ppPostingdetailid"),
		@NamedQuery(name = "PpPostingdetail.findByPpDesignationmasterid", query = "SELECT p FROM PpPostingdetail p WHERE p.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "PpPostingdetail.findByEffectivedate", query = "SELECT p FROM PpPostingdetail p WHERE p.effectivedate = :effectivedate"),
		@NamedQuery(name = "PpPostingdetail.findByPostingorderno", query = "SELECT p FROM PpPostingdetail p WHERE p.postingorderno = :postingorderno"),
		@NamedQuery(name = "PpPostingdetail.findByOrderdate", query = "SELECT p FROM PpPostingdetail p WHERE p.orderdate = :orderdate"),
		@NamedQuery(name = "PpPostingdetail.findByJoindate", query = "SELECT p FROM PpPostingdetail p WHERE p.joindate = :joindate"),
		@NamedQuery(name = "PpPostingdetail.findByJoinanfn", query = "SELECT p FROM PpPostingdetail p WHERE p.joinanfn = :joinanfn"),
		@NamedQuery(name = "PpPostingdetail.findByRmOfficeid", query = "SELECT p FROM PpPostingdetail p WHERE p.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "PpPostingdetail.findByIsPromotionForego", query = "SELECT p FROM PpPostingdetail p WHERE p.isPromotionForego = :isPromotionForego"),
		@NamedQuery(name = "PpPostingdetail.findByModeofposting", query = "SELECT p FROM PpPostingdetail p WHERE p.modeofposting = :modeofposting") })
public class PpPostingdetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_POSTINGDETAILID")
	private Long ppPostingdetailid;
	@Basic(optional = false)
	@Column(name = "PP_DESIGNATIONMASTERID")
	private int ppDesignationmasterid;
	@Column(name = "EFFECTIVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date effectivedate;
	@Basic(optional = false)
	@Column(name = "POSTINGORDERNO")
	private String postingorderno;
	@Basic(optional = false)
	@Column(name = "ORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderdate;
	@Column(name = "JOINDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date joindate;
	@Column(name = "JOINANFN")
	private String joinanfn;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Column(name = "IS_PROMOTION_FOREGO")
	private Character isPromotionForego;
	@Column(name = "MODEOFPOSTING")
	private Short modeofposting;
	@OneToMany(mappedBy = "nextpostingid")
	private Collection<PpDeputationdetail> ppDeputationdetailCollection;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppPostingdetailid")
	private Collection<PpCurrentstatus> ppCurrentstatusCollection;

	public PpPostingdetail() {
	}

	public PpPostingdetail(Long ppPostingdetailid) {
		this.ppPostingdetailid = ppPostingdetailid;
	}

	public PpPostingdetail(Long ppPostingdetailid, int ppDesignationmasterid, String postingorderno, Date orderdate,
			int rmOfficeid) {
		this.ppPostingdetailid = ppPostingdetailid;
		this.ppDesignationmasterid = ppDesignationmasterid;
		this.postingorderno = postingorderno;
		this.orderdate = orderdate;
		this.rmOfficeid = rmOfficeid;
	}

	public Long getPpPostingdetailid() {
		return ppPostingdetailid;
	}

	public void setPpPostingdetailid(Long ppPostingdetailid) {
		this.ppPostingdetailid = ppPostingdetailid;
	}

	public int getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(int ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public Date getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}

	public String getPostingorderno() {
		return postingorderno;
	}

	public void setPostingorderno(String postingorderno) {
		this.postingorderno = postingorderno;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getJoinanfn() {
		return joinanfn;
	}

	public void setJoinanfn(String joinanfn) {
		this.joinanfn = joinanfn;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Character getIsPromotionForego() {
		return isPromotionForego;
	}

	public void setIsPromotionForego(Character isPromotionForego) {
		this.isPromotionForego = isPromotionForego;
	}

	public Short getModeofposting() {
		return modeofposting;
	}

	public void setModeofposting(Short modeofposting) {
		this.modeofposting = modeofposting;
	}

	@XmlTransient
	public Collection<PpDeputationdetail> getPpDeputationdetailCollection() {
		return ppDeputationdetailCollection;
	}

	public void setPpDeputationdetailCollection(Collection<PpDeputationdetail> ppDeputationdetailCollection) {
		this.ppDeputationdetailCollection = ppDeputationdetailCollection;
	}

	public PpEmployeemaster getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(PpEmployeemaster ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	@XmlTransient
	public Collection<PpCurrentstatus> getPpCurrentstatusCollection() {
		return ppCurrentstatusCollection;
	}

	public void setPpCurrentstatusCollection(Collection<PpCurrentstatus> ppCurrentstatusCollection) {
		this.ppCurrentstatusCollection = ppCurrentstatusCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppPostingdetailid != null ? ppPostingdetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpPostingdetail)) {
			return false;
		}
		PpPostingdetail other = (PpPostingdetail) object;
		if ((this.ppPostingdetailid == null && other.ppPostingdetailid != null)
				|| (this.ppPostingdetailid != null && !this.ppPostingdetailid.equals(other.ppPostingdetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpPostingdetail[ ppPostingdetailid=" + ppPostingdetailid + " ]";
	}

}
