/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_PP_EMPPAYDETAIL_LIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpEmppaydetailList.findAll", query = "SELECT v FROM ViewPpEmppaydetailList v"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByFirstname", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.firstname = :firstname"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByLastname", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.lastname = :lastname"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByEmployeename", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByEmployeecode", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByEmploymenttype", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByRmOfficeid", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByIseditable", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.iseditable = :iseditable"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByPpDesignationmasterid", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByDesignation", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByPpSectionmasterid", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.ppSectionmasterid = :ppSectionmasterid"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findBySectionname", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.sectionname = :sectionname"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByPanno", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.panno = :panno"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findBySysPaymentmodeid", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.sysPaymentmodeid = :sysPaymentmodeid"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByPaymentmode", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.paymentmode = :paymentmode"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByIsfunctioning", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.isfunctioning = :isfunctioning"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByPpRegistermasterid", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.ppRegistermasterid = :ppRegistermasterid"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByMasEmploymentsubtypeid", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.masEmploymentsubtypeid = :masEmploymentsubtypeid"),
		@NamedQuery(name = "ViewPpEmppaydetailList.findByEmploymentsubtype", query = "SELECT v FROM ViewPpEmppaydetailList v WHERE v.employmentsubtype = :employmentsubtype") })
public class ViewPpEmppaydetailList implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "LASTNAME")
	private String lastname;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Column(name = "ISEDITABLE")
	private BigInteger iseditable;
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Integer ppDesignationmasterid;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "PP_SECTIONMASTERID")
	private int ppSectionmasterid;
	@Basic(optional = false)
	@Column(name = "SECTIONNAME")
	private String sectionname;
	@Column(name = "PANNO")
	private String panno;
	@Column(name = "SYS_PAYMENTMODEID")
	private Short sysPaymentmodeid;
	@Basic(optional = false)
	@Column(name = "PAYMENTMODE")
	private String paymentmode;
	@Basic(optional = false)
	@Column(name = "ISFUNCTIONING")
	private Character isfunctioning;
	@Column(name = "PP_REGISTERMASTERID")
	private Short ppRegistermasterid;
	@Column(name = "MAS_EMPLOYMENTSUBTYPEID")
	private Integer masEmploymentsubtypeid;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTSUBTYPE")
	private String employmentsubtype;

	public ViewPpEmppaydetailList() {
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
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

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getEmploymenttype() {
		return employmenttype;
	}

	public void setEmploymenttype(String employmenttype) {
		this.employmenttype = employmenttype;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public BigInteger getIseditable() {
		return iseditable;
	}

	public void setIseditable(BigInteger iseditable) {
		this.iseditable = iseditable;
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

	public int getPpSectionmasterid() {
		return ppSectionmasterid;
	}

	public void setPpSectionmasterid(int ppSectionmasterid) {
		this.ppSectionmasterid = ppSectionmasterid;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public Short getSysPaymentmodeid() {
		return sysPaymentmodeid;
	}

	public void setSysPaymentmodeid(Short sysPaymentmodeid) {
		this.sysPaymentmodeid = sysPaymentmodeid;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public Character getIsfunctioning() {
		return isfunctioning;
	}

	public void setIsfunctioning(Character isfunctioning) {
		this.isfunctioning = isfunctioning;
	}

	public Short getPpRegistermasterid() {
		return ppRegistermasterid;
	}

	public void setPpRegistermasterid(Short ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public Integer getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(Integer masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public String getEmploymentsubtype() {
		return employmentsubtype;
	}

	public void setEmploymentsubtype(String employmentsubtype) {
		this.employmentsubtype = employmentsubtype;
	}

}
