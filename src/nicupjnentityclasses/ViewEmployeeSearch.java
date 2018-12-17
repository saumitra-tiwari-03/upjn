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
@Table(name = "VIEW_EMPLOYEE_SEARCH")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewEmployeeSearch.findAll", query = "SELECT v FROM ViewEmployeeSearch v"),
		@NamedQuery(name = "ViewEmployeeSearch.findByPpEmployeemasterid", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewEmployeeSearch.findByEmployeecode", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEmployeeSearch.findByFirstname", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.firstname = :firstname"),
		@NamedQuery(name = "ViewEmployeeSearch.findByLastname", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.lastname = :lastname"),
		@NamedQuery(name = "ViewEmployeeSearch.findByRmOfficeid", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewEmployeeSearch.findByEmployeename", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEmployeeSearch.findByIsfunctioning", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.isfunctioning = :isfunctioning"),
		@NamedQuery(name = "ViewEmployeeSearch.findByIsretired", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.isretired = :isretired"),
		@NamedQuery(name = "ViewEmployeeSearch.findByEntryOfficeid", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.entryOfficeid = :entryOfficeid"),
		@NamedQuery(name = "ViewEmployeeSearch.findByPpDesignationmasterid", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "ViewEmployeeSearch.findByDesignation", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewEmployeeSearch.findByEmploymenttype", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewEmployeeSearch.findByMasEmploymenttypeid", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.masEmploymenttypeid = :masEmploymenttypeid"),
		@NamedQuery(name = "ViewEmployeeSearch.findByEmploymentsubtype", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.employmentsubtype = :employmentsubtype"),
		@NamedQuery(name = "ViewEmployeeSearch.findByMasEmploymentsubtypeid", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.masEmploymentsubtypeid = :masEmploymentsubtypeid"),
		@NamedQuery(name = "ViewEmployeeSearch.findByPlaceofposting", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.placeofposting = :placeofposting"),
		@NamedQuery(name = "ViewEmployeeSearch.findByPpPlacemasterid", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.ppPlacemasterid = :ppPlacemasterid"),
		@NamedQuery(name = "ViewEmployeeSearch.findByPpCurrentstatusid", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.ppCurrentstatusid = :ppCurrentstatusid"),
		@NamedQuery(name = "ViewEmployeeSearch.findByGpfacno", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.gpfacno = :gpfacno"),
		@NamedQuery(name = "ViewEmployeeSearch.findByPpPostingdetailid", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.ppPostingdetailid = :ppPostingdetailid"),
		@NamedQuery(name = "ViewEmployeeSearch.findByPpSuspensiondetailid", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.ppSuspensiondetailid = :ppSuspensiondetailid"),
		@NamedQuery(name = "ViewEmployeeSearch.findByPpExitdetailid", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.ppExitdetailid = :ppExitdetailid"),
		@NamedQuery(name = "ViewEmployeeSearch.findByPpDeputationdetailid", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.ppDeputationdetailid = :ppDeputationdetailid"),
		@NamedQuery(name = "ViewEmployeeSearch.findByJoindate", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.joindate = :joindate"),
		@NamedQuery(name = "ViewEmployeeSearch.findByServicephasename", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.servicephasename = :servicephasename"),
		@NamedQuery(name = "ViewEmployeeSearch.findBySubphasename", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.subphasename = :subphasename"),
		@NamedQuery(name = "ViewEmployeeSearch.findByOfficename", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.officename = :officename"),
		@NamedQuery(name = "ViewEmployeeSearch.findBySysPaycategoryid", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.sysPaycategoryid = :sysPaycategoryid"),
		@NamedQuery(name = "ViewEmployeeSearch.findByPpRegistermasterid", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.ppRegistermasterid = :ppRegistermasterid"),
		@NamedQuery(name = "ViewEmployeeSearch.findByEffectivedatjoin", query = "SELECT v FROM ViewEmployeeSearch v WHERE v.effectivedatjoin = :effectivedatjoin") })
public class ViewEmployeeSearch implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Basic(optional = false)
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "LASTNAME")
	private String lastname;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "ISFUNCTIONING")
	private Character isfunctioning;
	@Basic(optional = false)
	@Column(name = "ISRETIRED")
	private Character isretired;
	@Column(name = "ENTRY_OFFICEID")
	private Long entryOfficeid;
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Integer ppDesignationmasterid;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;
	@Basic(optional = false)
	@Column(name = "MAS_EMPLOYMENTTYPEID")
	private int masEmploymenttypeid;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTSUBTYPE")
	private String employmentsubtype;
	@Basic(optional = false)
	@Column(name = "MAS_EMPLOYMENTSUBTYPEID")
	private int masEmploymentsubtypeid;
	@Column(name = "PLACEOFPOSTING")
	private String placeofposting;
	@Column(name = "PP_PLACEMASTERID")
	private Long ppPlacemasterid;
	@Column(name = "PP_CURRENTSTATUSID")
	private String ppCurrentstatusid;
	@Column(name = "GPFACNO")
	private String gpfacno;
	@Basic(optional = false)
	@Column(name = "PP_POSTINGDETAILID")
	private long ppPostingdetailid;
	@Column(name = "PP_SUSPENSIONDETAILID")
	private Long ppSuspensiondetailid;
	@Column(name = "PP_EXITDETAILID")
	private Long ppExitdetailid;
	@Column(name = "PP_DEPUTATIONDETAILID")
	private Long ppDeputationdetailid;
	@Column(name = "JOINDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date joindate;
	@Basic(optional = false)
	@Column(name = "SERVICEPHASENAME")
	private String servicephasename;
	@Basic(optional = false)
	@Column(name = "SUBPHASENAME")
	private String subphasename;
	@Column(name = "OFFICENAME")
	private String officename;
	@Column(name = "SYS_PAYCATEGORYID")
	private Short sysPaycategoryid;
	@Column(name = "PP_REGISTERMASTERID")
	private Short ppRegistermasterid;
	@Column(name = "EFFECTIVEDATJOIN")
	private String effectivedatjoin;

	public ViewEmployeeSearch() {
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public Character getIsfunctioning() {
		return isfunctioning;
	}

	public void setIsfunctioning(Character isfunctioning) {
		this.isfunctioning = isfunctioning;
	}

	public Character getIsretired() {
		return isretired;
	}

	public void setIsretired(Character isretired) {
		this.isretired = isretired;
	}

	public Long getEntryOfficeid() {
		return entryOfficeid;
	}

	public void setEntryOfficeid(Long entryOfficeid) {
		this.entryOfficeid = entryOfficeid;
	}

	public Integer getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(Integer ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmploymenttype() {
		return employmenttype;
	}

	public void setEmploymenttype(String employmenttype) {
		this.employmenttype = employmenttype;
	}

	public int getMasEmploymenttypeid() {
		return masEmploymenttypeid;
	}

	public void setMasEmploymenttypeid(int masEmploymenttypeid) {
		this.masEmploymenttypeid = masEmploymenttypeid;
	}

	public String getEmploymentsubtype() {
		return employmentsubtype;
	}

	public void setEmploymentsubtype(String employmentsubtype) {
		this.employmentsubtype = employmentsubtype;
	}

	public int getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(int masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public String getPlaceofposting() {
		return placeofposting;
	}

	public void setPlaceofposting(String placeofposting) {
		this.placeofposting = placeofposting;
	}

	public Long getPpPlacemasterid() {
		return ppPlacemasterid;
	}

	public void setPpPlacemasterid(Long ppPlacemasterid) {
		this.ppPlacemasterid = ppPlacemasterid;
	}

	public String getPpCurrentstatusid() {
		return ppCurrentstatusid;
	}

	public void setPpCurrentstatusid(String ppCurrentstatusid) {
		this.ppCurrentstatusid = ppCurrentstatusid;
	}

	public String getGpfacno() {
		return gpfacno;
	}

	public void setGpfacno(String gpfacno) {
		this.gpfacno = gpfacno;
	}

	public long getPpPostingdetailid() {
		return ppPostingdetailid;
	}

	public void setPpPostingdetailid(long ppPostingdetailid) {
		this.ppPostingdetailid = ppPostingdetailid;
	}

	public Long getPpSuspensiondetailid() {
		return ppSuspensiondetailid;
	}

	public void setPpSuspensiondetailid(Long ppSuspensiondetailid) {
		this.ppSuspensiondetailid = ppSuspensiondetailid;
	}

	public Long getPpExitdetailid() {
		return ppExitdetailid;
	}

	public void setPpExitdetailid(Long ppExitdetailid) {
		this.ppExitdetailid = ppExitdetailid;
	}

	public Long getPpDeputationdetailid() {
		return ppDeputationdetailid;
	}

	public void setPpDeputationdetailid(Long ppDeputationdetailid) {
		this.ppDeputationdetailid = ppDeputationdetailid;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getServicephasename() {
		return servicephasename;
	}

	public void setServicephasename(String servicephasename) {
		this.servicephasename = servicephasename;
	}

	public String getSubphasename() {
		return subphasename;
	}

	public void setSubphasename(String subphasename) {
		this.subphasename = subphasename;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public Short getSysPaycategoryid() {
		return sysPaycategoryid;
	}

	public void setSysPaycategoryid(Short sysPaycategoryid) {
		this.sysPaycategoryid = sysPaycategoryid;
	}

	public Short getPpRegistermasterid() {
		return ppRegistermasterid;
	}

	public void setPpRegistermasterid(Short ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public String getEffectivedatjoin() {
		return effectivedatjoin;
	}

	public void setEffectivedatjoin(String effectivedatjoin) {
		this.effectivedatjoin = effectivedatjoin;
	}

}
