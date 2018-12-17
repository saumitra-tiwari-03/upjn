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
@Table(name = "VIEW_PP_EMPLOYEEPERSONALDETAIL")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findAll", query = "SELECT v FROM ViewPpEmployeepersonaldetail v"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByEmployeecode", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByFirstname", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.firstname = :firstname"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByMiddlename", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.middlename = :middlename"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByLastname", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.lastname = :lastname"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findBySexcode", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.sexcode = :sexcode"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByPpDesignationmasterid", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByDesignation", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByRmOfficeid", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByFathername", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.fathername = :fathername"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByHusbandname", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.husbandname = :husbandname"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByMasCasteid", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.masCasteid = :masCasteid"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByCaste", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.caste = :caste"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByMasReligionid", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.masReligionid = :masReligionid"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByReligion", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.religion = :religion"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByMasMaritalstatusid", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.masMaritalstatusid = :masMaritalstatusid"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByMaritalstatus", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.maritalstatus = :maritalstatus"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByDateofbirth", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.dateofbirth = :dateofbirth"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByPermanentaddress", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.permanentaddress = :permanentaddress"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByDistrict", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.district = :district"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByPincode", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.pincode = :pincode"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByPresentaddress", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.presentaddress = :presentaddress"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByHomephno", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.homephno = :homephno"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByOfficephno", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.officephno = :officephno"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByMobileno", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.mobileno = :mobileno"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByEmailid", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.emailid = :emailid"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByPanno", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.panno = :panno"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByHometown", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.hometown = :hometown"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByHeight", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.height = :height"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByPersonalidentificationmark", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.personalidentificationmark = :personalidentificationmark"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findBySpouseworkingwithgovt", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.spouseworkingwithgovt = :spouseworkingwithgovt"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByAppointmentfiledate", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.appointmentfiledate = :appointmentfiledate"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByAppointmentfileno", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.appointmentfileno = :appointmentfileno"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByAppointmentauthority", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.appointmentauthority = :appointmentauthority"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByDatejoining", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.datejoining = :datejoining"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findBySubphasename", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.subphasename = :subphasename"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByEmploymenttype", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByMasEmploymenttypeid", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.masEmploymenttypeid = :masEmploymenttypeid"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByFirstdesignation", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.firstdesignation = :firstdesignation"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByFirstdesignationid", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.firstdesignationid = :firstdesignationid"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByEmploymentsubtype", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.employmentsubtype = :employmentsubtype"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByMasEmploymentsubtypeid", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.masEmploymentsubtypeid = :masEmploymentsubtypeid"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByRetirementdate", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.retirementdate = :retirementdate"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByRetirementage", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.retirementage = :retirementage"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByPpEmployeepersonaldetailid", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.ppEmployeepersonaldetailid = :ppEmployeepersonaldetailid"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByBloodgroup", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.bloodgroup = :bloodgroup"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByPpEmployeeappointmentdetailid", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.ppEmployeeappointmentdetailid = :ppEmployeeappointmentdetailid"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByMlOpenbalance", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.mlOpenbalance = :mlOpenbalance"),
		@NamedQuery(name = "ViewPpEmployeepersonaldetail.findByMlOpenbaldate", query = "SELECT v FROM ViewPpEmployeepersonaldetail v WHERE v.mlOpenbaldate = :mlOpenbaldate") })
public class ViewPpEmployeepersonaldetail implements Serializable {
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
	@Column(name = "MIDDLENAME")
	private String middlename;
	@Column(name = "LASTNAME")
	private String lastname;
	@Column(name = "SEXCODE")
	private Character sexcode;
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Integer ppDesignationmasterid;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Column(name = "FATHERNAME")
	private String fathername;
	@Column(name = "HUSBANDNAME")
	private String husbandname;
	@Column(name = "MAS_CASTEID")
	private Short masCasteid;
	@Column(name = "CASTE")
	private String caste;
	@Column(name = "MAS_RELIGIONID")
	private Short masReligionid;
	@Column(name = "RELIGION")
	private String religion;
	@Column(name = "MAS_MARITALSTATUSID")
	private Short masMaritalstatusid;
	@Column(name = "MARITALSTATUS")
	private String maritalstatus;
	@Column(name = "DATEOFBIRTH")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofbirth;
	@Column(name = "PERMANENTADDRESS")
	private String permanentaddress;
	@Column(name = "DISTRICT")
	private String district;
	@Column(name = "PINCODE")
	private String pincode;
	@Column(name = "PRESENTADDRESS")
	private String presentaddress;
	@Column(name = "HOMEPHNO")
	private String homephno;
	@Column(name = "OFFICEPHNO")
	private String officephno;
	@Column(name = "MOBILENO")
	private String mobileno;
	@Column(name = "EMAILID")
	private String emailid;
	@Column(name = "PANNO")
	private String panno;
	@Column(name = "HOMETOWN")
	private String hometown;
	@Column(name = "HEIGHT")
	private String height;
	@Column(name = "PERSONALIDENTIFICATIONMARK")
	private String personalidentificationmark;
	@Column(name = "SPOUSEWORKINGWITHGOVT")
	private Character spouseworkingwithgovt;
	@Column(name = "APPOINTMENTFILEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date appointmentfiledate;
	@Column(name = "APPOINTMENTFILENO")
	private String appointmentfileno;
	@Column(name = "APPOINTMENTAUTHORITY")
	private String appointmentauthority;
	@Column(name = "DATEJOINING")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datejoining;
	@Basic(optional = false)
	@Column(name = "SUBPHASENAME")
	private String subphasename;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;
	@Basic(optional = false)
	@Column(name = "MAS_EMPLOYMENTTYPEID")
	private int masEmploymenttypeid;
	@Column(name = "FIRSTDESIGNATION")
	private String firstdesignation;
	@Column(name = "FIRSTDESIGNATIONID")
	private Integer firstdesignationid;
	@Column(name = "EMPLOYMENTSUBTYPE")
	private String employmentsubtype;
	@Column(name = "MAS_EMPLOYMENTSUBTYPEID")
	private Integer masEmploymentsubtypeid;
	@Column(name = "RETIREMENTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date retirementdate;
	@Column(name = "RETIREMENTAGE")
	private Short retirementage;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEPERSONALDETAILID")
	private long ppEmployeepersonaldetailid;
	@Column(name = "BLOODGROUP")
	private String bloodgroup;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEAPPOINTMENTDETAILID")
	private long ppEmployeeappointmentdetailid;
	@Column(name = "ML_OPENBALANCE")
	private String mlOpenbalance;
	@Column(name = "ML_OPENBALDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mlOpenbaldate;

	public ViewPpEmployeepersonaldetail() {
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

	public Character getSexcode() {
		return sexcode;
	}

	public void setSexcode(Character sexcode) {
		this.sexcode = sexcode;
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

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getHusbandname() {
		return husbandname;
	}

	public void setHusbandname(String husbandname) {
		this.husbandname = husbandname;
	}

	public Short getMasCasteid() {
		return masCasteid;
	}

	public void setMasCasteid(Short masCasteid) {
		this.masCasteid = masCasteid;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public Short getMasReligionid() {
		return masReligionid;
	}

	public void setMasReligionid(Short masReligionid) {
		this.masReligionid = masReligionid;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public Short getMasMaritalstatusid() {
		return masMaritalstatusid;
	}

	public void setMasMaritalstatusid(Short masMaritalstatusid) {
		this.masMaritalstatusid = masMaritalstatusid;
	}

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getPermanentaddress() {
		return permanentaddress;
	}

	public void setPermanentaddress(String permanentaddress) {
		this.permanentaddress = permanentaddress;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPresentaddress() {
		return presentaddress;
	}

	public void setPresentaddress(String presentaddress) {
		this.presentaddress = presentaddress;
	}

	public String getHomephno() {
		return homephno;
	}

	public void setHomephno(String homephno) {
		this.homephno = homephno;
	}

	public String getOfficephno() {
		return officephno;
	}

	public void setOfficephno(String officephno) {
		this.officephno = officephno;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getPersonalidentificationmark() {
		return personalidentificationmark;
	}

	public void setPersonalidentificationmark(String personalidentificationmark) {
		this.personalidentificationmark = personalidentificationmark;
	}

	public Character getSpouseworkingwithgovt() {
		return spouseworkingwithgovt;
	}

	public void setSpouseworkingwithgovt(Character spouseworkingwithgovt) {
		this.spouseworkingwithgovt = spouseworkingwithgovt;
	}

	public Date getAppointmentfiledate() {
		return appointmentfiledate;
	}

	public void setAppointmentfiledate(Date appointmentfiledate) {
		this.appointmentfiledate = appointmentfiledate;
	}

	public String getAppointmentfileno() {
		return appointmentfileno;
	}

	public void setAppointmentfileno(String appointmentfileno) {
		this.appointmentfileno = appointmentfileno;
	}

	public String getAppointmentauthority() {
		return appointmentauthority;
	}

	public void setAppointmentauthority(String appointmentauthority) {
		this.appointmentauthority = appointmentauthority;
	}

	public Date getDatejoining() {
		return datejoining;
	}

	public void setDatejoining(Date datejoining) {
		this.datejoining = datejoining;
	}

	public String getSubphasename() {
		return subphasename;
	}

	public void setSubphasename(String subphasename) {
		this.subphasename = subphasename;
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

	public String getFirstdesignation() {
		return firstdesignation;
	}

	public void setFirstdesignation(String firstdesignation) {
		this.firstdesignation = firstdesignation;
	}

	public Integer getFirstdesignationid() {
		return firstdesignationid;
	}

	public void setFirstdesignationid(Integer firstdesignationid) {
		this.firstdesignationid = firstdesignationid;
	}

	public String getEmploymentsubtype() {
		return employmentsubtype;
	}

	public void setEmploymentsubtype(String employmentsubtype) {
		this.employmentsubtype = employmentsubtype;
	}

	public Integer getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(Integer masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public Date getRetirementdate() {
		return retirementdate;
	}

	public void setRetirementdate(Date retirementdate) {
		this.retirementdate = retirementdate;
	}

	public Short getRetirementage() {
		return retirementage;
	}

	public void setRetirementage(Short retirementage) {
		this.retirementage = retirementage;
	}

	public long getPpEmployeepersonaldetailid() {
		return ppEmployeepersonaldetailid;
	}

	public void setPpEmployeepersonaldetailid(long ppEmployeepersonaldetailid) {
		this.ppEmployeepersonaldetailid = ppEmployeepersonaldetailid;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public long getPpEmployeeappointmentdetailid() {
		return ppEmployeeappointmentdetailid;
	}

	public void setPpEmployeeappointmentdetailid(long ppEmployeeappointmentdetailid) {
		this.ppEmployeeappointmentdetailid = ppEmployeeappointmentdetailid;
	}

	public String getMlOpenbalance() {
		return mlOpenbalance;
	}

	public void setMlOpenbalance(String mlOpenbalance) {
		this.mlOpenbalance = mlOpenbalance;
	}

	public Date getMlOpenbaldate() {
		return mlOpenbaldate;
	}

	public void setMlOpenbaldate(Date mlOpenbaldate) {
		this.mlOpenbaldate = mlOpenbaldate;
	}

}
