/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MAS_EMPLOYMENTSUBTYPE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "MasEmploymentsubtype.findAll", query = "SELECT m FROM MasEmploymentsubtype m"),
		@NamedQuery(name = "MasEmploymentsubtype.findByMasEmploymentsubtypeid", query = "SELECT m FROM MasEmploymentsubtype m WHERE m.masEmploymentsubtypeid = :masEmploymentsubtypeid"),
		@NamedQuery(name = "MasEmploymentsubtype.findByEmploymentsubtype", query = "SELECT m FROM MasEmploymentsubtype m WHERE m.employmentsubtype = :employmentsubtype") })
public class MasEmploymentsubtype implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "MAS_EMPLOYMENTSUBTYPEID")
	private Integer masEmploymentsubtypeid;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTSUBTYPE")
	private String employmentsubtype;
	@OneToMany(mappedBy = "masEmploymentsubtypeid")
	private Collection<PpEmployeemaster> ppEmployeemasterCollection;
	@JoinColumn(name = "MAS_EMPLOYMENTTYPEID", referencedColumnName = "MAS_EMPLOYMENTTYPEID")
	@ManyToOne(optional = false)
	private MasEmploymenttype masEmploymenttypeid;

	public MasEmploymentsubtype() {
	}

	public MasEmploymentsubtype(Integer masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public MasEmploymentsubtype(Integer masEmploymentsubtypeid, String employmentsubtype) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
		this.employmentsubtype = employmentsubtype;
	}

	public Integer getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(Integer masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public String getEmploymentsubtype() {
		return employmentsubtype;
	}

	public void setEmploymentsubtype(String employmentsubtype) {
		this.employmentsubtype = employmentsubtype;
	}

	@XmlTransient
	public Collection<PpEmployeemaster> getPpEmployeemasterCollection() {
		return ppEmployeemasterCollection;
	}

	public void setPpEmployeemasterCollection(Collection<PpEmployeemaster> ppEmployeemasterCollection) {
		this.ppEmployeemasterCollection = ppEmployeemasterCollection;
	}

	public MasEmploymenttype getMasEmploymenttypeid() {
		return masEmploymenttypeid;
	}

	public void setMasEmploymenttypeid(MasEmploymenttype masEmploymenttypeid) {
		this.masEmploymenttypeid = masEmploymenttypeid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (masEmploymentsubtypeid != null ? masEmploymentsubtypeid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof MasEmploymentsubtype)) {
			return false;
		}
		MasEmploymentsubtype other = (MasEmploymentsubtype) object;
		if ((this.masEmploymentsubtypeid == null && other.masEmploymentsubtypeid != null)
				|| (this.masEmploymentsubtypeid != null
						&& !this.masEmploymentsubtypeid.equals(other.masEmploymentsubtypeid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.MasEmploymentsubtype[ masEmploymentsubtypeid=" + masEmploymentsubtypeid + " ]";
	}

}
