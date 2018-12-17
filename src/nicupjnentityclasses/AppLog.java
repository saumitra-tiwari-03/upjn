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
import javax.persistence.Id;
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
@Table(name = "APP_LOG")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "AppLog.findAll", query = "SELECT a FROM AppLog a"),
		@NamedQuery(name = "AppLog.findByIpaddress", query = "SELECT a FROM AppLog a WHERE a.ipaddress = :ipaddress"),
		@NamedQuery(name = "AppLog.findByExecutiondate", query = "SELECT a FROM AppLog a WHERE a.executiondate = :executiondate"),
		@NamedQuery(name = "AppLog.findByRmOfficeid", query = "SELECT a FROM AppLog a WHERE a.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "AppLog.findByUsername", query = "SELECT a FROM AppLog a WHERE a.username = :username"),
		@NamedQuery(name = "AppLog.findByActionname", query = "SELECT a FROM AppLog a WHERE a.actionname = :actionname"),
		@NamedQuery(name = "AppLog.findByMethodname", query = "SELECT a FROM AppLog a WHERE a.methodname = :methodname"),
		@NamedQuery(name = "AppLog.findByQuerystring", query = "SELECT a FROM AppLog a WHERE a.querystring = :querystring"),
		@NamedQuery(name = "AppLog.findByAppLogid", query = "SELECT a FROM AppLog a WHERE a.appLogid = :appLogid") })
public class AppLog implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "IPADDRESS")
	private String ipaddress;
	@Basic(optional = false)
	@Column(name = "EXECUTIONDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date executiondate;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Basic(optional = false)
	@Column(name = "USERNAME")
	private String username;
	@Basic(optional = false)
	@Column(name = "ACTIONNAME")
	private String actionname;
	@Column(name = "METHODNAME")
	private String methodname;
	@Basic(optional = false)
	@Column(name = "QUERYSTRING")
	private String querystring;
	@Id
	@Basic(optional = false)
	@Column(name = "APP_LOGID")
	private Long appLogid;

	public AppLog() {
	}

	public AppLog(Long appLogid) {
		this.appLogid = appLogid;
	}

	public AppLog(Long appLogid, String ipaddress, Date executiondate, int rmOfficeid, String username,
			String actionname, String querystring) {
		this.appLogid = appLogid;
		this.ipaddress = ipaddress;
		this.executiondate = executiondate;
		this.rmOfficeid = rmOfficeid;
		this.username = username;
		this.actionname = actionname;
		this.querystring = querystring;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public Date getExecutiondate() {
		return executiondate;
	}

	public void setExecutiondate(Date executiondate) {
		this.executiondate = executiondate;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getActionname() {
		return actionname;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname;
	}

	public String getMethodname() {
		return methodname;
	}

	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}

	public String getQuerystring() {
		return querystring;
	}

	public void setQuerystring(String querystring) {
		this.querystring = querystring;
	}

	public Long getAppLogid() {
		return appLogid;
	}

	public void setAppLogid(Long appLogid) {
		this.appLogid = appLogid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (appLogid != null ? appLogid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof AppLog)) {
			return false;
		}
		AppLog other = (AppLog) object;
		if ((this.appLogid == null && other.appLogid != null)
				|| (this.appLogid != null && !this.appLogid.equals(other.appLogid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.AppLog[ appLogid=" + appLogid + " ]";
	}

}
