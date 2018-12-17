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
@Table(name = "WC_VIEW")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "WcView.findAll", query = "SELECT w FROM WcView w"),
		@NamedQuery(name = "WcView.findByEcode", query = "SELECT w FROM WcView w WHERE w.ecode = :ecode"),
		@NamedQuery(name = "WcView.findByEname", query = "SELECT w FROM WcView w WHERE w.ename = :ename"),
		@NamedQuery(name = "WcView.findByFirstName", query = "SELECT w FROM WcView w WHERE w.firstName = :firstName"),
		@NamedQuery(name = "WcView.findByMidName", query = "SELECT w FROM WcView w WHERE w.midName = :midName"),
		@NamedQuery(name = "WcView.findByLastName", query = "SELECT w FROM WcView w WHERE w.lastName = :lastName"),
		@NamedQuery(name = "WcView.findByFname", query = "SELECT w FROM WcView w WHERE w.fname = :fname"),
		@NamedQuery(name = "WcView.findByDob", query = "SELECT w FROM WcView w WHERE w.dob = :dob"),
		@NamedQuery(name = "WcView.findByDesigCode", query = "SELECT w FROM WcView w WHERE w.desigCode = :desigCode"),
		@NamedQuery(name = "WcView.findByDesig", query = "SELECT w FROM WcView w WHERE w.desig = :desig"),
		@NamedQuery(name = "WcView.findByDjdt", query = "SELECT w FROM WcView w WHERE w.djdt = :djdt"),
		@NamedQuery(name = "WcView.findByCasteGroup", query = "SELECT w FROM WcView w WHERE w.casteGroup = :casteGroup"),
		@NamedQuery(name = "WcView.findByMasCasteid", query = "SELECT w FROM WcView w WHERE w.masCasteid = :masCasteid"),
		@NamedQuery(name = "WcView.findByAppMode", query = "SELECT w FROM WcView w WHERE w.appMode = :appMode"),
		@NamedQuery(name = "WcView.findBySysSubservicephasemasterid", query = "SELECT w FROM WcView w WHERE w.sysSubservicephasemasterid = :sysSubservicephasemasterid"),
		@NamedQuery(name = "WcView.findByHomeDist", query = "SELECT w FROM WcView w WHERE w.homeDist = :homeDist"),
		@NamedQuery(name = "WcView.findByRmId", query = "SELECT w FROM WcView w WHERE w.rmId = :rmId") })
public class WcView implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "ECODE")
	private String ecode;
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
	@Column(name = "DESIG_CODE")
	private Long desigCode;
	@Column(name = "DESIG")
	private String desig;
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
	private String rmId;

	public WcView() {
	}

	public String getEcode() {
		return ecode;
	}

	public void setEcode(String ecode) {
		this.ecode = ecode;
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

	public Long getDesigCode() {
		return desigCode;
	}

	public void setDesigCode(Long desigCode) {
		this.desigCode = desigCode;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
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

	public String getRmId() {
		return rmId;
	}

	public void setRmId(String rmId) {
		this.rmId = rmId;
	}

}
