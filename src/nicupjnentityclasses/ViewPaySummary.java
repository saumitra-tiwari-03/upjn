/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "VIEW_PAY_SUMMARY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPaySummary.findAll", query = "SELECT v FROM ViewPaySummary v"),
		@NamedQuery(name = "ViewPaySummary.findByPpMonthlypayTranid", query = "SELECT v FROM ViewPaySummary v WHERE v.ppMonthlypayTranid = :ppMonthlypayTranid"),
		@NamedQuery(name = "ViewPaySummary.findByPpMonthlypayid", query = "SELECT v FROM ViewPaySummary v WHERE v.ppMonthlypayid = :ppMonthlypayid"),
		@NamedQuery(name = "ViewPaySummary.findByTranTypeid", query = "SELECT v FROM ViewPaySummary v WHERE v.tranTypeid = :tranTypeid"),
		@NamedQuery(name = "ViewPaySummary.findByAmount", query = "SELECT v FROM ViewPaySummary v WHERE v.amount = :amount"),
		@NamedQuery(name = "ViewPaySummary.findByRate", query = "SELECT v FROM ViewPaySummary v WHERE v.rate = :rate"),
		@NamedQuery(name = "ViewPaySummary.findByTranFlag", query = "SELECT v FROM ViewPaySummary v WHERE v.tranFlag = :tranFlag"),
		@NamedQuery(name = "ViewPaySummary.findByInstallmentNo", query = "SELECT v FROM ViewPaySummary v WHERE v.installmentNo = :installmentNo"),
		@NamedQuery(name = "ViewPaySummary.findByPaymonth", query = "SELECT v FROM ViewPaySummary v WHERE v.paymonth = :paymonth"),
		@NamedQuery(name = "ViewPaySummary.findByPayyear", query = "SELECT v FROM ViewPaySummary v WHERE v.payyear = :payyear"),
		@NamedQuery(name = "ViewPaySummary.findByPpEmployeemasterid", query = "SELECT v FROM ViewPaySummary v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPaySummary.findByPpRegistermasterid", query = "SELECT v FROM ViewPaySummary v WHERE v.ppRegistermasterid = :ppRegistermasterid"),
		@NamedQuery(name = "ViewPaySummary.findByRmOfficeid", query = "SELECT v FROM ViewPaySummary v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPaySummary.findByIslocked", query = "SELECT v FROM ViewPaySummary v WHERE v.islocked = :islocked") })
public class ViewPaySummary implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_MONTHLYPAY_TRANID")
	private long ppMonthlypayTranid;
	@Basic(optional = false)
	@Column(name = "PP_MONTHLYPAYID")
	private long ppMonthlypayid;
	@Basic(optional = false)
	@Column(name = "TRAN_TYPEID")
	private int tranTypeid;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Column(name = "RATE")
	private BigDecimal rate;
	@Basic(optional = false)
	@Column(name = "TRAN_FLAG")
	private Character tranFlag;
	@Column(name = "INSTALLMENT_NO")
	private Short installmentNo;
	@Basic(optional = false)
	@Column(name = "PAYMONTH")
	private short paymonth;
	@Basic(optional = false)
	@Column(name = "PAYYEAR")
	private short payyear;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "PP_REGISTERMASTERID")
	private short ppRegistermasterid;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Basic(optional = false)
	@Column(name = "ISLOCKED")
	private Character islocked;

	public ViewPaySummary() {
	}

	public long getPpMonthlypayTranid() {
		return ppMonthlypayTranid;
	}

	public void setPpMonthlypayTranid(long ppMonthlypayTranid) {
		this.ppMonthlypayTranid = ppMonthlypayTranid;
	}

	public long getPpMonthlypayid() {
		return ppMonthlypayid;
	}

	public void setPpMonthlypayid(long ppMonthlypayid) {
		this.ppMonthlypayid = ppMonthlypayid;
	}

	public int getTranTypeid() {
		return tranTypeid;
	}

	public void setTranTypeid(int tranTypeid) {
		this.tranTypeid = tranTypeid;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Character getTranFlag() {
		return tranFlag;
	}

	public void setTranFlag(Character tranFlag) {
		this.tranFlag = tranFlag;
	}

	public Short getInstallmentNo() {
		return installmentNo;
	}

	public void setInstallmentNo(Short installmentNo) {
		this.installmentNo = installmentNo;
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

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public short getPpRegistermasterid() {
		return ppRegistermasterid;
	}

	public void setPpRegistermasterid(short ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Character getIslocked() {
		return islocked;
	}

	public void setIslocked(Character islocked) {
		this.islocked = islocked;
	}

}
