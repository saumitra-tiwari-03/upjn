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
@Table(name = "PP_DEDUCTIONMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpDeductionmaster.findAll", query = " FROM PpDeductionmaster "),
		@NamedQuery(name = "PpDeductionmaster.findByPpDeductionmasterid", query = "SELECT p FROM PpDeductionmaster p WHERE p.ppDeductionmasterid = :ppDeductionmasterid"),
		@NamedQuery(name = "PpDeductionmaster.findByDeductionname", query = "SELECT p FROM PpDeductionmaster p WHERE p.deductionname = :deductionname"),
		@NamedQuery(name = "PpDeductionmaster.findByDedshortname", query = "SELECT p FROM PpDeductionmaster p WHERE p.dedshortname = :dedshortname"),
		@NamedQuery(name = "PpDeductionmaster.findByPrintOrder", query = "SELECT p FROM PpDeductionmaster p WHERE p.printOrder = :printOrder") })
public class PpDeductionmaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_DEDUCTIONMASTERID")
	private Integer ppDeductionmasterid;
	@Basic(optional = false)
	@Column(name = "DEDUCTIONNAME")
	private String deductionname;
	@Basic(optional = false)
	@Column(name = "DEDSHORTNAME")
	private String dedshortname;
	@Column(name = "PRINT_ORDER")
	private Short printOrder;
	@JoinColumn(name = "AC_CODE", referencedColumnName = "FWA_AC_CODE_MASTERID")
	@ManyToOne
	private FwaAcCodeMaster acCode;
	@JoinColumn(name = "PP_SCHEDULEMASTERID", referencedColumnName = "PP_SCHEDULEMASTERID")
	@ManyToOne(optional = false)
	private PpSchedulemaster ppSchedulemasterid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppDeductionmasterid")
	private Collection<PpDedRulesdetail> ppDedRulesdetailCollection;

	public PpDeductionmaster() {
	}

	public PpDeductionmaster(Integer ppDeductionmasterid) {
		this.ppDeductionmasterid = ppDeductionmasterid;
	}

	public PpDeductionmaster(Integer ppDeductionmasterid, String deductionname, String dedshortname) {
		this.ppDeductionmasterid = ppDeductionmasterid;
		this.deductionname = deductionname;
		this.dedshortname = dedshortname;
	}

	public Integer getPpDeductionmasterid() {
		return ppDeductionmasterid;
	}

	public void setPpDeductionmasterid(Integer ppDeductionmasterid) {
		this.ppDeductionmasterid = ppDeductionmasterid;
	}

	public String getDeductionname() {
		return deductionname;
	}

	public void setDeductionname(String deductionname) {
		this.deductionname = deductionname;
	}

	public String getDedshortname() {
		return dedshortname;
	}

	public void setDedshortname(String dedshortname) {
		this.dedshortname = dedshortname;
	}

	public Short getPrintOrder() {
		return printOrder;
	}

	public void setPrintOrder(Short printOrder) {
		this.printOrder = printOrder;
	}

	public FwaAcCodeMaster getAcCode() {
		return acCode;
	}

	public void setAcCode(FwaAcCodeMaster acCode) {
		this.acCode = acCode;
	}

	public PpSchedulemaster getPpSchedulemasterid() {
		return ppSchedulemasterid;
	}

	public void setPpSchedulemasterid(PpSchedulemaster ppSchedulemasterid) {
		this.ppSchedulemasterid = ppSchedulemasterid;
	}

	@XmlTransient
	public Collection<PpDedRulesdetail> getPpDedRulesdetailCollection() {
		return ppDedRulesdetailCollection;
	}

	public void setPpDedRulesdetailCollection(Collection<PpDedRulesdetail> ppDedRulesdetailCollection) {
		this.ppDedRulesdetailCollection = ppDedRulesdetailCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppDeductionmasterid != null ? ppDeductionmasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpDeductionmaster)) {
			return false;
		}
		PpDeductionmaster other = (PpDeductionmaster) object;
		if ((this.ppDeductionmasterid == null && other.ppDeductionmasterid != null)
				|| (this.ppDeductionmasterid != null && !this.ppDeductionmasterid.equals(other.ppDeductionmasterid))) {
			return false;
		}
		return true;
	}

	

}
