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
@Table(name = "VIEW_RM_OFFICELIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewRmOfficelist.findAll", query = "SELECT v FROM ViewRmOfficelist v"),
		@NamedQuery(name = "ViewRmOfficelist.findByOfficename", query = "SELECT v FROM ViewRmOfficelist v WHERE v.officename = :officename"),
		@NamedQuery(name = "ViewRmOfficelist.findByRmOfficeid", query = "SELECT v FROM ViewRmOfficelist v WHERE v.rmOfficeid = :rmOfficeid"),
		@NamedQuery(name = "ViewRmOfficelist.findByMasOfficelevelid", query = "SELECT v FROM ViewRmOfficelist v WHERE v.masOfficelevelid = :masOfficelevelid") })
public class ViewRmOfficelist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "OFFICENAME")
	private String officename;
	@Basic(optional = false)
	@Column(name = "RM_OFFICEID")
	private int rmOfficeid;
	@Basic(optional = false)
	@Column(name = "MAS_OFFICELEVELID")
	private short masOfficelevelid;

	public ViewRmOfficelist() {
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public int getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(int rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public short getMasOfficelevelid() {
		return masOfficelevelid;
	}

	public void setMasOfficelevelid(short masOfficelevelid) {
		this.masOfficelevelid = masOfficelevelid;
	}

}
