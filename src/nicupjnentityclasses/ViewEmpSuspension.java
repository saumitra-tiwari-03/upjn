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
@Table(name = "VIEW_EMP_SUSPENSION")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewEmpSuspension.findAll", query = "SELECT v FROM ViewEmpSuspension v"),
		@NamedQuery(name = "ViewEmpSuspension.findByPpEmployeemasterid", query = "SELECT v FROM ViewEmpSuspension v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewEmpSuspension.findByEmployeecode", query = "SELECT v FROM ViewEmpSuspension v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEmpSuspension.findByEmployeename", query = "SELECT v FROM ViewEmpSuspension v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEmpSuspension.findByRmOfficeid", query = "SELECT v FROM ViewEmpSuspension v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewEmpSuspension.findByDesignation", query = "SELECT v FROM ViewEmpSuspension v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewEmpSuspension.findByPpSuspensiondetailid", query = "SELECT v FROM ViewEmpSuspension v WHERE v.ppSuspensiondetailid = :ppSuspensiondetailid"),
		@NamedQuery(name = "ViewEmpSuspension.findBySuspensionordno", query = "SELECT v FROM ViewEmpSuspension v WHERE v.suspensionordno = :suspensionordno"),
		@NamedQuery(name = "ViewEmpSuspension.findBySuspensionorddate", query = "SELECT v FROM ViewEmpSuspension v WHERE v.suspensionorddate = :suspensionorddate"),
		@NamedQuery(name = "ViewEmpSuspension.findByOrderauthname", query = "SELECT v FROM ViewEmpSuspension v WHERE v.orderauthname = :orderauthname"),
		@NamedQuery(name = "ViewEmpSuspension.findByEffectivedate", query = "SELECT v FROM ViewEmpSuspension v WHERE v.effectivedate = :effectivedate"),
		@NamedQuery(name = "ViewEmpSuspension.findByOrderauthdesig", query = "SELECT v FROM ViewEmpSuspension v WHERE v.orderauthdesig = :orderauthdesig"),
		@NamedQuery(name = "ViewEmpSuspension.findByReasonforsuspension", query = "SELECT v FROM ViewEmpSuspension v WHERE v.reasonforsuspension = :reasonforsuspension"),
		@NamedQuery(name = "ViewEmpSuspension.findByReinstateeffectdate", query = "SELECT v FROM ViewEmpSuspension v WHERE v.reinstateeffectdate = :reinstateeffectdate") })
public class ViewEmpSuspension implements Serializable {
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
	@Column(name = "PP_SUSPENSIONDETAILID")
	private long ppSuspensiondetailid;
	@Basic(optional = false)
	@Column(name = "SUSPENSIONORDNO")
	private String suspensionordno;
	@Basic(optional = false)
	@Column(name = "SUSPENSIONORDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date suspensionorddate;
	@Basic(optional = false)
	@Column(name = "ORDERAUTHNAME")
	private String orderauthname;
	@Basic(optional = false)
	@Column(name = "EFFECTIVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date effectivedate;
	@Basic(optional = false)
	@Column(name = "ORDERAUTHDESIG")
	private String orderauthdesig;
	@Column(name = "REASONFORSUSPENSION")
	private String reasonforsuspension;
	@Column(name = "REINSTATEEFFECTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reinstateeffectdate;

	public ViewEmpSuspension() {
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

	public long getPpSuspensiondetailid() {
		return ppSuspensiondetailid;
	}

	public void setPpSuspensiondetailid(long ppSuspensiondetailid) {
		this.ppSuspensiondetailid = ppSuspensiondetailid;
	}

	public String getSuspensionordno() {
		return suspensionordno;
	}

	public void setSuspensionordno(String suspensionordno) {
		this.suspensionordno = suspensionordno;
	}

	public Date getSuspensionorddate() {
		return suspensionorddate;
	}

	public void setSuspensionorddate(Date suspensionorddate) {
		this.suspensionorddate = suspensionorddate;
	}

	public String getOrderauthname() {
		return orderauthname;
	}

	public void setOrderauthname(String orderauthname) {
		this.orderauthname = orderauthname;
	}

	public Date getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}

	public String getOrderauthdesig() {
		return orderauthdesig;
	}

	public void setOrderauthdesig(String orderauthdesig) {
		this.orderauthdesig = orderauthdesig;
	}

	public String getReasonforsuspension() {
		return reasonforsuspension;
	}

	public void setReasonforsuspension(String reasonforsuspension) {
		this.reasonforsuspension = reasonforsuspension;
	}

	public Date getReinstateeffectdate() {
		return reinstateeffectdate;
	}

	public void setReinstateeffectdate(Date reinstateeffectdate) {
		this.reinstateeffectdate = reinstateeffectdate;
	}

}
