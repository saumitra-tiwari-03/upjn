/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PP_SECTIONMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpSectionmaster.findAll", query = "SELECT p FROM PpSectionmaster p"),
		@NamedQuery(name = "PpSectionmaster.findByPpSectionmasterid", query = "SELECT p FROM PpSectionmaster p WHERE p.ppSectionmasterid = :ppSectionmasterid"),
		@NamedQuery(name = "PpSectionmaster.findBySectionname", query = "SELECT p FROM PpSectionmaster p WHERE p.sectionname = :sectionname") })
public class PpSectionmaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_PP_SECTIONMASTER", allocationSize = 1)
	@Id
	@Basic(optional = false)
	@Column(name = "PP_SECTIONMASTERID")
	private Integer ppSectionmasterid;
	@Basic(optional = false)
	@Column(name = "SECTIONNAME")
	private String sectionname;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private String rmOfficeid;
	@OneToMany
	private Collection<PpEmployeemaster> ppEmployeemaster;

	public PpSectionmaster() {
	}

	public PpSectionmaster(Integer ppSectionmasterid) {
		this.ppSectionmasterid = ppSectionmasterid;
	}

	public PpSectionmaster(Integer ppSectionmasterid, String sectionname) {
		this.ppSectionmasterid = ppSectionmasterid;
		this.sectionname = sectionname;
	}

	public Integer getPpSectionmasterid() {
		return ppSectionmasterid;
	}

	public void setPpSectionmasterid(Integer ppSectionmasterid) {
		this.ppSectionmasterid = ppSectionmasterid;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

	public String getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(String rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}
	
	public Collection<PpEmployeemaster> getPpEmployeemaster() {
		return ppEmployeemaster;
	}

	public void setPpEmployeemaster(Collection<PpEmployeemaster> ppEmployeemaster) {
		this.ppEmployeemaster = ppEmployeemaster;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppSectionmasterid != null ? ppSectionmasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpSectionmaster)) {
			return false;
		}
		PpSectionmaster other = (PpSectionmaster) object;
		if ((this.ppSectionmasterid == null && other.ppSectionmasterid != null)
				|| (this.ppSectionmasterid != null && !this.ppSectionmasterid.equals(other.ppSectionmasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.nic.upjn.spring.entity.PpSectionmaster[ ppSectionmasterid=" + ppSectionmasterid + " ]";
	}

}
