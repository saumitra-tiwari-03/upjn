package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ViewHeadNameYearlyPay implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private BigInteger HEADID;
	private String HEADTYPE;
	protected String HEADNAME;
	private BigInteger PRINT_ORDER;

	public BigInteger getHEADID() {
		return HEADID;
	}
	public void setHEADID(BigInteger hEADID) {
		HEADID = hEADID;
	}
	public String getHEADTYPE() {
		return HEADTYPE;
	}
	public void setHEADTYPE(String hEADTYPE) {
		HEADTYPE = hEADTYPE;
	}
	public String getHEADNAME() {
		return HEADNAME;
	}
	public void setHEADNAME(String hEADNAME) {
		HEADNAME = hEADNAME;
	}
	public BigInteger getPRINT_ORDER() {
		return PRINT_ORDER;
	}
	public void setPRINT_ORDER(BigInteger pRINT_ORDER) {
		PRINT_ORDER = pRINT_ORDER;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
