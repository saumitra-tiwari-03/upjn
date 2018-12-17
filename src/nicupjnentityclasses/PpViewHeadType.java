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
@Table(name = "PP_VIEW_HEAD_TYPE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpViewHeadType.findAll", query = "SELECT p FROM PpViewHeadType p"),
		@NamedQuery(name = "PpViewHeadType.findByHeadid", query = "SELECT p FROM PpViewHeadType p WHERE p.headid = :headid"),
		@NamedQuery(name = "PpViewHeadType.findByHeadname", query = "SELECT p FROM PpViewHeadType p WHERE p.headname = :headname"),
		@NamedQuery(name = "PpViewHeadType.findByHeadtype", query = "SELECT p FROM PpViewHeadType p WHERE p.headtype = :headtype"),
		@NamedQuery(name = "PpViewHeadType.findByPrintOrder", query = "SELECT p FROM PpViewHeadType p WHERE p.printOrder = :printOrder") })
public class PpViewHeadType implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "HEADID")
	private BigInteger headid;
	@Column(name = "HEADNAME")
	private String headname;
	@Column(name = "HEADTYPE")
	private String headtype;
	@Column(name = "PRINT_ORDER")
	private BigInteger printOrder;

	public PpViewHeadType() {
	}

	public BigInteger getHeadid() {
		return headid;
	}

	public void setHeadid(BigInteger headid) {
		this.headid = headid;
	}

	public String getHeadname() {
		return headname;
	}

	public void setHeadname(String headname) {
		this.headname = headname;
	}

	public String getHeadtype() {
		return headtype;
	}

	public void setHeadtype(String headtype) {
		this.headtype = headtype;
	}

	public BigInteger getPrintOrder() {
		return printOrder;
	}

	public void setPrintOrder(BigInteger printOrder) {
		this.printOrder = printOrder;
	}

}
