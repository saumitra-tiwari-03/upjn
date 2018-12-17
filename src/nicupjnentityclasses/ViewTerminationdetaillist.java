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
@Table(name = "VIEW_TERMINATIONDETAILLIST")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewTerminationdetaillist.findAll", query = "SELECT v FROM ViewTerminationdetaillist v"),
		@NamedQuery(name = "ViewTerminationdetaillist.findByPpEmployeemasterid", query = "SELECT v FROM ViewTerminationdetaillist v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewTerminationdetaillist.findByEmployeecode", query = "SELECT v FROM ViewTerminationdetaillist v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewTerminationdetaillist.findByEmployeename", query = "SELECT v FROM ViewTerminationdetaillist v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewTerminationdetaillist.findByRmOfficeid", query = "SELECT v FROM ViewTerminationdetaillist v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewTerminationdetaillist.findByDesignation", query = "SELECT v FROM ViewTerminationdetaillist v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewTerminationdetaillist.findByPpTerminationdetailid", query = "SELECT v FROM ViewTerminationdetaillist v WHERE v.ppTerminationdetailid = :ppTerminationdetailid"),
		@NamedQuery(name = "ViewTerminationdetaillist.findByTerminationordno", query = "SELECT v FROM ViewTerminationdetaillist v WHERE v.terminationordno = :terminationordno"),
		@NamedQuery(name = "ViewTerminationdetaillist.findByTerminationorddate", query = "SELECT v FROM ViewTerminationdetaillist v WHERE v.terminationorddate = :terminationorddate"),
		@NamedQuery(name = "ViewTerminationdetaillist.findByOrderauthname", query = "SELECT v FROM ViewTerminationdetaillist v WHERE v.orderauthname = :orderauthname"),
		@NamedQuery(name = "ViewTerminationdetaillist.findByEffectivedate", query = "SELECT v FROM ViewTerminationdetaillist v WHERE v.effectivedate = :effectivedate"),
		@NamedQuery(name = "ViewTerminationdetaillist.findByOrderauthdesig", query = "SELECT v FROM ViewTerminationdetaillist v WHERE v.orderauthdesig = :orderauthdesig"),
		@NamedQuery(name = "ViewTerminationdetaillist.findByEventofficeid", query = "SELECT v FROM ViewTerminationdetaillist v WHERE v.eventofficeid = :eventofficeid"),
		@NamedQuery(name = "ViewTerminationdetaillist.findByReasonfortermination", query = "SELECT v FROM ViewTerminationdetaillist v WHERE v.reasonfortermination = :reasonfortermination"),
		@NamedQuery(name = "ViewTerminationdetaillist.findByReinstateeffectdate", query = "SELECT v FROM ViewTerminationdetaillist v WHERE v.reinstateeffectdate = :reinstateeffectdate") })
public class ViewTerminationdetaillist implements Serializable {
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
	@Column(name = "PP_TERMINATIONDETAILID")
	private long ppTerminationdetailid;
	@Basic(optional = false)
	@Column(name = "TERMINATIONORDNO")
	private String terminationordno;
	@Basic(optional = false)
	@Column(name = "TERMINATIONORDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date terminationorddate;
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
	@Basic(optional = false)
	@Column(name = "EVENTOFFICEID")
	private int eventofficeid;
	@Column(name = "REASONFORTERMINATION")
	private String reasonfortermination;
	@Column(name = "REINSTATEEFFECTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reinstateeffectdate;

	public ViewTerminationdetaillist() {
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

	public long getPpTerminationdetailid() {
		return ppTerminationdetailid;
	}

	public void setPpTerminationdetailid(long ppTerminationdetailid) {
		this.ppTerminationdetailid = ppTerminationdetailid;
	}

	public String getTerminationordno() {
		return terminationordno;
	}

	public void setTerminationordno(String terminationordno) {
		this.terminationordno = terminationordno;
	}

	public Date getTerminationorddate() {
		return terminationorddate;
	}

	public void setTerminationorddate(Date terminationorddate) {
		this.terminationorddate = terminationorddate;
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

	public int getEventofficeid() {
		return eventofficeid;
	}

	public void setEventofficeid(int eventofficeid) {
		this.eventofficeid = eventofficeid;
	}

	public String getReasonfortermination() {
		return reasonfortermination;
	}

	public void setReasonfortermination(String reasonfortermination) {
		this.reasonfortermination = reasonfortermination;
	}

	public Date getReinstateeffectdate() {
		return reinstateeffectdate;
	}

	public void setReinstateeffectdate(Date reinstateeffectdate) {
		this.reinstateeffectdate = reinstateeffectdate;
	}

}
