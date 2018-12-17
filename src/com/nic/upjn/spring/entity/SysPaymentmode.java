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
@Table(name = "SYS_PAYMENTMODE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SysPaymentmode.findAll", query = "SELECT s FROM SysPaymentmode s"),
		@NamedQuery(name = "SysPaymentmode.findBySysPaymentmodeid", query = "SELECT s FROM SysPaymentmode s WHERE s.sysPaymentmodeid = ?"),
		@NamedQuery(name = "SysPaymentmode.findByPaymentmode", query = "SELECT s FROM SysPaymentmode s WHERE s.paymentmode = :paymentmode") })
public class SysPaymentmode implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SYS_PAYMENTMODEID")
	private Short sysPaymentmodeid;
	@Basic(optional = false)
	@Column(name = "PAYMENTMODE")
	private String paymentmode;

	public SysPaymentmode() {
	}

	public SysPaymentmode(Short sysPaymentmodeid) {
		this.sysPaymentmodeid = sysPaymentmodeid;
	}

	public SysPaymentmode(Short sysPaymentmodeid, String paymentmode) {
		this.sysPaymentmodeid = sysPaymentmodeid;
		this.paymentmode = paymentmode;
	}

	public Short getSysPaymentmodeid() {
		return sysPaymentmodeid;
	}

	public void setSysPaymentmodeid(Short sysPaymentmodeid) {
		this.sysPaymentmodeid = sysPaymentmodeid;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (sysPaymentmodeid != null ? sysPaymentmodeid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SysPaymentmode)) {
			return false;
		}
		SysPaymentmode other = (SysPaymentmode) object;
		if ((this.sysPaymentmodeid == null && other.sysPaymentmodeid != null)
				|| (this.sysPaymentmodeid != null && !this.sysPaymentmodeid.equals(other.sysPaymentmodeid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SysPaymentmode[ sysPaymentmodeid=" + sysPaymentmodeid + " ]";
	}

}
