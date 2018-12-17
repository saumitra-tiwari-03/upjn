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
@Table(name = "VIEW_PSN_FAMILYPENSION_GRID")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findAll", query = "SELECT v FROM ViewPsnFamilypensionGrid v"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByEmployeename", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByPsnEmployeepensionMasterid", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.psnEmployeepensionMasterid = :psnEmployeepensionMasterid"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByFirstname", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.firstname = :firstname"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByMiddlename", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.middlename = :middlename"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByLastname", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.lastname = :lastname"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByEmployeecode", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByFathername", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.fathername = :fathername"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByDateofbirth", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.dateofbirth = :dateofbirth"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByAddress", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.address = :address"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByLastdesignation", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.lastdesignation = :lastdesignation"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByLastoffice", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.lastoffice = :lastoffice"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByDateofretirement", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.dateofretirement = :dateofretirement"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByDateofdeath", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.dateofdeath = :dateofdeath"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByRmOfficeid", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByIsdirectentry", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.isdirectentry = :isdirectentry"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByJoiningdate", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.joiningdate = :joiningdate"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByEntryOfficeid", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.entryOfficeid = :entryOfficeid"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByEditdate", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.editdate = :editdate"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByClerkid", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.clerkid = :clerkid"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByAvailableinpis", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.availableinpis = :availableinpis"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByPpono", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.ppono = :ppono"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByPsnFamilypensionMasterid", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.psnFamilypensionMasterid = :psnFamilypensionMasterid"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByFpName", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.fpName = :fpName"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByIsnominationchanged", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.isnominationchanged = :isnominationchanged"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByReason", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.reason = :reason"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByDateofeffect", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.dateofeffect = :dateofeffect"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByFpRelationwithemployee", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.fpRelationwithemployee = :fpRelationwithemployee"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByFpAddress", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.fpAddress = :fpAddress"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByFpFathername", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.fpFathername = :fpFathername"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByFpDateofbirth", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.fpDateofbirth = :fpDateofbirth"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByFamilypensiontype", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.familypensiontype = :familypensiontype"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByHeight", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.height = :height"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByIdentificationmark", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.identificationmark = :identificationmark"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByDesignationofofficehead", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.designationofofficehead = :designationofofficehead"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByIsprovisional", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.isprovisional = :isprovisional"),
		@NamedQuery(name = "ViewPsnFamilypensionGrid.findByFillpartfiveaction", query = "SELECT v FROM ViewPsnFamilypensionGrid v WHERE v.fillpartfiveaction = :fillpartfiveaction") })
public class ViewPsnFamilypensionGrid implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "PSN_EMPLOYEEPENSION_MASTERID")
	private long psnEmployeepensionMasterid;
	@Basic(optional = false)
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "MIDDLENAME")
	private String middlename;
	@Column(name = "LASTNAME")
	private String lastname;
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
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
	@Basic(optional = false)
	@Column(name = "EDITDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date editdate;
	@Column(name = "CLERKID")
	private String clerkid;
	@Basic(optional = false)
	@Column(name = "AVAILABLEINPIS")
	private Character availableinpis;
	@Column(name = "PPONO")
	private String ppono;
	@Basic(optional = false)
	@Column(name = "PSN_FAMILYPENSION_MASTERID")
	private long psnFamilypensionMasterid;
	@Basic(optional = false)
	@Column(name = "FP_NAME")
	private String fpName;
	@Column(name = "ISNOMINATIONCHANGED")
	private Character isnominationchanged;
	@Column(name = "REASON")
	private String reason;
	@Column(name = "DATEOFEFFECT")
	private String dateofeffect;
	@Basic(optional = false)
	@Column(name = "FP_RELATIONWITHEMPLOYEE")
	private String fpRelationwithemployee;
	@Column(name = "FP_ADDRESS")
	private String fpAddress;
	@Basic(optional = false)
	@Column(name = "FP_FATHERNAME")
	private String fpFathername;
	@Column(name = "FP_DATEOFBIRTH")
	private String fpDateofbirth;
	@Basic(optional = false)
	@Column(name = "FAMILYPENSIONTYPE")
	private Character familypensiontype;
	@Column(name = "HEIGHT")
	private String height;
	@Column(name = "IDENTIFICATIONMARK")
	private String identificationmark;
	@Column(name = "DESIGNATIONOFOFFICEHEAD")
	private String designationofofficehead;
	@Column(name = "ISPROVISIONAL")
	private Character isprovisional;
	@Column(name = "FILLPARTFIVEACTION")
	private String fillpartfiveaction;

	public ViewPsnFamilypensionGrid() {
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public long getPsnEmployeepensionMasterid() {
		return psnEmployeepensionMasterid;
	}

	public void setPsnEmployeepensionMasterid(long psnEmployeepensionMasterid) {
		this.psnEmployeepensionMasterid = psnEmployeepensionMasterid;
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

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
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

	public Character getAvailableinpis() {
		return availableinpis;
	}

	public void setAvailableinpis(Character availableinpis) {
		this.availableinpis = availableinpis;
	}

	public String getPpono() {
		return ppono;
	}

	public void setPpono(String ppono) {
		this.ppono = ppono;
	}

	public long getPsnFamilypensionMasterid() {
		return psnFamilypensionMasterid;
	}

	public void setPsnFamilypensionMasterid(long psnFamilypensionMasterid) {
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

	public String getDateofeffect() {
		return dateofeffect;
	}

	public void setDateofeffect(String dateofeffect) {
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

	public String getFpDateofbirth() {
		return fpDateofbirth;
	}

	public void setFpDateofbirth(String fpDateofbirth) {
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

	public Character getIsprovisional() {
		return isprovisional;
	}

	public void setIsprovisional(Character isprovisional) {
		this.isprovisional = isprovisional;
	}

	public String getFillpartfiveaction() {
		return fillpartfiveaction;
	}

	public void setFillpartfiveaction(String fillpartfiveaction) {
		this.fillpartfiveaction = fillpartfiveaction;
	}

}
