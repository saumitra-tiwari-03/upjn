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
@Table(name = "VIEW_NODUESLIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewNodueslist.findAll", query = "SELECT v FROM ViewNodueslist v"),
		@NamedQuery(name = "ViewNodueslist.findByPpEmployeemasterid", query = "SELECT v FROM ViewNodueslist v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewNodueslist.findByEmployeecode", query = "SELECT v FROM ViewNodueslist v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewNodueslist.findByEmployeename", query = "SELECT v FROM ViewNodueslist v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewNodueslist.findByRmOfficeid", query = "SELECT v FROM ViewNodueslist v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewNodueslist.findByDesignation", query = "SELECT v FROM ViewNodueslist v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewNodueslist.findByPpNoduesdetailid", query = "SELECT v FROM ViewNodueslist v WHERE v.ppNoduesdetailid = :ppNoduesdetailid"),
		@NamedQuery(name = "ViewNodueslist.findByNoduesordno", query = "SELECT v FROM ViewNodueslist v WHERE v.noduesordno = :noduesordno"),
		@NamedQuery(name = "ViewNodueslist.findByNoduesorddate", query = "SELECT v FROM ViewNodueslist v WHERE v.noduesorddate = :noduesorddate"),
		@NamedQuery(name = "ViewNodueslist.findByIson", query = "SELECT v FROM ViewNodueslist v WHERE v.ison = :ison") })
public class ViewNodueslist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;
	@Column(name = "DESIGNATION")
	private String designation;
	@Basic(optional = false)
	@Column(name = "PP_NODUESDETAILID")
	private long ppNoduesdetailid;
	@Basic(optional = false)
	@Column(name = "NODUESORDNO")
	private String noduesordno;
	@Basic(optional = false)
	@Column(name = "NODUESORDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date noduesorddate;
	@Basic(optional = false)
	@Column(name = "ISON")
	private Character ison;

	public ViewNodueslist() {
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getPpNoduesdetailid() {
		return ppNoduesdetailid;
	}

	public void setPpNoduesdetailid(long ppNoduesdetailid) {
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

	public Character getIson() {
		return ison;
	}

	public void setIson(Character ison) {
		this.ison = ison;
	}

}
