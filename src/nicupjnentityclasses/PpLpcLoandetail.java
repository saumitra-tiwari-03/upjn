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
@Table(name = "PP_LPC_LOANDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpLpcLoandetail.findAll", query = "SELECT p FROM PpLpcLoandetail p"),
		@NamedQuery(name = "PpLpcLoandetail.findByPpLpcLoandetailid", query = "SELECT p FROM PpLpcLoandetail p WHERE p.ppLpcLoandetailid = :ppLpcLoandetailid"),
		@NamedQuery(name = "PpLpcLoandetail.findByPpLoanmasterid", query = "SELECT p FROM PpLpcLoandetail p WHERE p.ppLoanmasterid = :ppLoanmasterid"),
		@NamedQuery(name = "PpLpcLoandetail.findByPaRestInstallment", query = "SELECT p FROM PpLpcLoandetail p WHERE p.paRestInstallment = :paRestInstallment"),
		@NamedQuery(name = "PpLpcLoandetail.findByInstallmentamount", query = "SELECT p FROM PpLpcLoandetail p WHERE p.installmentamount = :installmentamount") })
public class PpLpcLoandetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_LPC_LOANDETAILID")
	private Integer ppLpcLoandetailid;
	@Basic(optional = false)
	@Column(name = "PP_LOANMASTERID")
	private int ppLoanmasterid;
	@Basic(optional = false)
	@Column(name = "PA_REST_INSTALLMENT")
	private short paRestInstallment;
	@Basic(optional = false)
	@Column(name = "INSTALLMENTAMOUNT")
	private int installmentamount;
	@JoinColumn(name = "PP_LPCDETAILID", referencedColumnName = "PP_LPCDETAILID")
	@ManyToOne(optional = false)
	private PpLpcdetail ppLpcdetailid;

	public PpLpcLoandetail() {
	}

	public PpLpcLoandetail(Integer ppLpcLoandetailid) {
		this.ppLpcLoandetailid = ppLpcLoandetailid;
	}

	public PpLpcLoandetail(Integer ppLpcLoandetailid, int ppLoanmasterid, short paRestInstallment,
			int installmentamount) {
		this.ppLpcLoandetailid = ppLpcLoandetailid;
		this.ppLoanmasterid = ppLoanmasterid;
		this.paRestInstallment = paRestInstallment;
		this.installmentamount = installmentamount;
	}

	public Integer getPpLpcLoandetailid() {
		return ppLpcLoandetailid;
	}

	public void setPpLpcLoandetailid(Integer ppLpcLoandetailid) {
		this.ppLpcLoandetailid = ppLpcLoandetailid;
	}

	public int getPpLoanmasterid() {
		return ppLoanmasterid;
	}

	public void setPpLoanmasterid(int ppLoanmasterid) {
		this.ppLoanmasterid = ppLoanmasterid;
	}

	public short getPaRestInstallment() {
		return paRestInstallment;
	}

	public void setPaRestInstallment(short paRestInstallment) {
		this.paRestInstallment = paRestInstallment;
	}

	public int getInstallmentamount() {
		return installmentamount;
	}

	public void setInstallmentamount(int installmentamount) {
		this.installmentamount = installmentamount;
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
		hash += (ppLpcLoandetailid != null ? ppLpcLoandetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpLpcLoandetail)) {
			return false;
		}
		PpLpcLoandetail other = (PpLpcLoandetail) object;
		if ((this.ppLpcLoandetailid == null && other.ppLpcLoandetailid != null)
				|| (this.ppLpcLoandetailid != null && !this.ppLpcLoandetailid.equals(other.ppLpcLoandetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpLpcLoandetail[ ppLpcLoandetailid=" + ppLpcLoandetailid + " ]";
	}

}
