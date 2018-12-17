package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OfficeBankAccountEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "FWA_BANKACCOUNTID")
	private long FWA_BANKACCOUNTID;
	@Column(name = "AC_HOLDERNAME")
	private String AC_HOLDERNAME;
	@Column(name = "AC_NUMBER")
	private String AC_NUMBER;
	@Column(name = "MAS_BANKID")
	private long MAS_BANKID;
	@Column(name = "OFFICENAME")
	private String OFFICENAME;
	@Column(name = "RM_OFFICEID")
	private long RM_OFFICEID;
	@Column(name = "BANKNAME")
	private String BANKNAME;
	@Column(name = "IFSC_CODE")
	private String IFSC_CODE;
	@Column(name = "RM_OFFICEID1")
	private String RM_OFFICEID1;
	@Column(name = "ACC_OFFICENAME")
	private String ACC_OFFICENAME;
	
	public long getFWA_BANKACCOUNTID() {
		return FWA_BANKACCOUNTID;
	}
	public void setFWA_BANKACCOUNTID(long fWA_BANKACCOUNTID) {
		FWA_BANKACCOUNTID = fWA_BANKACCOUNTID;
	}
	public String getAC_HOLDERNAME() {
		return AC_HOLDERNAME;
	}
	public void setAC_HOLDERNAME(String aC_HOLDERNAME) {
		AC_HOLDERNAME = aC_HOLDERNAME;
	}
	public String getAC_NUMBER() {
		return AC_NUMBER;
	}
	public void setAC_NUMBER(String aC_NUMBER) {
		AC_NUMBER = aC_NUMBER;
	}
	public long getMAS_BANKID() {
		return MAS_BANKID;
	}
	public void setMAS_BANKID(long mAS_BANKID) {
		MAS_BANKID = mAS_BANKID;
	}
	public String getOFFICENAME() {
		return OFFICENAME;
	}
	public void setOFFICENAME(String oFFICENAME) {
		OFFICENAME = oFFICENAME;
	}
	public long getRM_OFFICEID() {
		return RM_OFFICEID;
	}
	public void setRM_OFFICEID(long rM_OFFICEID) {
		RM_OFFICEID = rM_OFFICEID;
	}
	public String getBANKNAME() {
		return BANKNAME;
	}
	public void setBANKNAME(String bANKNAME) {
		BANKNAME = bANKNAME;
	}
	public String getIFSC_CODE() {
		return IFSC_CODE;
	}
	public void setIFSC_CODE(String iFSC_CODE) {
		IFSC_CODE = iFSC_CODE;
	}
	public String getRM_OFFICEID1() {
		return RM_OFFICEID1;
	}
	public void setRM_OFFICEID1(String rM_OFFICEID1) {
		RM_OFFICEID1 = rM_OFFICEID1;
	}
	public String getACC_OFFICENAME() {
		return ACC_OFFICENAME;
	}
	public void setACC_OFFICENAME(String aCC_OFFICENAME) {
		ACC_OFFICENAME = aCC_OFFICENAME;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
