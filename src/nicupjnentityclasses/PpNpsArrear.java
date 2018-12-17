/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigInteger;

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
@Table(name = "PP_NPS_ARREAR")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpNpsArrear.findAll", query = "SELECT p FROM PpNpsArrear p"),
		@NamedQuery(name = "PpNpsArrear.findByPpNpsArrearid", query = "SELECT p FROM PpNpsArrear p WHERE p.ppNpsArrearid = :ppNpsArrearid"),
		@NamedQuery(name = "PpNpsArrear.findByNpsArrearname", query = "SELECT p FROM PpNpsArrear p WHERE p.npsArrearname = :npsArrearname"),
		@NamedQuery(name = "PpNpsArrear.findByNpstype", query = "SELECT p FROM PpNpsArrear p WHERE p.npstype = :npstype"),
		@NamedQuery(name = "PpNpsArrear.findByPrintOrder", query = "SELECT p FROM PpNpsArrear p WHERE p.printOrder = :printOrder"),
		@NamedQuery(name = "PpNpsArrear.findByShortNpsArrearname", query = "SELECT p FROM PpNpsArrear p WHERE p.shortNpsArrearname = :shortNpsArrearname"),
		@NamedQuery(name = "PpNpsArrear.findByPpSchedulemasterid", query = "SELECT p FROM PpNpsArrear p WHERE p.ppSchedulemasterid = :ppSchedulemasterid") })
public class PpNpsArrear implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_NPS_ARREARID")
	private Long ppNpsArrearid;
	@Column(name = "NPS_ARREARNAME")
	private String npsArrearname;
	@Column(name = "NPSTYPE")
	private String npstype;
	@Column(name = "PRINT_ORDER")
	private Integer printOrder;
	@Column(name = "SHORT_NPS_ARREARNAME")
	private String shortNpsArrearname;
	@Column(name = "PP_SCHEDULEMASTERID")
	private BigInteger ppSchedulemasterid;

	public PpNpsArrear() {
	}

	public PpNpsArrear(Long ppNpsArrearid) {
		this.ppNpsArrearid = ppNpsArrearid;
	}

	public Long getPpNpsArrearid() {
		return ppNpsArrearid;
	}

	public void setPpNpsArrearid(Long ppNpsArrearid) {
		this.ppNpsArrearid = ppNpsArrearid;
	}

	public String getNpsArrearname() {
		return npsArrearname;
	}

	public void setNpsArrearname(String npsArrearname) {
		this.npsArrearname = npsArrearname;
	}

	public String getNpstype() {
		return npstype;
	}

	public void setNpstype(String npstype) {
		this.npstype = npstype;
	}

	public Integer getPrintOrder() {
		return printOrder;
	}

	public void setPrintOrder(Integer printOrder) {
		this.printOrder = printOrder;
	}

	public String getShortNpsArrearname() {
		return shortNpsArrearname;
	}

	public void setShortNpsArrearname(String shortNpsArrearname) {
		this.shortNpsArrearname = shortNpsArrearname;
	}

	public BigInteger getPpSchedulemasterid() {
		return ppSchedulemasterid;
	}

	public void setPpSchedulemasterid(BigInteger ppSchedulemasterid) {
		this.ppSchedulemasterid = ppSchedulemasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppNpsArrearid != null ? ppNpsArrearid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpNpsArrear)) {
			return false;
		}
		PpNpsArrear other = (PpNpsArrear) object;
		if ((this.ppNpsArrearid == null && other.ppNpsArrearid != null)
				|| (this.ppNpsArrearid != null && !this.ppNpsArrearid.equals(other.ppNpsArrearid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpNpsArrear[ ppNpsArrearid=" + ppNpsArrearid + " ]";
	}

}
