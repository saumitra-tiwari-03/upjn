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
@Table(name = "MONTH")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Month.findAll", query = "SELECT m FROM Month m"),
		@NamedQuery(name = "Month.findByMonthid", query = "SELECT m FROM Month m WHERE m.monthid = :monthid"),
		@NamedQuery(name = "Month.findByMonthname", query = "SELECT m FROM Month m WHERE m.monthname = :monthname") })
public class Month implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "MONTHID")
	private String monthid;
	@Basic(optional = false)
	@Column(name = "MONTHNAME")
	private String monthname;

	public Month() {
	}

	public Month(String monthid) {
		this.monthid = monthid;
	}

	public Month(String monthid, String monthname) {
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
		if (!(object instanceof Month)) {
			return false;
		}
		Month other = (Month) object;
		if ((this.monthid == null && other.monthid != null)
				|| (this.monthid != null && !this.monthid.equals(other.monthid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.Month[ monthid=" + monthid + " ]";
	}

}
