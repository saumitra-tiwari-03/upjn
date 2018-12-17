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
@Table(name = "LFY_PP_PAYBILLDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LfyPpPaybilldetail.findAll", query = "SELECT l FROM LfyPpPaybilldetail l"),
		@NamedQuery(name = "LfyPpPaybilldetail.findByLfyPpPaybilldetailid", query = "SELECT l FROM LfyPpPaybilldetail l WHERE l.lfyPpPaybilldetailid = :lfyPpPaybilldetailid"),
		@NamedQuery(name = "LfyPpPaybilldetail.findByBillclerkid", query = "SELECT l FROM LfyPpPaybilldetail l WHERE l.billclerkid = :billclerkid"),
		@NamedQuery(name = "LfyPpPaybilldetail.findByBillclerkname", query = "SELECT l FROM LfyPpPaybilldetail l WHERE l.billclerkname = :billclerkname"),
		@NamedQuery(name = "LfyPpPaybilldetail.findByMonth", query = "SELECT l FROM LfyPpPaybilldetail l WHERE l.month = :month"),
		@NamedQuery(name = "LfyPpPaybilldetail.findByYear", query = "SELECT l FROM LfyPpPaybilldetail l WHERE l.year = :year"),
		@NamedQuery(name = "LfyPpPaybilldetail.findByBillno", query = "SELECT l FROM LfyPpPaybilldetail l WHERE l.billno = :billno"),
		@NamedQuery(name = "LfyPpPaybilldetail.findByBillamount", query = "SELECT l FROM LfyPpPaybilldetail l WHERE l.billamount = :billamount"),
		@NamedQuery(name = "LfyPpPaybilldetail.findByIslocked", query = "SELECT l FROM LfyPpPaybilldetail l WHERE l.islocked = :islocked"),
		@NamedQuery(name = "LfyPpPaybilldetail.findByBilldate", query = "SELECT l FROM LfyPpPaybilldetail l WHERE l.billdate = :billdate"),
		@NamedQuery(name = "LfyPpPaybilldetail.findByRmOfficeid", query = "SELECT l FROM LfyPpPaybilldetail l WHERE l.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "LfyPpPaybilldetail.findByPpRegistermasterid", query = "SELECT l FROM LfyPpPaybilldetail l WHERE l.ppRegistermasterid = :ppRegistermasterid"),
		@NamedQuery(name = "LfyPpPaybilldetail.findByBilltypeFlag", query = "SELECT l FROM LfyPpPaybilldetail l WHERE l.billtypeFlag = :billtypeFlag"),
		@NamedQuery(name = "LfyPpPaybilldetail.findByPpPaybilldetailid", query = "SELECT l FROM LfyPpPaybilldetail l WHERE l.ppPaybilldetailid = :ppPaybilldetailid"),
		@NamedQuery(name = "LfyPpPaybilldetail.findByFinancialyear", query = "SELECT l FROM LfyPpPaybilldetail l WHERE l.financialyear = :financialyear") })
public class LfyPpPaybilldetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_PP_PAYBILLDETAILID")
	private Long lfyPpPaybilldetailid;
	@Basic(optional = false)
	@Column(name = "BILLCLERKID")
	private long billclerkid;
	@Basic(optional = false)
	@Column(name = "BILLCLERKNAME")
	private String billclerkname;
	@Basic(optional = false)
	@Column(name = "MONTH")
	private String month;
	@Basic(optional = false)
	@Column(name = "YEAR")
	private String year;
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
	@Basic(optional = false)
	@Column(name = "PP_REGISTERMASTERID")
	private short ppRegistermasterid;
	@Column(name = "BILLTYPE_FLAG")
	private Character billtypeFlag;
	@Basic(optional = false)
	@Column(name = "PP_PAYBILLDETAILID")
	private long ppPaybilldetailid;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;

	public LfyPpPaybilldetail() {
	}

	public LfyPpPaybilldetail(Long lfyPpPaybilldetailid) {
		this.lfyPpPaybilldetailid = lfyPpPaybilldetailid;
	}

	public LfyPpPaybilldetail(Long lfyPpPaybilldetailid, long billclerkid, String billclerkname, String month,
			String year, long billamount, Character islocked, Date billdate, long rmOfficeid, short ppRegistermasterid,
			long ppPaybilldetailid, String financialyear) {
		this.lfyPpPaybilldetailid = lfyPpPaybilldetailid;
		this.billclerkid = billclerkid;
		this.billclerkname = billclerkname;
		this.month = month;
		this.year = year;
		this.billamount = billamount;
		this.islocked = islocked;
		this.billdate = billdate;
		this.rmOfficeid = rmOfficeid;
		this.ppRegistermasterid = ppRegistermasterid;
		this.ppPaybilldetailid = ppPaybilldetailid;
		this.financialyear = financialyear;
	}

	public Long getLfyPpPaybilldetailid() {
		return lfyPpPaybilldetailid;
	}

	public void setLfyPpPaybilldetailid(Long lfyPpPaybilldetailid) {
		this.lfyPpPaybilldetailid = lfyPpPaybilldetailid;
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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

	public short getPpRegistermasterid() {
		return ppRegistermasterid;
	}

	public void setPpRegistermasterid(short ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public Character getBilltypeFlag() {
		return billtypeFlag;
	}

	public void setBilltypeFlag(Character billtypeFlag) {
		this.billtypeFlag = billtypeFlag;
	}

	public long getPpPaybilldetailid() {
		return ppPaybilldetailid;
	}

	public void setPpPaybilldetailid(long ppPaybilldetailid) {
		this.ppPaybilldetailid = ppPaybilldetailid;
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
		hash += (lfyPpPaybilldetailid != null ? lfyPpPaybilldetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfyPpPaybilldetail)) {
			return false;
		}
		LfyPpPaybilldetail other = (LfyPpPaybilldetail) object;
		if ((this.lfyPpPaybilldetailid == null && other.lfyPpPaybilldetailid != null)
				|| (this.lfyPpPaybilldetailid != null
						&& !this.lfyPpPaybilldetailid.equals(other.lfyPpPaybilldetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfyPpPaybilldetail[ lfyPpPaybilldetailid=" + lfyPpPaybilldetailid + " ]";
	}

}
