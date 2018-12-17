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
@Table(name = "VIEW_EMP_TRANSFER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewEmpTransfer.findAll", query = "SELECT v FROM ViewEmpTransfer v"),
		@NamedQuery(name = "ViewEmpTransfer.findByPpEmployeemasterid", query = "SELECT v FROM ViewEmpTransfer v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewEmpTransfer.findByEmployeecode", query = "SELECT v FROM ViewEmpTransfer v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEmpTransfer.findByEmployeename", query = "SELECT v FROM ViewEmpTransfer v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEmpTransfer.findByRmOfficeid", query = "SELECT v FROM ViewEmpTransfer v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewEmpTransfer.findByDesignation", query = "SELECT v FROM ViewEmpTransfer v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewEmpTransfer.findByPpTransferdetailid", query = "SELECT v FROM ViewEmpTransfer v WHERE v.ppTransferdetailid = :ppTransferdetailid"),
		@NamedQuery(name = "ViewEmpTransfer.findByTransferorderno", query = "SELECT v FROM ViewEmpTransfer v WHERE v.transferorderno = :transferorderno"),
		@NamedQuery(name = "ViewEmpTransfer.findByTransferorderdate", query = "SELECT v FROM ViewEmpTransfer v WHERE v.transferorderdate = :transferorderdate"),
		@NamedQuery(name = "ViewEmpTransfer.findByOfficefromid", query = "SELECT v FROM ViewEmpTransfer v WHERE v.officefromid = :officefromid"),
		@NamedQuery(name = "ViewEmpTransfer.findByFromoffice", query = "SELECT v FROM ViewEmpTransfer v WHERE v.fromoffice = :fromoffice"),
		@NamedQuery(name = "ViewEmpTransfer.findByTooffice", query = "SELECT v FROM ViewEmpTransfer v WHERE v.tooffice = :tooffice"),
		@NamedQuery(name = "ViewEmpTransfer.findByOfficetoid", query = "SELECT v FROM ViewEmpTransfer v WHERE v.officetoid = :officetoid"),
		@NamedQuery(name = "ViewEmpTransfer.findByRelieveorderno", query = "SELECT v FROM ViewEmpTransfer v WHERE v.relieveorderno = :relieveorderno"),
		@NamedQuery(name = "ViewEmpTransfer.findByRelieveorderdate", query = "SELECT v FROM ViewEmpTransfer v WHERE v.relieveorderdate = :relieveorderdate"),
		@NamedQuery(name = "ViewEmpTransfer.findByRelievedate", query = "SELECT v FROM ViewEmpTransfer v WHERE v.relievedate = :relievedate"),
		@NamedQuery(name = "ViewEmpTransfer.findByRelieveanfn", query = "SELECT v FROM ViewEmpTransfer v WHERE v.relieveanfn = :relieveanfn"),
		@NamedQuery(name = "ViewEmpTransfer.findByPpNoduesdetailid", query = "SELECT v FROM ViewEmpTransfer v WHERE v.ppNoduesdetailid = :ppNoduesdetailid"),
		@NamedQuery(name = "ViewEmpTransfer.findByJoiningdate", query = "SELECT v FROM ViewEmpTransfer v WHERE v.joiningdate = :joiningdate") })
public class ViewEmpTransfer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "PP_TRANSFERDETAILID")
	private long ppTransferdetailid;
	@Basic(optional = false)
	@Column(name = "TRANSFERORDERNO")
	private String transferorderno;
	@Basic(optional = false)
	@Column(name = "TRANSFERORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transferorderdate;
	@Basic(optional = false)
	@Column(name = "OFFICEFROMID")
	private int officefromid;
	@Basic(optional = false)
	@Column(name = "FROMOFFICE")
	private String fromoffice;
	@Basic(optional = false)
	@Column(name = "TOOFFICE")
	private String tooffice;
	@Basic(optional = false)
	@Column(name = "OFFICETOID")
	private int officetoid;
	@Basic(optional = false)
	@Column(name = "RELIEVEORDERNO")
	private String relieveorderno;
	@Basic(optional = false)
	@Column(name = "RELIEVEORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relieveorderdate;
	@Basic(optional = false)
	@Column(name = "RELIEVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relievedate;
	@Basic(optional = false)
	@Column(name = "RELIEVEANFN")
	private String relieveanfn;
	@Basic(optional = false)
	@Column(name = "PP_NODUESDETAILID")
	private long ppNoduesdetailid;
	@Column(name = "JOININGDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date joiningdate;

	public ViewEmpTransfer() {
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

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getPpTransferdetailid() {
		return ppTransferdetailid;
	}

	public void setPpTransferdetailid(long ppTransferdetailid) {
		this.ppTransferdetailid = ppTransferdetailid;
	}

	public String getTransferorderno() {
		return transferorderno;
	}

	public void setTransferorderno(String transferorderno) {
		this.transferorderno = transferorderno;
	}

	public Date getTransferorderdate() {
		return transferorderdate;
	}

	public void setTransferorderdate(Date transferorderdate) {
		this.transferorderdate = transferorderdate;
	}

	public int getOfficefromid() {
		return officefromid;
	}

	public void setOfficefromid(int officefromid) {
		this.officefromid = officefromid;
	}

	public String getFromoffice() {
		return fromoffice;
	}

	public void setFromoffice(String fromoffice) {
		this.fromoffice = fromoffice;
	}

	public String getTooffice() {
		return tooffice;
	}

	public void setTooffice(String tooffice) {
		this.tooffice = tooffice;
	}

	public int getOfficetoid() {
		return officetoid;
	}

	public void setOfficetoid(int officetoid) {
		this.officetoid = officetoid;
	}

	public String getRelieveorderno() {
		return relieveorderno;
	}

	public void setRelieveorderno(String relieveorderno) {
		this.relieveorderno = relieveorderno;
	}

	public Date getRelieveorderdate() {
		return relieveorderdate;
	}

	public void setRelieveorderdate(Date relieveorderdate) {
		this.relieveorderdate = relieveorderdate;
	}

	public Date getRelievedate() {
		return relievedate;
	}

	public void setRelievedate(Date relievedate) {
		this.relievedate = relievedate;
	}

	public String getRelieveanfn() {
		return relieveanfn;
	}

	public void setRelieveanfn(String relieveanfn) {
		this.relieveanfn = relieveanfn;
	}

	public long getPpNoduesdetailid() {
		return ppNoduesdetailid;
	}

	public void setPpNoduesdetailid(long ppNoduesdetailid) {
		this.ppNoduesdetailid = ppNoduesdetailid;
	}

	public Date getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

}
