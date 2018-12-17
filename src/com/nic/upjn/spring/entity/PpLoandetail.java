
package com.nic.upjn.spring.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_LOANDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpLoandetail.findAll", query = "SELECT p FROM PpLoandetail p"),
		@NamedQuery(name = "PpLoandetail.findByPpLoandetailid", query = "FROM PpLoandetail WHERE ppLoandetailid = ?"),
		@NamedQuery(name = "PpLoandetail.findByPpEmployeemasterid", query = "FROM PpLoandetail WHERE ppEmployeemasterid = ?"),

		@NamedQuery(name = "PpLoandetail.findByLoanshortname", query = "SELECT p FROM PpLoandetail p WHERE p.loanshortname = :loanshortname"),
		@NamedQuery(name = "PpLoandetail.findByLoanamount", query = "SELECT p FROM PpLoandetail p WHERE p.loanamount = :loanamount"),
		@NamedQuery(name = "PpLoandetail.findByPaNoofinstallments", query = "SELECT p FROM PpLoandetail p WHERE p.paNoofinstallments = :paNoofinstallments"),
		@NamedQuery(name = "PpLoandetail.findByPaInstallmentamount", query = "SELECT p FROM PpLoandetail p WHERE p.paInstallmentamount = :paInstallmentamount"),
		@NamedQuery(name = "PpLoandetail.findByLoansanctionordno", query = "SELECT p FROM PpLoandetail p WHERE p.loansanctionordno = :loansanctionordno"),
		@NamedQuery(name = "PpLoandetail.findBySanctiondate", query = "SELECT p FROM PpLoandetail p WHERE p.sanctiondate = :sanctiondate"),
		@NamedQuery(name = "PpLoandetail.findByPaRecovcommencemonth", query = "SELECT p FROM PpLoandetail p WHERE p.paRecovcommencemonth = :paRecovcommencemonth"),
		@NamedQuery(name = "PpLoandetail.findByPaRecovcommenceyear", query = "SELECT p FROM PpLoandetail p WHERE p.paRecovcommenceyear = :paRecovcommenceyear"),
		@NamedQuery(name = "PpLoandetail.findByPaNextinstallmentno", query = "SELECT p FROM PpLoandetail p WHERE p.paNextinstallmentno = :paNextinstallmentno"),
		@NamedQuery(name = "PpLoandetail.findByPaRecovered", query = "SELECT p FROM PpLoandetail p WHERE p.paRecovered = :paRecovered"),
		@NamedQuery(name = "PpLoandetail.findByPaIsfullyrecovered", query = "SELECT p FROM PpLoandetail p WHERE p.paIsfullyrecovered = :paIsfullyrecovered"),
		@NamedQuery(name = "PpLoandetail.findByStopLoan", query = "SELECT p FROM PpLoandetail p WHERE p.stopLoan = :stopLoan"),
		@NamedQuery(name = "PpLoandetail.findByIsinterest", query = "SELECT p FROM PpLoandetail p WHERE p.isinterest = :isinterest"),
		@NamedQuery(name = "PpLoandetail.findByIseditable", query = "SELECT p FROM PpLoandetail p WHERE p.iseditable = :iseditable"),
		@NamedQuery(name = "PpLoandetail.findByFirstinstallmentamount", query = "SELECT p FROM PpLoandetail p WHERE p.firstinstallmentamount = :firstinstallmentamount") })
public class PpLoandetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_PP_LOANDETAIL", allocationSize = 1)
	@Id
	@Basic(optional = false)
	@Column(name = "PP_LOANDETAILID")
	private Long ppLoandetailid;
	@Basic(optional = false)
	@Column(name = "LOANSHORTNAME")
	private String loanshortname;
	@Basic(optional = false)
	@Column(name = "LOANAMOUNT")
	private int loanamount;
	@Basic(optional = false)
	@Column(name = "PA_NOOFINSTALLMENTS")
	private short paNoofinstallments;
	@Basic(optional = false)
	@Column(name = "PA_INSTALLMENTAMOUNT")
	private int paInstallmentamount;
	@Basic(optional = false)
	@Column(name = "LOANSANCTIONORDNO")
	private String loansanctionordno;
	@Basic(optional = false)
	@Column(name = "SANCTIONDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sanctiondate;
	@Column(name = "PA_RECOVCOMMENCEMONTH")
	private Short paRecovcommencemonth;
	@Column(name = "PA_RECOVCOMMENCEYEAR")
	private Short paRecovcommenceyear;
	@Basic(optional = false)
	@Column(name = "PA_NEXTINSTALLMENTNO")
	private short paNextinstallmentno;
	@Basic(optional = false)
	@Column(name = "PA_RECOVERED")
	private int paRecovered;
	@Basic(optional = false)
	@Column(name = "PA_ISFULLYRECOVERED")
	private Character paIsfullyrecovered;
	@Basic(optional = false)
	@Column(name = "STOP_LOAN")
	private Character stopLoan;
	@Basic(optional = false)
	@Column(name = "ISINTEREST")
	private Character isinterest;
	@Basic(optional = false)
	@Column(name = "ISEDITABLE")
	private Character iseditable;
	@Column(name = "FIRSTINSTALLMENTAMOUNT")
	private Integer firstinstallmentamount;
	
	
	
	@Basic(optional = false)
    @Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
	@Column(name = "PP_LOANMASTERID")
	@Basic(optional = false)
	private Integer ppLoanmasterid;

	public PpLoandetail() {
	}

	public PpLoandetail(Long ppLoandetailid) {
		this.ppLoandetailid = ppLoandetailid;
	}

	public PpLoandetail(Long ppLoandetailid, String loanshortname, int loanamount, short paNoofinstallments,
			int paInstallmentamount, String loansanctionordno, Date sanctiondate, short paNextinstallmentno,
			int paRecovered, Character paIsfullyrecovered, Character stopLoan, Character isinterest,
			Character iseditable) {
		this.ppLoandetailid = ppLoandetailid;
		this.loanshortname = loanshortname;
		this.loanamount = loanamount;
		this.paNoofinstallments = paNoofinstallments;
		this.paInstallmentamount = paInstallmentamount;
		this.loansanctionordno = loansanctionordno;
		this.sanctiondate = sanctiondate;
		this.paNextinstallmentno = paNextinstallmentno;
		this.paRecovered = paRecovered;
		this.paIsfullyrecovered = paIsfullyrecovered;
		this.stopLoan = stopLoan;
		this.isinterest = isinterest;
		this.iseditable = iseditable;
	}

	public Long getPpLoandetailid() {
		return ppLoandetailid;
	}

	public void setPpLoandetailid(Long ppLoandetailid) {
		this.ppLoandetailid = ppLoandetailid;
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

	public short getPaNoofinstallments() {
		return paNoofinstallments;
	}

	public void setPaNoofinstallments(short paNoofinstallments) {
		this.paNoofinstallments = paNoofinstallments;
	}

	public int getPaInstallmentamount() {
		return paInstallmentamount;
	}

	public void setPaInstallmentamount(int paInstallmentamount) {
		this.paInstallmentamount = paInstallmentamount;
	}

	public String getLoansanctionordno() {
		return loansanctionordno;
	}

	public void setLoansanctionordno(String loansanctionordno) {
		this.loansanctionordno = loansanctionordno;
	}

	public Date getSanctiondate() {
		return sanctiondate;
	}

	public void setSanctiondate(Date sanctiondate) {
		this.sanctiondate = sanctiondate;
	}

	public Short getPaRecovcommencemonth() {
		return paRecovcommencemonth;
	}

	public void setPaRecovcommencemonth(Short paRecovcommencemonth) {
		this.paRecovcommencemonth = paRecovcommencemonth;
	}

	public Short getPaRecovcommenceyear() {
		return paRecovcommenceyear;
	}

	public void setPaRecovcommenceyear(Short paRecovcommenceyear) {
		this.paRecovcommenceyear = paRecovcommenceyear;
	}

	public short getPaNextinstallmentno() {
		return paNextinstallmentno;
	}

	public void setPaNextinstallmentno(short paNextinstallmentno) {
		this.paNextinstallmentno = paNextinstallmentno;
	}

	public int getPaRecovered() {
		return paRecovered;
	}

	public void setPaRecovered(int paRecovered) {
		this.paRecovered = paRecovered;
	}

	public Character getPaIsfullyrecovered() {
		return paIsfullyrecovered;
	}

	public void setPaIsfullyrecovered(Character paIsfullyrecovered) {
		this.paIsfullyrecovered = paIsfullyrecovered;
	}

	public Character getStopLoan() {
		return stopLoan;
	}

	public void setStopLoan(Character stopLoan) {
		this.stopLoan = stopLoan;
	}

	public Character getIsinterest() {
		return isinterest;
	}

	public void setIsinterest(Character isinterest) {
		this.isinterest = isinterest;
	}

	public Character getIseditable() {
		return iseditable;
	}

	public void setIseditable(Character iseditable) {
		this.iseditable = iseditable;
	}

	public Integer getFirstinstallmentamount() {
		return firstinstallmentamount;
	}

	public void setFirstinstallmentamount(Integer firstinstallmentamount) {
		this.firstinstallmentamount = firstinstallmentamount;
	}

	


	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public Integer getPpLoanmasterid() {
		return ppLoanmasterid;
	}

	public void setPpLoanmasterid(Integer ppLoanmasterid) {
		this.ppLoanmasterid = ppLoanmasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppLoandetailid != null ? ppLoandetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpLoandetail)) {
			return false;
		}
		PpLoandetail other = (PpLoandetail) object;
		if ((this.ppLoandetailid == null && other.ppLoandetailid != null)
				|| (this.ppLoandetailid != null && !this.ppLoandetailid.equals(other.ppLoandetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpLoandetail[ ppLoandetailid=" + ppLoandetailid + " ]";
	}

}
