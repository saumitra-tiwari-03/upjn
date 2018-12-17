/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 * 
 */
@Entity
@Table(name = "PP_PAYSCALEMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpPayscalemaster.findAll", query = " FROM PpPayscalemaster Order By ppPayscalemasterid"),
		@NamedQuery(name = "PpPayscalemaster.findByPpPayscalemasterid", query = " FROM PpPayscalemaster WHERE ppPayscalemasterid = ?"),
		@NamedQuery(name = "PpPayscalemaster.findByPayscale", query = "FROM PpPayscalemaster WHERE payscale = ?"),
		@NamedQuery(name = "PpPayscalemaster.findByDefaultincrement", query = "SELECT p FROM PpPayscalemaster p WHERE p.defaultincrement = :defaultincrement"),
		@NamedQuery(name = "PpPayscalemaster.findByMaxamt", query = "SELECT p FROM PpPayscalemaster p WHERE p.maxamt = :maxamt"),
		@NamedQuery(name = "PpPayscalemaster.findByMinamt", query = "SELECT p FROM PpPayscalemaster p WHERE p.minamt = :minamt"),
		@NamedQuery(name = "PpPayscalemaster.findBySysPaycategoryid", query = "FROM PpPayscalemaster WHERE sysPaycategoryid = ?"),
		@NamedQuery(name = "PpPayscalemaster.findByWeight", query = "SELECT p FROM PpPayscalemaster p WHERE p.weight = :weight") })
public class PpPayscalemaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_PP_PAYSCALEMASTER", allocationSize = 1)
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
