/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_CHECKLIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpChecklist.findAll", query = "SELECT p FROM PpChecklist p"),
		@NamedQuery(name = "PpChecklist.findByPpChecklistid", query = "SELECT p FROM PpChecklist p WHERE p.ppChecklistid = :ppChecklistid"),
		@NamedQuery(name = "PpChecklist.findByPpEmployeemasterid", query = "SELECT p FROM PpChecklist p WHERE p.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "PpChecklist.findByNewvalue", query = "SELECT p FROM PpChecklist p WHERE p.newvalue = :newvalue"),
		@NamedQuery(name = "PpChecklist.findByOldvalue", query = "SELECT p FROM PpChecklist p WHERE p.oldvalue = :oldvalue"),
		@NamedQuery(name = "PpChecklist.findByDescription", query = "SELECT p FROM PpChecklist p WHERE p.description = :description"),
		@NamedQuery(name = "PpChecklist.findByCurrentdate", query = "SELECT p FROM PpChecklist p WHERE p.currentdate = :currentdate") })
public class PpChecklist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_CHECKLISTID")
	private String ppChecklistid;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private BigInteger ppEmployeemasterid;
	@Column(name = "NEWVALUE")
	private String newvalue;
	@Column(name = "OLDVALUE")
	private String oldvalue;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "CURRENTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date currentdate;

	public PpChecklist() {
	}

	public PpChecklist(String ppChecklistid) {
		this.ppChecklistid = ppChecklistid;
	}

	public String getPpChecklistid() {
		return ppChecklistid;
	}

	public void setPpChecklistid(String ppChecklistid) {
		this.ppChecklistid = ppChecklistid;
	}

	public BigInteger getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(BigInteger ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public String getNewvalue() {
		return newvalue;
	}

	public void setNewvalue(String newvalue) {
		this.newvalue = newvalue;
	}

	public String getOldvalue() {
		return oldvalue;
	}

	public void setOldvalue(String oldvalue) {
		this.oldvalue = oldvalue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(Date currentdate) {
		this.currentdate = currentdate;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppChecklistid != null ? ppChecklistid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpChecklist)) {
			return false;
		}
		PpChecklist other = (PpChecklist) object;
		if ((this.ppChecklistid == null && other.ppChecklistid != null)
				|| (this.ppChecklistid != null && !this.ppChecklistid.equals(other.ppChecklistid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpChecklist[ ppChecklistid=" + ppChecklistid + " ]";
	}

}
