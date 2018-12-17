/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;

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
@Table(name = "VIEW_SANCTIONINCREMENTLIST")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewSanctionincrementlist.findAll", query = "SELECT v FROM ViewSanctionincrementlist v"),
		@NamedQuery(name = "ViewSanctionincrementlist.findByEmpname", query = "SELECT v FROM ViewSanctionincrementlist v WHERE v.empname = :empname"),
		@NamedQuery(name = "ViewSanctionincrementlist.findByDesignation", query = "SELECT v FROM ViewSanctionincrementlist v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewSanctionincrementlist.findByNextincrementmonth", query = "SELECT v FROM ViewSanctionincrementlist v WHERE v.nextincrementmonth = :nextincrementmonth"),
		@NamedQuery(name = "ViewSanctionincrementlist.findByDefaultincrementamount", query = "SELECT v FROM ViewSanctionincrementlist v WHERE v.defaultincrementamount = :defaultincrementamount"),
		@NamedQuery(name = "ViewSanctionincrementlist.findByIncrementamount", query = "SELECT v FROM ViewSanctionincrementlist v WHERE v.incrementamount = :incrementamount"),
		@NamedQuery(name = "ViewSanctionincrementlist.findBySanction", query = "SELECT v FROM ViewSanctionincrementlist v WHERE v.sanction = :sanction"),
		@NamedQuery(name = "ViewSanctionincrementlist.findByPpEmployeemasterid", query = "SELECT v FROM ViewSanctionincrementlist v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewSanctionincrementlist.findByPpEmployeepaydetailid", query = "SELECT v FROM ViewSanctionincrementlist v WHERE v.ppEmployeepaydetailid = :ppEmployeepaydetailid"),
		@NamedQuery(name = "ViewSanctionincrementlist.findByPpIncrementdetailid", query = "SELECT v FROM ViewSanctionincrementlist v WHERE v.ppIncrementdetailid = :ppIncrementdetailid"),
		@NamedQuery(name = "ViewSanctionincrementlist.findByPpRegistermasterid", query = "SELECT v FROM ViewSanctionincrementlist v WHERE v.ppRegistermasterid = :ppRegistermasterid"),
		@NamedQuery(name = "ViewSanctionincrementlist.findByRmOfficeid", query = "SELECT v FROM ViewSanctionincrementlist v WHERE v.rmOfficeid = :rmOfficeid") })
public class ViewSanctionincrementlist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "EMPNAME")
	private String empname;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "NEXTINCREMENTMONTH")
	private String nextincrementmonth;
	@Column(name = "DEFAULTINCREMENTAMOUNT")
	private Integer defaultincrementamount;
	@Column(name = "INCREMENTAMOUNT")
	private Integer incrementamount;
	@Column(name = "SANCTION")
	private Character sanction;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
	@Column(name = "PP_EMPLOYEEPAYDETAILID")
	private Long ppEmployeepaydetailid;
	@Column(name = "PP_INCREMENTDETAILID")
	private Long ppIncrementdetailid;
	@Column(name = "PP_REGISTERMASTERID")
	private Short ppRegistermasterid;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;

	public ViewSanctionincrementlist() {
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getNextincrementmonth() {
		return nextincrementmonth;
	}

	public void setNextincrementmonth(String nextincrementmonth) {
		this.nextincrementmonth = nextincrementmonth;
	}

	public Integer getDefaultincrementamount() {
		return defaultincrementamount;
	}

	public void setDefaultincrementamount(Integer defaultincrementamount) {
		this.defaultincrementamount = defaultincrementamount;
	}

	public Integer getIncrementamount() {
		return incrementamount;
	}

	public void setIncrementamount(Integer incrementamount) {
		this.incrementamount = incrementamount;
	}

	public Character getSanction() {
		return sanction;
	}

	public void setSanction(Character sanction) {
		this.sanction = sanction;
	}

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public Long getPpEmployeepaydetailid() {
		return ppEmployeepaydetailid;
	}

	public void setPpEmployeepaydetailid(Long ppEmployeepaydetailid) {
		this.ppEmployeepaydetailid = ppEmployeepaydetailid;
	}

	public Long getPpIncrementdetailid() {
		return ppIncrementdetailid;
	}

	public void setPpIncrementdetailid(Long ppIncrementdetailid) {
		this.ppIncrementdetailid = ppIncrementdetailid;
	}

	public Short getPpRegistermasterid() {
		return ppRegistermasterid;
	}

	public void setPpRegistermasterid(Short ppRegistermasterid) {
		this.ppRegistermasterid = ppRegistermasterid;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

}
