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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_CURRENTSTATUS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpCurrentstatus.findAll", query = "SELECT p FROM PpCurrentstatus p"),
		@NamedQuery(name = "PpCurrentstatus.findByPpCurrentstatusid", query = "SELECT p FROM PpCurrentstatus p WHERE p.ppCurrentstatusid = :ppCurrentstatusid"),
		@NamedQuery(name = "PpCurrentstatus.findByPpPromotionid", query = "SELECT p FROM PpCurrentstatus p WHERE p.ppPromotionid = :ppPromotionid") })
public class PpCurrentstatus implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_CURRENTSTATUSID")
	private Long ppCurrentstatusid;
	@Column(name = "PP_PROMOTIONID")
	private Long ppPromotionid;
	@JoinColumn(name = "PP_DEPUTATIONDETAILID", referencedColumnName = "PP_DEPUTATIONDETAILID")
	@ManyToOne
	private PpDeputationdetail ppDeputationdetailid;
	@JoinColumn(name = "PP_EMPLOYEEMASTERID", referencedColumnName = "PP_EMPLOYEEMASTERID")
	@OneToOne(optional = false)
	private PpEmployeemaster ppEmployeemasterid;
	@JoinColumn(name = "PP_EXITDETAILID", referencedColumnName = "PP_EXITDETAILID")
	@ManyToOne
	private PpExitdetail ppExitdetailid;
	@JoinColumn(name = "PP_POSTINGDETAILID", referencedColumnName = "PP_POSTINGDETAILID")
	@ManyToOne(optional = false)
	private PpPostingdetail ppPostingdetailid;
	@JoinColumn(name = "PP_SUSPENSIONDETAILID", referencedColumnName = "PP_SUSPENSIONDETAILID")
	@ManyToOne
	private PpSuspensiondetail ppSuspensiondetailid;

	public PpCurrentstatus() {
	}

	public PpCurrentstatus(Long ppCurrentstatusid) {
		this.ppCurrentstatusid = ppCurrentstatusid;
	}

	public Long getPpCurrentstatusid() {
		return ppCurrentstatusid;
	}

	public void setPpCurrentstatusid(Long ppCurrentstatusid) {
		this.ppCurrentstatusid = ppCurrentstatusid;
	}

	public Long getPpPromotionid() {
		return ppPromotionid;
	}

	public void setPpPromotionid(Long ppPromotionid) {
		this.ppPromotionid = ppPromotionid;
	}

	public PpDeputationdetail getPpDeputationdetailid() {
		return ppDeputationdetailid;
	}

	public void setPpDeputationdetailid(PpDeputationdetail ppDeputationdetailid) {
		this.ppDeputationdetailid = ppDeputationdetailid;
	}

	public PpEmployeemaster getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(PpEmployeemaster ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public PpExitdetail getPpExitdetailid() {
		return ppExitdetailid;
	}

	public void setPpExitdetailid(PpExitdetail ppExitdetailid) {
		this.ppExitdetailid = ppExitdetailid;
	}

	public PpPostingdetail getPpPostingdetailid() {
		return ppPostingdetailid;
	}

	public void setPpPostingdetailid(PpPostingdetail ppPostingdetailid) {
		this.ppPostingdetailid = ppPostingdetailid;
	}

	public PpSuspensiondetail getPpSuspensiondetailid() {
		return ppSuspensiondetailid;
	}

	public void setPpSuspensiondetailid(PpSuspensiondetail ppSuspensiondetailid) {
		this.ppSuspensiondetailid = ppSuspensiondetailid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppCurrentstatusid != null ? ppCurrentstatusid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpCurrentstatus)) {
			return false;
		}
		PpCurrentstatus other = (PpCurrentstatus) object;
		if ((this.ppCurrentstatusid == null && other.ppCurrentstatusid != null)
				|| (this.ppCurrentstatusid != null && !this.ppCurrentstatusid.equals(other.ppCurrentstatusid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpCurrentstatus[ ppCurrentstatusid=" + ppCurrentstatusid + " ]";
	}

}
