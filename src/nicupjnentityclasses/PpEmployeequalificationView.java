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
@Table(name = "PP_EMPLOYEEQUALIFICATION_VIEW")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "PpEmployeequalificationView.findAll", query = "SELECT p FROM PpEmployeequalificationView p"),
		@NamedQuery(name = "PpEmployeequalificationView.findByEmployeename", query = "SELECT p FROM PpEmployeequalificationView p WHERE p.employeename = :employeename"),
		@NamedQuery(name = "PpEmployeequalificationView.findByPpEmployeemasterid", query = "SELECT p FROM PpEmployeequalificationView p WHERE p.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "PpEmployeequalificationView.findByPpEmployeequalificationid", query = "SELECT p FROM PpEmployeequalificationView p WHERE p.ppEmployeequalificationid = :ppEmployeequalificationid"),
		@NamedQuery(name = "PpEmployeequalificationView.findByQualification", query = "SELECT p FROM PpEmployeequalificationView p WHERE p.qualification = :qualification"),
		@NamedQuery(name = "PpEmployeequalificationView.findByQualificationdetails", query = "SELECT p FROM PpEmployeequalificationView p WHERE p.qualificationdetails = :qualificationdetails"),
		@NamedQuery(name = "PpEmployeequalificationView.findByIsatjoining", query = "SELECT p FROM PpEmployeequalificationView p WHERE p.isatjoining = :isatjoining"),
		@NamedQuery(name = "PpEmployeequalificationView.findByPermissionno", query = "SELECT p FROM PpEmployeequalificationView p WHERE p.permissionno = :permissionno"),
		@NamedQuery(name = "PpEmployeequalificationView.findByPermissiondate", query = "SELECT p FROM PpEmployeequalificationView p WHERE p.permissiondate = :permissiondate") })
public class PpEmployeequalificationView implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEQUALIFICATIONID")
	private long ppEmployeequalificationid;
	@Basic(optional = false)
	@Column(name = "QUALIFICATION")
	private String qualification;
	@Column(name = "QUALIFICATIONDETAILS")
	private String qualificationdetails;
	@Basic(optional = false)
	@Column(name = "ISATJOINING")
	private Character isatjoining;
	@Column(name = "PERMISSIONNO")
	private String permissionno;
	@Column(name = "PERMISSIONDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date permissiondate;

	public PpEmployeequalificationView() {
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public long getPpEmployeequalificationid() {
		return ppEmployeequalificationid;
	}

	public void setPpEmployeequalificationid(long ppEmployeequalificationid) {
		this.ppEmployeequalificationid = ppEmployeequalificationid;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getQualificationdetails() {
		return qualificationdetails;
	}

	public void setQualificationdetails(String qualificationdetails) {
		this.qualificationdetails = qualificationdetails;
	}

	public Character getIsatjoining() {
		return isatjoining;
	}

	public void setIsatjoining(Character isatjoining) {
		this.isatjoining = isatjoining;
	}

	public String getPermissionno() {
		return permissionno;
	}

	public void setPermissionno(String permissionno) {
		this.permissionno = permissionno;
	}

	public Date getPermissiondate() {
		return permissiondate;
	}

	public void setPermissiondate(Date permissiondate) {
		this.permissiondate = permissiondate;
	}

}
