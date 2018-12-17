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
@Table(name = "PP_INCREMENTDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpIncrementdetail.findAll", query = "SELECT p FROM PpIncrementdetail p"),
		@NamedQuery(name = "PpIncrementdetail.findByPpIncrementdetailid", query = "SELECT p FROM PpIncrementdetail p WHERE p.ppIncrementdetailid = :ppIncrementdetailid"),
		@NamedQuery(name = "PpIncrementdetail.findByIncrementamount", query = "SELECT p FROM PpIncrementdetail p WHERE p.incrementamount = :incrementamount") })
public class PpIncrementdetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_INCREMENTDETAILID")
	private Long ppIncrementdetailid;
	@Basic(optional = false)
	@Column(name = "INCREMENTAMOUNT")
	private int incrementamount;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;

	public PpIncrementdetail() {
	}

	public PpIncrementdetail(Long ppIncrementdetailid) {
		this.ppIncrementdetailid = ppIncrementdetailid;
	}

	public PpIncrementdetail(Long ppIncrementdetailid, int incrementamount) {
		this.ppIncrementdetailid = ppIncrementdetailid;
		this.incrementamount = incrementamount;
	}

	public Long getPpIncrementdetailid() {
		return ppIncrementdetailid;
	}

	public void setPpIncrementdetailid(Long ppIncrementdetailid) {
		this.ppIncrementdetailid = ppIncrementdetailid;
	}

	public int getIncrementamount() {
		return incrementamount;
	}

	public void setIncrementamount(int incrementamount) {
		this.incrementamount = incrementamount;
	}

	public PpEmployeemaster getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(PpEmployeemaster ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppIncrementdetailid != null ? ppIncrementdetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpIncrementdetail)) {
			return false;
		}
		PpIncrementdetail other = (PpIncrementdetail) object;
		if ((this.ppIncrementdetailid == null && other.ppIncrementdetailid != null)
				|| (this.ppIncrementdetailid != null && !this.ppIncrementdetailid.equals(other.ppIncrementdetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpIncrementdetail[ ppIncrementdetailid=" + ppIncrementdetailid + " ]";
	}

}
