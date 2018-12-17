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
@Table(name = "VIEW_SANCTION_ORDER_EMPLOYEE")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewSanctionOrderEmployee.findAll", query = "SELECT v FROM ViewSanctionOrderEmployee v"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findBySanctionorderno", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.sanctionorderno = :sanctionorderno"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findBySanctionorderdate", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.sanctionorderdate = :sanctionorderdate"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findBySanctioningauthority", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.sanctioningauthority = :sanctioningauthority"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findByPpEmployeemasterid", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findByEmployeecode", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findByDesignation", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findByEmployeename", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findByLeavetype", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.leavetype = :leavetype"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findByFromdate", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.fromdate = :fromdate"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findByTodate", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.todate = :todate"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findByPpLeavesanctionorderid", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.ppLeavesanctionorderid = :ppLeavesanctionorderid"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findByPpAvailedleavedetailid", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.ppAvailedleavedetailid = :ppAvailedleavedetailid"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findByIsdebited", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.isdebited = :isdebited"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findBySysLeavetypemasterid", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.sysLeavetypemasterid = :sysLeavetypemasterid"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findByGroundforleave", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.groundforleave = :groundforleave"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findByIsadvanceleave", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.isadvanceleave = :isadvanceleave"),
		@NamedQuery(name = "ViewSanctionOrderEmployee.findByFullpayapplicable", query = "SELECT v FROM ViewSanctionOrderEmployee v WHERE v.fullpayapplicable = :fullpayapplicable") })
public class ViewSanctionOrderEmployee implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "SANCTIONORDERNO")
	private String sanctionorderno;
	@Basic(optional = false)
	@Column(name = "SANCTIONORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sanctionorderdate;
	@Basic(optional = false)
	@Column(name = "SANCTIONINGAUTHORITY")
	private String sanctioningauthority;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "LEAVETYPE")
	private String leavetype;
	@Basic(optional = false)
	@Column(name = "FROMDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromdate;
	@Basic(optional = false)
	@Column(name = "TODATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date todate;
	@Basic(optional = false)
	@Column(name = "PP_LEAVESANCTIONORDERID")
	private long ppLeavesanctionorderid;
	@Basic(optional = false)
	@Column(name = "PP_AVAILEDLEAVEDETAILID")
	private long ppAvailedleavedetailid;
	@Basic(optional = false)
	@Column(name = "ISDEBITED")
	private Character isdebited;
	@Basic(optional = false)
	@Column(name = "SYS_LEAVETYPEMASTERID")
	private long sysLeavetypemasterid;
	@Basic(optional = false)
	@Column(name = "GROUNDFORLEAVE")
	private String groundforleave;
	@Basic(optional = false)
	@Column(name = "ISADVANCELEAVE")
	private Character isadvanceleave;
	@Basic(optional = false)
	@Column(name = "FULLPAYAPPLICABLE")
	private String fullpayapplicable;

	public ViewSanctionOrderEmployee() {
	}

	public String getSanctionorderno() {
		return sanctionorderno;
	}

	public void setSanctionorderno(String sanctionorderno) {
		this.sanctionorderno = sanctionorderno;
	}

	public Date getSanctionorderdate() {
		return sanctionorderdate;
	}

	public void setSanctionorderdate(Date sanctionorderdate) {
		this.sanctionorderdate = sanctionorderdate;
	}

	public String getSanctioningauthority() {
		return sanctioningauthority;
	}

	public void setSanctioningauthority(String sanctioningauthority) {
		this.sanctioningauthority = sanctioningauthority;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
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

	public long getPpLeavesanctionorderid() {
		return ppLeavesanctionorderid;
	}

	public void setPpLeavesanctionorderid(long ppLeavesanctionorderid) {
		this.ppLeavesanctionorderid = ppLeavesanctionorderid;
	}

	public long getPpAvailedleavedetailid() {
		return ppAvailedleavedetailid;
	}

	public void setPpAvailedleavedetailid(long ppAvailedleavedetailid) {
		this.ppAvailedleavedetailid = ppAvailedleavedetailid;
	}

	public Character getIsdebited() {
		return isdebited;
	}

	public void setIsdebited(Character isdebited) {
		this.isdebited = isdebited;
	}

	public long getSysLeavetypemasterid() {
		return sysLeavetypemasterid;
	}

	public void setSysLeavetypemasterid(long sysLeavetypemasterid) {
		this.sysLeavetypemasterid = sysLeavetypemasterid;
	}

	public String getGroundforleave() {
		return groundforleave;
	}

	public void setGroundforleave(String groundforleave) {
		this.groundforleave = groundforleave;
	}

	public Character getIsadvanceleave() {
		return isadvanceleave;
	}

	public void setIsadvanceleave(Character isadvanceleave) {
		this.isadvanceleave = isadvanceleave;
	}

	public String getFullpayapplicable() {
		return fullpayapplicable;
	}

	public void setFullpayapplicable(String fullpayapplicable) {
		this.fullpayapplicable = fullpayapplicable;
	}

}
