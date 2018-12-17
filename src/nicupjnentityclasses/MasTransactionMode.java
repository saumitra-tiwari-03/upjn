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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "MAS_TRANSACTION_MODE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "MasTransactionMode.findAll", query = "SELECT m FROM MasTransactionMode m"),
		@NamedQuery(name = "MasTransactionMode.findByMasTransactionModeid", query = "SELECT m FROM MasTransactionMode m WHERE m.masTransactionModeid = :masTransactionModeid"),
		@NamedQuery(name = "MasTransactionMode.findByTransactionmodename", query = "SELECT m FROM MasTransactionMode m WHERE m.transactionmodename = :transactionmodename") })
public class MasTransactionMode implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "MAS_TRANSACTION_MODEID")
	private Short masTransactionModeid;
	@Basic(optional = false)
	@Column(name = "TRANSACTIONMODENAME")
	private String transactionmodename;

	public MasTransactionMode() {
	}

	public MasTransactionMode(Short masTransactionModeid) {
		this.masTransactionModeid = masTransactionModeid;
	}

	public MasTransactionMode(Short masTransactionModeid, String transactionmodename) {
		this.masTransactionModeid = masTransactionModeid;
		this.transactionmodename = transactionmodename;
	}

	public Short getMasTransactionModeid() {
		return masTransactionModeid;
	}

	public void setMasTransactionModeid(Short masTransactionModeid) {
		this.masTransactionModeid = masTransactionModeid;
	}

	public String getTransactionmodename() {
		return transactionmodename;
	}

	public void setTransactionmodename(String transactionmodename) {
		this.transactionmodename = transactionmodename;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (masTransactionModeid != null ? masTransactionModeid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof MasTransactionMode)) {
			return false;
		}
		MasTransactionMode other = (MasTransactionMode) object;
		if ((this.masTransactionModeid == null && other.masTransactionModeid != null)
				|| (this.masTransactionModeid != null
						&& !this.masTransactionModeid.equals(other.masTransactionModeid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.MasTransactionMode[ masTransactionModeid=" + masTransactionModeid + " ]";
	}

}
