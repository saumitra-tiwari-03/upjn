/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

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
@Table(name = "PP_PAYALWHEAD")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpPayalwhead.findAll", query = "SELECT p FROM PpPayalwhead p"),
		@NamedQuery(name = "PpPayalwhead.findByPayalwheadid", query = "SELECT p FROM PpPayalwhead p WHERE p.payalwheadid = :payalwheadid"),
		@NamedQuery(name = "PpPayalwhead.findByPayalwname", query = "SELECT p FROM PpPayalwhead p WHERE p.payalwname = :payalwname"),
		@NamedQuery(name = "PpPayalwhead.findByPayalwshortname", query = "SELECT p FROM PpPayalwhead p WHERE p.payalwshortname = :payalwshortname"),
		@NamedQuery(name = "PpPayalwhead.findByPrintOrder", query = "SELECT p FROM PpPayalwhead p WHERE p.printOrder = :printOrder"),
		@NamedQuery(name = "PpPayalwhead.findByPayOrPen", query = "SELECT p FROM PpPayalwhead p WHERE p.payOrPen = :payOrPen") })
public class PpPayalwhead implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PAYALWHEADID")
	private Integer payalwheadid;
	@Basic(optional = false)
	@Column(name = "PAYALWNAME")
	private String payalwname;
	@Basic(optional = false)
	@Column(name = "PAYALWSHORTNAME")
	private String payalwshortname;
	@Basic(optional = false)
	@Column(name = "PRINT_ORDER")
	private int printOrder;
	@Column(name = "PAY_OR_PEN")
	private Character payOrPen;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "payalwheadid")
	private Collection<PpPayalwmaster> ppPayalwmasterCollection;
	@JoinColumn(name = "AC_CODE", referencedColumnName = "FWA_AC_CODE_MASTERID")
	@ManyToOne
	private FwaAcCodeMaster acCode;

	public PpPayalwhead() {
	}

	public PpPayalwhead(Integer payalwheadid) {
		this.payalwheadid = payalwheadid;
	}

	public PpPayalwhead(Integer payalwheadid, String payalwname, String payalwshortname, int printOrder) {
		this.payalwheadid = payalwheadid;
		this.payalwname = payalwname;
		this.payalwshortname = payalwshortname;
		this.printOrder = printOrder;
	}

	public Integer getPayalwheadid() {
		return payalwheadid;
	}

	public void setPayalwheadid(Integer payalwheadid) {
		this.payalwheadid = payalwheadid;
	}

	public String getPayalwname() {
		return payalwname;
	}

	public void setPayalwname(String payalwname) {
		this.payalwname = payalwname;
	}

	public String getPayalwshortname() {
		return payalwshortname;
	}

	public void setPayalwshortname(String payalwshortname) {
		this.payalwshortname = payalwshortname;
	}

	public int getPrintOrder() {
		return printOrder;
	}

	public void setPrintOrder(int printOrder) {
		this.printOrder = printOrder;
	}

	public Character getPayOrPen() {
		return payOrPen;
	}

	public void setPayOrPen(Character payOrPen) {
		this.payOrPen = payOrPen;
	}

	@XmlTransient
	public Collection<PpPayalwmaster> getPpPayalwmasterCollection() {
		return ppPayalwmasterCollection;
	}

	public void setPpPayalwmasterCollection(Collection<PpPayalwmaster> ppPayalwmasterCollection) {
		this.ppPayalwmasterCollection = ppPayalwmasterCollection;
	}

	public FwaAcCodeMaster getAcCode() {
		return acCode;
	}

	public void setAcCode(FwaAcCodeMaster acCode) {
		this.acCode = acCode;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (payalwheadid != null ? payalwheadid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpPayalwhead)) {
			return false;
		}
		PpPayalwhead other = (PpPayalwhead) object;
		if ((this.payalwheadid == null && other.payalwheadid != null)
				|| (this.payalwheadid != null && !this.payalwheadid.equals(other.payalwheadid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpPayalwhead[ payalwheadid=" + payalwheadid + " ]";
	}

}
