/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

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
@Table(name = "PP_MONTHLYPAY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpMonthlypay.findAll", query = "SELECT p FROM PpMonthlypay p"),
		@NamedQuery(name = "PpMonthlypay.findByPpMonthlypayid", query = "SELECT p FROM PpMonthlypay p WHERE p.ppMonthlypayid = :ppMonthlypayid"),
		@NamedQuery(name = "PpMonthlypay.findByPpEmployeemasterid", query = "SELECT p FROM PpMonthlypay p WHERE p.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "PpMonthlypay.findByPayscale", query = "SELECT p FROM PpMonthlypay p WHERE p.payscale = :payscale"),
		@NamedQuery(name = "PpMonthlypay.findByNoofdays", query = "SELECT p FROM PpMonthlypay p WHERE p.noofdays = :noofdays"),
		@NamedQuery(name = "PpMonthlypay.findByPayyear", query = "SELECT p FROM PpMonthlypay p WHERE p.payyear = :payyear"),
		@NamedQuery(name = "PpMonthlypay.findByPaymonth", query = "SELECT p FROM PpMonthlypay p WHERE p.paymonth = :paymonth"),
		@NamedQuery(name = "PpMonthlypay.findByPpRegistermasterid", query = "SELECT p FROM PpMonthlypay p WHERE p.ppRegistermasterid = :ppRegistermasterid"),
		@NamedQuery(name = "PpMonthlypay.findByPpNetpay", query = "SELECT p FROM PpMonthlypay p WHERE p.ppNetpay = :ppNetpay") })
public class PpMonthlypay implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_MONTHLYPAYID")
	private Long ppMonthlypayid;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Column(name = "PAYSCALE")
	private String payscale;
	@Column(name = "NOOFDAYS")
	private Short noofdays;
	@Basic(optional = false)
	@Column(name = "PAYYEAR")
	private short payyear;
	@Basic(optional = false)
	@Column(name = "PAYMONTH")
	private short paymonth;
	@Basic(optional = false)
	@Column(name = "PP_REGISTERMASTERID")
	private short ppRegistermasterid;
	@Basic(optional = false)
	@Column(name = "PP_NETPAY")
	private int ppNetpay;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppMonthlypayid")
	private Collection<ViewEmpAlwDedlist> viewEmpAlwDedlistCollection;
	@JoinColumn(name = "PP_PAYBILLDETAILID", referencedColumnName = "PP_PAYBILLDETAILID")
	@ManyToOne(optional = false)
	private PpPaybilldetail ppPaybilldetailid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppMonthlypayid")
	private Collection<PpMonthlypayTran> ppMonthlypayTranCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppMonthlypayid")
	private Collection<PpViewEmpPay> ppViewEmpPayCollection;

	public PpMonthlypay() {
	}

	public PpMonthlypay(Long ppMonthlypayid) {
		this.ppMonthlypayid = ppMonthlypayid;
	}

	public PpMonthlypay(Long ppMonthlypayid, long ppEmployeemasterid, short payyear, short paymonth,
			short ppRegistermasterid, int ppNetpay) {
		this.ppMonthlypayid = ppMonthlypayid;
		this.ppEmployeemasterid = ppEmployeemasterid;
		this.payyear = payyear;
		this.paymonth = paymonth;
		this.ppRegistermasterid = ppRegistermasterid;
		this.ppNetpay = ppNetpay;
	}

	public Long getPpMonthlypayid() {
		return ppMonthlypayid;
	}

	public void setPpMonthlypayid(Long ppMonthlypayid) {
		this.ppMonthlypayid = ppMonthlypayid;
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public String getPayscale() {
		return payscale;
	}

	public void setPayscale(String payscale) {
		this.payscale = payscale;
	}

	public Short getNoofdays() {
		return noofdays;
	}

	public void setNoofdays(Short noofdays) {
		this.noofdays = noofdays;
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

	public short getPpRegistermasterid() {
		return ppRegistermasterid;
	}

	public void setPpRegistermasterid(short ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public int getPpNetpay() {
		return ppNetpay;
	}

	public void setPpNetpay(int ppNetpay) {
		this.ppNetpay = ppNetpay;
	}

	@XmlTransient
	public Collection<ViewEmpAlwDedlist> getViewEmpAlwDedlistCollection() {
		return viewEmpAlwDedlistCollection;
	}

	public void setViewEmpAlwDedlistCollection(Collection<ViewEmpAlwDedlist> viewEmpAlwDedlistCollection) {
		this.viewEmpAlwDedlistCollection = viewEmpAlwDedlistCollection;
	}

	public PpPaybilldetail getPpPaybilldetailid() {
		return ppPaybilldetailid;
	}

	public void setPpPaybilldetailid(PpPaybilldetail ppPaybilldetailid) {
		this.ppPaybilldetailid = ppPaybilldetailid;
	}

	@XmlTransient
	public Collection<PpMonthlypayTran> getPpMonthlypayTranCollection() {
		return ppMonthlypayTranCollection;
	}

	public void setPpMonthlypayTranCollection(Collection<PpMonthlypayTran> ppMonthlypayTranCollection) {
		this.ppMonthlypayTranCollection = ppMonthlypayTranCollection;
	}

	@XmlTransient
	public Collection<PpViewEmpPay> getPpViewEmpPayCollection() {
		return ppViewEmpPayCollection;
	}

	public void setPpViewEmpPayCollection(Collection<PpViewEmpPay> ppViewEmpPayCollection) {
		this.ppViewEmpPayCollection = ppViewEmpPayCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppMonthlypayid != null ? ppMonthlypayid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpMonthlypay)) {
			return false;
		}
		PpMonthlypay other = (PpMonthlypay) object;
		if ((this.ppMonthlypayid == null && other.ppMonthlypayid != null)
				|| (this.ppMonthlypayid != null && !this.ppMonthlypayid.equals(other.ppMonthlypayid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpMonthlypay[ ppMonthlypayid=" + ppMonthlypayid + " ]";
	}

}
