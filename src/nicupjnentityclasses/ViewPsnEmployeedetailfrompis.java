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
@Table(name = "VIEW_PSN_EMPLOYEEDETAILFROMPIS")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findAll", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByEmployeename", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByLastoffice", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.lastoffice = :lastoffice"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByLastdesignation", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.lastdesignation = :lastdesignation"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByEmployeecode", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByFirstname", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.firstname = :firstname"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByMiddlename", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.middlename = :middlename"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByLastname", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.lastname = :lastname"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByRetirementdate", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.retirementdate = :retirementdate"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByJoiningdate", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.joiningdate = :joiningdate"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByDateofbirth", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.dateofbirth = :dateofbirth"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByFathername", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.fathername = :fathername"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByAddress", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.address = :address"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByHeight", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.height = :height"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByIdentificationmark", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.identificationmark = :identificationmark"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByRmOfficeid", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByNomineename", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.nomineename = :nomineename"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByNomineedateofbirth", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.nomineedateofbirth = :nomineedateofbirth"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByNomineeaddress", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.nomineeaddress = :nomineeaddress"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByRelation", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.relation = :relation"),
		@NamedQuery(name = "ViewPsnEmployeedetailfrompis.findByBenifitname", query = "SELECT v FROM ViewPsnEmployeedetailfrompis v WHERE v.benifitname = :benifitname") })
public class ViewPsnEmployeedetailfrompis implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "LASTOFFICE")
	private String lastoffice;
	@Column(name = "LASTDESIGNATION")
	private String lastdesignation;
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
	@Column(name = "RETIREMENTDATE")
	private String retirementdate;
	@Column(name = "JOININGDATE")
	private String joiningdate;
	@Column(name = "DATEOFBIRTH")
	private String dateofbirth;
	@Column(name = "FATHERNAME")
	private String fathername;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "HEIGHT")
	private String height;
	@Column(name = "IDENTIFICATIONMARK")
	private String identificationmark;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Column(name = "NOMINEENAME")
	private String nomineename;
	@Column(name = "NOMINEEDATEOFBIRTH")
	private String nomineedateofbirth;
	@Column(name = "NOMINEEADDRESS")
	private String nomineeaddress;
	@Column(name = "RELATION")
	private String relation;
	@Column(name = "BENIFITNAME")
	private String benifitname;

	public ViewPsnEmployeedetailfrompis() {
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getLastoffice() {
		return lastoffice;
	}

	public void setLastoffice(String lastoffice) {
		this.lastoffice = lastoffice;
	}

	public String getLastdesignation() {
		return lastdesignation;
	}

	public void setLastdesignation(String lastdesignation) {
		this.lastdesignation = lastdesignation;
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

	public String getRetirementdate() {
		return retirementdate;
	}

	public void setRetirementdate(String retirementdate) {
		this.retirementdate = retirementdate;
	}

	public String getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(String joiningdate) {
		this.joiningdate = joiningdate;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
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

	public String getBenifitname() {
		return benifitname;
	}

	public void setBenifitname(String benifitname) {
		this.benifitname = benifitname;
	}

}
