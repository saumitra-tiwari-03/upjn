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
@Table(name = "VIEW_EMPDEPUTATION")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewEmpdeputation.findAll", query = "SELECT v FROM ViewEmpdeputation v"),
		@NamedQuery(name = "ViewEmpdeputation.findByPpEmployeemasterid", query = "SELECT v FROM ViewEmpdeputation v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewEmpdeputation.findByEmployeecode", query = "SELECT v FROM ViewEmpdeputation v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEmpdeputation.findByEmployeename", query = "SELECT v FROM ViewEmpdeputation v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEmpdeputation.findByRmOfficeid", query = "SELECT v FROM ViewEmpdeputation v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewEmpdeputation.findByDesignation", query = "SELECT v FROM ViewEmpdeputation v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewEmpdeputation.findByPpDeputationdetailid", query = "SELECT v FROM ViewEmpdeputation v WHERE v.ppDeputationdetailid = :ppDeputationdetailid"),
		@NamedQuery(name = "ViewEmpdeputation.findByDeputationorderno", query = "SELECT v FROM ViewEmpdeputation v WHERE v.deputationorderno = :deputationorderno"),
		@NamedQuery(name = "ViewEmpdeputation.findByDeputationorderdate", query = "SELECT v FROM ViewEmpdeputation v WHERE v.deputationorderdate = :deputationorderdate"),
		@NamedQuery(name = "ViewEmpdeputation.findByTargetoffice", query = "SELECT v FROM ViewEmpdeputation v WHERE v.targetoffice = :targetoffice"),
		@NamedQuery(name = "ViewEmpdeputation.findByRelieveorderno", query = "SELECT v FROM ViewEmpdeputation v WHERE v.relieveorderno = :relieveorderno"),
		@NamedQuery(name = "ViewEmpdeputation.findByRelieveorderdate", query = "SELECT v FROM ViewEmpdeputation v WHERE v.relieveorderdate = :relieveorderdate"),
		@NamedQuery(name = "ViewEmpdeputation.findByRelievedate", query = "SELECT v FROM ViewEmpdeputation v WHERE v.relievedate = :relievedate"),
		@NamedQuery(name = "ViewEmpdeputation.findByRelieveanfn", query = "SELECT v FROM ViewEmpdeputation v WHERE v.relieveanfn = :relieveanfn"),
		@NamedQuery(name = "ViewEmpdeputation.findByPpNoduesdetailid", query = "SELECT v FROM ViewEmpdeputation v WHERE v.ppNoduesdetailid = :ppNoduesdetailid"),
		@NamedQuery(name = "ViewEmpdeputation.findByFromofficename", query = "SELECT v FROM ViewEmpdeputation v WHERE v.fromofficename = :fromofficename") })
public class ViewEmpdeputation implements Serializable {
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
	@Column(name = "PP_DEPUTATIONDETAILID")
	private long ppDeputationdetailid;
	@Column(name = "DEPUTATIONORDERNO")
	private String deputationorderno;
	@Column(name = "DEPUTATIONORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deputationorderdate;
	@Column(name = "TARGETOFFICE")
	private String targetoffice;
	@Column(name = "RELIEVEORDERNO")
	private String relieveorderno;
	@Column(name = "RELIEVEORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relieveorderdate;
	@Column(name = "RELIEVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relievedate;
	@Column(name = "RELIEVEANFN")
	private String relieveanfn;
	@Column(name = "PP_NODUESDETAILID")
	private Long ppNoduesdetailid;
	@Basic(optional = false)
	@Column(name = "FROMOFFICENAME")
	private String fromofficename;

	public ViewEmpdeputation() {
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

	public long getPpDeputationdetailid() {
		return ppDeputationdetailid;
	}

	public void setPpDeputationdetailid(long ppDeputationdetailid) {
		this.ppDeputationdetailid = ppDeputationdetailid;
	}

	public String getDeputationorderno() {
		return deputationorderno;
	}

	public void setDeputationorderno(String deputationorderno) {
		this.deputationorderno = deputationorderno;
	}

	public Date getDeputationorderdate() {
		return deputationorderdate;
	}

	public void setDeputationorderdate(Date deputationorderdate) {
		this.deputationorderdate = deputationorderdate;
	}

	public String getTargetoffice() {
		return targetoffice;
	}

	public void setTargetoffice(String targetoffice) {
		this.targetoffice = targetoffice;
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

	public Long getPpNoduesdetailid() {
		return ppNoduesdetailid;
	}

	public void setPpNoduesdetailid(Long ppNoduesdetailid) {
		this.ppNoduesdetailid = ppNoduesdetailid;
	}

	public String getFromofficename() {
		return fromofficename;
	}

	public void setFromofficename(String fromofficename) {
		this.fromofficename = fromofficename;
	}

}
