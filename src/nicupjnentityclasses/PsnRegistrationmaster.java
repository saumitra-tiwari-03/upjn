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
@Table(name = "PSN_REGISTRATIONMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PsnRegistrationmaster.findAll", query = "SELECT p FROM PsnRegistrationmaster p"),
		@NamedQuery(name = "PsnRegistrationmaster.findByPrepsnRegistrationmasterid", query = "SELECT p FROM PsnRegistrationmaster p WHERE p.prepsnRegistrationmasterid = :prepsnRegistrationmasterid"),
		@NamedQuery(name = "PsnRegistrationmaster.findByEmployeecode", query = "SELECT p FROM PsnRegistrationmaster p WHERE p.employeecode = :employeecode"),
		@NamedQuery(name = "PsnRegistrationmaster.findByApplname", query = "SELECT p FROM PsnRegistrationmaster p WHERE p.applname = :applname"),
		@NamedQuery(name = "PsnRegistrationmaster.findByEmployeename", query = "SELECT p FROM PsnRegistrationmaster p WHERE p.employeename = :employeename"),
		@NamedQuery(name = "PsnRegistrationmaster.findByFathername", query = "SELECT p FROM PsnRegistrationmaster p WHERE p.fathername = :fathername"),
		@NamedQuery(name = "PsnRegistrationmaster.findByDateofbirth", query = "SELECT p FROM PsnRegistrationmaster p WHERE p.dateofbirth = :dateofbirth"),
		@NamedQuery(name = "PsnRegistrationmaster.findByAddress", query = "SELECT p FROM PsnRegistrationmaster p WHERE p.address = :address"),
		@NamedQuery(name = "PsnRegistrationmaster.findByDateofretirement", query = "SELECT p FROM PsnRegistrationmaster p WHERE p.dateofretirement = :dateofretirement"),
		@NamedQuery(name = "PsnRegistrationmaster.findByRmOfficeid", query = "SELECT p FROM PsnRegistrationmaster p WHERE p.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "PsnRegistrationmaster.findByGratuity", query = "SELECT p FROM PsnRegistrationmaster p WHERE p.gratuity = :gratuity"),
		@NamedQuery(name = "PsnRegistrationmaster.findByDateoflistreceived", query = "SELECT p FROM PsnRegistrationmaster p WHERE p.dateoflistreceived = :dateoflistreceived"),
		@NamedQuery(name = "PsnRegistrationmaster.findByOfficeheaddesignation", query = "SELECT p FROM PsnRegistrationmaster p WHERE p.officeheaddesignation = :officeheaddesignation"),
		@NamedQuery(name = "PsnRegistrationmaster.findByOffaddress", query = "SELECT p FROM PsnRegistrationmaster p WHERE p.offaddress = :offaddress"),
		@NamedQuery(name = "PsnRegistrationmaster.findByPenaddress", query = "SELECT p FROM PsnRegistrationmaster p WHERE p.penaddress = :penaddress"),
		@NamedQuery(name = "PsnRegistrationmaster.findByPensionersigningdate", query = "SELECT p FROM PsnRegistrationmaster p WHERE p.pensionersigningdate = :pensionersigningdate"),
		@NamedQuery(name = "PsnRegistrationmaster.findByJoiningdate", query = "SELECT p FROM PsnRegistrationmaster p WHERE p.joiningdate = :joiningdate") })
public class PsnRegistrationmaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PREPSN_REGISTRATIONMASTERID")
	private Long prepsnRegistrationmasterid;
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "APPLNAME")
	private String applname;
	@Basic(optional = false)
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "FATHERNAME")
	private String fathername;
	@Column(name = "DATEOFBIRTH")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofbirth;
	@Basic(optional = false)
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "DATEOFRETIREMENT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofretirement;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Column(name = "GRATUITY")
	private String gratuity;
	@Column(name = "DATEOFLISTRECEIVED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateoflistreceived;
	@Column(name = "OFFICEHEADDESIGNATION")
	private String officeheaddesignation;
	@Column(name = "OFFADDRESS")
	private String offaddress;
	@Column(name = "PENADDRESS")
	private String penaddress;
	@Column(name = "PENSIONERSIGNINGDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date pensionersigningdate;
	@Column(name = "JOININGDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date joiningdate;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prepsnRegistrationmasterid")
	private Collection<PrepsnFamilydetail> prepsnFamilydetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prepsnRegistrationmasterid")
	private Collection<PrepsnEmployeeobjection> prepsnEmployeeobjectionCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prepsnRegistrationmasterid")
	private Collection<PrepsnServicedetail> prepsnServicedetailCollection;

	public PsnRegistrationmaster() {
	}

	public PsnRegistrationmaster(Long prepsnRegistrationmasterid) {
		this.prepsnRegistrationmasterid = prepsnRegistrationmasterid;
	}

	public PsnRegistrationmaster(Long prepsnRegistrationmasterid, String employeename, String fathername,
			String address, int rmOfficeid) {
		this.prepsnRegistrationmasterid = prepsnRegistrationmasterid;
		this.employeename = employeename;
		this.fathername = fathername;
		this.address = address;
		this.rmOfficeid = rmOfficeid;
	}

	public Long getPrepsnRegistrationmasterid() {
		return prepsnRegistrationmasterid;
	}

	public void setPrepsnRegistrationmasterid(Long prepsnRegistrationmasterid) {
		this.prepsnRegistrationmasterid = prepsnRegistrationmasterid;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getApplname() {
		return applname;
	}

	public void setApplname(String applname) {
		this.applname = applname;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
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

	public Date getDateofretirement() {
		return dateofretirement;
	}

	public void setDateofretirement(Date dateofretirement) {
		this.dateofretirement = dateofretirement;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getGratuity() {
		return gratuity;
	}

	public void setGratuity(String gratuity) {
		this.gratuity = gratuity;
	}

	public Date getDateoflistreceived() {
		return dateoflistreceived;
	}

	public void setDateoflistreceived(Date dateoflistreceived) {
		this.dateoflistreceived = dateoflistreceived;
	}

	public String getOfficeheaddesignation() {
		return officeheaddesignation;
	}

	public void setOfficeheaddesignation(String officeheaddesignation) {
		this.officeheaddesignation = officeheaddesignation;
	}

	public String getOffaddress() {
		return offaddress;
	}

	public void setOffaddress(String offaddress) {
		this.offaddress = offaddress;
	}

	public String getPenaddress() {
		return penaddress;
	}

	public void setPenaddress(String penaddress) {
		this.penaddress = penaddress;
	}

	public Date getPensionersigningdate() {
		return pensionersigningdate;
	}

	public void setPensionersigningdate(Date pensionersigningdate) {
		this.pensionersigningdate = pensionersigningdate;
	}

	public Date getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	@XmlTransient
	public Collection<PrepsnFamilydetail> getPrepsnFamilydetailCollection() {
		return prepsnFamilydetailCollection;
	}

	public void setPrepsnFamilydetailCollection(Collection<PrepsnFamilydetail> prepsnFamilydetailCollection) {
		this.prepsnFamilydetailCollection = prepsnFamilydetailCollection;
	}

	@XmlTransient
	public Collection<PrepsnEmployeeobjection> getPrepsnEmployeeobjectionCollection() {
		return prepsnEmployeeobjectionCollection;
	}

	public void setPrepsnEmployeeobjectionCollection(
			Collection<PrepsnEmployeeobjection> prepsnEmployeeobjectionCollection) {
		this.prepsnEmployeeobjectionCollection = prepsnEmployeeobjectionCollection;
	}

	@XmlTransient
	public Collection<PrepsnServicedetail> getPrepsnServicedetailCollection() {
		return prepsnServicedetailCollection;
	}

	public void setPrepsnServicedetailCollection(Collection<PrepsnServicedetail> prepsnServicedetailCollection) {
		this.prepsnServicedetailCollection = prepsnServicedetailCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (prepsnRegistrationmasterid != null ? prepsnRegistrationmasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PsnRegistrationmaster)) {
			return false;
		}
		PsnRegistrationmaster other = (PsnRegistrationmaster) object;
		if ((this.prepsnRegistrationmasterid == null && other.prepsnRegistrationmasterid != null)
				|| (this.prepsnRegistrationmasterid != null
						&& !this.prepsnRegistrationmasterid.equals(other.prepsnRegistrationmasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PsnRegistrationmaster[ prepsnRegistrationmasterid=" + prepsnRegistrationmasterid
				+ " ]";
	}

}
