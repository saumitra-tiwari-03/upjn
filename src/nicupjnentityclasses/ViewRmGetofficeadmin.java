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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_RM_GETOFFICEADMIN")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewRmGetofficeadmin.findAll", query = "SELECT v FROM ViewRmGetofficeadmin v"),
		@NamedQuery(name = "ViewRmGetofficeadmin.findByRmRoleid", query = "SELECT v FROM ViewRmGetofficeadmin v WHERE v.rmRoleid = :rmRoleid"),
		@NamedQuery(name = "ViewRmGetofficeadmin.findByOfficename", query = "SELECT v FROM ViewRmGetofficeadmin v WHERE v.officename = :officename"),
		@NamedQuery(name = "ViewRmGetofficeadmin.findByOfficelevel", query = "SELECT v FROM ViewRmGetofficeadmin v WHERE v.officelevel = :officelevel") })
public class ViewRmGetofficeadmin implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "RM_ROLEID")
	private int rmRoleid;
	@Basic(optional = false)
	@Column(name = "OFFICENAME")
	private String officename;
	@Basic(optional = false)
	@Column(name = "OFFICELEVEL")
	private String officelevel;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;

	public ViewRmGetofficeadmin() {
	}

	public int getRmRoleid() {
		return rmRoleid;
	}

	public void setRmRoleid(int rmRoleid) {
		this.rmRoleid = rmRoleid;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public String getOfficelevel() {
		return officelevel;
	}

	public void setOfficelevel(String officelevel) {
		this.officelevel = officelevel;
	}

	public PpEmployeemaster getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(PpEmployeemaster ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

}
