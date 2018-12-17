/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "VIEW_PP_LOANDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpLoandetail.findAll", query = "SELECT v FROM ViewPpLoandetail v"),
		@NamedQuery(name = "ViewPpLoandetail.findByEmployeecode", query = "SELECT v FROM ViewPpLoandetail v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPpLoandetail.findByEmployeename", query = "SELECT v FROM ViewPpLoandetail v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPpLoandetail.findByLoanamount", query = "SELECT v FROM ViewPpLoandetail v WHERE v.loanamount = :loanamount"),
		@NamedQuery(name = "ViewPpLoandetail.findByLoansanctionordno", query = "SELECT v FROM ViewPpLoandetail v WHERE v.loansanctionordno = :loansanctionordno"),
		@NamedQuery(name = "ViewPpLoandetail.findBySanctiondate", query = "SELECT v FROM ViewPpLoandetail v WHERE v.sanctiondate = :sanctiondate"),
		@NamedQuery(name = "ViewPpLoandetail.findByLoanshortname", query = "SELECT v FROM ViewPpLoandetail v WHERE v.loanshortname = :loanshortname"),
		@NamedQuery(name = "ViewPpLoandetail.findByPaInstallmentamount", query = "SELECT v FROM ViewPpLoandetail v WHERE v.paInstallmentamount = :paInstallmentamount"),
	//	@NamedQuery(name = "ViewPpLoandetail.findByPaIsfullyrecovered", query = "SELECT v FROM ViewPpLoandetail v WHERE v.paIsfullyrecovered = :paIsfullyrecovered"),
		@NamedQuery(name = "ViewPpLoandetail.findByPaNextinstallmentno", query = "SELECT v FROM ViewPpLoandetail v WHERE v.paNextinstallmentno = :paNextinstallmentno"),
		@NamedQuery(name = "ViewPpLoandetail.findByPaNoofinstallments", query = "SELECT v FROM ViewPpLoandetail v WHERE v.paNoofinstallments = :paNoofinstallments"),
		@NamedQuery(name = "ViewPpLoandetail.findByPaRecovcommencemonth", query = "SELECT v FROM ViewPpLoandetail v WHERE v.paRecovcommencemonth = :paRecovcommencemonth"),
		@NamedQuery(name = "ViewPpLoandetail.findByPaRecovcommenceyear", query = "SELECT v FROM ViewPpLoandetail v WHERE v.paRecovcommenceyear = :paRecovcommenceyear"),
	//	@NamedQuery(name = "ViewPpLoandetail.findByPaymonth", query = "SELECT v FROM ViewPpLoandetail v WHERE v.paymonth = :paymonth"),
	//	@NamedQuery(name = "ViewPpLoandetail.findByPayyear", query = "SELECT v FROM ViewPpLoandetail v WHERE v.payyear = :payyear"),
	//	@NamedQuery(name = "ViewPpLoandetail.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpLoandetail v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
	//	@NamedQuery(name = "ViewPpLoandetail.findByAmount", query = "SELECT v FROM ViewPpLoandetail v WHERE v.amount = :amount"),
	//	@NamedQuery(name = "ViewPpLoandetail.findByInstallmentNo", query = "SELECT v FROM ViewPpLoandetail v WHERE v.installmentNo = :installmentNo"),
	//	@NamedQuery(name = "ViewPpLoandetail.findByRmOfficeid", query = "SELECT v FROM ViewPpLoandetail v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPpLoandetail.findByRegister", query = "SELECT v FROM ViewPpLoandetail v WHERE v.register = :register") })
public class ViewPpLoandetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ROWNUM")
	@Basic(optional = false)
	private long rownum;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "LOANAMOUNT")
	private int loanamount;
	@Basic(optional = false)
	@Column(name = "LOANSANCTIONORDNO")
	private String loansanctionordno;
	@Basic(optional = false)
	@Column(name = "SANCTIONDATE")
	private String sanctiondate;
	@Basic(optional = false)
	@Column(name = "LOANSHORTNAME")
	private String loanshortname;
	@Basic(optional = false)
	@Column(name = "PA_INSTALLMENTAMOUNT")
	private int paInstallmentamount;
/*	@Basic(optional = false)
	@Column(name = "PA_ISFULLYRECOVERED")
	private Character paIsfullyrecovered;*/
	@Basic(optional = false)
	@Column(name = "PA_NEXTINSTALLMENTNO")
	private short paNextinstallmentno;
	@Basic(optional = false)
	@Column(name = "PA_NOOFINSTALLMENTS")
	private short paNoofinstallments;
	@Column(name = "PA_RECOVCOMMENCEMONTH")
	private Short paRecovcommencemonth;
	@Column(name = "PA_RECOVCOMMENCEYEAR")
	private Short paRecovcommenceyear;
	/*	@Basic(optional = false)
	@Column(name = "PAYMONTH")
	private short paymonth;
	@Basic(optional = false)
	@Column(name = "PAYYEAR")
	private short payyear;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Column(name = "INSTALLMENT_NO")
	private Short installmentNo;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;*/
	@Column(name = "REGISTER")
	private Short register;

	public ViewPpLoandetail() {
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public int getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(int loanamount) {
		this.loanamount = loanamount;
	}

	public String getLoansanctionordno() {
		return loansanctionordno;
	}

	public void setLoansanctionordno(String loansanctionordno) {
		this.loansanctionordno = loansanctionordno;
	}

	public String getSanctiondate() {
		return sanctiondate;
	}

	public void setSanctiondate(String sanctiondate) {
		this.sanctiondate = sanctiondate;
	}

	public String getLoanshortname() {
		return loanshortname;
	}

	public void setLoanshortname(String loanshortname) {
		this.loanshortname = loanshortname;
	}

	public int getPaInstallmentamount() {
		return paInstallmentamount;
	}

	public void setPaInstallmentamount(int paInstallmentamount) {
		this.paInstallmentamount = paInstallmentamount;
	}

	
	public short getPaNextinstallmentno() {
		return paNextinstallmentno;
	}

	public void setPaNextinstallmentno(short paNextinstallmentno) {
		this.paNextinstallmentno = paNextinstallmentno;
	}

	public short getPaNoofinstallments() {
		return paNoofinstallments;
	}

	public void setPaNoofinstallments(short paNoofinstallments) {
		this.paNoofinstallments = paNoofinstallments;
	}

	public Short getPaRecovcommencemonth() {
		return paRecovcommencemonth;
	}

	public void setPaRecovcommencemonth(Short paRecovcommencemonth) {
		this.paRecovcommencemonth = paRecovcommencemonth;
	}

	public Short getPaRecovcommenceyear() {
		return paRecovcommenceyear;
	}

	public void setPaRecovcommenceyear(Short paRecovcommenceyear) {
		this.paRecovcommenceyear = paRecovcommenceyear;
	}

	
	public Short getRegister() {
		return register;
	}

	public void setRegister(Short register) {
		this.register = register;
	}

	public long getRownum() {
		return rownum;
	}

	public void setRownum(long rownum) {
		this.rownum = rownum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
