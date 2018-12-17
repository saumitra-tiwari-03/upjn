/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "VIEW_LOANDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewLoandetail.findAll", query = "SELECT v FROM ViewLoandetail v"),
		@NamedQuery(name = "ViewLoandetail.findByPpLoandetailid", query = "SELECT v FROM ViewLoandetail v WHERE v.ppLoandetailid = :ppLoandetailid"),
		@NamedQuery(name = "ViewLoandetail.findByPpEmployeemasterid", query = "SELECT v FROM ViewLoandetail v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewLoandetail.findByEmployeename", query = "SELECT v FROM ViewLoandetail v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewLoandetail.findByLoanname", query = "SELECT v FROM ViewLoandetail v WHERE v.loanname = :loanname"),
		@NamedQuery(name = "ViewLoandetail.findByLoanshortname", query = "SELECT v FROM ViewLoandetail v WHERE v.loanshortname = :loanshortname"),
		@NamedQuery(name = "ViewLoandetail.findByLoanamount", query = "SELECT v FROM ViewLoandetail v WHERE v.loanamount = :loanamount"),
		@NamedQuery(name = "ViewLoandetail.findBySanctiondate", query = "SELECT v FROM ViewLoandetail v WHERE v.sanctiondate = :sanctiondate"),
		@NamedQuery(name = "ViewLoandetail.findByPaRecovered", query = "SELECT v FROM ViewLoandetail v WHERE v.paRecovered = :paRecovered"),
		@NamedQuery(name = "ViewLoandetail.findByPaNextinstallmentno", query = "SELECT v FROM ViewLoandetail v WHERE v.paNextinstallmentno = :paNextinstallmentno"),
		@NamedQuery(name = "ViewLoandetail.findByEmployeecode", query = "SELECT v FROM ViewLoandetail v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewLoandetail.findByEmploymenttype", query = "SELECT v FROM ViewLoandetail v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewLoandetail.findByDesignation", query = "SELECT v FROM ViewLoandetail v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewLoandetail.findByIseditable", query = "SELECT v FROM ViewLoandetail v WHERE v.iseditable = :iseditable") })
public class ViewLoandetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_LOANDETAILID")
	private long ppLoandetailid;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "LOANNAME")
	private String loanname;
	@Basic(optional = false)
	@Column(name = "LOANSHORTNAME")
	private String loanshortname;
	@Basic(optional = false)
	@Column(name = "LOANAMOUNT")
	private int loanamount;
	@Basic(optional = false)
	@Column(name = "SANCTIONDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sanctiondate;
	@Basic(optional = false)
	@Column(name = "PA_RECOVERED")
	private int paRecovered;
	@Basic(optional = false)
	@Column(name = "PA_NEXTINSTALLMENTNO")
	private short paNextinstallmentno;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "ISEDITABLE")
	private Character iseditable;

	public ViewLoandetail() {
	}

	public long getPpLoandetailid() {
		return ppLoandetailid;
	}

	public void setPpLoandetailid(long ppLoandetailid) {
		this.ppLoandetailid = ppLoandetailid;
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getLoanname() {
		return loanname;
	}

	public void setLoanname(String loanname) {
		this.loanname = loanname;
	}

	public String getLoanshortname() {
		return loanshortname;
	}

	public void setLoanshortname(String loanshortname) {
		this.loanshortname = loanshortname;
	}

	public int getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(int loanamount) {
		this.loanamount = loanamount;
	}

	public Date getSanctiondate() {
		return sanctiondate;
	}

	public void setSanctiondate(Date sanctiondate) {
		this.sanctiondate = sanctiondate;
	}

	public int getPaRecovered() {
		return paRecovered;
	}

	public void setPaRecovered(int paRecovered) {
		this.paRecovered = paRecovered;
	}

	public short getPaNextinstallmentno() {
		return paNextinstallmentno;
	}

	public void setPaNextinstallmentno(short paNextinstallmentno) {
		this.paNextinstallmentno = paNextinstallmentno;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getEmploymenttype() {
		return employmenttype;
	}

	public void setEmploymenttype(String employmenttype) {
		this.employmenttype = employmenttype;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Character getIseditable() {
		return iseditable;
	}

	public void setIseditable(Character iseditable) {
		this.iseditable = iseditable;
	}

}
