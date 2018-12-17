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
@Table(name = "VIEW_PSN_NODUES")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPsnNodues.findAll", query = "SELECT v FROM ViewPsnNodues v"),
		@NamedQuery(name = "ViewPsnNodues.findByPrepsnServicedetailid", query = "SELECT v FROM ViewPsnNodues v WHERE v.prepsnServicedetailid = :prepsnServicedetailid"),
		@NamedQuery(name = "ViewPsnNodues.findByPrepsnRegistrationmasterid", query = "SELECT v FROM ViewPsnNodues v WHERE v.prepsnRegistrationmasterid = :prepsnRegistrationmasterid"),
		@NamedQuery(name = "ViewPsnNodues.findByEmployeecode", query = "SELECT v FROM ViewPsnNodues v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewPsnNodues.findByEmployeename", query = "SELECT v FROM ViewPsnNodues v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPsnNodues.findByPsnDesignationmasterid", query = "SELECT v FROM ViewPsnNodues v WHERE v.psnDesignationmasterid = :psnDesignationmasterid"),
		@NamedQuery(name = "ViewPsnNodues.findByFromdate", query = "SELECT v FROM ViewPsnNodues v WHERE v.fromdate = :fromdate"),
		@NamedQuery(name = "ViewPsnNodues.findByTodate", query = "SELECT v FROM ViewPsnNodues v WHERE v.todate = :todate"),
		@NamedQuery(name = "ViewPsnNodues.findByRmOfficeid", query = "SELECT v FROM ViewPsnNodues v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPsnNodues.findByOfficename", query = "SELECT v FROM ViewPsnNodues v WHERE v.officename = :officename"),
		@NamedQuery(name = "ViewPsnNodues.findByDesignation", query = "SELECT v FROM ViewPsnNodues v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewPsnNodues.findByPpDesignationmasterid", query = "SELECT v FROM ViewPsnNodues v WHERE v.ppDesignationmasterid = :ppDesignationmasterid") })
public class ViewPsnNodues implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PREPSN_SERVICEDETAILID")
	private long prepsnServicedetailid;
	@Basic(optional = false)
	@Column(name = "PREPSN_REGISTRATIONMASTERID")
	private long prepsnRegistrationmasterid;
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Basic(optional = false)
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "PSN_DESIGNATIONMASTERID")
	private int psnDesignationmasterid;
	@Column(name = "FROMDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromdate;
	@Column(name = "TODATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date todate;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Basic(optional = false)
	@Column(name = "OFFICENAME")
	private String officename;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Integer ppDesignationmasterid;

	public ViewPsnNodues() {
	}

	public long getPrepsnServicedetailid() {
		return prepsnServicedetailid;
	}

	public void setPrepsnServicedetailid(long prepsnServicedetailid) {
		this.prepsnServicedetailid = prepsnServicedetailid;
	}

	public long getPrepsnRegistrationmasterid() {
		return prepsnRegistrationmasterid;
	}

	public void setPrepsnRegistrationmasterid(long prepsnRegistrationmasterid) {
		this.prepsnRegistrationmasterid = prepsnRegistrationmasterid;
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

	public int getPsnDesignationmasterid() {
		return psnDesignationmasterid;
	}

	public void setPsnDesignationmasterid(int psnDesignationmasterid) {
		this.psnDesignationmasterid = psnDesignationmasterid;
	}

	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	public Date getTodate() {
		return todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(Integer ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

}
