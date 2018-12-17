/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigInteger;

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
@Table(name = "VIEW_ANNUAL_BUDGET")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewAnnualBudget.findAll", query = "SELECT v FROM ViewAnnualBudget v"),
		@NamedQuery(name = "ViewAnnualBudget.findByAnnualBudgetid", query = "SELECT v FROM ViewAnnualBudget v WHERE v.annualBudgetid = :annualBudgetid"),
		@NamedQuery(name = "ViewAnnualBudget.findByProgramNameid", query = "SELECT v FROM ViewAnnualBudget v WHERE v.programNameid = :programNameid"),
		@NamedQuery(name = "ViewAnnualBudget.findByTotal3", query = "SELECT v FROM ViewAnnualBudget v WHERE v.total3 = :total3"),
		@NamedQuery(name = "ViewAnnualBudget.findByCompleted4", query = "SELECT v FROM ViewAnnualBudget v WHERE v.completed4 = :completed4"),
		@NamedQuery(name = "ViewAnnualBudget.findByTotal5", query = "SELECT v FROM ViewAnnualBudget v WHERE v.total5 = :total5"),
		@NamedQuery(name = "ViewAnnualBudget.findByCompleted6", query = "SELECT v FROM ViewAnnualBudget v WHERE v.completed6 = :completed6"),
		@NamedQuery(name = "ViewAnnualBudget.findByContd7", query = "SELECT v FROM ViewAnnualBudget v WHERE v.contd7 = :contd7"),
		@NamedQuery(name = "ViewAnnualBudget.findByBalFund", query = "SELECT v FROM ViewAnnualBudget v WHERE v.balFund = :balFund"),
		@NamedQuery(name = "ViewAnnualBudget.findByApprovedNo", query = "SELECT v FROM ViewAnnualBudget v WHERE v.approvedNo = :approvedNo"),
		@NamedQuery(name = "ViewAnnualBudget.findByApprovedCost", query = "SELECT v FROM ViewAnnualBudget v WHERE v.approvedCost = :approvedCost"),
		@NamedQuery(name = "ViewAnnualBudget.findByProposedNo", query = "SELECT v FROM ViewAnnualBudget v WHERE v.proposedNo = :proposedNo"),
		@NamedQuery(name = "ViewAnnualBudget.findByProposedCost", query = "SELECT v FROM ViewAnnualBudget v WHERE v.proposedCost = :proposedCost"),
		@NamedQuery(name = "ViewAnnualBudget.findByContd13", query = "SELECT v FROM ViewAnnualBudget v WHERE v.contd13 = :contd13"),
		@NamedQuery(name = "ViewAnnualBudget.findByNew14", query = "SELECT v FROM ViewAnnualBudget v WHERE v.new14 = :new14"),
		@NamedQuery(name = "ViewAnnualBudget.findByTotal", query = "SELECT v FROM ViewAnnualBudget v WHERE v.total = :total"),
		@NamedQuery(name = "ViewAnnualBudget.findByMasDistrictid", query = "SELECT v FROM ViewAnnualBudget v WHERE v.masDistrictid = :masDistrictid"),
		@NamedQuery(name = "ViewAnnualBudget.findByProgramName", query = "SELECT v FROM ViewAnnualBudget v WHERE v.programName = :programName") })
public class ViewAnnualBudget implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "ANNUAL_BUDGETID")
	private long annualBudgetid;
	@Column(name = "PROGRAM_NAMEID")
	private BigInteger programNameid;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "TOTAL_3")
	private Double total3;
	@Column(name = "COMPLETED_4")
	private Double completed4;
	@Column(name = "TOTAL_5")
	private Double total5;
	@Column(name = "COMPLETED_6")
	private Double completed6;
	@Column(name = "CONTD_7")
	private Double contd7;
	@Column(name = "BAL_FUND")
	private Double balFund;
	@Column(name = "APPROVED_NO")
	private Double approvedNo;
	@Column(name = "APPROVED_COST")
	private Double approvedCost;
	@Column(name = "PROPOSED_NO")
	private Double proposedNo;
	@Column(name = "PROPOSED_COST")
	private Double proposedCost;
	@Column(name = "CONTD_13")
	private Double contd13;
	@Column(name = "NEW_14")
	private Double new14;
	@Column(name = "TOTAL")
	private Double total;
	@Column(name = "MAS_DISTRICTID")
	private BigInteger masDistrictid;
	@Basic(optional = false)
	@Column(name = "PROGRAM_NAME")
	private String programName;

	public ViewAnnualBudget() {
	}

	public long getAnnualBudgetid() {
		return annualBudgetid;
	}

	public void setAnnualBudgetid(long annualBudgetid) {
		this.annualBudgetid = annualBudgetid;
	}

	public BigInteger getProgramNameid() {
		return programNameid;
	}

	public void setProgramNameid(BigInteger programNameid) {
		this.programNameid = programNameid;
	}

	public Double getTotal3() {
		return total3;
	}

	public void setTotal3(Double total3) {
		this.total3 = total3;
	}

	public Double getCompleted4() {
		return completed4;
	}

	public void setCompleted4(Double completed4) {
		this.completed4 = completed4;
	}

	public Double getTotal5() {
		return total5;
	}

	public void setTotal5(Double total5) {
		this.total5 = total5;
	}

	public Double getCompleted6() {
		return completed6;
	}

	public void setCompleted6(Double completed6) {
		this.completed6 = completed6;
	}

	public Double getContd7() {
		return contd7;
	}

	public void setContd7(Double contd7) {
		this.contd7 = contd7;
	}

	public Double getBalFund() {
		return balFund;
	}

	public void setBalFund(Double balFund) {
		this.balFund = balFund;
	}

	public Double getApprovedNo() {
		return approvedNo;
	}

	public void setApprovedNo(Double approvedNo) {
		this.approvedNo = approvedNo;
	}

	public Double getApprovedCost() {
		return approvedCost;
	}

	public void setApprovedCost(Double approvedCost) {
		this.approvedCost = approvedCost;
	}

	public Double getProposedNo() {
		return proposedNo;
	}

	public void setProposedNo(Double proposedNo) {
		this.proposedNo = proposedNo;
	}

	public Double getProposedCost() {
		return proposedCost;
	}

	public void setProposedCost(Double proposedCost) {
		this.proposedCost = proposedCost;
	}

	public Double getContd13() {
		return contd13;
	}

	public void setContd13(Double contd13) {
		this.contd13 = contd13;
	}

	public Double getNew14() {
		return new14;
	}

	public void setNew14(Double new14) {
		this.new14 = new14;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public BigInteger getMasDistrictid() {
		return masDistrictid;
	}

	public void setMasDistrictid(BigInteger masDistrictid) {
		this.masDistrictid = masDistrictid;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

}
