package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "GPF_OPENINGBALANCE")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "GPFOpeningBalance.findbyppemployeemasterid", query = "FROM GPFOpeningBalanceEntity WHERE PP_EMPLOYEEMASTERID = ?") })
public class GPFOpeningBalanceEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "GPF_OPENINGBALANCEID")
	@Basic(optional = false)
	private long GPF_OPENINGBALANCEID;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long PP_EMPLOYEEMASTERID;
	@Column(name = "OPENING_BALANCE")
	private long OPENING_BALANCE;
	@Column(name = "GPF_ACCNO")
	private String GPF_ACCNO;
	@Column(name = "FINANCIAL_YEAR")
	private String FINANCIAL_YEAR;
	@Column(name = "DATE_OF_ENTRY")
	private Date DATE_OF_ENTRY;

	public long getGPF_OPENINGBALANCEID() {
		return GPF_OPENINGBALANCEID;
	}

	public void setGPF_OPENINGBALANCEID(long gPF_OPENINGBALANCEID) {
		GPF_OPENINGBALANCEID = gPF_OPENINGBALANCEID;
	}

	public long getPP_EMPLOYEEMASTERID() {
		return PP_EMPLOYEEMASTERID;
	}

	public void setPP_EMPLOYEEMASTERID(long pP_EMPLOYEEMASTERID) {
		PP_EMPLOYEEMASTERID = pP_EMPLOYEEMASTERID;
	}

	public long getOPENING_BALANCE() {
		return OPENING_BALANCE;
	}

	public void setOPENING_BALANCE(long oPENING_BALANCE) {
		OPENING_BALANCE = oPENING_BALANCE;
	}

	public String getGPF_ACCNO() {
		return GPF_ACCNO;
	}

	public void setGPF_ACCNO(String gPF_ACCNO) {
		GPF_ACCNO = gPF_ACCNO;
	}

	public Date getDATE_OF_ENTRY() {
		return DATE_OF_ENTRY;
	}

	public void setDATE_OF_ENTRY(Date dATE_OF_ENTRY) { 
	/*	DATE_OF_ENTRY = dATE_OF_ENTRY;*/
	}

	public String getFINANCIAL_YEAR() {
		return FINANCIAL_YEAR;
	}

	public void setFINANCIAL_YEAR(String fINANCIAL_YEAR) {
		FINANCIAL_YEAR = fINANCIAL_YEAR;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
