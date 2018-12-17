package com.nic.upjn.spring.entity;

import java.io.Serializable;

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
public class PpNpsdetailEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "PP_NPSDETAILID")
	private String npsdetailid;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private String pp_EmployeeMasterID;
	@Column(name = "MON_CONTR")
	private String mon_contr;
	@Column(name = "YEAR_CONTR")
	private String year_contr;
	@Column(name = "EMP_CONT_AMT")
	private String emp_cont_amt;
	@Column(name = "ACTUAL_DED_MON")
    private String actual_ded_mon;
	@Column(name = "ACTUAL_DED_YEAR")
    private String actual_ded_year;
	@Column(name = "joining_mnth")
    private String joining_mnth;
	@Column(name = "startmon_forregular_cont")
    private String startmon_forregular_cont;
	public String getNpsdetailid() {
		return npsdetailid;
	}
	public void setNpsdetailid(String npsdetailid) {
		this.npsdetailid = npsdetailid;
	}
	public String getPp_EmployeeMasterID() {
		return pp_EmployeeMasterID;
	}
	public void setPp_EmployeeMasterID(String pp_EmployeeMasterID) {
		this.pp_EmployeeMasterID = pp_EmployeeMasterID;
	}
	public String getMon_contr() {
		return mon_contr;
	}
	public void setMon_contr(String mon_contr) {
		this.mon_contr = mon_contr;
	}
	public String getYear_contr() {
		return year_contr;
	}
	public void setYear_contr(String year_contr) {
		this.year_contr = year_contr;
	}
	public String getEmp_cont_amt() {
		return emp_cont_amt;
	}
	public void setEmp_cont_amt(String emp_cont_amt) {
		this.emp_cont_amt = emp_cont_amt;
	}
	public String getActual_ded_mon() {
		return actual_ded_mon;
	}
	public void setActual_ded_mon(String actual_ded_mon) {
		this.actual_ded_mon = actual_ded_mon;
	}
	public String getActual_ded_year() {
		return actual_ded_year;
	}
	public void setActual_ded_year(String actual_ded_year) {
		this.actual_ded_year = actual_ded_year;
	}
	public String getJoining_mnth() {
		return joining_mnth;
	}
	public void setJoining_mnth(String joining_mnth) {
		this.joining_mnth = joining_mnth;
	}
	public String getStartmon_forregular_cont() {
		return startmon_forregular_cont;
	}
	public void setStartmon_forregular_cont(String startmon_forregular_cont) {
		this.startmon_forregular_cont = startmon_forregular_cont;
	}
	
	

}
