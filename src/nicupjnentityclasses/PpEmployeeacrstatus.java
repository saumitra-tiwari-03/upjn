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
@Table(name = "PP_EMPLOYEEACRSTATUS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpEmployeeacrstatus.findAll", query = "SELECT p FROM PpEmployeeacrstatus p"),
		@NamedQuery(name = "PpEmployeeacrstatus.findByPpEmployeeacrstatusid", query = "SELECT p FROM PpEmployeeacrstatus p WHERE p.ppEmployeeacrstatusid = :ppEmployeeacrstatusid"),
		@NamedQuery(name = "PpEmployeeacrstatus.findByDatefrom", query = "SELECT p FROM PpEmployeeacrstatus p WHERE p.datefrom = :datefrom"),
		@NamedQuery(name = "PpEmployeeacrstatus.findByDateto", query = "SELECT p FROM PpEmployeeacrstatus p WHERE p.dateto = :dateto"),
		@NamedQuery(name = "PpEmployeeacrstatus.findByApprovalauthority", query = "SELECT p FROM PpEmployeeacrstatus p WHERE p.approvalauthority = :approvalauthority"),
		@NamedQuery(name = "PpEmployeeacrstatus.findByFileno", query = "SELECT p FROM PpEmployeeacrstatus p WHERE p.fileno = :fileno") })
public class PpEmployeeacrstatus implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEACRSTATUSID")
	private Long ppEmployeeacrstatusid;
	@Basic(optional = false)
	@Column(name = "DATEFROM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datefrom;
	@Basic(optional = false)
	@Column(name = "DATETO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateto;
	@Column(name = "APPROVALAUTHORITY")
	private String approvalauthority;
	@Column(name = "FILENO")
	private String fileno;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;

	public PpEmployeeacrstatus() {
	}

	public PpEmployeeacrstatus(Long ppEmployeeacrstatusid) {
		this.ppEmployeeacrstatusid = ppEmployeeacrstatusid;
	}

	public PpEmployeeacrstatus(Long ppEmployeeacrstatusid, Date datefrom, Date dateto) {
		this.ppEmployeeacrstatusid = ppEmployeeacrstatusid;
		this.datefrom = datefrom;
		this.dateto = dateto;
	}

	public Long getPpEmployeeacrstatusid() {
		return ppEmployeeacrstatusid;
	}

	public void setPpEmployeeacrstatusid(Long ppEmployeeacrstatusid) {
		this.ppEmployeeacrstatusid = ppEmployeeacrstatusid;
	}

	public Date getDatefrom() {
		return datefrom;
	}

	public void setDatefrom(Date datefrom) {
		this.datefrom = datefrom;
	}

	public Date getDateto() {
		return dateto;
	}

	public void setDateto(Date dateto) {
		this.dateto = dateto;
	}

	public String getApprovalauthority() {
		return approvalauthority;
	}

	public void setApprovalauthority(String approvalauthority) {
		this.approvalauthority = approvalauthority;
	}

	public String getFileno() {
		return fileno;
	}

	public void setFileno(String fileno) {
		this.fileno = fileno;
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
		hash += (ppEmployeeacrstatusid != null ? ppEmployeeacrstatusid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpEmployeeacrstatus)) {
			return false;
		}
		PpEmployeeacrstatus other = (PpEmployeeacrstatus) object;
		if ((this.ppEmployeeacrstatusid == null && other.ppEmployeeacrstatusid != null)
				|| (this.ppEmployeeacrstatusid != null
						&& !this.ppEmployeeacrstatusid.equals(other.ppEmployeeacrstatusid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpEmployeeacrstatus[ ppEmployeeacrstatusid=" + ppEmployeeacrstatusid + " ]";
	}

}
