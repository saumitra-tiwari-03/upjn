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
@Table(name = "VIEW_EMPLOYEE_OBJECTION")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewEmployeeObjection.findAll", query = "SELECT v FROM ViewEmployeeObjection v"),
		@NamedQuery(name = "ViewEmployeeObjection.findByEmployeecode", query = "SELECT v FROM ViewEmployeeObjection v WHERE v.employeecode = :employeecode"),
		@NamedQuery(name = "ViewEmployeeObjection.findByEmployeename", query = "SELECT v FROM ViewEmployeeObjection v WHERE v.employeename = :employeename"),
		@NamedQuery(name = "ViewEmployeeObjection.findByFathername", query = "SELECT v FROM ViewEmployeeObjection v WHERE v.fathername = :fathername"),
		@NamedQuery(name = "ViewEmployeeObjection.findByPsnObjectionlistid", query = "SELECT v FROM ViewEmployeeObjection v WHERE v.psnObjectionlistid = :psnObjectionlistid"),
		@NamedQuery(name = "ViewEmployeeObjection.findByStatus", query = "SELECT v FROM ViewEmployeeObjection v WHERE v.status = :status"),
		@NamedQuery(name = "ViewEmployeeObjection.findByDateofobjection", query = "SELECT v FROM ViewEmployeeObjection v WHERE v.dateofobjection = :dateofobjection"),
		@NamedQuery(name = "ViewEmployeeObjection.findByListdescription", query = "SELECT v FROM ViewEmployeeObjection v WHERE v.listdescription = :listdescription"),
		@NamedQuery(name = "ViewEmployeeObjection.findByDescription", query = "SELECT v FROM ViewEmployeeObjection v WHERE v.description = :description"),
		@NamedQuery(name = "ViewEmployeeObjection.findByPensiontypeid", query = "SELECT v FROM ViewEmployeeObjection v WHERE v.pensiontypeid = :pensiontypeid"),
		@NamedQuery(name = "ViewEmployeeObjection.findBySerialno", query = "SELECT v FROM ViewEmployeeObjection v WHERE v.serialno = :serialno") })
public class ViewEmployeeObjection implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "EMPLOYEECODE")
	private String employeecode;
	@Basic(optional = false)
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Basic(optional = false)
	@Column(name = "FATHERNAME")
	private String fathername;
	@Basic(optional = false)
	@Column(name = "PSN_OBJECTIONLISTID")
	private long psnObjectionlistid;
	@Basic(optional = false)
	@Column(name = "STATUS")
	private Character status;
	@Column(name = "DATEOFOBJECTION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofobjection;
	@Column(name = "LISTDESCRIPTION")
	private String listdescription;
	@Column(name = "DESCRIPTION")
	private String description;
	@Basic(optional = false)
	@Column(name = "PENSIONTYPEID")
	private long pensiontypeid;
	@Column(name = "SERIALNO")
	private BigInteger serialno;

	public ViewEmployeeObjection() {
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public long getPsnObjectionlistid() {
		return psnObjectionlistid;
	}

	public void setPsnObjectionlistid(long psnObjectionlistid) {
		this.psnObjectionlistid = psnObjectionlistid;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public Date getDateofobjection() {
		return dateofobjection;
	}

	public void setDateofobjection(Date dateofobjection) {
		this.dateofobjection = dateofobjection;
	}

	public String getListdescription() {
		return listdescription;
	}

	public void setListdescription(String listdescription) {
		this.listdescription = listdescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPensiontypeid() {
		return pensiontypeid;
	}

	public void setPensiontypeid(long pensiontypeid) {
		this.pensiontypeid = pensiontypeid;
	}

	public BigInteger getSerialno() {
		return serialno;
	}

	public void setSerialno(BigInteger serialno) {
		this.serialno = serialno;
	}

}
