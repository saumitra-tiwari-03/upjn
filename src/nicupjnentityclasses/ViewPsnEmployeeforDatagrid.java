/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;

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
@Table(name = "VIEW_PSN_EMPLOYEEFOR_DATAGRID")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findAll", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByPsnEmployeepensionMasterid", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.psnEmployeepensionMasterid = :psnEmployeepensionMasterid"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByEmployeecode", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByPpono", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.ppono = :ppono"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByFirstname", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.firstname = :firstname"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByMiddlename", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.middlename = :middlename"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByLastname", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.lastname = :lastname"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByEmployeename", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByFathername", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.fathername = :fathername"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByDateofbirth", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.dateofbirth = :dateofbirth"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByAddress", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.address = :address"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByLastdesignation", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.lastdesignation = :lastdesignation"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByLastoffice", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.lastoffice = :lastoffice"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByDateofretirement", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.dateofretirement = :dateofretirement"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByDateofdeath", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.dateofdeath = :dateofdeath"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByRmOfficeid", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByIsdirectentry", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.isdirectentry = :isdirectentry"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByJoiningdate", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.joiningdate = :joiningdate"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByEntryOfficeid", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.entryOfficeid = :entryOfficeid"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByEditdate", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.editdate = :editdate"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByClerkid", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.clerkid = :clerkid"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByHeight", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.height = :height"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByIdentificationmark", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.identificationmark = :identificationmark"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByDesignationofofficehead", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.designationofofficehead = :designationofofficehead"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByAvailableinpis", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.availableinpis = :availableinpis"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByPsnNomineedetailid", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.psnNomineedetailid = :psnNomineedetailid"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByNomineename", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.nomineename = :nomineename"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByNomineedateofbirth", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.nomineedateofbirth = :nomineedateofbirth"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByNomineeaddress", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.nomineeaddress = :nomineeaddress"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByRelation", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.relation = :relation"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByNominationtype", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.nominationtype = :nominationtype"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByOfficeforpension", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.officeforpension = :officeforpension"),
		@NamedQuery(name = "ViewPsnEmployeeforDatagrid.findByStatus", query = "SELECT v FROM ViewPsnEmployeeforDatagrid v WHERE v.status = :status") })
public class ViewPsnEmployeeforDatagrid implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PSN_EMPLOYEEPENSION_MASTERID")
	private long psnEmployeepensionMasterid;
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
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "FATHERNAME")
	private String fathername;
	@Column(name = "DATEOFBIRTH")
	private String dateofbirth;
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
	private String dateofretirement;
	@Column(name = "DATEOFDEATH")
	private String dateofdeath;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Basic(optional = false)
	@Column(name = "ISDIRECTENTRY")
	private Character isdirectentry;
	@Column(name = "JOININGDATE")
	private String joiningdate;
	@Column(name = "ENTRY_OFFICEID")
	private Integer entryOfficeid;
	@Column(name = "EDITDATE")
	private String editdate;
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
	@Column(name = "PSN_NOMINEEDETAILID")
	private long psnNomineedetailid;
	@Basic(optional = false)
	@Column(name = "NOMINEENAME")
	private String nomineename;
	@Column(name = "NOMINEEDATEOFBIRTH")
	private String nomineedateofbirth;
	@Column(name = "NOMINEEADDRESS")
	private String nomineeaddress;
	@Basic(optional = false)
	@Column(name = "RELATION")
	private String relation;
	@Basic(optional = false)
	@Column(name = "NOMINATIONTYPE")
	private String nominationtype;
	@Basic(optional = false)
	@Column(name = "OFFICEFORPENSION")
	private String officeforpension;
	@Basic(optional = false)
	@Column(name = "STATUS")
	private String status;

	public ViewPsnEmployeeforDatagrid() {
	}

	public long getPsnEmployeepensionMasterid() {
		return psnEmployeepensionMasterid;
	}

	public void setPsnEmployeepensionMasterid(long psnEmployeepensionMasterid) {
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

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
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

	public String getDateofretirement() {
		return dateofretirement;
	}

	public void setDateofretirement(String dateofretirement) {
		this.dateofretirement = dateofretirement;
	}

	public String getDateofdeath() {
		return dateofdeath;
	}

	public void setDateofdeath(String dateofdeath) {
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

	public String getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(String joiningdate) {
		this.joiningdate = joiningdate;
	}

	public Integer getEntryOfficeid() {
		return entryOfficeid;
	}

	public void setEntryOfficeid(Integer entryOfficeid) {
		this.entryOfficeid = entryOfficeid;
	}

	public String getEditdate() {
		return editdate;
	}

	public void setEditdate(String editdate) {
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

	public long getPsnNomineedetailid() {
		return psnNomineedetailid;
	}

	public void setPsnNomineedetailid(long psnNomineedetailid) {
		this.psnNomineedetailid = psnNomineedetailid;
	}

	public String getNomineename() {
		return nomineename;
	}

	public void setNomineename(String nomineename) {
		this.nomineename = nomineename;
	}

	public String getNomineedateofbirth() {
		return nomineedateofbirth;
	}

	public void setNomineedateofbirth(String nomineedateofbirth) {
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

	public String getOfficeforpension() {
		return officeforpension;
	}

	public void setOfficeforpension(String officeforpension) {
		this.officeforpension = officeforpension;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
