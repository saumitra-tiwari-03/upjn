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
@Table(name = "VIEW_PP_NOMINATIONTYPE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpNominationtype.findAll", query = "SELECT v FROM ViewPpNominationtype v"),
		@NamedQuery(name = "ViewPpNominationtype.findByNominationtype", query = "SELECT v FROM ViewPpNominationtype v WHERE v.nominationtype = :nominationtype"),
		@NamedQuery(name = "ViewPpNominationtype.findByPpRetirementbenefitsid", query = "SELECT v FROM ViewPpNominationtype v WHERE v.ppRetirementbenefitsid = :ppRetirementbenefitsid") })
public class ViewPpNominationtype implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "NOMINATIONTYPE")
	private String nominationtype;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_RETIREMENTBENEFITSID")
	private Short ppRetirementbenefitsid;

	public ViewPpNominationtype() {
	}

	public ViewPpNominationtype(Short ppRetirementbenefitsid) {
		this.ppRetirementbenefitsid = ppRetirementbenefitsid;
	}

	public ViewPpNominationtype(Short ppRetirementbenefitsid, String nominationtype) {
		this.ppRetirementbenefitsid = ppRetirementbenefitsid;
		this.nominationtype = nominationtype;
	}

	public String getNominationtype() {
		return nominationtype;
	}

	public void setNominationtype(String nominationtype) {
		this.nominationtype = nominationtype;
	}

	public Short getPpRetirementbenefitsid() {
		return ppRetirementbenefitsid;
	}

	public void setPpRetirementbenefitsid(Short ppRetirementbenefitsid) {
		this.ppRetirementbenefitsid = ppRetirementbenefitsid;
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
		if (!(object instanceof ViewPpNominationtype)) {
			return false;
		}
		ViewPpNominationtype other = (ViewPpNominationtype) object;
		if ((this.ppRetirementbenefitsid == null && other.ppRetirementbenefitsid != null)
				|| (this.ppRetirementbenefitsid != null
						&& !this.ppRetirementbenefitsid.equals(other.ppRetirementbenefitsid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.ViewPpNominationtype[ ppRetirementbenefitsid=" + ppRetirementbenefitsid + " ]";
	}

}
