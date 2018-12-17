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
public class ViewDAArrearDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "PP_RULEMASTERID")
	@Basic(optional = false)
	private long pprulemasterid;
	@Column(name = "RULEORDERNO")
	@Basic(optional = false)
	private String ruleorderno;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RULEORDERDATE")
	private Date ruleorderdate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATEOFEFFECT")
	private Date dateofeffect;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DUEDATE")
	@Basic(optional = false)
	private Date duedate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "GPFDATE")
	private Date gpfdate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CASHDATE")
	@Basic(optional = false)
	private Date cashdate;
	@Column(name = "PERCENTVALUE")
	@Basic(optional = false)
	private String percentvalue;
	@Column(name = "DUEMONTH")
	@Basic(optional = false)
	private long DUEMONTH;
	@Column(name = "DUEYEAR")
	@Basic(optional = false)
	private long DUEYEAR;
	
	public long getPprulemasterid() {
		return pprulemasterid;
	}
	public void setPprulemasterid(long pprulemasterid) {
		this.pprulemasterid = pprulemasterid;
	}
	public String getRuleorderno() {
		return ruleorderno;
	}
	public void setRuleorderno(String ruleorderno) {
		this.ruleorderno = ruleorderno;
	}
	public Date getRuleorderdate() {
		return ruleorderdate;
	}
	public void setRuleorderdate(Date ruleorderdate) {
		this.ruleorderdate = ruleorderdate;
	}
	public Date getDateofeffect() {
		return dateofeffect;
	}
	public void setDateofeffect(Date dateofeffect) {
		this.dateofeffect = dateofeffect;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public Date getGpfdate() {
		return gpfdate;
	}
	public void setGpfdate(Date gpfdate) {
		this.gpfdate = gpfdate;
	}
	public Date getCashdate() {
		return cashdate;
	}
	public void setCashdate(Date cashdate) {
		this.cashdate = cashdate;
	}
	public String getPercentvalue() {
		return percentvalue;
	}
	public void setPercentvalue(String percentvalue) {
		this.percentvalue = percentvalue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getDUEMONTH() {
		return DUEMONTH;
	}
	public void setDUEMONTH(long dUEMONTH) {
		DUEMONTH = dUEMONTH;
	}
	public long getDUEYEAR() {
		return DUEYEAR;
	}
	public void setDUEYEAR(long dUEYEAR) {
		DUEYEAR = dUEYEAR;
	}
	
	
	

}
