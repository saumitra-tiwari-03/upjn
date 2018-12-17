/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



/**
 *
 * @author Nicsi
 */
@Entity
@Table(name = "PP_DESIGNATIONMASTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PpDesignationmaster.findAll", query = "SELECT p FROM PpDesignationmaster p"),
    @NamedQuery(name = "PpDesignationmaster.findByPpDesignationmasterid", query = "SELECT p FROM PpDesignationmaster p WHERE p.ppDesignationmasterid = ?"),
    @NamedQuery(name = "PpDesignationmaster.findByemployementtype", query = "FROM PpDesignationmaster WHERE masEmploymenttypeid = ?"),
    @NamedQuery(name = "PpDesignationmaster.findByDesignation", query = "SELECT p FROM PpDesignationmaster p WHERE p.designation = :designation")})
public class PpDesignationmaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ_PP_DESIGNATIONMASTER", allocationSize = 1)
	@Id
    @Column(name = "PP_DESIGNATIONMASTERID")
    private BigDecimal ppDesignationmasterid;
   
    @Column(name = "DESIGNATION")
    private String designation;
    
    @Column(name = "MAS_EMPLOYMENTSUBTYPEID")
    private Integer masEmploymentsubtypeid;
   
    @Column(name = "MAS_EMPLOYMENTTYPEID")
    private Integer masEmploymenttypeid;

    public PpDesignationmaster() {
    }

	public BigDecimal getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}

	public void setPpDesignationmasterid(BigDecimal ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getMasEmploymentsubtypeid() {
		return masEmploymentsubtypeid;
	}

	public void setMasEmploymentsubtypeid(Integer masEmploymentsubtypeid) {
		this.masEmploymentsubtypeid = masEmploymentsubtypeid;
	}

	public Integer getMasEmploymenttypeid() {
		return masEmploymenttypeid;
	}

	public void setMasEmploymenttypeid(Integer masEmploymenttypeid) {
		this.masEmploymenttypeid = masEmploymenttypeid;
	}
    
    
    

}