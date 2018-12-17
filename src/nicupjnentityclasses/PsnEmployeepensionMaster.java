/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PSN_EMPLOYEEPENSION_MASTER")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "PsnEmployeepensionMaster.findAll", query = "SELECT p FROM PsnEmployeepensionMaster p"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByPsnEmployeepensionMasterid", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.psnEmployeepensionMasterid = :psnEmployeepensionMasterid"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByEmployeecode", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.employeecode = :employeecode"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByPpono", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.ppono = :ppono"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByFirstname", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.firstname = :firstname"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByMiddlename", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.middlename = :middlename"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByLastname", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.lastname = :lastname"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByFathername", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.fathername = :fathername"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByDateofbirth", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.dateofbirth = :dateofbirth"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByAddress", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.address = :address"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByLastdesignation", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.lastdesignation = :lastdesignation"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByLastoffice", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.lastoffice = :lastoffice"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByDateofretirement", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.dateofretirement = :dateofretirement"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByDateofdeath", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.dateofdeath = :dateofdeath"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByRmOfficeid", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByIsdirectentry", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.isdirectentry = :isdirectentry"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByJoiningdate", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.joiningdate = :joiningdate"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByEntryOfficeid", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.entryOfficeid = :entryOfficeid"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByEditdate", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.editdate = :editdate"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByClerkid", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.clerkid = :clerkid"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByHeight", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.height = :height"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByIdentificationmark", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.identificationmark = :identificationmark"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByDesignationofofficehead", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.designationofofficehead = :designationofofficehead"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByAvailableinpis", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.availableinpis = :availableinpis"),
		@NamedQuery(name = "PsnEmployeepensionMaster.findByStatus", query = "SELECT p FROM PsnEmployeepensionMaster p WHERE p.status = :status") })
public class PsnEmployeepensionMaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PSN_EMPLOYEEPENSION_MASTERID")
	private Long psnEmployeepensionMasterid;
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "PPONO")
	private String ppono;
	@Basic(optional = false)
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "MIDDLENAME")
	private String middlename;
	@Column(name = "LASTNAME")
	private String lastname;
	@Basic(optional = false)
	@Column(name = "FATHERNAME")
	private String fathername;
	@Column(name = "DATEOFBIRTH")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofbirth;
	@Basic(optional = false)
	@Column(name = "ADDRESS")
	private String address;
	@Basic(optional = false)
	@Column(name = "LASTDESIGNATION")
	private String lastdesignation;
	@Basic(optional = false)
	@Column(name = "LASTOFFICE")
	private String lastoffice;
	@Column(name = "DATEOFRETIREMENT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofretirement;
	@Column(name = "DATEOFDEATH")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofdeath;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Basic(optional = false)
	@Column(name = "ISDIRECTENTRY")
	private Character isdirectentry;
	@Column(name = "JOININGDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date joiningdate;
	@Column(name = "ENTRY_OFFICEID")
	private Integer entryOfficeid;
	@Basic(optional = false)
	@Column(name = "EDITDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date editdate;
	@Column(name = "CLERKID")
	private String clerkid;
	@Column(name = "HEIGHT")
	private String height;
	@Column(name = "IDENTIFICATIONMARK")
	private String identificationmark;
	@Column(name = "DESIGNATIONOFOFFICEHEAD")
	private String designationofofficehead;
	@Basic(optional = false)
	@Column(name = "AVAILABLEINPIS")
	private Character availableinpis;
	@Basic(optional = false)
	@Column(name = "STATUS")
	private String status;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "psnEmployeepensionMasterid")
	private Collection<PsnPensiondetail> psnPensiondetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "psnEmployeepensionMasterid")
	private Collection<PsnFamilydetail> psnFamilydetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "psnEmployeepensionMasterid")
	private Collection<PsnMonthlypay> psnMonthlypayCollection;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "psnEmployeepensionMasterid")
	private PsnLifecertificate psnLifecertificate;
	@OneToMany(mappedBy = "psnEmployeepensionMasterid")
	private Collection<PsnSanctionpension> psnSanctionpensionCollection;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "psnEmployeepensionMasterid")
	private PsnFamilypensionMaster psnFamilypensionMaster;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "psnEmployeepensionMasterid")
	private Collection<PsnNomineedetail> psnNomineedetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "psnEmployeepensionMasterid")
	private Collection<PsnPaymentdetail> psnPaymentdetailCollection;

	public PsnEmployeepensionMaster() {
	}

	public PsnEmployeepensionMaster(Long psnEmployeepensionMasterid) {
		this.psnEmployeepensionMasterid = psnEmployeepensionMasterid;
	}

	public PsnEmployeepensionMaster(Long psnEmployeepensionMasterid, String firstname, String fathername,
			String address, String lastdesignation, String lastoffice, int rmOfficeid, Character isdirectentry,
			Date editdate, Character availableinpis, String status) {
		this.psnEmployeepensionMasterid = psnEmployeepensionMasterid;
		this.firstname = firstname;
		this.fathername = fathername;
		this.address = address;
		this.lastdesignation = lastdesignation;
		this.lastoffice = lastoffice;
		this.rmOfficeid = rmOfficeid;
		this.isdirectentry = isdirectentry;
		this.editdate = editdate;
		this.availableinpis = availableinpis;
		this.status = status;
	}

	public Long getPsnEmployeepensionMasterid() {
		return psnEmployeepensionMasterid;
	}

	public void setPsnEmployeepensionMasterid(Long psnEmployeepensionMasterid) {
		this.psnEmployeepensionMasterid = psnEmployeepensionMasterid;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getPpono() {
		return ppono;
	}

	public void setPpono(String ppono) {
		this.ppono = ppono;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLastdesignation() {
		return lastdesignation;
	}

	public void setLastdesignation(String lastdesignation) {
		this.lastdesignation = lastdesignation;
	}

	public String getLastoffice() {
		return lastoffice;
	}

	public void setLastoffice(String lastoffice) {
		this.lastoffice = lastoffice;
	}

	public Date getDateofretirement() {
		return dateofretirement;
	}

	public void setDateofretirement(Date dateofretirement) {
		this.dateofretirement = dateofretirement;
	}

	public Date getDateofdeath() {
		return dateofdeath;
	}

	public void setDateofdeath(Date dateofdeath) {
		this.dateofdeath = dateofdeath;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Character getIsdirectentry() {
		return isdirectentry;
	}

	public void setIsdirectentry(Character isdirectentry) {
		this.isdirectentry = isdirectentry;
	}

	public Date getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	public Integer getEntryOfficeid() {
		return entryOfficeid;
	}

	public void setEntryOfficeid(Integer entryOfficeid) {
		this.entryOfficeid = entryOfficeid;
	}

	public Date getEditdate() {
		return editdate;
	}

	public void setEditdate(Date editdate) {
		this.editdate = editdate;
	}

	public String getClerkid() {
		return clerkid;
	}

	public void setClerkid(String clerkid) {
		this.clerkid = clerkid;
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

	public Character getAvailableinpis() {
		return availableinpis;
	}

	public void setAvailableinpis(Character availableinpis) {
		this.availableinpis = availableinpis;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlTransient
	public Collection<PsnPensiondetail> getPsnPensiondetailCollection() {
		return psnPensiondetailCollection;
	}

	public void setPsnPensiondetailCollection(Collection<PsnPensiondetail> psnPensiondetailCollection) {
		this.psnPensiondetailCollection = psnPensiondetailCollection;
	}

	@XmlTransient
	public Collection<PsnFamilydetail> getPsnFamilydetailCollection() {
		return psnFamilydetailCollection;
	}

	public void setPsnFamilydetailCollection(Collection<PsnFamilydetail> psnFamilydetailCollection) {
		this.psnFamilydetailCollection = psnFamilydetailCollection;
	}

	@XmlTransient
	public Collection<PsnMonthlypay> getPsnMonthlypayCollection() {
		return psnMonthlypayCollection;
	}

	public void setPsnMonthlypayCollection(Collection<PsnMonthlypay> psnMonthlypayCollection) {
		this.psnMonthlypayCollection = psnMonthlypayCollection;
	}

	public PsnLifecertificate getPsnLifecertificate() {
		return psnLifecertificate;
	}

	public void setPsnLifecertificate(PsnLifecertificate psnLifecertificate) {
		this.psnLifecertificate = psnLifecertificate;
	}

	@XmlTransient
	public Collection<PsnSanctionpension> getPsnSanctionpensionCollection() {
		return psnSanctionpensionCollection;
	}

	public void setPsnSanctionpensionCollection(Collection<PsnSanctionpension> psnSanctionpensionCollection) {
		this.psnSanctionpensionCollection = psnSanctionpensionCollection;
	}

	public PsnFamilypensionMaster getPsnFamilypensionMaster() {
		return psnFamilypensionMaster;
	}

	public void setPsnFamilypensionMaster(PsnFamilypensionMaster psnFamilypensionMaster) {
		this.psnFamilypensionMaster = psnFamilypensionMaster;
	}

	@XmlTransient
	public Collection<PsnNomineedetail> getPsnNomineedetailCollection() {
		return psnNomineedetailCollection;
	}

	public void setPsnNomineedetailCollection(Collection<PsnNomineedetail> psnNomineedetailCollection) {
		this.psnNomineedetailCollection = psnNomineedetailCollection;
	}

	@XmlTransient
	public Collection<PsnPaymentdetail> getPsnPaymentdetailCollection() {
		return psnPaymentdetailCollection;
	}

	public void setPsnPaymentdetailCollection(Collection<PsnPaymentdetail> psnPaymentdetailCollection) {
		this.psnPaymentdetailCollection = psnPaymentdetailCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (psnEmployeepensionMasterid != null ? psnEmployeepensionMasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PsnEmployeepensionMaster)) {
			return false;
		}
		PsnEmployeepensionMaster other = (PsnEmployeepensionMaster) object;
		if ((this.psnEmployeepensionMasterid == null && other.psnEmployeepensionMasterid != null)
				|| (this.psnEmployeepensionMasterid != null
						&& !this.psnEmployeepensionMasterid.equals(other.psnEmployeepensionMasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PsnEmployeepensionMaster[ psnEmployeepensionMasterid=" + psnEmployeepensionMasterid
				+ " ]";
	}

}
