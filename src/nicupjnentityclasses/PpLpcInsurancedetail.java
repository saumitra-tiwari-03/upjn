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
@Table(name = "PP_LPC_INSURANCEDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpLpcInsurancedetail.findAll", query = "SELECT p FROM PpLpcInsurancedetail p"),
		@NamedQuery(name = "PpLpcInsurancedetail.findByPpLpcInsurancedetailid", query = "SELECT p FROM PpLpcInsurancedetail p WHERE p.ppLpcInsurancedetailid = :ppLpcInsurancedetailid"),
		@NamedQuery(name = "PpLpcInsurancedetail.findByInsurancecompanyname", query = "SELECT p FROM PpLpcInsurancedetail p WHERE p.insurancecompanyname = :insurancecompanyname"),
		@NamedQuery(name = "PpLpcInsurancedetail.findByPolicyname", query = "SELECT p FROM PpLpcInsurancedetail p WHERE p.policyname = :policyname"),
		@NamedQuery(name = "PpLpcInsurancedetail.findByPolicyno", query = "SELECT p FROM PpLpcInsurancedetail p WHERE p.policyno = :policyno"),
		@NamedQuery(name = "PpLpcInsurancedetail.findByNextduedate", query = "SELECT p FROM PpLpcInsurancedetail p WHERE p.nextduedate = :nextduedate"),
		@NamedQuery(name = "PpLpcInsurancedetail.findByPremiumamount", query = "SELECT p FROM PpLpcInsurancedetail p WHERE p.premiumamount = :premiumamount") })
public class PpLpcInsurancedetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_LPC_INSURANCEDETAILID")
	private Integer ppLpcInsurancedetailid;
	@Basic(optional = false)
	@Column(name = "INSURANCECOMPANYNAME")
	private String insurancecompanyname;
	@Basic(optional = false)
	@Column(name = "POLICYNAME")
	private String policyname;
	@Basic(optional = false)
	@Column(name = "POLICYNO")
	private int policyno;
	@Basic(optional = false)
	@Column(name = "NEXTDUEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date nextduedate;
	@Basic(optional = false)
	@Column(name = "PREMIUMAMOUNT")
	private String premiumamount;
	@JoinColumn(name = "PP_LPCDETAILID", referencedColumnName = "PP_LPCDETAILID")
	@ManyToOne(optional = false)
	private PpLpcdetail ppLpcdetailid;

	public PpLpcInsurancedetail() {
	}

	public PpLpcInsurancedetail(Integer ppLpcInsurancedetailid) {
		this.ppLpcInsurancedetailid = ppLpcInsurancedetailid;
	}

	public PpLpcInsurancedetail(Integer ppLpcInsurancedetailid, String insurancecompanyname, String policyname,
			int policyno, Date nextduedate, String premiumamount) {
		this.ppLpcInsurancedetailid = ppLpcInsurancedetailid;
		this.insurancecompanyname = insurancecompanyname;
		this.policyname = policyname;
		this.policyno = policyno;
		this.nextduedate = nextduedate;
		this.premiumamount = premiumamount;
	}

	public Integer getPpLpcInsurancedetailid() {
		return ppLpcInsurancedetailid;
	}

	public void setPpLpcInsurancedetailid(Integer ppLpcInsurancedetailid) {
		this.ppLpcInsurancedetailid = ppLpcInsurancedetailid;
	}

	public String getInsurancecompanyname() {
		return insurancecompanyname;
	}

	public void setInsurancecompanyname(String insurancecompanyname) {
		this.insurancecompanyname = insurancecompanyname;
	}

	public String getPolicyname() {
		return policyname;
	}

	public void setPolicyname(String policyname) {
		this.policyname = policyname;
	}

	public int getPolicyno() {
		return policyno;
	}

	public void setPolicyno(int policyno) {
		this.policyno = policyno;
	}

	public Date getNextduedate() {
		return nextduedate;
	}

	public void setNextduedate(Date nextduedate) {
		this.nextduedate = nextduedate;
	}

	public String getPremiumamount() {
		return premiumamount;
	}

	public void setPremiumamount(String premiumamount) {
		this.premiumamount = premiumamount;
	}

	public PpLpcdetail getPpLpcdetailid() {
		return ppLpcdetailid;
	}

	public void setPpLpcdetailid(PpLpcdetail ppLpcdetailid) {
		this.ppLpcdetailid = ppLpcdetailid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppLpcInsurancedetailid != null ? ppLpcInsurancedetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpLpcInsurancedetail)) {
			return false;
		}
		PpLpcInsurancedetail other = (PpLpcInsurancedetail) object;
		if ((this.ppLpcInsurancedetailid == null && other.ppLpcInsurancedetailid != null)
				|| (this.ppLpcInsurancedetailid != null
						&& !this.ppLpcInsurancedetailid.equals(other.ppLpcInsurancedetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpLpcInsurancedetail[ ppLpcInsurancedetailid=" + ppLpcInsurancedetailid + " ]";
	}

}
