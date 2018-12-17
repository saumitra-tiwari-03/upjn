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
@Table(name = "PSN_PAYMENTDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PsnPaymentdetail.findAll", query = "SELECT p FROM PsnPaymentdetail p"),
		@NamedQuery(name = "PsnPaymentdetail.findByPsnPaymentdetailid", query = "SELECT p FROM PsnPaymentdetail p WHERE p.psnPaymentdetailid = :psnPaymentdetailid"),
		@NamedQuery(name = "PsnPaymentdetail.findByPaymentmode", query = "SELECT p FROM PsnPaymentdetail p WHERE p.paymentmode = :paymentmode"),
		@NamedQuery(name = "PsnPaymentdetail.findByAccountno", query = "SELECT p FROM PsnPaymentdetail p WHERE p.accountno = :accountno"),
		@NamedQuery(name = "PsnPaymentdetail.findByFwaBankaccountid", query = "SELECT p FROM PsnPaymentdetail p WHERE p.fwaBankaccountid = :fwaBankaccountid") })
public class PsnPaymentdetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PSN_PAYMENTDETAILID")
	private Long psnPaymentdetailid;
	@Basic(optional = false)
	@Column(name = "PAYMENTMODE")
	private String paymentmode;
	@Column(name = "ACCOUNTNO")
	private String accountno;
	@Column(name = "FWA_BANKACCOUNTID")
	private Integer fwaBankaccountid;
	@JoinColumn(name = "PSN_EMPLOYEEPENSION_MASTERID", referencedColumnName = "PSN_EMPLOYEEPENSION_MASTERID")
	@ManyToOne(optional = false)
	private PsnEmployeepensionMaster psnEmployeepensionMasterid;

	public PsnPaymentdetail() {
	}

	public PsnPaymentdetail(Long psnPaymentdetailid) {
		this.psnPaymentdetailid = psnPaymentdetailid;
	}

	public PsnPaymentdetail(Long psnPaymentdetailid, String paymentmode) {
		this.psnPaymentdetailid = psnPaymentdetailid;
		this.paymentmode = paymentmode;
	}

	public Long getPsnPaymentdetailid() {
		return psnPaymentdetailid;
	}

	public void setPsnPaymentdetailid(Long psnPaymentdetailid) {
		this.psnPaymentdetailid = psnPaymentdetailid;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public Integer getFwaBankaccountid() {
		return fwaBankaccountid;
	}

	public void setFwaBankaccountid(Integer fwaBankaccountid) {
		this.fwaBankaccountid = fwaBankaccountid;
	}

	public PsnEmployeepensionMaster getPsnEmployeepensionMasterid() {
		return psnEmployeepensionMasterid;
	}

	public void setPsnEmployeepensionMasterid(PsnEmployeepensionMaster psnEmployeepensionMasterid) {
		this.psnEmployeepensionMasterid = psnEmployeepensionMasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (psnPaymentdetailid != null ? psnPaymentdetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PsnPaymentdetail)) {
			return false;
		}
		PsnPaymentdetail other = (PsnPaymentdetail) object;
		if ((this.psnPaymentdetailid == null && other.psnPaymentdetailid != null)
				|| (this.psnPaymentdetailid != null && !this.psnPaymentdetailid.equals(other.psnPaymentdetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PsnPaymentdetail[ psnPaymentdetailid=" + psnPaymentdetailid + " ]";
	}

}
