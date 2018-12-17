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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_LOANMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpLoanmaster.findAll", query = "SELECT p FROM PpLoanmaster p"),
		@NamedQuery(name = "PpLoanmaster.findByPpLoanmasterid", query = "FROM PpLoanmaster WHERE ppLoanmasterid = ?"),
		@NamedQuery(name = "PpLoanmaster.findByLoanname", query = "SELECT p FROM PpLoanmaster p WHERE p.loanname = :loanname"),
		@NamedQuery(name = "PpLoanmaster.findByLoanshortname", query = "SELECT p FROM PpLoanmaster p WHERE p.loanshortname = :loanshortname"),
		@NamedQuery(name = "PpLoanmaster.findByPrintOrder", query = "SELECT p FROM PpLoanmaster p WHERE p.printOrder = :printOrder"),
		@NamedQuery(name = "PpLoanmaster.findByMaxInstallmentno", query = "SELECT p FROM PpLoanmaster p WHERE p.maxInstallmentno = :maxInstallmentno") })
public class PpLoanmaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_PP_LOANMASTER", allocationSize = 1)
	@Id
	@Basic(optional = false)
	@Column(name = "PP_LOANMASTERID")
	private Short ppLoanmasterid;
	@Basic(optional = false)
	@Column(name = "LOANNAME")
	private String loanname;
	@Basic(optional = false)
	@Column(name = "LOANSHORTNAME")
	private String loanshortname;
	@Basic(optional = false)
	@Column(name = "PRINT_ORDER")
	private short printOrder;
	@Basic(optional = false)
	@Column(name = "MAX_INSTALLMENTNO")
	private short maxInstallmentno;
	@Column(name = "AC_CODE")
	private String acCode;
	@Column(name = "PP_SCHEDULEMASTERID")
	@Basic(optional = false)
	private Integer ppSchedulemasterid;
	
	
	

	public String getAcCode() {
		return acCode;
	}

	public void setAcCode(String acCode) {
		this.acCode = acCode;
	}

	public Integer getPpSchedulemasterid() {
		return ppSchedulemasterid;
	}

	public void setPpSchedulemasterid(Integer ppSchedulemasterid) {
		this.ppSchedulemasterid = ppSchedulemasterid;
	}

	public PpLoanmaster() {
	}

	public PpLoanmaster(Short ppLoanmasterid) {
		this.ppLoanmasterid = ppLoanmasterid;
	}

	public PpLoanmaster(Short ppLoanmasterid, String loanname, String loanshortname, short printOrder,
			short maxInstallmentno) {
		this.ppLoanmasterid = ppLoanmasterid;
		this.loanname = loanname;
		this.loanshortname = loanshortname;
		this.printOrder = printOrder;
		this.maxInstallmentno = maxInstallmentno;
	}

	public Short getPpLoanmasterid() {
		return ppLoanmasterid;
	}

	public void setPpLoanmasterid(Short ppLoanmasterid) {
		this.ppLoanmasterid = ppLoanmasterid;
	}

	public String getLoanname() {
		return loanname;
	}

	public void setLoanname(String loanname) {
		this.loanname = loanname;
	}

	public String getLoanshortname() {
		return loanshortname;
	}

	public void setLoanshortname(String loanshortname) {
		this.loanshortname = loanshortname;
	}

	public short getPrintOrder() {
		return printOrder;
	}

	public void setPrintOrder(short printOrder) {
		this.printOrder = printOrder;
	}

	public short getMaxInstallmentno() {
		return maxInstallmentno;
	}

	public void setMaxInstallmentno(short maxInstallmentno) {
		this.maxInstallmentno = maxInstallmentno;
	}

	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppLoanmasterid != null ? ppLoanmasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpLoanmaster)) {
			return false;
		}
		PpLoanmaster other = (PpLoanmaster) object;
		if ((this.ppLoanmasterid == null && other.ppLoanmasterid != null)
				|| (this.ppLoanmasterid != null && !this.ppLoanmasterid.equals(other.ppLoanmasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpLoanmaster[ ppLoanmasterid=" + ppLoanmasterid + " ]";
	}

}
