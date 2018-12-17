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
@Table(name = "PP_VIEW_HEAD_TYPELIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpViewHeadTypelist.findAll", query = "SELECT p FROM PpViewHeadTypelist p"),
		@NamedQuery(name = "PpViewHeadTypelist.findByHeadid", query = "SELECT p FROM PpViewHeadTypelist p WHERE p.headid = :headid"),
		@NamedQuery(name = "PpViewHeadTypelist.findByHeadtype", query = "SELECT p FROM PpViewHeadTypelist p WHERE p.headtype = :headtype"),
		@NamedQuery(name = "PpViewHeadTypelist.findByHeadname", query = "SELECT p FROM PpViewHeadTypelist p WHERE p.headname = :headname"),
		@NamedQuery(name = "PpViewHeadTypelist.findByPrintOrder", query = "SELECT p FROM PpViewHeadTypelist p WHERE p.printOrder = :printOrder"),
		@NamedQuery(name = "PpViewHeadTypelist.findByAmount", query = "SELECT p FROM PpViewHeadTypelist p WHERE p.amount = :amount"),
		@NamedQuery(name = "PpViewHeadTypelist.findByPayyear", query = "SELECT p FROM PpViewHeadTypelist p WHERE p.payyear = :payyear"),
		@NamedQuery(name = "PpViewHeadTypelist.findByPaymonth", query = "SELECT p FROM PpViewHeadTypelist p WHERE p.paymonth = :paymonth"),
		@NamedQuery(name = "PpViewHeadTypelist.findByEmployeecode", query = "SELECT p FROM PpViewHeadTypelist p WHERE p.employeecode = :employeecode") })
public class PpViewHeadTypelist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "HEADID")
	private BigInteger headid;
	@Column(name = "HEADTYPE")
	private String headtype;
	@Column(name = "HEADNAME")
	private String headname;
	@Column(name = "PRINT_ORDER")
	private BigInteger printOrder;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Basic(optional = false)
	@Column(name = "PAYYEAR")
	private short payyear;
	@Basic(optional = false)
	@Column(name = "PAYMONTH")
	private short paymonth;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;

	public PpViewHeadTypelist() {
	}

	public BigInteger getHeadid() {
		return headid;
	}

	public void setHeadid(BigInteger headid) {
		this.headid = headid;
	}

	public String getHeadtype() {
		return headtype;
	}

	public void setHeadtype(String headtype) {
		this.headtype = headtype;
	}

	public String getHeadname() {
		return headname;
	}

	public void setHeadname(String headname) {
		this.headname = headname;
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

	public short getPayyear() {
		return payyear;
	}

	public void setPayyear(short payyear) {
		this.payyear = payyear;
	}

	public short getPaymonth() {
		return paymonth;
	}

	public void setPaymonth(short paymonth) {
		this.paymonth = paymonth;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

}
