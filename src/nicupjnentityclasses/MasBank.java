/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "MAS_BANK")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "MasBank.findAll", query = "SELECT m FROM MasBank m"),
		@NamedQuery(name = "MasBank.findByMasBankid", query = "SELECT m FROM MasBank m WHERE m.masBankid = :masBankid"),
		@NamedQuery(name = "MasBank.findByBankname", query = "SELECT m FROM MasBank m WHERE m.bankname = :bankname") })
public class MasBank implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "MAS_BANKID")
	private Short masBankid;
	@Basic(optional = false)
	@Column(name = "BANKNAME")
	private String bankname;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "masBankid")
	private Collection<FwaBankaccount> fwaBankaccountCollection;

	public MasBank() {
	}

	public MasBank(Short masBankid) {
		this.masBankid = masBankid;
	}

	public MasBank(Short masBankid, String bankname) {
		this.masBankid = masBankid;
		this.bankname = bankname;
	}

	public Short getMasBankid() {
		return masBankid;
	}

	public void setMasBankid(Short masBankid) {
		this.masBankid = masBankid;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	@XmlTransient
	public Collection<FwaBankaccount> getFwaBankaccountCollection() {
		return fwaBankaccountCollection;
	}

	public void setFwaBankaccountCollection(Collection<FwaBankaccount> fwaBankaccountCollection) {
		this.fwaBankaccountCollection = fwaBankaccountCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (masBankid != null ? masBankid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof MasBank)) {
			return false;
		}
		MasBank other = (MasBank) object;
		if ((this.masBankid == null && other.masBankid != null)
				|| (this.masBankid != null && !this.masBankid.equals(other.masBankid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.MasBank[ masBankid=" + masBankid + " ]";
	}

}
