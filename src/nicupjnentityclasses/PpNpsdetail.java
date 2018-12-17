/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "PP_NPSDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpNpsdetail.findAll", query = "SELECT p FROM PpNpsdetail p"),
		@NamedQuery(name = "PpNpsdetail.findByPpNpsdetailid", query = "SELECT p FROM PpNpsdetail p WHERE p.ppNpsdetailid = :ppNpsdetailid"),
		@NamedQuery(name = "PpNpsdetail.findByPpEmployeemasterid", query = "SELECT p FROM PpNpsdetail p WHERE p.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "PpNpsdetail.findByJoiningMnth", query = "SELECT p FROM PpNpsdetail p WHERE p.joiningMnth = :joiningMnth"),
		@NamedQuery(name = "PpNpsdetail.findByStartmonForregularCont", query = "SELECT p FROM PpNpsdetail p WHERE p.startmonForregularCont = :startmonForregularCont"),
		@NamedQuery(name = "PpNpsdetail.findByMonContr", query = "SELECT p FROM PpNpsdetail p WHERE p.monContr = :monContr"),
		@NamedQuery(name = "PpNpsdetail.findByYearContr", query = "SELECT p FROM PpNpsdetail p WHERE p.yearContr = :yearContr"),
		@NamedQuery(name = "PpNpsdetail.findByEmpContAmt", query = "SELECT p FROM PpNpsdetail p WHERE p.empContAmt = :empContAmt"),
		@NamedQuery(name = "PpNpsdetail.findByPpNpsArrearid", query = "SELECT p FROM PpNpsdetail p WHERE p.ppNpsArrearid = :ppNpsArrearid"),
		@NamedQuery(name = "PpNpsdetail.findByEntryDate", query = "SELECT p FROM PpNpsdetail p WHERE p.entryDate = :entryDate"),
		@NamedQuery(name = "PpNpsdetail.findByActualDedMon", query = "SELECT p FROM PpNpsdetail p WHERE p.actualDedMon = :actualDedMon"),
		@NamedQuery(name = "PpNpsdetail.findByActualDedYear", query = "SELECT p FROM PpNpsdetail p WHERE p.actualDedYear = :actualDedYear"),
		@NamedQuery(name = "PpNpsdetail.findByRmOfficeid", query = "SELECT p FROM PpNpsdetail p WHERE p.rmOfficeid = :rmOfficeid") })
public class PpNpsdetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_NPSDETAILID")
	private Long ppNpsdetailid;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
	@Column(name = "JOINING_MNTH")
	@Temporal(TemporalType.TIMESTAMP)
	private Date joiningMnth;
	@Column(name = "STARTMON_FORREGULAR_CONT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startmonForregularCont;
	@Column(name = "MON_CONTR")
	private Short monContr;
	@Column(name = "YEAR_CONTR")
	private Short yearContr;
	@Column(name = "EMP_CONT_AMT")
	private Integer empContAmt;
	@Basic(optional = false)
	@Column(name = "PP_NPS_ARREARID")
	private BigInteger ppNpsArrearid;
	@Column(name = "ENTRY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date entryDate;
	@Column(name = "ACTUAL_DED_MON")
	private Short actualDedMon;
	@Column(name = "ACTUAL_DED_YEAR")
	private Short actualDedYear;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;

	public PpNpsdetail() {
	}

	public PpNpsdetail(Long ppNpsdetailid) {
		this.ppNpsdetailid = ppNpsdetailid;
	}

	public PpNpsdetail(Long ppNpsdetailid, BigInteger ppNpsArrearid) {
		this.ppNpsdetailid = ppNpsdetailid;
		this.ppNpsArrearid = ppNpsArrearid;
	}

	public Long getPpNpsdetailid() {
		return ppNpsdetailid;
	}

	public void setPpNpsdetailid(Long ppNpsdetailid) {
		this.ppNpsdetailid = ppNpsdetailid;
	}

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public Date getJoiningMnth() {
		return joiningMnth;
	}

	public void setJoiningMnth(Date joiningMnth) {
		this.joiningMnth = joiningMnth;
	}

	public Date getStartmonForregularCont() {
		return startmonForregularCont;
	}

	public void setStartmonForregularCont(Date startmonForregularCont) {
		this.startmonForregularCont = startmonForregularCont;
	}

	public Short getMonContr() {
		return monContr;
	}

	public void setMonContr(Short monContr) {
		this.monContr = monContr;
	}

	public Short getYearContr() {
		return yearContr;
	}

	public void setYearContr(Short yearContr) {
		this.yearContr = yearContr;
	}

	public Integer getEmpContAmt() {
		return empContAmt;
	}

	public void setEmpContAmt(Integer empContAmt) {
		this.empContAmt = empContAmt;
	}

	public BigInteger getPpNpsArrearid() {
		return ppNpsArrearid;
	}

	public void setPpNpsArrearid(BigInteger ppNpsArrearid) {
		this.ppNpsArrearid = ppNpsArrearid;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Short getActualDedMon() {
		return actualDedMon;
	}

	public void setActualDedMon(Short actualDedMon) {
		this.actualDedMon = actualDedMon;
	}

	public Short getActualDedYear() {
		return actualDedYear;
	}

	public void setActualDedYear(Short actualDedYear) {
		this.actualDedYear = actualDedYear;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppNpsdetailid != null ? ppNpsdetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpNpsdetail)) {
			return false;
		}
		PpNpsdetail other = (PpNpsdetail) object;
		if ((this.ppNpsdetailid == null && other.ppNpsdetailid != null)
				|| (this.ppNpsdetailid != null && !this.ppNpsdetailid.equals(other.ppNpsdetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpNpsdetail[ ppNpsdetailid=" + ppNpsdetailid + " ]";
	}

}
