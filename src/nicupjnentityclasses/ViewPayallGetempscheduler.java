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
@Table(name = "VIEW_PAYALL_GETEMPSCHEDULER")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewPayallGetempscheduler.findAll", query = "SELECT v FROM ViewPayallGetempscheduler v"),
		@NamedQuery(name = "ViewPayallGetempscheduler.findByEmployeecode", query = "SELECT v FROM ViewPayallGetempscheduler v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPayallGetempscheduler.findByEmployeename", query = "SELECT v FROM ViewPayallGetempscheduler v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPayallGetempscheduler.findByGpfacno", query = "SELECT v FROM ViewPayallGetempscheduler v WHERE v.gpfacno = :gpfacno"),
		@NamedQuery(name = "ViewPayallGetempscheduler.findByPaymonth", query = "SELECT v FROM ViewPayallGetempscheduler v WHERE v.paymonth = :paymonth"),
		@NamedQuery(name = "ViewPayallGetempscheduler.findByPayyear", query = "SELECT v FROM ViewPayallGetempscheduler v WHERE v.payyear = :payyear"),
		@NamedQuery(name = "ViewPayallGetempscheduler.findByPpRegistermasterid", query = "SELECT v FROM ViewPayallGetempscheduler v WHERE v.ppRegistermasterid = :ppRegistermasterid"),
		@NamedQuery(name = "ViewPayallGetempscheduler.findByPpMonthlypayid", query = "SELECT v FROM ViewPayallGetempscheduler v WHERE v.ppMonthlypayid = :ppMonthlypayid"),
		@NamedQuery(name = "ViewPayallGetempscheduler.findByTranTypeid", query = "SELECT v FROM ViewPayallGetempscheduler v WHERE v.tranTypeid = :tranTypeid"),
		@NamedQuery(name = "ViewPayallGetempscheduler.findByAmount", query = "SELECT v FROM ViewPayallGetempscheduler v WHERE v.amount = :amount"),
		@NamedQuery(name = "ViewPayallGetempscheduler.findByHeadname", query = "SELECT v FROM ViewPayallGetempscheduler v WHERE v.headname = :headname"),
		@NamedQuery(name = "ViewPayallGetempscheduler.findByPpSchedulemasterid", query = "SELECT v FROM ViewPayallGetempscheduler v WHERE v.ppSchedulemasterid = :ppSchedulemasterid"),
		@NamedQuery(name = "ViewPayallGetempscheduler.findByHeadtype", query = "SELECT v FROM ViewPayallGetempscheduler v WHERE v.headtype = :headtype"),
		@NamedQuery(name = "ViewPayallGetempscheduler.findByRmOfficeid", query = "SELECT v FROM ViewPayallGetempscheduler v WHERE v.rmOfficeid = :rmOfficeid") })
public class ViewPayallGetempscheduler implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "GPFACNO")
	private String gpfacno;
	@Basic(optional = false)
	@Column(name = "PAYMONTH")
	private short paymonth;
	@Basic(optional = false)
	@Column(name = "PAYYEAR")
	private short payyear;
	@Basic(optional = false)
	@Column(name = "PP_REGISTERMASTERID")
	private short ppRegistermasterid;
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
	@Column(name = "HEADNAME")
	private String headname;
	@Column(name = "PP_SCHEDULEMASTERID")
	private BigInteger ppSchedulemasterid;
	@Column(name = "HEADTYPE")
	private Character headtype;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;

	public ViewPayallGetempscheduler() {
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

	public String getGpfacno() {
		return gpfacno;
	}

	public void setGpfacno(String gpfacno) {
		this.gpfacno = gpfacno;
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

	public short getPpRegistermasterid() {
		return ppRegistermasterid;
	}

	public void setPpRegistermasterid(short ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
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

	public String getHeadname() {
		return headname;
	}

	public void setHeadname(String headname) {
		this.headname = headname;
	}

	public BigInteger getPpSchedulemasterid() {
		return ppSchedulemasterid;
	}

	public void setPpSchedulemasterid(BigInteger ppSchedulemasterid) {
		this.ppSchedulemasterid = ppSchedulemasterid;
	}

	public Character getHeadtype() {
		return headtype;
	}

	public void setHeadtype(Character headtype) {
		this.headtype = headtype;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

}
