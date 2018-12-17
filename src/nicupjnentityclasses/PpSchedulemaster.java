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
@Table(name = "PP_SCHEDULEMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpSchedulemaster.findAll", query = "SELECT p FROM PpSchedulemaster p"),
		@NamedQuery(name = "PpSchedulemaster.findByPpSchedulemasterid", query = "SELECT p FROM PpSchedulemaster p WHERE p.ppSchedulemasterid = :ppSchedulemasterid"),
		@NamedQuery(name = "PpSchedulemaster.findBySchedulename", query = "SELECT p FROM PpSchedulemaster p WHERE p.schedulename = :schedulename") })
public class PpSchedulemaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_SCHEDULEMASTERID")
	private Integer ppSchedulemasterid;
	@Basic(optional = false)
	@Column(name = "SCHEDULENAME")
	private String schedulename;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppSchedulemasterid")
	private Collection<PpDeductionmaster> ppDeductionmasterCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppSchedulemasterid")
	private Collection<PpLoanmaster> ppLoanmasterCollection;

	public PpSchedulemaster() {
	}

	public PpSchedulemaster(Integer ppSchedulemasterid) {
		this.ppSchedulemasterid = ppSchedulemasterid;
	}

	public PpSchedulemaster(Integer ppSchedulemasterid, String schedulename) {
		this.ppSchedulemasterid = ppSchedulemasterid;
		this.schedulename = schedulename;
	}

	public Integer getPpSchedulemasterid() {
		return ppSchedulemasterid;
	}

	public void setPpSchedulemasterid(Integer ppSchedulemasterid) {
		this.ppSchedulemasterid = ppSchedulemasterid;
	}

	public String getSchedulename() {
		return schedulename;
	}

	public void setSchedulename(String schedulename) {
		this.schedulename = schedulename;
	}

	@XmlTransient
	public Collection<PpDeductionmaster> getPpDeductionmasterCollection() {
		return ppDeductionmasterCollection;
	}

	public void setPpDeductionmasterCollection(Collection<PpDeductionmaster> ppDeductionmasterCollection) {
		this.ppDeductionmasterCollection = ppDeductionmasterCollection;
	}

	@XmlTransient
	public Collection<PpLoanmaster> getPpLoanmasterCollection() {
		return ppLoanmasterCollection;
	}

	public void setPpLoanmasterCollection(Collection<PpLoanmaster> ppLoanmasterCollection) {
		this.ppLoanmasterCollection = ppLoanmasterCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppSchedulemasterid != null ? ppSchedulemasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpSchedulemaster)) {
			return false;
		}
		PpSchedulemaster other = (PpSchedulemaster) object;
		if ((this.ppSchedulemasterid == null && other.ppSchedulemasterid != null)
				|| (this.ppSchedulemasterid != null && !this.ppSchedulemasterid.equals(other.ppSchedulemasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpSchedulemaster[ ppSchedulemasterid=" + ppSchedulemasterid + " ]";
	}

}
