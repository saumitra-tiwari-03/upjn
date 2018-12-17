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
@Table(name = "SYS_PROJECTCONSTANT")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SysProjectconstant.findAll", query = "SELECT s FROM SysProjectconstant s"),
		@NamedQuery(name = "SysProjectconstant.findByKey", query = "SELECT s FROM SysProjectconstant s WHERE s.key = :key"),
		@NamedQuery(name = "SysProjectconstant.findByValue", query = "SELECT s FROM SysProjectconstant s WHERE s.value = :value"),
		@NamedQuery(name = "SysProjectconstant.findByRemark", query = "SELECT s FROM SysProjectconstant s WHERE s.remark = :remark") })
public class SysProjectconstant implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "KEY")
	private String key;
	@Basic(optional = false)
	@Column(name = "VALUE")
	private String value;
	@Column(name = "REMARK")
	private String remark;

	public SysProjectconstant() {
	}

	public SysProjectconstant(String key) {
		this.key = key;
	}

	public SysProjectconstant(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (key != null ? key.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SysProjectconstant)) {
			return false;
		}
		SysProjectconstant other = (SysProjectconstant) object;
		if ((this.key == null && other.key != null) || (this.key != null && !this.key.equals(other.key))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SysProjectconstant[ key=" + key + " ]";
	}

}
