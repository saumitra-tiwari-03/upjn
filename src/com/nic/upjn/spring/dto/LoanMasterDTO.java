package com.nic.upjn.spring.dto;

import java.io.Serializable;

public class LoanMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String pp_LoanMasterID;
	protected String loanName;
	protected String loanShortName;
	protected int pp_ScheduleMasterID;
	protected int max_InstallmentNo;

	public String getPp_LoanMasterID() {
		return pp_LoanMasterID;
	}

	public void setPp_LoanMasterID(String pp_LoanMasterID) {
		this.pp_LoanMasterID = pp_LoanMasterID;
	}

	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	public String getLoanShortName() {
		return loanShortName;
	}

	public void setLoanShortName(String loanShortName) {
		this.loanShortName = loanShortName;
	}

	public int getPp_ScheduleMasterID() {
		return pp_ScheduleMasterID;
	}

	public void setPp_ScheduleMasterID(int pp_ScheduleMasterID) {
		this.pp_ScheduleMasterID = pp_ScheduleMasterID;
	}

	public int getMax_InstallmentNo() {
		return max_InstallmentNo;
	}

	public void setMax_InstallmentNo(int max_InstallmentNo) {
		this.max_InstallmentNo = max_InstallmentNo;
	}

}
