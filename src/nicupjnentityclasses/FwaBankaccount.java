/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "FWA_BANKACCOUNT")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FwaBankaccount.findAll", query = "SELECT f FROM FwaBankaccount f"),
		@NamedQuery(name = "FwaBankaccount.findByFwaBankaccountid", query = "SELECT f FROM FwaBankaccount f WHERE f.fwaBankaccountid = :fwaBankaccountid"),
		@NamedQuery(name = "FwaBankaccount.findByAcHoldername", query = "SELECT f FROM FwaBankaccount f WHERE f.acHoldername = :acHoldername"),
		@NamedQuery(name = "FwaBankaccount.findByAcNumber", query = "SELECT f FROM FwaBankaccount f WHERE f.acNumber = :acNumber"),
		@NamedQuery(name = "FwaBankaccount.findByBranchName", query = "SELECT f FROM FwaBankaccount f WHERE f.branchName = :branchName"),
		@NamedQuery(name = "FwaBankaccount.findByIfscCode", query = "SELECT f FROM FwaBankaccount f WHERE f.ifscCode = :ifscCode"),
		@NamedQuery(name = "FwaBankaccount.findByRmOfficeid1", query = "SELECT f FROM FwaBankaccount f WHERE f.rmOfficeid1 = :rmOfficeid1") })
public class FwaBankaccount implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "FWA_BANKACCOUNTID")
	private Integer fwaBankaccountid;
	@Basic(optional = false)
	@Column(name = "AC_HOLDERNAME")
	private String acHoldername;
	@Basic(optional = false)
	@Column(name = "AC_NUMBER")
	private String acNumber;
	@Column(name = "BRANCH_NAME")
	private String branchName;
	@Column(name = "IFSC_CODE")
	private String ifscCode;
	@Column(name = "RM_OFFICEID1")
	private Integer rmOfficeid1;
	@OneToMany(mappedBy = "fwaBankaccountid")
	private Collection<FwaChequedetail> fwaChequedetailCollection;
	@JoinColumn(name = "MAS_BANKID", referencedColumnName = "MAS_BANKID")
	@ManyToOne(optional = false)
	private MasBank masBankid;
	@JoinColumn(name = "RM_OFFICEID", referencedColumnName = "RM_OFFICEID")
	@ManyToOne(optional = false)
	private RmOffice rmOfficeid;

	public FwaBankaccount() {
	}

	public FwaBankaccount(Integer fwaBankaccountid) {
		this.fwaBankaccountid = fwaBankaccountid;
	}

	public FwaBankaccount(Integer fwaBankaccountid, String acHoldername, String acNumber) {
		this.fwaBankaccountid = fwaBankaccountid;
		this.acHoldername = acHoldername;
		this.acNumber = acNumber;
	}

	public Integer getFwaBankaccountid() {
		return fwaBankaccountid;
	}

	public void setFwaBankaccountid(Integer fwaBankaccountid) {
		this.fwaBankaccountid = fwaBankaccountid;
	}

	public String getAcHoldername() {
		return acHoldername;
	}

	public void setAcHoldername(String acHoldername) {
		this.acHoldername = acHoldername;
	}

	public String getAcNumber() {
		return acNumber;
	}

	public void setAcNumber(String acNumber) {
		this.acNumber = acNumber;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Integer getRmOfficeid1() {
		return rmOfficeid1;
	}

	public void setRmOfficeid1(Integer rmOfficeid1) {
		this.rmOfficeid1 = rmOfficeid1;
	}

	@XmlTransient
	public Collection<FwaChequedetail> getFwaChequedetailCollection() {
		return fwaChequedetailCollection;
	}

	public void setFwaChequedetailCollection(Collection<FwaChequedetail> fwaChequedetailCollection) {
		this.fwaChequedetailCollection = fwaChequedetailCollection;
	}

	public MasBank getMasBankid() {
		return masBankid;
	}

	public void setMasBankid(MasBank masBankid) {
		this.masBankid = masBankid;
	}

	public RmOffice getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(RmOffice rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (fwaBankaccountid != null ? fwaBankaccountid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof FwaBankaccount)) {
			return false;
		}
		FwaBankaccount other = (FwaBankaccount) object;
		if ((this.fwaBankaccountid == null && other.fwaBankaccountid != null)
				|| (this.fwaBankaccountid != null && !this.fwaBankaccountid.equals(other.fwaBankaccountid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.FwaBankaccount[ fwaBankaccountid=" + fwaBankaccountid + " ]";
	}

}
