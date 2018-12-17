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
@Table(name = "FIN_HQ")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FinHq.findAll", query = "SELECT f FROM FinHq f"),
		@NamedQuery(name = "FinHq.findByFinHqentryid", query = "SELECT f FROM FinHq f WHERE f.finHqentryid = :finHqentryid"),
		@NamedQuery(name = "FinHq.findByPlace", query = "SELECT f FROM FinHq f WHERE f.place = :place"),
		@NamedQuery(name = "FinHq.findByFinancemonth", query = "SELECT f FROM FinHq f WHERE f.financemonth = :financemonth"),
		@NamedQuery(name = "FinHq.findByFinanceyear", query = "SELECT f FROM FinHq f WHERE f.financeyear = :financeyear"),
		@NamedQuery(name = "FinHq.findByFinProgramid", query = "SELECT f FROM FinHq f WHERE f.finProgramid = :finProgramid"),
		@NamedQuery(name = "FinHq.findByRecievedbyhq", query = "SELECT f FROM FinHq f WHERE f.recievedbyhq = :recievedbyhq"),
		@NamedQuery(name = "FinHq.findByReleasedtofield", query = "SELECT f FROM FinHq f WHERE f.releasedtofield = :releasedtofield"),
		@NamedQuery(name = "FinHq.findByRmOfficeid", query = "SELECT f FROM FinHq f WHERE f.rmOfficeid = :rmOfficeid") })
public class FinHq implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "FIN_HQENTRYID")
	private Long finHqentryid;
	@Basic(optional = false)
	@Column(name = "PLACE")
	private String place;
	@Column(name = "FINANCEMONTH")
	private String financemonth;
	@Column(name = "FINANCEYEAR")
	private Long financeyear;
	@Basic(optional = false)
	@Column(name = "FIN_PROGRAMID")
	private long finProgramid;
	@Basic(optional = false)
	@Column(name = "RECIEVEDBYHQ")
	private String recievedbyhq;
	@Basic(optional = false)
	@Column(name = "RELEASEDTOFIELD")
	private String releasedtofield;
	@Column(name = "RM_OFFICEID")
	private String rmOfficeid;

	public FinHq() {
	}

	public FinHq(Long finHqentryid) {
		this.finHqentryid = finHqentryid;
	}

	public FinHq(Long finHqentryid, String place, long finProgramid, String recievedbyhq, String releasedtofield) {
		this.finHqentryid = finHqentryid;
		this.place = place;
		this.finProgramid = finProgramid;
		this.recievedbyhq = recievedbyhq;
		this.releasedtofield = releasedtofield;
	}

	public Long getFinHqentryid() {
		return finHqentryid;
	}

	public void setFinHqentryid(Long finHqentryid) {
		this.finHqentryid = finHqentryid;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getFinancemonth() {
		return financemonth;
	}

	public void setFinancemonth(String financemonth) {
		this.financemonth = financemonth;
	}

	public Long getFinanceyear() {
		return financeyear;
	}

	public void setFinanceyear(Long financeyear) {
		this.financeyear = financeyear;
	}

	public long getFinProgramid() {
		return finProgramid;
	}

	public void setFinProgramid(long finProgramid) {
		this.finProgramid = finProgramid;
	}

	public String getRecievedbyhq() {
		return recievedbyhq;
	}

	public void setRecievedbyhq(String recievedbyhq) {
		this.recievedbyhq = recievedbyhq;
	}

	public String getReleasedtofield() {
		return releasedtofield;
	}

	public void setReleasedtofield(String releasedtofield) {
		this.releasedtofield = releasedtofield;
	}

	public String getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(String rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (finHqentryid != null ? finHqentryid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof FinHq)) {
			return false;
		}
		FinHq other = (FinHq) object;
		if ((this.finHqentryid == null && other.finHqentryid != null)
				|| (this.finHqentryid != null && !this.finHqentryid.equals(other.finHqentryid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.FinHq[ finHqentryid=" + finHqentryid + " ]";
	}

}
