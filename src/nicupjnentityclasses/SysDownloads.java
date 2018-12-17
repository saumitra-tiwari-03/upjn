/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "SYS_DOWNLOADS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SysDownloads.findAll", query = "SELECT s FROM SysDownloads s"),
		@NamedQuery(name = "SysDownloads.findBySysDownloadsid", query = "SELECT s FROM SysDownloads s WHERE s.sysDownloadsid = :sysDownloadsid"),
		@NamedQuery(name = "SysDownloads.findByFilename", query = "SELECT s FROM SysDownloads s WHERE s.filename = :filename"),
		@NamedQuery(name = "SysDownloads.findByLabel", query = "SELECT s FROM SysDownloads s WHERE s.label = :label"),
		@NamedQuery(name = "SysDownloads.findByIsvisible", query = "SELECT s FROM SysDownloads s WHERE s.isvisible = :isvisible") })
public class SysDownloads implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SYS_DOWNLOADSID")
	private Integer sysDownloadsid;
	@Basic(optional = false)
	@Column(name = "FILENAME")
	private String filename;
	@Basic(optional = false)
	@Column(name = "LABEL")
	private String label;
	@Basic(optional = false)
	@Column(name = "ISVISIBLE")
	private Character isvisible;

	public SysDownloads() {
	}

	public SysDownloads(Integer sysDownloadsid) {
		this.sysDownloadsid = sysDownloadsid;
	}

	public SysDownloads(Integer sysDownloadsid, String filename, String label, Character isvisible) {
		this.sysDownloadsid = sysDownloadsid;
		this.filename = filename;
		this.label = label;
		this.isvisible = isvisible;
	}

	public Integer getSysDownloadsid() {
		return sysDownloadsid;
	}

	public void setSysDownloadsid(Integer sysDownloadsid) {
		this.sysDownloadsid = sysDownloadsid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Character getIsvisible() {
		return isvisible;
	}

	public void setIsvisible(Character isvisible) {
		this.isvisible = isvisible;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (sysDownloadsid != null ? sysDownloadsid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SysDownloads)) {
			return false;
		}
		SysDownloads other = (SysDownloads) object;
		if ((this.sysDownloadsid == null && other.sysDownloadsid != null)
				|| (this.sysDownloadsid != null && !this.sysDownloadsid.equals(other.sysDownloadsid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SysDownloads[ sysDownloadsid=" + sysDownloadsid + " ]";
	}

}
