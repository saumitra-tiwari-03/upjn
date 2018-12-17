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
@Table(name = "VIEW_PAY_GETSCHEDULEHEADLIST")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewPayGetscheduleheadlist.findAll", query = "SELECT v FROM ViewPayGetscheduleheadlist v"),
		@NamedQuery(name = "ViewPayGetscheduleheadlist.findByPpSchedulemasterid", query = "SELECT v FROM ViewPayGetscheduleheadlist v WHERE v.ppSchedulemasterid = :ppSchedulemasterid"),
		@NamedQuery(name = "ViewPayGetscheduleheadlist.findByHeadid", query = "SELECT v FROM ViewPayGetscheduleheadlist v WHERE v.headid = :headid"),
		@NamedQuery(name = "ViewPayGetscheduleheadlist.findByHeadname", query = "SELECT v FROM ViewPayGetscheduleheadlist v WHERE v.headname = :headname"),
		@NamedQuery(name = "ViewPayGetscheduleheadlist.findByHeadtype", query = "SELECT v FROM ViewPayGetscheduleheadlist v WHERE v.headtype = :headtype") })
public class ViewPayGetscheduleheadlist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "PP_SCHEDULEMASTERID")
	private BigInteger ppSchedulemasterid;
	@Column(name = "HEADID")
	private BigInteger headid;
	@Column(name = "HEADNAME")
	private String headname;
	@Column(name = "HEADTYPE")
	private String headtype;

	public ViewPayGetscheduleheadlist() {
	}

	public BigInteger getPpSchedulemasterid() {
		return ppSchedulemasterid;
	}

	public void setPpSchedulemasterid(BigInteger ppSchedulemasterid) {
		this.ppSchedulemasterid = ppSchedulemasterid;
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

}
