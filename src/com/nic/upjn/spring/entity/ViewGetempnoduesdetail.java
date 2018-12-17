/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "VIEW_GETEMPNODUESDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewGetempnoduesdetail.findAll", query = "SELECT v FROM ViewGetempnoduesdetail v"),
	            @NamedQuery(name = "ViewGetempnoduesdetail.findByPpNoduesdetailid", query = "SELECT v FROM ViewGetempnoduesdetail v WHERE v.ppNoduesdetailid = :ppNoduesdetailid"),
                @NamedQuery(name = "ViewGetempnoduesdetail.findByPpEmployeemasterid", query = "FROM ViewGetempnoduesdetail WHERE ppEmployeemasterid = ?"),
		        @NamedQuery(name = "ViewGetempnoduesdetail.findByNoduesordno", query = "SELECT v FROM ViewGetempnoduesdetail v WHERE v.noduesordno = :noduesordno"),
		        @NamedQuery(name = "ViewGetempnoduesdetail.findByNoduesorddate", query = "SELECT v FROM ViewGetempnoduesdetail v WHERE v.noduesorddate = :noduesorddate") })
public class ViewGetempnoduesdetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_NODUESDETAILID")
	private Long ppNoduesdetailid;
	@Basic(optional = false)
	@Column(name = "NODUESORDNO")
	private String noduesordno;
	@Basic(optional = false)
	@Column(name = "NODUESORDDATE")
	/*@Temporal(TemporalType.TIMESTAMP)*/
	private Date noduesorddate;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;

	public ViewGetempnoduesdetail() {
	}

	public ViewGetempnoduesdetail(Long ppNoduesdetailid) {
		this.ppNoduesdetailid = ppNoduesdetailid;
	}

	public ViewGetempnoduesdetail(Long ppNoduesdetailid, String noduesordno, Date noduesorddate) {
		this.ppNoduesdetailid = ppNoduesdetailid;
		this.noduesordno = noduesordno;
		this.noduesorddate = noduesorddate;
	}

	public Long getPpNoduesdetailid() {
		return ppNoduesdetailid;
	}

	public void setPpNoduesdetailid(Long ppNoduesdetailid) {
		this.ppNoduesdetailid = ppNoduesdetailid;
	}

	public String getNoduesordno() {
		return noduesordno;
	}

	public void setNoduesordno(String noduesordno) {
		this.noduesordno = noduesordno;
	}

	public Date getNoduesorddate() {
		return noduesorddate;
	}

	public void setNoduesorddate(Date noduesorddate) {
		this.noduesorddate = noduesorddate;
	}

	public PpEmployeemaster getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(PpEmployeemaster ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppNoduesdetailid != null ? ppNoduesdetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ViewGetempnoduesdetail)) {
			return false;
		}
		ViewGetempnoduesdetail other = (ViewGetempnoduesdetail) object;
		if ((this.ppNoduesdetailid == null && other.ppNoduesdetailid != null)
				|| (this.ppNoduesdetailid != null && !this.ppNoduesdetailid.equals(other.ppNoduesdetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.ViewGetempnoduesdetail[ ppNoduesdetailid=" + ppNoduesdetailid + " ]";
	}

}
