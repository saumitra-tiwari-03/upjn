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
@Table(name = "VIEW_PSN_LIFECERTIFICATELIST")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewPsnLifecertificatelist.findAll", query = "SELECT v FROM ViewPsnLifecertificatelist v"),
		@NamedQuery(name = "ViewPsnLifecertificatelist.findByPsnPensiondetailid", query = "SELECT v FROM ViewPsnLifecertificatelist v WHERE v.psnPensiondetailid = :psnPensiondetailid"),
		@NamedQuery(name = "ViewPsnLifecertificatelist.findByDateofeffect", query = "SELECT v FROM ViewPsnLifecertificatelist v WHERE v.dateofeffect = :dateofeffect"),
		@NamedQuery(name = "ViewPsnLifecertificatelist.findByPpono", query = "SELECT v FROM ViewPsnLifecertificatelist v WHERE v.ppono = :ppono"),
		@NamedQuery(name = "ViewPsnLifecertificatelist.findByRmOfficeid", query = "SELECT v FROM ViewPsnLifecertificatelist v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewPsnLifecertificatelist.findByPsnEmployeepensionMasterid", query = "SELECT v FROM ViewPsnLifecertificatelist v WHERE v.psnEmployeepensionMasterid = :psnEmployeepensionMasterid"),
		@NamedQuery(name = "ViewPsnLifecertificatelist.findByPensionername", query = "SELECT v FROM ViewPsnLifecertificatelist v WHERE v.pensionername = :pensionername"),
		@NamedQuery(name = "ViewPsnLifecertificatelist.findByPensionerfathername", query = "SELECT v FROM ViewPsnLifecertificatelist v WHERE v.pensionerfathername = :pensionerfathername") })
public class ViewPsnLifecertificatelist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PSN_PENSIONDETAILID")
	private long psnPensiondetailid;
	@Column(name = "DATEOFEFFECT")
	private String dateofeffect;
	@Column(name = "PPONO")
	private String ppono;
	@Column(name = "RM_OFFICEID")
	private BigInteger rmOfficeid;
	@Basic(optional = false)
	@Column(name = "PSN_EMPLOYEEPENSION_MASTERID")
	private long psnEmployeepensionMasterid;
	@Column(name = "PENSIONERNAME")
	private String pensionername;
	@Column(name = "PENSIONERFATHERNAME")
	private String pensionerfathername;

	public ViewPsnLifecertificatelist() {
	}

	public long getPsnPensiondetailid() {
		return psnPensiondetailid;
	}

	public void setPsnPensiondetailid(long psnPensiondetailid) {
		this.psnPensiondetailid = psnPensiondetailid;
	}

	public String getDateofeffect() {
		return dateofeffect;
	}

	public void setDateofeffect(String dateofeffect) {
		this.dateofeffect = dateofeffect;
	}

	public String getPpono() {
		return ppono;
	}

	public void setPpono(String ppono) {
		this.ppono = ppono;
	}

	public BigInteger getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(BigInteger rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public long getPsnEmployeepensionMasterid() {
		return psnEmployeepensionMasterid;
	}

	public void setPsnEmployeepensionMasterid(long psnEmployeepensionMasterid) {
		this.psnEmployeepensionMasterid = psnEmployeepensionMasterid;
	}

	public String getPensionername() {
		return pensionername;
	}

	public void setPensionername(String pensionername) {
		this.pensionername = pensionername;
	}

	public String getPensionerfathername() {
		return pensionerfathername;
	}

	public void setPensionerfathername(String pensionerfathername) {
		this.pensionerfathername = pensionerfathername;
	}

}
