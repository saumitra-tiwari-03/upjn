package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GPFValuesEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ROWNUM")
	@Basic(optional = false)
	private long rownum;
	@Column(name = "GPFAMOUNT")
	private long GPFAMOUNT;
	@Column(name = "PAYMONTH")
	private String PAYMONTH;
	@Column(name = "PAYYEAR")
	private String PAYYEAR;
	@Column(name = "MONTHNAME")
	private String monthname;
	
	public long getRownum() {
		return rownum;
	}
	public void setRownum(long rownum) {
		this.rownum = rownum;
	}
	public long getGPFAMOUNT() {
		return GPFAMOUNT;
	}
	public void setGPFAMOUNT(long gPFAMOUNT) {
		GPFAMOUNT = gPFAMOUNT;
	}
	public String getPAYMONTH() {
		return PAYMONTH;
	}
	public void setPAYMONTH(String pAYMONTH) {
		PAYMONTH = pAYMONTH;
	}
	public String getPAYYEAR() {
		return PAYYEAR;
	}
	public void setPAYYEAR(String pAYYEAR) {
		PAYYEAR = pAYYEAR;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getMonthname() {
		return monthname;
	}
	public void setMonthname(String monthname) {
		this.monthname = monthname;
	}
	

}
