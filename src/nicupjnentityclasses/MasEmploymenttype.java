/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "MAS_EMPLOYMENTTYPE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "MasEmploymenttype.findAll", query = "SELECT m FROM MasEmploymenttype m"),
		@NamedQuery(name = "MasEmploymenttype.findByEmploymenttype", query = "SELECT m FROM MasEmploymenttype m WHERE m.employmenttype = :employmenttype"),
		@NamedQuery(name = "MasEmploymenttype.findByMonthlypaytable", query = "SELECT m FROM MasEmploymenttype m WHERE m.monthlypaytable = :monthlypaytable"),
		@NamedQuery(name = "MasEmploymenttype.findByMasEmploymenttypeid", query = "SELECT m FROM MasEmploymenttype m WHERE m.masEmploymenttypeid = :masEmploymenttypeid") })
public class MasEmploymenttype implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;
	@Basic(optional = false)
	@Column(name = "MONTHLYPAYTABLE")
	private String monthlypaytable;
	@Id
	@Basic(optional = false)
	@Column(name = "MAS_EMPLOYMENTTYPEID")
	private Integer masEmploymenttypeid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "masEmploymenttypeid")
	private Collection<MasEmploymentsubtype> masEmploymentsubtypeCollection;

	public MasEmploymenttype() {
	}

	public MasEmploymenttype(Integer masEmploymenttypeid) {
		this.masEmploymenttypeid = masEmploymenttypeid;
	}

	public MasEmploymenttype(Integer masEmploymenttypeid, String employmenttype, String monthlypaytable) {
		this.masEmploymenttypeid = masEmploymenttypeid;
		this.employmenttype = employmenttype;
		this.monthlypaytable = monthlypaytable;
	}

	public String getEmploymenttype() {
		return employmenttype;
	}

	public void setEmploymenttype(String employmenttype) {
		this.employmenttype = employmenttype;
	}

	public String getMonthlypaytable() {
		return monthlypaytable;
	}

	public void setMonthlypaytable(String monthlypaytable) {
		this.monthlypaytable = monthlypaytable;
	}

	public Integer getMasEmploymenttypeid() {
		return masEmploymenttypeid;
	}

	public void setMasEmploymenttypeid(Integer masEmploymenttypeid) {
		this.masEmploymenttypeid = masEmploymenttypeid;
	}

	@XmlTransient
	public Collection<MasEmploymentsubtype> getMasEmploymentsubtypeCollection() {
		return masEmploymentsubtypeCollection;
	}

	public void setMasEmploymentsubtypeCollection(Collection<MasEmploymentsubtype> masEmploymentsubtypeCollection) {
		this.masEmploymentsubtypeCollection = masEmploymentsubtypeCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (masEmploymenttypeid != null ? masEmploymenttypeid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof MasEmploymenttype)) {
			return false;
		}
		MasEmploymenttype other = (MasEmploymenttype) object;
		if ((this.masEmploymenttypeid == null && other.masEmploymenttypeid != null)
				|| (this.masEmploymenttypeid != null && !this.masEmploymenttypeid.equals(other.masEmploymenttypeid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.MasEmploymenttype[ masEmploymenttypeid=" + masEmploymenttypeid + " ]";
	}

}
