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
@Table(name = "SYS_PAYCAT_HRACCAMAP")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SysPaycatHraccamap.findAll", query = "SELECT s FROM SysPaycatHraccamap s"),
		@NamedQuery(name = "SysPaycatHraccamap.findBySysPaycatHraccamapid", query = "SELECT s FROM SysPaycatHraccamap s WHERE s.sysPaycatHraccamapid = :sysPaycatHraccamapid") })
public class SysPaycatHraccamap implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SYS_PAYCAT_HRACCAMAPID")
	private Integer sysPaycatHraccamapid;
	@JoinColumn(name = "PP_TOWNCATEGORYMASTERID", referencedColumnName = "PP_TOWNCATEGORYMASTERID")
	@ManyToOne(optional = false)
	private PpTowncategorymaster ppTowncategorymasterid;
	@JoinColumn(name = "SYS_PAYCATEGORYID", referencedColumnName = "SYS_PAYCATEGORYID")
	@ManyToOne(optional = false)
	private SysPaycategory sysPaycategoryid;

	public SysPaycatHraccamap() {
	}

	public SysPaycatHraccamap(Integer sysPaycatHraccamapid) {
		this.sysPaycatHraccamapid = sysPaycatHraccamapid;
	}

	public Integer getSysPaycatHraccamapid() {
		return sysPaycatHraccamapid;
	}

	public void setSysPaycatHraccamapid(Integer sysPaycatHraccamapid) {
		this.sysPaycatHraccamapid = sysPaycatHraccamapid;
	}

	public PpTowncategorymaster getPpTowncategorymasterid() {
		return ppTowncategorymasterid;
	}

	public void setPpTowncategorymasterid(PpTowncategorymaster ppTowncategorymasterid) {
		this.ppTowncategorymasterid = ppTowncategorymasterid;
	}

	public SysPaycategory getSysPaycategoryid() {
		return sysPaycategoryid;
	}

	public void setSysPaycategoryid(SysPaycategory sysPaycategoryid) {
		this.sysPaycategoryid = sysPaycategoryid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (sysPaycatHraccamapid != null ? sysPaycatHraccamapid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SysPaycatHraccamap)) {
			return false;
		}
		SysPaycatHraccamap other = (SysPaycatHraccamap) object;
		if ((this.sysPaycatHraccamapid == null && other.sysPaycatHraccamapid != null)
				|| (this.sysPaycatHraccamapid != null
						&& !this.sysPaycatHraccamapid.equals(other.sysPaycatHraccamapid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SysPaycatHraccamap[ sysPaycatHraccamapid=" + sysPaycatHraccamapid + " ]";
	}

}
