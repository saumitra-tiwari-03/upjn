/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;

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
@Table(name = "VIEW_PP_EMPPAYDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpEmppaydetail.findAll", query = "SELECT v FROM ViewPpEmppaydetail v"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByPpEmployeemasterid", query = "FROM ViewPpEmppaydetail WHERE ppEmployeemasterid = ?"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByPpPayscalemasterid", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.ppPayscalemasterid = :ppPayscalemasterid"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByNextincrementmonth", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.nextincrementmonth = :nextincrementmonth"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByDefaultincrementamount", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.defaultincrementamount = :defaultincrementamount"),
		@NamedQuery(name = "ViewPpEmppaydetail.findBySysPaycategoryid", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.sysPaycategoryid = :sysPaycategoryid"),
		@NamedQuery(name = "ViewPpEmppaydetail.findBySysPaymentmodeid", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.sysPaymentmodeid = :sysPaymentmodeid"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByPaymentmode", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.paymentmode = :paymentmode"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByPpRegistermasterid", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.ppRegistermasterid = :ppRegistermasterid"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByRegistername", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.registername = :registername"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByPpSectionmasterid", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.ppSectionmasterid = :ppSectionmasterid"),
		@NamedQuery(name = "ViewPpEmppaydetail.findBySectionname", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.sectionname = :sectionname"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByIsnps", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.isnps = :isnps"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByGpfacno", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.gpfacno = :gpfacno"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByPanno", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.panno = :panno"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByFwaBankaccountid", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.fwaBankaccountid = :fwaBankaccountid"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByBankaccno", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.bankaccno = :bankaccno"),
		@NamedQuery(name = "ViewPpEmppaydetail.findBySalarypercent", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.salarypercent = :salarypercent"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByNoofdays", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.noofdays = :noofdays"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByHeadquarter", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.headquarter = :headquarter"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByHratowncategoryid", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.hratowncategoryid = :hratowncategoryid"),
		@NamedQuery(name = "ViewPpEmppaydetail.findByCcatowncategoryid", query = "SELECT v FROM ViewPpEmppaydetail v WHERE v.ccatowncategoryid = :ccatowncategoryid") })
public class ViewPpEmppaydetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
	@Column(name = "PP_PAYSCALEMASTERID")
	private Integer ppPayscalemasterid;
	@Column(name = "NEXTINCREMENTMONTH")
	private String nextincrementmonth;
	@Column(name = "DEFAULTINCREMENTAMOUNT")
	private Integer defaultincrementamount;
	@Column(name = "SYS_PAYCATEGORYID")
	private Short sysPaycategoryid;
	@Column(name = "SYS_PAYMENTMODEID")
	private Short sysPaymentmodeid;
	@Basic(optional = false)
	@Column(name = "PAYMENTMODE")
	private String paymentmode;
	@Column(name = "PP_REGISTERMASTERID")
	private Short ppRegistermasterid;
	@Basic(optional = false)
	@Column(name = "REGISTERNAME")
	private String registername;
	@Column(name = "PP_SECTIONMASTERID")
	private Integer ppSectionmasterid;
	@Basic(optional = false)
	@Column(name = "SECTIONNAME")
	private String sectionname;
	@Column(name = "ISNPS")
	private String isnps;
	@Column(name = "GPFACNO")
	private String gpfacno;
	@Column(name = "PANNO")
	private String panno;
	@Column(name = "FWA_BANKACCOUNTID")
	private Integer fwaBankaccountid;
	@Column(name = "BANKACCNO")
	private String bankaccno;
	@Column(name = "SALARYPERCENT")
	private String salarypercent;
	@Column(name = "NOOFDAYS")
	private String noofdays;
	@Column(name = "HEADQUARTER")
	private String headquarter;
	@Column(name = "HRATOWNCATEGORYID")
	private String hratowncategoryid;
	@Column(name = "CCATOWNCATEGORYID")
	private String ccatowncategoryid;
	@Column(name = "BANK_NAME")
	private String bankname;
	@Column(name ="BRANCH_NAME")
	private String branchname;
	@Column(name = "IFSC_CODE")
	private String ifsccode;
	public ViewPpEmppaydetail() {
	}

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public Integer getPpPayscalemasterid() {
		return ppPayscalemasterid;
	}

	public void setPpPayscalemasterid(Integer ppPayscalemasterid) {
		this.ppPayscalemasterid = ppPayscalemasterid;
	}

	public String getNextincrementmonth() {
		return nextincrementmonth;
	}

	public void setNextincrementmonth(String nextincrementmonth) {
		this.nextincrementmonth = nextincrementmonth;
	}

	public Integer getDefaultincrementamount() {
		return defaultincrementamount;
	}

	public void setDefaultincrementamount(Integer defaultincrementamount) {
		this.defaultincrementamount = defaultincrementamount;
	}

	public Short getSysPaycategoryid() {
		return sysPaycategoryid;
	}

	public void setSysPaycategoryid(Short sysPaycategoryid) {
		this.sysPaycategoryid = sysPaycategoryid;
	}

	public Short getSysPaymentmodeid() {
		return sysPaymentmodeid;
	}

	public void setSysPaymentmodeid(Short sysPaymentmodeid) {
		this.sysPaymentmodeid = sysPaymentmodeid;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public Short getPpRegistermasterid() {
		return ppRegistermasterid;
	}

	public void setPpRegistermasterid(Short ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public String getRegistername() {
		return registername;
	}

	public void setRegistername(String registername) {
		this.registername = registername;
	}

	public Integer getPpSectionmasterid() {
		return ppSectionmasterid;
	}

	public void setPpSectionmasterid(Integer ppSectionmasterid) {
		this.ppSectionmasterid = ppSectionmasterid;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

	public String getIsnps() {
		return isnps;
	}

	public void setIsnps(String isnps) {
		this.isnps = isnps;
	}

	public String getGpfacno() {
		return gpfacno;
	}

	public void setGpfacno(String gpfacno) {
		this.gpfacno = gpfacno;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public Integer getFwaBankaccountid() {
		return fwaBankaccountid;
	}

	public void setFwaBankaccountid(Integer fwaBankaccountid) {
		this.fwaBankaccountid = fwaBankaccountid;
	}

	public String getBankaccno() {
		return bankaccno;
	}

	public void setBankaccno(String bankaccno) {
		this.bankaccno = bankaccno;
	}

	public String getSalarypercent() {
		return salarypercent;
	}

	public void setSalarypercent(String salarypercent) {
		this.salarypercent = salarypercent;
	}

	public String getNoofdays() {
		return noofdays;
	}

	public void setNoofdays(String noofdays) {
		this.noofdays = noofdays;
	}

	public String getHeadquarter() {
		return headquarter;
	}

	public void setHeadquarter(String headquarter) {
		this.headquarter = headquarter;
	}

	public String getHratowncategoryid() {
		return hratowncategoryid;
	}

	public void setHratowncategoryid(String hratowncategoryid) {
		this.hratowncategoryid = hratowncategoryid;
	}

	public String getCcatowncategoryid() {
		return ccatowncategoryid;
	}

	public void setCcatowncategoryid(String ccatowncategoryid) {
		this.ccatowncategoryid = ccatowncategoryid;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

}
