package com.nic.upjn.spring.dto;

import java.io.Serializable;

public class LoanDetailDTO implements Serializable {

	protected Long ppLoandetailid;
	protected Long ppEmployeemasterid;
	protected String ppLoanmasterid;
	protected String employeeName;
	protected String loanShortName;
	protected String loanName;
	protected String loanAmount;
	protected int max_InstallmentNo;
	protected String stop_Loan;

	protected String pa_NoOfInstallments;
	protected int paInstallmentamount;
	protected String loanSanctionOrdNo;

	protected String sanctionDate;
	protected String pa_Recovered;
	protected short paNextinstallmentno;
	protected String pa_RecovCommenceMonth;
	protected String pa_RecovCommenceYear;
	protected String isInterest;
	protected String isEditable;
	protected Integer firstinstallmentamount;
	protected String stopInstallment;
	
	protected String pa_IsFullyRecovered;
	
	
	public String getPa_IsFullyRecovered() {
		return pa_IsFullyRecovered;
	}
	public void setPa_IsFullyRecovered(String pa_IsFullyRecovered) {
		this.pa_IsFullyRecovered = pa_IsFullyRecovered;
	}
	public Long getPpLoandetailid() {
		return ppLoandetailid;
	}
	public void setPpLoandetailid(Long ppLoandetailid) {
		this.ppLoandetailid = ppLoandetailid;
	}
	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}
	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}
	public String getPpLoanmasterid() {
		return ppLoanmasterid;
	}
	public void setPpLoanmasterid(String ppLoanmasterid) {
		this.ppLoanmasterid = ppLoanmasterid;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getLoanShortName() {
		return loanShortName;
	}
	public void setLoanShortName(String loanShortName) {
		this.loanShortName = loanShortName;
	}
	public String getLoanName() {
		return loanName;
	}
	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getMax_InstallmentNo() {
		return max_InstallmentNo;
	}
	public void setMax_InstallmentNo(int max_InstallmentNo) {
		this.max_InstallmentNo = max_InstallmentNo;
	}
	public String getStop_Loan() {
		return stop_Loan;
	}
	public void setStop_Loan(String stop_Loan) {
		this.stop_Loan = stop_Loan;
	}
	public String getPa_NoOfInstallments() {
		return pa_NoOfInstallments;
	}
	public void setPa_NoOfInstallments(String pa_NoOfInstallments) {
		this.pa_NoOfInstallments = pa_NoOfInstallments;
	}
	public int getPaInstallmentamount() {
		return paInstallmentamount;
	}
	public void setPaInstallmentamount(int paInstallmentamount) {
		this.paInstallmentamount = paInstallmentamount;
	}
	public String getLoanSanctionOrdNo() {
		return loanSanctionOrdNo;
	}
	public void setLoanSanctionOrdNo(String loanSanctionOrdNo) {
		this.loanSanctionOrdNo = loanSanctionOrdNo;
	}
	public String getSanctionDate() {
		return sanctionDate;
	}
	public void setSanctionDate(String sanctionDate) {
		this.sanctionDate = sanctionDate;
	}
	public String getPa_Recovered() {
		return pa_Recovered;
	}
	public void setPa_Recovered(String pa_Recovered) {
		this.pa_Recovered = pa_Recovered;
	}
	public short getPaNextinstallmentno() {
		return paNextinstallmentno;
	}
	public void setPaNextinstallmentno(short paNextinstallmentno) {
		this.paNextinstallmentno = paNextinstallmentno;
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
	public String getIsInterest() {
		return isInterest;
	}
	public void setIsInterest(String isInterest) {
		this.isInterest = isInterest;
	}
	public String getIsEditable() {
		return isEditable;
	}
	public void setIsEditable(String isEditable) {
		this.isEditable = isEditable;
	}
	public Integer getFirstinstallmentamount() {
		return firstinstallmentamount;
	}
	public void setFirstinstallmentamount(Integer firstinstallmentamount) {
		this.firstinstallmentamount = firstinstallmentamount;
	}
	public String getStopInstallment() {
		return stopInstallment;
	}
	public void setStopInstallment(String stopInstallment) {
		this.stopInstallment = stopInstallment;
	}
	
	
	
	
	

	}