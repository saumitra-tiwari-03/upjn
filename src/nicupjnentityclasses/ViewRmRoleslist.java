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
@Table(name = "VIEW_RM_ROLESLIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewRmRoleslist.findAll", query = "SELECT v FROM ViewRmRoleslist v"),
		@NamedQuery(name = "ViewRmRoleslist.findByRmRoleid", query = "SELECT v FROM ViewRmRoleslist v WHERE v.rmRoleid = :rmRoleid"),
		@NamedQuery(name = "ViewRmRoleslist.findByRolename", query = "SELECT v FROM ViewRmRoleslist v WHERE v.rolename = :rolename"),
		@NamedQuery(name = "ViewRmRoleslist.findByRmOfficeid", query = "SELECT v FROM ViewRmRoleslist v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewRmRoleslist.findByOfficename", query = "SELECT v FROM ViewRmRoleslist v WHERE v.officename = :officename") })
public class ViewRmRoleslist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "RM_ROLEID")
	private int rmRoleid;
	@Column(name = "ROLENAME")
	private String rolename;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Basic(optional = false)
	@Column(name = "OFFICENAME")
	private String officename;

	public ViewRmRoleslist() {
	}

	public int getRmRoleid() {
		return rmRoleid;
	}

	public void setRmRoleid(int rmRoleid) {
		this.rmRoleid = rmRoleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

}
