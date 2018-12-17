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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "SYS_MONTH")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SysMonth.findAll", query = "SELECT s FROM SysMonth s"),
		@NamedQuery(name = "SysMonth.findByMonthid", query = "SELECT s FROM SysMonth s WHERE s.monthid = :monthid"),
		@NamedQuery(name = "SysMonth.findByMonthname", query = "SELECT s FROM SysMonth s WHERE s.monthname = :monthname") })
public class SysMonth implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "MONTHID")
	private String monthid;
	@Basic(optional = false)
	@Column(name = "MONTHNAME")
	private String monthname;

	public SysMonth() {
	}

	public SysMonth(String monthid) {
		this.monthid = monthid;
	}

	public SysMonth(String monthid, String monthname) {
		this.monthid = monthid;
		this.monthname = monthname;
	}

	public String getMonthid() {
		return monthid;
	}

	public void setMonthid(String monthid) {
		this.monthid = monthid;
	}

	public String getMonthname() {
		return monthname;
	}

	public void setMonthname(String monthname) {
		this.monthname = monthname;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (monthid != null ? monthid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SysMonth)) {
			return false;
		}
		SysMonth other = (SysMonth) object;
		if ((this.monthid == null && other.monthid != null)
				|| (this.monthid != null && !this.monthid.equals(other.monthid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SysMonth[ monthid=" + monthid + " ]";
	}

}
