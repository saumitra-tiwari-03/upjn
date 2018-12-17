/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import nicupjnentityclasses.Fpr403EntryTable;
import nicupjnentityclasses.FwaBankaccount;
import nicupjnentityclasses.FwaBillmaster;
import nicupjnentityclasses.FwaLocalbodiesmaster;
import nicupjnentityclasses.FwaTeo;
import nicupjnentityclasses.PpPaybilldetail;
import nicupjnentityclasses.PpRelievefromservice;
import nicupjnentityclasses.PpSectionmaster;
import nicupjnentityclasses.PpSuspensiondetail;
import nicupjnentityclasses.PpTerminationdetail;
import nicupjnentityclasses.PpTransferdetail;
import nicupjnentityclasses.PpViewEmpPay;
import nicupjnentityclasses.RmRole;
import nicupjnentityclasses.ViewEmpAlwDedlist;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "RM_OFFICE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "RmOffice.findAll", query = "SELECT r FROM RmOffice r"),
		@NamedQuery(name = "RmOffice.findByRmOfficeid", query = "FROM RmOffice WHERE rmOfficeid = ?"),
		@NamedQuery(name = "RmOffice.findByOfficename", query = "SELECT r FROM RmOffice r WHERE r.mas_officelevelid = ? and r.mas_districtid = ?"),
		@NamedQuery(name = "RmOffice.findByIDOfficename", query = "SELECT r FROM RmOffice r WHERE r.mas_officelevelid = ?"),
		@NamedQuery(name = "RmOffice.findByPpPlacemasterid", query = "SELECT r FROM RmOffice r WHERE r.ppPlacemasterid = :ppPlacemasterid"),
		@NamedQuery(name = "RmOffice.findByOfficeaddress", query = "SELECT r FROM RmOffice r WHERE r.officeaddress = :officeaddress"),
		@NamedQuery(name = "RmOffice.findByPhno1", query = "SELECT r FROM RmOffice r WHERE r.phno1 = :phno1"),
		@NamedQuery(name = "RmOffice.findByPhno2", query = "SELECT r FROM RmOffice r WHERE r.phno2 = :phno2"),
		@NamedQuery(name = "RmOffice.findByFax", query = "SELECT r FROM RmOffice r WHERE r.fax = :fax"),
		@NamedQuery(name = "RmOffice.findByAccountclosingdate", query = "SELECT r FROM RmOffice r WHERE r.accountclosingdate = :accountclosingdate"),
		@NamedQuery(name = "RmOffice.findByIsdeleted", query = "SELECT r FROM RmOffice r WHERE r.isdeleted = :isdeleted"),
		@NamedQuery(name = "RmOffice.findByFinancialstartyear", query = "SELECT r FROM RmOffice r WHERE r.financialstartyear = :financialstartyear"),
		@NamedQuery(name = "RmOffice.findByIsfinancialyearclosed", query = "SELECT r FROM RmOffice r WHERE r.isfinancialyearclosed = :isfinancialyearclosed"),
		@NamedQuery(name = "RmOffice.findByActiveOffice", query = "SELECT r FROM RmOffice r WHERE r.activeOffice = :activeOffice"),
		@NamedQuery(name = "RmOffice.findByLocCode", query = "FROM RmOffice WHERE locCode = ?"),
		@NamedQuery(name = "RmOffice.findByZoneCode", query = "SELECT r FROM RmOffice r WHERE r.zoneCode = :zoneCode"),
		@NamedQuery(name = "RmOffice.findByZoneDesc", query = "SELECT r FROM RmOffice r WHERE r.zoneDesc = :zoneDesc") })
public class RmOffice implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_RM_OFFICE", allocationSize = 1)
	@Basic(optional = false)
	@Id
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Basic(optional = false)
	@Column(name = "OFFICENAME")
	private String officename;
	@Basic(optional = false)
	@Column(name = "MAS_OFFICELEVELID")
	private String mas_officelevelid;
	
	@Basic(optional = false)
	@Column(name = "MAS_DISTRICTID")
	private String mas_districtid;
	
	public String getMas_officelevelid() {
		return mas_officelevelid;
	}

	public void setMas_officelevelid(String mas_officelevelid) {
		this.mas_officelevelid = mas_officelevelid;
	}

	public String getMas_districtid() {
		return mas_districtid;
	}

	public void setMas_districtid(String mas_districtid) {
		this.mas_districtid = mas_districtid;
	}

	@Column(name = "PP_PLACEMASTERID")
	private Long ppPlacemasterid;
	@Column(name = "OFFICEADDRESS")
	private String officeaddress;
	@Column(name = "PHNO1")
	private String phno1;
	@Column(name = "PHNO2")
	private String phno2;
	@Column(name = "FAX")
	private String fax;
	@Column(name = "ACCOUNTCLOSINGDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date accountclosingdate;
	@Basic(optional = false)
	@Column(name = "ISDELETED")
	private Character isdeleted;
	@Column(name = "FINANCIALSTARTYEAR")
	private Long financialstartyear;
	@Basic(optional = false)
	@Column(name = "ISFINANCIALYEARCLOSED")
	private Character isfinancialyearclosed;
	@Column(name = "ACTIVE_OFFICE")
	private Short activeOffice;
	@Column(name = "LOC_CODE")
	private Long locCode;
	@Column(name = "ZONE_CODE")
	private String zoneCode;
	@Column(name = "ZONE_DESC")
	private String zoneDesc;
	
	private Integer  parentofficeid; 
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "rmOfficeid")
	private Collection<PpPaybilldetail> ppPaybilldetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "eventofficeid")
	private Collection<PpTerminationdetail> ppTerminationdetailCollection;
	@OneToMany(mappedBy = "rmOfficeid")
	private Collection<PpEmployeemaster> ppEmployeemasterCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "eventofficeid")
	private Collection<PpSuspensiondetail> ppSuspensiondetailCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rmOfficeid")
	private Collection<FwaBankaccount> fwaBankaccountCollection;
	@OneToMany(mappedBy = "rmOfficeid")
	private Collection<ViewEmpAlwDedlist> viewEmpAlwDedlistCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rmOfficeid")
	private Collection<Fpr403EntryTable> fpr403EntryTableCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rmOfficeid")
	private Collection<PpSectionmaster> ppSectionmasterCollection;
	@OneToMany(mappedBy = "rmOfficeid")
	private Collection<RmRole> rmRoleCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "officetoid")
	private Collection<PpTransferdetail> ppTransferdetailCollection;
	@JoinColumn(name = "MAS_DISTRICTID", referencedColumnName = "MAS_DISTRICTID")
	@ManyToOne(optional = false)
	private MasDistrict masDistrictid;
	@JoinColumn(name = "MAS_OFFICELEVELID", referencedColumnName = "MAS_OFFICELEVELID")
	@ManyToOne(optional = false)
	private MasOfficelevel masOfficelevelid;
	@OneToMany(mappedBy = "parentofficeid")
	private Collection<RmOffice> rmOfficeCollection;
	@JoinColumn(name = "PARENTOFFICEID", referencedColumnName = "RM_OFFICEID")
	@ManyToOne
	private RmOffice parentofficeid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "relievingofficeid")
	private Collection<PpRelievefromservice> ppRelievefromserviceCollection;
	@OneToMany(mappedBy = "rmOfficeid")
	private Collection<PpViewEmpPay> ppViewEmpPayCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rmOfficeid")
	private Collection<FwaBillmaster> fwaBillmasterCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rmOfficeid")
	private Collection<FwaLocalbodiesmaster> fwaLocalbodiesmasterCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rmOfficeid")
	private Collection<FwaTeo> fwaTeoCollection;*/

	public Integer getParentofficeid() {
		return parentofficeid;
	}

	public void setParentofficeid(Integer parentofficeid) {
		this.parentofficeid = parentofficeid;
	}

	public RmOffice() {
	}

	public RmOffice(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public RmOffice(Integer rmOfficeid, String officename, Character isdeleted, Character isfinancialyearclosed) {
		this.rmOfficeid = rmOfficeid;
		this.officename = officename;
		this.isdeleted = isdeleted;
		this.isfinancialyearclosed = isfinancialyearclosed;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public Long getPpPlacemasterid() {
		return ppPlacemasterid;
	}

	public void setPpPlacemasterid(Long ppPlacemasterid) {
		this.ppPlacemasterid = ppPlacemasterid;
	}

	public String getOfficeaddress() {
		return officeaddress;
	}

	public void setOfficeaddress(String officeaddress) {
		this.officeaddress = officeaddress;
	}

	public String getPhno1() {
		return phno1;
	}

	public void setPhno1(String phno1) {
		this.phno1 = phno1;
	}

	public String getPhno2() {
		return phno2;
	}

	public void setPhno2(String phno2) {
		this.phno2 = phno2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Date getAccountclosingdate() {
		return accountclosingdate;
	}

	public void setAccountclosingdate(Date accountclosingdate) {
		this.accountclosingdate = accountclosingdate;
	}

	public Character getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Character isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Long getFinancialstartyear() {
		return financialstartyear;
	}

	public void setFinancialstartyear(Long financialstartyear) {
		this.financialstartyear = financialstartyear;
	}

	public Character getIsfinancialyearclosed() {
		return isfinancialyearclosed;
	}

	public void setIsfinancialyearclosed(Character isfinancialyearclosed) {
		this.isfinancialyearclosed = isfinancialyearclosed;
	}

	public Short getActiveOffice() {
		return activeOffice;
	}

	public void setActiveOffice(Short activeOffice) {
		this.activeOffice = activeOffice;
	}

	public Long getLocCode() {
		return locCode;
	}

	public void setLocCode(Long locCode) {
		this.locCode = locCode;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public String getZoneDesc() {
		return zoneDesc;
	}

	public void setZoneDesc(String zoneDesc) {
		this.zoneDesc = zoneDesc;
	}

/*	@XmlTransient
	public Collection<PpPaybilldetail> getPpPaybilldetailCollection() {
		return ppPaybilldetailCollection;
	}

	public void setPpPaybilldetailCollection(Collection<PpPaybilldetail> ppPaybilldetailCollection) {
		this.ppPaybilldetailCollection = ppPaybilldetailCollection;
	}

	@XmlTransient
	public Collection<PpTerminationdetail> getPpTerminationdetailCollection() {
		return ppTerminationdetailCollection;
	}

	public void setPpTerminationdetailCollection(Collection<PpTerminationdetail> ppTerminationdetailCollection) {
		this.ppTerminationdetailCollection = ppTerminationdetailCollection;
	}

	@XmlTransient
	public Collection<PpEmployeemaster> getPpEmployeemasterCollection() {
		return ppEmployeemasterCollection;
	}

	public void setPpEmployeemasterCollection(Collection<PpEmployeemaster> ppEmployeemasterCollection) {
		this.ppEmployeemasterCollection = ppEmployeemasterCollection;
	}

	@XmlTransient
	public Collection<PpSuspensiondetail> getPpSuspensiondetailCollection() {
		return ppSuspensiondetailCollection;
	}

	public void setPpSuspensiondetailCollection(Collection<PpSuspensiondetail> ppSuspensiondetailCollection) {
		this.ppSuspensiondetailCollection = ppSuspensiondetailCollection;
	}

	@XmlTransient
	public Collection<FwaBankaccount> getFwaBankaccountCollection() {
		return fwaBankaccountCollection;
	}

	public void setFwaBankaccountCollection(Collection<FwaBankaccount> fwaBankaccountCollection) {
		this.fwaBankaccountCollection = fwaBankaccountCollection;
	}

	@XmlTransient
	public Collection<ViewEmpAlwDedlist> getViewEmpAlwDedlistCollection() {
		return viewEmpAlwDedlistCollection;
	}

	public void setViewEmpAlwDedlistCollection(Collection<ViewEmpAlwDedlist> viewEmpAlwDedlistCollection) {
		this.viewEmpAlwDedlistCollection = viewEmpAlwDedlistCollection;
	}

	@XmlTransient
	public Collection<Fpr403EntryTable> getFpr403EntryTableCollection() {
		return fpr403EntryTableCollection;
	}

	public void setFpr403EntryTableCollection(Collection<Fpr403EntryTable> fpr403EntryTableCollection) {
		this.fpr403EntryTableCollection = fpr403EntryTableCollection;
	}

	@XmlTransient
	public Collection<PpSectionmaster> getPpSectionmasterCollection() {
		return ppSectionmasterCollection;
	}

	public void setPpSectionmasterCollection(Collection<PpSectionmaster> ppSectionmasterCollection) {
		this.ppSectionmasterCollection = ppSectionmasterCollection;
	}

	@XmlTransient
	public Collection<RmRole> getRmRoleCollection() {
		return rmRoleCollection;
	}

	public void setRmRoleCollection(Collection<RmRole> rmRoleCollection) {
		this.rmRoleCollection = rmRoleCollection;
	}

	@XmlTransient
	public Collection<PpTransferdetail> getPpTransferdetailCollection() {
		return ppTransferdetailCollection;
	}

	public void setPpTransferdetailCollection(Collection<PpTransferdetail> ppTransferdetailCollection) {
		this.ppTransferdetailCollection = ppTransferdetailCollection;
	}

	public MasDistrict getMasDistrictid() {
		return masDistrictid;
	}

	public void setMasDistrictid(MasDistrict masDistrictid) {
		this.masDistrictid = masDistrictid;
	}

	public MasOfficelevel getMasOfficelevelid() {
		return masOfficelevelid;
	}

	public void setMasOfficelevelid(MasOfficelevel masOfficelevelid) {
		this.masOfficelevelid = masOfficelevelid;
	}

	@XmlTransient
	public Collection<RmOffice> getRmOfficeCollection() {
		return rmOfficeCollection;
	}

	public void setRmOfficeCollection(Collection<RmOffice> rmOfficeCollection) {
		this.rmOfficeCollection = rmOfficeCollection;
	}

	public RmOffice getParentofficeid() {
		return parentofficeid;
	}

	public void setParentofficeid(RmOffice parentofficeid) {
		this.parentofficeid = parentofficeid;
	}

	@XmlTransient
	public Collection<PpRelievefromservice> getPpRelievefromserviceCollection() {
		return ppRelievefromserviceCollection;
	}

	public void setPpRelievefromserviceCollection(Collection<PpRelievefromservice> ppRelievefromserviceCollection) {
		this.ppRelievefromserviceCollection = ppRelievefromserviceCollection;
	}

	@XmlTransient
	public Collection<PpViewEmpPay> getPpViewEmpPayCollection() {
		return ppViewEmpPayCollection;
	}

	public void setPpViewEmpPayCollection(Collection<PpViewEmpPay> ppViewEmpPayCollection) {
		this.ppViewEmpPayCollection = ppViewEmpPayCollection;
	}

	@XmlTransient
	public Collection<FwaBillmaster> getFwaBillmasterCollection() {
		return fwaBillmasterCollection;
	}

	public void setFwaBillmasterCollection(Collection<FwaBillmaster> fwaBillmasterCollection) {
		this.fwaBillmasterCollection = fwaBillmasterCollection;
	}

	@XmlTransient
	public Collection<FwaLocalbodiesmaster> getFwaLocalbodiesmasterCollection() {
		return fwaLocalbodiesmasterCollection;
	}

	public void setFwaLocalbodiesmasterCollection(Collection<FwaLocalbodiesmaster> fwaLocalbodiesmasterCollection) {
		this.fwaLocalbodiesmasterCollection = fwaLocalbodiesmasterCollection;
	}

	@XmlTransient
	public Collection<FwaTeo> getFwaTeoCollection() {
		return fwaTeoCollection;
	}

	public void setFwaTeoCollection(Collection<FwaTeo> fwaTeoCollection) {
		this.fwaTeoCollection = fwaTeoCollection;
	}*/

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (rmOfficeid != null ? rmOfficeid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof RmOffice)) {
			return false;
		}
		RmOffice other = (RmOffice) object;
		if ((this.rmOfficeid == null && other.rmOfficeid != null)
				|| (this.rmOfficeid != null && !this.rmOfficeid.equals(other.rmOfficeid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.RmOffice[ rmOfficeid=" + rmOfficeid + " ]";
	}

}
