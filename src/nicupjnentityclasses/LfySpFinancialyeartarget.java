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
@Table(name = "LFY_SP_FINANCIALYEARTARGET")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "LfySpFinancialyeartarget.findAll", query = "SELECT l FROM LfySpFinancialyeartarget l"),
		@NamedQuery(name = "LfySpFinancialyeartarget.findByLfySpFinancialyeartargetid", query = "SELECT l FROM LfySpFinancialyeartarget l WHERE l.lfySpFinancialyeartargetid = :lfySpFinancialyeartargetid"),
		@NamedQuery(name = "LfySpFinancialyeartarget.findBySpSchememasterid", query = "SELECT l FROM LfySpFinancialyeartarget l WHERE l.spSchememasterid = :spSchememasterid"),
		@NamedQuery(name = "LfySpFinancialyeartarget.findBySpComponentmasterid", query = "SELECT l FROM LfySpFinancialyeartarget l WHERE l.spComponentmasterid = :spComponentmasterid"),
		@NamedQuery(name = "LfySpFinancialyeartarget.findByTotalTarget", query = "SELECT l FROM LfySpFinancialyeartarget l WHERE l.totalTarget = :totalTarget"),
		@NamedQuery(name = "LfySpFinancialyeartarget.findByFinancialyeartarget", query = "SELECT l FROM LfySpFinancialyeartarget l WHERE l.financialyeartarget = :financialyeartarget"),
		@NamedQuery(name = "LfySpFinancialyeartarget.findByFinancialyear", query = "SELECT l FROM LfySpFinancialyeartarget l WHERE l.financialyear = :financialyear"),
		@NamedQuery(name = "LfySpFinancialyeartarget.findBySpFinancialyeartargetid", query = "SELECT l FROM LfySpFinancialyeartarget l WHERE l.spFinancialyeartargetid = :spFinancialyeartargetid") })
public class LfySpFinancialyeartarget implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "LFY_SP_FINANCIALYEARTARGETID")
	private Long lfySpFinancialyeartargetid;
	@Basic(optional = false)
	@Column(name = "SP_SCHEMEMASTERID")
	private long spSchememasterid;
	@Column(name = "SP_COMPONENTMASTERID")
	private Long spComponentmasterid;
	@Basic(optional = false)
	@Column(name = "TOTAL_TARGET")
	private long totalTarget;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEARTARGET")
	private long financialyeartarget;
	@Basic(optional = false)
	@Column(name = "FINANCIALYEAR")
	private String financialyear;
	@Basic(optional = false)
	@Column(name = "SP_FINANCIALYEARTARGETID")
	private long spFinancialyeartargetid;

	public LfySpFinancialyeartarget() {
	}

	public LfySpFinancialyeartarget(Long lfySpFinancialyeartargetid) {
		this.lfySpFinancialyeartargetid = lfySpFinancialyeartargetid;
	}

	public LfySpFinancialyeartarget(Long lfySpFinancialyeartargetid, long spSchememasterid, long totalTarget,
			long financialyeartarget, String financialyear, long spFinancialyeartargetid) {
		this.lfySpFinancialyeartargetid = lfySpFinancialyeartargetid;
		this.spSchememasterid = spSchememasterid;
		this.totalTarget = totalTarget;
		this.financialyeartarget = financialyeartarget;
		this.financialyear = financialyear;
		this.spFinancialyeartargetid = spFinancialyeartargetid;
	}

	public Long getLfySpFinancialyeartargetid() {
		return lfySpFinancialyeartargetid;
	}

	public void setLfySpFinancialyeartargetid(Long lfySpFinancialyeartargetid) {
		this.lfySpFinancialyeartargetid = lfySpFinancialyeartargetid;
	}

	public long getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(long spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public Long getSpComponentmasterid() {
		return spComponentmasterid;
	}

	public void setSpComponentmasterid(Long spComponentmasterid) {
		this.spComponentmasterid = spComponentmasterid;
	}

	public long getTotalTarget() {
		return totalTarget;
	}

	public void setTotalTarget(long totalTarget) {
		this.totalTarget = totalTarget;
	}

	public long getFinancialyeartarget() {
		return financialyeartarget;
	}

	public void setFinancialyeartarget(long financialyeartarget) {
		this.financialyeartarget = financialyeartarget;
	}

	public String getFinancialyear() {
		return financialyear;
	}

	public void setFinancialyear(String financialyear) {
		this.financialyear = financialyear;
	}

	public long getSpFinancialyeartargetid() {
		return spFinancialyeartargetid;
	}

	public void setSpFinancialyeartargetid(long spFinancialyeartargetid) {
		this.spFinancialyeartargetid = spFinancialyeartargetid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (lfySpFinancialyeartargetid != null ? lfySpFinancialyeartargetid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LfySpFinancialyeartarget)) {
			return false;
		}
		LfySpFinancialyeartarget other = (LfySpFinancialyeartarget) object;
		if ((this.lfySpFinancialyeartargetid == null && other.lfySpFinancialyeartargetid != null)
				|| (this.lfySpFinancialyeartargetid != null
						&& !this.lfySpFinancialyeartargetid.equals(other.lfySpFinancialyeartargetid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.LfySpFinancialyeartarget[ lfySpFinancialyeartargetid=" + lfySpFinancialyeartargetid
				+ " ]";
	}

}
