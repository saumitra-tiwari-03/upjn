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
@Table(name = "PSN_PAYBILLDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PsnPaybilldetail.findAll", query = "SELECT p FROM PsnPaybilldetail p"),
		@NamedQuery(name = "PsnPaybilldetail.findByPsnPaybilldetailid", query = "SELECT p FROM PsnPaybilldetail p WHERE p.psnPaybilldetailid = :psnPaybilldetailid"),
		@NamedQuery(name = "PsnPaybilldetail.findByBillclerkid", query = "SELECT p FROM PsnPaybilldetail p WHERE p.billclerkid = :billclerkid"),
		@NamedQuery(name = "PsnPaybilldetail.findByBillclerkname", query = "SELECT p FROM PsnPaybilldetail p WHERE p.billclerkname = :billclerkname"),
		@NamedQuery(name = "PsnPaybilldetail.findByPaymonth", query = "SELECT p FROM PsnPaybilldetail p WHERE p.paymonth = :paymonth"),
		@NamedQuery(name = "PsnPaybilldetail.findByPayyear", query = "SELECT p FROM PsnPaybilldetail p WHERE p.payyear = :payyear"),
		@NamedQuery(name = "PsnPaybilldetail.findByBillno", query = "SELECT p FROM PsnPaybilldetail p WHERE p.billno = :billno"),
		@NamedQuery(name = "PsnPaybilldetail.findByBillamount", query = "SELECT p FROM PsnPaybilldetail p WHERE p.billamount = :billamount"),
		@NamedQuery(name = "PsnPaybilldetail.findByIslocked", query = "SELECT p FROM PsnPaybilldetail p WHERE p.islocked = :islocked"),
		@NamedQuery(name = "PsnPaybilldetail.findByBilldate", query = "SELECT p FROM PsnPaybilldetail p WHERE p.billdate = :billdate"),
		@NamedQuery(name = "PsnPaybilldetail.findByRmOfficeid", query = "SELECT p FROM PsnPaybilldetail p WHERE p.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "PsnPaybilldetail.findByBilltypeFlag", query = "SELECT p FROM PsnPaybilldetail p WHERE p.billtypeFlag = :billtypeFlag") })
public class PsnPaybilldetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PSN_PAYBILLDETAILID")
	private Long psnPaybilldetailid;
	@Basic(optional = false)
	@Column(name = "BILLCLERKID")
	private long billclerkid;
	@Basic(optional = false)
	@Column(name = "BILLCLERKNAME")
	private String billclerkname;
	@Basic(optional = false)
	@Column(name = "PAYMONTH")
	private short paymonth;
	@Basic(optional = false)
	@Column(name = "PAYYEAR")
	private short payyear;
	@Column(name = "BILLNO")
	private String billno;
	@Basic(optional = false)
	@Column(name = "BILLAMOUNT")
	private long billamount;
	@Basic(optional = false)
	@Column(name = "ISLOCKED")
	private Character islocked;
	@Basic(optional = false)
	@Column(name = "BILLDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date billdate;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Column(name = "BILLTYPE_FLAG")
	private Character billtypeFlag;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "psnPaybilldetailid")
	private Collection<PsnMonthlypay> psnMonthlypayCollection;

	public PsnPaybilldetail() {
	}

	public PsnPaybilldetail(Long psnPaybilldetailid) {
		this.psnPaybilldetailid = psnPaybilldetailid;
	}

	public PsnPaybilldetail(Long psnPaybilldetailid, long billclerkid, String billclerkname, short paymonth,
			short payyear, long billamount, Character islocked, Date billdate, int rmOfficeid) {
		this.psnPaybilldetailid = psnPaybilldetailid;
		this.billclerkid = billclerkid;
		this.billclerkname = billclerkname;
		this.paymonth = paymonth;
		this.payyear = payyear;
		this.billamount = billamount;
		this.islocked = islocked;
		this.billdate = billdate;
		this.rmOfficeid = rmOfficeid;
	}

	public Long getPsnPaybilldetailid() {
		return psnPaybilldetailid;
	}

	public void setPsnPaybilldetailid(Long psnPaybilldetailid) {
		this.psnPaybilldetailid = psnPaybilldetailid;
	}

	public long getBillclerkid() {
		return billclerkid;
	}

	public void setBillclerkid(long billclerkid) {
		this.billclerkid = billclerkid;
	}

	public String getBillclerkname() {
		return billclerkname;
	}

	public void setBillclerkname(String billclerkname) {
		this.billclerkname = billclerkname;
	}

	public short getPaymonth() {
		return paymonth;
	}

	public void setPaymonth(short paymonth) {
		this.paymonth = paymonth;
	}

	public short getPayyear() {
		return payyear;
	}

	public void setPayyear(short payyear) {
		this.payyear = payyear;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public long getBillamount() {
		return billamount;
	}

	public void setBillamount(long billamount) {
		this.billamount = billamount;
	}

	public Character getIslocked() {
		return islocked;
	}

	public void setIslocked(Character islocked) {
		this.islocked = islocked;
	}

	public Date getBilldate() {
		return billdate;
	}

	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Character getBilltypeFlag() {
		return billtypeFlag;
	}

	public void setBilltypeFlag(Character billtypeFlag) {
		this.billtypeFlag = billtypeFlag;
	}

	@XmlTransient
	public Collection<PsnMonthlypay> getPsnMonthlypayCollection() {
		return psnMonthlypayCollection;
	}

	public void setPsnMonthlypayCollection(Collection<PsnMonthlypay> psnMonthlypayCollection) {
		this.psnMonthlypayCollection = psnMonthlypayCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (psnPaybilldetailid != null ? psnPaybilldetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PsnPaybilldetail)) {
			return false;
		}
		PsnPaybilldetail other = (PsnPaybilldetail) object;
		if ((this.psnPaybilldetailid == null && other.psnPaybilldetailid != null)
				|| (this.psnPaybilldetailid != null && !this.psnPaybilldetailid.equals(other.psnPaybilldetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PsnPaybilldetail[ psnPaybilldetailid=" + psnPaybilldetailid + " ]";
	}

}
