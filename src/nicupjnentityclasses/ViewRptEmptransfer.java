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
@Table(name = "VIEW_RPT_EMPTRANSFER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewRptEmptransfer.findAll", query = "SELECT v FROM ViewRptEmptransfer v"),
		@NamedQuery(name = "ViewRptEmptransfer.findByEmployeename", query = "SELECT v FROM ViewRptEmptransfer v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewRptEmptransfer.findByEmployeecode", query = "SELECT v FROM ViewRptEmptransfer v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewRptEmptransfer.findByOfficefrom", query = "SELECT v FROM ViewRptEmptransfer v WHERE v.officefrom = :officefrom"),
		@NamedQuery(name = "ViewRptEmptransfer.findByOfficeto", query = "SELECT v FROM ViewRptEmptransfer v WHERE v.officeto = :officeto"),
		@NamedQuery(name = "ViewRptEmptransfer.findByTransferorderno", query = "SELECT v FROM ViewRptEmptransfer v WHERE v.transferorderno = :transferorderno"),
		@NamedQuery(name = "ViewRptEmptransfer.findByTransferorderdate", query = "SELECT v FROM ViewRptEmptransfer v WHERE v.transferorderdate = :transferorderdate"),
		@NamedQuery(name = "ViewRptEmptransfer.findByRelieveorderdate", query = "SELECT v FROM ViewRptEmptransfer v WHERE v.relieveorderdate = :relieveorderdate"),
		@NamedQuery(name = "ViewRptEmptransfer.findByRelievedate", query = "SELECT v FROM ViewRptEmptransfer v WHERE v.relievedate = :relievedate") })
public class ViewRptEmptransfer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Basic(optional = false)
	@Column(name = "OFFICEFROM")
	private String officefrom;
	@Basic(optional = false)
	@Column(name = "OFFICETO")
	private String officeto;
	@Basic(optional = false)
	@Column(name = "TRANSFERORDERNO")
	private String transferorderno;
	@Basic(optional = false)
	@Column(name = "TRANSFERORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transferorderdate;
	@Basic(optional = false)
	@Column(name = "RELIEVEORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relieveorderdate;
	@Basic(optional = false)
	@Column(name = "RELIEVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relievedate;

	public ViewRptEmptransfer() {
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getOfficefrom() {
		return officefrom;
	}

	public void setOfficefrom(String officefrom) {
		this.officefrom = officefrom;
	}

	public String getOfficeto() {
		return officeto;
	}

	public void setOfficeto(String officeto) {
		this.officeto = officeto;
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

}
