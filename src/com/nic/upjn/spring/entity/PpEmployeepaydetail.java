/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author NICSI
 */
@Entity
@Table(name = "PP_EMPLOYEEPAYDETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PpEmployeepaydetail.findAll", query = "SELECT p FROM PpEmployeepaydetail p"),
    @NamedQuery(name = "PpEmployeepaydetail.findByPpEmployeepaydetailid", query = "SELECT p FROM PpEmployeepaydetail p WHERE p.ppEmployeepaydetailid = :ppEmployeepaydetailid"),
    @NamedQuery(name = "PpEmployeepaydetail.findByBankaccno", query = "SELECT p FROM PpEmployeepaydetail p WHERE p.bankaccno = :bankaccno"),
    @NamedQuery(name = "PpEmployeepaydetail.findByPpRegistermasterid", query = "SELECT p FROM PpEmployeepaydetail p WHERE p.ppRegistermasterid = :ppRegistermasterid"),
    @NamedQuery(name = "PpEmployeepaydetail.findByPpEmployeemasterid", query = "FROM PpEmployeepaydetail WHERE ppEmployeemasterid = ?"),
    @NamedQuery(name = "PpEmployeepaydetail.findBySalarypercent", query = "SELECT p FROM PpEmployeepaydetail p WHERE p.salarypercent = :salarypercent"),
    @NamedQuery(name = "PpEmployeepaydetail.findByNoofdays", query = "SELECT p FROM PpEmployeepaydetail p WHERE p.noofdays = :noofdays"),
    @NamedQuery(name = "PpEmployeepaydetail.findByHeadquarter", query = "SELECT p FROM PpEmployeepaydetail p WHERE p.headquarter = :headquarter"),
    @NamedQuery(name = "PpEmployeepaydetail.findByHratowncategoryid", query = "SELECT p FROM PpEmployeepaydetail p WHERE p.hratowncategoryid = :hratowncategoryid"),
    @NamedQuery(name = "PpEmployeepaydetail.findByCcatowncategoryid", query = "SELECT p FROM PpEmployeepaydetail p WHERE p.ccatowncategoryid = :ccatowncategoryid"),
    @NamedQuery(name = "PpEmployeepaydetail.findByDefaultincrementamount", query = "SELECT p FROM PpEmployeepaydetail p WHERE p.defaultincrementamount = :defaultincrementamount"),
    @NamedQuery(name = "PpEmployeepaydetail.findByNextincrementmonth", query = "SELECT p FROM PpEmployeepaydetail p WHERE p.nextincrementmonth = :nextincrementmonth"),
    @NamedQuery(name = "PpEmployeepaydetail.findByBankName", query = "SELECT p FROM PpEmployeepaydetail p WHERE p.bankName = :bankName"),
    @NamedQuery(name = "PpEmployeepaydetail.findByBranchName", query = "SELECT p FROM PpEmployeepaydetail p WHERE p.branchName = :branchName"),
    @NamedQuery(name = "PpEmployeepaydetail.findByIfscCode", query = "SELECT p FROM PpEmployeepaydetail p WHERE p.ifscCode = :ifscCode")})
public class PpEmployeepaydetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_PP_EMPLOYEEPAYDETAIL")
    @Id
    @Column(name = "PP_EMPLOYEEPAYDETAILID")
    private BigDecimal ppEmployeepaydetailid;
    @Column(name = "BANKACCNO")
    private String bankaccno;
    @Column(name = "PP_REGISTERMASTERID")
    private Short ppRegistermasterid;
    @Column(name = "SALARYPERCENT")
    private String salarypercent;
    @Column(name = "NOOFDAYS")
    private String noofdays;
    @Column(name = "HEADQUARTER")
    private String headquarter;
    @Column(name = "HRATOWNCATEGORYID")
    private String hratowncategoryid;
    @Column(name = "CCATOWNCATEGORYID")
    private String ccatowncategoryid;
    @Column(name = "DEFAULTINCREMENTAMOUNT")
    private Integer defaultincrementamount;
    @Column(name = "NEXTINCREMENTMONTH")
    private String nextincrementmonth;
    @Column(name = "BANK_NAME")
    private String bankName;
    @Column(name = "BRANCH_NAME")
    private String branchName;
    @Column(name = "IFSC_CODE")
    private String ifscCode;
    @Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
    // PP_PAYSCALEMASTERID,SYS_PAYMENTMODEID,BANKACCNO, SYS_PAYCATEGORYID, PP_SECTIONMASTERID,FWA_BANKACCOUNTID,
    @Column(name = "PP_PAYSCALEMASTERID")
	private Long ppScalemasterid;
    @Column(name = "SYS_PAYMENTMODEID")
	private char sysPaymentmodeid;
    @Column(name = "SYS_PAYCATEGORYID")
	private Long sysPaycategoryid;
    @Column(name = "PP_SECTIONMASTERID")
	private Long ppSectionmasterid;
    @Column(name = "FWA_BANKACCOUNTID")
	private Long fwaBankaccountid;
    
    
  
    public Long getPpScalemasterid() {
		return ppScalemasterid;
	}

	public void setPpScalemasterid(Long ppScalemasterid) {
		this.ppScalemasterid = ppScalemasterid;
	}

	public char getSysPaymentmodeid() {
		return sysPaymentmodeid;
	}

	public void setSysPaymentmodeid(char sysPaymentmodeid) {
		this.sysPaymentmodeid = sysPaymentmodeid;
	}

	public Long getSysPaycategoryid() {
		return sysPaycategoryid;
	}

	public void setSysPaycategoryid(Long sysPaycategoryid) {
		this.sysPaycategoryid = sysPaycategoryid;
	}

	public Long getPpSectionmasterid() {
		return ppSectionmasterid;
	}

	public void setPpSectionmasterid(Long ppSectionmasterid) {
		this.ppSectionmasterid = ppSectionmasterid;
	}

	public Long getFwaBankaccountid() {
		return fwaBankaccountid;
	}

	public void setFwaBankaccountid(Long fwaBankaccountid) {
		this.fwaBankaccountid = fwaBankaccountid;
	}

	public PpEmployeepaydetail() {
    }

    public PpEmployeepaydetail(BigDecimal ppEmployeepaydetailid) {
        this.ppEmployeepaydetailid = ppEmployeepaydetailid;
    }

    public BigDecimal getPpEmployeepaydetailid() {
        return ppEmployeepaydetailid;
    }

    public void setPpEmployeepaydetailid(BigDecimal ppEmployeepaydetailid) {
        this.ppEmployeepaydetailid = ppEmployeepaydetailid;
    }

    public String getBankaccno() {
        return bankaccno;
    }

    public void setBankaccno(String bankaccno) {
        this.bankaccno = bankaccno;
    }

    public Short getPpRegistermasterid() {
        return ppRegistermasterid;
    }

    public void setPpRegistermasterid(Short ppRegistermasterid) {
        this.ppRegistermasterid = ppRegistermasterid;
    }

    public String getSalarypercent() {
        return salarypercent;
    }

    public void setSalarypercent(String salarypercent) {
        this.salarypercent = salarypercent;
    }

    public String getNoofdays() {
        return noofdays;
    }

    public void setNoofdays(String noofdays) {
        this.noofdays = noofdays;
    }

    public String getHeadquarter() {
        return headquarter;
    }

    public void setHeadquarter(String headquarter) {
        this.headquarter = headquarter;
    }

    public String getHratowncategoryid() {
        return hratowncategoryid;
    }

    public void setHratowncategoryid(String hratowncategoryid) {
        this.hratowncategoryid = hratowncategoryid;
    }

    public String getCcatowncategoryid() {
        return ccatowncategoryid;
    }

    public void setCcatowncategoryid(String ccatowncategoryid) {
        this.ccatowncategoryid = ccatowncategoryid;
    }

    public Integer getDefaultincrementamount() {
        return defaultincrementamount;
    }

    public void setDefaultincrementamount(Integer defaultincrementamount) {
        this.defaultincrementamount = defaultincrementamount;
    }

    public String getNextincrementmonth() {
        return nextincrementmonth;
    }

    public void setNextincrementmonth(String nextincrementmonth) {
        this.nextincrementmonth = nextincrementmonth;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ppEmployeepaydetailid != null ? ppEmployeepaydetailid.hashCode() : 0);
        return hash;
    }

	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PpEmployeepaydetail)) {
            return false;
        }
        PpEmployeepaydetail other = (PpEmployeepaydetail) object;
        if ((this.ppEmployeepaydetailid == null && other.ppEmployeepaydetailid != null) || (this.ppEmployeepaydetailid != null && !this.ppEmployeepaydetailid.equals(other.ppEmployeepaydetailid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PpEmployeepaydetail[ ppEmployeepaydetailid=" + ppEmployeepaydetailid + " ]";
    }
    
}
