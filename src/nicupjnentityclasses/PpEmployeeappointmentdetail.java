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
@Table(name = "PP_EMPLOYEEAPPOINTMENTDETAIL")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "PpEmployeeappointmentdetail.findAll", query = "SELECT p FROM PpEmployeeappointmentdetail p"),
		@NamedQuery(name = "PpEmployeeappointmentdetail.findByPpEmployeeappointmentdetailid", query = "SELECT p FROM PpEmployeeappointmentdetail p WHERE p.ppEmployeeappointmentdetailid = :ppEmployeeappointmentdetailid"),
		@NamedQuery(name = "PpEmployeeappointmentdetail.findByDatejoining", query = "SELECT p FROM PpEmployeeappointmentdetail p WHERE p.datejoining = :datejoining"),
		@NamedQuery(name = "PpEmployeeappointmentdetail.findByAppointmentfileno", query = "SELECT p FROM PpEmployeeappointmentdetail p WHERE p.appointmentfileno = :appointmentfileno"),
		@NamedQuery(name = "PpEmployeeappointmentdetail.findByAppointmentfiledate", query = "SELECT p FROM PpEmployeeappointmentdetail p WHERE p.appointmentfiledate = :appointmentfiledate"),
		@NamedQuery(name = "PpEmployeeappointmentdetail.findByPpDesignationmasterid", query = "SELECT p FROM PpEmployeeappointmentdetail p WHERE p.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "PpEmployeeappointmentdetail.findByAppointmentauthority", query = "SELECT p FROM PpEmployeeappointmentdetail p WHERE p.appointmentauthority = :appointmentauthority"),
		@NamedQuery(name = "PpEmployeeappointmentdetail.findByMasEmploymentsubtypeid", query = "SELECT p FROM PpEmployeeappointmentdetail p WHERE p.masEmploymentsubtypeid = :masEmploymentsubtypeid"),
		@NamedQuery(name = "PpEmployeeappointmentdetail.findByEffectivedatjoin", query = "SELECT p FROM PpEmployeeappointmentdetail p WHERE p.effectivedatjoin = :effectivedatjoin") })
public class PpEmployeeappointmentdetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEAPPOINTMENTDETAILID")
	private Long ppEmployeeappointmentdetailid;
	@Column(name = "DATEJOINING")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datejoining;
	@Column(name = "APPOINTMENTFILENO")
	private String appointmentfileno;
	@Column(name = "APPOINTMENTFILEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date appointmentfiledate;
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Integer ppDesignationmasterid;
	@Column(name = "APPOINTMENTAUTHORITY")
	private String appointmentauthority;
	@Basic(optional = false)
	@Column(name = "MAS_EMPLOYMENTSUBTYPEID")
	private int masEmploymentsubtypeid;
	@Column(name = "EFFECTIVEDATJOIN")
	private String effectivedatjoin;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;
	@JoinColumn(name = "SYS_SUBSERVICEPHASEMASTERID", referencedColumnName = "SYS_SUBSERVICEPHASEMASTERID")
	@ManyToOne
	private SysSubservicephasemaster sysSubservicephasemasterid;

	public PpEmployeeappointmentdetail() {
	}

	public PpEmployeeappointmentdetail(Long ppEmployeeappointmentdetailid) {
		this.ppEmployeeappointmentdetailid = ppEmployeeappointmentdetailid;
	}

	public PpEmployeeappointmentdetail(Long ppEmployeeappointmentdetailid, int masEmploymentsubtypeid) {
		this.ppEmployeeappointmentdetailid = ppEmployeeappointmentdetailid;
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public Long getPpEmployeeappointmentdetailid() {
		return ppEmployeeappointmentdetailid;
	}

	public void setPpEmployeeappointmentdetailid(Long ppEmployeeappointmentdetailid) {
		this.ppEmployeeappointmentdetailid = ppEmployeeappointmentdetailid;
	}

	public Date getDatejoining() {
		return datejoining;
	}

	public void setDatejoining(Date datejoining) {
		this.datejoining = datejoining;
	}

	public String getAppointmentfileno() {
		return appointmentfileno;
	}

	public void setAppointmentfileno(String appointmentfileno) {
		this.appointmentfileno = appointmentfileno;
	}

	public Date getAppointmentfiledate() {
		return appointmentfiledate;
	}

	public void setAppointmentfiledate(Date appointmentfiledate) {
		this.appointmentfiledate = appointmentfiledate;
	}

	public Integer getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(Integer ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public String getAppointmentauthority() {
		return appointmentauthority;
	}

	public void setAppointmentauthority(String appointmentauthority) {
		this.appointmentauthority = appointmentauthority;
	}

	public int getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(int masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public String getEffectivedatjoin() {
		return effectivedatjoin;
	}

	public void setEffectivedatjoin(String effectivedatjoin) {
		this.effectivedatjoin = effectivedatjoin;
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

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppEmployeeappointmentdetailid != null ? ppEmployeeappointmentdetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpEmployeeappointmentdetail)) {
			return false;
		}
		PpEmployeeappointmentdetail other = (PpEmployeeappointmentdetail) object;
		if ((this.ppEmployeeappointmentdetailid == null && other.ppEmployeeappointmentdetailid != null)
				|| (this.ppEmployeeappointmentdetailid != null
						&& !this.ppEmployeeappointmentdetailid.equals(other.ppEmployeeappointmentdetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpEmployeeappointmentdetail[ ppEmployeeappointmentdetailid="
				+ ppEmployeeappointmentdetailid + " ]";
	}

}
