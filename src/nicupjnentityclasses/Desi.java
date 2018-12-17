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
@Table(name = "DESI")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Desi.findAll", query = "SELECT d FROM Desi d"),
		@NamedQuery(name = "Desi.findByDesigantion", query = "SELECT d FROM Desi d WHERE d.desigantion = :desigantion"),
		@NamedQuery(name = "Desi.findByNewDesignation", query = "SELECT d FROM Desi d WHERE d.newDesignation = :newDesignation"),
		@NamedQuery(name = "Desi.findByPpDesignationid", query = "SELECT d FROM Desi d WHERE d.ppDesignationid = :ppDesignationid") })
public class Desi implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "DESIGANTION")
	private String desigantion;
	@Column(name = "NEW_DESIGNATION")
	private String newDesignation;
	@Column(name = "PP_DESIGNATIONID")
	private Integer ppDesignationid;

	public Desi() {
	}

	public Desi(String desigantion) {
		this.desigantion = desigantion;
	}

	public String getDesigantion() {
		return desigantion;
	}

	public void setDesigantion(String desigantion) {
		this.desigantion = desigantion;
	}

	public String getNewDesignation() {
		return newDesignation;
	}

	public void setNewDesignation(String newDesignation) {
		this.newDesignation = newDesignation;
	}

	public Integer getPpDesignationid() {
		return ppDesignationid;
	}

	public void setPpDesignationid(Integer ppDesignationid) {
		this.ppDesignationid = ppDesignationid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (desigantion != null ? desigantion.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Desi)) {
			return false;
		}
		Desi other = (Desi) object;
		if ((this.desigantion == null && other.desigantion != null)
				|| (this.desigantion != null && !this.desigantion.equals(other.desigantion))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.Desi[ desigantion=" + desigantion + " ]";
	}

}
