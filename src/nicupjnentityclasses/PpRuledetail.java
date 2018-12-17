/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "PP_RULEDETAIL")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "PpRuledetail.findAll", query = "SELECT p FROM PpRuledetail p"),
		@NamedQuery(name = "PpRuledetail.findByPpRuledetailid", query = "SELECT p FROM PpRuledetail p WHERE p.ppRuledetailid = :ppRuledetailid"),
		@NamedQuery(name = "PpRuledetail.findByRangefrom", query = "SELECT p FROM PpRuledetail p WHERE p.rangefrom = :rangefrom"),
		@NamedQuery(name = "PpRuledetail.findByRangeto", query = "SELECT p FROM PpRuledetail p WHERE p.rangeto = :rangeto"),
		@NamedQuery(name = "PpRuledetail.findByPpEmploymentsubtypeid", query = "SELECT p FROM PpRuledetail p WHERE p.ppEmploymentsubtypeid = :ppEmploymentsubtypeid"),
		@NamedQuery(name = "PpRuledetail.findByPpTowncategorymasterid", query = "SELECT p FROM PpRuledetail p WHERE p.ppTowncategorymasterid = :ppTowncategorymasterid"),
		@NamedQuery(name = "PpRuledetail.findByPercentvalue", query = "SELECT p FROM PpRuledetail p WHERE p.percentvalue = :percentvalue"),
		@NamedQuery(name = "PpRuledetail.findByFlatamount", query = "SELECT p FROM PpRuledetail p WHERE p.flatamount = :flatamount"),
		@NamedQuery(name = "PpRuledetail.findByMaxlimit", query = "SELECT p FROM PpRuledetail p WHERE p.maxlimit = :maxlimit"),
		@NamedQuery(name = "PpRuledetail.findByMinlimit", query = "SELECT p FROM PpRuledetail p WHERE p.minlimit = :minlimit") })
public class PpRuledetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_RULEDETAILID")
	private Integer ppRuledetailid;
	@Column(name = "RANGEFROM")
	private Integer rangefrom;
	@Column(name = "RANGETO")
	private Integer rangeto;
	@Column(name = "PP_EMPLOYMENTSUBTYPEID")
	private Integer ppEmploymentsubtypeid;
	@Column(name = "PP_TOWNCATEGORYMASTERID")
	private Integer ppTowncategorymasterid;

	@Column(name = "PERCENTVALUE")
	private BigDecimal percentvalue;
	@Column(name = "FLATAMOUNT")
	private Integer flatamount;
	@Column(name = "MAXLIMIT")
	private Integer maxlimit;
	@Column(name = "MINLIMIT")
	private Integer minlimit;
	@JoinColumn(name = "PP_RULEMASTERID", referencedColumnName = "PP_RULEMASTERID")
	@ManyToOne(optional = false)
	private PpRulemaster ppRulemasterid;

	public PpRuledetail() {
	}

	public PpRuledetail(Integer ppRuledetailid) {
		this.ppRuledetailid = ppRuledetailid;
	}

	public Integer getPpRuledetailid() {
		return ppRuledetailid;
	}

	public void setPpRuledetailid(Integer ppRuledetailid) {
		this.ppRuledetailid = ppRuledetailid;
	}

	public Integer getRangefrom() {
		return rangefrom;
	}

	public void setRangefrom(Integer rangefrom) {
		this.rangefrom = rangefrom;
	}

	public Integer getRangeto() {
		return rangeto;
	}

	public void setRangeto(Integer rangeto) {
		this.rangeto = rangeto;
	}

	public Integer getPpEmploymentsubtypeid() {
		return ppEmploymentsubtypeid;
	}

	public void setPpEmploymentsubtypeid(Integer ppEmploymentsubtypeid) {
		this.ppEmploymentsubtypeid = ppEmploymentsubtypeid;
	}

	public Integer getPpTowncategorymasterid() {
		return ppTowncategorymasterid;
	}

	public void setPpTowncategorymasterid(Integer ppTowncategorymasterid) {
		this.ppTowncategorymasterid = ppTowncategorymasterid;
	}

	public BigDecimal getPercentvalue() {
		return percentvalue;
	}

	public void setPercentvalue(BigDecimal percentvalue) {
		this.percentvalue = percentvalue;
	}

	public Integer getFlatamount() {
		return flatamount;
	}

	public void setFlatamount(Integer flatamount) {
		this.flatamount = flatamount;
	}

	public Integer getMaxlimit() {
		return maxlimit;
	}

	public void setMaxlimit(Integer maxlimit) {
		this.maxlimit = maxlimit;
	}

	public Integer getMinlimit() {
		return minlimit;
	}

	public void setMinlimit(Integer minlimit) {
		this.minlimit = minlimit;
	}

	public PpRulemaster getPpRulemasterid() {
		return ppRulemasterid;
	}

	public void setPpRulemasterid(PpRulemaster ppRulemasterid) {
		this.ppRulemasterid = ppRulemasterid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppRuledetailid != null ? ppRuledetailid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpRuledetail)) {
			return false;
		}
		PpRuledetail other = (PpRuledetail) object;
		if ((this.ppRuledetailid == null && other.ppRuledetailid != null)
				|| (this.ppRuledetailid != null && !this.ppRuledetailid
						.equals(other.ppRuledetailid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpRuledetail[ ppRuledetailid="
				+ ppRuledetailid + " ]";
	}

}
