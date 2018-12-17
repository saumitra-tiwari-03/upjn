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
@Table(name = "VIEW_PP_EMPLOYEETRAINING")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpEmployeetraining.findAll", query = "SELECT v FROM ViewPpEmployeetraining v"),
		@NamedQuery(name = "ViewPpEmployeetraining.findByPpEmployeetrainingid", query = "SELECT v FROM ViewPpEmployeetraining v WHERE v.ppEmployeetrainingid = :ppEmployeetrainingid"),
		@NamedQuery(name = "ViewPpEmployeetraining.findByPpEmployeemasterid", query = "SELECT v FROM ViewPpEmployeetraining v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
		@NamedQuery(name = "ViewPpEmployeetraining.findByPpTrainingtypemasterid", query = "SELECT v FROM ViewPpEmployeetraining v WHERE v.ppTrainingtypemasterid = :ppTrainingtypemasterid"),
		@NamedQuery(name = "ViewPpEmployeetraining.findByTrainingstartdate", query = "SELECT v FROM ViewPpEmployeetraining v WHERE v.trainingstartdate = :trainingstartdate"),
		@NamedQuery(name = "ViewPpEmployeetraining.findByTrainingenddate", query = "SELECT v FROM ViewPpEmployeetraining v WHERE v.trainingenddate = :trainingenddate"),
		@NamedQuery(name = "ViewPpEmployeetraining.findByIsabroad", query = "SELECT v FROM ViewPpEmployeetraining v WHERE v.isabroad = :isabroad"),
		@NamedQuery(name = "ViewPpEmployeetraining.findByIsdepartmental", query = "SELECT v FROM ViewPpEmployeetraining v WHERE v.isdepartmental = :isdepartmental"),
		@NamedQuery(name = "ViewPpEmployeetraining.findByTrainingvenue", query = "SELECT v FROM ViewPpEmployeetraining v WHERE v.trainingvenue = :trainingvenue"),
		@NamedQuery(name = "ViewPpEmployeetraining.findByTrainingsubject", query = "SELECT v FROM ViewPpEmployeetraining v WHERE v.trainingsubject = :trainingsubject"),
		@NamedQuery(name = "ViewPpEmployeetraining.findByOrganizer", query = "SELECT v FROM ViewPpEmployeetraining v WHERE v.organizer = :organizer"),
		@NamedQuery(name = "ViewPpEmployeetraining.findByOrderno", query = "SELECT v FROM ViewPpEmployeetraining v WHERE v.orderno = :orderno"),
		@NamedQuery(name = "ViewPpEmployeetraining.findByOrderdate", query = "SELECT v FROM ViewPpEmployeetraining v WHERE v.orderdate = :orderdate"),
		@NamedQuery(name = "ViewPpEmployeetraining.findByTrainingtype", query = "SELECT v FROM ViewPpEmployeetraining v WHERE v.trainingtype = :trainingtype") })
public class ViewPpEmployeetraining implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEETRAININGID")
	private long ppEmployeetrainingid;
	@Basic(optional = false)
	@Column(name = "PP_EMPLOYEEMASTERID")
	private long ppEmployeemasterid;
	@Basic(optional = false)
	@Column(name = "PP_TRAININGTYPEMASTERID")
	private int ppTrainingtypemasterid;
	@Basic(optional = false)
	@Column(name = "TRAININGSTARTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date trainingstartdate;
	@Basic(optional = false)
	@Column(name = "TRAININGENDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date trainingenddate;
	@Basic(optional = false)
	@Column(name = "ISABROAD")
	private Character isabroad;
	@Basic(optional = false)
	@Column(name = "ISDEPARTMENTAL")
	private Character isdepartmental;
	@Column(name = "TRAININGVENUE")
	private String trainingvenue;
	@Column(name = "TRAININGSUBJECT")
	private String trainingsubject;
	@Column(name = "ORGANIZER")
	private String organizer;
	@Column(name = "ORDERNO")
	private String orderno;
	@Column(name = "ORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderdate;
	@Basic(optional = false)
	@Column(name = "TRAININGTYPE")
	private String trainingtype;

	public ViewPpEmployeetraining() {
	}

	public long getPpEmployeetrainingid() {
		return ppEmployeetrainingid;
	}

	public void setPpEmployeetrainingid(long ppEmployeetrainingid) {
		this.ppEmployeetrainingid = ppEmployeetrainingid;
	}

	public long getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(long ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public int getPpTrainingtypemasterid() {
		return ppTrainingtypemasterid;
	}

	public void setPpTrainingtypemasterid(int ppTrainingtypemasterid) {
		this.ppTrainingtypemasterid = ppTrainingtypemasterid;
	}

	public Date getTrainingstartdate() {
		return trainingstartdate;
	}

	public void setTrainingstartdate(Date trainingstartdate) {
		this.trainingstartdate = trainingstartdate;
	}

	public Date getTrainingenddate() {
		return trainingenddate;
	}

	public void setTrainingenddate(Date trainingenddate) {
		this.trainingenddate = trainingenddate;
	}

	public Character getIsabroad() {
		return isabroad;
	}

	public void setIsabroad(Character isabroad) {
		this.isabroad = isabroad;
	}

	public Character getIsdepartmental() {
		return isdepartmental;
	}

	public void setIsdepartmental(Character isdepartmental) {
		this.isdepartmental = isdepartmental;
	}

	public String getTrainingvenue() {
		return trainingvenue;
	}

	public void setTrainingvenue(String trainingvenue) {
		this.trainingvenue = trainingvenue;
	}

	public String getTrainingsubject() {
		return trainingsubject;
	}

	public void setTrainingsubject(String trainingsubject) {
		this.trainingsubject = trainingsubject;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getTrainingtype() {
		return trainingtype;
	}

	public void setTrainingtype(String trainingtype) {
		this.trainingtype = trainingtype;
	}

}
