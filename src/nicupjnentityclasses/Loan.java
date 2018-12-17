/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "LOAN")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Loan.findAll", query = "SELECT l FROM Loan l"),
		@NamedQuery(name = "Loan.findById", query = "SELECT l FROM Loan l WHERE l.id = :id"),
		@NamedQuery(name = "Loan.findByFasCode", query = "SELECT l FROM Loan l WHERE l.fasCode = :fasCode"),
		@NamedQuery(name = "Loan.findByNameOfEmployee", query = "SELECT l FROM Loan l WHERE l.nameOfEmployee = :nameOfEmployee"),
		@NamedQuery(name = "Loan.findByDesignation", query = "SELECT l FROM Loan l WHERE l.designation = :designation"),
		@NamedQuery(name = "Loan.findBySection", query = "SELECT l FROM Loan l WHERE l.section = :section"),
		@NamedQuery(name = "Loan.findByTypeOfAdvance", query = "SELECT l FROM Loan l WHERE l.typeOfAdvance = :typeOfAdvance"),
		@NamedQuery(name = "Loan.findByMonthlyInstal", query = "SELECT l FROM Loan l WHERE l.monthlyInstal = :monthlyInstal"),
		@NamedQuery(name = "Loan.findByLoanAdvanceSanctionOrder", query = "SELECT l FROM Loan l WHERE l.loanAdvanceSanctionOrder = :loanAdvanceSanctionOrder"),
		@NamedQuery(name = "Loan.findByDateOfOrder", query = "SELECT l FROM Loan l WHERE l.dateOfOrder = :dateOfOrder"),
		@NamedQuery(name = "Loan.findByLoanAmount", query = "SELECT l FROM Loan l WHERE l.loanAmount = :loanAmount"),
		@NamedQuery(name = "Loan.findByMonthOfStart", query = "SELECT l FROM Loan l WHERE l.monthOfStart = :monthOfStart"),
		@NamedQuery(name = "Loan.findByTotalInstl", query = "SELECT l FROM Loan l WHERE l.totalInstl = :totalInstl"),
		@NamedQuery(name = "Loan.findByLastMonth", query = "SELECT l FROM Loan l WHERE l.lastMonth = :lastMonth"),
		@NamedQuery(name = "Loan.findByYear", query = "SELECT l FROM Loan l WHERE l.year = :year"),
		@NamedQuery(name = "Loan.findByPpEmployeemasterid", query = "SELECT l FROM Loan l WHERE l.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "Loan.findByMonth", query = "SELECT l FROM Loan l WHERE l.month = :month"),
		@NamedQuery(name = "Loan.findByPpLoanmasterid", query = "SELECT l FROM Loan l WHERE l.ppLoanmasterid = :ppLoanmasterid") })
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	private BigDecimal id;
	@Column(name = "FAS_CODE")
	private String fasCode;
	@Column(name = "NAME_OF_EMPLOYEE")
	private String nameOfEmployee;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "SECTION")
	private String section;
	@Column(name = "TYPE_OF_ADVANCE")
	private String typeOfAdvance;
	@Column(name = "MONTHLY_INSTAL")
	private String monthlyInstal;
	@Column(name = "LOAN_ADVANCE_SANCTION_ORDER")
	private String loanAdvanceSanctionOrder;
	@Column(name = "DATE_OF_ORDER")
	private String dateOfOrder;
	@Column(name = "LOAN_AMOUNT")
	private String loanAmount;
	@Column(name = "MONTH_OF_START")
	private String monthOfStart;
	@Column(name = "TOTAL_INSTL")
	private String totalInstl;
	@Column(name = "LAST_MONTH")
	private String lastMonth;
	@Column(name = "YEAR")
	private Short year;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
	@Column(name = "MONTH")
	private String month;
	@Column(name = "PP_LOANMASTERID")
	private Short ppLoanmasterid;

	public Loan() {
	}

	public Loan(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getFasCode() {
		return fasCode;
	}

	public void setFasCode(String fasCode) {
		this.fasCode = fasCode;
	}

	public String getNameOfEmployee() {
		return nameOfEmployee;
	}

	public void setNameOfEmployee(String nameOfEmployee) {
		this.nameOfEmployee = nameOfEmployee;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getTypeOfAdvance() {
		return typeOfAdvance;
	}

	public void setTypeOfAdvance(String typeOfAdvance) {
		this.typeOfAdvance = typeOfAdvance;
	}

	public String getMonthlyInstal() {
		return monthlyInstal;
	}

	public void setMonthlyInstal(String monthlyInstal) {
		this.monthlyInstal = monthlyInstal;
	}

	public String getLoanAdvanceSanctionOrder() {
		return loanAdvanceSanctionOrder;
	}

	public void setLoanAdvanceSanctionOrder(String loanAdvanceSanctionOrder) {
		this.loanAdvanceSanctionOrder = loanAdvanceSanctionOrder;
	}

	public String getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(String dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getMonthOfStart() {
		return monthOfStart;
	}

	public void setMonthOfStart(String monthOfStart) {
		this.monthOfStart = monthOfStart;
	}

	public String getTotalInstl() {
		return totalInstl;
	}

	public void setTotalInstl(String totalInstl) {
		this.totalInstl = totalInstl;
	}

	public String getLastMonth() {
		return lastMonth;
	}

	public void setLastMonth(String lastMonth) {
		this.lastMonth = lastMonth;
	}

	public Short getYear() {
		return year;
	}

	public void setYear(Short year) {
		this.year = year;
	}

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Short getPpLoanmasterid() {
		return ppLoanmasterid;
	}

	public void setPpLoanmasterid(Short ppLoanmasterid) {
		this.ppLoanmasterid = ppLoanmasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Loan)) {
			return false;
		}
		Loan other = (Loan) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.Loan[ id=" + id + " ]";
	}

}
