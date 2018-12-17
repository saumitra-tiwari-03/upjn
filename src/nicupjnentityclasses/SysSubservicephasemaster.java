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
@Table(name = "SYS_SUBSERVICEPHASEMASTER")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "SysSubservicephasemaster.findAll", query = "SELECT s FROM SysSubservicephasemaster s"),
		@NamedQuery(name = "SysSubservicephasemaster.findBySysSubservicephasemasterid", query = "SELECT s FROM SysSubservicephasemaster s WHERE s.sysSubservicephasemasterid = :sysSubservicephasemasterid"),
		@NamedQuery(name = "SysSubservicephasemaster.findBySubphasename", query = "SELECT s FROM SysSubservicephasemaster s WHERE s.subphasename = :subphasename"),
		@NamedQuery(name = "SysSubservicephasemaster.findByServicephasename", query = "SELECT s FROM SysSubservicephasemaster s WHERE s.servicephasename = :servicephasename") })
public class SysSubservicephasemaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SYS_SUBSERVICEPHASEMASTERID")
	private Short sysSubservicephasemasterid;
	@Basic(optional = false)
	@Column(name = "SUBPHASENAME")
	private String subphasename;
	@Basic(optional = false)
	@Column(name = "SERVICEPHASENAME")
	private String servicephasename;
	@OneToMany(mappedBy = "sysSubservicephasemasterid")
	private Collection<PpEmployeeappointmentdetail> ppEmployeeappointmentdetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "causeofrelieveid")
	private Collection<PpRelievefromservice> ppRelievefromserviceCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sysSubservicephasemasterid")
	private Collection<PpExitdetail> ppExitdetailCollection;

	public SysSubservicephasemaster() {
	}

	public SysSubservicephasemaster(Short sysSubservicephasemasterid) {
		this.sysSubservicephasemasterid = sysSubservicephasemasterid;
	}

	public SysSubservicephasemaster(Short sysSubservicephasemasterid, String subphasename, String servicephasename) {
		this.sysSubservicephasemasterid = sysSubservicephasemasterid;
		this.subphasename = subphasename;
		this.servicephasename = servicephasename;
	}

	public Short getSysSubservicephasemasterid() {
		return sysSubservicephasemasterid;
	}

	public void setSysSubservicephasemasterid(Short sysSubservicephasemasterid) {
		this.sysSubservicephasemasterid = sysSubservicephasemasterid;
	}

	public String getSubphasename() {
		return subphasename;
	}

	public void setSubphasename(String subphasename) {
		this.subphasename = subphasename;
	}

	public String getServicephasename() {
		return servicephasename;
	}

	public void setServicephasename(String servicephasename) {
		this.servicephasename = servicephasename;
	}

	@XmlTransient
	public Collection<PpEmployeeappointmentdetail> getPpEmployeeappointmentdetailCollection() {
		return ppEmployeeappointmentdetailCollection;
	}

	public void setPpEmployeeappointmentdetailCollection(
			Collection<PpEmployeeappointmentdetail> ppEmployeeappointmentdetailCollection) {
		this.ppEmployeeappointmentdetailCollection = ppEmployeeappointmentdetailCollection;
	}

	@XmlTransient
	public Collection<PpRelievefromservice> getPpRelievefromserviceCollection() {
		return ppRelievefromserviceCollection;
	}

	public void setPpRelievefromserviceCollection(Collection<PpRelievefromservice> ppRelievefromserviceCollection) {
		this.ppRelievefromserviceCollection = ppRelievefromserviceCollection;
	}

	@XmlTransient
	public Collection<PpExitdetail> getPpExitdetailCollection() {
		return ppExitdetailCollection;
	}

	public void setPpExitdetailCollection(Collection<PpExitdetail> ppExitdetailCollection) {
		this.ppExitdetailCollection = ppExitdetailCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (sysSubservicephasemasterid != null ? sysSubservicephasemasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SysSubservicephasemaster)) {
			return false;
		}
		SysSubservicephasemaster other = (SysSubservicephasemaster) object;
		if ((this.sysSubservicephasemasterid == null && other.sysSubservicephasemasterid != null)
				|| (this.sysSubservicephasemasterid != null
						&& !this.sysSubservicephasemasterid.equals(other.sysSubservicephasemasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SysSubservicephasemaster[ sysSubservicephasemasterid=" + sysSubservicephasemasterid
				+ " ]";
	}

}
