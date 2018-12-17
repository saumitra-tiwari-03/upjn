/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_LPCDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpLpcdetail.findAll", query = "SELECT p FROM PpLpcdetail p"),
		@NamedQuery(name = "PpLpcdetail.findByPpLpcdetailid", query = "SELECT p FROM PpLpcdetail p WHERE p.ppLpcdetailid = :ppLpcdetailid"),
		@NamedQuery(name = "PpLpcdetail.findByCurrentofficeid", query = "SELECT p FROM PpLpcdetail p WHERE p.currentofficeid = :currentofficeid"),
		@NamedQuery(name = "PpLpcdetail.findByLpcfor", query = "SELECT p FROM PpLpcdetail p WHERE p.lpcfor = :lpcfor"),
		@NamedQuery(name = "PpLpcdetail.findByToofficeid", query = "SELECT p FROM PpLpcdetail p WHERE p.toofficeid = :toofficeid"),
		@NamedQuery(name = "PpLpcdetail.findByPpMonthlypayid", query = "SELECT p FROM PpLpcdetail p WHERE p.ppMonthlypayid = :ppMonthlypayid"),
		@NamedQuery(name = "PpLpcdetail.findByMadeoverchargeofficeof", query = "SELECT p FROM PpLpcdetail p WHERE p.madeoverchargeofficeof = :madeoverchargeofficeof"),
		@NamedQuery(name = "PpLpcdetail.findByMadeoverchargedate", query = "SELECT p FROM PpLpcdetail p WHERE p.madeoverchargedate = :madeoverchargedate"),
		@NamedQuery(name = "PpLpcdetail.findByExtendedjoiningdays", query = "SELECT p FROM PpLpcdetail p WHERE p.extendedjoiningdays = :extendedjoiningdays"),
		@NamedQuery(name = "PpLpcdetail.findByDrawthings", query = "SELECT p FROM PpLpcdetail p WHERE p.drawthings = :drawthings"),
		@NamedQuery(name = "PpLpcdetail.findByEditdate", query = "SELECT p FROM PpLpcdetail p WHERE p.editdate = :editdate"),
		@NamedQuery(name = "PpLpcdetail.findByPpDesignationmasterid", query = "SELECT p FROM PpLpcdetail p WHERE p.ppDesignationmasterid = :ppDesignationmasterid") })
public class PpLpcdetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_LPCDETAILID")
	private Integer ppLpcdetailid;
	@Basic(optional = false)
	@Column(name = "CURRENTOFFICEID")
	private int currentofficeid;
	@Basic(optional = false)
	@Column(name = "LPCFOR")
	private String lpcfor;
	@Column(name = "TOOFFICEID")
	private Integer toofficeid;
	@Column(name = "PP_MONTHLYPAYID")
	private Long ppMonthlypayid;
	@Basic(optional = false)
	@Column(name = "MADEOVERCHARGEOFFICEOF")
	private String madeoverchargeofficeof;
	@Basic(optional = false)
	@Column(name = "MADEOVERCHARGEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date madeoverchargedate;
	@Basic(optional = false)
	@Column(name = "EXTENDEDJOININGDAYS")
	private short extendedjoiningdays;
	@Basic(optional = false)
	@Column(name = "DRAWTHINGS")
	private String drawthings;
	@Column(name = "EDITDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date editdate;
	@Basic(optional = false)
	@Column(name = "PP_DESIGNATIONMASTERID")
	private short ppDesignationmasterid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppLpcdetailid")
	private Collection<PpLpcLeavedetail> ppLpcLeavedetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppLpcdetailid")
	private Collection<PpLpcLoandetail> ppLpcLoandetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppLpcdetailid")
	private Collection<PpLpcInsurancedetail> ppLpcInsurancedetailCollection;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;

	public PpLpcdetail() {
	}

	public PpLpcdetail(Integer ppLpcdetailid) {
		this.ppLpcdetailid = ppLpcdetailid;
	}

	public PpLpcdetail(Integer ppLpcdetailid, int currentofficeid, String lpcfor, String madeoverchargeofficeof,
			Date madeoverchargedate, short extendedjoiningdays, String drawthings, short ppDesignationmasterid) {
		this.ppLpcdetailid = ppLpcdetailid;
		this.currentofficeid = currentofficeid;
		this.lpcfor = lpcfor;
		this.madeoverchargeofficeof = madeoverchargeofficeof;
		this.madeoverchargedate = madeoverchargedate;
		this.extendedjoiningdays = extendedjoiningdays;
		this.drawthings = drawthings;
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public Integer getPpLpcdetailid() {
		return ppLpcdetailid;
	}

	public void setPpLpcdetailid(Integer ppLpcdetailid) {
		this.ppLpcdetailid = ppLpcdetailid;
	}

	public int getCurrentofficeid() {
		return currentofficeid;
	}

	public void setCurrentofficeid(int currentofficeid) {
		this.currentofficeid = currentofficeid;
	}

	public String getLpcfor() {
		return lpcfor;
	}

	public void setLpcfor(String lpcfor) {
		this.lpcfor = lpcfor;
	}

	public Integer getToofficeid() {
		return toofficeid;
	}

	public void setToofficeid(Integer toofficeid) {
		this.toofficeid = toofficeid;
	}

	public Long getPpMonthlypayid() {
		return ppMonthlypayid;
	}

	public void setPpMonthlypayid(Long ppMonthlypayid) {
		this.ppMonthlypayid = ppMonthlypayid;
	}

	public String getMadeoverchargeofficeof() {
		return madeoverchargeofficeof;
	}

	public void setMadeoverchargeofficeof(String madeoverchargeofficeof) {
		this.madeoverchargeofficeof = madeoverchargeofficeof;
	}

	public Date getMadeoverchargedate() {
		return madeoverchargedate;
	}

	public void setMadeoverchargedate(Date madeoverchargedate) {
		this.madeoverchargedate = madeoverchargedate;
	}

	public short getExtendedjoiningdays() {
		return extendedjoiningdays;
	}

	public void setExtendedjoiningdays(short extendedjoiningdays) {
		this.extendedjoiningdays = extendedjoiningdays;
	}

	public String getDrawthings() {
		return drawthings;
	}

	public void setDrawthings(String drawthings) {
		this.drawthings = drawthings;
	}

	public Date getEditdate() {
		return editdate;
	}

	public void setEditdate(Date editdate) {
		this.editdate = editdate;
	}

	public short getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(short ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	@XmlTransient
	public Collection<PpLpcLeavedetail> getPpLpcLeavedetailCollection() {
		return ppLpcLeavedetailCollection;
	}

	public void setPpLpcLeavedetailCollection(Collection<PpLpcLeavedetail> ppLpcLeavedetailCollection) {
		this.ppLpcLeavedetailCollection = ppLpcLeavedetailCollection;
	}

	@XmlTransient
	public Collection<PpLpcLoandetail> getPpLpcLoandetailCollection() {
		return ppLpcLoandetailCollection;
	}

	public void setPpLpcLoandetailCollection(Collection<PpLpcLoandetail> ppLpcLoandetailCollection) {
		this.ppLpcLoandetailCollection = ppLpcLoandetailCollection;
	}

	@XmlTransient
	public Collection<PpLpcInsurancedetail> getPpLpcInsurancedetailCollection() {
		return ppLpcInsurancedetailCollection;
	}

	public void setPpLpcInsurancedetailCollection(Collection<PpLpcInsurancedetail> ppLpcInsurancedetailCollection) {
		this.ppLpcInsurancedetailCollection = ppLpcInsurancedetailCollection;
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
		hash += (ppLpcdetailid != null ? ppLpcdetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpLpcdetail)) {
			return false;
		}
		PpLpcdetail other = (PpLpcdetail) object;
		if ((this.ppLpcdetailid == null && other.ppLpcdetailid != null)
				|| (this.ppLpcdetailid != null && !this.ppLpcdetailid.equals(other.ppLpcdetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpLpcdetail[ ppLpcdetailid=" + ppLpcdetailid + " ]";
	}

}
