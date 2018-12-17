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
@Table(name = "PP_RETIREMENTBENEFITS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpRetirementbenefits.findAll", query = "SELECT p FROM PpRetirementbenefits p"),
		@NamedQuery(name = "PpRetirementbenefits.findByPpRetirementbenefitsid", query = "SELECT p FROM PpRetirementbenefits p WHERE p.ppRetirementbenefitsid = :ppRetirementbenefitsid"),
		@NamedQuery(name = "PpRetirementbenefits.findByBenifitname", query = "SELECT p FROM PpRetirementbenefits p WHERE p.benifitname = :benifitname"),
		@NamedQuery(name = "PpRetirementbenefits.findByNominationapplicable", query = "SELECT p FROM PpRetirementbenefits p WHERE p.nominationapplicable = :nominationapplicable"),
		@NamedQuery(name = "PpRetirementbenefits.findByNominDateField", query = "SELECT p FROM PpRetirementbenefits p WHERE p.nominDateField = :nominDateField") })
public class PpRetirementbenefits implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_RETIREMENTBENEFITSID")
	private Short ppRetirementbenefitsid;
	@Basic(optional = false)
	@Column(name = "BENIFITNAME")
	private String benifitname;
	@Basic(optional = false)
	@Column(name = "NOMINATIONAPPLICABLE")
	private Character nominationapplicable;
	@Column(name = "NOMIN_DATE_FIELD")
	private String nominDateField;

	public PpRetirementbenefits() {
	}

	public PpRetirementbenefits(Short ppRetirementbenefitsid) {
		this.ppRetirementbenefitsid = ppRetirementbenefitsid;
	}

	public PpRetirementbenefits(Short ppRetirementbenefitsid, String benifitname, Character nominationapplicable) {
		this.ppRetirementbenefitsid = ppRetirementbenefitsid;
		this.benifitname = benifitname;
		this.nominationapplicable = nominationapplicable;
	}

	public Short getPpRetirementbenefitsid() {
		return ppRetirementbenefitsid;
	}

	public void setPpRetirementbenefitsid(Short ppRetirementbenefitsid) {
		this.ppRetirementbenefitsid = ppRetirementbenefitsid;
	}

	public String getBenifitname() {
		return benifitname;
	}

	public void setBenifitname(String benifitname) {
		this.benifitname = benifitname;
	}

	public Character getNominationapplicable() {
		return nominationapplicable;
	}

	public void setNominationapplicable(Character nominationapplicable) {
		this.nominationapplicable = nominationapplicable;
	}

	public String getNominDateField() {
		return nominDateField;
	}

	public void setNominDateField(String nominDateField) {
		this.nominDateField = nominDateField;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppRetirementbenefitsid != null ? ppRetirementbenefitsid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpRetirementbenefits)) {
			return false;
		}
		PpRetirementbenefits other = (PpRetirementbenefits) object;
		if ((this.ppRetirementbenefitsid == null && other.ppRetirementbenefitsid != null)
				|| (this.ppRetirementbenefitsid != null
						&& !this.ppRetirementbenefitsid.equals(other.ppRetirementbenefitsid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpRetirementbenefits[ ppRetirementbenefitsid=" + ppRetirementbenefitsid + " ]";
	}

}
