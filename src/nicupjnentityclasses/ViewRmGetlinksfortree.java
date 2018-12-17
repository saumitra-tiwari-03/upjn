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
@Table(name = "VIEW_RM_GETLINKSFORTREE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewRmGetlinksfortree.findAll", query = "SELECT v FROM ViewRmGetlinksfortree v"),
		@NamedQuery(name = "ViewRmGetlinksfortree.findByMenuname", query = "SELECT v FROM ViewRmGetlinksfortree v WHERE v.menuname = :menuname"),
		@NamedQuery(name = "ViewRmGetlinksfortree.findByLinks", query = "SELECT v FROM ViewRmGetlinksfortree v WHERE v.links = :links"),
		@NamedQuery(name = "ViewRmGetlinksfortree.findByLinklevel", query = "SELECT v FROM ViewRmGetlinksfortree v WHERE v.linklevel = :linklevel"),
		@NamedQuery(name = "ViewRmGetlinksfortree.findByParentid", query = "SELECT v FROM ViewRmGetlinksfortree v WHERE v.parentid = :parentid"),
		@NamedQuery(name = "ViewRmGetlinksfortree.findByRmRoleid", query = "SELECT v FROM ViewRmGetlinksfortree v WHERE v.rmRoleid = :rmRoleid"),
		@NamedQuery(name = "ViewRmGetlinksfortree.findByRolename", query = "SELECT v FROM ViewRmGetlinksfortree v WHERE v.rolename = :rolename"),
		@NamedQuery(name = "ViewRmGetlinksfortree.findByQuerystring", query = "SELECT v FROM ViewRmGetlinksfortree v WHERE v.querystring = :querystring"),
		@NamedQuery(name = "ViewRmGetlinksfortree.findByPpEmployeemasterid", query = "SELECT v FROM ViewRmGetlinksfortree v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewRmGetlinksfortree.findBySortid", query = "SELECT v FROM ViewRmGetlinksfortree v WHERE v.sortid = :sortid") })
public class ViewRmGetlinksfortree implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "MENUNAME")
	private String menuname;
	@Column(name = "LINKS")
	private String links;
	@Column(name = "LINKLEVEL")
	private BigInteger linklevel;
	@Column(name = "PARENTID")
	private Integer parentid;
	@Column(name = "RM_ROLEID")
	private BigInteger rmRoleid;
	@Column(name = "ROLENAME")
	private String rolename;
	@Column(name = "QUERYSTRING")
	private String querystring;
	@Column(name = "PP_EMPLOYEEMASTERID")
	private Long ppEmployeemasterid;
	@Column(name = "SORTID")
	private String sortid;
	@JoinColumn(name = "RM_MENUITEMID", referencedColumnName = "RM_MENUITEMID")
	@ManyToOne
	private RmMenuitem rmMenuitemid;

	public ViewRmGetlinksfortree() {
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

	public BigInteger getRmRoleid() {
		return rmRoleid;
	}

	public void setRmRoleid(BigInteger rmRoleid) {
		this.rmRoleid = rmRoleid;
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

	public Long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(Long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public String getSortid() {
		return sortid;
	}

	public void setSortid(String sortid) {
		this.sortid = sortid;
	}

	public RmMenuitem getRmMenuitemid() {
		return rmMenuitemid;
	}

	public void setRmMenuitemid(RmMenuitem rmMenuitemid) {
		this.rmMenuitemid = rmMenuitemid;
	}

}
