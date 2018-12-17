/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
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
@Table(name = "PP_PAYSCALEMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpPayscalemaster.findAll", query = "SELECT p FROM PpPayscalemaster p"),
		@NamedQuery(name = "PpPayscalemaster.findByPpPayscalemasterid", query = "SELECT p FROM PpPayscalemaster p WHERE p.ppPayscalemasterid = :ppPayscalemasterid"),
		@NamedQuery(name = "PpPayscalemaster.findByPayscale", query = "SELECT p FROM PpPayscalemaster p WHERE p.payscale = :payscale"),
		@NamedQuery(name = "PpPayscalemaster.findByDefaultincrement", query = "SELECT p FROM PpPayscalemaster p WHERE p.defaultincrement = :defaultincrement"),
		@NamedQuery(name = "PpPayscalemaster.findByMaxamt", query = "SELECT p FROM PpPayscalemaster p WHERE p.maxamt = :maxamt"),
		@NamedQuery(name = "PpPayscalemaster.findByMinamt", query = "SELECT p FROM PpPayscalemaster p WHERE p.minamt = :minamt"),
		@NamedQuery(name = "PpPayscalemaster.findBySysPaycategoryid", query = "SELECT p FROM PpPayscalemaster p WHERE p.sysPaycategoryid = :sysPaycategoryid"),
		@NamedQuery(name = "PpPayscalemaster.findByWeight", query = "SELECT p FROM PpPayscalemaster p WHERE p.weight = :weight") })
public class PpPayscalemaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_PAYSCALEMASTERID")
	private Integer ppPayscalemasterid;
	@Basic(optional = false)
	@Column(name = "PAYSCALE")
	private String payscale;
	@Basic(optional = false)
	@Column(name = "DEFAULTINCREMENT")
	private int defaultincrement;
	@Basic(optional = false)
	@Column(name = "MAXAMT")
	private int maxamt;
	@Basic(optional = false)
	@Column(name = "MINAMT")
	private int minamt;
	@Basic(optional = false)
	@Column(name = "SYS_PAYCATEGORYID")
	private short sysPaycategoryid;
	@Basic(optional = false)
	@Column(name = "WEIGHT")
	private short weight;
	@OneToMany(mappedBy = "ppPayscalemasterid")
	private Collection<ViewEmpAlwDedlist> viewEmpAlwDedlistCollection;
	@OneToMany(mappedBy = "ppPayscalemasterid")
	private Collection<PpViewEmpPay> ppViewEmpPayCollection;

	public PpPayscalemaster() {
	}

	public PpPayscalemaster(Integer ppPayscalemasterid) {
		this.ppPayscalemasterid = ppPayscalemasterid;
	}

	public PpPayscalemaster(Integer ppPayscalemasterid, String payscale, int defaultincrement, int maxamt, int minamt,
			short sysPaycategoryid, short weight) {
		this.ppPayscalemasterid = ppPayscalemasterid;
		this.payscale = payscale;
		this.defaultincrement = defaultincrement;
		this.maxamt = maxamt;
		this.minamt = minamt;
		this.sysPaycategoryid = sysPaycategoryid;
		this.weight = weight;
	}

	public Integer getPpPayscalemasterid() {
		return ppPayscalemasterid;
	}

	public void setPpPayscalemasterid(Integer ppPayscalemasterid) {
		this.ppPayscalemasterid = ppPayscalemasterid;
	}

	public String getPayscale() {
		return payscale;
	}

	public void setPayscale(String payscale) {
		this.payscale = payscale;
	}

	public int getDefaultincrement() {
		return defaultincrement;
	}

	public void setDefaultincrement(int defaultincrement) {
		this.defaultincrement = defaultincrement;
	}

	public int getMaxamt() {
		return maxamt;
	}

	public void setMaxamt(int maxamt) {
		this.maxamt = maxamt;
	}

	public int getMinamt() {
		return minamt;
	}

	public void setMinamt(int minamt) {
		this.minamt = minamt;
	}

	public short getSysPaycategoryid() {
		return sysPaycategoryid;
	}

	public void setSysPaycategoryid(short sysPaycategoryid) {
		this.sysPaycategoryid = sysPaycategoryid;
	}

	public short getWeight() {
		return weight;
	}

	public void setWeight(short weight) {
		this.weight = weight;
	}

	@XmlTransient
	public Collection<ViewEmpAlwDedlist> getViewEmpAlwDedlistCollection() {
		return viewEmpAlwDedlistCollection;
	}

	public void setViewEmpAlwDedlistCollection(Collection<ViewEmpAlwDedlist> viewEmpAlwDedlistCollection) {
		this.viewEmpAlwDedlistCollection = viewEmpAlwDedlistCollection;
	}

	@XmlTransient
	public Collection<PpViewEmpPay> getPpViewEmpPayCollection() {
		return ppViewEmpPayCollection;
	}

	public void setPpViewEmpPayCollection(Collection<PpViewEmpPay> ppViewEmpPayCollection) {
		this.ppViewEmpPayCollection = ppViewEmpPayCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppPayscalemasterid != null ? ppPayscalemasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpPayscalemaster)) {
			return false;
		}
		PpPayscalemaster other = (PpPayscalemaster) object;
		if ((this.ppPayscalemasterid == null && other.ppPayscalemasterid != null)
				|| (this.ppPayscalemasterid != null && !this.ppPayscalemasterid.equals(other.ppPayscalemasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpPayscalemaster[ ppPayscalemasterid=" + ppPayscalemasterid + " ]";
	}

}
