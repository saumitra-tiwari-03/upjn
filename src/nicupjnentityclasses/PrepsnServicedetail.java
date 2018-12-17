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
@Table(name = "PREPSN_SERVICEDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PrepsnServicedetail.findAll", query = "SELECT p FROM PrepsnServicedetail p"),
		@NamedQuery(name = "PrepsnServicedetail.findByPrepsnServicedetailid", query = "SELECT p FROM PrepsnServicedetail p WHERE p.prepsnServicedetailid = :prepsnServicedetailid"),
		@NamedQuery(name = "PrepsnServicedetail.findByPsnDesignationmasterid", query = "SELECT p FROM PrepsnServicedetail p WHERE p.psnDesignationmasterid = :psnDesignationmasterid"),
		@NamedQuery(name = "PrepsnServicedetail.findByFromdate", query = "SELECT p FROM PrepsnServicedetail p WHERE p.fromdate = :fromdate"),
		@NamedQuery(name = "PrepsnServicedetail.findByTodate", query = "SELECT p FROM PrepsnServicedetail p WHERE p.todate = :todate"),
		@NamedQuery(name = "PrepsnServicedetail.findByRmOfficeid", query = "SELECT p FROM PrepsnServicedetail p WHERE p.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "PrepsnServicedetail.findByIsrealible", query = "SELECT p FROM PrepsnServicedetail p WHERE p.isrealible = :isrealible"),
		@NamedQuery(name = "PrepsnServicedetail.findByReason", query = "SELECT p FROM PrepsnServicedetail p WHERE p.reason = :reason"),
		@NamedQuery(name = "PrepsnServicedetail.findByEmployeecode", query = "SELECT p FROM PrepsnServicedetail p WHERE p.employeecode = :employeecode") })
public class PrepsnServicedetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PREPSN_SERVICEDETAILID")
	private Long prepsnServicedetailid;
	@Basic(optional = false)
	@Column(name = "PSN_DESIGNATIONMASTERID")
	private int psnDesignationmasterid;
	@Column(name = "FROMDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromdate;
	@Column(name = "TODATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date todate;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Basic(optional = false)
	@Column(name = "ISREALIBLE")
	private Character isrealible;
	@Column(name = "REASON")
	private String reason;
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@JoinColumn(name = "PREPSN_REGISTRATIONMASTERID", referencedColumnName = "PREPSN_REGISTRATIONMASTERID")
	@ManyToOne(optional = false)
	private PsnRegistrationmaster prepsnRegistrationmasterid;

	public PrepsnServicedetail() {
	}

	public PrepsnServicedetail(Long prepsnServicedetailid) {
		this.prepsnServicedetailid = prepsnServicedetailid;
	}

	public PrepsnServicedetail(Long prepsnServicedetailid, int psnDesignationmasterid, int rmOfficeid,
			Character isrealible) {
		this.prepsnServicedetailid = prepsnServicedetailid;
		this.psnDesignationmasterid = psnDesignationmasterid;
		this.rmOfficeid = rmOfficeid;
		this.isrealible = isrealible;
	}

	public Long getPrepsnServicedetailid() {
		return prepsnServicedetailid;
	}

	public void setPrepsnServicedetailid(Long prepsnServicedetailid) {
		this.prepsnServicedetailid = prepsnServicedetailid;
	}

	public int getPsnDesignationmasterid() {
		return psnDesignationmasterid;
	}

	public void setPsnDesignationmasterid(int psnDesignationmasterid) {
		this.psnDesignationmasterid = psnDesignationmasterid;
	}

	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	public Date getTodate() {
		return todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Character getIsrealible() {
		return isrealible;
	}

	public void setIsrealible(Character isrealible) {
		this.isrealible = isrealible;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public PsnRegistrationmaster getPrepsnRegistrationmasterid() {
		return prepsnRegistrationmasterid;
	}

	public void setPrepsnRegistrationmasterid(PsnRegistrationmaster prepsnRegistrationmasterid) {
		this.prepsnRegistrationmasterid = prepsnRegistrationmasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (prepsnServicedetailid != null ? prepsnServicedetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PrepsnServicedetail)) {
			return false;
		}
		PrepsnServicedetail other = (PrepsnServicedetail) object;
		if ((this.prepsnServicedetailid == null && other.prepsnServicedetailid != null)
				|| (this.prepsnServicedetailid != null
						&& !this.prepsnServicedetailid.equals(other.prepsnServicedetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PrepsnServicedetail[ prepsnServicedetailid=" + prepsnServicedetailid + " ]";
	}

}
