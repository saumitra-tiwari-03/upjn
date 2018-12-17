/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "PSN_MONTHLYPAY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PsnMonthlypay.findAll", query = "SELECT p FROM PsnMonthlypay p"),
		@NamedQuery(name = "PsnMonthlypay.findByPsnMonthlypayid", query = "SELECT p FROM PsnMonthlypay p WHERE p.psnMonthlypayid = :psnMonthlypayid"),
		@NamedQuery(name = "PsnMonthlypay.findByPayyear", query = "SELECT p FROM PsnMonthlypay p WHERE p.payyear = :payyear"),
		@NamedQuery(name = "PsnMonthlypay.findByPaymonth", query = "SELECT p FROM PsnMonthlypay p WHERE p.paymonth = :paymonth"),
		@NamedQuery(name = "PsnMonthlypay.findByPpNetpension", query = "SELECT p FROM PsnMonthlypay p WHERE p.ppNetpension = :ppNetpension"),
		@NamedQuery(name = "PsnMonthlypay.findByAcCode", query = "SELECT p FROM PsnMonthlypay p WHERE p.acCode = :acCode") })
public class PsnMonthlypay implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PSN_MONTHLYPAYID")
	private Long psnMonthlypayid;
	@Basic(optional = false)
	@Column(name = "PAYYEAR")
	private short payyear;
	@Basic(optional = false)
	@Column(name = "PAYMONTH")
	private short paymonth;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "PP_NETPENSION")
	private BigDecimal ppNetpension;
	@Column(name = "AC_CODE")
	private String acCode;
	@JoinColumn(name = "PSN_EMPLOYEEPENSION_MASTERID", referencedColumnName = "PSN_EMPLOYEEPENSION_MASTERID")
	@ManyToOne(optional = false)
	private PsnEmployeepensionMaster psnEmployeepensionMasterid;
	@JoinColumn(name = "PSN_PAYBILLDETAILID", referencedColumnName = "PSN_PAYBILLDETAILID")
	@ManyToOne(optional = false)
	private PsnPaybilldetail psnPaybilldetailid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "psnMonthlypayid")
	private Collection<PsnMonthlypayTran> psnMonthlypayTranCollection;

	public PsnMonthlypay() {
	}

	public PsnMonthlypay(Long psnMonthlypayid) {
		this.psnMonthlypayid = psnMonthlypayid;
	}

	public PsnMonthlypay(Long psnMonthlypayid, short payyear, short paymonth, BigDecimal ppNetpension) {
		this.psnMonthlypayid = psnMonthlypayid;
		this.payyear = payyear;
		this.paymonth = paymonth;
		this.ppNetpension = ppNetpension;
	}

	public Long getPsnMonthlypayid() {
		return psnMonthlypayid;
	}

	public void setPsnMonthlypayid(Long psnMonthlypayid) {
		this.psnMonthlypayid = psnMonthlypayid;
	}

	public short getPayyear() {
		return payyear;
	}

	public void setPayyear(short payyear) {
		this.payyear = payyear;
	}

	public short getPaymonth() {
		return paymonth;
	}

	public void setPaymonth(short paymonth) {
		this.paymonth = paymonth;
	}

	public BigDecimal getPpNetpension() {
		return ppNetpension;
	}

	public void setPpNetpension(BigDecimal ppNetpension) {
		this.ppNetpension = ppNetpension;
	}

	public String getAcCode() {
		return acCode;
	}

	public void setAcCode(String acCode) {
		this.acCode = acCode;
	}

	public PsnEmployeepensionMaster getPsnEmployeepensionMasterid() {
		return psnEmployeepensionMasterid;
	}

	public void setPsnEmployeepensionMasterid(PsnEmployeepensionMaster psnEmployeepensionMasterid) {
		this.psnEmployeepensionMasterid = psnEmployeepensionMasterid;
	}

	public PsnPaybilldetail getPsnPaybilldetailid() {
		return psnPaybilldetailid;
	}

	public void setPsnPaybilldetailid(PsnPaybilldetail psnPaybilldetailid) {
		this.psnPaybilldetailid = psnPaybilldetailid;
	}

	@XmlTransient
	public Collection<PsnMonthlypayTran> getPsnMonthlypayTranCollection() {
		return psnMonthlypayTranCollection;
	}

	public void setPsnMonthlypayTranCollection(Collection<PsnMonthlypayTran> psnMonthlypayTranCollection) {
		this.psnMonthlypayTranCollection = psnMonthlypayTranCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (psnMonthlypayid != null ? psnMonthlypayid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PsnMonthlypay)) {
			return false;
		}
		PsnMonthlypay other = (PsnMonthlypay) object;
		if ((this.psnMonthlypayid == null && other.psnMonthlypayid != null)
				|| (this.psnMonthlypayid != null && !this.psnMonthlypayid.equals(other.psnMonthlypayid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PsnMonthlypay[ psnMonthlypayid=" + psnMonthlypayid + " ]";
	}

}
