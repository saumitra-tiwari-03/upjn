package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "GPFLEDGER")
public class GPFLedgerEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_GPF_GPFLEDGER", allocationSize = 1)
	@Id
	@Basic(optional = false)
	@Column(name = "PP_GPFLEDGERID")
	private long PP_GPFLEDGERID;
	@Column(name = "TOTALDEPOSIT")
	private long TOTALDEPOSIT;
	@Column(name = "TEMP_WITHDRAWAL")
	private long TEMP_WITHDRAWAL;
	@Column(name = "SALARY")
	private long SALARY;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long PP_EMPLOYEEMASTERID;
	@Column(name = "INTEREST_RATE")
	private long INTEREST_RATE;
	/*@Column(name = "INTEREST_AMOUNT")
	private long INTEREST_AMOUNT;*/
	@Column(name = "INSTL_NO")
	private String INSTL_NO;
	@Column(name = "FINAL_WITHDRAWAL")
	private long FINAL_WITHDRAWAL;
	/*@Column(name = "BALANCE")
	private long BALANCE;*/
	@Column(name = "ARREAR")
	private long ARREAR;
	@Column(name = "AMOUNT")
	private long AMOUNT;
	@Column(name = "MONTH")
	private String MONTH;
	@Column(name = "MONTHNAME")
	private String MONTHNAME;
	@Column(name = "YEAR")
	private String YEAR;
	@Column(name = "PA_NOOFINSTALLMENTS")
	private String PA_NOOFINSTALLMENTS;

	public long getPP_GPFLEDGERID() {
		return PP_GPFLEDGERID;
	}
	public void setPP_GPFLEDGERID(long pP_GPFLEDGERID) {
		PP_GPFLEDGERID = pP_GPFLEDGERID;
	}
	public long getTOTALDEPOSIT() {
		return TOTALDEPOSIT;
	}
	public void setTOTALDEPOSIT(long tOTALDEPOSIT) {
		TOTALDEPOSIT = tOTALDEPOSIT;
	}
	public long getTEMP_WITHDRAWAL() {
		return TEMP_WITHDRAWAL;
	}
	public void setTEMP_WITHDRAWAL(long tEMP_WITHDRAWAL) {
		TEMP_WITHDRAWAL = tEMP_WITHDRAWAL;
	}
	public long getSALARY() {
		return SALARY;
	}
	public void setSALARY(long sALARY) {
		SALARY = sALARY;
	}
	public long getPP_EMPLOYEEMASTERID() {
		return PP_EMPLOYEEMASTERID;
	}
	public void setPP_EMPLOYEEMASTERID(long pP_EMPLOYEEMASTERID) {
		PP_EMPLOYEEMASTERID = pP_EMPLOYEEMASTERID;
	}
	public long getINTEREST_RATE() {
		return INTEREST_RATE;
	}
	public void setINTEREST_RATE(long iNTEREST_RATE) {
		INTEREST_RATE = iNTEREST_RATE;
	}
	/*public long getINTEREST_AMOUNT() {
		return INTEREST_AMOUNT;
	}
	public void setINTEREST_AMOUNT(long iNTEREST_AMOUNT) {
		INTEREST_AMOUNT = iNTEREST_AMOUNT;
	}*/
	public String getINSTL_NO() {
		return INSTL_NO;
	}
	public void setINSTL_NO(String iNSTL_NO) {
		INSTL_NO = iNSTL_NO;
	}
	public long getFINAL_WITHDRAWAL() {
		return FINAL_WITHDRAWAL;
	}
	public void setFINAL_WITHDRAWAL(long fINAL_WITHDRAWAL) {
		FINAL_WITHDRAWAL = fINAL_WITHDRAWAL;
	}
	/*public long getBALANCE() {
		return BALANCE;
	}
	public void setBALANCE(long bALANCE) {
		BALANCE = bALANCE;
	}*/
	public long getARREAR() {
		return ARREAR;
	}
	public void setARREAR(long aRREAR) {
		ARREAR = aRREAR;
	}
	public long getAMOUNT() {
		return AMOUNT;
	}
	public void setAMOUNT(long aMOUNT) {
		AMOUNT = aMOUNT;
	}
	public String getMONTH() {
		return MONTH;
	}
	public void setMONTH(String mONTH) {
		MONTH = mONTH;
	}
	public String getYEAR() {
		return YEAR;
	}
	public void setYEAR(String yEAR) {
		YEAR = yEAR;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPA_NOOFINSTALLMENTS() {
		return PA_NOOFINSTALLMENTS;
	}
	public void setPA_NOOFINSTALLMENTS(String pA_NOOFINSTALLMENTS) {
		PA_NOOFINSTALLMENTS = pA_NOOFINSTALLMENTS;
	}
	public String getMONTHNAME() {
		return MONTHNAME;
	}
	public void setMONTHNAME(String mONTHNAME) {
		MONTHNAME = mONTHNAME;
	}
	

	
	
}
