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
@Table(name = "VIEW_EMP_ALW_DEDLIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewEmpAlwDedlist.findAll", query = "SELECT v FROM ViewEmpAlwDedlist v"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByPpEmployeepaydetailid", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.ppEmployeepaydetailid = :ppEmployeepaydetailid"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByPaycategory", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.paycategory = :paycategory"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByEmpname", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.empname = :empname"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByEmployeecode", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByDesignation", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByGpfacno", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.gpfacno = :gpfacno"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByBankaccno", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.bankaccno = :bankaccno"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByNoofdays", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.noofdays = :noofdays"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByPaymonth", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.paymonth = :paymonth"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByPayyear", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.payyear = :payyear"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByHeadid", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.headid = :headid"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByHeadname", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.headname = :headname"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByHeadtype", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.headtype = :headtype"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByPrintOrder", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.printOrder = :printOrder"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByAmount", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.amount = :amount"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByPpRegistermasterid", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.ppRegistermasterid = :ppRegistermasterid"),
		@NamedQuery(name = "ViewEmpAlwDedlist.findByInsatllment", query = "SELECT v FROM ViewEmpAlwDedlist v WHERE v.insatllment = :insatllment") })
public class ViewEmpAlwDedlist implements Serializable {
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
	private Character headtype;
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
	@Column(name = "INSATLLMENT")
	private String insatllment;
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

	public ViewEmpAlwDedlist() {
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

	public Character getHeadtype() {
		return headtype;
	}

	public void setHeadtype(Character headtype) {
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

	public String getInsatllment() {
		return insatllment;
	}

	public void setInsatllment(String insatllment) {
		this.insatllment = insatllment;
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
