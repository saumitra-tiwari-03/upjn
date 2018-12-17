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
@Table(name = "PSN_FAMILYDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PsnFamilydetail.findAll", query = "SELECT p FROM PsnFamilydetail p"),
		@NamedQuery(name = "PsnFamilydetail.findByPsnFamilydetailid", query = "SELECT p FROM PsnFamilydetail p WHERE p.psnFamilydetailid = :psnFamilydetailid"),
		@NamedQuery(name = "PsnFamilydetail.findByMembername", query = "SELECT p FROM PsnFamilydetail p WHERE p.membername = :membername"),
		@NamedQuery(name = "PsnFamilydetail.findByMemberdateofbirth", query = "SELECT p FROM PsnFamilydetail p WHERE p.memberdateofbirth = :memberdateofbirth"),
		@NamedQuery(name = "PsnFamilydetail.findByMemberaddress", query = "SELECT p FROM PsnFamilydetail p WHERE p.memberaddress = :memberaddress"),
		@NamedQuery(name = "PsnFamilydetail.findByMemberrelation", query = "SELECT p FROM PsnFamilydetail p WHERE p.memberrelation = :memberrelation"),
		@NamedQuery(name = "PsnFamilydetail.findByFamilyof", query = "SELECT p FROM PsnFamilydetail p WHERE p.familyof = :familyof"),
		@NamedQuery(name = "PsnFamilydetail.findByIsmarried", query = "SELECT p FROM PsnFamilydetail p WHERE p.ismarried = :ismarried") })
public class PsnFamilydetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PSN_FAMILYDETAILID")
	private Long psnFamilydetailid;
	@Basic(optional = false)
	@Column(name = "MEMBERNAME")
	private String membername;
	@Basic(optional = false)
	@Column(name = "MEMBERDATEOFBIRTH")
	@Temporal(TemporalType.TIMESTAMP)
	private Date memberdateofbirth;
	@Basic(optional = false)
	@Column(name = "MEMBERADDRESS")
	private String memberaddress;
	@Basic(optional = false)
	@Column(name = "MEMBERRELATION")
	private String memberrelation;
	@Basic(optional = false)
	@Column(name = "FAMILYOF")
	private Character familyof;
	@Basic(optional = false)
	@Column(name = "ISMARRIED")
	private Character ismarried;
	@JoinColumn(name = "PSN_EMPLOYEEPENSION_MASTERID", referencedColumnName = "PSN_EMPLOYEEPENSION_MASTERID")
	@ManyToOne(optional = false)
	private PsnEmployeepensionMaster psnEmployeepensionMasterid;

	public PsnFamilydetail() {
	}

	public PsnFamilydetail(Long psnFamilydetailid) {
		this.psnFamilydetailid = psnFamilydetailid;
	}

	public PsnFamilydetail(Long psnFamilydetailid, String membername, Date memberdateofbirth, String memberaddress,
			String memberrelation, Character familyof, Character ismarried) {
		this.psnFamilydetailid = psnFamilydetailid;
		this.membername = membername;
		this.memberdateofbirth = memberdateofbirth;
		this.memberaddress = memberaddress;
		this.memberrelation = memberrelation;
		this.familyof = familyof;
		this.ismarried = ismarried;
	}

	public Long getPsnFamilydetailid() {
		return psnFamilydetailid;
	}

	public void setPsnFamilydetailid(Long psnFamilydetailid) {
		this.psnFamilydetailid = psnFamilydetailid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public Date getMemberdateofbirth() {
		return memberdateofbirth;
	}

	public void setMemberdateofbirth(Date memberdateofbirth) {
		this.memberdateofbirth = memberdateofbirth;
	}

	public String getMemberaddress() {
		return memberaddress;
	}

	public void setMemberaddress(String memberaddress) {
		this.memberaddress = memberaddress;
	}

	public String getMemberrelation() {
		return memberrelation;
	}

	public void setMemberrelation(String memberrelation) {
		this.memberrelation = memberrelation;
	}

	public Character getFamilyof() {
		return familyof;
	}

	public void setFamilyof(Character familyof) {
		this.familyof = familyof;
	}

	public Character getIsmarried() {
		return ismarried;
	}

	public void setIsmarried(Character ismarried) {
		this.ismarried = ismarried;
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
		hash += (psnFamilydetailid != null ? psnFamilydetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PsnFamilydetail)) {
			return false;
		}
		PsnFamilydetail other = (PsnFamilydetail) object;
		if ((this.psnFamilydetailid == null && other.psnFamilydetailid != null)
				|| (this.psnFamilydetailid != null && !this.psnFamilydetailid.equals(other.psnFamilydetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PsnFamilydetail[ psnFamilydetailid=" + psnFamilydetailid + " ]";
	}

}
