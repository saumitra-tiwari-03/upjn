/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "EMP_VIEW")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "EmpView.findAll", query = "SELECT e FROM EmpView e"),
		@NamedQuery(name = "EmpView.findByEcode", query = "SELECT e FROM EmpView e WHERE e.ecode = :ecode"),
		@NamedQuery(name = "EmpView.findByPpEmployeemasterid", query = "SELECT e FROM EmpView e WHERE e.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "EmpView.findByEname", query = "SELECT e FROM EmpView e WHERE e.ename = :ename"),
		@NamedQuery(name = "EmpView.findByFirstName", query = "SELECT e FROM EmpView e WHERE e.firstName = :firstName"),
		@NamedQuery(name = "EmpView.findByMidName", query = "SELECT e FROM EmpView e WHERE e.midName = :midName"),
		@NamedQuery(name = "EmpView.findByLastName", query = "SELECT e FROM EmpView e WHERE e.lastName = :lastName"),
		@NamedQuery(name = "EmpView.findByFname", query = "SELECT e FROM EmpView e WHERE e.fname = :fname"),
		@NamedQuery(name = "EmpView.findByDob", query = "SELECT e FROM EmpView e WHERE e.dob = :dob"),
		@NamedQuery(name = "EmpView.findByDesig", query = "SELECT e FROM EmpView e WHERE e.desig = :desig"),
		@NamedQuery(name = "EmpView.findByPpDesignationmasterid", query = "SELECT e FROM EmpView e WHERE e.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "EmpView.findByDjdt", query = "SELECT e FROM EmpView e WHERE e.djdt = :djdt"),
		@NamedQuery(name = "EmpView.findByCasteGroup", query = "SELECT e FROM EmpView e WHERE e.casteGroup = :casteGroup"),
		@NamedQuery(name = "EmpView.findByMasCasteid", query = "SELECT e FROM EmpView e WHERE e.masCasteid = :masCasteid"),
		@NamedQuery(name = "EmpView.findByAppMode", query = "SELECT e FROM EmpView e WHERE e.appMode = :appMode"),
		@NamedQuery(name = "EmpView.findBySysSubservicephasemasterid", query = "SELECT e FROM EmpView e WHERE e.sysSubservicephasemasterid = :sysSubservicephasemasterid"),
		@NamedQuery(name = "EmpView.findByHomeDist", query = "SELECT e FROM EmpView e WHERE e.homeDist = :homeDist"),
		@NamedQuery(name = "EmpView.findByRmId", query = "SELECT e FROM EmpView e WHERE e.rmId = :rmId") })
public class EmpView implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "ECODE")
	private String ecode;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
	@Column(name = "ENAME")
	private String ename;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "MID_NAME")
	private String midName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "FNAME")
	private String fname;
	@Column(name = "DOB")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;
	@Column(name = "DESIG")
	private String desig;
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Integer ppDesignationmasterid;
	@Column(name = "DJDT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date djdt;
	@Column(name = "CASTE_GROUP")
	private String casteGroup;
	@Column(name = "MAS_CASTEID")
	private Short masCasteid;
	@Column(name = "APP_MODE")
	private String appMode;
	@Column(name = "SYS_SUBSERVICEPHASEMASTERID")
	private Short sysSubservicephasemasterid;
	@Column(name = "HOME_DIST")
	private String homeDist;
	@Column(name = "RM_ID")
	private Integer rmId;

	public EmpView() {
	}

	public String getEcode() {
		return ecode;
	}

	public void setEcode(String ecode) {
		this.ecode = ecode;
	}

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public Integer getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(Integer ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public Date getDjdt() {
		return djdt;
	}

	public void setDjdt(Date djdt) {
		this.djdt = djdt;
	}

	public String getCasteGroup() {
		return casteGroup;
	}

	public void setCasteGroup(String casteGroup) {
		this.casteGroup = casteGroup;
	}

	public Short getMasCasteid() {
		return masCasteid;
	}

	public void setMasCasteid(Short masCasteid) {
		this.masCasteid = masCasteid;
	}

	public String getAppMode() {
		return appMode;
	}

	public void setAppMode(String appMode) {
		this.appMode = appMode;
	}

	public Short getSysSubservicephasemasterid() {
		return sysSubservicephasemasterid;
	}

	public void setSysSubservicephasemasterid(Short sysSubservicephasemasterid) {
		this.sysSubservicephasemasterid = sysSubservicephasemasterid;
	}

	public String getHomeDist() {
		return homeDist;
	}

	public void setHomeDist(String homeDist) {
		this.homeDist = homeDist;
	}

	public Integer getRmId() {
		return rmId;
	}

	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}

}
