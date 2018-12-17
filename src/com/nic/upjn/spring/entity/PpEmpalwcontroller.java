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
@Table(name = "PP_EMPALWCONTROLLER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpEmpalwcontroller.findAll", query = "SELECT p FROM PpEmpalwcontroller p"),
	@NamedQuery(name = "PpEmpalwcontroller.findByPpEmployeemasteridbasicpay", query = "FROM PpEmpalwcontroller WHERE ppEmployeemasterid = ? and ppPayalwmasterid='570'"),
	@NamedQuery(name = "PpEmpalwcontroller.findByPpEmployeemasteridgradepay", query = "FROM PpEmpalwcontroller WHERE ppEmployeemasterid = ? and ppPayalwmasterid='575'"),
		@NamedQuery(name = "PpEmpalwcontroller.findByPpEmpalwcontrollerid", query = "SELECT p FROM PpEmpalwcontroller p WHERE p.ppEmpalwcontrollerid = :ppEmpalwcontrollerid"),
		@NamedQuery(name = "PpEmpalwcontroller.findByAmount", query = "SELECT p FROM PpEmpalwcontroller p WHERE p.amount = :amount"),
		@NamedQuery(name = "PpEmpalwcontroller.findByStopAlwFlag", query = "SELECT p FROM PpEmpalwcontroller p WHERE p.stopAlwFlag = :stopAlwFlag") })
public class PpEmpalwcontroller implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPALWCONTROLLERID")
	private Long ppEmpalwcontrollerid;
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private long amount;
	@Basic(optional = false)
	@Column(name = "STOP_ALW_FLAG")
	private Character stopAlwFlag;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "PP_PAYALWMASTERID")
	private long ppPayalwmasterid;
	/*@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;
	@JoinColumn(name = "PP_PAYALWMASTERID", referencedColumnName = "PP_PAYALWMASTERID")
	@ManyToOne(optional = false)
	private PpPayalwmaster ppPayalwmasterid;*/

	public PpEmpalwcontroller() {
	}

	public PpEmpalwcontroller(Long ppEmpalwcontrollerid) {
		this.ppEmpalwcontrollerid = ppEmpalwcontrollerid;
	}

	public PpEmpalwcontroller(Long ppEmpalwcontrollerid, long amount, Character stopAlwFlag) {
		this.ppEmpalwcontrollerid = ppEmpalwcontrollerid;
		this.amount = amount;
		this.stopAlwFlag = stopAlwFlag;
	}

	public Long getPpEmpalwcontrollerid() {
		return ppEmpalwcontrollerid;
	}

	public void setPpEmpalwcontrollerid(Long ppEmpalwcontrollerid) {
		this.ppEmpalwcontrollerid = ppEmpalwcontrollerid;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Character getStopAlwFlag() {
		return stopAlwFlag;
	}

	public void setStopAlwFlag(Character stopAlwFlag) {
		this.stopAlwFlag = stopAlwFlag;
	}

	

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public long getPpPayalwmasterid() {
		return ppPayalwmasterid;
	}

	public void setPpPayalwmasterid(long ppPayalwmasterid) {
		this.ppPayalwmasterid = ppPayalwmasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppEmpalwcontrollerid != null ? ppEmpalwcontrollerid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpEmpalwcontroller)) {
			return false;
		}
		PpEmpalwcontroller other = (PpEmpalwcontroller) object;
		if ((this.ppEmpalwcontrollerid == null && other.ppEmpalwcontrollerid != null)
				|| (this.ppEmpalwcontrollerid != null
						&& !this.ppEmpalwcontrollerid.equals(other.ppEmpalwcontrollerid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpEmpalwcontroller[ ppEmpalwcontrollerid=" + ppEmpalwcontrollerid + " ]";
	}

}
