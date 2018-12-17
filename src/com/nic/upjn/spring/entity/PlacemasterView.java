/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PLACEMASTER_VIEW")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PlacemasterView.findAll", query = "SELECT p FROM PlacemasterView p"),
		@NamedQuery(name = "PlacemasterView.findByPpPlacemasterid", query = "SELECT p FROM PlacemasterView p WHERE p.ppPlacemasterid = :ppPlacemasterid"),
		@NamedQuery(name = "PlacemasterView.findByPlace", query = "SELECT p FROM PlacemasterView p WHERE p.place = :place"),
		@NamedQuery(name = "PlacemasterView.findByDistrictname", query = "SELECT p FROM PlacemasterView p WHERE p.districtname = :districtname"),
		@NamedQuery(name = "PlacemasterView.findByCategorytype", query = "SELECT p FROM PlacemasterView p WHERE p.categorytype = :categorytype") })
public class PlacemasterView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@Column(name = "PP_PLACEMASTERID")
	private long ppPlacemasterid;
	@Basic(optional = false)
	@Column(name = "PLACE")
	private String place;
	@Basic(optional = false)
	@Column(name = "DISTRICTNAME")
	private String districtname;
	@Basic(optional = false)
	@Column(name = "CATEGORYTYPE")
	private String categorytype;

	public PlacemasterView() {
	}

	public long getPpPlacemasterid() {
		return ppPlacemasterid;
	}

	public void setPpPlacemasterid(long ppPlacemasterid) {
		this.ppPlacemasterid = ppPlacemasterid;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public String getCategorytype() {
		return categorytype;
	}

	public void setCategorytype(String categorytype) {
		this.categorytype = categorytype;
	}

}
