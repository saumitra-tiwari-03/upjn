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
@Table(name = "VIEW_PP_EMPLOANDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpEmploandetail.findAll", query = "SELECT v FROM ViewPpEmploandetail v"),
		@NamedQuery(name = "ViewPpEmploandetail.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpEmploandetail v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpEmploandetail.findByPpLoandetailid", query = "SELECT v FROM ViewPpEmploandetail v WHERE v.ppLoandetailid = :ppLoandetailid"),
		@NamedQuery(name = "ViewPpEmploandetail.findByPpLoanmasterid", query = "SELECT v FROM ViewPpEmploandetail v WHERE v.ppLoanmasterid = :ppLoanmasterid"),
		@NamedQuery(name = "ViewPpEmploandetail.findByLoanshortname", query = "SELECT v FROM ViewPpEmploandetail v WHERE v.loanshortname = :loanshortname"),
		@NamedQuery(name = "ViewPpEmploandetail.findByLoanname", query = "SELECT v FROM ViewPpEmploandetail v WHERE v.loanname = :loanname"),
		@NamedQuery(name = "ViewPpEmploandetail.findByStopLoan", query = "SELECT v FROM ViewPpEmploandetail v WHERE v.stopLoan = :stopLoan"),
		@NamedQuery(name = "ViewPpEmploandetail.findByLoanamount", query = "SELECT v FROM ViewPpEmploandetail v WHERE v.loanamount = :loanamount") })
public class ViewPpEmploandetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "PP_LOANDETAILID")
	private long ppLoandetailid;
	@Basic(optional = false)
	@Column(name = "PP_LOANMASTERID")
	private short ppLoanmasterid;
	@Basic(optional = false)
	@Column(name = "LOANSHORTNAME")
	private String loanshortname;
	@Basic(optional = false)
	@Column(name = "LOANNAME")
	private String loanname;
	@Basic(optional = false)
	@Column(name = "STOP_LOAN")
	private Character stopLoan;
	@Basic(optional = false)
	@Column(name = "LOANAMOUNT")
	private int loanamount;

	public ViewPpEmploandetail() {
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public long getPpLoandetailid() {
		return ppLoandetailid;
	}

	public void setPpLoandetailid(long ppLoandetailid) {
		this.ppLoandetailid = ppLoandetailid;
	}

	public short getPpLoanmasterid() {
		return ppLoanmasterid;
	}

	public void setPpLoanmasterid(short ppLoanmasterid) {
		this.ppLoanmasterid = ppLoanmasterid;
	}

	public String getLoanshortname() {
		return loanshortname;
	}

	public void setLoanshortname(String loanshortname) {
		this.loanshortname = loanshortname;
	}

	public String getLoanname() {
		return loanname;
	}

	public void setLoanname(String loanname) {
		this.loanname = loanname;
	}

	public Character getStopLoan() {
		return stopLoan;
	}

	public void setStopLoan(Character stopLoan) {
		this.stopLoan = stopLoan;
	}

	public int getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(int loanamount) {
		this.loanamount = loanamount;
	}

}
