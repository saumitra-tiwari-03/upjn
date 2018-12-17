/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_PP_EMP_ALWS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpEmpAlws.findAll", query = "SELECT v FROM ViewPpEmpAlws v"),
		@NamedQuery(name = "ViewPpEmpAlws.findByAlwname", query = "SELECT v FROM ViewPpEmpAlws v WHERE v.alwname = :alwname"),
		@NamedQuery(name = "ViewPpEmpAlws.findByAmount", query = "SELECT v FROM ViewPpEmpAlws v WHERE v.amount = :amount"),
		@NamedQuery(name = "ViewPpEmpAlws.findByPpPayalwmasterid", query = "SELECT v FROM ViewPpEmpAlws v WHERE v.ppPayalwmasterid = :ppPayalwmasterid"),
		@NamedQuery(name = "ViewPpEmpAlws.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpEmpAlws v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpEmpAlws.findBySysPaycategoryid", query = "SELECT v FROM ViewPpEmpAlws v WHERE v.sysPaycategoryid = :sysPaycategoryid"),
		@NamedQuery(name = "ViewPpEmpAlws.findByStopAlwFlag", query = "SELECT v FROM ViewPpEmpAlws v WHERE v.stopAlwFlag = :stopAlwFlag") })
public class ViewPpEmpAlws implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "ALWNAME")
	private String alwname;
	@Column(name = "AMOUNT")
	private BigInteger amount;
	@Column(name = "PP_PAYALWMASTERID")
	private Integer ppPayalwmasterid;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "SYS_PAYCATEGORYID")
	private short sysPaycategoryid;
	@Column(name = "STOP_ALW_FLAG")
	private Character stopAlwFlag;

	public ViewPpEmpAlws() {
	}

	public String getAlwname() {
		return alwname;
	}

	public void setAlwname(String alwname) {
		this.alwname = alwname;
	}

	public BigInteger getAmount() {
		return amount;
	}

	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}

	public Integer getPpPayalwmasterid() {
		return ppPayalwmasterid;
	}

	public void setPpPayalwmasterid(Integer ppPayalwmasterid) {
		this.ppPayalwmasterid = ppPayalwmasterid;
	}

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public short getSysPaycategoryid() {
		return sysPaycategoryid;
	}

	public void setSysPaycategoryid(short sysPaycategoryid) {
		this.sysPaycategoryid = sysPaycategoryid;
	}

	public Character getStopAlwFlag() {
		return stopAlwFlag;
	}

	public void setStopAlwFlag(Character stopAlwFlag) {
		this.stopAlwFlag = stopAlwFlag;
	}

}
