package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class BillDetailEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_PAYBILLDETAILID")
	private Long ppPaybilldetailid;
	@Basic(optional = false)
	@Column(name = "BILLCLERKNAME")
	private String billclerkname;
	@Column(name = "BILLNO")
	private String billno;
	@Basic(optional = false)
	@Column(name = "MONTH")
	private String month;
	@Basic(optional = false)
	@Column(name = "YEAR")
	private String year;
	@Basic(optional = false)
	private Date BILLDATE;
	@Basic(optional = false)
	@Column(name = "BILLAMOUNT")
	private String billamount;
	@Column(name = "BILLTYPE_FLAG")
	private Character billtypeFlag;
	@Basic(optional = false)
	@Column(name = "PP_REGISTERMASTERID")
	private short ppRegistermasterid;
	@Column(name = "REGISTERNAME")
	private String registername;

	public Long getPpPaybilldetailid() {
		return ppPaybilldetailid;
	}

	public void setPpPaybilldetailid(Long ppPaybilldetailid) {
		this.ppPaybilldetailid = ppPaybilldetailid;
	}

	public String getBillclerkname() {
		return billclerkname;
	}

	public void setBillclerkname(String billclerkname) {
		this.billclerkname = billclerkname;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
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

	public Date getBilldate() {
		return BILLDATE;
	}

	public void setBilldate(Date billdate) {
		this.BILLDATE = billdate;
	}

	public String getBillamount() {
		return billamount;
	}

	public void setBillamount(String billamount) {
		this.billamount = billamount;
	}

	public Character getBilltypeFlag() {
		return billtypeFlag;
	}

	public void setBilltypeFlag(Character billtypeFlag) {
		this.billtypeFlag = billtypeFlag;
	}

	public short getPpRegistermasterid() {
		return ppRegistermasterid;
	}

	public void setPpRegistermasterid(short ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public String getRegistername() {
		return registername;
	}

	public void setRegistername(String registername) {
		this.registername = registername;
	}

}
