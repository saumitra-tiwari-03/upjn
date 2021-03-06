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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_PP_NPSDETAIL1")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpNpsdetail1.findAll", query = "SELECT v FROM ViewPpNpsdetail1 v"),
		@NamedQuery(name = "ViewPpNpsdetail1.findByNpsdetailid", query = "SELECT v FROM ViewPpNpsdetail1 v WHERE v.npsdetailid = :npsdetailid"),
		@NamedQuery(name = "ViewPpNpsdetail1.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpNpsdetail1 v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpNpsdetail1.findByMonContr", query = "SELECT v FROM ViewPpNpsdetail1 v WHERE v.monContr = :monContr"),
		@NamedQuery(name = "ViewPpNpsdetail1.findByYearContr", query = "SELECT v FROM ViewPpNpsdetail1 v WHERE v.yearContr = :yearContr"),
		@NamedQuery(name = "ViewPpNpsdetail1.findByActualDedMon", query = "SELECT v FROM ViewPpNpsdetail1 v WHERE v.actualDedMon = :actualDedMon"),
		@NamedQuery(name = "ViewPpNpsdetail1.findByActualDedYear", query = "SELECT v FROM ViewPpNpsdetail1 v WHERE v.actualDedYear = :actualDedYear"),
		@NamedQuery(name = "ViewPpNpsdetail1.findByEmpContAmt", query = "SELECT v FROM ViewPpNpsdetail1 v WHERE v.empContAmt = :empContAmt") })
public class ViewPpNpsdetail1 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "NPSDETAILID")
	private long npsdetailid;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
	@Column(name = "MON_CONTR")
	private Short monContr;
	@Column(name = "YEAR_CONTR")
	private Short yearContr;
	@Column(name = "ACTUAL_DED_MON")
	private Short actualDedMon;
	@Column(name = "ACTUAL_DED_YEAR")
	private Short actualDedYear;
	@Column(name = "EMP_CONT_AMT")
	private Integer empContAmt;

	public ViewPpNpsdetail1() {
	}

	public long getNpsdetailid() {
		return npsdetailid;
	}

	public void setNpsdetailid(long npsdetailid) {
		this.npsdetailid = npsdetailid;
	}

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
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

	public Integer getEmpContAmt() {
		return empContAmt;
	}

	public void setEmpContAmt(Integer empContAmt) {
		this.empContAmt = empContAmt;
	}

}
