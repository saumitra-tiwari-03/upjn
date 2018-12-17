/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PP_EMPLOYEEQUALIFICATION")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "PpEmployeequalification.findAll", query = "SELECT p FROM PpEmployeequalification p"),
		@NamedQuery(name = "PpEmployeequalification.findByPpEmployeequalificationid", query = "SELECT p FROM PpEmployeequalification p WHERE p.ppEmployeequalificationid = :ppEmployeequalificationid"),
		@NamedQuery(name = "PpEmployeequalification.findByIsatjoining", query = "SELECT p FROM PpEmployeequalification p WHERE p.isatjoining = :isatjoining"),
		@NamedQuery(name = "PpEmployeequalification.findByPpQualificationmasterid", query = "SELECT p FROM PpEmployeequalification p WHERE p.ppQualificationmasterid = :ppQualificationmasterid"),
		@NamedQuery(name = "PpEmployeequalification.findByQualificationdetails", query = "SELECT p FROM PpEmployeequalification p WHERE p.qualificationdetails = :qualificationdetails"),
		@NamedQuery(name = "PpEmployeequalification.findByPermissionno", query = "SELECT p FROM PpEmployeequalification p WHERE p.permissionno = :permissionno"),
		@NamedQuery(name = "PpEmployeequalification.findByPermissiondate", query = "SELECT p FROM PpEmployeequalification p WHERE p.permissiondate = :permissiondate") })
public class PpEmployeequalification implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEQUALIFICATIONID")
	private Long ppEmployeequalificationid;
	@Basic(optional = false)
	@Column(name = "ISATJOINING")
	private Character isatjoining;
	@Basic(optional = false)
	@Column(name = "PP_QUALIFICATIONMASTERID")
	private int ppQualificationmasterid;
	@Column(name = "QUALIFICATIONDETAILS")
	private String qualificationdetails;
	@Column(name = "PERMISSIONNO")
	private String permissionno;
	@Column(name = "PERMISSIONDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date permissiondate;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;

	public PpEmployeequalification() {
	}

	public PpEmployeequalification(Long ppEmployeequalificationid) {
		this.ppEmployeequalificationid = ppEmployeequalificationid;
	}

	public PpEmployeequalification(Long ppEmployeequalificationid, Character isatjoining, int ppQualificationmasterid) {
		this.ppEmployeequalificationid = ppEmployeequalificationid;
		this.isatjoining = isatjoining;
		this.ppQualificationmasterid = ppQualificationmasterid;
	}

	public Long getPpEmployeequalificationid() {
		return ppEmployeequalificationid;
	}

	public void setPpEmployeequalificationid(Long ppEmployeequalificationid) {
		this.ppEmployeequalificationid = ppEmployeequalificationid;
	}

	public Character getIsatjoining() {
		return isatjoining;
	}

	public void setIsatjoining(Character isatjoining) {
		this.isatjoining = isatjoining;
	}

	public int getPpQualificationmasterid() {
		return ppQualificationmasterid;
	}

	public void setPpQualificationmasterid(int ppQualificationmasterid) {
		this.ppQualificationmasterid = ppQualificationmasterid;
	}

	public String getQualificationdetails() {
		return qualificationdetails;
	}

	public void setQualificationdetails(String qualificationdetails) {
		this.qualificationdetails = qualificationdetails;
	}

	public String getPermissionno() {
		return permissionno;
	}

	public void setPermissionno(String permissionno) {
		this.permissionno = permissionno;
	}

	public Date getPermissiondate() {
		return permissiondate;
	}

	public void setPermissiondate(Date permissiondate) {
		this.permissiondate = permissiondate;
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
		hash += (ppEmployeequalificationid != null ? ppEmployeequalificationid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpEmployeequalification)) {
			return false;
		}
		PpEmployeequalification other = (PpEmployeequalification) object;
		if ((this.ppEmployeequalificationid == null && other.ppEmployeequalificationid != null)
				|| (this.ppEmployeequalificationid != null
						&& !this.ppEmployeequalificationid.equals(other.ppEmployeequalificationid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpEmployeequalification[ ppEmployeequalificationid=" + ppEmployeequalificationid
				+ " ]";
	}

}
