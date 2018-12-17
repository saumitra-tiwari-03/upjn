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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "SYS_SP_SCHCAT_PROGMAP")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SysSpSchcatProgmap.findAll", query = "SELECT s FROM SysSpSchcatProgmap s"),
		@NamedQuery(name = "SysSpSchcatProgmap.findBySysSpSchcatProgmapid", query = "SELECT s FROM SysSpSchcatProgmap s WHERE s.sysSpSchcatProgmapid = :sysSpSchcatProgmapid") })
public class SysSpSchcatProgmap implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SYS_SP_SCHCAT_PROGMAPID")
	private Integer sysSpSchcatProgmapid;
	@JoinColumn(name = "SP_PROGRAMID", referencedColumnName = "SP_PROGRAMID")
	@ManyToOne(optional = false)
	private SpProgram spProgramid;
	@JoinColumn(name = "SYS_SP_SCHEMECATEGORYID", referencedColumnName = "SYS_SP_SCHEMECATEGORYID")
	@ManyToOne(optional = false)
	private SysSpSchemecategory sysSpSchemecategoryid;

	public SysSpSchcatProgmap() {
	}

	public SysSpSchcatProgmap(Integer sysSpSchcatProgmapid) {
		this.sysSpSchcatProgmapid = sysSpSchcatProgmapid;
	}

	public Integer getSysSpSchcatProgmapid() {
		return sysSpSchcatProgmapid;
	}

	public void setSysSpSchcatProgmapid(Integer sysSpSchcatProgmapid) {
		this.sysSpSchcatProgmapid = sysSpSchcatProgmapid;
	}

	public SpProgram getSpProgramid() {
		return spProgramid;
	}

	public void setSpProgramid(SpProgram spProgramid) {
		this.spProgramid = spProgramid;
	}

	public SysSpSchemecategory getSysSpSchemecategoryid() {
		return sysSpSchemecategoryid;
	}

	public void setSysSpSchemecategoryid(SysSpSchemecategory sysSpSchemecategoryid) {
		this.sysSpSchemecategoryid = sysSpSchemecategoryid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (sysSpSchcatProgmapid != null ? sysSpSchcatProgmapid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SysSpSchcatProgmap)) {
			return false;
		}
		SysSpSchcatProgmap other = (SysSpSchcatProgmap) object;
		if ((this.sysSpSchcatProgmapid == null && other.sysSpSchcatProgmapid != null)
				|| (this.sysSpSchcatProgmapid != null
						&& !this.sysSpSchcatProgmapid.equals(other.sysSpSchcatProgmapid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SysSpSchcatProgmap[ sysSpSchcatProgmapid=" + sysSpSchcatProgmapid + " ]";
	}

}
