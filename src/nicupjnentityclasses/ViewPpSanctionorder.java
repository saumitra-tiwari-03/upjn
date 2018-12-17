/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_PP_SANCTIONORDER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpSanctionorder.findAll", query = "SELECT v FROM ViewPpSanctionorder v"),
		@NamedQuery(name = "ViewPpSanctionorder.findByPpLeavesanctionorderid", query = "SELECT v FROM ViewPpSanctionorder v WHERE v.ppLeavesanctionorderid = :ppLeavesanctionorderid"),
		@NamedQuery(name = "ViewPpSanctionorder.findBySanctionorderno", query = "SELECT v FROM ViewPpSanctionorder v WHERE v.sanctionorderno = :sanctionorderno"),
		@NamedQuery(name = "ViewPpSanctionorder.findBySanctionorderdate", query = "SELECT v FROM ViewPpSanctionorder v WHERE v.sanctionorderdate = :sanctionorderdate"),
		@NamedQuery(name = "ViewPpSanctionorder.findBySanctioningauthority", query = "SELECT v FROM ViewPpSanctionorder v WHERE v.sanctioningauthority = :sanctioningauthority"),
		@NamedQuery(name = "ViewPpSanctionorder.findByEditflag", query = "SELECT v FROM ViewPpSanctionorder v WHERE v.editflag = :editflag") })
public class ViewPpSanctionorder implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_LEAVESANCTIONORDERID")
	private long ppLeavesanctionorderid;
	@Basic(optional = false)
	@Column(name = "SANCTIONORDERNO")
	private String sanctionorderno;
	@Basic(optional = false)
	@Column(name = "SANCTIONORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sanctionorderdate;
	@Basic(optional = false)
	@Column(name = "SANCTIONINGAUTHORITY")
	private String sanctioningauthority;
	@Column(name = "EDITFLAG")
	private BigInteger editflag;

	public ViewPpSanctionorder() {
	}

	public long getPpLeavesanctionorderid() {
		return ppLeavesanctionorderid;
	}

	public void setPpLeavesanctionorderid(long ppLeavesanctionorderid) {
		this.ppLeavesanctionorderid = ppLeavesanctionorderid;
	}

	public String getSanctionorderno() {
		return sanctionorderno;
	}

	public void setSanctionorderno(String sanctionorderno) {
		this.sanctionorderno = sanctionorderno;
	}

	public Date getSanctionorderdate() {
		return sanctionorderdate;
	}

	public void setSanctionorderdate(Date sanctionorderdate) {
		this.sanctionorderdate = sanctionorderdate;
	}

	public String getSanctioningauthority() {
		return sanctioningauthority;
	}

	public void setSanctioningauthority(String sanctioningauthority) {
		this.sanctioningauthority = sanctioningauthority;
	}

	public BigInteger getEditflag() {
		return editflag;
	}

	public void setEditflag(BigInteger editflag) {
		this.editflag = editflag;
	}

}
