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
@Table(name = "VIEW_EMPINFOFORREINS_TERM")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewEmpinfoforreinsTerm.findAll", query = "SELECT v FROM ViewEmpinfoforreinsTerm v"),
		@NamedQuery(name = "ViewEmpinfoforreinsTerm.findByPpTerminationdetailid", query = "SELECT v FROM ViewEmpinfoforreinsTerm v WHERE v.ppTerminationdetailid = :ppTerminationdetailid"),
		@NamedQuery(name = "ViewEmpinfoforreinsTerm.findByEmployeecode", query = "SELECT v FROM ViewEmpinfoforreinsTerm v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEmpinfoforreinsTerm.findByPpEmployeemasterid", query = "SELECT v FROM ViewEmpinfoforreinsTerm v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewEmpinfoforreinsTerm.findByEmployeename", query = "SELECT v FROM ViewEmpinfoforreinsTerm v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEmpinfoforreinsTerm.findByDesignation", query = "SELECT v FROM ViewEmpinfoforreinsTerm v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewEmpinfoforreinsTerm.findByTerminationordno", query = "SELECT v FROM ViewEmpinfoforreinsTerm v WHERE v.terminationordno = :terminationordno"),
		@NamedQuery(name = "ViewEmpinfoforreinsTerm.findByTerminationorddate", query = "SELECT v FROM ViewEmpinfoforreinsTerm v WHERE v.terminationorddate = :terminationorddate"),
		@NamedQuery(name = "ViewEmpinfoforreinsTerm.findByEffectivedate", query = "SELECT v FROM ViewEmpinfoforreinsTerm v WHERE v.effectivedate = :effectivedate"),
		@NamedQuery(name = "ViewEmpinfoforreinsTerm.findByOrderauthname", query = "SELECT v FROM ViewEmpinfoforreinsTerm v WHERE v.orderauthname = :orderauthname"),
		@NamedQuery(name = "ViewEmpinfoforreinsTerm.findByOrderauthdesig", query = "SELECT v FROM ViewEmpinfoforreinsTerm v WHERE v.orderauthdesig = :orderauthdesig") })
public class ViewEmpinfoforreinsTerm implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_TERMINATIONDETAILID")
	private long ppTerminationdetailid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "TERMINATIONORDNO")
	private String terminationordno;
	@Basic(optional = false)
	@Column(name = "TERMINATIONORDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date terminationorddate;
	@Basic(optional = false)
	@Column(name = "EFFECTIVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date effectivedate;
	@Basic(optional = false)
	@Column(name = "ORDERAUTHNAME")
	private String orderauthname;
	@Basic(optional = false)
	@Column(name = "ORDERAUTHDESIG")
	private String orderauthdesig;

	public ViewEmpinfoforreinsTerm() {
	}

	public long getPpTerminationdetailid() {
		return ppTerminationdetailid;
	}

	public void setPpTerminationdetailid(long ppTerminationdetailid) {
		this.ppTerminationdetailid = ppTerminationdetailid;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	public Date getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}

	public String getOrderauthname() {
		return orderauthname;
	}

	public void setOrderauthname(String orderauthname) {
		this.orderauthname = orderauthname;
	}

	public String getOrderauthdesig() {
		return orderauthdesig;
	}

	public void setOrderauthdesig(String orderauthdesig) {
		this.orderauthdesig = orderauthdesig;
	}

}
