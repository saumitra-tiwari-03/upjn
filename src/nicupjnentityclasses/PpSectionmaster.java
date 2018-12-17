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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_SECTIONMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpSectionmaster.findAll", query = "SELECT p FROM PpSectionmaster p"),
		@NamedQuery(name = "PpSectionmaster.findByPpSectionmasterid", query = "SELECT p FROM PpSectionmaster p WHERE p.ppSectionmasterid = :ppSectionmasterid"),
		@NamedQuery(name = "PpSectionmaster.findBySectionname", query = "SELECT p FROM PpSectionmaster p WHERE p.sectionname = :sectionname") })
public class PpSectionmaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_SECTIONMASTERID")
	private Integer ppSectionmasterid;
	@Basic(optional = false)
	@Column(name = "SECTIONNAME")
	private String sectionname;
	@JoinColumn(name = "RM_OFFICEID", referencedColumnName = "RM_OFFICEID")
	@ManyToOne(optional = false)
	private RmOffice rmOfficeid;

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

	public RmOffice getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(RmOffice rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
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
		return "nicupjnentityclasses.PpSectionmaster[ ppSectionmasterid=" + ppSectionmasterid + " ]";
	}

}
