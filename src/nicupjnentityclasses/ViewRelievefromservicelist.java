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
@Table(name = "VIEW_RELIEVEFROMSERVICELIST")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewRelievefromservicelist.findAll", query = "SELECT v FROM ViewRelievefromservicelist v"),
		@NamedQuery(name = "ViewRelievefromservicelist.findByPpEmployeemasterid", query = "SELECT v FROM ViewRelievefromservicelist v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewRelievefromservicelist.findByEmployeecode", query = "SELECT v FROM ViewRelievefromservicelist v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewRelievefromservicelist.findByEmployeename", query = "SELECT v FROM ViewRelievefromservicelist v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewRelievefromservicelist.findByRmOfficeid", query = "SELECT v FROM ViewRelievefromservicelist v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewRelievefromservicelist.findByDesignation", query = "SELECT v FROM ViewRelievefromservicelist v WHERE v.designation = :designation"),
		@NamedQuery(name = "ViewRelievefromservicelist.findByPpRelievefromserviceid", query = "SELECT v FROM ViewRelievefromservicelist v WHERE v.ppRelievefromserviceid = :ppRelievefromserviceid"),
		@NamedQuery(name = "ViewRelievefromservicelist.findBySubphasename", query = "SELECT v FROM ViewRelievefromservicelist v WHERE v.subphasename = :subphasename"),
		@NamedQuery(name = "ViewRelievefromservicelist.findByCauseofrelieveid", query = "SELECT v FROM ViewRelievefromservicelist v WHERE v.causeofrelieveid = :causeofrelieveid"),
		@NamedQuery(name = "ViewRelievefromservicelist.findByRelieveordno", query = "SELECT v FROM ViewRelievefromservicelist v WHERE v.relieveordno = :relieveordno"),
		@NamedQuery(name = "ViewRelievefromservicelist.findByRelieveorddate", query = "SELECT v FROM ViewRelievefromservicelist v WHERE v.relieveorddate = :relieveorddate"),
		@NamedQuery(name = "ViewRelievefromservicelist.findByDateofeffect", query = "SELECT v FROM ViewRelievefromservicelist v WHERE v.dateofeffect = :dateofeffect"),
		@NamedQuery(name = "ViewRelievefromservicelist.findByRelieveanfn", query = "SELECT v FROM ViewRelievefromservicelist v WHERE v.relieveanfn = :relieveanfn"),
		@NamedQuery(name = "ViewRelievefromservicelist.findByPpNoduesdetailid", query = "SELECT v FROM ViewRelievefromservicelist v WHERE v.ppNoduesdetailid = :ppNoduesdetailid"),
		@NamedQuery(name = "ViewRelievefromservicelist.findByRelievingofficeid", query = "SELECT v FROM ViewRelievefromservicelist v WHERE v.relievingofficeid = :relievingofficeid") })
public class ViewRelievefromservicelist implements Serializable {
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
	@Column(name = "PP_RELIEVEFROMSERVICEID")
	private long ppRelievefromserviceid;
	@Basic(optional = false)
	@Column(name = "SUBPHASENAME")
	private String subphasename;
	@Basic(optional = false)
	@Column(name = "CAUSEOFRELIEVEID")
	private short causeofrelieveid;
	@Column(name = "RELIEVEORDNO")
	private String relieveordno;
	@Column(name = "RELIEVEORDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date relieveorddate;
	@Basic(optional = false)
	@Column(name = "DATEOFEFFECT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofeffect;
	@Column(name = "RELIEVEANFN")
	private String relieveanfn;
	@Column(name = "PP_NODUESDETAILID")
	private Long ppNoduesdetailid;
	@Basic(optional = false)
	@Column(name = "RELIEVINGOFFICEID")
	private int relievingofficeid;

	public ViewRelievefromservicelist() {
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

	public long getPpRelievefromserviceid() {
		return ppRelievefromserviceid;
	}

	public void setPpRelievefromserviceid(long ppRelievefromserviceid) {
		this.ppRelievefromserviceid = ppRelievefromserviceid;
	}

	public String getSubphasename() {
		return subphasename;
	}

	public void setSubphasename(String subphasename) {
		this.subphasename = subphasename;
	}

	public short getCauseofrelieveid() {
		return causeofrelieveid;
	}

	public void setCauseofrelieveid(short causeofrelieveid) {
		this.causeofrelieveid = causeofrelieveid;
	}

	public String getRelieveordno() {
		return relieveordno;
	}

	public void setRelieveordno(String relieveordno) {
		this.relieveordno = relieveordno;
	}

	public Date getRelieveorddate() {
		return relieveorddate;
	}

	public void setRelieveorddate(Date relieveorddate) {
		this.relieveorddate = relieveorddate;
	}

	public Date getDateofeffect() {
		return dateofeffect;
	}

	public void setDateofeffect(Date dateofeffect) {
		this.dateofeffect = dateofeffect;
	}

	public String getRelieveanfn() {
		return relieveanfn;
	}

	public void setRelieveanfn(String relieveanfn) {
		this.relieveanfn = relieveanfn;
	}

	public Long getPpNoduesdetailid() {
		return ppNoduesdetailid;
	}

	public void setPpNoduesdetailid(Long ppNoduesdetailid) {
		this.ppNoduesdetailid = ppNoduesdetailid;
	}

	public int getRelievingofficeid() {
		return relievingofficeid;
	}

	public void setRelievingofficeid(int relievingofficeid) {
		this.relievingofficeid = relievingofficeid;
	}

}
