/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_TERMINATIONDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpTerminationdetail.findAll", query = "SELECT p FROM PpTerminationdetail p"),
		@NamedQuery(name = "PpTerminationdetail.findByPpTerminationdetailid", query = "SELECT p FROM PpTerminationdetail p WHERE p.ppTerminationdetailid = :ppTerminationdetailid"),
		@NamedQuery(name = "PpTerminationdetail.findByTerminationordno", query = "SELECT p FROM PpTerminationdetail p WHERE p.terminationordno = :terminationordno"),
		@NamedQuery(name = "PpTerminationdetail.findByTerminationorddate", query = "SELECT p FROM PpTerminationdetail p WHERE p.terminationorddate = :terminationorddate"),
		@NamedQuery(name = "PpTerminationdetail.findByOrderauthname", query = "SELECT p FROM PpTerminationdetail p WHERE p.orderauthname = :orderauthname"),
		@NamedQuery(name = "PpTerminationdetail.findByOrderauthdesig", query = "SELECT p FROM PpTerminationdetail p WHERE p.orderauthdesig = :orderauthdesig"),
		@NamedQuery(name = "PpTerminationdetail.findByEffectivedate", query = "SELECT p FROM PpTerminationdetail p WHERE p.effectivedate = :effectivedate"),
		@NamedQuery(name = "PpTerminationdetail.findByIsreinstate", query = "SELECT p FROM PpTerminationdetail p WHERE p.isreinstate = :isreinstate"),
		@NamedQuery(name = "PpTerminationdetail.findByReinstateorderdetail", query = "SELECT p FROM PpTerminationdetail p WHERE p.reinstateorderdetail = :reinstateorderdetail"),
		@NamedQuery(name = "PpTerminationdetail.findByReinstateeffectdate", query = "SELECT p FROM PpTerminationdetail p WHERE p.reinstateeffectdate = :reinstateeffectdate"),
		@NamedQuery(name = "PpTerminationdetail.findByReasonfortermination", query = "SELECT p FROM PpTerminationdetail p WHERE p.reasonfortermination = :reasonfortermination") })
public class PpTerminationdetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_TERMINATIONDETAILID")
	private Long ppTerminationdetailid;
	@Basic(optional = false)
	@Column(name = "TERMINATIONORDNO")
	private String terminationordno;
	@Basic(optional = false)
	@Column(name = "TERMINATIONORDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date terminationorddate;
	@Basic(optional = false)
	@Column(name = "ORDERAUTHNAME")
	private String orderauthname;
	@Basic(optional = false)
	@Column(name = "ORDERAUTHDESIG")
	private String orderauthdesig;
	@Basic(optional = false)
	@Column(name = "EFFECTIVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date effectivedate;
	@Basic(optional = false)
	@Column(name = "ISREINSTATE")
	private String isreinstate;
	@Column(name = "REINSTATEORDERDETAIL")
	private String reinstateorderdetail;
	@Column(name = "REINSTATEEFFECTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reinstateeffectdate;
	@Column(name = "REASONFORTERMINATION")
	private String reasonfortermination;
	@Column(name = "EVENTOFFICEID")
	private String eventofficeid;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long  ppEmployeemasterid;

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public PpTerminationdetail() {
	}

	public PpTerminationdetail(Long ppTerminationdetailid) {
		this.ppTerminationdetailid = ppTerminationdetailid;
	}

	public PpTerminationdetail(Long ppTerminationdetailid, String terminationordno, Date terminationorddate,
			String orderauthname, String orderauthdesig, Date effectivedate, String isreinstate) {
		this.ppTerminationdetailid = ppTerminationdetailid;
		this.terminationordno = terminationordno;
		this.terminationorddate = terminationorddate;
		this.orderauthname = orderauthname;
		this.orderauthdesig = orderauthdesig;
		this.effectivedate = effectivedate;
		this.isreinstate = isreinstate;
	}

	public Long getPpTerminationdetailid() {
		return ppTerminationdetailid;
	}

	public void setPpTerminationdetailid(Long ppTerminationdetailid) {
		this.ppTerminationdetailid = ppTerminationdetailid;
	}

	public String getTerminationordno() {
		return terminationordno;
	}

	public void setTerminationordno(String terminationordno) {
		this.terminationordno = terminationordno;
	}

	public Date getTerminationorddate() {
		return terminationorddate;
	}

	public void setTerminationorddate(Date terminationorddate) {
		this.terminationorddate = terminationorddate;
	}

	public String getOrderauthname() {
		return orderauthname;
	}

	public void setOrderauthname(String orderauthname) {
		this.orderauthname = orderauthname;
	}

	public String getOrderauthdesig() {
		return orderauthdesig;
	}

	public void setOrderauthdesig(String orderauthdesig) {
		this.orderauthdesig = orderauthdesig;
	}

	public Date getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}

	public String getIsreinstate() {
		return isreinstate;
	}

	public void setIsreinstate(String isreinstate) {
		this.isreinstate = isreinstate;
	}

	public String getReinstateorderdetail() {
		return reinstateorderdetail;
	}

	public void setReinstateorderdetail(String reinstateorderdetail) {
		this.reinstateorderdetail = reinstateorderdetail;
	}

	public Date getReinstateeffectdate() {
		return reinstateeffectdate;
	}

	public void setReinstateeffectdate(Date reinstateeffectdate) {
		this.reinstateeffectdate = reinstateeffectdate;
	}

	public String getReasonfortermination() {
		return reasonfortermination;
	}

	public void setReasonfortermination(String reasonfortermination) {
		this.reasonfortermination = reasonfortermination;
	}

	

	public String getEventofficeid() {
		return eventofficeid;
	}

	public void setEventofficeid(String eventofficeid) {
		this.eventofficeid = eventofficeid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppTerminationdetailid != null ? ppTerminationdetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpTerminationdetail)) {
			return false;
		}
		PpTerminationdetail other = (PpTerminationdetail) object;
		if ((this.ppTerminationdetailid == null && other.ppTerminationdetailid != null)
				|| (this.ppTerminationdetailid != null
						&& !this.ppTerminationdetailid.equals(other.ppTerminationdetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpTerminationdetail[ ppTerminationdetailid=" + ppTerminationdetailid + " ]";
	}

}
