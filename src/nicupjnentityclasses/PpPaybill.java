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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_PAYBILL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpPaybill.findAll", query = "SELECT p FROM PpPaybill p"),
		@NamedQuery(name = "PpPaybill.findByEmployeecode", query = "SELECT p FROM PpPaybill p WHERE p.employeecode = :employeecode"),
		@NamedQuery(name = "PpPaybill.findByEmpname", query = "SELECT p FROM PpPaybill p WHERE p.empname = :empname"),
		@NamedQuery(name = "PpPaybill.findByDesignation", query = "SELECT p FROM PpPaybill p WHERE p.designation = :designation"),
		@NamedQuery(name = "PpPaybill.findByPpMonthlypayid", query = "SELECT p FROM PpPaybill p WHERE p.ppMonthlypayid = :ppMonthlypayid"),
		@NamedQuery(name = "PpPaybill.findByNoofdays", query = "SELECT p FROM PpPaybill p WHERE p.noofdays = :noofdays"),
		@NamedQuery(name = "PpPaybill.findByPaymonth", query = "SELECT p FROM PpPaybill p WHERE p.paymonth = :paymonth"),
		@NamedQuery(name = "PpPaybill.findByPayyear", query = "SELECT p FROM PpPaybill p WHERE p.payyear = :payyear"),
		@NamedQuery(name = "PpPaybill.findByHeadid", query = "SELECT p FROM PpPaybill p WHERE p.headid = :headid"),
		@NamedQuery(name = "PpPaybill.findByHeadtype", query = "SELECT p FROM PpPaybill p WHERE p.headtype = :headtype"),
		@NamedQuery(name = "PpPaybill.findByPrintOrder", query = "SELECT p FROM PpPaybill p WHERE p.printOrder = :printOrder"),
		@NamedQuery(name = "PpPaybill.findByAmount", query = "SELECT p FROM PpPaybill p WHERE p.amount = :amount") })
public class PpPaybill implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPNAME")
	private String empname;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "PP_MONTHLYPAYID")
	private long ppMonthlypayid;
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
	@Column(name = "HEADTYPE")
	private Character headtype;
	@Column(name = "PRINT_ORDER")
	private BigInteger printOrder;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private BigDecimal amount;

	public PpPaybill() {
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getPpMonthlypayid() {
		return ppMonthlypayid;
	}

	public void setPpMonthlypayid(long ppMonthlypayid) {
		this.ppMonthlypayid = ppMonthlypayid;
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

}
