/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "FWA_CLOSINGBALANCES")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FwaClosingbalances.findAll", query = "SELECT f FROM FwaClosingbalances f"),
		@NamedQuery(name = "FwaClosingbalances.findByFwaClosingbalancesid", query = "SELECT f FROM FwaClosingbalances f WHERE f.fwaClosingbalancesid = :fwaClosingbalancesid"),
		@NamedQuery(name = "FwaClosingbalances.findByBalance", query = "SELECT f FROM FwaClosingbalances f WHERE f.balance = :balance"),
		@NamedQuery(name = "FwaClosingbalances.findByClosingDate", query = "SELECT f FROM FwaClosingbalances f WHERE f.closingDate = :closingDate"),
		@NamedQuery(name = "FwaClosingbalances.findByRmOfficeid", query = "SELECT f FROM FwaClosingbalances f WHERE f.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "FwaClosingbalances.findByCrdr", query = "SELECT f FROM FwaClosingbalances f WHERE f.crdr = :crdr") })
public class FwaClosingbalances implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "FWA_CLOSINGBALANCESID")
	private Long fwaClosingbalancesid;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "BALANCE")
	private BigDecimal balance;
	@Basic(optional = false)
	@Column(name = "CLOSING_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date closingDate;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Basic(optional = false)
	@Column(name = "CRDR")
	private String crdr;
	@JoinColumn(name = "FWA_AC_CODE_MASTERID", referencedColumnName = "FWA_AC_CODE_MASTERID")
	@ManyToOne(optional = false)
	private FwaAcCodeMaster fwaAcCodeMasterid;

	public FwaClosingbalances() {
	}

	public FwaClosingbalances(Long fwaClosingbalancesid) {
		this.fwaClosingbalancesid = fwaClosingbalancesid;
	}

	public FwaClosingbalances(Long fwaClosingbalancesid, BigDecimal balance, Date closingDate, int rmOfficeid,
			String crdr) {
		this.fwaClosingbalancesid = fwaClosingbalancesid;
		this.balance = balance;
		this.closingDate = closingDate;
		this.rmOfficeid = rmOfficeid;
		this.crdr = crdr;
	}

	public Long getFwaClosingbalancesid() {
		return fwaClosingbalancesid;
	}

	public void setFwaClosingbalancesid(Long fwaClosingbalancesid) {
		this.fwaClosingbalancesid = fwaClosingbalancesid;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getCrdr() {
		return crdr;
	}

	public void setCrdr(String crdr) {
		this.crdr = crdr;
	}

	public FwaAcCodeMaster getFwaAcCodeMasterid() {
		return fwaAcCodeMasterid;
	}

	public void setFwaAcCodeMasterid(FwaAcCodeMaster fwaAcCodeMasterid) {
		this.fwaAcCodeMasterid = fwaAcCodeMasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (fwaClosingbalancesid != null ? fwaClosingbalancesid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof FwaClosingbalances)) {
			return false;
		}
		FwaClosingbalances other = (FwaClosingbalances) object;
		if ((this.fwaClosingbalancesid == null && other.fwaClosingbalancesid != null)
				|| (this.fwaClosingbalancesid != null
						&& !this.fwaClosingbalancesid.equals(other.fwaClosingbalancesid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.FwaClosingbalances[ fwaClosingbalancesid=" + fwaClosingbalancesid + " ]";
	}

}
