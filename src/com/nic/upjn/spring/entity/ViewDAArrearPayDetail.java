package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ViewDAArrearPayDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "PAYMONTH")
	@Basic(optional = false)
	private long PAYMONTH;
	@Column(name = "PAYYEAR")
	@Basic(optional = false)
	private long PAYYEAR;
	@Column(name = "BASIC")
	@Basic(optional = false)
	private long basicpay;
	@Column(name = "GRADEPAY")
	@Basic(optional = false)
	private long gradepay;
	@Column(name = "MONTHNAME")
	@Basic(optional = false)
	private String monthname;
	@Column(name = "DA")
	@Basic(optional = false)
	private String da;
	
	public long getPAYMONTH() {
		return PAYMONTH;
	}
	public void setPAYMONTH(long pAYMONTH) {
		PAYMONTH = pAYMONTH;
	}
	public long getPAYYEAR() {
		return PAYYEAR;
	}
	public void setPAYYEAR(long pAYYEAR) {
		PAYYEAR = pAYYEAR;
	}	
	public long getBasicpay() {
		return basicpay;
	}
	public void setBasicpay(long basicpay) {
		this.basicpay = basicpay;
	}
	public String getMonthname() {
		return monthname;
	}
	public void setMonthname(String monthname) {
		this.monthname = monthname;
	}
	public long getGradepay() {
		return gradepay;
	}
	public void setGradepay(long gradepay) {
		this.gradepay = gradepay;
	}
	public String getDa() {
		return da;
	}
	public void setDa(String da) {
		this.da = da;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
