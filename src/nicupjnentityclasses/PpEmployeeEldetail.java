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
@Table(name = "PP_EMPLOYEE_ELDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpEmployeeEldetail.findAll", query = "SELECT p FROM PpEmployeeEldetail p"),
		@NamedQuery(name = "PpEmployeeEldetail.findByPpEmployeeEldetailid", query = "SELECT p FROM PpEmployeeEldetail p WHERE p.ppEmployeeEldetailid = :ppEmployeeEldetailid"),
		@NamedQuery(name = "PpEmployeeEldetail.findByRelorderno", query = "SELECT p FROM PpEmployeeEldetail p WHERE p.relorderno = :relorderno"),
		@NamedQuery(name = "PpEmployeeEldetail.findByRelorderdate", query = "SELECT p FROM PpEmployeeEldetail p WHERE p.relorderdate = :relorderdate"),
		@NamedQuery(name = "PpEmployeeEldetail.findByJoiningdate", query = "SELECT p FROM PpEmployeeEldetail p WHERE p.joiningdate = :joiningdate"),
		@NamedQuery(name = "PpEmployeeEldetail.findByJoininganfn", query = "SELECT p FROM PpEmployeeEldetail p WHERE p.joininganfn = :joininganfn"),
		@NamedQuery(name = "PpEmployeeEldetail.findByJoiningorderdate", query = "SELECT p FROM PpEmployeeEldetail p WHERE p.joiningorderdate = :joiningorderdate"),
		@NamedQuery(name = "PpEmployeeEldetail.findByJoiningorder", query = "SELECT p FROM PpEmployeeEldetail p WHERE p.joiningorder = :joiningorder"),
		@NamedQuery(name = "PpEmployeeEldetail.findByIsjoined", query = "SELECT p FROM PpEmployeeEldetail p WHERE p.isjoined = :isjoined"),
		@NamedQuery(name = "PpEmployeeEldetail.findByRmOfficeid", query = "SELECT p FROM PpEmployeeEldetail p WHERE p.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "PpEmployeeEldetail.findByTransferordno", query = "SELECT p FROM PpEmployeeEldetail p WHERE p.transferordno = :transferordno"),
		@NamedQuery(name = "PpEmployeeEldetail.findByTransferorddate", query = "SELECT p FROM PpEmployeeEldetail p WHERE p.transferorddate = :transferorddate"),
		@NamedQuery(name = "PpEmployeeEldetail.findByOfficeto", query = "SELECT p FROM PpEmployeeEldetail p WHERE p.officeto = :officeto") })
public class PpEmployeeEldetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEE_ELDETAILID")
	private Long ppEmployeeEldetailid;
	@Column(name = "RELORDERNO")
	private String relorderno;
	@Column(name = "RELORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relorderdate;
	@Column(name = "JOININGDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date joiningdate;
	@Column(name = "JOININGANFN")
	private String joininganfn;
	@Column(name = "JOININGORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date joiningorderdate;
	@Column(name = "JOININGORDER")
	private String joiningorder;
	@Column(name = "ISJOINED")
	private String isjoined;
	@Column(name = "RM_OFFICEID")
	private Long rmOfficeid;
	@Column(name = "TRANSFERORDNO")
	private String transferordno;
	@Column(name = "TRANSFERORDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transferorddate;
	@Column(name = "OFFICETO")
	private Long officeto;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne
	private PpEmployeemaster ppEmployeemasterid;

	public PpEmployeeEldetail() {
	}

	public PpEmployeeEldetail(Long ppEmployeeEldetailid) {
		this.ppEmployeeEldetailid = ppEmployeeEldetailid;
	}

	public Long getPpEmployeeEldetailid() {
		return ppEmployeeEldetailid;
	}

	public void setPpEmployeeEldetailid(Long ppEmployeeEldetailid) {
		this.ppEmployeeEldetailid = ppEmployeeEldetailid;
	}

	public String getRelorderno() {
		return relorderno;
	}

	public void setRelorderno(String relorderno) {
		this.relorderno = relorderno;
	}

	public Date getRelorderdate() {
		return relorderdate;
	}

	public void setRelorderdate(Date relorderdate) {
		this.relorderdate = relorderdate;
	}

	public Date getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	public String getJoininganfn() {
		return joininganfn;
	}

	public void setJoininganfn(String joininganfn) {
		this.joininganfn = joininganfn;
	}

	public Date getJoiningorderdate() {
		return joiningorderdate;
	}

	public void setJoiningorderdate(Date joiningorderdate) {
		this.joiningorderdate = joiningorderdate;
	}

	public String getJoiningorder() {
		return joiningorder;
	}

	public void setJoiningorder(String joiningorder) {
		this.joiningorder = joiningorder;
	}

	public String getIsjoined() {
		return isjoined;
	}

	public void setIsjoined(String isjoined) {
		this.isjoined = isjoined;
	}

	public Long getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Long rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getTransferordno() {
		return transferordno;
	}

	public void setTransferordno(String transferordno) {
		this.transferordno = transferordno;
	}

	public Date getTransferorddate() {
		return transferorddate;
	}

	public void setTransferorddate(Date transferorddate) {
		this.transferorddate = transferorddate;
	}

	public Long getOfficeto() {
		return officeto;
	}

	public void setOfficeto(Long officeto) {
		this.officeto = officeto;
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
		hash += (ppEmployeeEldetailid != null ? ppEmployeeEldetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpEmployeeEldetail)) {
			return false;
		}
		PpEmployeeEldetail other = (PpEmployeeEldetail) object;
		if ((this.ppEmployeeEldetailid == null && other.ppEmployeeEldetailid != null)
				|| (this.ppEmployeeEldetailid != null
						&& !this.ppEmployeeEldetailid.equals(other.ppEmployeeEldetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpEmployeeEldetail[ ppEmployeeEldetailid=" + ppEmployeeEldetailid + " ]";
	}

}
