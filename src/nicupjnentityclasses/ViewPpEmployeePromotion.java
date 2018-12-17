/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_PP_EMPLOYEE_PROMOTION")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewPpEmployeePromotion.findAll", query = "SELECT v FROM ViewPpEmployeePromotion v"),
		@NamedQuery(name = "ViewPpEmployeePromotion.findByPpPostingdetailid", query = "SELECT v FROM ViewPpEmployeePromotion v WHERE v.ppPostingdetailid = :ppPostingdetailid"),
		@NamedQuery(name = "ViewPpEmployeePromotion.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpEmployeePromotion v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpEmployeePromotion.findByPpDesignationmasterid", query = "SELECT v FROM ViewPpEmployeePromotion v WHERE v.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "ViewPpEmployeePromotion.findByEffectivedate", query = "SELECT v FROM ViewPpEmployeePromotion v WHERE v.effectivedate = :effectivedate"),
		@NamedQuery(name = "ViewPpEmployeePromotion.findByPostingorderno", query = "SELECT v FROM ViewPpEmployeePromotion v WHERE v.postingorderno = :postingorderno"),
		@NamedQuery(name = "ViewPpEmployeePromotion.findByOrderdate", query = "SELECT v FROM ViewPpEmployeePromotion v WHERE v.orderdate = :orderdate"),
		@NamedQuery(name = "ViewPpEmployeePromotion.findByRmOfficeid", query = "SELECT v FROM ViewPpEmployeePromotion v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPpEmployeePromotion.findByJoindate", query = "SELECT v FROM ViewPpEmployeePromotion v WHERE v.joindate = :joindate"),
		@NamedQuery(name = "ViewPpEmployeePromotion.findByJoinanfn", query = "SELECT v FROM ViewPpEmployeePromotion v WHERE v.joinanfn = :joinanfn"),
		@NamedQuery(name = "ViewPpEmployeePromotion.findByIsPromotionForego", query = "SELECT v FROM ViewPpEmployeePromotion v WHERE v.isPromotionForego = :isPromotionForego"),
		@NamedQuery(name = "ViewPpEmployeePromotion.findByDesignation", query = "SELECT v FROM ViewPpEmployeePromotion v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewPpEmployeePromotion.findByIslatest", query = "SELECT v FROM ViewPpEmployeePromotion v WHERE v.islatest = :islatest") })
public class ViewPpEmployeePromotion implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "PP_POSTINGDETAILID")
	private Long ppPostingdetailid;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Integer ppDesignationmasterid;
	@Column(name = "EFFECTIVEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date effectivedate;
	@Column(name = "POSTINGORDERNO")
	private String postingorderno;
	@Column(name = "ORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderdate;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Column(name = "JOINDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date joindate;
	@Column(name = "JOINANFN")
	private String joinanfn;
	@Column(name = "IS_PROMOTION_FOREGO")
	private Character isPromotionForego;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "ISLATEST")
	private String islatest;

	public ViewPpEmployeePromotion() {
	}

	public Long getPpPostingdetailid() {
		return ppPostingdetailid;
	}

	public void setPpPostingdetailid(Long ppPostingdetailid) {
		this.ppPostingdetailid = ppPostingdetailid;
	}

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public Integer getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(Integer ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public Date getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}

	public String getPostingorderno() {
		return postingorderno;
	}

	public void setPostingorderno(String postingorderno) {
		this.postingorderno = postingorderno;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getJoinanfn() {
		return joinanfn;
	}

	public void setJoinanfn(String joinanfn) {
		this.joinanfn = joinanfn;
	}

	public Character getIsPromotionForego() {
		return isPromotionForego;
	}

	public void setIsPromotionForego(Character isPromotionForego) {
		this.isPromotionForego = isPromotionForego;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getIslatest() {
		return islatest;
	}

	public void setIslatest(String islatest) {
		this.islatest = islatest;
	}

}
