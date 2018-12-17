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
@Table(name = "PP_EXITDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpExitdetail.findAll", query = "SELECT p FROM PpExitdetail p"),
		@NamedQuery(name = "PpExitdetail.findByPpExitdetailid", query = "SELECT p FROM PpExitdetail p WHERE p.ppExitdetailid = :ppExitdetailid"),
		@NamedQuery(name = "PpExitdetail.findByDetailid", query = "SELECT p FROM PpExitdetail p WHERE p.detailid = :detailid") })
public class PpExitdetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EXITDETAILID")
	private Long ppExitdetailid;
	@Basic(optional = false)
	@Column(name = "DETAILID")
	private long detailid;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;
	@JoinColumn(name = "SYS_SUBSERVICEPHASEMASTERID", referencedColumnName = "SYS_SUBSERVICEPHASEMASTERID")
	@ManyToOne(optional = false)
	private SysSubservicephasemaster sysSubservicephasemasterid;
	@OneToMany(mappedBy = "ppExitdetailid")
	private Collection<PpCurrentstatus> ppCurrentstatusCollection;

	public PpExitdetail() {
	}

	public PpExitdetail(Long ppExitdetailid) {
		this.ppExitdetailid = ppExitdetailid;
	}

	public PpExitdetail(Long ppExitdetailid, long detailid) {
		this.ppExitdetailid = ppExitdetailid;
		this.detailid = detailid;
	}

	public Long getPpExitdetailid() {
		return ppExitdetailid;
	}

	public void setPpExitdetailid(Long ppExitdetailid) {
		this.ppExitdetailid = ppExitdetailid;
	}

	public long getDetailid() {
		return detailid;
	}

	public void setDetailid(long detailid) {
		this.detailid = detailid;
	}

	public PpEmployeemaster getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(PpEmployeemaster ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public SysSubservicephasemaster getSysSubservicephasemasterid() {
		return sysSubservicephasemasterid;
	}

	public void setSysSubservicephasemasterid(SysSubservicephasemaster sysSubservicephasemasterid) {
		this.sysSubservicephasemasterid = sysSubservicephasemasterid;
	}

	@XmlTransient
	public Collection<PpCurrentstatus> getPpCurrentstatusCollection() {
		return ppCurrentstatusCollection;
	}

	public void setPpCurrentstatusCollection(Collection<PpCurrentstatus> ppCurrentstatusCollection) {
		this.ppCurrentstatusCollection = ppCurrentstatusCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppExitdetailid != null ? ppExitdetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpExitdetail)) {
			return false;
		}
		PpExitdetail other = (PpExitdetail) object;
		if ((this.ppExitdetailid == null && other.ppExitdetailid != null)
				|| (this.ppExitdetailid != null && !this.ppExitdetailid.equals(other.ppExitdetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpExitdetail[ ppExitdetailid=" + ppExitdetailid + " ]";
	}

}
