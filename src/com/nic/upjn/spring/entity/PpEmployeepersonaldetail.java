/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_EMPLOYEEPERSONALDETAIL")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "PpEmployeepersonaldetail.findAll", query = "SELECT p FROM PpEmployeepersonaldetail p"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByPpEmployeepersonaldetailid", query = "FROM PpEmployeepersonaldetail WHERE ppEmployeemasterid = ?"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByDateofbirth", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.dateofbirth = :dateofbirth"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByPermanentaddress", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.permanentaddress = :permanentaddress"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByFathername", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.fathername = :fathername"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByHeight", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.height = :height"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByPersonalidentificationmark", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.personalidentificationmark = :personalidentificationmark"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByMasReligionid", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.masReligionid = :masReligionid"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByMasCasteid", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.masCasteid = :masCasteid"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByPanno", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.panno = :panno"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByPresentaddress", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.presentaddress = :presentaddress"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByPhnohome", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.phnohome = :phnohome"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByPhnooffice", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.phnooffice = :phnooffice"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByMobileno", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.mobileno = :mobileno"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByEmailid", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.emailid = :emailid"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByHometown", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.hometown = :hometown"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByPincode", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.pincode = :pincode"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByDistrict", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.district = :district"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findBySexcode", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.sexcode = :sexcode"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findBySpouseworkingwithgovt", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.spouseworkingwithgovt = :spouseworkingwithgovt"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByMasMaritalstatusid", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.masMaritalstatusid = :masMaritalstatusid"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByHusbandname", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.husbandname = :husbandname"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByBloodgroup", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.bloodgroup = :bloodgroup"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByMlOpenbalance", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.mlOpenbalance = :mlOpenbalance"),
		@NamedQuery(name = "PpEmployeepersonaldetail.findByMlOpenbaldate", query = "SELECT p FROM PpEmployeepersonaldetail p WHERE p.mlOpenbaldate = :mlOpenbaldate") })
public class PpEmployeepersonaldetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_EMPPERSONALDETAIL")
	@Id
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEPERSONALDETAILID")
	private Long ppEmployeepersonaldetailid;
	@Column(name = "DATEOFBIRTH")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofbirth;
	@Column(name = "PERMANENTADDRESS")
	private String permanentaddress;
	@Column(name = "FATHERNAME")
	private String fathername;
	@Column(name = "HEIGHT")
	private String height;
	@Column(name = "PERSONALIDENTIFICATIONMARK")
	private String personalidentificationmark;
	@Column(name = "MAS_RELIGIONID")
	private Short masReligionid;
	@Column(name = "MAS_CASTEID")
	private Short masCasteid;
	@Column(name = "PANNO")
	private String panno;
	@Column(name = "PRESENTADDRESS")
	private String presentaddress;
	@Column(name = "PHNOHOME")
	private String phnohome;
	@Column(name = "PHNOOFFICE")
	private String phnooffice;
	@Column(name = "MOBILENO")
	private String mobileno;
	@Column(name = "EMAILID")
	private String emailid;
	@Column(name = "HOMETOWN")
	private String hometown;
	@Column(name = "PINCODE")
	private String pincode;
	@Column(name = "DISTRICT")
	private String district;
	@Column(name = "SEXCODE")
	private char sexcode;
	@Column(name = "SPOUSEWORKINGWITHGOVT")
	private Character spouseworkingwithgovt;
	@Column(name = "MAS_MARITALSTATUSID")
	private Short masMaritalstatusid;
	@Column(name = "HUSBANDNAME")
	private String husbandname;
	@Column(name = "BLOODGROUP")
	private String bloodgroup;
	@Column(name = "ML_OPENBALANCE")
	private String mlOpenbalance;
	@Column(name = "ML_OPENBALDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mlOpenbaldate;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
	
	
	
	/*@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@OneToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;*/

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public PpEmployeepersonaldetail() {
	}

	public PpEmployeepersonaldetail(Long ppEmployeepersonaldetailid) {
		this.ppEmployeepersonaldetailid = ppEmployeepersonaldetailid;
	}

	public Long getPpEmployeepersonaldetailid() {
		return ppEmployeepersonaldetailid;
	}

	public void setPpEmployeepersonaldetailid(Long ppEmployeepersonaldetailid) {
		this.ppEmployeepersonaldetailid = ppEmployeepersonaldetailid;
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

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
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

	public Short getMasReligionid() {
		return masReligionid;
	}

	public void setMasReligionid(Short masReligionid) {
		this.masReligionid = masReligionid;
	}

	public Short getMasCasteid() {
		return masCasteid;
	}

	public void setMasCasteid(Short masCasteid) {
		this.masCasteid = masCasteid;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public String getPresentaddress() {
		return presentaddress;
	}

	public void setPresentaddress(String presentaddress) {
		this.presentaddress = presentaddress;
	}

	public String getPhnohome() {
		return phnohome;
	}

	public void setPhnohome(String phnohome) {
		this.phnohome = phnohome;
	}

	public String getPhnooffice() {
		return phnooffice;
	}

	public void setPhnooffice(String phnooffice) {
		this.phnooffice = phnooffice;
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

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public char getSexcode() {
		return sexcode;
	}

	public void setSexcode(char sexcode) {
		this.sexcode = sexcode;
	}

	public Character getSpouseworkingwithgovt() {
		return spouseworkingwithgovt;
	}

	public void setSpouseworkingwithgovt(Character spouseworkingwithgovt) {
		this.spouseworkingwithgovt = spouseworkingwithgovt;
	}

	public Short getMasMaritalstatusid() {
		return masMaritalstatusid;
	}

	public void setMasMaritalstatusid(Short masMaritalstatusid) {
		this.masMaritalstatusid = masMaritalstatusid;
	}

	public String getHusbandname() {
		return husbandname;
	}

	public void setHusbandname(String husbandname) {
		this.husbandname = husbandname;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
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

/*	public PpEmployeemaster getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(PpEmployeemaster ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}
*/
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppEmployeepersonaldetailid != null ? ppEmployeepersonaldetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpEmployeepersonaldetail)) {
			return false;
		}
		PpEmployeepersonaldetail other = (PpEmployeepersonaldetail) object;
		if ((this.ppEmployeepersonaldetailid == null && other.ppEmployeepersonaldetailid != null)
				|| (this.ppEmployeepersonaldetailid != null
						&& !this.ppEmployeepersonaldetailid.equals(other.ppEmployeepersonaldetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpEmployeepersonaldetail[ ppEmployeepersonaldetailid=" + ppEmployeepersonaldetailid
				+ " ]";
	}

}
