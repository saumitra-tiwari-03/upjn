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
@Table(name = "MAS_AC_HEAD_CONTROLLER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "MasAcHeadController.findAll", query = "SELECT m FROM MasAcHeadController m"),
		@NamedQuery(name = "MasAcHeadController.findByMasAcHeadControllerid", query = "SELECT m FROM MasAcHeadController m WHERE m.masAcHeadControllerid = :masAcHeadControllerid"),
		@NamedQuery(name = "MasAcHeadController.findByFieldName", query = "SELECT m FROM MasAcHeadController m WHERE m.fieldName = :fieldName"),
		@NamedQuery(name = "MasAcHeadController.findByShortName", query = "SELECT m FROM MasAcHeadController m WHERE m.shortName = :shortName"),
		@NamedQuery(name = "MasAcHeadController.findByTranFlag", query = "SELECT m FROM MasAcHeadController m WHERE m.tranFlag = :tranFlag"),
		@NamedQuery(name = "MasAcHeadController.findBySortOrder", query = "SELECT m FROM MasAcHeadController m WHERE m.sortOrder = :sortOrder") })
public class MasAcHeadController implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "MAS_AC_HEAD_CONTROLLERID")
	private Short masAcHeadControllerid;
	@Basic(optional = false)
	@Column(name = "FIELD_NAME")
	private String fieldName;
	@Column(name = "SHORT_NAME")
	private String shortName;
	@Column(name = "TRAN_FLAG")
	private Character tranFlag;
	@Column(name = "SORT_ORDER")
	private Short sortOrder;
	@JoinColumn(name = "AC_CODE", referencedColumnName = "FWA_AC_CODE_MASTERID")
	@ManyToOne
	private FwaAcCodeMaster acCode;

	public MasAcHeadController() {
	}

	public MasAcHeadController(Short masAcHeadControllerid) {
		this.masAcHeadControllerid = masAcHeadControllerid;
	}

	public MasAcHeadController(Short masAcHeadControllerid, String fieldName) {
		this.masAcHeadControllerid = masAcHeadControllerid;
		this.fieldName = fieldName;
	}

	public Short getMasAcHeadControllerid() {
		return masAcHeadControllerid;
	}

	public void setMasAcHeadControllerid(Short masAcHeadControllerid) {
		this.masAcHeadControllerid = masAcHeadControllerid;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Character getTranFlag() {
		return tranFlag;
	}

	public void setTranFlag(Character tranFlag) {
		this.tranFlag = tranFlag;
	}

	public Short getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Short sortOrder) {
		this.sortOrder = sortOrder;
	}

	public FwaAcCodeMaster getAcCode() {
		return acCode;
	}

	public void setAcCode(FwaAcCodeMaster acCode) {
		this.acCode = acCode;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (masAcHeadControllerid != null ? masAcHeadControllerid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof MasAcHeadController)) {
			return false;
		}
		MasAcHeadController other = (MasAcHeadController) object;
		if ((this.masAcHeadControllerid == null && other.masAcHeadControllerid != null)
				|| (this.masAcHeadControllerid != null
						&& !this.masAcHeadControllerid.equals(other.masAcHeadControllerid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.MasAcHeadController[ masAcHeadControllerid=" + masAcHeadControllerid + " ]";
	}

}
