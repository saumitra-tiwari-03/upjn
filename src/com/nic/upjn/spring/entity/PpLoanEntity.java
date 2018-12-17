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
@Table(name = "PpLoanEntity")
@XmlRootElement
@NamedQueries({})
public class PpLoanEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "pp_LoanMasterID")
	private Integer pp_LoanMasterID;

	@Basic(optional = false)
	@Column(name = "LOANNAME")
	private String loanName;

	@Basic(optional = false)
	@Column(name = "loanShortName")
	private String loanShortName;

	@Basic(optional = false)
	@Column(name = "max_InstallmentNo")
	private int max_InstallmentNo;

	public Integer getPp_LoanMasterID() {
		return pp_LoanMasterID;
	}

	public void setPp_LoanMasterID(Integer pp_LoanMasterID) {
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

	public int getMax_InstallmentNo() {
		return max_InstallmentNo;
	}

	public void setMax_InstallmentNo(int max_InstallmentNo) {
		this.max_InstallmentNo = max_InstallmentNo;
	}
	
	

}
