/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.mapping.Collection;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_EMPLOYEEMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpEmployeemaster.findAll", query = "SELECT p FROM PpEmployeemaster p"),
		@NamedQuery(name = "PpEmployeemaster.findByPpEmployeemasterid", query = "SELECT p FROM PpEmployeemaster p WHERE p.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "PpEmployeemaster.findByEmployeecode", query = "SELECT p FROM PpEmployeemaster p WHERE p.employeecode = :employeecode"),
		@NamedQuery(name = "PpEmployeemaster.findByFirstname", query = "SELECT p FROM PpEmployeemaster p WHERE p.firstname = :firstname"),
		@NamedQuery(name = "PpEmployeemaster.findByMiddlename", query = "SELECT p FROM PpEmployeemaster p WHERE p.middlename = :middlename"),
		@NamedQuery(name = "PpEmployeemaster.findByLastname", query = "SELECT p FROM PpEmployeemaster p WHERE p.lastname = :lastname"),
		@NamedQuery(name = "PpEmployeemaster.findByPassword", query = "SELECT p FROM PpEmployeemaster p WHERE p.password = :password"),
		@NamedQuery(name = "PpEmployeemaster.findByPpDesignationmasterid", query = "SELECT p FROM PpEmployeemaster p WHERE p.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "PpEmployeemaster.findByIsdisablefinancial", query = "SELECT p FROM PpEmployeemaster p WHERE p.isdisablefinancial = :isdisablefinancial"),
		@NamedQuery(name = "PpEmployeemaster.findByIsretired", query = "SELECT p FROM PpEmployeemaster p WHERE p.isretired = :isretired"),
		@NamedQuery(name = "PpEmployeemaster.findByIsfunctioning", query = "SELECT p FROM PpEmployeemaster p WHERE p.isfunctioning = :isfunctioning"),
		@NamedQuery(name = "PpEmployeemaster.findByEntryOfficeid", query = "SELECT p FROM PpEmployeemaster p WHERE p.entryOfficeid = :entryOfficeid"),
		@NamedQuery(name = "PpEmployeemaster.findByIsloginlocked", query = "SELECT p FROM PpEmployeemaster p WHERE p.isloginlocked = :isloginlocked"),
		@NamedQuery(name = "PpEmployeemaster.findByLastLoginDate", query = "SELECT p FROM PpEmployeemaster p WHERE p.lastLoginDate = :lastLoginDate") })
public class PpEmployeemaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Basic(optional = false)
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "MIDDLENAME")
	private String middlename;
	@Column(name = "LASTNAME")
	private String lastname;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Integer ppDesignationmasterid;
	@Basic(optional = false)
	@Column(name = "ISDISABLEFINANCIAL")
	private Character isdisablefinancial;
	@Basic(optional = false)
	@Column(name = "ISRETIRED")
	private Character isretired;
	@Basic(optional = false)
	@Column(name = "ISFUNCTIONING")
	private Character isfunctioning;
	@Column(name = "ENTRY_OFFICEID")
	private Long entryOfficeid;
	@Basic(optional = false)
	@Column(name = "ISLOGINLOCKED")
	private Character isloginlocked;
	@Column(name = "LAST_LOGIN_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginDate;
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpDeputationdetail> ppDeputationdetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<ViewRmGetofficeadmin> viewRmGetofficeadminCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<ViewNominationDate> viewNominationDateCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpDeptenquiry> ppDeptenquiryCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpEmployeetraining> ppEmployeetrainingCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpIncrementdetail> ppIncrementdetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpLoandetail> ppLoandetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpAdverseentry> ppAdverseentryCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpTerminationdetail> ppTerminationdetailCollection;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private PpEmployeedetail ppEmployeedetail;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<RmLoginrole> rmLoginroleCollection;
	@JoinColumn(name = "MAS_EMPLOYMENTSUBTYPEID", referencedColumnName = "MAS_EMPLOYMENTSUBTYPEID")
	@ManyToOne
	private MasEmploymentsubtype masEmploymentsubtypeid;
	@JoinColumn(name = "RM_OFFICEID", referencedColumnName = "RM_OFFICEID")
	@ManyToOne
	private RmOffice rmOfficeid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpSuspensiondetail> ppSuspensiondetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpAvailedleavedetail> ppAvailedleavedetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpEmployeepersonaldetail> ppEmployeepersonaldetailCollection;
	@OneToMany(mappedBy = "ppEmployeemasterid")
	private Collection<PpEmployeeEldetail> ppEmployeeEldetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpEmployeequalification> ppEmployeequalificationCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<ViewGetempnoduesdetail> viewGetempnoduesdetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpEmployeeappointmentdetail> ppEmployeeappointmentdetailCollection;
	@OneToMany(mappedBy = "ppEmployeemasterid")
	private Collection<ViewRmGetlinksfortree1> viewRmGetlinksfortree1Collection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpTransferdetail> ppTransferdetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpPostingdetail> ppPostingdetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpLeaveaccount> ppLeaveaccountCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpRelievefromservice> ppRelievefromserviceCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpNoduesdetail> ppNoduesdetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpEmployeeacrstatus> ppEmployeeacrstatusCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpExitdetail> ppExitdetailCollection;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private PpCurrentstatus ppCurrentstatus;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpLpcdetail> ppLpcdetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ppEmployeemasterid")
	private Collection<PpEmpalwcontroller> ppEmpalwcontrollerCollection;
*/
	public PpEmployeemaster() {
	}

	public PpEmployeemaster(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public PpEmployeemaster(Long ppEmployeemasterid, String employeecode, String firstname,
			Character isdisablefinancial, Character isretired, Character isfunctioning, Character isloginlocked) {
		this.ppEmployeemasterid = ppEmployeemasterid;
		this.employeecode = employeecode;
		this.firstname = firstname;
		this.isdisablefinancial = isdisablefinancial;
		this.isretired = isretired;
		this.isfunctioning = isfunctioning;
		this.isloginlocked = isloginlocked;
	}

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(Integer ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public Character getIsdisablefinancial() {
		return isdisablefinancial;
	}

	public void setIsdisablefinancial(Character isdisablefinancial) {
		this.isdisablefinancial = isdisablefinancial;
	}

	public Character getIsretired() {
		return isretired;
	}

	public void setIsretired(Character isretired) {
		this.isretired = isretired;
	}

	public Character getIsfunctioning() {
		return isfunctioning;
	}

	public void setIsfunctioning(Character isfunctioning) {
		this.isfunctioning = isfunctioning;
	}

	public Long getEntryOfficeid() {
		return entryOfficeid;
	}

	public void setEntryOfficeid(Long entryOfficeid) {
		this.entryOfficeid = entryOfficeid;
	}

	public Character getIsloginlocked() {
		return isloginlocked;
	}

	public void setIsloginlocked(Character isloginlocked) {
		this.isloginlocked = isloginlocked;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
/*
	@XmlTransient
	public Collection<PpDeputationdetail> getPpDeputationdetailCollection() {
		return ppDeputationdetailCollection;
	}

	public void setPpDeputationdetailCollection(Collection<PpDeputationdetail> ppDeputationdetailCollection) {
		this.ppDeputationdetailCollection = ppDeputationdetailCollection;
	}

	@XmlTransient
	public Collection<ViewRmGetofficeadmin> getViewRmGetofficeadminCollection() {
		return viewRmGetofficeadminCollection;
	}

	public void setViewRmGetofficeadminCollection(Collection<ViewRmGetofficeadmin> viewRmGetofficeadminCollection) {
		this.viewRmGetofficeadminCollection = viewRmGetofficeadminCollection;
	}

	@XmlTransient
	public Collection<ViewNominationDate> getViewNominationDateCollection() {
		return viewNominationDateCollection;
	}

	public void setViewNominationDateCollection(Collection<ViewNominationDate> viewNominationDateCollection) {
		this.viewNominationDateCollection = viewNominationDateCollection;
	}

	@XmlTransient
	public Collection<PpDeptenquiry> getPpDeptenquiryCollection() {
		return ppDeptenquiryCollection;
	}

	public void setPpDeptenquiryCollection(Collection<PpDeptenquiry> ppDeptenquiryCollection) {
		this.ppDeptenquiryCollection = ppDeptenquiryCollection;
	}

	@XmlTransient
	public Collection<PpEmployeetraining> getPpEmployeetrainingCollection() {
		return ppEmployeetrainingCollection;
	}

	public void setPpEmployeetrainingCollection(Collection<PpEmployeetraining> ppEmployeetrainingCollection) {
		this.ppEmployeetrainingCollection = ppEmployeetrainingCollection;
	}

	@XmlTransient
	public Collection<PpIncrementdetail> getPpIncrementdetailCollection() {
		return ppIncrementdetailCollection;
	}

	public void setPpIncrementdetailCollection(Collection<PpIncrementdetail> ppIncrementdetailCollection) {
		this.ppIncrementdetailCollection = ppIncrementdetailCollection;
	}

	@XmlTransient
	public Collection<PpLoandetail> getPpLoandetailCollection() {
		return ppLoandetailCollection;
	}

	public void setPpLoandetailCollection(Collection<PpLoandetail> ppLoandetailCollection) {
		this.ppLoandetailCollection = ppLoandetailCollection;
	}

	@XmlTransient
	public Collection<PpAdverseentry> getPpAdverseentryCollection() {
		return ppAdverseentryCollection;
	}

	public void setPpAdverseentryCollection(Collection<PpAdverseentry> ppAdverseentryCollection) {
		this.ppAdverseentryCollection = ppAdverseentryCollection;
	}

	@XmlTransient
	public Collection<PpTerminationdetail> getPpTerminationdetailCollection() {
		return ppTerminationdetailCollection;
	}

	public void setPpTerminationdetailCollection(Collection<PpTerminationdetail> ppTerminationdetailCollection) {
		this.ppTerminationdetailCollection = ppTerminationdetailCollection;
	}

	public PpEmployeedetail getPpEmployeedetail() {
		return ppEmployeedetail;
	}

	public void setPpEmployeedetail(PpEmployeedetail ppEmployeedetail) {
		this.ppEmployeedetail = ppEmployeedetail;
	}

	@XmlTransient
	public Collection<RmLoginrole> getRmLoginroleCollection() {
		return rmLoginroleCollection;
	}

	public void setRmLoginroleCollection(Collection<RmLoginrole> rmLoginroleCollection) {
		this.rmLoginroleCollection = rmLoginroleCollection;
	}

	public MasEmploymentsubtype getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(MasEmploymentsubtype masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public RmOffice getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(RmOffice rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	@XmlTransient
	public Collection<PpSuspensiondetail> getPpSuspensiondetailCollection() {
		return ppSuspensiondetailCollection;
	}

	public void setPpSuspensiondetailCollection(Collection<PpSuspensiondetail> ppSuspensiondetailCollection) {
		this.ppSuspensiondetailCollection = ppSuspensiondetailCollection;
	}

	@XmlTransient
	public Collection<PpAvailedleavedetail> getPpAvailedleavedetailCollection() {
		return ppAvailedleavedetailCollection;
	}

	public void setPpAvailedleavedetailCollection(Collection<PpAvailedleavedetail> ppAvailedleavedetailCollection) {
		this.ppAvailedleavedetailCollection = ppAvailedleavedetailCollection;
	}

	@XmlTransient
	public Collection<PpEmployeepersonaldetail> getPpEmployeepersonaldetailCollection() {
		return ppEmployeepersonaldetailCollection;
	}

	public void setPpEmployeepersonaldetailCollection(
			Collection<PpEmployeepersonaldetail> ppEmployeepersonaldetailCollection) {
		this.ppEmployeepersonaldetailCollection = ppEmployeepersonaldetailCollection;
	}

	@XmlTransient
	public Collection<PpEmployeeEldetail> getPpEmployeeEldetailCollection() {
		return ppEmployeeEldetailCollection;
	}

	public void setPpEmployeeEldetailCollection(Collection<PpEmployeeEldetail> ppEmployeeEldetailCollection) {
		this.ppEmployeeEldetailCollection = ppEmployeeEldetailCollection;
	}

	@XmlTransient
	public Collection<PpEmployeequalification> getPpEmployeequalificationCollection() {
		return ppEmployeequalificationCollection;
	}

	public void setPpEmployeequalificationCollection(
			Collection<PpEmployeequalification> ppEmployeequalificationCollection) {
		this.ppEmployeequalificationCollection = ppEmployeequalificationCollection;
	}

	@XmlTransient
	public Collection<ViewGetempnoduesdetail> getViewGetempnoduesdetailCollection() {
		return viewGetempnoduesdetailCollection;
	}

	public void setViewGetempnoduesdetailCollection(
			Collection<ViewGetempnoduesdetail> viewGetempnoduesdetailCollection) {
		this.viewGetempnoduesdetailCollection = viewGetempnoduesdetailCollection;
	}

	@XmlTransient
	public Collection<PpEmployeeappointmentdetail> getPpEmployeeappointmentdetailCollection() {
		return ppEmployeeappointmentdetailCollection;
	}

	public void setPpEmployeeappointmentdetailCollection(
			Collection<PpEmployeeappointmentdetail> ppEmployeeappointmentdetailCollection) {
		this.ppEmployeeappointmentdetailCollection = ppEmployeeappointmentdetailCollection;
	}

	@XmlTransient
	public Collection<ViewRmGetlinksfortree1> getViewRmGetlinksfortree1Collection() {
		return viewRmGetlinksfortree1Collection;
	}

	public void setViewRmGetlinksfortree1Collection(
			Collection<ViewRmGetlinksfortree1> viewRmGetlinksfortree1Collection) {
		this.viewRmGetlinksfortree1Collection = viewRmGetlinksfortree1Collection;
	}

	@XmlTransient
	public Collection<PpTransferdetail> getPpTransferdetailCollection() {
		return ppTransferdetailCollection;
	}

	public void setPpTransferdetailCollection(Collection<PpTransferdetail> ppTransferdetailCollection) {
		this.ppTransferdetailCollection = ppTransferdetailCollection;
	}

	@XmlTransient
	public Collection<PpPostingdetail> getPpPostingdetailCollection() {
		return ppPostingdetailCollection;
	}

	public void setPpPostingdetailCollection(Collection<PpPostingdetail> ppPostingdetailCollection) {
		this.ppPostingdetailCollection = ppPostingdetailCollection;
	}

	@XmlTransient
	public Collection<PpLeaveaccount> getPpLeaveaccountCollection() {
		return ppLeaveaccountCollection;
	}

	public void setPpLeaveaccountCollection(Collection<PpLeaveaccount> ppLeaveaccountCollection) {
		this.ppLeaveaccountCollection = ppLeaveaccountCollection;
	}

	@XmlTransient
	public Collection<PpRelievefromservice> getPpRelievefromserviceCollection() {
		return ppRelievefromserviceCollection;
	}

	public void setPpRelievefromserviceCollection(Collection<PpRelievefromservice> ppRelievefromserviceCollection) {
		this.ppRelievefromserviceCollection = ppRelievefromserviceCollection;
	}

	@XmlTransient
	public Collection<PpNoduesdetail> getPpNoduesdetailCollection() {
		return ppNoduesdetailCollection;
	}

	public void setPpNoduesdetailCollection(Collection<PpNoduesdetail> ppNoduesdetailCollection) {
		this.ppNoduesdetailCollection = ppNoduesdetailCollection;
	}

	@XmlTransient
	public Collection<PpEmployeeacrstatus> getPpEmployeeacrstatusCollection() {
		return ppEmployeeacrstatusCollection;
	}

	public void setPpEmployeeacrstatusCollection(Collection<PpEmployeeacrstatus> ppEmployeeacrstatusCollection) {
		this.ppEmployeeacrstatusCollection = ppEmployeeacrstatusCollection;
	}

	@XmlTransient
	public Collection<PpExitdetail> getPpExitdetailCollection() {
		return ppExitdetailCollection;
	}

	public void setPpExitdetailCollection(Collection<PpExitdetail> ppExitdetailCollection) {
		this.ppExitdetailCollection = ppExitdetailCollection;
	}

	public PpCurrentstatus getPpCurrentstatus() {
		return ppCurrentstatus;
	}

	public void setPpCurrentstatus(PpCurrentstatus ppCurrentstatus) {
		this.ppCurrentstatus = ppCurrentstatus;
	}

	@XmlTransient
	public Collection<PpLpcdetail> getPpLpcdetailCollection() {
		return ppLpcdetailCollection;
	}

	public void setPpLpcdetailCollection(Collection<PpLpcdetail> ppLpcdetailCollection) {
		this.ppLpcdetailCollection = ppLpcdetailCollection;
	}

	@XmlTransient
	public Collection<PpEmpalwcontroller> getPpEmpalwcontrollerCollection() {
		return ppEmpalwcontrollerCollection;
	}

	public void setPpEmpalwcontrollerCollection(Collection<PpEmpalwcontroller> ppEmpalwcontrollerCollection) {
		this.ppEmpalwcontrollerCollection = ppEmpalwcontrollerCollection;
	}

*/	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppEmployeemasterid != null ? ppEmployeemasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpEmployeemaster)) {
			return false;
		}
		PpEmployeemaster other = (PpEmployeemaster) object;
		if ((this.ppEmployeemasterid == null && other.ppEmployeemasterid != null)
				|| (this.ppEmployeemasterid != null && !this.ppEmployeemasterid.equals(other.ppEmployeemasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpEmployeemaster[ ppEmployeemasterid=" + ppEmployeemasterid + " ]";
	}

}
