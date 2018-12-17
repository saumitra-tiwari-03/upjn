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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PP_LEAVEACCOUNT")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpLeaveaccount.findAll", query = "SELECT p FROM PpLeaveaccount p"),
		@NamedQuery(name = "PpLeaveaccount.findByPpLeaveaccountid", query = "SELECT p FROM PpLeaveaccount p WHERE p.ppLeaveaccountid = :ppLeaveaccountid"),
		@NamedQuery(name = "PpLeaveaccount.findByPreviousbalance", query = "SELECT p FROM PpLeaveaccount p WHERE p.previousbalance = :previousbalance"),
		@NamedQuery(name = "PpLeaveaccount.findByPrebalancedate", query = "SELECT p FROM PpLeaveaccount p WHERE p.prebalancedate = :prebalancedate"),
		@NamedQuery(name = "PpLeaveaccount.findByLeaveavailed", query = "SELECT p FROM PpLeaveaccount p WHERE p.leaveavailed = :leaveavailed"),
		@NamedQuery(name = "PpLeaveaccount.findByLeavecredited", query = "SELECT p FROM PpLeaveaccount p WHERE p.leavecredited = :leavecredited"),
		@NamedQuery(name = "PpLeaveaccount.findByCreditdate", query = "SELECT p FROM PpLeaveaccount p WHERE p.creditdate = :creditdate"),
		@NamedQuery(name = "PpLeaveaccount.findByBalance", query = "SELECT p FROM PpLeaveaccount p WHERE p.balance = :balance"),
		@NamedQuery(name = "PpLeaveaccount.findByIslocked", query = "SELECT p FROM PpLeaveaccount p WHERE p.islocked = :islocked"),
		@NamedQuery(name = "PpLeaveaccount.findByAdvanceleaveavailed", query = "SELECT p FROM PpLeaveaccount p WHERE p.advanceleaveavailed = :advanceleaveavailed"),
		@NamedQuery(name = "PpLeaveaccount.findByAdvanceleaveadjusted", query = "SELECT p FROM PpLeaveaccount p WHERE p.advanceleaveadjusted = :advanceleaveadjusted"),
		@NamedQuery(name = "PpLeaveaccount.findByAdvanceleavetoadjust", query = "SELECT p FROM PpLeaveaccount p WHERE p.advanceleavetoadjust = :advanceleavetoadjust") })
public class PpLeaveaccount implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_LEAVEACCOUNTID")
	private Long ppLeaveaccountid;
	@Column(name = "PREVIOUSBALANCE")
	private Short previousbalance;
	@Column(name = "PREBALANCEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date prebalancedate;
	@Column(name = "LEAVEAVAILED")
	private Short leaveavailed;
	@Column(name = "LEAVECREDITED")
	private Short leavecredited;
	@Column(name = "CREDITDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creditdate;
	@Column(name = "BALANCE")
	private Short balance;
	@Basic(optional = false)
	@Column(name = "ISLOCKED")
	private Character islocked;
	@Basic(optional = false)
	@Column(name = "ADVANCELEAVEAVAILED")
	private short advanceleaveavailed;
	@Basic(optional = false)
	@Column(name = "ADVANCELEAVEADJUSTED")
	private short advanceleaveadjusted;
	@Basic(optional = false)
	@Column(name = "ADVANCELEAVETOADJUST")
	private short advanceleavetoadjust;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;
	@JoinColumn(name = "SYS_LEAVETYPEMASTERID", referencedColumnName = "SYS_LEAVETYPEMASTERID")
	@ManyToOne(optional = false)
	private SysLeavetypemaster sysLeavetypemasterid;

	public PpLeaveaccount() {
	}

	public PpLeaveaccount(Long ppLeaveaccountid) {
		this.ppLeaveaccountid = ppLeaveaccountid;
	}

	public PpLeaveaccount(Long ppLeaveaccountid, Character islocked, short advanceleaveavailed,
			short advanceleaveadjusted, short advanceleavetoadjust) {
		this.ppLeaveaccountid = ppLeaveaccountid;
		this.islocked = islocked;
		this.advanceleaveavailed = advanceleaveavailed;
		this.advanceleaveadjusted = advanceleaveadjusted;
		this.advanceleavetoadjust = advanceleavetoadjust;
	}

	public Long getPpLeaveaccountid() {
		return ppLeaveaccountid;
	}

	public void setPpLeaveaccountid(Long ppLeaveaccountid) {
		this.ppLeaveaccountid = ppLeaveaccountid;
	}

	public Short getPreviousbalance() {
		return previousbalance;
	}

	public void setPreviousbalance(Short previousbalance) {
		this.previousbalance = previousbalance;
	}

	public Date getPrebalancedate() {
		return prebalancedate;
	}

	public void setPrebalancedate(Date prebalancedate) {
		this.prebalancedate = prebalancedate;
	}

	public Short getLeaveavailed() {
		return leaveavailed;
	}

	public void setLeaveavailed(Short leaveavailed) {
		this.leaveavailed = leaveavailed;
	}

	public Short getLeavecredited() {
		return leavecredited;
	}

	public void setLeavecredited(Short leavecredited) {
		this.leavecredited = leavecredited;
	}

	public Date getCreditdate() {
		return creditdate;
	}

	public void setCreditdate(Date creditdate) {
		this.creditdate = creditdate;
	}

	public Short getBalance() {
		return balance;
	}

	public void setBalance(Short balance) {
		this.balance = balance;
	}

	public Character getIslocked() {
		return islocked;
	}

	public void setIslocked(Character islocked) {
		this.islocked = islocked;
	}

	public short getAdvanceleaveavailed() {
		return advanceleaveavailed;
	}

	public void setAdvanceleaveavailed(short advanceleaveavailed) {
		this.advanceleaveavailed = advanceleaveavailed;
	}

	public short getAdvanceleaveadjusted() {
		return advanceleaveadjusted;
	}

	public void setAdvanceleaveadjusted(short advanceleaveadjusted) {
		this.advanceleaveadjusted = advanceleaveadjusted;
	}

	public short getAdvanceleavetoadjust() {
		return advanceleavetoadjust;
	}

	public void setAdvanceleavetoadjust(short advanceleavetoadjust) {
		this.advanceleavetoadjust = advanceleavetoadjust;
	}

	public PpEmployeemaster getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(PpEmployeemaster ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public SysLeavetypemaster getSysLeavetypemasterid() {
		return sysLeavetypemasterid;
	}

	public void setSysLeavetypemasterid(SysLeavetypemaster sysLeavetypemasterid) {
		this.sysLeavetypemasterid = sysLeavetypemasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppLeaveaccountid != null ? ppLeaveaccountid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpLeaveaccount)) {
			return false;
		}
		PpLeaveaccount other = (PpLeaveaccount) object;
		if ((this.ppLeaveaccountid == null && other.ppLeaveaccountid != null)
				|| (this.ppLeaveaccountid != null && !this.ppLeaveaccountid.equals(other.ppLeaveaccountid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpLeaveaccount[ ppLeaveaccountid=" + ppLeaveaccountid + " ]";
	}

}
