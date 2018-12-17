package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class YearlyPayReportEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	protected Integer ROWNUM;
	protected String EMPLOYEECODE;
	protected String PAYCATEGORY;
	protected String GPFACNO;
	protected String BANKACCNO;
	protected String EMPNAME;
	protected String DESIGNATION;
	private String NOOFDAYS;
	private short PAYMONTH;
	private short PAYYEAR;
	private BigInteger HEADID;
	private String HEADTYPE;
	protected String HEADNAME;
	private BigDecimal AMOUNT;
	protected String INSTALLMENT;
	private Integer PP_PAYSCALEMASTERID;
	private String PP_EMPLOYEEPAYDETAILID;
	private Character MONTH;
	private Character YEAR;
	private String TOTAL_EMPLOYEE;
	private Integer NETPAY;
	private Character BILLTYPE_FLAG;
    private Date BILLDATE;
    private Character ISLOCKED;
    private Integer BILLAMOUNT;
    private String BILLNO;
    private String BILLCLERKNAME;
    private long BILLCLERKID;
    private Integer PP_PAYBILLDETAILID;
    private Integer RM_OFFICEID;
  //  private Integer RM_OFFICEID_1;
  //  private Integer PP_PAYBILLDETAILID_1;
    private Short PP_REGISTERMASTERID;
  //  private Short PP_REGISTERMASTERID_1;
	private Long PP_MONTHLYPAYID;
	private BigInteger PRINT_ORDER;
//	private String PP_PAYBILLDETAILID;
//	private String WEIGHT;
	
	
	

	public Integer getROWNUM() {
		return ROWNUM;
	}
	public void setROWNUM(Integer rOWNUM) {
		ROWNUM = rOWNUM;
	}
	public String getEMPLOYEECODE() {
		return EMPLOYEECODE;
	}
	public void setEMPLOYEECODE(String eMPLOYEECODE) {
		EMPLOYEECODE = eMPLOYEECODE;
	}
	public String getPAYCATEGORY() {
		return PAYCATEGORY;
	}
	public void setPAYCATEGORY(String pAYCATEGORY) {
		PAYCATEGORY = pAYCATEGORY;
	}
	public String getGPFACNO() {
		return GPFACNO;
	}
	public void setGPFACNO(String gPFACNO) {
		GPFACNO = gPFACNO;
	}
	public String getBANKACCNO() {
		return BANKACCNO;
	}
	public void setBANKACCNO(String bANKACCNO) {
		BANKACCNO = bANKACCNO;
	}
	public String getEMPNAME() {
		return EMPNAME;
	}
	public void setEMPNAME(String eMPNAME) {
		EMPNAME = eMPNAME;
	}
	
	public String getDESIGNATION() {
		return DESIGNATION;
	}
	public void setDESIGNATION(String dESIGNATION) {
		DESIGNATION = dESIGNATION;
	}
	public String getNOOFDAYS() {
		return NOOFDAYS;
	}
	public void setNOOFDAYS(String nOOFDAYS) {
		NOOFDAYS = nOOFDAYS;
	}
	public short getPAYMONTH() {
		return PAYMONTH;
	}
	public void setPAYMONTH(short pAYMONTH) {
		PAYMONTH = pAYMONTH;
	}
	public short getPAYYEAR() {
		return PAYYEAR;
	}
	public void setPAYYEAR(short pAYYEAR) {
		PAYYEAR = pAYYEAR;
	}
	public BigInteger getHEADID() {
		return HEADID;
	}
	public void setHEADID(BigInteger hEADID) {
		HEADID = hEADID;
	}
	public String getHEADTYPE() {
		return HEADTYPE;
	}
	public void setHEADTYPE(String hEADTYPE) {
		HEADTYPE = hEADTYPE;
	}
	public String getHEADNAME() {
		return HEADNAME;
	}
	public void setHEADNAME(String hEADNAME) {
		HEADNAME = hEADNAME;
	}
	public BigDecimal getAMOUNT() {
		return AMOUNT;
	}
	public void setAMOUNT(BigDecimal aMOUNT) {
		AMOUNT = aMOUNT;
	}
	public String getINSTALLMENT() {
		return INSTALLMENT;
	}
	public void setINSTALLMENT(String iNSTALLMENT) {
		INSTALLMENT = iNSTALLMENT;
	}
	public Integer getPP_PAYSCALEMASTERID() {
		return PP_PAYSCALEMASTERID;
	}
	public void setPP_PAYSCALEMASTERID(Integer pP_PAYSCALEMASTERID) {
		PP_PAYSCALEMASTERID = pP_PAYSCALEMASTERID;
	}
	
	public String getPP_EMPLOYEEPAYDETAILID() {
		return PP_EMPLOYEEPAYDETAILID;
	}
	public void setPP_EMPLOYEEPAYDETAILID(String pP_EMPLOYEEPAYDETAILID) {
		PP_EMPLOYEEPAYDETAILID = pP_EMPLOYEEPAYDETAILID;
	}
	public Character getMONTH() {
		return MONTH;
	}
	public void setMONTH(Character mONTH) {
		MONTH = mONTH;
	}
	public Character getYEAR() {
		return YEAR;
	}
	public void setYEAR(Character yEAR) {
		YEAR = yEAR;
	}
	public String getTOTAL_EMPLOYEE() {
		return TOTAL_EMPLOYEE;
	}
	public void setTOTAL_EMPLOYEE(String tOTAL_EMPLOYEE) {
		TOTAL_EMPLOYEE = tOTAL_EMPLOYEE;
	}
	public Integer getNETPAY() {
		return NETPAY;
	}
	public void setNETPAY(Integer nETPAY) {
		NETPAY = nETPAY;
	}
	public Character getBILLTYPE_FLAG() {
		return BILLTYPE_FLAG;
	}
	public void setBILLTYPE_FLAG(Character bILLTYPE_FLAG) {
		BILLTYPE_FLAG = bILLTYPE_FLAG;
	}
	public Date getBILLDATE() {
		return BILLDATE;
	}
	public void setBILLDATE(Date bILLDATE) {
		BILLDATE = bILLDATE;
	}
	public Character getISLOCKED() {
		return ISLOCKED;
	}
	public void setISLOCKED(Character iSLOCKED) {
		ISLOCKED = iSLOCKED;
	}
	public Integer getBILLAMOUNT() {
		return BILLAMOUNT;
	}
	public void setBILLAMOUNT(Integer bILLAMOUNT) {
		BILLAMOUNT = bILLAMOUNT;
	}
	public String getBILLNO() {
		return BILLNO;
	}
	public void setBILLNO(String bILLNO) {
		BILLNO = bILLNO;
	}
	public String getBILLCLERKNAME() {
		return BILLCLERKNAME;
	}
	public void setBILLCLERKNAME(String bILLCLERKNAME) {
		BILLCLERKNAME = bILLCLERKNAME;
	}
	public long getBILLCLERKID() {
		return BILLCLERKID;
	}
	public void setBILLCLERKID(long bILLCLERKID) {
		BILLCLERKID = bILLCLERKID;
	}
	public Integer getPP_PAYBILLDETAILID() {
		return PP_PAYBILLDETAILID;
	}
	public void setPP_PAYBILLDETAILID(Integer pP_PAYBILLDETAILID) {
		PP_PAYBILLDETAILID = pP_PAYBILLDETAILID;
	}
	public Integer getRM_OFFICEID() {
		return RM_OFFICEID;
	}
	public void setRM_OFFICEID(Integer rM_OFFICEID) {
		RM_OFFICEID = rM_OFFICEID;
	}
	public Short getPP_REGISTERMASTERID() {
		return PP_REGISTERMASTERID;
	}
	public void setPP_REGISTERMASTERID(Short pP_REGISTERMASTERID) {
		PP_REGISTERMASTERID = pP_REGISTERMASTERID;
	}
	public Long getPP_MONTHLYPAYID() {
		return PP_MONTHLYPAYID;
	}
	public void setPP_MONTHLYPAYID(Long pP_MONTHLYPAYID) {
		PP_MONTHLYPAYID = pP_MONTHLYPAYID;
	}
	public BigInteger getPRINT_ORDER() {
		return PRINT_ORDER;
	}
	public void setPRINT_ORDER(BigInteger pRINT_ORDER) {
		PRINT_ORDER = pRINT_ORDER;
	}

	
	
    
}
