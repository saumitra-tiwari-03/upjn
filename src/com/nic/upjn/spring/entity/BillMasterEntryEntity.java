package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "BillMasterEntryEntity")
@XmlRootElement

public class BillMasterEntryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "PP_PAYBILLDETAILID")
	private Long ppPaybilldetailid;

	@Basic(optional = false)
	@Column(name = "BILLCLERKNAME")
	private String billclerkname;

	@Basic(optional = false)
	@Column(name = "MONTH")
	private String month;

	@Basic(optional = false)
	@Column(name = "YEAR")
	private String year;

	@Basic(optional = false)
	@Column(name = "BILL_AMOUNT")
	private String billamount;

	@Basic(optional = false)
	@Column(name = "BILLFROM")
	private String billFrom;

	@Basic(optional = false)
	@Column(name = "BILLNAME")
	private String billName;

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

	public String getBillamount() {
		return billamount;
	}

	public void setBillamount(String billamount) {
		this.billamount = billamount;
	}

	public String getBillFrom() {
		return billFrom;
	}

	public void setBillFrom(String billFrom) {
		this.billFrom = billFrom;
	}

	public String getBillName() {
		return billName;
	}

	public void setBillName(String billName) {
		this.billName = billName;
	}

}
