package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdvRecDetailsEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ROWNUM")
	@Basic(optional = false)
	private long rownum;
	@Column(name = "PAYYEAR")
	private long PAYYEAR;
	@Column(name = "PAYMONTH")
	private long PAYMONTH;
	@Column(name = "PP_MONTHLYPAYID")
	private long PP_MONTHLYPAYID;
	@Column(name = "GPF_ADV_AMOUNT")
	private long GPF_ADV_AMOUNT;
	@Column(name = "INSTALLMENT_NO")
	private long INSTALLMENT_NO;
	@Column(name = "PA_NOOFINSTALLMENTS")
	private long PA_NOOFINSTALLMENTS;
	@Column(name = "LOANAMOUNT")
	private long LOANAMOUNT;

	
	
	public long getRownum() {
		return rownum;
	}
	public void setRownum(long rownum) {
		this.rownum = rownum;
	}
	public long getPAYYEAR() {
		return PAYYEAR;
	}
	public void setPAYYEAR(long pAYYEAR) {
		PAYYEAR = pAYYEAR;
	}
	public long getPAYMONTH() {
		return PAYMONTH;
	}
	public void setPAYMONTH(long pAYMONTH) {
		PAYMONTH = pAYMONTH;
	}
	public long getPP_MONTHLYPAYID() {
		return PP_MONTHLYPAYID;
	}
	public void setPP_MONTHLYPAYID(long pP_MONTHLYPAYID) {
		PP_MONTHLYPAYID = pP_MONTHLYPAYID;
	}
	public long getGPF_ADV_AMOUNT() {
		return GPF_ADV_AMOUNT;
	}
	public void setGPF_ADV_AMOUNT(long gPF_ADV_AMOUNT) {
		GPF_ADV_AMOUNT = gPF_ADV_AMOUNT;
	}
	public long getINSTALLMENT_NO() {
		return INSTALLMENT_NO;
	}
	public void setINSTALLMENT_NO(long iNSTALLMENT_NO) {
		INSTALLMENT_NO = iNSTALLMENT_NO;
	}
	public long getPA_NOOFINSTALLMENTS() {
		return PA_NOOFINSTALLMENTS;
	}
	public void setPA_NOOFINSTALLMENTS(long pA_NOOFINSTALLMENTS) {
		PA_NOOFINSTALLMENTS = pA_NOOFINSTALLMENTS;
	}
	public long getLOANAMOUNT() {
		return LOANAMOUNT;
	}
	public void setLOANAMOUNT(long lOANAMOUNT) {
		LOANAMOUNT = lOANAMOUNT;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
