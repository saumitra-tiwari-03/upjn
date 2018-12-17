/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_PP_DEDUCTION")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpDeduction.findAll", query = "SELECT v FROM ViewPpDeduction v"),
		@NamedQuery(name = "ViewPpDeduction.findByMasEmploymenttypeid", query = "SELECT v FROM ViewPpDeduction v WHERE v.masEmploymenttypeid = :masEmploymenttypeid"),
		@NamedQuery(name = "ViewPpDeduction.findByEmploymenttype", query = "SELECT v FROM ViewPpDeduction v WHERE v.employmenttype = :employmenttype"),
		@NamedQuery(name = "ViewPpDeduction.findByMasEmploymentsubtypeid", query = "SELECT v FROM ViewPpDeduction v WHERE v.masEmploymentsubtypeid = :masEmploymentsubtypeid"),
		@NamedQuery(name = "ViewPpDeduction.findByPpDeductionmasterid", query = "SELECT v FROM ViewPpDeduction v WHERE v.ppDeductionmasterid = :ppDeductionmasterid"),
		@NamedQuery(name = "ViewPpDeduction.findByDeductionname", query = "SELECT v FROM ViewPpDeduction v WHERE v.deductionname = :deductionname"),
		@NamedQuery(name = "ViewPpDeduction.findByDedshortname", query = "SELECT v FROM ViewPpDeduction v WHERE v.dedshortname = :dedshortname"),
		@NamedQuery(name = "ViewPpDeduction.findByDefaultvalue", query = "SELECT v FROM ViewPpDeduction v WHERE v.defaultvalue = :defaultvalue"),
		@NamedQuery(name = "ViewPpDeduction.findByPpDedRulesdetailid", query = "SELECT v FROM ViewPpDeduction v WHERE v.ppDedRulesdetailid = :ppDedRulesdetailid") })
public class ViewPpDeduction implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "MAS_EMPLOYMENTTYPEID")
	private Integer masEmploymenttypeid;
	@Column(name = "EMPLOYMENTTYPE")
	private String employmenttype;
	@Column(name = "MAS_EMPLOYMENTSUBTYPEID")
	private Integer masEmploymentsubtypeid;
	@Column(name = "PP_DEDUCTIONMASTERID")
	private Integer ppDeductionmasterid;
	@Column(name = "DEDUCTIONNAME")
	private String deductionname;
	@Column(name = "DEDSHORTNAME")
	private String dedshortname;
	@Column(name = "DEFAULTVALUE")
	private String defaultvalue;
	@Column(name = "PP_DED_RULESDETAILID")
	private Long ppDedRulesdetailid;

	public ViewPpDeduction() {
	}

	public Integer getMasEmploymenttypeid() {
		return masEmploymenttypeid;
	}

	public void setMasEmploymenttypeid(Integer masEmploymenttypeid) {
		this.masEmploymenttypeid = masEmploymenttypeid;
	}

	public String getEmploymenttype() {
		return employmenttype;
	}

	public void setEmploymenttype(String employmenttype) {
		this.employmenttype = employmenttype;
	}

	public Integer getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(Integer masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public Integer getPpDeductionmasterid() {
		return ppDeductionmasterid;
	}

	public void setPpDeductionmasterid(Integer ppDeductionmasterid) {
		this.ppDeductionmasterid = ppDeductionmasterid;
	}

	public String getDeductionname() {
		return deductionname;
	}

	public void setDeductionname(String deductionname) {
		this.deductionname = deductionname;
	}

	public String getDedshortname() {
		return dedshortname;
	}

	public void setDedshortname(String dedshortname) {
		this.dedshortname = dedshortname;
	}

	public String getDefaultvalue() {
		return defaultvalue;
	}

	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}

	public Long getPpDedRulesdetailid() {
		return ppDedRulesdetailid;
	}

	public void setPpDedRulesdetailid(Long ppDedRulesdetailid) {
		this.ppDedRulesdetailid = ppDedRulesdetailid;
	}

}
