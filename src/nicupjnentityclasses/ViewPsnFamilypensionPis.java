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
@Table(name = "VIEW_PSN_FAMILYPENSION_PIS")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewPsnFamilypensionPis.findAll", query = "SELECT v FROM ViewPsnFamilypensionPis v"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByEmployeename", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByLastoffice", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.lastoffice = :lastoffice"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByLastdesignation", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.lastdesignation = :lastdesignation"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByEmployeecode", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByFirstname", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.firstname = :firstname"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByMiddlename", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.middlename = :middlename"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByLastname", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.lastname = :lastname"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByRmOfficeid", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByRetirementdate", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.retirementdate = :retirementdate"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByJoiningdate", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.joiningdate = :joiningdate"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByDateofbirth", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.dateofbirth = :dateofbirth"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByFathername", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.fathername = :fathername"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByAddress", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.address = :address"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByFpName", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.fpName = :fpName"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByFpDateofbirth", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.fpDateofbirth = :fpDateofbirth"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByFpAddress", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.fpAddress = :fpAddress"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByFpRelationwithemployee", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.fpRelationwithemployee = :fpRelationwithemployee"),
		@NamedQuery(name = "ViewPsnFamilypensionPis.findByBenifitname", query = "SELECT v FROM ViewPsnFamilypensionPis v WHERE v.benifitname = :benifitname") })
public class ViewPsnFamilypensionPis implements Serializable {
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
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
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
	@Column(name = "FP_NAME")
	private String fpName;
	@Column(name = "FP_DATEOFBIRTH")
	private String fpDateofbirth;
	@Column(name = "FP_ADDRESS")
	private String fpAddress;
	@Column(name = "FP_RELATIONWITHEMPLOYEE")
	private String fpRelationwithemployee;
	@Column(name = "BENIFITNAME")
	private String benifitname;

	public ViewPsnFamilypensionPis() {
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

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
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

	public String getFpName() {
		return fpName;
	}

	public void setFpName(String fpName) {
		this.fpName = fpName;
	}

	public String getFpDateofbirth() {
		return fpDateofbirth;
	}

	public void setFpDateofbirth(String fpDateofbirth) {
		this.fpDateofbirth = fpDateofbirth;
	}

	public String getFpAddress() {
		return fpAddress;
	}

	public void setFpAddress(String fpAddress) {
		this.fpAddress = fpAddress;
	}

	public String getFpRelationwithemployee() {
		return fpRelationwithemployee;
	}

	public void setFpRelationwithemployee(String fpRelationwithemployee) {
		this.fpRelationwithemployee = fpRelationwithemployee;
	}

	public String getBenifitname() {
		return benifitname;
	}

	public void setBenifitname(String benifitname) {
		this.benifitname = benifitname;
	}

}
