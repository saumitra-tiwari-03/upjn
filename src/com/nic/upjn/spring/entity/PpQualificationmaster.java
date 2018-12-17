/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_QUALIFICATIONMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpQualificationmaster.findAll", query = "FROM PpQualificationmaster order by qualification"),
		@NamedQuery(name = "PpQualificationmaster.findByPpQualificationmasterid", query = "FROM PpQualificationmaster WHERE ppQualificationmasterid = ?"),
		@NamedQuery(name = "PpQualificationmaster.findByQualification", query = "SELECT p FROM PpQualificationmaster p WHERE p.qualification = :qualification") })
public class PpQualificationmaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_PP_QUALIFICATIONMASTER", allocationSize = 1)
	@Id
	@Basic(optional = false)
	@Column(name = "PP_QUALIFICATIONMASTERID")
	private Integer ppQualificationmasterid;
	@Basic(optional = false)
	@Column(name = "QUALIFICATION")
	private String qualification;

	public PpQualificationmaster() {
	}

	public PpQualificationmaster(Integer ppQualificationmasterid) {
		this.ppQualificationmasterid = ppQualificationmasterid;
	}

	public PpQualificationmaster(Integer ppQualificationmasterid, String qualification) {
		this.ppQualificationmasterid = ppQualificationmasterid;
		this.qualification = qualification;
	}

	public Integer getPpQualificationmasterid() {
		return ppQualificationmasterid;
	}

	public void setPpQualificationmasterid(Integer ppQualificationmasterid) {
		this.ppQualificationmasterid = ppQualificationmasterid;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppQualificationmasterid != null ? ppQualificationmasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpQualificationmaster)) {
			return false;
		}
		PpQualificationmaster other = (PpQualificationmaster) object;
		if ((this.ppQualificationmasterid == null && other.ppQualificationmasterid != null)
				|| (this.ppQualificationmasterid != null
						&& !this.ppQualificationmasterid.equals(other.ppQualificationmasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpQualificationmaster[ ppQualificationmasterid=" + ppQualificationmasterid + " ]";
	}

}
