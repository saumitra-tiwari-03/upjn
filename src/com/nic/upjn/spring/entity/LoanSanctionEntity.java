package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "LoanSanctionEntity")
@XmlRootElement
@NamedQueries({})
public class LoanSanctionEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "PP_LOANDETAILID")
	protected String pp_LoanDetailID;

	@Basic(optional = false)
	@Column(name = "LOANAMOUNT")
	protected String loanAmount;

	@Basic(optional = false)
	@Column(name = "LOANSANCTIONORDNO")
	protected String loanSanctionOrdNo;

	@Basic(optional = false)
	@Column(name = "LOANSHORTNAME")
	protected String loanShortName;
	@Basic(optional = false)
	@Column(name = "PA_INSTALLMENTAMOUNT")
	protected int pa_InstallmentAmount;
	@Column(name = "FIRSTINSTALLMENTAMOUNT")
	protected String firstinstallmentAmount;

	@Basic(optional = false)
	@Column(name = "PA_ISFULLYRECOVERED")
	protected String pa_IsFullyRecovered;

	@Basic(optional = false)
	@Column(name = "PA_NEXTINSTALLMENTNO")
	protected String pa_NextInstallmentNo;

	@Basic(optional = false)
	@Column(name = "PA_NOOFINSTALLMENTS")
	protected String pa_NoOfInstallments;

	@Column(name = "PA_RECOVCOMMENCEMONTH")
	protected String pa_RecovCommenceMonth;

	@Column(name = "PA_RECOVCOMMENCEYEAR")
	protected String pa_RecovCommenceYear;

	@Basic(optional = false)
	@Column(name = "PA_RECOVERED")
	protected String pa_Recovered;

	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	protected String pp_EmployeeMasterID;

	@Column(name = "PP_LOANMASTERID")
	private String ppLoanmasterid;

	@Basic(optional = false)
	@Column(name = "SANCTIONDATE")
	
	protected String sanctionDate;

	@Basic(optional = false)
	@Column(name = "STOP_LOAN")
	protected String stop_Loan;

	@Basic(optional = false)
	@Column(name = "max_InstallmentNo")
	protected int max_InstallmentNo;

	@Basic(optional = false)
	@Column(name = "ISINTEREST")
	protected String isInterest;

	public String getPp_LoanDetailID() {
		return pp_LoanDetailID;
	}

	public void setPp_LoanDetailID(String pp_LoanDetailID) {
		this.pp_LoanDetailID = pp_LoanDetailID;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanSanctionOrdNo() {
		return loanSanctionOrdNo;
	}

	public void setLoanSanctionOrdNo(String loanSanctionOrdNo) {
		this.loanSanctionOrdNo = loanSanctionOrdNo;
	}

	public String getLoanShortName() {
		return loanShortName;
	}

	public void setLoanShortName(String loanShortName) {
		this.loanShortName = loanShortName;
	}

	public int getPa_InstallmentAmount() {
		return pa_InstallmentAmount;
	}

	public void setPa_InstallmentAmount(int pa_InstallmentAmount) {
		this.pa_InstallmentAmount = pa_InstallmentAmount;
	}

	public String getFirstinstallmentAmount() {
		return firstinstallmentAmount;
	}

	public void setFirstinstallmentAmount(String firstinstallmentAmount) {
		this.firstinstallmentAmount = firstinstallmentAmount;
	}

	public String getPa_IsFullyRecovered() {
		return pa_IsFullyRecovered;
	}

	public void setPa_IsFullyRecovered(String pa_IsFullyRecovered) {
		this.pa_IsFullyRecovered = pa_IsFullyRecovered;
	}

	public String getPa_NextInstallmentNo() {
		return pa_NextInstallmentNo;
	}

	public void setPa_NextInstallmentNo(String pa_NextInstallmentNo) {
		this.pa_NextInstallmentNo = pa_NextInstallmentNo;
	}

	public String getPa_NoOfInstallments() {
		return pa_NoOfInstallments;
	}

	public void setPa_NoOfInstallments(String pa_NoOfInstallments) {
		this.pa_NoOfInstallments = pa_NoOfInstallments;
	}

	public String getPa_RecovCommenceMonth() {
		return pa_RecovCommenceMonth;
	}

	public void setPa_RecovCommenceMonth(String pa_RecovCommenceMonth) {
		this.pa_RecovCommenceMonth = pa_RecovCommenceMonth;
	}

	public String getPa_RecovCommenceYear() {
		return pa_RecovCommenceYear;
	}

	public void setPa_RecovCommenceYear(String pa_RecovCommenceYear) {
		this.pa_RecovCommenceYear = pa_RecovCommenceYear;
	}

	public String getPa_Recovered() {
		return pa_Recovered;
	}

	public void setPa_Recovered(String pa_Recovered) {
		this.pa_Recovered = pa_Recovered;
	}

	public String getPp_EmployeeMasterID() {
		return pp_EmployeeMasterID;
	}

	public void setPp_EmployeeMasterID(String pp_EmployeeMasterID) {
		this.pp_EmployeeMasterID = pp_EmployeeMasterID;
	}

	public String getPpLoanmasterid() {
		return ppLoanmasterid;
	}

	public void setPpLoanmasterid(String ppLoanmasterid) {
		this.ppLoanmasterid = ppLoanmasterid;
	}

	public String getSanctionDate() {
		return sanctionDate;
	}

	public void setSanctionDate(String sanctionDate) {
		this.sanctionDate = sanctionDate;
	}

	public String getStop_Loan() {
		return stop_Loan;
	}

	public void setStop_Loan(String stop_Loan) {
		this.stop_Loan = stop_Loan;
	}

	public int getMax_InstallmentNo() {
		return max_InstallmentNo;
	}

	public void setMax_InstallmentNo(int max_InstallmentNo) {
		this.max_InstallmentNo = max_InstallmentNo;
	}

	public String getIsInterest() {
		return isInterest;
	}

	public void setIsInterest(String isInterest) {
		this.isInterest = isInterest;
	}

}
