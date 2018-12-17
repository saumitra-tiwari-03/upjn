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
@Table(name = "VIEW_CHECKLIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewChecklist.findAll", query = "SELECT v FROM ViewChecklist v"),
		@NamedQuery(name = "ViewChecklist.findByPpChecklistid", query = "SELECT v FROM ViewChecklist v WHERE v.ppChecklistid = :ppChecklistid"),
		@NamedQuery(name = "ViewChecklist.findByEmployeecode", query = "SELECT v FROM ViewChecklist v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewChecklist.findByEmployeename", query = "SELECT v FROM ViewChecklist v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewChecklist.findByOldvalue", query = "SELECT v FROM ViewChecklist v WHERE v.oldvalue = :oldvalue"),
		@NamedQuery(name = "ViewChecklist.findByNewvalue", query = "SELECT v FROM ViewChecklist v WHERE v.newvalue = :newvalue"),
		@NamedQuery(name = "ViewChecklist.findByDescription", query = "SELECT v FROM ViewChecklist v WHERE v.description = :description"),
		@NamedQuery(name = "ViewChecklist.findByExecutiondate", query = "SELECT v FROM ViewChecklist v WHERE v.executiondate = :executiondate"),
		@NamedQuery(name = "ViewChecklist.findByUsername", query = "SELECT v FROM ViewChecklist v WHERE v.username = :username"),
		@NamedQuery(name = "ViewChecklist.findByRmOfficeid", query = "SELECT v FROM ViewChecklist v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewChecklist.findByAppLogid", query = "SELECT v FROM ViewChecklist v WHERE v.appLogid = :appLogid"),
		@NamedQuery(name = "ViewChecklist.findByRegister", query = "SELECT v FROM ViewChecklist v WHERE v.register = :register") })
public class ViewChecklist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_CHECKLISTID")
	private String ppChecklistid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "OLDVALUE")
	private String oldvalue;
	@Column(name = "NEWVALUE")
	private String newvalue;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "EXECUTIONDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date executiondate;
	@Basic(optional = false)
	@Column(name = "USERNAME")
	private String username;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Basic(optional = false)
	@Column(name = "APP_LOGID")
	private long appLogid;
	@Column(name = "REGISTER")
	private Short register;

	public ViewChecklist() {
	}

	public String getPpChecklistid() {
		return ppChecklistid;
	}

	public void setPpChecklistid(String ppChecklistid) {
		this.ppChecklistid = ppChecklistid;
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

	public String getOldvalue() {
		return oldvalue;
	}

	public void setOldvalue(String oldvalue) {
		this.oldvalue = oldvalue;
	}

	public String getNewvalue() {
		return newvalue;
	}

	public void setNewvalue(String newvalue) {
		this.newvalue = newvalue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExecutiondate() {
		return executiondate;
	}

	public void setExecutiondate(Date executiondate) {
		this.executiondate = executiondate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public long getAppLogid() {
		return appLogid;
	}

	public void setAppLogid(long appLogid) {
		this.appLogid = appLogid;
	}

	public Short getRegister() {
		return register;
	}

	public void setRegister(Short register) {
		this.register = register;
	}

}
