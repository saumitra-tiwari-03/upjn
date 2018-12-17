/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigInteger;

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
@Table(name = "VIEW_PAYHEAD")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPayhead.findAll", query = "SELECT v FROM ViewPayhead v"),
		@NamedQuery(name = "ViewPayhead.findByPpPayalwmasterid", query = "SELECT v FROM ViewPayhead v WHERE v.ppPayalwmasterid = :ppPayalwmasterid"),
		@NamedQuery(name = "ViewPayhead.findByHeadname", query = "SELECT v FROM ViewPayhead v WHERE v.headname = :headname"),
		@NamedQuery(name = "ViewPayhead.findByHeadtype", query = "SELECT v FROM ViewPayhead v WHERE v.headtype = :headtype"),
		@NamedQuery(name = "ViewPayhead.findByPrintOrder", query = "SELECT v FROM ViewPayhead v WHERE v.printOrder = :printOrder") })
public class ViewPayhead implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "PP_PAYALWMASTERID")
	private BigInteger ppPayalwmasterid;
	@Column(name = "HEADNAME")
	private String headname;
	@Column(name = "HEADTYPE")
	private Character headtype;
	@Column(name = "PRINT_ORDER")
	private BigInteger printOrder;

	public ViewPayhead() {
	}

	public BigInteger getPpPayalwmasterid() {
		return ppPayalwmasterid;
	}

	public void setPpPayalwmasterid(BigInteger ppPayalwmasterid) {
		this.ppPayalwmasterid = ppPayalwmasterid;
	}

	public String getHeadname() {
		return headname;
	}

	public void setHeadname(String headname) {
		this.headname = headname;
	}

	public Character getHeadtype() {
		return headtype;
	}

	public void setHeadtype(Character headtype) {
		this.headtype = headtype;
	}

	public BigInteger getPrintOrder() {
		return printOrder;
	}

	public void setPrintOrder(BigInteger printOrder) {
		this.printOrder = printOrder;
	}

}
