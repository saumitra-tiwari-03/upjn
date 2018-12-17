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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PSN_FAMILYPENSION_MASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PsnFamilypensionMaster.findAll", query = "SELECT p FROM PsnFamilypensionMaster p"),
		@NamedQuery(name = "PsnFamilypensionMaster.findByPsnFamilypensionMasterid", query = "SELECT p FROM PsnFamilypensionMaster p WHERE p.psnFamilypensionMasterid = :psnFamilypensionMasterid"),
		@NamedQuery(name = "PsnFamilypensionMaster.findByFpName", query = "SELECT p FROM PsnFamilypensionMaster p WHERE p.fpName = :fpName"),
		@NamedQuery(name = "PsnFamilypensionMaster.findByIsnominationchanged", query = "SELECT p FROM PsnFamilypensionMaster p WHERE p.isnominationchanged = :isnominationchanged"),
		@NamedQuery(name = "PsnFamilypensionMaster.findByReason", query = "SELECT p FROM PsnFamilypensionMaster p WHERE p.reason = :reason"),
		@NamedQuery(name = "PsnFamilypensionMaster.findByDateofeffect", query = "SELECT p FROM PsnFamilypensionMaster p WHERE p.dateofeffect = :dateofeffect"),
		@NamedQuery(name = "PsnFamilypensionMaster.findByFpRelationwithemployee", query = "SELECT p FROM PsnFamilypensionMaster p WHERE p.fpRelationwithemployee = :fpRelationwithemployee"),
		@NamedQuery(name = "PsnFamilypensionMaster.findByFpAddress", query = "SELECT p FROM PsnFamilypensionMaster p WHERE p.fpAddress = :fpAddress"),
		@NamedQuery(name = "PsnFamilypensionMaster.findByFpFathername", query = "SELECT p FROM PsnFamilypensionMaster p WHERE p.fpFathername = :fpFathername"),
		@NamedQuery(name = "PsnFamilypensionMaster.findByFpDateofbirth", query = "SELECT p FROM PsnFamilypensionMaster p WHERE p.fpDateofbirth = :fpDateofbirth"),
		@NamedQuery(name = "PsnFamilypensionMaster.findByFamilypensiontype", query = "SELECT p FROM PsnFamilypensionMaster p WHERE p.familypensiontype = :familypensiontype"),
		@NamedQuery(name = "PsnFamilypensionMaster.findByHeight", query = "SELECT p FROM PsnFamilypensionMaster p WHERE p.height = :height"),
		@NamedQuery(name = "PsnFamilypensionMaster.findByIdentificationmark", query = "SELECT p FROM PsnFamilypensionMaster p WHERE p.identificationmark = :identificationmark"),
		@NamedQuery(name = "PsnFamilypensionMaster.findByDesignationofofficehead", query = "SELECT p FROM PsnFamilypensionMaster p WHERE p.designationofofficehead = :designationofofficehead") })
public class PsnFamilypensionMaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PSN_FAMILYPENSION_MASTERID")
	private Long psnFamilypensionMasterid;
	@Basic(optional = false)
	@Column(name = "FP_NAME")
	private String fpName;
	@Column(name = "ISNOMINATIONCHANGED")
	private Character isnominationchanged;
	@Column(name = "REASON")
	private String reason;
	@Column(name = "DATEOFEFFECT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofeffect;
	@Basic(optional = false)
	@Column(name = "FP_RELATIONWITHEMPLOYEE")
	private String fpRelationwithemployee;
	@Column(name = "FP_ADDRESS")
	private String fpAddress;
	@Basic(optional = false)
	@Column(name = "FP_FATHERNAME")
	private String fpFathername;
	@Basic(optional = false)
	@Column(name = "FP_DATEOFBIRTH")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fpDateofbirth;
	@Basic(optional = false)
	@Column(name = "FAMILYPENSIONTYPE")
	private Character familypensiontype;
	@Column(name = "HEIGHT")
	private String height;
	@Column(name = "IDENTIFICATIONMARK")
	private String identificationmark;
	@Column(name = "DESIGNATIONOFOFFICEHEAD")
	private String designationofofficehead;
	@JoinColumn(name = "PSN_EMPLOYEEPENSION_MASTERID", referencedColumnName = "PSN_EMPLOYEEPENSION_MASTERID")
	@OneToOne(optional = false)
	private PsnEmployeepensionMaster psnEmployeepensionMasterid;

	public PsnFamilypensionMaster() {
	}

	public PsnFamilypensionMaster(Long psnFamilypensionMasterid) {
		this.psnFamilypensionMasterid = psnFamilypensionMasterid;
	}

	public PsnFamilypensionMaster(Long psnFamilypensionMasterid, String fpName, String fpRelationwithemployee,
			String fpFathername, Date fpDateofbirth, Character familypensiontype) {
		this.psnFamilypensionMasterid = psnFamilypensionMasterid;
		this.fpName = fpName;
		this.fpRelationwithemployee = fpRelationwithemployee;
		this.fpFathername = fpFathername;
		this.fpDateofbirth = fpDateofbirth;
		this.familypensiontype = familypensiontype;
	}

	public Long getPsnFamilypensionMasterid() {
		return psnFamilypensionMasterid;
	}

	public void setPsnFamilypensionMasterid(Long psnFamilypensionMasterid) {
		this.psnFamilypensionMasterid = psnFamilypensionMasterid;
	}

	public String getFpName() {
		return fpName;
	}

	public void setFpName(String fpName) {
		this.fpName = fpName;
	}

	public Character getIsnominationchanged() {
		return isnominationchanged;
	}

	public void setIsnominationchanged(Character isnominationchanged) {
		this.isnominationchanged = isnominationchanged;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getDateofeffect() {
		return dateofeffect;
	}

	public void setDateofeffect(Date dateofeffect) {
		this.dateofeffect = dateofeffect;
	}

	public String getFpRelationwithemployee() {
		return fpRelationwithemployee;
	}

	public void setFpRelationwithemployee(String fpRelationwithemployee) {
		this.fpRelationwithemployee = fpRelationwithemployee;
	}

	public String getFpAddress() {
		return fpAddress;
	}

	public void setFpAddress(String fpAddress) {
		this.fpAddress = fpAddress;
	}

	public String getFpFathername() {
		return fpFathername;
	}

	public void setFpFathername(String fpFathername) {
		this.fpFathername = fpFathername;
	}

	public Date getFpDateofbirth() {
		return fpDateofbirth;
	}

	public void setFpDateofbirth(Date fpDateofbirth) {
		this.fpDateofbirth = fpDateofbirth;
	}

	public Character getFamilypensiontype() {
		return familypensiontype;
	}

	public void setFamilypensiontype(Character familypensiontype) {
		this.familypensiontype = familypensiontype;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getIdentificationmark() {
		return identificationmark;
	}

	public void setIdentificationmark(String identificationmark) {
		this.identificationmark = identificationmark;
	}

	public String getDesignationofofficehead() {
		return designationofofficehead;
	}

	public void setDesignationofofficehead(String designationofofficehead) {
		this.designationofofficehead = designationofofficehead;
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
		hash += (psnFamilypensionMasterid != null ? psnFamilypensionMasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PsnFamilypensionMaster)) {
			return false;
		}
		PsnFamilypensionMaster other = (PsnFamilypensionMaster) object;
		if ((this.psnFamilypensionMasterid == null && other.psnFamilypensionMasterid != null)
				|| (this.psnFamilypensionMasterid != null
						&& !this.psnFamilypensionMasterid.equals(other.psnFamilypensionMasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PsnFamilypensionMaster[ psnFamilypensionMasterid=" + psnFamilypensionMasterid
				+ " ]";
	}

}
