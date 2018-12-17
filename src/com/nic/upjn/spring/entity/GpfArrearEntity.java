package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="GPF_ARREAR")
@XmlRootElement
@NamedQueries({@NamedQuery(name="GpfArrear.findbycriteria",query="FROM GpfArrearEntity WHERE PP_EMPLOYEEMASTERID = ? and ARREAR_MONTH = ?  and ARREAR_YEAR = ? ")})
public class GpfArrearEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_GPF_ARREAR", allocationSize = 1)
	@Id
	@Column(name = "GPF_ARREARID")
	@Basic(optional = false)
	private long GPF_ARREARID;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long PP_EMPLOYEEMASTERID;
	@Column(name = "DATE_OF_ENTRY")
	private Date DATE_OF_ENTRY;
	@Column(name = "BILL_NUMBER")
	private String BILL_NUMBER;
	@Column(name = "ARREAR_YEAR")
	private long ARREAR_YEAR;
	@Column(name = "ARREAR_TO")
	private Date ARREAR_TO;
	@Column(name = "ARREAR_MONTH")
	private long ARREAR_MONTH;
	@Column(name = "ARREAR_FROM")
	private Date ARREAR_FROM;
	@Column(name = "AMOUNT")
	private long AMOUNT;
	@Column(name = "ARREARTYPE")
	private String ARREARTYPE;
	
	public long getGPF_ARREARID() {
		return GPF_ARREARID;
	}
	public void setGPF_ARREARID(long gPF_ARREARID) {
		GPF_ARREARID = gPF_ARREARID;
	}
	public long getPP_EMPLOYEEMASTERID() {
		return PP_EMPLOYEEMASTERID;
	}
	public void setPP_EMPLOYEEMASTERID(long pP_EMPLOYEEMASTERID) {
		PP_EMPLOYEEMASTERID = pP_EMPLOYEEMASTERID;
	}
	public Date getDATE_OF_ENTRY() {
		return DATE_OF_ENTRY;
	}
	public void setDATE_OF_ENTRY(Date dATE_OF_ENTRY) {
		DATE_OF_ENTRY = dATE_OF_ENTRY;
	}
	
	public String getBILL_NUMBER() {
		return BILL_NUMBER;
	}
	public void setBILL_NUMBER(String bILL_NUMBER) {
		BILL_NUMBER = bILL_NUMBER;
	}
	public long getARREAR_YEAR() {
		return ARREAR_YEAR;
	}
	public void setARREAR_YEAR(long aRREAR_YEAR) {
		ARREAR_YEAR = aRREAR_YEAR;
	}
	public Date getARREAR_TO() {
		return ARREAR_TO;
	}
	public void setARREAR_TO(Date aRREAR_TO) {
		ARREAR_TO = aRREAR_TO;
	}
	public long getARREAR_MONTH() {
		return ARREAR_MONTH;
	}
	public void setARREAR_MONTH(long aRREAR_MONTH) {
		ARREAR_MONTH = aRREAR_MONTH;
	}
	public Date getARREAR_FROM() {
		return ARREAR_FROM;
	}
	public void setARREAR_FROM(Date aRREAR_FROM) {
		ARREAR_FROM = aRREAR_FROM;
	}
	public long getAMOUNT() {
		return AMOUNT;
	}
	public void setAMOUNT(long aMOUNT) {
		AMOUNT = aMOUNT;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getARREARTYPE() {
		return ARREARTYPE;
	}
	public void setARREARTYPE(String aRREARTYPE) {
		ARREARTYPE = aRREARTYPE;
	}
	
	
	
	
}
