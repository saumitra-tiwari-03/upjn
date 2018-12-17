package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OfficeSummaryReportEntity implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String LOC_CODE;
	private String PAYMONTH;
	private String PAYYEAR;
	private String RM_OFFICEID;
	private String OFFICENAME;
	private String MAS_DISTRICTID;
	private String DISTRICTNAME;
	private String REGISTERNAME;
	private String EMPNO;
	private String EMPLOYEENAME;
	private String GROSS;
	private String TOTAL_DED;
	private String NET;
	private String ITAX;
	private String GPF;
	private String REG_EMP;
	private String EMP_ARR;
	private String REG_EMLR;
	private String EMLR_ARR;
	private String EMPLOYEE;
	private String EMPLOYER;
	private String STATUS;
	
	public String getPAYMONTH() {
		return PAYMONTH;
	}
	public void setPAYMONTH(String pAYMONTH) {
		PAYMONTH = pAYMONTH;
	}
	public String getPAYYEAR() {
		return PAYYEAR;
	}
	public void setPAYYEAR(String pAYYEAR) {
		PAYYEAR = pAYYEAR;
	}
	public String getLOC_CODE() {
		return LOC_CODE;
	}
	public void setLOC_CODE(String lOC_CODE) {
		LOC_CODE = lOC_CODE;
	}
	public String getRM_OFFICEID() {
		return RM_OFFICEID;
	}
	public void setRM_OFFICEID(String rM_OFFICEID) {
		RM_OFFICEID = rM_OFFICEID;
	}
	public String getOFFICENAME() {
		return OFFICENAME;
	}
	public void setOFFICENAME(String oFFICENAME) {
		OFFICENAME = oFFICENAME;
	}
	public String getMAS_DISTRICTID() {
		return MAS_DISTRICTID;
	}
	public void setMAS_DISTRICTID(String mAS_DISTRICTID) {
		MAS_DISTRICTID = mAS_DISTRICTID;
	}
	public String getDISTRICTNAME() {
		return DISTRICTNAME;
	}
	public void setDISTRICTNAME(String dISTRICTNAME) {
		DISTRICTNAME = dISTRICTNAME;
	}
	public String getREGISTERNAME() {
		return REGISTERNAME;
	}
	public void setREGISTERNAME(String rEGISTERNAME) {
		REGISTERNAME = rEGISTERNAME;
	}
	public String getEMPNO() {
		return EMPNO;
	}
	public void setEMPNO(String eMPNO) {
		EMPNO = eMPNO;
	}
	public String getEMPLOYEENAME() {
		return EMPLOYEENAME;
	}
	public void setEMPLOYEENAME(String eMPLOYEENAME) {
		EMPLOYEENAME = eMPLOYEENAME;
	}
	public String getGROSS() {
		return GROSS;
	}
	public void setGROSS(String gROSS) {
		GROSS = gROSS;
	}
	public String getTOTAL_DED() {
		return TOTAL_DED;
	}
	public void setTOTAL_DED(String tOTAL_DED) {
		TOTAL_DED = tOTAL_DED;
	}
	public String getNET() {
		return NET;
	}
	public void setNET(String nET) {
		NET = nET;
	}
	public String getITAX() {
		return ITAX;
	}
	public void setITAX(String iTAX) {
		ITAX = iTAX;
	}
	public String getGPF() {
		return GPF;
	}
	public void setGPF(String gPF) {
		GPF = gPF;
	}
	public String getREG_EMP() {
		return REG_EMP;
	}
	public void setREG_EMP(String rEG_EMP) {
		REG_EMP = rEG_EMP;
	}
	public String getEMP_ARR() {
		return EMP_ARR;
	}
	public void setEMP_ARR(String eMP_ARR) {
		EMP_ARR = eMP_ARR;
	}
	public String getREG_EMLR() {
		return REG_EMLR;
	}
	public void setREG_EMLR(String rEG_EMLR) {
		REG_EMLR = rEG_EMLR;
	}
	public String getEMLR_ARR() {
		return EMLR_ARR;
	}
	public void setEMLR_ARR(String eMLR_ARR) {
		EMLR_ARR = eMLR_ARR;
	}
	public String getEMPLOYEE() {
		return EMPLOYEE;
	}
	public void setEMPLOYEE(String eMPLOYEE) {
		EMPLOYEE = eMPLOYEE;
	}
	public String getEMPLOYER() {
		return EMPLOYER;
	}
	public void setEMPLOYER(String eMPLOYER) {
		EMPLOYER = eMPLOYER;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

}
