/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;

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
@Table(name = "VIEW_PP_GETEMPLOYEESUBTYPE")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewPpGetemployeesubtype.findAll", query = "SELECT v FROM ViewPpGetemployeesubtype v"),
		@NamedQuery(name = "ViewPpGetemployeesubtype.findByPpDesignationmasterid", query = "SELECT v FROM ViewPpGetemployeesubtype v WHERE v.ppDesignationmasterid = :ppDesignationmasterid"),
		@NamedQuery(name = "ViewPpGetemployeesubtype.findByMasEmploymentsubtypeid", query = "SELECT v FROM ViewPpGetemployeesubtype v WHERE v.masEmploymentsubtypeid = :masEmploymentsubtypeid"),
		@NamedQuery(name = "ViewPpGetemployeesubtype.findByEmploymentsubtype", query = "SELECT v FROM ViewPpGetemployeesubtype v WHERE v.employmentsubtype = :employmentsubtype") })
public class ViewPpGetemployeesubtype implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "PP_DESIGNATIONMASTERID")
	private Integer ppDesignationmasterid;
	@Column(name = "MAS_EMPLOYMENTSUBTYPEID")
	private Integer masEmploymentsubtypeid;
	@Basic(optional = false)
	@Column(name = "EMPLOYMENTSUBTYPE")
	private String employmentsubtype;

	public ViewPpGetemployeesubtype() {
	}

	public Integer getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(Integer ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public Integer getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(Integer masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public String getEmploymentsubtype() {
		return employmentsubtype;
	}

	public void setEmploymentsubtype(String employmentsubtype) {
		this.employmentsubtype = employmentsubtype;
	}

}
