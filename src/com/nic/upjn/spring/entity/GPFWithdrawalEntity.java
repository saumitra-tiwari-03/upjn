package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="GPF_WITHDRAWAL")
public class GPFWithdrawalEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_GPF_WITHDRAWAL", allocationSize = 1)
	@Id
	@Column(name = "GPF_WITHDRAWALID")
	@Basic(optional = false)
	private long GPF_WITHDRAWALID;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long PP_EMPLOYEEMASTERID;
	@Column(name = "YEAR")
	private long YEAR;
	@Column(name = "MONTH")
	private long MONTH;
	@Column(name = "AMOUNT")
	private long AMOUNT;
	@Column(name = "ORDERDATE")
	private Date ORDERDATE;
	@Column(name = "EFFECTIVEDATE")
	private Date EFFECTIVEDATE;
	@Column(name = "DATE_OF_ENTRY")
	private Date DATE_OF_ENTRY;
	@Column(name = "ORDERNUMBER")
	private String ORDERNUMBER;
	@Column(name = "BILL_NUMBER")
	private String BILL_NUMBER;

	public long getGPF_WITHDRAWALID() {
		return GPF_WITHDRAWALID;
	}
	public void setGPF_WITHDRAWALID(long gPF_WITHDRAWALID) {
		GPF_WITHDRAWALID = gPF_WITHDRAWALID;
	}
	public long getPP_EMPLOYEEMASTERID() {
		return PP_EMPLOYEEMASTERID;
	}
	public void setPP_EMPLOYEEMASTERID(long pP_EMPLOYEEMASTERID) {
		PP_EMPLOYEEMASTERID = pP_EMPLOYEEMASTERID;
	}
	public long getYEAR() {
		return YEAR;
	}
	public void setYEAR(long yEAR) {
		YEAR = yEAR;
	}
	public long getMONTH() {
		return MONTH;
	}
	public void setMONTH(long mONTH) {
		MONTH = mONTH;
	}
	public long getAMOUNT() {
		return AMOUNT;
	}
	public void setAMOUNT(long aMOUNT) {
		AMOUNT = aMOUNT;
	}
	public Date getORDERDATE() {
		return ORDERDATE;
	}
	public void setORDERDATE(Date oRDERDATE) {
		ORDERDATE = oRDERDATE;
	}
	public Date getEFFECTIVEDATE() {
		return EFFECTIVEDATE;
	}
	public void setEFFECTIVEDATE(Date eFFECTIVEDATE) {
		EFFECTIVEDATE = eFFECTIVEDATE;
	}
	public Date getDATE_OF_ENTRY() {
		return DATE_OF_ENTRY;
	}
	public void setDATE_OF_ENTRY(Date dATE_OF_ENTRY) {
		DATE_OF_ENTRY = dATE_OF_ENTRY;
	}
	public String getORDERNUMBER() {
		return ORDERNUMBER;
	}
	public void setORDERNUMBER(String oRDERNUMBER) {
		ORDERNUMBER = oRDERNUMBER;
	}
	public String getBILL_NUMBER() {
		return BILL_NUMBER;
	}
	public void setBILL_NUMBER(String bILL_NUMBER) {
		BILL_NUMBER = bILL_NUMBER;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
