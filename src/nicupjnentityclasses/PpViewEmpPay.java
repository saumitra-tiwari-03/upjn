/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_VIEW_EMP_PAY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpViewEmpPay.findAll", query = "SELECT p FROM PpViewEmpPay p"),
		@NamedQuery(name = "PpViewEmpPay.findByPpEmployeepaydetailid", query = "SELECT p FROM PpViewEmpPay p WHERE p.ppEmployeepaydetailid = :ppEmployeepaydetailid"),
		@NamedQuery(name = "PpViewEmpPay.findByPaycategory", query = "SELECT p FROM PpViewEmpPay p WHERE p.paycategory = :paycategory"),
		@NamedQuery(name = "PpViewEmpPay.findByEmpname", query = "SELECT p FROM PpViewEmpPay p WHERE p.empname = :empname"),
		@NamedQuery(name = "PpViewEmpPay.findByEmployeecode", query = "SELECT p FROM PpViewEmpPay p WHERE p.employeecode = :employeecode"),
		@NamedQuery(name = "PpViewEmpPay.findByDesignation", query = "SELECT p FROM PpViewEmpPay p WHERE p.designation = :designation"),
		@NamedQuery(name = "PpViewEmpPay.findByGpfacno", query = "SELECT p FROM PpViewEmpPay p WHERE p.gpfacno = :gpfacno"),
		@NamedQuery(name = "PpViewEmpPay.findByBankaccno", query = "SELECT p FROM PpViewEmpPay p WHERE p.bankaccno = :bankaccno"),
		@NamedQuery(name = "PpViewEmpPay.findByNoofdays", query = "SELECT p FROM PpViewEmpPay p WHERE p.noofdays = :noofdays"),
		@NamedQuery(name = "PpViewEmpPay.findByPaymonth", query = "SELECT p FROM PpViewEmpPay p WHERE p.paymonth = :paymonth"),
		@NamedQuery(name = "PpViewEmpPay.findByPayyear", query = "SELECT p FROM PpViewEmpPay p WHERE p.payyear = :payyear"),
		@NamedQuery(name = "PpViewEmpPay.findByHeadid", query = "SELECT p FROM PpViewEmpPay p WHERE p.headid = :headid"),
		@NamedQuery(name = "PpViewEmpPay.findByHeadname", query = "SELECT p FROM PpViewEmpPay p WHERE p.headname = :headname"),
		@NamedQuery(name = "PpViewEmpPay.findByHeadtype", query = "SELECT p FROM PpViewEmpPay p WHERE p.headtype = :headtype"),
		@NamedQuery(name = "PpViewEmpPay.findByPrintOrder", query = "SELECT p FROM PpViewEmpPay p WHERE p.printOrder = :printOrder"),
		@NamedQuery(name = "PpViewEmpPay.findByAmount", query = "SELECT p FROM PpViewEmpPay p WHERE p.amount = :amount"),
		@NamedQuery(name = "PpViewEmpPay.findByPpRegistermasterid", query = "SELECT p FROM PpViewEmpPay p WHERE p.ppRegistermasterid = :ppRegistermasterid"),
		@NamedQuery(name = "PpViewEmpPay.findByInstallment", query = "SELECT p FROM PpViewEmpPay p WHERE p.installment = :installment") })
public class PpViewEmpPay implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "PP_EMPLOYEEPAYDETAILID")
	private Long ppEmployeepaydetailid;
	@Basic(optional = false)
	@Column(name = "PAYCATEGORY")
	private String paycategory;
	@Column(name = "EMPNAME")
	private String empname;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "GPFACNO")
	private String gpfacno;
	@Column(name = "BANKACCNO")
	private String bankaccno;
	@Column(name = "NOOFDAYS")
	private Short noofdays;
	@Basic(optional = false)
	@Column(name = "PAYMONTH")
	private short paymonth;
	@Basic(optional = false)
	@Column(name = "PAYYEAR")
	private short payyear;
	@Column(name = "HEADID")
	private BigInteger headid;
	@Column(name = "HEADNAME")
	private String headname;
	@Column(name = "HEADTYPE")
	private String headtype;
	@Column(name = "PRINT_ORDER")
	private BigInteger printOrder;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Basic(optional = false)
	@Column(name = "PP_REGISTERMASTERID")
	private short ppRegistermasterid;
	@Column(name = "INSTALLMENT")
	private String installment;
	@JoinColumn(name = "RM_OFFICEID", referencedColumnName = "RM_OFFICEID")
	@ManyToOne
	private RmOffice rmOfficeid;
	@JoinColumn(name = "PP_PAYSCALEMASTERID", referencedColumnName = "PP_PAYSCALEMASTERID")
	@ManyToOne
	private PpPayscalemaster ppPayscalemasterid;
	@JoinColumn(name = "PP_PAYBILLDETAILID", referencedColumnName = "PP_PAYBILLDETAILID")
	@ManyToOne(optional = false)
	private PpPaybilldetail ppPaybilldetailid;
	@JoinColumn(name = "PP_MONTHLYPAYID", referencedColumnName = "PP_MONTHLYPAYID")
	@ManyToOne(optional = false)
	private PpMonthlypay ppMonthlypayid;

	public PpViewEmpPay() {
	}

	public Long getPpEmployeepaydetailid() {
		return ppEmployeepaydetailid;
	}

	public void setPpEmployeepaydetailid(Long ppEmployeepaydetailid) {
		this.ppEmployeepaydetailid = ppEmployeepaydetailid;
	}

	public String getPaycategory() {
		return paycategory;
	}

	public void setPaycategory(String paycategory) {
		this.paycategory = paycategory;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGpfacno() {
		return gpfacno;
	}

	public void setGpfacno(String gpfacno) {
		this.gpfacno = gpfacno;
	}

	public String getBankaccno() {
		return bankaccno;
	}

	public void setBankaccno(String bankaccno) {
		this.bankaccno = bankaccno;
	}

	public Short getNoofdays() {
		return noofdays;
	}

	public void setNoofdays(Short noofdays) {
		this.noofdays = noofdays;
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

	public BigInteger getHeadid() {
		return headid;
	}

	public void setHeadid(BigInteger headid) {
		this.headid = headid;
	}

	public String getHeadname() {
		return headname;
	}

	public void setHeadname(String headname) {
		this.headname = headname;
	}

	public String getHeadtype() {
		return headtype;
	}

	public void setHeadtype(String headtype) {
		this.headtype = headtype;
	}

	public BigInteger getPrintOrder() {
		return printOrder;
	}

	public void setPrintOrder(BigInteger printOrder) {
		this.printOrder = printOrder;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public short getPpRegistermasterid() {
		return ppRegistermasterid;
	}

	public void setPpRegistermasterid(short ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public String getInstallment() {
		return installment;
	}

	public void setInstallment(String installment) {
		this.installment = installment;
	}

	public RmOffice getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(RmOffice rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public PpPayscalemaster getPpPayscalemasterid() {
		return ppPayscalemasterid;
	}

	public void setPpPayscalemasterid(PpPayscalemaster ppPayscalemasterid) {
		this.ppPayscalemasterid = ppPayscalemasterid;
	}

	public PpPaybilldetail getPpPaybilldetailid() {
		return ppPaybilldetailid;
	}

	public void setPpPaybilldetailid(PpPaybilldetail ppPaybilldetailid) {
		this.ppPaybilldetailid = ppPaybilldetailid;
	}

	public PpMonthlypay getPpMonthlypayid() {
		return ppMonthlypayid;
	}

	public void setPpMonthlypayid(PpMonthlypay ppMonthlypayid) {
		this.ppMonthlypayid = ppMonthlypayid;
	}

}
