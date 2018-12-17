/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
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
@Table(name = "VIEW_ACRPENDINGREPORT")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewAcrpendingreport.findAll", query = "SELECT v FROM ViewAcrpendingreport v"),
		@NamedQuery(name = "ViewAcrpendingreport.findByPpEmployeemasterid", query = "SELECT v FROM ViewAcrpendingreport v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewAcrpendingreport.findByFromdate", query = "SELECT v FROM ViewAcrpendingreport v WHERE v.fromdate = :fromdate"),
		@NamedQuery(name = "ViewAcrpendingreport.findByTodate", query = "SELECT v FROM ViewAcrpendingreport v WHERE v.todate = :todate") })
public class ViewAcrpendingreport implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Column(name = "FROMDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromdate;
	@Column(name = "TODATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date todate;

	public ViewAcrpendingreport() {
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	public Date getTodate() {
		return todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

}
