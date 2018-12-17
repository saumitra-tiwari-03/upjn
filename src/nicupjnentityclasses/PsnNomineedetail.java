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
@Table(name = "PSN_NOMINEEDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PsnNomineedetail.findAll", query = "SELECT p FROM PsnNomineedetail p"),
		@NamedQuery(name = "PsnNomineedetail.findByPsnNomineedetailid", query = "SELECT p FROM PsnNomineedetail p WHERE p.psnNomineedetailid = :psnNomineedetailid"),
		@NamedQuery(name = "PsnNomineedetail.findByNomineename", query = "SELECT p FROM PsnNomineedetail p WHERE p.nomineename = :nomineename"),
		@NamedQuery(name = "PsnNomineedetail.findByNomineedateofbirth", query = "SELECT p FROM PsnNomineedetail p WHERE p.nomineedateofbirth = :nomineedateofbirth"),
		@NamedQuery(name = "PsnNomineedetail.findByNomineeaddress", query = "SELECT p FROM PsnNomineedetail p WHERE p.nomineeaddress = :nomineeaddress"),
		@NamedQuery(name = "PsnNomineedetail.findByRelation", query = "SELECT p FROM PsnNomineedetail p WHERE p.relation = :relation"),
		@NamedQuery(name = "PsnNomineedetail.findByNominationtype", query = "SELECT p FROM PsnNomineedetail p WHERE p.nominationtype = :nominationtype") })
public class PsnNomineedetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PSN_NOMINEEDETAILID")
	private Long psnNomineedetailid;
	@Basic(optional = false)
	@Column(name = "NOMINEENAME")
	private String nomineename;
	@Basic(optional = false)
	@Column(name = "NOMINEEDATEOFBIRTH")
	@Temporal(TemporalType.TIMESTAMP)
	private Date nomineedateofbirth;
	@Column(name = "NOMINEEADDRESS")
	private String nomineeaddress;
	@Basic(optional = false)
	@Column(name = "RELATION")
	private String relation;
	@Basic(optional = false)
	@Column(name = "NOMINATIONTYPE")
	private String nominationtype;
	@JoinColumn(name = "PSN_EMPLOYEEPENSION_MASTERID", referencedColumnName = "PSN_EMPLOYEEPENSION_MASTERID")
	@ManyToOne(optional = false)
	private PsnEmployeepensionMaster psnEmployeepensionMasterid;

	public PsnNomineedetail() {
	}

	public PsnNomineedetail(Long psnNomineedetailid) {
		this.psnNomineedetailid = psnNomineedetailid;
	}

	public PsnNomineedetail(Long psnNomineedetailid, String nomineename, Date nomineedateofbirth, String relation,
			String nominationtype) {
		this.psnNomineedetailid = psnNomineedetailid;
		this.nomineename = nomineename;
		this.nomineedateofbirth = nomineedateofbirth;
		this.relation = relation;
		this.nominationtype = nominationtype;
	}

	public Long getPsnNomineedetailid() {
		return psnNomineedetailid;
	}

	public void setPsnNomineedetailid(Long psnNomineedetailid) {
		this.psnNomineedetailid = psnNomineedetailid;
	}

	public String getNomineename() {
		return nomineename;
	}

	public void setNomineename(String nomineename) {
		this.nomineename = nomineename;
	}

	public Date getNomineedateofbirth() {
		return nomineedateofbirth;
	}

	public void setNomineedateofbirth(Date nomineedateofbirth) {
		this.nomineedateofbirth = nomineedateofbirth;
	}

	public String getNomineeaddress() {
		return nomineeaddress;
	}

	public void setNomineeaddress(String nomineeaddress) {
		this.nomineeaddress = nomineeaddress;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getNominationtype() {
		return nominationtype;
	}

	public void setNominationtype(String nominationtype) {
		this.nominationtype = nominationtype;
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
		hash += (psnNomineedetailid != null ? psnNomineedetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PsnNomineedetail)) {
			return false;
		}
		PsnNomineedetail other = (PsnNomineedetail) object;
		if ((this.psnNomineedetailid == null && other.psnNomineedetailid != null)
				|| (this.psnNomineedetailid != null && !this.psnNomineedetailid.equals(other.psnNomineedetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PsnNomineedetail[ psnNomineedetailid=" + psnNomineedetailid + " ]";
	}

}
