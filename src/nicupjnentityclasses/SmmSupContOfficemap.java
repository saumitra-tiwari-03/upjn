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
@Table(name = "SMM_SUP_CONT_OFFICEMAP")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SmmSupContOfficemap.findAll", query = "SELECT s FROM SmmSupContOfficemap s"),
		@NamedQuery(name = "SmmSupContOfficemap.findBySmmSupContOfficemapid", query = "SELECT s FROM SmmSupContOfficemap s WHERE s.smmSupContOfficemapid = :smmSupContOfficemapid"),
		@NamedQuery(name = "SmmSupContOfficemap.findByPLedgTypecode", query = "SELECT s FROM SmmSupContOfficemap s WHERE s.pLedgTypecode = :pLedgTypecode"),
		@NamedQuery(name = "SmmSupContOfficemap.findBySuppContId", query = "SELECT s FROM SmmSupContOfficemap s WHERE s.suppContId = :suppContId"),
		@NamedQuery(name = "SmmSupContOfficemap.findByRmOfficeid", query = "SELECT s FROM SmmSupContOfficemap s WHERE s.rmOfficeid = :rmOfficeid") })
public class SmmSupContOfficemap implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "SMM_SUP_CONT_OFFICEMAPID")
	private Long smmSupContOfficemapid;
	@Basic(optional = false)
	@Column(name = "P_LEDG_TYPECODE")
	private String pLedgTypecode;
	@Basic(optional = false)
	@Column(name = "SUPP_CONT_ID")
	private long suppContId;
	@Column(name = "RM_OFFICEID")
	private Integer rmOfficeid;

	public SmmSupContOfficemap() {
	}

	public SmmSupContOfficemap(Long smmSupContOfficemapid) {
		this.smmSupContOfficemapid = smmSupContOfficemapid;
	}

	public SmmSupContOfficemap(Long smmSupContOfficemapid, String pLedgTypecode, long suppContId) {
		this.smmSupContOfficemapid = smmSupContOfficemapid;
		this.pLedgTypecode = pLedgTypecode;
		this.suppContId = suppContId;
	}

	public Long getSmmSupContOfficemapid() {
		return smmSupContOfficemapid;
	}

	public void setSmmSupContOfficemapid(Long smmSupContOfficemapid) {
		this.smmSupContOfficemapid = smmSupContOfficemapid;
	}

	public String getPLedgTypecode() {
		return pLedgTypecode;
	}

	public void setPLedgTypecode(String pLedgTypecode) {
		this.pLedgTypecode = pLedgTypecode;
	}

	public long getSuppContId() {
		return suppContId;
	}

	public void setSuppContId(long suppContId) {
		this.suppContId = suppContId;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (smmSupContOfficemapid != null ? smmSupContOfficemapid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SmmSupContOfficemap)) {
			return false;
		}
		SmmSupContOfficemap other = (SmmSupContOfficemap) object;
		if ((this.smmSupContOfficemapid == null && other.smmSupContOfficemapid != null)
				|| (this.smmSupContOfficemapid != null
						&& !this.smmSupContOfficemapid.equals(other.smmSupContOfficemapid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.SmmSupContOfficemap[ smmSupContOfficemapid=" + smmSupContOfficemapid + " ]";
	}

}
