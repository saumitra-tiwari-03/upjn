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
@Table(name = "PP_TRAININGTYPEMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpTrainingtypemaster.findAll", query = "SELECT p FROM PpTrainingtypemaster p"),
		@NamedQuery(name = "PpTrainingtypemaster.findByPpTrainingtypemasterid", query = "SELECT p FROM PpTrainingtypemaster p WHERE p.ppTrainingtypemasterid = :ppTrainingtypemasterid"),
		@NamedQuery(name = "PpTrainingtypemaster.findByTrainingtype", query = "SELECT p FROM PpTrainingtypemaster p WHERE p.trainingtype = :trainingtype") })
public class PpTrainingtypemaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_TRAININGTYPEMASTERID")
	private Integer ppTrainingtypemasterid;
	@Basic(optional = false)
	@Column(name = "TRAININGTYPE")
	private String trainingtype;

	public PpTrainingtypemaster() {
	}

	public PpTrainingtypemaster(Integer ppTrainingtypemasterid) {
		this.ppTrainingtypemasterid = ppTrainingtypemasterid;
	}

	public PpTrainingtypemaster(Integer ppTrainingtypemasterid, String trainingtype) {
		this.ppTrainingtypemasterid = ppTrainingtypemasterid;
		this.trainingtype = trainingtype;
	}

	public Integer getPpTrainingtypemasterid() {
		return ppTrainingtypemasterid;
	}

	public void setPpTrainingtypemasterid(Integer ppTrainingtypemasterid) {
		this.ppTrainingtypemasterid = ppTrainingtypemasterid;
	}

	public String getTrainingtype() {
		return trainingtype;
	}

	public void setTrainingtype(String trainingtype) {
		this.trainingtype = trainingtype;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppTrainingtypemasterid != null ? ppTrainingtypemasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpTrainingtypemaster)) {
			return false;
		}
		PpTrainingtypemaster other = (PpTrainingtypemaster) object;
		if ((this.ppTrainingtypemasterid == null && other.ppTrainingtypemasterid != null)
				|| (this.ppTrainingtypemasterid != null
						&& !this.ppTrainingtypemasterid.equals(other.ppTrainingtypemasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpTrainingtypemaster[ ppTrainingtypemasterid=" + ppTrainingtypemasterid + " ]";
	}

}
