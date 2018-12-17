/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "LFY_PSN_PAYBILLDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfyPsnPaybilldetail.findAll", query = "SELECT l FROM LfyPsnPaybilldetail l"),
		@NamedQuery(name = "LfyPsnPaybilldetail.findByLfyPsnPaybilldetailid", query = "SELECT l FROM LfyPsnPaybilldetail l WHERE l.lfyPsnPaybilldetailid = :lfyPsnPaybilldetailid"),
		@NamedQuery(name = "LfyPsnPaybilldetail.findByBillclerkid", query = "SELECT l FROM LfyPsnPaybilldetail l WHERE l.billclerkid = :billclerkid"),
		@NamedQuery(name = "LfyPsnPaybilldetail.findByBillclerkname", query = "SELECT l FROM LfyPsnPaybilldetail l WHERE l.billclerkname = :billclerkname"),
		@NamedQuery(name = "LfyPsnPaybilldetail.findByPaymonth", query = "SELECT l FROM LfyPsnPaybilldetail l WHERE l.paymonth = :paymonth"),
		@NamedQuery(name = "LfyPsnPaybilldetail.findByPayyear", query = "SELECT l FROM LfyPsnPaybilldetail l WHERE l.payyear = :payyear"),
		@NamedQuery(name = "LfyPsnPaybilldetail.findByBillno", query = "SELECT l FROM LfyPsnPaybilldetail l WHERE l.billno = :billno"),
		@NamedQuery(name = "LfyPsnPaybilldetail.findByBillamount", query = "SELECT l FROM LfyPsnPaybilldetail l WHERE l.billamount = :billamount"),
		@NamedQuery(name = "LfyPsnPaybilldetail.findByIslocked", query = "SELECT l FROM LfyPsnPaybilldetail l WHERE l.islocked = :islocked"),
		@NamedQuery(name = "LfyPsnPaybilldetail.findByBilldate", query = "SELECT l FROM LfyPsnPaybilldetail l WHERE l.billdate = :billdate"),
		@NamedQuery(name = "LfyPsnPaybilldetail.findByRmOfficeid", query = "SELECT l FROM LfyPsnPaybilldetail l WHERE l.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "LfyPsnPaybilldetail.findByBilltypeFlag", query = "SELECT l FROM LfyPsnPaybilldetail l WHERE l.billtypeFlag = :billtypeFlag"),
		@NamedQuery(name = "LfyPsnPaybilldetail.findByPsnPaybilldetailid", query = "SELECT l FROM LfyPsnPaybilldetail l WHERE l.psnPaybilldetailid = :psnPaybilldetailid"),
		@NamedQuery(name = "LfyPsnPaybilldetail.findByFinancialyear", query = "SELECT l FROM LfyPsnPaybilldetail l WHERE l.financialyear = :financialyear") })
public class LfyPsnPaybilldetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_PSN_PAYBILLDETAILID")
	private Long lfyPsnPaybilldetailid;
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
	private long rmOfficeid;
	@Column(name = "BILLTYPE_FLAG")
	private Character billtypeFlag;
	@Basic(optional = false)
	@Column(name = "PSN_PAYBILLDETAILID")
	private long psnPaybilldetailid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfyPsnPaybilldetail() {
	}

	public LfyPsnPaybilldetail(Long lfyPsnPaybilldetailid) {
		this.lfyPsnPaybilldetailid = lfyPsnPaybilldetailid;
	}

	public LfyPsnPaybilldetail(Long lfyPsnPaybilldetailid, long billclerkid, String billclerkname, short paymonth,
			short payyear, long billamount, Character islocked, Date billdate, long rmOfficeid, long psnPaybilldetailid,
			String financialyear) {
		this.lfyPsnPaybilldetailid = lfyPsnPaybilldetailid;
		this.billclerkid = billclerkid;
		this.billclerkname = billclerkname;
		this.paymonth = paymonth;
		this.payyear = payyear;
		this.billamount = billamount;
		this.islocked = islocked;
		this.billdate = billdate;
		this.rmOfficeid = rmOfficeid;
		this.psnPaybilldetailid = psnPaybilldetailid;
		this.financialyear = financialyear;
	}

	public Long getLfyPsnPaybilldetailid() {
		return lfyPsnPaybilldetailid;
	}

	public void setLfyPsnPaybilldetailid(Long lfyPsnPaybilldetailid) {
		this.lfyPsnPaybilldetailid = lfyPsnPaybilldetailid;
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

	public long getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(long rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Character getBilltypeFlag() {
		return billtypeFlag;
	}

	public void setBilltypeFlag(Character billtypeFlag) {
		this.billtypeFlag = billtypeFlag;
	}

	public long getPsnPaybilldetailid() {
		return psnPaybilldetailid;
	}

	public void setPsnPaybilldetailid(long psnPaybilldetailid) {
		this.psnPaybilldetailid = psnPaybilldetailid;
	}

	public String getFinancialyear() {
		return financialyear;
	}

	public void setFinancialyear(String financialyear) {
		this.financialyear = financialyear;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (lfyPsnPaybilldetailid != null ? lfyPsnPaybilldetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfyPsnPaybilldetail)) {
			return false;
		}
		LfyPsnPaybilldetail other = (LfyPsnPaybilldetail) object;
		if ((this.lfyPsnPaybilldetailid == null && other.lfyPsnPaybilldetailid != null)
				|| (this.lfyPsnPaybilldetailid != null
						&& !this.lfyPsnPaybilldetailid.equals(other.lfyPsnPaybilldetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfyPsnPaybilldetail[ lfyPsnPaybilldetailid=" + lfyPsnPaybilldetailid + " ]";
	}

}
