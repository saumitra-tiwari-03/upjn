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
@Table(name = "PP_ADVERSEENTRY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpAdverseentry.findAll", query = "SELECT p FROM PpAdverseentry p"),
		@NamedQuery(name = "PpAdverseentry.findByPpAdverseentryid", query = "SELECT p FROM PpAdverseentry p WHERE p.ppAdverseentryid = :ppAdverseentryid"),
		@NamedQuery(name = "PpAdverseentry.findByEntrysubject", query = "SELECT p FROM PpAdverseentry p WHERE p.entrysubject = :entrysubject"),
		@NamedQuery(name = "PpAdverseentry.findByEntryofficername", query = "SELECT p FROM PpAdverseentry p WHERE p.entryofficername = :entryofficername"),
		@NamedQuery(name = "PpAdverseentry.findByEntryofficerdesignation", query = "SELECT p FROM PpAdverseentry p WHERE p.entryofficerdesignation = :entryofficerdesignation"),
		@NamedQuery(name = "PpAdverseentry.findByEntryorderno", query = "SELECT p FROM PpAdverseentry p WHERE p.entryorderno = :entryorderno"),
		@NamedQuery(name = "PpAdverseentry.findByEntryorderdate", query = "SELECT p FROM PpAdverseentry p WHERE p.entryorderdate = :entryorderdate") })
public class PpAdverseentry implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_ADVERSEENTRYID")
	private Long ppAdverseentryid;
	@Basic(optional = false)
	@Column(name = "ENTRYSUBJECT")
	private String entrysubject;
	@Basic(optional = false)
	@Column(name = "ENTRYOFFICERNAME")
	private String entryofficername;
	@Column(name = "ENTRYOFFICERDESIGNATION")
	private String entryofficerdesignation;
	@Basic(optional = false)
	@Column(name = "ENTRYORDERNO")
	private String entryorderno;
	@Basic(optional = false)
	@Column(name = "ENTRYORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date entryorderdate;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;

	public PpAdverseentry() {
	}

	public PpAdverseentry(Long ppAdverseentryid) {
		this.ppAdverseentryid = ppAdverseentryid;
	}

	public PpAdverseentry(Long ppAdverseentryid, String entrysubject, String entryofficername, String entryorderno,
			Date entryorderdate) {
		this.ppAdverseentryid = ppAdverseentryid;
		this.entrysubject = entrysubject;
		this.entryofficername = entryofficername;
		this.entryorderno = entryorderno;
		this.entryorderdate = entryorderdate;
	}

	public Long getPpAdverseentryid() {
		return ppAdverseentryid;
	}

	public void setPpAdverseentryid(Long ppAdverseentryid) {
		this.ppAdverseentryid = ppAdverseentryid;
	}

	public String getEntrysubject() {
		return entrysubject;
	}

	public void setEntrysubject(String entrysubject) {
		this.entrysubject = entrysubject;
	}

	public String getEntryofficername() {
		return entryofficername;
	}

	public void setEntryofficername(String entryofficername) {
		this.entryofficername = entryofficername;
	}

	public String getEntryofficerdesignation() {
		return entryofficerdesignation;
	}

	public void setEntryofficerdesignation(String entryofficerdesignation) {
		this.entryofficerdesignation = entryofficerdesignation;
	}

	public String getEntryorderno() {
		return entryorderno;
	}

	public void setEntryorderno(String entryorderno) {
		this.entryorderno = entryorderno;
	}

	public Date getEntryorderdate() {
		return entryorderdate;
	}

	public void setEntryorderdate(Date entryorderdate) {
		this.entryorderdate = entryorderdate;
	}

	public PpEmployeemaster getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(PpEmployeemaster ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppAdverseentryid != null ? ppAdverseentryid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpAdverseentry)) {
			return false;
		}
		PpAdverseentry other = (PpAdverseentry) object;
		if ((this.ppAdverseentryid == null && other.ppAdverseentryid != null)
				|| (this.ppAdverseentryid != null && !this.ppAdverseentryid.equals(other.ppAdverseentryid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpAdverseentry[ ppAdverseentryid=" + ppAdverseentryid + " ]";
	}

}
