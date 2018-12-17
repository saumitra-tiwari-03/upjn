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
@Table(name = "PREPSN_FAMILYDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PrepsnFamilydetail.findAll", query = "SELECT p FROM PrepsnFamilydetail p"),
		@NamedQuery(name = "PrepsnFamilydetail.findByPrepsnFamilydetailid", query = "SELECT p FROM PrepsnFamilydetail p WHERE p.prepsnFamilydetailid = :prepsnFamilydetailid"),
		@NamedQuery(name = "PrepsnFamilydetail.findByMembername", query = "SELECT p FROM PrepsnFamilydetail p WHERE p.membername = :membername"),
		@NamedQuery(name = "PrepsnFamilydetail.findByMemberdateofbirth", query = "SELECT p FROM PrepsnFamilydetail p WHERE p.memberdateofbirth = :memberdateofbirth"),
		@NamedQuery(name = "PrepsnFamilydetail.findByMemberaddress", query = "SELECT p FROM PrepsnFamilydetail p WHERE p.memberaddress = :memberaddress"),
		@NamedQuery(name = "PrepsnFamilydetail.findByMemberrelation", query = "SELECT p FROM PrepsnFamilydetail p WHERE p.memberrelation = :memberrelation"),
		@NamedQuery(name = "PrepsnFamilydetail.findByFamilyof", query = "SELECT p FROM PrepsnFamilydetail p WHERE p.familyof = :familyof"),
		@NamedQuery(name = "PrepsnFamilydetail.findByIsmarried", query = "SELECT p FROM PrepsnFamilydetail p WHERE p.ismarried = :ismarried"),
		@NamedQuery(name = "PrepsnFamilydetail.findByEmployeecode", query = "SELECT p FROM PrepsnFamilydetail p WHERE p.employeecode = :employeecode") })
public class PrepsnFamilydetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PREPSN_FAMILYDETAILID")
	private Long prepsnFamilydetailid;
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
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@JoinColumn(name = "PREPSN_REGISTRATIONMASTERID", referencedColumnName = "PREPSN_REGISTRATIONMASTERID")
	@ManyToOne(optional = false)
	private PsnRegistrationmaster prepsnRegistrationmasterid;

	public PrepsnFamilydetail() {
	}

	public PrepsnFamilydetail(Long prepsnFamilydetailid) {
		this.prepsnFamilydetailid = prepsnFamilydetailid;
	}

	public PrepsnFamilydetail(Long prepsnFamilydetailid, String membername, Date memberdateofbirth,
			String memberaddress, String memberrelation, Character familyof, Character ismarried) {
		this.prepsnFamilydetailid = prepsnFamilydetailid;
		this.membername = membername;
		this.memberdateofbirth = memberdateofbirth;
		this.memberaddress = memberaddress;
		this.memberrelation = memberrelation;
		this.familyof = familyof;
		this.ismarried = ismarried;
	}

	public Long getPrepsnFamilydetailid() {
		return prepsnFamilydetailid;
	}

	public void setPrepsnFamilydetailid(Long prepsnFamilydetailid) {
		this.prepsnFamilydetailid = prepsnFamilydetailid;
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

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public PsnRegistrationmaster getPrepsnRegistrationmasterid() {
		return prepsnRegistrationmasterid;
	}

	public void setPrepsnRegistrationmasterid(PsnRegistrationmaster prepsnRegistrationmasterid) {
		this.prepsnRegistrationmasterid = prepsnRegistrationmasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (prepsnFamilydetailid != null ? prepsnFamilydetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PrepsnFamilydetail)) {
			return false;
		}
		PrepsnFamilydetail other = (PrepsnFamilydetail) object;
		if ((this.prepsnFamilydetailid == null && other.prepsnFamilydetailid != null)
				|| (this.prepsnFamilydetailid != null
						&& !this.prepsnFamilydetailid.equals(other.prepsnFamilydetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PrepsnFamilydetail[ prepsnFamilydetailid=" + prepsnFamilydetailid + " ]";
	}

}
