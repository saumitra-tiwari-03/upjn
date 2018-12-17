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
@Table(name = "VIEW_PP_EMPDEDDETAIL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpEmpdeddetail.findAll", query = "SELECT v FROM ViewPpEmpdeddetail v"),
		@NamedQuery(name = "ViewPpEmpdeddetail.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpEmpdeddetail v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpEmpdeddetail.findByPpDeductionmasterid", query = "SELECT v FROM ViewPpEmpdeddetail v WHERE v.ppDeductionmasterid = :ppDeductionmasterid"),
		@NamedQuery(name = "ViewPpEmpdeddetail.findByDedshortname", query = "SELECT v FROM ViewPpEmpdeddetail v WHERE v.dedshortname = :dedshortname"),
		@NamedQuery(name = "ViewPpEmpdeddetail.findByDeductionname", query = "SELECT v FROM ViewPpEmpdeddetail v WHERE v.deductionname = :deductionname"),
		@NamedQuery(name = "ViewPpEmpdeddetail.findByPrintOrder", query = "SELECT v FROM ViewPpEmpdeddetail v WHERE v.printOrder = :printOrder"),
		@NamedQuery(name = "ViewPpEmpdeddetail.findByAmount", query = "SELECT v FROM ViewPpEmpdeddetail v WHERE v.amount = :amount") })
public class ViewPpEmpdeddetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "PP_DEDUCTIONMASTERID")
	private int ppDeductionmasterid;
	@Basic(optional = false)
	@Column(name = "DEDSHORTNAME")
	private String dedshortname;
	@Basic(optional = false)
	@Column(name = "DEDUCTIONNAME")
	private String deductionname;
	@Column(name = "PRINT_ORDER")
	private Short printOrder;
	@Basic(optional = false)
	@Column(name = "AMOUNT")
	private int amount;

	public ViewPpEmpdeddetail() {
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public int getPpDeductionmasterid() {
		return ppDeductionmasterid;
	}

	public void setPpDeductionmasterid(int ppDeductionmasterid) {
		this.ppDeductionmasterid = ppDeductionmasterid;
	}

	public String getDedshortname() {
		return dedshortname;
	}

	public void setDedshortname(String dedshortname) {
		this.dedshortname = dedshortname;
	}

	public String getDeductionname() {
		return deductionname;
	}

	public void setDeductionname(String deductionname) {
		this.deductionname = deductionname;
	}

	public Short getPrintOrder() {
		return printOrder;
	}

	public void setPrintOrder(Short printOrder) {
		this.printOrder = printOrder;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
