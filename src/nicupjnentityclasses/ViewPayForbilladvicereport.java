/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "VIEW_PAY_FORBILLADVICEREPORT")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewPayForbilladvicereport.findAll", query = "SELECT v FROM ViewPayForbilladvicereport v"),
		@NamedQuery(name = "ViewPayForbilladvicereport.findByPpEmployeemasterid", query = "SELECT v FROM ViewPayForbilladvicereport v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPayForbilladvicereport.findByEmployeecode", query = "SELECT v FROM ViewPayForbilladvicereport v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPayForbilladvicereport.findByEmployeename", query = "SELECT v FROM ViewPayForbilladvicereport v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPayForbilladvicereport.findByRmOfficeid", query = "SELECT v FROM ViewPayForbilladvicereport v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPayForbilladvicereport.findBySysPaymentmodeid", query = "SELECT v FROM ViewPayForbilladvicereport v WHERE v.sysPaymentmodeid = :sysPaymentmodeid"),
		@NamedQuery(name = "ViewPayForbilladvicereport.findByBankaccno", query = "SELECT v FROM ViewPayForbilladvicereport v WHERE v.bankaccno = :bankaccno"),
		@NamedQuery(name = "ViewPayForbilladvicereport.findByPaymonth", query = "SELECT v FROM ViewPayForbilladvicereport v WHERE v.paymonth = :paymonth"),
		@NamedQuery(name = "ViewPayForbilladvicereport.findByPayyear", query = "SELECT v FROM ViewPayForbilladvicereport v WHERE v.payyear = :payyear"),
		@NamedQuery(name = "ViewPayForbilladvicereport.findByPpNetpay", query = "SELECT v FROM ViewPayForbilladvicereport v WHERE v.ppNetpay = :ppNetpay"),
		@NamedQuery(name = "ViewPayForbilladvicereport.findByBilldate", query = "SELECT v FROM ViewPayForbilladvicereport v WHERE v.billdate = :billdate"),
		@NamedQuery(name = "ViewPayForbilladvicereport.findByBranchname", query = "SELECT v FROM ViewPayForbilladvicereport v WHERE v.branchname = :branchname"),
		@NamedQuery(name = "ViewPayForbilladvicereport.findByBankname", query = "SELECT v FROM ViewPayForbilladvicereport v WHERE v.bankname = :bankname"),
		@NamedQuery(name = "ViewPayForbilladvicereport.findByPpPaybilldetailid", query = "SELECT v FROM ViewPayForbilladvicereport v WHERE v.ppPaybilldetailid = :ppPaybilldetailid") })
public class ViewPayForbilladvicereport implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Column(name = "SYS_PAYMENTMODEID")
	private Short sysPaymentmodeid;
	@Column(name = "BANKACCNO")
	private String bankaccno;
	@Basic(optional = false)
	@Column(name = "PAYMONTH")
	private short paymonth;
	@Basic(optional = false)
	@Column(name = "PAYYEAR")
	private short payyear;
	@Basic(optional = false)
	@Column(name = "PP_NETPAY")
	private int ppNetpay;
	@Column(name = "BILLDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date billdate;
	@Column(name = "BRANCHNAME")
	private String branchname;
	@Column(name = "BANKNAME")
	private String bankname;
	@Basic(optional = false)
	@Column(name = "PP_PAYBILLDETAILID")
	private long ppPaybilldetailid;

	public ViewPayForbilladvicereport() {
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
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

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Short getSysPaymentmodeid() {
		return sysPaymentmodeid;
	}

	public void setSysPaymentmodeid(Short sysPaymentmodeid) {
		this.sysPaymentmodeid = sysPaymentmodeid;
	}

	public String getBankaccno() {
		return bankaccno;
	}

	public void setBankaccno(String bankaccno) {
		this.bankaccno = bankaccno;
	}

	public short getPaymonth() {
		return paymonth;
	}

	public void setPaymonth(short paymonth) {
		this.paymonth = paymonth;
	}

	public short getPayyear() {
		return payyear;
	}

	public void setPayyear(short payyear) {
		this.payyear = payyear;
	}

	public int getPpNetpay() {
		return ppNetpay;
	}

	public void setPpNetpay(int ppNetpay) {
		this.ppNetpay = ppNetpay;
	}

	public Date getBilldate() {
		return billdate;
	}

	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public long getPpPaybilldetailid() {
		return ppPaybilldetailid;
	}

	public void setPpPaybilldetailid(long ppPaybilldetailid) {
		this.ppPaybilldetailid = ppPaybilldetailid;
	}

}
