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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_RULEMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewRulemaster.findAll", query = "SELECT v FROM ViewRulemaster v"),
		@NamedQuery(name = "ViewRulemaster.findByEmployeename", query = "SELECT v FROM ViewRulemaster v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewRulemaster.findByEmployeecode", query = "SELECT v FROM ViewRulemaster v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewRulemaster.findByPpRulemasterid", query = "SELECT v FROM ViewRulemaster v WHERE v.ppRulemasterid = :ppRulemasterid"),
		@NamedQuery(name = "ViewRulemaster.findByFlatamount", query = "SELECT v FROM ViewRulemaster v WHERE v.flatamount = :flatamount") })
public class ViewRulemaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Basic(optional = false)
	@Column(name = "PP_RULEMASTERID")
	private int ppRulemasterid;
	@Column(name = "FLATAMOUNT")
	private Integer flatamount;

	public ViewRulemaster() {
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public int getPpRulemasterid() {
		return ppRulemasterid;
	}

	public void setPpRulemasterid(int ppRulemasterid) {
		this.ppRulemasterid = ppRulemasterid;
	}

	public Integer getFlatamount() {
		return flatamount;
	}

	public void setFlatamount(Integer flatamount) {
		this.flatamount = flatamount;
	}

}
