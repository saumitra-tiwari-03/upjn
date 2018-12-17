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
import javax.persistence.Id;
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
@Table(name = "RM_LOGINROLE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "RmLoginrole.findAll", query = "SELECT r FROM RmLoginrole r"),
		@NamedQuery(name = "RmLoginrole.findByRmLoginroleid", query = "SELECT r FROM RmLoginrole r WHERE r.rmLoginroleid = :rmLoginroleid") })
public class RmLoginrole implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "RM_LOGINROLEID")
	private Integer rmLoginroleid;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@ManyToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;
	@JoinColumn(name = "RM_ROLEID", referencedColumnName = "RM_ROLEID")
	@ManyToOne(optional = false)
	private RmRole rmRoleid;

	public RmLoginrole() {
	}

	public RmLoginrole(Integer rmLoginroleid) {
		this.rmLoginroleid = rmLoginroleid;
	}

	public Integer getRmLoginroleid() {
		return rmLoginroleid;
	}

	public void setRmLoginroleid(Integer rmLoginroleid) {
		this.rmLoginroleid = rmLoginroleid;
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

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (rmLoginroleid != null ? rmLoginroleid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof RmLoginrole)) {
			return false;
		}
		RmLoginrole other = (RmLoginrole) object;
		if ((this.rmLoginroleid == null && other.rmLoginroleid != null)
				|| (this.rmLoginroleid != null && !this.rmLoginroleid.equals(other.rmLoginroleid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.RmLoginrole[ rmLoginroleid=" + rmLoginroleid + " ]";
	}

}
