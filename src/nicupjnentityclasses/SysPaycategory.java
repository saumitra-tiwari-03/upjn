/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SYS_PAYCATEGORY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SysPaycategory.findAll", query = "SELECT s FROM SysPaycategory s"),
		@NamedQuery(name = "SysPaycategory.findBySysPaycategoryid", query = "SELECT s FROM SysPaycategory s WHERE s.sysPaycategoryid = :sysPaycategoryid"),
		@NamedQuery(name = "SysPaycategory.findByPaycategory", query = "SELECT s FROM SysPaycategory s WHERE s.paycategory = :paycategory"),
		@NamedQuery(name = "SysPaycategory.findByIspayscaleapplicable", query = "SELECT s FROM SysPaycategory s WHERE s.ispayscaleapplicable = :ispayscaleapplicable") })
public class SysPaycategory implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "SYS_PAYCATEGORYID")
	private BigDecimal sysPaycategoryid;
	@Basic(optional = false)
	@Column(name = "PAYCATEGORY")
	private String paycategory;
	@Basic(optional = false)
	@Column(name = "ISPAYSCALEAPPLICABLE")
	private Character ispayscaleapplicable;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sysPaycategoryid")
	private Collection<SysPaycatHraccamap> sysPaycatHraccamapCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sysPaycategoryid")
	private Collection<PpPayalwmaster> ppPayalwmasterCollection;

	public SysPaycategory() {
	}

	public SysPaycategory(BigDecimal sysPaycategoryid) {
		this.sysPaycategoryid = sysPaycategoryid;
	}

	public SysPaycategory(BigDecimal sysPaycategoryid, String paycategory, Character ispayscaleapplicable) {
		this.sysPaycategoryid = sysPaycategoryid;
		this.paycategory = paycategory;
		this.ispayscaleapplicable = ispayscaleapplicable;
	}

	public BigDecimal getSysPaycategoryid() {
		return sysPaycategoryid;
	}

	public void setSysPaycategoryid(BigDecimal sysPaycategoryid) {
		this.sysPaycategoryid = sysPaycategoryid;
	}

	public String getPaycategory() {
		return paycategory;
	}

	public void setPaycategory(String paycategory) {
		this.paycategory = paycategory;
	}

	public Character getIspayscaleapplicable() {
		return ispayscaleapplicable;
	}

	public void setIspayscaleapplicable(Character ispayscaleapplicable) {
		this.ispayscaleapplicable = ispayscaleapplicable;
	}

	@XmlTransient
	public Collection<SysPaycatHraccamap> getSysPaycatHraccamapCollection() {
		return sysPaycatHraccamapCollection;
	}

	public void setSysPaycatHraccamapCollection(Collection<SysPaycatHraccamap> sysPaycatHraccamapCollection) {
		this.sysPaycatHraccamapCollection = sysPaycatHraccamapCollection;
	}

	@XmlTransient
	public Collection<PpPayalwmaster> getPpPayalwmasterCollection() {
		return ppPayalwmasterCollection;
	}

	public void setPpPayalwmasterCollection(Collection<PpPayalwmaster> ppPayalwmasterCollection) {
		this.ppPayalwmasterCollection = ppPayalwmasterCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (sysPaycategoryid != null ? sysPaycategoryid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SysPaycategory)) {
			return false;
		}
		SysPaycategory other = (SysPaycategory) object;
		if ((this.sysPaycategoryid == null && other.sysPaycategoryid != null)
				|| (this.sysPaycategoryid != null && !this.sysPaycategoryid.equals(other.sysPaycategoryid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SysPaycategory[ sysPaycategoryid=" + sysPaycategoryid + " ]";
	}

}
