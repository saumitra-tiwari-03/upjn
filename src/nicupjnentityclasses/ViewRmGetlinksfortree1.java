/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigInteger;

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
@Table(name = "VIEW_RM_GETLINKSFORTREE1")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewRmGetlinksfortree1.findAll", query = "SELECT v FROM ViewRmGetlinksfortree1 v"),
		@NamedQuery(name = "ViewRmGetlinksfortree1.findByRmMenuitemid", query = "SELECT v FROM ViewRmGetlinksfortree1 v WHERE v.rmMenuitemid = :rmMenuitemid"),
		@NamedQuery(name = "ViewRmGetlinksfortree1.findByMenuname", query = "SELECT v FROM ViewRmGetlinksfortree1 v WHERE v.menuname = :menuname"),
		@NamedQuery(name = "ViewRmGetlinksfortree1.findByLinks", query = "SELECT v FROM ViewRmGetlinksfortree1 v WHERE v.links = :links"),
		@NamedQuery(name = "ViewRmGetlinksfortree1.findByLinklevel", query = "SELECT v FROM ViewRmGetlinksfortree1 v WHERE v.linklevel = :linklevel"),
		@NamedQuery(name = "ViewRmGetlinksfortree1.findByParentid", query = "SELECT v FROM ViewRmGetlinksfortree1 v WHERE v.parentid = :parentid"),
		@NamedQuery(name = "ViewRmGetlinksfortree1.findByRolename", query = "SELECT v FROM ViewRmGetlinksfortree1 v WHERE v.rolename = :rolename"),
		@NamedQuery(name = "ViewRmGetlinksfortree1.findByQuerystring", query = "SELECT v FROM ViewRmGetlinksfortree1 v WHERE v.querystring = :querystring") })
public class ViewRmGetlinksfortree1 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "RM_MENUITEMID")
	private Integer rmMenuitemid;
	@Column(name = "MENUNAME")
	private String menuname;
	@Column(name = "LINKS")
	private String links;
	@Column(name = "LINKLEVEL")
	private BigInteger linklevel;
	@Column(name = "PARENTID")
	private Integer parentid;
	@Column(name = "ROLENAME")
	private String rolename;
	@Column(name = "QUERYSTRING")
	private String querystring;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne
	private PpEmployeemaster ppEmployeemasterid;
	@JoinColumn(name = "RM_ROLEID", referencedColumnName = "RM_ROLEID")
	@ManyToOne
	private RmRole rmRoleid;

	public ViewRmGetlinksfortree1() {
	}

	public Integer getRmMenuitemid() {
		return rmMenuitemid;
	}

	public void setRmMenuitemid(Integer rmMenuitemid) {
		this.rmMenuitemid = rmMenuitemid;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public BigInteger getLinklevel() {
		return linklevel;
	}

	public void setLinklevel(BigInteger linklevel) {
		this.linklevel = linklevel;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getQuerystring() {
		return querystring;
	}

	public void setQuerystring(String querystring) {
		this.querystring = querystring;
	}

	public PpEmployeemaster getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(PpEmployeemaster ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public RmRole getRmRoleid() {
		return rmRoleid;
	}

	public void setRmRoleid(RmRole rmRoleid) {
		this.rmRoleid = rmRoleid;
	}

}
