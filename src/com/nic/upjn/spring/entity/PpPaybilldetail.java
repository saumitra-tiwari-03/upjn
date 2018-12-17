/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "PP_PAYBILLDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpPaybilldetail.findAll", query = "SELECT p FROM PpPaybilldetail p"),
		@NamedQuery(name = "PpPaybilldetail.findByPpPaybilldetailid", query = "SELECT p FROM PpPaybilldetail p WHERE p.ppPaybilldetailid = :ppPaybilldetailid"),
		@NamedQuery(name = "PpPaybilldetail.findByBillclerkid", query = "SELECT p FROM PpPaybilldetail p WHERE p.billclerkid = :billclerkid"),
		@NamedQuery(name = "PpPaybilldetail.findByBillclerkname", query = "SELECT p FROM PpPaybilldetail p WHERE p.billclerkname = :billclerkname"),
		@NamedQuery(name = "PpPaybilldetail.findByMonth", query = "SELECT p FROM PpPaybilldetail p WHERE p.month = :month"),
		@NamedQuery(name = "PpPaybilldetail.findByYear", query = "SELECT p FROM PpPaybilldetail p WHERE p.year = :year"),
		@NamedQuery(name = "PpPaybilldetail.findByBillno", query = "SELECT p FROM PpPaybilldetail p WHERE p.billno = :billno"),
		@NamedQuery(name = "PpPaybilldetail.findByBillamount", query = "SELECT p FROM PpPaybilldetail p WHERE p.billamount = :billamount"),
		@NamedQuery(name = "PpPaybilldetail.findbyCriteria", query = "FROM PpPaybilldetail WHERE rmOfficeid = ? AND month = ? AND year = ? AND ppRegistermasterid = ?"),
		@NamedQuery(name = "PpPaybilldetail.findByIslocked", query = "SELECT p FROM PpPaybilldetail p WHERE p.islocked = :islocked"),
		@NamedQuery(name = "PpPaybilldetail.findByBilldate", query = "SELECT p FROM PpPaybilldetail p WHERE p.billdate = :billdate"),
		@NamedQuery(name = "PpPaybilldetail.findByPpRegistermasterid", query = "SELECT p FROM PpPaybilldetail p WHERE p.ppRegistermasterid = :ppRegistermasterid"),
		@NamedQuery(name = "PpPaybilldetail.findByBilltypeFlag", query = "SELECT p FROM PpPaybilldetail p WHERE p.billtypeFlag = :billtypeFlag"),
		@NamedQuery(name = "PpPaybilldetail.findByNetpay", query = "SELECT p FROM PpPaybilldetail p WHERE p.netpay = :netpay"),
		@NamedQuery(name = "PpPaybilldetail.findByTotalEmployee", query = "SELECT p FROM PpPaybilldetail p WHERE p.totalEmployee = :totalEmployee") })
public class PpPaybilldetail implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_PP_PAYBILLDETAIL", allocationSize = 1)
	@Id
	@Basic(optional = false)
	@Column(name = "PP_PAYBILLDETAILID")
	private Long ppPaybilldetailid;
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
	private String billamount;
	@Basic(optional = false)
	@Column(name = "ISLOCKED")
	private Character islocked;
	@Column(name = "BILLDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date billdate;
	@Basic(optional = false)
	@Column(name = "PP_REGISTERMASTERID")
	private short ppRegistermasterid;
	@Column(name = "BILLTYPE_FLAG")
	private Character billtypeFlag;
	@Column(name = "NETPAY")
	private String netpay;
	@Column(name = "TOTAL_EMPLOYEE")
	private String totalEmployee;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	
	
	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public PpPaybilldetail() {
	}

	public PpPaybilldetail(Long ppPaybilldetailid) {
		this.ppPaybilldetailid = ppPaybilldetailid;
	}

	public PpPaybilldetail(Long ppPaybilldetailid, long billclerkid, String billclerkname, String month, String year,
			String billamount, Character islocked, short ppRegistermasterid) {
		this.ppPaybilldetailid = ppPaybilldetailid;
		this.billclerkid = billclerkid;
		this.billclerkname = billclerkname;
		this.month = month;
		this.year = year;
		this.billamount = billamount;
		this.islocked = islocked;
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public Long getPpPaybilldetailid() {
		return ppPaybilldetailid;
	}

	public void setPpPaybilldetailid(Long ppPaybilldetailid) {
		this.ppPaybilldetailid = ppPaybilldetailid;
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

	public String getBillamount() {
		return billamount;
	}

	public void setBillamount(String string) {
		this.billamount = string;
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

	public String getNetpay() {
		return netpay;
	}

	public void setNetpay(String netpay) {
		this.netpay = netpay;
	}

	public String getTotalEmployee() {
		return totalEmployee;
	}

	public void setTotalEmployee(String totalEmployee) {
		this.totalEmployee = totalEmployee;
	}

	

	

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppPaybilldetailid != null ? ppPaybilldetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpPaybilldetail)) {
			return false;
		}
		PpPaybilldetail other = (PpPaybilldetail) object;
		if ((this.ppPaybilldetailid == null && other.ppPaybilldetailid != null)
				|| (this.ppPaybilldetailid != null && !this.ppPaybilldetailid.equals(other.ppPaybilldetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpPaybilldetail[ ppPaybilldetailid=" + ppPaybilldetailid + " ]";
	}

}
