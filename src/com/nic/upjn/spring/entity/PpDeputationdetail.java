/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "PP_DEPUTATIONDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpDeputationdetail.findAll", query = "SELECT p FROM PpDeputationdetail p"),
		@NamedQuery(name = "PpDeputationdetail.findByPpDeputationdetailid", query = "SELECT p FROM PpDeputationdetail p WHERE p.ppDeputationdetailid = :ppDeputationdetailid"),
		@NamedQuery(name = "PpDeputationdetail.findByDeputationorderno", query = "SELECT p FROM PpDeputationdetail p WHERE p.deputationorderno = :deputationorderno"),
		@NamedQuery(name = "PpDeputationdetail.findByDeputationorderdate", query = "SELECT p FROM PpDeputationdetail p WHERE p.deputationorderdate = :deputationorderdate"),
		@NamedQuery(name = "PpDeputationdetail.findByOfficefromid", query = "SELECT p FROM PpDeputationdetail p WHERE p.officefromid = :officefromid"),
		@NamedQuery(name = "PpDeputationdetail.findByTargetoffice", query = "SELECT p FROM PpDeputationdetail p WHERE p.targetoffice = :targetoffice"),
		@NamedQuery(name = "PpDeputationdetail.findByRelieveorderno", query = "SELECT p FROM PpDeputationdetail p WHERE p.relieveorderno = :relieveorderno"),
		@NamedQuery(name = "PpDeputationdetail.findByRelieveorderdate", query = "SELECT p FROM PpDeputationdetail p WHERE p.relieveorderdate = :relieveorderdate"),
		@NamedQuery(name = "PpDeputationdetail.findByRelievedate", query = "SELECT p FROM PpDeputationdetail p WHERE p.relievedate = :relievedate"),
		@NamedQuery(name = "PpDeputationdetail.findByRelieveanfn", query = "SELECT p FROM PpDeputationdetail p WHERE p.relieveanfn = :relieveanfn"),
		@NamedQuery(name = "PpDeputationdetail.findByPpLpcdetailid", query = "SELECT p FROM PpDeputationdetail p WHERE p.ppLpcdetailid = :ppLpcdetailid"),
		@NamedQuery(name = "PpDeputationdetail.findByPpNoduesdetailid", query = "SELECT p FROM PpDeputationdetail p WHERE p.ppNoduesdetailid = :ppNoduesdetailid"),
		@NamedQuery(name = "PpDeputationdetail.findByResumedate", query = "SELECT p FROM PpDeputationdetail p WHERE p.resumedate = :resumedate"),
		@NamedQuery(name = "PpDeputationdetail.findByIsresumed", query = "SELECT p FROM PpDeputationdetail p WHERE p.isresumed = :isresumed") })
public class PpDeputationdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "PP_DEPUTATIONDETAILID")
	private Long ppDeputationdetailid;
	@Column(name = "DEPUTATIONORDERNO")
	private String deputationorderno;
	@Column(name = "DEPUTATIONORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deputationorderdate;
	@Column(name = "OFFICEFROMID")
	private Integer officefromid;
	@Column(name = "TARGETOFFICE")
	private String targetoffice;
	@Column(name = "RELIEVEORDERNO")
	private String relieveorderno;
	@Column(name = "RELIEVEORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relieveorderdate;
	@Column(name = "RELIEVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relievedate;
	@Column(name = "RELIEVEANFN")
	private String relieveanfn;
	@Column(name = "PP_LPCDETAILID")
	private Long ppLpcdetailid;
	@Column(name = "PP_NODUESDETAILID")
	private Long ppNoduesdetailid;
	@Column(name = "RESUMEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date resumedate;
	@Column(name = "ISRESUMED")
	private Character isresumed;
	@Column(name = "PP_EMPLOYEEMASTERID")
	
	private Long ppEmployeemasterid;
	@Column(name = "NEXTPOSTINGID")
	private String nextpostingid;
	
	

	public PpDeputationdetail() {
	}

	public PpDeputationdetail(Long ppDeputationdetailid) {
		this.ppDeputationdetailid = ppDeputationdetailid;
	}

	public Long getPpDeputationdetailid() {
		return ppDeputationdetailid;
	}

	public void setPpDeputationdetailid(Long ppDeputationdetailid) {
		this.ppDeputationdetailid = ppDeputationdetailid;
	}

	public String getDeputationorderno() {
		return deputationorderno;
	}

	public void setDeputationorderno(String deputationorderno) {
		this.deputationorderno = deputationorderno;
	}

	public Date getDeputationorderdate() {
		return deputationorderdate;
	}

	public void setDeputationorderdate(Date deputationorderdate) {
		this.deputationorderdate = deputationorderdate;
	}

	public Integer getOfficefromid() {
		return officefromid;
	}

	public void setOfficefromid(Integer officefromid) {
		this.officefromid = officefromid;
	}

	public String getTargetoffice() {
		return targetoffice;
	}

	public void setTargetoffice(String targetoffice) {
		this.targetoffice = targetoffice;
	}

	public String getRelieveorderno() {
		return relieveorderno;
	}

	public void setRelieveorderno(String relieveorderno) {
		this.relieveorderno = relieveorderno;
	}

	public Date getRelieveorderdate() {
		return relieveorderdate;
	}

	public void setRelieveorderdate(Date relieveorderdate) {
		this.relieveorderdate = relieveorderdate;
	}

	public Date getRelievedate() {
		return relievedate;
	}

	public void setRelievedate(Date relievedate) {
		this.relievedate = relievedate;
	}

	public String getRelieveanfn() {
		return relieveanfn;
	}

	public void setRelieveanfn(String relieveanfn) {
		this.relieveanfn = relieveanfn;
	}

	public Long getPpLpcdetailid() {
		return ppLpcdetailid;
	}

	public void setPpLpcdetailid(Long ppLpcdetailid) {
		this.ppLpcdetailid = ppLpcdetailid;
	}

	public Long getPpNoduesdetailid() {
		return ppNoduesdetailid;
	}

	public void setPpNoduesdetailid(Long ppNoduesdetailid) {
		this.ppNoduesdetailid = ppNoduesdetailid;
	}

	public Date getResumedate() {
		return resumedate;
	}

	public void setResumedate(Date resumedate) {
		this.resumedate = resumedate;
	}

	public Character getIsresumed() {
		return isresumed;
	}

	public void setIsresumed(Character isresumed) {
		this.isresumed = isresumed;
	}

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public String getNextpostingid() {
		return nextpostingid;
	}

	public void setNextpostingid(String nextpostingid) {
		this.nextpostingid = nextpostingid;
	}

	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppDeputationdetailid != null ? ppDeputationdetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpDeputationdetail)) {
			return false;
		}
		PpDeputationdetail other = (PpDeputationdetail) object;
		if ((this.ppDeputationdetailid == null && other.ppDeputationdetailid != null)
				|| (this.ppDeputationdetailid != null
						&& !this.ppDeputationdetailid.equals(other.ppDeputationdetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpDeputationdetail[ ppDeputationdetailid=" + ppDeputationdetailid + " ]";
	}

}
