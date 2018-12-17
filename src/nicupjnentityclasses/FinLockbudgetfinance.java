/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "FIN_LOCKBUDGETFINANCE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FinLockbudgetfinance.findAll", query = "SELECT f FROM FinLockbudgetfinance f"),
		@NamedQuery(name = "FinLockbudgetfinance.findByFinLockbudgetfinanceid", query = "SELECT f FROM FinLockbudgetfinance f WHERE f.finLockbudgetfinanceid = :finLockbudgetfinanceid"),
		@NamedQuery(name = "FinLockbudgetfinance.findByFinancemonth", query = "SELECT f FROM FinLockbudgetfinance f WHERE f.financemonth = :financemonth"),
		@NamedQuery(name = "FinLockbudgetfinance.findByFinanceyear", query = "SELECT f FROM FinLockbudgetfinance f WHERE f.financeyear = :financeyear"),
		@NamedQuery(name = "FinLockbudgetfinance.findByFinanciername", query = "SELECT f FROM FinLockbudgetfinance f WHERE f.financiername = :financiername"),
		@NamedQuery(name = "FinLockbudgetfinance.findByRmOfficeid", query = "SELECT f FROM FinLockbudgetfinance f WHERE f.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "FinLockbudgetfinance.findByLockdate", query = "SELECT f FROM FinLockbudgetfinance f WHERE f.lockdate = :lockdate"),
		@NamedQuery(name = "FinLockbudgetfinance.findByIslocked", query = "SELECT f FROM FinLockbudgetfinance f WHERE f.islocked = :islocked"),
		@NamedQuery(name = "FinLockbudgetfinance.findByOfficename", query = "SELECT f FROM FinLockbudgetfinance f WHERE f.officename = :officename") })
public class FinLockbudgetfinance implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "FIN_LOCKBUDGETFINANCEID")
	private Long finLockbudgetfinanceid;
	@Basic(optional = false)
	@Column(name = "FINANCEMONTH")
	private String financemonth;
	@Basic(optional = false)
	@Column(name = "FINANCEYEAR")
	private long financeyear;
	@Column(name = "FINANCIERNAME")
	private String financiername;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private String rmOfficeid;
	@Column(name = "LOCKDATE")
	private String lockdate;
	@Basic(optional = false)
	@Column(name = "ISLOCKED")
	private String islocked;
	@Column(name = "OFFICENAME")
	private String officename;

	public FinLockbudgetfinance() {
	}

	public FinLockbudgetfinance(Long finLockbudgetfinanceid) {
		this.finLockbudgetfinanceid = finLockbudgetfinanceid;
	}

	public FinLockbudgetfinance(Long finLockbudgetfinanceid, String financemonth, long financeyear, String rmOfficeid,
			String islocked) {
		this.finLockbudgetfinanceid = finLockbudgetfinanceid;
		this.financemonth = financemonth;
		this.financeyear = financeyear;
		this.rmOfficeid = rmOfficeid;
		this.islocked = islocked;
	}

	public Long getFinLockbudgetfinanceid() {
		return finLockbudgetfinanceid;
	}

	public void setFinLockbudgetfinanceid(Long finLockbudgetfinanceid) {
		this.finLockbudgetfinanceid = finLockbudgetfinanceid;
	}

	public String getFinancemonth() {
		return financemonth;
	}

	public void setFinancemonth(String financemonth) {
		this.financemonth = financemonth;
	}

	public long getFinanceyear() {
		return financeyear;
	}

	public void setFinanceyear(long financeyear) {
		this.financeyear = financeyear;
	}

	public String getFinanciername() {
		return financiername;
	}

	public void setFinanciername(String financiername) {
		this.financiername = financiername;
	}

	public String getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(String rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getLockdate() {
		return lockdate;
	}

	public void setLockdate(String lockdate) {
		this.lockdate = lockdate;
	}

	public String getIslocked() {
		return islocked;
	}

	public void setIslocked(String islocked) {
		this.islocked = islocked;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (finLockbudgetfinanceid != null ? finLockbudgetfinanceid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof FinLockbudgetfinance)) {
			return false;
		}
		FinLockbudgetfinance other = (FinLockbudgetfinance) object;
		if ((this.finLockbudgetfinanceid == null && other.finLockbudgetfinanceid != null)
				|| (this.finLockbudgetfinanceid != null
						&& !this.finLockbudgetfinanceid.equals(other.finLockbudgetfinanceid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.FinLockbudgetfinance[ finLockbudgetfinanceid=" + finLockbudgetfinanceid + " ]";
	}

}
