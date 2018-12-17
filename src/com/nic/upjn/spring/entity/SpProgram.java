/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SP_PROGRAM")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SpProgram.findAll", query = "SELECT s FROM SpProgram s"),
		@NamedQuery(name = "SpProgram.findBySpProgramid", query = "SELECT s FROM SpProgram s WHERE s.spProgramid = :spProgramid"),
		@NamedQuery(name = "SpProgram.findByProgram", query = "SELECT s FROM SpProgram s WHERE s.program = :program"),
		@NamedQuery(name = "SpProgram.findByRemark", query = "SELECT s FROM SpProgram s WHERE s.remark = :remark"),
		@NamedQuery(name = "SpProgram.findByStartmonth", query = "SELECT s FROM SpProgram s WHERE s.startmonth = :startmonth"),
		@NamedQuery(name = "SpProgram.findByStartyear", query = "SELECT s FROM SpProgram s WHERE s.startyear = :startyear"),
		@NamedQuery(name = "SpProgram.findByCentralContr", query = "SELECT s FROM SpProgram s WHERE s.centralContr = :centralContr"),
		@NamedQuery(name = "SpProgram.findByLocalContr", query = "SELECT s FROM SpProgram s WHERE s.localContr = :localContr"),
		@NamedQuery(name = "SpProgram.findByStateContr", query = "SELECT s FROM SpProgram s WHERE s.stateContr = :stateContr"),
		@NamedQuery(name = "SpProgram.findByIsactive", query = "SELECT s FROM SpProgram s WHERE s.isactive = :isactive"),
		@NamedQuery(name = "SpProgram.findByWcPer", query = "SELECT s FROM SpProgram s WHERE s.wcPer = :wcPer"),
		@NamedQuery(name = "SpProgram.findByContiPer", query = "SELECT s FROM SpProgram s WHERE s.contiPer = :contiPer"),
		@NamedQuery(name = "SpProgram.findByCentPer", query = "SELECT s FROM SpProgram s WHERE s.centPer = :centPer"),
		@NamedQuery(name = "SpProgram.findBySpProgramCode", query = "SELECT s FROM SpProgram s WHERE s.spProgramCode = :spProgramCode"),
		@NamedQuery(name = "SpProgram.findByProgramShortName", query = "SELECT s FROM SpProgram s WHERE s.programShortName = :programShortName") })
public class SpProgram implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SP_PROGRAMID")
	private Integer spProgramid;
	@Basic(optional = false)
	@Column(name = "PROGRAM")
	private String program;
	@Column(name = "REMARK")
	private String remark;
	@Basic(optional = false)
	@Column(name = "STARTMONTH")
	private short startmonth;
	@Basic(optional = false)
	@Column(name = "STARTYEAR")
	private short startyear;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "CENTRAL_CONTR")
	private BigDecimal centralContr;
	@Column(name = "LOCAL_CONTR")
	private BigDecimal localContr;
	@Column(name = "STATE_CONTR")
	private BigDecimal stateContr;
	@Basic(optional = false)
	@Column(name = "ISACTIVE")
	private Character isactive;
	@Basic(optional = false)
	@Column(name = "WC_PER")
	private BigDecimal wcPer;
	@Basic(optional = false)
	@Column(name = "CONTI_PER")
	private BigDecimal contiPer;
	@Basic(optional = false)
	@Column(name = "CENT_PER")
	private BigDecimal centPer;
	@Column(name = "SP_PROGRAM_CODE")
	private String spProgramCode;
	@Column(name = "PROGRAM_SHORT_NAME")
	private String programShortName;
	@JoinColumn(name = "FWA_AC_CODE_MASTERID_L", referencedColumnName = "FWA_AC_CODE_MASTERID")
	@ManyToOne
	private FwaAcCodeMaster fwaAcCodeMasteridL;
	@JoinColumn(name = "FWA_AC_CODE_MASTERID", referencedColumnName = "FWA_AC_CODE_MASTERID")
	@ManyToOne
	private FwaAcCodeMaster fwaAcCodeMasterid;
	@JoinColumn(name = "SP_SECTORID", referencedColumnName = "SP_SECTORID")
	@ManyToOne(optional = false)
	private SpSector spSectorid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "spProgramid")
	private Collection<SysSpSchcatProgmap> sysSpSchcatProgmapCollection;

	public SpProgram() {
	}

	public SpProgram(Integer spProgramid) {
		this.spProgramid = spProgramid;
	}

	public SpProgram(Integer spProgramid, String program, short startmonth, short startyear, Character isactive,
			BigDecimal wcPer, BigDecimal contiPer, BigDecimal centPer) {
		this.spProgramid = spProgramid;
		this.program = program;
		this.startmonth = startmonth;
		this.startyear = startyear;
		this.isactive = isactive;
		this.wcPer = wcPer;
		this.contiPer = contiPer;
		this.centPer = centPer;
	}

	public Integer getSpProgramid() {
		return spProgramid;
	}

	public void setSpProgramid(Integer spProgramid) {
		this.spProgramid = spProgramid;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public short getStartmonth() {
		return startmonth;
	}

	public void setStartmonth(short startmonth) {
		this.startmonth = startmonth;
	}

	public short getStartyear() {
		return startyear;
	}

	public void setStartyear(short startyear) {
		this.startyear = startyear;
	}

	public BigDecimal getCentralContr() {
		return centralContr;
	}

	public void setCentralContr(BigDecimal centralContr) {
		this.centralContr = centralContr;
	}

	public BigDecimal getLocalContr() {
		return localContr;
	}

	public void setLocalContr(BigDecimal localContr) {
		this.localContr = localContr;
	}

	public BigDecimal getStateContr() {
		return stateContr;
	}

	public void setStateContr(BigDecimal stateContr) {
		this.stateContr = stateContr;
	}

	public Character getIsactive() {
		return isactive;
	}

	public void setIsactive(Character isactive) {
		this.isactive = isactive;
	}

	public BigDecimal getWcPer() {
		return wcPer;
	}

	public void setWcPer(BigDecimal wcPer) {
		this.wcPer = wcPer;
	}

	public BigDecimal getContiPer() {
		return contiPer;
	}

	public void setContiPer(BigDecimal contiPer) {
		this.contiPer = contiPer;
	}

	public BigDecimal getCentPer() {
		return centPer;
	}

	public void setCentPer(BigDecimal centPer) {
		this.centPer = centPer;
	}

	public String getSpProgramCode() {
		return spProgramCode;
	}

	public void setSpProgramCode(String spProgramCode) {
		this.spProgramCode = spProgramCode;
	}

	public String getProgramShortName() {
		return programShortName;
	}

	public void setProgramShortName(String programShortName) {
		this.programShortName = programShortName;
	}

	public FwaAcCodeMaster getFwaAcCodeMasteridL() {
		return fwaAcCodeMasteridL;
	}

	public void setFwaAcCodeMasteridL(FwaAcCodeMaster fwaAcCodeMasteridL) {
		this.fwaAcCodeMasteridL = fwaAcCodeMasteridL;
	}

	public FwaAcCodeMaster getFwaAcCodeMasterid() {
		return fwaAcCodeMasterid;
	}

	public void setFwaAcCodeMasterid(FwaAcCodeMaster fwaAcCodeMasterid) {
		this.fwaAcCodeMasterid = fwaAcCodeMasterid;
	}

	public SpSector getSpSectorid() {
		return spSectorid;
	}

	public void setSpSectorid(SpSector spSectorid) {
		this.spSectorid = spSectorid;
	}

	@XmlTransient
	public Collection<SysSpSchcatProgmap> getSysSpSchcatProgmapCollection() {
		return sysSpSchcatProgmapCollection;
	}

	public void setSysSpSchcatProgmapCollection(Collection<SysSpSchcatProgmap> sysSpSchcatProgmapCollection) {
		this.sysSpSchcatProgmapCollection = sysSpSchcatProgmapCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (spProgramid != null ? spProgramid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SpProgram)) {
			return false;
		}
		SpProgram other = (SpProgram) object;
		if ((this.spProgramid == null && other.spProgramid != null)
				|| (this.spProgramid != null && !this.spProgramid.equals(other.spProgramid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SpProgram[ spProgramid=" + spProgramid + " ]";
	}

}
