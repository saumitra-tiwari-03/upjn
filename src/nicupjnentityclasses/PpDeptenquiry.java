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
@Table(name = "PP_DEPTENQUIRY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpDeptenquiry.findAll", query = "SELECT p FROM PpDeptenquiry p"),
		@NamedQuery(name = "PpDeptenquiry.findByPpDeptenquiryid", query = "SELECT p FROM PpDeptenquiry p WHERE p.ppDeptenquiryid = :ppDeptenquiryid"),
		@NamedQuery(name = "PpDeptenquiry.findByEnquirysubject", query = "SELECT p FROM PpDeptenquiry p WHERE p.enquirysubject = :enquirysubject"),
		@NamedQuery(name = "PpDeptenquiry.findBySubmissiondate", query = "SELECT p FROM PpDeptenquiry p WHERE p.submissiondate = :submissiondate"),
		@NamedQuery(name = "PpDeptenquiry.findByEnquiryofficername", query = "SELECT p FROM PpDeptenquiry p WHERE p.enquiryofficername = :enquiryofficername"),
		@NamedQuery(name = "PpDeptenquiry.findByEnquiryofficerdesignation", query = "SELECT p FROM PpDeptenquiry p WHERE p.enquiryofficerdesignation = :enquiryofficerdesignation"),
		@NamedQuery(name = "PpDeptenquiry.findByPunishment", query = "SELECT p FROM PpDeptenquiry p WHERE p.punishment = :punishment"),
		@NamedQuery(name = "PpDeptenquiry.findByIspunishable", query = "SELECT p FROM PpDeptenquiry p WHERE p.ispunishable = :ispunishable") })
public class PpDeptenquiry implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_DEPTENQUIRYID")
	private Long ppDeptenquiryid;
	@Basic(optional = false)
	@Column(name = "ENQUIRYSUBJECT")
	private String enquirysubject;
	@Basic(optional = false)
	@Column(name = "SUBMISSIONDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date submissiondate;
	@Basic(optional = false)
	@Column(name = "ENQUIRYOFFICERNAME")
	private String enquiryofficername;
	@Column(name = "ENQUIRYOFFICERDESIGNATION")
	private String enquiryofficerdesignation;
	@Column(name = "PUNISHMENT")
	private String punishment;
	@Basic(optional = false)
	@Column(name = "ISPUNISHABLE")
	private Character ispunishable;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;

	public PpDeptenquiry() {
	}

	public PpDeptenquiry(Long ppDeptenquiryid) {
		this.ppDeptenquiryid = ppDeptenquiryid;
	}

	public PpDeptenquiry(Long ppDeptenquiryid, String enquirysubject, Date submissiondate, String enquiryofficername,
			Character ispunishable) {
		this.ppDeptenquiryid = ppDeptenquiryid;
		this.enquirysubject = enquirysubject;
		this.submissiondate = submissiondate;
		this.enquiryofficername = enquiryofficername;
		this.ispunishable = ispunishable;
	}

	public Long getPpDeptenquiryid() {
		return ppDeptenquiryid;
	}

	public void setPpDeptenquiryid(Long ppDeptenquiryid) {
		this.ppDeptenquiryid = ppDeptenquiryid;
	}

	public String getEnquirysubject() {
		return enquirysubject;
	}

	public void setEnquirysubject(String enquirysubject) {
		this.enquirysubject = enquirysubject;
	}

	public Date getSubmissiondate() {
		return submissiondate;
	}

	public void setSubmissiondate(Date submissiondate) {
		this.submissiondate = submissiondate;
	}

	public String getEnquiryofficername() {
		return enquiryofficername;
	}

	public void setEnquiryofficername(String enquiryofficername) {
		this.enquiryofficername = enquiryofficername;
	}

	public String getEnquiryofficerdesignation() {
		return enquiryofficerdesignation;
	}

	public void setEnquiryofficerdesignation(String enquiryofficerdesignation) {
		this.enquiryofficerdesignation = enquiryofficerdesignation;
	}

	public String getPunishment() {
		return punishment;
	}

	public void setPunishment(String punishment) {
		this.punishment = punishment;
	}

	public Character getIspunishable() {
		return ispunishable;
	}

	public void setIspunishable(Character ispunishable) {
		this.ispunishable = ispunishable;
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
		hash += (ppDeptenquiryid != null ? ppDeptenquiryid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpDeptenquiry)) {
			return false;
		}
		PpDeptenquiry other = (PpDeptenquiry) object;
		if ((this.ppDeptenquiryid == null && other.ppDeptenquiryid != null)
				|| (this.ppDeptenquiryid != null && !this.ppDeptenquiryid.equals(other.ppDeptenquiryid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpDeptenquiry[ ppDeptenquiryid=" + ppDeptenquiryid + " ]";
	}

}
