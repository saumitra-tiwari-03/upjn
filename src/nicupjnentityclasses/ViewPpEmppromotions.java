/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
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
@Table(name = "VIEW_PP_EMPPROMOTIONS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpEmppromotions.findAll", query = "SELECT v FROM ViewPpEmppromotions v"),
		@NamedQuery(name = "ViewPpEmppromotions.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpEmppromotions v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpEmppromotions.findByEmployeename", query = "SELECT v FROM ViewPpEmppromotions v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewPpEmppromotions.findByPreviousdesignation", query = "SELECT v FROM ViewPpEmppromotions v WHERE v.previousdesignation = :previousdesignation"),
		@NamedQuery(name = "ViewPpEmppromotions.findByNextdesignation", query = "SELECT v FROM ViewPpEmppromotions v WHERE v.nextdesignation = :nextdesignation"),
		@NamedQuery(name = "ViewPpEmppromotions.findByPpPostingdetailid", query = "SELECT v FROM ViewPpEmppromotions v WHERE v.ppPostingdetailid = :ppPostingdetailid"),
		@NamedQuery(name = "ViewPpEmppromotions.findByPostingorderno", query = "SELECT v FROM ViewPpEmppromotions v WHERE v.postingorderno = :postingorderno"),
		@NamedQuery(name = "ViewPpEmppromotions.findByOrderdate", query = "SELECT v FROM ViewPpEmppromotions v WHERE v.orderdate = :orderdate") })
public class ViewPpEmppromotions implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "PREVIOUSDESIGNATION")
	private String previousdesignation;
	@Column(name = "NEXTDESIGNATION")
	private String nextdesignation;
	@Column(name = "PP_POSTINGDETAILID")
	private Long ppPostingdetailid;
	@Column(name = "POSTINGORDERNO")
	private String postingorderno;
	@Column(name = "ORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderdate;

	public ViewPpEmppromotions() {
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getPreviousdesignation() {
		return previousdesignation;
	}

	public void setPreviousdesignation(String previousdesignation) {
		this.previousdesignation = previousdesignation;
	}

	public String getNextdesignation() {
		return nextdesignation;
	}

	public void setNextdesignation(String nextdesignation) {
		this.nextdesignation = nextdesignation;
	}

	public Long getPpPostingdetailid() {
		return ppPostingdetailid;
	}

	public void setPpPostingdetailid(Long ppPostingdetailid) {
		this.ppPostingdetailid = ppPostingdetailid;
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

}
