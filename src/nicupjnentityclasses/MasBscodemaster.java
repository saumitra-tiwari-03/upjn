/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "MAS_BSCODEMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "MasBscodemaster.findAll", query = "SELECT m FROM MasBscodemaster m"),
		@NamedQuery(name = "MasBscodemaster.findByMasBscodemasterid", query = "SELECT m FROM MasBscodemaster m WHERE m.masBscodemasterid = :masBscodemasterid"),
		@NamedQuery(name = "MasBscodemaster.findByBsHeadName", query = "SELECT m FROM MasBscodemaster m WHERE m.bsHeadName = :bsHeadName"),
		@NamedQuery(name = "MasBscodemaster.findByBsCode", query = "SELECT m FROM MasBscodemaster m WHERE m.bsCode = :bsCode") })
public class MasBscodemaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "MAS_BSCODEMASTERID")
	private Integer masBscodemasterid;
	@Column(name = "BS_HEAD_NAME")
	private String bsHeadName;
	@Basic(optional = false)
	@Column(name = "BS_CODE")
	private String bsCode;
	@OneToMany(mappedBy = "masBscodemasterid")
	private Collection<FwaAcCodeMaster> fwaAcCodeMasterCollection;

	public MasBscodemaster() {
	}

	public MasBscodemaster(Integer masBscodemasterid) {
		this.masBscodemasterid = masBscodemasterid;
	}

	public MasBscodemaster(Integer masBscodemasterid, String bsCode) {
		this.masBscodemasterid = masBscodemasterid;
		this.bsCode = bsCode;
	}

	public Integer getMasBscodemasterid() {
		return masBscodemasterid;
	}

	public void setMasBscodemasterid(Integer masBscodemasterid) {
		this.masBscodemasterid = masBscodemasterid;
	}

	public String getBsHeadName() {
		return bsHeadName;
	}

	public void setBsHeadName(String bsHeadName) {
		this.bsHeadName = bsHeadName;
	}

	public String getBsCode() {
		return bsCode;
	}

	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
	}

	@XmlTransient
	public Collection<FwaAcCodeMaster> getFwaAcCodeMasterCollection() {
		return fwaAcCodeMasterCollection;
	}

	public void setFwaAcCodeMasterCollection(Collection<FwaAcCodeMaster> fwaAcCodeMasterCollection) {
		this.fwaAcCodeMasterCollection = fwaAcCodeMasterCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (masBscodemasterid != null ? masBscodemasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof MasBscodemaster)) {
			return false;
		}
		MasBscodemaster other = (MasBscodemaster) object;
		if ((this.masBscodemasterid == null && other.masBscodemasterid != null)
				|| (this.masBscodemasterid != null && !this.masBscodemasterid.equals(other.masBscodemasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.MasBscodemaster[ masBscodemasterid=" + masBscodemasterid + " ]";
	}

}
