/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "VIEW_PP_EMP_LIST_CREDITLEAVES")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewPpEmpListCreditleaves.findAll", query = "SELECT v FROM ViewPpEmpListCreditleaves v"),
		@NamedQuery(name = "ViewPpEmpListCreditleaves.findByEmployeename", query = "SELECT v FROM ViewPpEmpListCreditleaves v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPpEmpListCreditleaves.findByEmployeecode", query = "SELECT v FROM ViewPpEmpListCreditleaves v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPpEmpListCreditleaves.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpEmpListCreditleaves v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpEmpListCreditleaves.findByPreviousbalance", query = "SELECT v FROM ViewPpEmpListCreditleaves v WHERE v.previousbalance = :previousbalance"),
		@NamedQuery(name = "ViewPpEmpListCreditleaves.findByPrebalancedate", query = "SELECT v FROM ViewPpEmpListCreditleaves v WHERE v.prebalancedate = :prebalancedate"),
		@NamedQuery(name = "ViewPpEmpListCreditleaves.findByAdvanceleavetoadjust", query = "SELECT v FROM ViewPpEmpListCreditleaves v WHERE v.advanceleavetoadjust = :advanceleavetoadjust"),
		@NamedQuery(name = "ViewPpEmpListCreditleaves.findByPpLeaveaccountid", query = "SELECT v FROM ViewPpEmpListCreditleaves v WHERE v.ppLeaveaccountid = :ppLeaveaccountid"),
		@NamedQuery(name = "ViewPpEmpListCreditleaves.findByDefaultcreditvalue", query = "SELECT v FROM ViewPpEmpListCreditleaves v WHERE v.defaultcreditvalue = :defaultcreditvalue"),
		@NamedQuery(name = "ViewPpEmpListCreditleaves.findBySysLeavetypemasterid", query = "SELECT v FROM ViewPpEmpListCreditleaves v WHERE v.sysLeavetypemasterid = :sysLeavetypemasterid") })
public class ViewPpEmpListCreditleaves implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Column(name = "PREVIOUSBALANCE")
	private BigInteger previousbalance;
	@Column(name = "PREBALANCEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date prebalancedate;
	@Column(name = "ADVANCELEAVETOADJUST")
	private BigInteger advanceleavetoadjust;
	@Column(name = "PP_LEAVEACCOUNTID")
	private BigInteger ppLeaveaccountid;
	@Basic(optional = false)
	@Column(name = "DEFAULTCREDITVALUE")
	private short defaultcreditvalue;
	@Basic(optional = false)
	@Column(name = "SYS_LEAVETYPEMASTERID")
	private short sysLeavetypemasterid;

	public ViewPpEmpListCreditleaves() {
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public BigInteger getPreviousbalance() {
		return previousbalance;
	}

	public void setPreviousbalance(BigInteger previousbalance) {
		this.previousbalance = previousbalance;
	}

	public Date getPrebalancedate() {
		return prebalancedate;
	}

	public void setPrebalancedate(Date prebalancedate) {
		this.prebalancedate = prebalancedate;
	}

	public BigInteger getAdvanceleavetoadjust() {
		return advanceleavetoadjust;
	}

	public void setAdvanceleavetoadjust(BigInteger advanceleavetoadjust) {
		this.advanceleavetoadjust = advanceleavetoadjust;
	}

	public BigInteger getPpLeaveaccountid() {
		return ppLeaveaccountid;
	}

	public void setPpLeaveaccountid(BigInteger ppLeaveaccountid) {
		this.ppLeaveaccountid = ppLeaveaccountid;
	}

	public short getDefaultcreditvalue() {
		return defaultcreditvalue;
	}

	public void setDefaultcreditvalue(short defaultcreditvalue) {
		this.defaultcreditvalue = defaultcreditvalue;
	}

	public short getSysLeavetypemasterid() {
		return sysLeavetypemasterid;
	}

	public void setSysLeavetypemasterid(short sysLeavetypemasterid) {
		this.sysLeavetypemasterid = sysLeavetypemasterid;
	}

}
