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
@Table(name = "PSN_OBJECTIONTYPE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PsnObjectiontype.findAll", query = "SELECT p FROM PsnObjectiontype p"),
		@NamedQuery(name = "PsnObjectiontype.findByPensiontypeid", query = "SELECT p FROM PsnObjectiontype p WHERE p.pensiontypeid = :pensiontypeid"),
		@NamedQuery(name = "PsnObjectiontype.findByDescription", query = "SELECT p FROM PsnObjectiontype p WHERE p.description = :description") })
public class PsnObjectiontype implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PENSIONTYPEID")
	private Long pensiontypeid;
	@Column(name = "DESCRIPTION")
	private String description;

	public PsnObjectiontype() {
	}

	public PsnObjectiontype(Long pensiontypeid) {
		this.pensiontypeid = pensiontypeid;
	}

	public Long getPensiontypeid() {
		return pensiontypeid;
	}

	public void setPensiontypeid(Long pensiontypeid) {
		this.pensiontypeid = pensiontypeid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (pensiontypeid != null ? pensiontypeid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PsnObjectiontype)) {
			return false;
		}
		PsnObjectiontype other = (PsnObjectiontype) object;
		if ((this.pensiontypeid == null && other.pensiontypeid != null)
				|| (this.pensiontypeid != null && !this.pensiontypeid.equals(other.pensiontypeid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PsnObjectiontype[ pensiontypeid=" + pensiontypeid + " ]";
	}

}
