/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "SYS_SP_SCHEMECATEGORY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SysSpSchemecategory.findAll", query = "SELECT s FROM SysSpSchemecategory s"),
		@NamedQuery(name = "SysSpSchemecategory.findBySysSpSchemecategoryid", query = "SELECT s FROM SysSpSchemecategory s WHERE s.sysSpSchemecategoryid = :sysSpSchemecategoryid"),
		@NamedQuery(name = "SysSpSchemecategory.findBySchemecategoryname", query = "SELECT s FROM SysSpSchemecategory s WHERE s.schemecategoryname = :schemecategoryname"),
		@NamedQuery(name = "SysSpSchemecategory.findBySpCategoryCode", query = "SELECT s FROM SysSpSchemecategory s WHERE s.spCategoryCode = :spCategoryCode") })
public class SysSpSchemecategory implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SYS_SP_SCHEMECATEGORYID")
	private Integer sysSpSchemecategoryid;
	@Basic(optional = false)
	@Column(name = "SCHEMECATEGORYNAME")
	private String schemecategoryname;
	@Column(name = "SP_CATEGORY_CODE")
	private String spCategoryCode;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sysSpSchemecategoryid")
	private Collection<SysSpSchcatProgmap> sysSpSchcatProgmapCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sysSpSchemecategoryid")
	private Collection<SpSchememaster> spSchememasterCollection;

	public SysSpSchemecategory() {
	}

	public SysSpSchemecategory(Integer sysSpSchemecategoryid) {
		this.sysSpSchemecategoryid = sysSpSchemecategoryid;
	}

	public SysSpSchemecategory(Integer sysSpSchemecategoryid, String schemecategoryname) {
		this.sysSpSchemecategoryid = sysSpSchemecategoryid;
		this.schemecategoryname = schemecategoryname;
	}

	public Integer getSysSpSchemecategoryid() {
		return sysSpSchemecategoryid;
	}

	public void setSysSpSchemecategoryid(Integer sysSpSchemecategoryid) {
		this.sysSpSchemecategoryid = sysSpSchemecategoryid;
	}

	public String getSchemecategoryname() {
		return schemecategoryname;
	}

	public void setSchemecategoryname(String schemecategoryname) {
		this.schemecategoryname = schemecategoryname;
	}

	public String getSpCategoryCode() {
		return spCategoryCode;
	}

	public void setSpCategoryCode(String spCategoryCode) {
		this.spCategoryCode = spCategoryCode;
	}

	@XmlTransient
	public Collection<SysSpSchcatProgmap> getSysSpSchcatProgmapCollection() {
		return sysSpSchcatProgmapCollection;
	}

	public void setSysSpSchcatProgmapCollection(Collection<SysSpSchcatProgmap> sysSpSchcatProgmapCollection) {
		this.sysSpSchcatProgmapCollection = sysSpSchcatProgmapCollection;
	}

	@XmlTransient
	public Collection<SpSchememaster> getSpSchememasterCollection() {
		return spSchememasterCollection;
	}

	public void setSpSchememasterCollection(Collection<SpSchememaster> spSchememasterCollection) {
		this.spSchememasterCollection = spSchememasterCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (sysSpSchemecategoryid != null ? sysSpSchemecategoryid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SysSpSchemecategory)) {
			return false;
		}
		SysSpSchemecategory other = (SysSpSchemecategory) object;
		if ((this.sysSpSchemecategoryid == null && other.sysSpSchemecategoryid != null)
				|| (this.sysSpSchemecategoryid != null
						&& !this.sysSpSchemecategoryid.equals(other.sysSpSchemecategoryid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SysSpSchemecategory[ sysSpSchemecategoryid=" + sysSpSchemecategoryid + " ]";
	}

}
